package v0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: loaded from: classes3.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieComposition f552274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f552275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f552276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f552277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f552278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f552279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f552280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f552281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f552282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f552283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f552284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f552285l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PointF f552286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PointF f552287n;

    public final float b() {
        if (this.f552274a != null) goto L6;
        return 1.0f;
    L6:
        if (this.f552285l != Float.MIN_VALUE) goto L12;
        if (this.f552279f != null) goto L10;
        this.f552285l = 1.0f;
        goto L12
    L10:
        this.f552285l = c() + ((this.f552279f.floatValue() - this.f552278e) / this.f552274a.getDurationFrames());
    L12:
        return this.f552285l;
    }

    public final float c() {
        LottieComposition r100 = this.f552274a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        if (this.f552284k != Float.MIN_VALUE) goto L10;
        this.f552284k = (this.f552278e - r100.getStartFrame()) / this.f552274a.getDurationFrames();
    L10:
        return this.f552284k;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f552275b + ", endValue=" + this.f552276c + ", startFrame=" + this.f552278e + ", endFrame=" + this.f552279f + ", interpolator=" + this.f552277d + '}';
    }

    public a(T r100) {
        this.f552280g = -3987645.8f;
        this.f552281h = -3987645.8f;
        this.f552282i = 784923401;
        this.f552283j = 784923401;
        this.f552284k = Float.MIN_VALUE;
        this.f552285l = Float.MIN_VALUE;
        this.f552286m = null;
        this.f552287n = null;
        this.f552274a = null;
        this.f552275b = r100;
        this.f552276c = r100;
        this.f552277d = null;
        this.f552278e = Float.MIN_VALUE;
        this.f552279f = Float.valueOf(Float.MAX_VALUE);
    }

    public final boolean a(float r100) {
        if (r100 >= c()) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= b()) goto L7;
        return true;
    }

    public a(LottieComposition r100, T r101, T r102, Interpolator r103, float r104, Float r105) {
        this.f552280g = -3987645.8f;
        this.f552281h = -3987645.8f;
        this.f552282i = 784923401;
        this.f552283j = 784923401;
        this.f552284k = Float.MIN_VALUE;
        this.f552285l = Float.MIN_VALUE;
        this.f552286m = null;
        this.f552287n = null;
        this.f552274a = r100;
        this.f552275b = r101;
        this.f552276c = r102;
        this.f552277d = r103;
        this.f552278e = r104;
        this.f552279f = r105;
    }
}
