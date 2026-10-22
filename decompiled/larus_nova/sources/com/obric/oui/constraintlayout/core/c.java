package com.obric.oui.constraintlayout.core;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f399634q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f399635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f399636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f399638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f399639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b[] f399641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f399642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f399643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399645k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final rla.a f399647m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SolverVariable[] f399648n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f399649o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f399650p;

    public interface a {
        SolverVariable a(boolean[] r100);
    }

    public final void i() {
        int r100 = 0;
    L4:
        if (r100 >= this.f399645k) goto L6;
        b r101 = this.f399641g[r100];
        SolverVariable r102 = r101.f399629a;
        r102.f399610e = r101.f399630b;
        r100 = r100 + 1;
        goto L4
    }

    public final void s() {
        int r100 = 0;
    L4:
        if (r100 >= this.f399645k) goto L11;
        b[] r101 = this.f399641g;
        b r102 = r101[r100];
        if (r102 == null) goto L10;
        rla.b r103 = this.f399647m.f538497a;
        int r104 = r103.f538501b;
        Object[] r105 = r103.f538500a;
        if (r104 >= r105.length) goto L10;
        r105[r104] = r102;
        r103.f538501b = r104 + 1;
    L10:
        r101[r100] = null;
        r100 = r100 + 1;
        goto L4
    }

    public final void t() {
        int r100 = 0;
    L3:
        rla.a r101 = this.f399647m;
        SolverVariable[] r102 = r101.f538499c;
        if (r100 >= r102.length) goto L9;
        SolverVariable r103 = r102[r100];
        if (r103 == null) goto L8;
        r103.c();
    L8:
        r100 = r100 + 1;
        goto L3
    L9:
        rla.b r104 = r101.f538498b;
        SolverVariable[] r105 = this.f399648n;
        int r106 = this.f399649o;
        r104.getClass();
        if (r106 <= r105.length) goto L12;
        r106 = r105.length;
    L12:
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L18;
        SolverVariable r108 = r105[r107];
        int r109 = r104.f538501b;
        Object[] r110 = r104.f538500a;
        if (r109 >= r110.length) goto L17;
        r110[r109] = r108;
        r104.f538501b = r109 + 1;
    L17:
        r107 = r107 + 1;
        goto L13
    L18:
        this.f399649o = 0;
        Arrays.fill(this.f399647m.f538499c, null);
        this.f399637c = 0;
        d r111 = this.f399638d;
        r111.f399653h = 0;
        r111.f399630b = 0.0f;
        this.f399644j = 1;
        int r112 = 0;
    L20:
        if (r112 >= this.f399645k) goto L22;
        b r113 = this.f399641g[r112];
        r112 = r112 + 1;
        goto L20
    L22:
        s();
        this.f399645k = 0;
        this.f399650p = new b(this.f399647m);
    }

    public final b l() {
        rla.a r100 = this.f399647m;
        rla.b r101 = r100.f538497a;
        int r102 = r101.f538501b;
        if (r102 <= 0) goto L5;
        int r103 = r102 - 1;
        Object[] r104 = r101.f538500a;
        Object r105 = r104[r103];
        r104[r103] = null;
        r101.f538501b = r103;
    L6:
        b r106 = (b) r105;
        if (r106 == null) goto L11;
        r106.f399629a = null;
        r106.f399632d.clear();
        r106.f399630b = 0.0f;
        r106.f399633e = false;
        return r106;
    L11:
        return new b(r100);
    L5:
        r105 = null;
        goto L6
    }

    public final SolverVariable m() {
        if ((this.f399644j + 1) < this.f399640f) goto L5;
        o();
    L5:
        SolverVariable r100 = a(SolverVariable.Type.SLACK);
        int r101 = this.f399637c + 1;
        this.f399637c = r101;
        this.f399644j++;
        r100.f399607b = r101;
        this.f399647m.f538499c[r101] = r100;
        return r100;
    }

    public final void o() {
        int r100 = this.f399639e * 2;
        this.f399639e = r100;
        this.f399641g = (b[]) Arrays.copyOf(this.f399641g, r100);
        rla.a r101 = this.f399647m;
        r101.f538499c = (SolverVariable[]) Arrays.copyOf(r101.f538499c, this.f399639e);
        int r102 = this.f399639e;
        this.f399643i = new boolean[r102];
        this.f399640f = r102;
        this.f399646l = r102;
    }

    public final void p() throws Exception {
        if (this.f399638d.e() == false) goto L7;
        i();
        return;
    L7:
        if (this.f399642h == false) goto L19;
        boolean r100 = false;
        int r101 = 0;
    L10:
        if (r101 >= this.f399645k) goto L15;
        if (this.f399641g[r101].f399633e == false) goto L16;
        r101 = r101 + 1;
    L16:
        if (r100 == true) goto L18;
        q(this.f399638d);
        return;
    L18:
        i();
        return;
    L15:
        r100 = true;
        goto L16
    L19:
        q(this.f399638d);
    }

    public c() {
        this.f399635a = 1000;
        this.f399636b = false;
        this.f399637c = 0;
        this.f399639e = 32;
        this.f399640f = 32;
        this.f399642h = false;
        this.f399643i = new boolean[32];
        this.f399644j = 1;
        this.f399645k = 0;
        this.f399646l = 32;
        this.f399648n = new SolverVariable[1000];
        this.f399649o = 0;
        this.f399641g = new b[32];
        s();
        rla.a r100 = new rla.a();
        this.f399647m = r100;
        this.f399638d = new d(r100);
        this.f399650p = new b(r100);
    }

    public static int n(ConstraintAnchor r100) {
        SolverVariable r101 = r100.f399697i;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return (int) (r101.f399610e + 0.5f);
    }

    public final SolverVariable a(SolverVariable.Type r100) {
        rla.b r101 = this.f399647m.f538498b;
        int r102 = r101.f538501b;
        Object r103 = null;
        if (r102 <= 0) goto L5;
        int r104 = r102 - 1;
        Object[] r105 = r101.f538500a;
        Object r106 = r105[r104];
        r105[r104] = null;
        r101.f538501b = r104;
        r103 = r106;
    L5:
        SolverVariable r107 = (SolverVariable) r103;
        if (r107 != null) goto L8;
        r107 = new SolverVariable(r100);
        r107.f399614i = r100;
    L9:
        int r108 = this.f399649o;
        int r109 = this.f399635a;
        if (r108 < r109) goto L12;
        int r110 = r109 * 2;
        this.f399635a = r110;
        this.f399648n = (SolverVariable[]) Arrays.copyOf(this.f399648n, r110);
    L12:
        SolverVariable[] r111 = this.f399648n;
        int r112 = this.f399649o;
        this.f399649o = r112 + 1;
        r111[r112] = r107;
        return r107;
    L8:
        r107.c();
        r107.f399614i = r100;
        goto L9
    }

    public final void c(b r110) {
        boolean r100 = true;
        if ((this.f399645k + 1) < this.f399646l) goto L5;
    L6:
        o();
    L8:
        if (r110.f399633e == false) goto L10;
        boolean r101 = false;
    L136:
        if (r101 == true) goto L163;
        h(r110);
        return;
    L163:
        return;
    L10:
        if (this.f399641g.length == 0) goto L40;
        boolean r102 = false;
    L13:
        if (r102 == true) goto L35;
        int r103 = r110.f399632d.getCurrentSize();
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L23;
        SolverVariable r105 = r110.f399632d.getVariable(r104);
        if (r105.f399608c == (-1)) goto L19;
    L21:
        r110.f399631c.add(r105);
    L22:
        r104 = r104 + 1;
        goto L15
    L19:
        if (r105.f399611f == true) goto L21;
    L23:
        int r106 = r110.f399631c.size();
        if (r106 > 0) goto L25;
        r102 = true;
        goto L13
    L25:
        int r107 = 0;
    L26:
        if (r107 >= r106) goto L32;
        SolverVariable r108 = (SolverVariable) ListProtector.get(r110.f399631c, r107);
        if (r108.f399611f == false) goto L30;
        r110.h(this, r108, true);
    L31:
        r107 = r107 + 1;
        goto L26
    L30:
        r110.i(this, this.f399641g[r108.f399608c], true);
        goto L31
    L32:
        r110.f399631c.clear();
        goto L13
    L35:
        if (r110.f399629a == null) goto L40;
        if (r110.f399632d.getCurrentSize() != 0) goto L40;
        r110.f399633e = true;
        this.f399636b = true;
    L40:
        if (r110.e() == false) goto L42;
        return;
    L42:
        float r109 = r110.f399630b;
        if (r109 >= 0.0f) goto L45;
        r110.f399630b = r109 * (-1.0f);
        r110.f399632d.invert();
    L45:
        int r111 = r110.f399632d.getCurrentSize();
        int r112 = 0;
        SolverVariable r113 = null;
        SolverVariable r114 = null;
        float r115 = 0.0f;
        boolean r116 = false;
        float r117 = 0.0f;
        boolean r118 = false;
    L46:
        if (r112 >= r111) goto L89;
        float r119 = r110.f399632d.getVariableValue(r112);
        SolverVariable r120 = r110.f399632d.getVariable(r112);
        if (r120.f399614i != SolverVariable.Type.UNRESTRICTED) goto L67;
        if (r113 != null) goto L54;
        if (r120.f399617l <= 1) goto L57;
    L58:
        r116 = false;
    L59:
        r113 = r120;
        r115 = r119;
    L88:
        r112 = r112 + 1;
    L57:
        r116 = true;
        goto L59
    L54:
        if (r115 > r119) goto L56;
        if (r116 == true) goto L88;
        if (r120.f399617l > 1) goto L64;
        boolean r121 = true;
    L65:
        if (r121 == false) goto L88;
        r113 = r120;
        r115 = r119;
        r116 = true;
        goto L88
    L64:
        r121 = false;
        goto L65
    L56:
        if (r120.f399617l > 1) goto L58;
    L67:
        if (r113 != null) goto L88;
        if (r119 >= 0.0f) goto L88;
        if (r114 != null) goto L75;
        if (r120.f399617l <= 1) goto L78;
    L79:
        r118 = false;
    L80:
        r114 = r120;
        r117 = r119;
    L78:
        r118 = true;
        goto L80
    L75:
        if (r117 > r119) goto L77;
        if (r118 == true) goto L88;
        if (r120.f399617l > 1) goto L85;
        boolean r122 = true;
    L86:
        if (r122 == false) goto L88;
        r114 = r120;
        r117 = r119;
        r118 = true;
        goto L88
    L85:
        r122 = false;
        goto L86
    L77:
        if (r120.f399617l > 1) goto L79;
    L89:
        if (r113 != null) goto L92;
        r113 = r114;
    L92:
        if (r113 != null) goto L94;
        boolean r123 = true;
    L96:
        if (r110.f399632d.getCurrentSize() != 0) goto L98;
        r110.f399633e = true;
    L98:
        if (r123 == true) goto L100;
    L123:
        boolean r124 = false;
    L124:
        SolverVariable r125 = r110.f399629a;
        if (r125 != null) goto L127;
    L131:
        r100 = false;
    L132:
        if (r100 == true) goto L134;
        return;
    L134:
        r101 = r124;
        goto L136
    L127:
        if (r125.f399614i == SolverVariable.Type.UNRESTRICTED) goto L132;
        if (r110.f399630b < 0.0f) goto L131;
    L100:
        if ((this.f399644j + 1) < this.f399640f) goto L102;
        o();
    L102:
        SolverVariable r126 = a(SolverVariable.Type.SLACK);
        int r127 = this.f399637c + 1;
        this.f399637c = r127;
        this.f399644j++;
        r126.f399607b = r127;
        this.f399647m.f538499c[r127] = r126;
        r110.f399629a = r126;
        int r128 = this.f399645k;
        h(r110);
        if (this.f399645k != (r128 + 1)) goto L123;
        b r129 = this.f399650p;
        r129.getClass();
        r129.f399629a = null;
        r129.f399632d.clear();
        int r130 = 0;
    L106:
        if (r130 >= r110.f399632d.getCurrentSize()) goto L108;
        r129.f399632d.c(r110.f399632d.getVariable(r130), r110.f399632d.getVariableValue(r130), true);
        r130 = r130 + 1;
        goto L106
    L108:
        r(this.f399650p);
        if (r126.f399608c == (-1)) goto L111;
    L122:
        r124 = true;
        goto L124
    L111:
        if (r110.f399629a != r126) goto L116;
        SolverVariable r131 = r110.f(null, r126);
        if (r131 == null) goto L116;
        r110.g(r131);
    L116:
        if (r110.f399633e == true) goto L118;
        r110.f399629a.e(this, r110);
    L118:
        rla.b r132 = this.f399647m.f538497a;
        int r133 = r132.f538501b;
        Object[] r134 = r132.f538500a;
        if (r133 >= r134.length) goto L121;
        r134[r133] = r110;
        r132.f538501b = r133 + 1;
    L121:
        this.f399645k--;
        goto L122
    L94:
        r110.g(r113);
        r123 = false;
        goto L96
    L5:
        if ((this.f399644j + 1) < this.f399640f) goto L8;
        goto L6
    }

    public final void h(b r100) {
        if (r100.f399633e == false) goto L5;
        r100.f399629a.d(this, r100.f399630b);
    L7:
        if (this.f399636b == false) goto L41;
        int r101 = 0;
    L10:
        if (r101 >= this.f399645k) goto L32;
        if (this.f399641g[r101] != null) goto L14;
        System.out.println("WTF");
    L14:
        b r102 = this.f399641g[r101];
        if (r102 == null) goto L31;
        if (r102.f399633e == false) goto L31;
        r102.f399629a.d(this, r102.f399630b);
        rla.b r103 = this.f399647m.f538497a;
        int r104 = r103.f538501b;
        Object[] r105 = r103.f538500a;
        if (r104 >= r105.length) goto L21;
        r105[r104] = r102;
        r103.f538501b = r104 + 1;
    L21:
        this.f399641g[r101] = null;
        int r106 = r101 + 1;
        int r107 = r106;
    L22:
        int r108 = this.f399645k;
        if (r106 >= r108) goto L28;
        b[] r109 = this.f399641g;
        int r110 = r106 - 1;
        b r111 = r109[r106];
        r109[r110] = r111;
        SolverVariable r112 = r111.f399629a;
        if (r112.f399608c != r106) goto L27;
        r112.f399608c = r110;
    L27:
        r107 = r106;
        r106 = r106 + 1;
        goto L22
    L28:
        if (r107 >= r108) goto L30;
        this.f399641g[r107] = null;
    L30:
        this.f399645k = r108 - 1;
        r101 = r101 - 1;
    L31:
        r101 = r101 + 1;
        goto L10
    L32:
        this.f399636b = false;
        return;
    L41:
        return;
    L5:
        b[] r113 = this.f399641g;
        int r114 = this.f399645k;
        r113[r114] = r100;
        SolverVariable r115 = r100.f399629a;
        r115.f399608c = r114;
        this.f399645k = r114 + 1;
        r115.e(this, r100);
        goto L7
    }

    public final SolverVariable j(int r100) {
        if ((this.f399644j + 1) < this.f399640f) goto L5;
        o();
    L5:
        SolverVariable r101 = a(SolverVariable.Type.ERROR);
        int r102 = this.f399637c + 1;
        this.f399637c = r102;
        this.f399644j++;
        r101.f399607b = r102;
        r101.f399609d = r100;
        this.f399647m.f538499c[r102] = r101;
        d r103 = this.f399638d;
        r103.f399654i.f399655a = r101;
        Arrays.fill(r101.f399613h, 0.0f);
        r101.f399613h[r101.f399609d] = 1.0f;
        r103.j(r101);
        return r101;
    }

    public final SolverVariable k(Object r100) {
        SolverVariable r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((this.f399644j + 1) < this.f399640f) goto L9;
        o();
    L9:
        if ((r100 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r102 = (ConstraintAnchor) r100;
        r101 = r102.f399697i;
        if (r101 != null) goto L13;
        r102.k();
        r101 = r102.f399697i;
    L13:
        int r103 = r101.f399607b;
        if (r103 != (-1)) goto L16;
    L19:
        if (r103 == (-1)) goto L21;
        r101.c();
    L21:
        int r104 = this.f399637c + 1;
        this.f399637c = r104;
        this.f399644j++;
        r101.f399607b = r104;
        r101.f399614i = SolverVariable.Type.UNRESTRICTED;
        this.f399647m.f538499c[r104] = r101;
        goto L22
    L16:
        if (r103 > this.f399637c) goto L19;
        if (this.f399647m.f538499c[r103] == null) goto L19;
    L22:
        return r101;
    }

    public final void q(d r110) throws Exception {
        int r100 = 0;
    L3:
        float r101 = 0.0f;
        int r102 = 1;
        if (r100 >= this.f399645k) goto L12;
        b r103 = this.f399641g[r100];
        if (r103.f399629a.f399614i == SolverVariable.Type.UNRESTRICTED) goto L11;
        if (r103.f399630b >= 0.0f) goto L11;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L50;
        boolean r105 = false;
        int r106 = 0;
    L15:
        if (r105 == true) goto L50;
        r106 = r106 + r102;
        float r107 = Float.MAX_VALUE;
        int r108 = 0;
        int r109 = -1;
        int r111 = -1;
        int r112 = 0;
    L18:
        if (r108 >= this.f399645k) goto L43;
        b r113 = this.f399641g[r108];
        if (r113.f399629a.f399614i == SolverVariable.Type.UNRESTRICTED) goto L42;
        if (r113.f399633e == true) goto L42;
        if (r113.f399630b >= r101) goto L42;
        int r114 = r113.f399632d.getCurrentSize();
        int r115 = 0;
    L28:
        if (r115 >= r114) goto L42;
        SolverVariable r116 = r113.f399632d.getVariable(r115);
        float r117 = r113.f399632d.a(r116);
        if (r117 <= r101) goto L41;
        int r118 = 0;
    L34:
        if (r118 >= 9) goto L41;
        float r119 = r116.f399612g[r118] / r117;
        if (r119 >= r107) goto L38;
        if (r118 != r112) goto L38;
    L39:
        r111 = r116.f399607b;
        r112 = r118;
        r107 = r119;
        r109 = r108;
    L40:
        r118 = r118 + 1;
    L38:
        if (r118 <= r112) goto L40;
    L41:
        r115 = r115 + 1;
        r101 = 0.0f;
    L42:
        r108 = r108 + 1;
        r101 = 0.0f;
        goto L18
    L43:
        if (r109 == (-1)) goto L45;
        b r120 = this.f399641g[r109];
        r120.f399629a.f399608c = -1;
        r120.g(this.f399647m.f538499c[r111]);
        SolverVariable r121 = r120.f399629a;
        r121.f399608c = r109;
        r121.e(this, r120);
    L47:
        if (r106 <= (this.f399644j / 2)) goto L49;
        r105 = true;
    L49:
        r101 = 0.0f;
        r102 = 1;
        goto L15
    L45:
        r105 = true;
    L50:
        r(r110);
        i();
        return;
    L11:
        r100 = r100 + 1;
        goto L3
    L12:
        r104 = false;
        goto L13
    }

    public final void r(b r110) {
        int r100 = 0;
    L4:
        if (r100 >= this.f399644j) goto L6;
        this.f399643i[r100] = false;
        r100 = r100 + 1;
        goto L4
    L6:
        boolean r101 = false;
        int r102 = 0;
    L7:
        if (r101 == true) goto L41;
        r102 = r102 + 1;
        if (r102 >= (this.f399644j * 2)) goto L10;
        SolverVariable r103 = r110.f399629a;
        if (r103 == null) goto L14;
        this.f399643i[r103.f399607b] = true;
    L14:
        SolverVariable r104 = r110.a(this.f399643i);
        if (r104 == null) goto L20;
        boolean[] r105 = this.f399643i;
        int r106 = r104.f399607b;
        if (r105[r106] == true) goto L18;
        r105[r106] = true;
        goto L20
    L18:
        return;
    L20:
        if (r104 != null) goto L21;
        r101 = true;
        goto L7
    L21:
        float r107 = Float.MAX_VALUE;
        int r108 = 0;
        int r109 = -1;
    L23:
        if (r108 >= this.f399645k) goto L38;
        b r111 = this.f399641g[r108];
        if (r111.f399629a.f399614i == SolverVariable.Type.UNRESTRICTED) goto L37;
        if (r111.f399633e == true) goto L37;
        if (r111.f399632d.f(r104) == false) goto L37;
        float r112 = r111.f399632d.a(r104);
        if (r112 >= 0.0f) goto L37;
        float r113 = (-r111.f399630b) / r112;
        if (r113 >= r107) goto L37;
        r109 = r108;
        r107 = r113;
    L37:
        r108 = r108 + 1;
        goto L23
    L38:
        if (r109 <= (-1)) goto L7;
        b r114 = this.f399641g[r109];
        r114.f399629a.f399608c = -1;
        r114.g(r104);
        SolverVariable r115 = r114.f399629a;
        r115.f399608c = r109;
        r115.e(this, r114);
        goto L7
    L10:
        return;
    }

    public final void d(SolverVariable r100, int r101) {
        int r102 = r100.f399608c;
        if (r102 != (-1)) goto L9;
        r100.d(this, r101);
        int r103 = 0;
    L6:
        if (r103 >= (this.f399637c + 1)) goto L8;
        SolverVariable r104 = this.f399647m.f538499c[r103];
        r103 = r103 + 1;
        goto L6
    L8:
        return;
    L9:
        if (r102 == (-1)) goto L21;
        b r105 = this.f399641g[r102];
        if (r105.f399633e == false) goto L14;
        r105.f399630b = r101;
        return;
    L14:
        if (r105.f399632d.getCurrentSize() != 0) goto L16;
        r105.f399633e = true;
        r105.f399630b = r101;
        return;
    L16:
        b r106 = l();
        if (r101 >= 0) goto L19;
        r106.f399630b = r101 * (-1);
        r106.f399632d.e(r100, 1.0f);
    L20:
        c(r106);
        return;
    L19:
        r106.f399630b = r101;
        r106.f399632d.e(r100, -1.0f);
        goto L20
    L21:
        b r107 = l();
        r107.f399629a = r100;
        float r108 = r101;
        r100.f399610e = r108;
        r107.f399630b = r108;
        r107.f399633e = true;
        c(r107);
    }

    public final void e(SolverVariable r100, SolverVariable r101, int r102, int r103) {
        if (r103 == 8) goto L5;
    L10:
        b r104 = l();
        boolean r105 = false;
        if (r102 == 0) goto L16;
        if (r102 >= 0) goto L14;
        r102 = r102 * (-1);
        r105 = true;
    L14:
        r104.f399630b = r102;
    L16:
        if (r105 == true) goto L18;
        r104.f399632d.e(r100, -1.0f);
        r104.f399632d.e(r101, 1.0f);
    L19:
        if (r103 == 8) goto L21;
        r104.b(this, r103);
    L21:
        c(r104);
        return;
    L18:
        r104.f399632d.e(r100, 1.0f);
        r104.f399632d.e(r101, -1.0f);
        goto L19
    L5:
        if (r101.f399611f == false) goto L10;
        if (r100.f399608c != (-1)) goto L10;
        r100.d(this, r101.f399610e + r102);
    }

    public final void f(SolverVariable r100, SolverVariable r101, int r102, int r103) {
        b r104 = l();
        SolverVariable r105 = m();
        r105.f399609d = 0;
        r104.c(r100, r101, r105, r102);
        if (r103 == 8) goto L5;
        int r106 = (int) (r104.f399632d.a(r105) * (-1.0f));
        r104.f399632d.e(j(r103), r106);
    L5:
        c(r104);
    }

    public final void g(SolverVariable r100, SolverVariable r101, int r102, int r103) {
        b r104 = l();
        SolverVariable r105 = m();
        r105.f399609d = 0;
        r104.d(r100, r101, r105, r102);
        if (r103 == 8) goto L5;
        int r106 = (int) (r104.f399632d.a(r105) * (-1.0f));
        r104.f399632d.e(j(r103), r106);
    L5:
        c(r104);
    }

    public final void b(SolverVariable r100, SolverVariable r101, int r102, float r110, SolverVariable r111, SolverVariable r112, int r113, int r114) {
        b r103 = l();
        if (r101 != r111) goto L6;
        r103.f399632d.e(r100, 1.0f);
        r103.f399632d.e(r112, 1.0f);
        r103.f399632d.e(r101, -2.0f);
    L22:
        if (r114 == 8) goto L24;
        r103.b(this, r114);
    L24:
        c(r103);
        return;
    L6:
        if (r110 != 0.5f) goto L12;
        r103.f399632d.e(r100, 1.0f);
        r103.f399632d.e(r101, -1.0f);
        r103.f399632d.e(r111, -1.0f);
        r103.f399632d.e(r112, 1.0f);
        if (r102 > 0) goto L10;
        if (r113 <= 0) goto L22;
    L10:
        r103.f399630b = (-r102) + r113;
        goto L22
    L12:
        if (r110 > 0.0f) goto L15;
        r103.f399632d.e(r100, -1.0f);
        r103.f399632d.e(r101, 1.0f);
        r103.f399630b = r102;
        goto L22
    L15:
        if (r110 < 1.0f) goto L17;
        r103.f399632d.e(r112, -1.0f);
        r103.f399632d.e(r111, 1.0f);
        r103.f399630b = -r113;
        goto L22
    L17:
        float r104 = 1.0f - r110;
        r103.f399632d.e(r100, r104 * 1.0f);
        r103.f399632d.e(r101, r104 * (-1.0f));
        r103.f399632d.e(r111, (-1.0f) * r110);
        r103.f399632d.e(r112, 1.0f * r110);
        if (r102 > 0) goto L20;
        if (r113 <= 0) goto L22;
    L20:
        r103.f399630b = ((-r102) * r104) + (r113 * r110);
        goto L22
    }
}
