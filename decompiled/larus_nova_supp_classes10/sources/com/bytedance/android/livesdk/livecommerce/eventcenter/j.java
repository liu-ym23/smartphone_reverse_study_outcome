package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements d.a {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d.a
    public final void a(String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Object r3 = null;
        if (Intrinsics.areEqual(r12, "product_click") == false) goto L67;
        if ((r13 instanceof lh2.b) == false) goto L9;
        r3 = r13;
    L9:
        if (((lh2.b) r3) == null) goto L115;
        int r14 = k.a;
        lh2.b r15 = (lh2.b) r13;
        String r16 = r15.a;
        String r0 = r15.b;
        ql.a r4 = r15.c;
        int r17 = r15.d;
        if (r17 == 3) goto L15;
        int r5 = ECSdk.a;
        IECAPTService r6 = (IECAPTService) ECSdk.a(IECAPTService.class);
        if (r6 == null) goto L15;
        r6.record(new si2.f(r4));
    L15:
        boolean r7 = false;
        if (r17 != 3) goto L36;
        int r8 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.utils.d r9 = RoomContextController.a.b(r16, r0).d;
        String r10 = r4.getProductId();
        r9.getClass();
        if (r10 != null) goto L20;
    L21:
        r7 = true;
    L22:
        if (r7 == true) goto L55;
        Map<String, com.bytedance.android.livesdk.livecommerce.room.utils.a> r11 = r9.b;
        com.bytedance.android.livesdk.livecommerce.room.utils.a r18 = (com.bytedance.android.livesdk.livecommerce.room.utils.a) ((LinkedHashMap) r11).get(r10);
        if (r18 != null) goto L27;
        r18 = new com.bytedance.android.livesdk.livecommerce.room.utils.a();
    L27:
        r18.d(System.currentTimeMillis());
        r18.c(r18.a() + 1);
        Unit r2 = Unit.INSTANCE;
        Iterator<com.bytedance.android.livesdk.livecommerce.room.utils.f> r19 = r9.e.iterator();
    L29:
        if (r19.hasNext() == false) goto L35;
        com.bytedance.android.livesdk.livecommerce.room.utils.f r20 = r19.next();
        if (r10 != null) goto L33;
        String r21 = "";
    L34:
        r20.b(r21, r18);
        goto L29
    L33:
        r21 = r10;
        goto L34
    L35:
        Unit r1 = Unit.INSTANCE;
        r11.put(r10, r18);
    L55:
        if (r17 == 3) goto L61;
        int r110 = ECSdk.a;
        b93.c r111 = (b93.c) ECSdk.a(b93.c.class);
        if (r111 == null) goto L61;
        b93.b r112 = r111.b();
        if (r112 == null) goto L61;
        r112.sendEvent("click_product", new JSONObject());
    L61:
        int r113 = RoomContextController.h;
        y r114 = RoomContextController.a.b(r16, r0).c;
        if (r114 == null) goto L64;
        r114.e(r4.getProductId());
    L64:
        if (r16 == null) goto L116;
        q.a r115 = q.e;
        String r22 = r4.getProductId();
        r115.getClass();
        q.a.a(r16, r22);
        return;
    L116:
        return;
    L20:
        if (r10.length() != 0) goto L22;
    L36:
        int r23 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.utils.d r24 = RoomContextController.a.b(r16, r0).d;
        String r25 = r4.getProductId();
        r24.getClass();
        if (r25 != null) goto L39;
    L40:
        r7 = true;
    L41:
        if (r7 == true) goto L55;
        Map<String, com.bytedance.android.livesdk.livecommerce.room.utils.a> r26 = r24.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.a r27 = (com.bytedance.android.livesdk.livecommerce.room.utils.a) ((LinkedHashMap) r26).get(r25);
        if (r27 != null) goto L46;
        r27 = new com.bytedance.android.livesdk.livecommerce.room.utils.a();
    L46:
        r27.d(System.currentTimeMillis());
        r27.c(r27.a() + 1);
        Unit r28 = Unit.INSTANCE;
        Iterator<com.bytedance.android.livesdk.livecommerce.room.utils.f> r29 = r24.e.iterator();
    L48:
        if (r29.hasNext() == false) goto L54;
        com.bytedance.android.livesdk.livecommerce.room.utils.f r30 = r29.next();
        if (r25 != null) goto L52;
        String r31 = "";
    L53:
        r30.b(r31, r27);
        goto L48
    L52:
        r31 = r25;
        goto L53
    L54:
        Unit r32 = Unit.INSTANCE;
        r26.put(r25, r27);
        goto L55
    L39:
        if (r25.length() != 0) goto L41;
    L115:
        return;
    L67:
        if (Intrinsics.areEqual(r12, "product_show") == false) goto L95;
        if ((r13 instanceof lh2.c) == true) goto L71;
        Object r116 = null;
    L73:
        if (((lh2.c) r116) == null) goto L118;
        int r117 = k.a;
        lh2.c r118 = (lh2.c) r13;
        String r119 = r118.a;
        String r33 = r118.b;
        ql.a r34 = r118.c;
        int r120 = r118.d;
        int r35 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.utils.d r36 = RoomContextController.a.b(r119, r33).d;
        String r37 = r34.getProductId();
        r36.getClass();
        if (cg4.a.a(r37) == false) goto L77;
        r3 = r37;
    L77:
        if (r3 == null) goto L90;
        Map<String, com.bytedance.android.livesdk.livecommerce.room.utils.h> r38 = r36.c;
        com.bytedance.android.livesdk.livecommerce.room.utils.h r39 = (com.bytedance.android.livesdk.livecommerce.room.utils.h) ((LinkedHashMap) r38).get(r3);
        if (r39 != null) goto L81;
        r39 = new com.bytedance.android.livesdk.livecommerce.room.utils.h();
    L81:
        r39.b(r39.a() + 1);
        Unit r40 = Unit.INSTANCE;
        Iterator<com.bytedance.android.livesdk.livecommerce.room.utils.f> r41 = r36.e.iterator();
    L83:
        if (r41.hasNext() == false) goto L89;
        com.bytedance.android.livesdk.livecommerce.room.utils.f r42 = r41.next();
        if (r37 != null) goto L87;
        String r121 = "";
    L88:
        r42.a(r121, r39);
        goto L83
    L87:
        r121 = r37;
        goto L88
    L89:
        Unit r43 = Unit.INSTANCE;
        r38.put((String) r3, r39);
    L90:
        if (r120 != 1) goto L119;
        int r122 = RoomContextController.h;
        y r123 = RoomContextController.a.b(r119, r33).c;
        if (r123 == null) goto L120;
        r123.a(r34.getProductId());
        return;
    L120:
        return;
    L119:
        return;
    L118:
        return;
    L71:
        r116 = r13;
        goto L73
    L95:
        if (Intrinsics.areEqual(r12, "product_add_cart") == true) goto L97;
        return;
    L97:
        if ((r13 instanceof lh2.a) == false) goto L101;
        r3 = r13;
    L101:
        if (((lh2.a) r3) == null) goto L123;
        int r124 = k.a;
        lh2.a r125 = (lh2.a) r13;
        String r126 = r125.a;
        ql.a r127 = r125.c;
        if (r126 == null) goto L124;
        q.a r44 = q.e;
        String r128 = r127.getProductId();
        r44.getClass();
        q.a.a(r126, r128);
        return;
    L124:
        return;
    }
}
