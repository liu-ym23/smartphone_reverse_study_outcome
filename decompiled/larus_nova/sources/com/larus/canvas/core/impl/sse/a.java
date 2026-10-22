package com.larus.canvas.core.impl.sse;

import cy8.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, cy8.b> f322957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f322958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f322959c;

    public a() {
        this(0);
    }

    public a(List<cy8.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "originBlocks");
        this.f322957a = new LinkedHashMap();
        this.f322958b = new LinkedHashMap();
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        cy8.b r105 = (cy8.b) r103;
        this.f322957a.put(a(r105, r102), r105);
        r102 = r104;
        goto L4
    }

    public final cy8.c c(String r100) {
        return new cy8.c(CollectionsKt.toList(this.f322957a.values()), this.f322959c, r100);
    }

    public /* synthetic */ a(int r100) {
        this(CollectionsKt.emptyList());
    }

    public static String a(cy8.b r100, int r101) {
        String r102 = r100.f465807b;
        if (r102 != null) goto L12;
        Integer r103 = r100.f465808c;
        if (r103 == null) goto L7;
        String r104 = r103.toString();
    L8:
        String r105 = r104;
        if (r105 == null) goto L11;
        return r105;
    L11:
        return "idx_" + r101;
    L7:
        r104 = null;
        goto L8
    L12:
        return r102;
    }

    public final cy8.c b(List<cy8.b> r410, Long r411, boolean r412, String r413) {
        Long r100 = r411;
        Intrinsics.checkNotNullParameter(r410, "patchBlocks");
        Iterator r101 = r410.iterator();
        a r102 = this;
        Long r103 = r100;
        int r104 = 0;
    L4:
        if (r101.hasNext() == false) goto L121;
        Object r105 = r101.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        cy8.b r107 = (cy8.b) r105;
        String r108 = a(r107, r104);
        Long r109 = (Long) ((LinkedHashMap) r102.f322958b).get(r108);
        if (r412 == true) goto L15;
        if (r103 == null) goto L15;
        if (r109 == null) goto L15;
        if (r411.longValue() > r109.longValue()) goto L15;
        r101 = r101;
        Long r110 = r100;
        r106 = r106;
    L119:
        r100 = r110;
        r101 = r101;
        r104 = r106;
    L15:
        cy8.b r111 = r102.f322957a.get(r108);
        LinkedHashMap<String, cy8.b> r112 = r102.f322957a;
        if (r111 != null) goto L22;
        String r113 = r107.f465811f;
        if (r113 != null) goto L20;
        String r114 = r413;
    L21:
        cy8.b r115 = new cy8.b(r107.f465806a, r107.f465807b, r107.f465808c, r107.f465809d, r107.f465810e, r114);
        r101 = r101;
        LinkedHashMap<String, cy8.b> r116 = r112;
        String r117 = r108;
        r106 = r106;
    L115:
        r116.put(r117, r115);
        r110 = r411;
        if (r110 == null) goto L118;
        this.f322958b.put(r117, r110);
    L118:
        r103 = r110;
        r102 = this;
        goto L119
    L20:
        r114 = r113;
        goto L21
    L22:
        Integer r118 = r107.f465806a;
        if (r118 != null) goto L25;
        r118 = r111.f465806a;
    L25:
        Integer r119 = r118;
        String r120 = r107.f465807b;
        if (r120 != null) goto L28;
        r120 = r111.f465807b;
    L28:
        String r121 = r120;
        Integer r122 = r107.f465808c;
        if (r122 != null) goto L31;
        r122 = r111.f465808c;
    L31:
        Integer r123 = r122;
        if (r111.f465809d == false) goto L34;
    L37:
        boolean r124 = true;
    L38:
        cy8.a r125 = r111.f465810e;
        cy8.a r126 = r107.f465810e;
        if (r125 == null) goto L41;
        if (r126 != null) goto L44;
        r126 = r125;
        goto L41
    L44:
        cy8.k r127 = r125.f465801a;
        cy8.k r128 = r126.f465801a;
        if (r127 != null) goto L48;
        cy8.k r129 = r128;
    L54:
        cy8.i r130 = r126.f465802b;
        if (r130 != null) goto L57;
        r130 = r125.f465802b;
    L57:
        cy8.i r210 = r130;
        n r131 = r126.f465803c;
        if (r131 != null) goto L60;
        r131 = r125.f465803c;
    L60:
        n r211 = r131;
        cy8.h r132 = r125.f465804d;
        cy8.h r133 = r126.f465804d;
        if (r132 != null) goto L63;
        cy8.h r212 = r133;
    L104:
        cy8.e r134 = r126.f465805e;
        if (r134 != null) goto L107;
        r134 = r125.f465805e;
    L107:
        r126 = new cy8.a(r129, r210, r211, r212, r134);
    L108:
        String r135 = r107.f465811f;
        if (r135 != null) goto L113;
        if (r413 != null) goto L112;
        r135 = r111.f465811f;
        goto L113
    L112:
        String r136 = r413;
    L114:
        r115 = new cy8.b(r119, r121, r123, r124, r126, r136);
        r116 = r112;
        r117 = r108;
    L113:
        r136 = r135;
        goto L114
    L63:
        if (r133 == null) goto L103;
        String r137 = r133.f465829a;
        if (r137 != null) goto L68;
    L71:
        boolean r138 = true;
    L72:
        List<cy8.j> r139 = null;
        if (r138 == false) goto L76;
        r137 = null;
    L76:
        if (r137 != null) goto L78;
        r137 = r132.f465829a;
    L78:
        String r213 = r137;
        String r140 = r133.f465830b;
        if (r140 != null) goto L81;
    L84:
        boolean r141 = true;
    L85:
        if (r141 == false) goto L88;
        r140 = null;
    L88:
        if (r140 != null) goto L90;
        r140 = r132.f465830b;
    L90:
        String r214 = r140;
        List<cy8.j> r142 = r133.f465831c;
        List<cy8.j> r143 = r142;
        if (r143 != null) goto L93;
    L96:
        boolean r144 = true;
    L97:
        if (r144 == true) goto L99;
        r139 = r142;
    L99:
        if (r139 != null) goto L101;
        List<cy8.j> r215 = r132.f465831c;
    L102:
        r132 = new cy8.h(r213, r214, r215, r133.f465832d, r133.f465833e);
        goto L103
    L101:
        r215 = r139;
        goto L102
    L93:
        if (r143.isEmpty() == true) goto L96;
        r144 = false;
        goto L97
    L81:
        if (r140.length() == 0) goto L84;
        r141 = false;
        goto L85
    L68:
        if (r137.length() == 0) goto L71;
        r138 = false;
    L103:
        r212 = r132;
        goto L104
    L48:
        if (r128 != null) goto L50;
        r129 = r127;
        goto L54
    L50:
        r101 = r101;
        cy8.d r145 = r128.f465862j;
        if (r145 != null) goto L53;
        r145 = r127.f465862j;
    L53:
        r106 = r106;
        r112 = r112;
        r108 = r108;
        r111 = r111;
        r129 = new cy8.k(r128.f465853a, r128.f465854b, r128.f465855c, r128.f465856d, r128.f465857e, r128.f465858f, r128.f465859g, r128.f465860h, r128.f465861i, r145, r128.f465863k, r128.f465864l, r128.f465865m);
    L41:
        r119 = r119;
        r121 = r121;
        r123 = r123;
        r124 = r124;
        goto L108
    L34:
        if (r107.f465809d == true) goto L37;
        r124 = false;
        goto L38
    L121:
        if (r103 == null) goto L124;
        r102.f322959c = r103;
    L124:
        return r102.c(r413);
    }
}
