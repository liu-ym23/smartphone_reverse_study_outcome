package com.ss.ugc.effectplatform.task;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.repository.EffectRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class t extends BaseNetworkTask<List<? extends Effect>, EffectListResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f457941o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f457942p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final q f457943q;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        HashMap r101 = com.ss.ugc.effectplatform.util.g.b(this.f457940n, 6);
        Map<String, String> r102 = this.f457942p;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        List<String> r103 = this.f457941o;
        if (r103 == null) goto L12;
        dlc.a r104 = this.f457940n.f457174t;
        if (r104 == null) goto L12;
        String r105 = r104.f469201a.convertObjToJson(r103);
        if (r105 == null) goto L12;
        r101.put(EffectConfiguration.KEY_EFFECT_IDS, r105);
    L12:
        int r106 = com.ss.ugc.effectplatform.util.m.f458043a;
        StringBuilder r107 = new StringBuilder();
        r107.append(this.f457940n.E);
        this.f457940n.getClass();
        r107.append("/effect/api/v3/effect/list");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r101, r107.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (EffectListResponse) r100.f469201a.convertJsonToObj(r101, EffectListResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void l(long r110, long r111, long r210, com.ss.ugc.effectplatform.model.e r211) {
        EffectListResponse r100 = (EffectListResponse) r211;
        List<Effect> r101 = r100.getEffect_list();
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Effect r103 = (Effect) r102.next();
        r103.setId(StringsKt.replace$default(StringsKt.replace$default(r103.getId(), "\"", "_", false, 4, null), HTTP.URL_DEFAULT, "_", false, 4, null));
    L8:
        com.ss.ugc.effectplatform.util.h r104 = com.ss.ugc.effectplatform.util.h.f458037a;
        String r105 = this.f457940n.f457163i;
        List<Effect> r106 = r100.getEffect_list();
        r104.getClass();
        com.ss.ugc.effectplatform.util.h.e(r105, r106);
        ArrayList r112 = new ArrayList();
        r112.addAll(r100.getEffect_list());
        r112.addAll(r100.getBind_effects());
        r112.addAll(r100.getCollection_list());
        if (r112.isEmpty() == false) goto L11;
        super.l(r110, r111, r210, r100);
        return;
    L11:
        this.f457943q.a(r112, new s(this, r110, r111, r210, r100));
    }

    public t(EffectConfig r100, List r101, String r110, Map r111, EffectRepository.a r112) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r110, r100.P);
        this.f457940n = r100;
        this.f457941o = r101;
        this.f457942p = r111;
        this.f457943q = r112;
    }

    public static final /* synthetic */ void q(t r100, long r101, long r102, long r103, EffectListResponse r104) {
        super.l(r101, r102, r103, r104);
    }
}
