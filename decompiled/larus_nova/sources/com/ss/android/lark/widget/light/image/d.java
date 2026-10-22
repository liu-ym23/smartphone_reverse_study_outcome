package com.ss.android.lark.widget.light.image;

import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f446092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LKUIRoundedImageView2 f446093b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        hac.b.f484427a.b("ImageGalleryLayout", "load image failed for key " + this.f446092a.f446082a);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        this.f446093b.setImageDrawable((Drawable) r100);
        this.f446093b.setClickable(true);
        hac.b.f484427a.b("ImageGalleryLayout", "load image success for key " + this.f446092a.f446082a);
    }

    public d(a.b r100, LKUIRoundedImageView2 r101) {
        this.f446092a = r100;
        this.f446093b = r101;
    }
}
