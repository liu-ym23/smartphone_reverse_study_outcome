package com.bytedance.bdnavigationsdk.navigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h a(com.bytedance.bdnavigationsdk.network.route.t r9, Float r10) {
        int r0 = r9.b;
        if (r0 != 1) goto L5;
    L15:
        int r3 = 1;
    L17:
        return new h(r3, r9.c, r9.d, r9.e, r10, r9.f);
    L5:
        if (r0 != 2) goto L7;
    L14:
        r3 = 0;
        goto L17
    L7:
        if (r0 == 3) goto L13;
        int r1 = r9.c;
        if (r1 == 0) goto L15;
        if (r1 == 5) goto L15;
    L13:
        r3 = 2;
        goto L17
    }

    public static h b(List r9, float r10) {
        if (r9 != null) goto L5;
    L67:
        com.bytedance.bdnavigationsdk.network.route.t r3 = null;
    L68:
        if (r3 != null) goto L71;
        return null;
    L71:
        return a(r3, Float.valueOf(r10));
    L5:
        if ((!r9.isEmpty()) == true) goto L8;
        r9 = null;
    L8:
        if (r9 == null) goto L67;
        List r11 = r9;
        ArrayList r1 = new ArrayList();
        Iterator r4 = r11.iterator();
    L11:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L20;
        Object r6 = r4.next();
        com.bytedance.bdnavigationsdk.network.route.t r7 = (com.bytedance.bdnavigationsdk.network.route.t) r6;
        if (r7.b == 3) goto L16;
    L18:
        if (r5 == true) goto L11;
        r1.add(r6);
        goto L11
    L16:
        if (r7.a != 0) goto L18;
        r5 = true;
        goto L18
    L20:
        ArrayList r8 = new ArrayList();
        Iterator r2 = r1.iterator();
    L22:
        if (r2.hasNext() == false) goto L29;
        Object r12 = r2.next();
        if (r10 > ((com.bytedance.bdnavigationsdk.network.route.t) r12).a) goto L26;
        boolean r13 = true;
    L27:
        if (r13 == false) goto L22;
        r8.add(r12);
        goto L22
    L26:
        r13 = false;
        goto L27
    L29:
        Iterator r14 = r8.iterator();
        if (r14.hasNext() == true) goto L32;
        Object r15 = null;
    L41:
        r3 = (com.bytedance.bdnavigationsdk.network.route.t) r15;
        if (r3 != null) goto L68;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r11.iterator();
    L45:
        if (r17.hasNext() == false) goto L54;
        Object r18 = r17.next();
        com.bytedance.bdnavigationsdk.network.route.t r19 = (com.bytedance.bdnavigationsdk.network.route.t) r18;
        if (r19.b == 3) goto L49;
    L51:
        boolean r20 = false;
    L52:
        if (r20 == true) goto L45;
        r16.add(r18);
        goto L45
    L49:
        if (r19.a != 0) goto L51;
        r20 = true;
        goto L52
    L54:
        Iterator r21 = r16.iterator();
        if (r21.hasNext() == true) goto L57;
        Object r22 = null;
    L66:
        r3 = (com.bytedance.bdnavigationsdk.network.route.t) r22;
        goto L68
    L57:
        r22 = r21.next();
        if (r21.hasNext() == false) goto L66;
        int r23 = ((com.bytedance.bdnavigationsdk.network.route.t) r22).a;
    L61:
        Object r24 = r21.next();
        int r25 = ((com.bytedance.bdnavigationsdk.network.route.t) r24).a;
        if (r23 >= r25) goto L65;
        r22 = r24;
        r23 = r25;
    L65:
        if (r21.hasNext() == true) goto L61;
    L32:
        r15 = r14.next();
        if (r14.hasNext() == false) goto L41;
        int r26 = ((com.bytedance.bdnavigationsdk.network.route.t) r15).a;
    L36:
        Object r27 = r14.next();
        int r28 = ((com.bytedance.bdnavigationsdk.network.route.t) r27).a;
        if (r26 <= r28) goto L40;
        r15 = r27;
        r26 = r28;
    L40:
        if (r14.hasNext() == true) goto L36;
        goto L41
    }
}
