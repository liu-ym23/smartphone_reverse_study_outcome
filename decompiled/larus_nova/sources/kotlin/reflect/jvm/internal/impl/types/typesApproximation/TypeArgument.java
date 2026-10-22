package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* JADX INFO: loaded from: classes42.dex */
final class TypeArgument {
    private final KotlinType inProjection;
    private final KotlinType outProjection;
    private final TypeParameterDescriptor typeParameter;

    public final boolean isConsistent() {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.inProjection, this.outProjection);
    }

    public final KotlinType getInProjection() {
        return this.inProjection;
    }

    public final KotlinType getOutProjection() {
        return this.outProjection;
    }

    public final TypeParameterDescriptor getTypeParameter() {
        return this.typeParameter;
    }

    public TypeArgument(TypeParameterDescriptor r100, KotlinType r101, KotlinType r102) {
        Intrinsics.checkNotNullParameter(r100, "typeParameter");
        Intrinsics.checkNotNullParameter(r101, "inProjection");
        Intrinsics.checkNotNullParameter(r102, "outProjection");
        this.typeParameter = r100;
        this.inProjection = r101;
        this.outProjection = r102;
    }
}
