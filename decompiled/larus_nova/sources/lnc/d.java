package lnc;

import android.os.SystemClock;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.component.logger.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements com.suite.component.logger.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f510072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f510073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f510074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f510075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f510076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f510077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, AtomicInteger> f510078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f510079h;

    public d() {
        this.f510072a = 2;
        this.f510073b = 1000;
        this.f510074c = 300;
        this.f510075d = new AtomicLong(0);
        this.f510076e = new AtomicLong(0);
        this.f510077f = new AtomicInteger(0);
        this.f510078g = new ConcurrentHashMap();
        this.f510079h = new AtomicBoolean(false);
    }

    @Override // com.suite.component.logger.api.d
    public final void a(com.suite.component.logger.api.d.a r110, com.suite.component.logger.b r111, com.suite.component.logger.c r210) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "entity");
        r110.a(r111, r210);
        long r100 = SystemClock.elapsedRealtime();
        long r101 = 1000;
        if ((r100 - this.f510076e.get()) >= (this.f510074c * r101)) goto L6;
        return;
    L6:
        if (this.f510079h.getAndSet(true) == true) goto L8;
        this.f510075d.set(r100);
    L8:
        long r112 = r100 - this.f510075d.get();
        if (r112 < (this.f510072a * r101)) goto L25;
        if (this.f510079h.getAndSet(false) == false) goto L25;
        long r113 = ((long) (this.f510077f.incrementAndGet() * 1000)) / r112;
        ConcurrentHashMap<String, AtomicInteger> r102 = this.f510078g;
        if (r113 > this.f510073b) goto L15;
    L23:
        this.f510076e.set(r100);
        this.f510077f.set(0);
        this.f510078g.clear();
        return;
    L15:
        if (r102.isEmpty() == true) goto L23;
        com.suite.lark.component.logger.dynamic.a r114 = Log.f460091e;
        if (r114 == null) goto L23;
        LinkedHashMap r103 = new LinkedHashMap(MapsKt.mapCapacity(r102.size()));
        Iterator<T> r104 = r102.entrySet().iterator();
    L20:
        if (r104.hasNext() == false) goto L22;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put(r105.getKey(), Integer.valueOf(((AtomicInteger) r105.getValue()).get()));
        goto L20
    L22:
        r114.d(r112, r113, r103);
    L25:
        if (this.f510079h.get() == false) goto L36;
        this.f510077f.incrementAndGet();
        ConcurrentHashMap<String, AtomicInteger> r106 = this.f510078g;
        String r107 = r210.f460116b;
        AtomicInteger r108 = r106.get(r107);
        if (r108 != null) goto L32;
        r108 = new AtomicInteger(0);
        AtomicInteger r109 = r106.putIfAbsent(r107, r108);
        if (r109 == null) goto L32;
        r108 = r109;
    L32:
        r108.incrementAndGet();
        return;
    }
}
