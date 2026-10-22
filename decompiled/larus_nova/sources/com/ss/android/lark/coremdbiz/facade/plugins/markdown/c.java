package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f420144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f420145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f420146c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        Log.e("MarkdownImageLoader", "movable image load failed, " + this.f420144a);
        this.f420145b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f420145b.setImageDrawable(this.f420146c);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        super.onResourceReady(r101);
        this.f420145b.setImageDrawable(r101);
    }

    public c(String r100, LKUIRoundedImageView2 r101, Drawable r102) {
        this.f420144a = r100;
        this.f420145b = r101;
        this.f420146c = r102;
    }
}
