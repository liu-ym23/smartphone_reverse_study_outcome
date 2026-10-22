package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.utils.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewV1;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewV1 extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public final PriceView a;
    public PromotionProductStruct b;
    public final String c;
    public PromotionProductPriceStruct d;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewV1(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowPriceViewV1(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        int r0 = com.bytedance.android.shopping.feed.utils.c.a;
        Long r1 = com.bytedance.android.shopping.feed.utils.c.e(this.d);
        long r2 = 0;
        if (r1 == null) goto L5;
        long r6 = r1.longValue();
    L6:
        PromotionProductPriceStruct r3 = this.d;
        if (r3 == null) goto L9;
        Long r4 = r3.getMaxPrice();
    L10:
        if (r4 == null) goto L12;
        long r8 = r4.longValue();
    L13:
        Long r5 = com.bytedance.android.shopping.feed.utils.c.c(this.d);
        if (r5 == null) goto L16;
        r5.longValue();
    L16:
        Long r7 = com.bytedance.android.shopping.feed.utils.c.b(this.d).getMinPrice();
        if (r7 == null) goto L19;
        r2 = r7.longValue();
    L19:
        long r10 = r2;
        PromotionProductPriceStruct r9 = this.d;
        if (r9 == null) goto L22;
        r9.getHeader();
    L22:
        c(r6, r8, r10);
        return;
    L12:
        r8 = 0;
        goto L13
    L9:
        r4 = null;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public InFlowPriceViewV1(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = th.a.g(r2, 2131895957);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560731, this, true);
    L6:
        PriceView r6 = findViewById(2131380115);
        this.a = r6;
        if (ld3.c.h() == false) goto L10;
        r6.B(se3.a.a(24.0f));
        return;
    L10:
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560731, this, true);
        goto L6
    }

    public static final String a(InFlowPriceViewV1 r0, String r1, String r2) {
        r0.getClass();
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return r1 + ' ' + r2;
    L6:
        if (r1 != null) goto L14;
        if (r2 != null) goto L13;
        return null;
    L13:
        return r2;
    L14:
        return r1;
    }

    public final void c(final long r13, long r15, final long r17) {
        PromotionProductStruct r0 = this.b;
        if (r0 == null) goto L11;
        PromotionDepositPresaleActivity r1 = f53.a.c(r0).getDepositPresaleActivity();
        if (r1 == null) goto L11;
        if (com.bytedance.android.ec.model.n.b(r1) != true) goto L11;
        if (a53.a.a() != 1) goto L11;
        boolean r9 = true;
    L12:
        PromotionProductPriceStruct r2 = this.d;
        if (r2 == null) goto L18;
        PromotionDiscountPrice r3 = r2.getDiscountPrice();
        if (r3 == null) goto L18;
        String r4 = r3.getHeader();
        if (r4 == null) goto L18;
    L21:
        final String r7 = r4;
    L23:
        PromotionProductStruct r5 = this.b;
        if (r5 == null) goto L26;
        r5.setActivityLabel(r7);
    L26:
        int r6 = com.bytedance.android.shopping.feed.utils.c.a;
        PromotionDiscountPrice r8 = com.bytedance.android.shopping.feed.utils.c.b(this.d);
        int r10 = y.a;
        if (y.u(Long.valueOf(r13), r8, Long.valueOf(r17)) == false) goto L37;
        if (r15 <= r13) goto L31;
    L34:
        final String r11 = this.c;
    L35:
        final String r12 = r7;
        this.a.C(new InFlowPriceViewV1$updatePrice$1(this, r17, r11, r12));
    L41:
        if (r9 == false) goto L44;
        this.a.C(new InFlowPriceViewV1$updatePrice$3(this));
        return;
    L44:
        return;
    L31:
        if (y.v(r8) == true) goto L34;
        r11 = null;
        goto L35
    L37:
        if (r15 <= r13) goto L39;
        final String r14 = this.c;
    L40:
        this.a.C(new InFlowPriceViewV1$updatePrice$2(this, r13, r17, r14, r7));
        goto L41
    L39:
        r14 = null;
    L18:
        PromotionProductPriceStruct r16 = this.d;
        if (r16 == null) goto L22;
        r4 = r16.getHeader();
        goto L21
    L22:
        r7 = null;
    L11:
        r9 = false;
        goto L12
    }

    public /* synthetic */ InFlowPriceViewV1(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
