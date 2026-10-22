package s0;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements s<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f539996a = null;

    public i() {
    }

    static {
        f539996a = new i();
    }

    @Override // s0.s
    public final Integer a(JsonReader r100, float r101) throws IOException {
        return Integer.valueOf(Math.round(j.d(r100) * r101));
    }
}
