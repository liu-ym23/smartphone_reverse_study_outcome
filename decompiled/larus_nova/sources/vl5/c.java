package vl5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f555676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f555677c;

    public c() {
        this.f555676b = "";
        this.f555677c = false;
    }

    @Override // vl5.i, onb.b
    public final String a() {
        return this.f555676b;
    }

    @Override // vl5.i, onb.b
    public final void b(String r100) {
        this.f555679a = r100;
        JSONObject r101 = JSON.parseObject(r100);     // Catch: Exception -> L12
        if (r101 != null) goto L6;
    L18:
    L15:
        if (this.f555676b != null) goto L21;
        this.f555676b = "";
        return;
    L21:
        return;
    L6:
        if (r101.containsKey("apiName") == false) goto L8;
        this.f555677c = true;     // Catch: Exception -> L12
        goto L18
    L8:
        JSONObject r102 = r101.getJSONObject("data").getJSONObject("header");     // Catch: Exception -> L12
        if (r102 == null) goto L18;
        this.f555676b = r102.getString("requestId");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("JSDocResponse", "parseJson exception", e, false);
        goto L15
    }
}
