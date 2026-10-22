package com.ss.android.lark.chameleon.basewebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.bridge.BridgeHandler;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.bridge.JSHandler;
import com.ss.android.lark.chameleon.bridge.JsCallBack;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BridgeWebViewV2 extends LarkWebView {
    private static final String TAG = "BridgeWebViewV2";
    public static boolean shandlerRunOnUIThread;
    private Bridge mBridge;

    public String callSync(String r100) throws Exception {
        return "null";
    }

    public void clearAllHandlers() {
        this.mBridge.clearAllHandler();
    }

    private void init() {
        this.mBridge = getBridge();
    }

    @Override // com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimers();
    }

    public BridgeWebViewV2(Context r100) {
        super(r100);
        init();
    }

    public static CallBackFunction newToOldCallback(final JsCallBack r100) {
        return new AnonymousClass3(r100);
    }

    public static <T> BridgeHandler<String, LarkWebView> oldToNewHandler(final BridgeHandlerV2 r100) {
        return new AnonymousClass2(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.LarkWebView, com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void loadUrl(String r100) {
        loadUrl(r100, false);
    }

    public void unregisterHandler(String r100) {
        this.mBridge.unRegisterHandler(r100);
    }

    public static <T> BridgeHandler<String, LarkWebView> oldToNewHandler(final JSHandler r100) {
        return new AnonymousClass1(r100);
    }

    public BridgeWebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        init();
    }

    public void callJsFunction(String r100, JsonObject r101) {
        callJsFunction(r100, r101, false);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.LarkWebView, com.ss.android.lark.chameleon.basewebview.BaseWebView, android.webkit.WebView
    public void loadUrl(String r100, Map<String, String> r101) {
        if (r101 != null) goto L13;
    L7:
        loadUrl(r100);     // Catch: Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        Log.e(TAG, "loadUrl additionalHttpHeaders e = " + th);
        return;
    L13:
        if (r101.isEmpty() == true) goto L7;
        super.loadUrl(r100, r101);     // Catch: Throwable -> L9
        goto L12
    }

    public <T> void registerHandler(String r100, BridgeHandlerV2<T> r101) {
        this.mBridge.registerHandler(r100, oldToNewHandler(r101));
    }

    public void loadUrl(String r100, boolean r101) {
        if (r101 == true) goto L4;
        super.loadUrl(r100);     // Catch: Throwable -> L7
    L10:
        return;
    L4:
        evaluateJavascript(r100, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Log.e(TAG, "loadUrl e = " + th);
    }

    public <T> void registerHandler(String r100, JSHandler<T> r101) {
        this.mBridge.registerHandler(r100, oldToNewHandler(r101));
    }

    public void callJsFunction(String r100, JsonObject r101, boolean r102) {
        if (r102 == true) goto L4;
        super.loadUrl(JsonUtils.INSTANCE.combineRequestContent(r100, r101));     // Catch: Throwable -> L7
    L10:
        return;
    L4:
        SafeJSExecutor.execJS(this, r100, r101, null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Log.e(TAG, "loadUrl e = " + th);
    }
}
