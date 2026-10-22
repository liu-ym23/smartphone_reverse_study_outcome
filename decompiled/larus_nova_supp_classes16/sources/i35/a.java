package i35;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.k5;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import du5.b;
import java.util.Arrays;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends WebViewClient {
    public final ChameleonPluginHost a;
    public final boolean b;
    public final boolean c;
    public final C0238a d;

    /* JADX INFO: renamed from: i35.a$a, reason: collision with other inner class name */
    public class C0238a {
        public long a;
        public String b;
        public final /* synthetic */ a c;

        public C0238a(a r1) {
            this.c = r1;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r9, String r10) {
        C0238a r0 = this.d;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        if (TextUtils.equals(r0.b, r10) == true) goto L5;
    L7:
        r0.a = r1;
        r0.b = r10;
        a r2 = r0.c;
        r2.getClass();
        tt5.a.h("DocumentRouterWebViewClient", "overrideUrlLoading:" + b.g(r10));
        if (p.a().v6(r10) == true) goto L15;
        tt5.a.h("DocumentRouterWebViewClient", "dispatchAsNormalWeb");
        Bundle r11 = new Bundle();
        ChameleonPluginHost r3 = r2.a;
        if (r3 == null) goto L14;
        y3 r4 = ((e4) r3.getHostAbility(e4.class)).getDocumentMetadata();
        if (r4 == null) goto L14;
        r4.getDocumentType();
        r4.getOriginBearUrl();
        r11.putString("lk_seclink_params", mu5.b.e(new na5.b()));
    L14:
        RouteBean r5 = new RouteBean();
        r5.n = r11;
        ((h) org.koin.java.a.a(h.class)).m9(r10, r5);
        return true;
    L15:
        tt5.a.h("DocumentRouterWebViewClient", "dispatchDocumentUrl");
        h r6 = (h) org.koin.java.a.a(h.class);
        RouteBean r7 = new RouteBean();
        r7.l = r10;
        if (r2.c == false) goto L20;
        Activity r8 = r6.getCurrentActivity();
        if (com.bytedance.ee.util.ui.b.a(r8) == false) goto L20;
        r7.o = com.bytedance.ee.util.ui.a.a(r8);
    L20:
        r7.a(r2.a.getFragment());
        String r12 = ow4.a.a(r10, "tab_link");
        y3 r13 = ((e4) r2.a.getHostAbility(e4.class)).getDocumentMetadata();
        if (r13 == null) goto L23;
        BearUrl r14 = r13.getBearUrl();
    L24:
        if (r14 != null) goto L26;
    L30:
        if (r14 != null) goto L32;
    L34:
        BearUrl r16 = p.a().Z(r12);
        if (k5.a(r12, r2.a) == false) goto L38;
        return true;
    L38:
        if (((b0) org.koin.java.a.a(b0.class)).f() == false) goto L47;
        String r17 = UriProtector.parse(r10).getHost();
        int r18 = e.g(r16.a);
        String r19 = p.t;
        if (TextUtils.isEmpty(r19) == true) goto L47;
        if (r17.endsWith(r19) == true) goto L47;
        if (Arrays.asList(e.z).contains(Integer.valueOf(r18)) == false) goto L47;
        tt5.a.h("DocumentRouterWebViewClient", "originHost = ".concat(r17));
        r6.m9(r12, r7);
        return true;
    L47:
        if (r2.b == false) goto L49;
        r9.clearHistory();
    L49:
        r6.m9(r12, r7);
        return true;
    L32:
        if (TextUtils.isEmpty(r14.q) == true) goto L34;
        r12 = com.bytedance.ee.util.io.e.a(r12, "scene_id", r14.q);
        goto L34
    L26:
        if (TextUtils.isEmpty(r14.r) == true) goto L30;
        if (TextUtils.equals(r14.r, "301") == false) goto L30;
        r12 = com.bytedance.ee.util.io.e.a(r12, "doc_app_id", r14.r);
        goto L34
    L23:
        r14 = null;
        goto L24
    L5:
        if ((r1 - r0.a) >= 500) goto L7;
        tt5.a.k("DebounceShouldOverrideUrlLoading", "So fast click , ignored !");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
        return shouldOverrideUrlLoading(r1, r2.getUrl().toString());
    }

    public a(ChameleonPluginHost r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = new C0238a(this);
    }
}
