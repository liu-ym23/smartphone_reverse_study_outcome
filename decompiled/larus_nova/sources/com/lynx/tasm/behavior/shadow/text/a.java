package com.lynx.tasm.behavior.shadow.text;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import z6a.t;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public List<C4563a> A;
    public boolean B;
    public boolean C;
    public String D;
    public String E;
    public boolean F;
    public int G;
    public int H;
    public com.lynx.tasm.behavior.ui.g I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f382244J;
    public int K;
    public int L;
    public int M;
    public float N;
    public a7a.b O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f382245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f382246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f382247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f382249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f382250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f382251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f382252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f382253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f382254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f382255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f382256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f382257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f382258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public t f382259o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f382260p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f382261q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f382262r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f382263s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f382264t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f382265u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f382266v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f382267w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f382268x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f382269y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f382270z;

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.shadow.text.a$a, reason: collision with other inner class name */
    public static class C4563a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f382271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f382273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f382274d;

        public final int hashCode() {
            return (((((this.f382271a * 31) + this.f382272b) * 31) + Float.floatToIntBits(this.f382273c)) * 31) + Float.floatToIntBits(this.f382274d);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C4563a) == true) goto L5;
            return false;
        L5:
            C4563a r101 = (C4563a) r100;
            if (this.f382271a == r101.f382271a) goto L8;
            return false;
        L8:
            if (this.f382272b == r101.f382272b) goto L10;
            return false;
        L10:
            if (com.lynx.tasm.utils.b.a(this.f382273c, r101.f382273c) == true) goto L12;
            return false;
        L12:
            if (com.lynx.tasm.utils.b.a(this.f382274d, r101.f382274d) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public C4563a(int r100, int r101, float r102, float r103) {
            this.f382271a = r100;
            this.f382272b = r101;
            this.f382273c = r102;
            this.f382274d = r103;
        }
    }

    public final a a() {
        a r100 = new a();
        r100.f382245a = this.f382245a;
        r100.f382246b = this.f382246b;
        r100.f382247c = this.f382247c;
        r100.f382248d = this.f382248d;
        r100.f382250f = this.f382250f;
        r100.f382251g = this.f382251g;
        r100.f382252h = this.f382252h;
        r100.f382253i = this.f382253i;
        r100.f382254j = this.f382254j;
        r100.f382255k = this.f382255k;
        r100.f382256l = this.f382256l;
        r100.f382257m = this.f382257m;
        r100.f382258n = this.f382258n;
        r100.f382259o = this.f382259o;
        r100.f382260p = this.f382260p;
        r100.f382261q = this.f382261q;
        r100.f382262r = this.f382262r;
        r100.f382263s = this.f382263s;
        r100.f382264t = this.f382264t;
        r100.f382265u = this.f382265u;
        r100.I = this.I;
        r100.f382244J = this.f382244J;
        r100.K = this.K;
        r100.L = this.L;
        r100.N = this.N;
        r100.M = this.M;
        r100.f382249e = this.f382249e;
        r100.H = this.H;
        r100.f382266v = this.f382266v;
        r100.f382268x = this.f382268x;
        r100.f382267w = this.f382267w;
        r100.f382269y = this.f382269y;
        r100.f382270z = this.f382270z;
        if (this.A != null) goto L5;
        ArrayList r101 = null;
    L6:
        r100.A = r101;
        r100.G = this.G;
        r100.B = this.B;
        r100.C = this.C;
        r100.D = this.D;
        r100.E = this.E;
        r100.F = this.F;
        return r100;
    L5:
        r101 = new ArrayList(this.A);
        goto L6
    }

    public final TextDirectionHeuristic b() {
        int r100 = this.f382249e;
        if (r100 != 0) goto L7;
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L7:
        if (r100 != 3) goto L11;
        return TextDirectionHeuristics.LTR;
    L11:
        return TextDirectionHeuristics.RTL;
    }

    public final String c() {
        if (this.F == false) goto L5;
        StringBuilder r100 = new StringBuilder();
        if (TextUtils.isEmpty(this.D) == true) goto L9;
        r100.append(this.D);
        r100.append(",");
    L9:
        r100.append("'opsz' ");
        r100.append(this.f382258n);
        return r100.toString();
    L5:
        return this.D;
    }

    public final int e() {
        int r100 = this.f382251g;
        if (r100 == 1) goto L8;
        if (r100 < 6) goto L7;
        if (r100 <= 10) goto L8;
    L7:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L12;
    L14:
        if (r100 == 1) goto L19;
        if (r100 < 6) goto L18;
        if (r100 <= 10) goto L19;
    L18:
        boolean r102 = false;
    L20:
        if (r102 == false) goto L22;
        return 1;
    L22:
        int r103 = this.f382252h;
        if (r103 == 2) goto L25;
        return 0;
    L25:
        return r103;
    L19:
        r102 = true;
        goto L20
    L12:
        if (this.f382252h != 2) goto L14;
        return 3;
    L8:
        r101 = true;
        goto L10
    }

    public final int hashCode() {
        int r100 = ((this.f382245a * 31) + this.f382246b) * 31;
        Integer r101 = this.f382247c;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        int r103 = (((((((((((((((((((r100 + r102) * 31) + this.f382248d) * 31) + this.f382250f) * 31) + this.f382251g) * 31) + this.f382253i) * 31) + this.f382254j) * 31) + Float.floatToIntBits(this.f382255k)) * 31) + Float.floatToIntBits(this.f382256l)) * 31) + Float.floatToIntBits(this.f382257m)) * 31) + Float.floatToIntBits(this.f382258n)) * 31;
        t r104 = this.f382259o;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((((((r103 + r106) * 31) + Float.floatToIntBits(this.f382260p)) * 31) + (this.f382261q ? 1 : 0)) * 31) + (this.f382263s ? 1 : 0)) * 31) + (this.f382262r ? 1 : 0)) * 31) + (this.f382264t ? 1 : 0)) * 31;
        String r108 = this.f382265u;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        com.lynx.tasm.behavior.ui.g r111 = this.I;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((((((((((r110 + r112) * 31) + this.f382244J) * 31) + this.K) * 31) + this.L) * 31) + Float.floatToIntBits(this.N)) * 31) + this.M) * 31) + this.f382249e) * 31;
        a7a.b r114 = this.O;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((((((((((r113 + r115) * 31) + this.H) * 31) + (this.f382266v ? 1 : 0)) * 31) + Float.floatToIntBits(this.f382268x)) * 31) + Float.floatToIntBits(this.f382267w)) * 31) + Float.floatToIntBits(this.f382269y)) * 31;
        float[] r117 = this.f382270z;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        List<C4563a> r120 = this.A;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((((((r119 + r121) * 31) + this.G) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31;
        String r123 = this.D;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.E;
        if (r126 == null) goto L39;
        r105 = r126.hashCode();
    L39:
        return ((r125 + r105) * 31) + (this.F ? 1 : 0);
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = -16777216;
        goto L6
    }

    public a() {
        this.f382245a = -1;
        this.f382246b = -1;
        this.f382247c = null;
        this.f382248d = 3;
        this.f382249e = 0;
        this.f382250f = -1;
        this.f382251g = 0;
        this.f382252h = 0;
        this.f382253i = 0;
        this.f382254j = 0;
        this.f382255k = 1.0E21f;
        this.f382256l = 1.0E21f;
        this.f382257m = 0.0f;
        this.f382258n = 0.0f;
        this.f382259o = null;
        this.f382260p = 0.0f;
        this.f382261q = false;
        this.f382262r = false;
        this.f382263s = false;
        this.f382264t = false;
        this.f382265u = null;
        this.f382266v = false;
        this.f382267w = 0.0f;
        this.f382268x = 0.0f;
        this.f382269y = 1.0f;
        this.B = false;
        this.C = false;
        this.D = null;
        this.E = null;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.K = 4;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = null;
    }

    public final Layout.Alignment d(boolean r100) {
        int r101 = this.f382248d;
        if (r101 != 0) goto L16;
        int r102 = this.f382249e;
        if (r102 != 0) goto L10;
        if (r100 == false) goto L9;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L9:
        return Layout.Alignment.ALIGN_NORMAL;
    L10:
        if (r102 != 3) goto L14;
        return Layout.Alignment.ALIGN_NORMAL;
    L14:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L16:
        if (r101 != 2) goto L29;
        int r103 = this.f382249e;
        if (r103 != 0) goto L23;
        if (r100 == false) goto L22;
        return Layout.Alignment.ALIGN_NORMAL;
    L22:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L23:
        if (r103 != 3) goto L27;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L27:
        return Layout.Alignment.ALIGN_NORMAL;
    L29:
        if (r101 != 1) goto L33;
        return Layout.Alignment.ALIGN_CENTER;
    L33:
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        a r101 = (a) r100;
        if (this.f382245a == r101.f382245a) goto L8;
        return false;
    L8:
        if (this.f382246b != r101.f382246b) goto L95;
        Integer r102 = r101.f382247c;
        Integer r103 = this.f382247c;
        if (r103 == null) goto L13;
        if (r102 == null) goto L13;
        boolean r104 = r103.equals(r102);
    L17:
        if (r104 == true) goto L19;
        return false;
    L19:
        if (this.f382248d == r101.f382248d) goto L21;
        return false;
    L21:
        if (this.f382250f == r101.f382250f) goto L23;
        return false;
    L23:
        if (this.f382251g == r101.f382251g) goto L25;
        return false;
    L25:
        if (this.f382252h == r101.f382252h) goto L27;
        return false;
    L27:
        if (this.f382253i == r101.f382253i) goto L29;
        return false;
    L29:
        if (this.f382254j == r101.f382254j) goto L31;
        return false;
    L31:
        if (com.lynx.tasm.utils.b.a(this.f382255k, r101.f382255k) == true) goto L33;
        return false;
    L33:
        if (com.lynx.tasm.utils.b.a(this.f382256l, r101.f382256l) == true) goto L35;
        return false;
    L35:
        if (com.lynx.tasm.utils.b.a(this.f382257m, r101.f382257m) == true) goto L37;
        return false;
    L37:
        if (com.lynx.tasm.utils.b.a(this.f382258n, r101.f382258n) == true) goto L39;
        return false;
    L39:
        if (Objects.equals(this.f382259o, r101.f382259o) == true) goto L41;
        return false;
    L41:
        if (this.f382260p == r101.f382260p) goto L43;
        return false;
    L43:
        if (this.f382261q == r101.f382261q) goto L45;
        return false;
    L45:
        if (this.f382263s == r101.f382263s) goto L47;
        return false;
    L47:
        if (this.f382262r == r101.f382262r) goto L49;
        return false;
    L49:
        if (this.f382264t == r101.f382264t) goto L51;
        return false;
    L51:
        if (TextUtils.equals(this.f382265u, r101.f382265u) == true) goto L53;
        return false;
    L53:
        if (Objects.equals(this.I, r101.I) == true) goto L55;
        return false;
    L55:
        if (this.f382244J == r101.f382244J) goto L57;
        return false;
    L57:
        if (this.f382249e == r101.f382249e) goto L59;
        return false;
    L59:
        if (this.L == r101.L) goto L61;
        return false;
    L61:
        if (this.K == r101.K) goto L63;
        return false;
    L63:
        if (this.M == r101.M) goto L65;
        return false;
    L65:
        if (com.lynx.tasm.utils.b.a(this.N, r101.N) == true) goto L67;
        return false;
    L67:
        if (this.H == r101.H) goto L69;
        return false;
    L69:
        if (this.f382266v == r101.f382266v) goto L71;
        return false;
    L71:
        if (com.lynx.tasm.utils.b.a(this.f382268x, r101.f382268x) == true) goto L73;
        return false;
    L73:
        if (com.lynx.tasm.utils.b.a(this.f382267w, r101.f382267w) == true) goto L75;
        return false;
    L75:
        if (com.lynx.tasm.utils.b.a(this.f382269y, r101.f382269y) == true) goto L77;
        return false;
    L77:
        if (Arrays.equals(this.f382270z, r101.f382270z) == true) goto L79;
        return false;
    L79:
        if (Objects.equals(this.A, r101.A) == true) goto L81;
        return false;
    L81:
        if (this.G == r101.G) goto L83;
        return false;
    L83:
        if (this.B == r101.B) goto L85;
        return false;
    L85:
        if (this.C == r101.C) goto L87;
        return false;
    L87:
        if (this.F == r101.F) goto L89;
        return false;
    L89:
        if (TextUtils.equals(this.D, r101.D) == true) goto L91;
        return false;
    L91:
        if (TextUtils.equals(this.E, r101.E) == false) goto L133;
        return true;
    L133:
        return false;
    L13:
        if (r103 != null) goto L16;
        if (r102 != null) goto L16;
        r104 = true;
    L16:
        r104 = false;
        goto L17
    L95:
        return false;
    }
}
