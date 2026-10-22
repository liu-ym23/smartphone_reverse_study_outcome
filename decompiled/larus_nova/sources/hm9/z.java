package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f486000a;

    public z(b0 r100) {
        this.f486000a = r100;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (r101 == null) goto L6;
        boolean r102 = true;
        if (r101.f485976f != true) goto L6;
    L8:
        if (r102 == false) goto L12;
        s.b(r101, "BackgroundNetworkInterceptor#UserInWhiteListHandler", "[UserInWhiteListHandler]No need continue process current user is in white list , userDidInWhiteList :" + r101.f485976f + " userWhiteList :" + r101.f485987q);
        if (r100 != null) goto L19;
    L17:
        return null;
    L19:
        return r100.proceed(r100.request());
    L12:
        if (r101 == null) goto L14;
        s.b(r101, "BackgroundNetworkInterceptor#UserInWhiteListHandler", "[UserInWhiteListHandler]Need continue process current user is not in white list , userDidInWhiteList :" + r101.f485976f + " userWhiteList :" + r101.f485987q);
    L14:
        x r103 = this.f486000a;
        if (r103 == null) goto L17;
        return r103.a(r100, r101);
    L6:
        r102 = false;
        goto L8
    }
}
