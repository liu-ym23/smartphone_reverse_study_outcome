package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f278242a;

    static {
        f278242a = new Handler(Looper.getMainLooper());
    }

    public c() {
    }

    public static void a(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f278242a.post(r100);
    }
}
