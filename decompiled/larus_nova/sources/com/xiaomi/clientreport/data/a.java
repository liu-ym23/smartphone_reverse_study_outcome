package com.xiaomi.clientreport.data;

import com.heytap.mcssdk.constant.b;
import com.xiaomi.push.bk;
import com.xiaomi.push.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class a {
    public String clientInterfaceId;
    private String miuiVersion;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    private String f463013os;
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("production", this.production);     // Catch: JSONException -> L5
        r100.put("reportType", this.reportType);     // Catch: JSONException -> L5
        r100.put("clientInterfaceId", this.clientInterfaceId);     // Catch: JSONException -> L5
        r100.put("os", this.f463013os);     // Catch: JSONException -> L5
        r100.put("miuiVersion", this.miuiVersion);     // Catch: JSONException -> L5
        r100.put("pkgName", this.pkgName);     // Catch: JSONException -> L5
        r100.put(b.C, this.sdkVersion);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return null;
    }

    public a() {
        this.f463013os = bk.a();
        this.miuiVersion = j.m9291a();
    }

    public String toJsonString() {
        JSONObject r100 = toJson();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toString();
    }

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String r100) {
        this.pkgName = r100;
    }

    public void setSdkVersion(String r100) {
        this.sdkVersion = r100;
    }
}
