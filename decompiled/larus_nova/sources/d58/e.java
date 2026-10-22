package d58;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f467072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Long> f467073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f467074c;

    public e(int r100) {
        Function0<Long> r101 = new d();
        Intrinsics.checkNotNullParameter(r101, "clock");
        this.f467072a = 500;
        this.f467073b = r101;
        this.f467074c = -500;
    }

    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "show");
        long r101 = this.f467073b.invoke().longValue();
        if ((r101 - this.f467074c) < this.f467072a) goto L6;
        this.f467074c = r101;
        r100.invoke();
        return;
    }
}
