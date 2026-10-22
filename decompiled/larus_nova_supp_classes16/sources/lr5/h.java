package lr5;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends f {
    @Override // lr5.f
    public final a b() {
        OkHttpClient r0 = this.a;
        sr5.a.a(r0);
        return new a(r0.newBuilder(), Boolean.TRUE);
    }

    public h(OkHttpClient r1) {
        this.a = r1.newBuilder().build();
    }

    @Override // lr5.g
    public final f a(OkHttpClient r2) {
        return new h(r2);
    }

    public final Call newCall(Request r1) {
        return super.newCall(r1);
    }
}
