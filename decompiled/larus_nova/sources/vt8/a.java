package vt8;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements d {
    public a() {
    }

    @Override // vt8.d
    public final int b() {
        return 5;
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        return TuplesKt.to(0, Integer.valueOf(r100.length()));
    }
}
