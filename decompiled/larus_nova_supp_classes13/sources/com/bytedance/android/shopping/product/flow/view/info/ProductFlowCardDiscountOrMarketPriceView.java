package com.bytedance.android.shopping.product.flow.view.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.utils.y;
import d63.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardDiscountOrMarketPriceView;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardDiscountOrMarketPriceView extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public final PriceView a;
    public final ViewGroup b;
    public final PriceView c;
    public final PriceView d;
    public final TextView e;
    public final String f;
    public j g;
    public ActivityVO h;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardDiscountOrMarketPriceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFlowCardDiscountOrMarketPriceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ProductFlowCardDiscountOrMarketPriceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = th.a.g(r2, 2131895957);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560808, this, true);
    L6:
        this.a = findViewById(2131380999);
        this.c = findViewById(2131380998);
        this.b = (ViewGroup) findViewById(2131367757);
        this.d = findViewById(2131390512);
        this.e = (TextView) findViewById(2131390513);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560808, this, true);
        goto L6
    }

    public /* synthetic */ ProductFlowCardDiscountOrMarketPriceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(final long r17, final long r19, final long r21, final long r23) {
        ActivityVO r0 = this.h;
        if (r0 == null) goto L5;
        Boolean r12 = Boolean.valueOf(r0.isDepositActivity());
    L7:
        if (r17 == 0) goto L41;
        this.a.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$1(this, r17, r19));
        boolean r1 = true;
        if (r12 != null) goto L11;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == false) goto L28;
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        TextView r3 = this.e;
        j r4 = this.g;
        if (r4 == null) goto L26;
        PromotionDiscountPrice r5 = r4.q;
        if (r5 == null) goto L26;
        String r11 = r5.getHeader();
    L27:
        r3.setText(r11);
        this.d.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$2(this, r21));
        return;
    L26:
        r11 = null;
        goto L27
    L28:
        this.b.setVisibility(8);
        if (r23 > r17) goto L32;
        r1 = false;
    L32:
        if (r1 == false) goto L34;
        this.c.setVisibility(0);
        this.c.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$3(r23));
    L36:
        if (r21 > 0) goto L38;
        return;
    L38:
        if (r21 >= r17) goto L45;
        this.a.C(new ProductFlowCardDiscountOrMarketPriceView$updatePrice$4(this, r21, r19, r17));
        return;
    L45:
        return;
    L34:
        this.c.setVisibility(8);
        goto L36
    L11:
        if ((!r12.booleanValue()) != true) goto L19;
        j r6 = this.g;
        if (r6 == null) goto L19;
        PromotionDiscountPrice r7 = r6.q;
        if (r7 == null) goto L19;
        int r8 = y.a;
        if (y.u(Long.valueOf(r17), r7, Long.valueOf(r21)) != true) goto L19;
        r2 = true;
        goto L20
    L41:
        setVisibility(8);
        return;
    L5:
        r12 = null;
        goto L7
    }
}
