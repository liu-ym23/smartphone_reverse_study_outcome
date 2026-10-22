package com.relax.relaxframework;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.relax.runtime.gen.NativeLayoutProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class RxPageImpl extends RxElementImpl implements i5, u0 {
    public static final /* synthetic */ int E = 0;
    public final Map<Integer, RxElementImpl> A;
    public final Map<Integer, Function0<Unit>> B;
    public boolean C;
    public final Map<Integer, ArrayList<Function0<Unit>>> D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OwnerImpl f404948x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<RxElementImpl> f404949y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ArrayList<Double> f404950z;

    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean U() {
        return true;
    }

    @Override // com.relax.relaxframework.i5
    public final void e() {
        this.C = true;
    }

    public final void c0() {
        OwnerImpl r100 = this.f404948x;
        Intrinsics.checkNotNull(r100);
        RelaxInstance r101 = r100.f404835b;
        Intrinsics.checkNotNull(r101);
        NativeLayoutProxy r102 = r101.getLayoutProxy();
        Intrinsics.checkNotNull(r102);
        qpa.e r103 = r101.getShadowNodeProxy();
        Intrinsics.checkNotNull(r103);
        qpa.f r104 = r101.getUIProxy();
        Intrinsics.checkNotNull(r104);
        ArrayList<Integer> r105 = r102.k();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
        IntCompanionObject r106 = IntCompanionObject.INSTANCE;
        int r107 = com.bytedance.rts.foundation.j.d(r105);
        com.bytedance.rts.foundation.k.c(r106, r107);
        if (r107 > 0) goto L38;
        ArrayList<Integer> r108 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        if (this.B.size() <= 0) goto L7;
        r108 = com.bytedance.rts.foundation.m.c(this.B);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
    L7:
        ArrayList<Double> r109 = r102.p(r108);
        int r110 = com.bytedance.rts.foundation.j.d(r105);
        com.bytedance.rts.foundation.k.c(r106, r110);
        if (r110 > 0) goto L36;
        int r111 = com.bytedance.rts.foundation.j.d(r109);
        com.bytedance.rts.foundation.k.c(r106, r111);
        int r112 = (r111 - RelaxFrameworkKt.E) / RelaxFrameworkKt.F;
        ArrayList r113 = new ArrayList();
        int r114 = 0;
    L10:
        if (r114 >= r112) goto L25;
        int r115 = RelaxFrameworkKt.E;
        int r116 = RelaxFrameworkKt.F;
        int r117 = r115 + (r114 * r116);
        int r118 = com.bytedance.rts.foundation.c.f267576a;
        int r119 = com.bytedance.rts.foundation.d.f267577a;
        int r120 = (int) ((Number) ListProtector.get(r109, r117)).doubleValue();
        Map<Integer, RxElementImpl> r121 = this.A;
        LinkedHashMap r122 = (LinkedHashMap) r121;
        RxElementImpl r123 = (RxElementImpl) r122.get(Integer.valueOf(r120));
        if (r123 == null) goto L24;
        b4 r124 = new b4(((Number) ListProtector.get(r109, r117 + 1)).doubleValue(), ((Number) ListProtector.get(r109, r117 + 2)).doubleValue(), ((Number) ListProtector.get(r109, r117 + 3)).doubleValue(), ((Number) ListProtector.get(r109, r117 + 4)).doubleValue());
        Intrinsics.checkNotNullParameter(r124, SVGRenderEngine.RECT);
        r123.f404929r = r124;
        ArrayList<Double> r125 = com.bytedance.rts.foundation.j.l(r109, r117 + 5, r117 + r116);
        Intrinsics.checkNotNullParameter(r125, "info");
        r123.f404930s = r125;
        if (r123.f404931t == false) goto L16;
        com.bytedance.rts.foundation.j.j(r113, r123);
        goto L24
    L16:
        RxElementImpl r126 = r123.f404920i;
        if (r126 == null) goto L21;
        boolean r127 = true;
        if (r126.f404931t != true) goto L21;
    L22:
        if (r127 == false) goto L24;
        Intrinsics.checkNotNull(r126);
        com.bytedance.rts.foundation.j.j(r113, r126);
    L21:
        r127 = false;
    L24:
        r114 = r114 + 1;
        goto L10
    L25:
        int r128 = 0;
    L26:
        if (r128 >= r112) goto L34;
        int r129 = RelaxFrameworkKt.E + (RelaxFrameworkKt.F * r128);
        int r130 = com.bytedance.rts.foundation.c.f267576a;
        int r131 = com.bytedance.rts.foundation.d.f267577a;
        int r132 = (int) ((Number) ListProtector.get(r109, r129)).doubleValue();
        Map<Integer, RxElementImpl> r133 = this.A;
        LinkedHashMap r134 = (LinkedHashMap) r133;
        RxElementImpl r135 = (RxElementImpl) r134.get(Integer.valueOf(r132));
        if (r135 == null) goto L33;
        if (r135.f404925n == false) goto L32;
        NativeNodeType r136 = NativeNodeType.UINode;
        Intrinsics.checkNotNullParameter(r136, "type");
        ArrayList<RxElementImpl> r137 = com.bytedance.rts.foundation.j.k(new RxElementImpl[0]);
        r135.D(r136, new RxElementImpl$findNativeChildren$1(r137));
        r135.Y(r137);
        goto L33
    L32:
        b4 r138 = r135.G();
        ListProtector.set(r109, r129 + 1, Double.valueOf(r138.f405020a));
        ListProtector.set(r109, r129 + 2, Double.valueOf(r138.f405021b));
    L33:
        r128 = r128 + 1;
        goto L26
    L34:
        r104.getClass();
        throw null;
    L36:
        int r139 = com.bytedance.rts.foundation.d.f267577a;
        ((Number) ListProtector.get(r105, 0)).intValue();
        r103.getClass();
        throw null;
    L38:
        int r140 = com.bytedance.rts.foundation.d.f267577a;
        ((Number) ListProtector.get(r105, 0)).intValue();
        r103.getClass();
        throw null;
    }

    public final void d0() {
        if (this.f404932u.rtsPipelineEnabled() == false) goto L71;
        int r100 = 0;
        int r101 = 0;
        boolean r102 = false;
    L5:
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        int r104 = com.bytedance.rts.foundation.j.d(this.f404949y);
        com.bytedance.rts.foundation.k.c(r103, r104);
        if (r101 >= r104) goto L51;
        ArrayList<RxElementImpl> r105 = this.f404949y;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        final RxElementImpl r107 = (RxElementImpl) ListProtector.get(r105, r101);
        r107.getClass();
        final Ref.BooleanRef r108 = new Ref.BooleanRef();
        a2 r109 = r107.F();
        if (r109 == null) goto L10;
        r109.h(new RxElementImpl$updateLayout$1(r108, r107));
    L10:
        boolean r110 = r108.element;
        final boolean r111 = r107 instanceof RxTextImpl;
        final Ref.BooleanRef r112 = new Ref.BooleanRef();
        a2 r113 = r107.F();
        if (r113 == null) goto L14;
        r113.b(new RxElementImpl$updateStyle$1(r107, r112, r111));
    L14:
        if (r107.f404930s != null) goto L16;
    L18:
        a2 r114 = r107.F();
        if (r114 == null) goto L21;
        boolean r115 = r114.i(CSSModifierProperty.Position);
    L22:
        if (r115 == false) goto L33;
        a2 r116 = r107.F();
        if (r116 == null) goto L28;
        m3 r117 = r116.f();
        if (r117 == null) goto L28;
    L30:
        if (r117.f405190a == r117.f405191b) goto L33;
        final RxElementImpl r118 = r107.B(NativeNodeType.UINode);
        Intrinsics.checkNotNull(r118);
        j5 r119 = r107.f404932u.getRootElement();
        Intrinsics.checkNotNull(r119);
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type com.relax.relaxframework.ElementManager");
        ((u0) r119).c(r107, r117.f405190a, new RxElementImpl$checkPositionFixed$1(r107, r118));
    L28:
        r117 = new m3();
    L33:
        if (r107.s(NativeNodeType.UINode) == false) goto L40;
        if (r107.f404932u.getUIProxy() == null) goto L40;
        r107.X();
        throw null;
    L40:
        if (r107.s(NativeNodeType.ShadowNode) == true) goto L42;
    L45:
        r107.f404923l = false;
        a2 r120 = r107.F();
        if (r120 == null) goto L48;
        r120.g();
    L48:
        if (r110 == false) goto L50;
        r102 = true;
    L50:
        r101 = r101 + 1;
        goto L5
    L42:
        if (r107.f404932u.getShadowNodeProxy() == null) goto L45;
        throw null;
    L21:
        r115 = false;
        goto L22
    L16:
        if (r112.element == false) goto L18;
        r107.J();
        goto L18
    L51:
        this.f404949y = com.bytedance.rts.foundation.j.k(new RxElementImpl[0]);
        if (r102 == false) goto L54;
        this.C = true;
    L56:
        int r121 = this.f404921j;
        ArrayList r122 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        if (this.B.size() <= 0) goto L59;
        r122 = com.bytedance.rts.foundation.m.c(this.B);
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
    L59:
        IntCompanionObject r123 = IntCompanionObject.INSTANCE;
        int r124 = com.bytedance.rts.foundation.j.d(r122);
        com.bytedance.rts.foundation.k.c(r123, r124);
        if (r100 >= r124) goto L66;
        int r125 = com.bytedance.rts.foundation.d.f267577a;
        int r126 = ((Number) ListProtector.get(r122, r100)).intValue();
        Map<Integer, Function0<Unit>> r127 = this.B;
        LinkedHashMap r128 = (LinkedHashMap) r127;
        if (r128.get(Integer.valueOf(r126)) != null) goto L64;
        RxElementImpl.a r129 = RxElementImpl.f404912w;
        NativeNodeType r130 = NativeNodeType.UINode;
        r129.getClass();
        RxElementImpl.a.a(r130, r121, r126, -1);
    L64:
        r100 = r100 + 1;
        goto L59
    L66:
        if (this.C == false) goto L82;
        c0();
        throw null;
    L82:
        return;
    L54:
        OwnerImpl r131 = this.f404948x;
        Intrinsics.checkNotNull(r131);
        RelaxInstance r132 = r131.f404835b;
        Intrinsics.checkNotNull(r132);
        if (r132.getUIProxy() == null) goto L56;
        throw null;
    L71:
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().c0();
    }

    public RxPageImpl(PageWrapper r100) {
        int r101 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        RelaxInstance r102 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r102);
        if (r102.rtsPipelineEnabled() == false) goto L5;
        Long r103 = null;
    L9:
        super("page", r103);
        this.f404949y = com.bytedance.rts.foundation.j.k(new RxElementImpl[0]);
        this.f404950z = com.bytedance.rts.foundation.j.k(new Double[0]);
        this.A = new LinkedHashMap();
        this.B = new LinkedHashMap();
        this.D = new LinkedHashMap();
        this.f404948x = OwnerImpl.f404833g;
        if (this.f404932u.rtsPipelineEnabled() == true) goto L15;
        RelaxFrameworkKt.f404892v = Long.valueOf(E());
        final WeakReference r104 = new WeakReference(this);
        if (r100 == null) goto L17;
        r100.setPagePhaseListener(new k3(new AnonymousClass1(r104), new AnonymousClass2(r104), new AnonymousClass3(r104)));
        return;
    L17:
        return;
    L15:
        new WeakReference(this);
        OwnerImpl r105 = this.f404948x;
        Intrinsics.checkNotNull(r105);
        RelaxInstance r106 = r105.f404835b;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r106.getContextProxy());
        OwnerImpl r107 = this.f404948x;
        Intrinsics.checkNotNull(r107);
        RelaxInstance r108 = r107.f404835b;
        Intrinsics.checkNotNull(r108);
        NativeLayoutProxy r109 = r108.getLayoutProxy();
        Intrinsics.checkNotNull(r109);
        OwnerImpl r110 = this.f404948x;
        Intrinsics.checkNotNull(r110);
        RelaxInstance r111 = r110.f404835b;
        Intrinsics.checkNotNull(r111);
        qpa.e r112 = r111.getShadowNodeProxy();
        Intrinsics.checkNotNull(r112);
        OwnerImpl r113 = this.f404948x;
        Intrinsics.checkNotNull(r113);
        RelaxInstance r114 = r113.f404835b;
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNull(r114.getUIProxy());
        RelaxFrameworkKt.f404892v = Long.valueOf(r109.l());
        r112.getClass();
        throw null;
    L5:
        if (r100 == null) goto L7;
        long r115 = r100.rawRelaxPage();
    L8:
        r103 = Long.valueOf(r115);
        goto L9
    L7:
        r115 = RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().D();
        goto L8
    }

    @Override // com.relax.relaxframework.u0
    public final void f(RxElementImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        com.bytedance.rts.foundation.m.e(this.A, Integer.valueOf(r100.f404921j), r100);
    }

    @Override // com.relax.relaxframework.i5
    public final void k(RxElementImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        com.bytedance.rts.foundation.j.j(this.f404949y, r100);
    }

    @Override // com.relax.relaxframework.u0
    public final void l(RxElementImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        com.bytedance.rts.foundation.m.delete(this.A, Integer.valueOf(r100.f404921j));
        if (com.bytedance.rts.foundation.m.b(this.B, Integer.valueOf(r100.f404921j)) == false) goto L6;
        com.bytedance.rts.foundation.m.delete(this.B, Integer.valueOf(r100.f404921j));
        Q(r100);
        return;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public final void x(int r100) {
        NativeLayoutProxy r101 = this.f404932u.getLayoutProxy();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    public static final void b0(RxPageImpl r100, int r101) {
        Map<Integer, ArrayList<Function0<Unit>>> r102 = r100.D;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        ArrayList r104 = (ArrayList) r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L8;
        Iterator r105 = r104.iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        ((Function0) r105.next()).invoke();
        goto L6
    L10:
        return;
    }

    @Override // com.relax.relaxframework.u0
    public final void c(RxElementImpl r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (r100.f404930s == null) goto L5;
        boolean r103 = true;
    L6:
        if (r101 == false) goto L12;
        com.bytedance.rts.foundation.m.e(this.B, Integer.valueOf(r100.f404921j), r102);
        NativeNodeType r104 = NativeNodeType.UINode;
        Intrinsics.checkNotNullParameter(r104, "type");
        if (r100.s(r104) == false) goto L11;
        if (r103 == false) goto L11;
        RxElementImpl.a r105 = RxElementImpl.f404912w;
        RxElementImpl r106 = r100.B(r104);
        Intrinsics.checkNotNull(r106);
        int r107 = r106.f404921j;
        int r108 = r100.f404921j;
        r105.getClass();
        RxElementImpl.a.b(r104, r107, r108);
    L11:
        RxElementImpl.a r109 = RxElementImpl.f404912w;
        int r110 = this.f404921j;
        int r111 = r100.f404921j;
        r109.getClass();
        RxElementImpl.a.a(r104, r110, r111, -1);
        return;
    L12:
        if (r103 == false) goto L18;
        Map<Integer, Function0<Unit>> r112 = this.B;
        LinkedHashMap r113 = (LinkedHashMap) r112;
        Function0 r114 = (Function0) r113.get(Integer.valueOf(r100.f404921j));
        RxElementImpl.a r115 = RxElementImpl.f404912w;
        NativeNodeType r116 = NativeNodeType.UINode;
        int r117 = this.f404921j;
        int r118 = r100.f404921j;
        r115.getClass();
        RxElementImpl.a.b(r116, r117, r118);
        com.bytedance.rts.foundation.m.delete(this.B, Integer.valueOf(r100.f404921j));
        if (r114 == null) goto L19;
        r114.invoke();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
