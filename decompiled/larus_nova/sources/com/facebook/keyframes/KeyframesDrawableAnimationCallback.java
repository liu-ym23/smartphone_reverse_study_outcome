package com.facebook.keyframes;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import com.facebook.keyframes.model.KFImage;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class KeyframesDrawableAnimationCallback {
    private int mCurrentLoopNumber;
    private final int mFrameCount;
    private final WeakReference<FrameListener> mListener;
    private final int mMillisPerLoop;
    private long mMinimumMillisBetweenProgressUpdates;
    private long mPreviousProgressMillis;
    private long mStartTimeMillis;
    private boolean mStopAtLoopEnd;

    /* JADX INFO: renamed from: com.facebook.keyframes.KeyframesDrawableAnimationCallback$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class FrameCallbackFaceAnimationCallback extends KeyframesDrawableAnimationCallback implements Choreographer.FrameCallback {
        private final Choreographer mChoreographer;

        @Override // com.facebook.keyframes.KeyframesDrawableAnimationCallback
        public void cancelCallback() {
            this.mChoreographer.removeFrameCallback(this);
        }

        @Override // com.facebook.keyframes.KeyframesDrawableAnimationCallback
        public void postCallback() {
            this.mChoreographer.postFrameCallback(this);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r100) {
            advanceAnimation(r100 / 1000000);
        }

        private FrameCallbackFaceAnimationCallback(FrameListener r100, int r101, int r102) {
            super(r100, r101, r102, null);
            this.mChoreographer = Choreographer.getInstance();
        }

        public /* synthetic */ FrameCallbackFaceAnimationCallback(FrameListener r100, int r101, int r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public interface FrameListener {
        void onProgressUpdate(float r100);

        void onStop();
    }

    public static class RunnableFaceAnimationCallback extends KeyframesDrawableAnimationCallback implements Runnable {
        private static final int ANIMATION_MIN_STEP_TIME_MS = 25;
        private final Handler mHandler;

        @Override // java.lang.Runnable
        public void run() {
            com_facebook_keyframes_KeyframesDrawableAnimationCallback$RunnableFaceAnimationCallback_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Override // com.facebook.keyframes.KeyframesDrawableAnimationCallback
        public void cancelCallback() {
            this.mHandler.removeCallbacks(this);
        }

        @Override // com.facebook.keyframes.KeyframesDrawableAnimationCallback
        public void postCallback() {
            this.mHandler.postDelayed(this, 25);
        }

        public void com_facebook_keyframes_KeyframesDrawableAnimationCallback$RunnableFaceAnimationCallback__run$___twin___() {
            advanceAnimation(SystemClock.uptimeMillis());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_facebook_keyframes_KeyframesDrawableAnimationCallback$RunnableFaceAnimationCallback_com_larus_apm_impl_protector_RunnableLancet_run(RunnableFaceAnimationCallback r100) {
            r100.com_facebook_keyframes_KeyframesDrawableAnimationCallback$RunnableFaceAnimationCallback__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private RunnableFaceAnimationCallback(FrameListener r100, int r101, int r102) {
            super(r100, r101, r102, null);
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        public /* synthetic */ RunnableFaceAnimationCallback(FrameListener r100, int r101, int r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    private static boolean hasChoreographer() {
        return true;
    }

    public abstract void cancelCallback();

    public abstract void postCallback();

    public void start() {
        this.mStopAtLoopEnd = false;
        cancelCallback();
        postCallback();
    }

    public void stopAtLoopEnd() {
        this.mStopAtLoopEnd = true;
    }

    public void stop() {
        cancelCallback();
        this.mStartTimeMillis = 0;
        this.mCurrentLoopNumber = -1;
        this.mListener.get().onStop();
    }

    public void advanceAnimation(long r110) {
        if (this.mListener.get() != null) goto L7;
        cancelCallback();
        this.mStartTimeMillis = 0;
        this.mPreviousProgressMillis = 0;
        this.mCurrentLoopNumber = -1;
        return;
    L7:
        if (this.mStartTimeMillis != 0) goto L9;
        this.mStartTimeMillis = r110;
    L9:
        long r100 = this.mStartTimeMillis;
        int r101 = (int) (r110 - r100);
        int r102 = this.mMillisPerLoop;
        boolean r103 = true;
        if ((r101 / r102) <= this.mCurrentLoopNumber) goto L12;
        boolean r104 = true;
    L14:
        if (this.mStopAtLoopEnd == false) goto L18;
        if (r104 == false) goto L18;
        this.mListener.get().onProgressUpdate(this.mFrameCount);
        stop();
        return;
    L18:
        long r105 = (r110 - r100) % ((long) r102);
        if ((r110 - this.mPreviousProgressMillis) >= this.mMinimumMillisBetweenProgressUpdates) goto L21;
        r103 = false;
    L22:
        if (r103 == false) goto L24;
        this.mListener.get().onProgressUpdate((r105 / this.mMillisPerLoop) * this.mFrameCount);
    L24:
        this.mCurrentLoopNumber = ((int) (r110 - this.mStartTimeMillis)) / this.mMillisPerLoop;
        postCallback();
        return;
    L21:
        this.mPreviousProgressMillis = r110;
        goto L22
    L12:
        r104 = false;
        goto L14
    }

    public void setMaxFrameRate(int r100) {
        this.mMinimumMillisBetweenProgressUpdates = 1000 / r100;
    }

    public static KeyframesDrawableAnimationCallback create(FrameListener r100, KFImage r101) {
        AnonymousClass1 r102 = null;
        if (hasChoreographer() == false) goto L7;
        return new FrameCallbackFaceAnimationCallback(r100, r101.getFrameRate(), r101.getFrameCount(), r102);
    L7:
        return new RunnableFaceAnimationCallback(r100, r101.getFrameRate(), r101.getFrameCount(), r102);
    }

    private KeyframesDrawableAnimationCallback(FrameListener r100, int r101, int r102) {
        this.mMinimumMillisBetweenProgressUpdates = -1;
        this.mPreviousProgressMillis = 0;
        this.mListener = new WeakReference(r100);
        this.mFrameCount = r102;
        this.mMillisPerLoop = Math.round((r102 / r101) * 1000.0f);
    }

    public /* synthetic */ KeyframesDrawableAnimationCallback(FrameListener r100, int r101, int r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
