package sz6;

import android.graphics.PointF;
import com.bytedance.lottie.LottieDrawable;
import nz6.n;
import rz6.m;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f543962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rz6.f f543963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rz6.b f543964d;

    public final String toString() {
        return "RectangleShape{position=" + this.f543962b + ", size=" + this.f543963c + '}';
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new n(r100, r101, this);
    }

    public e(String r100, m<PointF, PointF> r101, rz6.f r102, rz6.b r103) {
        this.f543961a = r100;
        this.f543962b = r101;
        this.f543963c = r102;
        this.f543964d = r103;
    }
}
