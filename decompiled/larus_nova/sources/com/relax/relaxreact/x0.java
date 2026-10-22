package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f405596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f405597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f405598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SnapshotInstance f405599d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405600a = null;

        static {
            int[] r100 = new int[VNodeType.values().length];
            r100[VNodeType.Snapshot.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VNodeType.Component.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f405600a = r100;
        }
    }

    public x0(RenderFnRenderer r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f405596a = r100;
        this.f405597b = new Scheduler(r100);
        ArrayList r101 = null;
        SnapshotInstance r102 = new SnapshotInstance(new d1(SnapshotKt$getPageSnapshot$1.INSTANCE, r101, com.bytedance.rts.kmp.foundation.i.b(new Integer[]{16777216})), 0);
        this.f405599d = r102;
        r102.e(r100);
    }

    public static SnapshotInstance b(u r100) {
        t r101 = r100.f405589a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        return r101.a();
    L6:
        ArrayList<t> r102 = r100.f405590b;
        if (r102 == null) goto L12;
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        int r104 = r102.size();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r104 <= 0) goto L14;
        ArrayList<t> r105 = r100.f405590b;
        Intrinsics.checkNotNull(r105);
        return ((t) ListProtector.get(r105, 0)).a();
    L14:
        return null;
    L12:
        return null;
    }

    public final void a(d r100, ArrayList<d> r101) {
        c r102 = r100.f405477d;
        if (r102 == null) goto L24;
        ArrayList<n> r103 = r102.f405470b;
        ArrayList<n> r104 = null;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("pendingEffects");
        r103 = null;
    L9:
        if (com.bytedance.rts.kmp.foundation.i.a(r103) <= 0) goto L16;
        final Scheduler r105 = this.f405597b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "c");
        ArrayList<d> r106 = r105.f405431b;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("afterPaintEffects");
        r106 = null;
    L13:
        com.bytedance.rts.kmp.foundation.i.f(r106, r100);
        if (r105.f405433d != null) goto L16;
        Function1<Long, Unit> r107 = new Scheduler$pendingEffect$frameCallback$1(r105);
        r105.f405433d = r107;
        r105.c().c(r107);
    L16:
        ArrayList<n> r108 = r102.f405471c;
        if (r108 == null) goto L19;
        r104 = r108;
    L21:
        if (com.bytedance.rts.kmp.foundation.i.a(r104) <= 0) goto L25;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.add(r100);
        return;
    L25:
        return;
    L19:
        Intrinsics.throwUninitializedPropertyAccessException("layoutEffects");
        goto L21
    }

    public final void l(t r100, d r110, boolean r111) {
        if (r100.getType().getValue() != FiberType.Component.getValue()) goto L5;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.relax.relaxreact.ComponentFiber");
        b r101 = (b) r100;
    L6:
        int r102 = 0;
        if (r101 == null) goto L23;
        d r103 = r101.f405464e;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("component");
        r103 = null;
    L12:
        t r112 = r103.f405479f;
        r103.f405475b = false;
        if (r112 == null) goto L16;
        l(r112, r103, r111);
    L16:
        if (r103.f405477d == null) goto L59;
    L17:
        IntCompanionObject r113 = IntCompanionObject.INSTANCE;
        c r114 = r103.f405477d;
        Intrinsics.checkNotNull(r114);
        int r115 = com.bytedance.rts.kmp.foundation.i.a(r114.a());
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if (r102 >= r115) goto L20;
        c r116 = r103.f405477d;
        Intrinsics.checkNotNull(r116);
        ((a0) ListProtector.get(r116.a(), r102)).a();
        r102 = r102 + 1;
        goto L17
    L20:
        r103.f405477d = null;
        return;
    L59:
        return;
    L23:
        if (r100.getType().getValue() != FiberType.Snapshot.getValue()) goto L25;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.relax.relaxreact.SnapshotFiber");
        g1 r104 = (g1) r100;
    L26:
        if (r104 == null) goto L60;
        SnapshotInstance r105 = r104.a();
        com.bytedance.rts.kmp.foundation.j.b(r105.f405448l, SnapshotInstance$__unmountRefs$1.INSTANCE);
        r105.f405448l = new LinkedHashMap();
        new LinkedHashMap();
        if (r111 == false) goto L48;
        SnapshotInstance r117 = r100.a().f405449m;
        if (r117 == null) goto L48;
        final z0 r106 = this.f405596a;
        SnapshotInstance r107 = r100.a();
        Intrinsics.checkNotNullParameter(r106, "renderer");
        Intrinsics.checkNotNullParameter(r107, "node");
        d1 r108 = r117.f405438b;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r108 = null;
    L35:
        if (r108.f405491h == false) goto L37;
        r106.m().i(r106, r117, r107);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "renderer");
        r107.q(new SnapshotInstance$detachBindingsRecursively$1(r106));
        ArrayList<p> r109 = r107.c();
        r107.r();
        r117.b(r107);
        r107.q(SnapshotInstance$removeChild$1.INSTANCE);
        SnapshotInstance.d(r106, r109);
        goto L48
    L37:
        r117.b(r107);
        Intrinsics.checkNotNullParameter(r106, "renderer");
        r107.q(new SnapshotInstance$detachBindingsRecursively$1(r106));
        p r118 = r107.f405440d;
        ArrayList<p> r119 = r107.c();
        r107.q(new SnapshotInstance$removeChild$2(r106));
        if (r118 == null) goto L48;
        if (r117.g(r107.f405439c) != 0) goto L43;
        int r120 = r107.f405439c;
        p r121 = r106.n();
        r106.l(r121, r118);
        r117.k(r120, r121);
        SnapshotInstance.d(r106, r119);
        goto L48
    L43:
        p r122 = r117.f(r107.f405439c);
        if (r122 == null) goto L48;
        r106.g(r122, r118);
        SnapshotInstance.d(r106, r119);
    L48:
        if (r104.f405507e == false) goto L50;
        u r123 = r104.f405508f;
        Intrinsics.checkNotNull(r123);
        n(r123, r110, false);
        r104.f405507e = false;
        r104.f405508f = null;
    L50:
        ArrayList<u> r124 = r104.f405509g;
        if (r124 == null) goto L61;
        IntCompanionObject r125 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r124, "<this>");
        int r126 = r124.size();
        Intrinsics.checkNotNullParameter(r125, "<this>");
        int r127 = 0;
    L53:
        if (r127 >= r126) goto L55;
        n((u) ListProtector.get(r124, r127), r110, false);
        r127 = r127 + 1;
        goto L53
    L55:
        r104.f405509g = null;
        return;
    L61:
        return;
    L60:
        return;
    L25:
        r104 = null;
        goto L26
    L5:
        r101 = null;
        goto L6
    }

    public final void m(ArrayList<t> r100, d r101, boolean r102) {
        int r103 = 0;
    L3:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r105 = r100.size();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r103 >= r105) goto L6;
        l((t) ListProtector.get(r100, r103), r101, r102);
        r103 = r103 + 1;
        goto L3
    }

    public final void n(u r100, d r101, boolean r102) {
        t r103 = r100.f405589a;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        l(r103, r101, r102);
        r100.f405589a = null;
    L5:
        ArrayList<t> r104 = r100.f405590b;
        if (r104 == null) goto L9;
        Intrinsics.checkNotNull(r104);
        m(r104, r101, r102);
        r100.f405590b = null;
        return;
    }

    public final void k(SnapshotInstance r100, SnapshotInstance r101, SnapshotInstance r102, boolean r103) {
        if (r103 == false) goto L18;
        z0 r104 = this.f405596a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r100, "node");
        SnapshotInstance r105 = r101.f405451o;
        if (r105 == null) goto L6;
        Intrinsics.checkNotNull(r105);
        r105.f405453q = r100;
        SnapshotInstance r106 = r101.f405451o;
        Intrinsics.checkNotNull(r106);
        r100.f405452p = r106;
    L7:
        r101.f405451o = r100;
        r100.f405449m = r101;
        r100.f405453q = null;
        if (r101.f405441e != null) goto L11;
        return;
    L11:
        if (r100.f405441e != null) goto L14;
        r100.e(r104);
    L14:
        if (r101.g(r100.f405439c) != 0) goto L16;
        r101.j(r104, r100.f405439c, r100);
        return;
    L16:
        p r107 = r101.f(r100.f405439c);
        Intrinsics.checkNotNull(r107);
        p r108 = r100.f405440d;
        Intrinsics.checkNotNull(r108);
        r104.k(r107, r108);
        return;
    L6:
        r101.f405450n = r100;
        r100.f405452p = null;
        goto L7
    L18:
        r101.h(this.f405596a, r100, r102);
    }

    public final void o(SnapshotInstance r100, int r101, u r102, d r103) {
        if (r100.g(r101) != 67108864) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r100.o(this.f405596a, r101, null);
    L8:
        n(r102, r103, true);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final void p(d r110, g r111, int r112, ArrayList<d> r113) {
        Intrinsics.checkNotNullParameter(r110, "instance");
        Intrinsics.checkNotNullParameter(r113, "commitQueue");
        r110.f405476c = false;
        if (r110.f405475b == true) goto L5;
        return;
    L5:
        t r100 = r110.f405479f;
        Intrinsics.checkNotNull(r100);
        if (r111 != null) goto L8;
        b r101 = r110.f405478e;
        Intrinsics.checkNotNull(r101);
        o1 r102 = r101.b();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.relax.relaxreact.ComponentVNode");
        g r103 = (g) r102;
    L9:
        o1 r104 = r110.a(r103);
        int r105 = r112 + 1;
        SnapshotInstance r106 = r100.a().f405449m;
        Intrinsics.checkNotNull(r106);
        t r114 = h(r100, r104, r105, r113, r106, r100.a().f405439c, r100.a().f405453q, r110);
        Intrinsics.checkNotNull(r114);
        b r107 = r110.f405478e;
        Intrinsics.checkNotNull(r107);
        SnapshotInstance r108 = r114.a();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f405585c = r108;
        r110.f405479f = r114;
        if (r111 != null) goto L16;
        SnapshotInstance r115 = r114.a();
        Intrinsics.checkNotNullParameter(r115, "el");
        b r116 = r110.f405478e;
        d r109 = r110.f405480g;
    L12:
        if (r109 == null) goto L16;
        if (r109.f405479f != r116) goto L16;
        r116 = r109.f405478e;
        Intrinsics.checkNotNull(r116);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r116.f405585c = r115;
        r109 = r109.f405480g;
    L16:
        a(r110, r113);
        return;
    L8:
        r103 = r111;
        goto L9
    }

    public final b c(g r110, int r111, ArrayList<d> r112, SnapshotInstance r113, int r114, SnapshotInstance r115, d r116, boolean r210) {
        d r117 = new d(r110, r116, this);
        b r118 = new b(r113, r110, r117);
        r118.f405584b = r111;
        r117.f405475b = true;
        t r100 = g(r117.a(r110), 1 + r111, r112, r113, r114, r115, r117, r210);
        SnapshotInstance r101 = r100.a();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r118.f405585c = r101;
        r117.f405479f = r100;
        a(r117, r112);
        return r118;
    }

    public final u d(p1 r110, int r111, ArrayList<d> r112, SnapshotInstance r210, int r211, SnapshotInstance r212, d r213, boolean r214) {
        u r100 = new u();
        int r101 = 0;
        if (r214 == false) goto L6;
        if (r212 != null) goto L6;
        boolean r113 = true;
    L7:
        ArrayList<o1> r114 = r110.f405557b;
        if (r114 == null) goto L18;
        Intrinsics.checkNotNull(r114);
        int r102 = r111 + 1;
        ArrayList<t> r115 = com.bytedance.rts.kmp.foundation.i.b(new t[0]);
    L10:
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        int r104 = r114.size();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r101 >= r104) goto L17;
        o1 r105 = (o1) ListProtector.get(r114, r101);
        if (r105 == null) goto L16;
        com.bytedance.rts.kmp.foundation.i.f(r115, g(r105, r102 + 1, r112, r210, r211, r212, r213, r113));
    L16:
        r101 = r101 + 1;
        goto L10
    L17:
        r100.f405590b = r115;
    L23:
        return r100;
    L18:
        o1 r106 = r110.f405556a;
        if (r106 == null) goto L21;
        Intrinsics.checkNotNull(r106);
        t r107 = g(r106, r111 + 1, r112, r210, r211, r212, r213, r113);
    L22:
        r100.f405589a = r107;
        goto L23
    L21:
        r107 = null;
    L6:
        r113 = false;
        goto L7
    }

    public final g1 e(j1 r210, int r211, ArrayList<d> r212, SnapshotInstance r213, int r214, SnapshotInstance r310, d r311, boolean r312) {
        d1 r100 = r210.f405528d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r100 = null;
    L6:
        ArrayList<Object> r110 = r210.f405529e;
        ArrayList<p1> r101 = r210.f405532h;
        String r111 = "<this>";
        if (r210.f405533i == true) goto L23;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.size() != 0) goto L23;
    L11:
        d1 r102 = r210.f405528d;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r102 = null;
    L15:
        SnapshotInstance r103 = new SnapshotInstance(r102, r214);
        g1 r104 = new g1(r103, r210);
        r104.f405584b = r211;
        if (r210.f405530f == false) goto L18;
        z0 r105 = this.f405596a;
        Object r106 = r210.f405531g;
        Intrinsics.checkNotNullParameter(r105, "renderer");
        r103.f405442f = null;
        r103.f405443g = true;
        r103.f405444h = r106;
        r103.s(r105, null);
    L21:
        k(r103, r213, r310, r312);
        return r104;
    L18:
        ArrayList<Object> r107 = r210.f405529e;
        if (r107 == null) goto L21;
        z0 r108 = this.f405596a;
        Intrinsics.checkNotNull(r107);
        Intrinsics.checkNotNullParameter(r108, "renderer");
        Intrinsics.checkNotNullParameter(r107, "values");
        r103.f405442f = r107;
        r103.f405443g = false;
        r103.f405444h = null;
        r103.u(r108, r107, null, false, null);
    L23:
        SnapshotInstance r109 = new SnapshotInstance(r100, r214);
        g1 r112 = new g1(r109, r210);
        r112.f405584b = r211;
        if (r210.f405530f == false) goto L27;
        z0 r113 = this.f405596a;
        Object r114 = r210.f405531g;
        Intrinsics.checkNotNullParameter(r113, "renderer");
        r109.f405442f = null;
        r109.f405443g = true;
        r109.f405444h = r114;
        r109.s(r113, null);
    L30:
        k(r109, r213, r310, r312);
        if (r210.f405533i == false) goto L34;
        p1 r115 = r210.f405534j;
        Intrinsics.checkNotNull(r115);
        u r116 = f(r115, r211, r212, r109, 0, null, r311, !r109.i());
        r112.f405507e = true;
        r112.f405508f = r116;
        return r112;
    L34:
        if (r101 == null) goto L59;
        Intrinsics.checkNotNullParameter(r101, r111);
        if (r101.size() <= 0) goto L60;
        ArrayList r117 = com.bytedance.rts.kmp.foundation.i.b(new u[0]);
        Intrinsics.checkNotNullParameter(r101, r111);
        if (r101.size() == 1) goto L40;
    L42:
        boolean r118 = false;
    L43:
        IntCompanionObject r119 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, r111);
        int r120 = r101.size();
        Intrinsics.checkNotNullParameter(r119, r111);
        int r121 = r120 - 1;
        SnapshotInstance r122 = null;
    L44:
        if (r121 < 0) goto L49;
        p1 r123 = (p1) ListProtector.get(r101, r121);
        int r124 = com.bytedance.rts.kmp.foundation.c.f267609a;
        String r125 = r111;
        SnapshotInstance r126 = r109;
        ArrayList<p1> r127 = r101;
        u r128 = f(r123, r211, r212, r109, r121, r122, r311, r118);
        com.bytedance.rts.kmp.foundation.i.f(r117, r128);
        SnapshotInstance r129 = b(r128);
        if (r129 == null) goto L48;
        r122 = r129;
    L48:
        r121 = r121 - 1;
        r111 = r125;
        r109 = r126;
        r101 = r127;
        goto L44
    L49:
        String r130 = r111;
        ArrayList<u> r131 = com.bytedance.rts.kmp.foundation.i.b(new u[0]);
        IntCompanionObject r132 = IntCompanionObject.INSTANCE;
        int r133 = com.bytedance.rts.kmp.foundation.i.a(r117);
        Intrinsics.checkNotNullParameter(r132, r130);
        int r134 = r133 - 1;
    L50:
        if (r134 < 0) goto L52;
        com.bytedance.rts.kmp.foundation.i.f(r131, ListProtector.get(r117, r134));
        r134 = r134 - 1;
        goto L50
    L52:
        r112.f405509g = r131;
        return r112;
    L40:
        if (r109.i() == true) goto L42;
        r118 = true;
        goto L43
    L60:
        return r112;
    L59:
        return r112;
    L27:
        if (r110 == null) goto L30;
        z0 r135 = this.f405596a;
        Intrinsics.checkNotNullParameter(r135, "renderer");
        Intrinsics.checkNotNullParameter(r110, "values");
        r109.f405442f = r110;
        r109.f405443g = false;
        r109.f405444h = null;
        r109.u(r135, r110, null, false, null);
        goto L30
    }

    public final u f(p1 r100, int r101, ArrayList<d> r102, SnapshotInstance r103, int r104, SnapshotInstance r105, d r106, boolean r110) {
        if (r103.g(r104) != 67108864) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        String r108 = r100.f405558c;
        if (r108 == null) goto L12;
        z0 r109 = this.f405596a;
        Intrinsics.checkNotNull(r108);
        r103.o(r109, r104, r108);
        return new u();
    L12:
        return d(r100, r101, r102, r103, r104, r105, r106, r110);
    L8:
        return d(r100, r101, r102, r103, r104, r105, r106, r110);
    L5:
        r107 = false;
        goto L6
    }

    public final t g(o1 r110, int r111, ArrayList<d> r112, SnapshotInstance r113, int r114, SnapshotInstance r115, d r116, boolean r117) {
        if (r110.getType().getValue() != VNodeType.Snapshot.getValue()) goto L6;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.relax.relaxreact.SnapshotVNode");
        return e((j1) r110, r111, r112, r113, r114, r115, r116, r117);
    L6:
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.relax.relaxreact.ComponentVNode");
        return c((g) r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public final t h(t r210, o1 r211, int r212, ArrayList<d> r213, SnapshotInstance r214, int r215, SnapshotInstance r216, d r217) {
        t r100 = r210;
        d r110 = null;
        boolean r111 = true;
        if (r211 != null) goto L8;
        if (r100 == null) goto L6;
        l(r100, r217, true);
    L6:
        return null;
    L8:
        if (r100 == null) goto L24;
        if (r210.b() != r211) goto L14;
        r100.f405584b = r212;
        return r100;
    L14:
        if (r210.a().f405439c == r215) goto L16;
        boolean r101 = true;
    L17:
        if (r101 == false) goto L20;
        int r102 = com.relax.relaxreact.shared.b.f405582a;
        com.relax.relaxreact.shared.b.a.a(new String[]{"[Relax][React] SlotIndex is baked into SnapshotInstance and can't be changed after mount."});
    L20:
        if (r210.b().a(r211) == false) goto L22;
        if (r101 == false) goto L24;
    L22:
        SnapshotInstance r103 = r210.a().f405453q;
        l(r100, r217, true);
        SnapshotInstance r104 = r103;
        r100 = null;
    L25:
        int r105 = a.f405600a[r211.getType().ordinal()];
        if (r105 == 1) goto L50;
        if (r105 != 2) goto L48;
        if (r100 == null) goto L31;
        b r106 = (b) r100;
    L32:
        g r107 = (g) r211;
        if (r106 != null) goto L35;
        r106 = c(r107, r212, r213, r214, r215, r104, r217, false);
    L46:
        Intrinsics.checkNotNull(r106);
        g1 r108 = r106;
    L166:
        Intrinsics.checkNotNull(r108);
        Intrinsics.checkNotNullParameter(r211, "<set-?>");
        r108.f405586d = r211;
        r108.f405584b = r212;
        return r108;
    L35:
        d r109 = r106.f405464e;
        if (r109 == null) goto L38;
        r110 = r109;
    L40:
        if (r110.f405476c == true) goto L45;
        o1 r112 = r106.b();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.relax.relaxreact.ComponentVNode");
        g r113 = (g) r112;
        Object r114 = r107.f405506e;
        if (r113.d().f405493b == null) goto L44;
        Function2<Object, Object, Boolean> r115 = r113.d().f405493b;
        Intrinsics.checkNotNull(r115);
        r111 = true ^ r115.invoke(r113.f405506e, r114).booleanValue();
    L44:
        if (r111 == false) goto L46;
    L45:
        p(r110, r107, r212, r213);
        goto L46
    L38:
        Intrinsics.throwUninitializedPropertyAccessException("component");
        goto L40
    L31:
        r106 = null;
        goto L32
    L48:
        throw new NoWhenBranchMatchedException();
    L50:
        if (r100 == null) goto L52;
        g1 r116 = (g1) r100;
    L53:
        j1 r117 = (j1) r211;
        if (r116 != null) goto L57;
        g1 r118 = e(r117, r212, r213, r214, r215, r104, r217, false);
    L165:
        Intrinsics.checkNotNull(r118);
        r108 = r118;
        goto L166
    L57:
        if (r117.f405530f == false) goto L99;
        SnapshotInstance r119 = r116.a();
        z0 r120 = this.f405596a;
        Object r121 = r117.f405531g;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "renderer");
        d1 r122 = r119.f405438b;
        if (r122 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r122 = null;
    L61:
        ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r123 = r122.f405486c;
        if (r119.f405443g == false) goto L64;
        Object r124 = r119.f405444h;
    L72:
        if (r119.f405443g == false) goto L74;
    L77:
        boolean r125 = true;
    L78:
        r119.f405442f = null;
        r119.f405443g = true;
        r119.f405444h = r121;
        if (r119.f405441e != null) goto L84;
        if (r125 == true) goto L82;
    L83:
        r119.s(r120, r124);
    L102:
        if (r117.f405533i == true) goto L104;
        g1 r126 = r116;
        SnapshotInstance r127 = r104;
        ArrayList<p1> r128 = r117.f405532h;
        if (r128 == null) goto L154;
        Intrinsics.checkNotNull(r128);
        Intrinsics.checkNotNullParameter(r128, "<this>");
        if (r128.size() == 0) goto L154;
        ArrayList<p1> r129 = r117.f405532h;
        Intrinsics.checkNotNull(r129);
        ArrayList<u> r130 = r126.f405509g;
        ArrayList r131 = com.bytedance.rts.kmp.foundation.i.b(new u[0]);
        IntCompanionObject r132 = IntCompanionObject.INSTANCE;
        int r133 = com.bytedance.rts.kmp.foundation.i.a(r129);
        Intrinsics.checkNotNullParameter(r132, "<this>");
        int r134 = r133 - 1;
        SnapshotInstance r135 = null;
    L128:
        if (r134 < 0) goto L143;
        if (r126.f405507e == false) goto L133;
        if (r134 != 0) goto L133;
        u r136 = r126.f405508f;
    L137:
        u r137 = r136;
    L139:
        p1 r138 = (p1) ListProtector.get(r129, r134);
        SnapshotInstance r139 = r126.a();
        int r140 = com.bytedance.rts.kmp.foundation.c.f267609a;
        int r141 = r134;
        ArrayList r142 = r131;
        ArrayList<u> r143 = r130;
        SnapshotInstance r144 = r127;
        ArrayList<p1> r145 = r129;
        u r146 = j(r137, r138, r212, r213, r139, r141, r135, r217);
        com.bytedance.rts.kmp.foundation.i.f(r142, r146);
        SnapshotInstance r147 = b(r146);
        if (r147 == null) goto L142;
        r135 = r147;
    L142:
        r134 = r141 - 1;
        r130 = r143;
        r131 = r142;
        r129 = r145;
        r127 = r144;
    L133:
        if (r130 == null) goto L138;
        IntCompanionObject r148 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r130, "<this>");
        int r149 = r130.size();
        Intrinsics.checkNotNullParameter(r148, "<this>");
        if (r134 >= r149) goto L138;
        r136 = (u) ListProtector.get(r130, r134);
    L138:
        r137 = null;
        goto L139
    L143:
        ArrayList r150 = r131;
        ArrayList<u> r151 = r130;
        SnapshotInstance r152 = r127;
        ArrayList<p1> r153 = r129;
        ArrayList<u> r154 = com.bytedance.rts.kmp.foundation.i.b(new u[0]);
        IntCompanionObject r155 = IntCompanionObject.INSTANCE;
        int r156 = com.bytedance.rts.kmp.foundation.i.a(r150);
        Intrinsics.checkNotNullParameter(r155, "<this>");
        int r157 = r156 - 1;
    L144:
        if (r157 < 0) goto L146;
        com.bytedance.rts.kmp.foundation.i.f(r154, ListProtector.get(r150, r157));
        r157 = r157 - 1;
        goto L144
    L146:
        if (r151 == null) goto L153;
        Intrinsics.checkNotNullParameter(r151, "<this>");
        int r158 = r151.size();
        Intrinsics.checkNotNullParameter(r153, "<this>");
        if (r158 <= r153.size()) goto L153;
        int r159 = com.relax.relaxreact.shared.b.f405582a;
        com.relax.relaxreact.shared.b.a.a(new String[]{"[Relax][React]','SnapshotFiber slots length can't be decreased after mount."});
        IntCompanionObject r160 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r153, "<this>");
        int r161 = r153.size();
        Intrinsics.checkNotNullParameter(r160, "<this>");
    L150:
        IntCompanionObject r162 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r151, "<this>");
        int r163 = r151.size();
        Intrinsics.checkNotNullParameter(r162, "<this>");
        if (r161 >= r163) goto L153;
        SnapshotInstance r164 = r126.a();
        int r165 = com.bytedance.rts.kmp.foundation.c.f267609a;
        o(r164, r161, (u) ListProtector.get(r151, r161), r217);
        r161 = r161 + 1;
    L153:
        r126.f405509g = r154;
        r126.f405507e = false;
        r126.f405508f = null;
    L164:
        r214.h(this.f405596a, r126.a(), r152);
        r118 = r126;
    L154:
        r152 = r127;
        if (r126.f405507e == false) goto L158;
        SnapshotInstance r166 = r126.a();
        u r167 = r126.f405508f;
        Intrinsics.checkNotNull(r167);
        o(r166, 0, r167, r217);
        r126.f405507e = false;
        r126.f405508f = null;
    L158:
        if (r126.f405509g == null) goto L164;
        int r168 = 0;
    L160:
        IntCompanionObject r169 = IntCompanionObject.INSTANCE;
        ArrayList<u> r170 = r126.f405509g;
        Intrinsics.checkNotNull(r170);
        int r171 = com.bytedance.rts.kmp.foundation.i.a(r170);
        Intrinsics.checkNotNullParameter(r169, "<this>");
        if (r168 >= r171) goto L163;
        SnapshotInstance r172 = r126.a();
        int r173 = com.bytedance.rts.kmp.foundation.c.f267609a;
        ArrayList<u> r174 = r126.f405509g;
        Intrinsics.checkNotNull(r174);
        o(r172, r168, (u) ListProtector.get(r174, r168), r217);
        r168 = r168 + 1;
        goto L160
    L163:
        r126.f405509g = null;
        goto L164
    L104:
        if (r116.f405507e == false) goto L106;
        u r175 = r116.f405508f;
    L111:
        u r176 = r175;
    L113:
        p1 r177 = r117.f405534j;
        Intrinsics.checkNotNull(r177);
        r126 = r116;
        SnapshotInstance r178 = r104;
        u r179 = j(r176, r177, r212, r213, r116.a(), 0, null, r217);
        ArrayList<u> r180 = r126.f405509g;
        if (r180 == null) goto L121;
        Intrinsics.checkNotNull(r180);
        Intrinsics.checkNotNullParameter(r180, "<this>");
        if (r180.size() <= 1) goto L121;
        int r181 = 1;
    L118:
        IntCompanionObject r182 = IntCompanionObject.INSTANCE;
        ArrayList<u> r183 = r126.f405509g;
        Intrinsics.checkNotNull(r183);
        int r184 = com.bytedance.rts.kmp.foundation.i.a(r183);
        Intrinsics.checkNotNullParameter(r182, "<this>");
        if (r181 >= r184) goto L121;
        SnapshotInstance r185 = r126.a();
        int r186 = com.bytedance.rts.kmp.foundation.c.f267609a;
        ArrayList<u> r187 = r126.f405509g;
        Intrinsics.checkNotNull(r187);
        o(r185, r181, (u) ListProtector.get(r187, r181), r217);
        r181 = r181 + 1;
    L121:
        r126.f405509g = null;
        r126.f405507e = true;
        r126.f405508f = r179;
        r152 = r178;
        goto L164
    L106:
        ArrayList<u> r188 = r116.f405509g;
        if (r188 == null) goto L112;
        Intrinsics.checkNotNull(r188);
        Intrinsics.checkNotNullParameter(r188, "<this>");
        if (r188.size() <= 0) goto L112;
        ArrayList<u> r189 = r116.f405509g;
        Intrinsics.checkNotNull(r189);
        r175 = (u) ListProtector.get(r189, 0);
    L112:
        r176 = null;
        goto L113
    L82:
        if ((!p0.a(r124, r121)) == false) goto L102;
    L84:
        if (r125 == true) goto L86;
    L87:
        d1 r190 = r119.f405438b;
        if (r190 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r190 = null;
    L90:
        Function4<z0, SnapshotInstance, Integer, Object, Unit> r191 = r190.f405489f;
        if (r191 == null) goto L94;
        r191.invoke(r120, r119, 0, r124);
        goto L102
    L94:
        if (r123 == null) goto L102;
        Intrinsics.checkNotNullParameter(r123, "<this>");
        if (r123.size() <= 0) goto L102;
        ((Function4) ListProtector.get(r123, 0)).invoke(r120, r119, 0, r124);
        goto L102
    L86:
        if ((!p0.a(r124, r121)) == false) goto L102;
    L74:
        if (r119.f405442f != null) goto L77;
        r125 = false;
        goto L78
    L64:
        ArrayList<Object> r192 = r119.f405442f;
        if (r192 == null) goto L70;
        Intrinsics.checkNotNull(r192);
        Intrinsics.checkNotNullParameter(r192, "<this>");
        if (r192.size() <= 0) goto L70;
        ArrayList<Object> r193 = r119.f405442f;
        Intrinsics.checkNotNull(r193);
        r124 = ListProtector.get(r193, 0);
    L70:
        r124 = null;
        goto L72
    L99:
        if (r117.f405529e == null) goto L102;
        SnapshotInstance r194 = r116.a();
        z0 r195 = this.f405596a;
        ArrayList<Object> r196 = r117.f405529e;
        Intrinsics.checkNotNull(r196);
        r194.t(r195, r196);
        goto L102
    L52:
        r116 = null;
        goto L53
    L16:
        r101 = false;
    L24:
        r104 = r216;
        goto L25
    }

    public final u i(u r210, p1 r211, int r212, ArrayList<d> r213, SnapshotInstance r214, int r215, SnapshotInstance r216, d r217) {
        if (r210 != null) goto L5;
        u r110 = new u();
    L7:
        if (r211.f405557b == null) goto L85;
        t r100 = r110.f405589a;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        l(r100, r217, true);
        r110.f405589a = null;
    L11:
        ArrayList<t> r101 = r110.f405590b;
        ArrayList<o1> r111 = r211.f405557b;
        Intrinsics.checkNotNull(r111);
        int r112 = r212 + 1;
        if (r101 != null) goto L14;
        r101 = com.bytedance.rts.kmp.foundation.i.b(new t[0]);
    L14:
        ArrayList<t> r102 = r101;
        ArrayList r103 = com.bytedance.rts.kmp.foundation.i.b(new Boolean[0]);
        int r104 = 0;
    L15:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        int r106 = com.bytedance.rts.kmp.foundation.i.a(r102);
        String r107 = "<this>";
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r104 >= r106) goto L18;
        com.bytedance.rts.kmp.foundation.i.f(r103, Boolean.FALSE);
        r104 = r104 + 1;
        goto L15
    L18:
        ArrayList<t> r108 = com.bytedance.rts.kmp.foundation.i.b(new t[0]);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        int r109 = r102.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r109 <= 0) goto L21;
        SnapshotInstance r113 = ((t) ListProtector.get(r102, 0)).a();
    L22:
        SnapshotInstance r114 = null;
        int r115 = 0;
    L23:
        IntCompanionObject r116 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, r107);
        int r117 = r111.size();
        Intrinsics.checkNotNullParameter(r116, r107);
        if (r115 >= r117) goto L76;
        o1 r118 = (o1) ListProtector.get(r111, r115);
        if (r118 == null) goto L27;
        Intrinsics.checkNotNullParameter(r118, "vnode");
        if (r118.f405553b == null) goto L31;
    L34:
        boolean r119 = true;
    L36:
        if (r119 == false) goto L45;
        Intrinsics.checkNotNullParameter(r102, r107);
        int r120 = r102.size();
        Intrinsics.checkNotNullParameter(r116, r107);
        int r121 = r120 - 1;
    L38:
        if (r121 < 0) goto L62;
        if (((Boolean) ListProtector.get(r103, r121)).booleanValue() == true) goto L44;
        if (((t) ListProtector.get(r102, r121)).b().a(r118) == false) goto L44;
    L63:
        if (r121 < 0) goto L65;
        t r122 = (t) ListProtector.get(r102, r121);
    L66:
        if (r121 < 0) goto L68;
        ListProtector.set(r103, r121, Boolean.TRUE);
    L68:
        if (r114 == null) goto L70;
        SnapshotInstance r123 = r114.f405453q;
    L71:
        if (r122 != null) goto L73;
    L75:
        SnapshotInstance r124 = r123;
        int r125 = r115;
        ArrayList<t> r126 = r108;
        t r127 = h(r122, r118, r112, r213, r214, r215, r124, r217);
        Intrinsics.checkNotNull(r127);
        r214.h(this.f405596a, r127.a(), r124);
        SnapshotInstance r128 = r127.a();
        com.bytedance.rts.kmp.foundation.i.f(r126, r127);
        r115 = r125 + 1;
        r114 = r128;
        r108 = r126;
        r102 = r102;
        r107 = r107;
        r103 = r103;
        r111 = r111;
        r110 = r110;
        r112 = r112;
        goto L23
    L73:
        if (r123 != r122.a()) goto L75;
        r123 = r122.a().f405453q;
        goto L75
    L70:
        r123 = r113;
        goto L71
    L65:
        r122 = null;
    L44:
        r121 = r121 - 1;
    L62:
        r121 = -1;
        goto L63
    L45:
        int r129 = 0;
    L46:
        IntCompanionObject r130 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, r107);
        int r131 = r102.size();
        Intrinsics.checkNotNullParameter(r130, r107);
        if (r129 >= r131) goto L62;
        if (((Boolean) ListProtector.get(r103, r129)).booleanValue() == true) goto L61;
        o1 r132 = ((t) ListProtector.get(r102, r129)).b();
        Intrinsics.checkNotNullParameter(r132, "vnode");
        if (r132.f405553b == null) goto L53;
    L56:
        boolean r133 = true;
    L57:
        if (r133 == true) goto L61;
        if (((t) ListProtector.get(r102, r129)).b().a(r118) == false) goto L61;
        r121 = r129;
        goto L63
    L53:
        if (r132.f405554c != null) goto L56;
        r133 = false;
    L61:
        r129 = r129 + 1;
        goto L46
    L31:
        if (r118.f405554c != null) goto L34;
        r119 = false;
        goto L36
    L27:
        r115 = r115 + 1;
        goto L23
    L76:
        ArrayList<t> r134 = r108;
        String r135 = r107;
        ArrayList r136 = r103;
        u r137 = r110;
        ArrayList<t> r138 = r102;
        int r139 = 0;
    L77:
        IntCompanionObject r140 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r138, r135);
        int r141 = r138.size();
        Intrinsics.checkNotNullParameter(r140, r135);
        if (r139 >= r141) goto L84;
        if (((Boolean) ListProtector.get(r136, r139)).booleanValue() == true) goto L83;
        l((t) ListProtector.get(r138, r139), r217, true);
    L83:
        r139 = r139 + 1;
        r134 = r134;
        goto L77
    L84:
        r137.f405590b = r134;
        return r137;
    L21:
        r113 = r216;
        goto L22
    L85:
        u r142 = r110;
        ArrayList<t> r143 = r142.f405590b;
        if (r143 == null) goto L88;
        Intrinsics.checkNotNull(r143);
        m(r143, r217, true);
        r142.f405590b = null;
    L88:
        r142.f405589a = h(r142.f405589a, r211.f405556a, r212 + 1, r213, r214, r215, r216, r217);
        return r142;
    L5:
        r110 = r210;
        goto L7
    }

    public final u j(u r110, p1 r111, int r112, ArrayList<d> r113, SnapshotInstance r114, int r115, SnapshotInstance r116, d r117) {
        if (r114.g(r115) != 67108864) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        if (r110 != null) goto L11;
        u r101 = new u();
    L13:
        if (r111.f405558c == null) goto L22;
        t r102 = r101.f405589a;
        if (r102 == null) goto L17;
        Intrinsics.checkNotNull(r102);
        l(r102, r117, true);
        r101.f405589a = null;
    L17:
        ArrayList<t> r103 = r101.f405590b;
        if (r103 == null) goto L20;
        Intrinsics.checkNotNull(r103);
        m(r103, r117, true);
        r101.f405590b = null;
    L20:
        z0 r104 = this.f405596a;
        String r105 = r111.f405558c;
        Intrinsics.checkNotNull(r105);
        r114.o(r104, r115, r105);
        return r101;
    L22:
        r114.o(this.f405596a, r115, null);
        return i(r101, r111, r112, r113, r114, r115, r116, r117);
    L11:
        r101 = r110;
        goto L13
    L8:
        return i(r110, r111, r112, r113, r114, r115, r116, r117);
    L5:
        r100 = false;
        goto L6
    }
}
