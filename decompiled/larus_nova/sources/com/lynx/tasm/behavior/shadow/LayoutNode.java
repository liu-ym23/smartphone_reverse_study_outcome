package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.LayoutNodeManager;
import y6a.a;
import y6a.b;
import y6a.e;
import y6a.g;
import y6a.h;
import y6a.j;
import y6a.o;

/* JADX INFO: loaded from: classes32.dex */
public class LayoutNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutNodeManager f382202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f382203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f382204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f382205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f382206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f382207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f382208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f382209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f382210i;

    public void g() {
    }

    public void align() {
        if (this.f382208g == null) goto L6;
        b r100 = new b();
        a r101 = new a();
        this.f382208g.d(r100, r101);
        return;
    }

    public void e() {
        this.f382209h = new o((ShadowNode) this);
        if (this.f382204c == true) goto L8;
        h r100 = this.f382207f;
        if (r100 == null) goto L8;
        i(r100);
        return;
    L8:
        if (this.f382205d == true) goto L14;
        e r101 = this.f382208g;
        if (r101 == null) goto L15;
        h(r101);
        return;
    L15:
        return;
    }

    public LayoutNode() {
        this.f382204c = false;
        this.f382205d = false;
        this.f382206e = false;
        this.f382208g = null;
        this.f382210i = 0;
    }

    public final void h(e r100) {
        this.f382208g = r100;
        LayoutNodeManager r101 = this.f382202a;
        if (r101 == null) goto L6;
        this.f382205d = true;
        r101.i(this.f382203b, this);
        return;
    }

    public final void i(h r100) {
        this.f382207f = r100;
        LayoutNodeManager r101 = this.f382202a;
        if (r101 == null) goto L6;
        this.f382204c = true;
        r101.i(this.f382203b, this);
        return;
    }

    public void f(int r100, int r101) {
        this.f382206e = false;
    }

    public float[] measure(float r110, int r111, float r112, int r113, boolean r114) {
        float[] r100 = new float[3];
        h r101 = this.f382207f;
        if (r101 == null) goto L6;
        long r115 = r101.c(this, r110, MeasureMode.fromInt(r111), r112, MeasureMode.fromInt(r113));
        r100[0] = Float.intBitsToFloat((int) ((r115 >> 32) & (-1)));
        r100[1] = Float.intBitsToFloat((int) (r115 & (-1)));
        r100[2] = this.f382210i;
    L8:
        return r100;
    L6:
        if (this.f382208g == null) goto L8;
        g r102 = new g(r114);
        j r116 = new j();
        MeasureMode r117 = MeasureMode.fromInt(r111);
        MeasureMode r118 = MeasureMode.fromInt(r113);
        r116.f566410a = r110;
        r116.f566411b = r117;
        r116.f566412c = r112;
        r116.f566413d = r118;
        float[] r119 = this.f382208g.b(r116, r102).f566414a;
        r100[0] = r119[0];
        r100[1] = r119[1];
        r100[2] = r119[2];
        goto L8
    }
}
