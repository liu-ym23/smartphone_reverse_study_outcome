package e28;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f470836a;

    public b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "usSupporter");
        this.f470836a = r100;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        String r101 = this.f470836a.getUserAgent();
        if (r101 == null) goto L5;
        Response r102 = r100.proceed(r100.request().newBuilder().header("User-Agent", r101).build());
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        Response r103 = r100.proceed(r100.request());
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
