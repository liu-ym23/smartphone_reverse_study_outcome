package com.obric.oui.constraintlayout.core;

import androidx.camera.core.processing.util.GLUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class b implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SolverVariable f399629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f399630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<SolverVariable> f399631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f399632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f399633e;

    public interface a {
        float a(SolverVariable r100);

        float b(SolverVariable r100, boolean r101);

        void c(SolverVariable r100, float r101, boolean r102);

        void clear();

        float d(b r100, boolean r101);

        void divideByAmount(float r100);

        void e(SolverVariable r100, float r101);

        boolean f(SolverVariable r100);

        int getCurrentSize();

        SolverVariable getVariable(int r100);

        float getVariableValue(int r100);

        void invert();
    }

    public boolean e() {
        if (this.f399629a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f399630b != 0.0f) goto L9;
        if (this.f399632d.getCurrentSize() != 0) goto L9;
        return true;
    }

    public String toString() {
        if (this.f399629a != null) goto L5;
        String r100 = "0";
    L6:
        String r101 = r100 + " = ";
        int r102 = 0;
        if (this.f399630b == 0.0f) goto L9;
        r101 = r101 + this.f399630b;
        boolean r103 = true;
    L10:
        int r104 = this.f399632d.getCurrentSize();
    L11:
        if (r102 >= r104) goto L33;
        SolverVariable r105 = this.f399632d.getVariable(r102);
        if (r105 == null) goto L32;
        float r106 = this.f399632d.getVariableValue(r102);
        if (r106 == 0.0f) goto L32;
        String r107 = r105.toString();
        if (r103 == false) goto L21;
        if (r106 <= 0.0f) goto L25;
        r101 = r101 + " + ";
    L28:
        if (r106 != 1.0f) goto L30;
        r101 = r101 + r107;
    L31:
        r103 = true;
        goto L32
    L30:
        r101 = r101 + r106 + " " + r107;
        goto L31
    L25:
        r101 = r101 + " - ";
    L26:
        r106 = r106 * (-1.0f);
        goto L28
    L21:
        if (r106 >= 0.0f) goto L28;
        r101 = r101 + "- ";
    L32:
        r102 = r102 + 1;
        goto L11
    L33:
        if (r103 == false) goto L35;
        return r101;
    L35:
        return r101 + GLUtils.VERSION_UNKNOWN;
    L9:
        r103 = false;
        goto L10
    L5:
        r100 = "" + this.f399629a;
        goto L6
    }

    public b() {
        this.f399629a = null;
        this.f399630b = 0.0f;
        this.f399631c = new ArrayList();
        this.f399633e = false;
    }

    public b(rla.a r100) {
        this.f399629a = null;
        this.f399630b = 0.0f;
        this.f399631c = new ArrayList();
        this.f399633e = false;
        this.f399632d = new com.obric.oui.constraintlayout.core.a(this, r100);
    }

    @Override // com.obric.oui.constraintlayout.core.c.a
    public SolverVariable a(boolean[] r100) {
        return f(r100, null);
    }

    public final void g(SolverVariable r100) {
        SolverVariable r101 = this.f399629a;
        if (r101 == null) goto L5;
        this.f399632d.e(r101, -1.0f);
        this.f399629a.f399608c = -1;
        this.f399629a = null;
    L5:
        float r102 = this.f399632d.b(r100, true) * (-1.0f);
        this.f399629a = r100;
        if (r102 != 1.0f) goto L8;
        return;
    L8:
        this.f399630b /= r102;
        this.f399632d.divideByAmount(r102);
    }

    public final void b(c r100, int r101) {
        this.f399632d.e(r100.j(r101), 1.0f);
        this.f399632d.e(r100.j(r101), -1.0f);
    }

    public final SolverVariable f(boolean[] r110, SolverVariable r111) {
        int r100 = this.f399632d.getCurrentSize();
        SolverVariable r101 = null;
        int r102 = 0;
        float r103 = 0.0f;
    L3:
        if (r102 >= r100) goto L19;
        float r104 = this.f399632d.getVariableValue(r102);
        if (r104 >= 0.0f) goto L18;
        SolverVariable r105 = this.f399632d.getVariable(r102);
        if (r110 != null) goto L9;
    L10:
        if (r105 == r111) goto L18;
        SolverVariable.Type r106 = r105.f399614i;
        if (r106 == SolverVariable.Type.SLACK) goto L16;
        if (r106 != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r104 >= r103) goto L18;
        r103 = r104;
        r101 = r105;
        goto L18
    L9:
        if (r110[r105.f399607b] == false) goto L10;
    L18:
        r102 = r102 + 1;
        goto L3
    L19:
        return r101;
    }

    public final void h(c r100, SolverVariable r101, boolean r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.f399611f == false) goto L15;
        this.f399630b += r101.f399610e * this.f399632d.a(r101);
        this.f399632d.b(r101, r102);
        if (r102 == false) goto L10;
        r101.b(this);
    L10:
        if (this.f399632d.getCurrentSize() != 0) goto L14;
        this.f399633e = true;
        r100.f399636b = true;
        return;
    L14:
        return;
    }

    public void i(c r100, b r101, boolean r102) {
        this.f399630b += r101.f399630b * this.f399632d.d(r101, r102);
        if (r102 == false) goto L6;
        r101.f399629a.b(this);
    L6:
        if (this.f399629a != null) goto L8;
        return;
    L8:
        if (this.f399632d.getCurrentSize() != 0) goto L12;
        this.f399633e = true;
        r100.f399636b = true;
        return;
    }

    public final void c(SolverVariable r100, SolverVariable r101, SolverVariable r102, int r103) {
        boolean r104 = false;
        if (r103 == 0) goto L8;
        if (r103 >= 0) goto L6;
        r103 = r103 * (-1);
        r104 = true;
    L6:
        this.f399630b = r103;
    L8:
        if (r104 == true) goto L10;
        this.f399632d.e(r100, -1.0f);
        this.f399632d.e(r101, 1.0f);
        this.f399632d.e(r102, 1.0f);
        return;
    L10:
        this.f399632d.e(r100, 1.0f);
        this.f399632d.e(r101, -1.0f);
        this.f399632d.e(r102, -1.0f);
    }

    public final void d(SolverVariable r100, SolverVariable r101, SolverVariable r102, int r103) {
        boolean r104 = false;
        if (r103 == 0) goto L8;
        if (r103 >= 0) goto L6;
        r103 = r103 * (-1);
        r104 = true;
    L6:
        this.f399630b = r103;
    L8:
        if (r104 == true) goto L10;
        this.f399632d.e(r100, -1.0f);
        this.f399632d.e(r101, 1.0f);
        this.f399632d.e(r102, -1.0f);
        return;
    L10:
        this.f399632d.e(r100, 1.0f);
        this.f399632d.e(r101, -1.0f);
        this.f399632d.e(r102, 1.0f);
    }
}
