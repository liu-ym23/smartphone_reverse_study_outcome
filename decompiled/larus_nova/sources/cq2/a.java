package cq2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u30.b f464766a;

    @Override // cq2.b
    public final a a() {
        this.f464766a.d(true);
        return this;
    }

    public final void b() {
        this.f464766a.b();
    }

    public a(u30.b r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f464766a = r100;
    }

    @Override // cq2.b
    public final a setTitle(String r100) {
        this.f464766a.setTitle(r100);
        return this;
    }
}
