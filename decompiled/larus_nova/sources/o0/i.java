package o0;

import com.airbnb.lottie.LottieDrawable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f521599b;

    public final String toString() {
        return "ShapeGroup{name='" + this.f521598a + "' Shapes: " + Arrays.toString(this.f521599b.toArray()) + '}';
    }

    public i(String r100, List<b> r101) {
        this.f521598a = r100;
        this.f521599b = r101;
    }

    @Override // o0.b
    public final i0.c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new i0.d(r100, r101, this);
    }
}
