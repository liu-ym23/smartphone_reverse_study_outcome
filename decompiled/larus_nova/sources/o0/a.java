package o0;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import n0.m;

/* JADX INFO: loaded from: classes28.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f521570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.f f521571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f521572d;

    @Override // o0.b
    public final i0.c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new i0.f(r100, r101, this);
    }

    public a(String r100, m<PointF, PointF> r101, n0.f r102, boolean r103) {
        this.f521569a = r100;
        this.f521570b = r101;
        this.f521571c = r102;
        this.f521572d = r103;
    }
}
