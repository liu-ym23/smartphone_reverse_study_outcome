package com.lynx.animax;

import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes32.dex */
public class VSyncMonitor {
    public VSyncMonitor() {
    }

    private static native void nativeInvokeCallback(long r100);

    public static void requestVSync() {
        Runnable r100 = new b0();
        Handler r101 = y4a.d.a();
        Message r102 = Message.obtain(r101, r100);
        if (Build.VERSION.SDK_INT < 22) goto L5;
        r102.setAsynchronous(true);
    L5:
        r101.sendMessageAtFrontOfQueue(r102);
    }

    public static void a(long r100) {
        nativeInvokeCallback(r100);
    }
}
