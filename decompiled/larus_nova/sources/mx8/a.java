package mx8;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f516316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f516317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f516318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f516319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f516320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f516321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f516322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f516323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f516324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f516325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f516326k;

    public final void b() {
        this.f516319d.reset();
        float r100 = this.f516325j / 2.0f;
        float r101 = this.f516326k / 2.0f;
        Matrix r102 = this.f516319d;
        float r103 = this.f516317b;
        r102.postScale(r103, r103, r100, r101);
        this.f516319d.postTranslate((this.f516323h / 2.0f) - r100, (this.f516324i / 2.0f) - r101);
        this.f516319d.postRotate(this.f516318c, this.f516323h / 2.0f, this.f516324i / 2.0f);
        this.f516319d.invert(this.f516320e);
        this.f516319d.mapRect(this.f516322g, this.f516321f);
    }

    public a() {
        this.f516317b = 1.0f;
        this.f516319d = new Matrix();
        this.f516320e = new Matrix();
        this.f516321f = new RectF();
        this.f516322g = new RectF();
    }

    public final float a(float r100) {
        float r101 = this.f516326k;
        if (r101 <= 0.0f) goto L15;
        float r102 = this.f516325j;
        if (r102 > 0.0f) goto L8;
        return 1.0f;
    L8:
        if ((r100 % 180) != 0.0f) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        return Math.min(this.f516323h / r102, this.f516324i / r101);
    L14:
        return Math.min(this.f516324i / r102, this.f516323h / r101);
    L10:
        r103 = false;
        goto L11
    L15:
        return 1.0f;
    }
}
