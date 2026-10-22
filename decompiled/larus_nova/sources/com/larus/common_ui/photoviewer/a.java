package com.larus.common_ui.photoviewer;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import j19.m;
import k19.b;
import k19.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a implements b<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f327668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f327669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f327670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f327671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f327672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f327673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f327674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f327675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f327676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f327677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f327678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f327679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f327680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f327681n;

    /* JADX INFO: renamed from: com.larus.common_ui.photoviewer.a$a, reason: collision with other inner class name */
    public interface InterfaceC4188a {
        void a(boolean r100);

        void b();
    }

    public final void d() {
        this.f327679l.mapRect(this.f327678k, this.f327677j);
        m r100 = this.f327669b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f327670c == false) goto L9;
        r100.a();
        return;
    }

    public final void i() {
        RectF r100 = this.f327676i;
        RectF r101 = this.f327677j;
        if (r101.width() <= r100.width()) goto L5;
    L8:
        this.f327675h = Math.max(r101.width() / r100.width(), r101.height() / r100.height());
        return;
    L5:
        if (r101.height() > r100.height()) goto L8;
        this.f327675h = Math.max(r100.width() / r101.width(), r100.height() / r101.height());
    }

    public a(e r100) {
        this.f327669b = null;
        this.f327670c = false;
        this.f327671d = true;
        this.f327672e = true;
        this.f327673f = 1.0f;
        this.f327674g = 0.0f;
        this.f327675h = 0.0f;
        this.f327676i = new RectF();
        this.f327677j = new RectF();
        this.f327678k = new RectF();
        this.f327679l = new Matrix();
        this.f327680m = new Matrix();
        this.f327681n = new float[9];
        this.f327668a = r100;
        Intrinsics.checkNotNullParameter(this, "listener");
        r100.f501402a.add(this);
    }

    public final PointF a(PointF r110) {
        float[] r100 = this.f327681n;
        r100[0] = r110.x;
        r100[1] = r110.y;
        this.f327679l.invert(this.f327680m);
        this.f327680m.mapPoints(r100, 0, r100, 0, 1);
        return new PointF(r100[0], r100[1]);
    }

    public final void f(boolean r100) {
        this.f327670c = r100;
        if (r100 == true) goto L9;
        ZoomableControllerImp r101 = (ZoomableControllerImp) this;
        r101.w();
        if (r101.f327665z.computeScrollOffset() == false) goto L7;
        r101.f327665z.forceFinished(true);
    L7:
        r101.f327658s.reset();
        r101.f327657r.reset();
        r101.f327679l.reset();
        r101.d();
        return;
    }

    public final void g(float r100) {
        if (r100 >= 1.0f) goto L5;
        return;
    L5:
        if (r100 < this.f327673f) goto L10;
        this.f327674g = r100;
        return;
    }

    public void h(RectF r100) {
        this.f327676i.set(r100);
        i();
    }
}
