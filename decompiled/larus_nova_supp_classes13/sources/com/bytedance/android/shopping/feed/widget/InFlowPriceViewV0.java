package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewV0;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewV0 extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final PriceView a;
    public final ViewGroup b;
    public final PriceView c;
    public final PriceView d;
    public PromotionProductPriceStruct e;
    public PromotionProductStruct f;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewV0(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowPriceViewV0(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        int r0 = com.bytedance.android.shopping.feed.utils.c.a;
        Long r1 = com.bytedance.android.shopping.feed.utils.c.e(this.e);
        long r2 = 0;
        if (r1 == null) goto L5;
        long r6 = r1.longValue();
    L6:
        Long r3 = com.bytedance.android.shopping.feed.utils.c.c(this.e);
        if (r3 == null) goto L9;
        long r10 = r3.longValue();
    L10:
        Long r4 = com.bytedance.android.shopping.feed.utils.c.b(this.e).getMinPrice();
        if (r4 == null) goto L13;
        r2 = r4.longValue();
    L13:
        b(r6, r2, r10);
        return;
    L9:
        r10 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public InFlowPriceViewV0(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        if (ld3.b.a() == false) goto L5;
        Map r6 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r3).aU(2131560730, this, true);
    L6:
        PriceView r7 = findViewById(2131380115);
        this.a = r7;
        PriceView r8 = findViewById(2131379604);
        this.c = r8;
        this.b = (ViewGroup) findViewById(2131367757);
        PriceView r9 = findViewById(2131390512);
        this.d = r9;
        if (ld3.c.h() == false) goto L10;
        r7.B(se3.a.a(26.0f));
        r8.B(se3.a.a(15.0f));
        r9.B(se3.a.a(19.0f));
    L10:
        if (ld3.c.d() == false) goto L13;
        PriceView.z(r7, 0, 6);
        PriceView.z(r9, 0, 6);
        PriceView.z(r8, 0, 6);
        return;
    L13:
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560730, this, true);
        goto L6
    }

    public final void b(final long r8, final long r10, final long r12) {
        PromotionProductStruct r0 = this.f;
        if (r0 == null) goto L11;
        PromotionDepositPresaleActivity r1 = f53.a.c(r0).getDepositPresaleActivity();
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (com.bytedance.android.ec.model.n.b(r1) != true) goto L11;
        if (a53.a.a() != 1) goto L11;
    L13:
        if (r8 <= 0) goto L31;
        this.a.C(new InFlowPriceViewV0$updatePrice$1(this, r8));
        if (r2 == false) goto L18;
        this.a.C(new InFlowPriceViewV0$updatePrice$2(this));
    L18:
        if (r10 <= 0) goto L28;
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        this.d.C(new InFlowPriceViewV0$updatePrice$3(this, r10));
        if (r2 == false) goto L33;
        Drawable r9 = this.b.getBackground();
        if ((r9 instanceof GradientDrawable) == true) goto L24;
        r9 = null;
    L24:
        GradientDrawable r11 = (GradientDrawable) r9;
        if (r11 == null) goto L34;
        int r13 = g1.a;
        r11.setColor(g1.a.a(getContext(), 2131101767));
        return;
    L34:
        return;
    L33:
        return;
    L28:
        if (r12 <= 0) goto L30;
        this.c.setVisibility(0);
        this.b.setVisibility(8);
        this.c.C(new InFlowPriceViewV0$updatePrice$4(r12));
        return;
    L30:
        this.c.setVisibility(8);
        this.b.setVisibility(8);
        return;
    L31:
        setVisibility(8);
        return;
    L11:
        r2 = false;
        goto L13
    }

    public /* synthetic */ InFlowPriceViewV0(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
