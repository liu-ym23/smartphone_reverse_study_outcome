package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.relax.runtime.gen.NativeLayoutProxy;
import com.relax.runtime.gen.PageConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public class RxElementImpl extends c1 implements j5, p1 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f404912w = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f404913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f404914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f404915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RxElementImpl f404916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RxElementImpl f404917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RxElementImpl f404918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RxElementImpl f404919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RxElementImpl f404920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f404921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f404922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f404923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f404924m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f404925n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f404926o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f404927p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a3 f404928q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b4 f404929r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<Double> f404930s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f404931t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RelaxInstance f404932u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<Integer, BaseGesture> f404933v;

    public static final class a {

        /* JADX INFO: renamed from: com.relax.relaxframework.RxElementImpl$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4694a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f404934a = null;

            static {
                int[] r100 = new int[NativeNodeType.values().length];
                r100[NativeNodeType.UINode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[NativeNodeType.LayoutNode.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[NativeNodeType.ShadowNode.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f404934a = r100;
            }
        }

        public a() {
        }

        public static void b(NativeNodeType r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            int r103 = C4694a.f404934a[r100.ordinal()];
            if (r103 != 1) goto L5;
            RelaxInstance.Companion.getClass();
            RelaxInstance r104 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r104);
            if (r104.getUIProxy() == null) goto L21;
            throw null;
        L21:
            return;
        L5:
            if (r103 != 2) goto L7;
            RelaxInstance.Companion.getClass();
            RelaxInstance r105 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r105);
            NativeLayoutProxy r106 = r105.getLayoutProxy();
            if (r106 == null) goto L18;
            r106.o(r101, r102);
            return;
        L18:
            return;
        L7:
            if (r103 == 3) goto L9;
            return;
        L9:
            RelaxInstance.Companion.getClass();
            RelaxInstance r107 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r107);
            if (r107.getShadowNodeProxy() == null) goto L22;
            throw null;
        }

        public static void a(NativeNodeType r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "type");
            int r104 = C4694a.f404934a[r100.ordinal()];
            if (r104 != 1) goto L5;
            RelaxInstance.Companion.getClass();
            RelaxInstance r105 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r105);
            if (r105.getUIProxy() == null) goto L21;
            throw null;
        L21:
            return;
        L5:
            if (r104 != 2) goto L7;
            RelaxInstance.Companion.getClass();
            RelaxInstance r106 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r106);
            NativeLayoutProxy r107 = r106.getLayoutProxy();
            if (r107 == null) goto L18;
            r107.m(r101, r102, r103);
            return;
        L18:
            return;
        L7:
            if (r104 == 3) goto L9;
            return;
        L9:
            RelaxInstance.Companion.getClass();
            RelaxInstance r108 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r108);
            if (r108.getShadowNodeProxy() == null) goto L22;
            throw null;
        }
    }

    public boolean I() {
        return this instanceof u5;
    }

    public boolean U() {
        return !(this instanceof q4);
    }

    public boolean V() {
        return this instanceof h5;
    }

    public boolean W() {
        return !(this instanceof q4);
    }

    static {
        f404912w = new a();
    }

    public final long E() {
        Long r100 = this.f404914c;
        Intrinsics.checkNotNull(r100);
        return r100.longValue();
    }

    public final a2 F() {
        a3 r100 = this.f404928q;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f405003d;
    }

    public final b4 G() {
        b4 r100 = this.f404929r;
        double r101 = r100.f405020a;
        double r102 = r100.f405021b;
        RxElementImpl r103 = this.f404920i;
        double r104 = r102;
        double r105 = r101;
    L3:
        if (r103 == null) goto L7;
        if (r103.s(NativeNodeType.UINode) == true) goto L7;
        b4 r106 = r103.f404929r;
        r105 = r105 + r106.f405020a;
        r104 = r104 + r106.f405021b;
        r103 = r103.f404920i;
    L7:
        b4 r107 = this.f404929r;
        return new b4(r105, r104, r107.f405022c, r107.f405023d);
    }

    public final boolean H() {
        RxElementImpl r100 = this.f404920i;
        if (r100 == null) goto L12;
        Intrinsics.checkNotNull(r100);
        r100.getClass();
        if ((r100 instanceof RxTextImpl) == true) goto L10;
        RxElementImpl r101 = this.f404920i;
        Intrinsics.checkNotNull(r101);
        if (r101.I() == true) goto L13;
        RxElementImpl r102 = this.f404920i;
        Intrinsics.checkNotNull(r102);
        if (r102.H() == true) goto L10;
        return false;
    L13:
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    public final void J() {
        NativeLayoutProxy r100 = this.f404932u.getLayoutProxy();
        if (r100 == null) goto L5;
        r100.n(this.f404921j);
    L5:
        L();
    }

    public final void K() {
        if (this.f404925n == false) goto L22;
        this.f404925n = false;
        if (W() == false) goto L18;
        if (this.f404932u.getUIProxy() == null) goto L14;
        if (I() == false) goto L11;
        int r100 = l5.f405179a;
    L11:
        X();
        throw null;
    L14:
        if (this.f404930s == null) goto L16;
        Y(Z(NativeNodeType.UINode));
        goto L18
    L16:
        Z(NativeNodeType.UINode);
    L18:
        if (V() == false) goto L23;
        qpa.e r101 = this.f404932u.getShadowNodeProxy();
        Intrinsics.checkNotNull(r101);
        r101.getClass();
        throw null;
    L23:
        return;
    }

    public final void L() {
        j5 r100 = this.f404932u.getRootElement();
        if ((r100 instanceof i5) == false) goto L5;
        i5 r101 = (i5) r100;
    L6:
        if (r101 == null) goto L9;
        r101.e();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void X() {
        if (this.f404924m == false) goto L19;
        PageConfig r100 = this.f404932u.getPageConfig();
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.getEnableFlatten() != true) goto L9;
    L10:
        if (r101 == true) goto L12;
        return;
    L12:
        if (I() == true) goto L14;
    L17:
        H();
        return;
    L14:
        if (this.f404927p != 0) goto L17;
        if (this.f404926o == false) goto L17;
        return;
    L9:
        r101 = false;
        goto L10
    }

    @Override // com.relax.relaxframework.p1
    public final void markDirty() {
        if (this.f404923l == false) goto L5;
        return;
    L5:
        j5 r100 = this.f404932u.getRootElement();
        if ((r100 instanceof i5) == false) goto L8;
        i5 r101 = (i5) r100;
    L9:
        if (r101 == null) goto L11;
        r101.k(this);
    L11:
        this.f404923l = true;
        return;
    L8:
        r101 = null;
        goto L9
    }

    @Override // com.relax.relaxframework.c1
    public final c1 r() {
        RxElementImpl r100 = this.f404920i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return null;
    }

    public final void y() {
        j5 r100 = this.f404932u.getRootElement();
        if ((r100 instanceof u0) == false) goto L5;
        u0 r101 = (u0) r100;
    L6:
        if (r101 == null) goto L8;
        r101.l(this);
    L8:
        NativeNodeType r102 = NativeNodeType.UINode;
        if (s(r102) == false) goto L15;
        B(r102);
        if (this.f404932u.getUIProxy() == null) goto L15;
        throw null;
    L15:
        if (s(NativeNodeType.LayoutNode) == false) goto L20;
        NativeLayoutProxy r103 = this.f404932u.getLayoutProxy();
        if (r103 == null) goto L20;
        r103.j(this.f404921j);
    L20:
        if (s(NativeNodeType.ShadowNode) == true) goto L22;
    L25:
        RxElementImpl$destroyNativeNodes$1 r104 = RxElementImpl$destroyNativeNodes$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "callback");
        RxElementImpl r105 = this.f404916e;
    L26:
        if (r105 == null) goto L28;
        r104.invoke(r105);
        r105 = r105.f404918g;
        goto L26
    L28:
        return;
    L22:
        if (this.f404932u.getShadowNodeProxy() == null) goto L25;
        throw null;
    L5:
        r101 = null;
        goto L6
    }

    public final void z() {
        if (RelaxFrameworkKt.f404893w != 0) goto L6;
        int r100 = p4.f405213a;
        Intrinsics.checkNotNullParameter(FeatureList.RendererDestroyElement, "feature");
        RelaxFrameworkKt.f404893w = 2;
    L6:
        if (RelaxFrameworkKt.f404893w == 2) goto L8;
        return;
    L8:
        if (this.f404932u.rtsPipelineEnabled() == true) goto L10;
        Long r101 = this.f404914c;
        Intrinsics.checkNotNull(r101);
        long r102 = r101.longValue();
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().b0(r102);
    L10:
        y();
    }

    public final void O() {
        a2 r100 = F();
        boolean r101 = false;
        if (r100 == null) goto L9;
        m3 r102 = r100.f();
        if (r102 == null) goto L9;
        if (r102.f405190a != true) goto L9;
        r101 = true;
    L9:
        if (r101 == true) goto L11;
        P(NativeNodeType.UINode);
    L11:
        P(NativeNodeType.LayoutNode);
        P(NativeNodeType.ShadowNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RxElementImpl A(final NativeNodeType r100) {
        if (s(r100) == false) goto L5;
        return this;
    L5:
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        Function1<RxElementImpl, Boolean> r102 = new RxElementImpl$findFirstNativeDescendant$1(r101, r100);
        Intrinsics.checkNotNullParameter(r102, "callback");
        RxElementImpl r103 = this.f404916e;
    L6:
        if (r103 == null) goto L12;
        if (r102.invoke(r103).booleanValue() == true) goto L12;
        r103 = r103.f404918g;
    L12:
        return (RxElementImpl) r101.element;
    }

    public final RxElementImpl B(NativeNodeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        RxElementImpl r101 = this.f404920i;
    L3:
        if (r101 == null) goto L8;
        if (r101.s(r100) == true) goto L6;
        r101 = r101.f404920i;
        goto L3
    L6:
        return r101;
    L8:
        return null;
    }

    public final RxElementImpl C(NativeNodeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        RxElementImpl r101 = this.f404918g;
    L3:
        if (r101 == null) goto L8;
        RxElementImpl r102 = r101.A(r100);
        if (r102 != null) goto L6;
        r101 = r101.f404918g;
        goto L3
    L6:
        return r102;
    L8:
        RxElementImpl r103 = this.f404920i;
        if (r103 != null) goto L11;
        return null;
    L11:
        if (r103.s(r100) == false) goto L13;
        return null;
    L13:
        return r103.C(r100);
    }

    public final void M(j5 r100) {
        if (r100 == null) goto L5;
        t(r100);
        return;
    }

    public final void N(ArrayList<j5> r100) {
        if (r100 == null) goto L7;
        int r101 = 0;
    L4:
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r102, r103);
        if (r101 >= r103) goto L9;
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        t((j5) ListProtector.get(r100, r101));
        r101 = r101 + 1;
        goto L4
    L9:
        return;
    }

    public final void P(final NativeNodeType r100) {
        final RxElementImpl r101 = B(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        RxElementImpl r102 = C(r100);
        final Ref.IntRef r103 = new Ref.IntRef();
        if (r102 != null) goto L8;
        int r104 = -1;
    L9:
        r103.element = r104;
        D(r100, new RxElementImpl$mountNativeNodesOfType$1(r100, r101, r103));
        return;
    L8:
        r104 = r102.f404921j;
        goto L9
    }

    public final void Q(j5 r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        RxElementImpl r101 = (RxElementImpl) r100;
        r101.getClass();
        final NativeNodeType r102 = NativeNodeType.UINode;
        final RxElementImpl r103 = r101.B(r102);
        if (r103 == null) goto L6;
        r101.D(r102, new RxElementImpl$unmountNativeNodesOfType$1(r102, r103));
    L6:
        final NativeNodeType r104 = NativeNodeType.LayoutNode;
        final RxElementImpl r105 = r101.B(r104);
        if (r105 == null) goto L10;
        r101.D(r104, new RxElementImpl$unmountNativeNodesOfType$1(r104, r105));
    L10:
        final NativeNodeType r106 = NativeNodeType.ShadowNode;
        final RxElementImpl r107 = r101.B(r106);
        if (r107 == null) goto L14;
        r101.D(r106, new RxElementImpl$unmountNativeNodesOfType$1(r106, r107));
    L14:
        RxElementImpl r108 = r101.f404919h;
        if (r108 == null) goto L17;
        Intrinsics.checkNotNull(r108);
        r108.f404918g = r101.f404918g;
    L18:
        RxElementImpl r109 = r101.f404918g;
        if (r109 == null) goto L21;
        Intrinsics.checkNotNull(r109);
        r109.f404919h = r101.f404919h;
    L22:
        r101.f404919h = null;
        r101.f404918g = null;
        r101.f404920i = null;
        if (this.f404932u.rtsPipelineEnabled() == true) goto L25;
        Long r110 = this.f404914c;
        Intrinsics.checkNotNull(r110);
        long r111 = r110.longValue();
        Long r112 = r101.f404914c;
        Intrinsics.checkNotNull(r112);
        long r113 = r112.longValue();
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().h0(r111, r113);
    L25:
        L();
        return;
    L21:
        this.f404917f = r101.f404919h;
        goto L22
    L17:
        this.f404916e = r101.f404918g;
        goto L18
    }

    public final void R(Function0<? extends ArrayList<j5>> r100) {
        Intrinsics.checkNotNullParameter(r100, "children");
        N(r100.invoke());
    }

    public final void S(NativeNodeType r100) {
        int r101 = this.f404922k;
        this.f404922k = r100.getValue() | r101;
    }

    public final void Y(ArrayList<RxElementImpl> r100) {
        Intrinsics.checkNotNullParameter(r100, "nativeChildren");
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r101, r102);
        if (r102 != 0) goto L5;
        return;
    L5:
        int r103 = 0;
        ArrayList<Double> r104 = com.bytedance.rts.foundation.j.k(new Double[0]);
        com.bytedance.rts.foundation.j.j(r104, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        com.bytedance.rts.foundation.j.j(r104, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        w(r104);
    L6:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        int r106 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r105, r106);
        if (r103 >= r106) goto L10;
        int r107 = com.bytedance.rts.foundation.d.f267577a;
        ((RxElementImpl) ListProtector.get(r100, r103)).w(r104);
        r103 = r103 + 1;
        goto L6
    L10:
        if (this.f404932u.getUIProxy() == null) goto L12;
        throw null;
    L12:
        if (this.f404932u.getShadowNodeProxy() != null) goto L14;
        return;
    L14:
        throw null;
    }

    public final ArrayList<RxElementImpl> Z(NativeNodeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        RxElementImpl r101 = C(r100);
        RxElementImpl r102 = B(r100);
        Intrinsics.checkNotNullParameter(r100, "type");
        int r103 = 0;
        ArrayList<RxElementImpl> r104 = com.bytedance.rts.foundation.j.k(new RxElementImpl[0]);
        D(r100, new RxElementImpl$findNativeChildren$1(r104));
        S(r100);
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        int r105 = -1;
    L7:
        a r106 = f404912w;
        int r107 = r102.f404921j;
        int r108 = this.f404921j;
        r106.getClass();
        a.a(r100, r107, r108, r105);
        goto L8
    L6:
        r105 = r101.f404921j;
    L8:
        IntCompanionObject r109 = IntCompanionObject.INSTANCE;
        int r110 = com.bytedance.rts.foundation.j.d(r104);
        com.bytedance.rts.foundation.k.c(r109, r110);
        if (r103 >= r110) goto L14;
        int r111 = com.bytedance.rts.foundation.d.f267577a;
        RxElementImpl r112 = (RxElementImpl) ListProtector.get(r104, r103);
        if (r102 == null) goto L13;
        a r113 = f404912w;
        int r114 = r102.f404921j;
        int r115 = r112.f404921j;
        r113.getClass();
        a.b(r100, r114, r115);
    L13:
        a r116 = f404912w;
        int r117 = this.f404921j;
        int r118 = r112.f404921j;
        r116.getClass();
        a.a(r100, r117, r118, -1);
        r103 = r103 + 1;
        goto L8
    L14:
        return r104;
    }

    @Override // com.relax.relaxframework.c1
    public final q0 q(v0 r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        a1 r100 = this.f405031a;
        if (r100 == null) goto L5;
        ArrayList<q1> r101 = r100.a(r110.f405311b);
    L6:
        int r102 = 0;
        if (r101 == null) goto L9;
        PhaseType r103 = r110.f405313d;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("___eventPhase");
        r103 = null;
    L13:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.foundation.j.d(r101);
        com.bytedance.rts.foundation.k.c(r104, r105);
        if (r103 != PhaseType.AtTarget) goto L16;
    L19:
        int r106 = 0;
        boolean r107 = false;
        boolean r108 = false;
    L20:
        if (r106 >= r105) goto L36;
        int r111 = com.bytedance.rts.foundation.d.f267577a;
        q1 r112 = (q1) ListProtector.get(r101, r106);
        if ((r112 instanceof z0) == false) goto L35;
        z0 r113 = (z0) r112;
        EventBindType r114 = r113.f405370b;
        if (r114 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("_bindType");
        r114 = null;
    L28:
        if (r114 != EventBindType.CaptureBind) goto L30;
    L31:
        r113.a(r110);
        r108 = true;
    L33:
        if (r114 != EventBindType.CaptureCatch) goto L35;
        r107 = true;
        goto L35
    L30:
        if (r114 != EventBindType.CaptureCatch) goto L33;
    L35:
        r106 = r106 + 1;
        goto L20
    L36:
        if (r107 == true) goto L38;
    L40:
        if (r103 == PhaseType.AtTarget) goto L43;
        if (r103 == PhaseType.BubblingPhase) goto L43;
    L63:
        return new q0(EventCancelType.NotCanceled, r108);
    L43:
        if (r102 >= r105) goto L59;
        int r109 = com.bytedance.rts.foundation.d.f267577a;
        q1 r115 = (q1) ListProtector.get(r101, r102);
        if ((r115 instanceof z0) == false) goto L58;
        z0 r116 = (z0) r115;
        EventBindType r117 = r116.f405370b;
        if (r117 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("_bindType");
        r117 = null;
    L51:
        if (r117 != EventBindType.Bind) goto L53;
    L54:
        r116.a(r110);
        r108 = true;
    L56:
        if (r117 != EventBindType.Catch) goto L58;
        r107 = true;
        goto L58
    L53:
        if (r117 != EventBindType.Catch) goto L56;
    L58:
        r102 = r102 + 1;
        goto L43
    L59:
        if (r107 == false) goto L63;
        return new q0(EventCancelType.CanceledByDefaultEventHandler, r108);
    L38:
        return new q0(EventCancelType.CanceledByDefaultEventHandler, r108);
    L16:
        if (r103 == PhaseType.CapturingPhase) goto L19;
        r107 = false;
        r108 = false;
        goto L40
    L9:
        return new q0(EventCancelType.NotCanceled, false);
    L5:
        r101 = null;
        goto L6
    }

    public final boolean s(NativeNodeType r100) {
        int r101 = this.f404922k;
        if ((r100.getValue() & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void t(j5 r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        RxElementImpl r101 = (RxElementImpl) r100;
        r101.f404920i = this;
        RxElementImpl r102 = this.f404917f;
        if (r102 != null) goto L5;
        this.f404916e = r101;
    L6:
        this.f404917f = r101;
        if (this.f404932u.rtsPipelineEnabled() == true) goto L9;
        Long r103 = this.f404914c;
        Intrinsics.checkNotNull(r103);
        long r104 = r103.longValue();
        Long r105 = r101.f404914c;
        Intrinsics.checkNotNull(r105);
        long r106 = r105.longValue();
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().c(r104, r106);
    L9:
        r101.O();
        L();
        return;
    L5:
        Intrinsics.checkNotNull(r102);
        r102.f404918g = r101;
        RxElementImpl r107 = this.f404917f;
        Intrinsics.checkNotNull(r107);
        r101.f404919h = r107;
        goto L6
    }

    public final void u(final ArrayList<p6> r110) {
        Intrinsics.checkNotNullParameter(r110, "modifier");
        if (this.f404923l == true) goto L5;
        return;
    L5:
        final a3 r100 = this.f404928q;
        boolean r101 = false;
        if (r100 == null) goto L38;
        Intrinsics.checkNotNullParameter(r110, "modifierLinks");
        ArrayList<p6> r102 = new ArrayList();
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        int r104 = com.bytedance.rts.foundation.j.d(r110);
        com.bytedance.rts.foundation.k.c(r103, r104);
        int r105 = 0;
        boolean r106 = false;
    L9:
        if (r105 >= r104) goto L19;
        int r107 = com.bytedance.rts.foundation.d.f267577a;
        Object r108 = ListProtector.get(r110, r105);
        int r109 = a3.a.f405004a[((p6) r108).b().ordinal()];
        if (r109 != 1) goto L13;
        r106 = true;
    L18:
        r105 = r105 + 1;
        goto L9
    L13:
        if (r109 == 2) goto L15;
        com.bytedance.rts.foundation.j.j(r102, r108);
        goto L18
    L15:
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.relax.relaxframework.ComposedModifier___0");
        ((i0) r108).getClass();
        Intrinsics.checkNotNullParameter(r102, "res");
        new ArrayList();
        IntCompanionObject r111 = IntCompanionObject.INSTANCE;
        Intrinsics.throwUninitializedPropertyAccessException("_modifiers");
        com.bytedance.rts.foundation.j.d(null);
        throw null;
    L19:
        a2 r112 = r100.f405003d;
        if (r112 != null) goto L22;
    L25:
        if (r106 == false) goto L27;
        r100.f405003d = new ComputedStyle();
    L29:
        if (r100.f405001b == null) goto L31;
        a2 r113 = r100.f405003d;
        Intrinsics.checkNotNull(r113);
        p1 r114 = r100.f405001b;
        Intrinsics.checkNotNull(r114);
        r113.k(r114);
    L31:
        r100.f405002c = r106;
        final Ref.BooleanRef r115 = new Ref.BooleanRef();
        r115.element = true;
        if (r106 == false) goto L34;
        RelaxFrameworkKt.K(new ModifierApplier$apply$2(r110, r100, r115));
    L36:
        if (r115.element != true) goto L38;
        r101 = true;
        goto L38
    L34:
        r115.element = !r100.a(r102);
        goto L36
    L27:
        r100.f405003d = new v7();
        goto L29
    L22:
        if (r100.f405002c != r106) goto L25;
        Intrinsics.checkNotNull(r112);
        r112.g();
    L38:
        if (r101 == true) goto L45;
        K();
        return;
    }

    public final void w(ArrayList<Double> r100) {
        if (this.f404930s == null) goto L8;
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r100, Double.valueOf(this.f404921j));
        b4 r102 = G();
        com.bytedance.rts.foundation.j.j(r100, Double.valueOf(r102.f405020a));
        com.bytedance.rts.foundation.j.j(r100, Double.valueOf(r102.f405021b));
        com.bytedance.rts.foundation.j.j(r100, Double.valueOf(r102.f405022c));
        com.bytedance.rts.foundation.j.j(r100, Double.valueOf(r102.f405023d));
        int r103 = 0;
    L5:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        ArrayList<Double> r105 = this.f404930s;
        Intrinsics.checkNotNull(r105);
        int r106 = com.bytedance.rts.foundation.j.d(r105);
        com.bytedance.rts.foundation.k.c(r104, r106);
        if (r103 >= r106) goto L10;
        ArrayList<Double> r107 = this.f404930s;
        Intrinsics.checkNotNull(r107);
        int r108 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r100, ListProtector.get(r107, r103));
        r103 = r103 + 1;
        goto L5
    L10:
        return;
    }

    public void x(int r100) {
        NativeLayoutProxy r101 = this.f404932u.getLayoutProxy();
        if (r101 == null) goto L6;
        r101.d(r100, this.f404913b);
        return;
    }

    public RxElementImpl(String r110, Long r111) {
        Intrinsics.checkNotNullParameter(r110, "tagName");
        this.f404913b = "";
        boolean r100 = true;
        this.f404915d = true;
        this.f404924m = true;
        this.f404927p = OverflowDirection.Overflow.getValue();
        this.f404929r = new b4(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        RelaxInstance.Companion.getClass();
        RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r101);
        this.f404932u = r101;
        this.f404933v = new LinkedHashMap();
        this.f404913b = r110;
        this.f404914c = r111;
        int r112 = RelaxFrameworkKt.f404894x;
        RelaxFrameworkKt.f404894x = r112 + 1;
        this.f404921j = r112;
        Intrinsics.checkNotNullParameter(this, "node");
        int r113 = z2.f405371a;
        u0 r102 = null;
        if (z2.a.h() == false) goto L5;
        a3 r114 = new a3(this);
    L6:
        this.f404928q = r114;
        if (r101.rtsPipelineEnabled() == true) goto L10;
        return;
    L10:
        if (U() == false) goto L13;
        x(r112);
        S(NativeNodeType.LayoutNode);
    L13:
        if (I() == false) goto L22;
        PageConfig r115 = r101.getPageConfig();
        if (r115 != null) goto L17;
    L19:
        boolean r116 = false;
    L20:
        if (r116 == false) goto L22;
    L23:
        this.f404925n = r100;
        if (r100 == false) goto L26;
    L40:
        j5 r117 = r101.getRootElement();
        if ((r117 instanceof u0) == false) goto L43;
        r102 = (u0) r117;
    L43:
        if (r102 == null) goto L46;
        r102.f(this);
        return;
    L46:
        return;
    L26:
        if (W() == false) goto L36;
        if (r101.getUIProxy() != null) goto L30;
        S(NativeNodeType.UINode);
        goto L36
    L30:
        if (I() == false) goto L32;
        int r118 = l5.f405179a;
    L32:
        X();
        throw null;
    L36:
        if (V() == false) goto L40;
        qpa.e r119 = r101.getShadowNodeProxy();
        Intrinsics.checkNotNull(r119);
        r119.getClass();
        throw null;
    L17:
        if (r115.getEnableLayoutOnly() != true) goto L19;
        r116 = true;
    L22:
        r100 = false;
        goto L23
    L5:
        r114 = null;
        goto L6
    }

    public final void D(final NativeNodeType r100, final Function1<? super RxElementImpl, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (s(r100) == false) goto L5;
        r101.invoke(this);
        return;
    L5:
        Function1<RxElementImpl, Unit> r102 = new RxElementImpl$forEachNativeChild$1(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "callback");
        RxElementImpl r103 = this.f404916e;
    L6:
        if (r103 == null) goto L10;
        r102.invoke(r103);
        r103 = r103.f404918g;
        goto L6
    }

    public final <T> void T(T r100, final Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "refFn");
        r101.invoke(r100);
        RelaxFrameworkKt.Y(new RxElementImpl$setRefImpl$1(r101, this));
    }

    public final void a0(OverflowDirection r100, int r101) {
        if (r101 != ModifierValue_Overflow.Visible.getValue()) goto L5;
        int r102 = this.f404927p;
        this.f404927p = r100.getValue() | r102;
        return;
    L5:
        int r103 = this.f404927p;
        this.f404927p = (~r100.getValue()) & r103;
    }

    public final boolean v(String r100, z0 r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        K();
        ArrayList<q1> r102 = null;
        if (this.f404932u.getUIProxy() != null) goto L16;
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (this.f405031a != null) goto L7;
        this.f405031a = new a1();
    L7:
        a1 r103 = this.f405031a;
        Intrinsics.checkNotNull(r103);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        ArrayList<q1> r104 = r103.a(r100);
        if (r104 != null) goto L14;
        b1 r105 = new b1(r100);
        ArrayList<q1> r106 = r105.f405015b;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("___listeners");
    L13:
        com.bytedance.rts.foundation.j.j(r103.f404999a, r105);
        r104 = r102;
        goto L14
    L12:
        r102 = r106;
    L14:
        Intrinsics.checkNotNull(r104);
        com.bytedance.rts.foundation.j.j(r104, r101);
        return true;
    L16:
        throw null;
    }
}
