package com.bytedance.ee.bear.widgets;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public abstract class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f240331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f240332b;

    public abstract void a(View r100);

    public t() {
        this.f240332b = 200;
    }

    public t(long r100) {
        this.f240332b = 200;
        this.f240332b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        long r102 = r101 - this.f240331a;
        this.f240331a = r101;
        if (r102 <= this.f240332b) goto L5;
        a(r100);
        return;
    L5:
        com.ss.android.lark.officesdk.utils.di.j.f("SafeClickListener", "So fast click , ignored !");
    }
}
