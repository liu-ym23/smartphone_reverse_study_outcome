package com.bytedance.sysoptimizer.java;

import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes22.dex */
public class AndroidNWindowManagerProtector {
    private static final int LAUNCH_ACTIVITY = 100;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "WindowManagerProtector";
    private static GuardListener guardListener;
    private static int retryCount;

    public static class CrashGuardCallback implements Handler.Callback {
        Handler.Callback originCallBack;
        Handler systemHandler;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            Handler.Callback r101 = this.originCallBack;     // Catch: Throwable -> L12
            if (r101 != null) goto L5;
        L8:
            Handler r102 = this.systemHandler;     // Catch: Throwable -> L12
            if (r102 == null) goto L11;
            r102.handleMessage(r100);     // Catch: Throwable -> L12
            AndroidNWindowManagerProtector.access$000();     // Catch: Throwable -> L12
        L11:
            return true;
        L5:
            if (r101.handleMessage(r100) == false) goto L8;
            AndroidNWindowManagerProtector.access$000();     // Catch: Throwable -> L12
            return true;
        L12:
            th = move-exception;
            if ((th instanceof StackOverflowError) == false) goto L26;
            if (r100 != null) goto L17;
            return false;
        L17:
            if (r100.what == 100) goto L19;
            return false;
        L19:
            if (AndroidNWindowManagerProtector.access$100(r100, this.systemHandler) == false) goto L21;
            return false;
        L21:
            if (AndroidNWindowManagerProtector.access$200() == null) goto L23;
            AndroidNWindowManagerProtector.access$200().onGuardFailed();
        L23:
            throw th;
        L26:
            throw th;
        }

        public CrashGuardCallback(Handler r100, Handler.Callback r101) {
            this.systemHandler = r100;
            this.originCallBack = r101;
        }
    }

    public interface GuardListener {
        void onGuardFailed();

        void onGuardSuccess();
    }

    public AndroidNWindowManagerProtector() {
    }

    private static void resetRetryCount() {
        if (retryCount <= 0) goto L5;
        retryCount = 0;
    L5:
        GuardListener r100 = guardListener;
        if (r100 == null) goto L9;
        r100.onGuardSuccess();
        return;
    }

    private static void takeOverSystemCallback() {
        Object r100 = ReflectionUtils.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread");
        if (r100 == null) goto L8;
        Handler r101 = (Handler) ReflectionUtils.getFieldObject("android.app.ActivityThread", "mH", r100);
        if (r101 == null) goto L9;
        ReflectionUtils.setFieldObject(r101, "mCallback", new CrashGuardCallback(r101, (Handler.Callback) ReflectionUtils.getFieldObject("android.app.ActivityThread$H", "mCallback", r101)));
        return;
    L9:
        return;
    }

    public static /* synthetic */ void access$000() {
        resetRetryCount();
    }

    public static /* synthetic */ GuardListener access$200() {
        return guardListener;
    }

    public static void install(GuardListener r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 24) goto L5;
    L6:
        takeOverSystemCallback();
        guardListener = r100;
        return;
    L5:
        if (r101 == 25) goto L6;
    }

    public static /* synthetic */ boolean access$100(Message r100, Handler r101) {
        return retryWhenWindowManagerStackOverFlow(r100, r101);
    }

    private static boolean retryWhenWindowManagerStackOverFlow(Message r100, Handler r101) {
        if (retryCount <= 3) goto L11;
        return false;
    L11:
        Thread.sleep(20);     // Catch: InterruptedException -> L7
        Message r102 = new Message();     // Catch: InterruptedException -> L7
        r102.copyFrom(r100);     // Catch: InterruptedException -> L7
        r101.sendMessage(r102);     // Catch: InterruptedException -> L7
        retryCount++;     // Catch: InterruptedException -> L7
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
