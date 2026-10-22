package com.bytedance.ee.larkwebview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.larkwebview.networkproxy.InjectHookJsInstance;
import com.bytedance.ee.larkwebview.quality.HangDetectConfig;
import com.bytedance.ee.larkwebview.quality.WebViewOptimizeConfig;
import com.bytedance.ee.larkwebview.service.impl.WebViewPerformanceService;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.suite.lark.emm.impl.SCClipboardProvider;
import gt5.i;
import gt5.p;
import gt5.s;
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
import org.json.JSONObject;
import otb.n;
import st5.o;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 £\u00012\u00020\u0001:\u0004£\u0001¤\u0001B+\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000bJ\u001c\u00109\u001a\u00020:2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010$J\u0010\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\rH\u0016J\r\u0010>\u001a\u00020\rH\u0000¢\u0006\u0002\b?J\u001e\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020:2\u0006\u0010J\u001a\u00020KJ\u0006\u0010P\u001a\u00020\"J\b\u0010Q\u001a\u00020:H\u0014J\n\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u00020\u0000H\u0016J\n\u0010U\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020FH\u0016J\u0012\u0010Y\u001a\u00020:2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\\\u001a\u00020:2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010]\u001a\u00020:H\u0016J\u0012\u0010^\u001a\u00020\u00112\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020:H\u0002J\u0016\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020O\u0018\u00010cH\u0016J\u0010\u0010d\u001a\u00020:2\b\u0010e\u001a\u0004\u0018\u000101J\u0014\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020O0cH\u0016J\u001a\u0010g\u001a\u00020h2\u0006\u0010_\u001a\u00020\r2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u001a\u0010k\u001a\u00020h2\u0006\u0010_\u001a\u00020\r2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\b\u0010l\u001a\u00020:H\u0016J\b\u0010m\u001a\u00020:H\u0016J\u0010\u0010n\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010pJ\u0010\u0010q\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010rJ(\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020u2\u0006\u0010w\u001a\u00020u2\u0006\u0010x\u001a\u00020uH\u0014JS\u0010y\u001a\u00020\u00112\u0006\u0010z\u001a\u00020u2\u0006\u0010{\u001a\u00020u2\u0006\u0010|\u001a\u00020u2\u0006\u0010}\u001a\u00020u2\u0006\u0010~\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020u2\u0007\u0010\u0080\u0001\u001a\u00020u2\u0007\u0010\u0081\u0001\u001a\u00020u2\u0007\u0010\u0082\u0001\u001a\u00020\u0011H\u0014J\u000f\u0010\u0083\u0001\u001a\u00020:2\u0006\u0010\n\u001a\u00020\u0007J\t\u0010\u0084\u0001\u001a\u00020\rH\u0016J\u0010\u0010\u0085\u0001\u001a\u00020:2\u0007\u0010\u0086\u0001\u001a\u00020/J\t\u0010\u0087\u0001\u001a\u00020/H\u0016J\t\u0010\u0088\u0001\u001a\u00020:H\u0016J\u0014\u0010\u0089\u0001\u001a\u00020:2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\rH\u0016J+\u0010\u0089\u0001\u001a\u00020:2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\r2\u0015\u0010\u008b\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010cH\u0016J>\u0010\u008c\u0001\u001a\u00020:2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u008e\u0001\u001a\u00020\r2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010\u0092\u0001\u001a\u00020:H\u0016J\t\u0010\u0093\u0001\u001a\u00020:H\u0016J\t\u0010\u0094\u0001\u001a\u00020:H\u0016J\u0007\u0010\u0095\u0001\u001a\u00020\u0011J\t\u0010\u0096\u0001\u001a\u00020:H\u0014J\u001f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u00012\t\u0010G\u001a\u0005\u0018\u00010\u0099\u00012\u0006\u0010\n\u001a\u00020uH\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u009b\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u009c\u0001\u001a\u00020\u0011H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020:2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J\u0007\u0010 \u0001\u001a\u00020:J\u0007\u0010¡\u0001\u001a\u00020\u0011J\t\u0010¢\u0001\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R!\u00102\u001a\b\u0012\u0004\u0012\u00020\r038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u001d\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001d\u001a\u0004\b7\u0010-R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020O0NX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¥\u0001"}, d2 = {"Lcom/bytedance/ee/larkwebview/base/LarkWebView;", "Lcom/bytedance/ee/larkwebview/base/BaseWebView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "set", "Landroid/util/AttributeSet;", "bizType", "Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;)V", "type", "(Landroid/content/Context;Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;)V", "mTracingId", "", "mTracingSpan", "Lcom/ss/android/lark/optrace/api/TracingCoreSpan;", "mIsEnableLarkWebviewInsetPauseTimers", "", "Ljava/lang/Boolean;", "mIsEnableLarkWebviewInsetResumeTimers", "larkWebViewDependency", "Lcom/bytedance/ee/larkwebview/dependency/ILarkWebViewDependency;", "bridgeWebViewTouchDispatcher", "Lcom/bytedance/ee/larkwebview/util/BridgeWebViewTouchDispatcher;", "extensionBridge", "Lcom/bytedance/lark/webview/ttwebsdkbridge/TTWebExtensionBridge;", "getExtensionBridge", "()Lcom/bytedance/lark/webview/ttwebsdkbridge/TTWebExtensionBridge;", "extensionBridge$delegate", "Lkotlin/Lazy;", "monitorBridge", "Lcom/bytedance/ee/larkwebview/base/monitor/MonitorBridge;", "monitorId", "mBridge", "Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "injectedLogParams", "", "larkHybridMonitor", "Lcom/bytedance/ee/larkwebview/base/LarkWebView$LarkHybridMonitor;", "monitorConfig", "Lcom/bytedance/ee/larkwebview/base/monitor/MonitorConfigBridge;", "bizScene", "value", "webViewIsDestroy", "getWebViewIsDestroy", "()Z", "mStartTime", "", "mParamInjector", "Lcom/bytedance/ee/larkwebview/base/interfaces/ILarkWebViewParamInjector;", "pluginList", "", "getPluginList", "()Ljava/util/List;", "pluginList$delegate", "isEnablePluginDuplicateCheck", "isEnablePluginDuplicateCheck$delegate", "setInjectedLogParams", "", "logParams", "setBizScene", "scene", "getBizScene", "getBizScene$lark_webview_base_chinaRelease", "coreTarget", "Lcom/larksuite/framework/apiplugin/core/LKCoreTarget;", "sendEvent", "Lcom/larksuite/framework/apiplugin/entity/LKBasePluginResult;", "api", "params", "Lorg/json/JSONObject;", "callback", "Lcom/larksuite/framework/apiplugin/api/LKEventCallback;", "registerPlugin", "lkPlugin", "Lcom/larksuite/framework/apiplugin/LKPlugin;", "registerPluginOnce", "mCommonParams", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getBridge", "afterInitServiceManager", "getServiceManager", "Lcom/bytedance/ee/larkwebview/service/ServiceManager;", "getWebView", "getBaseTraceSpan", "reportEvent", "eventName", "eventJson", "addTouchListener", "onTouchListener", "Landroid/view/View$OnTouchListener;", "removeTouchListener", "clearTouchListeners", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "initTracing", "getCommonParams", "", "setParamInjector", "paramInjector", "getReasonParams", "createErrorMonitor", "Lcom/bytedance/ee/larkwebview/monitor/webview/WebMonitor;", "monitorCode", "Lcom/ss/android/lark/opmonitor/model/OPMonitorCode;", "createNormalMonitor", MapMonitorConst.EVENT_DESTROY, LiveCommonConstants.REASON_ON_DEDTROY, "setStableListener", "listener", "Lcom/bytedance/ee/larkwebview/quality/stable/IStableListener;", "setPerformListener", "Lcom/bytedance/ee/larkwebview/quality/performance/IPerformanceListener;", "onScrollChanged", "left", "", "top", "oldLeft", "oldTop", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "setBizType", "getBizType", "setStartTime", DyPayConstant.KEY_START_TIME, "getStartTime", "onResume", "loadUrl", "url", "additionalHttpHeaders", "loadDataWithBaseURL", "baseUrl", "data", DBDefinition.MIME_TYPE, "encoding", "historyUrl", "goBack", "onPause", "onStop", "isForegroundUsable", "onAttachedToWindow", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "getIsEnableLarkWebviewInsetPauseTimers", "getIsEnableLarkWebviewInsetResumeTimers", "enablePluginDuplicateCheck", "setMonitorConfig", "monitor", "Lcom/bytedance/ee/larkwebview/base/interfaces/ILarkWebViewHybridMonitor;", "checkWhiteScreen", "checkWhiteScreenForResult", "getWebViewType", "Companion", "LarkHybridMonitor", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LarkWebView extends g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f242842z = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gt5.d f242843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f242844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OPTrace f242845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f242846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f242847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ct5.a f242848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.larkwebview.util.b f242849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f242850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final zs5.c f242851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final at5.a f242852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f242853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f242854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f242855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f242856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f242857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f242858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.ee.larkwebview.util.e f242859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f242860y;

    public static final class a {
    }

    static {
    }

    public LarkWebView(Context r100) {
        this(r100, null, 6);
    }

    public LarkWebView(Context r100, AttributeSet r101) {
        this(r100, r101, 4);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f242855t = true;
        this.f242851p.getClass();
        super.destroy();
        this.f242852q.b();
        this.f242859x.f242971f = null;
        int r100 = p.f482566a;
        String r101 = getUrl();
        gt5.g r102 = new gt5.g("wb_webview_destroy", gt5.e.f482528l, this);
        p.a(this, r102, r101);
        r102.flush();
        if (FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.webview.monitor.clean.disable") == true) goto L6;
        this.f242851p.getClass();
    L6:
        if (((Boolean) this.f242858w.getValue()).booleanValue() == false) goto L8;
        getPluginList().clear();
    L8:
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "larkwebview destroy");
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ys5.c
    public LarkWebView getWebView() {
        return this;
    }

    public final void setParamInjector(ys5.e r100) {
    }

    private final ve6.a getExtensionBridge() {
        return (ve6.a) this.f242850o.getValue();
    }

    private final boolean getIsEnableLarkWebviewInsetPauseTimers() {
        if (this.f242846k != null) goto L8;
        if (this.f242848m == null) goto L8;
        this.f242846k = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.lark.webview.inset.pause.timers.enable"));
    L8:
        return Intrinsics.areEqual(this.f242846k, Boolean.TRUE);
    }

    private final boolean getIsEnableLarkWebviewInsetResumeTimers() {
        if (this.f242847l != null) goto L8;
        if (this.f242848m == null) goto L8;
        this.f242847l = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("openplatform.lark.webview.inset.resume.timers.enable"));
    L8:
        return Intrinsics.areEqual(this.f242847l, Boolean.TRUE);
    }

    private final List<String> getPluginList() {
        return (List) this.f242857v.getValue();
    }

    private final String getWebViewType() {
        int r100 = gt5.f.f482536a;
        Lazy<n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        TTWebViewUtil.a.c(this);
        return "sys_webview";
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ft5.a
    public String getBizType() {
        gt5.d r100 = this.f242843h;
        if (r100 != null) goto L6;
        gt5.d r101 = gt5.d.f482512b;
        r100 = gt5.d.f482515e;
    L6:
        return r100.a();
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ft5.a
    public Map<String, Object> getCommonParams() {
        this.f242860y.put("event_time", Long.valueOf(System.currentTimeMillis()));
        Map<String, String> r100 = this.f242853r;
        if (r100 == null) goto L6;
        this.f242860y.putAll(r100);
    L6:
        return this.f242860y;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ft5.a
    public Map<String, Object> getReasonParams() {
        return new HashMap();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        this.f242851p.getClass();
        super.goBack();
    }

    @Override // com.bytedance.ee.larkwebview.base.g
    public final void j() {
        this.f242880a.b(InjectHookJsInstance.class);
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.c.class);
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.a.class);
        ((st5.f) this.f242880a.a(st5.f.class)).H(this);
        Lazy<n> r100 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "afterInitServiceManager, isTTWebView = false");
        TTWebViewUtil.a.d(this);
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.g.class);
        com.bytedance.ee.larkwebview.quality.stable.d r101 = (com.bytedance.ee.larkwebview.quality.stable.d) this.f242880a.a(com.bytedance.ee.larkwebview.quality.stable.d.class);
        st5.g r102 = (st5.g) this.f242880a.a(st5.g.class);
        HangDetectConfig r103 = null;
        if (r102 == null) goto L5;
        otb.e r104 = r102.B();
    L6:
        r101.F(r104, this);
        if (lt5.a.f510673b == true) goto L9;
        Log.i("WebViewOptimizeUtil", "hangFgEnable is false");
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L19;
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.e.class);
        mt5.a r106 = (mt5.a) this.f242880a.a(mt5.a.class);
        if (r106 == null) goto L19;
        r106.b(this);
    L19:
        this.f242880a.b(WebViewPerformanceService.class);
        ((pt5.b) this.f242880a.a(pt5.b.class)).b(this);
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.d.class);
        this.f242880a.b(com.bytedance.ee.larkwebview.service.impl.f.class);
        ((com.bytedance.ee.larkwebview.quality.safe.b) this.f242880a.a(com.bytedance.ee.larkwebview.quality.safe.b.class)).b(this);
        gt5.d r107 = this.f242843h;
        if (r107 == null) goto L23;
        getExtensionBridge().a(r107.a());
        return;
    L23:
        return;
    L9:
        WebViewOptimizeConfig r108 = lt5.a.f510672a;
        if (r108 == null) goto L12;
        r103 = r108.getHangDetect();
    L12:
        if (r103 == null) goto L14;
        r105 = r103.getEnableDetection();
        goto L15
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.f242851p.getClass();
        super.onAttachedToWindow();
        o r100 = getServiceManager();
        if (r100 == null) goto L8;
        mt5.a r101 = (mt5.a) r100.a(mt5.a.class);
        if (r101 == null) goto L9;
        r101.start();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public void onPause() {
        int r100 = p.f482566a;
        String r101 = getUrl();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new gt5.h(this, r101));
        super.onPause();
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "lark webview onPause");
        if (getIsEnableLarkWebviewInsetPauseTimers() == false) goto L6;
        pauseTimers();
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "lark webview call inset pauseTimers");
        return;
    }

    public final boolean n() {
        if (getWebView().f242855t == false) goto L6;
        String r100 = MapMonitorConst.EVENT_DESTROY;
    L13:
        if (r100.length() <= 0) goto L15;
        boolean r101 = true;
    L16:
        if (r101 == false) goto L19;
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "biz = " + this.f242854s + " not foreground, reason = " + r100);
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

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public void onResume() {
        super.onResume();
        int r100 = p.f482566a;
        String r101 = getUrl();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new i(this, r101));
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "lark webview onResume");
        if (getIsEnableLarkWebviewInsetResumeTimers() == false) goto L5;
        resumeTimers();
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "lark webview call inset resumeTimers");
    L5:
        o r102 = getServiceManager();
        if (r102 == null) goto L11;
        mt5.a r103 = (mt5.a) r102.a(mt5.a.class);
        if (r103 == null) goto L12;
        r103.start();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ft5.a
    public TracingCoreSpan getBaseTraceSpan() {
        return this.f242845j;
    }

    public final String getBizScene$lark_webview_base_chinaRelease() {
        return this.f242854s;
    }

    public final at5.a getBridge() {
        return this.f242852q;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ys5.c
    public o getServiceManager() {
        return this.f242880a;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, ft5.a
    public long getStartTime() {
        return this.f242856u;
    }

    public final boolean getWebViewIsDestroy() {
        return this.f242855t;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public void loadUrl(String r100) {
        this.f242851p.getClass();
        super.loadUrl(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Iterator r101 = ((ArrayList) this.f242849n.f242966a).iterator();
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
        this.f242854s = r100;
    }

    public final void setBizType(gt5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f242843h = r100;
        getExtensionBridge().a(r100.a());
        ConcurrentHashMap<String, Object> r101 = this.f242860y;
        gt5.d r102 = this.f242843h;
        if (r102 != null) goto L5;
        gt5.d r103 = gt5.d.f482512b;
        r102 = gt5.d.f482515e;
    L5:
        r101.put("biz_type", r102.a());
    }

    public final void setInjectedLogParams(Map<String, String> r100) {
        this.f242853r = r100;
    }

    public final void setMonitorConfig(ys5.d r100) {
        if (r100 == null) goto L4;
        r100.getMonitorDataCallback();
        r100.openMonitor();
        int r101 = h.f242887a;
        this.f242851p.getClass();
        zs5.b r102 = zs5.b.f573486a;
        r100.openMonitor();
        r100.getBid();
        String r103 = r100.getBizType().a();
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter("biz_type", "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        String.valueOf(hashCode());
        this.f242851p.getClass();
        this.f242851p.getClass();
        return;
    L4:
        Log.e(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "monitor is null");
    }

    public final void setPerformListener(pt5.a r100) {
        if (r100 == null) goto L8;
        o r101 = getServiceManager();
        if (r101 == null) goto L8;
        pt5.b r102 = (pt5.b) r101.a(pt5.b.class);
        if (r102 == null) goto L8;
        r102.E();
    L8:
        StringBuilder r103 = new StringBuilder("setPerformListener result = ");
        if (r100 != null) goto L11;
        boolean r104 = true;
    L12:
        r103.append(r104);
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, r103.toString());
        return;
    L11:
        r104 = false;
        goto L12
    }

    public final void setStableListener(com.bytedance.ee.larkwebview.quality.stable.c r100) {
        if (r100 == null) goto L8;
        o r101 = getServiceManager();
        if (r101 == null) goto L8;
        com.bytedance.ee.larkwebview.quality.stable.d r102 = (com.bytedance.ee.larkwebview.quality.stable.d) r101.a(com.bytedance.ee.larkwebview.quality.stable.d.class);
        if (r102 == null) goto L8;
        r102.r();
    L8:
        StringBuilder r103 = new StringBuilder("setStableListener result = ");
        if (r100 != null) goto L11;
        boolean r104 = true;
    L12:
        r103.append(r104);
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, r103.toString());
        return;
    L11:
        r104 = false;
        goto L12
    }

    public final void setStartTime(long r100) {
        this.f242856u = r100;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public void loadUrl(String r100, Map<String, String> r101) {
        super.loadUrl(r100, r101);
        this.f242851p.getClass();
    }

    public final gt5.g m(String r100, OPMonitorCode r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        return new gt5.g(r100, r101, this);
    }

    @Override // ft5.a
    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventJson");
        ct5.a r102 = (ct5.a) ClaymoreServiceLoader.loadFirst(ct5.a.class);
        if (r102 == null) goto L5;
        r102.reportEvent(r100, r101);
        return;
    L5:
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "host not setDependency");
    }

    @Override // android.view.View, zv4.b
    public ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "startActionMode---run");
        int r102 = com.suite.lark.emm.impl.a.f460436a;     // Catch: Throwable -> L12
        com.suite.lark.emm.impl.a.C5524a.a().getClass();     // Catch: Throwable -> L12
        ActionMode.Callback r103 = SCClipboardProvider.a().R0(r100);     // Catch: Throwable -> L12
        o r104 = getServiceManager();     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        ys5.a r105 = (ys5.a) r104.a(ys5.a.class);     // Catch: Throwable -> L12
    L7:
        if (r105 == null) goto L10;
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "use Customize callBack");     // Catch: Throwable -> L12
        return super.startActionMode(r105.a(), r101);
    L10:
        Log.i(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "not find ILarkWebViewActionMode impl");     // Catch: Throwable -> L12
        return super.startActionMode(r103, r101);
    L6:
        r105 = null;
    L12:
        th = move-exception;
        Log.e(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "startActionMode error", th);
        return null;
    }

    public LarkWebView(Context r100, AttributeSet r101, gt5.d r102) {
        super(new com.bytedance.ee.larkwebview.util.c(r100), r101);
        this.f242843h = r102;
        this.f242844i = "";
        this.f242848m = (ct5.a) ClaymoreServiceLoader.loadFirst(ct5.a.class);
        this.f242849n = new com.bytedance.ee.larkwebview.util.b();
        this.f242850o = LazyKt.lazy(new LarkWebView$extensionBridge$2(this));
        this.f242851p = zs5.a.f573485a;
        this.f242852q = new at5.a(this);
        this.f242854s = "";
        this.f242857v = LazyKt.lazy(LarkWebView$pluginList$2.INSTANCE);
        this.f242858w = LazyKt.lazy(new LarkWebView$isEnablePluginDuplicateCheck$2(this));
        this.f242859x = new com.bytedance.ee.larkwebview.util.e(getContext());
        ConcurrentHashMap<String, Object> r103 = new ConcurrentHashMap();
        gt5.d r104 = this.f242843h;
        if (r104 != null) goto L5;
        r104 = gt5.d.f482515e;
    L5:
        r103.put("biz_type", r104.a());
        r103.put("os", "Android");
        r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, this.f242844i);
        int r105 = gt5.f.f482536a;
        Lazy<n> r106 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(this);
        r103.put("webview_type", "sys_webview");
        r103.put("ttwebview_version", getTTWebViewVersion());
        TTWebViewUtil.a.d(this);
        TTWebViewUtil.a.c(this);
        r103.put("webview_tt_type", "sys_webview");
        this.f242860y = r103;
        OPTrace r107 = gyb.a.a();
        this.f242845j = r107;
        if (r107 == null) goto L8;
        Intrinsics.checkNotNull(r107);
        this.f242844i = r107.getTracingID();
    L9:
        ct5.a r108 = (ct5.a) ClaymoreServiceLoader.loadFirst(ct5.a.class);
        int r109 = p.f482566a;
        this.f242886g.getClass();
        long r110 = System.currentTimeMillis() - 0;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new s(this, r110));
        return;
    L8:
        Log.e(com.ss.android.lark.chameleon.basewebview.LarkWebView.TAG, "tracingSpan is null");
        goto L9
    }

    public LarkWebView(Context r100, AttributeSet r101, int r102) {
        gt5.d r103 = null;
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r103 = gt5.d.f482515e;
    L8:
        this(r100, r101, r103);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        o r104 = this.f242880a;
        if (r104 == null) goto L8;
        st5.i r105 = (st5.i) r104.a(st5.i.class);
        if (r105 == null) goto L9;
        r105.u(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public final void loadDataWithBaseURL(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        super.loadDataWithBaseURL(r100, r101, r102, r103, r104);
        zs5.c r105 = this.f242851p;
        getUrl();
        r105.getClass();
    }

    @Override // android.view.View
    public boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r210, int r211, boolean r212) {
        boolean r100 = super.overScrollBy(r110, r111, r112, r113, r114, r115, r210, r211, r212);
        o r101 = this.f242880a;
        if (r101 == null) goto L7;
        st5.i r102 = (st5.i) r101.a(st5.i.class);
        if (r102 == null) goto L7;
        r102.m(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    L7:
        return r100;
    }
}
