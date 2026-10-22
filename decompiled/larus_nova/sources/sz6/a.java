package sz6;

import android.graphics.PointF;
import com.bytedance.lottie.LottieDrawable;
import rz6.m;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f543949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rz6.f f543950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f543951d;

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new nz6.e(r100, r101, this);
    }

    public a(String r100, m<PointF, PointF> r101, rz6.f r102, boolean r103) {
        this.f543948a = r100;
        this.f543949b = r101;
        this.f543950c = r102;
        this.f543951d = r103;
    }
}
