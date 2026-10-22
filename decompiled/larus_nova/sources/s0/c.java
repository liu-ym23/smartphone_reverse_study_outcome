package s0;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static n0.d b(JsonReader r100, LottieComposition r101) throws IOException {
        return new n0.d(l.a(r100, r101, 1.0f, i.f539996a));
    }

    public static n0.f c(JsonReader r100, LottieComposition r101) throws IOException {
        return new n0.f(l.a(r100, r101, u0.f.d(), p.f540002a));
    }

    public static n0.b a(JsonReader r100, LottieComposition r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        float r103 = u0.f.d();
    L7:
        return new n0.b(l.a(r100, r101, r103, g.f539994a));
    L5:
        r103 = 1.0f;
        goto L7
    }
}
