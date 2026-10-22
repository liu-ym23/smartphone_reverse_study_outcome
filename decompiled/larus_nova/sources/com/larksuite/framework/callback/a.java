package com.larksuite.framework.callback;

import android.os.Handler;

/* JADX INFO: loaded from: classes24.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f285564a;

    public a(Handler r100) {
        this.f285564a = r100;
    }

    public void a(Runnable r100) {
        this.f285564a.post(r100);
    }

    public void b(Runnable r100, long r101) {
        this.f285564a.postDelayed(r100, r101);
    }
}
