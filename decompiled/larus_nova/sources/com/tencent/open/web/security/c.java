package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.c.d;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class c extends com.tencent.open.b.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f461881d;

    @Override // com.tencent.open.b.a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    private void b(String r100) {
        WebView r101 = this.f461703a.get();
        if (r101 == null) goto L6;
        StringBuffer r102 = new StringBuffer("javascript:if(!!");
        r102.append(this.f461881d);
        r102.append("){");
        r102.append(this.f461881d);
        r102.append("(");
        r102.append(r100);
        r102.append(")}");
        String r103 = r102.toString();
        SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + r103);
        r101.loadUrl(r103);
        return;
    }

    @Override // com.tencent.open.b.a
    public void a(String r100) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + r100);
        JSONObject r101 = new JSONObject();
        if (d.f461748a == true) goto L5;
        int r102 = -4;
    L12:
        r101.put("result", r102);     // Catch: JSONException -> L8
        r101.put("sn", this.f461704b);     // Catch: JSONException -> L8
        r101.put("data", r100);     // Catch: JSONException -> L8
    L10:
        b(r101.toString());
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L5:
        r102 = 0;
        goto L12
    }

    @Override // com.tencent.open.b.a
    public void a(Object r100) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + r100);
    }

    public c(WebView r100, long r101, String r102, String r103) {
        super(r100, r101, r102);
        this.f461881d = r103;
    }
}
