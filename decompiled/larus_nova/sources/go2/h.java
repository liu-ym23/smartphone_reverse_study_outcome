package go2;

import com.bytedance.android.livesdk.config.ig0;
import com.bytedance.android.livesdk.config.s31;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements com.bytedance.android.livesdk.performance.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s31 f481905a;

    public h() {
        this.f481905a = ig0.f120451a.getValue();
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L16;
        g r102 = new g();
        d(r100, "mem_pss_total", r101.f154738r, r102);
        d(r100, "mem_java_total", r101.f154746v, r102);
        d(r100, "mem_java_free", r101.f154748w, r102);
        d(r100, "mem_java_used", r101.f154750x, r102);
        d(r100, "mem_java_max", r101.f154752y, r102);
        d(r100, "mem_pss_dalvik", r101.f154740s, r102);
        d(r100, "mem_pss_native", r101.f154742t, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_graphics, r101.D, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_system, r101.G, r102);
        d(r100, IPerformanceManager.MEM.mem_java_lave, r101.f154754z, r102);
        d(r100, IPerformanceManager.MEM.mem_native_lave, r101.A, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_native, r101.C, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_java, r101.B, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_code, r101.E, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_stack, r101.F, r102);
        d(r100, IPerformanceManager.MEM.mem_sum_other, r101.H, r102);
        d(r100, "mem_vmsize", r101.f154744u, r102);
        d(r100, IPerformanceManager.MEM.mem_device_total, r101.I, r102);
        d(r100, IPerformanceManager.MEM.mem_device_available, r101.f154692J, r102);
        d(r100, IPerformanceManager.MEM.mem_device_threshold, r101.K, r102);
        c(r100, IPerformanceManager.MEM.mem_trim_level, r101.M);
        c(r100, IPerformanceManager.MEM.mem_gc_time, r101.W0);
        c(r100, IPerformanceManager.MEM.mem_gc_count, r101.V0);
        c(r100, IPerformanceManager.MEM.mem_gc_count_block, r101.X0);
        c(r100, IPerformanceManager.MEM.mem_gc_time_block, r101.Y0);
        c(r100, IPerformanceManager.MEM.mem_gc_stat_no, r101.Z0);
        b(r100, IPerformanceManager.MEM.mem_gc_time_new_per_second, r101.f154698b1);
        b(r100, IPerformanceManager.MEM.mem_gc_count_new_per_second, r101.f154695a1);
        b(r100, IPerformanceManager.MEM.mem_gc_time_block_new_per_second, r101.f154704d1);
        b(r100, IPerformanceManager.MEM.mem_gc_count_block_new_per_second, r101.f154701c1);
        b(r100, IPerformanceManager.MEM.mem_minor_faults_per_second, r101.f154713g1);
        b(r100, IPerformanceManager.MEM.mem_major_faults_per_second, r101.f154716h1);
        b(r100, IPerformanceManager.MEM.mem_kBytes_allocated_per_second, r101.f154719i1);
        b(r100, IPerformanceManager.MEM.mem_kBytes_freed_per_second, r101.f154722j1);
        b(r100, IPerformanceManager.MEM.mem_gc_time_wait_per_second, r101.f154707e1);
        b(r100, IPerformanceManager.MEM.mem_gc_time_pause_per_second, r101.f154710f1);
        if (r101.L == false) goto L7;
        String r103 = "1";
    L8:
        HashMap r104 = (HashMap) r100;
        r104.put(IPerformanceManager.MEM.mem_device_mem_Low, r103);
        long r105 = r101.f154752y;
        if (r105 <= 0) goto L14;
        long r106 = r101.f154750x;
        if (r106 <= 0) goto L15;
        r104.put(IPerformanceManager.MEM.mem_java_used_percentage, String.valueOf(r106 / r105));
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r103 = "0";
        goto L8
    }

    public final void b(Map<String, String> r100, String r101, float r102) {
        if (r102 < 0.0f) goto L5;
    L7:
        HashMap r103 = (HashMap) r100;
        r103.put(r101, String.valueOf(r102));
        return;
    L5:
        if (this.f481905a.h() == false) goto L7;
    }

    public final void c(Map<String, String> r100, String r101, long r102) {
        d(r100, r101, r102, null);
    }

    public final void d(Map r100, String r101, long r102, g r103) {
        if (r102 < 0) goto L5;
    L7:
        if (r103 != null) goto L9;
        HashMap r104 = (HashMap) r100;
        r104.put(r101, String.valueOf(r102));
        return;
    L9:
        HashMap r105 = (HashMap) r100;
        r105.put(r101, String.valueOf((r102 / 1024) / 1024));
        return;
    L5:
        if (this.f481905a.h() == false) goto L7;
    }
}
