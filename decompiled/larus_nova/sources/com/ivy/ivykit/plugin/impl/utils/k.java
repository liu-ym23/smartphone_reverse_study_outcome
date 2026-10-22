package com.ivy.ivykit.plugin.impl.utils;

import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.keva.Keva;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.ivy.ivykit.plugin.impl.bullet.IBulletNetworkApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class k implements w26.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBulletNetworkApi f278443a;

    public k() {
    }

    @Override // w26.f
    public final w26.k post(String r100, Map<String, String> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        if (this.f278443a != null) goto L5;
        this.f278443a = (IBulletNetworkApi) new Retrofit.Builder().setEndpoint("https://is.snssdk.com/service/settings/v3/").client(new j()).addConverterFactory(rx5.a.a()).httpExecutor(new SsHttpExecutor()).build().create(IBulletNetworkApi.class);
    L5:
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((LinkedHashMap) r101).entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.add(new Header((String) r105.getKey(), (String) r105.getValue()));
        goto L7
    L9:
        AnnieXInit.f278438a.getClass();
        Keva r106 = AnnieXInit.f278440c;
        boolean r107 = r106.getBoolean("first_request", true);
        if (r107 == false) goto L12;
        r106.storeBoolean("first_request", false);
    L12:
        r103.add(new Header("X-Tt-Request-Tag", "t=0;n=" + (r107 ? 1 : 0)));
        IBulletNetworkApi r108 = this.f278443a;     // Catch: Throwable -> L21
        if (r108 == null) goto L24;
        Call<String> r109 = r108.doPost(r100, r102, r103);     // Catch: Throwable -> L21
        if (r109 == null) goto L24;
        SsResponse<String> r110 = r109.execute();     // Catch: Throwable -> L21
        if (r110 == null) goto L24;
        w26.k r111 = new w26.k();     // Catch: Throwable -> L21
        r111.f558034a = r110.body();     // Catch: Throwable -> L21
        r111.f558035b = r110.code();     // Catch: Throwable -> L21
        return r111;
    L24:
        return new w26.k();
    L21:
        th = move-exception;
        ExecutorService r112 = BulletLogger.f247763a;
        BulletLogger.e(th, "bullet settings request");
        goto L24
    }
}
