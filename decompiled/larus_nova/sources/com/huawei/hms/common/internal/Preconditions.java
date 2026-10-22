package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes23.dex */
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Cannot use constructor to make a new instance");
    }

    private static boolean a() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void checkNotMainThread() {
        if (a() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Must not be called on the main application thread");
    }

    public static void checkHandlerThread(Handler r100) {
        checkHandlerThread(r100, "Must be called on the handler thread");
    }

    public static void checkMainThread(String r100) {
        if (a() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100);
    }

    public static <O> O checkNotNull(O r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("must not refer to a null object");
    }

    public static void checkArgument(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void checkHandlerThread(Handler r100, String r101) {
        if (Looper.myLooper() != r100.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException(r101);
    }

    public static <O> O checkNotNull(O r100, Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static void checkState(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r101));
    }
}
