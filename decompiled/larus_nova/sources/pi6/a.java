package pi6;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final <T1, T2, R> R a(T1 r100, T2 r101, Function2<? super T1, ? super T2, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r102, "block");
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        return r102.invoke(r100, r101);
    L6:
        return null;
    }
}
