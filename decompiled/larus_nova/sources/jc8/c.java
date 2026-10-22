package jc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {
    public static final <V extends l, T extends a> V a(b<T> r100, Class<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        k r102 = r100.f498153a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return (V) r102.a(r101);
    }
}
