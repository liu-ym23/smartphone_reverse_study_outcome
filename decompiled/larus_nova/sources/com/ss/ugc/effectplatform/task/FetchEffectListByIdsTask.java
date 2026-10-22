package com.ss.ugc.effectplatform.task;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.repository.EffectRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class FetchEffectListByIdsTask extends BaseNetworkTask<List<? extends Effect>, EffectListResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f457599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f457600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f457601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f457602r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final q f457603s;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final int h() {
        return 10014;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        HashMap r101 = com.ss.ugc.effectplatform.util.g.b(this.f457598n, 6);
        Map<String, String> r102 = this.f457601q;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        List<String> r103 = this.f457599o;
        if (r103 == null) goto L15;
        dlc.a r104 = this.f457598n.f457174t;
        if (r104 == null) goto L15;
        String r105 = r104.f469201a.convertObjToJson(r103);
        if (r105 == null) goto L15;
        if (this.f457602r == false) goto L14;
        r101.put(EffectConfiguration.KEY_EFFECT_IDS, r105);
        goto L15
    L14:
        r101.put(EffectConfiguration.KEY_RESOURCE_IDS, r105);
    L15:
        int r106 = com.ss.ugc.effectplatform.util.m.f458043a;
        StringBuilder r107 = new StringBuilder();
        r107.append(this.f457598n.E);
        this.f457598n.getClass();
        r107.append("/effect/api");
        if (this.f457602r == false) goto L18;
        String r108 = EffectConstants.ROUTE_LIST;
    L19:
        r107.append(r108);
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r101, r107.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L18:
        r108 = EffectConstants.ROUTE_GET_LIST_BY_RESOURCE;
        goto L19
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (EffectListResponse) r100.f469201a.convertJsonToObj(r101, EffectListResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void k(String r100, String r101, final ExceptionResult r102) {
        e(new FetchEffectListByIdsTask$onFailure$1(this, r102));
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void l(long r110, long r111, long r112, com.ss.ugc.effectplatform.model.e r210) {
        final EffectListResponse r100 = (EffectListResponse) r210;
        List<Effect> r101 = r100.getEffect_list();
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Effect r103 = (Effect) r102.next();
        r103.setId(StringsKt.replace$default(StringsKt.replace$default(r103.getId(), "\"", "_", false, 4, null), HTTP.URL_DEFAULT, "_", false, 4, null));
    L8:
        List<Effect> r104 = r100.getCollection_list();
        if (r104 == null) goto L14;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Effect r106 = (Effect) r105.next();
        r106.setId(StringsKt.replace$default(StringsKt.replace$default(r106.getId(), "\"", "_", false, 4, null), HTTP.URL_DEFAULT, "_", false, 4, null));
    L14:
        com.ss.ugc.effectplatform.util.h r107 = com.ss.ugc.effectplatform.util.h.f458037a;
        String r108 = this.f457598n.f457163i;
        List<Effect> r109 = r100.getEffect_list();
        r107.getClass();
        com.ss.ugc.effectplatform.util.h.e(r108, r109);
        com.ss.ugc.effectplatform.util.h.e(this.f457598n.f457163i, r100.getCollection_list());
        ArrayList r113 = new ArrayList();
        r113.addAll(r100.getEffect_list());
        r113.addAll(r100.getBind_effects());
        r113.addAll(r100.getCollection_list());
        if (r113.isEmpty() == false) goto L17;
        e(new FetchEffectListByIdsTask$onSuccess$3(this, r100));
        return;
    L17:
        this.f457603s.a(r113, new FetchEffectListByIdsTask$onSuccess$4(this, r100));
    }

    public FetchEffectListByIdsTask(EffectConfig r100, List r101, String r110, Map r111, boolean r112, EffectRepository.a r113) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r110, r100.P);
        this.f457598n = r100;
        this.f457599o = r101;
        this.f457600p = r110;
        this.f457601q = r111;
        this.f457602r = r112;
        this.f457603s = r113;
    }
}
