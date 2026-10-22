package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedProductInfo;
import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class DefaultCardShowStrategy implements com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a {
    public final PromotionCardProductRefreshHandler b;
    public final Map<Integer, Long> c;
    public long d;
    public String e;
    public final i f;
    public final g g;
    public final String h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void g(String r1, ECHotAtmosphere r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void h() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void j(ECUIPromotion r1) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void o() {
        g r0 = this.g;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void a(boolean r1) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.b.a(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void d(ECUIPromotion r3) {
        Intrinsics.checkNotNullParameter(r3, "uiPromotion");
        this.e = r3.getPromotionId();
        Intrinsics.checkNotNullParameter(r3, "uiPromotion");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void e(boolean r1) {
        this.f.r();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void k(boolean r1) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.b.b(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void m(ECLiveCardPanelType r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        Intrinsics.checkNotNullParameter(r2, "panelType");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void p(b r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "message");
        sg2.b r13 = r11.getCommon();
        long r0 = r11.c;
        if (r13 == null) goto L5;
        long r14 = r13.c;
    L6:
        ExplainCardViewModel r4 = this.f.j();
        if (r4 == null) goto L11;
        QLiveData<ECUIPromotion> r5 = r4.getPromotionState();
        if (r5 == null) goto L11;
        ECUIPromotion r6 = (ECUIPromotion) r5.a();
    L12:
        int r7 = com.bytedance.android.livesdk.livecommerce.utils.e.a;
        if (r6 != null) goto L15;
    L19:
        boolean r15 = false;
    L20:
        if (r15 == false) goto L24;
        f.a().w("Promotion data verification failed.", null);
        return;
    L24:
        if (this.f.i().v() == false) goto L30;
        ECContext r16 = this.f.i().r();
        if (r16 == null) goto L35;
        n<ECUIPromotion> r17 = r16.getExplainPromotion();
        if (r17 == null) goto L35;
        r17.setValue(null);
    L35:
        this.e = null;
        g r18 = this.g;
        if (r18 == null) goto L39;
        r18.f("explain_card_request");
    L39:
        if (r0 <= 0) goto L47;
        if (r6 == null) goto L48;
        g r19 = this.g;
        if (r19 == null) goto L45;
        r19.a();
    L45:
        this.f.k(null, String.valueOf(r0), true);
        return;
    L48:
        return;
    L47:
        return;
    L30:
        ECContext r110 = ControllerExtensionsKt.c(this.f.i(), this.h).r();
        if (r110 == null) goto L35;
        n<ECUIPromotion> r111 = r110.getExplainPromotion();
        if (r111 == null) goto L35;
        r111.setValue(null);
        goto L35
    L15:
        if (r14 <= 0) goto L19;
        if (r6.logicalClock <= r14) goto L19;
        r15 = true;
    L11:
        r6 = null;
        goto L12
    L5:
        r14 = 0;
        goto L6
    }

    public static final void f(DefaultCardShowStrategy r4, ECUIPromotion r5, ECV2UpdatedProductInfo r6) {
        r4.getClass();
        if (r6 == null) goto L19;
        String r7 = r6.title;
        if (r7 == null) goto L8;
        r5.title = r7;
    L8:
        String r8 = r6.cover;
        if (r8 == null) goto L11;
        r5.imageUrl = r8;
    L11:
        long r0 = r6.status;
        if (r0 <= 0) goto L15;
        r5.setStatus(ECUIPromotion.getECUIPromotionStatus((int) r0, r5.inStock, r5.canSold));
    L15:
        if (a2.b(r6.popUpIcon) == false) goto L18;
        r5.qIvIcon = r6.popUpIcon;
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void b(final b r20, boolean r21, final Function1<? super ECUIPromotion, Unit> r22) {
        Intrinsics.checkNotNullParameter(r20, "msg");
        ExplainCardViewModel r0 = this.f.j();
        int r1 = com.bytedance.android.livesdk.livecommerce.message.a.i;
        final com.bytedance.android.livesdk.livecommerce.message.a r2 = com.bytedance.android.livesdk.livecommerce.message.a.C0078a.a(r20.getCommon());
        sg2.b r3 = r20.getCommon();
        if (r3 == null) goto L5;
        long r5 = r3.c;
    L7:
        if (r0 == null) goto L11;
        QLiveData<ECUIPromotion> r4 = r0.getPromotionState();
        if (r4 == null) goto L11;
        ECUIPromotion r6 = (ECUIPromotion) r4.a();
    L12:
        int r7 = com.bytedance.android.livesdk.livecommerce.utils.e.a;
        if (r6 != null) goto L15;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L23;
        f.a().w("Promotion data verification failed.", null);
        return;
    L23:
        if (r2 != null) goto L25;
    L29:
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = null;
        ECV2DelayParam r10 = r20.d;
        if (r10 != null) goto L32;
    L35:
        boolean r11 = true;
    L36:
        if (r11 == false) goto L38;
        b r12 = r20;
    L39:
        if (r12 == null) goto L43;
        ECV2DelayParam r13 = r12.d;
        if (r13 == null) goto L43;
        r9.element = new Pair(Long.valueOf(r13.minDelayMs), Long.valueOf(r13.maxDelayMs));
    L43:
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        ECV2PopMsgProductInfo r15 = r20.e;
        if (r15 == null) goto L55;
        if (r15.explainTime < this.d) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == true) goto L52;
        r15 = null;
    L52:
        if (r15 == null) goto L55;
        long r17 = r15.explainTime;
        this.d = r17;
        r14.element = new s(r15.promotionId, r15.productId, r17);
        goto L55
    L48:
        r16 = false;
    L55:
        this.e = String.valueOf(r20.c);
        Function0<Unit> r18 = new DefaultCardShowStrategy$onReceiveCardAppearMsg$requestAction$1(this, r2, r22, r9, r14, r20);
        ECV2OpenPriceTriggerInfo r19 = r20.f;
        if (r19 == null) goto L65;
        ECV2DelayParam r23 = r19.delayParam;
        if (r23 == null) goto L65;
        if (r23.delayStrategy == 0) goto L62;
        boolean r110 = true;
    L63:
        if (r110 == false) goto L65;
        ECV2DelayParam r24 = r23;
    L66:
        g r25 = this.g;
        if (r25 == null) goto L69;
        r25.f("explain_card_request");
    L69:
        if (r24 == null) goto L74;
        g r111 = this.g;
        if (r111 == null) goto L74;
        r111.d("explain_card_request", r24.minDelayMs, r24.maxDelayMs, r18);
        return;
    L74:
        r18.invoke();
        return;
    L62:
        r110 = false;
    L65:
        r24 = null;
        goto L66
    L38:
        r12 = null;
        goto L39
    L32:
        if (r10.delayStrategy != 0) goto L35;
        r11 = false;
        goto L36
    L25:
        if (r20.b == 0) goto L27;
        String r26 = "pop_up";
    L28:
        r2.b(r26);
        goto L29
    L27:
        r26 = "explain_card";
        goto L28
    L15:
        if (r5 <= 0) goto L19;
        if (r6.logicalClock <= r5) goto L19;
        r8 = true;
    L11:
        r6 = null;
        goto L12
    L5:
        r5 = 0;
        goto L7
    }

    public DefaultCardShowStrategy(i r2, g r3, String r4, com.bytedance.android.livesdk.livecommerce.room.controller.business.n r5) {
        Intrinsics.checkNotNullParameter(r2, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r5, "explainCardController");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.b = new PromotionCardProductRefreshHandler(r2, r4, new DefaultCardShowStrategy$handler$1(this));
        this.c = new LinkedHashMap();
    }

    public static final boolean c(DefaultCardShowStrategy r5, f0 r6, ECUIPromotion r7, int r8) {
        Map<Integer, Long> r0 = r5.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Long r2 = (Long) r1.get(Integer.valueOf(r8));
        if (r2 == null) goto L5;
        long r3 = r2.longValue();
    L7:
        if (r3 >= r6.timeStamp) goto L19;
        r5.c.put(Integer.valueOf(r8), Long.valueOf(r6.timeStamp));
        List<Long> r9 = r6.productIds;
        if (r9 == null) goto L15;
        String r10 = r7.getProductId();
        if (r10 == null) goto L13;
        Long r11 = Long.valueOf(CastLongProtector.parseLong(r10));
    L14:
        boolean r12 = r9.contains(Long.valueOf(r11.longValue()));
    L16:
        if (r12 == false) goto L19;
        if (r6.updateType != r8) goto L19;
        return false;
    L13:
        r11 = null;
        goto L14
    L15:
        r12 = false;
    L19:
        return true;
    L5:
        r3 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void l(f0 r2, boolean r3, boolean r4, Function1<? super ECUIPromotion, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ExplainCardViewModel r6 = this.f.j();     // Catch: Exception -> L24
        if (r4 == true) goto L6;
        if (r6 == null) goto L21;
        QLiveData<ECUIPromotion> r7 = r6.getPromotionState();     // Catch: Exception -> L24
        if (r7 == null) goto L21;
        ECUIPromotion r8 = (ECUIPromotion) r7.a();     // Catch: Exception -> L24
    L22:
        UtilityKotlinExtentionsKt.f(r2, r8, new DefaultCardShowStrategy$onReceiveCardUpdateMsg$1(this, r6, r5));     // Catch: Exception -> L24
        return;
    L21:
        r8 = null;
        goto L22
    L6:
        if (this.f.i().v() == false) goto L12;
        ECContext r9 = this.f.i().r();     // Catch: Exception -> L24
        if (r9 == null) goto L21;
        n<ECUIPromotion> r10 = r9.getExplainPromotion();     // Catch: Exception -> L24
        if (r10 == null) goto L21;
        r8 = (ECUIPromotion) r10.getValue();     // Catch: Exception -> L24
        goto L22
    L12:
        int r11 = RoomContextController.h;     // Catch: Exception -> L24
        ECContext r12 = RoomContextController.a.a().r();     // Catch: Exception -> L24
        if (r12 == null) goto L21;
        n<ECUIPromotion> r13 = r12.getExplainPromotion();     // Catch: Exception -> L24
        if (r13 == null) goto L21;
        r8 = (ECUIPromotion) r13.getValue();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void n(final e0 r6, boolean r7, boolean r8, final Function2<? super ECUIPromotion, ? super Integer, Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r9, "callback");
        final PromotionCardProductRefreshHandler r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r9, "callback");
        ExplainCardViewModel r10 = r1.c.j();
        if (r10 == null) goto L7;
        QLiveData<ECUIPromotion> r11 = r10.getPromotionState();
        if (r11 == null) goto L7;
        ECUIPromotion r12 = (ECUIPromotion) r11.a();
    L9:
        if (r12 != null) goto L25;
        if (r8 == false) goto L25;
        if (r1.c.i().v() == false) goto L18;
        ECContext r13 = r1.c.i().r();
        if (r13 == null) goto L23;
        n<ECUIPromotion> r14 = r13.getExplainPromotion();
        if (r14 == null) goto L23;
        r12 = (ECUIPromotion) r14.getValue();
    L24:
        boolean r3 = true;
    L26:
        if (r8 == false) goto L28;
        r3 = true;
    L28:
        if (r3 == false) goto L31;
        if (r12 == null) goto L31;
        r9 = new PromotionCardProductRefreshHandler$handleProductRefreshMessage$updateCallback$1(r1, r9);
    L31:
        if (r12 == null) goto L39;
        if (Intrinsics.areEqual(String.valueOf(r6.promotionId), r12.getPromotionId()) == true) goto L36;
        r12 = null;
    L36:
        if (r12 == null) goto L39;
        r1.e(r6, CollectionsKt.listOf(r12), new PromotionCardProductRefreshHandler$handleProductRefreshMessage$$inlined$also$lambda$1(r1, r6, r9), r1.c.i());
        return;
    L39:
        if (Intrinsics.areEqual(String.valueOf(r6.promotionId), (String) r1.e.invoke()) == true) goto L41;
    L59:
        Unit r15 = Unit.INSTANCE;
        return;
    L41:
        if (r1.c.i().v() == true) goto L59;
        ExplainCardViewModel r16 = r1.c.j();
        if (r16 == null) goto L47;
        QLiveData<ECUIPromotion> r17 = r16.getPromotionState();
        if (r17 == null) goto L47;
        ECUIPromotion r18 = (ECUIPromotion) r17.a();
    L48:
        if (r18 != null) goto L59;
        RequestInfo r19 = r6.requestInfo;
        if (r19 == null) goto L54;
        Map<Integer, Request> r20 = r19.pop;
        if (r20 == null) goto L54;
        Request r21 = r20.get(3);
    L55:
        if (r21 == null) goto L59;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_POP_RECV_REFRESH() != 1) goto L59;
        r1.e(r6, null, new PromotionCardProductRefreshHandler$handleProductRefreshMessage$$inlined$run$lambda$1(r6, r9), r1.c.i());
    L54:
        r21 = null;
    L47:
        r18 = null;
    L23:
        r12 = null;
        goto L24
    L18:
        int r22 = RoomContextController.h;
        ECContext r23 = RoomContextController.a.a().r();
        if (r23 == null) goto L23;
        n<ECUIPromotion> r24 = r23.getExplainPromotion();
        if (r24 == null) goto L23;
        r12 = (ECUIPromotion) r24.getValue();
    L25:
        r3 = false;
    L7:
        r12 = null;
        goto L9
    }
}
