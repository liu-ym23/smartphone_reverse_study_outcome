package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/WindowNodeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowNodeView extends FrameLayout {
    public static final /* synthetic */ int l = 0;
    public u a;
    public final ECDraweeView b;
    public rd3.a c;
    public final TextView d;
    public final View e;
    public final TextView f;
    public final ViewGroup g;
    public final View h;
    public final ImageWithPrice i;
    public final ImageWithPrice j;
    public final ImageWithPrice k;

    public static final class a {
    }

    static {
    }

    public WindowNodeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WindowNodeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (((((this.d.getMeasuredWidth() + com.bytedance.android.shopping.extensions.b.b(8)) + com.bytedance.android.shopping.extensions.b.b(16)) + com.bytedance.android.shopping.extensions.b.b(40)) + com.bytedance.android.shopping.extensions.b.b(64)) <= this.g.getMeasuredWidth()) goto L10;
        u r5 = this.a;
        if (r5 == null) goto L11;
        String r6 = r5.d();
        if (r6 == null) goto L12;
        this.d.setText(r6.substring(0, Math.min(8, r6.length())));
        this.d.setText(this.d.getText().toString() + "...的橱窗");
        return;
    L12:
        return;
    L11:
        return;
    }

    public WindowNodeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131561048, this, true);
        this.d = (TextView) findViewById(2131393291);
        this.b = findViewById(2131393290);
        LinearLayout r5 = (LinearLayout) findViewById(2131393293);
        this.e = findViewById(2131373127);
        this.f = (TextView) findViewById(2131383901);
        this.g = (ViewGroup) findViewById(2131374305);
        this.h = findViewById(2131393292);
        this.i = (ImageWithPrice) findViewById(2131375092);
        this.j = (ImageWithPrice) findViewById(2131375093);
        this.k = (ImageWithPrice) findViewById(2131375094);
    }

    public /* synthetic */ WindowNodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(rd3.a r16, String r17, String r18, Promotion r19) {
        String r0 = "pic";
        if (Intrinsics.areEqual(r17, "pic") == false) goto L9;
        com.bytedance.android.ec.sdk.helper.p r1 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r3 = getContext();
        if (r19 == null) goto L7;
        String r4 = r19.getLink();
    L8:
        r1.openSchema(r3, r4);
    L14:
        FeedProductEventTracker r6 = FeedProductEventTracker.a;
        if (Intrinsics.areEqual(r17, "pic") == true) goto L18;
        r0 = BuyNowCloseMethod.OTHERS;
    L18:
        FeedProductEventTracker.m(r6, r16, r0, null, null, null, null, null, 124);
        Context r2 = getContext();
        if (r19 == null) goto L25;
        PromotionProductStruct r5 = r19.getPromotionInfo();
        if (r5 == null) goto L25;
        PromotionProductBaseStruct r7 = r5.getBaseInfo();
        if (r7 == null) goto L25;
        String r8 = r7.getProductId();
    L26:
        FeedProductEventTracker.R(r16, r2, null, "product_flow_under", r18, r17, "window", r8);
        return;
    L25:
        r8 = null;
        goto L26
    L7:
        r4 = null;
        goto L8
    L9:
        yd3.p r9 = r16.i();
        if (r9 == null) goto L14;
        String r10 = r9.n();
        if (r10 == null) goto L14;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(getContext(), r10);
        goto L14
    }
}
