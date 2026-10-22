package com.bytedance.ee.lark.infra.foundation.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f242802a = null;

    static {
        f242802a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        f242802a.post(r100);
    }
}
