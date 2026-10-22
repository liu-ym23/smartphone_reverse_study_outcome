package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s extends a {
    public com.bytedance.android.livesdk.livecommerce.room.model.e e;
    public final RealRoomController f;

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean d() {
        return !ECLiveABUtils.INSTANCE.getECOM_LIVE_MESSAGE_NO_LOGIN().booleanValue();
    }

    public s(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(true);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r12) {
        Intrinsics.checkNotNullParameter(r12, "message");
        if ((r12 instanceof si2.a0) == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o r0 = (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o) b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o.class, r12);
        com.bytedance.android.livesdk.livecommerce.intro.message.a r2 = (com.bytedance.android.livesdk.livecommerce.intro.message.a) b(com.bytedance.android.livesdk.livecommerce.intro.message.a.class, r12);
        com.bytedance.android.livesdk.livecommerce.room.model.e r3 = this.e;
        if (r3 != null) goto L8;
    L63:
        return false;
    L8:
        if (r3.isAnchor() == true) goto L63;
        jk2.a r4 = (jk2.a) b(jk2.a.class, r12);
        if (r4 == null) goto L12;
        si2.a0 r5 = (si2.a0) r12;
        r4.a();
    L12:
        si2.a0 r13 = (si2.a0) r12;
        int r6 = r13.msgType;
        String r9 = null;
        if (r6 != 0) goto L38;
        int r7 = com.bytedance.android.livesdk.livecommerce.kmp.a.a;
        Intrinsics.checkNotNullParameter("pop_card_message", "scene");
        JSONObject r8 = new JSONObject();
        r8.put("is_change", 1);
        Unit r10 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.explainCard.change", r8);
        if (this.f.l() == false) goto L17;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r11 = this.f.q;
    L25:
        dm.a.b r14 = dm.a.a;
        dm.a.a("isCanChangeExplainCard = " + r11.m);
        if (r11.m == false) goto L63;
        if (r0 == null) goto L29;
        int r15 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.g;
        r0.j(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.a.a(r13));
    L29:
        if (r2 == null) goto L31;
        int r1 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.g;
        r2.a(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.a.a(r13));
    L31:
        String.valueOf(r13.promotionId);
        ECV2PopMsgProductInfo r16 = r13.productInfo;
        if (r16 == null) goto L34;
        String.valueOf(r16.productId);
    L34:
        Intrinsics.checkNotNullParameter(new cf.v(), "params");
        Iterator r17 = ((ArrayList) r11.l).iterator();
    L36:
        if (r17.hasNext() == false) goto L63;
        ((cf.g) r17.next()).a();
        goto L36
    L17:
        int r18 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        com.bytedance.android.livesdk.livecommerce.room.model.e r19 = this.e;
        if (r19 == null) goto L20;
        String r20 = r19.roomId();
    L21:
        com.bytedance.android.livesdk.livecommerce.room.model.e r21 = this.e;
        if (r21 == null) goto L24;
        r9 = r21.a();
    L24:
        r11 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r20, r9);
        goto L25
    L20:
        r20 = null;
        goto L21
    L38:
        if (r6 != 1) goto L63;
        JSONObject r22 = new JSONObject();
        r22.put("is_change", 1);
        Unit r23 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.explainCard.change", r22);
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L42;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r24 = this.f.q;
    L50:
        dm.a.b r25 = dm.a.a;
        dm.a.a("isCanChangeExplainCard = " + r24.m);
        if (r24.m == false) goto L63;
        if (r0 == null) goto L54;
        int r26 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.g;
        r0.k(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.a.a(r13));
    L54:
        if (r2 == null) goto L56;
        int r27 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.g;
        r2.b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b.a.a(r13));
    L56:
        String.valueOf(r13.promotionId);
        ECV2PopMsgProductInfo r110 = r13.productInfo;
        if (r110 == null) goto L59;
        String.valueOf(r110.productId);
    L59:
        Intrinsics.checkNotNullParameter(new cf.v(), "params");
        Iterator r111 = ((ArrayList) r24.l).iterator();
    L61:
        if (r111.hasNext() == false) goto L63;
        ((cf.g) r111.next()).a();
        goto L61
    L42:
        int r28 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        com.bytedance.android.livesdk.livecommerce.room.model.e r29 = this.e;
        if (r29 == null) goto L45;
        String r30 = r29.roomId();
    L46:
        com.bytedance.android.livesdk.livecommerce.room.model.e r31 = this.e;
        if (r31 == null) goto L49;
        r9 = r31.a();
    L49:
        r24 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r30, r9);
        goto L50
    L45:
        r30 = null;
        goto L46
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        com.bytedance.android.livesdk.livecommerce.room.j r3 = this.a;
        if (r3 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.room.model.g r4 = r3.c();
    L6:
        this.e = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
