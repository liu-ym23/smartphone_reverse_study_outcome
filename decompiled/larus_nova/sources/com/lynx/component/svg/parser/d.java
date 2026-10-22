package com.lynx.component.svg.parser;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements com.lynx.component.svg.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SVG.n f381201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreserveAspectRatio f381202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f381203c;

    @Override // com.lynx.component.svg.d.b
    public final void onFailed() {
    }

    @Override // com.lynx.component.svg.d.b
    public final void onSuccess(Bitmap r100) {
        this.f381203c.D(this.f381201a, this.f381202b, r100);
    }

    public d(e r100, SVG.n r101, PreserveAspectRatio r102) {
        this.f381203c = r100;
        this.f381201a = r101;
        this.f381202b = r102;
    }
}
