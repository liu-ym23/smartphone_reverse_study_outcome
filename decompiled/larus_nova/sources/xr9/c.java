package xr9;

import com.bytedance.crash.dumper.Scraps;
import com.larus.power.state.impl.AndroidPowerStateEventSource;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wr9.k;
import wr9.l;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f564881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wr9.e f564882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f564883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f564884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<d> f564885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<wr9.j> f564886f;

    public static final class a {
    }

    static {
    }

    public final void d() {
        if (this.f564884d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        long r100 = this.f564882b.a();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(this.f564881a.b(r100));     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L20;
        k r110 = (k) r102;
        Object r111 = this.f564883c;
        monitor-enter(r111);
        wr9.j r103 = wr9.j.a(wr9.j.a(this.f564886f.get(), 0, null, null, null, r110, 31), r100, null, null, null, null, 62);     // Catch: Throwable -> L17
        this.f564886f.set(r103);     // Catch: Throwable -> L17
        monitor-exit(r111);
        e(r103);
    L17:
        th = move-exception;
        throw th;
    L20:
        Result.m9452exceptionOrNullimpl(r102);
        this.f564881a.a(this);     // Catch: Throwable -> L23
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Result.m9452exceptionOrNullimpl(r104);
        return;
    L23:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void e(wr9.j r100) {
        Iterator<d> r101 = this.f564885e.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        r101.next().a(r100);     // Catch: Throwable -> L8
        goto L4
    }

    public c(AndroidPowerStateEventSource r100, wr9.e r101) {
        Intrinsics.checkNotNullParameter(r100, "eventSource");
        Intrinsics.checkNotNullParameter(r101, "clock");
        this.f564881a = r100;
        this.f564882b = r101;
        this.f564883c = new Object();
        this.f564884d = new AtomicBoolean(false);
        this.f564885e = new CopyOnWriteArraySet();
        this.f564886f = new AtomicReference(g.b(r101.a(), "not_initialized"));
    }

    @Override // xr9.e
    public final void a(l r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, "thermal");
        Object r110 = this.f564883c;
        monitor-enter(r110);
        wr9.j r100 = wr9.j.a(wr9.j.a(this.f564886f.get(), 0, r210, null, null, null, 61), r211, null, null, null, null, 62);     // Catch: Throwable -> L8
        this.f564886f.set(r100);     // Catch: Throwable -> L8
        monitor-exit(r110);
        e(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // xr9.e
    public final void b(wr9.a r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, Scraps.BATTERY);
        Object r110 = this.f564883c;
        monitor-enter(r110);
        wr9.j r100 = wr9.j.a(wr9.j.a(this.f564886f.get(), 0, null, null, r210, null, 47), r211, null, null, null, null, 62);     // Catch: Throwable -> L8
        this.f564886f.set(r100);     // Catch: Throwable -> L8
        monitor-exit(r110);
        e(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // xr9.e
    public final void c(wr9.c r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, "memory");
        Object r110 = this.f564883c;
        monitor-enter(r110);
        wr9.j r100 = wr9.j.a(wr9.j.a(this.f564886f.get(), 0, null, r210, null, null, 55), r211, null, null, null, null, 62);     // Catch: Throwable -> L8
        this.f564886f.set(r100);     // Catch: Throwable -> L8
        monitor-exit(r110);
        e(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
