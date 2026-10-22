package com.lynx.component.svg;

import android.graphics.Bitmap;
import com.lynx.serval.svg.SVGRender;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SVGRender.b f381018a;

    @Override // com.lynx.component.svg.d.b
    public final void onFailed() {
        this.f381018a.getClass();
    }

    public g(SVGRender.a r100) {
        this.f381018a = r100;
    }

    @Override // com.lynx.component.svg.d.b
    public final void onSuccess(Bitmap r100) {
        ((SVGRender.a) this.f381018a).a(r100);
    }
}
