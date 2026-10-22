package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveSkinUtil;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.RoundCornerFrameLayout;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.RoundCornerRelativeLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q extends p {
    public static final /* synthetic */ int j = 0;
    public boolean g;
    public float h;
    public float i;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        public final void onChanged(Object r20) {
            final ECUIPromotion r8 = (ECUIPromotion) r20;
            if (r8 == null) goto L214;
            if (r8.isAuction() == true) goto L214;
            final q r10 = this.a;
            ExplainCardViewModel r0 = r10.e;
            if (r0 == null) goto L9;
            final com.bytedance.android.livesdk.livecommerce.largemode.b r12 = r0.getLargeModeAdapter();
        L10:
            ECNetImageView r13 = r10.w().b(2131375993).f();
            final PriceView r14 = r10.w().b(2131371374).f();
            ((RelativeLayout) r10.w().b(2131365160).f()).setVisibility(0);
            ExplainCardViewModel r1 = r10.e;
            int r4 = 12;
            if (r1 == null) goto L108;
            com.bytedance.android.livesdk.livecommerce.skin.g r2 = r1.getCardSkinHelper();
            if (r2 == null) goto L108;
            Pair r3 = r2.a();
            if (r3 == null) goto L108;
            ECLiveSkinBackgroundElement r5 = (ECLiveSkinBackgroundElement) r3.component1();
            List r6 = (List) r3.component2();
            if (r6 == null) goto L29;
            Integer r7 = (Integer) CollectionsKt.firstOrNull(r6);
            if (r7 == null) goto L29;
            if (r7.intValue() <= 0) goto L23;
            boolean r16 = true;
        L24:
            if (r16 == true) goto L27;
            r7 = null;
        L27:
            if (r7 == null) goto L29;
            float r9 = r7.intValue();
            r10.h = r9;
            r10.i = r9;
            goto L29
        L23:
            r16 = false;
        L29:
            if (r6 == null) goto L41;
            Integer r11 = (Integer) CollectionsKt.firstOrNull(r6);
            if (r11 == null) goto L41;
            if (r11.intValue() <= 0) goto L35;
            boolean r15 = true;
        L36:
            if (r15 == true) goto L39;
            r11 = null;
        L39:
            if (r11 == null) goto L41;
            r4 = r11.intValue();
            goto L41
        L35:
            r15 = false;
        L41:
            ViewExtensionsKt.g(r10.w().b(2131365160).f(), UtilityKotlinExtentionsKt.c(Integer.valueOf(r4)), UtilityKotlinExtentionsKt.c(Integer.valueOf(r4)), UtilityKotlinExtentionsKt.c(Integer.valueOf(r4)), UtilityKotlinExtentionsKt.c(Integer.valueOf(r4)));
            if (r5 == null) goto L63;
            List<String> r17 = r5.getColor();
            if (r17 == null) goto L63;
            if (r17.size() != 1) goto L48;
            boolean r18 = true;
        L49:
            if (r18 == true) goto L52;
            r17 = null;
        L52:
            if (r17 == null) goto L63;
            ExplainCardViewModel r19 = r10.e;
            if (r19 == null) goto L60;
            com.bytedance.android.livesdk.livecommerce.skin.g r21 = r19.getCardSkinHelper();
            if (r21 == null) goto L60;
            Pair r22 = r21.c();
            if (r22 == null) goto L60;
            Drawable r23 = (Drawable) r22.getFirst();
        L61:
            if (r23 == null) goto L63;
            ((RelativeLayout) r10.w().b(2131365160).f()).setBackground(r23);
        L113:
            r13.setVisibility(8);
            r14.C(new BottomPresenter$updateUI$4(r10));
            PriceView.z(r14, 600, 4);
            ECDraweeView r24 = r10.w().b(2131376054).f();
            r24.setBottomRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r10.i)));
            r24.setTopRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r10.i)));
            ECDraweeView r25 = r10.w().b(2131376055).f();
            r25.setBottomRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r10.i)));
            r25.setTopRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r10.i)));
            FrameLayout r26 = (FrameLayout) r10.w().b(2131370506).f();
            LottieAnimationView r27 = (ECLottieAnimationView) r10.w().b(2131376070).f();     // Catch: NullPointerException -> L163
            if (r10.E() == false) goto L118;
        L145:
            ECLiveABUtils r28 = ECLiveABUtils.INSTANCE;     // Catch: NullPointerException -> L163
            if (r28.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L148;
            int r29 = 2131234535;
        L149:
            ExplainCardViewModel r30 = r10.e;     // Catch: NullPointerException -> L163
            if (r30 == null) goto L158;
            com.bytedance.android.livesdk.livecommerce.skin.g r31 = r30.getCardSkinHelper();     // Catch: NullPointerException -> L163
            if (r31 == null) goto L158;
            String r32 = r31.d(true);     // Catch: NullPointerException -> L163
            if (r32 == null) goto L158;
            ECLiveSkinUtil.l.getClass();     // Catch: NullPointerException -> L163
            Integer r33 = ECLiveSkinUtil.b(r32);     // Catch: NullPointerException -> L163
            if (r33 == null) goto L158;
            r29 = r33.intValue();     // Catch: NullPointerException -> L163
        L158:
            ECDraweeView.setPlaceholderImage$default(r24, r29, null, 2, null);     // Catch: NullPointerException -> L163
            ImageExtensionsKt.D(r24, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r24, r8.transparentBottonIcon);     // Catch: NullPointerException -> L163
            if (r28.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L161;
            ((RoundCornerRelativeLayout) r10.w().b(2131365160).f()).setBackground(th.a.b(r10.u().c(), 2131234260));     // Catch: NullPointerException -> L163
        L161:
            r25.setVisibility(8);     // Catch: NullPointerException -> L163
        L166:
            if (r8.isPreSale() == false) goto L174;
            ECUICampaign r34 = r8.campaign;
            if (r34 == null) goto L172;
            ECPreSaleData r35 = r34.preSaleData;
            if (r35 == null) goto L172;
            Long r36 = Long.valueOf(r35.getDepositPrice());
        L177:
            Long r37 = r36;
        L179:
            if (r8.isActivity() == false) goto L181;
            String r38 = r8.campaign.priceHeader;
        L182:
            if (r38 != null) goto L184;
            r38 = "";
        L184:
            final String r39 = r38;
            final Ref.ObjectRef r40 = new Ref.ObjectRef();
            r40.element = null;
            if (r8.isPriceDeduce() == true) goto L189;
            if (ECLiveABUtils.INSTANCE.getECOM_LIVE_CARD_NO_LOGIN().booleanValue() == true) goto L189;
        L193:
            if (r37 == null) goto L195;
            final long r41 = r37.longValue();
            int r110 = 0;
            r14.C(new BottomPresenter$updateUI$$inlined$let$lambda$1(r41, r14, r39, r40, r8));
            r8.setCostPrice(com.bytedance.android.ec.core.widget.price.b.b(r41, false));
        L196:
            boolean r42 = r8.shouldShowFindSimilarWithOtherStore();
            if (r8.isOnSale() == true) goto L200;
            if (r42 == true) goto L200;
            GradientDrawable r43 = new GradientDrawable();
            r43.setColor(th.a.a(r10.u().c(), 2131101707));
            r43.setCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r10.i)));
            Unit r44 = Unit.INSTANCE;
            r26.setForeground(r43);
        L201:
            ECPromotion.ReservationInfo r45 = r8.reservationInfo;
            if (r45 == null) goto L208;
            ((RelativeLayout) r10.w().b(2131365160).f()).setVisibility(8);
            if (r45.hasReserved != 0) goto L206;
            ECLiveImageUtils.i(r13, r8.normalBottonIcon, r110, r110);
        L207:
            r13.setVisibility(r110);
            goto L208
        L206:
            ECLiveImageUtils.i(r13, r8.transparentBottonIcon, r110, r110);
        L208:
            r14.C(new BottomPresenter$largeModeAdaptationForPrice$1(r12));
            ExplainCardViewModel r46 = r10.e;
            if (r46 == null) goto L216;
            QLiveData<bk2.a<Unit>> r47 = r46.getShowCardAction();
            if (r47 == null) goto L217;
            r47.g(new bk2.a(Unit.INSTANCE));
            return;
        L217:
            return;
        L216:
            return;
        L200:
            r26.setForeground(null);
            goto L201
        L195:
            r110 = 0;
        L189:
            if (r8.isActivity() == false) goto L191;
            String r48 = r8.campaign.priceStr;
        L192:
            r40.element = r48;
            goto L193
        L191:
            r48 = r8.minPriceStr;
            goto L192
        L181:
            r38 = r8.priceHeader;
        L172:
            r37 = null;
            goto L179
        L174:
            if (r8.isActivity() == false) goto L176;
            r36 = Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(r8.campaign.price));
            goto L177
        L176:
            r36 = Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(r8.price));
            goto L177
        L148:
            r29 = 2131234536;
            goto L149
        L118:
            if (r27.getVisibility() == 0) goto L120;
        L122:
            r27.setVisibility(8);     // Catch: NullPointerException -> L163
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L125;
            int r49 = 2131234533;
        L126:
            ExplainCardViewModel r50 = r10.e;     // Catch: NullPointerException -> L163
            if (r50 == null) goto L135;
            com.bytedance.android.livesdk.livecommerce.skin.g r51 = r50.getCardSkinHelper();     // Catch: NullPointerException -> L163
            if (r51 == null) goto L135;
            String r52 = r51.d(false);     // Catch: NullPointerException -> L163
            if (r52 == null) goto L135;
            ECLiveSkinUtil.l.getClass();     // Catch: NullPointerException -> L163
            Integer r53 = ECLiveSkinUtil.b(r52);     // Catch: NullPointerException -> L163
            if (r53 == null) goto L135;
            r49 = r53.intValue();     // Catch: NullPointerException -> L163
        L135:
            ECDraweeView.setPlaceholderImage$default(r24, r49, null, 2, null);     // Catch: NullPointerException -> L163
            String r54 = r8.backgroundButtonIcon;     // Catch: NullPointerException -> L163
            if (r54 != null) goto L138;
        L141:
            boolean r55 = true;
        L142:
            if (r55 == false) goto L144;
            ImageExtensionsKt.D(r24, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r24, r8.normalBottonIcon);     // Catch: NullPointerException -> L163
            r25.setVisibility(8);     // Catch: NullPointerException -> L163
            goto L166
        L144:
            ImageExtensionsKt.D(r24, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r24, r8.transparentBottonIcon);     // Catch: NullPointerException -> L163
            r25.setVisibility(0);     // Catch: NullPointerException -> L163
            ImageExtensionsKt.D(r25, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r25, r8.backgroundButtonIcon);     // Catch: NullPointerException -> L163
            goto L166
        L138:
            if (r54.length() == 0) goto L141;
            r55 = false;
            goto L142
        L125:
            r49 = 2131234534;
            goto L126
        L120:
            if (r27.isAnimating() == false) goto L122;
        L163:
            e = move-exception;
            ECExceptionMonitor.e(e);
        L60:
            r23 = null;
            goto L61
        L48:
            r18 = false;
        L63:
            Lazy r56 = LazyKt.lazy(new BottomPresenter$updateUI$2$6$defaultBgDrawable$2(r10));
            ECLiveABUtils r57 = ECLiveABUtils.INSTANCE;
            Integer r58 = r57.getECOM_LIVE_BUTTON_V2_STYLE();
            if (r58 != null) goto L67;
        L85:
            Integer r59 = r57.getECOM_LIVE_BUTTON_V2_STYLE();
            if (r59 != null) goto L89;
        L107:
            ((RelativeLayout) r10.w().b(2131365160).f()).setBackground((Drawable) r56.getValue());
            goto L113
        L89:
            if (r59.intValue() != 2) goto L107;
            ExplainCardViewModel r60 = r10.e;
            if (r60 == null) goto L95;
            com.bytedance.android.livesdk.livecommerce.skin.g r61 = r60.getCardSkinHelper();
            if (r61 == null) goto L95;
            int[] r62 = r61.f();
        L96:
            if (r62 != null) goto L98;
        L106:
            ((RelativeLayout) r10.w().b(2131365160).f()).setBackground((Drawable) r56.getValue());
            Unit r63 = Unit.INSTANCE;
            goto L113
        L98:
            if (r62.length != 2) goto L100;
            boolean r64 = true;
        L101:
            if (r64 == true) goto L104;
            r62 = null;
        L104:
            if (r62 == null) goto L106;
            ((RelativeLayout) r10.w().b(2131365160).f()).setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r62, new float[]{0.0f, 0.4272f}, 118.0f, UtilityKotlinExtentionsKt.c(-5)));
            goto L113
        L100:
            r64 = false;
        L95:
            r62 = null;
            goto L96
        L67:
            if (r58.intValue() != 1) goto L85;
            ExplainCardViewModel r65 = r10.e;
            if (r65 == null) goto L73;
            com.bytedance.android.livesdk.livecommerce.skin.g r66 = r65.getCardSkinHelper();
            if (r66 == null) goto L73;
            int[] r67 = r66.e();
        L74:
            if (r67 != null) goto L76;
        L84:
            ((RelativeLayout) r10.w().b(2131365160).f()).setBackground((Drawable) r56.getValue());
            Unit r68 = Unit.INSTANCE;
            goto L113
        L76:
            if (r67.length != 4) goto L78;
            boolean r69 = true;
        L79:
            if (r69 == true) goto L82;
            r67 = null;
        L82:
            if (r67 == null) goto L84;
            ((RelativeLayout) r10.w().b(2131365160).f()).setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r67, new float[]{0.0f, 0.38f, 0.62f, 1.0f}, 113.0f, 0.0f));
            goto L113
        L78:
            r69 = false;
        L73:
            r67 = null;
        L108:
            RoundCornerRelativeLayout r70 = (RoundCornerRelativeLayout) r10.w().b(2131365160).f();
            if (Build.VERSION.SDK_INT < 24) goto L111;
            r70.setBackground(th.a.b(r10.u().c(), 2131234259));
        L112:
            ViewExtensionsKt.g(r70, UtilityKotlinExtentionsKt.c(12), UtilityKotlinExtentionsKt.c(12), UtilityKotlinExtentionsKt.c(12), UtilityKotlinExtentionsKt.c(12));
            float r71 = 12;
            r10.h = r71;
            r10.i = r71;
            goto L113
        L111:
            r70.setBackgroundColor(th.a.a(r10.u().c(), 2131106067));
            goto L112
        L9:
            r12 = null;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ q a;

        public c(q r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            bk2.a r8 = (bk2.a) r7;
            if (this.a.E() == false) goto L28;
            ExplainCardViewModel r9 = this.a.e;
            if (r9 == null) goto L7;
            r9.setHasShowBtnAnimation(true);
        L7:
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a = false;
            Query r0 = this.a.w().b(2131372696);
            r0.g(0);
            ViewExtensionsKt.g((RoundCornerFrameLayout) r0.f(), UtilityKotlinExtentionsKt.c(Float.valueOf(this.a.h)), UtilityKotlinExtentionsKt.c(Float.valueOf(this.a.h)), UtilityKotlinExtentionsKt.c(Float.valueOf(this.a.h)), UtilityKotlinExtentionsKt.c(Float.valueOf(this.a.h)));
            Query r1 = this.a.w().b(2131376070);
            r1.g(0);
            ECLottieAnimationView r2 = (ECLottieAnimationView) r1.f();
            ExplainCardViewModel r3 = this.a.e;
            if (r3 == null) goto L29;
            QLiveData<ECUIPromotion> r4 = r3.getPromotionState();
            if (r4 == null) goto L30;
            ECUIPromotion r5 = (ECUIPromotion) r4.a();
            if (r5 != null) goto L15;
            return;
        L15:
            if (r5.buttomIconWide != 1) goto L22;
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L19;
            String r6 = "ec_live_card_buy_long_lottie.json";
        L20:
            r2.setAnimation(r6);
        L26:
            r2.playAnimation();
            r2.loop(false);
            return;
        L19:
            r6 = "ec_live_card_buy_long_lottie_old.json";
            goto L20
        L22:
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L24;
            String r10 = "ec_live_card_buy_short_lottie.json";
        L25:
            r2.setAnimation(r10);
            goto L26
        L24:
            r10 = "ec_live_card_buy_short_lottie_old.json";
            goto L25
        L30:
            return;
        L29:
            return;
        }
    }

    static {
    }

    public final boolean E() {
        if (this.g == true) goto L5;
        return false;
    L5:
        ExplainCardViewModel r0 = this.e;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.getNeedShowBtnAnimation() == true) goto L10;
        return false;
    L10:
        if (r0.getHasShowBtnAnimation() == true) goto L20;
        ECUIPromotion r1 = (ECUIPromotion) r0.getPromotionState().a();
        if (r1 == null) goto L14;
        ECPromotion.ReservationInfo r2 = r1.reservationInfo;
    L15:
        if (r2 == null) goto L17;
        return false;
    L17:
        return true;
    L14:
        r2 = null;
        goto L15
    L20:
        return false;
    }

    public q() {
        this.h = 12.0f;
        this.i = 12.0f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L5;
        r1.getStrategyService();
    L5:
        ECLiveDegradeHelper.c.getClass();
        if (ECLiveDegradeHelper.a("shopping_card_bottom_anim_degrade", ECLiveDegradeHelper.b().getEnableShoppingCardBottomAnimDegrade()) != 0) goto L8;
        boolean r2 = true;
    L9:
        this.g = r2;
        ECLiveABUtils r3 = ECLiveABUtils.INSTANCE;
        Integer r4 = r3.getECOM_LIVE_BUTTON_V2_STYLE();
        if (r4 != null) goto L13;
    L14:
        Integer r6 = r3.getECOM_LIVE_BUTTON_V2_STYLE();
        if (r6 != null) goto L18;
    L20:
        ExplainCardViewModel r7 = this.e;
        if (r7 == null) goto L25;
        QLiveData<ECUIPromotion> r8 = r7.getPromotionState();
        if (r8 == null) goto L25;
        r8.b(r5.getLifecycleOwner(), new b(this));
    L25:
        ExplainCardViewModel r9 = this.e;
        if (r9 == null) goto L31;
        QLiveData<bk2.a<Unit>> r10 = r9.getShowAfterAnimAction();
        if (r10 == null) goto L32;
        r10.b(r5.getLifecycleOwner(), new c(this));
        return;
    L32:
        return;
    L31:
        return;
    L18:
        if (r6.intValue() != 2) goto L20;
    L19:
        this.g = false;
        goto L20
    L13:
        if (r4.intValue() == 1) goto L19;
    L8:
        r2 = false;
        goto L9
    }
}
