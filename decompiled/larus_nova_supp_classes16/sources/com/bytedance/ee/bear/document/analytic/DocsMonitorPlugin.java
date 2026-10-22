package com.bytedance.ee.bear.document.analytic;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.ProcessMonitorConfig;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.i;
import tb5.m;
import vv4.k;
import zv4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b:\u0002PQB\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010#\u001a\u00020$2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0&H\u0016J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020$H\u0002J\u001a\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001c\u00101\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001c\u00104\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00105\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J2\u00106\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0016J\u001c\u0010=\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u0001082\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0017\u0010@\u001a\u00020$2\b\u0010A\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020E2\u0006\u0010>\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u00020$2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010I\u001a\u00020$2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010J\u001a\u00020$H\u0016J\"\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u00052\b\u0010N\u001a\u0004\u0018\u00010OH\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/document/analytic/DocsMonitorPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/browser/view/OnScrollChangeListener;", "Landroid/view/View$OnTouchListener;", "Landroidx/lifecycle/Observer;", "", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/bytedance/ee/bear/document/analytic/IPerfMonitorAbility;", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/CpuCollectTimerService$CpuCallback;", "<init>", "()V", "extra", "Lorg/json/JSONObject;", "jsbExtraMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "analyticService", "Lcom/bytedance/ee/bear/contract/AnalyticService;", "visibleService", "Lcom/bytedance/ee/bear/contract/AppVisibleService;", "fling", "isUserConsumingTouch", "initObserver", "monitorCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ee/bear/doc/follow/FollowApiV2$PerfCallback;", "processMonitor", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/ProcessMonitor;", "processMonitorConfig", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/ProcessMonitorConfig;", "vcFloatingModel", "downgradeCount", "", "flingEndRunnable", "Ljava/lang/Runnable;", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "isInVc", "putCommonExtra", "putExtra", "key", "value", "", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "onScrollChange", "v", "Landroid/view/View;", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onTouch", "event", "Landroid/view/MotionEvent;", "onChanged", "it", "(Ljava/lang/Boolean;)V", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle$Event;", "registerPerfMonitor", "callback", "unregisterPerfMonitor", "onDowngade", "onProcessCpuChange", "process", "restarted", "cpuInfo", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/CpuInfo;", "Companion", "BatterySceneHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocsMonitorPlugin extends DocumentPlugin implements f, View.OnTouchListener, Observer<Boolean>, LifecycleEventObserver, a05.f, c05.a.InterfaceC0010a {
    private static final String BIZ_UTIL_BATTERY_SCENE = "biz.util.processMonitorScene";
    public static final b Companion = null;
    public static final String TAG = "DocsMonitorPlugin";
    private final com.bytedance.ee.bear.contract.d analyticService;
    private int downgradeCount;
    private final JSONObject extra;
    private boolean fling;
    private final Runnable flingEndRunnable;
    private boolean initObserver;
    private boolean isUserConsumingTouch;
    private final ConcurrentHashMap<String, String> jsbExtraMap;
    private final CopyOnWriteArrayList<py4.d.b> monitorCallbacks;
    private c05.d processMonitor;
    private ProcessMonitorConfig processMonitorConfig;
    private boolean vcFloatingModel;
    private final com.bytedance.ee.bear.contract.f visibleService;

    public final class a implements i<BatterySceneData> {
        public final /* synthetic */ DocsMonitorPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(DocsMonitorPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, m r9) {
            BatterySceneData r10 = (BatterySceneData) r8;
            ProcessMonitorConfig r11 = DocsMonitorPlugin.access$getProcessMonitorConfig$p(this.a);
            if (r11 == null) goto L7;
            boolean r1 = true;
            if (r11.isJsbSceneEnable() != true) goto L7;
        L8:
            if (r1 == false) goto L51;
            tt5.a.h(DocsMonitorPlugin.TAG, "BatterySceneHandler data=" + r10);
            if (r10 != null) goto L13;
            return;
        L13:
            if (TextUtils.isEmpty(r10.getScene()) == false) goto L15;
            return;
        L15:
            if (TextUtils.isEmpty(r10.getOpt()) == false) goto L17;
            return;
        L17:
            if (DocsMonitorPlugin.access$isUIContainerDetached(this.a) == true) goto L52;
            String r12 = r10.getOpt();
            if (Intrinsics.areEqual(r12, BatterySceneData.OPT_START) == false) goto L26;
            c05.d r13 = DocsMonitorPlugin.access$getProcessMonitor$p(this.a);
            if (r13 == null) goto L24;
            r13.a("fe_" + r10.getScene());
        L24:
            DocsMonitorPlugin.access$getAnalyticService$p(this.a).k("fe_" + r10.getScene());
            return;
        L26:
            if (Intrinsics.areEqual(r12, BatterySceneData.OPT_END) == false) goto L50;
            JSONObject r14 = new JSONObject();
            HashMap<String, String> r2 = r10.getExtra();     // Catch: Throwable -> L35
            if (r2 == null) goto L37;
            Iterator<Map.Entry<String, String>> r3 = r2.entrySet().iterator();     // Catch: Throwable -> L35
        L32:
            if (r3.hasNext() == false) goto L37;
            Map.Entry<String, String> r4 = r3.next();     // Catch: Throwable -> L35
            r14.put("fe_" + r4.getKey(), r4.getValue());     // Catch: Throwable -> L35
        L37:
            c05.d r0 = DocsMonitorPlugin.access$getProcessMonitor$p(this.a);
            if (r0 == null) goto L40;
            r0.b("fe_" + r10.getScene(), r14);
        L40:
            DocsMonitorPlugin.access$getAnalyticService$p(this.a).p("fe_" + r10.getScene(), r14);
            return;
        L35:
            th = move-exception;
            tt5.a.f(DocsMonitorPlugin.TAG, th, false);
            goto L37
        L50:
            return;
        L52:
            return;
        L51:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DocsMonitorPlugin a;

        public d(DocsMonitorPlugin r1) {
            this.a = r1;
        }

        public final void a() {
            tt5.a.b(DocsMonitorPlugin.TAG, "flingEndRunnable run");
            DocsMonitorPlugin.access$setFling$p(this.a, false);
            DocsMonitorPlugin.access$setUserConsumingTouch$p(this.a, false);
            DocsMonitorPlugin.access$getAnalyticService$p(this.a).p("docs_fling", DocsMonitorPlugin.access$getExtra$p(this.a));
            c05.d r0 = DocsMonitorPlugin.access$getProcessMonitor$p(this.a);
            if (r0 == null) goto L6;
            r0.b("docs_fling", DocsMonitorPlugin.access$getExtra$p(this.a));
            return;
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
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void putCommonExtra() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.i("lark.core.cpu.manager.power.optimize", false);
        putExtra("batch_log", Boolean.valueOf(r0.i("ccm.common.batch_log", false)));
        putExtra("downgrade_enable", Boolean.valueOf(r1));
    }

    public DocsMonitorPlugin() {
        this.extra = new JSONObject();
        this.jsbExtraMap = new ConcurrentHashMap();
        this.analyticService = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        this.visibleService = (com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6);
        this.initObserver = true;
        this.monitorCallbacks = new CopyOnWriteArrayList();
        this.flingEndRunnable = new d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isInVc() {
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        if (r0 == null) goto L7;
        DocViewModel r1 = r0.a();
        if (r1 == null) goto L7;
        DocsOpenSource r2 = r1.getOpenSource();
    L9:
        if (r2 != DocsOpenSource.vc) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    @Override // a05.f
    public void onDowngade() {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        int r0 = this.downgradeCount + 1;
        this.downgradeCount = r0;
        putExtra("downgrade_count", Integer.valueOf(r0));
    }

    public static final /* synthetic */ com.bytedance.ee.bear.contract.d access$getAnalyticService$p(DocsMonitorPlugin r0) {
        return r0.analyticService;
    }

    public static final /* synthetic */ JSONObject access$getExtra$p(DocsMonitorPlugin r0) {
        return r0.extra;
    }

    public static final /* synthetic */ c05.d access$getProcessMonitor$p(DocsMonitorPlugin r0) {
        return r0.processMonitor;
    }

    public static final /* synthetic */ ProcessMonitorConfig access$getProcessMonitorConfig$p(DocsMonitorPlugin r0) {
        return r0.processMonitorConfig;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DocsMonitorPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(BIZ_UTIL_BATTERY_SCENE, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r11) {
        super.onAttachToHost(r11);
        this.processMonitorConfig = (ProcessMonitorConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(ProcessMonitorConfig.KEY, ProcessMonitorConfig.class, new ProcessMonitorConfig());
        this.analyticService.h("ccm_battery_extra");
        com.bytedance.ee.bear.contract.d r1 = this.analyticService;
        StringBuilder r3 = new StringBuilder("ccm_battery_extra");
        Boolean r4 = null;
        if (r11 == null) goto L7;
        DocViewModel r5 = r11.a();
        if (r5 == null) goto L7;
        String r6 = r5.getToken();
    L8:
        r3.append(r6);
        r1.j("ccm_battery_extra", r3.toString(), this.extra);
        this.analyticService.j("ccm_battery_extra", "ccm_battery_jsb_extra", this.jsbExtraMap);
        if (r11 == null) goto L13;
        k r2 = r11.getWeb();
        if (r2 == null) goto L13;
        WebView r7 = r2.getWebView();
    L14:
        boolean r8 = true;
        if ((r7 instanceof LarkWebView) == false) goto L57;
        String r9 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getDeviceId();
        StringBuilder r10 = new StringBuilder();
        r10.append(r9);
        r10.append('_');
        LarkWebView r12 = (LarkWebView) r7;
        r10.append(r12.hashCode());
        r10.append('_');
        if (r11 == null) goto L23;
        DocViewModel r13 = r11.a();
        if (r13 == null) goto L23;
        String r14 = r13.getUrl();
        if (r14 == null) goto L23;
        Integer r16 = Integer.valueOf(r14.hashCode());
    L24:
        r10.append(r16);
        r10.append('_');
        r10.append(eu5.b.a.hashCode());
        r10.append('_');
        r10.append(hashCode());
        r10.append('_');
        r10.append(SystemClock.uptimeMillis());
        String r17 = r10.toString();
        this.extra.put("relation_id", r17);     // Catch: Throwable -> L27
        JSONObject r18 = this.extra;     // Catch: Throwable -> L27
        LarkWebView r19 = (LarkWebView) r7;     // Catch: Throwable -> L27
        r19.getClass();     // Catch: Throwable -> L27
        Lazy r20 = TTWebViewUtil.a;     // Catch: Throwable -> L27
        TTWebViewUtil.a.d(r19);     // Catch: Throwable -> L27
        r18.put("isTTWebView", false);     // Catch: Throwable -> L27
    L29:
        this.jsbExtraMap.put("jsb_webview_id", r17);
        this.jsbExtraMap.put("jsb_state", "init");
        ConcurrentHashMap<String, String> r21 = this.jsbExtraMap;
        if (r11 == null) goto L34;
        DocViewModel r22 = r11.a();
        if (r22 == null) goto L34;
        DocsOpenSource r23 = r22.getOpenSource();
    L36:
        if (r23 != DocsOpenSource.vc) goto L38;
        boolean r24 = true;
    L39:
        r21.put("is_vc", String.valueOf(r24));
        this.jsbExtraMap.put("net_level", String.valueOf(TTNetInit.getEffectiveConnectionType()));
        this.jsbExtraMap.put("app_visible", String.valueOf(this.visibleService.a()));
        ConcurrentHashMap<String, String> r26 = this.jsbExtraMap;
        String r27 = ow4.a.a;
        if (r27 != null) goto L42;
        r27 = "";
    L42:
        r26.put("scm_version", r27);
        r12.setInjectedLogParams(this.jsbExtraMap);
        tt5.a.h(TAG, "jsbExtraMap=" + this.jsbExtraMap);
        StringBuilder r28 = new StringBuilder("isTTWebView=false processMonitor enable=");
        Lazy r29 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(r12);
        ProcessMonitorConfig r30 = this.processMonitorConfig;
        if (r30 == null) goto L47;
        ProcessMonitorConfig.CpuConfig r31 = r30.getCpuConfig();
        if (r31 == null) goto L47;
        r4 = Boolean.valueOf(r31.isEnable());
    L47:
        r28.append(r4);
        tt5.a.h(TAG, r28.toString());
        ProcessMonitorConfig r0 = this.processMonitorConfig;
        if (r0 == null) goto L54;
        ProcessMonitorConfig.CpuConfig r32 = r0.getCpuConfig();
        if (r32 == null) goto L54;
        if (r32.isEnable() != true) goto L54;
        boolean r33 = true;
    L55:
        if (r33 == false) goto L57;
        TTWebViewUtil.a.d(r12);
    L54:
        r33 = false;
        goto L55
    L38:
        r24 = false;
    L34:
        r23 = null;
    L27:
        th = move-exception;
        tt5.a.f(TAG, th, false);
    L23:
        r16 = null;
    L57:
        this.visibleService.c().observeForever(this);
        if (isInVc() == false) goto L69;
        ProcessMonitorConfig r34 = this.processMonitorConfig;
        if (r34 == null) goto L66;
        ProcessMonitorConfig.CpuConfig r36 = r34.getCpuConfig();
        if (r36 == null) goto L66;
        if (r36.isEnable() != true) goto L66;
    L67:
        if (r8 == false) goto L69;
        getLifecycleOwner().getLifecycle().addObserver(this);
    L66:
        r8 = false;
    L69:
        if (r11 == null) goto L72;
        r11.registerHostAbility(this);
    L72:
        if (this.processMonitor == null) goto L79;
        Intrinsics.checkNotNullParameter(this, "cb");
        CopyOnWriteArrayList<c05.a.InterfaceC0010a> r110 = c05.a.d;
        if (r110.contains(this) == true) goto L80;
        r110.add(this);
        return;
    L80:
        return;
    L79:
        return;
    L13:
        r7 = null;
    L7:
        r6 = null;
        goto L8
    }

    public void onChanged(Boolean r5) {
        if (this.initObserver == true) goto L22;
        if (r5 == null) goto L22;
        if (this.processMonitor == null) goto L24;
        boolean r6 = r5.booleanValue();
        ScheduledFuture<?> r0 = c05.a.b;
        tt5.a.h("ProcessMonitor_CpuCollectTimerService", "onAppFrontChange isAppFront=" + r6);
        if (c05.a.g == true) goto L12;
        tt5.a.h("ProcessMonitor_CpuCollectTimerService", "onAppFrontChange but discardInBackground false, ignore");
        return;
    L12:
        if (c05.a.e.isEmpty() == false) goto L15;
        c05.a.a();
        return;
    L15:
        if (c05.a.j == r6) goto L28;
        c05.a.j = r6;
        if (r6 == false) goto L20;
        c05.a.b(0, c05.a.c);
        return;
    L20:
        long r1 = c05.a.a;
        c05.a.b(r1, r1);
        return;
    L28:
        return;
    L24:
        return;
    L22:
        this.initObserver = false;
    }

    public void onDetachFromHost(DocumentPluginHost r3) {
        super.onDetachFromHost(r3);
        this.analyticService.c("ccm_battery_extra");
        c05.d r0 = this.processMonitor;
        if (r0 != null) goto L23;
        this.visibleService.c().removeObserver(this);
        if (isInVc() == false) goto L16;
        ProcessMonitorConfig r1 = this.processMonitorConfig;
        if (r1 == null) goto L13;
        ProcessMonitorConfig.CpuConfig r2 = r1.getCpuConfig();
        if (r2 == null) goto L13;
        boolean r4 = true;
        if (r2.isEnable() != true) goto L13;
    L14:
        if (r4 == false) goto L16;
        getLifecycleOwner().getLifecycle().removeObserver(this);
    L13:
        r4 = false;
    L16:
        if (r3 == null) goto L19;
        r3.unregisterHostAbility(this);
    L19:
        if (this.processMonitor == null) goto L21;
        Intrinsics.checkNotNullParameter(this, "cb");
        c05.a.d.remove(this);
    L21:
        this.monitorCallbacks.clear();
        return;
    L23:
        Intrinsics.checkNotNullParameter("sandboxed_process", "processName");
        r0.getClass();
        throw null;
    }

    @Override // a05.f
    public void registerPerfMonitor(py4.d.b r3) {
        tt5.a.h(TAG, "registerPerfMonitor cb=" + r3);
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.monitorCallbacks.contains(r3) == true) goto L9;
        this.monitorCallbacks.add(r3);
        return;
    }

    @Override // a05.f
    public void unregisterPerfMonitor(py4.d.b r3) {
        tt5.a.h(TAG, "unregisterPerfMonitor cb=" + r3);
        if (r3 == null) goto L6;
        this.monitorCallbacks.remove(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((Boolean) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setFling$p(DocsMonitorPlugin r0, boolean r1) {
        r0.fling = r1;
    }

    public static final /* synthetic */ void access$setUserConsumingTouch$p(DocsMonitorPlugin r0, boolean r1) {
        r0.isUserConsumingTouch = r1;
    }

    private final void putExtra(String r2, Object r3) {
        if (r3 == null) goto L5;
        this.extra.put(r2, r3);
        String r4 = this.jsbExtraMap.put(r2, r3.toString());
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r5, t r6) {
        super.onAttachToUIContainer(r5, r6);
        this.extra.put("is_vc", isInVc());
        JSONObject r7 = this.extra;
        String r0 = "";
        if (r5 == null) goto L8;
        DocViewModel r1 = r5.a();
        if (r1 == null) goto L8;
        String r2 = r1.getDocumentType();
        if (r2 == null) goto L8;
    L9:
        r7.put("doc_type", r2);
        JSONObject r8 = this.extra;
        k r3 = null;
        if (r5 == null) goto L14;
        DocViewModel r4 = r5.a();
        if (r4 == null) goto L14;
        String r9 = r4.getToken();
    L15:
        r8.put("encrypted_token", du5.b.g(r9));
        this.extra.put("start_net_level", TTNetInit.getEffectiveConnectionType());
        JSONObject r10 = this.extra;
        String r11 = ow4.a.a;
        if (r11 == null) goto L19;
        r0 = r11;
    L19:
        r10.put("scm_version", r0);
        putCommonExtra();
        this.analyticService.l("docs_view", this.extra);
        c05.d r12 = this.processMonitor;
        if (r12 == null) goto L22;
        r12.a("docs_view");
    L22:
        if (r5 == null) goto L25;
        r3 = r5.getWeb();
    L25:
        if ((r3 instanceof z4) == false) goto L32;
        ((z4) r3).d(this);
        if (r5 == null) goto L33;
        k r13 = r5.getWeb();
        if (r13 == null) goto L34;
        r13.addOnTouchListener(this);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L14:
        r9 = null;
    L8:
        r2 = "";
        goto L9
    }

    public void onDetachFromUIContainer(DocumentPluginHost r3, t r4) {
        super.onDetachFromUIContainer(r3, r4);
        c05.d r5 = this.processMonitor;
        if (r5 == null) goto L5;
        r5.b("docs_view", this.extra);
    L5:
        this.analyticService.p("docs_view", this.extra);
        if (r3 == null) goto L8;
        k r6 = r3.getWeb();
    L10:
        if ((r6 instanceof z4) == false) goto L17;
        ((z4) r6).F(this);
        if (r3 == null) goto L16;
        k r7 = r3.getWeb();
        if (r7 == null) goto L16;
        r7.removeOnTouchListener(this);
    L16:
        this.jsbExtraMap.put("jsb_webview_id", "");
        this.jsbExtraMap.put("jsb_state", "");
    L17:
        com.bytedance.ee.util.ui.m.e(this.flingEndRunnable);
        return;
    L8:
        r6 = null;
        goto L10
    }

    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        tt5.a.b(TAG, "event=" + r3);
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        int r4 = c.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        this.vcFloatingModel = true;
        this.extra.put("vc_floating", true);
        this.jsbExtraMap.put("vc_floating", String.valueOf(this.vcFloatingModel));
        c05.d r5 = this.processMonitor;
        if (r5 == null) goto L20;
        r5.a("vc_floating");
    L20:
        this.analyticService.k("vc_floating");
        return;
    L8:
        if (r4 == 2) goto L11;
        return;
    L11:
        if (this.vcFloatingModel == false) goto L16;
        c05.d r6 = this.processMonitor;
        if (r6 == null) goto L15;
        r6.b("vc_floating", this.extra);
    L15:
        this.analyticService.p("vc_floating", this.extra);
    L16:
        this.vcFloatingModel = false;
        this.extra.put("vc_floating", false);
        this.jsbExtraMap.put("vc_floating", String.valueOf(this.vcFloatingModel));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r3, MotionEvent r4) {
        boolean r5 = true;
        if (r4 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        this.isUserConsumingTouch = true;
    L18:
        return false;
    L10:
        if (r4 != null) goto L12;
    L14:
        r5 = false;
    L15:
        if (r5 == true) goto L18;
        if (r4 == null) goto L18;
        r4.getAction();
        goto L18
    L12:
        if (r4.getAction() != 1) goto L14;
    L5:
        if (r4.getAction() != 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // c05.a.InterfaceC0010a
    public void onProcessCpuChange(String r2, boolean r3, CpuInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "process");
        if (isUIContainerDetached() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("sandboxed_process", r2) == false) goto L27;
        StringBuilder r5 = new StringBuilder("onProcessCpuChange SANDBOX_PROCESS_NAME cpuRate=");
        Double r6 = null;
        if (r4 == null) goto L10;
        Double r0 = r4.getCpuRate();
    L11:
        r5.append(r0);
        r5.append(" cpuSpeed=");
        if (r4 == null) goto L14;
        r6 = r4.getCpuSpeed();
    L14:
        r5.append(r6);
        tt5.a.h(TAG, r5.toString());
        Iterator<py4.d.b> r7 = this.monitorCallbacks.iterator();
    L16:
        if (r7.hasNext() == false) goto L32;
        py4.d.b r8 = r7.next();
        if (r4 == null) goto L22;
        Double r1 = r4.getCpuRate();
        if (r1 == null) goto L22;
        r1.doubleValue();
    L22:
        if (r4 == null) goto L26;
        Double r9 = r4.getCpuSpeed();
        if (r9 == null) goto L26;
        r9.doubleValue();
    L26:
        r8.a();
        goto L16
    L32:
        return;
    L10:
        r0 = null;
        goto L11
    }

    @Override // zv4.f
    public void onScrollChange(View r1, int r2, int r3, int r4, int r5) {
        if (this.fling == true) goto L7;
        this.extra.put("user_fling", this.isUserConsumingTouch);
        this.analyticService.k("docs_fling");
        c05.d r6 = this.processMonitor;
        if (r6 == null) goto L7;
        r6.a("docs_fling");
    L7:
        this.fling = true;
        com.bytedance.ee.util.ui.m.e(this.flingEndRunnable);
        com.bytedance.ee.util.ui.m.b(this.flingEndRunnable, 1000);
    }
}
