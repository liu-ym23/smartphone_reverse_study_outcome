package uj6;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.live.photoviewer.ZoomableControllerImp;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements wj6.b<wj6.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wj6.e f550394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f550395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f550396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f550397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f550398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f550399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f550400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f550401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f550402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f550403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f550404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f550405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float[] f550406m;

    public final void c() {
        this.f550404k.mapRect(this.f550403j, this.f550402i);
        d r100 = this.f550395b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f550396c == false) goto L9;
        r100.a();
        return;
    }

    public final void f() {
        RectF r100 = this.f550401h;
        RectF r101 = this.f550402i;
        if (r101.width() <= r100.width()) goto L5;
    L8:
        this.f550400g = Math.max(r101.width() / r100.width(), r101.height() / r100.height());
        return;
    L5:
        if (r101.height() > r100.height()) goto L8;
        this.f550400g = Math.max(r100.width() / r101.width(), r100.height() / r101.height());
    }

    public a(wj6.e r100) {
        this.f550395b = null;
        this.f550396c = false;
        this.f550397d = true;
        this.f550398e = true;
        this.f550399f = 0.0f;
        this.f550400g = 0.0f;
        this.f550401h = new RectF();
        this.f550402i = new RectF();
        this.f550403j = new RectF();
        this.f550404k = new Matrix();
        this.f550405l = new Matrix();
        this.f550406m = new float[9];
        this.f550394a = r100;
        r100.f560031a = this;
    }

    public final float b(Matrix r100) {
        r100.getValues(this.f550406m);
        return this.f550406m[0];
    }

    public final void e(boolean r100) {
        this.f550396c = r100;
        if (r100 == true) goto L9;
        ZoomableControllerImp r101 = (ZoomableControllerImp) this;
        r101.q();
        if (r101.f255632y.computeScrollOffset() == false) goto L7;
        r101.f255632y.forceFinished(true);
    L7:
        r101.f255625r.reset();
        r101.f255624q.reset();
        r101.f550404k.reset();
        r101.c();
        return;
    }
}
