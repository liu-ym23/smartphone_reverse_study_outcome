package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(TypeComponentPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 == TypeComponentPosition.INFLEXIBLE) goto L5;
        return true;
    L5:
        return false;
    }
}
