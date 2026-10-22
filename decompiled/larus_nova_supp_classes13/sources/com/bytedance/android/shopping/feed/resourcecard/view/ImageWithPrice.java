package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/ImageWithPrice;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "a", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getMainImgDV", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "mainImgDV", "Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "b", "Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "getPanelPriceView", "()Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "panelPriceView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageWithPrice extends FrameLayout {
    public final ECDraweeView a;
    public final PanelPriceView b;

    public ImageWithPrice(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageWithPrice(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ECDraweeView getMainImgDV() {
        return this.a;
    }

    public final PanelPriceView getPanelPriceView() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r1);
    }

    public ImageWithPrice(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560794, this, true);
        this.a = findViewById(2131379444);
        this.b = (PanelPriceView) findViewById(2131381885);
    }

    public /* synthetic */ ImageWithPrice(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
