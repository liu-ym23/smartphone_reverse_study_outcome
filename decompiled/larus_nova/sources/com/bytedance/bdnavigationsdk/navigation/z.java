package com.bytedance.bdnavigationsdk.navigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200117a = 0;

    static {
    }

    public static h a(com.bytedance.bdnavigationsdk.network.route.t r100, Float r110) {
        int r101 = r100.f200283b;
        if (r101 != 1) goto L5;
    L15:
        int r102 = 1;
    L17:
        return new h(r102, r100.f200284c, r100.f200285d, r100.f200286e, r110, r100.f200287f);
    L5:
        if (r101 != 2) goto L7;
    L14:
        r102 = 0;
        goto L17
    L7:
        if (r101 == 3) goto L13;
        int r103 = r100.f200284c;
        if (r103 == 0) goto L15;
        if (r103 == 5) goto L15;
    L13:
        r102 = 2;
        goto L17
    }

    public static h b(List r100, float r110) {
        if (r100 != null) goto L5;
    L67:
        com.bytedance.bdnavigationsdk.network.route.t r101 = null;
    L68:
        if (r101 != null) goto L71;
        return null;
    L71:
        return a(r101, Float.valueOf(r110));
    L5:
        if ((!r100.isEmpty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L67;
        List r102 = r100;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L11:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L20;
        Object r106 = r104.next();
        com.bytedance.bdnavigationsdk.network.route.t r107 = (com.bytedance.bdnavigationsdk.network.route.t) r106;
        if (r107.f200283b == 3) goto L16;
    L18:
        if (r105 == true) goto L11;
        r103.add(r106);
        goto L11
    L16:
        if (r107.f200282a != 0) goto L18;
        r105 = true;
        goto L18
    L20:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r103.iterator();
    L22:
        if (r109.hasNext() == false) goto L29;
        Object r111 = r109.next();
        if (r110 > ((com.bytedance.bdnavigationsdk.network.route.t) r111).f200282a) goto L26;
        boolean r112 = true;
    L27:
        if (r112 == false) goto L22;
        r108.add(r111);
        goto L22
    L26:
        r112 = false;
        goto L27
    L29:
        Iterator r113 = r108.iterator();
        if (r113.hasNext() == true) goto L32;
        Object r114 = null;
    L41:
        r101 = (com.bytedance.bdnavigationsdk.network.route.t) r114;
        if (r101 != null) goto L68;
        ArrayList r115 = new ArrayList();
        Iterator r116 = r102.iterator();
    L45:
        if (r116.hasNext() == false) goto L54;
        Object r117 = r116.next();
        com.bytedance.bdnavigationsdk.network.route.t r118 = (com.bytedance.bdnavigationsdk.network.route.t) r117;
        if (r118.f200283b == 3) goto L49;
    L51:
        boolean r119 = false;
    L52:
        if (r119 == true) goto L45;
        r115.add(r117);
        goto L45
    L49:
        if (r118.f200282a != 0) goto L51;
        r119 = true;
        goto L52
    L54:
        Iterator r120 = r115.iterator();
        if (r120.hasNext() == true) goto L57;
        Object r121 = null;
    L66:
        r101 = (com.bytedance.bdnavigationsdk.network.route.t) r121;
        goto L68
    L57:
        r121 = r120.next();
        if (r120.hasNext() == false) goto L66;
        int r122 = ((com.bytedance.bdnavigationsdk.network.route.t) r121).f200282a;
    L61:
        Object r123 = r120.next();
        int r124 = ((com.bytedance.bdnavigationsdk.network.route.t) r123).f200282a;
        if (r122 >= r124) goto L65;
        r121 = r123;
        r122 = r124;
    L65:
        if (r120.hasNext() == true) goto L61;
    L32:
        r114 = r113.next();
        if (r113.hasNext() == false) goto L41;
        int r125 = ((com.bytedance.bdnavigationsdk.network.route.t) r114).f200282a;
    L36:
        Object r126 = r113.next();
        int r127 = ((com.bytedance.bdnavigationsdk.network.route.t) r126).f200282a;
        if (r125 <= r127) goto L40;
        r114 = r126;
        r125 = r127;
    L40:
        if (r113.hasNext() == true) goto L36;
        goto L41
    }
}
