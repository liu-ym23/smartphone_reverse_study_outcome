package rx9;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f539858h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f539860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f539861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f539862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f539863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f539864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f539865g;

    public static final class a {
    }

    static {
        f539858h = new AtomicInteger(1);
    }

    public final void a() {
        if (rx9.a.f539833a.get() == true) goto L6;
        return;
    L6:
        if (this.f539861c.get() != 0) goto L10;
        s.a(this.f539863e, this.f539864f + " end failure, no start");
        return;
    L10:
        if (this.f539862d.compareAndSet(0, SystemClock.elapsedRealtime()) == false) goto L12;
        Lazy r100 = q.f539873a;
        Intrinsics.checkNotNullParameter(this, "task");
        q.a(new o(this));
        s.a(this.f539863e, this.f539864f + " end success");
        return;
    L12:
        s.a(this.f539863e, this.f539864f + " end failure, completed");
    }

    public final void b() {
        if (rx9.a.f539833a.get() == true) goto L6;
        return;
    L6:
        if (this.f539862d.get() == 0) goto L10;
        s.a(this.f539863e, this.f539864f + " start failure, completed");
        return;
    L10:
        if (this.f539861c.compareAndSet(0, SystemClock.elapsedRealtime()) == false) goto L12;
        Lazy r100 = q.f539873a;
        Intrinsics.checkNotNullParameter(this, "task");
        q.a(new n(this));
        s.a(this.f539863e, this.f539864f + " start success");
        return;
    L12:
        s.a(this.f539863e, this.f539864f + " start failure, started");
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        this.f539859a = r100;
        this.f539860b = true;
        this.f539861c = new AtomicLong(0);
        this.f539862d = new AtomicLong(0);
        StringBuilder r101 = new StringBuilder("TickTask@");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r101.append(Integer.toHexString(hashCode()));
        this.f539863e = r101.toString();
        this.f539864f = r100 + '#' + f539858h.getAndIncrement();
        AtomicBoolean r102 = rx9.a.f539833a;
        this.f539865g = rx9.a.f539838f;
    }
}
