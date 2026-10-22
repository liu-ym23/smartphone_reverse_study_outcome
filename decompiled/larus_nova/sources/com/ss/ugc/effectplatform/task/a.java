package com.ss.ugc.effectplatform.task;

import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.AddCustomizedEffectResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends BaseNetworkTask<AddCustomizedEffectResponse, AddCustomizedEffectResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f457671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f457672p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f457673q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f457674r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f457675s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f457676t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f457677u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f457678v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f457679w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<String, Object> f457680x;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.task.a$a, reason: collision with other inner class name */
    public static final class C5472a {
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
        int r101 = com.ss.ugc.effectplatform.util.g.f458036a;
        r100.putAll(com.ss.ugc.effectplatform.util.g.b(this.f457670n, 6));
        r100.remove("aid");
        r100.put("aid", Long.valueOf(this.f457671o));
        r100.put(MobConstants.EFFECT_ID, this.f457672p);
        r100.put("effect_source_id", this.f457673q);
        r100.put("effect_file", this.f457675s);
        String r102 = this.f457678v;
        if (r102 == null) goto L5;
        r100.put("icon", r102);
    L5:
        r100.put("file_url_type", Integer.valueOf(this.f457674r));
        r100.put("file_md5", this.f457676t);
        r100.put("icon_url_type", Integer.valueOf(this.f457677u));
        String r103 = this.f457679w;
        if (r103 == null) goto L8;
        r100.put("effect_description", r103);
    L8:
        Map<String, Object> r104 = this.f457680x;
        if (r104 == null) goto L11;
        r100.putAll(r104);
    L11:
        StringBuilder r105 = new StringBuilder();
        r105.append(this.f457670n.E);
        this.f457670n.getClass();
        r105.append("/effect/api/customized/add");
        return new NetRequest(r105.toString(), null, HTTPMethod.POST, null, r100, "application/json", false, null, 202, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final int i() {
        return this.f457670n.f457171q;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (AddCustomizedEffectResponse) r100.f469201a.convertJsonToObj(r101, AddCustomizedEffectResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void k(String r100, String r101, ExceptionResult r102) {
        r102.setTrackParams(r100, this.f457670n.E, r101);
        super.k(r100, r101, r102);
    }

    public a(EffectConfig r100, long r110, String r111, String r112, int r113, String r114, String r115, int r116, String r117, String r118, String r210, Map<String, ? extends Object> r211) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r210, r100.P);
        this.f457670n = r100;
        this.f457671o = r110;
        this.f457672p = r111;
        this.f457673q = r112;
        this.f457674r = r113;
        this.f457675s = r114;
        this.f457676t = r115;
        this.f457677u = r116;
        this.f457678v = r117;
        this.f457679w = r118;
        this.f457680x = r211;
    }
}
