package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f224252a;

    public m(k r100) {
        this.f224252a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r101 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r100;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f223712a != true) goto L7;
    L8:
        k r103 = this.f224252a;
        if (r103.f224235q == r102) goto L13;
        r103.f224235q = r102;
        r103.c();
        k.a(this.f224252a);
        this.f224252a.j();
        this.f224252a.f224224f.invoke(Boolean.valueOf(r102));
        tt5.a.h("DriveSdk", "observeOverlayTemporaryState hidden=" + r102);
        return;
    L13:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
