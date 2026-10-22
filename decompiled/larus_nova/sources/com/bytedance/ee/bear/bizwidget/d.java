package com.bytedance.ee.bear.bizwidget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f216367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f216368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f216369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f216370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f216371e;

    public final void a() {
        this.f216370d.removeCallbacks(this.f216369c);
        Toast.cancelLoading();
        this.f216368b = false;
    }

    public final void b() {
        this.f216370d.removeCallbacks(this.f216369c);
        this.f216370d.postDelayed(this.f216369c, 300);
        this.f216368b = true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.bizwidget.c] */
    public d(Context r100) {
        this.f216369c = new c(this);
        this.f216370d = new Handler(Looper.getMainLooper());
        this.f216371e = -1;
        this.f216367a = r100;
    }
}
