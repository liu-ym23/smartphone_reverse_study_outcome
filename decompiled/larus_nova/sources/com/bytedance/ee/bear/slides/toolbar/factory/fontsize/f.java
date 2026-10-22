package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f238605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ an4.b f238606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f238607c;

    public f(d r100, an4.b r101, Fragment r102) {
        this.f238605a = r100;
        this.f238606b = r101;
        this.f238607c = r102;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.fontsize.h
    public final void onBackClick() {
        this.f238605a.c(this.f238606b, this.f238607c);
    }
}
