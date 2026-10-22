package com.bytedance.sysoptimizer.suspension;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadSuspensionHandler extends PthreadHandlerThreadV2 implements Handler.Callback {
    private static final int MSG_CHECK_THREAD_SUSPENSION = 1;
    private static final int MSG_QUIT = 2;
    private static final int MSG_RESUME_THREAD = 0;
    private static final String TAG = "ThreadSuspension";
    private static boolean mJniInitSuccess;
    private static final AtomicBoolean sNativeHasInited = null;
    private String[] ignoredThreadNameArray;
    private final Set<String> ignoredThreadNameSet;
    private final AtomicBoolean mCheckQuitFlag;
    private boolean mEnableCrash;
    private long mIntervalCheckDuration;
    private final int mMainThreadTid;
    private float mRatio;
    private long mSuspendDuration;
    private ThreadSuspendedCallback mSuspendedCallback;
    private Runnable mThreadFinishedCallback;
    private Handler mThreadHandler;

    private void logI(String r100) {
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        com_bytedance_sysoptimizer_suspension_ThreadSuspensionHandler_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        sNativeHasInited = new AtomicBoolean(false);
        mJniInitSuccess = true;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.mThreadHandler = new Handler(getLooper(), this);
        sNativeHasInited.getAndSet(true);
        if (mJniInitSuccess == true) goto L6;
        Message r100 = Message.obtain();
        r100.what = 2;
        this.mThreadHandler.sendMessage(r100);
        return;
    L6:
        Message r101 = Message.obtain();
        r101.what = 1;
        this.mThreadHandler.sendMessage(r101);
    }

    public void stopTask() {
        if (this.mCheckQuitFlag.get() == true) goto L6;
        this.mCheckQuitFlag.set(true);
        this.mThreadHandler.removeMessages(1);
        Message r100 = Message.obtain();
        r100.what = 2;
        this.mThreadHandler.sendMessage(r100);
        return;
    }

    public void com_bytedance_sysoptimizer_suspension_ThreadSuspensionHandler__run$___twin___() {
        super.run();
        Runnable r100 = this.mThreadFinishedCallback;
        if (r100 == null) goto L5;
        r100.run();
    L5:
        this.mThreadFinishedCallback = null;
    }

    private void doQuit() {
        quitSafely();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_sysoptimizer_suspension_ThreadSuspensionHandler_com_larus_apm_impl_protector_RunnableLancet_run(ThreadSuspensionHandler r100) {
        r100.com_bytedance_sysoptimizer_suspension_ThreadSuspensionHandler__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private void setupParam(SuspensionParam r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mSuspendDuration = r100.getThreadSuspendDuration();
        this.mIntervalCheckDuration = r100.getIntervalCheckSuspensionDuration();
        this.mRatio = r100.getRatio();
        this.mEnableCrash = r100.isEnableCrashWhenInitFailed();
        Set<String> r101 = r100.getIgnoredThreadSet();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isEmpty() == true) goto L11;
        this.ignoredThreadNameSet.addAll(r101);
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 == 0) goto L18;
        if (r101 == 1) goto L12;
        if (r101 != 2) goto L22;
        this.mThreadHandler.removeMessages(1);
        this.mSuspendedCallback = null;
        if (this.mThreadHandler.hasMessages(0) == true) goto L22;
        logI("MSG_QUIT do quit !!!");
        doQuit();
    L22:
        return true;
    L12:
        if (this.mCheckQuitFlag.get() == true) goto L22;
        if (this.mCheckQuitFlag.get() == true) goto L22;
        Message r102 = Message.obtain();
        r102.what = 1;
        this.mThreadHandler.sendMessageDelayed(r102, this.mIntervalCheckDuration);
        goto L22
    L18:
        if (this.mCheckQuitFlag.get() == false) goto L22;
        if (this.mThreadHandler.hasMessages(0) == true) goto L22;
        logI("MSG_RESUME_THREAD do quit !!!");
        doQuit();
        goto L22
    }

    public void setSuspendedCallback(ThreadSuspendedCallback r100) {
        this.mSuspendedCallback = r100;
    }

    public void setThreadFinishedCallback(Runnable r100) {
        this.mThreadFinishedCallback = r100;
    }

    private void delayResumeThread(long r100, long r101) {
        Message r102 = Message.obtain();
        r102.what = 0;
        r102.obj = Long.valueOf(r100);
        this.mThreadHandler.sendMessageDelayed(r102, r101);
    }

    public ThreadSuspensionHandler(String r100, int r101, SuspensionParam r110) {
        this(r100, 0, r101, r110, null, null);
    }

    private void onThreadSuspended(int r100, String r101, long r102) {
        delayResumeThread(r102, this.mSuspendDuration);
        ThreadSuspendedCallback r103 = this.mSuspendedCallback;
        if (r103 == null) goto L6;
        r103.onThreadSuspended(r100, r101);
        return;
    }

    public ThreadSuspensionHandler(String r100, int r101, int r102, SuspensionParam r103, ThreadSuspendedCallback r104, Runnable r105) {
        super(r100, r101);
        this.mCheckQuitFlag = new AtomicBoolean(false);
        this.mSuspendDuration = 500;
        this.mIntervalCheckDuration = 2000;
        this.mRatio = 1.0f;
        this.mSuspendedCallback = null;
        this.mThreadFinishedCallback = null;
        this.mEnableCrash = false;
        HashSet<String> r106 = new AnonymousClass1(this);
        this.ignoredThreadNameSet = r106;
        this.mMainThreadTid = r102;
        r106.add(r100);
        this.mSuspendedCallback = r104;
        this.mThreadFinishedCallback = r105;
        setupParam(r103);
        int r107 = r106.size();
        String[] r108 = new String[r107];
        this.ignoredThreadNameArray = r108;
        if (r107 <= 0) goto L6;
        this.ignoredThreadNameArray = (String[]) r106.toArray(r108);
        return;
    }
}
