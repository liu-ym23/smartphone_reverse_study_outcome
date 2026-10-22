package com.bytedance.ee.bear.drive.view.preview.wps;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.WpsPreviewView;
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.ContextsKt;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WpsView extends BaseWebPreviewView {
    public static final /* synthetic */ int D = 0;
    public h0 A;
    public boolean B;
    public final a C;
    public ArrayList<CommentRectF> h;
    public c95.c i;
    public p j;
    public boolean k;
    public long l;
    public ViewOwner m;
    public b n;
    public com.bytedance.ee.bear.drive.view.preview.wps.a o;
    public String p;
    public c q;
    public boolean r;
    public String s;
    public com.bytedance.ee.bear.drive.view.preview.wps.b t;
    public boolean u;
    public boolean v;
    public boolean w;
    public f x;
    public WpsViewModel y;
    public volatile boolean z;

    public class a implements Runnable {
        public final /* synthetic */ WpsView a;

        public final void a() {
            WpsView r0 = this.a;
            if (r0.r == true) goto L5;
            c95.c r1 = r0.i;
            if (r1 == null) goto L13;
            r1.a("wps", new Throwable(this.a.s));
        L13:
            j65.a.a(this.a.d, "WpsWebView");
            this.a.o.b.a();
            return;
        L5:
            if (r0.k == false) goto L9;
            c95.c r2 = r0.i;
            if (r2 == null) goto L9;
            r2.b("wps");
            this.a.o.b.b();
        L9:
            j65.a.c(this.a.d, "WpsWebView");
            this.a.k = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(WpsView r1) {
            this.a = r1;
        }
    }

    public class b {
        public final /* synthetic */ WpsView a;

        public b(WpsView r1) {
            this.a = r1;
        }

        @JavascriptInterface
        public void getAuthToken(String r4) {
            tt5.a.h("WpsWebView", "getAuthToken called");
            WpsView r5 = this.a;
            int r0 = WpsView.D;
            if (r5.i() == false) goto L5;
            return;
        L5:
            WpsView r6 = this.a;
            r6.b.add(r6.o.j().observeOn(fo5.d.d()).subscribe(new v0(this), new w0(this)));
        }

        @JavascriptInterface
        public void getInitialData(String r2) {
            tt5.a.h("WpsWebView", "getInitialData called");
            this.a.getInitData();
        }

        @JavascriptInterface
        public void getWpsIframeUrlHeadData(String r5) {
            tt5.a.h("WpsWebView", "getWpsIframeUrlHeadData called");
            final WpsView r0 = this.a;
            if (r0.q != null) goto L5;
            return;
        L5:
            if (r0.i() == true) goto L10;
            r0.b.add(r0.o.h(r5).observeOn(fo5.d.d()).subscribe(new z(r0), new a0(r0)));
            return;
        }

        @JavascriptInterface
        public void onHyperLinkOpen(String r5) {
            String r6 = new JSONObject(r5).optString("linkUrl");     // Catch: Exception -> L9
            tt5.a.h("WpsWebView", "onHyperLinkOpen() url=" + du5.b.g(r6));     // Catch: Exception -> L9
            Bundle r1 = new Bundle();     // Catch: Exception -> L9
            if (this.a.q.a == null) goto L6;
            r1.putSerializable("lk_seclink_params", mu5.b.e(new na5.b()));     // Catch: Exception -> L9
        L7:
            RouteBean r2 = new RouteBean();     // Catch: Exception -> L9
            r2.n = r1;     // Catch: Exception -> L9
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r6, r2);     // Catch: Exception -> L9
            return;
        L6:
            tt5.a.d("WpsWebView", "onHyperLinkOpen() fileModel is null");     // Catch: Exception -> L9
        L9:
            e = move-exception;
            tt5.a.e("WpsWebView", "onHyperLinkOpen() error", e, false);
        }

        @JavascriptInterface
        public void printIframeLog(String r3) {
            tt5.a.b("WpsWebView", "printIframeLog = " + r3);
        }

        @JavascriptInterface
        public void slideShowStatusChanged(String r4) {
            tt5.a.h("WpsWebView", "slideShowStatusChanged called: data=" + du5.b.f(r4));
            WpsView r0 = this.a;
            int r2 = WpsView.D;
            if (r0.i() == false) goto L6;
            return;
        L6:
            if (this.a.B == true) goto L16;
            return;
        L16:
        L13:
            tt5.a.d("WpsWebView", "parse wpsApiCallback error");
            return;
        L9:
            if ("begin".equals(new JSONObject(r4).optString("status", BatterySceneData.OPT_END)) == false) goto L11;
            WpsView.h(this.a);     // Catch: Exception -> L13
        L15:
            return;
        L11:
            this.a.k();     // Catch: Exception -> L13
            goto L15
        }

        @JavascriptInterface
        public void wpsApplicationReady(String r4) {
            tt5.a.h("WpsWebView", "wpsApplicationReady called");
            WpsView r5 = this.a;
            int r0 = WpsView.D;
            if (r5.i() == false) goto L5;
            return;
        L5:
            final WpsView r6 = this.a;
            if (r6.B == true) goto L8;
            return;
        L8:
            r6.b.add(Flowable.just(Boolean.valueOf(r6.t.c)).filter(new b0(r6)).observeOn(fo5.d.d()).subscribe(new c0(r6), new d0()));
            this.a.y.getWpsApplicationReadyLiveData().postValue(Boolean.TRUE);
        }

        @JavascriptInterface
        public void wpsError(final String r9) {
            tt5.a.d("WpsWebView", "wpsError = " + r9);
            WpsView r0 = this.a;
            int r1 = WpsView.D;
            if (r0.i() == false) goto L5;
            return;
        L5:
            long r2 = SystemClock.uptimeMillis();
            WpsView r3 = this.a;
            if ((r2 - r3.l) >= 50) goto L8;
            return;
        L8:
            r3.l = r2;
            com.bytedance.ee.util.ui.j.e(r3.C);
            this.a.y.getErrorLiveData().postValue("true");
            this.a.b.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new x0(this, r9), new y0()));
        }

        @JavascriptInterface
        public void wpsFilePasswordStatusChanged(String r3) {
        L6:
            tt5.a.d("WpsWebView", "wpsFilePasswordStatusChanged error");
            return;
        L3:
            if ("NeedPassword".equals(new JSONObject(new JSONObject(r3).optString("status", "")).optString("type")) == false) goto L10;
            this.a.y.getSuccessLiveData().postValue("true");     // Catch: Exception -> L6
            return;
        }

        @JavascriptInterface
        public void wpsLoadStatus(String r7) {
            tt5.a.h("WpsWebView", "wpsLoadStatus = " + r7);
            WpsView r0 = this.a;
            int r2 = WpsView.D;
            if (r0.i() == false) goto L5;
            return;
        L5:
            boolean r3 = r7.contains("isSuccess");
            r7.contains("sdkLoadStart");
            boolean r4 = false;
            boolean r1 = new JSONObject(r7).optBoolean("isSuccess", false);     // Catch: Exception -> L11
            r4 = new JSONObject(r7).optBoolean("sdkLoadStart", false);     // Catch: Exception -> L9
        L14:
            WpsView r5 = this.a;
            r5.s = r7;
            if (r3 == false) goto L21;
            f r6 = r5.x;
            if (r6 == null) goto L20;
            if (r1 == false) goto L20;
            ((WpsPreviewView.a) r6).a.trackWpsRenderSuccess();
        L20:
            this.a.y.getSuccessLiveData().postValue("true");
            WpsView r8 = this.a;
            r8.r = r1;
            com.bytedance.ee.util.ui.j.e(r8.C);
            com.bytedance.ee.util.ui.j.d(this.a.C, 50);
        L21:
            if (r4 == false) goto L30;
            WpsView r9 = this.a;
            if (r9.v == false) goto L31;
            r9.y.getPreloadLoadEndLiveData().postValue("true");
            return;
        L31:
            return;
        L30:
            return;
        L9:
            Exception e = e;
        L13:
            tt5.a.e("WpsWebView", "parse wpsLoadStatus fail. ", e, false);
        L11:
            e = move-exception;
            e = e;
            r1 = false;
            goto L13
        }

        @JavascriptInterface
        public void wpsStageChanged(String r3) {
            JSONObject r0 = new JSONObject(r3);     // Catch: Exception -> L6
            u r4 = (u) new Gson().fromJson(JSONObjectProtectorUtils.getString(r0, "stage"), u.class);     // Catch: Exception -> L6
            f r1 = this.a.x;     // Catch: Exception -> L6
            if (r1 == null) goto L10;
            ((WpsPreviewView.a) r1).a.trackWpsStageStart(r4);     // Catch: Exception -> L6
            ((WpsPreviewView.a) this.a.x).a.trackWpsStageEnd(r4);     // Catch: Exception -> L6
            return;
        L10:
            return;
        L6:
            tt5.a.d("WpsWebView", "parse stage info error");
        }
    }

    public static class c {
        public final com.bytedance.ee.bear.drive.view.preview.wrapper.z a;
        public int b;
        public boolean c;

        public final boolean a() {
            if (this.b != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public c(com.bytedance.ee.bear.drive.view.preview.wrapper.z r2) {
            this.b = 1;
            this.c = false;
            this.a = r2;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView
    public /* bridge */ /* synthetic */ com.bytedance.ee.bear.drive.view.preview.wrapper.z getPreviewFileModel() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public String getReleaseKey() {
        return "WpsWebView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
    }

    private void getGrayStrategy() {
        this.b.add(new WpsGrayStrategyPuller((NetService) org.koin.java.a.a(NetService.class)).pull(new WpsGrayStrategyPuller.Params()).subscribe(new e0(this), new f0()));
    }

    private String getUnmountWpsJSEvent() {
        int r0 = com.bytedance.ee.bear.drive.view.preview.wps.a.c;
        return String.format("javascript:triggerJSEvent('%1$s')", new Object[]{com.bytedance.ee.bear.drive.view.preview.wps.a.C0187a.a("unmountWPS", null)});
    }

    public void getInitData() {
        if (this.q != null) goto L5;
        return;
    L5:
        if (i() == true) goto L13;
        f r0 = this.x;
        if (r0 == null) goto L10;
        ((WpsPreviewView.a) r0).a.trackWpsStart("wps_getInitial_data");
    L10:
        this.b.add(this.o.d().observeOn(fo5.d.d()).subscribe(new w(this), new x(this)));
        return;
    }

    public Object getJavascriptInterface() {
        if (this.n != null) goto L6;
        this.n = new b(this);
    L6:
        return this.n;
    }

    public final boolean i() {
        if (this.o != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j() {
        tt5.a.h("WpsWebView", "executeExitPresentationCommand: isPresentationMode:" + this.z);
        this.b.add(Flowable.just(Boolean.valueOf(this.z)).filter(new n0(this)).flatMap(new o0(this)).observeOn(fo5.d.d()).subscribe(new p0(this), new q0()));
    }

    public final void k() {
        this.b.add(Flowable.just(Boolean.valueOf(this.t.c)).filter(new r0(this)).observeOn(fo5.d.d()).subscribe(new s0(this), new t0()));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        if (this.z == false) goto L6;
        j();
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        if (TextUtils.isEmpty(this.p) == false) goto L5;
        getGrayStrategy();
    L5:
        getWebView().setVerticalScrollBarEnabled(false);
        getWebView().setHorizontalScrollBarEnabled(false);
        c r0 = this.q;
        if (r0 != null) goto L8;
    L22:
        tt5.a.d("WpsWebView", "WpsView show fail because mWpsViewEntity= " + this.q + ", fileModel= " + this.q.a);
        return;
    L8:
        if (r0.a == null) goto L22;
        tt5.a.h("WpsWebView", "show, token = " + du5.b.g(this.q.a.o));
        c95.c r1 = this.i;
        if (r1 == null) goto L12;
        r1.onShowStart();
    L12:
        j65.a.b(this.d, "WpsWebView");
        if (this.v == false) goto L18;
        this.y.getPreloadStartLiveData().setValue("true");
        if (this.u == false) goto L17;
        tt5.a.h("WpsWebView", "preload webview load complete");
        getInitData();
        return;
    L17:
        tt5.a.h("WpsWebView", "preload webview not load complete , listen to page finish");
        this.a.f(new z0(this));
        return;
    L18:
        this.a.addJavascriptInterface(getJavascriptInterface(), "jsObj");
        this.a.f(new u0(this));
        f r2 = this.x;
        if (r2 == null) goto L21;
        ((WpsPreviewView.a) r2).a.trackWpsStart("wps_load_template");
    L21:
        this.a.loadUrl("file:///android_asset/wps/wps.html");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public final void onRelease() {
        super.onRelease();
        PreviewViewModel r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        this.d.liveInnerShowWPSPresentationAction().postValue(Boolean.FALSE);
        if (this.A == null) goto L11;
        this.d.liveOuterEnterPresentationMode().removeObserver(this.A);
    L11:
        if (this.v == false) goto L19;
        tt5.a.h("WpsWebView", "unmount preload wps frame");
        n(getUnmountWpsJSEvent());
        DriveWebView r1 = this.a;
        if (r1 == null) goto L17;
        com.bytedance.ee.bear.drive.view.widget.c r2 = r1.p;
        if (r2 == null) goto L17;
        r2.a.clear();
    L17:
        this.o = null;
        this.i = null;
        this.x = null;
        this.d = null;
        return;
    L19:
        this.o.i();
        com.bytedance.ee.util.ui.j.e(this.C);
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    public c getEntity() {
        return this.q;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public WpsView(Context r3) {
        super(r3);
        this.k = true;
        this.p = null;
        this.r = false;
        this.s = "";
        this.z = false;
        this.C = new a(this);
        l(r3);
    }

    public static void h(final WpsView r3) {
        r3.b.add(Flowable.just(Boolean.valueOf(r3.t.c)).filter(new v(r3)).observeOn(fo5.d.d()).subscribe(new g0(r3), new m0()));
    }

    private void setRequestedOrientation(int r3) {
        tt5.a.h("WpsWebView", "setRequestedOrientation() called with: requestedOrientation = [" + r3 + "]");
        Context r0 = getContext();
        if (r0 == null) goto L8;
        Activity r1 = ContextsKt.findActivity(r0);
        if (r1 == null) goto L9;
        r1.setRequestedOrientation(r3);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r9) {
        p r0 = this.j;
        r0.getClass();
        int r1 = r9.getAction();
        if (r1 != 0) goto L5;
        r0.b = System.currentTimeMillis();
        r0.c = new PointF(r9.getX(), r9.getY());
    L20:
        return super.dispatchTouchEvent(r9);
    L5:
        if (r1 != 1) goto L20;
        r0.d = new PointF(r9.getX(), r9.getY());
        long r2 = System.currentTimeMillis() - r0.b;
        r0.f.removeCallbacks(r0.e);
        PointF r3 = r0.c;
        if (r3 == null) goto L20;
        PointF r4 = r0.d;
        if (r4 == null) goto L20;
        float r5 = Math.abs(r3.x - r4.x);
        float r6 = Math.abs(r0.c.y - r0.d.y);
        if (r2 > 150) goto L20;
        if (Math.max(r5, r6) > 10.0f) goto L20;
        r0.f.postDelayed(r0.e, 150);
        goto L20
    }

    public final void l(Context r1) {
        this.j = new p();
        this.b = new CompositeDisposable();
        cu5.c.c();
    }

    public final void m(Throwable r3) {
        c95.c r0 = this.i;
        if (r0 == null) goto L5;
        r0.a("wps", r3);
    L5:
        j65.a.a(this.d, "WpsWebView");
    }

    public final void n(String r3) {
        DriveWebView r0 = this.a;
        if (r0 == null) goto L6;
        r0.evaluateJavascript(r3, null);
        return;
    }

    public void setOnFullScreenSwitchListener(Runnable r2) {
        this.j.a = r2;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, c95.d
    public void setOnShowViewTrackEventCallback(c95.c r1) {
        this.i = r1;
    }

    public void setPreloadStatus(boolean r1) {
        this.u = r1;
        this.v = true;
    }

    public void setWpsFileConfig(com.bytedance.ee.bear.drive.view.preview.wps.b r1) {
        this.t = r1;
    }

    public void setWpsLoadState(f r1) {
        this.x = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r3) {
        ArrayList<CommentRectF> r0 = this.h;
        if (r0 == null) goto L9;
        Iterator<CommentRectF> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        if (TextUtils.equals(r1.next().b, r3) == false) goto L6;
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r1) {
        this.h = r1;
    }

    public WpsView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.k = true;
        this.p = null;
        this.r = false;
        this.s = "";
        this.z = false;
        this.C = new a(this);
        l(r2);
    }

    public static /* synthetic */ void f(WpsView r0, String r1) {
        r0.n(r1);
        r0.setRequestedOrientation(1);
    }

    public static /* synthetic */ void g(WpsView r0, String r1) {
        r0.n(r1);
        r0.setRequestedOrientation(0);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r2, ViewOwner r3) {
        super.onSetup(r2, r3);
        this.m = r3;
        this.o.k(r3);
        this.y = (WpsViewModel) r3.viewModel(WpsViewModel.class);
        ((DriveConfigurationVM) r3.viewModel(DriveConfigurationVM.class)).isPortrait().observe(this.m.lifecycleOwner(), new y(this));
        int r4 = this.d.getBizType();
        int r5 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        boolean r6 = !com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r4);
        this.B = r6;
        tt5.a.h("WpsWebView", "init().. mWPSPPTExhibitionEnable-> enable= true && !attachmentBizType=" + r6);
    }

    public WpsView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.k = true;
        this.p = null;
        this.r = false;
        this.s = "";
        this.z = false;
        this.C = new a(this);
        l(r1);
    }
}
