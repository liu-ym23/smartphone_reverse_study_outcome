package s0;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements s<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f539994a = null;

    public g() {
    }

    static {
        f539994a = new g();
    }

    @Override // s0.s
    public final Float a(JsonReader r100, float r101) throws IOException {
        return Float.valueOf(j.d(r100) * r101);
    }
}
