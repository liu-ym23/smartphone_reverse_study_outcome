package com.ss.android.lark.officewebview.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f437548a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f437549a = null;

        static {
            f437549a = new i();
        }
    }

    public i() {
        this.f437548a = new Handler(Looper.getMainLooper());
    }

    public static boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(Runnable r100) {
        this.f437548a.post(r100);
    }
}
