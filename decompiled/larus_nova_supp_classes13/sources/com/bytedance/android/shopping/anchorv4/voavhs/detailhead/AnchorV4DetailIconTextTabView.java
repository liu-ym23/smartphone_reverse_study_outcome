package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.utils.c0;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020'¢\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0019\u001a\n \u0010*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001e\u001a\n \u0010*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR#\u0010!\u001a\n \u0010*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u001dR#\u0010&\u001a\n \u0010*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailIconTextTabView;", "Landroid/widget/FrameLayout;", "", "checked", "", "update", "selected", "setSelected", "a", "Z", "getOpt", "()Z", "setOpt", "(Z)V", "opt", "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getBackgroundView", "()Landroid/view/View;", "backgroundView", "c", "getImageViewGroup", "()Landroid/widget/FrameLayout;", "imageViewGroup", "Lcom/facebook/drawee/view/SimpleDraweeView;", "d", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "e", "getImageCoverView", "imageCoverView", "Landroid/widget/TextView;", "f", "getTextView", "()Landroid/widget/TextView;", "textView", "", "getNormalWH", "()I", "normalWH", "getSelectedWH", "selectedWH", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailIconTextTabView extends FrameLayout {
    public boolean a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    private final View getBackgroundView() {
        return (View) this.b.getValue();
    }

    private final SimpleDraweeView getImageCoverView() {
        return (SimpleDraweeView) this.e.getValue();
    }

    private final SimpleDraweeView getImageView() {
        return (SimpleDraweeView) this.d.getValue();
    }

    private final FrameLayout getImageViewGroup() {
        return (FrameLayout) this.c.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.f.getValue();
    }

    private final int getNormalWH() {
        if (this.a == false) goto L9;
        if (LargeFontModeUtil.a() <= 1.0d) goto L14;
        return c0.a(147.0d);
    L14:
        return c0.a(98.0d);
    L9:
        if (LargeFontModeUtil.a() <= 1.0d) goto L12;
        return c0.a(150.0d);
    L12:
        return c0.a(100.0d);
    }

    private final int getSelectedWH() {
        if (this.a == false) goto L6;
        return c0.a(98.0d);
    L6:
        return c0.a(102.0d);
    }

    public final boolean getOpt() {
        return this.a;
    }

    private final void update(boolean r4) {
        if (isSelected() != r4) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        int r0 = getSelectedWH();
    L8:
        ViewGroup.LayoutParams r1 = getBackgroundView().getLayoutParams();
        r1.width = r0;
        r1.height = r0;
        getBackgroundView().setLayoutParams(r1);
        if (this.a == true) goto L11;
        return;
    L11:
        if (r4 == false) goto L13;
        RoundingParams r5 = new RoundingParams();
        r5.setCornersRadius(com.bytedance.android.shopping.extensions.b.b(10));
        r5.setBorder(ag4.a.b(2131106041), com.bytedance.android.shopping.extensions.b.b(1));
        getImageView().getHierarchy().setRoundingParams(r5);
        RoundingParams r6 = new RoundingParams();
        r6.setCornersRadius(com.bytedance.android.shopping.extensions.b.b(10));
        getImageCoverView().getHierarchy().setRoundingParams(r6);
        return;
    L13:
        RoundingParams r7 = new RoundingParams();
        r7.setCornersRadius(com.bytedance.android.shopping.extensions.b.b(10));
        r7.setBorder(ag4.a.b(2131101169), com.bytedance.android.shopping.extensions.b.b(1));
        getImageView().getHierarchy().setRoundingParams(r7);
        getImageCoverView().getHierarchy().setRoundingParams(r7);
        return;
    L7:
        r0 = getNormalWH();
        goto L8
    }

    public final void setOpt(boolean r1) {
        this.a = r1;
    }

    @Override // android.view.View
    public void setSelected(boolean r1) {
        update(r1);
        super.setSelected(r1);
    }

    public AnchorV4DetailIconTextTabView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560486, this, true);
        this.b = LazyKt.lazy(new AnchorV4DetailIconTextTabView$backgroundView$2(this));
        this.c = LazyKt.lazy(new AnchorV4DetailIconTextTabView$imageViewGroup$2(this));
        this.d = LazyKt.lazy(new AnchorV4DetailIconTextTabView$imageView$2(this));
        this.e = LazyKt.lazy(new AnchorV4DetailIconTextTabView$imageCoverView$2(this));
        this.f = LazyKt.lazy(new AnchorV4DetailIconTextTabView$textView$2(this));
    }

    public final void a(String r3, ECUrlModel r4, boolean r5) {
        this.a = r5;
        if (r5 == false) goto L5;
        ViewGroup.LayoutParams r6 = getImageViewGroup().getLayoutParams();
        r6.width = getNormalWH();
        r6.height = getNormalWH();
        getImageViewGroup().setLayoutParams(r6);
        getImageCoverView().setLayoutParams(r6);
        getBackgroundView().setVisibility(8);
        ViewGroup.LayoutParams r7 = getTextView().getLayoutParams();
        r7.width = getNormalWH();
        getTextView().setLayoutParams(r7);
        com.bytedance.android.shopping.anchorv3.comment.c.a(getTextView(), 0.0f, 0.0f, 8.0f, 8.0f);
    L5:
        getTextView().setText(r3);
        if (r4 == null) goto L9;
        y.a(getImageView(), r4);
        return;
    }
}
