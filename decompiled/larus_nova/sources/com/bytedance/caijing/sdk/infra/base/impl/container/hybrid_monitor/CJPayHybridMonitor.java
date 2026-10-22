package com.bytedance.caijing.sdk.infra.base.impl.container.hybrid_monitor;

import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.c;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u0017\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J7\u0010\u0017\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0017\u0010\u001cJ&\u0010\u001f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J#\u0010!\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/hybrid_monitor/CJPayHybridMonitor;", "Lcom/bytedance/caijing/sdk/infra/base/api/container/webMonitor/ICJPayWebViewMonitorHelper;", "Landroid/webkit/WebView;", "webView", "Lcom/bytedance/android/monitorV2/webview/c;", "buildConfig", "", "isMonitor", "", "handleViewCreate", "", "url", "onLoadUrl", "goBack", "reload", MapMonitorConst.EVENT_DESTROY, "onAttachedToWindow", "onPageStarted", "onPageFinished", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceError;", "error", "handleRequestError", "", "errorCode", "description", "failingUrl", "(Landroid/webkit/WebView;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebResourceResponse;", "errorResponse", "handleRequestHttpError", "newProgress", "onProgressChanged", "(Landroid/webkit/WebView;Ljava/lang/Integer;)V", "Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "cjLogger", "Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final class CJPayHybridMonitor implements ICJPayWebViewMonitorHelper {
    public static final a Companion = null;
    private static final String TAG = "CJPayHybridMonitor";
    private static final HashMap<Integer, Boolean> isMonitorWebViewMap = null;
    private final ALogService cjLogger;

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class b implements tz2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJPayHybridMonitor f202509a;

        public b(CJPayHybridMonitor r100) {
            this.f202509a = r100;
        }

        @Override // tz2.a
        public final void a(View r100, int r101) {
            if (r101 != 1) goto L5;
            String r102 = "BLANK_SCREEN";
        L9:
            ALogService r103 = CJPayHybridMonitor.access$getCjLogger$p(this.f202509a);
            if (r103 == null) goto L13;
            r103.i(CJPayHybridMonitor.TAG, "onDetectResult() called with: view = " + r100 + ", blankState = " + r101 + ", blankMsg = " + r102);
            return;
        L13:
            return;
        L5:
            if (r101 == 2) goto L7;
            r102 = "DETECT_FAIL";
            goto L9
        L7:
            r102 = "NORMAL_SCREEN";
            goto L9
        }

        @Override // tz2.a
        public final void b(View r100, long r101) {
            ALogService r102 = CJPayHybridMonitor.access$getCjLogger$p(this.f202509a);
            if (r102 == null) goto L6;
            r102.i("WebActivity", "onDetectCost() called with: view = " + r100 + ", costTime = " + r101);
            return;
        }
    }

    static {
        Companion = new a();
        isMonitorWebViewMap = new HashMap();
    }

    public CJPayHybridMonitor() {
        ve4.a.f554342a.getClass();
        this.cjLogger = (ALogService) ve4.a.a(ALogService.class);
    }

    public static final /* synthetic */ ALogService access$getCjLogger$p(CJPayHybridMonitor r100) {
        return r100.cjLogger;
    }

    private final c buildConfig(WebView r100) {
        m.f163358f.getClass();
        c r101 = new c();
        r101.f163341f = true;
        r101.a(new WebView[]{r100});
        r101.f163342g = "cjpay_webview";
        r101.f163345j = new b(this);
        return r101;
    }

    private final boolean isMonitor(WebView r100) {
        if (r100 == null) goto L4;
        int r101 = r100.hashCode();
    L6:
        return Intrinsics.areEqual(isMonitorWebViewMap.get(Integer.valueOf(r101)), Boolean.TRUE);
    L4:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void destroy(WebView r100) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        int r101 = r100.hashCode();
        Boolean r102 = isMonitorWebViewMap.remove(Integer.valueOf(r101));
    L7:
        m.f163358f.k(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void goBack(WebView r100) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.l(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void onAttachedToWindow(WebView r100) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.E(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void reload(WebView r100) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.M(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void handleViewCreate(WebView r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Integer r102 = Integer.valueOf(r100.hashCode());
        Boolean r103 = Boolean.valueOf(r101);
        isMonitorWebViewMap.put(r102, r103);
        if (isMonitor(r100) == true) goto L7;
        return;
    L7:
        m r104 = m.f163358f;
        r104.h(buildConfig(r100));
        r104.A(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void onLoadUrl(WebView r100, String r101) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.F(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void onPageFinished(WebView r100, String r101) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.H(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void onPageStarted(WebView r100, String r101) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.I(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void onProgressChanged(WebView r100, Integer r101) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m r102 = m.f163358f;
        if (r101 == null) goto L8;
        int r103 = r101.intValue();
    L9:
        r102.K(r100, r103);
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void handleRequestError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.u(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void handleRequestHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m.f163358f.x(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.webMonitor.ICJPayWebViewMonitorHelper
    public void handleRequestError(WebView r100, Integer r101, String r102, String r103) {
        if (isMonitor(r100) == true) goto L5;
        return;
    L5:
        m r104 = m.f163358f;
        if (r101 == null) goto L8;
        int r105 = r101.intValue();
    L9:
        r104.t(r100, r105, r102, r103);
        return;
    L8:
        r105 = 0;
        goto L9
    }
}
