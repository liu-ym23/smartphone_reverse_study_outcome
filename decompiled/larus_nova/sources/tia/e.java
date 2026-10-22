package tia;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements hga.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f546292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hga.e f546293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Long, Boolean> f546294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<e, Unit> f546295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f546296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f546297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f546298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f546299h;

    public static final class a {
    }

    static {
    }

    @Override // hga.c
    public final void release() {
        if (this.f546298g.compareAndSet(false, true) == false) goto L6;
        this.f546295d.invoke(this);
        return;
    }

    @Override // hga.c
    public final void start() {
        this.f546297f.set(true);
    }

    @Override // hga.c
    public final void stop() {
        this.f546297f.set(false);
    }

    @Override // hga.c
    public final int a() {
        return this.f546299h;
    }

    @Override // hga.c
    public final long d(long r100) {
        return tia.a.a(r100);
    }

    @Override // hga.c
    public final int read(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        if (this.f546297f.get() == true) goto L5;
        return 0;
    L5:
        if (this.f546298g.get() == true) goto L29;
        f r101 = this.f546292a;
        monitor-enter(r101);
        d r102 = this.f546292a.b(this.f546296e, r100);     // Catch: Throwable -> L22
        monitor-exit(r101);
        if (r102.f546291c <= 0) goto L14;
        FLogger.f375446a.i("WakeupCaptureReader", "reader missing audio scene=" + this.f546293b.f485035a + " reason=" + this.f546293b.f485037c + " missingMs=" + r102.f546291c);
    L14:
        this.f546296e = r102.f546290b;
        if (r102.f546289a != 0) goto L21;
        if (this.f546294c.invoke(Long.valueOf(this.f546296e)).booleanValue() == false) goto L21;
        return -1;
    L21:
        return r102.f546289a;
    L22:
        th = move-exception;
        throw th;
    L29:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(f r100, hga.e r101, Function1<? super Long, Boolean> r102, Function1<? super e, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "ringBuffer");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "shouldStopOnEmpty");
        Intrinsics.checkNotNullParameter(r103, "onRelease");
        this.f546292a = r100;
        this.f546293b = r101;
        this.f546294c = r102;
        this.f546295d = r103;
        this.f546296e = r101.f485036b;
        this.f546297f = new AtomicBoolean(false);
        this.f546298g = new AtomicBoolean(false);
        this.f546299h = BmLocated.HALF_LEFT_TOP;
    }
}
