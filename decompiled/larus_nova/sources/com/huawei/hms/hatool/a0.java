package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class a0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f277286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f277291h;

    public a0(String r100, JSONObject r101, String r102, String r103, long r104) {
        this.f277284a = q0.i();
        this.f277285b = r100;
        this.f277286c = r101;
        this.f277287d = r102;
        this.f277288e = r103;
        this.f277289f = String.valueOf(r104);
        if (z.i(r102, "oper") == false) goto L6;
        p0 r105 = y.a().a(r102, r104);
        this.f277290g = r105.a();
        this.f277291h = Boolean.valueOf(r105.b());
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        v.a("hmsSdk", "Begin to run EventRecordTask...");
        int r100 = q0.h();
        int r101 = a1.k(this.f277287d, this.f277288e);
        if (c0.a(this.f277284a, "stat_v2_1", r100 * 1048576) == false) goto L6;
        v.c("hmsSdk", "stat sp file reach max limited size, delete it");
        d.a(this.f277284a, "stat_v2_1", new String[0]);
        return;
    L6:
        b1 r102 = new b1();
        r102.b(this.f277285b);
        r102.a(this.f277286c.toString());
        r102.d(this.f277288e);
        r102.c(this.f277289f);
        r102.f(this.f277290g);
        Boolean r103 = this.f277291h;
        if (r103 != null) goto L9;
        String r104 = null;
    L10:
        r102.e(r104);
        JSONObject r105 = r102.d();     // Catch: JSONException -> L23
        String r106 = n1.a(this.f277287d, this.f277288e);
        String r107 = d.a(this.f277284a, "stat_v2_1", r106, "");
    L18:
        v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
        JSONArray r108 = new JSONArray();
    L19:
        r108.put(r105);
        d.b(this.f277284a, "stat_v2_1", r106, r108.toString());
        if (r108.toString().length() <= (r101 * 1024)) goto L30;
        e.a().a(this.f277287d, this.f277288e);
        return;
    L30:
        return;
    L14:
        if (TextUtils.isEmpty(r107) == true) goto L16;
        r108 = new JSONArray(r107);     // Catch: JSONException -> L18
    L27:
        goto L19
    L16:
        r108 = new JSONArray();     // Catch: JSONException -> L18
    L23:
        v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        return;
    L9:
        r104 = String.valueOf(r103);
        goto L10
    }
}
