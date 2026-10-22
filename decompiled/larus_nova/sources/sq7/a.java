package sq7;

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
import f06.d;
import iq7.g;
import java.util.ArrayList;
import oq7.c;

/* JADX INFO: loaded from: classes22.dex */
public class a extends WebChromeClient implements pq7.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f543079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pq7.a f543080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebChromeClient f543081c;

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient r100 = this.f543081c;
        if (r100 == null) goto L7;
        return r100.getDefaultVideoPoster();
    L7:
        return super.getDefaultVideoPoster();
    }

    @Override // pq7.b
    public final oq7.a getExtendableContext() {
        pq7.a r100 = this.f543080b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f530284a;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        WebChromeClient r100 = this.f543081c;
        if (r100 == null) goto L7;
        return r100.getVideoLoadingProgressView();
    L7:
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient r100 = this.f543081c;
        if (r100 == null) goto L6;
        r100.onGeolocationPermissionsHidePrompt();
        return;
    L6:
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient r100 = this.f543081c;
        if (r100 == null) goto L6;
        r100.onHideCustomView();
        return;
    L6:
        super.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient r100 = this.f543081c;
        if (r100 == null) goto L7;
        return r100.onJsTimeout();
    L7:
        return super.onJsTimeout();
    }

    public a() {
        this.f543080b = new pq7.a();
    }

    @Override // pq7.b
    public final void b(g r100) {
        this.f543079a = r100;
        this.f543080b.f530284a = new oq7.a(this.f543079a, this);
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r100) {
        WebChromeClient r101 = this.f543081c;
        if (r101 == null) goto L6;
        r101.getVisitedHistory(r100);
        return;
    L6:
        super.getVisitedHistory(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView r100) {
        WebChromeClient r101 = this.f543081c;
        if (r101 == null) goto L6;
        r101.onCloseWindow(r100);
        return;
    L6:
        super.onCloseWindow(r100);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r100) {
        WebChromeClient r101 = this.f543081c;
        if (r101 == null) goto L7;
        return r101.onConsoleMessage(r100);
    L7:
        return super.onConsoleMessage(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r100) {
        WebChromeClient r101 = this.f543081c;
        if (r101 == null) goto L6;
        r101.onPermissionRequest(r100);
        return;
    L6:
        super.onPermissionRequest(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r100) {
        WebChromeClient r101 = this.f543081c;
        if (r101 == null) goto L6;
        r101.onPermissionRequestCanceled(r100);
        return;
    L6:
        super.onPermissionRequestCanceled(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView r100) {
        WebChromeClient r101 = this.f543081c;
        if (r101 == null) goto L6;
        r101.onRequestFocus(r100);
        return;
    L6:
        super.onRequestFocus(r100);
    }

    @Override // android.webkit.WebChromeClient
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
        d r106 = r105.preInvoke(100003, "com/bytedance/webx/core/webview/client/inner/WebChromeContainerClientInner", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L25
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L25
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        WebChromeClient r107 = this.f543081c;
        if (r107 == null) goto L23;
        r107.onGeolocationPermissionsShowPrompt(r210, r211);
        return;
    L23:
        super.onGeolocationPermissionsShowPrompt(r210, r211);
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

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView r100, int r101) {
        WebChromeClient r102 = this.f543081c;
        if (r102 == null) goto L6;
        r102.onProgressChanged(r100, r101);
        return;
    L6:
        super.onProgressChanged(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r100, Bitmap r101) {
        WebChromeClient r102 = this.f543081c;
        if (r102 == null) goto L6;
        r102.onReceivedIcon(r100, r101);
        return;
    L6:
        super.onReceivedIcon(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r100, String r101) {
        WebChromeClient r102 = this.f543081c;
        if (r102 == null) goto L6;
        r102.onReceivedTitle(r100, r101);
        return;
    L6:
        super.onReceivedTitle(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        WebChromeClient r102 = this.f543081c;
        if (r102 == null) goto L6;
        r102.onShowCustomView(r100, r101);
        return;
    L6:
        super.onShowCustomView(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r100, int r101, String r102) {
        WebChromeClient r103 = this.f543081c;
        if (r103 == null) goto L6;
        r103.onConsoleMessage(r100, r101, r102);
        return;
    L6:
        super.onConsoleMessage(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        WebChromeClient r103 = this.f543081c;
        if (r103 == null) goto L6;
        r103.onReceivedTouchIconUrl(r100, r101, r102);
        return;
    L6:
        super.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        WebChromeClient r103 = this.f543081c;
        if (r103 == null) goto L6;
        r103.onShowCustomView(r100, r101, r102);
        return;
    L6:
        super.onShowCustomView(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        WebChromeClient r103 = this.f543081c;
        if (r103 == null) goto L7;
        return r103.onShowFileChooser(r100, r101, r102);
    L7:
        return super.onShowFileChooser(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        WebChromeClient r104 = this.f543081c;
        if (r104 == null) goto L7;
        return r104.onCreateWindow(r100, r101, r102, r103);
    L7:
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        WebChromeClient r104 = this.f543081c;
        if (r104 == null) goto L7;
        return r104.onJsAlert(r100, r101, r102, r103);
    L7:
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        WebChromeClient r104 = this.f543081c;
        if (r104 == null) goto L7;
        return r104.onJsBeforeUnload(r100, r101, r102, r103);
    L7:
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        WebChromeClient r104 = this.f543081c;
        if (r104 == null) goto L7;
        return r104.onJsConfirm(r100, r101, r102, r103);
    L7:
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r100, String r101, String r102, String r110, JsPromptResult r111) {
        WebChromeClient r103 = this.f543081c;
        if (r103 == null) goto L7;
        return r103.onJsPrompt(r100, r101, r102, r110, r111);
    L7:
        return super.onJsPrompt(r100, r101, r102, r110, r111);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r110, String r111, long r112, long r113, long r114, WebStorage.QuotaUpdater r210) {
        WebChromeClient r100 = this.f543081c;
        if (r100 == null) goto L6;
        r100.onExceededDatabaseQuota(r110, r111, r112, r113, r114, r210);
        return;
    L6:
        super.onExceededDatabaseQuota(r110, r111, r112, r113, r114, r210);
    }
}
