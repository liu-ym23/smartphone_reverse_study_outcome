package com.obric.assistant.network.restrict;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import hm9.s;
import hm9.x;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f390368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f390369b;

    public i(boolean r100) {
        this.f390368a = r100;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (this.f390368a == false) goto L9;
        if (r101 == null) goto L6;
        s.b(r101, "BackgroundNetworkInterceptor#ObricNetworkControlEnableHandler", "[ObricNetworkControlEnableHandler]Need continue process need open control");
    L6:
        x r102 = this.f390369b;
        if (r102 != null) goto L15;
    L13:
        return null;
    L15:
        return r102.a(r100, r101);
    L9:
        if (r101 == null) goto L11;
        s.b(r101, "BackgroundNetworkInterceptor#ObricNetworkControlEnableHandler", "[ObricNetworkControlEnableHandler]No Need continue ,no need open control just process");
    L11:
        if (r100 == null) goto L13;
        return r100.proceed(r100.request());
    }
}
