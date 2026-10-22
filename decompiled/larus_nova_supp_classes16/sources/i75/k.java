package i75;

import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public static void a(WebView r3) {
        r3.getSettings().setDefaultTextEncodingName("utf-8");
        r3.getSettings().setJavaScriptEnabled(true);
        r3.getSettings().setSupportZoom(true);
        r3.getSettings().setBuiltInZoomControls(true);
        r3.getSettings().setDisplayZoomControls(false);
        r3.getSettings().setLoadWithOverviewMode(true);
        r3.setScrollBarStyle(0);
        r3.setHorizontalScrollbarOverlay(true);
        r3.setVerticalScrollbarOverlay(true);
        r3.setVerticalScrollBarEnabled(true);
        r3.setHorizontalScrollBarEnabled(true);
    }
}
