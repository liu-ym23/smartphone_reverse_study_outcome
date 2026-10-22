package com.bytedance.ee.bear.document;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class h6 extends vv4.j implements c4 {
    public String c;
    public vv4.k.b d;

    @Override // vv4.j, vv4.k
    public final void removeJSONParamInterceptor() {
        this.d = null;
    }

    private boolean I() {
        Object r0 = this.a;
        if ((r0 instanceof DocBridgeWebViewV2) == true) goto L5;
        return true;
    L5:
        if (((DocBridgeWebViewV2) r0).M2 == true) goto L7;
        return true;
    L7:
        if (((DocBridgeWebViewV2) r0).M() == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.c4
    public final void H() {
        DocBridgeWebViewV2 r0 = (DocBridgeWebViewV2) this.a;
        tt5.a.h(r0.g1, "removeRenderParams:isTemplate");
        ((HashMap) r0.V2).remove("isTemplate");
    }

    @Override // vv4.j, vv4.k
    public final String getWebViewId() {
        Object r0 = this.a;
        if ((r0 instanceof DocBridgeWebViewV2) == true) goto L5;
        return "";
    L5:
        return ((DocBridgeWebViewV2) r0).getWebViewId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h6(DocBridgeWebViewV2 r2) {
        super(r2, r2.getBridge());
        this.c = "SimpleDocumentWebV2#" + Integer.toHexString(hashCode());
        this.d = null;
    }

    @Override // com.bytedance.ee.bear.document.c4
    public final void A(p35.f r2) {
        ((DocBridgeWebViewV2) this.a).D(r2);
    }

    public void g(p35.f r2) {
        ((DocBridgeWebViewV2) this.a).getClass();
        if (r2 == null) goto L7;
        ((CopyOnWriteArrayList) DocBridgeWebViewV2.v3).remove(r2);
        return;
    }

    @Override // vv4.j, vv4.k
    public final void n(vv4.k.b r1) {
        this.d = r1;
    }

    @Override // com.bytedance.ee.bear.document.c4
    public final void b(String r2, Serializable r3) {
        ((DocBridgeWebViewV2) this.a).E(r2, r3);
    }

    @Override // vv4.j, vv4.k
    public void a(String r2, JSONObject r3, ValueCallback<String> r4) {
        if (I() == false) goto L5;
        this.b.a(r2, r3, r4);
        return;
    L5:
        tt5.a.k(this.c, " execJS DocBridgeWebView is not ready  js : " + mu5.b.c(r2));
    }

    @Override // vv4.j, vv4.k
    public void k(String r2, NonProguard r3, ValueCallback<String> r4) {
        if (I() == false) goto L5;
        super.k(r2, r3, r4);
        return;
    L5:
        tt5.a.k(this.c, " execJS DocBridgeWebView is not ready  js : " + mu5.b.c(r2));
    }

    @Override // vv4.j, vv4.k
    public void l(String r2, org.json.JSONObject r3, ValueCallback<String> r4) {
        if (I() == false) goto L5;
        super.l(r2, r3, r4);
        return;
    L5:
        tt5.a.k(this.c, " execJS DocBridgeWebView is not ready  js : " + mu5.b.c(r2));
    }
}
