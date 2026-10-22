package com.ss.android.common.applog;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class y implements com.bytedance.applog.log.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f408239a;

    @Override // com.bytedance.applog.log.g.b
    public final Object fetch() {
        JSONObject r100 = new JSONObject();
        nx3.f.b(this.f408239a, r100);
        r100.put("appId", String.valueOf(jta.g.c()));     // Catch: Throwable -> L5
    L4:
        return r100;
    }

    public y(JSONObject r100) {
        this.f408239a = r100;
    }
}
