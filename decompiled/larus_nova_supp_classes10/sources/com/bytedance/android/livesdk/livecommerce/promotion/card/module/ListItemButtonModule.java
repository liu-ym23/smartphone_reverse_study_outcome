package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPingGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.StepperActionType;
import com.bytedance.android.ec.model.response.v;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.n;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.o;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.common.util.UriUtil;
import hl.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemButtonModule;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECRoundedLinearLayout;", "", "newStyle", "", "setBuyButtonForSimilarStyle", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "setArgument", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemButtonModule extends ECRoundedLinearLayout {
    public static final /* synthetic */ int l = 0;
    public i b;
    public LivePromotionCardArgs c;
    public final ImageView d;
    public final TextView e;
    public final View f;
    public final ECDraweeView g;
    public final TextView h;
    public final ECDraweeView i;
    public boolean j;
    public final int k;

    public static final class a implements View.OnLongClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return true;
        }
    }

    public static final class b implements View.OnLongClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return true;
        }
    }

    public static final class c {
    }

    static {
    }

    public ListItemButtonModule(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemButtonModule(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean e() {
        i r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ECUIPromotion r1 = r0.a.a;
        if (r1.getCanAddShopCart() == true) goto L8;
    L12:
        return false;
    L8:
        if (r1.isOnSale() == false) goto L12;
        if (TextUtils.isEmpty(r1.flashIcon) == false) goto L12;
        return true;
    }

    private final void setBuyButtonForSimilarStyle(boolean r4) {
        if (r4 == false) goto L4;
        this.e.setTextColor(th.a.a(getContext(), 2131106181));
        this.e.setBackgroundColor(th.a.a(getContext(), 2131106159));
    L5:
        LivePromotionCardArgs r5 = this.c;
        if (r5 == null) goto L12;
        ILivePromotionCardContainerHandler r6 = r5.b;
        if (r6 == null) goto L12;
        Drawable r7 = (Drawable) r6.n(ILivePromotionCardContainerHandler.Scene.SimilarBtnBgEnabled, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r7 == null) goto L12;
        this.e.setBackground(r7);
    L12:
        LivePromotionCardArgs r8 = this.c;
        if (r8 == null) goto L20;
        ILivePromotionCardContainerHandler r9 = r8.b;
        if (r9 == null) goto L21;
        Integer r10 = (Integer) r9.n(ILivePromotionCardContainerHandler.Scene.SimilarBtnTextColorEnabled, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r10 == null) goto L22;
        int r11 = r10.intValue();
        this.e.setTextColor(r11);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L4:
        this.e.setTextColor(th.a.a(getContext(), 2131105908));
        this.e.setBackgroundColor(th.a.a(getContext(), 2131101679));
        goto L5
    }

    public final void b(i r9) {
        Intrinsics.checkNotNullParameter(r9, "promotionCardItem");
        this.b = r9;
        ECUIPromotion r1 = r9.a.a;
        IPromotionUIConfig.d r2 = r9.c.a(PromotionCardModuleName.AddCartModule);
        if (r2 == null) goto L5;
        int r3 = UIConfigHelper.a;
        UIConfigHelper.d(this.d, r2);
    L5:
        IPromotionUIConfig.d r4 = r9.c.a(PromotionCardModuleName.BuyModule);
        if (r4 == null) goto L8;
        int r5 = UIConfigHelper.a;
        UIConfigHelper.d(this.e, r4);
    L8:
        IPromotionUIConfig.d r6 = r9.c.a(PromotionCardModuleName.ButtonAreaModule);
        if (r6 == null) goto L11;
        UIConfigHelper.d(this, r6);
    L11:
        boolean r7 = true;
        Map r8 = null;
        String r10 = null;
        String r11 = null;
        r11 = null;
        String r12 = null;
        String r13 = null;
        if (r1.shouldShowStepper() == false) goto L78;
        h(r1);
        i r14 = this.b;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L16:
        ECUIPromotion r15 = r14.a.a;
        LivePromotionCardArgs r0 = this.c;
        if (r0 == null) goto L23;
        ILivePromotionCardContainerHandler r16 = r0.b;
        if (r16 == null) goto L23;
        Integer r17 = (Integer) r16.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperTextColor, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r17 == null) goto L23;
        this.h.setTextColor(r17.intValue());
    L23:
        LivePromotionCardArgs r18 = this.c;
        if (r18 == null) goto L31;
        ILivePromotionCardContainerHandler r19 = r18.b;
        if (r19 == null) goto L31;
        Integer r20 = (Integer) r19.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperTextSize, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r20 == null) goto L31;
        this.h.setTextSize(r20.intValue());
    L31:
        if (this.e.getVisibility() == 0) goto L34;
        r7 = false;
    L34:
        if (r7 == true) goto L36;
        return;
    L36:
        if (r15.shouldShowFindSimilarWithOtherStore() == false) goto L45;
        LivePromotionCardArgs r21 = this.c;
        if (r21 == null) goto L63;
        ILivePromotionCardContainerHandler r22 = r21.b;
        if (r22 == null) goto L63;
        Drawable r23 = (Drawable) r22.n(ILivePromotionCardContainerHandler.Scene.SimilarBtnBgEnabled, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r23 == null) goto L63;
        this.e.setBackground(r23);
    L63:
        if (r15.shouldShowFindSimilarWithOtherStore() == false) goto L71;
        LivePromotionCardArgs r24 = this.c;
        if (r24 == null) goto L221;
        ILivePromotionCardContainerHandler r25 = r24.b;
        if (r25 == null) goto L222;
        Integer r26 = (Integer) r25.n(ILivePromotionCardContainerHandler.Scene.SimilarBtnTextColorEnabled, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r26 == null) goto L223;
        this.e.setTextColor(r26.intValue());
        return;
    L223:
        return;
    L222:
        return;
    L221:
        return;
    L71:
        LivePromotionCardArgs r27 = this.c;
        if (r27 == null) goto L225;
        ILivePromotionCardContainerHandler r28 = r27.b;
        if (r28 == null) goto L226;
        Integer r29 = (Integer) r28.n(ILivePromotionCardContainerHandler.Scene.BuyBtnTextColor, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r29 == null) goto L227;
        this.e.setTextColor(r29.intValue());
        return;
    L227:
        return;
    L226:
        return;
    L225:
        return;
    L45:
        if (r15.shouldShowFindSimilar() == true) goto L63;
        if (this.j == false) goto L55;
        LivePromotionCardArgs r30 = this.c;
        if (r30 == null) goto L63;
        ILivePromotionCardContainerHandler r31 = r30.b;
        if (r31 == null) goto L63;
        Drawable r32 = (Drawable) r31.n(ILivePromotionCardContainerHandler.Scene.BuyBtnBgEnabled, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r32 == null) goto L63;
        this.e.setBackground(r32);
        goto L63
    L55:
        LivePromotionCardArgs r33 = this.c;
        if (r33 == null) goto L63;
        ILivePromotionCardContainerHandler r34 = r33.b;
        if (r34 == null) goto L63;
        Drawable r35 = (Drawable) r34.n(ILivePromotionCardContainerHandler.Scene.BuyBtnBgDisabled, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r35 == null) goto L63;
        this.e.setBackground(r35);
        goto L63
    L78:
        this.f.setVisibility(8);
        ECUIPromotion r36 = r9.a.a;
        this.e.setVisibility(0);
        this.e.setTextColor(th.a.a(getContext(), 2131101703));
        if (r36.shouldShowFindSimilar() == false) goto L92;
        ECUIPromotionLiveListConfig r37 = r36.getClientData().g;
        if (r37 == null) goto L83;
        r10 = r37.getSimilarLabel();
    L83:
        f(r36, r10);
        g(true, false);
        ECUIPromotionLiveListConfig r38 = r36.getClientData().g;
        if (r38 == null) goto L86;
        boolean r39 = r38.getSimilarNewDesign();
    L87:
        setBuyButtonForSimilarStyle(r39);
        LivePromotionCardArgs r40 = this.c;
        if (r40 == null) goto L172;
        PromotionListEventActionImpl r41 = r40.h;
        if (r41 == null) goto L172;
        r41.j(r9.a.b);
    L172:
        if (r36.isInvalid() == false) goto L174;
        g(true, true);
    L174:
        this.e.setContentDescription(this.e.getText().toString() + th.a.g(getContext(), 2131896355));
        ECUIPromotion r42 = r9.a.a;
        if (r42.canShowAddCart() == false) goto L218;
        this.d.setVisibility(0);
        if (r42.getCanAddShopCart() == true) goto L179;
    L183:
        r7 = false;
    L184:
        if (r7 == false) goto L186;
        int r43 = 2131234524;
    L187:
        if (r7 == false) goto L195;
        LivePromotionCardArgs r44 = this.c;
        if (r44 == null) goto L202;
        ILivePromotionCardContainerHandler r45 = r44.b;
        if (r45 == null) goto L202;
        Integer r46 = (Integer) r45.n(ILivePromotionCardContainerHandler.Scene.AddCartIconEnabled, Reflection.getOrCreateKotlinClass(Integer.TYPE), getContext());
        if (r46 == null) goto L202;
        r43 = r46.intValue();
    L202:
        this.d.setImageResource(r43);
        this.d.setBackgroundColor(th.a.a(getContext(), 2131106155));
        if (r7 == false) goto L211;
        LivePromotionCardArgs r47 = this.c;
        if (r47 == null) goto L229;
        ILivePromotionCardContainerHandler r48 = r47.b;
        if (r48 == null) goto L230;
        Drawable r49 = (Drawable) r48.n(ILivePromotionCardContainerHandler.Scene.AddCartBtnBgEnabled, Reflection.getOrCreateKotlinClass(Drawable.class), getContext());
        if (r49 == null) goto L231;
        this.d.setBackground(r49);
        return;
    L231:
        return;
    L230:
        return;
    L229:
        return;
    L211:
        LivePromotionCardArgs r50 = this.c;
        if (r50 == null) goto L233;
        ILivePromotionCardContainerHandler r51 = r50.b;
        if (r51 == null) goto L234;
        Drawable r52 = (Drawable) r51.n(ILivePromotionCardContainerHandler.Scene.AddCartBtnBgDisabled, Reflection.getOrCreateKotlinClass(Drawable.class), getContext());
        if (r52 == null) goto L235;
        this.d.setBackground(r52);
        return;
    L235:
        return;
    L234:
        return;
    L233:
        return;
    L195:
        LivePromotionCardArgs r53 = this.c;
        if (r53 == null) goto L202;
        ILivePromotionCardContainerHandler r54 = r53.b;
        if (r54 == null) goto L202;
        Integer r55 = (Integer) r54.n(ILivePromotionCardContainerHandler.Scene.AddCartIconDisabled, Reflection.getOrCreateKotlinClass(Integer.TYPE), getContext());
        if (r55 == null) goto L202;
        r43 = r55.intValue();
        goto L202
    L186:
        r43 = 2131234525;
        goto L187
    L179:
        if (r42.isOnSale() == false) goto L183;
        if (TextUtils.isEmpty(r42.flashIcon) == false) goto L183;
    L218:
        this.d.setVisibility(8);
        return;
    L86:
        r39 = false;
        goto L87
    L92:
        ECUICampaign r56 = r36.getCampaign();
        if (r56 == null) goto L95;
        Boolean r57 = r56.isPreSale();
    L96:
        Boolean r58 = Boolean.TRUE;
        if (Intrinsics.areEqual(r57, r58) == false) goto L105;
        f(r36, th.a.g(getContext(), 2131896679));
        if (r36.isOnSale() == true) goto L101;
    L103:
        boolean r59 = false;
    L104:
        g(r59, false);
        goto L172
    L101:
        if (r36.isCampaignActive() == false) goto L103;
        r59 = true;
        goto L104
    L105:
        ECUICampaign r60 = r36.getCampaign();
        if (r60 == null) goto L108;
        Boolean r61 = r60.isGroup();
    L110:
        if (Intrinsics.areEqual(r61, r58) == false) goto L118;
        ECUICampaign r62 = r36.getCampaign();
        if (r62 == null) goto L116;
        ECUIPingGroup r63 = r62.groupData;
        if (r63 == null) goto L116;
        r11 = r63.getButtonText();
    L116:
        f(r36, r11);
        g(r36.isOnSale(), false);
        goto L172
    L118:
        if (r36.isLottery() == false) goto L131;
        ECUILotteryInfo r64 = r36.getLotteryInfo();
        if (r64 == null) goto L122;
        r12 = r64.getButtonLabel();
    L122:
        f(r36, r12);
        ECUILotteryInfo r65 = r36.getLotteryInfo();
        if (r65 != null) goto L125;
    L128:
        boolean r66 = true;
    L129:
        g(r66, false);
        goto L172
    L125:
        if (r65.isButtonGray() != true) goto L128;
        r66 = false;
        goto L129
    L131:
        if (r36.isAuction() == false) goto L150;
        ECPromotionAuctionInfo r67 = r36.getAuctionInfo();
        if (r67 == null) goto L135;
        r13 = r67.getButtonLabel();
    L135:
        f(r36, r13);
        ECPromotionAuctionInfo r68 = r36.getAuctionInfo();
        if (r68 == null) goto L140;
        Integer r69 = r68.getStatus();
        if (r69 == null) goto L140;
        int r70 = r69.intValue();
    L141:
        if (r70 == 1) goto L145;
        if (r70 == 2) goto L145;
    L147:
        boolean r71 = false;
    L148:
        g(r71, false);
    L145:
        if (r36.getStatus() == 10000) goto L147;
        r71 = true;
    L140:
        r70 = 4;
        goto L141
    L150:
        if (r36.isPreheat() == false) goto L152;
        f(r36, r36.buttonLabel);
        g(false, false);
        goto L172
    L152:
        ECPromotion.ReservationInfo r72 = r36.reservationInfo;
        if (r72 == null) goto L155;
        r8 = r72.buttonLabel;
    L155:
        if (r8 == null) goto L165;
        if (r72.hasReserved != 1) goto L159;
        g(false, false);
        f(r36, (String) r36.reservationInfo.buttonLabel.get("transparent"));
        goto L172
    L159:
        if (r36.getStatus() == 10000) goto L161;
        boolean r73 = true;
    L162:
        g(r73, false);
        f(r36, (String) r36.reservationInfo.buttonLabel.get("normal"));
        goto L172
    L161:
        r73 = false;
        goto L162
    L165:
        if (r36.shouldCheckIfNotOnSale() == false) goto L170;
        g(true, true);
        if (r36.shouldShowFindSimilarWithOtherStore() == false) goto L169;
        setBuyButtonForSimilarStyle(true);
    L169:
        f(r36, r36.buttonLabel);
        goto L172
    L170:
        f(r36, r36.buttonLabel);
        g(r36.isOnSale(), false);
        goto L172
    L108:
        r61 = null;
        goto L110
    L95:
        r57 = null;
        goto L96
    }

    public final void c(StepperActionType r16) {
        i r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ECUIPromotion r2 = r1.a.a;
        if (r2.stepperInfo != null) goto L8;
        UIUtils.displayToast(getContext(), th.a.g(getContext(), 2131896304));
    L8:
        v r3 = r2.stepperInfo;
        if (r3 != null) goto L11;
        return;
    L11:
        int r4 = r3.b();
        if (r4 <= 0) goto L14;
    L16:
        int r5 = r2.getIronIndex();
        LivePromotionCardArgs r6 = this.c;
        String r8 = null;
        if (r6 == null) goto L21;
        g.a r7 = r6.a;
        if (r7 == null) goto L21;
        String r9 = r7.a(ListItemButtonModule$clickStepper$btm$1.INSTANCE, r5);
    L22:
        if (r9 == null) goto L24;
        String r10 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r9, Boolean.FALSE).withView(this.f).build());
    L25:
        StepperActionType r11 = StepperActionType.STEPPER_ADD;
        if (r16 != r11) goto L35;
        LivePromotionCardArgs r12 = this.c;
        if (r12 == null) goto L43;
        PromotionListEventActionImpl r13 = r12.h;
        if (r13 == null) goto L43;
        i r14 = this.b;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L34:
        r13.h(r14.a.b, true, r9, r10);
    L43:
        if (r16 != r11) goto L45;
        String r15 = "live_add_cart_from_cart_pendant";
    L46:
        int r17 = ECSdk.a;
        IECUserTrackerService r18 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r18 == null) goto L51;
        of.a r19 = r18.getMarketingService();
        if (r19 == null) goto L51;
        r19.a(r15, PostActionType.DO, "live");
    L51:
        if (r16 != r11) goto L53;
        String r20 = "cell_add_cart";
    L54:
        xh.c.a("Live").d("good_list", r20, MapsKt.mapOf(new Pair[]{TuplesKt.to("button_enabled", String.valueOf(e())), TuplesKt.to("promotion_id", r2.getPromotionId()), TuplesKt.to("product_id", r2.getProductId())}));
        if (e() == false) goto L75;
        if (r9 != null) goto L58;
    L62:
        com.bytedance.android.btm.api.model.d r21 = BtmUtilsKt.e(r9, PageFinder.via(this.f));
        LivePromotionCardArgs r22 = this.c;
        if (r22 == null) goto L80;
        jf.d r23 = r22.g;
        if (r23 == null) goto L81;
        if (r16 != r11) goto L68;
        int r24 = r4 + 1;
    L69:
        int r25 = r24;
        Context r26 = getContext();
        i r27 = this.b;
        if (r27 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L72:
        r23.q(r26, r27.a.b, r21, new ListItemButtonModule$addCartListener$1(this), this.f, r16, r25);
        return;
    L68:
        r24 = r4 - 1;
        goto L69
    L81:
        return;
    L80:
        return;
    L58:
        if ((!r2.isFromPlayback) == false) goto L60;
        r8 = r9;
    L60:
        if (r8 == null) goto L62;
        new BtmItemBuilder(r9, Boolean.TRUE).withView(this.f);
        goto L62
    L75:
        if (r2.getCanAddShopCart() == true) goto L77;
    L78:
        UIUtils.displayToast(getContext(), th.a.g(getContext(), 2131896304));
        return;
    L77:
        if (TextUtils.isEmpty(r2.flashIcon) == false) goto L78;
        return;
    L53:
        r20 = "cell_sub_cart";
        goto L54
    L45:
        r15 = "live_sub_cart_from_cart_pendant";
        goto L46
    L35:
        LivePromotionCardArgs r110 = this.c;
        if (r110 == null) goto L43;
        PromotionListEventActionImpl r111 = r110.h;
        if (r111 == null) goto L43;
        i r112 = this.b;
        if (r112 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L42:
        com.bytedance.android.ec.common.api.jump.model.g r113 = r112.a.b;
        Intrinsics.checkNotNullParameter(r113, "promotionParams");
        oh.a.c("ECSubShopCartEvent", new n(r111, r113, r9, r10));
        oh.a.c("doClickSubCartForDouPlus", new o(r111, r113));
        goto L43
    L24:
        r10 = "";
    L21:
        r9 = null;
        goto L22
    L14:
        if (r16 != StepperActionType.STEPPER_SUB) goto L16;
    }

    public final void d(View r18) {
        Intrinsics.checkNotNullParameter(r18, "v");
        i r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        final ECUIPromotion r3 = r0.a.a;
        s0.a(new m());
        int r1 = r3.getIronIndex();
        LivePromotionCardArgs r2 = this.c;
        if (r2 == null) goto L11;
        ILivePromotionCardContainerHandler r4 = r2.b;
        if (r4 == null) goto L11;
        r4.j(r3.getProductId());
    L11:
        if (Intrinsics.areEqual(r18, this.g) == false) goto L14;
        c(StepperActionType.STEPPER_SUB);
        return;
    L14:
        if (Intrinsics.areEqual(r18, this.i) == false) goto L16;
        c(StepperActionType.STEPPER_ADD);
        return;
    L16:
        String r11 = "";
        String r16 = null;
        if (Intrinsics.areEqual(r18, this.d) == false) goto L69;
        LivePromotionCardArgs r5 = this.c;
        if (r5 == null) goto L23;
        g.a r6 = r5.a;
        if (r6 == null) goto L23;
        r16 = r6.a(ListItemButtonModule$doClick$btm$1.INSTANCE, r1);
    L23:
        String r7 = r16;
        if (r7 == null) goto L26;
        r11 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r7, Boolean.FALSE).withView(this.d).build());
    L26:
        LivePromotionCardArgs r8 = this.c;
        if (r8 == null) goto L34;
        PromotionListEventActionImpl r9 = r8.h;
        if (r9 == null) goto L34;
        i r10 = this.b;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L33:
        r9.h(r10.a.b, true, r7, r11);
    L34:
        int r12 = ECSdk.a;
        IECUserTrackerService r13 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r13 == null) goto L40;
        of.a r14 = r13.getMarketingService();
        if (r14 == null) goto L40;
        r14.a("live_add_cart_from_cart_pendant", PostActionType.DO, "live");
    L40:
        if (r3.getCanAddShopCart() == true) goto L42;
    L46:
        boolean r15 = false;
    L47:
        xh.c.a("Live").d("good_list", "cell_add_cart", MapsKt.mapOf(new Pair[]{TuplesKt.to("button_enabled", String.valueOf(r15)), TuplesKt.to("promotion_id", r3.getPromotionId()), TuplesKt.to("product_id", r3.getProductId())}));
        if (r15 == false) goto L64;
        com.bytedance.android.btm.api.model.d r17 = BtmUtilsKt.e(r7, PageFinder.via(this.d));
        LivePromotionCardArgs r19 = this.c;
        if (r19 == null) goto L115;
        jf.d r20 = r19.g;
        if (r20 == null) goto L116;
        Context r110 = getContext();
        i r21 = this.b;
        if (r21 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L56:
        com.bytedance.android.ec.common.api.jump.model.g r111 = r21.a.b;
        ListItemButtonModule$addCartListener$1 r112 = new ListItemButtonModule$addCartListener$1(this);
        ImageView r113 = this.d;
        LivePromotionCardArgs r22 = this.c;
        if (r22 == null) goto L61;
        ILivePromotionCardContainerHandler r23 = r22.b;
        if (r23 == null) goto L61;
        r23.m();
    L61:
        r20.j(r110, r111, r17, r112, r113, null);
        return;
    L116:
        return;
    L115:
        return;
    L64:
        if (r3.getCanAddShopCart() == true) goto L66;
    L67:
        UIUtils.displayToast(getContext(), th.a.g(getContext(), 2131896304));
        return;
    L66:
        if (TextUtils.isEmpty(r3.flashIcon) == false) goto L67;
        return;
    L42:
        if (r3.isOnSale() == false) goto L46;
        if (TextUtils.isEmpty(r3.flashIcon) == false) goto L46;
        r15 = true;
        goto L47
    L69:
        if (Intrinsics.areEqual(r18, this.e) == false) goto L122;
        xh.c.a("Live").d("good_list", "cell_action_button", MapsKt.mapOf(new Pair[]{TuplesKt.to("button_enabled", String.valueOf(!this.j)), TuplesKt.to("promotion_id", r3.getPromotionId()), TuplesKt.to("product_id", r3.getProductId())}));
        if (this.j == true) goto L88;
        LivePromotionCardArgs r24 = this.c;
        if (r24 == null) goto L117;
        i r25 = this.b;
        if (r25 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L77:
        com.bytedance.android.ec.common.api.jump.model.e r26 = r25.a;
        LivePromotionCardArgs r27 = this.c;
        if (r27 == null) goto L85;
        g.a r28 = r27.a;
        if (r28 == null) goto L85;
        KProperty1<g.a, String> r29 = ListItemButtonModule$reportClickInvalidProductEvent$1.INSTANCE;
        i r30 = this.b;
        if (r30 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L84:
        String r31 = r28.a(r29, r30.a.a.getIronIndex());
    L86:
        LivePromotionCardArgs.b(r24, r26, "button", r31, null, r18, 16);
        return;
    L85:
        r31 = null;
        goto L86
    L117:
        return;
    L88:
        final String r32 = "button";
        LivePromotionCardArgs r33 = this.c;
        if (r33 == null) goto L93;
        g.a r34 = r33.a;
        if (r34 == null) goto L93;
        final String r35 = r34.a(ListItemButtonModule$doClick$btm$2.INSTANCE, r1);
    L95:
        if (r35 == null) goto L98;
        r11 = r35;
    L98:
        final BtmItemBuilder r36 = new BtmItemBuilder(r11, Boolean.TRUE).withView(this.e);
        final com.bytedance.android.btm.api.model.d r114 = BtmUtilsKt.e(r35, PageFinder.via(this.e));
        LivePromotionCardArgs r37 = this.c;
        if (r37 == null) goto L123;
        jf.d r38 = r37.g;
        if (r38 == null) goto L124;
        i r39 = this.b;
        if (r39 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L105:
        com.bytedance.android.ec.common.api.jump.model.e r115 = r39.a;
        jf.d.a.getClass();
        r37.a(r115, "button", jf.d.a.a("button", r3), r35, r36, this.e);
        Context r40 = getContext();
        i r41 = this.b;
        if (r41 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L108:
        com.bytedance.android.ec.common.api.jump.model.g r116 = r41.a.b;
        Function0<Unit> r117 = new ListItemButtonModule$doClick$$inlined$also$lambda$1(this, r32, r3, r35, r36, r114);
        TextView r118 = this.e;
        LivePromotionCardArgs r42 = this.c;
        if (r42 == null) goto L113;
        ILivePromotionCardContainerHandler r43 = r42.b;
        if (r43 == null) goto L113;
        r43.m();
    L113:
        r38.h(r40, "button", r116, r114, null, r118, r117, null);
        return;
    L124:
        return;
    L123:
        return;
    L93:
        r35 = null;
        goto L95
    }

    public final void h(ECUIPromotion r20) {
        boolean r2 = false;
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        v r1 = r20.stepperInfo;
        if (r1 == null) goto L77;
        LivePromotionCardArgs r4 = this.c;
        if (r4 == null) goto L15;
        ILivePromotionCardContainerHandler r5 = r4.b;
        if (r5 == null) goto L15;
        Boolean r6 = Boolean.valueOf(r5.h(Decision.ADJUST_INSTANT_FUSION));
        if (r6.booleanValue() == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L15;
        r6.booleanValue();
        ViewGroup.LayoutParams r7 = this.i.getLayoutParams();
        r7.width = UtilityKotlinExtentionsKt.d(22);
        r7.height = UtilityKotlinExtentionsKt.d(22);
        ViewGroup.LayoutParams r8 = this.g.getLayoutParams();
        r8.width = UtilityKotlinExtentionsKt.d(22);
        r8.height = UtilityKotlinExtentionsKt.d(22);
    L15:
        if (r1.b() <= 0) goto L26;
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        String r10 = String.valueOf(r1.b());
        int r3 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        float r9 = this.h.getTextSize();
        Intrinsics.checkNotNullParameter(r10, "text");
        Paint r11 = new Paint();
        r11.setTextSize(r9);
        if (r11.measureText(r10) < this.h.getLayoutParams().width) goto L19;
    L22:
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.b(this.k, 8, this.h.getLayoutParams().width, r10, this.h, 0);
    L25:
        this.h.setText(String.valueOf(r1.b()));
    L28:
        if ((!r1.c()) == false) goto L45;
        LivePromotionCardArgs r13 = this.c;
        if (r13 == null) goto L44;
        ILivePromotionCardContainerHandler r14 = r13.b;
        if (r14 == null) goto L44;
        String r15 = (String) r14.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperAddEnabledImageUrl, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r15 == null) goto L44;
        if (r15.length() <= 0) goto L38;
        boolean r16 = true;
    L39:
        if (r16 == false) goto L41;
        String r17 = r15;
    L42:
        if (r17 == null) goto L44;
        h0.e(this.i, r17, null, null, null, 120);
    L61:
        LivePromotionCardArgs r18 = this.c;
        if (r18 == null) goto L75;
        ILivePromotionCardContainerHandler r19 = r18.b;
        if (r19 == null) goto L75;
        String r21 = (String) r19.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperSubImageUrl, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r21 == null) goto L75;
        if (r21.length() <= 0) goto L70;
        r2 = true;
    L70:
        if (r2 == false) goto L72;
        String r22 = r21;
    L73:
        if (r22 == null) goto L75;
        h0.e(this.g, r22, null, null, null, 120);
        return;
    L72:
        r22 = null;
    L75:
        h0.e(this.g, UriUtil.getUriForResourceId(2131234530).toString(), null, null, null, 120);
        return;
    L41:
        r17 = null;
        goto L42
    L38:
        r16 = false;
    L44:
        h0.e(this.i, UriUtil.getUriForResourceId(2131234528).toString(), null, null, null, 120);
        goto L61
    L45:
        LivePromotionCardArgs r23 = this.c;
        if (r23 == null) goto L60;
        ILivePromotionCardContainerHandler r24 = r23.b;
        if (r24 == null) goto L60;
        String r25 = (String) r24.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperAddDisabledImageUrl, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r25 == null) goto L60;
        if (r25.length() <= 0) goto L54;
        boolean r26 = true;
    L55:
        if (r26 == false) goto L57;
        String r27 = r25;
    L58:
        if (r27 == null) goto L60;
        h0.e(this.i, r27, null, null, null, 120);
        goto L61
    L57:
        r27 = null;
        goto L58
    L54:
        r26 = false;
    L60:
        h0.e(this.i, UriUtil.getUriForResourceId(2131234529).toString(), null, null, null, 120);
        goto L61
    L19:
        if (((int) this.h.getTextSize()) != com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.c(this.k)) goto L22;
        r12 = false;
        goto L23
    L26:
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        goto L28
    }

    public final void setArgument(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.c = r2;
    }

    public final void a(String r7, int r8) {
        if (r7.length() <= r8) goto L5;
        this.e.setMaxLines(1);
        int r9 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.b(12, 4, this.e.getLayoutParams().width, r7, this.e, UtilityKotlinExtentionsKt.d(6) * 2);
    L6:
        this.e.setText(r7);
        return;
    L5:
        this.e.setTextSize(12);
        goto L6
    }

    public final void f(ECUIPromotion r4, String r5) {
        if (r5 != null) goto L4;
        String r0 = "";
    L5:
        r4.setCurrentLabel(r0);
        this.e.setText(r5);
        LivePromotionCardArgs r6 = this.c;
        Boolean r1 = null;
        if (r6 == null) goto L17;
        ILivePromotionCardContainerHandler r7 = r6.b;
        if (r7 == null) goto L17;
        Boolean r8 = Boolean.valueOf(r7.h(Decision.SHORTEN_BTN_INSTANT_FUSION));
        if (r8.booleanValue() == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L17;
        r8.booleanValue();
        if (r5 == null) goto L17;
        a(r5, 3);
    L17:
        LivePromotionCardArgs r9 = this.c;
        if (r9 == null) goto L31;
        ILivePromotionCardContainerHandler r10 = r9.b;
        if (r10 == null) goto L32;
        Boolean r11 = (Boolean) r10.n(ILivePromotionCardContainerHandler.Scene.AddCartBtnLargeSize, Reflection.getOrCreateKotlinClass(Boolean.TYPE), null);
        if (r11 != null) goto L24;
        return;
    L24:
        if (r11.booleanValue() == false) goto L26;
        r1 = r11;
    L26:
        if (r1 == null) goto L34;
        r1.booleanValue();
        if (r5 == null) goto L35;
        a(r5, 2);
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L4:
        r0 = r5;
        goto L5
    }

    public final void g(boolean r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 24) goto L10;
        TextView r0 = this.e;
        Context r1 = getContext();
        if (r4 == false) goto L8;
        if (r5 == true) goto L8;
        int r2 = 2131234251;
    L9:
        r0.setBackground(th.a.b(r1, r2));
    L17:
        if (r4 == false) goto L26;
        if (r5 == true) goto L26;
        LivePromotionCardArgs r6 = this.c;
        if (r6 == null) goto L33;
        ILivePromotionCardContainerHandler r7 = r6.b;
        if (r7 == null) goto L33;
        Drawable r8 = (Drawable) r7.n(ILivePromotionCardContainerHandler.Scene.BuyBtnBgEnabled, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r8 == null) goto L33;
        this.e.setBackground(r8);
    L33:
        this.j = r4;
        return;
    L26:
        LivePromotionCardArgs r9 = this.c;
        if (r9 == null) goto L33;
        ILivePromotionCardContainerHandler r10 = r9.b;
        if (r10 == null) goto L33;
        Drawable r11 = (Drawable) r10.n(ILivePromotionCardContainerHandler.Scene.BuyBtnBgDisabled, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r11 == null) goto L33;
        this.e.setBackground(r11);
    L8:
        r2 = 2131234252;
        goto L9
    L10:
        TextView r3 = this.e;
        Context r12 = getContext();
        if (r4 == false) goto L14;
        if (r5 == true) goto L14;
        int r13 = 2131106067;
    L15:
        r3.setBackgroundColor(th.a.a(r12, r13));
    L14:
        r13 = 2131105965;
        goto L15
    }

    public ListItemButtonModule(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        int r10 = 14;
        this.k = 14;
        th.a.c(r7, 2131564748, this, true);
        setRadius(th.a.f(r7).getDimension(2131168167));
        ImageView r11 = (ImageView) findViewById(2131374918);
        this.d = r11;
        TextView r12 = (TextView) findViewById(2131390705);
        this.e = r12;
        this.f = findViewById(2131365250);
        ECDraweeView r1 = findViewById(2131376639);
        this.g = r1;
        TextView r2 = (TextView) findViewById(2131390286);
        this.h = r2;
        ECDraweeView r3 = findViewById(2131376638);
        this.i = r3;
        Object r4 = com.bytedance.android.shopping.extensions.b.f(Float.valueOf(r2.getTextSize()));
        if ((r4 instanceof Float) == true) goto L5;
        r4 = null;
    L5:
        Float r5 = (Float) r4;
        if (r5 == null) goto L8;
        r10 = (int) r5.floatValue();
    L8:
        this.k = r10;
        f.c(r11, null, null, new AnonymousClass1(this), 3);
        f.c(r12, null, "bind_key_live_promotion_list", new AnonymousClass2(this), 1);
        f.c(r1, null, null, new AnonymousClass3(this), 3);
        f.c(r3, null, null, new AnonymousClass4(this), 3);
        r11.setOnLongClickListener(a.a);
        r12.setOnLongClickListener(b.a);
    }

    public /* synthetic */ ListItemButtonModule(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
