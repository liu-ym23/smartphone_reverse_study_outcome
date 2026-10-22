package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.network.interceptor.http.DoraTaskStatus;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f485968a;

    public k(x r100) {
        this.f485968a = r100;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (r101 == null) goto L6;
        boolean r102 = true;
        if (r101.f485977g != true) goto L6;
    L8:
        if (r102 == true) goto L10;
        if (r101 == null) goto L19;
        s.b(r101, "BackgroundNetworkInterceptor#DoraQueryStatusHandler", "[DoraQueryStatusHandler]Need continue process , needOnlyBlockWhenNotUseDora :" + r101.f485977g + " mDoraTaskStatus : " + r101.f485992v + ' ');
    L19:
        x r103 = this.f485968a;
        if (r103 != null) goto L26;
    L22:
        return null;
    L26:
        return r103.a(r100, r101);
    L10:
        if (r101.f485992v != DoraTaskStatus.WAKE_UP) goto L14;
        s.b(r101, "BackgroundNetworkInterceptor#DoraQueryStatusHandler", "[DoraQueryStatusHandler]No need continue process , needOnlyBlockWhenNotUseDora :" + r101.f485977g + " mDoraTaskStatus : " + r101.f485992v + ' ');
        r101.c();
        if (r100 == null) goto L22;
        return r100.proceed(r100.request());
    L14:
        s.b(r101, "BackgroundNetworkInterceptor#DoraQueryStatusHandler", "[DoraQueryStatusHandler]Need continue process , needOnlyBlockWhenNotUseDora :" + r101.f485977g + " mDoraTaskStatus : " + r101.f485992v + ' ');
        x r104 = this.f485968a;
        if (r104 == null) goto L22;
        return r104.a(r100, r101);
    L6:
        r102 = false;
        goto L8
    }
}
