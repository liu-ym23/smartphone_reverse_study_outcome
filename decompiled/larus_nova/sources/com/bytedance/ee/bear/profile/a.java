package com.bytedance.ee.bear.profile;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236280a;

    public a(HalfProfileActivity r100) {
        this.f236280a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r104 - r102;
        HalfProfileActivity r110 = this.f236280a;
        r110.f236244f = r109;
        j r111 = r110.f236248j;
        if (r111 == null) goto L6;
        r111.m(0.0f, r109 * 0.87f, r109);
        return;
    }
}
