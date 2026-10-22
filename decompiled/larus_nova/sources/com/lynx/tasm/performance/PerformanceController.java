package com.lynx.tasm.performance;

import b8a.l;
import b8a.m;
import c8a.b;
import c8a.c;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.b2;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.performance.fsp.FSPTracer;
import com.lynx.tasm.utils.UIThreadUtils;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y7a.a;
import y7a.d;
import y7a.f;

/* JADX INFO: loaded from: classes32.dex */
public class PerformanceController implements c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f383526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile LynxBooleanOption f383527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile long f383528m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f383529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f383530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<a> f383531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<i8a.a> f383532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f383533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JavaOnlyMap f383534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JavaOnlyArray f383535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f383536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FSPTracer f383537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f383538j;

    private native void nativeAllocateMemory(long r100, String r101, long r102, String r103, String r104);

    private static native long nativeCurrentSystemTimeMicroseconds();

    private native void nativeDeallocateMemory(long r100, String r101, long r102, String r103, String r104);

    private static native boolean nativeIsMemoryMonitorEnabled();

    private native void nativeSetFSPTimingInfo(long r100, long r101, Map<String, String> r102);

    private native void nativeSetPaintEndTimingAndHostPlatformTiming(long r100, long r101, JavaOnlyMap r102, JavaOnlyArray r103);

    private native void nativeSetTiming(long r100, String r101, long r102, String r103);

    private native void nativeUpdateMemoryUsage(long r100, String r101, long r102, int r103, Map<String, String> r104);

    static {
        f383527l = LynxBooleanOption.UNSET;
        f383528m = -1;
    }

    public static long j() {
        if (f383526k == true) goto L6;
        f383526k = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (f383526k == true) goto L8;
        LLog.e("PerformanceController", "Failed to call currentSystemTimeMicroseconds to obtain the timestamp.");
        return 0;
    L8:
        return nativeCurrentSystemTimeMicroseconds();
    }

    public static boolean m() {
        if (f383526k == true) goto L6;
        f383526k = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (f383526k == false) goto L19;
        LynxBooleanOption r100 = f383527l;
        LynxBooleanOption r101 = LynxBooleanOption.FALSE;
        if (r100 != r101) goto L11;
        return false;
    L11:
        if (r100 != LynxBooleanOption.UNSET) goto L17;
        boolean r102 = nativeIsMemoryMonitorEnabled();
        if (r102 == false) goto L15;
        r101 = LynxBooleanOption.TRUE;
    L15:
        f383527l = r101;
        return r102;
    L17:
        return true;
    L19:
        return false;
    }

    @Override // c8a.c
    public final void b() {
        if (this.f383533e == false) goto L12;
        k();
        b r100 = this.f383529a;
        if (r100.f22751e == true) goto L7;
    L9:
        long r101 = j();
        n("Timing::Mark", "paintEnd", r101, "");
        this.f383529a.c("paintEnd", r101);
        return;
    L7:
        if ((!r100.f22749c.isEmpty()) == true) goto L9;
        return;
    L12:
        if (UIThreadUtils.isOnUiThread() == true) goto L14;
        return;
    L14:
        if (this.f383535g.isEmpty() == true) goto L19;
        final long r102 = j();
        o("Timing::Mark", "paintEnd", r102);
        final JavaOnlyMap r103 = this.f383534f;
        this.f383534f = null;
        final JavaOnlyArray r104 = this.f383535g;
        this.f383535g = new JavaOnlyArray();
        q(new f(this, r102, r103, r104));
        return;
    }

    public final void k() {
        if (this.f383533e == true) goto L5;
        return;
    L5:
        if (this.f383529a != null) goto L9;
        b r100 = new b();
        this.f383529a = r100;
        r100.f22754h = this.f383531c;
        r100.f22753g = this.f383536h;
        return;
    }

    public final boolean l() {
        Boolean r100 = this.f383538j;
        if (r100 != null) goto L6;
        return LynxEnv.inst().enableFSP();
    L6:
        return r100.booleanValue();
    }

    public PerformanceController() {
        this.f383530b = 0;
        this.f383533e = false;
        this.f383535g = new JavaOnlyArray();
        this.f383536h = -1;
        this.f383537i = null;
    }

    @Override // c8a.c
    public final JavaOnlyArray c() {
        return this.f383535g;
    }

    @Override // c8a.c
    public final void a(String r100) {
        if (this.f383533e == false) goto L5;
        return;
    L5:
        if (UIThreadUtils.isOnUiThread() == true) goto L7;
        return;
    L7:
        if (this.f383535g.isEmpty() == true) goto L22;
        if (r100 != null) goto L11;
        return;
    L11:
        if (this.f383534f != null) goto L13;
        this.f383534f = new JavaOnlyMap();
    L18:
        long r101 = j();
        o("Timing::MarkHostPlatformTiming", r100, r101);
        this.f383534f.put(r100, Long.valueOf(r101));
        return;
    L13:
        if (r100.endsWith("Start") == false) goto L18;
        if (this.f383534f.containsKey(r100) == false) goto L18;
        return;
    }

    public void onPerformanceEvent(ReadableMap r100) {
        if (this.f383533e == false) goto L5;
        return;
    L5:
        a r101 = this.f383531c.get();
        l r102 = m.e(r100);
        if (r101 == null) goto L8;
        r101.onPerformanceEvent(r102);
    L8:
        WeakReference<i8a.a> r103 = this.f383532d;
        if (r103 == null) goto L11;
        i8a.a r104 = r103.get();
    L14:
        if (r104 == null) goto L19;
        int r105 = r100.getInt("instanceId", -1);
        if (r105 == (-1)) goto L20;
        HashMap<String, Object> r106 = LynxEventReporter.getGenericInfoWithExtraParams(Integer.valueOf(r105));
        r106.putAll(r100.asHashMap());
        r104.onPerformanceEvent(m.e(JavaOnlyMap.from(r106)));
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r104 = (i8a.a) n.c().a(i8a.a.class);
        if (r104 == null) goto L14;
        this.f383532d = new WeakReference(r104);
        goto L14
    }

    public final void q(Runnable r100) {
        if (this.f383533e == false) goto L5;
        return;
    L5:
        LynxEventReporter.runOnReportThread(r100);
    }

    public void setNativePtr(long r100) {
        if (this.f383533e == false) goto L5;
        return;
    L5:
        this.f383530b = r100;
    }

    public static void d(PerformanceController r100, Map r110) {
        if (r100.f383530b == 0) goto L12;
        Iterator r111 = r110.entrySet().iterator();
    L7:
        if (r111.hasNext() == false) goto L18;
        a8a.a r101 = (a8a.a) ((Map.Entry) r111.next()).getValue();
        if (r101 == null) goto L7;
        r100.nativeUpdateMemoryUsage(r100.f383530b, r101.f2204a, r101.f2205b, r101.f2206c, r101.f2207d);
        goto L7
    L18:
        return;
    }

    public static /* synthetic */ void f(PerformanceController r110, b2 r111) {
        if (r110.f383530b != 0) goto L6;
        return;
    L6:
        if (r111.f381841a <= 0) goto L9;
        r110.nativeSetTiming(r110.f383530b, "openTime", r111.f381841a * 1000, null);
    L9:
        if (r111.f381842b <= 0) goto L12;
        r110.nativeSetTiming(r110.f383530b, "containerInitStart", r111.f381842b * 1000, null);
    L12:
        if (r111.f381843c <= 0) goto L15;
        r110.nativeSetTiming(r110.f383530b, "containerInitEnd", r111.f381843c * 1000, null);
    L15:
        if (r111.f381844d <= 0) goto L18;
        r110.nativeSetTiming(r110.f383530b, "prepareTemplateStart", r111.f381844d * 1000, null);
    L18:
        if (r111.f381845e <= 0) goto L21;
        r110.nativeSetTiming(r110.f383530b, "prepareTemplateEnd", r111.f381845e * 1000, null);
        return;
    }

    public final void p(final String r110, final String r111) {
        final long r100 = j();
        n("Timing::Mark", r110, r100, r111);
        if (this.f383533e == false) goto L6;
        k();
        this.f383529a.c(r110, r100);
        return;
    L6:
        q(new d(this, r110, r100, r111));
    }

    public static /* synthetic */ void i(PerformanceController r110, long r111, Map r112) {
        if (r110.f383530b == 0) goto L7;
        r110.nativeSetFSPTimingInfo(r110.f383530b, r111, r112);
        return;
    }

    public final void o(String r100, String r110, long r111) {
        if (TraceEvent.isTracingStarted() == false) goto L8;
        Iterator<Object> r101 = this.f383535g.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        n(r100, r110, r111, (String) r101.next());
        goto L6
    L10:
        return;
    }

    public static /* synthetic */ void e(PerformanceController r100, String r101, long r102, String r110) {
        if (r100.f383530b == 0) goto L7;
        r100.nativeSetTiming(r100.f383530b, r101, r102 * 1000, r110);
        return;
    }

    public static /* synthetic */ void g(PerformanceController r100, String r101, long r102, String r110) {
        if (r100.f383530b == 0) goto L7;
        r100.nativeSetTiming(r100.f383530b, r101, r102, r110);
        return;
    }

    public static /* synthetic */ void h(PerformanceController r100, long r101, JavaOnlyMap r110, JavaOnlyArray r111) {
        if (r100.f383530b == 0) goto L7;
        r100.nativeSetPaintEndTimingAndHostPlatformTiming(r100.f383530b, r101, r110, r111);
        return;
    }

    public final void n(String r100, String r101, long r102, String r103) {
        if (TraceEvent.isTracingStarted() == false) goto L6;
        HashMap r104 = new HashMap();
        r104.put("timing_key", r101);
        r104.put("timestamp", String.valueOf(r102));
        r104.put("pipeline_id", r103);
        r104.put("instance_id", String.valueOf(this.f383536h));
        TraceEvent.instant(0, r100 + "." + r101, r104);
        return;
    }
}
