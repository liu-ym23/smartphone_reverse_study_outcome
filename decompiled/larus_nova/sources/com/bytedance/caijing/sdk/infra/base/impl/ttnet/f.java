package com.bytedance.caijing.sdk.infra.base.impl.ttnet;

import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInSaasService;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ALogService f202754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlugInSaasService f202755b;

    public f() {
        ve4.a.f554342a.getClass();
        this.f202754a = (ALogService) ve4.a.a(ALogService.class);
        this.f202755b = (PlugInSaasService) ve4.a.a(PlugInSaasService.class);
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        Iterator<Header> r102 = r101.getHeaders().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Header r103 = r102.next();
        if (this.f202755b.hasEnvHeader(r103.getName()) == false) goto L4;
        if (this.f202755b.isSaasRequest(r103.getValue()) == false) goto L11;
        this.f202754a.i("Saas", "SaasTTInterceptor check is isSaasRequest, url is " + r101.getUrl());
        return r100.proceed(a(r101, true));
    L11:
        if (this.f202755b.isSaasJsbRequest(r103.getValue()) == false) goto L13;
        this.f202754a.i("Saas", "SaasTTInterceptor check is isSaasJsbRequest, url is " + r101.getUrl());
        return r100.proceed(a(r101, false));
    L13:
        this.f202754a.i("Saas", "SaasTTInterceptor check is not saas request, url is " + r101.getUrl());
        return r100.proceed(r101);
    L16:
        if (this.f202755b.checkIsCaijingSaasEnv() == false) goto L18;
        this.f202754a.i("Saas", "SaasTTInterceptor check is caijing sdk saas request, url is " + r101.getUrl());
        return r100.proceed(a(r101, true));
    L18:
        this.f202754a.i("Saas", "SaasTTInterceptor check is not caijing sdk saas request, url is " + r101.getUrl());
        return r100.proceed(r101);
    }

    public final Request a(Request r100, boolean r101) {
        String r102 = r100.getUrl();
        if (r101 == false) goto L5;
        r102 = this.f202755b.getSaasUrl(r102);
    L5:
        ArrayList r103 = new ArrayList();
        r103.addAll(r100.getHeaders());
        Iterator<Map.Entry<String, String>> r104 = this.f202755b.getSaasHeaders().entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry<String, String> r105 = r104.next();
        r103.add(new Header(r105.getKey(), r105.getValue()));
        goto L7
    L9:
        this.f202754a.i("Saas", "SaasTTInterceptor send saas request, url is " + r102);
        return r100.newBuilder().url(r102).headers(r103).build();
    }
}
