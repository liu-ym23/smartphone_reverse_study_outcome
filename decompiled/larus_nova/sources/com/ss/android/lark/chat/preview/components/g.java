package com.ss.android.lark.chat.preview.components;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f416044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f416045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f416046c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        this.f416046c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f416046c.setImageDrawable(r100);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadStarted(Drawable r100) {
        if (this.f416044a == false) goto L5;
        this.f416046c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f416046c.setImageDrawable(r100);
        return;
    L5:
        if (this.f416045b == true) goto L7;
    L8:
        this.f416046c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f416046c.setImageDrawable(r100);
        return;
    L7:
        if (this.f416046c.getDrawable() == null) goto L8;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        this.f416046c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView r101 = this.f416046c;
        r101.setImageDrawable((Drawable) r100);
    }

    public g(boolean r100, boolean r101, ImageView r102) {
        this.f416044a = r100;
        this.f416045b = r101;
        this.f416046c = r102;
    }
}
