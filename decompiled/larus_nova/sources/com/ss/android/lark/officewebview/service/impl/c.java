package com.ss.android.lark.officewebview.service.impl;

import com.ss.android.lark.officewebview.service.listener.OnViewScrollListener;
import oxb.h;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnViewScrollListener f437516a;

    public c() {
    }

    @Override // oxb.h
    public final void K(OnViewScrollListener r100) {
        this.f437516a = r100;
    }

    @Override // oxb.h
    public final void u(int r100, int r101, int r102, int r103) {
        if (this.f437516a != null) goto L6;
        return;
    L6:
        if (r100 != r102) goto L13;
        int r104 = r101 - r103;
        if (Math.abs(r104) < 3) goto L13;
        if (r101 <= r103) goto L11;
        OnViewScrollListener r105 = this.f437516a;
        Math.abs(r104);
        r105.b();
    L20:
        this.f437516a.c(r100, r101);
        return;
    L11:
        if (r101 >= r103) goto L20;
        OnViewScrollListener r106 = this.f437516a;
        Math.abs(r104);
        r106.b();
    L13:
        if (r101 != r103) goto L20;
        if (Math.abs(r100 - r102) < 3) goto L20;
        if (r100 <= r102) goto L18;
        OnViewScrollListener r107 = this.f437516a;
        Math.abs(r101 - r103);
        r107.b();
        goto L20
    L18:
        if (r100 >= r102) goto L20;
        OnViewScrollListener r108 = this.f437516a;
        Math.abs(r101 - r103);
        r108.b();
        goto L20
    }

    @Override // oxb.h
    public final void m(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r108) {
        OnViewScrollListener r109 = this.f437516a;
        if (r109 != null) goto L5;
        return;
    L5:
        r109.a();
    }
}
