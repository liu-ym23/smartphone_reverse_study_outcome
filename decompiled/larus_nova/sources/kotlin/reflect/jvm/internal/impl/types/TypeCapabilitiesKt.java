package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeCapabilitiesKt {
    public static final CustomTypeParameter getCustomTypeParameter(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.unwrap();
        if ((r101 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r102 = (CustomTypeParameter) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.isTypeParameter() == true) goto L10;
        return null;
    L10:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean isCustomTypeParameter(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.unwrap();
        if ((r101 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r102 = (CustomTypeParameter) r101;
    L6:
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.isTypeParameter();
    L5:
        r102 = null;
        goto L6
    }
}
