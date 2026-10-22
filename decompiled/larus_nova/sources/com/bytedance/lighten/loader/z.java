package com.bytedance.lighten.loader;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: classes20.dex */
public final class z extends hf6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmartCircleImageView f254792a;

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
    }

    public z(SmartCircleImageView r100) {
        this.f254792a = r100;
    }

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
        if (r103 == null) goto L4;
        this.f254792a.f254698j = true;
        this.f254792a.f254700l = true;
        return;
    L4:
        this.f254792a.f254698j = false;
        this.f254792a.f254700l = false;
    }
}
