package com.bytedance.ug.sdk.luckydog.task.pendant;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f272200a = 0;

    static {
    }

    public static void a(dl7.f r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L15;
    L11:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_time_pendant_show", r101);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        JSONObject r102 = r101.put("activity_name", r100.f469137c);     // Catch: JSONException -> L7
        if (r100.a() < r100.o()) goto L9;
        String r103 = "done";
    L10:
        r102.put("status", r103).put("cross_domain_id", r100.f());     // Catch: JSONException -> L7
        goto L11
    L9:
        r103 = "not_done";
        goto L10
    }

    public static void b(dl7.f r100, String r101) {
        JSONObject r102 = new JSONObject();
        if (r100 != null) goto L10;
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_time_pendant_complete_jump", r102);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        r102.put("cross_token", r100.f469136b).put("status", r101).put("cross_domain_id", r100.f());     // Catch: JSONException -> L7
        goto L5
    }
}
