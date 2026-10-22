package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rect f216399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f216400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f216401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f216402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f216403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f216404f;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r110) {
        if (r110 == null) goto L5;
        Rect r101 = this.f216399a;
        r110.setRoundRect(r101.left + this.f216400b, r101.top + this.f216401c, r101.right + this.f216402d, r101.bottom + this.f216403e, this.f216404f);
        return;
    }

    public a(Rect r100, int r101, int r102, int r103, int r104, int r105) {
        this.f216399a = r100;
        this.f216400b = r101;
        this.f216401c = r102;
        this.f216402d = r103;
        this.f216403e = r104;
        this.f216404f = r105;
    }
}
