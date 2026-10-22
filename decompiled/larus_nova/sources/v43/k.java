package v43;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f553074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f553075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n33.f f553076c;

    public k() {
        AtomicLong r100 = new AtomicLong(0);
        Intrinsics.checkNotNullParameter(r100, "uplinkVersion");
        this.f553074a = r100;
        this.f553075b = null;
        this.f553076c = null;
    }

    @Override // v43.s
    public final t A() {
        return this.f553075b;
    }

    @Override // v43.s
    public final AtomicLong b() {
        return this.f553074a;
    }

    @Override // v43.s
    public final n33.f t() {
        return this.f553076c;
    }

    @Override // v43.s
    public final void B(n33.f r100) {
        this.f553076c = r100;
    }

    @Override // v43.s
    public final void l(t r100) {
        this.f553075b = r100;
    }
}
