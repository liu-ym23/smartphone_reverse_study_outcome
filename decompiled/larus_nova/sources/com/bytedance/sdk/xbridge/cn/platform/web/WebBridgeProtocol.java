package com.bytedance.sdk.xbridge.cn.platform.web;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.bean.i;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.d7;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import com.bytedance.sdk.xbridge.cn.utils.l;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class WebBridgeProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f270004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f270005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebBDXBridge f270006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f270007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f270008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f270009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f270010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AuthUrlSourceType f270011h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebBridgeProtocol f270012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f270013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ValueCallback<String> f270014c;

        public b(WebBridgeProtocol r100, String r101, ValueCallback<String> r102) {
            this.f270012a = r100;
            this.f270013b = r101;
            this.f270014c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f270012a.d(this.f270013b, this.f270014c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebBridgeProtocol f270015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f270016b;

        public c(WebBridgeProtocol r100, String r101) {
            this.f270015a = r100;
            this.f270016b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f270015a.j(this.f270016b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends com.bytedance.sdk.xbridge.cn.protocol.d<JSONObject> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.web.b f270017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WebBridgeProtocol f270018d;

        @Override // com.bytedance.sdk.xbridge.cn.protocol.d
        public final JSONObject a() {
            return new JSONObject();
        }

        @Override // com.bytedance.sdk.xbridge.cn.protocol.d
        public final void b(JSONObject r110) {
            JSONObject r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "data");
            ArgusWebDelegate r100 = this.f270018d.e().f269997m;
            String r101 = null;
            if (r100 == null) goto L5;
            com.bytedance.sdk.xbridge.cn.platform.web.b r102 = this.f270017c;
            i<com.bytedance.ies.argus.api.params.d> r103 = r100.j(new com.bytedance.ies.argus.api.params.c(r102.f508943a, r102.f508959q, r102.N, r111));
        L6:
            boolean r104 = false;
            if (r103 != null) goto L9;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == false) goto L17;
            REWRITE_PAYLOAD r106 = r103.f246032c;
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.ies.argus.api.params.AfterJSBHandlerRewritePayload");
            ((com.bytedance.ies.argus.api.params.d) r106).e(r111);
        L17:
            this.f270018d.c(this.f270018d.b(this.f270017c, r111), null);
            WebBridgeProtocol r107 = this.f270018d;
            com.bytedance.sdk.xbridge.cn.platform.web.b r108 = this.f270017c;
            r107.getClass();
            if (r108.f508953k != 1) goto L20;
            boolean r109 = true;
        L21:
            SLAnnieXMonitor r112 = com.bytedance.android.anniex.monitor.salamander.c.f41013a.a(r107.e().f269995k);
            d7 r113 = new d7();
            String r114 = r108.f508943a;
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r113.f268031a = r114;
            JSONObject r115 = r108.M;
            Intrinsics.checkNotNullParameter(r115, "<set-?>");
            r113.f268033c = r115;
            r113.f268032b = CastIntegerProtector.parseInt(r108.R);
            Intrinsics.checkNotNullParameter(r111, "<set-?>");
            r113.f268034d = r111;
            if (r109 == false) goto L24;
            long r116 = System.currentTimeMillis() - r108.f508948f;
        L25:
            r113.f268035e = r116;
            r113.f268037g = r108.f508953k;
            String r117 = r108.f508954l;
            Intrinsics.checkNotNullParameter(r117, "<set-?>");
            r113.f268038h = r117;
            r113.f268036f = System.currentTimeMillis();
            r113.f268039i = r109;
            r112.y(r113);
            if (r108.f508953k != 1) goto L39;
            m r118 = m.f163358f;
            WebView r119 = r107.g();
            jz2.i r120 = new jz2.i();
            r120.f501150a = r108.f508943a;
            r120.f501151b = 0;
            r120.f501154e = System.currentTimeMillis() - r108.f508948f;
            long r121 = SystemClock.elapsedRealtime();
            long r122 = System.currentTimeMillis();
            long r123 = r108.f508948f;
            r120.f501155f = r121 - (r122 - r123);
            if (r108.f508952j == r123) goto L30;
            long r124 = SystemClock.elapsedRealtime() - (System.currentTimeMillis() - r108.f508952j);
        L31:
            r120.f501156g = r124;
            if (Intrinsics.areEqual(r120.f501150a, "x.request") == false) goto L37;
            JSONObject r125 = r108.M;
            if (r125 == null) goto L36;
            r101 = r125.optString("url");
        L36:
            r120.f501157h = r101;
        L37:
            r120.f501153d = r108.R;
            Unit r126 = Unit.INSTANCE;
            r118.p(r119, r120);
            return;
        L30:
            r124 = SystemClock.elapsedRealtime();
            goto L31
        L39:
            if (h.n() == false) goto L42;
            r104 = r108.I;
        L42:
            if (r104 == false) goto L44;
            int r127 = l.f270263a;
            l.a(r108.f508943a, r108.N, r108.f508954l, r107.g());
            return;
        L44:
            m r128 = m.f163358f;
            WebView r129 = r107.g();
            jz2.h r130 = new jz2.h();
            r130.f501149c = r108.f508943a;
            int r131 = r108.f508953k;
            r130.f501147a = r131;
            String r132 = r108.f508954l;
            Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L47
            r132 = new JSONObject().putOpt("message", r132).putOpt("code", Integer.valueOf(r131)).toString();     // Catch: Throwable -> L47
        L49:
            r130.f501148b = r132;
            Unit r134 = Unit.INSTANCE;
            r128.o(r129, r130);
            return;
        L47:
            th = move-exception;
            Result.Companion r135 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L49
        L24:
            r116 = -1;
            goto L25
        L20:
            r109 = false;
            goto L21
        L9:
            if (r103.f246031b != ArgusVerifyAction.REWRITE) goto L11;
            boolean r136 = true;
        L12:
            if (r136 != true) goto L14;
            r105 = true;
            goto L15
        L11:
            r136 = false;
            goto L12
        L5:
            r103 = null;
            goto L6
        }

        public d(com.bytedance.sdk.xbridge.cn.platform.web.b r100, WebBridgeProtocol r101) {
            this.f270017c = r100;
            this.f270018d = r101;
            super(r100);
        }
    }

    static {
    }

    public abstract com.bytedance.sdk.xbridge.cn.platform.web.b a(String r100);

    public abstract String b(com.bytedance.sdk.xbridge.cn.platform.web.b r100, JSONObject r101);

    public void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    public abstract void l(WebView r100);

    public abstract void m(String r100, JSONObject r101);

    public boolean n(String r100) {
        return false;
    }

    public final WebBDXBridge e() {
        WebBDXBridge r100 = this.f270006c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bdxBridge");
        return null;
    }

    public final WebView g() {
        WebView r100 = this.f270005b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    public final String h() {
    L20:
        th = move-exception;
        id7.c.a("get url failed: " + th.getMessage());
        return "unknown: exception: " + th.getMessage();
    L4:
        if (TextUtils.isEmpty(this.f270010g) == true) goto L6;
        id7.c.a("GetWebViewUrlSync: from V1 protocol, " + this.f270010g + ' ');     // Catch: Throwable -> L20
        String r100 = this.f270010g;     // Catch: Throwable -> L20
    L7:
        if (r100 == null) goto L10;
        return r100;
    L10:
        if (this.f270008e == false) goto L12;
    L18:
        return "unknown:destroyed or not initialize";
    L12:
        if (this.f270005b == null) goto L18;
        WebView r101 = g();     // Catch: Throwable -> L20
        if (r101 == null) goto L27;
        return r101.getUrl();
    L27:
        return null;
    L6:
        r100 = f();     // Catch: Throwable -> L20
        goto L7
    }

    public final String f() {
        ViewParent r100 = g();
        if ((r100 instanceof ke7.b) == false) goto L20;
        ke7.b r101 = (ke7.b) r100;
        if (r101.a() == false) goto L20;
        if (this.f270008e == false) goto L9;
    L18:
        id7.c.a("webview已销毁或未初始化，无法获取");
        return "unknown:destroyed or not initialize";
    L9:
        if (this.f270005b == null) goto L18;
        String r102 = r101.getXSafeUrl();
        this.f270011h = r101.getAuthUrlSourceType();
        if (TextUtils.isEmpty(r102) == false) goto L21;
        WebView r103 = g();
        if (r103 != null) goto L17;
        return null;
    L17:
        return r103.getUrl();
    L21:
        return r102;
    L20:
        return null;
    }

    public WebBridgeProtocol(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        this.f270004a = LazyKt.lazy(WebBridgeProtocol$bridgeHandler$2.INSTANCE);
        this.f270007d = new Handler(Looper.getMainLooper());
        this.f270009f = r100;
        this.f270011h = AuthUrlSourceType.DisableSafeAuthInXBridge3;
    }

    public static String o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        if (Intrinsics.areEqual("host", r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    public final void i(String r100) {
        if (this.f270008e == false) goto L7;
        id7.c.a("webview已销毁，handleJSMessage未执行");
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        j(r100);
        return;
    L9:
        this.f270007d.post(new c(this, r100));
    }

    public final void j(String r100) {
        if (r100 != null) goto L5;
        String r101 = SliceInitService.DEFAULT_SWITCH;
    L6:
        com.bytedance.sdk.xbridge.cn.platform.web.b r102 = a(r101);
        d r103 = new d(r102, this);
        if (r100 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
    L22:
        r103.c(((com.bytedance.sdk.xbridge.cn.platform.web.a) this.f270004a.getValue()).a(r102, 0, "invoke msg is empty"));
        return;
    L15:
        if (Intrinsics.areEqual(r100, SliceInitService.DEFAULT_SWITCH) == true) goto L22;
        if (Intrinsics.areEqual(e().f270003s, Boolean.TRUE) == false) goto L20;
        e().p(r102, r103);
        return;
    L20:
        e().o(r102, r103);
        return;
    L9:
        if (r100.length() == 0) goto L12;
        r104 = false;
        goto L13
    L5:
        r101 = r100;
        goto L6
    }

    public final void c(String r100, ValueCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        d(r100, r101);
        return;
    L5:
        this.f270007d.post(new b(this, r100, r101));
    }

    public final void d(String r100, ValueCallback<String> r101) {
        if (this.f270008e == false) goto L7;
        id7.c.a("webview已销毁，evaluateJavaScriptInternal未执行，url: " + r100);
        return;
    L7:
        if (this.f270005b != null) goto L15;
        id7.c.a("webview对象未初始化，evaluateJavaScriptInternal未执行");
        return;
    L15:
        g().evaluateJavascript(r100, r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        id7.c.a("webview.evaluateJavascript失败：" + th.getMessage());
    }
}
