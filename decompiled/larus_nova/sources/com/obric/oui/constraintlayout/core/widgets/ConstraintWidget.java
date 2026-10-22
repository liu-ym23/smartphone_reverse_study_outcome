package com.obric.oui.constraintlayout.core.widgets;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.DependencyNode;
import com.obric.oui.constraintlayout.core.widgets.analyzer.k;
import com.obric.oui.constraintlayout.core.widgets.analyzer.m;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public class ConstraintWidget {
    public int A;
    public float B;
    public int C;
    public float D;
    public int[] E;
    public float F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f399700J;
    public int K;
    public final ConstraintAnchor L;
    public final ConstraintAnchor M;
    public final ConstraintAnchor N;
    public final ConstraintAnchor O;
    public final ConstraintAnchor P;
    public final ConstraintAnchor Q;
    public final ConstraintAnchor R;
    public final ConstraintAnchor S;
    public final ConstraintAnchor[] T;
    public final ArrayList<ConstraintAnchor> U;
    public final boolean[] V;
    public DimensionBehaviour[] W;
    public ConstraintWidget X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f399701a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f399702a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c f399703b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f399704b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c f399705c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f399706c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f399707d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f399708d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f399709e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f399710e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f399711f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f399712f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f399713g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f399714g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f399715h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f399716h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f399717i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f399718i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399719j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Object f399720j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.obric.oui.constraintlayout.core.state.a f399721k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f399722k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f399723l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f399724l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f399725m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f399726m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f399727n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f399728n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f399729o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f399730o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f399731p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f399732p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f399733q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final float[] f399734q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f399735r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final ConstraintWidget[] f399736r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f399737s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final ConstraintWidget[] f399738s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f399739t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ConstraintWidget f399740t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f399741u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ConstraintWidget f399742u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f399743v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f399744v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f399745w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f399746w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f399747x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f399748y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f399749z;

    public static final enum DimensionBehaviour extends Enum<DimensionBehaviour> {
        public static final DimensionBehaviour FIXED = null;
        public static final DimensionBehaviour MATCH_CONSTRAINT = null;
        public static final DimensionBehaviour MATCH_PARENT = null;
        public static final DimensionBehaviour WRAP_CONTENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DimensionBehaviour[] f399750a = null;

        static {
            DimensionBehaviour r100 = new DimensionBehaviour("FIXED", 0);
            FIXED = r100;
            DimensionBehaviour r101 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r101;
            DimensionBehaviour r102 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r102;
            DimensionBehaviour r103 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r103;
            f399750a = new DimensionBehaviour[]{r100, r101, r102, r103};
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) f399750a.clone();
        }

        public static DimensionBehaviour valueOf(String r100) {
            return (DimensionBehaviour) r27.a.a(DimensionBehaviour.class, r100);
        }

        public DimensionBehaviour(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399751a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f399752b = null;

        static {
            int[] r100 = new int[DimensionBehaviour.values().length];
            f399752b = r100;
            r100[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            f399752b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            f399752b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            f399752b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r101 = new int[ConstraintAnchor.Type.values().length];
            f399751a = r101;
            r101[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            f399751a[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            f399751a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            f399751a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            f399751a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            f399751a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            f399751a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            f399751a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            f399751a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public final void H() {
        this.f399725m = false;
        this.f399727n = false;
        this.f399729o = false;
        this.f399731p = false;
        int r100 = this.U.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ConstraintAnchor r102 = (ConstraintAnchor) ListProtector.get(this.U, r101);
        r102.f399691c = false;
        r102.f399690b = 0;
        r101 = r101 + 1;
        goto L3
    }

    public ConstraintWidget() {
        this.f399701a = false;
        this.f399707d = null;
        this.f399709e = null;
        this.f399711f = new boolean[]{true, true};
        this.f399713g = true;
        this.f399715h = true;
        this.f399717i = -1;
        this.f399719j = -1;
        this.f399721k = new com.obric.oui.constraintlayout.core.state.a(this);
        this.f399725m = false;
        this.f399727n = false;
        this.f399729o = false;
        this.f399731p = false;
        this.f399733q = -1;
        this.f399735r = -1;
        this.f399737s = 0;
        this.f399739t = 0;
        this.f399741u = 0;
        this.f399743v = new int[2];
        this.f399745w = 0;
        this.f399747x = 0;
        this.f399748y = 1.0f;
        this.f399749z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = -1;
        this.D = 1.0f;
        this.E = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.F = Float.NaN;
        this.G = false;
        this.I = false;
        this.f399700J = 0;
        this.K = 0;
        ConstraintAnchor r100 = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.L = r100;
        ConstraintAnchor r101 = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.M = r101;
        ConstraintAnchor r102 = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.N = r102;
        ConstraintAnchor r103 = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.O = r103;
        ConstraintAnchor r110 = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.P = r110;
        ConstraintAnchor r111 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.Q = r111;
        ConstraintAnchor r112 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.R = r112;
        ConstraintAnchor r113 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.S = r113;
        this.T = new ConstraintAnchor[]{r100, r102, r101, r103, r110, r113};
        ArrayList<ConstraintAnchor> r114 = new ArrayList();
        this.U = r114;
        this.V = new boolean[2];
        DimensionBehaviour r115 = DimensionBehaviour.FIXED;
        this.W = new DimensionBehaviour[]{r115, r115};
        this.X = null;
        this.Y = 0;
        this.Z = 0;
        this.f399702a0 = 0.0f;
        this.f399704b0 = -1;
        this.f399706c0 = 0;
        this.f399708d0 = 0;
        this.f399710e0 = 0;
        this.f399716h0 = 0.5f;
        this.f399718i0 = 0.5f;
        this.f399722k0 = 0;
        this.f399724l0 = false;
        this.f399726m0 = null;
        this.f399728n0 = null;
        this.f399730o0 = 0;
        this.f399732p0 = 0;
        this.f399734q0 = new float[]{-1.0f, -1.0f};
        this.f399736r0 = new ConstraintWidget[]{null, null};
        this.f399738s0 = new ConstraintWidget[]{null, null};
        this.f399740t0 = null;
        this.f399742u0 = null;
        this.f399744v0 = -1;
        this.f399746w0 = -1;
        r114.add(r100);
        r114.add(r101);
        r114.add(r102);
        r114.add(r103);
        r114.add(r111);
        r114.add(r112);
        r114.add(r113);
        r114.add(r110);
    }

    public final boolean A() {
        ConstraintAnchor r100 = this.L;
        ConstraintAnchor r101 = r100.f399694f;
        if (r101 != null) goto L5;
    L6:
        ConstraintAnchor r102 = this.N;
        ConstraintAnchor r103 = r102.f399694f;
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.f399694f != r102) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r101.f399694f != r100) goto L6;
        return true;
    }

    public final boolean B() {
        ConstraintAnchor r100 = this.M;
        ConstraintAnchor r101 = r100.f399694f;
        if (r101 != null) goto L5;
    L6:
        ConstraintAnchor r102 = this.O;
        ConstraintAnchor r103 = r102.f399694f;
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.f399694f != r102) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r101.f399694f != r100) goto L6;
        return true;
    }

    public final boolean C() {
        if (this.f399713g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f399722k0 == 8) goto L7;
        return true;
    }

    public boolean D() {
        if (this.f399725m == false) goto L5;
    L10:
        return true;
    L5:
        if (this.L.f399691c == true) goto L7;
    L9:
        return false;
    L7:
        if (this.N.f399691c == false) goto L9;
        goto L9
    }

    public boolean E() {
        if (this.f399727n == false) goto L5;
    L10:
        return true;
    L5:
        if (this.M.f399691c == true) goto L7;
    L9:
        return false;
    L7:
        if (this.O.f399691c == false) goto L9;
        goto L9
    }

    public void F() {
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.R.j();
        this.S.j();
        this.X = null;
        this.F = Float.NaN;
        this.Y = 0;
        this.Z = 0;
        this.f399702a0 = 0.0f;
        this.f399704b0 = -1;
        this.f399706c0 = 0;
        this.f399708d0 = 0;
        this.f399710e0 = 0;
        this.f399712f0 = 0;
        this.f399714g0 = 0;
        this.f399716h0 = 0.5f;
        this.f399718i0 = 0.5f;
        DimensionBehaviour[] r100 = this.W;
        DimensionBehaviour r101 = DimensionBehaviour.FIXED;
        r100[0] = r101;
        r100[1] = r101;
        this.f399720j0 = null;
        this.f399722k0 = 0;
        this.f399728n0 = null;
        this.f399730o0 = 0;
        this.f399732p0 = 0;
        float[] r102 = this.f399734q0;
        r102[0] = -1.0f;
        r102[1] = -1.0f;
        this.f399733q = -1;
        this.f399735r = -1;
        int[] r103 = this.E;
        r103[0] = Integer.MAX_VALUE;
        r103[1] = Integer.MAX_VALUE;
        this.f399739t = 0;
        this.f399741u = 0;
        this.f399748y = 1.0f;
        this.B = 1.0f;
        this.f399747x = Integer.MAX_VALUE;
        this.A = Integer.MAX_VALUE;
        this.f399745w = 0;
        this.f399749z = 0;
        this.C = -1;
        this.D = 1.0f;
        boolean[] r104 = this.f399711f;
        r104[0] = true;
        r104[1] = true;
        this.I = false;
        boolean[] r105 = this.V;
        r105[0] = false;
        r105[1] = false;
        this.f399713g = true;
        int[] r106 = this.f399743v;
        r106[0] = 0;
        r106[1] = 0;
        this.f399717i = -1;
        this.f399719j = -1;
    }

    public final void G() {
        ConstraintWidget r100 = this.X;
        if (r100 != null) goto L5;
    L7:
        int r101 = this.U.size();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L10;
        ((ConstraintAnchor) ListProtector.get(this.U, r102)).j();
        r102 = r102 + 1;
        goto L8
    L10:
        return;
    L5:
        if ((r100 instanceof d) == false) goto L7;
        ((d) r100).getClass();
        goto L7
    }

    public boolean e() {
        if (this.f399722k0 == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public final void k() {
        if (this.f399707d != null) goto L6;
        this.f399707d = new k(this);
    L6:
        if (this.f399709e != null) goto L9;
        this.f399709e = new m(this);
        return;
    }

    public final int n() {
        if (this.f399722k0 != 8) goto L7;
        return 0;
    L7:
        return this.Z;
    }

    public final int t() {
        if (this.f399722k0 != 8) goto L7;
        return 0;
    L7:
        return this.Y;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = "";
        if (this.f399728n0 == null) goto L5;
        String r102 = "type: " + this.f399728n0 + " ";
    L6:
        r100.append(r102);
        if (this.f399726m0 == null) goto L9;
        r101 = "id: " + this.f399726m0 + " ";
    L9:
        r100.append(r101);
        r100.append("(");
        r100.append(this.f399706c0);
        r100.append(", ");
        r100.append(this.f399708d0);
        r100.append(") - (");
        r100.append(this.Y);
        r100.append(" x ");
        r100.append(this.Z);
        r100.append(")");
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    public final int u() {
        ConstraintWidget r100 = this.X;
        if (r100 == null) goto L9;
        if ((r100 instanceof d) == false) goto L9;
        return ((d) r100).E0 + this.f399706c0;
    L9:
        return this.f399706c0;
    }

    public final int v() {
        ConstraintWidget r100 = this.X;
        if (r100 == null) goto L9;
        if ((r100 instanceof d) == false) goto L9;
        return ((d) r100).F0 + this.f399708d0;
    L9:
        return this.f399708d0;
    }

    public String getType() {
        return this.f399728n0;
    }

    public void I(rla.a r100) {
        this.L.k();
        this.M.k();
        this.N.k();
        this.O.k();
        this.P.k();
        this.S.k();
        this.Q.k();
        this.R.k();
    }

    public final void N(int r100) {
        this.Z = r100;
        int r101 = this.f399714g0;
        if (r100 >= r101) goto L6;
        this.Z = r101;
        return;
    }

    public final void O(DimensionBehaviour r100) {
        this.W[0] = r100;
    }

    public final void P(DimensionBehaviour r100) {
        this.W[1] = r100;
    }

    public final void Q(int r100) {
        this.Y = r100;
        int r101 = this.f399712f0;
        if (r100 >= r101) goto L6;
        this.Y = r101;
        return;
    }

    public final void j(com.obric.oui.constraintlayout.core.c r100) {
        r100.k(this.L);
        r100.k(this.M);
        r100.k(this.N);
        r100.k(this.O);
        if (this.f399710e0 <= 0) goto L6;
        r100.k(this.P);
        return;
    }

    public ConstraintAnchor l(ConstraintAnchor.Type r100) {
        switch(a.f399751a[r100.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r100.name());
    L9:
        return this.R;
    L11:
        return this.Q;
    L13:
        return this.S;
    L15:
        return this.P;
    L17:
        return this.O;
    L19:
        return this.N;
    L21:
        return this.M;
    L23:
        return this.L;
    }

    public final DimensionBehaviour m(int r100) {
        if (r100 != 0) goto L6;
        return this.W[0];
    L6:
        if (r100 == 1) goto L8;
        return null;
    L8:
        return this.W[1];
    }

    public final ConstraintWidget o(int r100) {
        if (r100 != 0) goto L10;
        ConstraintAnchor r101 = this.N;
        ConstraintAnchor r102 = r101.f399694f;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.f399694f == r101) goto L8;
        return null;
    L8:
        return r102.f399692d;
    L10:
        if (r100 != 1) goto L20;
        ConstraintAnchor r103 = this.O;
        ConstraintAnchor r104 = r103.f399694f;
        if (r104 != null) goto L14;
        return null;
    L14:
        if (r104.f399694f == r103) goto L16;
        return null;
    L16:
        return r104.f399692d;
    L20:
        return null;
    }

    public final ConstraintWidget p(int r100) {
        if (r100 != 0) goto L10;
        ConstraintAnchor r101 = this.L;
        ConstraintAnchor r102 = r101.f399694f;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.f399694f == r101) goto L8;
        return null;
    L8:
        return r102.f399692d;
    L10:
        if (r100 != 1) goto L20;
        ConstraintAnchor r103 = this.M;
        ConstraintAnchor r104 = r103.f399694f;
        if (r104 != null) goto L14;
        return null;
    L14:
        if (r104.f399694f == r103) goto L16;
        return null;
    L16:
        return r104.f399692d;
    L20:
        return null;
    }

    public void q(StringBuilder r110) {
        r110.append(tb2.c.DEFAULT_TEXT + this.f399723l + ":{\n");
        StringBuilder r100 = new StringBuilder("    actualWidth:");
        r100.append(this.Y);
        r110.append(r100.toString());
        r110.append("\n");
        r110.append("    actualHeight:" + this.Z);
        r110.append("\n");
        r110.append("    actualLeft:" + this.f399706c0);
        r110.append("\n");
        r110.append("    actualTop:" + this.f399708d0);
        r110.append("\n");
        s(r110, "left", this.L);
        s(r110, "top", this.M);
        s(r110, "right", this.N);
        s(r110, "bottom", this.O);
        s(r110, "baseline", this.P);
        s(r110, "centerX", this.Q);
        s(r110, "centerY", this.R);
        int r101 = this.Y;
        int r102 = this.f399712f0;
        int r103 = this.E[0];
        int r104 = this.f399745w;
        int r105 = this.f399739t;
        float r106 = this.f399748y;
        DimensionBehaviour r107 = this.W[0];
        float r108 = this.f399734q0[0];
        r(r110, "    width", r101, r102, r103, r104, r105, r106, r107);
        int r109 = this.Z;
        int r111 = this.f399714g0;
        int r112 = this.E[1];
        int r113 = this.f399749z;
        int r114 = this.f399741u;
        float r115 = this.B;
        DimensionBehaviour r116 = this.W[1];
        float r117 = this.f399734q0[1];
        r(r110, "    height", r109, r111, r112, r113, r114, r115, r116);
        float r118 = this.f399702a0;
        int r119 = this.f399704b0;
        if (r118 == 0.0f) goto L6;
        r110.append("    dimensionRatio");
        r110.append(" :  [");
        r110.append(r118);
        r110.append(",");
        r110.append(r119);
        r110.append("");
        r110.append("],\n");
    L6:
        J(r110, "    horizontalBias", this.f399716h0, 0.5f);
        J(r110, "    verticalBias", this.f399718i0, 0.5f);
        K(r110, "    horizontalChainStyle", this.f399730o0, 0);
        K(r110, "    verticalChainStyle", this.f399732p0, 0);
        r110.append("  }");
    }

    public final boolean w(int r100) {
        if (r100 != 0) goto L18;
        if (this.L.f399694f == null) goto L7;
        int r101 = 1;
    L9:
        if (this.N.f399694f == null) goto L11;
        int r102 = 1;
    L13:
        if ((r101 + r102) < 2) goto L34;
        return false;
    L34:
        return true;
    L11:
        r102 = 0;
        goto L13
    L7:
        r101 = 0;
        goto L9
    L18:
        if (this.M.f399694f == null) goto L20;
        int r103 = 1;
    L22:
        if (this.O.f399694f == null) goto L24;
        int r104 = 1;
    L25:
        int r105 = r103 + r104;
        if (this.P.f399694f == null) goto L28;
        int r106 = 1;
    L30:
        if ((r105 + r106) < 2) goto L35;
        return false;
    L35:
        return true;
    L28:
        r106 = 0;
        goto L30
    L24:
        r104 = 0;
        goto L25
    L20:
        r103 = 0;
        goto L22
    }

    public final boolean z(int r100) {
        int r101 = r100 * 2;
        ConstraintAnchor[] r102 = this.T;
        ConstraintAnchor r103 = r102[r101];
        ConstraintAnchor r104 = r103.f399694f;
        if (r104 != null) goto L5;
    L11:
        return false;
    L5:
        if (r104.f399694f == r103) goto L11;
        ConstraintAnchor r105 = r102[r101 + 1];
        ConstraintAnchor r106 = r105.f399694f;
        if (r106 == null) goto L11;
        if (r106.f399694f != r105) goto L11;
        return true;
    }

    public final void L(int r100, int r101) {
        if (this.f399725m == false) goto L5;
        return;
    L5:
        this.L.l(r100);
        this.N.l(r101);
        this.f399706c0 = r100;
        this.Y = r101 - r100;
        this.f399725m = true;
    }

    public final void M(int r100, int r101) {
        if (this.f399727n == false) goto L5;
        return;
    L5:
        this.M.l(r100);
        this.O.l(r101);
        this.f399708d0 = r100;
        this.Z = r101 - r100;
        if (this.G == false) goto L8;
        this.P.l(r100 + this.f399710e0);
    L8:
        this.f399727n = true;
    }

    public void R(boolean r100, boolean r101) {
        k r102 = this.f399707d;
        boolean r103 = r100 & r102.f399773g;
        m r104 = this.f399709e;
        boolean r105 = r101 & r104.f399773g;
        int r106 = r102.f399774h.f399760g;
        int r107 = r104.f399774h.f399760g;
        int r108 = r102.f399775i.f399760g;
        int r109 = r104.f399775i.f399760g;
        int r110 = r109 - r107;
        if ((r108 - r106) < 0) goto L15;
        if (r110 < 0) goto L15;
        if (r106 == Integer.MIN_VALUE) goto L15;
        if (r106 == Integer.MAX_VALUE) goto L15;
        if (r107 == Integer.MIN_VALUE) goto L15;
        if (r107 == Integer.MAX_VALUE) goto L15;
        if (r108 == Integer.MIN_VALUE) goto L15;
        if (r108 == Integer.MAX_VALUE) goto L15;
        if (r109 == Integer.MIN_VALUE) goto L15;
        if (r109 == Integer.MAX_VALUE) goto L15;
    L16:
        int r111 = r108 - r106;
        int r112 = r109 - r107;
        if (r103 == false) goto L19;
        this.f399706c0 = r106;
    L19:
        if (r105 == false) goto L22;
        this.f399708d0 = r107;
    L22:
        if (this.f399722k0 != 8) goto L25;
        this.Y = 0;
        this.Z = 0;
        return;
    L25:
        if (r103 == true) goto L27;
    L34:
        if (r105 == true) goto L36;
        return;
    L36:
        if (this.W[1] != DimensionBehaviour.FIXED) goto L40;
        int r113 = this.Z;
        if (r112 >= r113) goto L40;
        r112 = r113;
    L40:
        this.Z = r112;
        int r114 = this.f399714g0;
        if (r112 >= r114) goto L45;
        this.Z = r114;
        return;
    L45:
        return;
    L27:
        if (this.W[0] != DimensionBehaviour.FIXED) goto L31;
        int r115 = this.Y;
        if (r111 >= r115) goto L31;
        r111 = r115;
    L31:
        this.Y = r111;
        int r116 = this.f399712f0;
        if (r111 >= r116) goto L34;
        this.Y = r116;
    L15:
        r108 = 0;
        r109 = 0;
        r106 = 0;
        r107 = 0;
        goto L16
    }

    public void S(com.obric.oui.constraintlayout.core.c r100, boolean r101) {
        ConstraintAnchor r102 = this.L;
        r100.getClass();
        int r103 = com.obric.oui.constraintlayout.core.c.n(r102);
        int r104 = com.obric.oui.constraintlayout.core.c.n(this.M);
        int r105 = com.obric.oui.constraintlayout.core.c.n(this.N);
        int r106 = com.obric.oui.constraintlayout.core.c.n(this.O);
        if (r101 == false) goto L11;
        k r107 = this.f399707d;
        if (r107 == null) goto L11;
        DependencyNode r108 = r107.f399774h;
        if (r108.f399763j == false) goto L11;
        DependencyNode r109 = r107.f399775i;
        if (r109.f399763j == false) goto L11;
        r103 = r108.f399760g;
        r105 = r109.f399760g;
    L11:
        if (r101 == false) goto L19;
        m r110 = this.f399709e;
        if (r110 == null) goto L19;
        DependencyNode r111 = r110.f399774h;
        if (r111.f399763j == false) goto L19;
        DependencyNode r112 = r110.f399775i;
        if (r112.f399763j == false) goto L19;
        r104 = r111.f399760g;
        r106 = r112.f399760g;
    L19:
        int r113 = r106 - r104;
        if ((r105 - r103) < 0) goto L32;
        if (r113 < 0) goto L32;
        if (r103 == Integer.MIN_VALUE) goto L32;
        if (r103 == Integer.MAX_VALUE) goto L32;
        if (r104 == Integer.MIN_VALUE) goto L32;
        if (r104 == Integer.MAX_VALUE) goto L32;
        if (r105 == Integer.MIN_VALUE) goto L32;
        if (r105 == Integer.MAX_VALUE) goto L32;
        if (r106 == Integer.MIN_VALUE) goto L32;
        if (r106 == Integer.MAX_VALUE) goto L32;
    L33:
        int r114 = r105 - r103;
        int r115 = r106 - r104;
        this.f399706c0 = r103;
        this.f399708d0 = r104;
        if (this.f399722k0 != 8) goto L36;
        this.Y = 0;
        this.Z = 0;
        return;
    L36:
        DimensionBehaviour[] r116 = this.W;
        DimensionBehaviour r117 = r116[0];
        DimensionBehaviour r118 = DimensionBehaviour.FIXED;
        if (r117 != r118) goto L42;
        int r119 = this.Y;
        if (r114 >= r119) goto L42;
        r114 = r119;
    L42:
        if (r116[1] != r118) goto L46;
        int r120 = this.Z;
        if (r115 >= r120) goto L46;
        r115 = r120;
    L46:
        this.Y = r114;
        this.Z = r115;
        int r121 = this.f399714g0;
        if (r115 >= r121) goto L49;
        this.Z = r121;
    L49:
        int r122 = this.f399712f0;
        if (r114 >= r122) goto L52;
        this.Y = r122;
    L52:
        int r123 = this.f399747x;
        if (r123 > 0) goto L55;
    L57:
        int r124 = this.A;
        if (r124 > 0) goto L60;
    L62:
        int r125 = this.Y;
        if (r114 == r125) goto L65;
        this.f399717i = r125;
    L65:
        int r126 = this.Z;
        if (r115 == r126) goto L70;
        this.f399719j = r126;
        return;
    L70:
        return;
    L60:
        if (this.W[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        this.Z = Math.min(this.Z, r124);
        goto L62
    L55:
        if (r117 != DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        this.Y = Math.min(this.Y, r123);
    L32:
        r103 = 0;
        r104 = 0;
        r105 = 0;
        r106 = 0;
        goto L33
    }

    public void d(com.obric.oui.constraintlayout.core.c r510, boolean r511) {
        SolverVariable r110 = r510.k(this.L);
        SolverVariable r111 = r510.k(this.N);
        SolverVariable r112 = r510.k(this.M);
        SolverVariable r113 = r510.k(this.O);
        SolverVariable r100 = r510.k(this.P);
        ConstraintWidget r101 = this.X;
        if (r101 == null) goto L18;
        DimensionBehaviour[] r102 = r101.W;
        DimensionBehaviour r103 = r102[0];
        DimensionBehaviour r104 = DimensionBehaviour.WRAP_CONTENT;
        if (r103 != r104) goto L7;
        boolean r105 = true;
    L9:
        if (r102[1] != r104) goto L11;
        boolean r106 = true;
    L12:
        int r107 = this.f399737s;
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L19;
        if (r107 == 3) goto L18;
        boolean r210 = r106;
        boolean r211 = r105;
    L21:
        if (this.f399722k0 == 8) goto L23;
    L43:
        boolean r108 = this.f399725m;
        if (r108 == false) goto L46;
    L47:
        if (r108 == false) goto L70;
        r510.d(r110, this.f399706c0);
        r510.d(r111, this.f399706c0 + this.Y);
        if (r211 == false) goto L70;
        ConstraintWidget r109 = this.X;
        if (r109 == null) goto L70;
        if (this.f399715h == false) goto L68;
        d r114 = (d) r109;
        ConstraintAnchor r115 = this.L;
        WeakReference<ConstraintAnchor> r116 = r114.O0;
        if (r116 != null) goto L57;
    L60:
        r114.O0 = new WeakReference(r115);
    L61:
        ConstraintAnchor r117 = this.N;
        WeakReference<ConstraintAnchor> r118 = r114.Q0;
        if (r118 != null) goto L64;
    L67:
        r114.Q0 = new WeakReference(r117);
        goto L70
    L64:
        if (r118.get() == null) goto L67;
        if (r117.d() <= r114.Q0.get().d()) goto L70;
    L57:
        if (r116.get() == null) goto L60;
        if (r115.d() <= r114.O0.get().d()) goto L61;
    L68:
        r510.f(r510.k(r109.N), r111, 0, 5);
    L70:
        if (this.f399727n == false) goto L101;
        r510.d(r112, this.f399708d0);
        r510.d(r113, this.f399708d0 + this.Z);
        HashSet<ConstraintAnchor> r119 = this.P.f399689a;
        if (r119 != null) goto L75;
    L77:
        boolean r120 = false;
    L78:
        if (r120 == false) goto L80;
        r510.d(r100, this.f399708d0 + this.f399710e0);
    L80:
        if (r210 == false) goto L101;
        ConstraintWidget r121 = this.X;
        if (r121 == null) goto L101;
        if (this.f399715h == false) goto L99;
        d r122 = (d) r121;
        ConstraintAnchor r123 = this.M;
        WeakReference<ConstraintAnchor> r124 = r122.N0;
        if (r124 != null) goto L88;
    L91:
        r122.N0 = new WeakReference(r123);
    L92:
        ConstraintAnchor r125 = this.O;
        WeakReference<ConstraintAnchor> r126 = r122.P0;
        if (r126 != null) goto L95;
    L98:
        r122.P0 = new WeakReference(r125);
        goto L101
    L95:
        if (r126.get() == null) goto L98;
        if (r125.d() <= r122.P0.get().d()) goto L101;
    L88:
        if (r124.get() == null) goto L91;
        if (r123.d() <= r122.N0.get().d()) goto L92;
    L99:
        r510.f(r510.k(r121.O), r113, 0, 5);
        goto L101
    L75:
        if (r119.size() <= 0) goto L77;
        r120 = true;
    L101:
        if (this.f399725m == true) goto L103;
    L106:
        if (r511 == false) goto L136;
        k r127 = this.f399707d;
        if (r127 == null) goto L136;
        m r128 = this.f399709e;
        if (r128 == null) goto L136;
        DependencyNode r129 = r127.f399774h;
        if (r129.f399763j == false) goto L136;
        if (r127.f399775i.f399763j == false) goto L136;
        if (r128.f399774h.f399763j == false) goto L136;
        if (r128.f399775i.f399763j == false) goto L136;
        r510.d(r110, r129.f399760g);
        r510.d(r111, this.f399707d.f399775i.f399760g);
        r510.d(r112, this.f399709e.f399774h.f399760g);
        r510.d(r113, this.f399709e.f399775i.f399760g);
        r510.d(r100, this.f399709e.f399808k.f399760g);
        if (this.X == null) goto L133;
        if (r211 == true) goto L123;
    L127:
        if (r210 == false) goto L133;
        if (this.f399711f[1] == false) goto L133;
        if (B() == true) goto L133;
        r510.f(r510.k(this.X.O), r113, 0, 8);
        goto L133
    L123:
        if (this.f399711f[0] == false) goto L127;
        if (A() == true) goto L127;
        r510.f(r510.k(this.X.N), r111, 0, 8);
    L133:
        this.f399725m = false;
        this.f399727n = false;
        return;
    L136:
        if (this.X != null) goto L138;
        boolean r310 = false;
        boolean r311 = false;
    L167:
        int r130 = this.Y;
        int r131 = this.f399712f0;
        if (r130 < r131) goto L171;
        r131 = r130;
    L171:
        int r132 = this.Z;
        int r133 = this.f399714g0;
        if (r132 < r133) goto L175;
        r133 = r132;
    L175:
        DimensionBehaviour[] r134 = this.W;
        DimensionBehaviour r135 = r134[0];
        int r136 = r131;
        DimensionBehaviour r137 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r135 == r137) goto L178;
        boolean r212 = true;
    L179:
        DimensionBehaviour r138 = r134[1];
        if (r138 == r137) goto L182;
        boolean r213 = true;
    L183:
        int r139 = this.f399704b0;
        this.C = r139;
        float r140 = this.f399702a0;
        this.D = r140;
        int r141 = this.f399739t;
        int r214 = r133;
        int r142 = this.f399741u;
        SolverVariable r312 = r112;
        if (r140 <= 0.0f) goto L272;
        SolverVariable r313 = r100;
        if (this.f399722k0 == 8) goto L273;
        if (r135 != r137) goto L190;
        if (r141 != 0) goto L190;
        r141 = 3;
    L190:
        if (r138 != r137) goto L193;
        if (r142 != 0) goto L193;
        r142 = 3;
    L193:
        if (r135 != r137) goto L254;
        if (r138 != r137) goto L254;
        if (r141 != 3) goto L254;
        if (r142 != 3) goto L254;
        if (r139 != (-1)) goto L209;
        if (r212 == false) goto L203;
        if (r213 == true) goto L203;
        this.C = 0;
    L203:
        if (r212 == true) goto L209;
        if (r213 == false) goto L209;
        this.C = 1;
        if (r139 != (-1)) goto L209;
        this.D = 1.0f / r140;
    L209:
        if (this.C != 0) goto L216;
        if (this.M.h() == true) goto L213;
    L214:
        this.C = 1;
    L223:
        if (this.C != (-1)) goto L243;
        if (this.M.h() == false) goto L233;
        if (this.O.h() == false) goto L233;
        if (this.L.h() == false) goto L233;
        if (this.N.h() == true) goto L243;
    L233:
        if (this.M.h() == false) goto L238;
        if (this.O.h() == false) goto L238;
        this.C = 0;
    L238:
        if (this.L.h() == false) goto L243;
        if (this.N.h() == false) goto L243;
        this.D = 1.0f / this.D;
        this.C = 1;
    L243:
        if (this.C != (-1)) goto L269;
        int r143 = this.f399745w;
        if (r143 > 0) goto L247;
    L249:
        if (r143 != 0) goto L269;
        if (this.f399749z <= 0) goto L269;
        this.D = 1.0f / this.D;
        this.C = 1;
        goto L269
    L247:
        if (this.f399749z != 0) goto L249;
        this.C = 0;
    L269:
        int r144 = r136;
    L271:
        int r314 = r141;
        int r315 = r142;
        int r316 = r214;
        boolean r317 = true;
    L274:
        int[] r145 = this.f399743v;
        r145[0] = r314;
        r145[1] = r315;
        if (r317 == false) goto L280;
        int r146 = this.C;
        int r147 = -1;
        if (r146 == 0) goto L279;
        if (r146 == (-1)) goto L279;
    L281:
        boolean r148 = false;
    L282:
        if (r317 == false) goto L287;
        int r149 = this.C;
        if (r149 == 1) goto L286;
        if (r149 != r147) goto L287;
    L286:
        boolean r318 = true;
    L288:
        DimensionBehaviour r150 = this.W[0];
        DimensionBehaviour r151 = DimensionBehaviour.WRAP_CONTENT;
        if (r150 == r151) goto L291;
    L293:
        boolean r152 = false;
    L294:
        if (r152 == false) goto L296;
        int r215 = 0;
    L297:
        boolean r319 = !this.S.h();
        boolean[] r153 = this.V;
        boolean r216 = r153[0];
        boolean r410 = r153[1];
        if (this.f399733q == 2) goto L332;
        if (this.f399725m == true) goto L332;
        if (r511 == false) goto L318;
        k r154 = this.f399707d;
        if (r154 == null) goto L318;
        DependencyNode r155 = r154.f399774h;
        if (r155.f399763j == false) goto L318;
        if (r154.f399775i.f399763j == false) goto L318;
        if (r511 == false) goto L332;
        r510.d(r110, r155.f399760g);
        r510.d(r111, this.f399707d.f399775i.f399760g);
        if (this.X == null) goto L332;
        if (r211 == false) goto L332;
        if (this.f399711f[0] == false) goto L332;
        if (A() == true) goto L332;
        r510.f(r510.k(this.X.N), r111, 0, 8);
    L318:
        ConstraintWidget r156 = this.X;
        if (r156 == null) goto L321;
        SolverVariable r157 = r510.k(r156.N);
    L322:
        ConstraintWidget r158 = this.X;
        if (r158 == null) goto L325;
        SolverVariable r159 = r510.k(r158.L);
    L326:
        boolean r217 = this.f399711f[0];
        DimensionBehaviour[] r160 = this.W;
        DimensionBehaviour r218 = r160[0];
        ConstraintAnchor r161 = this.L;
        ConstraintAnchor r162 = this.N;
        int r163 = this.f399706c0;
        int r164 = this.f399712f0;
        int r411 = this.E[0];
        float r165 = this.f399716h0;
        if (r160[1] != r137) goto L329;
        boolean r412 = true;
    L330:
        f(r510, true, r211, r210, r217, r159, r157, r218, r152, r161, r162, r163, r215, r164, r411, r165, r148, r412, r311, r310, r216, r314, r315, this.f399745w, this.f399747x, this.f399748y, r319);
        goto L332
    L329:
        r412 = false;
        goto L330
    L325:
        r159 = null;
        goto L326
    L321:
        r157 = null;
    L332:
        if (r511 == false) goto L350;
        ConstraintWidget r166 = this;
        m r167 = r166.f399709e;
        if (r167 == null) goto L349;
        DependencyNode r168 = r167.f399774h;
        if (r168.f399763j == false) goto L349;
        if (r167.f399775i.f399763j == false) goto L349;
        r510 = r510;
        r312 = r312;
        r510.d(r312, r168.f399760g);
        r113 = r113;
        r510.d(r113, r166.f399709e.f399775i.f399760g);
        r313 = r313;
        r510.d(r313, r166.f399709e.f399808k.f399760g);
        ConstraintWidget r169 = r166.X;
        if (r169 == null) goto L347;
        if (r310 == true) goto L347;
        if (r210 == false) goto L347;
        char r170 = 1;
        if (r166.f399711f[1] == false) goto L346;
        int r171 = 8;
        int r172 = 0;
        r510.f(r510.k(r169.O), r113, 0, 8);
    L348:
        boolean r173 = false;
    L353:
        if (r166.f399735r != 2) goto L355;
        boolean r174 = false;
    L356:
        if (r174 == false) goto L396;
        if (r166.f399727n == true) goto L396;
        if (r166.W[r170] == r151) goto L362;
    L364:
        boolean r175 = false;
    L365:
        if (r175 == false) goto L367;
        r316 = 0;
    L367:
        ConstraintWidget r176 = r166.X;
        if (r176 == null) goto L370;
        SolverVariable r177 = r510.k(r176.O);
    L371:
        ConstraintWidget r178 = r166.X;
        if (r178 == null) goto L374;
        SolverVariable r179 = r510.k(r178.M);
    L375:
        int r180 = r166.f399710e0;
        if (r180 <= 0) goto L378;
    L379:
        ConstraintAnchor r181 = r166.P;
        if (r181.f399694f == null) goto L386;
        r510.e(r313, r312, r180, r171);
        r510.e(r313, r510.k(r166.P.f399694f), r166.P.e(), r171);
        if (r210 == false) goto L384;
        r510.f(r177, r510.k(r166.O), r172, 5);
    L384:
        boolean r219 = false;
    L390:
        boolean r182 = r166.f399711f[r170];
        DimensionBehaviour[] r183 = r166.W;
        DimensionBehaviour r184 = r183[r170];
        ConstraintAnchor r185 = r166.M;
        ConstraintAnchor r186 = r166.O;
        int r187 = r166.f399708d0;
        int r188 = r166.f399714g0;
        int r189 = r166.E[r170];
        float r190 = r166.f399718i0;
        if (r183[0] != r137) goto L393;
        boolean r191 = true;
    L394:
        f(r510, false, r210, r211, r182, r179, r177, r184, r175, r185, r186, r187, r316, r188, r189, r190, r318, r191, r310, r311, r410, r315, r314, r166.f399749z, r166.A, r166.B, r219);
        goto L396
    L393:
        r191 = false;
        goto L394
    L386:
        if (r166.f399722k0 != r171) goto L388;
        r510.e(r313, r312, r181.e(), r171);
    L389:
        r219 = r319;
        goto L390
    L388:
        r510.e(r313, r312, r180, r171);
        goto L389
    L378:
        if (r166.f399722k0 != r171) goto L389;
    L374:
        r179 = null;
        goto L375
    L370:
        r177 = null;
        goto L371
    L362:
        if ((r166 instanceof d) == false) goto L364;
        r175 = true;
    L396:
        if (r317 == false) goto L401;
        ConstraintWidget r192 = this;
        if (r192.C != 1) goto L400;
        float r193 = r192.D;
        com.obric.oui.constraintlayout.core.b r194 = r510.l();
        r194.f399632d.e(r113, -1.0f);
        r194.f399632d.e(r312, 1.0f);
        r194.f399632d.e(r111, r193);
        r194.f399632d.e(r110, -r193);
        com.obric.oui.constraintlayout.core.c r195 = r510;
        r195.c(r194);
    L403:
        if (r192.S.h() == false) goto L405;
        ConstraintWidget r196 = r192.S.f399694f.f399692d;
        float r197 = (float) Math.toRadians(r192.F + 90.0f);
        int r198 = r192.S.e();
        ConstraintAnchor.Type r199 = ConstraintAnchor.Type.LEFT;
        SolverVariable r200 = r195.k(r192.l(r199));
        ConstraintAnchor.Type r201 = ConstraintAnchor.Type.TOP;
        SolverVariable r202 = r195.k(r192.l(r201));
        ConstraintAnchor.Type r203 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r1100 = r195.k(r192.l(r203));
        ConstraintAnchor.Type r1101 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r1102 = r195.k(r192.l(r1101));
        SolverVariable r204 = r195.k(r196.l(r199));
        SolverVariable r205 = r195.k(r196.l(r201));
        SolverVariable r206 = r195.k(r196.l(r203));
        SolverVariable r207 = r195.k(r196.l(r1101));
        com.obric.oui.constraintlayout.core.b r1103 = r510.l();
        double r1104 = r197;
        double r208 = r198;
        float r209 = (float) (Math.sin(r1104) * r208);
        r1103.f399632d.e(r205, 0.5f);
        r1103.f399632d.e(r207, 0.5f);
        r1103.f399632d.e(r202, -0.5f);
        r1103.f399632d.e(r1102, -0.5f);
        r1103.f399630b = -r209;
        r195.c(r1103);
        com.obric.oui.constraintlayout.core.b r220 = r510.l();
        float r221 = (float) (Math.cos(r1104) * r208);
        r220.f399632d.e(r204, 0.5f);
        r220.f399632d.e(r206, 0.5f);
        r220.f399632d.e(r200, -0.5f);
        r220.f399632d.e(r1100, -0.5f);
        r220.f399630b = -r221;
        r195.c(r220);
    L405:
        r192.f399725m = false;
        r192.f399727n = false;
        return;
    L400:
        r195 = r510;
        float r222 = r192.D;
        com.obric.oui.constraintlayout.core.b r223 = r510.l();
        r223.f399632d.e(r111, -1.0f);
        r223.f399632d.e(r110, 1.0f);
        r223.f399632d.e(r113, r222);
        r223.f399632d.e(r312, -r222);
        r195.c(r223);
        goto L403
    L401:
        r192 = this;
        r195 = r510;
        goto L403
    L355:
        r174 = r173;
        goto L356
    L346:
        r171 = 8;
        r172 = 0;
    L347:
        r171 = 8;
        r172 = 0;
        r170 = 1;
    L349:
        r171 = 8;
        r172 = 0;
        r170 = 1;
    L351:
        r173 = true;
        goto L353
    L350:
        r171 = 8;
        r172 = 0;
        r170 = 1;
        r166 = this;
        goto L351
    L296:
        r215 = r144;
        goto L297
    L291:
        if ((this instanceof d) == false) goto L293;
        r152 = true;
    L287:
        r318 = false;
    L279:
        r148 = true;
        goto L282
    L280:
        r147 = -1;
        goto L281
    L213:
        if (this.O.h() == false) goto L214;
    L216:
        if (this.C != 1) goto L223;
        if (this.L.h() == true) goto L220;
    L221:
        this.C = 0;
        goto L223
    L220:
        if (this.N.h() == true) goto L223;
    L254:
        if (r135 != r137) goto L260;
        if (r141 != 3) goto L260;
        this.C = 0;
        r144 = (int) (r140 * r132);
        if (r138 == r137) goto L271;
        r315 = r142;
        r316 = r214;
        r317 = false;
        r314 = 4;
    L260:
        if (r138 != r137) goto L269;
        if (r142 != 3) goto L269;
        this.C = 1;
        if (r139 != (-1)) goto L265;
        this.D = 1.0f / r140;
    L265:
        int r224 = (int) (this.D * r130);
        if (r135 == r137) goto L268;
        r316 = r224;
        r314 = r141;
        r144 = r136;
        r317 = false;
        r315 = 4;
        goto L274
    L268:
        r214 = r224;
    L273:
        r314 = r141;
        r315 = r142;
        r144 = r136;
        r316 = r214;
        r317 = false;
        goto L274
    L272:
        r313 = r100;
        goto L273
    L182:
        r213 = false;
        goto L183
    L178:
        r212 = false;
        goto L179
    L138:
        if (z(0) == false) goto L140;
        ((d) this.X).U(this, 0);
        boolean r225 = true;
    L142:
        if (z(1) == false) goto L144;
        ((d) this.X).U(this, 1);
        boolean r226 = true;
    L145:
        if (r225 == true) goto L154;
        if (r211 == false) goto L154;
        if (this.f399722k0 == 8) goto L154;
        if (this.L.f399694f != null) goto L154;
        if (this.N.f399694f != null) goto L154;
        r510.f(r510.k(this.X.N), r111, 0, 1);
    L154:
        if (r226 == true) goto L165;
        if (r210 == false) goto L165;
        if (this.f399722k0 == 8) goto L165;
        if (this.M.f399694f != null) goto L165;
        if (this.O.f399694f != null) goto L165;
        if (this.P != null) goto L165;
        r510.f(r510.k(this.X.O), r113, 0, 1);
    L165:
        r311 = r225;
        r310 = r226;
        goto L167
    L144:
        r226 = B();
        goto L145
    L140:
        r225 = A();
        goto L142
    L103:
        if (this.f399727n == false) goto L106;
        this.f399725m = false;
        this.f399727n = false;
        return;
    L46:
        if (this.f399727n == false) goto L106;
    L23:
        if (this.f399724l0 == true) goto L43;
        int r227 = this.U.size();
        int r228 = 0;
    L25:
        if (r228 >= r227) goto L36;
        HashSet<ConstraintAnchor> r229 = ((ConstraintAnchor) ListProtector.get(this.U, r228)).f399689a;
        if (r229 != null) goto L30;
    L32:
        boolean r230 = false;
    L33:
        if (r230 == true) goto L34;
        r228 = r228 + 1;
        goto L25
    L34:
        boolean r231 = true;
    L37:
        if (r231 == true) goto L43;
        boolean[] r232 = this.V;
        if (r232[0] == true) goto L43;
        if (r232[1] == true) goto L43;
        return;
    L30:
        if (r229.size() <= 0) goto L32;
        r230 = true;
        goto L33
    L36:
        r231 = false;
    L19:
        r210 = r106;
        r211 = false;
        goto L21
    L17:
        r211 = r105;
        r210 = false;
        goto L21
    L11:
        r106 = false;
        goto L12
    L7:
        r105 = false;
    L18:
        r106 = false;
        goto L19
    }

    public void i(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        this.f399733q = r100.f399733q;
        this.f399735r = r100.f399735r;
        this.f399739t = r100.f399739t;
        this.f399741u = r100.f399741u;
        int[] r102 = this.f399743v;
        int[] r103 = r100.f399743v;
        r102[0] = r103[0];
        r102[1] = r103[1];
        this.f399745w = r100.f399745w;
        this.f399747x = r100.f399747x;
        this.f399749z = r100.f399749z;
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        int[] r104 = r100.E;
        this.E = Arrays.copyOf(r104, r104.length);
        this.F = r100.F;
        this.G = r100.G;
        this.H = r100.H;
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.R.j();
        this.S.j();
        this.W = (DimensionBehaviour[]) Arrays.copyOf(this.W, 2);
        ConstraintWidget r105 = null;
        if (this.X != null) goto L5;
        ConstraintWidget r106 = null;
    L6:
        this.X = r106;
        this.Y = r100.Y;
        this.Z = r100.Z;
        this.f399702a0 = r100.f399702a0;
        this.f399704b0 = r100.f399704b0;
        this.f399706c0 = r100.f399706c0;
        this.f399708d0 = r100.f399708d0;
        this.f399710e0 = r100.f399710e0;
        this.f399712f0 = r100.f399712f0;
        this.f399714g0 = r100.f399714g0;
        this.f399716h0 = r100.f399716h0;
        this.f399718i0 = r100.f399718i0;
        this.f399720j0 = r100.f399720j0;
        this.f399722k0 = r100.f399722k0;
        this.f399724l0 = r100.f399724l0;
        this.f399726m0 = r100.f399726m0;
        this.f399728n0 = r100.f399728n0;
        this.f399730o0 = r100.f399730o0;
        this.f399732p0 = r100.f399732p0;
        float[] r107 = this.f399734q0;
        float[] r108 = r100.f399734q0;
        r107[0] = r108[0];
        r107[1] = r108[1];
        ConstraintWidget[] r109 = this.f399736r0;
        ConstraintWidget[] r110 = r100.f399736r0;
        r109[0] = r110[0];
        r109[1] = r110[1];
        ConstraintWidget[] r111 = this.f399738s0;
        ConstraintWidget[] r112 = r100.f399738s0;
        r111[0] = r112[0];
        r111[1] = r112[1];
        ConstraintWidget r113 = r100.f399740t0;
        if (r113 != null) goto L9;
        ConstraintWidget r114 = null;
    L10:
        this.f399740t0 = r114;
        ConstraintWidget r115 = r100.f399742u0;
        if (r115 == null) goto L14;
        r105 = r101.get(r115);
    L14:
        this.f399742u0 = r105;
        return;
    L9:
        r114 = r101.get(r113);
        goto L10
    L5:
        r106 = r101.get(r100.X);
        goto L6
    }

    public final boolean x(int r100, int r101) {
        if (r100 != 0) goto L17;
        ConstraintAnchor r102 = this.L.f399694f;
        if (r102 != null) goto L7;
    L30:
        return false;
    L7:
        if (r102.f399691c == false) goto L30;
        ConstraintAnchor r103 = this.N.f399694f;
        if (r103 == null) goto L30;
        if (r103.f399691c == false) goto L30;
        if (((r103.d() - this.N.e()) - (this.L.f399694f.d() + this.L.e())) >= r101) goto L31;
        return false;
    L31:
        return true;
    L17:
        ConstraintAnchor r104 = this.M.f399694f;
        if (r104 == null) goto L30;
        if (r104.f399691c == false) goto L30;
        ConstraintAnchor r105 = this.O.f399694f;
        if (r105 == null) goto L30;
        if (r105.f399691c == false) goto L30;
        if (((r105.d() - this.O.e()) - (this.M.f399694f.d() + this.M.e())) >= r101) goto L32;
        return false;
    L32:
        return true;
    }

    public static void s(StringBuilder r100, String r101, ConstraintAnchor r102) {
        if (r102.f399694f != null) goto L5;
        return;
    L5:
        r100.append(LineContent.FOUR_SPACE);
        r100.append(r101);
        r100.append(" : [ '");
        r100.append(r102.f399694f);
        r100.append("'");
        if (r102.f399696h == Integer.MIN_VALUE) goto L8;
    L9:
        r100.append(",");
        r100.append(r102.f399695g);
        if (r102.f399696h == Integer.MIN_VALUE) goto L12;
        r100.append(",");
        r100.append(r102.f399696h);
        r100.append(",");
    L12:
        r100.append(" ] ,\n");
        return;
    L8:
        if (r102.f399695g == 0) goto L12;
        goto L9
    }

    public final void h(ConstraintAnchor r100, ConstraintAnchor r101, int r102) {
        if (r100.f399692d != this) goto L6;
        g(r100.getType(), r101.f399692d, r101.getType(), r102);
        return;
    }

    public static void J(StringBuilder r100, String r101, float r102, float r103) {
        if (r102 != r103) goto L5;
        return;
    L5:
        r100.append(r101);
        r100.append(" :   ");
        r100.append(r102);
        r100.append(",\n");
    }

    public static void K(StringBuilder r100, String r101, int r102, int r103) {
        if (r102 != r103) goto L4;
        return;
    L4:
        r100.append(r101);
        r100.append(" :   ");
        r100.append(r102);
        r100.append(",\n");
    }

    public final void g(ConstraintAnchor.Type r100, ConstraintWidget r110, ConstraintAnchor.Type r111, int r112) {
        ConstraintAnchor.Type r101 = ConstraintAnchor.Type.CENTER;
        if (r100 != r101) goto L44;
        if (r111 != r101) goto L29;
        ConstraintAnchor.Type r102 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor r113 = l(r102);
        ConstraintAnchor.Type r114 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor r103 = l(r114);
        ConstraintAnchor.Type r104 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor r105 = l(r104);
        ConstraintAnchor.Type r106 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r107 = l(r106);
        boolean r108 = true;
        if (r113 != null) goto L8;
    L9:
        if (r103 != null) goto L11;
    L13:
        g(r102, r110, r102, 0);
        g(r114, r110, r114, 0);
        boolean r109 = true;
    L14:
        if (r105 != null) goto L16;
    L17:
        if (r107 != null) goto L19;
    L21:
        g(r104, r110, r104, 0);
        g(r106, r110, r106, 0);
    L22:
        if (r109 == false) goto L25;
        if (r108 == false) goto L25;
        l(r101).a(r110.l(r101), 0);
        return;
    L25:
        if (r109 == false) goto L27;
        ConstraintAnchor.Type r115 = ConstraintAnchor.Type.CENTER_X;
        l(r115).a(r110.l(r115), 0);
        return;
    L27:
        if (r108 == false) goto L103;
        ConstraintAnchor.Type r116 = ConstraintAnchor.Type.CENTER_Y;
        l(r116).a(r110.l(r116), 0);
        return;
    L103:
        return;
    L19:
        if (r107.h() == false) goto L21;
    L20:
        r108 = false;
        goto L22
    L16:
        if (r105.h() == true) goto L20;
    L11:
        if (r103.h() == false) goto L13;
    L12:
        r109 = false;
        goto L14
    L8:
        if (r113.h() == true) goto L12;
    L29:
        ConstraintAnchor.Type r117 = ConstraintAnchor.Type.LEFT;
        if (r111 != r117) goto L32;
    L39:
        g(r117, r110, r111, 0);
        g(ConstraintAnchor.Type.RIGHT, r110, r111, 0);     // Catch: Throwable -> L42
        l(r101).a(r110.l(r111), 0);
        return;
    L42:
        th = move-exception;
        throw th;
    L32:
        if (r111 == ConstraintAnchor.Type.RIGHT) goto L39;
        ConstraintAnchor.Type r118 = ConstraintAnchor.Type.TOP;
        if (r111 != r118) goto L37;
    L38:
        g(r118, r110, r111, 0);
        g(ConstraintAnchor.Type.BOTTOM, r110, r111, 0);
        l(r101).a(r110.l(r111), 0);
        return;
    L37:
        if (r111 == ConstraintAnchor.Type.BOTTOM) goto L38;
        return;
    L44:
        ConstraintAnchor.Type r119 = ConstraintAnchor.Type.CENTER_X;
        if (r100 != r119) goto L51;
        ConstraintAnchor.Type r120 = ConstraintAnchor.Type.LEFT;
        if (r111 != r120) goto L49;
    L50:
        ConstraintAnchor r121 = l(r120);
        ConstraintAnchor r122 = r110.l(r111);
        ConstraintAnchor r123 = l(ConstraintAnchor.Type.RIGHT);
        r121.a(r122, 0);
        r123.a(r122, 0);
        l(r119).a(r122, 0);
        return;
    L49:
        if (r111 == ConstraintAnchor.Type.RIGHT) goto L50;
    L51:
        ConstraintAnchor.Type r124 = ConstraintAnchor.Type.CENTER_Y;
        if (r100 != r124) goto L58;
        ConstraintAnchor.Type r125 = ConstraintAnchor.Type.TOP;
        if (r111 != r125) goto L56;
    L57:
        ConstraintAnchor r126 = r110.l(r111);
        l(r125).a(r126, 0);
        l(ConstraintAnchor.Type.BOTTOM).a(r126, 0);
        l(r124).a(r126, 0);
        return;
    L56:
        if (r111 == ConstraintAnchor.Type.BOTTOM) goto L57;
    L58:
        if (r100 != r119) goto L61;
        if (r111 != r119) goto L61;
        ConstraintAnchor.Type r127 = ConstraintAnchor.Type.LEFT;
        l(r127).a(r110.l(r127), 0);
        ConstraintAnchor.Type r128 = ConstraintAnchor.Type.RIGHT;
        l(r128).a(r110.l(r128), 0);
        l(r119).a(r110.l(r111), 0);
        return;
    L61:
        if (r100 != r124) goto L64;
        if (r111 != r124) goto L64;
        ConstraintAnchor.Type r129 = ConstraintAnchor.Type.TOP;
        l(r129).a(r110.l(r129), 0);
        ConstraintAnchor.Type r130 = ConstraintAnchor.Type.BOTTOM;
        l(r130).a(r110.l(r130), 0);
        l(r124).a(r110.l(r111), 0);
        return;
    L64:
        ConstraintAnchor r131 = l(r100);
        ConstraintAnchor r132 = r110.l(r111);
        if (r131.i(r132) == false) goto L112;
        ConstraintAnchor.Type r133 = ConstraintAnchor.Type.BASELINE;
        if (r100 != r133) goto L74;
        ConstraintAnchor r134 = l(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r135 = l(ConstraintAnchor.Type.BOTTOM);
        if (r134 == null) goto L71;
        r134.j();
    L71:
        if (r135 == null) goto L97;
        r135.j();
    L97:
        r131.a(r132, r112);
        return;
    L74:
        if (r100 != ConstraintAnchor.Type.TOP) goto L76;
    L88:
        ConstraintAnchor r136 = l(r133);
        if (r136 == null) goto L91;
        r136.j();
    L91:
        ConstraintAnchor r137 = l(r101);
        if (r137.f399694f == r132) goto L94;
        r137.j();
    L94:
        ConstraintAnchor r138 = l(r100).f();
        ConstraintAnchor r139 = l(r124);
        if (r139.h() == false) goto L97;
        r138.j();
        r139.j();
        goto L97
    L76:
        if (r100 == ConstraintAnchor.Type.BOTTOM) goto L88;
        if (r100 != ConstraintAnchor.Type.LEFT) goto L81;
    L82:
        ConstraintAnchor r140 = l(r101);
        if (r140.f399694f == r132) goto L85;
        r140.j();
    L85:
        ConstraintAnchor r141 = l(r100).f();
        ConstraintAnchor r142 = l(r119);
        if (r142.h() == false) goto L97;
        r141.j();
        r142.j();
        goto L97
    L81:
        if (r100 != ConstraintAnchor.Type.RIGHT) goto L97;
    }

    public final void c(d r100, com.obric.oui.constraintlayout.core.c r101, HashSet<ConstraintWidget> r110, int r111, boolean r112) {
        if (r112 == true) goto L4;
    L7:
        if (r111 != 0) goto L20;
        HashSet<ConstraintAnchor> r113 = this.L.f399689a;
        if (r113 == null) goto L14;
        Iterator<ConstraintAnchor> r114 = r113.iterator();
    L12:
        if (r114.hasNext() == false) goto L14;
        r114.next().f399692d.c(r100, r101, r110, r111, true);
    L14:
        HashSet<ConstraintAnchor> r115 = this.N.f399689a;
        if (r115 == null) goto L42;
        Iterator<ConstraintAnchor> r116 = r115.iterator();
    L18:
        if (r116.hasNext() == false) goto L52;
        r116.next().f399692d.c(r100, r101, r110, r111, true);
        goto L18
    L52:
        return;
    L42:
        return;
    L20:
        HashSet<ConstraintAnchor> r117 = this.M.f399689a;
        if (r117 == null) goto L26;
        Iterator<ConstraintAnchor> r118 = r117.iterator();
    L24:
        if (r118.hasNext() == false) goto L26;
        r118.next().f399692d.c(r100, r101, r110, r111, true);
    L26:
        HashSet<ConstraintAnchor> r119 = this.O.f399689a;
        if (r119 == null) goto L32;
        Iterator<ConstraintAnchor> r120 = r119.iterator();
    L30:
        if (r120.hasNext() == false) goto L32;
        r120.next().f399692d.c(r100, r101, r110, r111, true);
    L32:
        HashSet<ConstraintAnchor> r121 = this.P.f399689a;
        if (r121 == null) goto L51;
        Iterator<ConstraintAnchor> r122 = r121.iterator();
    L36:
        if (r122.hasNext() == false) goto L53;
        r122.next().f399692d.c(r100, r101, r110, r111, true);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L53:
        return;
    L51:
        return;
    L4:
        if (r110.contains(this) == true) goto L6;
        return;
    L6:
        g.a(r100, r101, this);
        r110.remove(this);
        d(r101, r100.Y(64));
        goto L7
    }

    public final void y(ConstraintAnchor.Type r100, ConstraintWidget r101, ConstraintAnchor.Type r102, int r103, int r104) {
        l(r100).b(r101.l(r102), r103, r104, true);
    }

    public static void r(StringBuilder r100, String r101, int r102, int r103, int r104, int r105, int r106, float r107, DimensionBehaviour r108) {
        r100.append(r101);
        r100.append(" :  {\n");
        String r109 = r108.toString();
        if (DimensionBehaviour.FIXED.toString().equals(r109) == true) goto L6;
        r100.append("      behavior");
        r100.append(" :   ");
        r100.append(r109);
        r100.append(",\n");
    L6:
        K(r100, "      size", r102, 0);
        K(r100, "      min", r103, 0);
        K(r100, "      max", r104, Integer.MAX_VALUE);
        K(r100, "      matchMin", r105, 0);
        K(r100, "      matchDef", r106, 0);
        J(r100, "      matchPercent", r107, 1.0f);
        r100.append("    },\n");
    }

    public final void f(com.obric.oui.constraintlayout.core.c r310, boolean r311, boolean r312, boolean r313, boolean r314, SolverVariable r315, SolverVariable r316, DimensionBehaviour r317, boolean r318, ConstraintAnchor r319, ConstraintAnchor r410, int r411, int r412, int r413, int r414, float r415, boolean r416, boolean r417, boolean r418, boolean r419, boolean r510, int r511, int r512, int r513, int r514, float r515, boolean r516) {
        int r100 = r513;
        int r101 = r514;
        SolverVariable r102 = r310.k(r319);
        SolverVariable r103 = r310.k(r410);
        SolverVariable r104 = r310.k(r319.f399694f);
        SolverVariable r105 = r310.k(r410.f399694f);
        boolean r110 = r319.h();
        boolean r111 = r410.h();
        boolean r112 = this.S.h();
        if (r111 == false) goto L5;
        int r113 = (r110 ? 1 : 0) + 1;
    L6:
        if (r112 == false) goto L8;
        r113 = r113 + 1;
    L8:
        int r106 = r113;
        if (r416 == false) goto L11;
        int r114 = 3;
    L12:
        int r115 = a.f399752b[r317.ordinal()];
        if (r115 != 1) goto L15;
    L24:
        int r116 = r114;
    L25:
        boolean r117 = false;
    L26:
        int r118 = this.f399717i;
        if (r118 == (-1)) goto L30;
        if (r311 == false) goto L30;
        this.f399717i = -1;
        r412 = r118;
        r117 = false;
    L30:
        int r119 = this.f399719j;
        if (r119 == (-1)) goto L34;
        if (r311 == true) goto L34;
        this.f399719j = -1;
        r117 = false;
    L35:
        int r420 = r119;
        if (this.f399722k0 != 8) goto L38;
        int r107 = 0;
        r117 = false;
    L39:
        if (r516 == false) goto L47;
        if (r110 == true) goto L44;
        if (r111 == true) goto L44;
        if (r112 == true) goto L44;
        r310.d(r102, r411);
    L44:
        if (r110 == false) goto L47;
        if (r111 == true) goto L47;
        int r120 = 8;
        r310.e(r102, r104, r319.e(), 8);
    L48:
        if (r117 == true) goto L59;
        if (r318 == false) goto L56;
        r310.e(r103, r102, 0, 3);
        if (r413 <= 0) goto L54;
        r310.f(r103, r102, r413, r120);
    L54:
        if (r414 >= Integer.MAX_VALUE) goto L98;
        r310.g(r103, r102, r414, r120);
    L98:
        int r121 = r100;
    L113:
        if (r516 == false) goto L338;
        if (r418 == true) goto L338;
        if (r110 == true) goto L121;
        if (r111 == true) goto L121;
        if (r112 == true) goto L121;
        SolverVariable r108 = r105;
    L136:
        ConstraintAnchor r109 = r410;
        SolverVariable r122 = r108;
        SolverVariable r123 = r103;
        r314 = r314;
        boolean r210 = r312;
    L328:
        int r124 = 5;
    L329:
        if (r210 == false) goto L367;
        if (r314 == true) goto L332;
        return;
    L332:
        if (r109.f399694f == null) goto L334;
        int r125 = r410.e();
    L335:
        if (r122 == r316) goto L369;
        r310.f(r316, r123, r125, r124);
        return;
    L369:
        return;
    L334:
        r125 = 0;
        goto L335
    L367:
        return;
    L121:
        if (r110 == false) goto L131;
        if (r111 == true) goto L131;
        ConstraintWidget r126 = r319.f399694f.f399692d;
        if (r312 == true) goto L126;
    L128:
        int r127 = 5;
    L129:
        r210 = r312;
        r109 = r410;
        r123 = r103;
        r314 = r314;
        r124 = r127;
        r122 = r105;
        goto L329
    L126:
        if ((r126 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L128;
        r127 = 8;
    L131:
        if (r110 == true) goto L137;
        if (r111 == false) goto L137;
        r108 = r105;
        r310.e(r103, r108, -r410.e(), 8);
        if (r312 == false) goto L136;
        r310.f(r102, r315, 0, 5);
    L137:
        r108 = r105;
        if (r110 == false) goto L136;
        if (r111 == false) goto L136;
        ConstraintWidget r128 = r319.f399694f.f399692d;
        r109 = r410;
        ConstraintWidget r129 = r109.f399694f.f399692d;
        ConstraintWidget r130 = this.X;
        int r131 = 6;
        if (r117 == false) goto L212;
        if (r116 != 0) goto L162;
        if (r101 != 0) goto L152;
        if (r121 != 0) goto L152;
        if (r104.f399611f == true) goto L148;
    L151:
        int r320 = 8;
        int r132 = 8;
        boolean r133 = false;
        boolean r211 = true;
        boolean r212 = false;
    L154:
        if ((r128 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L156;
    L159:
        int r134 = 4;
    L160:
        int r135 = r134;
        int r136 = r132;
        int r213 = 6;
        int r137 = r116;
        r316 = r316;
        boolean r214 = r211;
        boolean r215 = r133;
        boolean r138 = r214;
    L230:
        if (r212 == false) goto L234;
        if (r104 != r108) goto L234;
        if (r128 == r130) goto L234;
        boolean r216 = false;
        boolean r217 = false;
    L235:
        if (r215 == false) goto L244;
        if (r117 == true) goto L242;
        if (r417 == true) goto L242;
        if (r419 == true) goto L242;
        if (r104 != r315) goto L242;
        if (r108 != r316) goto L242;
        r210 = false;
        int r218 = 8;
        r213 = 8;
        boolean r219 = false;
    L243:
        SolverVariable r220 = r103;
        r310.b(r102, r104, r319.e(), r415, r108, r103, r410.e(), r213);
        r136 = r218;
        r216 = r219;
    L246:
        if (this.f399722k0 != 8) goto L256;
        HashSet<ConstraintAnchor> r139 = r109.f399689a;
        if (r139 != null) goto L251;
    L253:
        boolean r140 = false;
    L254:
        if (r140 == true) goto L256;
        return;
    L251:
        if (r139.size() <= 0) goto L253;
        r140 = true;
    L256:
        if (r217 == false) goto L267;
        r122 = r108;
        if (r210 == false) goto L266;
        if (r104 == r122) goto L266;
        if (r117 == true) goto L266;
        if ((r128 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L264;
    L265:
        r136 = 6;
        goto L266
    L264:
        if ((r129 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L265;
    L266:
        r310.f(r102, r104, r319.e(), r136);
        r123 = r220;
        r310.g(r123, r122, -r410.e(), r136);
    L268:
        if (r210 == false) goto L277;
        if (r510 == false) goto L277;
        if ((r128 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L277;
        if ((r129 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L277;
        ConstraintWidget r141 = r130;
        if (r129 == r141) goto L278;
        r136 = 6;
        int r142 = 6;
        boolean r221 = true;
    L279:
        if (r221 == false) goto L310;
        if (r138 == false) goto L301;
        if (r419 == false) goto L283;
        if (r313 == false) goto L301;
    L283:
        if (r128 == r141) goto L288;
        if (r129 == r141) goto L288;
        r131 = r142;
    L288:
        if ((r128 instanceof f) == false) goto L290;
    L291:
        r131 = 5;
    L293:
        if ((r128 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L295;
    L296:
        r131 = 5;
    L297:
        if (r419 == false) goto L299;
        int r143 = 5;
    L300:
        r142 = Math.max(r143, r142);
        goto L301
    L299:
        r143 = r131;
        goto L300
    L295:
        if ((r129 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L297;
    L290:
        if ((r129 instanceof f) == false) goto L293;
    L301:
        if (r210 == false) goto L308;
        int r144 = Math.min(r136, r142);
        if (r416 == false) goto L309;
        if (r419 == true) goto L309;
        if (r128 == r141) goto L307;
        if (r129 != r141) goto L309;
    L307:
        r144 = 4;
    L309:
        r310.e(r102, r104, r319.e(), r144);
        r310.e(r123, r122, -r410.e(), r144);
        goto L310
    L308:
        r144 = r142;
    L310:
        if (r210 == true) goto L312;
    L317:
        if (r210 == false) goto L328;
        if (r117 == false) goto L328;
        if (r413 != 0) goto L328;
        if (r121 != 0) goto L328;
        if (r117 == true) goto L323;
    L325:
        r310.f(r123, r102, 0, 5);
        goto L328
    L323:
        if (r137 != 3) goto L325;
        r310.f(r123, r102, 0, 8);
        goto L328
    L312:
        if (r315 != r104) goto L314;
        int r145 = r319.e();
    L315:
        if (r104 == r315) goto L317;
        r310.f(r102, r315, r145, 5);
        goto L317
    L314:
        r145 = 0;
    L278:
        r142 = r135;
        r221 = r216;
    L277:
        r141 = r130;
        goto L278
    L267:
        r122 = r108;
        r123 = r220;
    L242:
        r210 = r312;
        r219 = r216;
        r218 = r136;
        goto L243
    L244:
        r220 = r103;
        r210 = r312;
    L234:
        r217 = r212;
        r216 = true;
        goto L235
    L156:
        if ((r129 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L159;
        r134 = r320;
        goto L160
    L148:
        if (r108.f399611f == false) goto L151;
        r310.e(r102, r104, r319.e(), 8);
        r310.e(r103, r108, -r410.e(), 8);
        return;
    L152:
        r320 = 5;
        r132 = 5;
        r133 = true;
        r211 = false;
        r212 = true;
        goto L154
    L162:
        if (r116 != 2) goto L171;
        if ((r128 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L166;
    L169:
        r137 = r116;
    L226:
        int r146 = 4;
    L227:
        r135 = r146;
        r136 = 5;
    L228:
        boolean r147 = true;
        r215 = true;
    L229:
        r212 = r147;
        r138 = false;
        r213 = 6;
        goto L230
    L166:
        if ((r129 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L169;
        r137 = r116;
        r146 = 5;
        goto L227
    L171:
        if (r116 != 1) goto L174;
        r137 = r116;
        r136 = 8;
        r135 = 4;
        r316 = r316;
        goto L228
    L174:
        if (r116 != 3) goto L211;
        r137 = r116;
        if (this.C != (-1)) goto L183;
        if (r419 == false) goto L181;
        if (r312 == false) goto L180;
        int r148 = 5;
    L182:
        int r149 = r148;
        int r150 = 5;
        int r151 = 8;
    L209:
        r213 = r149;
        r138 = true;
        r215 = true;
        r212 = true;
        r135 = r150;
        r136 = r151;
    L210:
        r316 = r316;
        goto L230
    L180:
        r148 = 4;
        goto L182
    L181:
        r148 = 8;
        goto L182
    L183:
        if (r416 == true) goto L185;
        if (r101 <= 0) goto L197;
        r150 = 5;
    L207:
        r151 = 5;
    L208:
        r149 = 6;
        goto L209
    L197:
        if (r101 != 0) goto L206;
        if (r121 != 0) goto L206;
        if (r419 == true) goto L201;
        r150 = 8;
        goto L207
    L201:
        if (r128 == r130) goto L204;
        if (r129 == r130) goto L204;
        int r152 = 4;
    L205:
        r151 = r152;
        r150 = 4;
    L204:
        r152 = 5;
    L206:
        r150 = 4;
        goto L207
    L185:
        if (r512 != 2) goto L187;
    L190:
        boolean r153 = true;
    L191:
        if (r153 == true) goto L193;
        int r154 = 5;
        int r155 = 8;
    L194:
        r135 = r154;
        r136 = r155;
        r138 = true;
        r215 = true;
        r212 = true;
        r213 = 6;
        goto L210
    L193:
        r154 = 4;
        r155 = 5;
        goto L194
    L187:
        if (r512 == 1) goto L190;
        r153 = false;
        goto L191
    L211:
        r137 = r116;
        r316 = r316;
        r136 = 5;
        r135 = 4;
        r147 = false;
        r215 = false;
        goto L229
    L212:
        r137 = r116;
        if (r104.f399611f == false) goto L226;
        if (r108.f399611f == false) goto L226;
        r310.b(r102, r104, r319.e(), r415, r108, r103, r410.e(), 8);
        if (r312 == false) goto L364;
        if (r314 == true) goto L220;
        return;
    L220:
        if (r109.f399694f == null) goto L222;
        int r156 = r410.e();
    L223:
        if (r108 == r316) goto L366;
        r310.f(r316, r103, r156, 5);
        return;
    L366:
        return;
    L222:
        r156 = 0;
        goto L223
    L364:
        return;
    L338:
        boolean r321 = r314;
        if (r106 >= 2) goto L370;
        if (r312 == false) goto L371;
        if (r321 == false) goto L372;
        r310.f(r102, r315, 0, 8);
        if (r311 == false) goto L345;
    L348:
        boolean r157 = true;
    L349:
        if (r311 == true) goto L360;
        ConstraintAnchor r158 = this.P.f399694f;
        if (r158 == null) goto L360;
        ConstraintWidget r159 = r158.f399692d;
        if (r159.f399702a0 == 0.0f) goto L359;
        DimensionBehaviour[] r160 = r159.W;
        DimensionBehaviour r161 = r160[0];
        DimensionBehaviour r162 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r161 != r162) goto L359;
        if (r160[1] != r162) goto L359;
        boolean r163 = true;
    L361:
        if (r163 == false) goto L373;
        r310.f(r316, r103, 0, 8);
        return;
    L373:
        return;
    L359:
        r163 = false;
    L360:
        r163 = r157;
        goto L361
    L345:
        if (this.P.f399694f == null) goto L348;
        r157 = false;
        goto L349
    L372:
        return;
    L371:
        return;
    L370:
        return;
    L56:
        r310.e(r103, r102, r107, r120);
        goto L98
    L59:
        if (r106 == 2) goto L69;
        if (r416 == true) goto L69;
        if (r116 == 1) goto L64;
        if (r116 != 0) goto L69;
    L64:
        int r164 = Math.max(r100, r107);
        if (r101 <= 0) goto L67;
        r164 = Math.min(r101, r164);
    L67:
        r310.e(r103, r102, r164, 8);
        r117 = false;
    L69:
        if (r100 != (-2)) goto L71;
        r100 = r107;
    L71:
        if (r101 != (-2)) goto L73;
        r101 = r107;
    L73:
        if (r107 > 0) goto L75;
    L77:
        if (r100 <= 0) goto L79;
        r310.f(r103, r102, r100, 8);
        r107 = Math.max(r107, r100);
    L79:
        if (r101 <= 0) goto L89;
        if (r312 == true) goto L82;
    L84:
        boolean r165 = true;
    L85:
        if (r165 == false) goto L87;
        int r166 = 8;
        r310.g(r103, r102, r101, 8);
    L88:
        r107 = Math.min(r107, r101);
    L91:
        if (r116 != 1) goto L100;
        if (r312 == false) goto L94;
        r310.e(r103, r102, r107, r166);
        goto L98
    L94:
        if (r418 == false) goto L96;
        r310.e(r103, r102, r107, 5);
        r310.g(r103, r102, r107, r166);
        goto L98
    L96:
        r310.e(r103, r102, r107, 5);
        r310.g(r103, r102, r107, r166);
        goto L98
    L100:
        if (r116 != 2) goto L112;
        ConstraintAnchor.Type r167 = r319.getType();
        ConstraintAnchor.Type r168 = ConstraintAnchor.Type.TOP;
        if (r167 != r168) goto L104;
    L107:
        SolverVariable r169 = r310.k(this.X.l(r168));
        SolverVariable r170 = r310.k(this.X.l(ConstraintAnchor.Type.BOTTOM));
    L108:
        com.obric.oui.constraintlayout.core.b r171 = r310.l();
        r171.f399632d.e(r103, -1.0f);
        r171.f399632d.e(r102, 1.0f);
        r171.f399632d.e(r170, r515);
        r171.f399632d.e(r169, -r515);
        r310.c(r171);
        if (r312 == false) goto L98;
        r117 = false;
        goto L98
    L104:
        if (r319.getType() == ConstraintAnchor.Type.BOTTOM) goto L107;
        r169 = r310.k(this.X.l(ConstraintAnchor.Type.LEFT));
        r170 = r310.k(this.X.l(ConstraintAnchor.Type.RIGHT));
        goto L108
    L112:
        r106 = r106 == true ? 1 : 0;
        r121 = r100;
        r314 = true;
        goto L113
    L87:
        r166 = 8;
        goto L88
    L82:
        if (r116 != 1) goto L84;
        r165 = false;
        goto L85
    L89:
        r166 = 8;
        goto L91
    L75:
        if (r116 == 1) goto L77;
        r107 = 0;
    L47:
        r120 = 8;
        goto L48
    L38:
        r107 = r420;
    L34:
        r119 = r412;
        goto L35
    L15:
        if (r115 == 2) goto L24;
        if (r115 == 3) goto L24;
        if (r115 == 4) goto L21;
        r116 = r114;
        goto L25
    L21:
        r116 = r114;
        if (r116 == 4) goto L25;
        r117 = true;
        goto L26
    L11:
        r114 = r511;
        goto L12
    L5:
        r113 = r110 ? 1 : 0;
        goto L6
    }
}
