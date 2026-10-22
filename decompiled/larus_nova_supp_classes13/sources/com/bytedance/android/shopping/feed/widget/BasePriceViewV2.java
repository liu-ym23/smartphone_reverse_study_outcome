package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStructV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/BasePriceViewV2;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "a", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "getMainPriceView", "()Lcom/bytedance/android/ec/core/widget/price/PriceView;", "setMainPriceView", "(Lcom/bytedance/android/ec/core/widget/price/PriceView;)V", "mainPriceView", "b", "getSubPriceView", "setSubPriceView", "subPriceView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getPriceDescriptionView", "()Landroid/widget/TextView;", "setPriceDescriptionView", "(Landroid/widget/TextView;)V", "priceDescriptionView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePriceViewV2 extends FrameLayout {
    public PriceView a;
    public PriceView b;
    public TextView c;
    public final RelativeLayout d;
    public PromotionProductPriceStructV2 e;

    public BasePriceViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BasePriceViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void a(Context r1);

    public final PriceView getMainPriceView() {
        return this.a;
    }

    public final TextView getPriceDescriptionView() {
        return this.c;
    }

    public final PriceView getSubPriceView() {
        return this.b;
    }

    public final void setMainPriceView(PriceView r1) {
        this.a = r1;
    }

    public final void setPriceDescriptionView(TextView r1) {
        this.c = r1;
    }

    public final void setSubPriceView(PriceView r1) {
        this.b = r1;
    }

    public BasePriceViewV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a(r2);
        this.a = findViewById(2131379459);
        this.b = findViewById(2131387541);
        this.c = (TextView) findViewById(2131383006);
        this.d = (RelativeLayout) findViewById(2131370765);
        PriceView r5 = this.a;
        if (r5 == null) goto L5;
        PriceView.z(r5, 0, 6);
    L5:
        PriceView r6 = this.b;
        if (r6 == null) goto L9;
        PriceView.z(r6, 0, 6);
    L9:
        if (ld3.c.h() == false) goto L17;
        PriceView r7 = this.a;
        if (r7 == null) goto L13;
        r7.B(se3.a.a(26.0f));
    L13:
        PriceView r8 = this.b;
        if (r8 == null) goto L18;
        r8.B(se3.a.a(13.0f));
        return;
    L18:
        return;
    }

    public /* synthetic */ BasePriceViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
