package i75;

import android.webkit.WebView;
import com.byted.cast.linkcommon.cybergarage.xml.XML;

/* JADX INFO: loaded from: classes16.dex */
public final class k {
    public static void a(WebView r100) {
        r100.getSettings().setDefaultTextEncodingName(XML.CHARSET_UTF8);
        r100.getSettings().setJavaScriptEnabled(true);
        r100.getSettings().setSupportZoom(true);
        r100.getSettings().setBuiltInZoomControls(true);
        r100.getSettings().setDisplayZoomControls(false);
        r100.getSettings().setLoadWithOverviewMode(true);
        r100.setScrollBarStyle(0);
        r100.setHorizontalScrollbarOverlay(true);
        r100.setVerticalScrollbarOverlay(true);
        r100.setVerticalScrollBarEnabled(true);
        r100.setHorizontalScrollBarEnabled(true);
    }
}
