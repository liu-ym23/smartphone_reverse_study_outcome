package vt3;

import android.text.TextUtils;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class g {
    public static void a(int r110, Map<Integer, h> r111) {
        File[] r100 = new PolarisFileWrapper("/proc/" + r110 + "/task/").listFiles();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        int r103 = CastIntegerProtector.parseInt(r100[r102].getName());     // Catch: NumberFormatException -> L16
        com.bytedance.monitor.collector.c.e().getClass();     // Catch: NumberFormatException -> L16
        ThreadStatInfo r104 = MonitorJni.getThreadStatInfo(r110, r103);     // Catch: NumberFormatException -> L16
        if (r103 == 0) goto L14;
        if (r104 == null) goto L14;
        if (TextUtils.isEmpty(r104.threadName) == true) goto L14;
        if (r104.threadCpuTime == 0) goto L14;
        h r105 = new h();     // Catch: NumberFormatException -> L16
        r105.f557213a = r103;     // Catch: NumberFormatException -> L16
        r105.f557214b = r104.threadName;     // Catch: NumberFormatException -> L16
        r105.f557215c = r104.threadCpuTime;     // Catch: NumberFormatException -> L16
        ((HashMap) r111).put(Integer.valueOf(r103), r105);     // Catch: NumberFormatException -> L16
    L14:
        r102 = r102 + 1;
        goto L3
    }
}
