package j35;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public c a;
    public final DocBridgeWebViewV2 b;

    public final h a() {
        if (this.a != null) goto L10;
        DocBridgeWebViewV2 r0 = this.b;
        if (((Boolean) new ml5.b("debug_config").a("resourceIntercept", Boolean.TRUE)).booleanValue() == true) goto L7;
        c r1 = new f(r0);
    L8:
        this.a = r1;
        goto L10
    L7:
        tt5.a.b("PreloaderFactory", "creatPreloader: use offline.");
        r1 = new k(r0);
    L10:
        return this.a;
    }

    public g(DocBridgeWebViewV2 r1) {
        this.b = r1;
    }
}
