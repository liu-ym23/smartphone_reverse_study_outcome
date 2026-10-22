package com.lynx.tasm;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.BuildConfig;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class NativeFacade implements EventEmitter.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f381742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1 f381743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f381744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f381745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<LynxEngineProxy> f381746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<LynxContext> f381747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f381748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f381749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LynxModuleFactory f381750i;

    public class a extends LynxResourceCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<NativeFacade> f381751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f381752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NativeFacade f381753c;

        /* JADX INFO: renamed from: com.lynx.tasm.NativeFacade$a$a, reason: collision with other inner class name */
        public class RunnableC4561a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LynxResourceResponse f381754a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f381755b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f381755b.a(this.f381754a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC4561a(a r100, LynxResourceResponse r101) {
                this.f381755b = r100;
                this.f381754a = r101;
            }
        }

        public final void a(LynxResourceResponse<String> r100) {
            NativeFacade r101 = this.f381751a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r100.getData()) == false) goto L10;
            LynxContext r102 = r101.f381747f.get();
            if (r102 == null) goto L10;
            r102.reportResourceError(30400, this.f381752b, "I18nResource", "empty i18n resource return");
            r101.f381742a.c(this.f381752b, "", -1);
            return;
        L10:
            r101.f381742a.c(this.f381752b, r100.getData(), r100.getCode());
        }

        @Override // com.lynx.tasm.provider.LynxResourceCallback
        public final void onResponse(LynxResourceResponse<String> r100) {
            super.onResponse(r100);
            if (UIThreadUtils.isOnUiThread() == true) goto L5;
            UIThreadUtils.runOnUiThread(new RunnableC4561a(this, r100));
            return;
        L5:
            a(r100);
        }

        public a(NativeFacade r100, String r101) {
            this.f381753c = r100;
            this.f381752b = r101;
            this.f381751a = new WeakReference(this.f381753c);
        }
    }

    public class b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NativeFacade f381757b;

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r100) {
            if (this.f381756a >= 0) goto L5;
            return;
        L5:
            JavaOnlyMap r101 = new JavaOnlyMap();
            r101.putInt("code", ((Integer) r100[0]).intValue());
            if (r100.length <= 1) goto L8;
            r101.put("data", r100[1]);
        L8:
            c r102 = this.f381757b.f381742a;
            if (r102 == null) goto L12;
            r102.b(this.f381756a, r101);
            return;
        }

        public b(NativeFacade r100, int r101) {
            this.f381757b = r100;
            this.f381756a = r101;
        }
    }

    public interface c {
        void a(TemplateBundle r100);

        void b(int r100, JavaOnlyMap r101);

        void c(String r100, String r101, int r102);

        String d(String r100, String r101);

        void e(k8a.a r100);

        void f(HashMap<String, Object> r100);

        void g();

        void h(int r100);

        void i(Map<String, Object> r100);

        void j(boolean r100);

        void k();

        void l(long r100, boolean r101, long r102);

        void m(long r100, boolean r101, long r102);

        void n(JavaOnlyMap r100);

        void o();

        void onDataUpdated();

        void onErrorOccurred(LynxError r100);

        void onReceiveMessageEvent(ReadableMap r100);

        void onRuntimeReady();

        void onUpdateDataWithoutChange();

        void p(String r100, String r101, int r102);

        void q();

        void r();

        void s(long r100, boolean r101, long r102);

        void t(t1 r100);
    }

    private void dispatchOnLoaded() {
        LLog.i("NativeFacade", "native->java dispatchOnLoaded templateSize:" + this.f381745d + " " + b());
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.h(this.f381745d);
        return;
    }

    private void onDataUpdated() {
        LLog.i("NativeFacade", "native->java onDataUpdated " + b());
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.onDataUpdated();
        return;
    }

    private void onRuntimeReady() {
        LLog.i("NativeFacade", "native->java onRuntimeReady " + b());
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.onRuntimeReady();
        return;
    }

    private void onSSRHydrateFinished() {
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    private void onTASMFinishedByNative() {
        LLog.i("NativeFacade", "native->java onTASMFinishedByNative " + b());
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.r();
        return;
    }

    private void onUpdateDataWithoutChange() {
        LLog.i("NativeFacade", "native->java onUpdateDataWithoutChange " + b());
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.onUpdateDataWithoutChange();
        return;
    }

    public final String b() {
        WeakReference<LynxContext> r100 = this.f381747f;
        if (r100 == null) goto L5;
        LynxContext r101 = r100.get();
    L6:
        if (r101 == null) goto L8;
        int r102 = r101.getInstanceId();
    L10:
        if (TextUtils.isEmpty(this.f381744c) == true) goto L12;
        String r103 = this.f381744c;
    L16:
        return "instanceId:" + r102 + " url:" + r103;
    L12:
        if (r101 == null) goto L14;
        r103 = r101.getTemplateUrl();
        goto L16
    L14:
        r103 = "";
        goto L16
    L8:
        r102 = -1;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public void onRunPipelineFinished() {
        c r100 = this.f381742a;
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    public NativeFacade(boolean r100) {
        this.f381748g = true;
        this.f381749h = false;
        this.f381750i = null;
        this.f381748g = r100;
    }

    private void flushJSBTiming(ReadableMap r100) {
        if (BuildConfig.enable_lite.booleanValue() == false) goto L5;
        return;
    L5:
        c r101 = this.f381742a;
        if (r101 == null) goto L14;
        if (r100 == null) goto L15;
        r101.n(JavaOnlyMap.from(r100.getMap("info").asHashMap()));
        if (r100.getMap("info").getInt("jsb_status_code", 0) == 1) goto L12;
        return;
    L12:
        this.f381742a.i(r100.asHashMap());
        return;
    L15:
        return;
    }

    private void onDynamicComponentPerfReady(ReadableMap r100) {
        c r101 = this.f381742a;
        if (r101 == null) goto L6;
        r101.f(r100.asHashMap());
        return;
    }

    private void onPageChanged(boolean r100) {
        LLog.i("NativeFacade", "native->java onPageChanged isFirstScreen:" + r100 + " " + b());
        c r101 = this.f381742a;
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    private void onReceiveMessageEvent(ReadableMap r100) {
        c r101 = this.f381742a;
        if (r101 == null) goto L6;
        r101.onReceiveMessageEvent(r100);
        return;
    }

    private void onTemplateBundleReady(TemplateBundle r100) {
        c r101 = this.f381742a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    private void onTimingSetup(ReadableMap r100) {
        q1 r101 = this.f381743b;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.onTimingSetup(r100.asHashMap());
    }

    private void startRecording(ReadableMap r100) {
        WeakReference<LynxContext> r101 = this.f381747f;
        if (r101 == null) goto L5;
        LynxContext r102 = r101.get();
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        final int r103 = r102.getInstanceId();
        if (r103 != (-1)) goto L11;
        return;
    L11:
        DisplayMetrics r104 = r102.getScreenMetrics();
        if (r104 == null) goto L14;
        float r105 = r104.density;
    L15:
        final LynxFrameRecorder r106 = LynxFrameRecorder.f383583k;
        if (r103 >= 0) goto L19;
        r106.getClass();
        return;
    L19:
        if (r105 <= 0.0f) goto L21;
        r106.f383590g.put(Integer.valueOf(r103), Float.valueOf(r105));
    L22:
        final int r107 = r106.f383593j.getAndIncrement();
        r106.f383587d.put(Integer.valueOf(r103), Integer.valueOf(r107));
        r106.f383585b.put(Integer.valueOf(r103), Integer.valueOf(r107));
        r106.f383586c.remove(Integer.valueOf(r103));
        r106.f383588e.put(Integer.valueOf(r103), new LynxFrameRecorder.c());
        r106.f383584a.execute(new com.lynx.tasm.recording.c(r106, r103, r107));
        return;
    L21:
        r106.f383590g.remove(Integer.valueOf(r103));
        goto L22
    L14:
        r105 = 0.0f;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    private void stopRecording(ReadableMap r100) {
        LynxContext r101 = this.f381747f.get();
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 != (-1)) goto L8;
        return;
    L8:
        LynxFrameRecorder.f383583k.x(r102);
        return;
    L5:
        r102 = r101.getInstanceId();
        goto L6
    }

    @Override // com.lynx.tasm.EventEmitter.d
    public final boolean a(LynxEvent r110) {
        int r100 = 0;
        if (this.f381743b == null) goto L58;
        if (r110 == null) goto L67;
        LynxContext r101 = this.f381747f.get();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.getLynxUIOwner() == null) goto L66;
        LynxUIOwner r102 = r101.getLynxUIOwner();
        LynxEvent.LynxEventType r103 = r110.getType();
        LynxEvent.LynxEventType r104 = LynxEvent.LynxEventType.kTouch;
        if (r103 == r104) goto L14;
    L39:
        EventTarget r105 = (EventTarget) r110.getTarget();
        if (this.f381749h == false) goto L43;
        if (r105 != null) goto L43;
        r105 = r102.findLynxUIBySign(r110.getTag());
    L43:
        if (r105 != null) goto L46;
        return false;
    L46:
        r101.getLynxView();
        LynxEventDetail r106 = new LynxEventDetail(r110, r105);
        if (r110.getType() != r104) goto L52;
        if ((r110 instanceof LynxTouchEvent) == false) goto L52;
        ((LynxTouchEvent) r110).getMotionEvent();
    L52:
        if (r105.dispatchEvent(r106) == false) goto L54;
        return true;
    L54:
        this.f381743b.onLynxEvent(r106);
        return false;
    L14:
        if ((r110 instanceof LynxTouchEvent) == false) goto L39;
        LynxTouchEvent r107 = (LynxTouchEvent) r110;
        if (r107.getIsMultiTouch() == false) goto L39;
        JavaOnlyMap r108 = r107.getUITouchMap();
        Iterator<Map.Entry<String, Object>> r109 = r108.entrySet().iterator();
    L19:
        if (r109.hasNext() == false) goto L35;
        Map.Entry<String, Object> r111 = r109.next();
        int r112 = CastIntegerProtector.parseInt(r111.getKey());
        EventTarget r113 = (EventTarget) r107.getActiveTargetMap().get(Integer.valueOf(r112));
        if (r113 != null) goto L23;
        r113 = r102.findLynxUIBySign(r112);
    L23:
        if (r113 == null) goto L19;
        HashMap r114 = new HashMap();
        Iterator<Object> r115 = ((JavaOnlyArray) r111.getValue()).iterator();
    L27:
        if (r115.hasNext() == false) goto L29;
        JavaOnlyArray r116 = (JavaOnlyArray) r115.next();
        r114.put((Integer) r116.get(r100), new LynxTouchEvent.a(((Float) r116.get(5)).floatValue(), ((Float) r116.get(6)).floatValue()));
        r100 = 0;
        goto L27
    L29:
        LynxTouchEvent r117 = new LynxTouchEvent(r113.getSign(), r110.getName(), r114);
        r101.getLynxView();
        LynxEventDetail r118 = new LynxEventDetail(r117, r113);
        r107.getMotionEvent();
        if (r113.dispatchEvent(r118) == false) goto L32;
        r109.remove();
    L33:
        r100 = 0;
        goto L19
    L32:
        this.f381743b.onLynxEvent(r118);
        goto L33
    L35:
        if (r108.size() != 0) goto L37;
        return true;
    L37:
        return false;
    L66:
        return false;
    L67:
        return false;
    L58:
        return false;
    }

    public void onLynxEvent(ReadableMap r100) {
        c r101 = this.f381742a;
        if (r101 == null) goto L6;
        r101.o();
        return;
    }

    public void onPageConfigDecoded(ReadableMap r100) {
        if (this.f381742a == null) goto L6;
        t1 r101 = new t1(r100);
        this.f381742a.t(r101);
        this.f381749h = r101.U;
        return;
    }

    public void reportError(LynxError r100) {
        StringBuilder r101 = new StringBuilder("native->java reportError instanceId:");
        LynxContext r102 = this.f381747f.get();
        if (r102 != null) goto L5;
        int r103 = -1;
    L6:
        r101.append(r103);
        r101.append(" url:");
        r101.append(this.f381744c);
        r101.append(" error:");
        if (r100 == null) goto L9;
        Object r104 = Integer.valueOf(r100.getErrorCode());
    L10:
        r101.append(r104);
        LLog.i("NativeFacade", r101.toString());
        c r105 = this.f381742a;
        if (r105 == null) goto L14;
        r105.onErrorOccurred(r100);
        return;
    L14:
        return;
    L9:
        r104 = "null";
        goto L10
    L5:
        r103 = r102.getInstanceId();
        goto L6
    }

    private void onConfigUpdatedByJS(String r100, Object r101) {
        if (r100 == null) goto L18;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof HashMap) == false) goto L22;
        HashMap r102 = (HashMap) r101;
        if ("theme".equals(r100) == false) goto L20;
        k8a.a r103 = new k8a.a();
        Iterator r104 = r102.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.update((String) r105.getKey(), (String) r105.getValue());
        goto L11
    L13:
        c r106 = this.f381742a;
        if (r106 == null) goto L21;
        r106.e(r103);
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    }

    public void getI18nResourceByNative(String r100, String r101) {
        LynxContext r102 = this.f381747f.get();
        if (r102 == null) goto L13;
        d8a.f r103 = r102.getProviderRegistry();
        r103.getClass();
        if (TextUtils.isEmpty("I18N_TEXT") == false) goto L7;
        d8a.k r104 = null;
    L8:
        if (r104 != null) goto L11;
        r102.reportResourceError(30400, r100, "I18nResource", "no i18n provider found");
        return;
    L11:
        Bundle r105 = new Bundle();
        r105.putString("fallbackUrl", r101);
        r104.request(new LynxResourceRequest(r100.toLowerCase(), r105), new a(this, r100));
        return;
    L7:
        r104 = (d8a.k) ((HashMap) r103.f467438a).get("I18N_TEXT");
        goto L8
    }

    public String translateResourceForTheme(String r100, String r101) {
        c r102 = this.f381742a;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.d(r100, r101);
    }

    /* JADX INFO: Removed unreachable split cross block B:44:0x00cc */
    public ByteBuffer triggerLepusBridge(String r110, Object r111) {
        j7a.a r100 = j7a.a.f497652a;
        LynxModuleFactory r101 = this.f381750i;
        Object r102 = null;
        if ((r111 instanceof ReadableMap) == true) goto L6;
    L42:
        r100.getClass();
        return j7a.a.b(r102);
    L6:
        if (r101 != null) goto L8;
        LLog.e("LynxLepusModule", "mModuleFactory does not exist!");
        goto L42
    L8:
        ReadableMap r112 = ((ReadableMap) r111).getMap("methodDetail", new JavaOnlyMap());
        String r103 = r112.getString(EventConstant.Key.MODULE, null);
        String r104 = r112.getString(com.alipay.sdk.m.p.e.f25671s, null);
        if (r103 == null) goto L42;
        LynxModuleWrapper r105 = r101.b(r103);
        if (r105 != null) goto L14;
        r105 = LynxEnv.inst().getModuleFactory().b(r103);
    L14:
        if (r105 == null) goto L42;
        if (r110.equals(NotificationCompat.CATEGORY_CALL) == false) goto L19;
    L25:
        boolean r106 = true;
    L26:
        Iterator<MethodDescriptor> r107 = r105.getMethodDescriptors().iterator();
    L28:
        if (r107.hasNext() == false) goto L42;
        MethodDescriptor r108 = r107.next();
        String r113 = r108.getName();
        if (r113 == null) goto L28;
        if (r113.isEmpty() == true) goto L28;
        if (r113.equals(r110) == false) goto L28;
        if (r106 == false) goto L38;
        r102 = r108.getMethod().invoke(r105.getModule(), new Object[]{r104, r112});     // Catch: Exception -> L40
        goto L42
    L38:
        r102 = r108.getMethod().invoke(r105.getModule(), new Object[]{r112});     // Catch: Exception -> L40
    L40:
        e = move-exception;
        LLog.e("LynxLepusModule", "Lepus Module invokeSync: " + e.toString());
        goto L28
    L19:
        if (r110.equals("callSync") == true) goto L25;
        if (r104 != null) goto L22;
    L24:
        r106 = false;
        goto L26
    L22:
        if (r104.length() == 0) goto L24;
        goto L24
    }

    public void triggerLepusBridgeAsync(String r100, Object r101) {
        WeakReference<LynxEngineProxy> r102 = this.f381746e;
        if (r102 == null) goto L5;
        LynxEngineProxy r103 = r102.get();
    L6:
        LynxModuleFactory r104 = this.f381750i;
        if ((r101 instanceof ReadableMap) == false) goto L44;
        if (r104 != null) goto L11;
        LLog.e("LynxLepusModule", "mModuleFactory does not exist!");
        return;
    L11:
        ReadableMap r105 = (ReadableMap) r101;
        ReadableMap r106 = r105.getMap("methodDetail", new JavaOnlyMap());
        String r107 = r106.getString(EventConstant.Key.MODULE, null);
        r106.getString(com.alipay.sdk.m.p.e.f25671s, null);
        if (r107 == null) goto L45;
        LynxModuleWrapper r108 = r104.b(r107);
        if (r108 != null) goto L17;
        r108 = LynxEnv.inst().getModuleFactory().b(r107);
    L17:
        if (r108 == null) goto L46;
        boolean r109 = false;
        if (r105.getBoolean("lepusUseUIThread", false) == false) goto L22;
    L24:
        if (r109 == false) goto L38;
        WeakReference r110 = new WeakReference(r108);
        WeakReference r111 = new WeakReference(r103);
        if (LynxThreadPool.f383251e == null) goto L28;
    L37:
        LynxThreadPool.f383251e.execute(new a6a.a(r110, r111, r105, r100));
        return;
    L28:
        monitor-enter(LynxThreadPool.class);
    L34:
        th = move-exception;
        throw th;
    L30:
        if (LynxThreadPool.f383251e != null) goto L32;
        LynxThreadPool.f383251e = LynxThreadPool.c("lepus-bridge-async-thread", 3, 1);     // Catch: Throwable -> L34
    L32:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L34
        goto L37
    L38:
        a6a.b.a(r108, r103, r105, r100);
        return;
    L22:
        if (r105.getBoolean("useAirThread", false) == false) goto L24;
        r109 = true;
        goto L24
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L5:
        r103 = null;
        goto L6
    }

    private void onModuleFunctionInvoked(String r100, String r101, int r102) {
        c r103 = this.f381742a;
        if (r103 == null) goto L11;
        r103.p(r100, r101, r102);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        LynxError r104 = new LynxError(99900, "Callback 'onModuleFunctionInvoked' called after method '" + r101 + "' in module '" + r100 + "' threw an exception: " + e.getMessage());
        r104.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(e));
        reportError(r104);
        return;
    }

    private void onTimingUpdate(ReadableMap r100, ReadableMap r101, String r102) {
        if (this.f381743b != null) goto L5;
        return;
    L5:
        Object r103 = r101.asHashMap().get(r102);
        if ((r103 instanceof HashMap) == true) goto L8;
        return;
    L8:
        HashMap r104 = new HashMap();
        Iterator r105 = ((HashMap) r103).entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L16;
        Map.Entry r106 = (Map.Entry) r105.next();
        Object r107 = r106.getKey();
        Object r108 = r106.getValue();
        if ((r107 instanceof String) == false) goto L10;
        if ((r108 instanceof Long) == false) goto L10;
        r104.put((String) r107, (Long) r108);
        goto L10
    L16:
        this.f381743b.onTimingUpdate(r100.asHashMap(), r104, r102);
    }

    private void setEmbeddedTiming(String r100, long r101, String r110) {
        c r102 = this.f381742a;
        if ((r102 instanceof LynxTemplateRender.t) == false) goto L10;
        PerformanceController r103 = LynxTemplateRender.access$1000(((LynxTemplateRender.t) r102).f381720a);
        if (r103.f383533e == false) goto L11;
        if (r100 == null) goto L12;
        r103.n("Timing::Mark", r100, r101, r110);
        r103.k();
        r103.f383529a.c(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onEventBubble(long r100, boolean r101, long r110) {
        c r102 = this.f381742a;
        if (r102 == null) goto L6;
        r102.m(r100, r101, r110);
        return;
    }

    public void onEventCapture(long r100, boolean r101, long r110) {
        c r102 = this.f381742a;
        if (r102 == null) goto L6;
        r102.l(r100, r101, r110);
        return;
    }

    public void onEventFire(long r100, boolean r101, long r110) {
        c r102 = this.f381742a;
        if (r102 == null) goto L6;
        r102.s(r100, r101, r110);
        return;
    }

    private void InvokeUIMethod(LynxGetUIResult r100, String r110, JavaOnlyMap r111, int r112) {
        WeakReference<LynxContext> r101 = this.f381747f;
        if (r101 != null) goto L5;
        return;
    L5:
        LynxContext r102 = r101.get();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getLynxUIOwner() == null) goto L15;
        b r103 = new b(this, r112);
        int r104 = r100.f381660a.getInt(0);
        int r105 = r102.getInstanceId();
        LynxFrameRecorder r106 = LynxFrameRecorder.f383583k;
        if (r106.k(r105) == false) goto L12;
        long r107 = SystemClock.uptimeMillis();
        r106.p(r105, 108, new LynxFrameRecorder.f(r104, r110, LynxFrameRecorder.v(r111)), r107);
    L12:
        r102.getLynxUIOwner().invokeUIMethodForSelectorQuery(r104, r110, r111, r103);
        return;
    }
}
