package com.bytedance.ee.util.ui;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f243161a;

    public static boolean a(long r100) {
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - f243161a) >= r100) goto L6;
        return false;
    L6:
        f243161a = r101;
        return true;
    }
}
