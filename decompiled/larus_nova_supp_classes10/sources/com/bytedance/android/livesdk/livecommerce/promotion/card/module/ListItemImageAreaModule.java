package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.opt.ab.o;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.w;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.m;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemImageAreaModule;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "", "setArgument", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemImageAreaModule extends FrameLayout {
    public static final /* synthetic */ int p = 0;
    public LivePromotionCardArgs a;
    public ECUIPromotion b;
    public i c;
    public final ECPromotionImageView d;
    public final ECPromotionTopTagLinearlayout e;
    public final ECDraweeView f;
    public final ECNetImageView g;
    public final ECDraweeView h;
    public final TextView i;
    public final TextView j;
    public final ECHotAtmosphereView k;
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.utils.e l;
    public Runnable m;
    public final boolean n;
    public boolean o;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ListItemImageAreaModule a;
        public final /* synthetic */ i b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.h.setVisibility(8);     // Catch: Throwable -> L4
                b r0 = this.a;     // Catch: Throwable -> L4
                r0.a.f(r0.b, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(ListItemImageAreaModule r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListItemImageAreaModule r0 = this.a;     // Catch: Throwable -> L4
            r0.o = false;     // Catch: Throwable -> L4
            ECDraweeView r1 = r0.h;     // Catch: Throwable -> L4
            UIConfigHelper.a(r1, r1, new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ListItemImageAreaModule a;

        public c(ListItemImageAreaModule r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListItemImageAreaModule r0 = this.a;     // Catch: Throwable -> L4
            r0.o = false;     // Catch: Throwable -> L4
            UIConfigHelper.a(r0.g, r0.e, null);     // Catch: Throwable -> L4
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

    public ListItemImageAreaModule(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemImageAreaModule(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setArgument(final LivePromotionCardArgs r3) {
        Intrinsics.checkNotNullParameter(r3, "argument");
        this.a = r3;
        this.k.setDegradeModeCallback(new ListItemImageAreaModule$updateHotAtmosphereDegradeStatus$1(r3));
    }

    public static final void a(ListItemImageAreaModule r5, boolean r6) {
        r5.getClass();
        if (r6 == false) goto L5;
        String r7 = "cell_ask_explain";
    L6:
        xh.a r0 = xh.c.a("Live");
        Pair[] r1 = new Pair[2];
        ECUIPromotion r2 = r5.b;
        String r3 = "";
        if (r2 == null) goto L10;
        String r4 = r2.getPromotionId();
        if (r4 == null) goto L10;
    L11:
        r1[0] = TuplesKt.to("promotion_id", r4);
        ECUIPromotion r8 = r5.b;
        if (r8 == null) goto L17;
        String r9 = r8.getProductId();
        if (r9 == null) goto L17;
        r3 = r9;
    L17:
        r1[1] = TuplesKt.to("product_id", r3);
        r0.d("good_list", r7, MapsKt.mapOf(r1));
        return;
    L10:
        r4 = "";
        goto L11
    L5:
        r7 = "cell_watch_explain";
        goto L6
    }

    public final void b(final i r11, UpdateType r12) {
        Intrinsics.checkNotNullParameter(r11, "promotionCardItem");
        ECUIPromotion r0 = r11.a.a;
        String r1 = r0.getPromotionId();
        ECUIPromotion r2 = this.b;
        ViewGroup.LayoutParams r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getPromotionId();
    L6:
        boolean r5 = Intrinsics.areEqual(r1, r4);
        if ((!Intrinsics.areEqual(this.b, r0)) == false) goto L11;
        this.e.setVisibility(0);
        this.g.setVisibility(8);
        Runnable r6 = this.m;
        if (r6 == null) goto L11;
        this.o = false;
        Lazy r7 = UIUtils.a;
        UIUtils.c().removeCallbacks(r6);
    L11:
        this.c = r11;
        this.b = r0;
        this.d.setPromotionImageBindConfig(new w(new d(this), null));
        this.d.setForceRadius(10);
        ECPromotionTopTagLinearlayout r8 = this.e;
        r8.a.d(UtilityKotlinExtentionsKt.d(10), 0, 0, UtilityKotlinExtentionsKt.d(10));
        this.d.setCallerContext(new r("ec_live", "goods_info_view"));
        i r9 = this.c;
        if (r9 == null) goto L21;
        k r10 = r9.c;
        if (r10 == null) goto L21;
        IPromotionUIConfig.d r13 = r10.a(PromotionCardModuleName.ImageAreaIndex);
        if (r13 == null) goto L21;
        IPromotionUIConfig.b r14 = r13.a();
        if (r14 == null) goto L21;
        IPromotionUIConfig.b r15 = IPromotionUIConfig.b.a(r14);
        int r16 = UIConfigHelper.a;
        UIConfigHelper.c(this.e, r15);
    L21:
        if (r12 != UpdateType.UPDATE_EXPOSE) goto L24;
        d(r11, false);
        return;
    L24:
        ECPromotionImageView r17 = this.d;
        LivePromotionCardArgs r18 = this.a;
        if (r18 == null) goto L38;
        ILivePromotionCardContainerHandler r19 = r18.b;
        if (r19 == null) goto L38;
        String r20 = (String) r19.n(ILivePromotionCardContainerHandler.Scene.ExplainBarWaveIcon, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r20 == null) goto L38;
        if (r20.length() <= 0) goto L33;
        boolean r21 = true;
    L34:
        if (r21 == true) goto L37;
        r20 = null;
    L37:
        if (r20 == null) goto L38;
    L39:
        r17.setAnimation(r20);
        ECPromotionImageView r110 = this.d;
        int r22 = r0.getStatus();
        boolean r23 = r0.isOnExplain();
        LivePromotionCardArgs r24 = this.a;
        if (r24 == null) goto L44;
        ILivePromotionCardContainerHandler r25 = r24.b;
        if (r25 == null) goto L44;
        boolean r26 = r25.h(Decision.HIDE_EXPLAINING_ANIM);
    L45:
        ECLiveImageUtils.h(r110, r0, r22, r23, r26);
        ECLiveImageUtils.g(this.d, r0.getBorderImageUrl());
        f(r11, r5);
        d(r11, true);
        final ECUIPromotion r111 = r11.a.a;
        IPromotionUIConfig.d r27 = r11.c.a(PromotionCardModuleName.ImageAreaBottomTip);
        if (r27 == null) goto L50;
        Boolean r28 = r27.d();
        if (r28 == null) goto L50;
        boolean r29 = r28.booleanValue();
    L52:
        if (r111.isOnExplain() == true) goto L108;
        if (r29 == false) goto L108;
        int r30 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.a.a;
        Lazy r31 = ECAppInfoService.a;
        if (ECAppInfoService.j() == false) goto L57;
    L58:
        int r32 = o.a;
        Object r33 = Boolean.FALSE;
        boolean r34 = ECServiceManager.a;
        Object r35 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("live_ec_explain_playback_enable", r33);
        if (r35 == null) goto L63;
        r33 = r35;
    L63:
        if (((Boolean) r33).booleanValue() == false) goto L65;
    L68:
        boolean r36 = true;
    L70:
        if (r36 == false) goto L80;
        if (r111.hasCommentaryVideo == false) goto L80;
        LivePromotionCardArgs r37 = this.a;
        if (r37 == null) goto L78;
        il.a r38 = r37.e;
        if (r38 == null) goto L78;
        r38.c("livesdk_explain_replay_entrance_show", r111.getPromotionId(), new ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$1(this, r11));
    L78:
        this.j.setText(th.a.g(getContext(), 2131896704));
        this.j.setAlpha(1.0f);
        this.j.setCompoundDrawablesWithIntrinsicBounds(th.a.b(getContext(), 2131234526), null, null, null);
        this.j.setVisibility(0);
        f.c(this.j, null, "bind_key_live_promotion_list", new ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$2(this, r111, r11), 1);
        this.j.setFocusable(true);
        this.j.setContentDescription(th.a.g(getContext(), 2131896704) + th.a.g(getContext(), 2131896355));
    L109:
        e(r11, false);
        final ECUIPromotion r112 = r11.a.a;
        if (r112.isOnExplain() == true) goto L112;
    L118:
        this.d.getExplaingingLayout().setClickable(false);
        LivePromotionCardArgs r113 = this.a;
        if (r113 == null) goto L126;
        il.a r114 = r113.e;
        if (r114 == null) goto L126;
        String r115 = r112.getPromotionId();
        if (r115 != null) goto L125;
        r115 = "";
    L125:
        r114.e("bottom_explain_status_show", r115);
    L126:
        LivePromotionCardArgs r116 = this.a;
        if (r116 == null) goto L140;
        ILivePromotionCardContainerHandler r117 = r116.b;
        if (r117 != null) goto L131;
        return;
    L131:
        if (r117.h(Decision.ADJUST_INSTANT_FUSION) != true) goto L142;
        ViewGroup.LayoutParams r118 = this.k.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L136;
        r3 = r118;
    L136:
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r3;
        if (r39 == null) goto L143;
        r39.leftMargin = UtilityKotlinExtentionsKt.d(-4);
        this.k.setLayoutParams(r39);
        return;
    L143:
        return;
    L142:
        return;
    L140:
        return;
    L112:
        if (r112.bottomBanner == null) goto L118;
        f.c(this.d.getExplaingingLayout(), null, "bind_key_live_promotion_list", new ListItemImageAreaModule$update3DModelStatus$1(this, r112, r11), 1);
        LivePromotionCardArgs r40 = this.a;
        if (r40 == null) goto L126;
        il.a r41 = r40.e;
        if (r41 == null) goto L126;
        r41.c("bottom_explain_status_show", r112.getPromotionId(), new ListItemImageAreaModule$update3DModelStatus$2(this, r11));
    L80:
        if (r111.isOnSale() == true) goto L82;
    L107:
        this.j.setVisibility(8);
        goto L109
    L82:
        if (r111.getAskExplainInfo() == null) goto L107;
        ECUIAskExplainInfo r42 = r111.getAskExplainInfo();
        if (r42 == null) goto L107;
        if (r42.getCanAskExplain() != true) goto L107;
        LivePromotionCardArgs r43 = this.a;
        if (r43 == null) goto L92;
        il.a r44 = r43.e;
        if (r44 == null) goto L92;
        r44.c("livesdk_explain_apply_entrance_show", r111.getPromotionId(), new ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$3(this, r11));
    L92:
        ECUIAskExplainInfo r45 = r111.getAskExplainInfo();
        if (r45 != null) goto L95;
    L97:
        boolean r46 = false;
    L98:
        ECUIAskExplainInfo r47 = r111.getAskExplainInfo();
        if (r47 == null) goto L101;
        long r48 = r47.getUserCount();
    L102:
        c(r11, r46, r48);
        if (r46 == false) goto L105;
        this.j.setOnClickListener(null);
    L106:
        this.j.setVisibility(0);
        goto L109
    L105:
        f.c(this.j, null, "bind_key_live_promotion_list", new ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$4(this, r11, r111), 1);
        this.j.setFocusable(true);
        this.j.setContentDescription(th.a.g(getContext(), 2131896705) + th.a.g(getContext(), 2131896355));
        goto L106
    L101:
        r48 = 0;
        goto L102
    L95:
        if (r45.isAsked() != true) goto L97;
        r46 = true;
    L65:
        if (com.bytedance.android.ec.core.abtest.d.B() == 1) goto L68;
        r36 = false;
        goto L70
    L57:
        if (ECAppInfoService.k() == false) goto L65;
    L108:
        this.j.setVisibility(8);
    L50:
        r29 = true;
    L44:
        r26 = false;
        goto L45
    L33:
        r21 = false;
    L38:
        r20 = "live_music_wave_icon_normal.json";
        goto L39
    L5:
        r4 = null;
        goto L6
    }

    public final void d(i r22, boolean r23) {
        ECUIPromotion r2 = r22.a.a;
        if (r2.isOnExplain() == true) goto L9;
        ECPromotion.FlickerIcon r3 = r2.flickerIconV2;
        if (r3 == null) goto L9;
        if (r3.icon == null) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L70;
        ECPromotion.FlickerIcon r5 = r2.flickerIconV2;
        if (r5 != null) goto L14;
    L17:
        if (r5 == null) goto L19;
        Long r6 = Long.valueOf(r5.duration);
    L20:
        if (r6 == null) goto L22;
        long r9 = r6.longValue();
    L23:
        if (r23 == true) goto L25;
    L27:
        ECPromotion.FlickerIcon r7 = r2.flickerIconV2;
        if (r7 == null) goto L30;
        boolean r8 = r7.showIndex;
    L32:
        if (r8 == false) goto L38;
        this.h.setVisibility(0);
        ECDraweeView r13 = this.h;
        ECPromotion.FlickerIcon r12 = r2.flickerIconV2;
        if (r12 == null) goto L36;
        ECUrlModel r14 = r12.icon;
    L37:
        int r15 = r.h;
        h0.d(r13, r14, r.a.b("ec_live_promotion_list_flicker_image"), null, null, null, null, 120);
        this.e.setVisibility(0);
        this.g.setVisibility(8);
    L44:
        if (r9 >= 0) goto L46;
        this.o = false;
        if (r2.hasShowHaveSeenLabel == true) goto L74;
        r2.hasShowHaveSeenLabel = true;
        LivePromotionCardArgs r10 = this.a;
        if (r10 == null) goto L75;
        PromotionListEventActionImpl r11 = r10.h;
        if (r11 == null) goto L76;
        r11.k(r22.a.b);
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L46:
        if (this.m != null) goto L51;
        if (r8 == false) goto L49;
        Runnable r16 = new b(this, r22);
    L50:
        this.m = r16;
        goto L51
    L49:
        r16 = new c(this);
    L51:
        Runnable r17 = this.m;
        if (r17 == null) goto L54;
        this.o = true;
        Lazy r18 = UIUtils.a;
        UIUtils.c().postDelayed(r17, r9 * ((long) 1000));
    L54:
        ECPromotion.FlickerIcon r19 = r2.flickerIconV2;
        if (r19 == null) goto L57;
        r19.icon = null;
    L57:
        LivePromotionCardArgs r20 = this.a;
        if (r20 == null) goto L71;
        PromotionListEventActionImpl r21 = r20.h;
        if (r21 == null) goto L72;
        r21.k(r22.a.b);
        return;
    L72:
        return;
    L71:
        return;
    L36:
        r14 = null;
        goto L37
    L38:
        this.h.setVisibility(8);
        ECNetImageView r110 = this.g;
        ECPromotion.FlickerIcon r111 = r2.flickerIconV2;
        if (r111 == null) goto L41;
        ECUrlModel r112 = r111.icon;
    L42:
        ECLiveImageUtils.c(r110, r112, false, null);
        this.e.setVisibility(8);
        this.g.setVisibility(0);
        goto L44
    L41:
        r112 = null;
        goto L42
    L30:
        r8 = false;
        goto L32
    L25:
        if (r9 < 0) goto L27;
        return;
    L22:
        r9 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.a.a();
        goto L23
    L19:
        r6 = null;
        goto L20
    L14:
        if (r5.duration != 0) goto L17;
        r6 = Long.valueOf(com.bytedance.android.livesdk.livecommerce.promotion.card.utils.a.a());
        goto L20
    L70:
        return;
    L9:
        r4 = false;
        goto L10
    }

    public final void e(i r5, boolean r6) {
        ECHotAtmosphere r0 = r5.a.a.getHotAtmosphere();
        if (r0 == null) goto L19;
        String r1 = r0.num;
        if (r1 == null) goto L11;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        if (r3 > 0) goto L19;
    L9:
        r3 = 0;
    L11:
        LiveRoomParams r4 = r5.a.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        int r7 = zg2.a.a;
        if (r4 == null) goto L14;
        String r8 = r4.getRoomId();
    L15:
        if (r4 == null) goto L17;
        String r9 = r4.getRoomUniqueKey();
    L18:
        zg2.a.a(r8, r9, Action.SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR, null);
        goto L19
    L17:
        r9 = null;
        goto L18
    L14:
        r8 = null;
    L19:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.e r10 = this.l;
        if (r10 == null) goto L23;
        r10.a(r5.a, r6);
        return;
    }

    public final void f(i r8, boolean r9) {
        ECUIPromotion r0 = r8.a.a;
        if (a2.d(r0.flashIcon) == null) goto L5;
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setVisibility(0);
        y.d(this.f, r0.flashIcon);
    L32:
        IPromotionUIConfig.d r10 = r8.c.a(PromotionCardModuleName.ImageAreaIndex);
        if (r10 == null) goto L35;
        int r1 = UIConfigHelper.a;
        UIConfigHelper.d(this.i, r10);
    L35:
        IPromotionUIConfig.d r11 = r8.c.a(PromotionCardModuleName.ImageAreaStatusTag);
        if (r11 == null) goto L38;
        int r2 = UIConfigHelper.a;
        UIConfigHelper.d(this.h, r11);
    L38:
        IPromotionUIConfig.d r12 = r8.c.a(PromotionCardModuleName.ImageAreaFlickerIcon);
        if (r12 == null) goto L41;
        int r3 = UIConfigHelper.a;
        UIConfigHelper.d(this.f, r12);
    L41:
        IPromotionUIConfig.d r13 = r8.c.a(PromotionCardModuleName.ImageAreaExplainingBarTip);
        if (r13 == null) goto L46;
        TextView r4 = (TextView) this.d.findViewById(2131390596);
        if (r4 == null) goto L46;
        UIConfigHelper.d(r4, r13);
    L46:
        IPromotionUIConfig.d r14 = r8.c.a(PromotionCardModuleName.ImageAreaExplainingBar);
        if (r14 == null) goto L52;
        ViewGroup r15 = (ViewGroup) this.d.findViewById(2131371938);
        if (r15 == null) goto L53;
        UIConfigHelper.d(r15, r14);
        return;
    L53:
        return;
    L52:
        return;
    L5:
        this.i.setVisibility(0);
        this.f.setVisibility(8);
        this.i.setText(String.valueOf(r0.getIronIndex()));
        Typeface r5 = ECFontHelper.e.b("DouyinNumberABC", MonitorLevel.FATAL, false);
        if (r5 == null) goto L8;
        this.i.setTypeface(r5);
    L8:
        ECUrlModel r6 = r0.statusImgUrl;
        String r7 = null;
        if (r6 == null) goto L11;
        String r16 = r6.getFirstUrl();
    L13:
        if (cg4.a.a(r16) == false) goto L16;
        y.d(this.h, r0.statusImgUrl.getFirstUrl());
        this.h.setVisibility(0);
        goto L32
    L16:
        if (r0.isPreheat() == false) goto L27;
        Map r17 = r0.statusImgMap;
        if (r17 == null) goto L20;
        String r18 = (String) r17.get(String.valueOf(7000));
    L21:
        if (r18 == null) goto L27;
        ECDraweeView r19 = this.h;
        Map r20 = r0.statusImgMap;
        if (r20 == null) goto L25;
        r7 = (String) r20.get(String.valueOf(7000));
    L25:
        y.d(r19, r7);
        this.h.setVisibility(0);
        goto L32
    L20:
        r18 = null;
    L27:
        if (this.n == false) goto L31;
        if (r9 == false) goto L31;
        if (this.o == true) goto L32;
    L31:
        this.h.setVisibility(8);
        goto L32
    L11:
        r16 = null;
        goto L13
    }

    public ListItemImageAreaModule(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = EComABUtils.enableListFlickerIconFix();
        th.a.c(r2, 2131564750, this, true);
        this.d = findViewById(2131382338);
        ECPromotionTopTagLinearlayout r5 = (ECPromotionTopTagLinearlayout) findViewById(2131389180);
        this.e = r5;
        this.g = findViewById(2131376250);
        this.f = findViewById(2131385273);
        this.h = findViewById(2131376637);
        this.i = (TextView) findViewById(2131391196);
        this.j = (TextView) findViewById(2131390592);
        ECHotAtmosphereView r6 = findViewById(2131377516);
        this.k = r6;
        this.l = new com.bytedance.android.livesdk.livecommerce.promotion.card.utils.e(r6, r5, new AnonymousClass1(this));
    }

    public final void c(i r9, boolean r10, long r11) {
        if (r10 == true) goto L4;
        this.j.setText(th.a.g(getContext(), 2131896705));
    L26:
        TextView r12 = this.j;
        if (r10 == false) goto L29;
        int r13 = th.a.a(getContext(), 2131101558);
    L30:
        r12.setTextColor(r13);
        if (r10 == false) goto L33;
        Drawable r14 = null;
    L34:
        this.j.setCompoundDrawablesWithIntrinsicBounds(r14, null, null, null);
        return;
    L33:
        r14 = th.a.b(getContext(), 2131234527);
        goto L34
    L29:
        r13 = -1;
        goto L30
    L4:
        if (r11 >= 10) goto L11;
        this.j.setText(th.a.g(getContext(), 2131896706));
        LivePromotionCardArgs r15 = this.a;
        if (r15 == null) goto L26;
        PromotionListEventActionImpl r16 = r15.h;
        if (r16 == null) goto L26;
        g r17 = r9.a.b;
        Intrinsics.checkNotNullParameter(r17, "promotionParams");
        oh.a.c("", new m(r16, r17, 1));
        goto L26
    L11:
        if (r11 < 1000000) goto L14;
        String r18 = "99万+";
    L20:
        this.j.setText(th.a.h(getContext(), 2131896700, new Object[]{r18}));
        LivePromotionCardArgs r19 = this.a;
        if (r19 == null) goto L26;
        PromotionListEventActionImpl r110 = r19.h;
        if (r110 == null) goto L26;
        g r20 = r9.a.b;
        Intrinsics.checkNotNullParameter(r20, "promotionParams");
        oh.a.c("", new m(r110, r20, 2));
        goto L26
    L14:
        if (r11 < 10000) goto L19;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        String r111 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf((r11 * 1.0d) / ((double) 10000))}, 1));
        if ('0' != r111.charAt(r111.length() - 1)) goto L18;
        r18 = r111.substring(0, r111.length() - 2) + "万";
        goto L20
    L18:
        r18 = r111.concat("万");
        goto L20
    L19:
        r18 = String.valueOf(r11);
        goto L20
    }

    public /* synthetic */ ListItemImageAreaModule(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
