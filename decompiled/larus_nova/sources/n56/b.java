package n56;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes19.dex */
public class b extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f518028a;

    public b() {
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        super.onLoadResource(r100, r101);
        a r102 = this.f518028a;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        a r102 = this.f518028a;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.b(r101) == false) goto L7;
        return true;
    }
}
