package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECAuctionStatusLayout;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECTagAndSalePointWidget extends LinearLayout implements ij2.a {
    public static final /* synthetic */ int n = 0;
    public LivePromotionCardArgs a;
    public ECLiveImageUtils.ECNetImageInfo b;
    public ECPromotionAuctionInfo c;
    public String d;
    public com.bytedance.android.ec.common.api.jump.model.e e;
    public ECNetImageView f;
    public ECAuctionStatusLayout g;
    public ECSalePointView h;
    public ECSalePointView i;
    public g j;
    public StringBuilder k;
    public final Lazy l;
    public final boolean m;

    public static final class a {
    }

    static {
    }

    public ECTagAndSalePointWidget(Context r3) {
        this(r3, false, 14);
    }

    private final q83.a getLotteryTickListener() {
        return (q83.a) this.l.getValue();
    }

    @Override // ij2.a
    public String getType() {
        return "tag_and_sales_point";
    }

    public final void c() {
        Unit r3 = null;
        if (this.m == false) goto L12;
        ECNetImageView r0 = this.f;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L7:
        r0.setVisibility(8);
        ECAuctionStatusLayout r1 = this.g;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L10:
        r1.setVisibility(8);
    L58:
        ECSalePointView r2 = this.h;
        if (r2 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L61:
        r2.setVisibility(8);
        ECSalePointView r4 = this.i;
        if (r4 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L64:
        r4.setVisibility(8);
        com.bytedance.android.ec.common.api.jump.model.e r5 = this.e;
        if (r5 == null) goto L67;
        ECUIPromotion r6 = r5.a;
    L69:
        if (this.m == false) goto L72;
        if (r6 != null) goto L76;
    L77:
        ECSalePointCarouselData r7 = null;
    L79:
        if (r7 == null) goto L85;
        List r8 = r7.getData();
        if (r8 == null) goto L85;
        if ((!r8.isEmpty()) == false) goto L85;
        List r9 = r8;
    L86:
        if (r7 == null) goto L127;
        if (r9 == null) goto L127;
        g r10 = this.j;
        if (r10 == null) goto L91;
        r10.a();
    L91:
        this.j = null;
        StringBuilder r11 = this.k;
        if (r11 == null) goto L95;
        StringsKt.clear(r11);
    L95:
        if (r7.getCarouselTime() > 0) goto L97;
    L116:
        ECCarouselData r12 = (ECCarouselData) CollectionsKt.first(r9);
        ECSalePointView r13 = this.h;
        if (r13 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L119:
        r13.setVisibility(0);
        ECSalePointView r14 = this.h;
        if (r14 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L122:
        r14.a(r12);
        StringBuilder r15 = this.k;
        if (r15 == null) goto L125;
        StringsKt.append(r15, new String[]{r12.getBefore(), r12.getContent()});
    L125:
        d((ECCarouselData) CollectionsKt.first(r9));
    L126:
        r3 = Unit.INSTANCE;
        goto L127
    L97:
        if (r9.size() == 1) goto L116;
        if (r9.size() <= 1) goto L126;
        long r16 = r7.getCarouselTime();
        g r17 = this.j;
        if (r17 == null) goto L104;
        r17.a();
    L104:
        this.j = null;
        LivePromotionCardArgs r18 = this.a;
        if (r18 == null) goto L109;
        ILivePromotionCardContainerHandler r19 = r18.b;
        if (r19 == null) goto L109;
        boolean r20 = r19.h(Decision.DEGRADE_SALE_POINT_LOOP);
    L110:
        this.j = new g(this, r9, r9, r16, r16, r20);
        ECSalePointView r21 = this.h;
        if (r21 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L113:
        r21.setVisibility(0);
        g r22 = this.j;
        if (r22 == null) goto L126;
        r22.j();
    L109:
        r20 = false;
    L127:
        if (r3 != null) goto L136;
        ECSalePointView r23 = this.h;
        if (r23 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L131:
        r23.setVisibility(0);
        ECSalePointView r24 = this.h;
        if (r24 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L134:
        r24.a(new ECCarouselData(null, 0, this.d, null, null, 27, null));
        Unit r25 = Unit.INSTANCE;
        return;
    L136:
        return;
    L85:
        r9 = null;
    L76:
        r7 = r6.recommendPointData;
        goto L79
    L72:
        if (r6 == null) goto L75;
        r7 = r6.getRealSalePointCarouselData();
        if (r7 != null) goto L79;
    L75:
        if (r6 == null) goto L77;
    L67:
        r6 = null;
        goto L69
    L12:
        if (this.b == null) goto L21;
        ECNetImageView r26 = this.f;
        if (r26 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L16:
        r26.setVisibility(0);
        ECNetImageView r27 = this.f;
        if (r27 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L19:
        ECLiveImageUtils.b(r27, this.b);
        goto L58
    L21:
        if (this.c == null) goto L51;
        ECAuctionStatusLayout r28 = this.g;
        if (r28 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L25:
        r28.setVisibility(0);
        ECAuctionStatusLayout r29 = this.g;
        if (r29 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L28:
        ECPromotionAuctionInfo r30 = this.c;
        Intrinsics.checkNotNull(r30);
        Function0<Unit> r31 = new ECTagAndSalePointWidget$refresh$1(this);
        r29.getClass();
        Intrinsics.checkNotNullParameter(r30, "auctionInfo");
        r29.d = false;
        r29.g = r31;
        r29.c = r30;
        int r32 = wl.a.b;
        r29.h = wl.a.a(r30.getEndTime());
        r29.a(r30);
        ECAuctionStatusLayout r33 = this.g;
        if (r33 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L32:
        if (r33.d(null) == false) goto L42;
        LivePromotionCardArgs r34 = this.a;
        if (r34 == null) goto L38;
        ILivePromotionCardContainerHandler r35 = r34.b;
        if (r35 == null) goto L38;
        r35.a();
    L38:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r36 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        ECAuctionStatusLayout r37 = this.g;
        if (r37 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L41:
        r36.a(r37);
        goto L58
    L42:
        LivePromotionCardArgs r38 = this.a;
        if (r38 == null) goto L47;
        ILivePromotionCardContainerHandler r39 = r38.b;
        if (r39 == null) goto L47;
        r39.a();
    L47:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r40 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        ECAuctionStatusLayout r41 = this.g;
        if (r41 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L50:
        r40.b(r41);
        e();
        goto L58
    L51:
        ECNetImageView r42 = this.f;
        if (r42 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L54:
        r42.setVisibility(8);
        ECAuctionStatusLayout r43 = this.g;
        if (r43 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L57:
        r43.setVisibility(8);
        goto L58
    }

    public final void e() {
        ECPromotionAuctionInfo r0 = this.c;
        if (r0 == null) goto L19;
        ECAuctionStatusLayout r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L8:
        if (r1.e(r0) == false) goto L20;
        c();
        com.bytedance.android.ec.common.api.jump.model.e r2 = this.e;
        if (r2 == null) goto L21;
        ECUIPromotion r3 = r2.a;
        if (r3 == null) goto L22;
        LivePromotionCardArgs r4 = this.a;
        if (r4 == null) goto L23;
        ILivePromotionCardContainerHandler r5 = r4.b;
        if (r5 == null) goto L24;
        r5.f(r3);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.k;
        if (r0 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r0);
    }

    @Override // ij2.a
    public final void release() {
        LivePromotionCardArgs r0 = this.a;
        if (r0 == null) goto L7;
        ILivePromotionCardContainerHandler r1 = r0.b;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r2 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        r2.b(getLotteryTickListener());
        LivePromotionCardArgs r3 = this.a;
        if (r3 == null) goto L12;
        ILivePromotionCardContainerHandler r4 = r3.b;
        if (r4 == null) goto L12;
        r4.a();
    L12:
        ECAuctionStatusLayout r5 = this.g;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("auctionStatusLayout");
    L15:
        r2.b(r5);
        g r6 = this.j;
        if (r6 == null) goto L18;
        r6.a();
    L18:
        this.j = null;
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C0143a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C0143a.a(this);
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        ql.a r0 = r6.a;
        this.k = new StringBuilder();
        this.e = r6;
        ViewGroup.LayoutParams r1 = null;
        if (r0.isAuction() == false) goto L5;
        ql.a r7 = r0;
    L6:
        if (r7 == null) goto L8;
        ECPromotionAuctionInfo r8 = r7.getAuctionInfo();
    L9:
        this.c = r8;
        this.d = null;
        if (this.m == true) goto L14;
        ECSalePointCarouselData r9 = r0.getRealSalePointCarouselData();
        if (r9 == null) goto L14;
    L15:
        if (r9 == null) goto L17;
        ECUrlModel r10 = r9.getLeftIcon();
    L19:
        if (r10 == null) goto L34;
        ECLiveImageUtils.ECNetImageInfo r2 = new ECLiveImageUtils.ECNetImageInfo();
        String r4 = r10.getFirstUrl();
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        r2.url = r4;
        r2.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r10.getWidth()));
        r2.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r10.getHeight()));
        Unit r11 = Unit.INSTANCE;
        this.b = r2;
        ECNetImageView r12 = this.f;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L26:
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == false) goto L30;
        r1 = r13;
    L30:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r1;
        if (r3 == null) goto L40;
        r3.gravity = 16;
    L40:
        f(true);
        c();
        return;
    L34:
        if (r0.isFindGoods() == false) goto L39;
        ECLiveImageUtils.ECNetImageInfo r14 = new ECLiveImageUtils.ECNetImageInfo();
        r14.url = ((ECUIPromotion) r0).findGoodsInfo;
        ECNetImageView r5 = this.f;
        if (r5 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("tagIV");
    L38:
        r14.height = r5.getLayoutParams().height;
        r14.width = -3;
        r14.autoScaleOneSide = true;
        Unit r15 = Unit.INSTANCE;
        this.b = r14;
        goto L40
    L39:
        this.b = null;
        goto L40
    L17:
        r10 = null;
    L14:
        r9 = ((ECUIPromotion) r0).recommendPointData;
        goto L15
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public final void d(ECCarouselData r4) {
        if (r4.getType() != 3) goto L11;
        com.bytedance.android.ec.common.api.jump.model.e r0 = this.e;
        if (r0 == null) goto L21;
        LivePromotionCardArgs r1 = this.a;
        if (r1 == null) goto L22;
        PromotionListEventActionImpl r2 = r1.h;
        if (r2 == null) goto L23;
        r2.f(r4.getEventParam(), r0.b, null);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L11:
        LivePromotionCardArgs r3 = this.a;
        if (r3 == null) goto L25;
        PromotionListEventActionImpl r5 = r3.h;
        if (r5 == null) goto L26;
        Map<String, String> r6 = r4.getEventParam();
        com.bytedance.android.ec.common.api.jump.model.e r7 = this.e;
        if (r7 == null) goto L18;
        com.bytedance.android.ec.common.api.jump.model.g r8 = r7.b;
    L19:
        r5.a(r6, r8, null);
        return;
    L18:
        r8 = null;
        goto L19
    L26:
        return;
    }

    public final void f(boolean r5) {
        com.bytedance.android.ec.common.api.jump.model.e r0 = this.e;
        if (r0 == null) goto L36;
        ECUIPromotion r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isScarceLottery() == true) goto L9;
        return;
    L9:
        String r2 = r1.getLotteryElasticTitleText();
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        this.d = r2;
    L18:
        if (r5 == false) goto L38;
        ECUILotteryInfo r6 = r1.getLotteryInfo();
        if (r6 != null) goto L22;
    L29:
        LivePromotionCardArgs r7 = this.a;
        if (r7 == null) goto L34;
        ILivePromotionCardContainerHandler r8 = r7.b;
        if (r8 == null) goto L34;
        r8.a();
    L34:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getLotteryTickListener());
        return;
    L22:
        if (r6.needCountDown() != true) goto L29;
        LivePromotionCardArgs r9 = this.a;
        if (r9 == null) goto L28;
        ILivePromotionCardContainerHandler r10 = r9.b;
        if (r10 == null) goto L28;
        r10.a();
    L28:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(getLotteryTickListener());
        return;
    L38:
        return;
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
        goto L16
    }

    public final void setArgument(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    public ECTagAndSalePointWidget(Context r8, boolean r9, int r10) {
        if ((r10 & 2) == 0) goto L5;
        r9 = false;
    L5:
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, null, 0);
        this.m = r9;
        ECNetImageView r11 = new ECNetImageView(getContext());
        Float r2 = Float.valueOf(16.0f);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(r2)));
        ViewGroup.LayoutParams r1 = r11.getLayoutParams();
        if (r1 == null) goto L29;
        ((LinearLayout.LayoutParams) r1).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)), 0);
        r11.setVisibility(8);
        Unit r6 = Unit.INSTANCE;
        this.f = r11;
        addView(r11);
        ECAuctionStatusLayout r12 = new ECAuctionStatusLayout(getContext(), null);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(r2)));
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L27;
        ((LinearLayout.LayoutParams) r13).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)), 0);
        r12.setVisibility(8);
        this.g = r12;
        addView(r12);
        this.h = new ECSalePointView(getContext());
        this.i = new ECSalePointView(getContext());
        if (r9 == false) goto L18;
        ECSalePointView r14 = this.h;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L14:
        r14.d = true;
        ECSalePointView r15 = this.i;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L17:
        r15.d = true;
    L18:
        FrameLayout r16 = new FrameLayout(getContext());
        ECSalePointView r0 = this.h;
        if (r0 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L21:
        r16.addView(r0);
        ECSalePointView r17 = this.i;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L24:
        r16.addView(r17);
        addView(r16);
        this.l = LazyKt.lazy(new ECTagAndSalePointWidget$lotteryTickListener$2(this));
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
