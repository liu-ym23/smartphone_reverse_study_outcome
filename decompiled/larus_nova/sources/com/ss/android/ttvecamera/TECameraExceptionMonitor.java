package com.ss.android.ttvecamera;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraExceptionMonitor {
    private static WeakReference<IExceptionMonitor> sExceptionMonitor;

    public interface IExceptionMonitor {
        void onException(Throwable r100);
    }

    public TECameraExceptionMonitor() {
    }

    public static void monitorException(Throwable r100) {
        WeakReference<IExceptionMonitor> r101 = sExceptionMonitor;
        if (r101 != null) goto L5;
        IExceptionMonitor r102 = null;
    L6:
        if (r102 == null) goto L9;
        r102.onException(r100);
        return;
    L9:
        return;
    L5:
        r102 = r101.get();
        goto L6
    }

    public static void register(IExceptionMonitor r100) {
        if (r100 != null) goto L4;
        WeakReference<IExceptionMonitor> r101 = null;
    L5:
        sExceptionMonitor = r101;
        return;
    L4:
        r101 = new WeakReference(r100);
        goto L5
    }
}
