package vt3;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    public static double a() {
        long r100 = System.currentTimeMillis();
        long r101 = com.bytedance.monitor.collector.c.e().a();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((com.bytedance.monitor.collector.c.e().a() - r101) * 1000.0d) / (System.currentTimeMillis() - r100)) / com.bytedance.apm.util.b.f();
    }
}
