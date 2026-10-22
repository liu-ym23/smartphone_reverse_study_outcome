package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public int hashCode() {
        SimpleType r100 = getDefaultType();
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return r101 + ((r101 * 31) + getHowThisTypeIsUsed().hashCode());
    L5:
        r101 = 0;
        goto L7
    }

    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ErasureTypeAttributes) == true) goto L5;
        return false;
    L5:
        ErasureTypeAttributes r101 = (ErasureTypeAttributes) r100;
        if (Intrinsics.areEqual(r101.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r101.getHowThisTypeIsUsed() != getHowThisTypeIsUsed()) goto L12;
        return true;
    L12:
        return false;
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "typeParameter");
        TypeUsage r101 = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> r102 = getVisitedTypeParameters();
        if (r102 == null) goto L6;
        Set r103 = SetsKt.plus(r102, r100);
        if (r103 == null) goto L6;
    L8:
        return new ErasureTypeAttributes(r101, r103, getDefaultType());
    L6:
        r103 = SetsKt.setOf(r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage r100, Set<? extends TypeParameterDescriptor> r101, SimpleType r102) {
        Intrinsics.checkNotNullParameter(r100, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = r100;
        this.visitedTypeParameters = r101;
        this.defaultType = r102;
    }
}
