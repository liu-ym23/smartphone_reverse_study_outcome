package y36;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p extends i<String> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        return (String) this.f565862b;
    }

    public p(String r100) {
        super(r100);
    }

    @Override // y36.i
    public final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        return r100;
    }

    public p(t36.d r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
