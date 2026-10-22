package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.util.LruCache;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r extends a {
    public final LruCache<String, Long> e;

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean d() {
        return !ECLiveABUtils.INSTANCE.getECOM_LIVE_MESSAGE_NO_LOGIN().booleanValue();
    }

    public r(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(true);
        this.e = new LruCache(100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r14) {
        Intrinsics.checkNotNullParameter(r14, "message");
        boolean r1 = false;
        if ((r14 instanceof si2.e0) == true) goto L5;
        return false;
    L5:
        si2.e0 r15 = (si2.e0) r14;
        String r2 = null;
        if (r15.actionType != 3) goto L25;
        sg2.v r0 = new sg2.v("livesdk_hot_atmosphere_message_received", com.bytedance.android.ec.common.api.jump.model.b.a);
        sg2.b r4 = r15.getCommon();
        String r5 = "NoValue";
        if (r4 == null) goto L11;
        String r6 = r4.a;
        if (r6 == null) goto L11;
    L12:
        r0.c("message_id", r6);
        ECV2HotAtmosphere r7 = r15.hotAtmosphere;
        if (r7 == null) goto L16;
        String r8 = ((ECHotAtmosphere) r7).num;
        if (r8 == null) goto L16;
    L17:
        r0.c("hot_sale_num", r8);
        ECV2HotAtmosphere r9 = r15.hotAtmosphere;
        if (r9 == null) goto L23;
        String r10 = r9.getTypeStr();
        if (r10 == null) goto L23;
        r5 = r10;
    L23:
        r0.c("hot_sale_type", r5);
        r0.b("promotion_id", r15.promotionId);
        r0.c("use_new_message", "1");
        r0.c("handled", BDLocationException.ERROR_TIMEOUT);
        r0.i(null);
    L16:
        r8 = "NoValue";
    L11:
        r6 = "NoValue";
    L25:
        if (EComABUtils.useNewProductRefreshMessage() != 1) goto L34;
        int r3 = r15.actionType;
        if (r3 != 1) goto L29;
    L33:
        boolean r11 = true;
    L35:
        if (r11 == false) goto L37;
    L46:
        long r12 = r15.promotionId;
        int r13 = r15.actionType;
        sg2.b r16 = r15.getCommon();
        if (r16 == null) goto L49;
        String r17 = r16.e;
    L50:
        String r18 = r12 + '_' + r13 + '_' + String.valueOf(r17);
        if (r13 == 4) goto L53;
    L55:
        long r19 = r15.updateTs;
        Long r20 = this.e.get(r18);
        if (r20 == null) goto L58;
        long r110 = r20.longValue();
    L60:
        if (r19 > r110) goto L62;
        if (r1 == true) goto L62;
    L91:
        return true;
    L62:
        this.e.put(r18, Long.valueOf(r15.updateTs));
        lj2.a r21 = (lj2.a) b(lj2.a.class, r15);
        if (r21 == null) goto L65;
        r21.a(r15);
    L65:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o r22 = (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o) b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o.class, r15);
        if (r22 == null) goto L68;
        r22.a(r15);
    L68:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c r23 = (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c) b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c.class, r15);
        if (r23 == null) goto L71;
        r23.a(r15);
    L71:
        jk2.a r24 = (jk2.a) b(jk2.a.class, r15);
        if (r24 == null) goto L74;
        r24.c();
    L74:
        com.bytedance.android.livesdk.livecommerce.intro.message.a r25 = (com.bytedance.android.livesdk.livecommerce.intro.message.a) b(com.bytedance.android.livesdk.livecommerce.intro.message.a.class, r15);
        if (r25 == null) goto L78;
        r25.c(r15);
    L78:
        if (ECLiveABUtils.INSTANCE.getECOM_DETAIL_SHOW_HOT_ATMOSPHERE().booleanValue() == false) goto L91;
        if (r13 != 3) goto L91;
        j r26 = (j) b(j.class, r15);
        if (r26 == null) goto L91;
        sg2.b r27 = r15.getCommon();
        if (r27 == null) goto L85;
        r2 = r27.e;
    L85:
        List<com.bytedance.android.ec.model.live.r> r28 = r26.a(r2);
        if (r28 == null) goto L91;
        Iterator<T> r29 = r28.iterator();
    L89:
        if (r29.hasNext() == false) goto L91;
        ((com.bytedance.android.ec.model.live.r) r29.next()).g(String.valueOf(r12), r15.hotAtmosphere);
        goto L89
    L58:
        r110 = 0;
        goto L60
    L53:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_AUCTION_REFRESH_RATE_LIMIT() == true) goto L55;
        r1 = true;
        goto L55
    L49:
        r17 = null;
        goto L50
    L37:
        if (EComABUtils.useNewProductRefreshMessageAtmosphere() == false) goto L43;
        int r30 = r15.actionType;
        if (r30 != 3) goto L41;
    L42:
        boolean r31 = true;
    L44:
        if (r31 == true) goto L46;
    L41:
        if (r30 == 6) goto L42;
    L43:
        r31 = false;
        goto L44
    L29:
        if (r3 == 2) goto L33;
        if (r3 == 4) goto L33;
        if (r3 == 5) goto L33;
    L34:
        r11 = false;
        goto L35
    }
}
