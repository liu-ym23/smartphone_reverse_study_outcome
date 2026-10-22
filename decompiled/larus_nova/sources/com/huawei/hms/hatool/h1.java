package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class h1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b1> f277352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k0 f277353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t0 f277354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o1 f277355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277357f;

    public h1(String r100) {
        this.f277356e = "";
        this.f277357f = r100;
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        List<b1> r100 = this.f277352a;
        if (r100 != null) goto L5;
    L36:
        String r101 = "Not have actionEvent to send";
    L33:
        v.e("hmsSdk", r101);
        return null;
    L5:
        if (r100.size() == 0) goto L36;
        if (this.f277353b != null) goto L10;
    L35:
        r101 = "model in wrong format";
        goto L33
    L10:
        if (this.f277354c == null) goto L35;
        if (this.f277355d == null) goto L35;
        JSONObject r102 = new JSONObject();
        r102.put("header", this.f277353b.a());
        JSONObject r103 = new JSONObject();
        JSONObject r104 = this.f277355d.a();
        r104.put("properties", this.f277354c.a());
        r104.put("events_global_properties", new JSONObject(this.f277356e));     // Catch: JSONException -> L17
    L18:
        r103.put("events_common", r104);
        JSONArray r105 = new JSONArray();
        Iterator<b1> r106 = this.f277352a.iterator();
    L20:
        if (r106.hasNext() == false) goto L25;
        JSONObject r107 = r106.next().a();
        if (r107 != null) goto L23;
        v.e("hmsSdk", "custom event is empty,delete this event");
        goto L20
    L23:
        r105.put(r107);
        goto L20
    L25:
        r103.put("events", r105);
        String r108 = n.a(k1.a(r103.toString().getBytes("UTF-8")), this.f277357f);     // Catch: UnsupportedEncodingException -> L32
        if (TextUtils.isEmpty(r108) == false) goto L30;
        v.e("hmsSdk", "eventInfo encrypt failed,report over!");     // Catch: UnsupportedEncodingException -> L32
        return null;
    L30:
        r102.put("event", r108);     // Catch: UnsupportedEncodingException -> L32
        return r102;
    L32:
        r101 = "getBitZip(): Unsupported coding : utf-8";
    L17:
        r104.put("events_global_properties", this.f277356e);
        goto L18
    }

    public void a(k0 r100) {
        this.f277353b = r100;
    }

    public void a(l r100) {
        this.f277355d = r100;
    }

    public void a(t0 r100) {
        this.f277354c = r100;
    }

    public void a(String r100) {
        if (r100 == null) goto L5;
        this.f277356e = r100;
        return;
    }

    public void a(List<b1> r100) {
        this.f277352a = r100;
    }
}
