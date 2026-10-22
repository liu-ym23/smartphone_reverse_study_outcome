package dg8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r extends lsc.a {
    public r() {
    }

    @Override // lsc.a, lsc.j
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "markdown");
        return s.f468533b.replace(r100, " - ");
    }
}
