package n45;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ee.bear.contract.b0;
import com.ss.android.lark.officewebview.util.j;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebSettings f517053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f517054b;

    public final void a(WebView r100) {
        this.f517053a.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        this.f517053a.setLoadWithOverviewMode(true);
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        this.f517053a.setUseWideViewPort(true);
        this.f517053a.setSupportZoom(true);
        this.f517053a.setJavaScriptEnabled(true);
        this.f517053a.setDomStorageEnabled(true);
        this.f517053a.setSupportMultipleWindows(true);
        this.f517053a.setJavaScriptCanOpenWindowsAutomatically(true);
        this.f517053a.setCacheMode(-1);
        this.f517053a.setAllowFileAccess(true);
        this.f517053a.setDatabaseEnabled(true);
        b(r100);
        CookieManager.getInstance().setAcceptThirdPartyCookies(r100, true);
        this.f517053a.setMixedContentMode(2);
    }

    public final void b(WebView r100) {
        int r101 = j.f437550a;
        String r102 = j.a(r100.getContext());
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L5:
        this.f517053a.setUserAgentString(r102 + " " + this.f517054b.h() + " Bytedance Docs/" + this.f517054b.getVersionName() + " Type/Default " + this.f517054b.m());
        StringBuilder r103 = new StringBuilder("initSettings: ua=");
        r103.append(this.f517053a.getUserAgentString());
        tt5.a.h("DocWebSettings", r103.toString());
    }

    public c(WebSettings r100, b0 r101) {
        this.f517053a = r100;
        this.f517054b = r101;
    }
}
