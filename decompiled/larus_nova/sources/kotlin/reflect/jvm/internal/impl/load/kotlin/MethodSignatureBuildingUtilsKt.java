package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents r100, ClassDescriptor r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "classDescriptor");
        Intrinsics.checkNotNullParameter(r102, "jvmDescriptor");
        return r100.signature(MethodSignatureMappingKt.getInternalName(r101), r102);
    }
}
