package lr5;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends f {
    @Override // lr5.f
    public final a b() {
        OkHttpClient r100 = this.f510429a;
        sr5.a.a(r100);
        return new a(r100.newBuilder(), Boolean.TRUE);
    }

    public h(OkHttpClient r100) {
        this.f510429a = r100.newBuilder().build();
    }

    @Override // lr5.g
    public final f a(OkHttpClient r100) {
        return new h(r100);
    }

    @Override // okhttp3.OkHttpClient, okhttp3.Call.a
    public final Call newCall(Request r100) {
        return super.newCall(r100);
    }
}
