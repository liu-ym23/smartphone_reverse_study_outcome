package com.ss.android.lark.chameleon.basewebview.client;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import com.ss.android.lark.chameleon.idependency.Log;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes35.dex */
public class LarkBaseWebChromeClient extends WebChromeClient {
    private static final String TAG = "LarkBaseWebChromeClient";
    private WebChromeClient mClient;
    private ILarkWebViewContext mContext;

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "getVideoLoadingProgressView");
        return this.mClient.getVideoLoadingProgressView();
    L6:
        Log.i(TAG, "getVideoLoadingProgressView");
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Log.i(TAG, "onGeolocationPermissionsHidePrompt");
        super.onGeolocationPermissionsHidePrompt();
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onGeolocationPermissionsHidePrompt mClient");
        this.mClient.onGeolocationPermissionsHidePrompt();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Log.i(TAG, "onHideCustomView");
        super.onHideCustomView();
        WebChromeClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.onHideCustomView();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient r100 = this.mClient;
        if (r100 == null) goto L7;
        return r100.onJsTimeout();
    L7:
        return super.onJsTimeout();
    }

    public LarkBaseWebChromeClient(ILarkWebViewContext r100) {
        this.mContext = r100;
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r100) {
        Log.i(TAG, "getVisitedHistory");
        super.getVisitedHistory(r100);
        WebChromeClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.getVisitedHistory(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView r100) {
        Log.i(TAG, "onCloseWindow");
        super.onCloseWindow(r100);
        WebChromeClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.onCloseWindow(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r100) {
        WebChromeClient r101 = this.mClient;
        if (r101 == null) goto L7;
        return r101.onConsoleMessage(r100);
    L7:
        return super.onConsoleMessage(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r100) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onPermissionRequest mClient");
        this.mClient.onPermissionRequest(r100);
        return;
    L5:
        Log.i(TAG, "onPermissionRequest default");
        super.onPermissionRequest(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r100) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onPermissionRequestCanceled mClient");
        this.mClient.onPermissionRequestCanceled(r100);
        return;
    L5:
        Log.i(TAG, "onPermissionRequestCanceled default");
        super.onPermissionRequestCanceled(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView r100) {
        super.onRequestFocus(r100);
        WebChromeClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.onRequestFocus(r100);
        return;
    }

    public void setWebChromeClient(WebChromeClient r100) {
        Log.i(TAG, "Caller setWebChromeClient");
        this.mClient = r100;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r210, GeolocationPermissions.Callback r211) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210, r211};
        b r112 = new b();
        a r100 = ApiHookConfig.f245611b.get(100003);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r212 = r102;
        d r106 = r105.preInvoke(100003, "com/ss/android/lark/chameleon/basewebview/client/LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r111, "void", r112);     // Catch: Exception -> L23
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L23
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        Log.i(TAG, "onGeolocationPermissionsShowPrompt");
        super.onGeolocationPermissionsShowPrompt(r210, r211);
        if (this.mClient == null) goto L29;
        Log.i(TAG, "onGeolocationPermissionsShowPrompt default");
        this.mClient.onGeolocationPermissionsShowPrompt(r210, r211);
        return;
    L29:
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r212;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView r100, int r101) {
        Log.i(TAG, "onProgressChanged " + r101);
        super.onProgressChanged(r100, r101);
        WebChromeClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onProgressChanged(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r100, Bitmap r101) {
        Log.i(TAG, "onReceiveIcon");
        super.onReceivedIcon(r100, r101);
        WebChromeClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onReceivedIcon(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r100, String r101) {
        Log.i(TAG, "onReceivedTitle");
        super.onReceivedTitle(r100, r101);
        WebChromeClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onReceivedTitle(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        Log.i(TAG, "onShowCustomView");
        super.onShowCustomView(r100, r101);
        WebChromeClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.onShowCustomView(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r100, int r101, String r102) {
        super.onConsoleMessage(r100, r101, r102);
        WebChromeClient r103 = this.mClient;
        if (r103 == null) goto L6;
        r103.onConsoleMessage(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        Log.i(TAG, "onReceivedTouchIconUrl , precomposed = " + r102);
        WebChromeClient r103 = this.mClient;
        if (r103 == null) goto L5;
        r103.onReceivedTouchIconUrl(r100, r101, r102);
    L5:
        super.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        super.onShowCustomView(r100, r101, r102);
        WebChromeClient r103 = this.mClient;
        if (r103 == null) goto L6;
        r103.onShowCustomView(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onCreateWindow mClient");
        return this.mClient.onCreateWindow(r100, r101, r102, r103);
    L6:
        Log.i(TAG, "onCreateWindow default");
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsAlert mClient");
        return this.mClient.onJsAlert(r100, r101, r102, r103);
    L6:
        Log.i(TAG, "onJsAlert default");
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsBeforeUnload mClient");
        return this.mClient.onJsBeforeUnload(r100, r101, r102, r103);
    L6:
        Log.i(TAG, "onJsBeforeUnload default");
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsConfirm mClient");
        return this.mClient.onJsConfirm(r100, r101, r102, r103);
    L6:
        Log.i(TAG, "onJsConfirm default");
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onJsPrompt mClient");
        return this.mClient.onJsPrompt(r100, r110, r111, r112, r113);
    L6:
        Log.i(TAG, "onJsPrompt default");
        return super.onJsPrompt(r100, r110, r111, r112, r113);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r100, String r101, long r102, long r103, long r104, WebStorage.QuotaUpdater r105) {
        super.onExceededDatabaseQuota(r100, r101, r102, r103, r104, r105);
    }
}
