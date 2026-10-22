package com.bytedance.ee.larkwebview.service.impl;

import com.bytedance.ee.larkwebview.service.listener.OnViewScrollListener;
import st5.i;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnViewScrollListener f242945a;

    public c() {
    }

    @Override // st5.i
    public final void I(OnViewScrollListener r100) {
        this.f242945a = r100;
    }

    @Override // st5.i
    public final void u(int r100, int r101, int r102, int r103) {
        if (this.f242945a != null) goto L6;
        return;
    L6:
        if (r100 != r102) goto L13;
        int r104 = r101 - r103;
        if (Math.abs(r104) < 3) goto L13;
        if (r101 <= r103) goto L11;
        OnViewScrollListener r105 = this.f242945a;
        Math.abs(r104);
        r105.b();
    L20:
        this.f242945a.c(r100, r101);
        return;
    L11:
        if (r101 >= r103) goto L20;
        OnViewScrollListener r106 = this.f242945a;
        Math.abs(r104);
        r106.b();
    L13:
        if (r101 != r103) goto L20;
        if (Math.abs(r100 - r102) < 3) goto L20;
        if (r100 <= r102) goto L18;
        OnViewScrollListener r107 = this.f242945a;
        Math.abs(r101 - r103);
        r107.b();
        goto L20
    L18:
        if (r100 >= r102) goto L20;
        OnViewScrollListener r108 = this.f242945a;
        Math.abs(r101 - r103);
        r108.b();
        goto L20
    }

    @Override // st5.i
    public final void m(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r108) {
        OnViewScrollListener r109 = this.f242945a;
        if (r109 != null) goto L5;
        return;
    L5:
        r109.a();
    }
}
