package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes42.dex */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {
    FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r100);

    PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r100);

    PrimitiveType getPrimitiveType(TypeConstructorMarker r100);

    KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r100);

    KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r100);

    boolean hasAnnotation(KotlinTypeMarker r100, FqName r101);

    boolean isInlineClass(TypeConstructorMarker r100);

    boolean isUnderKotlinPackage(TypeConstructorMarker r100);

    KotlinTypeMarker makeNullable(KotlinTypeMarker r100);
}
