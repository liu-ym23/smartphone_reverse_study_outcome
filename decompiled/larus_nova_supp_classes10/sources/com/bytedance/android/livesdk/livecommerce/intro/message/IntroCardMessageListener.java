package com.bytedance.android.livesdk.livecommerce.intro.message;

import android.content.Context;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.intro.event.j;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPrice;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPriceDescription;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.d;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.d0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.m0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.o0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.w;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.bytedance.android.livesdk.livecommerce.model.AtmosphereInfo;
import com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionSuccess;
import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UrlPicture;
import com.bytedance.android.livesdk.livecommerce.model.ProductAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ProductNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.model.e;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.v;
import si2.e0;
import si2.g;
import si2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardMessageListener implements a {
    public final c a;
    public final b b;
    public long c;
    public final Context d;
    public final e e;
    public final RoomContextController f;
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.c g;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.message.a
    public final void a(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r20) {
        Intrinsics.checkNotNullParameter(r20, "message");
        k.c(">> createIntroOnRecvMsg");
        int r3 = com.bytedance.android.livesdk.livecommerce.message.a.i;
        final com.bytedance.android.livesdk.livecommerce.message.a r4 = com.bytedance.android.livesdk.livecommerce.message.a.C0078a.a(r20.getCommon());
        r20.getCommon();
        this.g.b();
        j r5 = this.g.c();
        Integer r6 = null;
        boolean r7 = true;
        if (r5 == null) goto L24;
        Intrinsics.checkNotNullParameter(r20, "message");
        v r2 = new v("livesdk_pop_msg_receive", r5.d);
        jf.b.g r8 = jf.b.g.b;
        r2.c("ecom_entrance_form", "live_popup_card");
        long r9 = System.currentTimeMillis();
        r2.c("ignore", BDLocationException.ERROR_TIMEOUT);
        int r10 = r20.a;
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L10;
        r2.c("msg_type", "disappear");
    L10:
        r2.b("promotion_id", r20.c);
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r11 = r5.a;
        if (r11 == null) goto L21;
        int r12 = r11.a;
        if (r12 == 0) goto L17;
        if (r12 != 1) goto L18;
        r2.c("last_msg_type", "disappear");
    L18:
        r2.b("last_promotion_id", r11.c);
        Long r13 = r5.b;
        if (r13 == null) goto L21;
        r2.b("msg_interval_time", r9 - r13.longValue());
        goto L21
    L17:
        r2.c("last_msg_type", "appear");
    L21:
        r5.a = r20;
        r5.b = Long.valueOf(r9);
        if (r5.c == false) goto L24;
        r2.i(null);
        goto L24
    L9:
        r2.c("msg_type", "appear");
    L24:
        if (r4 != null) goto L26;
    L30:
        ECV2DelayParam r14 = r20.d;
        if (r14 != null) goto L33;
    L36:
        boolean r15 = true;
    L37:
        if (r15 == false) goto L39;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r16 = r20;
    L40:
        if (r16 == null) goto L44;
        ECV2DelayParam r17 = r16.d;
        if (r17 == null) goto L44;
        Pair<Long, Long> r18 = new Pair(Long.valueOf(r17.minDelayMs), Long.valueOf(r17.maxDelayMs));
    L45:
        ECV2PopMsgProductInfo r19 = r20.e;
        if (r19 != null) goto L48;
    L56:
        sh2.b r110 = null;
    L57:
        com.bytedance.android.livesdk.livecommerce.intro.manager.c r21 = this.g;
        IntroCardScene r111 = IntroCardScene.POP_MESSAGE;
        Function2<LiveIntroResponse, List<? extends uh2.a>, Unit> r112 = new IntroCardMessageListener$createIntroOnRecvMsg$5(r4);
        int r22 = r20.a;
        ECV2OpenPriceTriggerInfo r1 = r20.f;
        if (r1 == null) goto L60;
        r6 = Integer.valueOf(r1.triggerType);
    L60:
        r21.e(r111, r18, r110, null, null, r112, new sh2.a(r22, r6));
        return;
    L48:
        if (r19.explainTime >= this.c) goto L51;
        r7 = false;
    L51:
        if (r7 == true) goto L54;
        r19 = null;
    L54:
        if (r19 == null) goto L56;
        long r23 = r19.explainTime;
        this.c = r23;
        r110 = new sh2.b(r19.promotionId, r19.productId, r23);
    L44:
        r18 = null;
        goto L45
    L39:
        r16 = null;
        goto L40
    L33:
        if (r14.delayStrategy != 0) goto L36;
        r15 = false;
        goto L37
    L26:
        if (r20.b == 0) goto L28;
        String r24 = "pop_up";
    L29:
        r4.b(r24);
        goto L30
    L28:
        r24 = "explain_card";
        goto L29
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.message.a
    public final void b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        k.c(">> cancelIntroOnRecvMsg");
        long r0 = r9.c;
        r9.getCommon();
        List<uh2.a> r2 = this.g.b();
        if (r0 <= 0) goto L40;
        if (r2 == null) goto L40;
        List<uh2.a> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L22;
        uh2.a r5 = (uh2.a) r4.next();
        String r6 = String.valueOf(r0);
        boolean r7 = false;
        if ((r5 instanceof IntroPromotionVO) == false) goto L17;
        boolean r8 = Intrinsics.areEqual(((IntroPromotionVO) r5).getPromotionId(), r6);
    L20:
        if (r8 == false) goto L12;
    L23:
        if (r7 == true) goto L40;
        int r10 = r9.a;
        ECV2OpenPriceTriggerInfo r11 = r9.f;
        if (r11 == null) goto L28;
        Integer r12 = Integer.valueOf(r11.triggerType);
    L30:
        if (this.g.h(new sh2.a(r10, r12)) == false) goto L33;
        k.c("cancelIntroOnRecvMsg, filter cancel during open price animation");
        return;
    L33:
        ECContext r13 = this.f.r();
        if (r13 == null) goto L38;
        n<IntroPromotionVO> r14 = r13.getIntroCardState();
        if (r14 == null) goto L38;
        r14.setValue(null);
    L38:
        this.g.g(null, String.valueOf(r0), true);
        return;
    L28:
        r12 = null;
        goto L30
    L17:
        if ((r5 instanceof IntroAuctionPromotionVO) == false) goto L19;
        r8 = Intrinsics.areEqual(((IntroAuctionPromotionVO) r5).getPromotionId(), r6);
        goto L20
    L19:
        r8 = false;
    L22:
        r7 = true;
        goto L23
    L8:
        if (r3.isEmpty() == false) goto L10;
    L40:
        int r15 = k.a;
        k.c("cancelIntroOnRecvMsg, ignore cancel for non-current promotion=" + r0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.message.a
    public final void c(final e0 r18) {
        Intrinsics.checkNotNullParameter(r18, "message");
        k.c(">> refreshIntroOnRecvMsg");
        final c r5 = this.a;
        final Function2<List<? extends uh2.a>, Integer, Unit> r2 = IntroCardMessageListener$refreshIntroOnRecvMsg$1.INSTANCE;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r18, "message");
        List<uh2.a> r3 = r5.d.b();
        if (r3 == null) goto L8;
        if ((!r3.isEmpty()) != true) goto L8;
        r2 = new IntroCardRefreshHandler$handleProductRefreshMessage$updateCallback$1(r2);
    L8:
        if (r3 == null) goto L173;
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L11:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        uh2.a r8 = (uh2.a) r7;
        if ((r8 instanceof IntroPromotionVO) == true) goto L15;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == false) goto L11;
        r4.add(r7);
        goto L11
    L15:
        if (Intrinsics.areEqual(((IntroPromotionVO) r8).getPromotionId(), String.valueOf(r18.promotionId)) == false) goto L17;
        r9 = true;
        goto L18
    L21:
        if ((!r4.isEmpty()) == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L173;
        Function2<LiveIntroResponse, Integer, Unit> r10 = new IntroCardRefreshHandler$handleProductRefreshMessage$$inlined$also$lambda$1(r5, r18, r2);
        int r11 = k.a;
        k.c("[refresh] got ProductRefreshMessage, actionType=" + r18.actionType);
        if (r5.d.a(1) == false) goto L173;
        int r12 = r18.actionType;
        if (r12 == 1) goto L163;
        if (r12 == 2) goto L140;
        int r13 = 5;
        if (r12 == 4) goto L93;
        if (r12 != 5) goto L35;
        AuctionAtmosphere r14 = r18.auctionAtmosphere;
        if (r14 == null) goto L92;
        Iterator r15 = r4.iterator();
    L78:
        if (r15.hasNext() == false) goto L92;
        uh2.a r16 = (uh2.a) r15.next();
        if ((r16 instanceof IntroPromotionVO) == true) goto L82;
        r16 = null;
    L82:
        IntroPromotionVO r17 = (IntroPromotionVO) r16;
        if (r17 == null) goto L78;
        IntroAtmosphere r19 = r17.getIntroAtmosphere();
        if (r19 == null) goto L88;
        if (r19.c() == false) goto L78;
    L88:
        IntroAtmosphere r20 = r17.getIntroAtmosphere();
        if (r20 != null) goto L90;
        AuctionAtmosphere.Companion.getClass();
        r17.setIntroAtmosphere(new IntroAtmosphere(2, true, AuctionAtmosphere.a.b(r14), 4));
        Unit r21 = Unit.INSTANCE;
        goto L78
    L90:
        r20.e(2);
        AuctionAtmosphere.Companion.getClass();
        r20.f(AuctionAtmosphere.a.b(r14));
    L92:
        r5.a(String.valueOf(r18.promotionId));
        goto L173
    L35:
        if (r12 != 6) goto L173;
        AtmosphereInfo r22 = r18.atmosphereInfo;
        if (r22 == null) goto L173;
        Map<Integer, ProductAtmosphere> r23 = r22.atmosphere;
        if (r23 == null) goto L173;
        ProductAtmosphere r24 = r23.get(1);
        if (r24 == null) goto L173;
        if (r24.atmosphereType != 1) goto L173;
        Iterator r25 = r4.iterator();
    L48:
        if (r25.hasNext() == false) goto L173;
        uh2.a r26 = (uh2.a) r25.next();
        if ((r26 instanceof IntroPromotionVO) == false) goto L48;
        IntroPromotionVO r27 = (IntroPromotionVO) r26;
        IntroAtmosphere r28 = r27.getIntroAtmosphere();
        if (r28 == null) goto L55;
        if (r28.c() == false) goto L48;
    L55:
        IntroAtmosphere r29 = r27.getIntroAtmosphere();
        if (r29 == null) goto L58;
        r29.e(r24.atmosphereType);
    L58:
        IntroAtmosphere r30 = r27.getIntroAtmosphere();
        if (r30 == null) goto L73;
        ProductNumAtmosphere r31 = r24.numAtmosphere;
        if (r31 == null) goto L71;
        ProductNumAtmosphere.Companion.getClass();
        Intrinsics.checkNotNullParameter(r31, "$this$toIntroNumAtmosphere");
        ECV2UrlPicture r110 = r31.leftIcon;
        if (r110 == null) goto L65;
        ECV2UrlPicture.Companion.getClass();
        ECUrlModel r111 = ECV2UrlPicture.a.a(r110);
    L66:
        ECV2UrlPicture r112 = r31.background;
        if (r112 == null) goto L69;
        ECV2UrlPicture.Companion.getClass();
        ECUrlModel r113 = ECV2UrlPicture.a.a(r112);
    L70:
        IntroNumAtmosphere r32 = new IntroNumAtmosphere(r111, r113, r31.type, r31.num);
    L72:
        r30.g(r32);
        goto L73
    L69:
        r113 = null;
        goto L70
    L65:
        r111 = null;
        goto L66
    L71:
        r32 = null;
    L73:
        r5.a(String.valueOf(r18.promotionId));
        goto L48
    L93:
        AuctionInfo r33 = r18.auctionInfo;
        if (r33 == null) goto L139;
        Iterator r34 = r4.iterator();
    L97:
        if (r34.hasNext() == false) goto L139;
        uh2.a r35 = (uh2.a) r34.next();
        if ((r35 instanceof IntroPromotionVO) == true) goto L101;
        uh2.a r36 = null;
    L102:
        IntroPromotionVO r37 = (IntroPromotionVO) r36;
        if (r37 == null) goto L97;
        IntroAtmosphere r114 = r37.getIntroAtmosphere();
        if (r114 != null) goto L107;
    L110:
        IntroAtmosphere r115 = r37.getIntroAtmosphere();
        if (r115 == null) goto L117;
        AuctionAtmosphere r116 = r33.atmosphere;
        if (r116 == null) goto L115;
        AuctionAtmosphere.Companion.getClass();
        d r117 = AuctionAtmosphere.a.b(r116);
    L116:
        r115.f(r117);
    L122:
        IntroPrice r38 = r37.getPrice();
        if (r38 == null) goto L136;
        m0 r39 = r38.c();
        if (r39 == null) goto L136;
        w r118 = r39.b();
        Iterator r119 = r34;
        if (r118 == null) goto L129;
        r118.d(r33.price);
    L129:
        List<IntroPriceDescription> r40 = r39.a();
        if (r40 == null) goto L137;
        IntroPriceDescription r41 = (IntroPriceDescription) CollectionsKt.firstOrNull(r40);
        if (r41 == null) goto L137;
        d0 r42 = r41.d();
        if (r42 == null) goto L137;
        r42.d(r33.introPriceLabel);
    L137:
        ((IntroPromotionVO) r35).setAuctionEndTime(r33.endTime);
        r34 = r119;
        r13 = 5;
    L136:
        r119 = r34;
        goto L137
    L115:
        r117 = null;
        goto L116
    L117:
        AuctionAtmosphere r120 = r33.atmosphere;
        if (r120 == null) goto L120;
        AuctionAtmosphere.Companion.getClass();
        d r121 = AuctionAtmosphere.a.b(r120);
    L121:
        r37.setIntroAtmosphere(new IntroAtmosphere(0, true, r121, r13));
        Unit r122 = Unit.INSTANCE;
        goto L122
    L120:
        r121 = null;
        goto L121
    L107:
        if (r114.c() == false) goto L122;
    L101:
        r36 = r35;
    L139:
        r5.a(String.valueOf(r18.promotionId));
        goto L173
    L140:
        ProductInfo r43 = r18.productInfo;
        if (r43 == null) goto L173;
        String r44 = r43.title;
        if (r44 == null) goto L152;
        Iterator r45 = r4.iterator();
    L146:
        if (r45.hasNext() == false) goto L152;
        uh2.a r46 = (uh2.a) r45.next();
        if ((r46 instanceof IntroPromotionVO) == false) goto L146;
        o0 r47 = ((IntroPromotionVO) r46).getTitle();
        if (r47 == null) goto L146;
        r47.d(r44);
    L152:
        String r48 = r43.cover;
        if (r48 == null) goto L162;
        Iterator r49 = r4.iterator();
    L156:
        if (r49.hasNext() == false) goto L162;
        uh2.a r50 = (uh2.a) r49.next();
        if ((r50 instanceof IntroPromotionVO) == false) goto L156;
        u r51 = ((IntroPromotionVO) r50).getImage();
        if (r51 == null) goto L156;
        r51.f(r48);
    L162:
        r5.a(String.valueOf(r18.promotionId));
        goto L173
    L163:
        RequestInfo r52 = r18.requestInfo;
        if (r52 == null) goto L170;
        Map<Integer, Request> r53 = r52.intro;
        if (r53 == null) goto L170;
        Request r54 = r53.get(1);
        if (r54 == null) goto L170;
        Pair r55 = new Pair(1, r54);
    L171:
        if (r55 == null) goto L173;
        int r56 = ((Number) r55.component1()).intValue();
        Request r57 = (Request) r55.component2();
        UtilityKotlinExtentionsKt.f(r57.path, r57.params, new IntroCardRefreshHandler$refreshIntroByMessage$$inlined$also$lambda$1(r57, r56, r5, r18, r10));
    L170:
        r55 = null;
    L173:
        final b r58 = this.b;
        r58.getClass();
        Intrinsics.checkNotNullParameter(r18, "message");
        List<uh2.a> r59 = r58.d.b();
        if (r59 == null) goto L291;
        ArrayList r60 = new ArrayList();
        Iterator<T> r61 = r59.iterator();
    L177:
        if (r61.hasNext() == false) goto L187;
        Object r62 = r61.next();
        uh2.a r63 = (uh2.a) r62;
        if ((r63 instanceof IntroAuctionPromotionVO) == true) goto L181;
    L183:
        boolean r64 = false;
    L184:
        if (r64 == false) goto L177;
        r60.add(r62);
        goto L177
    L181:
        if (Intrinsics.areEqual(((IntroAuctionPromotionVO) r63).getPromotionId(), String.valueOf(r18.promotionId)) == false) goto L183;
        r64 = true;
        goto L184
    L187:
        if ((!r60.isEmpty()) == true) goto L190;
        r60 = null;
    L190:
        if (r60 == null) goto L292;
        int r65 = k.a;
        k.c("[refresh] got ProductRefreshMessage, actionType=" + r18.actionType);
        Integer r66 = r58.d.j();
        if (r66 != null) goto L195;
    L196:
        boolean r123 = false;
    L198:
        if (r123 == true) goto L201;
        return;
    L201:
        if (r58.d.a(2) == true) goto L204;
        return;
    L204:
        if (r18.actionType == 1) goto L229;
        JSONObject r67 = z1.g(r18.toJsonString());
        if (r67 == null) goto L293;
        JSONObject r68 = new JSONObject();
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L226
        sg2.b r70 = r18.getCommon();     // Catch: Throwable -> L226
        if (r70 == null) goto L211;
        Long r71 = Long.valueOf(r70.g);     // Catch: Throwable -> L226
    L212:
        r68.putOpt("client_recv_timestamp", r71);     // Catch: Throwable -> L226
        r68.putOpt("client_send_timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L226
        sg2.b r72 = r18.getCommon();     // Catch: Throwable -> L226
        if (r72 == null) goto L217;
        TraceTimeMetricV2 r73 = r72.d;     // Catch: Throwable -> L226
        if (r73 == null) goto L217;
        Long r74 = Long.valueOf(r73.getOpTimestamp());     // Catch: Throwable -> L226
    L218:
        r68.putOpt("op_timestamp", r74);     // Catch: Throwable -> L226
        sg2.b r0 = r18.getCommon();     // Catch: Throwable -> L226
        if (r0 == null) goto L223;
        TraceTimeMetricV2 r1 = r0.d;     // Catch: Throwable -> L226
        if (r1 == null) goto L223;
        Long r124 = Long.valueOf(r1.getMsgSendTimestamp());     // Catch: Throwable -> L226
    L224:
        r68.putOpt("msg_send_timestamp", r124);     // Catch: Throwable -> L226
        Result.constructor-impl(r67.put("msg_trace_info", r68));     // Catch: Throwable -> L226
    L228:
        ECLiveHybridUtil.f("ecom.audience.productRefreshMessage", r67);
        return;
    L223:
        r124 = null;
    L217:
        r74 = null;
        goto L218
    L211:
        r71 = null;
    L226:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L228
    L293:
        return;
    L229:
        RequestInfo r76 = r18.requestInfo;
        if (r76 == null) goto L236;
        Map<Integer, Request> r77 = r76.intro;
        if (r77 == null) goto L236;
        Request r78 = r77.get(1);
        if (r78 == null) goto L236;
        Pair r125 = new Pair(1, r78);
    L237:
        if (r125 == null) goto L295;
        ((Number) r125.component1()).intValue();
        final Request r79 = (Request) r125.component2();
        UtilityKotlinExtentionsKt.f(r79.path, r79.params, new IntroAuctionRefreshHandler$refreshIntroByMessage$$inlined$also$lambda$1(r79, r58, r18));
        return;
    L295:
        return;
    L236:
        r125 = null;
        goto L237
    L195:
        if (r66.intValue() != 2) goto L196;
        r123 = true;
        goto L198
    L292:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.message.a
    public final void d(z r13) {
        k.c(">> updateAuctionOnRecvMsg");
        if (r13 == null) goto L5;
        Integer r1 = Integer.valueOf(r13.msgType);
    L7:
        if (r1 != null) goto L10;
    L98:
        if (r13 == null) goto L194;
        List<uh2.a> r2 = this.g.b();
        if (r2 == null) goto L147;
        ArrayList r7 = new ArrayList();
        Iterator<T> r6 = r2.iterator();
    L103:
        if (r6.hasNext() == false) goto L122;
        Object r8 = r6.next();
        uh2.a r9 = (uh2.a) r8;
        if ((r9 instanceof IntroPromotionVO) == false) goto L119;
        IntroProduct r10 = ((IntroPromotionVO) r9).getProduct();
        if (r10 == null) goto L109;
        String r11 = r10.g();
    L110:
        List<Long> r12 = r13.productIds;
        if (r12 == null) goto L115;
        Long r14 = (Long) CollectionsKt.firstOrNull(r12);
        if (r14 == null) goto L115;
        String r15 = String.valueOf(r14.longValue());
    L117:
        if (Intrinsics.areEqual(r11, r15) == false) goto L119;
        boolean r16 = true;
    L120:
        if (r16 == false) goto L103;
        r7.add(r8);
    L115:
        r15 = null;
        goto L117
    L109:
        r11 = null;
    L119:
        r16 = false;
        goto L120
    L122:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r7.iterator();
    L124:
        if (r18.hasNext() == false) goto L132;
        uh2.a r19 = (uh2.a) r18.next();
        if ((r19 instanceof IntroPromotionVO) == true) goto L128;
        r19 = null;
    L128:
        IntroPromotionVO r20 = (IntroPromotionVO) r19;
        if (r20 == null) goto L124;
        r17.add(r20);
        goto L124
    L132:
        if ((!r17.isEmpty()) == true) goto L135;
        r17 = null;
    L135:
        if (r17 == null) goto L147;
        c r21 = this.a;
        String r22 = g.b0;
        Map<String, String> r23 = MapsKt.emptyMap();
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r24 = r17.iterator();
    L138:
        if (r24.hasNext() == false) goto L146;
        IntroProduct r111 = ((IntroPromotionVO) r24.next()).getProduct();
        if (r111 == null) goto L142;
        String r112 = r111.i();
    L143:
        if (r112 != null) goto L145;
        r112 = "";
    L145:
        r110.add(r112);
        goto L138
    L142:
        r112 = null;
        goto L143
    L146:
        r21.b(r22, r23, r110, IntroCardMessageListener$handleAuctionLiveMarketingMessageRefresh$4$2.INSTANCE);
    L147:
        if (r2 == null) goto L194;
        ArrayList r25 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L150:
        if (r3.hasNext() == false) goto L169;
        Object r26 = r3.next();
        uh2.a r27 = (uh2.a) r26;
        if ((r27 instanceof IntroAuctionPromotionVO) == false) goto L166;
        IntroProduct r28 = ((IntroAuctionPromotionVO) r27).getProduct();
        if (r28 == null) goto L156;
        String r29 = r28.g();
    L157:
        List<Long> r30 = r13.productIds;
        if (r30 == null) goto L162;
        Long r31 = (Long) CollectionsKt.firstOrNull(r30);
        if (r31 == null) goto L162;
        String r32 = String.valueOf(r31.longValue());
    L164:
        if (Intrinsics.areEqual(r29, r32) == false) goto L166;
        boolean r33 = true;
    L167:
        if (r33 == false) goto L150;
        r25.add(r26);
    L162:
        r32 = null;
        goto L164
    L156:
        r29 = null;
    L166:
        r33 = false;
        goto L167
    L169:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r25.iterator();
    L171:
        if (r5.hasNext() == false) goto L179;
        uh2.a r34 = (uh2.a) r5.next();
        if ((r34 instanceof IntroPromotionVO) == true) goto L175;
        r34 = null;
    L175:
        IntroPromotionVO r35 = (IntroPromotionVO) r34;
        if (r35 == null) goto L171;
        r4.add(r35);
        goto L171
    L179:
        if ((!r4.isEmpty()) == true) goto L182;
        r4 = null;
    L182:
        if (r4 == null) goto L194;
        b r36 = this.b;
        String r37 = g.b0;
        Map<String, String> r38 = MapsKt.emptyMap();
        ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r40 = r4.iterator();
    L185:
        if (r40.hasNext() == false) goto L193;
        IntroProduct r41 = ((IntroPromotionVO) r40.next()).getProduct();
        if (r41 == null) goto L189;
        String r42 = r41.i();
    L190:
        if (r42 != null) goto L192;
        r42 = "";
    L192:
        r39.add(r42);
        goto L185
    L189:
        r42 = null;
        goto L190
    L193:
        r36.a(r37, r38, r39);
    L194:
        if (r13 == null) goto L267;
        ECV2AuctionSuccess r113 = r13.auctionSuccess;
        if (r113 == null) goto L268;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.a.a(this.d, r113);
        return;
    L268:
        return;
    L267:
        return;
    L10:
        if (r1.intValue() != 4) goto L98;
        if (r13 == null) goto L194;
        ECV2AuctionInfo r43 = r13.auctionInfo;
        if (r43 == null) goto L194;
        List<uh2.a> r44 = this.g.b();
        if (r44 == null) goto L194;
        ArrayList r45 = new ArrayList();
        Iterator<T> r46 = r44.iterator();
    L18:
        if (r46.hasNext() == false) goto L32;
        Object r47 = r46.next();
        uh2.a r48 = (uh2.a) r47;
        if ((r48 instanceof IntroPromotionVO) == false) goto L28;
        IntroProduct r49 = ((IntroPromotionVO) r48).getProduct();
        if (r49 == null) goto L24;
        String r50 = r49.g();
    L26:
        if (Intrinsics.areEqual(r50, String.valueOf(r43.productId)) == false) goto L28;
        boolean r51 = true;
    L29:
        if (r51 == false) goto L18;
        r45.add(r47);
        goto L18
    L24:
        r50 = null;
    L28:
        r51 = false;
        goto L29
    L32:
        if ((!r45.isEmpty()) == true) goto L35;
        r45 = null;
    L35:
        if (r45 == null) goto L194;
        ArrayList r52 = new ArrayList();
        Iterator r53 = r45.iterator();
    L38:
        if (r53.hasNext() == false) goto L45;
        uh2.a r54 = (uh2.a) r53.next();
        if ((r54 instanceof IntroPromotionVO) == true) goto L42;
        r54 = null;
    L42:
        IntroPromotionVO r55 = (IntroPromotionVO) r54;
        if (r55 == null) goto L38;
        r52.add(r55);
        goto L38
    L45:
        Iterator r56 = r52.iterator();
    L47:
        if (r56.hasNext() == false) goto L95;
        IntroPromotionVO r57 = (IntroPromotionVO) r56.next();
        r57.setAuctionInfo(r43.toECPromotionAuctionInfo());
        IntroPrice r58 = r57.getPrice();
        if (r58 == null) goto L55;
        m0 r59 = r58.c();
        if (r59 == null) goto L55;
        w r60 = r59.b();
        if (r60 == null) goto L55;
        r60.d(r43.price);
    L55:
        ECV2AuctionInfo.ECV2AuctionUserInfo r61 = r43.currentUserInfo;
        if (r61 == null) goto L47;
        String r62 = r61.userName;
        if (r62 == null) goto L47;
        if (r62.length() <= 0) goto L62;
        boolean r63 = true;
    L63:
        if (r63 == true) goto L66;
        r62 = null;
    L66:
        if (r62 == null) goto L47;
        ECV2AuctionInfo.ECV2AuctionUserInfo r64 = r43.currentUserInfo;
        if (r64 == null) goto L70;
        String r65 = String.valueOf(r64.userId);
    L72:
        if (Intrinsics.areEqual(r65, r.a.getCurrentUserId()) == true) goto L73;
        IntroPrice r66 = r57.getPrice();
        if (r66 == null) goto L47;
        m0 r67 = r66.c();
        if (r67 == null) goto L47;
        List<IntroPriceDescription> r68 = r67.a();
        if (r68 == null) goto L47;
        IntroPriceDescription r69 = (IntroPriceDescription) CollectionsKt.firstOrNull(r68);
        if (r69 == null) goto L47;
        d0 r70 = r69.d();
        if (r70 == null) goto L47;
        r70.d(r62.concat("领先"));
        goto L47
    L73:
        IntroPrice r71 = r57.getPrice();
        if (r71 == null) goto L47;
        m0 r72 = r71.c();
        if (r72 == null) goto L47;
        List<IntroPriceDescription> r73 = r72.a();
        if (r73 == null) goto L47;
        IntroPriceDescription r74 = (IntroPriceDescription) CollectionsKt.firstOrNull(r73);
        if (r74 == null) goto L47;
        d0 r75 = r74.d();
        if (r75 == null) goto L47;
        r75.d("我领先");
        goto L47
    L70:
        r65 = null;
        goto L72
    L62:
        r63 = false;
        goto L63
    L95:
        List<uh2.a> r0 = this.g.b();
        if (r0 == null) goto L194;
        this.g.f(r0);
        goto L194
    L5:
        r1 = null;
        goto L7
    }

    public IntroCardMessageListener(Context r2, e r3, RoomContextController r4, com.bytedance.android.livesdk.livecommerce.intro.manager.c r5, com.bytedance.android.livesdk.livecommerce.intro.manager.r r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r4, "roomContextController");
        Intrinsics.checkNotNullParameter(r5, "introCardManager");
        Intrinsics.checkNotNullParameter(r6, "repository");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new c(r3, r5, r6, r4);
        this.b = new b(r3, r5, r6, r4);
    }
}
