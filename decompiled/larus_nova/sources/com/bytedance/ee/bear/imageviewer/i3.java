package com.bytedance.ee.bear.imageviewer;

import android.text.TextUtils;
import com.bytedance.ee.bear.imageviewer.view.DiagramWebView;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class i3 implements tw4.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiagramWebView f226943a;

    public /* synthetic */ i3(DiagramWebView r100) {
        this.f226943a = r100;
    }

    public final void a(String r100) {
        DiagramWebView r101 = this.f226943a;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        tt5.a.d("DiagramWebView", "loadSVG()... svgString is empty");
        return;
    L5:
        r101.f227037d = false;
        r101.setWebViewClient(new gb5.d(r101, r100));
        r101.loadUrl("file:///android_asset/diagram/diagram_template.html");
    }
}
