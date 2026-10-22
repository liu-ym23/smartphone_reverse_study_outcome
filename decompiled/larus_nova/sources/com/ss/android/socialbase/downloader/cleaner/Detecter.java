package com.ss.android.socialbase.downloader.cleaner;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class Detecter {
    private static final int COUNT_INIT = 0;
    private static final int DETECT_COUNT_MAX = 3;
    private static final int SMOOTH_COUNT_MAX = 15;
    private static final String TAG = "Detecter";
    private static final int THREAD_STUCK_MAX = 200;
    private static final int THREAD_STUCK_MIN = 50;
    private ExecutorService mDetecterThreadPool;
    private volatile IDetecterEventCallback mEventCallback;
    private volatile boolean mIsStop;
    private volatile Handler mMainThreadHandler;
    private volatile Semaphore mMainThreadResponseSem;
    private int mSmoothHitCount;
    private volatile DetecterState mState;
    private int mStuckHitCount;

    public static final enum DetecterState extends Enum<DetecterState> {
        private static final /* synthetic */ DetecterState[] $VALUES = null;
        public static final DetecterState DETECTER_INIT = null;
        public static final DetecterState DETECTER_SMOOTH = null;
        public static final DetecterState DETECTER_STUCK = null;

        static {
            DetecterState r100 = new DetecterState("DETECTER_INIT", 0);
            DETECTER_INIT = r100;
            DetecterState r101 = new DetecterState("DETECTER_STUCK", 1);
            DETECTER_STUCK = r101;
            DetecterState r102 = new DetecterState("DETECTER_SMOOTH", 2);
            DETECTER_SMOOTH = r102;
            $VALUES = new DetecterState[]{r100, r101, r102};
        }

        public static DetecterState[] values() {
            return (DetecterState[]) $VALUES.clone();
        }

        public static DetecterState valueOf(String r100) {
            return (DetecterState) a.a(DetecterState.class, r100);
        }

        private DetecterState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface IDetecterEventCallback {
        void onSmooth();

        void onStuck();
    }

    public void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != DetecterState.DETECTER_INIT) goto L9;
        this.mState = DetecterState.DETECTER_SMOOTH;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.mDetecterThreadPool.execute(new AnonymousClass1(this));
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void stop() {
        this.mIsStop = true;
        this.mEventCallback = null;
        this.mMainThreadResponseSem.release();
    }

    public boolean isSmooth() {
        if (DetecterState.DETECTER_SMOOTH != this.mState) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStuck() {
        if (DetecterState.DETECTER_STUCK != this.mState) goto L5;
        return true;
    L5:
        return false;
    }

    public Detecter(IDetecterEventCallback r100) {
        this.mState = DetecterState.DETECTER_INIT;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mMainThreadResponseSem = new Semaphore(0);
        this.mDetecterThreadPool = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("aner/Detecter"));
        this.mIsStop = false;
        this.mSmoothHitCount = 0;
        this.mStuckHitCount = 0;
        this.mEventCallback = r100;
    }

    public static /* synthetic */ Semaphore access$000(Detecter r100) {
        return r100.mMainThreadResponseSem;
    }

    public static /* synthetic */ Handler access$100(Detecter r100) {
        return r100.mMainThreadHandler;
    }

    public static /* synthetic */ boolean access$200(Detecter r100) {
        return r100.mIsStop;
    }

    public static /* synthetic */ IDetecterEventCallback access$400(Detecter r100) {
        return r100.mEventCallback;
    }

    private void tryUpdateState(long r100) {
        if (r100 < 200) goto L12;
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "tryUpdateState", ">200ms enter real stuck");
    L7:
        this.mSmoothHitCount = 0;
        if (isStuck() == false) goto L10;
        return;
    L10:
        this.mStuckHitCount = 0;
        transToNewState(DetecterState.DETECTER_STUCK);
        return;
    L12:
        if (r100 >= 50) goto L14;
        this.mStuckHitCount = 0;
        if (isSmooth() == false) goto L25;
        return;
    L25:
        int r101 = this.mSmoothHitCount;
        if (r101 != 15) goto L28;
        transToNewState(DetecterState.DETECTER_SMOOTH);
        this.mSmoothHitCount++;
        return;
    L28:
        if (r101 >= 15) goto L35;
        this.mSmoothHitCount = r101 + 1;
        return;
    L35:
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "tryUpdateState", "50ms<=duration<=200ms enter maybe stuck");
    L16:
        this.mSmoothHitCount = 0;
        if (isStuck() == false) goto L19;
        return;
    L19:
        int r102 = this.mStuckHitCount + 1;
        this.mStuckHitCount = r102;
        if (r102 < 3) goto L32;
        this.mStuckHitCount = 0;
        transToNewState(DetecterState.DETECTER_STUCK);
        return;
    }

    public void transToNewState(final DetecterState r100) {
        this.mState = r100;
        this.mDetecterThreadPool.execute(new AnonymousClass2(this, r100));
    }

    public static /* synthetic */ boolean access$202(Detecter r100, boolean r101) {
        r100.mIsStop = r101;
        return r101;
    }

    private void checkStuck(long r100, long r101) {
        long r102 = r101 - r100;
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "CheckStuck", "ping main thread duration=" + r102);
    L5:
        tryUpdateState(r102);
    }

    public static /* synthetic */ void access$300(Detecter r100, long r101, long r102) {
        r100.checkStuck(r101, r102);
    }
}
