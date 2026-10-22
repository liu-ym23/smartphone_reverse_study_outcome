package com.huawei.secure.android.common.util;

import android.os.Looper;

/* JADX INFO: loaded from: classes23.dex */
public class b {
    public static boolean a() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public b() {
    }
}
