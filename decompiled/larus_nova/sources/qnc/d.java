package qnc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f534133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f534134b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends c> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        this.f534133a = r100;
        this.f534134b = r101;
    }

    @Override // qnc.c.a
    public final void a(e r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "request");
        if (this.f534134b >= this.f534133a.size()) goto L7;
        d r102 = new d(this.f534133a, this.f534134b + 1);
        ((c) ListProtector.get(this.f534133a, this.f534134b)).b(r100, r101, r102);
        return;
    L7:
        throw new AssertionError();
    }

    public final boolean b(e r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "request");
        if (this.f534134b >= this.f534133a.size()) goto L7;
        d r102 = new d(this.f534133a, this.f534134b + 1);
        return ((c) ListProtector.get(this.f534133a, this.f534134b)).a(r100, r101, r102);
    L7:
        throw new AssertionError();
    }
}
