package com.bytedance.caijing.sdk.infra.base.impl.ttnet;

import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PluginPayWithoutLoginService;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ALogService f202752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PluginPayWithoutLoginService f202753b;

    public d() {
        ve4.a.f554342a.getClass();
        this.f202752a = (ALogService) ve4.a.a(ALogService.class);
        this.f202753b = (PluginPayWithoutLoginService) ve4.a.a(PluginPayWithoutLoginService.class);
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        ve4.a.f554342a.getClass();
        PluginPayWithoutLoginService r102 = (PluginPayWithoutLoginService) ve4.a.a(PluginPayWithoutLoginService.class);
        this.f202753b = r102;
        if (r102 == null) goto L19;
        if (r102.isPayWithoutLoginEnv() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L19;
        ALogService r103 = this.f202752a;
        if (r103 == null) goto L12;
        r103.i("pay_without_login", "CJPayWithoutLoginTTInterceptor check is isSaasRequest, url is " + r101.getUrl());
    L12:
        ArrayList r104 = new ArrayList();
        r104.addAll(r101.getHeaders());
        Iterator<Map.Entry<String, String>> r105 = r102.getPayWithoutLoginHeaders().entrySet().iterator();
    L14:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<String, String> r106 = r105.next();
        r104.add(new Header(r106.getKey(), r106.getValue()));
        goto L14
    L17:
        return r100.proceed(r100.request().newBuilder().headers(r104).build());
    L19:
        return r100.proceed(r101);
    }
}
