package com.bytedance.android.shopping.product.flow.view.info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.n;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.bytedance.android.shopping.utils.g;
import d63.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardPrefixActivityIconPriceView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardPrefixActivityIconPriceView extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public final TextView a;
    public final PriceView b;
    public final PriceView c;
    public final PriceView d;
    public PromotionProductStruct e;
    public final String f;
    public ActivityVO g;
    public j h;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardPrefixActivityIconPriceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFlowCardPrefixActivityIconPriceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        j r0 = this.h;
        long r1 = 0;
        if (r0 == null) goto L7;
        Long r2 = r0.e;
        if (r2 == null) goto L7;
        long r12 = r2.longValue();
    L8:
        j r3 = this.h;
        if (r3 == null) goto L13;
        Long r4 = r3.c;
        if (r4 == null) goto L13;
        long r8 = r4.longValue();
    L14:
        j r5 = this.h;
        if (r5 == null) goto L19;
        Long r6 = r5.d;
        if (r6 == null) goto L19;
        long r10 = r6.longValue();
    L20:
        j r7 = this.h;
        if (r7 == null) goto L27;
        PromotionDiscountPrice r9 = r7.q;
        if (r9 == null) goto L27;
        Long r11 = r9.getMinPrice();
        if (r11 == null) goto L27;
        r1 = r11.longValue();
    L27:
        b(r1, r8, r10, r12);
        return;
    L19:
        r10 = 0;
    L13:
        r8 = 0;
    L7:
        r12 = 0;
        goto L8
    }

    public ProductFlowCardPrefixActivityIconPriceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = th.a.g(r2, 2131895957);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560806, this, true);
    L6:
        this.a = (TextView) findViewById(2131382872);
        this.b = findViewById(2131382842);
        this.c = findViewById(2131380119);
        this.d = findViewById(2131379605);
        RelativeLayout r6 = (RelativeLayout) findViewById(2131383120);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560806, this, true);
        goto L6
    }

    public /* synthetic */ ProductFlowCardPrefixActivityIconPriceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(final long r17, final long r19, final long r21, final long r23) {
        j r0 = this.h;
        if (r0 == null) goto L5;
        PromotionDiscountPrice r1 = r0.q;
    L6:
        final PromotionDiscountPrice r8 = r1;
        if (r8 == null) goto L14;
        int r2 = y.a;
        if (y.u(Long.valueOf(r19), r8, Long.valueOf(r17)) == false) goto L14;
        this.c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$1(this, r17, r21, r19, r8));
        if (r23 <= r19) goto L13;
        this.d.setVisibility(0);
        this.d.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$2(r23));
    L48:
        int r3 = 8;
    L51:
        if (a53.a.a() != 1) goto L63;
        ActivityVO r4 = this.g;
        if (r4 != null) goto L55;
        return;
    L55:
        if (r4.getActivityType() != r3) goto L72;
        ActivityVO r5 = this.g;
        if (r5 == null) goto L73;
        PromotionDepositPresaleActivity r6 = r5.getDepositPresaleActivity();
        if (r6 != null) goto L61;
        return;
    L61:
        if (n.b(r6) != true) goto L75;
        this.c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$7(this));
        TextView r7 = this.a;
        int r9 = g1.a;
        r7.setTextColor(g1.a.a(getContext(), 2131101767));
        return;
    L75:
        return;
    L73:
        return;
    L72:
        return;
    L63:
        ActivityVO r10 = this.g;
        if (r10 == null) goto L68;
        int r11 = 8;
        if (r10.getActivityType() != 8) goto L69;
        this.b.setVisibility(0);
        this.b.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$8(this));
        return;
    L69:
        this.b.setVisibility(r11);
        return;
    L68:
        r11 = 8;
        goto L69
    L13:
        this.d.setVisibility(8);
    L14:
        ActivityVO r12 = this.g;
        if (r12 == null) goto L20;
        if (r12.isSubsidizedActivity() != true) goto L20;
        this.c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$3(this));
    L22:
        ActivityVO r13 = this.g;
        if (r13 == null) goto L49;
        int r14 = y.a;
        Intrinsics.checkNotNullParameter(r13, "activityVO");
        if (r13.getActivityType() != 1) goto L27;
    L32:
        boolean r15 = true;
    L33:
        if (r15 != true) goto L49;
        if (r23 <= 0) goto L45;
        String r16 = g.d(r23);
        if (StringsKt.indexOf$default(r16, ".", 0, false, 6, null) == (-1)) goto L43;
        if (r16.length() > 6) goto L45;
    L44:
        boolean r18 = true;
    L46:
        if (r18 == false) goto L49;
        this.d.setVisibility(0);
        this.d.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$6(r23));
        goto L48
    L43:
        if (r16.length() < 6) goto L44;
    L45:
        r18 = false;
        goto L46
    L27:
        if (r13.getActivityType() == 6) goto L32;
        if (r13.getActivityType() == 12) goto L32;
        r15 = false;
    L49:
        r3 = 8;
        this.d.setVisibility(8);
    L20:
        if (r19 <= 0) goto L22;
        this.c.C(new ProductFlowCardPrefixActivityIconPriceView$updatePrice$4(this, r17, r19, r21));
        goto L22
    L5:
        r1 = null;
        goto L6
    }
}
