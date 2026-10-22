package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionGroupBuyPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.bytedance.android.shopping.utils.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0003¢\u0006\u0004\b+\u0010,J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010%\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001c¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/TinyCardPriceView;", "Landroid/widget/LinearLayout;", "", "", "marginLeft", "", "setSalesMarginLeft", "Lcom/bytedance/android/ec/core/widget/PriceView;", "a", "Lcom/bytedance/android/ec/core/widget/PriceView;", "getMinPriceView", "()Lcom/bytedance/android/ec/core/widget/PriceView;", "minPriceView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getSuffixTextView", "()Landroid/widget/TextView;", "suffixTextView", "c", "getSalesTextView", "salesTextView", "", "d", "Z", "getNeedShowSalesTextWhenSuffixGone", "()Z", "setNeedShowSalesTextWhenSuffixGone", "(Z)V", "needShowSalesTextWhenSuffixGone", "e", "getNeedShowSalesAndSuffixText", "setNeedShowSalesAndSuffixText", "needShowSalesAndSuffixText", "f", "getNeedShowSuffixButNoSales", "setNeedShowSuffixButNoSales", "needShowSuffixButNoSales", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TinyCardPriceView extends LinearLayout {
    public final PriceView a;
    public final TextView b;
    public final TextView c;
    public boolean d;
    public boolean e;
    public boolean f;
    public PromotionProductStruct g;
    public final String h;

    public TinyCardPriceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TinyCardPriceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        PromotionProductStruct r0 = this.g;
        Unit r1 = null;
        if (r0 == null) goto L7;
        PromotionProductBaseStruct r2 = r0.getBaseInfo();
        if (r2 == null) goto L7;
        SalesInfoStruct r3 = r2.getSalesInfo();
    L9:
        if (r3 == null) goto L18;
        String r4 = r3.getText();
        if (r4 == null) goto L18;
        if (cg4.a.a(r4) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        this.c.setVisibility(0);
        this.c.setText(r4);
        r1 = Unit.INSTANCE;
    L33:
        if (r1 != null) goto L36;
        this.c.setVisibility(8);
        Unit r5 = Unit.INSTANCE;
        return;
    L36:
        return;
    L18:
        PromotionProductStruct r6 = this.g;
        if (r6 == null) goto L33;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L33;
        Long r8 = r7.getSales();
        if (r8 == null) goto L33;
        if (r8.longValue() <= 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        long r10 = r8.longValue();
        this.c.setVisibility(0);
        this.c.setTextColor(ag4.a.b(2131100049));
        this.c.setText(th.a.h(getContext(), 2131913958, new Object[]{k0.a(r10)}));
        r1 = Unit.INSTANCE;
        goto L33
    L27:
        r9 = false;
    L7:
        r3 = null;
        goto L9
    }

    public final void c() {
        PromotionProductStruct r0 = this.g;
        String r1 = null;
        if (r0 == null) goto L5;
        PromotionProductPriceStruct r2 = r0.getProductPrice();
    L6:
        this.c.setVisibility(8);
        if (r2 == null) goto L11;
        PromotionGroupBuyPrice r3 = r2.getGroupBuyPrice();
        if (r3 == null) goto L11;
        String r4 = r3.getHeader();
    L13:
        if (cg4.a.a(r4) == false) goto L20;
        this.b.setVisibility(0);
        TextView r5 = this.b;
        if (r2 == null) goto L19;
        PromotionGroupBuyPrice r6 = r2.getGroupBuyPrice();
        if (r6 == null) goto L19;
        r1 = r6.getHeader();
    L19:
        r5.setText(r1);
        return;
    L20:
        if (r2 == null) goto L24;
        PromotionDiscountPrice r7 = r2.getDiscountPrice();
        if (r7 == null) goto L24;
        String r8 = r7.getHeader();
    L26:
        if (cg4.a.a(r8) == false) goto L33;
        this.b.setVisibility(0);
        TextView r9 = this.b;
        if (r2 == null) goto L32;
        PromotionDiscountPrice r10 = r2.getDiscountPrice();
        if (r10 == null) goto L32;
        r1 = r10.getHeader();
    L32:
        r9.setText(r1);
        return;
    L33:
        if (r2 == null) goto L35;
        String r11 = r2.getHeader();
    L37:
        if (cg4.a.a(r11) == false) goto L42;
        this.b.setVisibility(0);
        TextView r12 = this.b;
        if (r2 == null) goto L41;
        r1 = r2.getHeader();
    L41:
        r12.setText(r1);
        return;
    L42:
        this.b.setVisibility(8);
        return;
    L35:
        r11 = null;
    L24:
        r8 = null;
    L11:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final PriceView getMinPriceView() {
        return this.a;
    }

    public final boolean getNeedShowSalesAndSuffixText() {
        return this.e;
    }

    public final boolean getNeedShowSalesTextWhenSuffixGone() {
        return this.d;
    }

    public final boolean getNeedShowSuffixButNoSales() {
        return this.f;
    }

    public final TextView getSalesTextView() {
        return this.c;
    }

    public final TextView getSuffixTextView() {
        return this.b;
    }

    public final void a(PromotionProductStruct r7) {
        Intrinsics.checkNotNullParameter(r7, "promotionProductStruct");
        this.g = r7;
        d63.j r0 = d63.k.a(r7);
        ActivityVO r8 = f53.a.c(r7);
        int r1 = y.a;
        String r3 = null;
        boolean r2 = true;
        if (y.u(r0.c, r0.q, null) == false) goto L17;
        Long r9 = r0.q.getMinPrice();
        if (r9 == null) goto L7;
        long r4 = r9.longValue();
    L8:
        this.a.setPriceText(com.bytedance.android.shopping.utils.g.d(r4));
        Long r10 = r0.d;
        if (r10 == null) goto L13;
        if ((!Intrinsics.areEqual(r10, r0.c)) == false) goto L13;
    L14:
        this.a.setExtraText(this.h);
    L39:
        if (this.f == false) goto L42;
        c();
        this.c.setVisibility(8);
    L46:
        if (this.d == true) goto L48;
        return;
    L48:
        if (this.b.getVisibility() == 8) goto L51;
        r2 = false;
    L51:
        if (r2 == true) goto L53;
        return;
    L53:
        if (this.f == true) goto L58;
        b();
        return;
    L58:
        return;
    L42:
        if (this.e == false) goto L44;
        c();
        b();
        goto L46
    L44:
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    L13:
        if (y.v(r0.q) == true) goto L14;
        this.a.setExtraText(null);
        goto L39
    L7:
        r4 = 0;
        goto L8
    L17:
        if (r8.isSubsidizedActivity() == false) goto L30;
        PriceView r11 = this.a;
        PromotionProductStruct r5 = this.g;
        if (r5 == null) goto L29;
        PromotionProductPrivilegesStruct r6 = r5.getPrivilegeInfo();
        if (r6 == null) goto L29;
        PromotionProductActivitiesStruct r12 = r6.getActivities();
        if (r12 == null) goto L29;
        PromotionSubsidizedActivity r13 = r12.getSubsidizedActivity();
        if (r13 == null) goto L29;
        Long r14 = r13.getSellPrice();
        if (r14 == null) goto L29;
        r3 = com.bytedance.android.shopping.utils.g.d(r14.longValue());
    L29:
        r11.setPriceText(r3);
        goto L39
    L30:
        Long r15 = r0.c;
        if (r15 == null) goto L39;
        PriceView r16 = this.a;
        int r17 = com.bytedance.android.shopping.utils.g.a;
        r16.setPriceText(com.bytedance.android.shopping.utils.g.d(r15.longValue()));
        Long r18 = r0.d;
        if (r18 != null) goto L35;
    L37:
        this.a.setExtraText(null);
        goto L39
    L35:
        if ((!Intrinsics.areEqual(r18, r0.c)) == false) goto L37;
        this.a.setExtraText(this.h);
        goto L39
    }

    public final void setNeedShowSalesAndSuffixText(boolean r1) {
        this.e = r1;
    }

    public final void setNeedShowSalesTextWhenSuffixGone(boolean r1) {
        this.d = r1;
    }

    public final void setNeedShowSuffixButNoSales(boolean r1) {
        this.f = r1;
    }

    public final void setSalesMarginLeft(int r5) {
        ViewGroup.LayoutParams r0 = this.c.getLayoutParams();
        if (r0 == null) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.setMargins(r5, r1.topMargin, r1.rightMargin, r1.bottomMargin);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public TinyCardPriceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = g1.a;
        this.h = g1.a.c(r2, 2131895957, new Object[0]);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560664, this, true);
        this.a = findViewById(2131388701);
        this.b = (TextView) findViewById(2131388703);
        this.c = (TextView) findViewById(2131388702);
    }

    public /* synthetic */ TinyCardPriceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
