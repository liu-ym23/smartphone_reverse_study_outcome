package com.bytedance.sdk.open.douyin.settings;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f269709f = "SettingsModel";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f269710g = "vid_info";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f269711h = "settings_json";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f269712i = "ctx_info";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f269713j = "update_time";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f269714k = "settings_time";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f269715l = 86400000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f269716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f269717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f269718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f269719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f269720e;

    public f(long r100, String r101, JSONObject r102, JSONObject r103, long r104) {
        this.f269716a = r100;
        this.f269717b = r101;
        this.f269718c = r102;
        this.f269719d = r103;
        this.f269720e = r104;
    }

    public static f a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L20;
        return null;
    L20:
        JSONObject r100 = new JSONObject(r110);     // Catch: Exception -> L17
        long r101 = r100.optLong("update_time");     // Catch: Exception -> L17
        JSONObject r111 = r100.optJSONObject(f269710g);     // Catch: Exception -> L17
        if (r111 != null) goto L8;
        r111 = new JSONObject();     // Catch: Exception -> L17
    L8:
        JSONObject r102 = r111;
        String r112 = r100.optString(f269712i);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r112) == false) goto L11;
        String r103 = null;
    L12:
        long r104 = r100.optLong("settings_time");     // Catch: Exception -> L17
        JSONObject r113 = r100.optJSONObject(f269711h);     // Catch: Exception -> L17
        if (r113 != null) goto L15;
        r113 = new JSONObject();     // Catch: Exception -> L17
    L15:
        return new f(r101, r103, r113, r102, r104);
    L11:
        r103 = r112;
    L17:
        e = move-exception;
        LogUtils.w(f269709f, new Object[]{e.getMessage()});
        return null;
    }

    public String a() {
        return this.f269717b;
    }

    public long b() {
        return this.f269716a;
    }

    public JSONObject c() {
        return this.f269718c;
    }

    public long d() {
        return this.f269720e;
    }

    public JSONObject e() {
        return this.f269719d;
    }

    public boolean f() {
        if (this.f269716a != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f269720e == 0) goto L7;
        return true;
    }

    public JSONObject g() {
        JSONObject r100 = new JSONObject();
        r100.put("update_time", this.f269716a);     // Catch: JSONException -> L13
        r100.put(f269710g, this.f269719d);     // Catch: JSONException -> L13
        r100.put(f269712i, this.f269717b);     // Catch: JSONException -> L13
        r100.put("settings_time", this.f269720e);     // Catch: JSONException -> L13
        r100.put(f269711h, this.f269718c);     // Catch: JSONException -> L13
    L15:
        return r100;
    L13:
        e = move-exception;
        LogUtils.w(f269709f, new Object[]{"toJson", e});
        goto L15
    }
}
