package rq7;

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
import com.bytedance.webx.event.EventManager;
import f06.d;
import java.util.ArrayList;
import pq7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends sq7.a {

    /* JADX INFO: renamed from: rq7.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC7520a extends com.bytedance.webx.event.a<a> {
        public final Bitmap e() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getDefaultVideoPoster");
            if ((r100 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r100).e();
        L7:
            return a.q(b());
        }

        public final View f() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getVideoLoadingProgressView");
            if ((r100 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r100).f();
        L7:
            return a.r(b());
        }

        public final void m() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onGeolocationPermissionsHidePrompt");
            if ((r100 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r100).m();
            return;
        L5:
            a.j(b());
        }

        public final void o() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onHideCustomView");
            if ((r100 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r100).o();
            return;
        L5:
            a.x(b());
        }

        public final boolean t() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onJsTimeout");
            if ((r100 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r100).t();
        L7:
            return a.n(b());
        }

        public AbstractC7520a() {
        }

        public final void A(WebView r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onRequestFocus");
            if ((r101 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r101).A(r100);
            return;
        L5:
            a.z(b(), r100);
        }

        public final void g(ValueCallback<String[]> r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "getVisitedHistory");
            if ((r101 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r101).g(r100);
            return;
        L5:
            a.s(b(), r100);
        }

        public final void h(WebView r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onCloseWindow");
            if ((r101 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r101).h(r100);
            return;
        L5:
            a.A(b(), r100);
        }

        public final boolean j(ConsoleMessage r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onConsoleMessage");
            if ((r101 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r101).j(r100);
        L7:
            return a.p(b(), r100);
        }

        public final void u(PermissionRequest r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onPermissionRequest");
            if ((r101 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r101).u(r100);
            return;
        L5:
            a.k(b(), r100);
        }

        public final void v(PermissionRequest r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onPermissionRequestCanceled");
            if ((r101 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r101).v(r100);
            return;
        L5:
            a.l(b(), r100);
        }

        public final void C(View r100, WebChromeClient.CustomViewCallback r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onShowCustomView");
            if ((r102 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r102).C(r100, r101);
            return;
        L5:
            a.v(b(), r100, r101);
        }

        public final void n(String r100, GeolocationPermissions.Callback r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onGeolocationPermissionsShowPrompt");
            if ((r102 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r102).n(r100, r101);
            return;
        L5:
            a.i(b(), r100, r101);
        }

        public void w(WebView r100, int r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onProgressChanged");
            if ((r102 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r102).w(r100, r101);
            return;
        L5:
            a.a(b(), r100, r101);
        }

        public final void x(WebView r100, Bitmap r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onReceivedIcon");
            if ((r102 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r102).x(r100, r101);
            return;
        L5:
            a.m(b(), r100, r101);
        }

        public final void y(WebView r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onReceivedTitle");
            if ((r102 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r102).y(r100, r101);
            return;
        L5:
            a.c(b(), r100, r101);
        }

        public final void B(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onShowCustomView");
            if ((r103 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r103).B(r100, r101, r102);
            return;
        L5:
            a.w(b(), r100, r101, r102);
        }

        public final boolean D(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onShowFileChooser");
            if ((r103 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r103).D(r100, r101, r102);
        L7:
            return a.t(b(), r100, r101, r102);
        }

        public final void i(String r100, int r101, String r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onConsoleMessage");
            if ((r103 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r103).i(r100, r101, r102);
            return;
        L5:
            a.o(b(), r100, r101, r102);
        }

        public final void z(WebView r100, String r101, boolean r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onReceivedTouchIconUrl");
            if ((r103 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r103).z(r100, r101, r102);
            return;
        L5:
            a.u(b(), r100, r101, r102);
        }

        public final boolean k(WebView r100, boolean r101, boolean r102, Message r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onCreateWindow");
            if ((r104 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r104).k(r100, r101, r102, r103);
        L7:
            return a.y(b(), r100, r101, r102, r103);
        }

        public final boolean p(WebView r100, String r101, String r102, JsResult r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onJsAlert");
            if ((r104 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r104).p(r100, r101, r102, r103);
        L7:
            return a.d(b(), r100, r101, r102, r103);
        }

        public final boolean q(WebView r100, String r101, String r102, JsResult r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onJsBeforeUnload");
            if ((r104 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r104).q(r100, r101, r102, r103);
        L7:
            return a.g(b(), r100, r101, r102, r103);
        }

        public final boolean r(WebView r100, String r101, String r102, JsResult r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onJsConfirm");
            if ((r104 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r104).r(r100, r101, r102, r103);
        L7:
            return a.e(b(), r100, r101, r102, r103);
        }

        public final boolean s(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onJsPrompt");
            if ((r101 instanceof AbstractC7520a) == false) goto L7;
            return ((AbstractC7520a) r101).s(r100, r110, r111, r112, r113);
        L7:
            return a.f(b(), r100, r110, r111, r112, r113);
        }

        public final void l(String r110, String r111, long r112, long r113, long r210, WebStorage.QuotaUpdater r211) {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onExceededDatabaseQuota");
            if ((r100 instanceof AbstractC7520a) == false) goto L5;
            ((AbstractC7520a) r100).l(r110, r111, r112, r113, r210, r211);
            return;
        L5:
            a.h(b(), r110, r111, r112, r113, r210, r211);
        }
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getDefaultVideoPoster");
        if ((r100 instanceof AbstractC7520a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        Bitmap r102 = ((AbstractC7520a) r100).e();
        r101.get().a();
        return r102;
    L7:
        return super.getDefaultVideoPoster();
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getVideoLoadingProgressView");
        if ((r100 instanceof AbstractC7520a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        View r102 = ((AbstractC7520a) r100).f();
        r101.get().a();
        return r102;
    L7:
        return super.getVideoLoadingProgressView();
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onGeolocationPermissionsHidePrompt");
        if ((r100 instanceof AbstractC7520a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((AbstractC7520a) r100).m();
        r101.get().a();
        return;
    L5:
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onHideCustomView");
        if ((r100 instanceof AbstractC7520a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((AbstractC7520a) r100).o();
        r101.get().a();
        return;
    L5:
        super.onHideCustomView();
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onJsTimeout");
        if ((r100 instanceof AbstractC7520a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((AbstractC7520a) r100).t();
        r101.get().a();
        return r102;
    L7:
        return super.onJsTimeout();
    }

    public a() {
    }

    public static void j(a r100) {
        super.onGeolocationPermissionsHidePrompt();
    }

    public static boolean n(a r100) {
        return super.onJsTimeout();
    }

    public static Bitmap q(a r100) {
        return super.getDefaultVideoPoster();
    }

    public static View r(a r100) {
        return super.getVideoLoadingProgressView();
    }

    public static void x(a r100) {
        super.onHideCustomView();
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "getVisitedHistory");
        if ((r101 instanceof AbstractC7520a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((AbstractC7520a) r101).g(r100);
        r102.get().a();
        return;
    L5:
        super.getVisitedHistory(r100);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onCloseWindow");
        if ((r101 instanceof AbstractC7520a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((AbstractC7520a) r101).h(r100);
        r102.get().a();
        return;
    L5:
        super.onCloseWindow(r100);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onConsoleMessage");
        if ((r101 instanceof AbstractC7520a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((AbstractC7520a) r101).j(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onConsoleMessage(r100);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onPermissionRequest");
        if ((r101 instanceof AbstractC7520a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((AbstractC7520a) r101).u(r100);
        r102.get().a();
        return;
    L5:
        super.onPermissionRequest(r100);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onPermissionRequestCanceled");
        if ((r101 instanceof AbstractC7520a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((AbstractC7520a) r101).v(r100);
        r102.get().a();
        return;
    L5:
        super.onPermissionRequestCanceled(r100);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onRequestFocus(WebView r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onRequestFocus");
        if ((r101 instanceof AbstractC7520a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((AbstractC7520a) r101).A(r100);
        r102.get().a();
        return;
    L5:
        super.onRequestFocus(r100);
    }

    public static void A(a r100, WebView r101) {
        super.onCloseWindow(r101);
    }

    public static void k(a r100, PermissionRequest r101) {
        super.onPermissionRequest(r101);
    }

    public static void l(a r100, PermissionRequest r101) {
        super.onPermissionRequestCanceled(r101);
    }

    public static boolean p(a r100, ConsoleMessage r101) {
        return super.onConsoleMessage(r101);
    }

    public static void s(a r100, ValueCallback r101) {
        super.getVisitedHistory(r101);
    }

    public static void z(a r100, WebView r101) {
        super.onRequestFocus(r101);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
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
        d r106 = r105.preInvoke(100003, "com/bytedance/webx/core/webview/client/WebChromeContainerClient", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L24
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L24
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        com.bytedance.webx.event.a r107 = EventManager.b(getExtendableContext(), "onGeolocationPermissionsShowPrompt");
        if ((r107 instanceof AbstractC7520a) == false) goto L22;
        c.b r108 = c.f530286b;
        r108.get().b();
        ((AbstractC7520a) r107).n(r210, r211);
        r108.get().a();
        return;
    L22:
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

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onProgressChanged");
        if ((r102 instanceof AbstractC7520a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((AbstractC7520a) r102).w(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onProgressChanged(r100, r101);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView r100, Bitmap r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onReceivedIcon");
        if ((r102 instanceof AbstractC7520a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((AbstractC7520a) r102).x(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onReceivedIcon(r100, r101);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onReceivedTitle");
        if ((r102 instanceof AbstractC7520a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((AbstractC7520a) r102).y(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onReceivedTitle(r100, r101);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onShowCustomView");
        if ((r102 instanceof AbstractC7520a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((AbstractC7520a) r102).C(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onShowCustomView(r100, r101);
    }

    public static void a(a r100, WebView r101, int r102) {
        super.onProgressChanged(r101, r102);
    }

    public static void c(a r100, WebView r101, String r102) {
        super.onReceivedTitle(r101, r102);
    }

    public static void i(a r100, String r101, GeolocationPermissions.Callback r102) {
        super.onGeolocationPermissionsShowPrompt(r101, r102);
    }

    public static void m(a r100, WebView r101, Bitmap r102) {
        super.onReceivedIcon(r101, r102);
    }

    public static void v(a r100, View r101, WebChromeClient.CustomViewCallback r102) {
        super.onShowCustomView(r101, r102);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onConsoleMessage(String r100, int r101, String r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onConsoleMessage");
        if ((r103 instanceof AbstractC7520a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((AbstractC7520a) r103).i(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onConsoleMessage(r100, r101, r102);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onReceivedTouchIconUrl");
        if ((r103 instanceof AbstractC7520a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((AbstractC7520a) r103).z(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onShowCustomView");
        if ((r103 instanceof AbstractC7520a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((AbstractC7520a) r103).B(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onShowCustomView(r100, r101, r102);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onShowFileChooser");
        if ((r103 instanceof AbstractC7520a) == false) goto L7;
        c.b r104 = c.f530286b;
        r104.get().b();
        boolean r105 = ((AbstractC7520a) r103).D(r100, r101, r102);
        r104.get().a();
        return r105;
    L7:
        return super.onShowFileChooser(r100, r101, r102);
    }

    public static void o(a r100, String r101, int r102, String r103) {
        super.onConsoleMessage(r101, r102, r103);
    }

    public static boolean t(a r100, WebView r101, ValueCallback r102, WebChromeClient.FileChooserParams r103) {
        return super.onShowFileChooser(r101, r102, r103);
    }

    public static void u(a r100, WebView r101, String r102, boolean r103) {
        super.onReceivedTouchIconUrl(r101, r102, r103);
    }

    public static void w(a r100, View r101, int r102, WebChromeClient.CustomViewCallback r103) {
        super.onShowCustomView(r101, r102, r103);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onCreateWindow");
        if ((r104 instanceof AbstractC7520a) == false) goto L7;
        c.b r105 = c.f530286b;
        r105.get().b();
        boolean r106 = ((AbstractC7520a) r104).k(r100, r101, r102, r103);
        r105.get().a();
        return r106;
    L7:
        return super.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onJsAlert");
        if ((r104 instanceof AbstractC7520a) == false) goto L7;
        c.b r105 = c.f530286b;
        r105.get().b();
        boolean r106 = ((AbstractC7520a) r104).p(r100, r101, r102, r103);
        r105.get().a();
        return r106;
    L7:
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onJsBeforeUnload");
        if ((r104 instanceof AbstractC7520a) == false) goto L7;
        c.b r105 = c.f530286b;
        r105.get().b();
        boolean r106 = ((AbstractC7520a) r104).q(r100, r101, r102, r103);
        r105.get().a();
        return r106;
    L7:
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onJsConfirm");
        if ((r104 instanceof AbstractC7520a) == false) goto L7;
        c.b r105 = c.f530286b;
        r105.get().b();
        boolean r106 = ((AbstractC7520a) r104).r(r100, r101, r102, r103);
        r105.get().a();
        return r106;
    L7:
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    public static boolean d(a r100, WebView r101, String r102, String r103, JsResult r104) {
        return super.onJsAlert(r101, r102, r103, r104);
    }

    public static boolean e(a r100, WebView r101, String r102, String r103, JsResult r104) {
        return super.onJsConfirm(r101, r102, r103, r104);
    }

    public static boolean g(a r100, WebView r101, String r102, String r103, JsResult r104) {
        return super.onJsBeforeUnload(r101, r102, r103, r104);
    }

    public static boolean y(a r100, WebView r101, boolean r102, boolean r103, Message r104) {
        return super.onCreateWindow(r101, r102, r103, r104);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r110, String r111, String r112, String r113, JsPromptResult r114) {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onJsPrompt");
        if ((r100 instanceof AbstractC7520a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r115 = ((AbstractC7520a) r100).s(r110, r111, r112, r113, r114);
        r101.get().a();
        return r115;
    L7:
        return super.onJsPrompt(r110, r111, r112, r113, r114);
    }

    public static boolean f(a r100, WebView r101, String r102, String r103, String r104, JsPromptResult r105) {
        return super.onJsPrompt(r101, r102, r103, r104, r105);
    }

    @Override // sq7.a, android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String r110, String r111, long r112, long r113, long r210, WebStorage.QuotaUpdater r211) {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onExceededDatabaseQuota");
        if ((r100 instanceof AbstractC7520a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((AbstractC7520a) r100).l(r110, r111, r112, r113, r210, r211);
        r101.get().a();
        return;
    L5:
        super.onExceededDatabaseQuota(r110, r111, r112, r113, r210, r211);
    }

    public static void h(a r100, String r101, String r102, long r103, long r104, long r105, WebStorage.QuotaUpdater r106) {
        super.onExceededDatabaseQuota(r101, r102, r103, r104, r105, r106);
    }
}
