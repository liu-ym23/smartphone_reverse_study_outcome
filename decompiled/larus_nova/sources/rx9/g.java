package rx9;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<ScheduledThreadPoolExecutor> f539845k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f539846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f539847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f539848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f539849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f539850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f539851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f539852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScheduledFuture<?> f539853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f539854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f539855j;

    public static final class a {
        public a() {
        }

        public static final ScheduledFuture a(long r100, Runnable r101) {
            Lazy<ScheduledThreadPoolExecutor> r102 = g.f539845k;
            return g.f539845k.getValue().schedule(r101, r100, TimeUnit.MILLISECONDS);
        }
    }

    static {
        new a();
        f539845k = LazyKt.lazy(new d());
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [rx9.f] */
    public g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f539846a = r100;
        StringBuilder r101 = new StringBuilder("TickSession@");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r101.append(Integer.toHexString(hashCode()));
        this.f539847b = r101.toString();
        this.f539848c = new AtomicInteger(0);
        long r102 = r100.f539840b;
        this.f539849d = r100.f539839a;
        this.f539852g = r102;
        this.f539855j = new f(this);
    }

    public final synchronized void a(boolean r110, final boolean r111) {
        monitor-enter(this);
        long r100 = this.f539850e;     // Catch: Throwable -> L29
        long r101 = this.f539851f;     // Catch: Throwable -> L29
        long r102 = this.f539852g;     // Catch: Throwable -> L29
        long r103 = r101 + r102;     // Catch: Throwable -> L29
        long r104 = this.f539849d;     // Catch: Throwable -> L29
        if (r103 < r104) goto L7;
        r103 = r104;
    L8:
        s.a(this.f539847b, "onTick->first=" + r110 + ", loop=" + r111 + ", new_interval=" + r103 + ", last_interval=" + r100 + ", scale=" + this.f539846a.f539841c);     // Catch: Throwable -> L29
        final boolean r105 = false;
        if (r111 == false) goto L11;
        this.f539853h = a.a(r103, this.f539855j);     // Catch: Throwable -> L29
        this.f539850e = r103;     // Catch: Throwable -> L29
    L15:
        final long r106 = this.f539854i;     // Catch: Throwable -> L29
        final long r107 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L29
        if (r110 == true) goto L25;
        long r112 = r107 - r106;     // Catch: Throwable -> L29
        if (r112 >= (r100 * this.f539846a.f539841c)) goto L20;
        Keva r113 = j.a();     // Catch: Throwable -> L29
        Lazy r108 = j.f539857b;     // Catch: Throwable -> L29
        j.a().storeLong((String) r108.getValue(), r113.getLong((String) r108.getValue(), 0) + r112);     // Catch: Throwable -> L29
        r105 = true;
    L20:
        String r114 = this.f539847b;     // Catch: Throwable -> L29
        StringBuilder r109 = new StringBuilder("onTick->");     // Catch: Throwable -> L29
        if (r105 == false) goto L23;
        String r115 = "valid";
    L24:
        r109.append(r115);     // Catch: Throwable -> L29
        r109.append(", duration=");     // Catch: Throwable -> L29
        r109.append(r112);     // Catch: Throwable -> L29
        r109.append(", app_total=");     // Catch: Throwable -> L29
        r109.append(j.a().getLong((String) j.f539857b.getValue(), 0));     // Catch: Throwable -> L29
        s.a(r114, r109.toString());     // Catch: Throwable -> L29
        q.a(new p(r111, r105, r106, r107));     // Catch: Throwable -> L29
    L26:
        this.f539854i = r107;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L23:
        r115 = "invalid";
        goto L24
    L25:
        s.a(this.f539847b, "onTick->skip, app_total=" + j.a().getLong((String) j.f539857b.getValue(), 0));     // Catch: Throwable -> L29
        final boolean r116 = false;
        q.a(new p(r111, r116, r106, r107));     // Catch: Throwable -> L29
        goto L26
    L11:
        ScheduledFuture<?> r117 = this.f539853h;     // Catch: Throwable -> L29
        if (r117 == null) goto L14;
        r117.cancel(false);     // Catch: Throwable -> L29
    L14:
        this.f539850e = 0;     // Catch: Throwable -> L29
        goto L15
    L7:
        this.f539851f = r102;     // Catch: Throwable -> L29
        this.f539852g = r103;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }
}
