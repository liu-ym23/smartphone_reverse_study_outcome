package t6b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class i implements s6b.b<i, j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f544803a;

    public i() {
        this(true);
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new j(this);
    }

    public boolean c() {
        return this.f544803a;
    }

    public i(boolean r100) {
        this.f544803a = r100;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "patch");
        return new i(r101.c());
    }
}
