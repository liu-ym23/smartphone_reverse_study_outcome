package r35;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.h5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Arrays;
import java.util.HashMap;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends WebViewClient {
    public final DocumentPluginHost a;
    public final boolean b;
    public final boolean c;
    public final a d;

    public class a {
        public long a;
        public String b;
        public final /* synthetic */ e c;

        public a(e r1) {
            this.c = r1;
        }
    }

    public final String a() {
        DocumentPluginHost r0 = this.a;
        if (r0 == null) goto L8;
        DocViewModel r1 = r0.a();
        if (r1 == null) goto L10;
        r1.getDocumentType();
        r1.getOriginBearUrl();
        return mu5.b.e(new na5.b());
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r9, String r10) {
        a r0 = this.d;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        if (TextUtils.equals(r0.b, r10) == true) goto L5;
    L7:
        r0.a = r1;
        r0.b = r10;
        e r2 = r0.c;
        r2.getClass();
        tt5.a.h("DocumentRouterWebViewClient", "overrideUrlLoading:" + du5.b.g(r10));
        FragmentActivity r3 = null;
        if (p.a().u6(r10) == false) goto L22;
        tt5.a.h("DocumentRouterWebViewClient", "dispatchMiaodaAsNormalWeb");
        HashMap r4 = new HashMap();
        String r5 = r2.a();
        if (r5 == null) goto L12;
        r4.put("lk_seclink_params", r5);
    L12:
        DocumentPluginHost r6 = r2.a;
        if (r6 == null) goto L17;
        r3 = r6.getActivity();
    L17:
        if (com.bytedance.ee.util.ui.b.a(r3) == true) goto L20;
        r3 = r9.getContext();
    L20:
        ((com.bytedance.ee.bear.lark.dependency.f) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.f.class)).a(r3, r10, r4);
        return true;
    L22:
        if (p.a().v6(r10) == true) goto L27;
        tt5.a.h("DocumentRouterWebViewClient", "dispatchAsNormalWeb");
        Bundle r11 = new Bundle();
        String r7 = r2.a();
        if (r7 == null) goto L26;
        r11.putString("lk_seclink_params", r7);
    L26:
        RouteBean r8 = new RouteBean();
        r8.n = r11;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r10, r8);
        return true;
    L27:
        tt5.a.h("DocumentRouterWebViewClient", "dispatchDocumentUrl");
        com.bytedance.ee.bear.route.h r12 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        RouteBean r13 = new RouteBean();
        r13.l = r10;
        if (r2.c == false) goto L32;
        Activity r14 = r12.getCurrentActivity();
        if (com.bytedance.ee.util.ui.b.a(r14) == false) goto L32;
        int r16 = lw4.a.g;
        r13.o = com.bytedance.ee.util.ui.a.a(r14);
    L32:
        r13.a(r2.a.c());
        String r17 = ow4.a.a(r10, "tab_link");
        DocViewModel r18 = r2.a.a();
        if (r18 == null) goto L35;
        r3 = r18.getBearUrl();
    L35:
        if (r3 != null) goto L37;
    L41:
        if (r3 != null) goto L43;
    L45:
        BearUrl r19 = p.a().Z(r17);
        if (h5.a(r17, r2.a) == false) goto L49;
        return true;
    L49:
        if (((b0) org.koin.java.a.a(b0.class)).f() == false) goto L58;
        String r110 = UriProtector.parse(r10).getHost();
        int r20 = sbb.e.g(r19.a);
        String r21 = p.t;
        if (TextUtils.isEmpty(r21) == true) goto L58;
        if (r110.endsWith(r21) == true) goto L58;
        if (Arrays.asList(sbb.e.z).contains(Integer.valueOf(r20)) == false) goto L58;
        tt5.a.h("DocumentRouterWebViewClient", "originHost = ".concat(r110));
        r12.m9(r17, r13);
        return true;
    L58:
        if (r2.b == false) goto L60;
        r9.clearHistory();
    L60:
        r12.m9(r17, r13);
        return true;
    L43:
        if (TextUtils.isEmpty(r3.q) == true) goto L45;
        r17 = com.bytedance.ee.util.io.e.a(r17, "scene_id", r3.q);
        goto L45
    L37:
        if (TextUtils.isEmpty(r3.r) == true) goto L41;
        if (TextUtils.equals(r3.r, "301") == false) goto L41;
        r17 = com.bytedance.ee.util.io.e.a(r17, "doc_app_id", r3.r);
        goto L45
    L5:
        if ((r1 - r0.a) >= 500) goto L7;
        tt5.a.k("DebounceShouldOverrideUrlLoading", "So fast click , ignored !");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
        return shouldOverrideUrlLoading(r1, r2.getUrl().toString());
    }

    public e(DocumentPluginHost r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = new a(this);
    }
}
