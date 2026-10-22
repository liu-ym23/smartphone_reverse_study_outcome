package com.ss.android.lark.chameleon.pluginsystem;

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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import f06.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public class ExtendableWebChromeClient extends LarkBaseWebChromeClient {
    private List<WebChromeClient> delegates;

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        Iterator<WebChromeClient> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Bitmap r101 = r100.next().getDefaultVideoPoster();
        if (r101 == null) goto L4;
        return r101;
    L9:
        return super.getDefaultVideoPoster();
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        Iterator<WebChromeClient> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        r100.next().getVideoLoadingProgressView();
        goto L4
    L7:
        return super.getVideoLoadingProgressView();
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Iterator<WebChromeClient> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onGeolocationPermissionsHidePrompt();
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onHideCustomView() {
        Iterator<WebChromeClient> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onHideCustomView();
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        Iterator<WebChromeClient> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        if (r100.next().onJsTimeout() == false) goto L4;
        return true;
    L10:
        return super.onJsTimeout();
    }

    public ExtendableWebChromeClient(ILarkWebViewContext r100) {
        super(r100);
        this.delegates = new CopyOnWriteArrayList();
    }

    public void addWebChromeClientDelegate(WebChromeClient r100) {
        if (this.delegates.contains(r100) == true) goto L6;
        this.delegates.add(r100);
        return;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r100) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getVisitedHistory(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onCloseWindow(WebView r100) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onCloseWindow(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r100) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        if (r101.next().onConsoleMessage(r100) == false) goto L4;
        return true;
    L10:
        return super.onConsoleMessage(r100);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r100) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onPermissionRequest(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r100) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onPermissionRequestCanceled(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onRequestFocus(WebView r100) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onRequestFocus(r100);
        goto L4
    }

    public void removeWebChromeClientDelegate(WebChromeClient r100) {
        this.delegates.remove(r100);
    }

    public void sortDelegates(Comparator<WebChromeClient> r100) {
        ArrayList r101 = new ArrayList(this.delegates);
        Collections.sort(r101, r100);
        this.delegates.clear();
        this.delegates.addAll(r101);
    }

    public void addWebChromeClientDelegate(int r100, WebChromeClient r101) {
        if (this.delegates.contains(r101) == true) goto L6;
        ListProtector.add(this.delegates, r100, r101);
        return;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r210, GeolocationPermissions.Callback r211) {
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
        d r106 = r105.preInvoke(100003, "com/ss/android/lark/chameleon/pluginsystem/ExtendableWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L24
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L24
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        Iterator<WebChromeClient> r107 = this.delegates.iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        r107.next().onGeolocationPermissionsShowPrompt(r210, r211);
        goto L21
    L23:
        return;
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onProgressChanged(WebView r100, int r101) {
        Iterator<WebChromeClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onProgressChanged(r100, r101);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r100, Bitmap r101) {
        Iterator<WebChromeClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onReceivedIcon(r100, r101);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r100, String r101) {
        Iterator<WebChromeClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onReceivedTitle(r100, r101);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        Iterator<WebChromeClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onShowCustomView(r100, r101);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onConsoleMessage(String r100, int r101, String r102) {
        Iterator<WebChromeClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onConsoleMessage(r100, r101, r102);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        Iterator<WebChromeClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onReceivedTouchIconUrl(r100, r101, r102);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        Iterator<WebChromeClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onShowCustomView(r100, r101, r102);
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        return super.onShowFileChooser(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        Iterator<WebChromeClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (r104.next().onCreateWindow(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        Iterator<WebChromeClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (r104.next().onJsAlert(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        Iterator<WebChromeClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (r104.next().onJsBeforeUnload(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        Iterator<WebChromeClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        if (r104.next().onJsConfirm(r100, r101, r102, r103) == false) goto L4;
        return true;
    L10:
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
        Iterator<WebChromeClient> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        if (r101.next().onJsPrompt(r100, r110, r111, r112, r113) == false) goto L4;
        return true;
    L10:
        return super.onJsPrompt(r100, r110, r111, r112, r113);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r110, String r111, long r112, long r113, long r210, WebStorage.QuotaUpdater r211) {
        Iterator<WebChromeClient> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onExceededDatabaseQuota(r110, r111, r112, r113, r210, r211);
        goto L4
    }
}
