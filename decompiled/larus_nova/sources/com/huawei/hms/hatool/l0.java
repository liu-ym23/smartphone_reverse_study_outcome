package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<b1> f277395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277396e;

    public l0(String r100, String r101, String r102, List<b1> r103, String r104) {
        this.f277392a = r100;
        this.f277393b = r101;
        this.f277394c = r102;
        this.f277395d = r103;
        this.f277396e = r104;
    }

    private String a(String r100, String r101) {
        String r102 = a1.f(r100, r101);
        if (TextUtils.isEmpty(r102) == false) goto L7;
        v.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", new Object[]{r100, r101});
        return "";
    L7:
        if ("oper".equals(r101) == false) goto L11;
        String r103 = "{url}/common/hmshioperqrt";
    L16:
        return r103.replace("{url}", r102);
    L11:
        if ("maint".equals(r101) == false) goto L14;
        r103 = "{url}/common/hmshimaintqrt";
        goto L16
    L14:
        if ("diffprivacy".equals(r101) == false) goto L17;
        r103 = "{url}/common/common2";
        goto L16
    L17:
        return "";
    }

    private byte[] a(h1 r100) {
        JSONObject r101 = r100.a();     // Catch: UnsupportedEncodingException -> L9 JSONException -> L10
        if (r101 != null) goto L8;
        v.e("hmsSdk", "uploadEvents is null");     // Catch: UnsupportedEncodingException -> L9 JSONException -> L10
        return new byte[0];
    L8:
        return k1.a(r101.toString().getBytes("UTF-8"));
    L9:
        String r102 = "sendData(): getBytes - Unsupported coding format!!";
    L11:
        v.e("hmsSdk", r102);
        return new byte[0];
    L10:
        r102 = "uploadEvents to json error";
        goto L11
    }

    private void b() {
        if (c0.a(q0.i(), "backup_event", 5242880) == false) goto L6;
        v.d("hmsSdk", "backup file reach max limited size, delete it");
        d.a(q0.i(), "backup_event", new String[0]);
        return;
    L6:
        JSONArray r100 = c();
        String r101 = n1.a(this.f277392a, this.f277393b, this.f277396e);
        v.c("hmsSdk", "Update data cached into backup,spKey: " + r101);
        d.b(q0.i(), "backup_event", r101, r100.toString());
    }

    private JSONArray c() {
        JSONArray r100 = new JSONArray();
        Iterator<b1> r101 = this.f277395d.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        r100.put(r101.next().d());
    L8:
        v.c("hmsSdk", "handleEvents: json error,Abandon this data");
        goto L4
    L9:
        return r100;
    }

    private h1 d() {
        return k.a(this.f277395d, this.f277392a, this.f277393b, this.f277396e, this.f277394c);
    }

    public void a() {
        String r100 = a(this.f277392a, this.f277393b);
        if (TextUtils.isEmpty(r100) == false) goto L10;
        if ("preins".equals(this.f277393b) == true) goto L10;
        String r101 = "collectUrl is empty";
    L7:
        v.e("hmsSdk", r101);
        return;
    L10:
        if ("_hms_config_tag".equals(this.f277392a) == false) goto L12;
    L14:
        h1 r102 = d();
        if (r102 == null) goto L20;
        byte[] r103 = a(r102);
        if (r103.length != 0) goto L19;
        r101 = "request body is empty";
        goto L7
    L19:
        g r104 = new f(r103, r100, this.f277392a, this.f277393b, this.f277396e, this.f277395d);
        b0 r105 = b0.b();
    L21:
        r105.a(r104);
        return;
    L20:
        r104 = new d1(this.f277395d, this.f277392a, this.f277396e, this.f277393b);
        r105 = b0.c();
        goto L21
    L12:
        if ("_openness_config_tag".equals(this.f277392a) == true) goto L14;
        b();
        goto L14
    }
}
