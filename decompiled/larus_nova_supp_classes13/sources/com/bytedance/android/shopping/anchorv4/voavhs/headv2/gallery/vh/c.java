package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ GalleryVideoVH a;

    public c(GalleryVideoVH r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        GalleryVideoVH.a r3 = this.a.m;
        if (r3 == null) goto L6;
        ((com.bytedance.android.shopping.anchorv4.video.d) r3).d.c(r3);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        GalleryVideoVH.a r3 = this.a.m;
        if (r3 == null) goto L6;
        ((com.bytedance.android.shopping.anchorv4.video.d) r3).d.g(r3);
        return;
    }
}
