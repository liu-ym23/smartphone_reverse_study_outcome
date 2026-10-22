package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionCurrentUserInfo;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.AuctionV2CardAtmosphereHelper;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionBidPriceAreaView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionButtonView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionStatusView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.generic.RoundingParams;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class AuctionV2CardPresenter extends p {
    public static final /* synthetic */ int l = 0;
    public boolean g;
    public AuctionV2CardAtmosphereHelper h;
    public final DisposableScope i;
    public String j;
    public String k;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AuctionV2CardPresenter a;

        public b(AuctionV2CardPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            ECUIPromotion r13 = (ECUIPromotion) r12;
            if (r13 == null) goto L94;
            boolean r1 = true;
            if (r13.isAuctionV2() != true) goto L94;
            this.a.u().d().q(rk2.c.class, 0);
            AuctionV2CardPresenter r0 = this.a;
            if (r0.g == true) goto L9;
            th.a.c(this.a.u().c(), 2131560687, (ViewGroup) r0.w().f(), true);
            this.a.g = true;
        L9:
            final AuctionV2CardPresenter r2 = this.a;
            r2.getClass();
            String r5 = r13.imageUrl;
            if (r5 == null) goto L12;
            ECDraweeView r4 = r2.w().b(2131365202).f();
            float r3 = UtilityKotlinExtentionsKt.c(14);
            r4.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r3, r3, 0.0f, 0.0f));
            h0.e(r4, r5, new com.bytedance.android.ec.core.imagex.r("ec_live", "auction_card_view"), null, null, 120);
        L12:
            r2.I(r13.auctionV2);
            r2.G(r13.auctionV2);
            ECAuctionInfo r6 = r13.auctionV2;
            if (r6 == null) goto L15;
            AuctionBidPriceAreaView r7 = (AuctionBidPriceAreaView) r2.w().b(2131365159).f();
            Intrinsics.checkNotNullParameter(r6, "auctionInfo");
            ((com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.a) r7.e.getValue()).c(Long.valueOf(r6.getPrice()));
            ((com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.a) r7.f.getValue()).c(r6);
        L15:
            AuctionHotAtmosphereView r8 = r2.w().b(2131365179).f();
            ECAuctionAtmosphere r9 = r13.auctionAtmosphere;
            if (r9 == null) goto L83;
            AuctionV2CardAtmosphereHelper r10 = r2.h;
            ECAuctionCountdownAtmosphere r11 = null;
            if (r10 != null) goto L26;
            String r14 = r2.j;
            String r15 = r2.k;
            ExplainCardViewModel r16 = r2.e;
            if (r16 == null) goto L22;
            com.bytedance.android.ec.common.api.jump.model.g r17 = r16.buildAuctionV2PromotionParams(r13);
        L23:
            if (r17 != null) goto L25;
            r17 = com.bytedance.android.ec.common.api.jump.model.b.a;
        L25:
            r2.h = new AuctionV2CardAtmosphereHelper(r14, r15, r8, r17);
        L33:
            AuctionV2CardAtmosphereHelper r18 = r2.h;
            if (r18 == null) goto L37;
            com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(r18);
        L37:
            if (r9.getDigital() == null) goto L39;
        L53:
            AuctionV2CardAtmosphereHelper r19 = r2.h;
            if (r19 == null) goto L86;
            Intrinsics.checkNotNullParameter(r9, "auctionAtmosphere");
            r19.a = r9;
            r19.c = false;
            Runnable r20 = r19.d;
            if (r20 == null) goto L58;
            UtilityKotlinExtentionsKt.b.removeCallbacks(r20);
        L58:
            r19.d = null;
            r19.g.setVisibility(4);
            ECAuctionAtmosphere r21 = r19.a;
            if (r21 == null) goto L61;
            ECAuctionDigitalAtmosphere r22 = r21.getDigital();
        L62:
            ECAuctionAtmosphere r23 = r19.a;
            if (r23 == null) goto L65;
            r11 = r23.getCountDown();
        L65:
            dm.a.b r24 = dm.a.a("AuctionV2");
            StringBuilder r25 = new StringBuilder("show auction atmosphere, has digital=");
            if (r22 == null) goto L68;
            boolean r26 = true;
        L69:
            r25.append(r26);
            r25.append(", has count down=");
            if (r11 != null) goto L73;
            r1 = false;
        L73:
            r25.append(r1);
            r24.i(r25.toString());
            if (r22 != null) goto L76;
            if (r11 != null) goto L86;
        L76:
            if (r22 == null) goto L79;
            if (r11 != null) goto L79;
            r19.b(r22);
        L79:
            if (r22 == null) goto L82;
            if (r11 == null) goto L82;
            r19.b(r22);
        L82:
            r19.g.setVisibility(4);
            goto L86
        L68:
            r26 = false;
            goto L69
        L61:
            r22 = null;
        L86:
            r2.w().b(2131376072).f().setOnClickListener(new AuctionV2CardPresenter$bindClick$1(r2));
            ((AuctionButtonView) r2.w().b(2131365162).f()).setOnClickListener(new j(r2));
            r2.w().f().setOnClickListener(new k(r2));
            if (r2.F(r13.auctionV2) == false) goto L89;
            r2.I(r13.auctionV2);
            r2.G(r13.auctionV2);
        L89:
            ExplainCardViewModel r110 = this.a.e;
            if (r110 == null) goto L96;
            QLiveData<bk2.a<Unit>> r111 = r110.getShowCardAction();
            if (r111 == null) goto L97;
            r111.g(new bk2.a(Unit.INSTANCE));
            return;
        L97:
            return;
        L96:
            return;
        L39:
            if (r9.getCountDown() != null) goto L53;
            int r27 = zg2.a.a;
            ExplainCardViewModel r28 = r2.e;
            if (r28 == null) goto L45;
            ml.b r29 = r28.getLiveRoomInfo();
            if (r29 == null) goto L45;
            String r30 = r29.roomId();
        L46:
            ExplainCardViewModel r31 = r2.e;
            if (r31 == null) goto L51;
            RoomContextController r32 = r31.getRoomContextController();
            if (r32 == null) goto L51;
            String r33 = r32.D();
        L52:
            zg2.a.a(r30, r33, Action.GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR, null);
        L51:
            r33 = null;
        L45:
            r30 = null;
            goto L46
        L22:
            r17 = null;
            goto L23
        L26:
            ExplainCardViewModel r34 = r2.e;
            if (r34 == null) goto L29;
            com.bytedance.android.ec.common.api.jump.model.g r35 = r34.buildAuctionV2PromotionParams(r13);
        L30:
            if (r35 != null) goto L32;
            r35 = com.bytedance.android.ec.common.api.jump.model.b.a;
        L32:
            Intrinsics.checkNotNullParameter(r35, "<set-?>");
            r10.h = r35;
            goto L33
        L29:
            r35 = null;
            goto L30
        L83:
            AuctionV2CardAtmosphereHelper r36 = r2.h;
            if (r36 == null) goto L86;
            r36.g.setVisibility(4);
            Unit r37 = Unit.INSTANCE;
        L94:
            this.a.u().d().q(rk2.c.class, 8);
            this.a.clear();
        }
    }

    static {
    }

    public final void clear() {
        if (this.g == false) goto L18;
        AuctionV2CardAtmosphereHelper r0 = this.h;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r0);
    L7:
        AuctionV2CardAtmosphereHelper r1 = this.h;
        if (r1 == null) goto L16;
        Runnable r2 = r1.d;
        if (r2 == null) goto L12;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r2);
    L12:
        Runnable r3 = r1.d;
        if (r3 == null) goto L15;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r3);
    L15:
        r1.d = null;
    L16:
        AuctionStatusView r4 = (AuctionStatusView) w().b(2131365156).f();
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r4);
        r4.f = null;
        this.i.clearDisposable();
        return;
    }

    public AuctionV2CardPresenter() {
        this.i = new DisposableScope();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ExplainCardViewModel r0 = this.e;
        String r1 = null;
        if (r0 == null) goto L7;
        RoomContextController r2 = r0.getRoomContextController();
        if (r2 == null) goto L7;
        String r4 = r2.B();
    L8:
        this.j = r4;
        ExplainCardViewModel r5 = this.e;
        if (r5 == null) goto L13;
        RoomContextController r6 = r5.getRoomContextController();
        if (r6 == null) goto L13;
        r1 = r6.D();
    L13:
        this.k = r1;
        ExplainCardViewModel r7 = this.e;
        if (r7 == null) goto L19;
        QLiveData<ECUIPromotion> r8 = r7.getPromotionState();
        if (r8 == null) goto L20;
        r8.b(r3.getLifecycleOwner(), new b(this));
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final boolean F(ECAuctionInfo r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (((AuctionStatusView) w().b(2131365156).f()).S5(null) == true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionButtonView] */
    public final void G(ECAuctionInfo r18) {
        if (r18 == null) goto L47;
        ?? r1 = (AuctionButtonView) w().b(2131365162).f();
        Intrinsics.checkNotNullParameter(r18, "auctionInfo");
        Long r2 = Long.valueOf(r18.getStatus());
        if (r2.longValue() > 2) goto L7;
        boolean r3 = true;
    L8:
        String r4 = null;
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L18;
        r2.longValue();
        r1.c.setTextColor(com.bytedance.android.ec.core.utils.s.a("#FFFFFFFF", -1));
        if (Build.VERSION.SDK_INT < 24) goto L17;
        r1.setBackground(th.a.b(r1.getContext(), 2131234241));
    L23:
        r1.b.setVisibility(8);
        String r5 = "";
        if (r18.getStatus() != 3) goto L41;
        ECAuctionCurrentUserInfo r6 = r18.getCurrentUserInfo();
        if (r6 == null) goto L36;
        ECUrlModel r10 = r6.getUserPic();
        if (r10 == null) goto L36;
        r1.b.setVisibility(0);
        r1.b.getRoundingParams().setRoundAsCircle(true);
        ECDraweeView r9 = r1.b;
        int r7 = com.bytedance.android.ec.core.imagex.r.h;
        h0.d(r9, r10, com.bytedance.android.ec.core.imagex.r.a.b("auction_card_button_head_icon"), null, null, null, null, 120);
        TextView r8 = r1.c;
        Context r11 = r1.getContext();
        Object[] r12 = new Object[1];
        ECAuctionCurrentUserInfo r0 = r18.getCurrentUserInfo();
        if (r0 == null) goto L32;
        r4 = r0.getUserName();
    L32:
        if (r4 == null) goto L35;
        r5 = r4;
    L35:
        r12[0] = r5;
        r8.setText(th.a.h(r11, 2131896346, r12));
        return;
    L36:
        r1.b.setVisibility(8);
        TextView r13 = r1.c;
        String r14 = r18.getButtonLabel();
        if (r14 == null) goto L40;
        r5 = r14;
    L40:
        r13.setText(r5);
        Unit r15 = Unit.INSTANCE;
        return;
    L41:
        TextView r16 = r1.c;
        String r17 = r18.getButtonLabel();
        if (r17 == null) goto L45;
        r5 = r17;
    L45:
        r16.setText(r5);
        return;
    L17:
        r1.setBackgroundColor(th.a.a(r1.getContext(), 2131106067));
        goto L23
    L18:
        r1.c.setTextColor(com.bytedance.android.ec.core.utils.s.a("#80FFFFFF", -1));
        if (Build.VERSION.SDK_INT < 24) goto L21;
        r1.setBackground(th.a.b(r1.getContext(), 2131234240));
    L22:
        Unit r19 = Unit.INSTANCE;
        goto L23
    L21:
        r1.setBackgroundColor(th.a.a(r1.getContext(), 2131105965));
        goto L22
    L7:
        r3 = false;
        goto L8
    }

    public final void I(final ECAuctionInfo r4) {
        if (r4 == null) goto L8;
        AuctionStatusView r0 = (AuctionStatusView) w().b(2131365156).f();
        Function0<Unit> r1 = new AuctionV2CardPresenter$updateStatus$$inlined$also$lambda$1(r4, this);
        Intrinsics.checkNotNullParameter(r4, "auctionData");
        Intrinsics.checkNotNullParameter(r1, "onCountDownFinish");
        r0.g = r4;
        r0.f = r1;
        r0.b.setVisibility(8);
        int r2 = wl.a.b;
        r0.e = wl.a.a(r4.getEndTime());
        r0.R5(r4);
        if (r0.S5(null) == false) goto L6;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(r0);
        return;
    L6:
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r0);
        return;
    }

    public static final void E(AuctionV2CardPresenter r9, String r10, ECUIPromotion r11) {
        r9.getClass();
        if (r11 == null) goto L47;
        ECAuctionInfo r0 = r11.auctionV2;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r10.length() <= 0) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        String r2 = r10;
    L16:
        if (r2 == null) goto L46;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("report_type", "1");
        r6.put("auction_id", String.valueOf(r0.getAuctionId()));
        r6.put("product_id", r11.getProductId());
        ExplainCardViewModel r12 = r9.e;
        if (r12 == null) goto L22;
        ml.b r13 = r12.getLiveRoomInfo();
        if (r13 == null) goto L22;
        String r14 = r13.roomId();
    L24:
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r6.put("room_id", r14);
        ExplainCardViewModel r15 = r9.e;
        if (r15 == null) goto L31;
        ml.b r16 = r15.getLiveRoomInfo();
        if (r16 == null) goto L31;
        String r17 = r16.c();
    L32:
        if (r17 != null) goto L34;
        String r5 = "";
    L35:
        ExplainCardViewModel r18 = r9.e;
        if (r18 == null) goto L40;
        ml.b r19 = r18.getLiveRoomInfo();
        if (r19 == null) goto L40;
        String r110 = r19.d();
    L41:
        if (r110 != null) goto L43;
        String r4 = "";
    L44:
        com.bytedance.android.ec.core.async.a.a(vi2.h.e(null, null, r10, new vi2.v(r4, r5, r6, MapsKt.mapOf(TuplesKt.to("Agw-Js-Conv", "str")), r10)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(l.a, m.a), r9.i);
        return;
    L43:
        r4 = r110;
    L40:
        r110 = null;
        goto L41
    L34:
        r5 = r17;
    L31:
        r17 = null;
    L22:
        r14 = null;
        goto L24
    L46:
        return;
    L15:
        r2 = null;
        goto L16
    L11:
        r1 = false;
        goto L13
    }
}
