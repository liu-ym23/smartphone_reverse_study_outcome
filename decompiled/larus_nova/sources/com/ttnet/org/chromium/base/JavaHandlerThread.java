package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public class JavaHandlerThread {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final HandlerThread mThread;
    private Throwable mUnhandledException;

    public interface Natives {
        void initializeThread(long r100, long r101);

        void onLooperStopped(long r100);
    }

    private void joinThread() {
        boolean r100 = false;
    L3:
        if (r100 == true) goto L7;
        ThreadMethodProxy.join(this.mThread);     // Catch: InterruptedException -> L6
        r100 = true;
        goto L3
    }

    private boolean hasStarted() {
        if (this.mThread.getState() == Thread.State.NEW) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isAlive() {
        return ThreadMethodProxy.isAlive(this.mThread);
    }

    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new AnonymousClass3(this));
    }

    public Looper getLooper() {
        return this.mThread.getLooper();
    }

    public void maybeStart() {
        if (hasStarted() == false) goto L5;
        return;
    L5:
        ThreadMethodProxy.start(this.mThread);
    }

    static {
    }

    private Throwable getUncaughtExceptionIfAny() {
        return this.mUnhandledException;
    }

    public static /* synthetic */ HandlerThread access$000(JavaHandlerThread r100) {
        return r100.mThread;
    }

    private void quitThreadSafely(final long r100) {
        new Handler(this.mThread.getLooper()).post(new AnonymousClass2(this, r100));
        ThreadMethodProxy.quitSafely(this.mThread.getLooper());
    }

    public JavaHandlerThread(String r100, int r101) {
        this.mThread = new PthreadHandlerThreadV2(r100, r101);
    }

    public static /* synthetic */ Throwable access$102(JavaHandlerThread r100, Throwable r101) {
        r100.mUnhandledException = r101;
        return r101;
    }

    private static JavaHandlerThread create(String r100, int r101) {
        return new JavaHandlerThread(r100, r101);
    }

    private void startAndInitialize(final long r100, final long r110) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new AnonymousClass1(this, r100, r110));
    }
}
