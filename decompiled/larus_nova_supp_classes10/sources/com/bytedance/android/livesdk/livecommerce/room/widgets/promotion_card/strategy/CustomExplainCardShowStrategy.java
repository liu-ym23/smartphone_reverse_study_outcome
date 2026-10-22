package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.n;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.data.ExplainCardPopStrategyConfig;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.hover.ECExplainCardLiveDialogHoverManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CustomExplainCardShowStrategy implements a, uk2.a {
    public final DefaultCardShowStrategy b;
    public final ECExplainCardLiveDialogHoverManager c;
    public final tk2.a d;
    public String e;
    public final QueryWithMsgCacheCardShowStrategy f;
    public String g;
    public int h;
    public final boolean i;
    public boolean j;
    public Long k;
    public int l;
    public Long m;
    public ECV2PopMsgProductInfo n;
    public final i o;
    public final String p;
    public final n q;
    public final /* synthetic */ vk2.a r;

    public static boolean r() {
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L5;
        vi.a r2 = r1.getIECHostAppInfo();
    L7:
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L12;
    L14:
        return false;
    L12:
        if (r2.isLocalTest() != true) goto L14;
        return true;
    L9:
        if (r2.isDebug() != true) goto L10;
        return true;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void o() {
        u("clear live context.");
        QueryWithMsgCacheCardShowStrategy r0 = this.f;
        if (r0 == null) goto L5;
        r0.o();
    L5:
        this.b.o();
        if (r() == false) goto L11;
        cl.d r1 = k.a();
        if (r1 == null) goto L12;
        r1.m();
        return;
    L12:
        return;
    }

    public final a q() {
        QueryWithMsgCacheCardShowStrategy r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.b;
    }

    public final boolean s() {
        ExplainCardViewModel r0 = this.o.j();
        if (r0 == null) goto L7;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L7;
        ECUIPromotion r2 = (ECUIPromotion) r1.a();
    L8:
        if (r2 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean t() {
        return this.q.A().l();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void h() {
        if (r() == false) goto L8;
        cl.d r0 = k.a();
        if (r0 == null) goto L9;
        r0.m();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void a(boolean r14) {
        a.b.a(r14);
        if (this.i == false) goto L21;
        ExplainCardViewModel r15 = this.o.j();
        if (r15 == null) goto L12;
        QLiveData<ECUIPromotion> r16 = r15.getPromotionState();
        if (r16 == null) goto L12;
        if (((ECUIPromotion) r16.a()) == null) goto L12;
        f.a().i("onFullDialogHoverHide, exist card showing, skipped.");
        v(true, 0);
        this.j = false;
        this.k = null;
        return;
    L12:
        f.a().i("onFullDialogHoverHide, no cached data and query, needPopRequest=" + this.j);
        if (this.j == false) goto L19;
        final long r3 = SystemClock.elapsedRealtime();
        i r17 = this.o;
        Function1<ECUIPromotion, Unit> r5 = new CustomExplainCardShowStrategy$onFullDialogHoverHide$2(this, r3);
        ECV2PopMsgProductInfo r4 = this.n;
        if (r4 == null) goto L17;
        s r6 = new s(r4.promotionId, r4.productId, r4.explainTime);
    L18:
        i.a.a(r17, r5, true, r6, 105);
        goto L19
    L17:
        r6 = null;
    L19:
        this.j = false;
        this.k = null;
        return;
    }

    @Override // uk2.a
    public final void c(ECLiveCardPanelType r7) {
        Intrinsics.checkNotNullParameter(r7, "lastPanel");
        u("onHoverHide");
        ECLiveABUtils r8 = ECLiveABUtils.INSTANCE;
        if (r8.getEC_LIVE_CARD_OBSCURED_EXTEND_TIME() > 0) goto L5;
    L37:
        this.e = null;
        return;
    L5:
        if (t() == true) goto L37;
        ExplainCardViewModel r0 = this.o.j();
        if (r0 == null) goto L11;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L11;
        ECUIPromotion r2 = (ECUIPromotion) r1.a();
    L12:
        boolean r3 = true;
        if (r2 == null) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L26;
        ExplainCardViewModel r5 = this.o.j();
        if (r5 == null) goto L24;
        QLiveData<ECUIPromotion> r6 = r5.getPromotionState();
        if (r6 == null) goto L24;
        ECUIPromotion r9 = (ECUIPromotion) r6.a();
        if (r9 == null) goto L24;
        String r10 = r9.getPromotionId();
    L25:
        u("onHoverHide, card " + r10 + " is displaying, extend exposure time to 10s.");
        this.o.h(r10, r8.getEC_LIVE_CARD_OBSCURED_EXTEND_TIME());
    L24:
        r10 = null;
        goto L25
    L26:
        u("onHoverHide, card is not displaying, request a new card, obscured id=" + this.e);
        String r11 = this.e;
        if (r11 == null) goto L37;
        if (r11.length() > 0) goto L32;
        r3 = false;
    L32:
        if (r3 == true) goto L35;
        r11 = null;
    L35:
        if (r11 == null) goto L37;
        int r12 = f.a;
        f.b(this.p, null, null, null, new CustomExplainCardShowStrategy$onHoverHide$$inlined$also$lambda$1(this));
        goto L37
    L15:
        r4 = false;
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void d(ECUIPromotion r2) {
        Intrinsics.checkNotNullParameter(r2, "uiPromotion");
        q().d(r2);
        this.d.b(r2.getPromotionId());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void e(boolean r2) {
        if (this.i == false) goto L8;
        if (r2 == false) goto L8;
        if (s() == true) goto L8;
        return;
    L8:
        q().e(r2);
    }

    @Override // uk2.a
    public final void i(ECLiveCardPanelType r5) {
        Intrinsics.checkNotNullParameter(r5, "firstPanel");
        u("onHoverShow");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_CARD_OBSCURED_EXTEND_TIME() > 0) goto L5;
        return;
    L5:
        if (t() == true) goto L26;
        ExplainCardViewModel r6 = this.o.j();
        String r0 = null;
        if (r6 == null) goto L11;
        QLiveData<ECUIPromotion> r7 = r6.getPromotionState();
        if (r7 == null) goto L11;
        ECUIPromotion r8 = (ECUIPromotion) r7.a();
    L12:
        if (r8 == null) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L27;
        ExplainCardViewModel r10 = this.o.j();
        if (r10 == null) goto L23;
        QLiveData<ECUIPromotion> r11 = r10.getPromotionState();
        if (r11 == null) goto L23;
        ECUIPromotion r12 = (ECUIPromotion) r11.a();
        if (r12 == null) goto L23;
        r0 = r12.getPromotionId();
    L23:
        this.e = r0;
        return;
    L27:
        return;
    L14:
        r9 = false;
    L11:
        r8 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void j(ECUIPromotion r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getPromotionId();
    L7:
        if (Intrinsics.areEqual(r1, this.g) == false) goto L9;
        this.h++;
    L12:
        if (r4 == null) goto L15;
        r4.appendExtraEventParams("card_pop_times", String.valueOf(this.h));
    L15:
        if (r() == false) goto L20;
        cl.d r5 = k.a();
        if (r5 == null) goto L21;
        r5.m();
        return;
    L21:
        return;
    L20:
        return;
    L9:
        if (r4 == null) goto L11;
        r0 = r4.getPromotionId();
    L11:
        this.g = r0;
        this.h = 1;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void k(boolean r3) {
        a.b.b(r3);
        if (this.i == false) goto L6;
        this.l = 0;
        this.j = false;
        this.k = null;
        this.m = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void m(ECLiveCardPanelType r3) {
        Intrinsics.checkNotNullParameter(r3, "panelType");
        Intrinsics.checkNotNullParameter(r3, "panelType");
        u("explain card open panel " + r3);
    }

    public final void u(String r3) {
        vk2.a r0 = this.r;
        r0.getClass();
        dm.a.b r1 = dm.a.a;
        dm.a.a(r0.a).i(r3);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void g(String r6, ECHotAtmosphere r7) {
        StringBuilder r0 = new StringBuilder("onHotSaleChanged, id=");
        r0.append(r6);
        r0.append(", type=");
        String r1 = null;
        if (r7 == null) goto L5;
        Integer r2 = Integer.valueOf(r7.type);
    L6:
        r0.append(r2);
        r0.append(", num=");
        if (r7 == null) goto L9;
        r1 = r7.num;
    L9:
        r0.append(r1);
        u(r0.toString());
        ECLiveABUtils r8 = ECLiveABUtils.INSTANCE;
        if (r8.getEC_LIVE_CARD_OBSCURED_EXTEND_TIME() <= 0) goto L15;
        if (t() == true) goto L15;
        this.o.q(r6, r8.getEC_LIVE_CARD_HOT_ATMOSPHERE_EXTEND_TIME());
    L15:
        if (r() == false) goto L20;
        cl.d r9 = k.a();
        if (r9 == null) goto L21;
        r9.m();
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void p(b r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "message");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_CARD_OBSCURED_EXTEND_TIME() <= 0) goto L12;
        ECExplainCardLiveDialogHoverManager r0 = this.c;
        if (r0 == null) goto L7;
        int r1 = ((ArrayList) r0.b).size();
    L8:
        if (r1 <= 0) goto L12;
        if (t() == true) goto L12;
        this.e = null;
        goto L12
    L7:
        r1 = 0;
    L12:
        q().p(r8, r9);
        if (this.i == false) goto L24;
        if (r9 == true) goto L16;
        return;
    L16:
        if (this.j == false) goto L26;
        long r10 = r8.c;
        Long r2 = this.k;
        if (r2 != null) goto L21;
        return;
    L21:
        if (r10 != r2.longValue()) goto L27;
        this.j = false;
        this.k = null;
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void v(boolean r7, long r8) {
        Long r0 = this.m;
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
        int r2 = f.a;
        long r3 = SystemClock.elapsedRealtime() - r1;
        int r4 = this.l;
        f.a().a("listShowDuration=" + r3 + ", isCardShowing=" + r7 + ", appearCount=" + r4 + ", showDuration=" + r8);
        com.bytedance.android.livesdk.livecommerce.event.n r5 = new com.bytedance.android.livesdk.livecommerce.event.n();
        r5.e("list_show_duration", r3);
        r5.f("is_existed_card_showing", String.valueOf(r7));
        r5.d("count_msg_appear", r4);
        r5.e("show_duration", r8);
        r5.k();
    L5:
        this.m = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void b(b r8, boolean r9, Function1<? super ECUIPromotion, Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        ECV2PopMsgProductInfo r11 = r8.e;
        if (r11 == null) goto L17;
        long r2 = r11.explainTime;
        ECV2PopMsgProductInfo r4 = this.n;
        if (r4 == null) goto L7;
        long r5 = r4.explainTime;
    L9:
        if (r2 < r5) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r11 = null;
    L15:
        if (r11 == null) goto L17;
        this.n = r11;
        goto L17
    L11:
        r3 = false;
        goto L12
    L7:
        r5 = 0;
    L17:
        if (r9 == false) goto L32;
        if (this.i == false) goto L32;
        ExplainCardViewModel r12 = this.o.j();
        if (r12 == null) goto L29;
        QLiveData<ECUIPromotion> r13 = r12.getPromotionState();
        if (r13 == null) goto L29;
        ECUIPromotion r14 = (ECUIPromotion) r13.a();
        if (r14 == null) goto L29;
        f.a().i("Recv appear msg while card showing, " + r14.getPromotionId() + " / " + r8.c + ", try hide card.");
        if ((!Intrinsics.areEqual(r14.getPromotionId(), String.valueOf(r8.c))) == false) goto L29;
        this.o.k(null, r14.getPromotionId(), true);
    L29:
        this.l++;
        this.j = true;
        this.k = Long.valueOf(r8.c);
        return;
    L32:
        if (this.d.a(String.valueOf(r8.c)) == false) goto L34;
    L37:
        q().b(r8, r9, new CustomExplainCardShowStrategy$onReceiveCardAppearMsg$4(this));
        return;
    L34:
        if (t() == true) goto L37;
        u("card " + r8.c + " cannot be displayed, because of the control of display frequency.");
    }

    @Override // uk2.a
    public final void f(int r4, int r5, ECLiveCardPanelType r6) {
        Intrinsics.checkNotNullParameter(r6, "panelType");
        u("onDialogCountChanged from " + r4 + " to " + r5);
        Intrinsics.checkNotNullParameter(r6, "panelType");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void l(f0 r2, boolean r3, boolean r4, Function1<? super ECUIPromotion, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (this.i == false) goto L8;
        if (r3 == false) goto L8;
        if (s() == true) goto L8;
        return;
    L8:
        q().l(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void n(e0 r2, boolean r3, boolean r4, Function2<? super ECUIPromotion, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (this.i == false) goto L8;
        if (r3 == false) goto L8;
        if (s() == true) goto L8;
        return;
    L8:
        q().n(r2, r3, r4, new CustomExplainCardShowStrategy$onReceiveProductRefreshMsg$1(this));
    }

    public CustomExplainCardShowStrategy(Context r10, i r11, g r12, String r13, n r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r14, "explainCardController");
        this.r = new vk2.a("Show");
        this.o = r11;
        this.p = r13;
        this.q = r14;
        DefaultCardShowStrategy r4 = new DefaultCardShowStrategy(r11, r12, r13, r14);
        this.b = r4;
        ECLiveABUtils r15 = ECLiveABUtils.INSTANCE;
        ExplainCardPopStrategyConfig r16 = r15.getEC_LIVE_CARD_POPUP_STRATEGY();
        boolean r0 = false;
        if (r16 == null) goto L5;
        int r17 = r16.getCardContinuousControl();
    L6:
        tk2.a r7 = new tk2.a(r17);
        this.d = r7;
        if (r15.getLIVE_CARD_SHOW_OPT_TYPE() != 2) goto L9;
        boolean r18 = true;
    L10:
        this.i = r18;
        ExplainCardPopStrategyConfig r19 = r15.getEC_LIVE_CARD_POPUP_STRATEGY();
        if (r19 == null) goto L13;
        Integer r110 = Integer.valueOf(r19.getCardPopupType());
    L15:
        if (r110 != null) goto L18;
    L20:
        if (r110 != null) goto L23;
    L25:
        if (r110 != null) goto L28;
    L44:
        if (t() == false) goto L46;
    L48:
        if (r0 == false) goto L51;
        ECExplainCardLiveDialogHoverManager r111 = new ECExplainCardLiveDialogHoverManager(r10);
        r14.k = r111;
        Intrinsics.checkNotNullParameter(this, "listener");
        r111.c.add(this);
        Unit r112 = Unit.INSTANCE;
        this.c = r111;
        return;
    L51:
        return;
    L46:
        if (r15.getEC_LIVE_CARD_OBSCURED_EXTEND_TIME() <= 0) goto L48;
        r0 = true;
        goto L48
    L28:
        if (r110.intValue() != 5) goto L44;
    L30:
        if (t() == true) goto L44;
        ExplainCardPopStrategyConfig r5 = r15.getEC_LIVE_CARD_POPUP_STRATEGY();
        if (r5 == null) goto L44;
        ok2.a r6 = r5.getAutoPopConfig();
        if (r6 == null) goto L44;
        u("start auto host strategy, cardPopupType = " + r110);
        if (r110.intValue() != 2) goto L38;
    L41:
        boolean r8 = true;
    L42:
        this.f = new QueryWithMsgCacheCardShowStrategy(r10, r4, r11, r6, r7, r8);
        goto L44
    L38:
        if (r110.intValue() == 5) goto L41;
        r8 = false;
        goto L42
    L23:
        if (r110.intValue() != 2) goto L25;
    L18:
        if (r110.intValue() != 1) goto L20;
    L13:
        r110 = null;
        goto L15
    L9:
        r18 = false;
        goto L10
    L5:
        r17 = 0;
        goto L6
    }
}
