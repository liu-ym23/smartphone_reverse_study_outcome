package com.ss.android.lark.officewebview.base;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.l;
import com.ss.android.lark.officewebview.service.impl.WebViewPerformanceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import dxb.h;
import dxb.i;
import dxb.s;
import dxb.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;
import org.json.JSONObject;
import otb.n;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u009c\u00012\u00020\u0001:\u0004\u009c\u0001\u009d\u0001B+\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000bJ\r\u0010\u0011\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0012J\u001c\u0010/\u001a\u0002002\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016J\u0010\u00102\u001a\u0002002\u0006\u00103\u001a\u00020\rH\u0016J\r\u00104\u001a\u00020\rH\u0000¢\u0006\u0002\b5J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u0002002\u0006\u0010C\u001a\u00020DJ\u0006\u0010I\u001a\u00020\u0014J\b\u0010J\u001a\u000200H\u0014J\n\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u0000H\u0016J\u0018\u0010N\u001a\u0002002\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020?H\u0016J\u0012\u0010Q\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0012\u0010T\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010U\u001a\u000200H\u0016J\u0012\u0010V\u001a\u00020\u001d2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u000200H\u0002J\u0016\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020H\u0018\u00010[H\u0016J\u0010\u0010\\\u001a\u0002002\b\u0010]\u001a\u0004\u0018\u00010$J\u0014\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020H0[H\u0016J\u001a\u0010_\u001a\u00020`2\u0006\u0010W\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u001a\u0010c\u001a\u00020`2\u0006\u0010W\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010d\u001a\u000200H\u0016J\b\u0010e\u001a\u000200H\u0016J\u0010\u0010f\u001a\u0002002\b\u0010g\u001a\u0004\u0018\u00010hJ\u0010\u0010i\u001a\u0002002\b\u0010g\u001a\u0004\u0018\u00010jJ(\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020m2\u0006\u0010p\u001a\u00020mH\u0014JP\u0010q\u001a\u00020\u001d2\u0006\u0010r\u001a\u00020m2\u0006\u0010s\u001a\u00020m2\u0006\u0010t\u001a\u00020m2\u0006\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020m2\u0006\u0010w\u001a\u00020m2\u0006\u0010x\u001a\u00020m2\u0006\u0010y\u001a\u00020m2\u0006\u0010z\u001a\u00020\u001dH\u0014J\u000e\u0010{\u001a\u0002002\u0006\u0010\n\u001a\u00020\u0007J\b\u0010|\u001a\u00020\rH\u0016J\b\u0010}\u001a\u00020\rH\u0016J\u000e\u0010~\u001a\u0002002\u0006\u0010\u007f\u001a\u00020\"J\t\u0010\u0080\u0001\u001a\u00020\"H\u0016J\t\u0010\u0081\u0001\u001a\u000200H\u0016J\u0014\u0010\u0082\u0001\u001a\u0002002\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\rH\u0016J+\u0010\u0082\u0001\u001a\u0002002\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\r2\u0015\u0010\u0084\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010[H\u0016J>\u0010\u0085\u0001\u001a\u0002002\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0087\u0001\u001a\u00020\r2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010\u008b\u0001\u001a\u000200H\u0016J\t\u0010\u008c\u0001\u001a\u000200H\u0016J\t\u0010\u008d\u0001\u001a\u000200H\u0016J\u0007\u0010\u008e\u0001\u001a\u00020\u001dJ\t\u0010\u008f\u0001\u001a\u000200H\u0014J\u001f\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\t\u0010@\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\n\u001a\u00020mH\u0016J\t\u0010\u0093\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0094\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0095\u0001\u001a\u00020\u001dH\u0002J\u0013\u0010\u0096\u0001\u001a\u0002002\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001J\u0007\u0010\u0099\u0001\u001a\u000200J\u0007\u0010\u009a\u0001\u001a\u00020\u001dJ\t\u0010\u009b\u0001\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b+\u0010 R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010*\u001a\u0004\b8\u00109R\u001a\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020H0GX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Lcom/ss/android/lark/officewebview/base/OfficeWebView;", "Lcom/ss/android/lark/officewebview/base/BaseOfficeWebView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "set", "Landroid/util/AttributeSet;", "bizType", "Lcom/ss/android/lark/officewebview/monitor/webview/BizType;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/ss/android/lark/officewebview/monitor/webview/BizType;)V", "type", "(Landroid/content/Context;Lcom/ss/android/lark/officewebview/monitor/webview/BizType;)V", "mTracingId", "", "bridgeWebViewTouchDispatcher", "Lcom/ss/android/lark/officewebview/util/BridgeWebViewTouchDispatcher;", "monitorId", "getContainerMonitorId", "getContainerMonitorId$webview_release", "mBridge", "Lcom/ss/android/lark/officewebview/bridge/Bridge;", "injectedLogParams", "", "larkHybridMonitor", "Lcom/ss/android/lark/officewebview/base/OfficeWebView$LarkHybridMonitor;", "monitorConfig", "Lcom/ss/android/lark/officewebview/dependency/IAnniexMonitorDependency$MonitorConfig;", "bizScene", "value", "", "webViewIsDestroy", "getWebViewIsDestroy", "()Z", "mStartTime", "", "mParamInjector", "Lcom/ss/android/lark/officewebview/base/interfaces/ILarkWebViewParamInjector;", "pluginList", "", "getPluginList", "()Ljava/util/List;", "pluginList$delegate", "Lkotlin/Lazy;", "isEnablePluginDuplicateCheck", "isEnablePluginDuplicateCheck$delegate", "officeWebViewLabel", "Landroid/widget/TextView;", "setInjectedLogParams", "", "logParams", "setBizScene", "scene", "getBizScene", "getBizScene$webview_release", "pluginBridge", "Lcom/ss/android/lark/officewebview/dependency/IOpenPluginWrapper;", "getPluginBridge", "()Lcom/ss/android/lark/officewebview/dependency/IOpenPluginWrapper;", "pluginBridge$delegate", "sendEvent", "Lcom/ss/android/lark/officewebview/dependency/PluginBaseResult;", "api", "params", "Lorg/json/JSONObject;", "callback", "Lcom/ss/android/lark/officewebview/dependency/PluginEventCallback;", "registerPlugin", CloudControlInf.PLUGIN, "Lcom/ss/android/lark/officewebview/dependency/Plugin;", "registerPluginOnce", "mCommonParams", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getBridge", "afterInitServiceManager", "getServiceManager", "Lcom/ss/android/lark/officewebview/service/ServiceManager;", "getWebView", "reportEvent", "eventName", "eventJson", "addTouchListener", "onTouchListener", "Landroid/view/View$OnTouchListener;", "removeTouchListener", "clearTouchListeners", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "initTracing", "getCommonParams", "", "setParamInjector", "paramInjector", "getReasonParams", "createErrorMonitor", "Lcom/ss/android/lark/officewebview/monitor/webview/WebMonitor;", "monitorCode", "Lcom/ss/android/lark/officesdk/di/core/deps/IMonitorDependency$IMonitorCode;", "createNormalMonitor", MapMonitorConst.EVENT_DESTROY, LiveCommonConstants.REASON_ON_DEDTROY, "setStableListener", "listener", "Lcom/ss/android/lark/officewebview/quality/stable/IStableListener;", "setPerformListener", "Lcom/ss/android/lark/officewebview/quality/performance/IPerformanceListener;", "onScrollChanged", "left", "", "top", "oldLeft", "oldTop", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "setBizType", "getBizType", "getBaseTraceId", "setStartTime", DyPayConstant.KEY_START_TIME, "getStartTime", "onResume", "loadUrl", "url", "additionalHttpHeaders", "loadDataWithBaseURL", "baseUrl", "data", DBDefinition.MIME_TYPE, "encoding", "historyUrl", "goBack", "onPause", "onStop", "isForegroundUsable", "onAttachedToWindow", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "getIsEnableLarkWebviewInsetPauseTimers", "getIsEnableLarkWebviewInsetResumeTimers", "enablePluginDuplicateCheck", "setMonitorConfig", "monitor", "Lcom/ss/android/lark/officewebview/base/interfaces/ILarkWebViewHybridMonitor;", "checkWhiteScreen", "checkWhiteScreenForResult", "getWebViewType", "Companion", "LarkHybridMonitor", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeWebView extends g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f437425u = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public dxb.b f437426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f437427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.officewebview.util.c f437428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f437429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final xwb.a f437430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f437431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f437432n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f437433o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f437434p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f437435q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f437436r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f437437s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f437438t;

    public static final class a {
    }

    static {
    }

    public OfficeWebView(Context r100) {
        this(r100, null, 6);
    }

    public OfficeWebView(Context r100, AttributeSet r101) {
        this(r100, r101, 4);
    }

    private final boolean getIsEnableLarkWebviewInsetPauseTimers() {
        return false;
    }

    private final boolean getIsEnableLarkWebviewInsetResumeTimers() {
        return false;
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        this.f437433o = true;
        int r100 = t.f470510a;
        String r101 = getUrl();
        dxb.g r102 = new dxb.g("wb_webview_destroy", dxb.c.f470463h, this);
        t.a(this, r102, r101);
        r102.b();
        int r103 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r104 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r104 == null) goto L5;
        r104.destroy();
    L5:
        super.destroy();
        xwb.a r105 = this.f437430l;
        r105.getClass();
        j.e("CML_TAG_JSBridge", MapMonitorConst.EVENT_DESTROY);
        ((ConcurrentHashMap) r105.f565288b.f565311a).clear();
        r105.f565289c.shutdown();
        getPluginBridge().release();
        int r106 = com.ss.android.lark.officesdk.utils.di.g.f437223a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.webview.monitor.clean.disable") == true) goto L11;
        Intrinsics.checkNotNullParameter(this.f437429k, "monitorId");
        zwb.a r107 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r107 == null) goto L11;
        r107.d0();
    L11:
        if (((Boolean) this.f437436r.getValue()).booleanValue() == false) goto L13;
        getPluginList().clear();
    L13:
        j.e(LarkWebView.TAG, "larkwebview destroy");
    }

    @Override // com.ss.android.lark.officewebview.base.g, wwb.c
    public OfficeWebView getWebView() {
        return this;
    }

    public final void setParamInjector(wwb.e r100) {
    }

    private final zwb.c getPluginBridge() {
        return (zwb.c) this.f437437s.getValue();
    }

    private final List<String> getPluginList() {
        return (List) this.f437435q.getValue();
    }

    private final String getWebViewType() {
        int r100 = dxb.d.f470469a;
        Lazy<n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        TTWebViewUtil.a.c(this);
        return "sys_webview";
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public String getBizType() {
        dxb.b r100 = this.f437426h;
        if (r100 != null) goto L6;
        dxb.b r101 = dxb.b.f470452b;
        r100 = dxb.b.f470454d;
    L6:
        return r100.a();
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public Map<String, Object> getCommonParams() {
        this.f437438t.put("event_time", Long.valueOf(System.currentTimeMillis()));
        Map<String, String> r100 = this.f437431m;
        if (r100 == null) goto L6;
        this.f437438t.putAll(r100);
    L6:
        return this.f437438t;
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public Map<String, Object> getReasonParams() {
        return new HashMap();
    }

    @Override // android.webkit.WebView
    public final void goBack() {
        int r100 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r101 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r101 == null) goto L5;
        r101.goBack();
    L5:
        super.goBack();
    }

    @Override // com.ss.android.lark.officewebview.base.g
    public final void k() {
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.c.class);
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.a.class);
        ((oxb.e) this.f437458a.a(oxb.e.class)).J(this);
        Lazy<n> r100 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        j.e(LarkWebView.TAG, "afterInitServiceManager, isTTWebView = false");
        TTWebViewUtil.a.d(this);
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.g.class);
        com.ss.android.lark.officewebview.quality.stable.d r101 = (com.ss.android.lark.officewebview.quality.stable.d) this.f437458a.a(com.ss.android.lark.officewebview.quality.stable.d.class);
        oxb.f r102 = (oxb.f) this.f437458a.a(oxb.f.class);
        if (r102 == null) goto L5;
        otb.e r103 = r102.B();
    L6:
        r101.M(r103, this);
        if (ixb.a.a() == false) goto L11;
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.e.class);
        jxb.a r104 = (jxb.a) this.f437458a.a(jxb.a.class);
        if (r104 == null) goto L11;
        r104.b(this);
    L11:
        this.f437458a.b(WebViewPerformanceService.class);
        ((mxb.b) this.f437458a.a(mxb.b.class)).b(this);
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.d.class);
        this.f437458a.b(com.ss.android.lark.officewebview.service.impl.f.class);
        ((com.ss.android.lark.officewebview.quality.safe.a) this.f437458a.a(com.ss.android.lark.officewebview.quality.safe.a.class)).b(this);
        dxb.b r105 = this.f437426h;
        if (r105 == null) goto L15;
        TTWebViewUtil.a.e(this, r105.a());
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        j.e(LarkWebView.TAG, "onAttachedToWindow, biz = " + this.f437432n);
        int r100 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r101 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r101 == null) goto L5;
        r101.onAttachedToWindow();
    L5:
        super.onAttachedToWindow();
        oxb.n r102 = getServiceManager();
        if (r102 == null) goto L11;
        jxb.a r103 = (jxb.a) r102.a(jxb.a.class);
        if (r103 == null) goto L12;
        r103.start();
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public void onPause() {
        int r100 = t.f470510a;
        String r101 = getUrl();
        Lazy<Handler> r102 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new h(this, r101));
        super.onPause();
        j.e(LarkWebView.TAG, "lark webview onPause, biz = " + this.f437432n);
        if (getIsEnableLarkWebviewInsetPauseTimers() == false) goto L6;
        pauseTimers();
        j.e(LarkWebView.TAG, "lark webview call inset pauseTimers");
        return;
    }

    public final boolean n() {
        if (getWebView().f437433o == false) goto L6;
        String r100 = MapMonitorConst.EVENT_DESTROY;
    L13:
        if (r100.length() <= 0) goto L15;
        boolean r101 = true;
    L16:
        if (r101 == false) goto L19;
        j.e(LarkWebView.TAG, "biz = " + this.f437432n + " not foreground, reason = " + r100);
        return false;
    L19:
        return true;
    L15:
        r101 = false;
        goto L16
    L6:
        if (getWebView().isAttachedToWindow() == true) goto L9;
        r100 = "not attached";
        goto L13
    L9:
        if (getWebView().isShown() == true) goto L11;
        r100 = "not shown";
        goto L13
    L11:
        r100 = "";
        goto L13
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public void onResume() {
        super.onResume();
        int r100 = t.f470510a;
        String r101 = getUrl();
        Lazy<Handler> r102 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new i(this, r101));
        j.e(LarkWebView.TAG, "lark webview onResume, biz = " + this.f437432n);
        if (getIsEnableLarkWebviewInsetResumeTimers() == false) goto L5;
        resumeTimers();
        j.e(LarkWebView.TAG, "lark webview call inset resumeTimers");
    L5:
        oxb.n r103 = getServiceManager();
        if (r103 == null) goto L11;
        jxb.a r104 = (jxb.a) r103.a(jxb.a.class);
        if (r104 == null) goto L12;
        r104.start();
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public String getBaseTraceId() {
        return this.f437427i;
    }

    public final String getBizScene$webview_release() {
        return this.f437432n;
    }

    public final xwb.a getBridge() {
        return this.f437430l;
    }

    public final String getContainerMonitorId$webview_release() {
        return this.f437429k;
    }

    @Override // com.ss.android.lark.officewebview.base.g, wwb.c
    public oxb.n getServiceManager() {
        return this.f437458a;
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public long getStartTime() {
        return this.f437434p;
    }

    public final boolean getWebViewIsDestroy() {
        return this.f437433o;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void loadUrl(String r100) {
        int r101 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r102 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r102 == null) goto L5;
        r102.X();
    L5:
        super.loadUrl(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Iterator r101 = ((ArrayList) this.f437428j.f437539a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (((View.OnTouchListener) r101.next()).onTouch(this, r100) == false) goto L4;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        if (r100 == null) goto L13;
        r100.setAction(3);
    L13:
        return super.onTouchEvent(r100);
    L8:
        r102 = false;
        goto L9
    }

    public void setBizScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f437432n = r100;
    }

    public final void setBizType(dxb.b r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f437426h = r100;
        Lazy<n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.e(this, r100.a());
        ConcurrentHashMap<String, Object> r102 = this.f437438t;
        dxb.b r103 = this.f437426h;
        if (r103 != null) goto L5;
        r103 = dxb.b.f470454d;
    L5:
        r102.put("biz_type", r103.a());
    }

    public final void setInjectedLogParams(Map<String, String> r100) {
        this.f437431m = r100;
    }

    public final void setMonitorConfig(wwb.d r100) {
        if (r100 == null) goto L6;
        r100.getMonitorDataCallback();
        int r101 = com.ss.android.lark.officewebview.util.a.f437536a;
        zwb.a r102 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r102 == null) goto L6;
        r102.buildConfig();
    L6:
        j.b(LarkWebView.TAG, "monitor is null");
    }

    public final void setPerformListener(mxb.a r100) {
        if (r100 == null) goto L8;
        oxb.n r101 = getServiceManager();
        if (r101 == null) goto L8;
        mxb.b r102 = (mxb.b) r101.a(mxb.b.class);
        if (r102 == null) goto L8;
        r102.E();
    L8:
        StringBuilder r103 = new StringBuilder("setPerformListener result = ");
        if (r100 != null) goto L11;
        boolean r104 = true;
    L12:
        r103.append(r104);
        j.e(LarkWebView.TAG, r103.toString());
        return;
    L11:
        r104 = false;
        goto L12
    }

    public final void setStableListener(com.ss.android.lark.officewebview.quality.stable.c r100) {
        if (r100 == null) goto L8;
        oxb.n r101 = getServiceManager();
        if (r101 == null) goto L8;
        com.ss.android.lark.officewebview.quality.stable.d r102 = (com.ss.android.lark.officewebview.quality.stable.d) r101.a(com.ss.android.lark.officewebview.quality.stable.d.class);
        if (r102 == null) goto L8;
        r102.r();
    L8:
        StringBuilder r103 = new StringBuilder("setStableListener result = ");
        if (r100 != null) goto L11;
        boolean r104 = true;
    L12:
        r103.append(r104);
        j.e(LarkWebView.TAG, r103.toString());
        return;
    L11:
        r104 = false;
        goto L12
    }

    public final void setStartTime(long r100) {
        this.f437434p = r100;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void loadUrl(String r100, Map<String, String> r101) {
        super.loadUrl(r100, r101);
        int r102 = com.ss.android.lark.officewebview.util.a.f437536a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r103 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r103 == null) goto L6;
        r103.X();
        return;
    }

    public final dxb.g m(String r100, o.b r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return new dxb.g(r100, r101, this);
    }

    @Override // android.view.View, zv4.b
    public ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        j.e(LarkWebView.TAG, "startActionMode---run");
        int r102 = com.ss.android.lark.officewebview.util.h.f437547a;
        DependencyContainer r103 = DependencyContainer.f433166a;
        zwb.d r104 = (zwb.d) DependencyContainer.a(zwb.d.class, DependencyContextUniqueId.OfficeWebView);
        if (r104 == null) goto L8;
        ActionMode.Callback r105 = r104.v();
        if (r105 == null) goto L8;
        r100 = r105;
    L8:
        oxb.n r106 = getServiceManager();
        if (r106 == null) goto L11;
        wwb.a r107 = (wwb.a) r106.a(wwb.a.class);
    L12:
        if (r107 == null) goto L15;
        j.e(LarkWebView.TAG, "use Customize callBack");
        return super.startActionMode(r107.a(), r101);
    L15:
        j.e(LarkWebView.TAG, "not find ILarkWebViewActionMode impl");
        return super.startActionMode(r100, r101);
    L11:
        r107 = null;
        goto L12
    }

    public OfficeWebView(Context r100, AttributeSet r101, int r102) {
        dxb.b r103 = null;
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r103 = dxb.b.f470454d;
    L8:
        super(new com.ss.android.lark.officewebview.util.d(r100), r101);
        this.f437426h = r103;
        String r104 = "";
        this.f437427i = "";
        this.f437428j = new com.ss.android.lark.officewebview.util.c();
        int r105 = com.ss.android.lark.officewebview.util.a.f437536a;
        zwb.a r106 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r106 == null) goto L12;
        String r107 = r106.Z();
        if (r107 == null) goto L12;
    L13:
        this.f437429k = r107;
        this.f437430l = new xwb.a(this);
        this.f437432n = "";
        this.f437435q = LazyKt.lazy(OfficeWebView$pluginList$2.INSTANCE);
        this.f437436r = LazyKt.lazy(new OfficeWebView$isEnablePluginDuplicateCheck$2(this));
        this.f437437s = LazyKt.lazy(new OfficeWebView$pluginBridge$2(this));
        ConcurrentHashMap<String, Object> r108 = new ConcurrentHashMap();
        dxb.b r109 = this.f437426h;
        if (r109 != null) goto L16;
        r109 = dxb.b.f470454d;
    L16:
        r108.put("biz_type", r109.a());
        r108.put("os", "Android");
        r108.put(BindCardPayConfirmConstants.Key.TRACE_ID, this.f437427i);
        int r110 = dxb.d.f470469a;
        Lazy<n> r111 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        r108.put("webview_type", "sys_webview");
        r108.put("ttwebview_version", getTTWebViewVersion());
        TTWebViewUtil.a.d(this);
        TTWebViewUtil.a.c(this);
        r108.put("webview_tt_type", "sys_webview");
        this.f437438t = r108;
        int r112 = l.f437227a;
        o r113 = l.a.a();
        if (r113 == null) goto L22;
        String r114 = r113.k0();
        if (r114 == null) goto L22;
        r104 = r114;
    L22:
        this.f437427i = r104;
        int r115 = t.f470510a;
        this.f437464g.getClass();
        long r116 = System.currentTimeMillis() - 0;
        Lazy<Handler> r117 = ThreadUtil.f437211a;
        ThreadUtil.a.b(new s(this, r116));
        Intrinsics.checkNotNullParameter(r107, "monitorId");
        Intrinsics.checkNotNullParameter(this, "view");
        zwb.a r118 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r118 == null) goto L26;
        r118.i0();
        r118.attach();
        return;
    L26:
        return;
    L12:
        r107 = "";
        goto L13
    }

    public final zwb.f o(String r100, JSONObject r101, xwb.c r102) {
        Intrinsics.checkNotNullParameter(r100, "api");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        return getPluginBridge().a(r100, r101, r102);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        oxb.n r104 = this.f437458a;
        if (r104 == null) goto L8;
        oxb.h r105 = (oxb.h) r104.a(oxb.h.class);
        if (r105 == null) goto L9;
        r105.u(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void loadDataWithBaseURL(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        super.loadDataWithBaseURL(r100, r101, r102, r103, r104);
        int r105 = com.ss.android.lark.officewebview.util.a.f437536a;
        getUrl();
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r106 = com.ss.android.lark.officewebview.util.a.C5225a.a();
        if (r106 == null) goto L6;
        r106.X();
        return;
    }

    @Override // android.view.View
    public boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r210, int r211, boolean r212) {
        boolean r100 = super.overScrollBy(r110, r111, r112, r113, r114, r115, r210, r211, r212);
        oxb.n r101 = this.f437458a;
        if (r101 == null) goto L7;
        oxb.h r102 = (oxb.h) r101.a(oxb.h.class);
        if (r102 == null) goto L7;
        r102.m(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    L7:
        return r100;
    }
}
