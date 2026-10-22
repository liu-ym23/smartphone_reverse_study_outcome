package com.ss.ugc.effectplatform.task;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.SearchEffectResponseV2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class l1 extends BaseNetworkTask<SearchEffectResponseV2, SearchEffectResponseV2> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f457831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f457832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f457833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f457834r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f457835s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, String> f457836t;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final int h() {
        return 10014;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        HashMap r101 = com.ss.ugc.effectplatform.util.g.b(this.f457830n, 6);
        String r102 = this.f457831o;
        if (r102 == null) goto L5;
        r101.put("search_id", r102);
    L5:
        r101.put("keyword", this.f457832p);
        r101.put(EffectConfiguration.KEY_CURSOR, String.valueOf(this.f457834r));
        r101.put("count", String.valueOf(this.f457833q));
        String r103 = this.f457835s;
        if (r103 == null) goto L8;
        r101.put("panel", r103);
    L8:
        Map<String, String> r104 = this.f457836t;
        if (r104 == null) goto L11;
        r101.putAll(r104);
    L11:
        int r105 = com.ss.ugc.effectplatform.util.m.f458043a;
        StringBuilder r106 = new StringBuilder();
        r106.append(this.f457830n.E);
        this.f457830n.getClass();
        r106.append("/effect/api/search/effects");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r101, r106.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (SearchEffectResponseV2) r100.f469201a.convertJsonToObj(r101, SearchEffectResponseV2.class);
    }

    public l1(EffectConfig r100, String r101, String r110, int r111, int r112, String r113, Map<String, String> r114, String r115) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r115, r100.P);
        this.f457830n = r100;
        this.f457831o = r101;
        this.f457832p = r110;
        this.f457833q = r111;
        this.f457834r = r112;
        this.f457835s = r113;
        this.f457836t = r114;
    }
}
