package com.cmic.sso.sdk.c.b;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class h extends a {
    protected String A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected String f273429z;

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("ver", this.f273376a);     // Catch: JSONException -> L5
        r100.put("sdkver", this.f273377b);     // Catch: JSONException -> L5
        r100.put("appid", this.f273378c);     // Catch: JSONException -> L5
        r100.put("imsi", this.f273379d);     // Catch: JSONException -> L5
        r100.put(OnekeyLoginConstants.OPERATOR_TYPE, this.f273380e);     // Catch: JSONException -> L5
        r100.put("networktype", this.f273381f);     // Catch: JSONException -> L5
        r100.put("mobilebrand", this.f273382g);     // Catch: JSONException -> L5
        r100.put("mobilemodel", this.f273383h);     // Catch: JSONException -> L5
        r100.put("mobilesystem", this.f273384i);     // Catch: JSONException -> L5
        r100.put("clienttype", this.f273385j);     // Catch: JSONException -> L5
        r100.put("interfacever", this.f273386k);     // Catch: JSONException -> L5
        r100.put("expandparams", this.f273387l);     // Catch: JSONException -> L5
        r100.put("msgid", this.f273388m);     // Catch: JSONException -> L5
        r100.put("timestamp", this.f273389n);     // Catch: JSONException -> L5
        r100.put("subimsi", this.f273390o);     // Catch: JSONException -> L5
        r100.put("sign", this.f273391p);     // Catch: JSONException -> L5
        r100.put("apppackage", this.f273392q);     // Catch: JSONException -> L5
        r100.put("appsign", this.f273393r);     // Catch: JSONException -> L5
        r100.put("ipv4_list", this.f273394s);     // Catch: JSONException -> L5
        r100.put("ipv6_list", this.f273395t);     // Catch: JSONException -> L5
        r100.put("sdkType", this.f273396u);     // Catch: JSONException -> L5
        r100.put("tempPDR", this.f273397v);     // Catch: JSONException -> L5
        r100.put("scrip", this.f273429z);     // Catch: JSONException -> L5
        r100.put("userCapaid", this.A);     // Catch: JSONException -> L5
        r100.put("funcType", this.f273398w);     // Catch: JSONException -> L5
        r100.put("socketip", this.f273399x);     // Catch: JSONException -> L5
        r100.put("simOperator", this.f273400y);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return this.f273376a + "&" + this.f273377b + "&" + this.f273378c + "&" + this.f273379d + "&" + this.f273380e + "&" + this.f273381f + "&" + this.f273382g + "&" + this.f273383h + "&" + this.f273384i + "&" + this.f273385j + "&" + this.f273386k + "&" + this.f273387l + "&" + this.f273388m + "&" + this.f273389n + "&" + this.f273390o + "&" + this.f273391p + "&" + this.f273392q + "&" + this.f273393r + "&&" + this.f273394s + "&" + this.f273395t + "&" + this.f273396u + "&" + this.f273397v + "&" + this.f273429z + "&" + this.A + "&" + this.f273398w + "&" + this.f273399x + "&" + this.f273400y;
    }

    public h() {
        this.f273429z = "";
        this.A = "";
    }

    @Override // com.cmic.sso.sdk.c.b.a
    public void a(String r100) {
        this.f273397v = t(r100);
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String r100) {
        return this.f273377b + this.f273378c + this.f273379d + this.f273380e + this.f273381f + this.f273382g + this.f273383h + this.f273384i + this.f273385j + this.f273388m + this.f273389n + r100 + this.f273390o + this.f273392q + this.f273393r + this.f273394s + this.f273395t + this.f273396u + this.f273397v + this.f273429z + this.A + this.f273398w + this.f273399x;
    }

    public void x(String r100) {
        this.f273429z = t(r100);
    }

    public void y(String r100) {
        this.A = t(r100);
    }
}
