package ed4;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes15.dex */
public interface l {
    void onLoadFail(String r100, WebView r101, Throwable r102);

    void onLoadStart(String r100, WebView r101);

    void onLoadUriSuccess(String r100, WebView r101);

    void onRuntimeReady(String r100, WebView r101);

    void onViewDestroy(String r100, WebView r101, Throwable r102);
}
