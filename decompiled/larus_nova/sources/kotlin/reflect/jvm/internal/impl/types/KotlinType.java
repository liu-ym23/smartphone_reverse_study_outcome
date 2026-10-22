package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KotlinType implements Annotated, KotlinTypeMarker {
    private int cachedHashCode;

    private KotlinType() {
    }

    public /* synthetic */ KotlinType(DefaultConstructorMarker r100) {
        this();
    }

    public abstract List<TypeProjection> getArguments();

    public abstract TypeAttributes getAttributes();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope getMemberScope();

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner r100);

    public abstract UnwrappedType unwrap();

    public final int hashCode() {
        int r100 = this.cachedHashCode;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = computeHashCode();
        this.cachedHashCode = r101;
        return r101;
    }

    private final int computeHashCode() {
        if (KotlinTypeKt.isError(this) == false) goto L7;
        return super.hashCode();
    L7:
        return (((getConstructor().hashCode() * 31) + getArguments().hashCode()) * 31) + (isMarkedNullable() ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return AnnotationsTypeAttributeKt.getAnnotations(getAttributes());
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KotlinType) == true) goto L8;
        return false;
    L8:
        KotlinType r101 = (KotlinType) r100;
        if (isMarkedNullable() == r101.isMarkedNullable()) goto L11;
    L13:
        return false;
    L11:
        if (StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(unwrap(), r101.unwrap()) == false) goto L13;
        return true;
    }
}
