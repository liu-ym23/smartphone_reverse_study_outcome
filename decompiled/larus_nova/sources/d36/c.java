package d36;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Double> f466729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f466730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f466731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Long> f466732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f466733e;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f466729a = new ConcurrentHashMap();
        this.f466730b = new ConcurrentHashMap();
        this.f466731c = new AtomicBoolean(false);
        this.f466732d = new LinkedHashMap();
        this.f466733e = "";
    }

    public final void a(String r100, String r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "stepName");
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.g(r100, r101 + "  recordCpu cpurate: " + r102, "CpuMemoryPerfMetric", 8);
        this.f466729a.put(r101, Double.valueOf(r102));
    }

    public final void b(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "stepName");
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.g(r100, r101 + "  recordMemroy memory: " + r102, "CpuMemoryPerfMetric", 8);
        this.f466730b.put(r101, Long.valueOf(r102));
    }
}
