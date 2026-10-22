package com.bytedance.sdk.account.settings.common;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f269422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f269423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f269424c;

    public static void a() {
        JSONObject r100 = a.b();
        if (r100 == null) goto L5;
        JSONObject r101 = r100.optJSONObject("xtoken_safe_use_config");
    L7:
        if (f269422a == r101) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L16;
        f269422a = r101;
        tb7.a.a("TokenUseSettingsManager", "settings=" + f269422a);
        JSONObject r103 = f269422a;
        if (r103 == null) goto L14;
        f269423b = r103.optBoolean("enable_http_forbid", false);
        f269424c = f269422a.optBoolean("enable_http_request_track", false);
        return;
    L14:
        f269423b = false;
        f269424c = false;
        return;
    L16:
        return;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = null;
        goto L7
    }
}
