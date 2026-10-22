package ws5;

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
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.quality.safe.FileChooseHandlerV2;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.log.Log;
import f06.d;
import gt5.e;
import gt5.g;
import gt5.p;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import st5.h;

/* JADX INFO: loaded from: classes19.dex */
public class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ys5.c f561050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebChromeClient f561051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileChooseHandlerV2 f561052c;

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        h r100 = (h) this.f561050a.getServiceManager().a(h.class);
        if (r100 == null) goto L7;
        Log.i("LarkBaseWebChromeClient", "getDefaultVideoPoster service handle");
        return r100.C();
    L7:
        if (this.f561051b == null) goto L10;
        Log.i("LarkBaseWebChromeClient", "getDefaultVideoPoster mClient handle");
        return this.f561051b.getDefaultVideoPoster();
    L10:
        Log.i("LarkBaseWebChromeClient", "getDefaultVideoPoster default");
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "getVideoLoadingProgressView");
        return this.f561051b.getVideoLoadingProgressView();
    L6:
        Log.i("LarkBaseWebChromeClient", "getVideoLoadingProgressView");
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Log.i("LarkBaseWebChromeClient", "onGeolocationPermissionsHidePrompt");
        super.onGeolocationPermissionsHidePrompt();
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "onGeolocationPermissionsHidePrompt mClient");
        this.f561051b.onGeolocationPermissionsHidePrompt();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Log.i("LarkBaseWebChromeClient", "onHideCustomView");
        super.onHideCustomView();
        WebChromeClient r100 = this.f561051b;
        if (r100 == null) goto L6;
        r100.onHideCustomView();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient r100 = this.f561051b;
        if (r100 == null) goto L7;
        return r100.onJsTimeout();
    L7:
        return super.onJsTimeout();
    }

    public b(ys5.c r100) {
        this.f561050a = r100;
        this.f561052c = new FileChooseHandlerV2(r100.getWebView().getContext());
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r100) {
        Log.i("LarkBaseWebChromeClient", "getVisitedHistory");
        super.getVisitedHistory(r100);
        WebChromeClient r101 = this.f561051b;
        if (r101 == null) goto L6;
        r101.getVisitedHistory(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView r100) {
        Log.i("LarkBaseWebChromeClient", "onCloseWindow");
        super.onCloseWindow(r100);
        WebChromeClient r101 = this.f561051b;
        if (r101 == null) goto L6;
        r101.onCloseWindow(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r100) {
        WebChromeClient r101 = this.f561051b;
        if (r101 == null) goto L7;
        return r101.onConsoleMessage(r100);
    L7:
        return super.onConsoleMessage(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r100) {
        if (this.f561051b == null) goto L5;
        Log.i("LarkBaseWebChromeClient", "onPermissionRequest mClient");
        this.f561051b.onPermissionRequest(r100);
        return;
    L5:
        Log.i("LarkBaseWebChromeClient", "onPermissionRequest default");
        super.onPermissionRequest(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r100) {
        if (this.f561051b == null) goto L5;
        Log.i("LarkBaseWebChromeClient", "onPermissionRequestCanceled mClient");
        this.f561051b.onPermissionRequestCanceled(r100);
        return;
    L5:
        Log.i("LarkBaseWebChromeClient", "onPermissionRequestCanceled default");
        super.onPermissionRequestCanceled(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView r100) {
        super.onRequestFocus(r100);
        WebChromeClient r101 = this.f561051b;
        if (r101 == null) goto L6;
        r101.onRequestFocus(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r210, GeolocationPermissions.Callback r211) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210, r211};
        f06.b r112 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(100003);
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
        d r106 = r105.preInvoke(100003, "com/bytedance/ee/larkwebview/base/client/LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r111, "void", r112);     // Catch: Exception -> L23
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L23
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        Log.i("LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt");
        super.onGeolocationPermissionsShowPrompt(r210, r211);
        if (this.f561051b == null) goto L29;
        Log.i("LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt default");
        this.f561051b.onGeolocationPermissionsShowPrompt(r210, r211);
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
        Log.i("LarkBaseWebChromeClient", "onProgressChanged " + r101);
        super.onProgressChanged(r100, r101);
        WebChromeClient r102 = this.f561051b;
        if (r102 == null) goto L5;
        r102.onProgressChanged(r100, r101);
    L5:
        zs5.c r103 = zs5.a.f573485a;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r100, Bitmap r101) {
        Log.i("LarkBaseWebChromeClient", "onReceiveIcon");
        super.onReceivedIcon(r100, r101);
        WebChromeClient r102 = this.f561051b;
        if (r102 == null) goto L6;
        r102.onReceivedIcon(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r100, String r101) {
        Log.i("LarkBaseWebChromeClient", "onReceivedTitle");
        super.onReceivedTitle(r100, r101);
        WebChromeClient r102 = this.f561051b;
        if (r102 == null) goto L6;
        r102.onReceivedTitle(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        Log.i("LarkBaseWebChromeClient", "onShowCustomView");
        super.onShowCustomView(r100, r101);
        WebChromeClient r102 = this.f561051b;
        if (r102 == null) goto L6;
        r102.onShowCustomView(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r100, int r101, String r102) {
        super.onConsoleMessage(r100, r101, r102);
        WebChromeClient r103 = this.f561051b;
        if (r103 == null) goto L6;
        r103.onConsoleMessage(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        Log.i("LarkBaseWebChromeClient", "onReceivedTouchIconUrl , precomposed = " + r102);
        WebChromeClient r103 = this.f561051b;
        if (r103 == null) goto L5;
        r103.onReceivedTouchIconUrl(r100, r101, r102);
    L5:
        super.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        super.onShowCustomView(r100, r101, r102);
        WebChromeClient r103 = this.f561051b;
        if (r103 == null) goto L6;
        r103.onShowCustomView(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r110, ValueCallback<Uri[]> r111, WebChromeClient.FileChooserParams r112) {
        int r100 = p.f482566a;
        LarkWebView r101 = this.f561050a.getWebView();
        Intrinsics.checkNotNullParameter("input", "tag");
        new g("wb_html_tag", e.f482520d, r101).addCategoryValue("tag", "input").addMap(new HashMap()).flush();
        WebChromeClient r102 = this.f561051b;
        if (r102 == null) goto L8;
        boolean r113 = r102.onShowFileChooser(r110, r111, r112);
        Log.i("LarkBaseWebChromeClient", "onShowFileChooser mClient clientResult = " + r113);
        if (r113 == true) goto L7;
        FileChooseHandlerV2 r103 = this.f561052c;
        r103.getClass();
        Intrinsics.checkNotNull(r112);
        r103.g(null, r111, r112.getAcceptTypes(), r112, false);
    L7:
        return true;
    L8:
        Log.i("LarkBaseWebChromeClient", "onShowFileChooser default");
        FileChooseHandlerV2 r104 = this.f561052c;
        r104.getClass();
        Intrinsics.checkNotNull(r112);
        r104.g(null, r111, r112.getAcceptTypes(), r112, false);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "onCreateWindow mClient");
        return this.f561051b.onCreateWindow(r100, r101, r102, r103);
    L6:
        Log.i("LarkBaseWebChromeClient", "onCreateWindow default");
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "onJsAlert mClient");
        return this.f561051b.onJsAlert(r100, r101, r102, r103);
    L6:
        Log.i("LarkBaseWebChromeClient", "onJsAlert default");
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "onJsBeforeUnload mClient");
        return this.f561051b.onJsBeforeUnload(r100, r101, r102, r103);
    L6:
        Log.i("LarkBaseWebChromeClient", "onJsBeforeUnload default");
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "onJsConfirm mClient");
        return this.f561051b.onJsConfirm(r100, r101, r102, r103);
    L6:
        Log.i("LarkBaseWebChromeClient", "onJsConfirm default");
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
        if (this.f561051b == null) goto L6;
        Log.i("LarkBaseWebChromeClient", "onJsPrompt mClient");
        return this.f561051b.onJsPrompt(r100, r110, r111, r112, r113);
    L6:
        Log.i("LarkBaseWebChromeClient", "onJsPrompt default");
        return super.onJsPrompt(r100, r110, r111, r112, r113);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r100, String r101, long r102, long r103, long r104, WebStorage.QuotaUpdater r105) {
        super.onExceededDatabaseQuota(r100, r101, r102, r103, r104, r105);
    }
}
