package com.bytedance.ee.bear.jsbridge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import at5.a;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.webview.fps.FpsWebViewV2;
import java.util.Map;
import mu5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BridgeWebViewV2 extends FpsWebViewV2 {
    public static boolean E;
    public a D;

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.onAttachedToWindow();
        resumeTimers();
    }

    public BridgeWebViewV2(Context r1) {
        super(r1);
        this.D = getBridge();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return super/*android.webkit.WebView*/.dispatchTouchEvent(r1);
    }

    public void loadUrl(String r2) {
        p(r2, false);
    }

    public BridgeWebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.D = getBridge();
    }

    public void loadUrl(String r2, Map<String, String> r3) {
        if (r3 != null) goto L13;
    L7:
        loadUrl(r2);     // Catch: Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        tt5.a.d("BridgeWebViewV2", "loadUrl additionalHttpHeaders e = " + th);
        return;
    L13:
        if (r3.isEmpty() == true) goto L7;
        super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.loadUrl(r2, r3);     // Catch: Throwable -> L9
        goto L12
    }

    public void p(String r2, boolean r3) {
        if (r3 == true) goto L4;
        super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.loadUrl(r2);     // Catch: Throwable -> L7
    L10:
        return;
    L4:
        evaluateJavascript(r2, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        tt5.a.d("BridgeWebViewV2", "loadUrl e = " + th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(String r1, JSONObject r2, boolean r3) {
        if (r3 == true) goto L4;
        super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.loadUrl(b.d(r1, r2));     // Catch: Throwable -> L7
    L10:
        return;
    L4:
        ap5.a.a(this, r1, r2, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        tt5.a.d("BridgeWebViewV2", "loadUrl e = " + th);
    }
}
