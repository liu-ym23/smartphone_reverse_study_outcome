package com.bytedance.lighten.loader;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: classes20.dex */
public final class b0 extends hf6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmartCircleImageView f254711a;

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
    }

    public b0(SmartCircleImageView r100) {
        this.f254711a = r100;
    }

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
        this.f254711a.f254698j = true;
    }
}
