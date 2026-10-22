package x18;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y18.a f562143a;

    public c(y18.a r100) {
        this.f562143a = r100;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) throws IOException {
        return r100.proceed(r100.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", this.f562143a.getUserAgent()).build());
    }
}
