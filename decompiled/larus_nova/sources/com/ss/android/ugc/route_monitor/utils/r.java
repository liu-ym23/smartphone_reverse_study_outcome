package com.ss.android.ugc.route_monitor.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes40.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f454781a = null;

    static {
        f454781a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100, long r101) {
        f454781a.postDelayed(r100, Math.max(r101, 0));
    }
}
