package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.bean.i;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.ies.web.jsbridge2.u;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "XBridge3.0 is ready, XBridge2.0's Web Bridge Module is not recommended to continue to use", replaceWith = @ReplaceWith(expression = "WebBDXBridge", imports = {}))
public final class f implements r26.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f247047s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f247048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebViewClient f247049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebChromeClient f247050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f247051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f247052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f247053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f247054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f247055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f247056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f247057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u f247058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n56.a f247059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f0 f247060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d0 f247061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o f247062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function2<? super String, ? super com.bytedance.ies.bullet.core.kit.bridge.e, Unit> f247063p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f247064q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, com.bytedance.ies.bullet.core.kit.bridge.e> f247065r;

    public static final class a {
    }

    static {
    }

    public f(SSWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f247048a = r100;
        this.f247051d = new ArrayList();
        this.f247052e = new ArrayList();
        this.f247053f = new ArrayList();
        this.f247054g = new ArrayList();
        com.bytedance.android.anniex.assemble.a.h();
        this.f247055h = false;
        this.f247056i = "ToutiaoJSBridge";
        this.f247057j = AdBaseConstants.BYTEDANCE_PACKAGE_NAME_SUFFIX;
        this.f247064q = LazyKt.lazy(WebJsBridge$gson$2.INSTANCE);
        this.f247065r = new LinkedHashMap();
    }

    @Override // r26.b
    public final void sendJsEvent(String r100, JSONObject r101) {
        n56.a r102 = this.f247059l;
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }

    public final void a(com.bytedance.ies.bullet.service.base.bridge.a r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        i<com.bytedance.ies.argus.api.params.d> r103 = null;
        if (r101 == null) goto L7;
        com.bytedance.ies.bullet.core.kit.bridge.e r104 = (com.bytedance.ies.bullet.core.kit.bridge.e) ((LinkedHashMap) this.f247065r).get(r101);
        if (r104 != null) goto L8;
        r104 = new com.bytedance.ies.bullet.core.kit.bridge.e();
        this.f247065r.put(r101, r104);
    L8:
        if (r104 == null) goto L10;
        com.bytedance.ies.bullet.core.kit.bridge.e.b(r104);
    L10:
        ArgusWebDelegate r105 = com.bytedance.ies.argus.api.a.b(null, null);
        if (r105 == null) goto L16;
        String r106 = r100.getName();
        String r107 = this.f247048a.getUrl();
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        r103 = r105.j(new com.bytedance.ies.argus.api.params.c(r106, "-1", r107, r102));
    L16:
        boolean r108 = false;
        if (r103 != null) goto L19;
    L24:
        if (r108 == false) goto L26;
        REWRITE_PAYLOAD r109 = r103.f246032c;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.ies.argus.api.params.AfterJSBHandlerRewritePayload");
        ((com.bytedance.ies.argus.api.params.d) r109).e(r102);
    L26:
        n56.a r110 = this.f247059l;
        if (r110 == null) goto L29;
        r110.c(r101, r102);
    L29:
        if (r104 == null) goto L38;
        com.bytedance.ies.bullet.core.kit.bridge.e.c(r104);
        r104.f246553g = System.currentTimeMillis();
        if (r104.a() == false) goto L39;
        if (r101 == null) goto L34;
        com.bytedance.ies.bullet.core.kit.bridge.e r111 = this.f247065r.remove(r101);
    L34:
        Function2<? super String, ? super com.bytedance.ies.bullet.core.kit.bridge.e, Unit> r112 = this.f247063p;
        if (r112 == null) goto L40;
        r112.invoke(r100.getName(), r104);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L19:
        if (r103.f246031b != ArgusVerifyAction.REWRITE) goto L21;
        boolean r113 = true;
    L22:
        if (r113 != true) goto L24;
        r108 = true;
        goto L24
    L21:
        r113 = false;
        goto L22
    L7:
        r104 = null;
        goto L8
    }
}
