package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.h2;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InnerFeedPageRightWidget;", "Landroid/widget/FrameLayout;", "", "c", "Lkotlin/Lazy;", "getThreshold", "()I", "threshold", "Lyd3/p;", "e", "Lyd3/p;", "getMallResourceCard", "()Lyd3/p;", "setMallResourceCard", "(Lyd3/p;)V", "mallResourceCard", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFeedPageRightWidget extends FrameLayout {
    public final View a;
    public final View b;
    public final Lazy c;
    public final ImageView d;
    public yd3.p e;
    public ProductFeedViewModel f;

    public interface a {
        void a();
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InnerFeedPageRightWidget a;
        public final /* synthetic */ ProductFeedViewModel b;

        public b(InnerFeedPageRightWidget r1, ProductFeedViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.ec.sdk.helper.p r5 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r0 = this.a.getContext();
            AnchorV3Param r1 = this.b.m907getAnchorV3Param();
            if (r1 == null) goto L9;
            PromotionProductStruct r2 = r1.getCurrentPromotion();
            if (r2 == null) goto L9;
            PromotionProductExtraStruct r3 = r2.getExtraInfo();
            if (r3 == null) goto L9;
            String r6 = r3.getCartUrl();
        L10:
            r5.openSchema(r0, r6);
            Context r7 = this.a.getContext();
            if (r7 == null) goto L14;
            FeedProductEventTracker.k(FeedProductEventTracker.a, r7, null, null, 14);
            return;
        L14:
            return;
        L9:
            r6 = null;
            goto L10
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (z53.b.a(r3.getId(), 800) == true) goto L8;
            a r4 = this.a;
            if (r4 == null) goto L9;
            r4.a();
            return;
        L9:
            return;
        }
    }

    private final int getThreshold() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final yd3.p getMallResourceCard() {
        return this.e;
    }

    public InnerFeedPageRightWidget(Context r2) {
        this(r2, null);
    }

    public final void b(int r5) {
        if (r5 <= getThreshold()) goto L14;
        View r0 = this.a;
        if (r0 != null) goto L7;
    L8:
        int r1 = com.bytedance.android.shopping.feed.utils.l.a;
        Context r2 = getContext();
        int r3 = com.bytedance.android.ec.core.opt.ab.c.a;
        com.bytedance.android.shopping.feed.event.g.c(new h2(), r2, null);
        View r4 = this.a;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
    L11:
        View r6 = this.a;
        if (r6 == null) goto L18;
        float r7 = r5 - getThreshold();
        Resources r8 = Resources.getSystem();
        r6.setAlpha(Math.max(1.0f, r7 / MathKt.roundToInt(TypedValue.applyDimension(1, 30, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())))));
        return;
    L18:
        return;
    L7:
        if (r0.getVisibility() == 0) goto L11;
    L14:
        View r9 = this.a;
        if (r9 == null) goto L20;
        r9.setVisibility(4);
        return;
    }

    public final void setMallResourceCard(yd3.p r1) {
        this.e = r1;
    }

    public InnerFeedPageRightWidget(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = LazyKt.lazy(new InnerFeedPageRightWidget$threshold$2(r2));
        LayoutInflater.from(r2).inflate(2131560644, this);
        this.a = findViewById(2131375274);
        this.b = findViewById(2131375275);
        this.d = (ImageView) findViewById(2131375276);
    }

    public final void a(ProductFeedViewModel r6, a r7) {
        Intrinsics.checkNotNullParameter(r6, "productViewModel");
        this.f = r6;
        InnerFlowPageStyleDTO r0 = r6.getInnerFlowPageStyle();
        Integer r1 = null;
        if (r0 == null) goto L5;
        PageStyle r2 = r0.getPageStyle();
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getHeaderSearchDisplay();
    L9:
        if (r1 != null) goto L12;
    L32:
        View r8 = this.b;
        if (r8 == null) goto L35;
        r8.setVisibility(8);
    L35:
        View r9 = this.a;
        if (r9 == null) goto L38;
        r9.setVisibility(0);
    L38:
        View r10 = this.a;
        if (r10 == null) goto L42;
        r10.setOnClickListener(new c(r7));
        return;
    L42:
        return;
    L12:
        if (r1.intValue() != 3) goto L32;
        Integer r3 = r2.getHeaderCartDisplay();
        if (r3 != null) goto L17;
    L29:
        View r11 = this.b;
        if (r11 == null) goto L35;
        r11.setVisibility(8);
        goto L35
    L17:
        if (r3.intValue() != 1) goto L29;
        Integer r4 = r2.getHeaderMallDisplay();
        if (r4 == null) goto L29;
        if (r4.intValue() != 1) goto L29;
        View r5 = this.b;
        if (r5 == null) goto L26;
        r5.setVisibility(0);
    L26:
        View r12 = this.b;
        if (r12 == null) goto L35;
        r12.setOnClickListener(new b(this, r6));
        goto L35
    L5:
        r2 = null;
        goto L6
    }
}
