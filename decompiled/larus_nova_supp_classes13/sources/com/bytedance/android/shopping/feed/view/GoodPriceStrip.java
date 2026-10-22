package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.inflow.view.MainCardImageBannerHolder;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/GoodPriceStrip;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoodPriceStrip extends FrameLayout {
    public final ECDraweeView a;
    public final TextView b;
    public final PriceView c;

    public interface a {
        void a(yd3.o r1);
    }

    public GoodPriceStrip(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GoodPriceStrip(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(final yd3.o r9, final MainCardImageBannerHolder.b r10) {
        Intrinsics.checkNotNullParameter(r9, "resourceBarData");
        Intrinsics.checkNotNullParameter(r10, "iGoodPriceStrip");
        List<yd3.e> r0 = r9.a();
        if (r0 == null) goto L5;
        yd3.e r1 = (yd3.e) CollectionsKt.firstOrNull(r0);
    L6:
        ECDraweeView r2 = this.a;
        if (r2 == null) goto L14;
        if (r1 == null) goto L12;
        ECUrlModel r3 = r1.d();
        if (r3 == null) goto L12;
        String r4 = r3.getFirstUrl();
    L13:
        h0.e(r2, r4, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_default"), null, null, 120);
    L12:
        r4 = null;
    L14:
        TextView r5 = this.b;
        if (r5 == null) goto L21;
        String r6 = r9.b();
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r5.setText(r6);
    L21:
        PriceView r7 = this.c;
        if (r7 == null) goto L24;
        r7.setVisibility(8);
    L24:
        if (r1 == null) goto L28;
        yd3.n r8 = r1.a();
        if (r8 == null) goto L28;
        Long r11 = r8.a();
    L30:
        if (r11 != null) goto L32;
    L34:
        boolean r12 = false;
    L35:
        if (r12 == true) goto L38;
        r11 = null;
    L38:
        if (r11 == null) goto L42;
        final long r13 = r11.longValue();
        PriceView r14 = this.c;
        if (r14 == null) goto L42;
        r14.setVisibility(0);
        r14.C(new GoodPriceStrip$$special$$inlined$apply$lambda$1(r13));
    L42:
        com.bytedance.android.ec.core.widget.f.c(this, null, null, new GoodPriceStrip$bind$4(r10, r9), 3);
        r10.b(r9);
        return;
    L32:
        if (r11.longValue() <= 0) goto L34;
        r12 = true;
    L28:
        r11 = null;
        goto L30
    L5:
        r1 = null;
        goto L6
    }

    public GoodPriceStrip(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560574, this, true);
        this.a = findViewById(2131373851);
        this.b = (TextView) findViewById(2131373852);
        this.c = findViewById(2131373849);
    }

    public /* synthetic */ GoodPriceStrip(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
