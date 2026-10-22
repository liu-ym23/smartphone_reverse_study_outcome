package com.ss.android.ugc.tools.view.widget.textimageview;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.views.CircleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f455204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f455205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f455206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f455208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f455209f;

    public final int getBorderColorRes() {
        return 0;
    }

    public final int getBorderPadding() {
        return 0;
    }

    public final int getBorderWidth() {
        return 0;
    }

    public final int getContainerHeight() {
        return 0;
    }

    public final int getContainerWidth() {
        return 0;
    }

    public final boolean getEnableBorder() {
        return false;
    }

    public final boolean getEnableCellStyle() {
        return false;
    }

    public final boolean getEnableExpandBorder() {
        return false;
    }

    public final boolean getEnableNewStickerPanel() {
        return false;
    }

    public final int getImageMarginLeft() {
        return 0;
    }

    public final int getImageMarginTop() {
        return 0;
    }

    public final int getImgHeight() {
        return 0;
    }

    public final int getImgWidth() {
        return 0;
    }

    public final int getRoundRadius() {
        return 0;
    }

    public final int getRoundRadiusForIcon() {
        return 0;
    }

    public final boolean getSimpleLayoutMode() {
        return false;
    }

    public final TextView getTextView() {
        return null;
    }

    public final CircleDraweeView getDynamicView() {
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        throw null;
    }

    public final CircleDraweeView getImageView() {
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        return null;
    }

    public final View getImageViewContainer() {
        Intrinsics.throwUninitializedPropertyAccessException("imageViewContainer");
        return null;
    }

    public final Drawable getPlaceHolderDrawableCached() {
        if (this.f455209f != null) goto L6;
        this.f455209f = getPlaceHolderDrawable();
    L6:
        return this.f455209f;
    }

    public final Drawable getPlaceHolderDrawable() {
        int r100 = getResources().getColor(R.color.tools_styleview_bg_subview);
        com.ss.android.ugc.tools.view.style.a r101 = new com.ss.android.ugc.tools.view.style.a();
        r101.c(0);
        r101.b(r100);
        r101.d(r100, 0);
        r101.f454977g = Float.valueOf(0);
        return r101.a();
    }

    public View getBorderLayout() {
        return this.f455204a;
    }

    public final View getBorderView() {
        return this.f455204a;
    }

    public final View getDotView() {
        return this.f455205b;
    }

    public final int getImgLayoutHeight() {
        return this.f455208e;
    }

    public final int getImgLayoutWidth() {
        return this.f455207d;
    }

    public final void setBorderView(View r100) {
        this.f455204a = r100;
    }

    public void setCustomSelected(boolean r100) {
        if (this.f455206c == r100) goto L17;
        this.f455206c = r100;
        if (this.f455204a != null) goto L9;
        if (r100 == true) goto L9;
        return;
    L9:
        View r101 = getBorderLayout();
        if (r101 == null) goto L16;
        if (r100 == false) goto L13;
        int r102 = 0;
    L14:
        r101.setVisibility(r102);
        return;
    L13:
        r102 = 8;
        goto L14
    L16:
        return;
    }

    public final void setDotView(View r100) {
        this.f455205b = r100;
    }

    public final void setImgLayoutHeight(int r100) {
        this.f455208e = r100;
    }

    public final void setImgLayoutWidth(int r100) {
        this.f455207d = r100;
    }

    public final void setPlaceHolderDrawableCached(Drawable r100) {
        this.f455209f = r100;
    }

    public void setText(CharSequence r100) {
        if (r100 == null) goto L5;
        r100.length();
        return;
    }
}
