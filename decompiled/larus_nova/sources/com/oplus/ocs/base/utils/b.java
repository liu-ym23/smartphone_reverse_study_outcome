package com.oplus.ocs.base.utils;

import android.os.Looper;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static boolean a() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return true;
    L6:
        return false;
    }
}
