package vt3;

import com.bytedance.apm.util.b;
import com.bytedance.monitor.collector.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static double a() {
        long r0 = System.currentTimeMillis();
        long r2 = c.e().a();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((c.e().a() - r2) * 1000.0d) / (System.currentTimeMillis() - r0)) / b.f();
    }
}
