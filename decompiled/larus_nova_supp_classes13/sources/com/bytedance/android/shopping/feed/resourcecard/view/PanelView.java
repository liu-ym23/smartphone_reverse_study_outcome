package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelView;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "e", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getMainImgDV", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "mainImgDV", "Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "f", "Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "getPanelPriceView", "()Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "panelPriceView", "Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "g", "Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "getCenterPriceLayout", "()Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "centerPriceLayout", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "getCenterPriceView", "()Landroid/widget/TextView;", "centerPriceView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelView extends BasePanelView {
    public static final /* synthetic */ int i = 0;
    public final ECDraweeView e;
    public final PanelPriceView f;
    public final RoundedFrameLayout g;
    public final TextView h;

    public static final class a {
    }

    static {
    }

    public PanelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PanelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final RoundedFrameLayout getCenterPriceLayout() {
        return this.g;
    }

    public final TextView getCenterPriceView() {
        return this.h;
    }

    public final ECDraweeView getMainImgDV() {
        return this.e;
    }

    public final PanelPriceView getPanelPriceView() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.BasePanelView
    public final void a(rd3.a r27, int r28) {
        Intrinsics.checkNotNullParameter(r27, "anchorInflowFeedItem");
        super.a(r27, r28);
        yd3.p r0 = r27.i();
        if (r0 == null) goto L7;
        yd3.m r1 = r0.l();
        if (r1 == null) goto L7;
        Integer r4 = Integer.valueOf(r1.b());
    L8:
        ImageExtensionsKt.D(this.e, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_shop_goods"));
        ECDraweeView r2 = this.e;
        Promotion r5 = getPromotion();
        if (r5 == null) goto L17;
        PromotionProductStruct r6 = r5.getPromotionInfo();
        if (r6 == null) goto L17;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L17;
        List r8 = r7.getImages();
        if (r8 == null) goto L17;
        ECUrlModel r9 = (ECUrlModel) CollectionsKt.firstOrNull(r8);
    L18:
        y.a(r2, r9);
        Promotion r3 = getPromotion();
        if (r3 == null) goto L136;
        PromotionProductStruct r10 = r3.getPromotionInfo();
        if (r10 == null) goto L137;
        PromotionProductPriceStruct r11 = r10.getProductPrice();
        if (r11 == null) goto L139;
        yd3.p r12 = r27.i();
        if (r12 != null) goto L28;
    L29:
        yd3.p r13 = r27.i();
        if (r13 != null) goto L32;
    L33:
        yd3.p r14 = r27.i();
        if (r14 != null) goto L36;
    L38:
        this.g.setVisibility(8);
        this.f.setVisibility(0);
    L39:
        yd3.p r15 = r27.i();
        if (r15 != null) goto L42;
    L48:
        yd3.p r16 = r27.i();
        if (r16 != null) goto L51;
    L63:
        yd3.p r17 = r27.i();
        if (r17 != null) goto L66;
    L67:
        yd3.p r18 = r27.i();
        if (r18 != null) goto L70;
    L71:
        yd3.p r19 = r27.i();
        if (r19 != null) goto L74;
    L114:
        Integer r110 = r4;
        PanelPriceView.a(this.f, r11.getPreferentialPrice(), null, null, null, 14);
    L115:
        if (r110 != null) goto L118;
    L119:
        yd3.p r20 = r27.i();
        if (r20 == null) goto L124;
        yd3.m r21 = r20.l();
        if (r21 == null) goto L124;
        Integer r22 = r21.f();
    L125:
        if (r22 != null) goto L128;
    L131:
        this.f.getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(20);
        this.f.setBackgroundResource(2131233428);
        return;
    L128:
        if (r22.intValue() != 0) goto L131;
        if (r28 != 0) goto L131;
    L132:
        this.f.getLayoutParams().height = com.bytedance.android.shopping.extensions.b.b(24);
        this.f.setBackgroundResource(2131233429);
        this.f.setPadding(com.bytedance.android.shopping.extensions.b.b(6), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(6), com.bytedance.android.shopping.extensions.b.b(2));
        return;
    L124:
        r22 = null;
        goto L125
    L118:
        if (r110.intValue() == 4) goto L132;
    L74:
        if (r19.getType() != 12) goto L114;
    L75:
        TextView r23 = this.h;
        long r24 = r11.getPreferentialPrice();
        PromotionDiscountPrice r111 = r11.getDiscountPrice();
        if (r111 == null) goto L79;
        String r112 = r111.getHeader();
        if (r112 == null) goto L79;
    L80:
        String r25 = "";
        if (r112 != null) goto L83;
        r112 = "";
    L83:
        long r113 = 100;
        String r114 = String.valueOf(r24 / r113);
        long r26 = r24 % r113;
        if (r26 != 0) goto L87;
    L89:
        r110 = r4;
    L94:
        SpannableString r29 = new SpannableString(r112 + "¥" + r114 + r25);
        if (r112.length() <= 0) goto L97;
        boolean r30 = true;
    L99:
        if (r30 == false) goto L101;
        r29.setSpan(new AbsoluteSizeSpan(11, true), 0, r112.length() + 0, 33);
    L101:
        int r31 = r112.length() + 1;
        r29.setSpan(new AbsoluteSizeSpan(15, true), r31, r114.length() + r31, 33);
        r23.setText(r29);
        yd3.p r32 = r27.i();
        if (r32 == null) goto L109;
        yd3.m r33 = r32.l();
        if (r33 == null) goto L109;
        yd3.c r34 = r33.e();
        if (r34 == null) goto L109;
        String r35 = r34.b();
        if (r35 == null) goto L109;
    L134:
        this.g.setBackgroundColor(Color.parseColor(r35));     // Catch: Exception -> L112
    L112:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L109:
        r35 = "#57000000";
        goto L134
    L97:
        r30 = false;
        goto L99
    L87:
        if (r26 >= 10) goto L90;
        r25 = ".0" + r26;
        goto L89
    L90:
        r110 = r4;
        long r36 = 10;
        if ((r26 % r36) != 0) goto L93;
        r25 = "." + (r26 / r36);
        goto L94
    L93:
        r25 = "." + r26;
    L79:
        r112 = r11.getHeader();
        goto L80
    L70:
        if (r18.getType() == 9) goto L75;
    L66:
        if (r17.getType() == 7) goto L75;
    L51:
        if (r16.getType() != 6) goto L63;
        if (r4 != null) goto L55;
    L57:
        if (r28 == 0) goto L59;
    L61:
        PanelPriceView.a(this.f, r11.getPreferentialPrice(), r11.getRegularPrice(), null, null, 12);
    L62:
        r110 = r4;
        goto L115
    L59:
        if (r11.getHeaderIcon() == null) goto L61;
        PanelPriceView.a(this.f, r11.getPreferentialPrice(), r11.getRegularPrice(), r11.getHeaderIcon(), null, 8);
        goto L62
    L55:
        if (r4.intValue() != 4) goto L57;
        PanelPriceView.a(this.f, r11.getPreferentialPrice(), null, null, r11.getHeader(), 6);
        goto L62
    L42:
        if (r15.getType() != 3) goto L48;
        if (r28 == 0) goto L45;
    L47:
        PanelPriceView.a(this.f, r11.getPreferentialPrice(), r11.getRegularPrice(), null, null, 12);
        goto L62
    L45:
        if (r11.getHeaderIcon() == null) goto L47;
        PanelPriceView.a(this.f, r11.getPreferentialPrice(), null, r11.getHeaderIcon(), null, 10);
        goto L62
    L36:
        if (r14.getType() != 12) goto L38;
    L37:
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        goto L39
    L32:
        if (r13.getType() == 9) goto L37;
    L28:
        if (r12.getType() == 7) goto L37;
    L139:
        return;
    L137:
        return;
    L136:
        return;
    L17:
        r9 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r1);
    }

    public PanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560794, this, true);
        this.e = findViewById(2131379444);
        this.f = (PanelPriceView) findViewById(2131381885);
        this.g = findViewById(2131372820);
        this.h = (TextView) findViewById(2131391150);
    }

    public /* synthetic */ PanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
