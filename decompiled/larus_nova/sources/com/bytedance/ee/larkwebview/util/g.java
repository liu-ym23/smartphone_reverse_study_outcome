package com.bytedance.ee.larkwebview.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f242973a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f242974a = null;

        static {
            f242974a = new g();
        }
    }

    public g() {
        this.f242973a = new Handler(Looper.getMainLooper());
    }

    public static boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(Runnable r100) {
        this.f242973a.post(r100);
    }
}
