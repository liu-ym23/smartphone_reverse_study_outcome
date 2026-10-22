package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaTypeAttributesKt {
    public static final JavaTypeAttributes toAttributes(TypeUsage r110, boolean r111, boolean r112, TypeParameterDescriptor r113) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r113 == null) goto L5;
        Set r114 = SetsKt.setOf(r113);
    L7:
        return new JavaTypeAttributes(r110, null, r112, r111, r114, null, 34, null);
    L5:
        r114 = null;
        goto L7
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage r100, boolean r101, boolean r102, TypeParameterDescriptor r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = null;
    L12:
        return toAttributes(r100, r101, r102, r103);
    }
}
