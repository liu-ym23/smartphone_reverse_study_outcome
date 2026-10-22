package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class k2 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520726c;

    @Override // luc.f
    public final String f() {
        return this.f520726c;
    }

    public k2(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "primitive");
        super(r100);
        this.f520726c = r100.f() + "Array";
    }
}
