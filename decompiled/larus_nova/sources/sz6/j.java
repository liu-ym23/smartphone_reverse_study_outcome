package sz6;

import com.bytedance.lottie.LottieDrawable;
import nz6.p;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rz6.h f543981c;

    public final String toString() {
        return "ShapePath{name=" + this.f543979a + ", index=" + this.f543980b + '}';
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new p(r100, r101, this);
    }

    public j(String r100, int r101, rz6.h r102) {
        this.f543979a = r100;
        this.f543980b = r101;
        this.f543981c = r102;
    }
}
