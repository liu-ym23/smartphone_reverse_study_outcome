package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getModality() == Modality.FINAL) goto L5;
    L7:
        return false;
    L5:
        if (r100.getKind() == ClassKind.ENUM_CLASS) goto L7;
        return true;
    }
}
