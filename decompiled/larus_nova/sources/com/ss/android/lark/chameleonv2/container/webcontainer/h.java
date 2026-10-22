package com.ss.android.lark.chameleonv2.container.webcontainer;

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
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends uwb.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<WebChromeClient> f411164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebChromeClient f411165e;

    @Override // uwb.b, android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Bitmap r101 = ((WebChromeClient) r100.next()).getDefaultVideoPoster();
        if (r101 == null) goto L4;
        return r101;
    L9:
        return super.getDefaultVideoPoster();
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        ((WebChromeClient) r100.next()).getVideoLoadingProgressView();
        goto L4
    L7:
        return super.getVideoLoadingProgressView();
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((WebChromeClient) r100.next()).onGeolocationPermissionsHidePrompt();
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onHideCustomView() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((WebChromeClient) r100.next()).onHideCustomView();
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        if (((WebChromeClient) r100.next()).onJsTimeout() == false) goto L4;
        return true;
    L10:
        return super.onJsTimeout();
    }

    public h(wwb.c r100) {
        super(r100);
        this.f411164d = new CopyOnWriteArrayList();
    }

    public static void a(PermissionRequest r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102606);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102606, "android/webkit/PermissionRequest", "deny", r110, r111, "void", r112);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        r110.deny();
        return;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((WebChromeClient) r101.next()).getVisitedHistory(r100);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((WebChromeClient) r101.next()).onCloseWindow(r100);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        if (((WebChromeClient) r101.next()).onConsoleMessage(r100) == false) goto L4;
        return true;
    L10:
        return super.onConsoleMessage(r100);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WebChromeClient r101 = this.f411165e;
        if (r101 != null) goto L19;
        super.onPermissionRequest(r100);
        return;
    L19:
        r101.onPermissionRequest(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_ExtendableWebChromeClient", th.getMessage());
        a(r100);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_ExtendableWebChromeClient", "deny permission request failed", th);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r100) {
        WebChromeClient r101 = this.f411165e;
        if (r101 != null) goto L6;
        super.onPermissionRequestCanceled(r100);
        return;
    L6:
        r101.onPermissionRequestCanceled(r100);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onRequestFocus(WebView r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((WebChromeClient) r101.next()).onRequestFocus(r100);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
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
        f06.d r106 = r105.preInvoke(100003, "com/ss/android/lark/chameleonv2/container/webcontainer/ExtendableWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L24
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L24
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        Iterator r107 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        ((WebChromeClient) r107.next()).onGeolocationPermissionsShowPrompt(r210, r211);
        goto L21
    L23:
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

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebChromeClient) r102.next()).onProgressChanged(r100, r101);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView r100, Bitmap r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebChromeClient) r102.next()).onReceivedIcon(r100, r101);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebChromeClient) r102.next()).onReceivedTitle(r100, r101);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebChromeClient) r102.next()).onShowCustomView(r100, r101);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onConsoleMessage(String r100, int r101, String r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebChromeClient) r103.next()).onConsoleMessage(r100, r101, r102);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebChromeClient) r103.next()).onReceivedTouchIconUrl(r100, r101, r102);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebChromeClient) r103.next()).onShowCustomView(r100, r101, r102);
        goto L4
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        super.onShowFileChooser(r100, r101, r102);
        return true;
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (((WebChromeClient) r104.next()).onCreateWindow(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (((WebChromeClient) r104.next()).onJsAlert(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (((WebChromeClient) r104.next()).onJsBeforeUnload(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (((WebChromeClient) r104.next()).onJsConfirm(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        if (((WebChromeClient) r101.next()).onJsPrompt(r100, r110, r111, r112, r113) == false) goto L4;
        return true;
    L10:
        return super.onJsPrompt(r100, r110, r111, r112, r113);
    }

    @Override // uwb.b, android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String r110, String r111, long r112, long r113, long r210, WebStorage.QuotaUpdater r211) {
        Iterator r100 = ((CopyOnWriteArrayList) this.f411164d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((WebChromeClient) r100.next()).onExceededDatabaseQuota(r110, r111, r112, r113, r210, r211);
        goto L4
    }
}
