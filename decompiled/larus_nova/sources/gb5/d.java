package gb5;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.imageviewer.view.DiagramWebView;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f480727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiagramWebView f480728b;

    public d(DiagramWebView r100, String r101) {
        this.f480728b = r100;
        this.f480727a = r101;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        final DiagramWebView r102 = this.f480728b;
        String r103 = this.f480727a;
        int r104 = DiagramWebView.f227033e;
        r102.getClass();
        final JSONObject r105 = new JSONObject();
        r105.put2("svgString", r103);
        j.c(new a(r102, r105));
    }
}
