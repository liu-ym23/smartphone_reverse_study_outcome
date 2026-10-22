package com.bytedance.interaction.game.base.monitor;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f250884a;

    public c() {
    }

    public final void a(String r100, Object r101) {
        if (r101 == null) goto L15;
    L10:
        e = move-exception;
        int r102 = f96.a.f475971a;
        f96.a.a("interactive_monitor", "ParamsBuilder kv error:" + e.getMessage(), null);
        return;
    L4:
        if (this.f250884a != null) goto L6;
        this.f250884a = new JSONObject();     // Catch: JSONException -> L10
    L6:
        JSONObject r103 = this.f250884a;     // Catch: JSONException -> L10
        if (r103 == null) goto L16;
        r103.put(r100, r101);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }
}
