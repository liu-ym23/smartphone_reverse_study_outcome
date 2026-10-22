package com.obric.oui.constraintlayout.core;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends com.obric.oui.constraintlayout.core.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SolverVariable[] f399651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SolverVariable[] f399652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f399654i;

    public class a implements Comparator<SolverVariable> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(SolverVariable r100, SolverVariable r101) {
            return r100.f399607b - r101.f399607b;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SolverVariable f399655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f399656b;

        public final String toString() {
            String r100 = "[ ";
            if (this.f399655a == null) goto L9;
            int r101 = 0;
        L6:
            if (r101 >= 9) goto L9;
            r100 = r100 + this.f399655a.f399613h[r101] + " ";
            r101 = r101 + 1;
        L9:
            return r100 + "] " + this.f399655a;
        }

        public b(d r100) {
            this.f399656b = r100;
        }
    }

    @Override // com.obric.oui.constraintlayout.core.b
    public final boolean e() {
        if (this.f399653h != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.b
    public final String toString() {
        String r100 = " goal -> (" + this.f399630b + ") : ";
        int r101 = 0;
    L4:
        if (r101 >= this.f399653h) goto L6;
        this.f399654i.f399655a = this.f399651f[r101];
        r100 = r100 + this.f399654i + " ";
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public d(rla.a r100) {
        super(r100);
        this.f399651f = new SolverVariable[128];
        this.f399652g = new SolverVariable[128];
        this.f399653h = 0;
        this.f399654i = new b(this);
    }

    @Override // com.obric.oui.constraintlayout.core.b, com.obric.oui.constraintlayout.core.c.a
    public final SolverVariable a(boolean[] r110) {
        int r100 = 0;
        int r101 = -1;
    L4:
        if (r100 >= this.f399653h) goto L33;
        SolverVariable[] r102 = this.f399651f;
        SolverVariable r103 = r102[r100];
        if (r110[r103.f399607b] == true) goto L32;
        b r104 = this.f399654i;
        r104.f399655a = r103;
        boolean r105 = true;
        int r106 = 8;
        if (r101 != (-1)) goto L21;
    L10:
        if (r106 < 0) goto L18;
        float r107 = r104.f399655a.f399613h[r106];
        if (r107 > 0.0f) goto L18;
        if (r107 < 0.0f) goto L19;
        r106 = r106 - 1;
    L19:
        if (r105 == false) goto L32;
    L31:
        r101 = r100;
    L18:
        r105 = false;
        goto L19
    L21:
        SolverVariable r108 = r102[r101];
    L22:
        if (r106 < 0) goto L29;
        float r109 = r108.f399613h[r106];
        float r111 = r104.f399655a.f399613h[r106];
        if (r111 != r109) goto L27;
        r106 = r106 - 1;
        goto L22
    L27:
        if (r111 >= r109) goto L29;
    L30:
        if (r105 == false) goto L32;
    L29:
        r105 = false;
    L32:
        r100 = r100 + 1;
        goto L4
    L33:
        if (r101 != (-1)) goto L37;
        return null;
    L37:
        return this.f399651f[r101];
    }

    public final void j(SolverVariable r100) {
        int r101 = this.f399653h + 1;
        SolverVariable[] r102 = this.f399651f;
        if (r101 <= r102.length) goto L5;
        SolverVariable[] r103 = (SolverVariable[]) Arrays.copyOf(r102, r102.length * 2);
        this.f399651f = r103;
        this.f399652g = (SolverVariable[]) Arrays.copyOf(r103, r103.length * 2);
    L5:
        SolverVariable[] r104 = this.f399651f;
        int r105 = this.f399653h;
        r104[r105] = r100;
        int r106 = r105 + 1;
        this.f399653h = r106;
        if (r106 > 1) goto L8;
    L17:
        r100.f399606a = true;
        r100.a(this);
        return;
    L8:
        if (r104[r106 - 1].f399607b <= r100.f399607b) goto L17;
        int r107 = 0;
        int r108 = 0;
    L10:
        int r109 = this.f399653h;
        if (r108 >= r109) goto L13;
        this.f399652g[r108] = this.f399651f[r108];
        r108 = r108 + 1;
        goto L10
    L13:
        Arrays.sort(this.f399652g, 0, r109, new a());
    L15:
        if (r107 >= this.f399653h) goto L17;
        this.f399651f[r107] = this.f399652g[r107];
        r107 = r107 + 1;
        goto L15
    }

    public final void k(SolverVariable r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f399653h) goto L13;
        if (this.f399651f[r101] == r100) goto L7;
        r101 = r101 + 1;
    L7:
        int r102 = this.f399653h;
        if (r101 >= (r102 - 1)) goto L10;
        SolverVariable[] r103 = this.f399651f;
        int r104 = r101 + 1;
        r103[r101] = r103[r104];
        r101 = r104;
        goto L7
    L10:
        this.f399653h = r102 - 1;
        r100.f399606a = false;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.b
    public final void i(c r110, com.obric.oui.constraintlayout.core.b r111, boolean r210) {
        SolverVariable r100 = r111.f399629a;
        if (r100 != null) goto L5;
        return;
    L5:
        com.obric.oui.constraintlayout.core.b.a r101 = r111.f399632d;
        int r102 = r101.getCurrentSize();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L32;
        SolverVariable r104 = r101.getVariable(r103);
        float r105 = r101.getVariableValue(r103);
        b r106 = this.f399654i;
        r106.f399655a = r104;
        boolean r112 = true;
        if (r104.f399606a == false) goto L19;
        int r113 = 0;
    L10:
        if (r113 >= 9) goto L16;
        float[] r114 = r106.f399655a.f399613h;
        float r115 = r114[r113] + (r100.f399613h[r113] * r105);
        r114[r113] = r115;
        if (Math.abs(r115) >= 1.0E-4f) goto L14;
        r106.f399655a.f399613h[r113] = 0.0f;
    L15:
        r113 = r113 + 1;
        goto L10
    L14:
        r112 = false;
        goto L15
    L16:
        if (r112 == false) goto L18;
        r106.f399656b.k(r106.f399655a);
    L18:
        r112 = false;
    L29:
        if (r112 == false) goto L31;
        j(r104);
    L31:
        this.f399630b += r111.f399630b * r105;
        r103 = r103 + 1;
        goto L6
    L19:
        int r107 = 0;
    L20:
        if (r107 >= 9) goto L29;
        float r116 = r100.f399613h[r107];
        if (r116 == 0.0f) goto L27;
        float r117 = r116 * r105;
        if (Math.abs(r117) >= 1.0E-4f) goto L26;
        r117 = 0.0f;
    L26:
        r106.f399655a.f399613h[r107] = r117;
    L28:
        r107 = r107 + 1;
        goto L20
    L27:
        r106.f399655a.f399613h[r107] = 0.0f;
        goto L28
    L32:
        k(r100);
    }
}
