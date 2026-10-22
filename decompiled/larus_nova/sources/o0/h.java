package o0;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes28.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f521593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f521594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f521595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0.a f521596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n0.d f521597e;

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f521593a + '}';
    }

    @Override // o0.b
    public final i0.c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new i0.g(r100, r101, this);
    }

    public h(String r100, boolean r101, Path.FillType r102, n0.a r103, n0.d r104) {
        this.f521595c = r100;
        this.f521593a = r101;
        this.f521594b = r102;
        this.f521596d = r103;
        this.f521597e = r104;
    }
}
