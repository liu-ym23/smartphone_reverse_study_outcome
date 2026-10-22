package xz6;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes21.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lottie.d f565526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f565527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f565528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f565529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f565530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f565531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f565532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f565533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PointF f565534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PointF f565535j;

    public final float a() {
        if (this.f565526a != null) goto L6;
        return 1.0f;
    L6:
        if (this.f565533h != Float.MIN_VALUE) goto L12;
        if (this.f565531f != null) goto L10;
        this.f565533h = 1.0f;
        goto L12
    L10:
        float r100 = b();
        float r101 = this.f565531f.floatValue() - this.f565530e;
        com.bytedance.lottie.d r102 = this.f565526a;
        this.f565533h = r100 + (r101 / (r102.f264434k - r102.f264433j));
    L12:
        return this.f565533h;
    }

    public final float b() {
        com.bytedance.lottie.d r100 = this.f565526a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        if (this.f565532g != Float.MIN_VALUE) goto L10;
        float r101 = this.f565530e;
        float r102 = r100.f264433j;
        this.f565532g = (r101 - r102) / (r100.f264434k - r102);
    L10:
        return this.f565532g;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f565527b + ", endValue=" + this.f565528c + ", startFrame=" + this.f565530e + ", endFrame=" + this.f565531f + ", interpolator=" + this.f565529d + '}';
    }

    public a(T r100) {
        this.f565532g = Float.MIN_VALUE;
        this.f565533h = Float.MIN_VALUE;
        this.f565534i = null;
        this.f565535j = null;
        this.f565526a = null;
        this.f565527b = r100;
        this.f565528c = r100;
        this.f565529d = null;
        this.f565530e = Float.MIN_VALUE;
        this.f565531f = Float.valueOf(Float.MAX_VALUE);
    }

    public a(com.bytedance.lottie.d r100, T r101, T r102, Interpolator r103, float r104, Float r105) {
        this.f565532g = Float.MIN_VALUE;
        this.f565533h = Float.MIN_VALUE;
        this.f565534i = null;
        this.f565535j = null;
        this.f565526a = r100;
        this.f565527b = r101;
        this.f565528c = r102;
        this.f565529d = r103;
        this.f565530e = r104;
        this.f565531f = r105;
    }
}
