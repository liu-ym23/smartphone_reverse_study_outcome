package com.lynx.component.svg;

import android.graphics.Bitmap;
import com.lynx.serval.svg.SVGRender;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SVGRender.b f381005a;

    @Override // com.lynx.component.svg.d.b
    public final void onFailed() {
        this.f381005a.getClass();
    }

    public b(SVGRender.a r100) {
        this.f381005a = r100;
    }

    @Override // com.lynx.component.svg.d.b
    public final void onSuccess(Bitmap r100) {
        ((SVGRender.a) this.f381005a).a(r100);
    }
}
