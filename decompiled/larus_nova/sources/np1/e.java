package np1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d<? extends a> f520009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f520010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f520011d;

    @Override // np1.a
    public final d<? extends a> a() {
        return this.f520009b;
    }

    @Override // np1.a
    public final c c() {
        return this.f520010c;
    }

    @Override // np1.a
    public int getType() {
        return this.f520011d;
    }

    public e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        this.f520010c = r100;
        this.f520011d = 2;
    }
}
