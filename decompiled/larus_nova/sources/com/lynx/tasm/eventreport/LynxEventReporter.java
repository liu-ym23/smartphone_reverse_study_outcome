package com.lynx.tasm.eventreport;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import i8a.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import n7a.c;
import n7a.d;
import n7a.e;
import n7a.f;
import n7a.g;
import n7a.h;

/* JADX INFO: loaded from: classes32.dex */
public class LynxEventReporter {
    public static final int INSTANCE_ID_UNKNOWN = -1;
    public static final String LYNX_SDK_ERROR_EVENT = "lynxsdk_error_event";
    public static final String PROP_NAME_ENABLE_SSR = "enable_ssr";
    public static final String PROP_NAME_LYNX_SDK_VERSION = "lynx_sdk_version";
    public static final String PROP_NAME_RELATIVE_PATH = "relative_path";
    public static final String PROP_NAME_THREAD_MODE = "thread_mode";
    public static final String PROP_NAME_URL = "url";
    private static final String REMOVE_GENERIC_INFO = "LynxEventReporter::removeGenericInfo";
    private static final String TAG = "LynxEventReporter";
    private static final String UPDATE_GENERIC_INFO = "LynxEventReporter::updateGenericInfo";
    private HashMap<Integer, HashMap<String, Object>> mAllExtraParams;
    private HashMap<Integer, HashMap<String, Object>> mAllGenericInfos;
    private ILynxEventReportObserver mEventReporterService;
    private volatile boolean mIsNativeLibraryLoaded;
    private final CopyOnWriteArrayList<ILynxEventReportObserver> mObserverList;

    public interface PropsBuilder {
        Map<String, Object> build();
    }

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LynxEventReporter f383325a = null;

        static {
            f383325a = new LynxEventReporter(null);
        }
    }

    public static /* synthetic */ void a(int r100, Map r101) {
        lambda$updateGenericInfo$3(r100, r101);
    }

    public static /* synthetic */ void b(int r100) {
        lambda$removeGenericInfo$4(r100);
    }

    public static /* synthetic */ void c(PropsBuilder r100, int r101, String r102) {
        lambda$onEvent$1(r100, r101, r102);
    }

    public static /* synthetic */ void d(int r100, String r101, Object r102) {
        lambda$updateGenericInfo$2(r100, r101, r102);
    }

    public static /* synthetic */ void e(int r100) {
        lambda$clearCache$7(r100);
    }

    public static /* synthetic */ void f(int r100, int r101) {
        lambda$moveExtraParams$6(r100, r101);
    }

    public static /* synthetic */ void g(int r100, Map r101) {
        lambda$putExtraParams$5(r100, r101);
    }

    public static /* synthetic */ void h(int r100, String r101, Map r102) {
        lambda$onEvent$0(r100, r101, r102);
    }

    private native void nativeRunOnReportThread(Object r100, long r101);

    private void setupEventReporterServiceIfNeeded() {
        if (this.mEventReporterService == null) goto L5;
        return;
    L5:
        ILynxEventReportObserver r100 = (ILynxEventReportObserver) n.c().a(i8a.a.class);
        this.mEventReporterService = r100;
        if (r100 != null) goto L8;
        LLog.e(TAG, "eventReporter service not found or event name is null.");
        return;
    L8:
        addObserverInternal(r100);
    }

    private LynxEventReporter() {
        this.mObserverList = new CopyOnWriteArrayList();
        this.mIsNativeLibraryLoaded = false;
        this.mAllGenericInfos = new HashMap();
        this.mAllExtraParams = new HashMap();
    }

    public static LynxEventReporter getInstance() {
        return b.f383325a;
    }

    public /* synthetic */ LynxEventReporter(a r100) {
        this();
    }

    public static void addObserver(ILynxEventReportObserver r100) {
        getInstance().addObserverInternal(r100);
    }

    private void addObserverInternal(ILynxEventReportObserver r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mObserverList.contains(r100) == true) goto L8;
        this.mObserverList.add(r100);
        return;
    }

    public static void callRunnable(Object r100) {
        if ((r100 instanceof Runnable) == false) goto L5;
        ((Runnable) r100).run();
        return;
    L5:
        StringBuilder r101 = new StringBuilder("runnable[");
        if (r100 != null) goto L8;
        Object r102 = "null";
    L9:
        r101.append(r102);
        r101.append("] must be an instance of Runnable.");
        LLog.e(TAG, r101.toString());
        return;
    L8:
        r102 = r100.getClass();
        goto L9
    }

    public static void clearCache(final int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        delayRunOnReportThread(new f(r100), 5000);
    }

    private static HashMap<String, Object> getGenericInfoInternal(Integer r100) {
        HashMap<String, Object> r101 = getInstance().mAllGenericInfos.get(r100);
        if (r101 != null) goto L6;
        HashMap<String, Object> r102 = new HashMap();
        r102.put(PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        getInstance().mAllGenericInfos.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public static HashMap<String, Object> getGenericInfoWithExtraParams(Integer r100) {
        HashMap<String, Object> r101 = new HashMap();
        if (r100.intValue() >= 0) goto L5;
        return r101;
    L5:
        HashMap<String, Object> r102 = getInstance().mAllExtraParams.get(r100);
        if (r102 == null) goto L8;
        r101.putAll(r102);
    L8:
        HashMap<String, Object> r103 = getGenericInfoInternal(r100);
        if (r103 == null) goto L11;
        r101.putAll(r103);
    L11:
        return r101;
    }

    private static /* synthetic */ void lambda$clearCache$7(int r100) {
        LynxEventReporter r101 = getInstance();
        r101.mAllGenericInfos.remove(Integer.valueOf(r100));
        r101.mAllExtraParams.remove(Integer.valueOf(r100));
    }

    private static /* synthetic */ void lambda$removeGenericInfo$4(int r100) {
        TraceEvent.beginSection(REMOVE_GENERIC_INFO);
        getInstance().mAllGenericInfos.remove(Integer.valueOf(r100));
        TraceEvent.endSection(REMOVE_GENERIC_INFO);
    }

    public static void removeGenericInfo(final int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (TraceEvent.isTracingStarted() == false) goto L7;
        HashMap r101 = new HashMap();
        r101.put("instance_id", String.valueOf(r100));
        TraceEvent.beginSection(REMOVE_GENERIC_INFO, r101);
    L7:
        runOnReportThread(new d(r100));
        TraceEvent.endSection(REMOVE_GENERIC_INFO);
    }

    public static void removeObserver(ILynxEventReportObserver r100) {
        getInstance().removeObserverInternal(r100);
    }

    private void removeObserverInternal(ILynxEventReportObserver r100) {
        if (r100 == null) goto L5;
        this.mObserverList.remove(r100);
        return;
    }

    public static void runOnReportThread(Runnable r100) {
        if (getInstance().mIsNativeLibraryLoaded == true) goto L6;
        LynxEventReporter r101 = getInstance();
        r101.mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (getInstance().mIsNativeLibraryLoaded == false) goto L9;
        getInstance().nativeRunOnReportThread(r100, 0);
        return;
    }

    public static void delayRunOnReportThread(Runnable r100, long r101) {
        if (getInstance().mIsNativeLibraryLoaded == true) goto L6;
        LynxEventReporter r102 = getInstance();
        r102.mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (getInstance().mIsNativeLibraryLoaded == false) goto L9;
        getInstance().nativeRunOnReportThread(r100, r101);
        return;
    }

    private static /* synthetic */ void lambda$moveExtraParams$6(int r100, int r101) {
        LynxEventReporter r102 = getInstance();
        HashMap<String, Object> r103 = r102.mAllExtraParams.get(Integer.valueOf(r100));
        if (r103 == null) goto L10;
        HashMap<String, Object> r104 = r102.mAllExtraParams.get(Integer.valueOf(r101));
        if (r104 == null) goto L7;
        r104.putAll(r103);
    L8:
        r102.mAllExtraParams.remove(Integer.valueOf(r100));
        return;
    L7:
        r102.mAllExtraParams.put(Integer.valueOf(r101), r103);
        goto L8
    }

    private static /* synthetic */ void lambda$putExtraParams$5(int r100, Map r101) {
        LynxEventReporter r102 = getInstance();
        HashMap<String, Object> r103 = r102.mAllExtraParams.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        r102.mAllExtraParams.put(Integer.valueOf(r100), new HashMap(r101));
        return;
    L5:
        r103.putAll(r101);
    }

    private static /* synthetic */ void lambda$updateGenericInfo$3(int r100, Map r101) {
        TraceEvent.beginSection(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(r100)).putAll(r101);
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    public static void moveExtraParams(final int r100, final int r101) {
        if (r100 < 0) goto L7;
        if (r101 < 0) goto L8;
        runOnReportThread(new g(r100, r101));
        return;
    L8:
        return;
    }

    public static void putExtraParams(final Map<String, Object> r100, final int r101) {
        if (r100 == null) goto L7;
        if (r101 < 0) goto L8;
        runOnReportThread(new n7a.b(r101, r100));
        return;
    L8:
        return;
    }

    public static void updateGenericInfo(final Map<String, Object> r100, final int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L18;
        if (r101 >= 0) goto L8;
        return;
    L8:
        if (TraceEvent.isTracingStarted() == false) goto L14;
        HashMap r102 = new HashMap();
        r102.put("instance_id", String.valueOf(r101));
        Iterator<Map.Entry<String, Object>> r103 = r100.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, Object> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue().toString());
        goto L11
    L13:
        TraceEvent.beginSection(UPDATE_GENERIC_INFO, r102);
    L14:
        runOnReportThread(new n7a.a(r101, r100));
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
        return;
    }

    public static void updateGenericInfo(int r100, ReadableMap r101) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r102 = new HashMap();
        r102.put("instance_id", String.valueOf(r100));
        TraceEvent.beginSection(UPDATE_GENERIC_INFO, r102);
    L5:
        getGenericInfoInternal(Integer.valueOf(r100)).putAll(r101.asHashMap());
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    private void handleEvent(int r100, String r101, Map<String, Object> r102) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r103 = new HashMap();
        r103.put("instance_id", String.valueOf(r100));
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, r101);
        TraceEvent.beginSection("LynxEventReporter::handleEvent", r103);
    L5:
        if (r101 != null) goto L8;
        LLog.e(TAG, "event name is null.");
        TraceEvent.endSection("LynxEventReporter::handleEvent");
        return;
    L8:
        HashMap r104 = new HashMap();
        HashMap<String, Object> r105 = this.mAllGenericInfos.get(Integer.valueOf(r100));
        if (r105 == null) goto L11;
        r104.putAll(r105);
    L11:
        if (r102 == null) goto L13;
        r104.putAll(r102);
    L13:
        Map<String, ? extends Object> r106 = Collections.unmodifiableMap(r104);
        HashMap<String, Object> r107 = this.mAllExtraParams.get(Integer.valueOf(r100));
        if (r107 == null) goto L16;
        Map<String, ? extends Object> r108 = Collections.unmodifiableMap(r107);
    L17:
        setupEventReporterServiceIfNeeded();
        Iterator<ILynxEventReportObserver> r109 = this.mObserverList.iterator();
    L19:
        if (r109.hasNext() == false) goto L21;
        r109.next().onReportEvent(r101, r100, r106, r108);
        goto L19
    L21:
        TraceEvent.endSection("LynxEventReporter::handleEvent");
        return;
    L16:
        r108 = null;
        goto L17
    }

    private static /* synthetic */ void lambda$onEvent$0(int r100, String r101, Map r102) {
        getInstance().handleEvent(r100, r101, r102);
    }

    private static /* synthetic */ void lambda$onEvent$1(PropsBuilder r100, int r101, String r102) {
        if (r100 == null) goto L4;
        Map<String, Object> r103 = r100.build();
    L5:
        if (r101 >= 0) goto L8;
        if (r103 != null) goto L8;
        return;
    L8:
        getInstance().handleEvent(r101, r102, r103);
        return;
    L4:
        r103 = null;
        goto L5
    }

    private static /* synthetic */ void lambda$updateGenericInfo$2(int r100, String r101, Object r102) {
        TraceEvent.beginSection(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(r100)).put(r101, r102);
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    public static void onEvent(final String r100, final int r101, final PropsBuilder r102) {
        if (r100 == null) goto L11;
        if (r101 >= 0) goto L7;
        if (r102 != null) goto L7;
        return;
    L7:
        if (TraceEvent.isTracingStarted() == false) goto L9;
        HashMap r103 = new HashMap();
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r103.put("instance_id", String.valueOf(r101));
        TraceEvent.beginSection("LynxEventReporter::OnEvent", r103);
    L9:
        runOnReportThread(new e(r102, r101, r100));
        TraceEvent.endSection("LynxEventReporter::OnEvent");
        return;
    }

    public static void updateGenericInfo(final String r100, final Object r101, final int r102) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        if (r102 >= 0) goto L7;
        return;
    L7:
        if (TraceEvent.isTracingStarted() == false) goto L9;
        HashMap r103 = new HashMap();
        r103.put("key", r100);
        r103.put("instance_id", String.valueOf(r102));
        r103.put("value", r101.toString());
        TraceEvent.beginSection(UPDATE_GENERIC_INFO, r103);
    L9:
        runOnReportThread(new c(r102, r100, r101));
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
        return;
    L12:
        return;
    }

    public static void onEvent(final String r100, final Map<String, Object> r101, final int r102) {
        if (r100 == null) goto L11;
        if (r102 >= 0) goto L7;
        if (r101 != null) goto L7;
        return;
    L7:
        if (TraceEvent.isTracingStarted() == false) goto L9;
        HashMap r103 = new HashMap();
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r103.put("instance_id", String.valueOf(r102));
        TraceEvent.beginSection("LynxEventReporter::OnEvent", r103);
    L9:
        runOnReportThread(new h(r102, r100, r101));
        TraceEvent.endSection("LynxEventReporter::OnEvent");
        return;
    }

    public static void onEvent(int r100, String r101, ReadableMap r102) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r103 = new HashMap();
        r103.put("instance_id", String.valueOf(r100));
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, r101);
        TraceEvent.beginSection("LynxEventReporter::OnEvent", r103);
    L5:
        getInstance().handleEvent(r100, r101, r102.asHashMap());
        TraceEvent.endSection("LynxEventReporter::OnEvent");
    }
}
