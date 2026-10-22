package n45;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ee.bear.contract.b0;
import com.ss.android.lark.officewebview.util.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final WebSettings a;
    public final b0 b;

    public final void a(WebView r4) {
        this.a.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        this.a.setLoadWithOverviewMode(true);
        int r0 = com.larksuite.framework.utils.autoscale.a.a;
        this.a.setUseWideViewPort(true);
        this.a.setSupportZoom(true);
        this.a.setJavaScriptEnabled(true);
        this.a.setDomStorageEnabled(true);
        this.a.setSupportMultipleWindows(true);
        this.a.setJavaScriptCanOpenWindowsAutomatically(true);
        this.a.setCacheMode(-1);
        this.a.setAllowFileAccess(true);
        this.a.setDatabaseEnabled(true);
        b(r4);
        CookieManager.getInstance().setAcceptThirdPartyCookies(r4, true);
        this.a.setMixedContentMode(2);
    }

    public final void b(WebView r3) {
        int r0 = j.a;
        String r4 = j.a(r3.getContext());
        if (TextUtils.isEmpty(r4) == false) goto L5;
        r4 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L5:
        this.a.setUserAgentString(r4 + " " + this.b.h() + " Bytedance Docs/" + this.b.getVersionName() + " Type/Default " + this.b.m());
        StringBuilder r5 = new StringBuilder("initSettings: ua=");
        r5.append(this.a.getUserAgentString());
        tt5.a.h("DocWebSettings", r5.toString());
    }

    public c(WebSettings r1, b0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
