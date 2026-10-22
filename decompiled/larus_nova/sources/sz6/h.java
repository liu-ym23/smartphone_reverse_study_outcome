package sz6;

import android.graphics.Path;
import com.bytedance.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f543972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f543973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rz6.a f543975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rz6.d f543976e;

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f543972a + '}';
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new nz6.f(r100, r101, this);
    }

    public h(String r100, boolean r101, Path.FillType r102, rz6.a r103, rz6.d r104) {
        this.f543974c = r100;
        this.f543972a = r101;
        this.f543973b = r102;
        this.f543975d = r103;
        this.f543976e = r104;
    }
}
