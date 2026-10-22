package jr7;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.webx.seclink.webview.SecWebWebview;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SecWebWebview f500138a;

    public a(SecWebWebview r100) {
        this.f500138a = r100;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        SecWebWebview r102 = this.f500138a;
        if (r102.f272651a == null) goto L7;
        r102.getClass();
        this.f500138a.f272651a.a(r101);
        return false;
    L7:
        return false;
    }
}
