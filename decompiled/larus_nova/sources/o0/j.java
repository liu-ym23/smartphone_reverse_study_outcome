package o0;

import com.airbnb.lottie.LottieDrawable;
import i0.q;

/* JADX INFO: loaded from: classes28.dex */
public final class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f521601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.h f521602c;

    public final String toString() {
        return "ShapePath{name=" + this.f521600a + ", index=" + this.f521601b + '}';
    }

    @Override // o0.b
    public final i0.c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new q(r100, r101, this);
    }

    public j(String r100, int r101, n0.h r102) {
        this.f521600a = r100;
        this.f521601b = r101;
        this.f521602c = r102;
    }
}
