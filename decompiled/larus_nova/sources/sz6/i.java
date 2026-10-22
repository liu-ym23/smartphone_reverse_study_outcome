package sz6;

import com.bytedance.lottie.LottieDrawable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f543978b;

    public final String toString() {
        return "ShapeGroup{name='" + this.f543977a + "' Shapes: " + Arrays.toString(this.f543978b.toArray()) + '}';
    }

    public i(String r100, List<b> r101) {
        this.f543977a = r100;
        this.f543978b = r101;
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new nz6.c(r100, r101, this);
    }
}
