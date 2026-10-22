package com.ss.ugc.effectplatform.task;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.ModfifyFavoriteResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class w0 extends BaseNetworkTask<List<? extends String>, ModfifyFavoriteResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457965n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f457966o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f457967p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f457968q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f457969r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f457970s;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        HashMap r100 = new HashMap();
        int r101 = com.ss.ugc.effectplatform.util.g.f458036a;
        r100.putAll(com.ss.ugc.effectplatform.util.g.b(this.f457965n, 6));
        String r102 = this.f457966o;
        if (r102 == null) goto L5;
        r100.put("panel", r102);
    L5:
        r100.put(EffectConfiguration.KEY_EFFECT_IDS, this.f457968q);
        r100.put("type", Integer.valueOf(this.f457969r ? 1 : 0));
        Map<String, String> r103 = this.f457970s;
        if (r103 == null) goto L8;
        r100.putAll(r103);
    L8:
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f457965n.E);
        this.f457965n.getClass();
        r104.append("/effect/api/v3/effect/favorite");
        return new NetRequest(r104.toString(), null, HTTPMethod.POST, null, r100, "application/json", false, null, 202, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (ModfifyFavoriteResponse) r100.f469201a.convertJsonToObj(r101, ModfifyFavoriteResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void l(long r100, long r101, long r102, com.ss.ugc.effectplatform.model.e r103) {
        ModfifyFavoriteResponse r104 = (ModfifyFavoriteResponse) r103;
        e(new ModFavoriteTask$onSuccess$1(this));
    }

    public w0(EffectConfig r100, String r101, String r110, List<String> r111, boolean r112, Map<String, String> r113) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r110, r100.P);
        this.f457965n = r100;
        this.f457966o = r101;
        this.f457967p = r110;
        this.f457968q = r111;
        this.f457969r = r112;
        this.f457970s = r113;
    }
}
