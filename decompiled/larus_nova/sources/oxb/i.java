package oxb;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes37.dex */
public interface i extends j {
    void A(WebResourceRequest r100);

    WebResourceResponse k(WebView r100, String r101);

    boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101);

    boolean shouldOverrideUrlLoading(WebView r100, String r101);

    void z(String r100);
}
