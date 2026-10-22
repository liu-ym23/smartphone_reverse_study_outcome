package com.ss.android.ainote.list;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteGalleryView.d f407079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f407080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AINoteGalleryView f407081c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        if (Intrinsics.areEqual(this.f407079a.f406914d, this.f407080b) == true) goto L5;
        return;
    L5:
        AINoteGalleryView.d r101 = this.f407079a;
        r101.f406914d = null;
        r101.f406915e = false;
        r101.f406911a.a();
        this.f407079a.f406912b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Drawable r102 = UDIconUtils.getIconDrawable(this.f407081c.getContext(), R.drawable.ud_icon_image_fail_outlined, new UDDimension.Dp(24));
        r102.setTint(ContextCompat.getColor(this.f407081c.getContext(), R.color.static_white));
        this.f407079a.f406912b.setImageDrawable(r102);
        this.f407079a.f406912b.setBackgroundColor(ContextCompat.getColor(this.f407081c.getContext(), R.color.bg_body_overlay));
        this.f407079a.T3();
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        super.onResourceReady(r101);
        if (Intrinsics.areEqual(this.f407079a.f406914d, this.f407080b) == false) goto L7;
        AINoteGalleryView.d r102 = this.f407079a;
        r102.f406915e = false;
        r102.f406911a.a();
        this.f407079a.f406912b.setBackground(null);
        this.f407079a.f406912b.setImageDrawable(r101);
        this.f407079a.T3();
        return;
    }

    public i(AINoteGalleryView.d r100, String r101, AINoteGalleryView r102) {
        this.f407079a = r100;
        this.f407080b = r101;
        this.f407081c = r102;
    }
}
