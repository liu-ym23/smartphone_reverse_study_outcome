package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceAreaView;", "Landroid/widget/FrameLayout;", "", "style", "", "setStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceAreaView extends FrameLayout {
    public final ViewGroup a;
    public final TextView b;
    public InFlowPriceViewV1 c;
    public InFlowPriceViewV0 d;
    public InFlowPriceViewWithLowPrice e;
    public InFlowPriceViewV2 f;
    public Integer g;

    public static final class a {
    }

    static {
    }

    public InFlowPriceAreaView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowPriceAreaView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setStyle(int r6) {
        this.a.removeAllViews();
        this.g = Integer.valueOf(r6);
        if (r6 != 0) goto L5;
        int r7 = InFlowPriceViewV0.g;
        Context r8 = getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        if (ld3.b.a() == false) goto L25;
        Map r0 = ShoppingAsyncCacheInflater.d;
        InFlowPriceViewV0 r9 = (InFlowPriceViewV0) ShoppingAsyncCacheInflater.a.a(r8).b("ec_inflow_card_price_view_v0", new i());
    L26:
        this.d = r9;
        com.bytedance.android.shopping.extensions.f.b(this.a, r9);
        return;
    L25:
        r9 = new InFlowPriceViewV0(r8, null, 6, 0);
        goto L26
    L5:
        if (r6 != 1) goto L7;
        int r10 = InFlowPriceViewV1.e;
        Context r11 = getContext();
        Intrinsics.checkNotNullParameter(r11, "context");
        if (ld3.b.a() == false) goto L20;
        Map r1 = ShoppingAsyncCacheInflater.d;
        InFlowPriceViewV1 r12 = (InFlowPriceViewV1) ShoppingAsyncCacheInflater.a.a(r11).b("ec_inflow_card_price_view_v1", new j());
    L21:
        this.c = r12;
        com.bytedance.android.shopping.extensions.f.b(this.a, r12);
        return;
    L20:
        r12 = new InFlowPriceViewV1(r11, null, 6, 0);
        goto L21
    L7:
        if (r6 != 2) goto L9;
        int r13 = InFlowPriceViewWithLowPrice.e;
        Context r14 = getContext();
        Intrinsics.checkNotNullParameter(r14, "context");
        InFlowPriceViewWithLowPrice r3 = new InFlowPriceViewWithLowPrice(r14, null, 6, 0);
        com.bytedance.android.shopping.extensions.f.b(this.a, r3);
        Unit r15 = Unit.INSTANCE;
        this.e = r3;
        return;
    L9:
        if (r6 != 3) goto L31;
        int r16 = InFlowPriceViewV2.f;
        Context r17 = getContext();
        Intrinsics.checkNotNullParameter(r17, "context");
        if (ld3.b.a() == false) goto L14;
        Map r2 = ShoppingAsyncCacheInflater.d;
        InFlowPriceViewV2 r18 = (InFlowPriceViewV2) ShoppingAsyncCacheInflater.a.a(r17).b("ec_inflow_full_price_view_v2", new k());
    L15:
        this.f = r18;
        com.bytedance.android.shopping.extensions.f.b(this.a, r18);
        return;
    L14:
        r18 = new InFlowPriceViewV2(r17, null, 6, 0);
        goto L15
    }

    public InFlowPriceAreaView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560729, this, true);
    L6:
        this.a = (ViewGroup) findViewById(2131383015);
        TextView r6 = (TextView) findViewById(2131383164);
        this.b = r6;
        se3.a.c(r6, 2, 13.0f);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560729, this, true);
        goto L6
    }

    public /* synthetic */ InFlowPriceAreaView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
