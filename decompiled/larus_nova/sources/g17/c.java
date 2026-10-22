package g17;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.glue.IWebViewExtension;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WeakHashMap<Object, IWebViewExtension.TTSafeBrowsingListener> f479616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f479617b;

    public c() {
    }

    public static boolean a(WebView r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        if (TTWebSdk.isTTWebView(r100) == false) goto L8;
        return false;
    L8:
        IWebViewExtension.TTSafeBrowsingListener r102 = f479616a.get(r100);
        if (r102 != null) goto L12;
        return false;
    L12:
        return !r102.shouldSkipCheck(r100, r101);
    }
}
