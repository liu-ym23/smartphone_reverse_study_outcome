package ak5;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.ttnet.TTNetInit;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements jr5.a, rr5.a {
    public Application a;
    public com.bytedance.ee.bear.contract.d b;
    public com.bytedance.ee.bear.drive.sdk.service.f c;
    public b0 d;
    public com.bytedance.ee.bear.contract.f e;
    public i0 f;

    public g() {
    }

    public final void a(long r9, kr5.a r11, int r12, Throwable r13) {
        if (this.b != null) goto L5;
        this.b = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
    L5:
        com.bytedance.ee.bear.contract.d r3 = this.b;
        if (this.d != null) goto L8;
        this.d = (b0) org.koin.java.a.a(b0.class);
    L8:
        b0 r4 = this.d;
        HashMap r5 = new HashMap();
        r5.put("cost_time", Long.valueOf(r9));     // Catch: Throwable -> L36
        r5.put("docs_net_dnsInterval", Integer.valueOf(r11.a));     // Catch: Throwable -> L36
        r5.put("docs_net_tlsInterval", Integer.valueOf(r11.c));     // Catch: Throwable -> L36
        r5.put("docs_net_connectionEstablishInterval", Integer.valueOf(r11.b));     // Catch: Throwable -> L36
        r5.put("http_protocol", r11.d);     // Catch: Throwable -> L36
        r5.put("version_type", r4.e());     // Catch: Throwable -> L36
        r5.put("http_channel", r11.f);     // Catch: Throwable -> L36
        r5.put("http_request_tag", r11.j);     // Catch: Throwable -> L36
        r5.put(ResourceData.KEY_URL, yu5.c.e(r11.e));     // Catch: Throwable -> L36
        r5.put("http_request_method", r11.i);     // Catch: Throwable -> L36
        r5.put("response_length", Long.valueOf(r11.l));     // Catch: Throwable -> L36
        if (r11.k == false) goto L12;
        int r10 = 1;
    L13:
        r5.put("doc_use_multi_connection", Integer.valueOf(r10));     // Catch: Throwable -> L36
        r5.put("server-timing", r11.m);     // Catch: Throwable -> L36
        r5.put("docs_request_id", r11.g);     // Catch: Throwable -> L36
        r5.put("rust_cookie", Boolean.TRUE);     // Catch: Throwable -> L36
        if (r12 != 0) goto L17;
        r5.put("code", Integer.valueOf(r12));     // Catch: Throwable -> L36
    L28:
        r5.put("docs_request_id", r11.g);     // Catch: Throwable -> L36
        if (this.e != null) goto L31;
        this.e = (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class);     // Catch: Throwable -> L36
    L31:
        r5.put("app_visible", String.valueOf(this.e.a()));     // Catch: Throwable -> L36
        r5.put("doc_network_status", Integer.valueOf(fw4.d.a().ordinal()));     // Catch: Throwable -> L36
        if (this.c != null) goto L34;
        this.c = (com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class);     // Catch: Throwable -> L36
    L34:
        r5.put("doc_network_level", Integer.valueOf(this.c.d0().p().getValue()));     // Catch: Throwable -> L36
        r5.put("network_quality_type", Integer.valueOf(TTNetInit.getEffectiveConnectionType()));     // Catch: Throwable -> L36
        r3.b("dev_performance_native_network_request", r5, false);     // Catch: Throwable -> L36
        tt5.a.k("HttpConfig", "onApi report  map:  " + du5.b.k(r5.toString()));     // Catch: Throwable -> L36
        return;
    L17:
        if ((r13 instanceof RustIOException) == false) goto L19;
        r5.put("code", Integer.valueOf(((RustIOException) r13).getRustSdkErrorCode()));     // Catch: Throwable -> L36
    L20:
        String r14 = "";
        if (r13 == null) goto L26;
        String r15 = r13.getMessage();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r14 = r15;
    L25:
        r5.put("errorMsg", r14);     // Catch: Throwable -> L36
        goto L28
    L26:
        r5.put("errorMsg", "");     // Catch: Throwable -> L36
        goto L28
    L19:
        r5.put("code", Integer.valueOf(ax4.c.a(r13)));     // Catch: Throwable -> L36
        goto L20
    L12:
        r10 = 0;
    L36:
        th = move-exception;
        tt5.a.l("HttpConfig", "onApi report err : ", th);
    }
}
