package com.relax.relaxreact;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Long, j0> f405565a;

    public s0() {
        this.f405565a = new LinkedHashMap();
    }

    public final j0 b(SnapshotInstance r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        long r101 = r100.f405437a;
        Map<Long, j0> r102 = this.f405565a;
        Intrinsics.checkNotNull(r102);
        if (com.bytedance.rts.kmp.foundation.j.d(r102, Long.valueOf(r101)) == false) goto L6;
        Map<Long, j0> r103 = this.f405565a;
        Intrinsics.checkNotNull(r103);
        Object r104 = com.bytedance.rts.kmp.foundation.j.c(r103, Long.valueOf(r101));
        Intrinsics.checkNotNull(r104);
        return (j0) r104;
    L6:
        j0 r105 = new j0(r100);
        Map<Long, j0> r106 = this.f405565a;
        Intrinsics.checkNotNull(r106);
        com.bytedance.rts.kmp.foundation.j.e(r106, Long.valueOf(r101), r105);
        return r105;
    }

    public final void a(z0 r310, ListRuntime r311, long r312) {
        Map<Long, j0> r100 = this.f405565a;
        if (r100 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r100);
        Long r101 = Long.valueOf(r312);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.containsKey(r101) == false) goto L106;
        Map<Long, j0> r102 = this.f405565a;
        Intrinsics.checkNotNull(r102);
        Object r103 = com.bytedance.rts.kmp.foundation.j.c(r102, Long.valueOf(r312));
        Intrinsics.checkNotNull(r103);
        j0 r104 = (j0) r103;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r310, "renderer");
        Intrinsics.checkNotNullParameter(r311, "runtime");
        SnapshotInstance r105 = r104.f405524a;
        String r106 = "parent";
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
        r105 = null;
    L10:
        boolean r107 = false;
        if (r105.f405441e == null) goto L91;
        SnapshotInstance r108 = r104.f405524a;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
        r108 = null;
    L16:
        p r109 = r108.f405440d;
        if (r109 == null) goto L91;
        if (r104.f405526c == true) goto L24;
        Map<Long, g0> r110 = r104.f405527d;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r110.size() != 0) goto L24;
    L89:
        r107 = true;
    L24:
        ArrayList r111 = com.bytedance.rts.kmp.foundation.i.b(new f0[0]);
        ArrayList r112 = com.bytedance.rts.kmp.foundation.i.b(new Integer[0]);
        ArrayList r113 = com.bytedance.rts.kmp.foundation.i.b(new i0[0]);
        SnapshotInstance r114 = r104.f405524a;
        if (r114 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
        r114 = null;
    L27:
        ArrayList<SnapshotInstance> r115 = h0.b(r114);
        LinkedHashMap r116 = new LinkedHashMap();
        int r117 = 0;
    L28:
        IntCompanionObject r118 = IntCompanionObject.INSTANCE;
        ArrayList<SnapshotInstance> r119 = r104.f405525b;
        if (r119 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("oldChildNodes");
        r119 = null;
    L31:
        int r120 = com.bytedance.rts.kmp.foundation.i.a(r119);
        Intrinsics.checkNotNullParameter(r118, "<this>");
        if (r117 >= r120) goto L37;
        ArrayList<SnapshotInstance> r121 = r104.f405525b;
        if (r121 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("oldChildNodes");
        r121 = null;
    L36:
        Long r122 = Long.valueOf(((SnapshotInstance) ListProtector.get(r121, r117)).f405437a);
        Integer r123 = Integer.valueOf(r117);
        Intrinsics.checkNotNullParameter(r116, "<this>");
        r116.put(r122, r123);
        r117 = r117 + 1;
        r111 = r111;
        goto L28
    L37:
        ArrayList r124 = r111;
        Set r125 = com.bytedance.rts.kmp.foundation.l.a(new Long[0]);
        Set r126 = com.bytedance.rts.kmp.foundation.l.a(new Long[0]);
        int r127 = 0;
        int r128 = 0;
    L38:
        IntCompanionObject r129 = IntCompanionObject.INSTANCE;
        int r130 = com.bytedance.rts.kmp.foundation.i.a(r115);
        Intrinsics.checkNotNullParameter(r129, "<this>");
        if (r127 >= r130) goto L57;
        SnapshotInstance r131 = (SnapshotInstance) ListProtector.get(r115, r127);
        long r132 = r131.f405437a;
        ArrayList<SnapshotInstance> r133 = r115;
        Long r134 = Long.valueOf(r132);
        Intrinsics.checkNotNullParameter(r116, "<this>");
        if (r116.containsKey(r134) == true) goto L43;
        ArrayList r135 = r124;
        j0.a(r135, r131, r127);
        String r136 = r106;
    L46:
        r127 = r127 + 1;
        r116 = r116;
    L56:
        r116 = r116;
        r106 = r136;
        r124 = r135;
        r115 = r133;
        goto L38
    L43:
        r135 = r124;
        r136 = r106;
        Long r137 = Long.valueOf(r132);
        Intrinsics.checkNotNullParameter(r125, "<this>");
        r125.add(r137);
        Long r138 = Long.valueOf(r132);
        Intrinsics.checkNotNullParameter(r116, "<this>");
        Object r139 = r116.get(r138);
        Intrinsics.checkNotNull(r139);
        int r140 = ((Number) r139).intValue();
        if (r140 >= r128) goto L48;
        Long r141 = Long.valueOf(r132);
        Intrinsics.checkNotNullParameter(r126, "<this>");
        r126.add(r141);
        j0.a(r135, r131, r127);
        goto L46
    L48:
        if (com.bytedance.rts.kmp.foundation.j.d(r104.f405527d, Long.valueOf(r132)) == false) goto L55;
        Object r142 = com.bytedance.rts.kmp.foundation.j.c(r104.f405527d, Long.valueOf(r131.f405437a));
        Intrinsics.checkNotNull(r142);
        g0 r143 = (g0) r142;
        i0 r144 = new i0();
        r144.f405511a = r127;
        r144.f405512b = r127;
        Intrinsics.checkNotNullParameter(r144, "action");
        if (r143 == null) goto L53;
        r144.f405514d = null;
        r144.f405515e = null;
        r144.f405516f = null;
        r144.f405517g = null;
        r144.f405518h = null;
        r144.f405519i = null;
        r144.f405520j = null;
        r144.f405521k = null;
        r144.f405522l = null;
    L53:
        com.bytedance.rts.kmp.foundation.i.f(r113, r144);
    L55:
        r127 = r127 + 1;
        r128 = r140;
        goto L56
    L57:
        ArrayList r145 = r124;
        String r146 = r106;
        int r147 = 0;
    L58:
        IntCompanionObject r148 = IntCompanionObject.INSTANCE;
        ArrayList<SnapshotInstance> r149 = r104.f405525b;
        if (r149 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("oldChildNodes");
        r149 = null;
    L61:
        int r150 = com.bytedance.rts.kmp.foundation.i.a(r149);
        Intrinsics.checkNotNullParameter(r148, "<this>");
        if (r147 >= r150) goto L72;
        ArrayList<SnapshotInstance> r151 = r104.f405525b;
        if (r151 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("oldChildNodes");
        r151 = null;
    L66:
        long r152 = ((SnapshotInstance) ListProtector.get(r151, r147)).f405437a;
        Long r153 = Long.valueOf(r152);
        Intrinsics.checkNotNullParameter(r125, "<this>");
        if (r125.contains(r153) == false) goto L70;
        Long r154 = Long.valueOf(r152);
        Intrinsics.checkNotNullParameter(r126, "<this>");
        if (r126.contains(r154) == true) goto L70;
    L71:
        r147 = r147 + 1;
    L70:
        com.bytedance.rts.kmp.foundation.i.f(r112, Integer.valueOf(r147));
        goto L71
    L72:
        Intrinsics.checkNotNullParameter(r145, "insertActions");
        Intrinsics.checkNotNullParameter(r112, "removeActions");
        Intrinsics.checkNotNullParameter(r113, "updateActions");
        LinkedHashMap r155 = new LinkedHashMap();
        String r156 = SlcCommonAction.KEY_ACTIONS;
        Intrinsics.checkNotNullParameter(r145, SlcCommonAction.KEY_ACTIONS);
        String r157 = "action";
        ArrayList r158 = com.bytedance.rts.kmp.foundation.i.b(new Object[0]);
        int r159 = 0;
    L73:
        IntCompanionObject r160 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r145, "<this>");
        int r161 = r145.size();
        Intrinsics.checkNotNullParameter(r160, "<this>");
        if (r159 >= r161) goto L76;
        f0 r162 = (f0) ListProtector.get(r145, r159);
        Intrinsics.checkNotNullParameter(r162, r157);
        LinkedHashMap r163 = new LinkedHashMap();
        Integer r164 = Integer.valueOf(r162.f405494a);
        Intrinsics.checkNotNullParameter(r163, "<this>");
        ArrayList r210 = r145;
        r163.put("position", r164);
        String r165 = r162.getType();
        Intrinsics.checkNotNull(r165, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r163, "<this>");
        r163.put("type", r165);
        h0.a(r163, r162.f405496c, r162.f405497d, r162.f405498e, r162.f405499f, r162.f405500g, r162.f405501h, r162.f405502i, r162.f405503j, r162.f405504k);
        Intrinsics.checkNotNull(r163, "null cannot be cast to non-null type kotlin.Any");
        com.bytedance.rts.kmp.foundation.i.f(r158, r163);
        r159 = r159 + 1;
        r145 = r210;
        r104 = r104;
        r109 = r109;
        r157 = r157;
        r113 = r113;
        r156 = r156;
        goto L73
    L76:
        String r313 = r156;
        j0 r211 = r104;
        p r314 = r109;
        String r315 = r157;
        ArrayList r316 = r113;
        Intrinsics.checkNotNull(r158, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r155, "<this>");
        r155.put("insertAction", r158);
        Intrinsics.checkNotNullParameter(r112, r313);
        ArrayList r166 = com.bytedance.rts.kmp.foundation.i.b(new Object[0]);
        int r167 = 0;
    L77:
        IntCompanionObject r168 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        int r169 = r112.size();
        Intrinsics.checkNotNullParameter(r168, "<this>");
        if (r167 >= r169) goto L80;
        Object r170 = ListProtector.get(r112, r167);
        Intrinsics.checkNotNull(r170, "null cannot be cast to non-null type kotlin.Any");
        com.bytedance.rts.kmp.foundation.i.f(r166, r170);
        r167 = r167 + 1;
        goto L77
    L80:
        Intrinsics.checkNotNull(r166, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r155, "<this>");
        r155.put("removeAction", r166);
        ArrayList r171 = r316;
        Intrinsics.checkNotNullParameter(r171, r313);
        ArrayList r172 = com.bytedance.rts.kmp.foundation.i.b(new Object[0]);
        int r173 = 0;
    L81:
        IntCompanionObject r174 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r171, "<this>");
        int r175 = r171.size();
        Intrinsics.checkNotNullParameter(r174, "<this>");
        if (r173 >= r175) goto L84;
        i0 r176 = (i0) ListProtector.get(r171, r173);
        Intrinsics.checkNotNullParameter(r176, r315);
        LinkedHashMap r177 = new LinkedHashMap();
        Integer r178 = Integer.valueOf(r176.f405511a);
        Intrinsics.checkNotNullParameter(r177, "<this>");
        r177.put("from", r178);
        Integer r179 = Integer.valueOf(r176.f405512b);
        Intrinsics.checkNotNullParameter(r177, "<this>");
        r177.put(RemoteMessageConst.TO, r179);
        String r180 = r176.getType();
        Intrinsics.checkNotNull(r180, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r177, "<this>");
        r177.put("type", r180);
        Boolean r181 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r177, "<this>");
        r177.put("flush", r181);
        h0.a(r177, r176.f405514d, r176.f405515e, r176.f405516f, r176.f405517g, r176.f405518h, r176.f405519i, r176.f405520j, r176.f405521k, r176.f405522l);
        Intrinsics.checkNotNull(r177, "null cannot be cast to non-null type kotlin.Any");
        com.bytedance.rts.kmp.foundation.i.f(r172, r177);
        r173 = r173 + 1;
        r171 = r171;
        goto L81
    L84:
        Intrinsics.checkNotNull(r172, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r155, "<this>");
        r155.put("updateAction", r172);
        Intrinsics.checkNotNull(r155, "null cannot be cast to non-null type kotlin.Any");
        r310.u(r314, r155);
        SnapshotInstance r182 = r211.f405524a;
        if (r182 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException(r146);
        SnapshotInstance r183 = null;
    L88:
        r311.c(r310, r183);
        goto L89
    L87:
        r183 = r182;
    L91:
        if (r107 == false) goto L107;
        Map<Long, j0> r184 = this.f405565a;
        Intrinsics.checkNotNull(r184);
        com.bytedance.rts.kmp.foundation.j.a(r184, Long.valueOf(r312));
        return;
    L107:
        return;
    }
}
