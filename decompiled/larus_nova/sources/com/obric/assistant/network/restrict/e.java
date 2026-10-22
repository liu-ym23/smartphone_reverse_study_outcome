package com.obric.assistant.network.restrict;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.assistant.network.api.INetworkInterceptorService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hm9.s;
import hm9.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f390362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f390363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f390364c;

    public e() {
        this.f390363b = new AtomicBoolean(true);
        this.f390364c = "ObricAssistantStateHandler";
        INetworkInterceptorService r100 = (INetworkInterceptorService) ServiceManager.get().getService(INetworkInterceptorService.class);
        if (r100 == null) goto L6;
        r100.b(new d(this));
        return;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (this.f390363b.get() == true) goto L10;
        if (r101 == null) goto L6;
        s.b(r101, "BackgroundNetworkInterceptor#ObricAssistantStateHandler", "[ObricAssistantStateHandler]NO need continue process current is active state}");
    L6:
        if (r101 == null) goto L8;
        r101.c();
    L8:
        if (r100 != null) goto L17;
    L15:
        return null;
    L17:
        return r100.proceed(r100.request());
    L10:
        if (r101 == null) goto L12;
        s.b(r101, "BackgroundNetworkInterceptor#ObricAssistantStateHandler", "[ObricAssistantStateHandler]Need continue process");
    L12:
        x r102 = this.f390362a;
        if (r102 == null) goto L15;
        return r102.a(r100, r101);
    }
}
