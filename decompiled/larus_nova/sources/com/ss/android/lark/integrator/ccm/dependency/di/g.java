package com.ss.android.lark.integrator.ccm.dependency.di;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements gwa.g {
    @Override // gwa.g
    public final /* synthetic */ gwa.g.a a() {
        return null;
    }

    @Override // gwa.g
    public final /* synthetic */ boolean isDoubaoEnterpriseUser() {
        return false;
    }

    @Override // gwa.g
    public final /* synthetic */ void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    @Override // gwa.g
    public final String getHost() {
        return "https://www." + ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).getMainDomain();
    }

    @Override // gwa.g
    public final gwa.g.b getSecurityComplianceDependency() {
        return new gwa.f();
    }

    public g() {
    }
}
