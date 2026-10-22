package com.bytedance.sdk.account.impl;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class w extends sa7.h<xa7.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f269140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xa7.f f269141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sa7.h f269142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f269143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ cra.a f269144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Map f269145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p f269146g;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.h r101 = (xa7.h) r100;
        tb7.a.a("BDAccountPlatformImpl", "getOauthTokenInner: onSuccess: openTokenInfo 成功");
        JSONObject r102 = new JSONObject(this.f269140a);
        r102.put("status", "success");     // Catch: JSONException -> L6
    L4:
        com.bytedance.sdk.account.monitor.a.a("passport_token_info_request_response", r102);
        xa7.f r103 = this.f269141b;
        r103.B = 1;
        r103.C = "success";
        this.f269142c.onSuccess(r103);
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.h r102 = (xa7.h) r100;
        tb7.a.a("BDAccountPlatformImpl", "getOauthTokenInner: onError: openTokenInfo 失败, getOauthToken 进行网络请求");
        rb7.f.p(this.f269146g.f269109a, this.f269143d, this.f269144e.f465119a, this.f269145f, new v(this)).m();
        JSONObject r103 = new JSONObject(this.f269140a);
        r103.put("status", "fail");     // Catch: JSONException -> L6
        r103.put("error_code", r101);     // Catch: JSONException -> L6
        r103.put("fail_info", r102.f549255i);     // Catch: JSONException -> L6
    L4:
        com.bytedance.sdk.account.monitor.a.a("passport_token_info_request_response", r103);
    }

    public w(p r100, Map r101, xa7.f r102, r r103, String r104, cra.a r105, Map r106) {
        this.f269146g = r100;
        this.f269140a = r101;
        this.f269141b = r102;
        this.f269142c = r103;
        this.f269143d = r104;
        this.f269144e = r105;
        this.f269145f = r106;
    }
}
