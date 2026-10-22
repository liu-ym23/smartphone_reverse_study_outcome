package z05;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends r35.d {
    public final PluginHost d;
    public final a15.a e;

    public h(PluginHost r2) {
        super(new com.bytedance.ee.bear.route.d[0]);
        this.d = r2;
        if ((r2 instanceof DocumentPluginHost) == false) goto L5;
        int r3 = ((DocumentPluginHost) r2).a().getDocumentTypeValue();
    L6:
        this.e = a15.a.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r3);
        return;
    L5:
        r3 = -1;
        goto L6
    }

    @Override // r35.d
    public final boolean b(Context r3, BearUrl r4, RouteBean r5) {
        if (i.d(r4.e) == true) goto L18;
    L17:
        return false;
    L18:
        boolean r6 = "tasklist".equals(UriProtector.getQueryParameter(UriProtector.parse(r4.e), DocRedirectToDocxPlugin.FROM));     // Catch: Exception -> L7
    L9:
        if (r6 == true) goto L17;
        if ((this.d instanceof DocumentPluginHost) == false) goto L17;
        r4.e = r4.e.replace(DocViewModel.ENTER_CHAR, "");
        String r7 = ((DocumentPluginHost) this.d).a().getUrl();
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (i.d(r7) == false) goto L17;
        this.e.k("from_version_link");
    L7:
        e = move-exception;
        tt5.a.d("EditionUtils", "isFromTaskList err: " + e.getMessage());
        r6 = false;
        goto L9
    }
}
