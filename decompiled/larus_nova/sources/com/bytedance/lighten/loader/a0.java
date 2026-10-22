package com.bytedance.lighten.loader;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: classes20.dex */
public final class a0 implements hf6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf6.f f254708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmartCircleImageView f254709b;

    @Override // hf6.f
    public final void onRelease(Uri r100) {
        this.f254708a.onRelease(r100);
    }

    public a0(SmartCircleImageView r100, hf6.f r101) {
        this.f254709b = r100;
        this.f254708a = r101;
    }

    @Override // hf6.f
    public final void onIntermediateImageFailed(Uri r100, Throwable r101) {
        this.f254708a.onIntermediateImageFailed(r100, r101);
    }

    @Override // hf6.f
    public final void onIntermediateImageSet(Uri r100, df6.o r101) {
        this.f254708a.onIntermediateImageSet(r100, r101);
    }

    @Override // hf6.f
    public final void onStart(Uri r100, View r101) {
        this.f254708a.onStart(r100, r101);
    }

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
        this.f254708a.onFailed(r100, r101, r102);
    }

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
        if (r103 == null) goto L4;
        this.f254709b.f254698j = true;
        this.f254709b.f254700l = true;
    L5:
        this.f254708a.onComplete(r100, r101, r102, r103);
        return;
    L4:
        this.f254709b.f254698j = false;
        this.f254709b.f254700l = false;
        goto L5
    }
}
