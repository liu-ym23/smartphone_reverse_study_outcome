package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.RecommendSearchWordsResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class i1 extends BaseNetworkTask<RecommendSearchWordsResponse, RecommendSearchWordsResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f457800o;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final int h() {
        return 10003;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        HashMap r101 = com.ss.ugc.effectplatform.util.g.b(this.f457799n, 6);
        String r102 = this.f457800o;
        if (r102 == null) goto L5;
        r101.put("panel", r102);
    L5:
        int r103 = com.ss.ugc.effectplatform.util.m.f458043a;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f457799n.E);
        this.f457799n.getClass();
        r104.append("/effect/api/search/recommend");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r101, r104.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (RecommendSearchWordsResponse) r100.f469201a.convertJsonToObj(r101, RecommendSearchWordsResponse.class);
    }

    public i1(EffectConfig r100, String r101, String r110) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r110, r100.P);
        this.f457799n = r100;
        this.f457800o = r101;
    }
}
