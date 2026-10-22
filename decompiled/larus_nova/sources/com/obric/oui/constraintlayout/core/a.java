package com.obric.oui.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f399619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f399620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rla.a f399621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f399622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f399623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f399624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f399625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f399627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f399628j;

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final void clear() {
        int r100 = this.f399626h;
        int r101 = 0;
    L4:
        if (r100 == (-1)) goto L11;
        if (r101 >= this.f399619a) goto L11;
        SolverVariable r102 = this.f399621c.f538499c[this.f399623e[r100]];
        if (r102 == null) goto L10;
        r102.b(this.f399620b);
    L10:
        r100 = this.f399624f[r100];
        r101 = r101 + 1;
    L11:
        this.f399626h = -1;
        this.f399627i = -1;
        this.f399628j = false;
        this.f399619a = 0;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final void invert() {
        int r100 = this.f399626h;
        int r101 = 0;
    L4:
        if (r100 == (-1)) goto L8;
        if (r101 >= this.f399619a) goto L11;
        float[] r102 = this.f399625g;
        r102[r100] = r102[r100] * (-1.0f);
        r100 = this.f399624f[r100];
        r101 = r101 + 1;
        goto L4
    L11:
        return;
    }

    public final String toString() {
        int r100 = this.f399626h;
        String r101 = "";
        int r102 = 0;
    L4:
        if (r100 == (-1)) goto L8;
        if (r102 >= this.f399619a) goto L8;
        r101 = ((r101 + " -> ") + this.f399625g[r100] + " : ") + this.f399621c.f538499c[this.f399623e[r100]];
        r100 = this.f399624f[r100];
        r102 = r102 + 1;
    L8:
        return r101;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final int getCurrentSize() {
        return this.f399619a;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final float a(SolverVariable r100) {
        int r101 = this.f399626h;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L12;
        if (r102 >= this.f399619a) goto L17;
        if (this.f399623e[r101] == r100.f399607b) goto L10;
        r101 = this.f399624f[r101];
        r102 = r102 + 1;
        goto L4
    L10:
        return this.f399625g[r101];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final void divideByAmount(float r100) {
        int r101 = this.f399626h;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L8;
        if (r102 >= this.f399619a) goto L11;
        float[] r103 = this.f399625g;
        r103[r101] = r103[r101] / r100;
        r101 = this.f399624f[r101];
        r102 = r102 + 1;
        goto L4
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final boolean f(SolverVariable r100) {
        int r101 = this.f399626h;
        if (r101 != (-1)) goto L5;
        return false;
    L5:
        int r102 = 0;
    L6:
        if (r101 == (-1)) goto L14;
        if (r102 >= this.f399619a) goto L14;
        if (this.f399623e[r101] == r100.f399607b) goto L11;
        r101 = this.f399624f[r101];
        r102 = r102 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final SolverVariable getVariable(int r100) {
        int r101 = this.f399626h;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L11;
        if (r102 >= this.f399619a) goto L16;
        if (r102 == r100) goto L9;
        r101 = this.f399624f[r101];
        r102 = r102 + 1;
        goto L4
    L9:
        return this.f399621c.f538499c[this.f399623e[r101]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final float getVariableValue(int r100) {
        int r101 = this.f399626h;
        int r102 = 0;
    L4:
        if (r101 == (-1)) goto L11;
        if (r102 >= this.f399619a) goto L16;
        if (r102 == r100) goto L9;
        r101 = this.f399624f[r101];
        r102 = r102 + 1;
        goto L4
    L9:
        return this.f399625g[r101];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    public a(b r100, rla.a r101) {
        this.f399619a = 0;
        this.f399622d = 8;
        this.f399623e = new int[8];
        this.f399624f = new int[8];
        this.f399625g = new float[8];
        this.f399626h = -1;
        this.f399627i = -1;
        this.f399628j = false;
        this.f399620b = r100;
        this.f399621c = r101;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final float b(SolverVariable r100, boolean r110) {
        int r101 = this.f399626h;
        if (r101 != (-1)) goto L5;
        return 0.0f;
    L5:
        int r102 = 0;
        int r103 = -1;
    L6:
        if (r101 == (-1)) goto L23;
        if (r102 >= this.f399619a) goto L23;
        if (this.f399623e[r101] == r100.f399607b) goto L12;
        r102 = r102 + 1;
        r103 = r101;
        r101 = this.f399624f[r101];
        goto L6
    L12:
        if (r101 != this.f399626h) goto L14;
        this.f399626h = this.f399624f[r101];
    L15:
        if (r110 == false) goto L17;
        r100.b(this.f399620b);
    L17:
        r100.f399617l--;
        this.f399619a--;
        this.f399623e[r101] = -1;
        if (this.f399628j == false) goto L21;
        this.f399627i = r101;
    L21:
        return this.f399625g[r101];
    L14:
        int[] r104 = this.f399624f;
        r104[r103] = r104[r101];
    L23:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final float d(b r100, boolean r101) {
        float r102 = a(r100.f399629a);
        b(r100.f399629a, r101);
        b.a r103 = r100.f399632d;
        int r104 = r103.getCurrentSize();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        SolverVariable r106 = r103.getVariable(r105);
        c(r106, r103.a(r106) * r102, r101);
        r105 = r105 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final void e(SolverVariable r100, float r110) {
        if (r110 != 0.0f) goto L6;
        b(r100, true);
        return;
    L6:
        int r101 = this.f399626h;
        if (r101 != (-1)) goto L14;
        this.f399626h = 0;
        this.f399625g[0] = r110;
        this.f399623e[0] = r100.f399607b;
        this.f399624f[0] = -1;
        r100.f399617l++;
        r100.a(this.f399620b);
        this.f399619a++;
        if (this.f399628j == true) goto L67;
        int r102 = this.f399627i + 1;
        this.f399627i = r102;
        int[] r111 = this.f399623e;
        if (r102 < r111.length) goto L68;
        this.f399628j = true;
        this.f399627i = r111.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r103 = 0;
        int r104 = -1;
    L15:
        if (r101 == (-1)) goto L25;
        if (r103 >= this.f399619a) goto L25;
        int r105 = this.f399623e[r101];
        int r106 = r100.f399607b;
        if (r105 == r106) goto L20;
        if (r105 >= r106) goto L24;
        r104 = r101;
    L24:
        r101 = this.f399624f[r101];
        r103 = r103 + 1;
        goto L15
    L20:
        this.f399625g[r101] = r110;
        return;
    L25:
        int r107 = this.f399627i;
        int r108 = r107 + 1;
        if (this.f399628j == false) goto L31;
        int[] r109 = this.f399623e;
        if (r109[r107] == (-1)) goto L32;
        r107 = r109.length;
    L32:
        int[] r112 = this.f399623e;
        if (r107 >= r112.length) goto L35;
    L43:
        int[] r113 = this.f399623e;
        if (r107 < r113.length) goto L46;
        r107 = r113.length;
        int r114 = this.f399622d * 2;
        this.f399622d = r114;
        this.f399628j = false;
        this.f399627i = r107 - 1;
        this.f399625g = Arrays.copyOf(this.f399625g, r114);
        this.f399623e = Arrays.copyOf(this.f399623e, this.f399622d);
        this.f399624f = Arrays.copyOf(this.f399624f, this.f399622d);
    L46:
        this.f399623e[r107] = r100.f399607b;
        this.f399625g[r107] = r110;
        if (r104 == (-1)) goto L49;
        int[] r115 = this.f399624f;
        r115[r107] = r115[r104];
        r115[r104] = r107;
    L50:
        r100.f399617l++;
        r100.a(this.f399620b);
        int r116 = this.f399619a + 1;
        this.f399619a = r116;
        if (this.f399628j == true) goto L53;
        this.f399627i++;
    L53:
        int[] r117 = this.f399623e;
        if (r116 < r117.length) goto L57;
        this.f399628j = true;
    L57:
        if (this.f399627i < r117.length) goto L69;
        this.f399628j = true;
        this.f399627i = r117.length - 1;
        return;
    L69:
        return;
    L49:
        this.f399624f[r107] = this.f399626h;
        this.f399626h = r107;
        goto L50
    L35:
        if (this.f399619a >= r112.length) goto L43;
        int r118 = 0;
    L37:
        int[] r119 = this.f399623e;
        if (r118 >= r119.length) goto L43;
        if (r119[r118] == (-1)) goto L41;
        r118 = r118 + 1;
        goto L37
    L41:
        r107 = r118;
        goto L43
    L31:
        r107 = r108;
        goto L32
    }

    @Override // com.obric.oui.constraintlayout.core.b.a
    public final void c(SolverVariable r110, float r111, boolean r112) {
        if (r111 > (-0.001f)) goto L5;
    L7:
        int r100 = this.f399626h;
        if (r100 != (-1)) goto L15;
        this.f399626h = 0;
        this.f399625g[0] = r111;
        this.f399623e[0] = r110.f399607b;
        this.f399624f[0] = -1;
        r110.f399617l++;
        r110.a(this.f399620b);
        this.f399619a++;
        if (this.f399628j == true) goto L81;
        int r113 = this.f399627i + 1;
        this.f399627i = r113;
        int[] r114 = this.f399623e;
        if (r113 < r114.length) goto L82;
        this.f399628j = true;
        this.f399627i = r114.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r101 = 0;
        int r102 = -1;
    L16:
        if (r100 == (-1)) goto L42;
        if (r101 >= this.f399619a) goto L42;
        int r103 = this.f399623e[r100];
        int r104 = r110.f399607b;
        if (r103 == r104) goto L21;
        if (r103 >= r104) goto L41;
        r102 = r100;
    L41:
        r100 = this.f399624f[r100];
        r101 = r101 + 1;
        goto L16
    L21:
        float[] r105 = this.f399625g;
        float r106 = r105[r100] + r111;
        if (r106 > (-0.001f)) goto L24;
    L26:
        r105[r100] = r106;
        if (r106 == 0.0f) goto L29;
        return;
    L29:
        if (r100 != this.f399626h) goto L31;
        this.f399626h = this.f399624f[r100];
    L32:
        if (r112 == false) goto L35;
        r110.b(this.f399620b);
    L35:
        if (this.f399628j == false) goto L37;
        this.f399627i = r100;
    L37:
        r110.f399617l--;
        this.f399619a--;
        return;
    L31:
        int[] r115 = this.f399624f;
        r115[r102] = r115[r100];
        goto L32
    L24:
        if (r106 >= 0.001f) goto L26;
        r106 = 0.0f;
    L42:
        int r116 = this.f399627i;
        int r107 = r116 + 1;
        if (this.f399628j == false) goto L48;
        int[] r108 = this.f399623e;
        if (r108[r116] == (-1)) goto L49;
        r116 = r108.length;
    L49:
        int[] r109 = this.f399623e;
        if (r116 >= r109.length) goto L52;
    L60:
        int[] r117 = this.f399623e;
        if (r116 < r117.length) goto L63;
        r116 = r117.length;
        int r118 = this.f399622d * 2;
        this.f399622d = r118;
        this.f399628j = false;
        this.f399627i = r116 - 1;
        this.f399625g = Arrays.copyOf(this.f399625g, r118);
        this.f399623e = Arrays.copyOf(this.f399623e, this.f399622d);
        this.f399624f = Arrays.copyOf(this.f399624f, this.f399622d);
    L63:
        this.f399623e[r116] = r110.f399607b;
        this.f399625g[r116] = r111;
        if (r102 == (-1)) goto L66;
        int[] r119 = this.f399624f;
        r119[r116] = r119[r102];
        r119[r102] = r116;
    L67:
        r110.f399617l++;
        r110.a(this.f399620b);
        this.f399619a++;
        if (this.f399628j == true) goto L70;
        this.f399627i++;
    L70:
        int r120 = this.f399627i;
        int[] r121 = this.f399623e;
        if (r120 < r121.length) goto L84;
        this.f399628j = true;
        this.f399627i = r121.length - 1;
        return;
    L84:
        return;
    L66:
        this.f399624f[r116] = this.f399626h;
        this.f399626h = r116;
        goto L67
    L52:
        if (this.f399619a >= r109.length) goto L60;
        int r122 = 0;
    L54:
        int[] r123 = this.f399623e;
        if (r122 >= r123.length) goto L60;
        if (r123[r122] == (-1)) goto L58;
        r122 = r122 + 1;
        goto L54
    L58:
        r116 = r122;
        goto L60
    L48:
        r116 = r107;
        goto L49
    L5:
        if (r111 >= 0.001f) goto L7;
    }
}
