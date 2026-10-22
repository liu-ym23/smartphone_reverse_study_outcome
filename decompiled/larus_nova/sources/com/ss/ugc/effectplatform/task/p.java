package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.ConvertOidToUrlResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class p extends BaseNetworkTask<ConvertOidToUrlResponse, ConvertOidToUrlResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457889n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f457890o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f457891p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f457892q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f457893r;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final int h() {
        return 10002;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        HashMap r100 = new HashMap();
        r100.put("scene", this.f457891p);
        dlc.a r101 = this.f457889n.f457174t;
        if (r101 == null) goto L7;
        List<String> r102 = this.f457892q;
        String r103 = r101.f469201a.convertObjToJson(r102);
        if (r103 == null) goto L7;
        r100.put("object_ids", r103);
    L7:
        Map<String, String> r104 = this.f457893r;
        if (r104 == null) goto L10;
        r100.putAll(r104);
    L10:
        int r105 = com.ss.ugc.effectplatform.util.m.f458043a;
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r100, this.f457890o), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final int i() {
        return this.f457889n.f457171q;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (ConvertOidToUrlResponse) r100.f469201a.convertJsonToObj(r101, ConvertOidToUrlResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void k(String r100, String r101, ExceptionResult r102) {
        r102.setTrackParams(r100, this.f457889n.E, r101);
        super.k(r100, r101, r102);
    }

    public p(EffectConfig r100, String r101, String r110, List<String> r111, String r112, Map<String, String> r113) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r112, r100.P);
        this.f457889n = r100;
        this.f457890o = r101;
        this.f457891p = r110;
        this.f457892q = r111;
        this.f457893r = r113;
    }
}
