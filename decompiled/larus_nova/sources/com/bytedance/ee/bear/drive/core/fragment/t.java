package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final class t<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f224272a;

    public t(r r100) {
        this.f224272a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r101 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r100;
        r r102 = this.f224272a;
        if (r102.f224270k == true) goto L25;
        boolean r103 = false;
        if (r101 != null) goto L8;
    L10:
        boolean r104 = false;
    L12:
        if (r102.f224268i == r104) goto L26;
        r102.f224268i = r104;
        r102.c();
        this.f224272a.a();
        StringBuilder r105 = new StringBuilder("thumbnailOverlay fullscreen hidden=");
        r105.append(r104);
        r105.append(" shown=");
        r r106 = this.f224272a;
        if (r106.f224267h == true) goto L17;
    L23:
        r105.append(r103);
        tt5.a.h("DriveThumbnailOverlay", r105.toString());
        return;
    L17:
        if (r106.f224266g == null) goto L23;
        if (r106.f224268i == true) goto L23;
        if (r106.f224269j.isEmpty() == false) goto L23;
        r103 = true;
        goto L23
    L26:
        return;
    L8:
        if (r101.f223712a != true) goto L10;
        r104 = true;
        goto L12
    }
}
