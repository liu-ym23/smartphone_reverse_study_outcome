package vt3;

import android.text.TextUtils;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.c;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static void a(int r10, Map<Integer, h> r11) {
        File[] r0 = new PolarisFileWrapper("/proc/" + r10 + "/task/").listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        int r3 = CastIntegerProtector.parseInt(r0[r2].getName());     // Catch: NumberFormatException -> L16
        c.e().getClass();     // Catch: NumberFormatException -> L16
        ThreadStatInfo r4 = MonitorJni.getThreadStatInfo(r10, r3);     // Catch: NumberFormatException -> L16
        if (r3 == 0) goto L14;
        if (r4 == null) goto L14;
        if (TextUtils.isEmpty(r4.threadName) == true) goto L14;
        if (r4.threadCpuTime == 0) goto L14;
        h r5 = new h();     // Catch: NumberFormatException -> L16
        r5.a = r3;     // Catch: NumberFormatException -> L16
        r5.b = r4.threadName;     // Catch: NumberFormatException -> L16
        r5.c = r4.threadCpuTime;     // Catch: NumberFormatException -> L16
        ((HashMap) r11).put(Integer.valueOf(r3), r5);     // Catch: NumberFormatException -> L16
    L14:
        r2 = r2 + 1;
        goto L3
    }
}
