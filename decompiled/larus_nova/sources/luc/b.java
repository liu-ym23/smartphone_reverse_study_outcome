package luc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import nuc.p2;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static final KClass<?> a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof c) == false) goto L6;
        return ((c) r100).f510845b;
    L6:
        if ((r100 instanceof p2) == true) goto L11;
        return null;
    L11:
        return a(((p2) r100).f520754a);
    }
}
