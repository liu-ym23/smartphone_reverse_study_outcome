package com.ss.android.downloadlib.exception;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes34.dex */
public class Safe {

    public interface Run<T> {
        T run();
    }

    public Safe() {
    }

    public static void noCatch(final Runnable r100) {
        noCatch(new AnonymousClass1(r100));
    }

    public static <T> T noCatch(Run<T> r100) {
        return (T) tryCatch(true, null, r100);
    }

    public static <T> T tryCatch(String r100, Run<T> r101) {
        return (T) tryCatch(true, r100, r101);
    }

    public static void tryCatch(String r100, Runnable r101) {
        tryCatch(true, r100, r101);
    }

    public static <T> T tryCatch(boolean r100, String r101, Run<T> r102) {
        return r102.run();
    L4:
        th = move-exception;
        if ((th instanceof MonitorException) == true) goto L12;
        TTDownloaderMonitor.inst().monitorException(r100, th, r101);
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return null;
    L11:
        throw th;
    L12:
        throw th;
    }

    public static void tryCatch(boolean r100, String r101, final Runnable r102) {
        tryCatch(r100, r101, new AnonymousClass2(r102));
    }
}
