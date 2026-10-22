package com.cmic.ida.sdk;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f273254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f273256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f273259f;

    public JSONObject a() {
        String r100 = this.f273256c.optString("expandParams");     // Catch: Exception -> L8
        String r101 = "apppackage=" + this.f273258e + "|appsign=" + this.f273259f;     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r101 = r100 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101;     // Catch: Exception -> L8
    L6:
        this.f273256c.put("expandParams", r101);     // Catch: Exception -> L8
    L10:
        JSONObject r102 = this.f273256c;
        if (r102 == null) goto L13;
        return r102;
    L13:
        return new JSONObject();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public JSONObject b() {
        return this.f273254a;
    }

    public String c() {
        return this.f273257d;
    }

    public String d() {
        return this.f273255b;
    }

    public void a(String r100) {
        this.f273259f = r100;
    }

    public void b(String r100) {
        this.f273257d = r100;
    }

    public void c(String r100) {
        this.f273258e = r100;
    }

    public void d(String r100) {
        this.f273255b = r100;
    }

    public v0(String r100, String r101, JSONObject r102, JSONObject r103) {
        this.f273255b = r100;
        this.f273257d = r101;
        this.f273254a = r102;
        this.f273256c = r103;
    }
}
