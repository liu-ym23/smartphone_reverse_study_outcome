package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import b8a.g;
import b8a.h;
import b8a.l;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.lynx.service.reporter.LynxEventReporterService;
import com.lynx.tasm.base.LLog;
import com.ss.android.common.lib.AppLogNewUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class LynxMemoryUsageProcessor implements com.bytedance.lynx.service.reporter.performance.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f264915h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, g> f264916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, LynxMemoryReportTimer> f264917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<String> f264918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<Boolean> f264919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f264920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f264921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f264922g;

    public static final class a {
    }

    static {
    }

    public LynxMemoryUsageProcessor() {
        this.f264916a = new ConcurrentHashMap();
        this.f264917b = new ConcurrentHashMap();
        this.f264918c = new AtomicReference(null);
        this.f264919d = new AtomicReference(Boolean.FALSE);
        this.f264921f = LazyKt.lazy(new LynxMemoryUsageProcessor$globalReporter$2(this));
        this.f264922g = LazyKt.lazy(LynxMemoryUsageProcessor$enable$2.INSTANCE);
        Npth.addAttachLongUserData(new d(this), CrashType.ALL);
    }

    public static Integer c(l r100) {
        Object r101 = r100.f18217d.get("instanceId");
        if ((r101 instanceof Integer) == true) goto L7;
        return null;
    L7:
        return (Integer) r101;
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final Map<String, Object> a(l r110) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        if ((r110 instanceof g) == true) goto L5;
        return null;
    L5:
        Integer r100 = c(r110);
        if (r100 == null) goto L39;
        int r101 = r100.intValue();
        g r102 = (g) r110;
        ((LynxMemoryUsageGlobalReporter) this.f264921f.getValue()).processMemoryUsageEntry(r102, r101, this.f264916a.get(Integer.valueOf(r101)));
        long r103 = 0;
        if (r102.f18210e != 0) goto L12;
        this.f264916a.remove(Integer.valueOf(r101));
        LynxMemoryReportTimer r111 = this.f264917b.remove(Integer.valueOf(r101));
        if (r111 == null) goto L13;
        r111.f264908e = false;
    L13:
        LinkedHashSet r112 = new LinkedHashSet();
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<T> r105 = this.f264916a.values().iterator();
    L15:
        if (r105.hasNext() == false) goto L40;
        g r106 = (g) r105.next();
        long r107 = r106.f18210e;
        h r108 = r106.f18211f.get("backgroundThreadScriptingEngine");
        if (r108 == null) goto L24;
        String r113 = r108.f18213b.get("groupId");
        if (r113 == null) goto L24;
        if (r112.contains(r113) == false) goto L23;
        r107 = r107 - r108.f18212a;
        goto L24
    L23:
        r112.add(r113);
    L24:
        Object r109 = r106.f18217d.get("url");
        if ((r109 instanceof String) == false) goto L27;
        String r114 = (String) r109;
    L28:
        if (r114 == null) goto L15;
        r104.put(r114, new JSONObject(r106.f18217d));
        r103 = r103 + r107;
        goto L15
    L27:
        r114 = null;
        goto L28
    L40:
        JSONObject r115 = new JSONObject();     // Catch: JSONException -> L34
        r115.put("sizeBytes", r103);     // Catch: JSONException -> L34
        r115.put("lynxViewCount", r104.size());     // Catch: JSONException -> L34
        r115.put("detail", new JSONObject(r104));     // Catch: JSONException -> L34
        LLog.i("LynxSDKMonitor", "LynxSDKMemoryUsage - totalSizeBytes: " + r103 + ", lynxViewCount: " + r104.size());     // Catch: JSONException -> L34
        StringBuilder r116 = new StringBuilder();     // Catch: JSONException -> L34
        r116.append("LynxSDKMemoryUsage - detail: ");     // Catch: JSONException -> L34
        r116.append(r115);     // Catch: JSONException -> L34
        String r117 = r116.toString();     // Catch: JSONException -> L34
        this.f264918c.set(r117);     // Catch: JSONException -> L34
        LLog.i("LynxSDKMonitor", r117);     // Catch: JSONException -> L34
        if (this.f264919d.get().booleanValue() == true) goto L39;
        this.f264919d.set(Boolean.TRUE);     // Catch: JSONException -> L34
        Npth.addTag("enableLynxMemoryMonitor", "true");     // Catch: JSONException -> L34
    L34:
        e = move-exception;
        String r118 = e.getMessage();
        if (r118 != null) goto L38;
        r118 = "";
    L38:
        LLog.e("LynxMemoryUsageProcessor", r118);
        goto L39
    L12:
        this.f264916a.put(Integer.valueOf(r101), r110);
    L39:
        return null;
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final boolean b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        ((Boolean) this.f264922g.getValue()).booleanValue();
        String r101 = r100.f18214a;
        int r102 = r101.hashCode();
        if (r102 == (-701686520)) goto L19;
        if (r102 == 101203) goto L13;
        if (r102 != 528832539) goto L28;
        if (r101.equals("actualFmp") == false) goto L28;
    L15:
        Integer r103 = c(r100);
        if (r103 == null) goto L28;
        d(r103.intValue(), r100.f18214a, null);
    L28:
        return Intrinsics.areEqual(r100.f18215b, "memory");
    L13:
        if (r101.equals("fcp") == true) goto L15;
    L19:
        if (r101.equals("loadBundle") == false) goto L28;
        Integer r104 = c(r100);
        if (r104 == null) goto L28;
        final int r105 = r104.intValue();
        if (this.f264917b.containsKey(Integer.valueOf(r105)) == true) goto L28;
        final WeakReference r106 = new WeakReference(this);
        Lazy<Long> r107 = LynxMemoryReportTimer.f264903f;
        LynxMemoryReportTimer r108 = LynxMemoryReportTimer.a.a(r105, new LynxMemoryUsageProcessor$startTimer$timer$1(r106, r105));
        Integer r109 = Integer.valueOf(r105);
        this.f264917b.put(r109, r108);
        goto L28
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final void onInitialize(Context r100) {
        this.f264920e = r100;
    }

    public final void d(int r100, String r101, Map<String, ? extends Object> r102) {
        g r103 = this.f264916a.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        return;
    L5:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("totalSizeBytes", Long.valueOf(r103.f18210e));
        r104.put("stage", r101);
        Iterator<Map.Entry<String, h>> r105 = r103.f18211f.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, h> r106 = r105.next();
        r104.put(r106.getKey() + "SizeBytes", Long.valueOf(r106.getValue().f18212a));
        goto L7
    L9:
        HashMap<String, Object> r107 = r103.f18217d;
        if (r107 == null) goto L12;
        r104.putAll(r107);
    L12:
        if (r102 == null) goto L14;
        r104.putAll(r102);
    L14:
        AppLogNewUtils.onEventV3("lynxsdk_performance_entry_memory", LynxEventReporterService.INSTANCE.convertBooleanToInt(new JSONObject(r104)));
    }
}
