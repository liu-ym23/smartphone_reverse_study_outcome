package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SellingPointInfoStruct;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/FlowTinyProductViewStyle67;", "Landroid/widget/FrameLayout;", "", "realPrice", "", "setPriceViewSize", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "m", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getLineDv", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "setLineDv", "(Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;)V", "lineDv", "n", "getDiscountMinPriceBg", "setDiscountMinPriceBg", "discountMinPriceBg", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlowTinyProductViewStyle67 extends FrameLayout {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ECDraweeView h;
    public final LinearLayout i;
    public final TextView j;
    public final TextView k;
    public final ConstraintLayout l;
    public ECDraweeView m;
    public ECDraweeView n;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FlowTinyProductViewStyle67 a;
        public final /* synthetic */ PromotionProductStruct b;

        public b(FlowTinyProductViewStyle67 r1, PromotionProductStruct r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            FlowTinyProductViewStyle67 r0 = this.a;
            TextView r1 = r0.b;
            if (r1 == null) goto L45;
            PromotionProductBaseStruct r2 = this.b.getBaseInfo();
            if (r2 == null) goto L7;
            List r3 = r2.getSellingPointInfo();
        L8:
            TextView r4 = this.a.b;
            boolean r5 = false;
            if (r4 == null) goto L11;
            int r6 = r4.getMeasuredWidth();
        L12:
            r0.getClass();
            String r7 = "";
            if (r3 != null) goto L15;
        L43:
            r1.setText(r7);
            return;
        L15:
            if (r3.isEmpty() == true) goto L43;
            SellingPointInfoStruct r8 = (SellingPointInfoStruct) CollectionsKt.getOrNull(r3, 0);
            if (r8 == null) goto L21;
            String r9 = r8.getContent();
            if (r9 == null) goto L21;
        L22:
            SellingPointInfoStruct r10 = (SellingPointInfoStruct) CollectionsKt.getOrNull(r3, 1);
            if (r10 == null) goto L29;
            String r11 = r10.getContent();
            if (r11 == null) goto L29;
            r7 = r11;
        L29:
            if (r7.length() <= 0) goto L31;
            r5 = true;
        L31:
            if (r5 == false) goto L33;
            r7 = r9 + " · " + r7;
        L34:
            TextView r12 = r0.b;
            if (r12 == null) goto L39;
            TextPaint r13 = r12.getPaint();
            if (r13 == null) goto L39;
            float r14 = r13.measureText(r7);
        L41:
            if ((r14 + 12.0f) <= r6) goto L43;
            r7 = r9;
        L39:
            r14 = 0.0f;
            goto L41
        L33:
            r7 = r9;
        L21:
            r9 = "";
            goto L22
        L11:
            r6 = 0;
            goto L12
        L7:
            r3 = null;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public FlowTinyProductViewStyle67(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowTinyProductViewStyle67(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ECDraweeView getDiscountMinPriceBg() {
        return this.n;
    }

    public final ECDraweeView getLineDv() {
        return this.m;
    }

    private final void setPriceViewSize(long r4) {
        if ((r4 / ((long) 100)) < 1000) goto L10;
        TextView r5 = this.c;
        if (r5 == null) goto L7;
        ViewExtensionsKt.h(r5, 10);
    L7:
        TextView r6 = this.e;
        if (r6 == null) goto L17;
        ViewExtensionsKt.h(r6, 14);
        return;
    L17:
        return;
    L10:
        TextView r7 = this.c;
        if (r7 == null) goto L13;
        ViewExtensionsKt.h(r7, 11);
    L13:
        TextView r8 = this.e;
        if (r8 == null) goto L19;
        ViewExtensionsKt.h(r8, 16);
        return;
    }

    public final void a(PromotionProductStruct r13) {
        Intrinsics.checkNotNullParameter(r13, "promotion");
        ECDraweeView r1 = this.h;
        Boolean r0 = null;
        Long r2 = null;
        if (r1 == null) goto L11;
        PromotionProductBaseStruct r3 = r13.getBaseInfo();
        if (r3 == null) goto L9;
        List r4 = r3.getImages();
        if (r4 == null) goto L9;
        ECUrlModel r5 = (ECUrlModel) CollectionsKt.firstOrNull(r4);
    L10:
        h0.d(r1, r5, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_tiny"), null, null, null, null, 120);
    L9:
        r5 = null;
    L11:
        TextView r6 = this.a;
        String r7 = "";
        if (r6 == null) goto L20;
        PromotionProductBaseStruct r8 = r13.getBaseInfo();
        if (r8 == null) goto L18;
        String r9 = r8.getTitle();
        if (r9 == null) goto L18;
    L19:
        r6.setText(r9);
    L18:
        r9 = "";
    L20:
        PromotionProductBaseStruct r10 = r13.getBaseInfo();
        if (r10 == null) goto L23;
        List r11 = r10.getSellingPointInfo();
    L25:
        if (r11 != null) goto L29;
        TextView r12 = this.b;
        if (r12 == null) goto L35;
        r12.setVisibility(4);
    L35:
        PromotionProductPriceStruct r14 = r13.getProductPrice();
        if (r14 == null) goto L38;
        PromotionDiscountPrice r15 = r14.getDiscountPrice();
    L40:
        if (r15 != null) goto L75;
        ConstraintLayout r16 = this.l;
        if (r16 == null) goto L44;
        r16.setVisibility(8);
    L44:
        LinearLayout r17 = this.i;
        if (r17 == null) goto L47;
        r17.setVisibility(0);
    L47:
        PromotionProductPriceStruct r18 = r13.getProductPrice();
        if (r18 == null) goto L50;
        r2 = r18.getMinPrice();
    L50:
        String r19 = com.bytedance.android.shopping.extensions.i.a(r2);
        boolean r20 = true;
        String r21 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r19, new char[]{'.'}, false, 0, 6, null), 0);
        if (r21 != null) goto L53;
        String r110 = "";
    L54:
        String r111 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r19, new char[]{'.'}, false, 0, 6, null), 1);
        if (r111 == null) goto L58;
        r7 = r111;
    L58:
        TextView r112 = this.j;
        if (r112 == null) goto L62;
        r112.setText(r110);
    L62:
        if (r7.length() > 0) goto L65;
        r20 = false;
    L65:
        if (r20 == false) goto L72;
        TextView r113 = this.k;
        if (r113 == null) goto L69;
        r113.setVisibility(0);
    L69:
        TextView r114 = this.k;
        if (r114 == null) goto L127;
        r114.setText(".".concat(r7));
        return;
    L127:
        return;
    L72:
        TextView r115 = this.k;
        if (r115 == null) goto L129;
        r115.setVisibility(8);
        return;
    L129:
        return;
    L53:
        r110 = r21;
        goto L54
    L75:
        ConstraintLayout r22 = this.l;
        if (r22 == null) goto L78;
        r22.setVisibility(0);
    L78:
        LinearLayout r23 = this.i;
        if (r23 == null) goto L81;
        r23.setVisibility(8);
    L81:
        TextView r24 = this.d;
        if (r24 == null) goto L88;
        StringBuilder r25 = new StringBuilder("¥");
        PromotionProductPriceStruct r26 = r13.getProductPrice();
        if (r26 == null) goto L86;
        Long r27 = r26.getMinPrice();
    L87:
        r25.append(com.bytedance.android.shopping.extensions.i.a(r27));
        r24.setText(r25.toString());
        goto L88
    L86:
        r27 = null;
    L88:
        PromotionProductPriceStruct r28 = r13.getProductPrice();
        if (r28 == null) goto L95;
        PromotionDiscountPrice r29 = r28.getDiscountPrice();
        if (r29 == null) goto L95;
        Long r30 = r29.getMinPrice();
        if (r30 == null) goto L95;
        long r31 = r30.longValue();
    L96:
        setPriceViewSize(r31);
        TextView r32 = this.e;
        if (r32 == null) goto L105;
        PromotionProductPriceStruct r33 = r13.getProductPrice();
        if (r33 == null) goto L103;
        PromotionDiscountPrice r34 = r33.getDiscountPrice();
        if (r34 == null) goto L103;
        Long r35 = r34.getMinPrice();
    L104:
        r32.setText(com.bytedance.android.shopping.extensions.i.a(r35));
    L103:
        r35 = null;
    L105:
        PromotionProductExtraStruct r36 = r13.getExtraInfo();
        if (r36 == null) goto L109;
        r0 = r36.getNeedCheck();
    L109:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L113;
        TextView r37 = this.f;
        if (r37 == null) goto L116;
        r37.setVisibility(0);
    L116:
        TextView r38 = this.g;
        if (r38 == null) goto L131;
        PromotionProductPriceStruct r116 = r13.getProductPrice();
        if (r116 == null) goto L125;
        PromotionDiscountPrice r117 = r116.getDiscountPrice();
        if (r117 == null) goto L125;
        String r118 = r117.getHeader();
        if (r118 == null) goto L125;
        r7 = r118;
    L125:
        r38.setText(r7);
        return;
    L131:
        return;
    L113:
        TextView r39 = this.f;
        if (r39 == null) goto L116;
        r39.setVisibility(8);
    L95:
        r31 = 0;
        goto L96
    L38:
        r15 = null;
        goto L40
    L29:
        TextView r40 = this.b;
        if (r40 == null) goto L32;
        r40.setVisibility(0);
    L32:
        TextView r41 = this.b;
        if (r41 == null) goto L35;
        r41.post(new b(this, r13));
        goto L35
    L23:
        r11 = null;
        goto L25
    }

    public final void setDiscountMinPriceBg(ECDraweeView r1) {
        this.n = r1;
    }

    public final void setLineDv(ECDraweeView r1) {
        this.m = r1;
    }

    public FlowTinyProductViewStyle67(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560717, this, true);
        ConstraintLayout r5 = findViewById(2131383176);
        this.h = findViewById(2131383167);
        this.a = (TextView) findViewById(2131383179);
        this.b = (TextView) findViewById(2131385889);
        this.m = findViewById(2131377915);
        this.c = (TextView) findViewById(2131369135);
        this.d = (TextView) findViewById(2131380115);
        this.n = findViewById(2131369134);
        this.e = (TextView) findViewById(2131369133);
        this.f = (TextView) findViewById(2131369137);
        this.g = (TextView) findViewById(2131369136);
        this.i = (LinearLayout) findViewById(2131364440);
        TextView r6 = (TextView) findViewById(2131380116);
        this.j = (TextView) findViewById(2131380118);
        this.k = (TextView) findViewById(2131380117);
        this.l = findViewById(2131364438);
    }

    public /* synthetic */ FlowTinyProductViewStyle67(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
