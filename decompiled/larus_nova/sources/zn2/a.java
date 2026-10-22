package zn2;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.apm.util.b;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static final void a(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "memInfoMap");
        long r101 = Runtime.getRuntime().maxMemory();
        long r102 = Runtime.getRuntime().totalMemory();
        long r103 = Runtime.getRuntime().freeMemory();
        r100.put("mem_java_used", Long.valueOf(r102 - r103));
        r100.put("mem_java_total", Long.valueOf(r102));
        r100.put("mem_java_free", Long.valueOf(r103));
        r100.put("mem_java_max", Long.valueOf(r101));
    }

    public static final void b(Map<String, Long> r210) {
        Intrinsics.checkNotNullParameter(r210, "memInfoMap");
        Debug.MemoryInfo r100 = b.e(Process.myPid(), s1.getContext());
        if (r100 == null) goto L55;
        long r101 = ((long) r100.dalvikPss) * 1024;
        long r102 = ((long) r100.nativePss) * 1024;
        long r103 = ((long) r100.getTotalPss()) * 1024;
        if (Build.VERSION.SDK_INT >= 23) goto L47;
        long r104 = 0;
        long r110 = 0;
        long r111 = 0;
        long r112 = 0;
        long r211 = 0;
        long r212 = 0;
        long r213 = 0;
        long r214 = 0;
    L37:
        r210.put("mem_pss_dalvik", Long.valueOf(r101));
        r210.put("mem_pss_native", Long.valueOf(r102));
        r210.put("mem_pss_total", Long.valueOf(r103));
        r210.put("mem_graphics", Long.valueOf(r110));
        r210.put("mem_vmsize", Long.valueOf(r112));
        r210.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_JAVA_HEAP, Long.valueOf(r111));
        r210.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_NATIVE_HEAP, Long.valueOf(r104));
        r210.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_CODE, Long.valueOf(r211));
        r210.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_STACK, Long.valueOf(r212));
        r210.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_PRIVATE_OTHER, Long.valueOf(r213));
        r210.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_SYSTEM, Long.valueOf(r214));
        return;
    L47:
        long r113 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.graphics"))) * 1024;
        r111 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.java-heap"))) * 1024;
        long r114 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.native-heap"))) * 1024;
        r211 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.code"))) * 1024;
        r212 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.stack"))) * 1024;
        r213 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.private-other"))) * 1024;
        r214 = ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.system"))) * 1024;
        CastIntegerProtector.parseInt(r100.getMemoryStat("summary.total-pss"));     // Catch: Exception -> L22
        CastIntegerProtector.parseInt(r100.getMemoryStat("summary.total-swap"));     // Catch: Exception -> L22
        r112 = b.k() * 1024;
        r104 = r114;
    L35:
        r110 = r113;
    L22:
        long r105 = r211;
    L34:
        r211 = r105;
        r104 = r114;
        r112 = 0;
    L23:
        r105 = r211;
    L33:
        r214 = 0;
    L24:
        r105 = r211;
    L32:
        r213 = 0;
    L25:
        r105 = r211;
    L31:
        r212 = 0;
    L26:
        r105 = 0;
    L27:
        r105 = 0;
        r114 = 0;
    L28:
        r105 = 0;
    L30:
        r114 = 0;
        r111 = 0;
    L29:
        r105 = 0;
        r113 = 0;
        goto L30
    }
}
