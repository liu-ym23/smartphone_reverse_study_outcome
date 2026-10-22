package vz6;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements s<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f557727a = null;

    public i() {
    }

    static {
        f557727a = new i();
    }

    @Override // vz6.s
    public final Integer a(JsonReader r100, float r101) throws IOException {
        return Integer.valueOf(Math.round(j.d(r100) * r101));
    }
}
