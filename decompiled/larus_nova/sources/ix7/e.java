package ix7;

import android.net.http.SslError;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes23.dex */
public interface e {
    void a(int r100, String r101, String r102);

    void b(SslError r100);

    lx7.b c(lx7.b r100);

    boolean d(com.ivy.ivykit.plugin.impl.web.b r100);

    void e(View r100);

    void f();

    boolean g(WebView r100, ValueCallback r101);

    void h(String r100, int r101, String r102);

    void i(WebView r100, int r101);

    boolean j(WebView r100, com.ivy.ivykit.plugin.impl.web.c r101);

    void k(WebResourceRequest r100, WebResourceError r101);

    void onPageFinished(WebView r100, String r101);

    void onPageStarted(String r100);

    void onReceivedTitle(WebView r100, String r101);

    boolean shouldOverrideUrlLoading(WebView r100, String r101);
}
