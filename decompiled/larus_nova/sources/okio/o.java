package okio;

import com.bytedance.crash.dumper.Scraps;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class o extends j0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j0 f524091e;

    @Override // okio.j0
    public final void a(Condition r100) {
        throw null;
    }

    @Override // okio.j0
    public final j0 b() {
        return this.f524091e.b();
    }

    @Override // okio.j0
    public final j0 c() {
        return this.f524091e.c();
    }

    @Override // okio.j0
    public final long d() {
        return this.f524091e.d();
    }

    @Override // okio.j0
    public final boolean f() {
        return this.f524091e.f();
    }

    @Override // okio.j0
    public final void g() throws IOException {
        this.f524091e.g();
    }

    @Override // okio.j0
    public final long i() {
        return this.f524091e.i();
    }

    public o(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f524091e = r100;
    }

    @Override // okio.j0
    public final j0 e(long r100) {
        return this.f524091e.e(r100);
    }

    @Override // okio.j0
    public final j0 h(long r100, TimeUnit r101) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        return this.f524091e.h(r100, r101);
    }
}
