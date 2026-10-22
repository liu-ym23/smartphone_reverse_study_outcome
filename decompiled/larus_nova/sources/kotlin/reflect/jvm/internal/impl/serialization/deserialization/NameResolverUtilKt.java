package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ClassId.Companion.fromString(r100.getQualifiedClassName(r101), r100.isLocalClassName(r101));
    }

    public static final Name getName(NameResolver r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Name.guessByFirstCharacter(r100.getString(r101));
    }
}
