package ej6;

import com.bytedance.live.livelink.kmp.impl.core.link.LinkManager$logReporter$2;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements ki6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f472875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<ki6.b> f472876b;

    public static final class a {
    }

    static {
    }

    @Override // ki6.a
    public final long c() {
        return this.f472875a.incrementAndGet();
    }

    @Override // ki6.a
    public final void release() {
        this.f472876b.clear();
    }

    public c() {
        this.f472875a = new AtomicLong(0);
        this.f472876b = new LinkedHashSet();
    }

    @Override // ki6.a
    public final void a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        Intrinsics.checkNotNullParameter("live_client_monitor_log", "logType");
        Intrinsics.checkNotNullParameter(r100, "log");
        Iterator<T> r101 = this.f472876b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ki6.b) r101.next()).a(r100);
        goto L4
    }

    @Override // ki6.a
    public final void b(LinkManager$logReporter$2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f472876b.add(r100);
    }

    @Override // ki6.a
    public final void d(LinkManager$logReporter$2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f472876b.remove(r100);
    }
}
