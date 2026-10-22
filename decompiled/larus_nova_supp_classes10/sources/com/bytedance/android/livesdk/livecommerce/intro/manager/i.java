package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.controller.IntroAuctionWidgetController;
import com.bytedance.android.livesdk.livecommerce.intro.controller.IntroCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.intro.message.IntroCardMessageListener;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntro;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements c, d {
    public final h a;
    public final u b;
    public final IntroCardAnimController c;
    public final SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> d;
    public boolean e;
    public a f;
    public final j g;
    public final l h;
    public final com.bytedance.android.livesdk.livecommerce.intro.event.j i;
    public final IntroManagerViewModel j;
    public final com.bytedance.android.livesdk.livecommerce.room.model.e k;
    public final RoomContextController l;
    public final q m;

    public static final class a {
        public final String a;
        public final String b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.c;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "OpenPriceAnimationExecution(promotionId=" + this.a + ", productId=" + this.b + ", executionKey=" + this.c + ")";
        }

        public a() {
            this.a = null;
            this.b = null;
            this.c = 0;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.d
    public final void i(int r2, Runnable r3) {
        this.m.i(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final List<uh2.a> b() {
        uh2.c r0 = this.j.getIntroVOLiveData().a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final Integer j() {
        uh2.c r0 = this.j.getIntroVOLiveData().a();
        if (r0 == null) goto L9;
        List<uh2.a> r1 = r0.a;
        if (r1 == null) goto L9;
        uh2.a r2 = (uh2.a) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L9;
        return Integer.valueOf(r2.getIntroType());
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final com.bytedance.android.livesdk.livecommerce.intro.event.j c() {
        return this.i;
    }

    public static Pair k(uh2.a r1) {
        if ((r1 instanceof IntroPromotionVO) == false) goto L6;
        IntroPromotionVO r2 = (IntroPromotionVO) r1;
        return TuplesKt.to(r2.getPromotionId(), r2.getCardReqScene());
    L6:
        if ((r1 instanceof IntroAuctionPromotionVO) == false) goto L8;
        IntroAuctionPromotionVO r3 = (IntroAuctionPromotionVO) r1;
        return TuplesKt.to(r3.getPromotionId(), r3.getCardReqScene());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final boolean a(Integer r5) {
        if (r5 != null) goto L10;
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r6 = this.d;
        int r1 = r6.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L18;
        if (r6.valueAt(r2).i() == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L18:
        return false;
    L10:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b r7 = this.d.get(r5.intValue());
        if (r7 != null) goto L13;
        return false;
    L13:
        return r7.i();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void d(LiveIntroResponse r11) {
        if (this.f == null) goto L5;
        return;
    L5:
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r0 = this.d;
        int r1 = r0.size();
        boolean r2 = false;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        if (r0.valueAt(r3).i() == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        r2 = true;
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        if (r11 == null) goto L26;
        List<LiveIntro> r4 = r11.getIntros();
        if (r4 != null) goto L18;
        return;
    L18:
        if ((!r4.isEmpty()) == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L28;
        IntroManagerViewModel.handleIntroResp$default(this.j, r11, IntroCardScene.REFRESH_MESSAGE, null, false, false, false, 56, null);
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void f(List<? extends uh2.a> r6) {
        if (this.f == null) goto L5;
        return;
    L5:
        uh2.c r0 = this.j.getIntroVOLiveData().a();
        IntroPromotionVO r1 = null;
        if (r0 == null) goto L17;
        List<uh2.a> r2 = r0.a;
        if (r2 == null) goto L17;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if ((((uh2.a) r4) instanceof IntroPromotionVO) == false) goto L11;
    L16:
        uh2.a r5 = (uh2.a) r4;
    L19:
        if ((r5 instanceof IntroPromotionVO) == true) goto L21;
        r5 = null;
    L21:
        IntroPromotionVO r7 = (IntroPromotionVO) r5;
        Iterator<T> r8 = r6.iterator();
    L23:
        if (r8.hasNext() == false) goto L27;
        Object r9 = r8.next();
        if ((((uh2.a) r9) instanceof IntroPromotionVO) == false) goto L23;
    L28:
        uh2.a r10 = (uh2.a) r9;
        if ((r10 instanceof IntroPromotionVO) == true) goto L31;
        r10 = null;
    L31:
        IntroPromotionVO r11 = (IntroPromotionVO) r10;
        if (r11 == null) goto L49;
        String r12 = r11.getPromotionId();
        if (r7 == null) goto L36;
        String r13 = r7.getPromotionId();
    L38:
        if (Intrinsics.areEqual(r12, r13) == false) goto L40;
        r1 = r11;
    L40:
        if (r1 == null) goto L50;
        this.j.updateIntroVOs(r6);
        return;
    L50:
        return;
    L36:
        r13 = null;
        goto L38
    L49:
        return;
    L27:
        r9 = null;
        goto L28
    L15:
        r4 = null;
    L17:
        r5 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final boolean h(sh2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "popMessageContext");
        return l(IntroCardScene.POP_MESSAGE, r2);
    }

    public final boolean l(IntroCardScene r5, sh2.a r6) {
        if (this.f != null) goto L6;
        return false;
    L6:
        if (r5 != IntroCardScene.ACTION) goto L9;
        return false;
    L9:
        if (r6 == null) goto L25;
        Integer r2 = r6.b;
        if (r2 != null) goto L14;
    L15:
        Integer r3 = r6.b;
        if (r3 != null) goto L19;
    L21:
        boolean r4 = false;
    L23:
        if (r4 != true) goto L25;
        boolean r7 = true;
    L27:
        if (r5 != IntroCardScene.POP_MESSAGE) goto L36;
        if (r6 != null) goto L30;
    L31:
        if (r6 == null) goto L36;
        if (r6.a != 1) goto L36;
    L34:
        if (r7 == true) goto L36;
        boolean r8 = true;
    L37:
        if (r8 == false) goto L40;
        this.f = null;
        return false;
    L40:
        return true;
    L30:
        if (r6.a == 0) goto L34;
    L36:
        r8 = false;
        goto L37
    L19:
        if (r3.intValue() != 2) goto L21;
    L22:
        r4 = true;
        goto L23
    L14:
        if (r2.intValue() == 1) goto L22;
    L25:
        r7 = false;
        goto L27
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void g(String r13, String r14, boolean r15) {
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r0 = this.d;
        int r1 = r0.size();
        boolean r2 = false;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        if (r0.valueAt(r3).n() == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        return;
    L13:
        if (r15 == false) goto L44;
        uh2.c r16 = this.j.getIntroVOLiveData().a();
        if (r16 == null) goto L35;
        List<uh2.a> r17 = r16.a;
        if (r17 == null) goto L35;
        Iterator<T> r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L33;
        Object r5 = r18.next();
        Pair r6 = k((uh2.a) r5);
        if (r6 == null) goto L24;
        String r7 = (String) r6.getFirst();
    L25:
        if (r14 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == false) goto L20;
    L34:
        uh2.a r9 = (uh2.a) r5;
    L36:
        if (r9 == null) goto L38;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b r10 = this.d.get(r9.getIntroType());
    L39:
        if (r10 != null) goto L42;
        int r19 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[cancelIntroCard] ignore stale pop cancel, promotionId=" + r14);
        return;
    L42:
        this.f = null;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(r10, r13, r14, true, false, 8);
        return;
    L38:
        r10 = null;
        goto L39
    L27:
        if (Intrinsics.areEqual(r14, r7) == true) goto L30;
        r8 = false;
        goto L31
    L24:
        r7 = null;
        goto L25
    L33:
        r5 = null;
    L35:
        r9 = null;
        goto L36
    L44:
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r110 = this.d;
        int r11 = r110.size();
        int r12 = 0;
    L45:
        if (r12 >= r11) goto L47;
        r110.keyAt(r12);
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(r110.valueAt(r12), r13, r14, false, false, 8);
        r12 = r12 + 1;
        goto L45
    L47:
        a r111 = this.f;
        if (r111 == null) goto L70;
        if (r13 != null) goto L51;
    L52:
        if (r14 != null) goto L54;
    L55:
        r2 = true;
    L56:
        if (r2 == true) goto L59;
        r111 = null;
    L59:
        if (r111 == null) goto L71;
        this.f = null;
        return;
    L71:
        return;
    L54:
        if (Intrinsics.areEqual(r14, r111.a) == false) goto L56;
    L51:
        if (Intrinsics.areEqual(r13, r111.b) == false) goto L56;
    L70:
        return;
    L9:
        r4 = false;
        goto L10
    }

    public i(Context r25, com.bytedance.android.livesdk.livecommerce.room.model.g r26, LiveRoomParams r27, RoomContextController r28, qh2.d.b r29, qh2.b r30, qh2.c r31) {
        q r1 = new q();
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r26, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r28, "roomContextController");
        Intrinsics.checkNotNullParameter(r29, "btmInfo");
        Intrinsics.checkNotNullParameter(r1, "cardQueue");
        Intrinsics.checkNotNullParameter(r30, "introCardWidget");
        Intrinsics.checkNotNullParameter(r31, "widgetCallback");
        this.k = r26;
        this.l = r28;
        this.m = r1;
        u r8 = new u(r31, new IntroCardManager$animDelegate$1(this));
        this.b = r8;
        IntroCardAnimController r7 = new IntroCardAnimController(r28, r8);
        this.c = r7;
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r6 = new SparseArray();
        this.d = r6;
        j r5 = new j(this);
        this.g = r5;
        l r4 = new l(this);
        this.h = r4;
        if (r27 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.intro.event.j r0 = new com.bytedance.android.livesdk.livecommerce.intro.event.j(r27);
    L6:
        com.bytedance.android.livesdk.livecommerce.intro.event.j r3 = r0;
        this.i = r3;
        r r2 = new r();
        h r9 = new h(this, r25);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r10 = Unit.INSTANCE;
        this.a = r9;
        IntroManagerViewModel r11 = new IntroManagerViewModel(r2, r26, r27, r28);
        this.j = r11;
        k r12 = new k(this);
        IntroCardWidgetController r13 = new IntroCardWidgetController(r25, r28, r26, r27, r9, r29, this, r7, r8, r3, r30, r12);
        r6.put(r13.a, r13);
        IntroAuctionWidgetController r14 = new IntroAuctionWidgetController(r25, r28, r26, r27, r9, r29, this, r7, r8, r30, r12);
        r6.put(r14.a, r14);
        bk2.e<uh2.c> r15 = r11.getIntroVOLiveData();
        ECContext r16 = r28.r();
        if (r16 == null) goto L13;
        com.bytedance.live.datacontext.i<LiveRoomLifecycleOwner> r17 = r16.getLifecycleOwner();
        if (r17 == null) goto L13;
        LiveRoomLifecycleOwner r18 = (LiveRoomLifecycleOwner) r17.getValue();
        if (r18 == null) goto L13;
    L14:
        r15.b(r18, new p(this));
        if (this.e == true) goto L18;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r19 = r28.A().q;
        r19.g = new IntroCardMessageListener(r25, r26, r28, this, r2);
        Lazy r20 = LiveEventCenter.b;
        LiveEventCenter.a.a().b(r4);
        this.e = true;
    L18:
        r28.A().q.i = this;
        ECLiveHybridUtil.m("closeExplainCard", r5);
        return;
    L13:
        r18 = ECQuickUtilKt.b;
        goto L14
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void e(IntroCardScene r11, Pair<Long, Long> r12, sh2.b r13, String r14, Map<String, String> r15, Function2<? super LiveIntroResponse, ? super List<? extends uh2.a>, Unit> r16, sh2.a r17) {
        Intrinsics.checkNotNullParameter(r11, "cardScene");
        if (l(r11, r17) == false) goto L6;
        int r1 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[createIntroCard] filter refresh during open price animation, scene=" + r11);
        return;
    L6:
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r3 = this.d;
        int r4 = r3.size();
        int r6 = 0;
    L7:
        boolean r7 = true;
        if (r6 >= r4) goto L13;
        if (r3.valueAt(r6).n() == true) goto L11;
        r6 = r6 + 1;
        goto L7
    L11:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
    L18:
        com.bytedance.android.livesdk.livecommerce.intro.event.j r8 = this.i;
        if (r8 != null) goto L21;
    L27:
        IntroManagerViewModel r9 = this.j;
        if (r17 == null) goto L44;
        Integer r10 = r17.b;
        if (r10 != null) goto L33;
    L34:
        Integer r2 = r17.b;
        if (r2 != null) goto L38;
    L40:
        boolean r18 = false;
    L42:
        if (r18 != true) goto L44;
    L45:
        r9.queryIntro(r11, r12, r13, r14, r15, r7, r16);
        return;
    L38:
        if (r2.intValue() != 2) goto L40;
    L41:
        r18 = true;
        goto L42
    L33:
        if (r10.intValue() == 1) goto L41;
    L44:
        r7 = false;
        goto L45
    L21:
        if (sh2.f.b(r11) == true) goto L23;
        String r19 = "enter_room";
    L24:
        v r20 = new v("livesdk_popup_card_request_show", r8.d);
        r20.c("from_scene", r19);
        Unit r21 = Unit.INSTANCE;
        if (r8.c == false) goto L27;
        r20.i(null);
        goto L27
    L23:
        r19 = "message";
        goto L24
    L16:
        if (r11 == IntroCardScene.ACTION) goto L18;
        return;
    L13:
        r5 = false;
        goto L14
    }
}
