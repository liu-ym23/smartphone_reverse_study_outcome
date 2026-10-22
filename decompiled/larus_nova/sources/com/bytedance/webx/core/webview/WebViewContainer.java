package com.bytedance.webx.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.webx.core.webview.inner.WebViewContainerInner;
import com.bytedance.webx.event.EventManager;
import iq7.d;
import java.util.Map;
import java.util.concurrent.Executor;
import pq7.c;

/* JADX INFO: loaded from: classes22.dex */
public class WebViewContainer extends WebViewContainerInner {

    public static abstract class a extends com.bytedance.webx.event.a<WebViewContainer> implements d {
        public final void A() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "goForward");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).A();
            return;
        L5:
            WebViewContainer.q(b());
        }

        public final void C0() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "stopLoading");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).C0();
            return;
        L5:
            WebViewContainer.k(b());
        }

        public final boolean E0() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "zoomIn");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).E0();
        L7:
            return WebViewContainer.R(b());
        }

        public final void F() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onAttachedToWindow");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).F();
            return;
        L5:
            WebViewContainer.T(b());
        }

        public final boolean F0() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "zoomOut");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).F0();
        L7:
            return WebViewContainer.S(b());
        }

        public final boolean G() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onCheckIsTextEditor");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).G();
        L7:
            return WebViewContainer.x0(b());
        }

        public final void L() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onFinishTemporaryDetach");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).L();
            return;
        L5:
            WebViewContainer.w0(b());
        }

        public final void V() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onPause");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).V();
            return;
        L5:
            WebViewContainer.v(b());
        }

        public final void Y() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onResume");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).Y();
            return;
        L5:
            WebViewContainer.w(b());
        }

        public final void b0() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "onStartTemporaryDetach");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).b0();
            return;
        L5:
            WebViewContainer.v0(b());
        }

        public final boolean f() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "canGoBack");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).f();
        L7:
            return WebViewContainer.m(b());
        }

        public final boolean h() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "canGoForward");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).h();
        L7:
            return WebViewContainer.p(b());
        }

        public final WebMessagePort[] i() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "createWebMessageChannel");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).i();
        L7:
            return WebViewContainer.M(b());
        }

        public final void j() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, MapMonitorConst.EVENT_DESTROY);
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).j();
            return;
        L5:
            WebViewContainer.V(b());
        }

        public final void m0() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "reload");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).m0();
            return;
        L5:
            WebViewContainer.l(b());
        }

        public final SslCertificate r() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getCertificate");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).r();
        L7:
            return WebViewContainer.c(b());
        }

        public final WebSettings t() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getSettings");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).t();
        L7:
            return WebViewContainer.O(b());
        }

        public final WebChromeClient u() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getWebChromeClient");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).u();
        L7:
            return WebViewContainer.I(b());
        }

        public final WebViewClient v() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getWebViewClient");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).v();
        L7:
            return WebViewContainer.B(b());
        }

        public final WebViewRenderProcess w() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getWebViewRenderProcess");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).w();
        L7:
            return WebViewContainer.C(b());
        }

        public final WebViewRenderProcessClient x() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "getWebViewRenderProcessClient");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).x();
        L7:
            return WebViewContainer.F(b());
        }

        public final void y() {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "goBack");
            if ((r100 instanceof a) == false) goto L5;
            ((a) r100).y();
            return;
        L5:
            WebViewContainer.n(b());
        }

        public a() {
        }

        public final void A0(WebViewRenderProcessClient r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "setWebViewRenderProcessClient");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).A0(r100);
            return;
        L5:
            WebViewContainer.E(b(), r100);
        }

        public void D(String r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "loadUrl");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).D(r100);
            return;
        L5:
            WebViewContainer.D0(b(), r100);
        }

        public final void D0(float r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "zoomBy");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).D0(r100);
            return;
        L5:
            WebViewContainer.Q(b(), r100);
        }

        public final void H(Configuration r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onConfigurationChanged");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).H(r100);
            return;
        L5:
            WebViewContainer.i0(b(), r100);
        }

        public final InputConnection I(EditorInfo r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onCreateInputConnection");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).I(r100);
        L7:
            return WebViewContainer.j0(b(), r100);
        }

        public final boolean J(DragEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onDragEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).J(r100);
        L7:
            return WebViewContainer.k0(b(), r100);
        }

        public final void K(Canvas r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onDraw");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).K(r100);
            return;
        L5:
            WebViewContainer.h0(b(), r100);
        }

        public final boolean N(MotionEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onGenericMotionEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).N(r100);
        L7:
            return WebViewContainer.X(b(), r100);
        }

        public final boolean O(MotionEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onHoverEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).O(r100);
        L7:
            return WebViewContainer.U(b(), r100);
        }

        public final boolean P(MotionEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onInterceptTouchEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).P(r100);
        L7:
            return WebViewContainer.B0(b(), r100);
        }

        public final void X(ViewStructure r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onProvideVirtualStructure");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).X(r100);
            return;
        L5:
            WebViewContainer.c0(b(), r100);
        }

        public final boolean c0(MotionEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onTouchEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).c0(r100);
        L7:
            return WebViewContainer.W(b(), r100);
        }

        public final boolean d0(MotionEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onTrackballEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).d0(r100);
        L7:
            return WebViewContainer.Y(b(), r100);
        }

        public final void f0(boolean r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onWindowFocusChanged");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).f0(r100);
            return;
        L5:
            WebViewContainer.m0(b(), r100);
        }

        public final boolean g(int r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "canGoBackOrForward");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).g(r100);
        L7:
            return WebViewContainer.r(b(), r100);
        }

        public final void g0(int r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "onWindowVisibilityChanged");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).g0(r100);
            return;
        L5:
            WebViewContainer.f0(b(), r100);
        }

        public final boolean i0(boolean r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "pageDown");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).i0(r100);
        L7:
            return WebViewContainer.u(b(), r100);
        }

        public final boolean j0(boolean r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "pageUp");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).j0(r100);
        L7:
            return WebViewContainer.t(b(), r100);
        }

        public final void k(Canvas r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "dispatchDraw");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).k(r100);
            return;
        L5:
            WebViewContainer.u0(b(), r100);
        }

        public final boolean l(KeyEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "dispatchKeyEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).l(r100);
        L7:
            return WebViewContainer.q0(b(), r100);
        }

        public final boolean m(MotionEvent r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "dispatchTouchEvent");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).m(r100);
        L7:
            return WebViewContainer.A0(b(), r100);
        }

        public final void n(Message r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "documentHasImages");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).n(r100);
            return;
        L5:
            WebViewContainer.y(b(), r100);
        }

        public final void n0(String r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "removeJavascriptInterface");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).n0(r100);
            return;
        L5:
            WebViewContainer.L(b(), r100);
        }

        public final void o(Canvas r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "draw");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).o(r100);
            return;
        L5:
            WebViewContainer.z0(b(), r100);
        }

        public final WebBackForwardList p0(Bundle r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "restoreState");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).p0(r100);
        L7:
            return WebViewContainer.r0(b(), r100);
        }

        public final WebBackForwardList r0(Bundle r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "saveState");
            if ((r101 instanceof a) == false) goto L7;
            return ((a) r101).r0(r100);
        L7:
            return WebViewContainer.g0(b(), r100);
        }

        public final void s0(String r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "saveWebArchive");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).s0(r100);
            return;
        L5:
            WebViewContainer.i(b(), r100);
        }

        public final void u0(SslCertificate r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "setCertificate");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).u0(r100);
            return;
        L5:
            WebViewContainer.d(b(), r100);
        }

        public final void v0(DownloadListener r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "setDownloadListener");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).v0(r100);
            return;
        L5:
            WebViewContainer.G(b(), r100);
        }

        public final void w0(WebView.FindListener r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "setFindListener");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).w0(r100);
            return;
        L5:
            WebViewContainer.x(b(), r100);
        }

        public final void y0(WebChromeClient r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "setWebChromeClient");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).y0(r100);
            return;
        L5:
            WebViewContainer.H(b(), r100);
        }

        public final void z(int r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "goBackOrForward");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).z(r100);
            return;
        L5:
            WebViewContainer.s(b(), r100);
        }

        public final void z0(WebViewClient r100) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "setWebViewClient");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).z0(r100);
            return;
        L5:
            WebViewContainer.A(b(), r100);
        }

        public final void B0(Executor r100, WebViewRenderProcessClient r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "setWebViewRenderProcessClient");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).B0(r100, r101);
            return;
        L5:
            WebViewContainer.D(b(), r100, r101);
        }

        public void E(String r100, Map<String, String> r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "loadUrl");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).E(r100, r101);
            return;
        L5:
            WebViewContainer.C0(b(), r100, r101);
        }

        public final boolean Q(int r100, KeyEvent r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onKeyDown");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).Q(r100, r101);
        L7:
            return WebViewContainer.Z(b(), r100, r101);
        }

        public final boolean S(int r100, KeyEvent r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onKeyUp");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).S(r100, r101);
        L7:
            return WebViewContainer.a0(b(), r100, r101);
        }

        public final void T(int r100, int r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onMeasure");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).T(r100, r101);
            return;
        L5:
            WebViewContainer.t0(b(), r100, r101);
        }

        public final void W(ViewStructure r100, int r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onProvideAutofillVirtualStructure");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).W(r100, r101);
            return;
        L5:
            WebViewContainer.d0(b(), r100, r101);
        }

        public final void e(Object r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "addJavascriptInterface");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).e(r100, r101);
            return;
        L5:
            WebViewContainer.J(b(), r100, r101);
        }

        public final void e0(View r100, int r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onVisibilityChanged");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).e0(r100, r101);
            return;
        L5:
            WebViewContainer.l0(b(), r100, r101);
        }

        public final void k0(String r100, byte[] r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "postUrl");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).k0(r100, r101);
            return;
        L5:
            WebViewContainer.e(b(), r100, r101);
        }

        public final void l0(WebMessage r100, Uri r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "postWebMessage");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).l0(r100, r101);
            return;
        L5:
            WebViewContainer.N(b(), r100, r101);
        }

        public final boolean o0(int r100, Rect r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "requestFocus");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).o0(r100, r101);
        L7:
            return WebViewContainer.s0(b(), r100, r101);
        }

        public final void p(String r100, ValueCallback<String> r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "evaluateJavascript");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).p(r100, r101);
            return;
        L5:
            WebViewContainer.h(b(), r100, r101);
        }

        public final void q(int r100, int r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "flingScroll");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).q(r100, r101);
            return;
        L5:
            WebViewContainer.P(b(), r100, r101);
        }

        public final String[] s(String r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "getHttpAuthUsernamePassword");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).s(r100, r101);
        L7:
            return WebViewContainer.K(b(), r100, r101);
        }

        public final void B(String r100, String r101, String r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "loadData");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).B(r100, r101, r102);
            return;
        L5:
            WebViewContainer.f(b(), r100, r101, r102);
        }

        public final void M(boolean r100, int r101, Rect r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onFocusChanged");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).M(r100, r101, r102);
            return;
        L5:
            WebViewContainer.n0(b(), r100, r101, r102);
        }

        public final boolean R(int r100, int r101, KeyEvent r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onKeyMultiple");
            if ((r103 instanceof a) == false) goto L7;
            return ((a) r103).R(r100, r101, r102);
        L7:
            return WebViewContainer.b0(b(), r100, r101, r102);
        }

        public final void q0(String r100, String r101, String r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "savePassword");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).q0(r100, r101, r102);
            return;
        L5:
            WebViewContainer.o(b(), r100, r101, r102);
        }

        public final void t0(String r100, boolean r101, ValueCallback<String> r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "saveWebArchive");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).t0(r100, r101, r102);
            return;
        L5:
            WebViewContainer.j(b(), r100, r101, r102);
        }

        public final void U(int r100, int r101, boolean r102, boolean r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onOverScrolled");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).U(r100, r101, r102, r103);
            return;
        L5:
            WebViewContainer.e0(b(), r100, r101, r102, r103);
        }

        public final void Z(int r100, int r101, int r102, int r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onScrollChanged");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).Z(r100, r101, r102, r103);
            return;
        L5:
            WebViewContainer.p0(b(), r100, r101, r102, r103);
        }

        public final void a0(int r100, int r101, int r102, int r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onSizeChanged");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).a0(r100, r101, r102, r103);
            return;
        L5:
            WebViewContainer.o0(b(), r100, r101, r102, r103);
        }

        public final void x0(String r100, String r101, String r102, String r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "setHttpAuthUsernamePassword");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).x0(r100, r101, r102, r103);
            return;
        L5:
            WebViewContainer.z(b(), r100, r101, r102, r103);
        }

        public final void C(String r100, String r110, String r111, String r112, String r113) {
            com.bytedance.webx.event.a r101 = EventManager.a(c(), this, "loadDataWithBaseURL");
            if ((r101 instanceof a) == false) goto L5;
            ((a) r101).C(r100, r110, r111, r112, r113);
            return;
        L5:
            WebViewContainer.g(b(), r100, r110, r111, r112, r113);
        }

        public final boolean h0(int r110, int r111, int r112, int r113, int r114, int r115, int r210, int r211, boolean r212) {
            com.bytedance.webx.event.a r100 = EventManager.a(c(), this, "overScrollBy");
            if ((r100 instanceof a) == false) goto L7;
            return ((a) r100).h0(r110, r111, r112, r113, r114, r115, r210, r211, r212);
        L7:
            return WebViewContainer.y0(b(), r110, r111, r112, r113, r114, r115, r210, r211, r212);
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "canGoBack");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((a) r100).f();
        r101.get().a();
        return r102;
    L7:
        return super.canGoBack();
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "canGoForward");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((a) r100).h();
        r101.get().a();
        return r102;
    L7:
        return super.canGoForward();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public final WebMessagePort[] createWebMessageChannel() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "createWebMessageChannel");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        WebMessagePort[] r102 = ((a) r100).i();
        r101.get().a();
        return r102;
    L7:
        return super.createWebMessageChannel();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), MapMonitorConst.EVENT_DESTROY);
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).j();
        r101.get().a();
        return;
    L5:
        super.destroy();
    }

    @Override // android.webkit.WebView
    public SslCertificate getCertificate() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getCertificate");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        SslCertificate r102 = ((a) r100).r();
        r101.get().a();
        return r102;
    L7:
        return super.getCertificate();
    }

    @Override // android.webkit.WebView
    public WebSettings getSettings() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getSettings");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        WebSettings r102 = ((a) r100).t();
        r101.get().a();
        return r102;
    L7:
        return super.getSettings();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getWebChromeClient");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        WebChromeClient r102 = ((a) r100).u();
        r101.get().a();
        return r102;
    L7:
        return super.getWebChromeClient();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public WebViewClient getWebViewClient() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getWebViewClient");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        WebViewClient r102 = ((a) r100).v();
        r101.get().a();
        return r102;
    L7:
        return super.getWebViewClient();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public WebViewRenderProcess getWebViewRenderProcess() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getWebViewRenderProcess");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        WebViewRenderProcess r102 = ((a) r100).w();
        r101.get().a();
        return r102;
    L7:
        return super.getWebViewRenderProcess();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "getWebViewRenderProcessClient");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        WebViewRenderProcessClient r102 = ((a) r100).x();
        r101.get().a();
        return r102;
    L7:
        return super.getWebViewRenderProcessClient();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "goBack");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).y();
        r101.get().a();
        return;
    L5:
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goForward() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "goForward");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).A();
        r101.get().a();
        return;
    L5:
        super.goForward();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onAttachedToWindow");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).F();
        r101.get().a();
        return;
    L5:
        super.onAttachedToWindow();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onCheckIsTextEditor() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onCheckIsTextEditor");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((a) r100).G();
        r101.get().a();
        return r102;
    L7:
        return super.onCheckIsTextEditor();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onFinishTemporaryDetach() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onFinishTemporaryDetach");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).L();
        r101.get().a();
        return;
    L5:
        super.onFinishTemporaryDetach();
    }

    @Override // android.webkit.WebView
    public void onPause() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onPause");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).V();
        r101.get().a();
        return;
    L5:
        super.onPause();
    }

    @Override // android.webkit.WebView
    public void onResume() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onResume");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).Y();
        r101.get().a();
        return;
    L5:
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onStartTemporaryDetach() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "onStartTemporaryDetach");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).b0();
        r101.get().a();
        return;
    L5:
        super.onStartTemporaryDetach();
    }

    @Override // android.webkit.WebView
    public void reload() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "reload");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).m0();
        r101.get().a();
        return;
    L5:
        super.reload();
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "stopLoading");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).C0();
        r101.get().a();
        return;
    L5:
        super.stopLoading();
    }

    @Override // android.webkit.WebView
    public final boolean zoomIn() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "zoomIn");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((a) r100).E0();
        r101.get().a();
        return r102;
    L7:
        return super.zoomIn();
    }

    @Override // android.webkit.WebView
    public final boolean zoomOut() {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "zoomOut");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((a) r100).F0();
        r101.get().a();
        return r102;
    L7:
        return super.zoomOut();
    }

    public WebViewContainer(Context r100) {
        super(r100);
    }

    public static WebViewClient B(WebViewContainer r100) {
        return super.getWebViewClient();
    }

    public static WebViewRenderProcess C(WebViewContainer r100) {
        return super.getWebViewRenderProcess();
    }

    public static WebViewRenderProcessClient F(WebViewContainer r100) {
        return super.getWebViewRenderProcessClient();
    }

    public static WebChromeClient I(WebViewContainer r100) {
        return super.getWebChromeClient();
    }

    public static WebMessagePort[] M(WebViewContainer r100) {
        return super.createWebMessageChannel();
    }

    public static WebSettings O(WebViewContainer r100) {
        return super.getSettings();
    }

    public static boolean R(WebViewContainer r100) {
        return super.zoomIn();
    }

    public static boolean S(WebViewContainer r100) {
        return super.zoomOut();
    }

    public static void T(WebViewContainer r100) {
        super.onAttachedToWindow();
    }

    public static void V(WebViewContainer r100) {
        super.destroy();
    }

    public static SslCertificate c(WebViewContainer r100) {
        return super.getCertificate();
    }

    public static void k(WebViewContainer r100) {
        super.stopLoading();
    }

    public static void l(WebViewContainer r100) {
        super.reload();
    }

    public static boolean m(WebViewContainer r100) {
        return super.canGoBack();
    }

    public static void n(WebViewContainer r100) {
        super.goBack();
    }

    public static boolean p(WebViewContainer r100) {
        return super.canGoForward();
    }

    public static void q(WebViewContainer r100) {
        super.goForward();
    }

    public static void v(WebViewContainer r100) {
        super.onPause();
    }

    public static void v0(WebViewContainer r100) {
        super.onStartTemporaryDetach();
    }

    public static void w(WebViewContainer r100) {
        super.onResume();
    }

    public static void w0(WebViewContainer r100) {
        super.onFinishTemporaryDetach();
    }

    public static boolean x0(WebViewContainer r100) {
        return super.onCheckIsTextEditor();
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "canGoBackOrForward");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).g(r100);
        r102.get().a();
        return r103;
    L7:
        return super.canGoBackOrForward(r100);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "dispatchDraw");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).k(r100);
        r102.get().a();
        return;
    L5:
        super.dispatchDraw(r100);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "dispatchKeyEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).l(r100);
        r102.get().a();
        return r103;
    L7:
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "dispatchTouchEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).m(r100);
        r102.get().a();
        return r103;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.webkit.WebView
    public final void documentHasImages(Message r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "documentHasImages");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).n(r100);
        r102.get().a();
        return;
    L5:
        super.documentHasImages(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "draw");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).o(r100);
        r102.get().a();
        return;
    L5:
        super.draw(r100);
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "goBackOrForward");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).z(r100);
        r102.get().a();
        return;
    L5:
        super.goBackOrForward(r100);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "loadUrl");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).D(r100);
        r102.get().a();
        return;
    L5:
        super.loadUrl(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onConfigurationChanged");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).H(r100);
        r102.get().a();
        return;
    L5:
        super.onConfigurationChanged(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onCreateInputConnection");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        InputConnection r103 = ((a) r101).I(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onCreateInputConnection(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onDragEvent(DragEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onDragEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).J(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onDragEvent(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onDraw");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).K(r100);
        r102.get().a();
        return;
    L5:
        super.onDraw(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onGenericMotionEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).N(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onGenericMotionEvent(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onHoverEvent(MotionEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onHoverEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).O(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onHoverEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onInterceptTouchEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).P(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, android.view.View
    public final void onProvideVirtualStructure(ViewStructure r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onProvideVirtualStructure");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).X(r100);
        r102.get().a();
        return;
    L5:
        super.onProvideVirtualStructure(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onTouchEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).c0(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onTouchEvent(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTrackballEvent(MotionEvent r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onTrackballEvent");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).d0(r100);
        r102.get().a();
        return r103;
    L7:
        return super.onTrackballEvent(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onWindowFocusChanged");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).f0(r100);
        r102.get().a();
        return;
    L5:
        super.onWindowFocusChanged(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "onWindowVisibilityChanged");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).g0(r100);
        r102.get().a();
        return;
    L5:
        super.onWindowVisibilityChanged(r100);
    }

    @Override // android.webkit.WebView
    public final boolean pageDown(boolean r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "pageDown");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).i0(r100);
        r102.get().a();
        return r103;
    L7:
        return super.pageDown(r100);
    }

    @Override // android.webkit.WebView
    public final boolean pageUp(boolean r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "pageUp");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        boolean r103 = ((a) r101).j0(r100);
        r102.get().a();
        return r103;
    L7:
        return super.pageUp(r100);
    }

    @Override // android.webkit.WebView
    public final void removeJavascriptInterface(String r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "removeJavascriptInterface");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).n0(r100);
        r102.get().a();
        return;
    L5:
        super.removeJavascriptInterface(r100);
    }

    @Override // android.webkit.WebView
    public final WebBackForwardList restoreState(Bundle r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "restoreState");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        WebBackForwardList r103 = ((a) r101).p0(r100);
        r102.get().a();
        return r103;
    L7:
        return super.restoreState(r100);
    }

    @Override // android.webkit.WebView
    public final WebBackForwardList saveState(Bundle r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "saveState");
        if ((r101 instanceof a) == false) goto L7;
        c.b r102 = c.f530286b;
        r102.get().b();
        WebBackForwardList r103 = ((a) r101).r0(r100);
        r102.get().a();
        return r103;
    L7:
        return super.saveState(r100);
    }

    @Override // android.webkit.WebView
    public final void saveWebArchive(String r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "saveWebArchive");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).s0(r100);
        r102.get().a();
        return;
    L5:
        super.saveWebArchive(r100);
    }

    @Override // android.webkit.WebView
    public void setCertificate(SslCertificate r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "setCertificate");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).u0(r100);
        r102.get().a();
        return;
    L5:
        super.setCertificate(r100);
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "setDownloadListener");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).v0(r100);
        r102.get().a();
        return;
    L5:
        super.setDownloadListener(r100);
    }

    @Override // android.webkit.WebView
    public void setFindListener(WebView.FindListener r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "setFindListener");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).w0(r100);
        r102.get().a();
        return;
    L5:
        super.setFindListener(r100);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "setWebChromeClient");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).y0(r100);
        r102.get().a();
        return;
    L5:
        super.setWebChromeClient(r100);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "setWebViewClient");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).z0(r100);
        r102.get().a();
        return;
    L5:
        super.setWebViewClient(r100);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebViewRenderProcessClient(WebViewRenderProcessClient r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "setWebViewRenderProcessClient");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).A0(r100);
        r102.get().a();
        return;
    L5:
        super.setWebViewRenderProcessClient(r100);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public final void zoomBy(float r100) {
        com.bytedance.webx.event.a r101 = EventManager.b(getExtendableContext(), "zoomBy");
        if ((r101 instanceof a) == false) goto L5;
        c.b r102 = c.f530286b;
        r102.get().b();
        ((a) r101).D0(r100);
        r102.get().a();
        return;
    L5:
        super.zoomBy(r100);
    }

    public WebViewContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public static void A(WebViewContainer r100, WebViewClient r101) {
        super.setWebViewClient(r101);
    }

    public static boolean A0(WebViewContainer r100, MotionEvent r101) {
        return super.dispatchTouchEvent(r101);
    }

    public static boolean B0(WebViewContainer r100, MotionEvent r101) {
        return super.onInterceptTouchEvent(r101);
    }

    public static void D0(WebViewContainer r100, String r101) {
        super.loadUrl(r101);
    }

    public static void E(WebViewContainer r100, WebViewRenderProcessClient r101) {
        super.setWebViewRenderProcessClient(r101);
    }

    public static void G(WebViewContainer r100, DownloadListener r101) {
        super.setDownloadListener(r101);
    }

    public static void H(WebViewContainer r100, WebChromeClient r101) {
        super.setWebChromeClient(r101);
    }

    public static void L(WebViewContainer r100, String r101) {
        super.removeJavascriptInterface(r101);
    }

    public static void Q(WebViewContainer r100, float r101) {
        super.zoomBy(r101);
    }

    public static boolean U(WebViewContainer r100, MotionEvent r101) {
        return super.onHoverEvent(r101);
    }

    public static boolean W(WebViewContainer r100, MotionEvent r101) {
        return super.onTouchEvent(r101);
    }

    public static boolean X(WebViewContainer r100, MotionEvent r101) {
        return super.onGenericMotionEvent(r101);
    }

    public static boolean Y(WebViewContainer r100, MotionEvent r101) {
        return super.onTrackballEvent(r101);
    }

    public static void c0(WebViewContainer r100, ViewStructure r101) {
        super.onProvideVirtualStructure(r101);
    }

    public static void d(WebViewContainer r100, SslCertificate r101) {
        super.setCertificate(r101);
    }

    public static void f0(WebViewContainer r100, int r101) {
        super.onWindowVisibilityChanged(r101);
    }

    public static WebBackForwardList g0(WebViewContainer r100, Bundle r101) {
        return super.saveState(r101);
    }

    public static void h0(WebViewContainer r100, Canvas r101) {
        super.onDraw(r101);
    }

    public static void i(WebViewContainer r100, String r101) {
        super.saveWebArchive(r101);
    }

    public static void i0(WebViewContainer r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    public static InputConnection j0(WebViewContainer r100, EditorInfo r101) {
        return super.onCreateInputConnection(r101);
    }

    public static boolean k0(WebViewContainer r100, DragEvent r101) {
        return super.onDragEvent(r101);
    }

    public static void m0(WebViewContainer r100, boolean r101) {
        super.onWindowFocusChanged(r101);
    }

    public static boolean q0(WebViewContainer r100, KeyEvent r101) {
        return super.dispatchKeyEvent(r101);
    }

    public static boolean r(WebViewContainer r100, int r101) {
        return super.canGoBackOrForward(r101);
    }

    public static WebBackForwardList r0(WebViewContainer r100, Bundle r101) {
        return super.restoreState(r101);
    }

    public static void s(WebViewContainer r100, int r101) {
        super.goBackOrForward(r101);
    }

    public static boolean t(WebViewContainer r100, boolean r101) {
        return super.pageUp(r101);
    }

    public static boolean u(WebViewContainer r100, boolean r101) {
        return super.pageDown(r101);
    }

    public static void u0(WebViewContainer r100, Canvas r101) {
        super.dispatchDraw(r101);
    }

    public static void x(WebViewContainer r100, WebView.FindListener r101) {
        super.setFindListener(r101);
    }

    public static void y(WebViewContainer r100, Message r101) {
        super.documentHasImages(r101);
    }

    public static void z0(WebViewContainer r100, Canvas r101) {
        super.draw(r101);
    }

    @Override // android.webkit.WebView
    public final void addJavascriptInterface(Object r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "addJavascriptInterface");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).e(r100, r101);
        r103.get().a();
        return;
    L5:
        super.addJavascriptInterface(r100, r101);
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String r100, ValueCallback<String> r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "evaluateJavascript");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).p(r100, r101);
        r103.get().a();
        return;
    L5:
        super.evaluateJavascript(r100, r101);
    }

    @Override // android.webkit.WebView
    public final void flingScroll(int r100, int r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "flingScroll");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).q(r100, r101);
        r103.get().a();
        return;
    L5:
        super.flingScroll(r100, r101);
    }

    @Override // android.webkit.WebView
    public final String[] getHttpAuthUsernamePassword(String r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "getHttpAuthUsernamePassword");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        String[] r104 = ((a) r102).s(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.getHttpAuthUsernamePassword(r100, r101);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100, Map<String, String> r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "loadUrl");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).E(r100, r101);
        r103.get().a();
        return;
    L5:
        super.loadUrl(r100, r101);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onKeyDown");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).Q(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r100, KeyEvent r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onKeyUp");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).S(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.onKeyUp(r100, r101);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onMeasure");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).T(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onMeasure(r100, r101);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView, android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure r100, int r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onProvideAutofillVirtualStructure");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).W(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onProvideAutofillVirtualStructure(r100, r101);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onVisibilityChanged");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).e0(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onVisibilityChanged(r100, r101);
    }

    @Override // android.webkit.WebView
    public void postUrl(String r100, byte[] r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "postUrl");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).k0(r100, r101);
        r103.get().a();
        return;
    L5:
        super.postUrl(r100, r101);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public final void postWebMessage(WebMessage r100, Uri r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "postWebMessage");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).l0(r100, r101);
        r103.get().a();
        return;
    L5:
        super.postWebMessage(r100, r101);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int r100, Rect r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "requestFocus");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).o0(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.requestFocus(r100, r101);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public final void setWebViewRenderProcessClient(Executor r100, WebViewRenderProcessClient r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "setWebViewRenderProcessClient");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).B0(r100, r101);
        r103.get().a();
        return;
    L5:
        super.setWebViewRenderProcessClient(r100, r101);
    }

    public WebViewContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public static void C0(WebViewContainer r100, String r101, Map r102) {
        super.loadUrl(r101, r102);
    }

    public static void D(WebViewContainer r100, Executor r101, WebViewRenderProcessClient r102) {
        super.setWebViewRenderProcessClient(r101, r102);
    }

    public static void J(WebViewContainer r100, Object r101, String r102) {
        super.addJavascriptInterface(r101, r102);
    }

    public static String[] K(WebViewContainer r100, String r101, String r102) {
        return super.getHttpAuthUsernamePassword(r101, r102);
    }

    public static void N(WebViewContainer r100, WebMessage r101, Uri r102) {
        super.postWebMessage(r101, r102);
    }

    public static void P(WebViewContainer r100, int r101, int r102) {
        super.flingScroll(r101, r102);
    }

    public static boolean Z(WebViewContainer r100, int r101, KeyEvent r102) {
        return super.onKeyDown(r101, r102);
    }

    public static boolean a0(WebViewContainer r100, int r101, KeyEvent r102) {
        return super.onKeyUp(r101, r102);
    }

    public static void d0(WebViewContainer r100, ViewStructure r101, int r102) {
        super.onProvideAutofillVirtualStructure(r101, r102);
    }

    public static void e(WebViewContainer r100, String r101, byte[] r102) {
        super.postUrl(r101, r102);
    }

    public static void h(WebViewContainer r100, String r101, ValueCallback r102) {
        super.evaluateJavascript(r101, r102);
    }

    public static void l0(WebViewContainer r100, View r101, int r102) {
        super.onVisibilityChanged(r101, r102);
    }

    public static boolean s0(WebViewContainer r100, int r101, Rect r102) {
        return super.requestFocus(r101, r102);
    }

    public static void t0(WebViewContainer r100, int r101, int r102) {
        super.onMeasure(r101, r102);
    }

    @Override // android.webkit.WebView
    public void loadData(String r100, String r101, String r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "loadData");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).B(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.loadData(r100, r101, r102);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onFocusChanged");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).M(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onFocusChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int r100, int r101, KeyEvent r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onKeyMultiple");
        if ((r103 instanceof a) == false) goto L7;
        c.b r104 = c.f530286b;
        r104.get().b();
        boolean r105 = ((a) r103).R(r100, r101, r102);
        r104.get().a();
        return r105;
    L7:
        return super.onKeyMultiple(r100, r101, r102);
    }

    @Override // android.webkit.WebView
    public final void savePassword(String r100, String r101, String r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "savePassword");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).q0(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.savePassword(r100, r101, r102);
    }

    @Override // android.webkit.WebView
    public final void saveWebArchive(String r100, boolean r101, ValueCallback<String> r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "saveWebArchive");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).t0(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.saveWebArchive(r100, r101, r102);
    }

    public static boolean b0(WebViewContainer r100, int r101, int r102, KeyEvent r103) {
        return super.onKeyMultiple(r101, r102, r103);
    }

    public static void f(WebViewContainer r100, String r101, String r102, String r103) {
        super.loadData(r101, r102, r103);
    }

    public static void j(WebViewContainer r100, String r101, boolean r102, ValueCallback r103) {
        super.saveWebArchive(r101, r102, r103);
    }

    public static void n0(WebViewContainer r100, boolean r101, int r102, Rect r103) {
        super.onFocusChanged(r101, r102, r103);
    }

    public static void o(WebViewContainer r100, String r101, String r102, String r103) {
        super.savePassword(r101, r102, r103);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int r100, int r101, boolean r102, boolean r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onOverScrolled");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).U(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onOverScrolled(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onScrollChanged");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).Z(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onScrollChanged(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onSizeChanged");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).a0(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onSizeChanged(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebView
    public final void setHttpAuthUsernamePassword(String r100, String r101, String r102, String r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "setHttpAuthUsernamePassword");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).x0(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.setHttpAuthUsernamePassword(r100, r101, r102, r103);
    }

    public static void e0(WebViewContainer r100, int r101, int r102, boolean r103, boolean r104) {
        super.onOverScrolled(r101, r102, r103, r104);
    }

    public static void o0(WebViewContainer r100, int r101, int r102, int r103, int r104) {
        super.onSizeChanged(r101, r102, r103, r104);
    }

    public static void p0(WebViewContainer r100, int r101, int r102, int r103, int r104) {
        super.onScrollChanged(r101, r102, r103, r104);
    }

    public static void z(WebViewContainer r100, String r101, String r102, String r103, String r104) {
        super.setHttpAuthUsernamePassword(r101, r102, r103, r104);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String r110, String r111, String r112, String r113, String r114) {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "loadDataWithBaseURL");
        if ((r100 instanceof a) == false) goto L5;
        c.b r101 = c.f530286b;
        r101.get().b();
        ((a) r100).C(r110, r111, r112, r113, r114);
        r101.get().a();
        return;
    L5:
        super.loadDataWithBaseURL(r110, r111, r112, r113, r114);
    }

    public static void g(WebViewContainer r100, String r101, String r102, String r103, String r104, String r105) {
        super.loadDataWithBaseURL(r101, r102, r103, r104, r105);
    }

    @Override // android.view.View
    public boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r210, int r211, boolean r212) {
        com.bytedance.webx.event.a r100 = EventManager.b(getExtendableContext(), "overScrollBy");
        if ((r100 instanceof a) == false) goto L7;
        c.b r101 = c.f530286b;
        r101.get().b();
        boolean r102 = ((a) r100).h0(r110, r111, r112, r113, r114, r115, r210, r211, r212);
        r101.get().a();
        return r102;
    L7:
        return super.overScrollBy(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public static boolean y0(WebViewContainer r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, boolean r109) {
        return super.overScrollBy(r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }
}
