package com.bytedance.crash.upload;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f203361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f203362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f203363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f203364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f203365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f203366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f203367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f203368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f203369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f203370j;

    public final String toString() {
        return "[" + this.f203361a + " " + this.f203365e + " " + this.f203366f + " " + this.f203367g + " " + this.f203368h + "]";
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        this.f203370j.put("aid", this.f203362b);     // Catch: Throwable -> L12
        this.f203370j.put("path", this.f203363c);     // Catch: Throwable -> L12
        this.f203370j.put("update_time", this.f203364d);     // Catch: Throwable -> L12
        JSONObject r101 = this.f203370j;     // Catch: Throwable -> L9
        if (com.bytedance.crash.util.c.f203410d != null) goto L7;
        com.bytedance.crash.util.c.f203410d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());     // Catch: Throwable -> L9
    L7:
        r101.put("update_time_format", com.bytedance.crash.util.c.f203410d.format(new Date(this.f203364d)));     // Catch: Throwable -> L9
    L10:
        this.f203370j.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, this.f203365e);     // Catch: Throwable -> L12
        this.f203370j.put("alog_strategy", this.f203366f);     // Catch: Throwable -> L12
        this.f203370j.put("retreatCount", this.f203367g);     // Catch: Throwable -> L12
        this.f203370j.put("redirect", this.f203369i);     // Catch: Throwable -> L12
        r100.put(this.f203361a, this.f203370j);     // Catch: Throwable -> L12
        goto L11
    L9:
        this.f203370j.put("update_time_format", "");     // Catch: Throwable -> L12
    L11:
        return r100;
    }

    public h(JSONObject r100) throws JSONException {
        if (r100 == null) goto L7;
        String r101 = r100.optString("aid");
        this.f203362b = r101;
        String r102 = r100.optString("path");
        this.f203363c = r102;
        this.f203365e = r100.optInt(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f203366f = r100.optInt("alog_strategy");
        this.f203364d = r100.optLong("update_time");
        r100.optString("update_time_format");
        this.f203367g = r100.optInt("retreatCount");
        this.f203369i = r100.optString("redirect");
        this.f203370j = new JSONObject(r100.toString());
        this.f203361a = i.f(r101, r102);
        return;
    L7:
        throw new IllegalArgumentException("json can't be null");
    }

    public h(String r100, String r101) {
        this.f203362b = r100;
        this.f203363c = r101;
        this.f203365e = 0;
        this.f203366f = 0;
        this.f203364d = 0;
        this.f203367g = 0;
        this.f203368h = 0;
        this.f203369i = "";
        JSONObject r102 = new JSONObject();
        this.f203370j = r102;
        this.f203361a = i.f(r100, r101);
        r102.put("aid", r100);     // Catch: Throwable -> L5
        r102.put("path", r101);     // Catch: Throwable -> L5
        return;
    }
}
