package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ResourceListModel;
import com.ss.ugc.effectplatform.model.net.ResourceListResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class u0 extends BaseNetworkTask<ResourceListModel, ResourceListResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, String> f457959o;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        HashMap r101 = com.ss.ugc.effectplatform.util.g.b(this.f457958n, 6);
        Map<String, String> r102 = this.f457959o;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        int r103 = com.ss.ugc.effectplatform.util.m.f458043a;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f457958n.E);
        this.f457958n.getClass();
        r104.append("/effect/api/moji/resource");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r101, r104.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (ResourceListResponse) r100.f469201a.convertJsonToObj(r101, ResourceListResponse.class);
    }

    public u0(EffectConfig r100, String r101, Map<String, String> r110) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r101, r100.P);
        this.f457958n = r100;
        this.f457959o = r110;
    }
}
