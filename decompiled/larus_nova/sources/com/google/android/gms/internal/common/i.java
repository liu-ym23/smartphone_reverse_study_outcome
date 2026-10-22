package com.google.android.gms.internal.common;

import android.os.Build;

/* JADX INFO: loaded from: classes23.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f274648a = 0;

    static {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r100 = 67108864;
    L6:
        f274648a = r100;
        return;
    L5:
        r100 = 0;
        goto L6
    }
}
