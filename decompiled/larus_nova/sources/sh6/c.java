package sh6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static final <T> b<T> a(T r100) {
        if (r100 == null) goto L5;
        return new d(r100);
    L5:
        return a.f541970a;
    }

    public static final <T> T b(b<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof d) == true) goto L7;
        return null;
    L7:
        return ((d) r100).f541971a;
    }
}
