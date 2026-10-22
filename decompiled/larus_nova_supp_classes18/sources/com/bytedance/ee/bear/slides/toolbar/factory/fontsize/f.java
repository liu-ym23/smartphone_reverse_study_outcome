package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements h {
    public final /* synthetic */ d a;
    public final /* synthetic */ an4.b b;
    public final /* synthetic */ Fragment c;

    public f(d r1, an4.b r2, Fragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.fontsize.h
    public final void onBackClick() {
        this.a.c(this.b, this.c);
    }
}
