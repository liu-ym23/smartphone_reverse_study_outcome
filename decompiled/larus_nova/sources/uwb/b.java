package uwb;

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
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.k;
import com.ss.android.lark.officesdk.utils.di.l;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.safe.FileChooseHandlerV2;
import dxb.t;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;
import oxb.g;

/* JADX INFO: loaded from: classes37.dex */
public class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwb.c f551954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebChromeClient f551955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileChooseHandlerV2 f551956c;

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        g r100 = (g) this.f551954a.getServiceManager().a(g.class);
        if (r100 == null) goto L7;
        j.e("LarkBaseWebChromeClient", "getDefaultVideoPoster service handle");
        return r100.C();
    L7:
        if (this.f551955b == null) goto L10;
        j.e("LarkBaseWebChromeClient", "getDefaultVideoPoster mClient handle");
        return this.f551955b.getDefaultVideoPoster();
    L10:
        j.e("LarkBaseWebChromeClient", "getDefaultVideoPoster default");
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "getVideoLoadingProgressView");
        return this.f551955b.getVideoLoadingProgressView();
    L6:
        j.e("LarkBaseWebChromeClient", "getVideoLoadingProgressView");
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsHidePrompt");
        super.onGeolocationPermissionsHidePrompt();
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsHidePrompt mClient");
        this.f551955b.onGeolocationPermissionsHidePrompt();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        j.e("LarkBaseWebChromeClient", "onHideCustomView");
        super.onHideCustomView();
        WebChromeClient r100 = this.f551955b;
        if (r100 == null) goto L6;
        r100.onHideCustomView();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient r100 = this.f551955b;
        if (r100 == null) goto L7;
        return r100.onJsTimeout();
    L7:
        return super.onJsTimeout();
    }

    public b(wwb.c r100) {
        this.f551954a = r100;
        this.f551956c = new FileChooseHandlerV2(r100.getWebView().getContext());
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r100) {
        j.e("LarkBaseWebChromeClient", "getVisitedHistory");
        super.getVisitedHistory(r100);
        WebChromeClient r101 = this.f551955b;
        if (r101 == null) goto L6;
        r101.getVisitedHistory(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView r100) {
        j.e("LarkBaseWebChromeClient", "onCloseWindow");
        super.onCloseWindow(r100);
        WebChromeClient r101 = this.f551955b;
        if (r101 == null) goto L6;
        r101.onCloseWindow(r100);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r100) {
        WebChromeClient r101 = this.f551955b;
        if (r101 == null) goto L7;
        return r101.onConsoleMessage(r100);
    L7:
        return super.onConsoleMessage(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r100) {
        if (this.f551955b == null) goto L5;
        j.e("LarkBaseWebChromeClient", "onPermissionRequest mClient");
        this.f551955b.onPermissionRequest(r100);
        return;
    L5:
        j.e("LarkBaseWebChromeClient", "onPermissionRequest default");
        super.onPermissionRequest(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r100) {
        if (this.f551955b == null) goto L5;
        j.e("LarkBaseWebChromeClient", "onPermissionRequestCanceled mClient");
        this.f551955b.onPermissionRequestCanceled(r100);
        return;
    L5:
        j.e("LarkBaseWebChromeClient", "onPermissionRequestCanceled default");
        super.onPermissionRequestCanceled(r100);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView r100) {
        super.onRequestFocus(r100);
        WebChromeClient r101 = this.f551955b;
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
        d r106 = r105.preInvoke(100003, "com/ss/android/lark/officewebview/base/client/LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r111, "void", r112);     // Catch: Exception -> L23
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L23
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt");
        super.onGeolocationPermissionsShowPrompt(r210, r211);
        if (this.f551955b == null) goto L29;
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt default");
        this.f551955b.onGeolocationPermissionsShowPrompt(r210, r211);
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
        j.e("LarkBaseWebChromeClient", "onProgressChanged " + r101);
        super.onProgressChanged(r100, r101);
        WebChromeClient r102 = this.f551955b;
        if (r102 == null) goto L5;
        r102.onProgressChanged(r100, r101);
    L5:
        int r103 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(r100, "view");
        zwb.a r104 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r104 == null) goto L9;
        r104.f();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r100, Bitmap r101) {
        j.e("LarkBaseWebChromeClient", "onReceiveIcon");
        super.onReceivedIcon(r100, r101);
        WebChromeClient r102 = this.f551955b;
        if (r102 == null) goto L6;
        r102.onReceivedIcon(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r100, String r101) {
        j.e("LarkBaseWebChromeClient", "onReceivedTitle");
        super.onReceivedTitle(r100, r101);
        WebChromeClient r102 = this.f551955b;
        if (r102 == null) goto L6;
        r102.onReceivedTitle(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        j.e("LarkBaseWebChromeClient", "onShowCustomView");
        super.onShowCustomView(r100, r101);
        WebChromeClient r102 = this.f551955b;
        if (r102 == null) goto L6;
        r102.onShowCustomView(r100, r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r100, int r101, String r102) {
        super.onConsoleMessage(r100, r101, r102);
        WebChromeClient r103 = this.f551955b;
        if (r103 == null) goto L6;
        r103.onConsoleMessage(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        j.e("LarkBaseWebChromeClient", "onReceivedTouchIconUrl , precomposed = " + r102);
        WebChromeClient r103 = this.f551955b;
        if (r103 == null) goto L5;
        r103.onReceivedTouchIconUrl(r100, r101, r102);
    L5:
        super.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        super.onShowCustomView(r100, r101, r102);
        WebChromeClient r103 = this.f551955b;
        if (r103 == null) goto L6;
        r103.onShowCustomView(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r110, ValueCallback<Uri[]> r111, WebChromeClient.FileChooserParams r112) {
        int r100 = t.f470510a;
        OfficeWebView r101 = this.f551954a.getWebView();
        Intrinsics.checkNotNullParameter("input", "tag");
        dxb.c.a r102 = dxb.c.f470456a;
        int r103 = l.f437227a;
        o r104 = l.a.a();
        if (r104 == null) goto L6;
        o.a r105 = r104.d();
        if (r105 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("tag", "key");
        r105.a("tag");
        new HashMap();
        r105.b();
        if (r101 != null) goto L31;
        Map<String, Object> r106 = null;
    L14:
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == false) goto L21;
        r105.b();     // Catch: Throwable -> L10
    L21:
        r105.flush();     // Catch: Throwable -> L10
        WebChromeClient r108 = this.f551955b;
        if (r108 == null) goto L28;
        boolean r113 = r108.onShowFileChooser(r110, r111, r112);
        j.e("LarkBaseWebChromeClient", "onShowFileChooser mClient clientResult = " + r113);
        if (r113 == true) goto L27;
        FileChooseHandlerV2 r109 = this.f551956c;
        r109.getClass();
        Intrinsics.checkNotNull(r112);
        r109.g(null, r111, r112.getAcceptTypes(), r112, false);
    L27:
        return true;
    L28:
        j.e("LarkBaseWebChromeClient", "onShowFileChooser default");
        FileChooseHandlerV2 r114 = this.f551956c;
        r114.getClass();
        Intrinsics.checkNotNull(r112);
        r114.g(null, r111, r112.getAcceptTypes(), r112, false);
        return true;
    L10:
        th = move-exception;
        throw th;
    L16:
        if ((!r106.isEmpty()) != true) goto L18;
        r107 = true;
        goto L19
    L31:
        r106 = r101.getCommonParams();     // Catch: Throwable -> L10
    L6:
        r105 = new k();
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onCreateWindow mClient");
        return this.f551955b.onCreateWindow(r100, r101, r102, r103);
    L6:
        j.e("LarkBaseWebChromeClient", "onCreateWindow default");
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsAlert mClient");
        return this.f551955b.onJsAlert(r100, r101, r102, r103);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsAlert default");
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsBeforeUnload mClient");
        return this.f551955b.onJsBeforeUnload(r100, r101, r102, r103);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsBeforeUnload default");
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsConfirm mClient");
        return this.f551955b.onJsConfirm(r100, r101, r102, r103);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsConfirm default");
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
        if (this.f551955b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsPrompt mClient");
        return this.f551955b.onJsPrompt(r100, r110, r111, r112, r113);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsPrompt default");
        return super.onJsPrompt(r100, r110, r111, r112, r113);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r100, String r101, long r102, long r103, long r104, WebStorage.QuotaUpdater r105) {
        super.onExceededDatabaseQuota(r100, r101, r102, r103, r104, r105);
    }
}
