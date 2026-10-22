package hg9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements gb6.b {
    public b() {
    }

    @Override // gb6.a
    public final a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        return new a(r100);
    }
}
