package com.bytedance.ee.bear.imageviewer;

import android.text.TextUtils;
import com.bytedance.ee.bear.imageviewer.view.DiagramWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class i3 implements tw4.a.b {
    public final /* synthetic */ DiagramWebView a;

    public /* synthetic */ i3(DiagramWebView r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        DiagramWebView r0 = this.a;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        tt5.a.d("DiagramWebView", "loadSVG()... svgString is empty");
        return;
    L5:
        r0.d = false;
        r0.setWebViewClient(new gb5.d(r0, r3));
        r0.loadUrl("file:///android_asset/diagram/diagram_template.html");
    }
}
