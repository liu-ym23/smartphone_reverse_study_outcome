package com.bytedance.ee.bear.document;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.browser.WebFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebViewContainer extends FrameLayout implements b5 {
    public final List<b5.a> a;
    public Boolean b;

    @Override // com.bytedance.ee.bear.document.b5
    public WebView getWebView() {
        return (WebView) getChildAt(0);
    L5:
        e = move-exception;
        tt5.a.l("WebViewContainer", "getWebView: ", e);
        return null;
    }

    public float getScale() {
        WebView r0 = getWebView();
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.getScale();
    }

    public String getUrl() {
        WebView r0 = getWebView();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getUrl();
    }

    @Override // com.bytedance.ee.bear.document.b5
    public final boolean isAttached() {
        if (getWebView() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public final boolean isVerticalScrollBarEnabled() {
        WebView r0 = getWebView();
        if (r0 != null) goto L5;
        Boolean r1 = this.b;
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.booleanValue();
    L5:
        return r0.isVerticalScrollBarEnabled();
    }

    @Override // com.bytedance.ee.bear.document.b5
    public final void onResume() {
        WebView r0 = getWebView();
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public List<b5.a> getOnDetachListeners() {
        return this.a;
    }

    public WebViewContainer(Context r1) {
        super(r1);
        this.a = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.webkit.WebView, com.bytedance.ee.bear.document.DocBridgeWebViewV2] */
    @Override // com.bytedance.ee.bear.document.b5
    public final void a(WebFragment r2) {
        tt5.a.h("WebViewContainer", "detach: ");
        ?? r0 = (DocBridgeWebViewV2) getWebView();
        if (r0 != 0) goto L6;
        tt5.a.h("WebViewContainer", "detach: webview has already detached");
        return;
    L6:
        r0.I();
        r0.setHostFragment(null);
        r0.setOnTouchListener(null);
        super.removeView(r0);
    }

    @Override // com.bytedance.ee.bear.document.b5
    public final void b(b5.a r2) {
        if (r2 == null) goto L5;
        this.a.remove(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.b5
    public final void c(b5.a r2) {
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r3) {
        if ((r3 instanceof WebView) == true) goto L5;
    L10:
        super.removeView(r3);
        return;
    L5:
        if (r3.getParent() != this) goto L10;
        Iterator r0 = new ArrayList(this.a).iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((b5.a) r0.next()).a();
        goto L8
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean r2) {
        this.b = Boolean.valueOf(r2);
        WebView r0 = getWebView();
        if (r0 == null) goto L6;
        r0.setVerticalScrollBarEnabled(r2);
        return;
    }

    public WebViewContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.b5
    public final void d(DocBridgeWebViewV2 r3, WebFragment r4) {
        tt5.a.h("WebViewContainer", "attach: ");
        if (getWebView() == null) goto L6;
        tt5.a.h("WebViewContainer", "attach: webview has alreay attached");
        return;
    L6:
        super.addView(r3, -1, -1);
        r3.setHostFragment(r4);
        Boolean r5 = this.b;
        if (r5 == null) goto L10;
        r3.setVerticalScrollBarEnabled(r5.booleanValue());
        return;
    }

    public WebViewContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
    }
}
