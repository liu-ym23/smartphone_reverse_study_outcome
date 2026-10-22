package vz6;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static rz6.d b(JsonReader r100, com.bytedance.lottie.d r101) throws IOException {
        return new rz6.d(l.a(r100, r101, 1.0f, i.f557727a));
    }

    public static rz6.f c(JsonReader r100, com.bytedance.lottie.d r101) throws IOException {
        return new rz6.f(l.a(r100, r101, wz6.h.d(), p.f557732a));
    }

    public static rz6.b a(JsonReader r100, com.bytedance.lottie.d r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        float r103 = wz6.h.d();
    L7:
        return new rz6.b(l.a(r100, r101, r103, g.f557725a));
    L5:
        r103 = 1.0f;
        goto L7
    }
}
