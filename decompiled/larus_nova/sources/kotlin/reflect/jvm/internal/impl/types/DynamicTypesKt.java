package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.unwrap() instanceof DynamicType;
    }
}
