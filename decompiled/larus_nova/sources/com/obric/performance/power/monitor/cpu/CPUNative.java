package com.obric.performance.power.monitor.cpu;

import com.obric.performance.power.monitor.utils.EnsureLoad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J)\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\fH\u0083 J\t\u0010\r\u001a\u00020\u000eH\u0087 J\t\u0010\u000f\u001a\u00020\u000eH\u0087 J\t\u0010\u0010\u001a\u00020\u000eH\u0087 J\u0011\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bH\u0087 J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0087 J:\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0007J;\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0087 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/performance/power/monitor/cpu/CPUNative;", "", "<init>", "()V", "TAG", "", "cpuPolicyMap", "", "", "getCpuPolicy", "dumpCpuPolicy", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getProcessCpuTime", "", "getDeviceCpuTime", "getDeviceIdleTime", "getThreadCpuTime", "tid", "getThreadArrayCpuTime", "", "tidArray", "", "dumpCpuTime", "Lcom/obric/performance/power/monitor/cpu/CPUInfo;", "needDeviceCpu", "", "needDeviceIdle", "needProcess", "needDevicePolicy", "needThreadPolicy", "dumpNativeCpuTime", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CPUNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CPUNative f403805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<Integer, Integer> f403806b;

    public CPUNative() {
    }

    @JvmStatic
    private static final native HashMap<String, String> dumpCpuPolicy();

    @JvmStatic
    public static final native CPUInfo dumpNativeCpuTime(boolean r100, boolean r101, boolean r102, int[] r103, boolean r104, boolean r105);

    @JvmStatic
    public static final native long getDeviceCpuTime();

    @JvmStatic
    public static final native long getDeviceIdleTime();

    @JvmStatic
    public static final native long getProcessCpuTime();

    @JvmStatic
    public static final native long[] getThreadArrayCpuTime(int[] r100);

    @JvmStatic
    public static final native long getThreadCpuTime(int r100);

    static {
        f403805a = new CPUNative();
        EnsureLoad.f403830a.init();
    }

    public final Map<Integer, Integer> a() {
        if (f403806b != null) goto L24;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (f403806b != null) goto L17;
        HashMap<String, String> r100 = dumpCpuPolicy();     // Catch: Throwable -> L20
        if (r100 == null) goto L15;
        ArrayList r101 = new ArrayList(r100.size());     // Catch: Throwable -> L20
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L20
    L11:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Throwable -> L20
        String r104 = r103.getKey();     // Catch: Throwable -> L20
        String r105 = r103.getValue();     // Catch: Throwable -> L20
        r101.add(TuplesKt.to(Integer.valueOf(Integer.parseInt(r104)), Integer.valueOf(Integer.parseInt(r105))));     // Catch: Throwable -> L20
        goto L11
    L13:
        Map<Integer, Integer> r106 = MapsKt.toMap(r101);     // Catch: Throwable -> L20
        if (r106 == null) goto L15;
    L16:
        f403806b = r106;     // Catch: Throwable -> L20
    L15:
        r106 = new LinkedHashMap();     // Catch: Throwable -> L20
    L17:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
    L24:
        return f403806b;
    }
}
