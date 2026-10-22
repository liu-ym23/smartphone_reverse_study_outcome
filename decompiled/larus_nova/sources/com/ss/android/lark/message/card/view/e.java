package com.ss.android.lark.message.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.EncryptImage;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements rkb.g<EncryptImage, Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f431933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f431934b;

    public e(ImageView r100, Context r101) {
        this.f431933a = r100;
        this.f431934b = r101;
    }

    @Override // rkb.g
    public final boolean onLoadFailed(Exception r100, EncryptImage r101, Target<Drawable> r102, boolean r103) {
        this.f431933a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f431933a.setBackgroundColor(UIUtils.getColor(this.f431934b, R.color.line_border_card));
        return false;
    }

    @Override // rkb.g
    public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r100, EncryptImage r101, Target<Drawable> r102, DataSource r103, boolean r104) {
        return false;
    }
}
