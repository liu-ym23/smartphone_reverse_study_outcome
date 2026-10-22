package com.bytedance.lynx.webview.internal;

import android.graphics.Bitmap;
import android.net.Uri;
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
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.StackLeakChecker;
import java.security.MessageDigest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class b1 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebChromeClient f265271a;

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return this.f265271a.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        return this.f265271a.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        this.f265271a.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        this.f265271a.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        return this.f265271a.onJsTimeout();
    }

    public b1(WebChromeClient r100) {
        this.f265271a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> r100) {
        this.f265271a.getVisitedHistory(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        this.f265271a.onCloseWindow(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage r100) {
        return this.f265271a.onConsoleMessage(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        this.f265271a.onPermissionRequest(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r100) {
        this.f265271a.onPermissionRequestCanceled(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(WebView r100) {
        this.f265271a.onRequestFocus(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String r210, GeolocationPermissions.Callback r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210, r211};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100003);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r115 = r111;
        f06.d r106 = r105.preInvoke(100003, "com/bytedance/lynx/webview/internal/WebChromeClientWrapper", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        this.f265271a.onGeolocationPermissionsShowPrompt(r210, r211);
        return;
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        s.a("onProgressChanged", new Object[]{r100, Integer.valueOf(r101)});
        this.f265271a.onProgressChanged(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView r100, Bitmap r101) {
        this.f265271a.onReceivedIcon(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        this.f265271a.onReceivedTitle(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        this.f265271a.onShowCustomView(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String r100, int r101, String r102) {
        this.f265271a.onConsoleMessage(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        this.f265271a.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        this.f265271a.onShowCustomView(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r110, WebChromeClient.FileChooserParams r111) {
        boolean r101 = false;
        if (Setting.c().b("sdk_enable_remote_shell", false) == false) goto L29;
        String r102 = r100.getUrl();
        if (r102.contains("ttwebview_upload") == true) goto L30;
    L26:
        if (r101 == false) goto L29;
        return true;
    L30:
        byte[] r103 = String.valueOf(System.currentTimeMillis() / StackLeakChecker.CHECK_INTERVAL_10_SEC).getBytes(XML.CHARSET_UTF8);     // Catch: Exception -> L9
        MessageDigest r104 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r104.update(r103);     // Catch: Exception -> L9
        String r105 = l17.g.a(r104.digest());     // Catch: Exception -> L9
    L12:
        if (r102.contains(r105) == false) goto L26;
        int r106 = r102.indexOf("path=");
        if (r106 < 0) goto L26;
        String r107 = r102.substring(r106 + 5);
        int r108 = r107.indexOf(38);
        if (r108 < 0) goto L19;
        r107 = r107.substring(0, r108);
    L19:
        PolarisFileWrapper r109 = new PolarisFileWrapper(l17.m.f(), r107);
        if (r109.exists() == false) goto L26;
        if (r109.isDirectory() == true) goto L26;
        r110.onReceiveValue(new Uri[]{Uri.fromFile(r109)});
        r101 = true;
    L9:
        e = move-exception;
        e.printStackTrace();
        r105 = "";
    L29:
        return this.f265271a.onShowFileChooser(r100, r110, r111);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        return this.f265271a.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        return this.f265271a.onJsAlert(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        return this.f265271a.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        return this.f265271a.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r100, String r101, String r102, String r110, JsPromptResult r111) {
        return this.f265271a.onJsPrompt(r100, r101, r102, r110, r111);
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String r110, String r111, long r112, long r113, long r114, WebStorage.QuotaUpdater r210) {
        this.f265271a.onExceededDatabaseQuota(r110, r111, r112, r113, r114, r210);
    }
}
