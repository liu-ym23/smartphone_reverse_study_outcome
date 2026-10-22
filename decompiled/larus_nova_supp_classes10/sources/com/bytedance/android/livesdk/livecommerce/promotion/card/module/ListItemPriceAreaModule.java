package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECPriceDescription;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemPriceAreaModule;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "", "setArgument", "", "getReadableText", "Lq83/a;", "k", "Lkotlin/Lazy;", "getLotteryTickListener", "()Lq83/a;", "lotteryTickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemPriceAreaModule extends ECLargePriceAutoLocateLayout {
    public static final /* synthetic */ int l = 0;
    public ECUIPromotion d;
    public LivePromotionCardArgs e;
    public final PriceView f;
    public final TextView g;
    public final PriceView h;
    public final PriceView i;
    public int j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    public ListItemPriceAreaModule(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemPriceAreaModule(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final q83.a getLotteryTickListener() {
        return (q83.a) this.k.getValue();
    }

    public final void c() {
        if (this.j != 2) goto L11;
        LivePromotionCardArgs r0 = this.e;
        if (r0 == null) goto L9;
        ILivePromotionCardContainerHandler r1 = r0.b;
        if (r1 == null) goto L9;
        r1.a();
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getLotteryTickListener());
        return;
    }

    public final String getReadableText() {
        boolean r1 = true;
        if (this.f.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = "";
        if (r0 == false) goto L10;
        r3 = "" + this.f.A();
    L10:
        if (this.h.getVisibility() != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        r3 = (r3 + th.a.g(getContext(), 2131913940)) + this.h.A();
    L16:
        if (this.i.getVisibility() == 0) goto L19;
        r1 = false;
    L19:
        if (r1 == true) goto L21;
        return r3;
    L21:
        return r3 + this.i.A();
    L12:
        r2 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void b(final i r17) {
        Intrinsics.checkNotNullParameter(r17, "promotionCardItem");
        ECUIPromotion r9 = r17.a.a;
        ECUIPromotion r1 = this.d;
        if (r1 != null) goto L5;
    L6:
        c();
        this.d = r9;
    L7:
        this.f.C(new ListItemPriceAreaModule$initSkinStyle$1(r17));
        this.h.C(new ListItemPriceAreaModule$initSkinStyle$2(r17));
        IPromotionUIConfig.d r0 = r17.c.a(PromotionCardModuleName.DescPriceAreaModule);
        if (r0 == null) goto L10;
        int r2 = UIConfigHelper.a;
        UIConfigHelper.d(this.g, r0);
    L10:
        String r3 = null;
        r9.setRealPrice(null);
        r9.setCostPrice(null);
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.HIDE_MODE);
        if (r9.isPreSale() == false) goto L23;
        ECUICampaign r4 = r9.getCampaign();
        if (r4 == null) goto L23;
        if (r4.inCampaignTime() != true) goto L23;
        ECUICampaign r5 = r9.getCampaign();
        if (r5 == null) goto L70;
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.DEFAULT_MODE);
        f(1);
        ECPreSaleData r6 = r5.preSaleData;
        if (r6 == null) goto L21;
        final Long r10 = Long.valueOf(r6.getDepositPrice());
    L22:
        String r7 = r5.price;
        String r8 = r5.maxPrice;
        e(r9.getPriceHeader(), com.bytedance.android.ec.core.widget.price.b.a(r7), Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(r8)), Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(null)), null, null);
        this.i.C(new ListItemPriceAreaModule$bindData$2$1(r10));
        return;
    L21:
        r10 = null;
        goto L22
    L70:
        return;
    L23:
        int r11 = 0;
        if (r9.isAuction() == false) goto L36;
        f(0);
        ECPromotionAuctionInfo r12 = r9.getAuctionInfo();
        if (r12 == null) goto L28;
        r3 = r12.getPriceLabel();
    L28:
        String r13 = r3;
        ECPromotionAuctionInfo r14 = r9.getAuctionInfo();
        if (r14 == null) goto L33;
        Long r15 = r14.getPrice();
        if (r15 == null) goto L33;
        long r16 = r15.longValue();
    L34:
        e(r13, r16, null, null, null, null);
        return;
    L33:
        r16 = 0;
        goto L34
    L36:
        if (r9.isCommonLottery() == false) goto L38;
    L68:
        f(2);
        d(true);
        return;
    L38:
        if (r9.isScarceLotteryFinish() == true) goto L68;
        ECPriceDescription r18 = r9.priceDescription;
        if (r18 == null) goto L43;
        r11 = 3;
    L43:
        if (r18 == null) goto L45;
        r18.getColor();
    L45:
        f(r11);
        ECUICampaign r19 = r9.getCampaign();
        if (r9.isCampaignActive() == false) goto L49;
        if (r19 == null) goto L49;
        String r20 = r19.price;
    L50:
        String r110 = r20;
        if (r9.isCampaignActive() == false) goto L54;
        if (r19 == null) goto L54;
        String r21 = r19.maxPrice;
    L56:
        if (r9.isCampaignActive() == false) goto L59;
        if (r19 == null) goto L59;
        String r22 = r19.marketPrice;
    L60:
        String r111 = r22;
        if (r9.isPriceDeduce() == true) goto L63;
    L67:
        String r23 = r9.getPriceHeader();
        ECPriceDescription r24 = r9.priceDescription;
        long r25 = com.bytedance.android.ec.core.widget.price.b.a(r110);
        long r112 = com.bytedance.android.ec.core.widget.price.b.a(r21);
        long r113 = com.bytedance.android.ec.core.widget.price.b.a(r111);
        e(r23, r25, Long.valueOf(r112), Long.valueOf(r113), r24, r3);
        r9.setRealPrice(r111);
        r9.setCostPrice(r110);
        return;
    L63:
        if (r9.isCampaignActive() == false) goto L66;
        if (r19 == null) goto L66;
        r3 = r19.priceStr;
    L66:
        r3 = r9.minPriceStr;
    L59:
        r22 = r9.getMarketPrice();
    L54:
        r21 = r9.getMaxPrice();
    L49:
        r20 = r9.price;
        goto L50
    L5:
        if ((!Intrinsics.areEqual(r1, r9)) == false) goto L7;
        goto L6
    }

    public final void d(boolean r7) {
        ECUIPromotion r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUILotteryInfo r1 = r0.getLotteryInfo();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a;
        String r3 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a(r1.getCountDownTime());
        if (r1.isLotteryFinish() == false) goto L17;
        String r4 = r1.getResultLabel();
        LivePromotionCardArgs r5 = this.e;
        if (r5 == null) goto L15;
        ILivePromotionCardContainerHandler r6 = r5.b;
        if (r6 == null) goto L15;
        r6.a();
    L15:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getLotteryTickListener());
    L23:
        this.f.C(ListItemPriceAreaModule$updateLotteryStatus$1.INSTANCE);
        this.f.setText(r4);
        if (r7 == false) goto L45;
        ECUIPromotion r8 = this.d;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L28:
        ECUILotteryInfo r9 = r8.getLotteryInfo();
        if (r9 != null) goto L31;
    L38:
        LivePromotionCardArgs r10 = this.e;
        if (r10 == null) goto L43;
        ILivePromotionCardContainerHandler r11 = r10.b;
        if (r11 == null) goto L43;
        r11.a();
    L43:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getLotteryTickListener());
        return;
    L31:
        if (r9.needCountDown() != true) goto L38;
        LivePromotionCardArgs r12 = this.e;
        if (r12 == null) goto L37;
        ILivePromotionCardContainerHandler r13 = r12.b;
        if (r13 == null) goto L37;
        r13.a();
    L37:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(getLotteryTickListener());
        return;
    L45:
        return;
    L17:
        if (r3.length() <= 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
        r4 = th.a.h(getContext(), 2131896642, new Object[]{r3});
        goto L23
    L22:
        r4 = null;
        goto L23
    L19:
        r14 = false;
        goto L20
    }

    public final void f(int r6) {
        if (this.j != r6) goto L5;
        return;
    L5:
        this.j = r6;
        boolean r0 = true;
        if (r6 == 0) goto L13;
        if (r6 != 1) goto L9;
        this.f.C(ListItemPriceAreaModule$updateStyle$4.INSTANCE);
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        this.f.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(55.0f)));
    L21:
        if (this.j == 1) goto L25;
        r0 = false;
    L25:
        if (r0 == false) goto L31;
        this.f.getLayoutParams().width = 0;
        ViewGroup.LayoutParams r1 = this.f.getLayoutParams();
        if (r1 == null) goto L30;
        ((LinearLayout.LayoutParams) r1).weight = 1.0f;
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L31:
        this.f.getLayoutParams().width = -2;
        ViewGroup.LayoutParams r2 = this.f.getLayoutParams();
        if (r2 == null) goto L36;
        ((LinearLayout.LayoutParams) r2).weight = 0.0f;
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L19:
        this.f.setMaxWidth(Integer.MAX_VALUE);
        goto L21
    L9:
        if (r6 != 2) goto L16;
        this.f.C(ListItemPriceAreaModule$updateStyle$5.INSTANCE);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
    L16:
        r7 = false;
        goto L17
    L13:
        this.i.setVisibility(8);
        this.f.C(ListItemPriceAreaModule$updateStyle$1.INSTANCE);
        this.h.C(new ListItemPriceAreaModule$updateStyle$2(this));
        this.h.setBackgroundColor(0);
        this.h.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r8 = this.h.getLayoutParams();
        if (r8 == null) goto L38;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r9.setMargins(r9.leftMargin, r9.topMargin, r9.rightMargin, 0);
        goto L16
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setArgument(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.e = r2;
        this.f.C(ListItemPriceAreaModule$initOptStyle$1.INSTANCE);     // Catch: Exception -> L5
        this.i.C(ListItemPriceAreaModule$initOptStyle$2.INSTANCE);     // Catch: Exception -> L5
    L8:
        if (isBaselineAligned() == false) goto L13;
        setBaselineAligned(false);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.j != 1) goto L15;
        float r6 = this.f.getTextSize();
        if (r6 < q.b(Float.valueOf(12.0f))) goto L7;
        int r7 = (int) ((r6 - q.b(Float.valueOf(12.0f))) * 0.6f);
    L8:
        ViewGroup.LayoutParams r8 = this.i.getLayoutParams();
        if (r8 == null) goto L14;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9.bottomMargin == r7) goto L16;
        r9.setMargins(r9.leftMargin, r9.topMargin, r9.rightMargin, r7);
        return;
    L16:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L7:
        r7 = 0;
        goto L8
    }

    public ListItemPriceAreaModule(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = LazyKt.lazy(new ListItemPriceAreaModule$lotteryTickListener$2(this));
        th.a.c(r2, 2131564754, this, true);
        this.f = findViewById(2131383478);
        this.g = (TextView) findViewById(2131390486);
        this.h = findViewById(2131383481);
        PriceView r5 = findViewById(2131383476);
        this.i = r5;
        r5.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(46.0f)));
    }

    public /* synthetic */ ListItemPriceAreaModule(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void e(final String r13, final long r14, final Long r16, final Long r17, final ECPriceDescription r18, final String r19) {
        this.f.C(new ListItemPriceAreaModule$updatePriceViews$1(this, r13, r18, r14, r16, r19));
        if (r18 == null) goto L5;
        this.h.setVisibility(0);
        this.h.setText(r18.getName());
    L11:
        if (this.g.getVisibility() != 8) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L28;
        ECUIPromotion r3 = this.d;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L19:
        if (r3.stockNum > 0) goto L21;
        return;
    L21:
        if (isBaselineAligned() == false) goto L23;
        setBaselineAligned(false);
    L23:
        this.g.setVisibility(0);
        TextView r0 = this.g;
        Context r1 = getContext();
        Object[] r4 = new Object[1];
        ECUIPromotion r5 = this.d;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L26:
        r4[0] = Long.valueOf(r5.stockNum);
        r0.setText(th.a.h(r1, 2131896838, r4));
        return;
    L28:
        return;
    L13:
        r2 = false;
        goto L14
    L5:
        if (r17 != null) goto L7;
    L9:
        this.h.setVisibility(8);
        goto L11
    L7:
        if (r17.longValue() <= 0) goto L9;
        this.h.setVisibility(0);
        this.h.C(new ListItemPriceAreaModule$updatePriceViews$2(r17));
        goto L11
    }
}
