package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f485969a;

    public l(m r100) {
        this.f485969a = r100;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (r101 == null) goto L6;
        boolean r102 = true;
        if (r101.f485975e != true) goto L6;
    L8:
        if (r102 == false) goto L12;
        s.b(r101, "BackgroundNetworkInterceptor#DoraUserControlHandler", "[DoraUserControlHandler]Need continue process is dora user , doraUser :" + r101.f485975e);
        x r103 = this.f485969a;
        if (r103 != null) goto L18;
    L16:
        return null;
    L18:
        return r103.a(r100, r101);
    L12:
        if (r101 == null) goto L14;
        s.b(r101, "BackgroundNetworkInterceptor#DoraUserControlHandler", "[DoraUserControlHandler]No Need continue ,not dora user no need control just process, doraUser :" + r101.f485975e);
    L14:
        if (r100 == null) goto L16;
        return r100.proceed(r100.request());
    L6:
        r102 = false;
        goto L8
    }
}
