package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends AbsPrefetchInterceptor {
    @Override // com.bytedance.locallife.biz.prefetch.newsdk.AbsPrefetchInterceptor
    public final boolean b() {
        return false;
    }

    public b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
    }

    @Override // com.bytedance.locallife.biz.prefetch.newsdk.AbsPrefetchInterceptor
    public final SsResponse<?> f(Interceptor.Chain r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Intrinsics.checkNotNullParameter(r111, "key");
        this.f256934a.getScene();
        i<f> r100 = PrefetchManager.f256936a;
        f r101 = r100.get(r111);
        if (r101 == null) goto L50;
        r100.remove(r111);
        this.f256934a.getScene();
        System.currentTimeMillis();
        n r113 = r101.f256946c;
        boolean r102 = true;
        Integer r103 = null;
        if (a(r101) == true) goto L30;
        Throwable r104 = r101.f256947d;
        if ((r104 instanceof CronetIOException) == false) goto L9;
        CronetIOException r105 = (CronetIOException) r104;
    L10:
        if (r105 == null) goto L12;
        r103 = Integer.valueOf(r105.getStatusCode());
    L12:
        if (r103 == null) goto L28;
        int r106 = r103.intValue();
        if (r106 != 503) goto L16;
    L21:
        if (r102 == false) goto L28;
        if (this.f256934a.b() == false) goto L28;
        this.f256934a.getScene();
        Throwable r107 = r101.f256947d;
        if (r107 == null) goto L27;
        throw r107;
    L27:
        throw new IllegalStateException("prefetch disaster code: " + r103);
    L16:
        if (r106 == 555) goto L21;
        if (r106 == 556) goto L21;
        r102 = false;
    L28:
        this.f256934a.getScene();
        return g(r110, r112, "CACHE_VALID_TIME_OUT", "");
    L9:
        r105 = null;
        goto L10
    L30:
        if (r113 != null) goto L32;
    L41:
        this.f256934a.getScene();
        AbsPrefetchInterceptor.e(this, false, true, 0, 124);
        Throwable r108 = r101.f256947d;
        if (r108 != null) goto L48;
        if (r113 == null) goto L47;
        SsResponse<?> r109 = r113.f256970b;
        if (r109 == null) goto L47;
        return r109;
    L47:
        return g(r110, r112, "CACHE_DATA_ERROR", "");
    L48:
        throw r108;
    L32:
        if (r113.f256969a == 200) goto L35;
        r102 = false;
    L35:
        if (r102 == false) goto L41;
        this.f256934a.getScene();
        Objects.toString(r113.f256970b);
        long r114 = System.currentTimeMillis() - r112;
        long r115 = r112 - r101.f256948e;
        Long r116 = r101.f256949f;
        if (r116 == null) goto L39;
        Long r117 = Long.valueOf(r112 - r116.longValue());
    L40:
        String r118 = r101.f256945b.i();
        r101.f256945b.f();
        d(true, true, r114, r115, r117, r118, "default");
        this.f256935b = false;
        return r113.f256970b;
    L39:
        r117 = null;
        goto L40
    L50:
        return g(r110, r112, "REQUEST_NOT_FOCUS", "预请求未命中");
    }

    public final SsResponse<?> g(Interceptor.Chain r100, long r101, String r110, String r111) {
        c(r110, r111);
        Function0<Unit> r112 = this.f256934a.e();
        if (r112 == null) goto L19;
        r112.invoke();
    L19:
        SsResponse<?> r102 = r100.proceed(r100.request());     // Catch: Throwable -> L13 Exception -> L15
        Function0<Unit> r113 = this.f256934a.j();     // Catch: Throwable -> L13 Exception -> L15
        if (r113 == null) goto L8;
        r113.invoke();     // Catch: Throwable -> L13 Exception -> L15
    L8:
        AbsPrefetchInterceptor.e(this, true, false, System.currentTimeMillis() - r101, 120);     // Catch: Throwable -> L13 Exception -> L15
        if (r102.code() != 200) goto L11;
        k.f256959e = 0;     // Catch: Throwable -> L13 Exception -> L15
    L11:
        this.f256935b = false;     // Catch: Throwable -> L13 Exception -> L15
        return r102;
    L15:
        e = move-exception;
        k.f256959e++;     // Catch: Throwable -> L13
        AbsPrefetchInterceptor.e(this, false, false, 0, 124);     // Catch: Throwable -> L13
        throw e;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
