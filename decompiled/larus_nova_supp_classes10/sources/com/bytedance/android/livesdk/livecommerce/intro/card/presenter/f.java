package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardAtmosphereComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction.IntroAuctionHotAtmosphereView;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroAuctionAtmosphereHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends oh2.a implements b {
    public e i;

    public static final class a<T> implements Observer {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v11, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardAtmosphereComponent] */
        public final void onChanged(Object r10) {
            IntroPromotionVO r11 = (IntroPromotionVO) r10;
            if (r11 == null) goto L157;
            f r0 = this.a;
            r0.i.e = r11.getProduct();
            e r1 = r0.i;
            IntroProduct r2 = r11.getProduct();
            boolean r3 = false;
            if (r2 == null) goto L7;
            int r4 = r2.h();
        L8:
            r1.c = r4;
            e r5 = r0.i;
            IntroProduct r6 = r11.getProduct();
            if (r6 == null) goto L11;
            int r7 = r6.e();
        L12:
            r5.d = r7;
            r0.i.f = r11.getAuctionInfo();
            r0.i.b = r11.getIntroAtmosphere();
            e r8 = r0.i;
            oh2.e r9 = r0.f;
            String r12 = "";
            if (r9 == null) goto L18;
            com.bytedance.android.livesdk.livecommerce.room.model.e r13 = r9.c;
            if (r13 == null) goto L18;
            String r14 = r13.roomId();
            if (r14 == null) goto L18;
        L19:
            r8.getClass();
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            r8.g = r14;
            e r15 = r0.i;
            oh2.e r16 = r0.f;
            if (r16 == null) goto L27;
            com.bytedance.android.livesdk.livecommerce.room.model.e r17 = r16.c;
            if (r17 == null) goto L27;
            String r18 = r17.a();
            if (r18 == null) goto L27;
            r12 = r18;
        L27:
            r15.getClass();
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            r15.h = r12;
            e r19 = r0.i;
            int r20 = r19.d;
            IntroAtmosphere r21 = null;
            if (r20 == 1) goto L34;
            if (r20 == 2) goto L34;
            if (r19.b != null) goto L34;
            r19 = null;
        L34:
            if (r19 == null) goto L159;
            f r22 = this.a;
            s0 r110 = r11.getControl();
            if (r110 == null) goto L38;
            int r111 = r110.d();
        L39:
            ?? r23 = (IntroCardAtmosphereComponent) r22.w().f();
            Intrinsics.checkNotNullParameter(r19, "atmosphereModel");
            String r24 = r23.l;
            IntroProduct r25 = r19.e;
            if (r25 == null) goto L42;
            String r26 = r25.i();
        L44:
            if ((!Intrinsics.areEqual(r24, r26)) == false) goto L52;
            IntroProduct r27 = r19.e;
            if (r27 == null) goto L48;
            String r28 = r27.i();
        L49:
            r23.l = r28;
            r23.e.i();
            IntroAuctionHotAtmosphereView r29 = r23.g;
            if (r29 == null) goto L52;
            r29.setCallback(null);
            goto L52
        L48:
            r28 = null;
        L52:
            int r30 = r19.d;
            if (r30 == 1) goto L126;
            if (r30 == 2) goto L71;
            IntroAuctionHotAtmosphereView r31 = r23.g;
            if (r31 == null) goto L58;
            r31.setVisibility(8);
        L58:
            IntroAtmosphere r32 = r19.b;
            if (r32 != null) goto L61;
        L68:
            b r112 = r23.c;
            if (r112 == null) goto L161;
            r112.q(true);
            Unit r113 = Unit.INSTANCE;
            return;
        L161:
            return;
        L61:
            if (r32.a() != 1) goto L63;
            boolean r33 = true;
        L64:
            if (r33 == false) goto L66;
            r21 = r32;
        L66:
            if (r21 == null) goto L68;
            r23.T5(r21, r111, false);
            return;
        L63:
            r33 = false;
            goto L64
        L71:
            r23.e.setVisibility(8);
            ECLiveABUtils r34 = ECLiveABUtils.INSTANCE;
            th2.b r35 = r34.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r111));
            if (r35 == null) goto L77;
            ECUrlModel r36 = r35.b();
            if (r36 == null) goto L77;
            String r37 = r36.getFirstUrl();
            if (r37 == null) goto L77;
        L78:
            th2.b r38 = r34.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r111));
            if (r38 == null) goto L84;
            ECUrlModel r39 = r38.d();
            if (r39 == null) goto L84;
            String r40 = r39.getFirstUrl();
            if (r40 == null) goto L84;
        L85:
            ECPromotionAuctionInfo r41 = r19.f;
            if (r41 == null) goto L93;
            ECHotAtmosphere r42 = r41.getIntroHotAtmosphere(r37, r40);
            if (r42 == null) goto L93;
            if (r23.g != null) goto L92;
            r23.R5();
        L92:
            r23.S5(r19, r42, r111);
            return;
        L93:
            IntroAtmosphere r43 = r19.b;
            if (r43 != null) goto L96;
        L110:
            b r114 = r23.c;
            if (r114 == null) goto L113;
            r114.q(true);
        L113:
            r19.a.reset();
            IntroAuctionHotAtmosphereView r115 = r23.g;
            if (r115 == null) goto L116;
            r115.setCallback(null);
        L116:
            IntroAuctionHotAtmosphereView r116 = r23.g;
            if (r116 == null) goto L119;
            r116.setTag(null);
        L119:
            IntroAuctionHotAtmosphereView r117 = r23.g;
            if (r117 == null) goto L122;
            r117.setVisibility(4);
        L122:
            IntroAuctionHotAtmosphereView r118 = r23.g;
            if (r118 == null) goto L125;
            r118.h();
        L125:
            r23.d.setVisibility(4);
            Unit r119 = Unit.INSTANCE;
            return;
        L96:
            if (r43.a() != 1) goto L102;
            IntroNumAtmosphere r44 = r43.d();
            if (r44 == null) goto L102;
            if (r44.getType() != 10001) goto L102;
            r3 = true;
        L102:
            if (r3 == true) goto L105;
            r43 = null;
        L105:
            if (r43 == null) goto L110;
            IntroAuctionHotAtmosphereView r45 = r23.g;
            if (r45 == null) goto L109;
            r45.setVisibility(8);
        L109:
            r23.T5(r43, r111, true);
            return;
        L84:
            r40 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/lcps_tvjl/ljhwZthlaukjlkulzlp/live_intro/auction/auction_deal_v2.webp";
        L77:
            r37 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/lcps_tvjl/ljhwZthlaukjlkulzlp/live_intro/auction/auction_price_v3.webp";
            goto L78
        L126:
            r23.e.setVisibility(8);
            IntroAtmosphere r120 = r19.b;
            if (r120 != null) goto L129;
            return;
        L129:
            if (r120.a() != 2) goto L131;
            boolean r46 = true;
        L132:
            if (r46 == false) goto L134;
            r21 = r120;
        L134:
            if (r21 != null) goto L136;
            return;
        L136:
            if (r23.g != null) goto L138;
            r23.R5();
        L138:
            IntroAtmosphere r121 = r19.b;
            if (r121 != null) goto L141;
        L153:
            IntroAuctionHotAtmosphereView r122 = r23.g;
            if (r122 == null) goto L156;
            r122.setVisibility(8);
        L156:
            r23.d.setVisibility(8);
            r23.setVisibility(8);
            Unit r123 = Unit.INSTANCE;
            return;
        L141:
            if (r121.b() == null) goto L153;
            r23.setVisibility(0);
            IntroAuctionHotAtmosphereView r124 = r23.g;
            if (r124 == null) goto L145;
            r124.setVisibility(0);
        L145:
            IntroAuctionAtmosphereHelper r125 = r23.h;
            if (r125 == null) goto L148;
            r125.a(r19);
        L148:
            IntroAuctionAtmosphereHelper r126 = r23.h;
            if (r126 != null) goto L151;
            return;
        L151:
            if (r126.c == true) goto L169;
            com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(r126);
            r126.c = true;
            return;
        L169:
            return;
        L131:
            r46 = false;
            goto L132
        L42:
            r26 = null;
            goto L44
        L38:
            r111 = 0;
            goto L39
        L159:
            return;
        L18:
            r14 = "";
            goto L19
        L11:
            r7 = 0;
            goto L12
        L7:
            r4 = 0;
            goto L8
        L157:
            this.a.E();
            Unit r127 = Unit.INSTANCE;
        }
    }

    public f() {
        super(0);
        this.i = new e();
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
        E();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardAtmosphereComponent] */
    public final void E() {
        ?? r0 = (IntroCardAtmosphereComponent) w().f();
        r0.d.setVisibility(8);
        r0.e.setVisibility(8);
        IntroAuctionHotAtmosphereView r1 = r0.g;
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        r0.setVisibility(8);
        r0.e.i();
        IntroAuctionHotAtmosphereView r2 = r0.g;
        if (r2 == null) goto L8;
        r2.h();
    L8:
        r0.j = !ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().b();
        r0.i = false;
        IntroAuctionAtmosphereHelper r3 = r0.h;
        if (r3 == null) goto L24;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r3);
        r3.c = false;
        Runnable r4 = r3.h;
        if (r4 == null) goto L13;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r4);
    L13:
        Runnable r5 = r3.h;
        if (r5 == null) goto L16;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r5);
    L16:
        r3.h = null;
        Runnable r6 = r3.i;
        if (r6 == null) goto L19;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r6);
    L19:
        Runnable r7 = r3.i;
        if (r7 == null) goto L22;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r7);
    L22:
        r3.i = null;
        r3.d = null;
        r3.j = true;
        return;
    }

    @Override // oh2.a
    public final void D(oh2.h r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ((IntroCardAtmosphereComponent) w().f()).setPresenter(this);
        IntroCardAtmosphereComponent r0 = (IntroCardAtmosphereComponent) w().f();
        r0.setArgument(this.f);
        r0.setContainerAbility(this.g);
        this.i = new e();
        IntroCardViewModel r1 = this.e;
        if (r1 == null) goto L8;
        bk2.e<IntroPromotionVO> r2 = r1.getCardState();
        if (r2 == null) goto L9;
        r2.b(r3.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b
    public final void q(boolean r4) {
        dm.a.a("IntroAuction").i("setImageTagVisibility to " + r4);
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        bk2.e<bk2.a<Boolean>> r1 = r0.getShowImageTagAction();
        if (r1 == null) goto L9;
        r1.g(new bk2.a(Boolean.valueOf(r4)));
        return;
    L9:
        return;
    }
}
