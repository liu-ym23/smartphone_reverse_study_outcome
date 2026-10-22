package wr4;

import android.webkit.WebView;
import com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final a a(WebView r100) {
        if ((r100 instanceof NestedScrollWebViewV2) == false) goto L5;
        NestedScrollWebViewV2 r101 = (NestedScrollWebViewV2) r100;
    L6:
        if (r101 == null) goto L9;
        tt5.a.h("ElasticCollapsedStrategy", "initNestedScroll");
        a r102 = new a(r101.getContext(), r101);
        r101.setNestedScrollStrategy(r102);
        return r102;
    L9:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}
