package com.bytedance.lighten.loader;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: classes20.dex */
public final class c0 implements hf6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf6.f f254715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmartCircleImageView f254716b;

    @Override // hf6.f
    public final void onRelease(Uri r100) {
        this.f254715a.onRelease(r100);
    }

    public c0(SmartCircleImageView r100, hf6.f r101) {
        this.f254716b = r100;
        this.f254715a = r101;
    }

    @Override // hf6.f
    public final void onIntermediateImageFailed(Uri r100, Throwable r101) {
        this.f254715a.onIntermediateImageFailed(r100, r101);
    }

    @Override // hf6.f
    public final void onIntermediateImageSet(Uri r100, df6.o r101) {
        this.f254715a.onIntermediateImageSet(r100, r101);
    }

    @Override // hf6.f
    public final void onStart(Uri r100, View r101) {
        this.f254715a.onStart(r100, r101);
    }

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
        this.f254715a.onFailed(r100, r101, r102);
    }

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
        this.f254716b.f254698j = true;
        this.f254715a.onComplete(r100, r101, r102, r103);
    }
}
