package o0;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import i0.o;
import n0.m;

/* JADX INFO: loaded from: classes28.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f521583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.f f521584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0.b f521585d;

    public final String toString() {
        return "RectangleShape{position=" + this.f521583b + ", size=" + this.f521584c + '}';
    }

    @Override // o0.b
    public final i0.c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new o(r100, r101, this);
    }

    public e(String r100, m<PointF, PointF> r101, n0.f r102, n0.b r103) {
        this.f521582a = r100;
        this.f521583b = r101;
        this.f521584c = r102;
        this.f521585d = r103;
    }
}
