package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaTypeAttributes extends ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final JavaTypeFlexibility flexibility;
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final boolean isRaw;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes r100, TypeUsage r101, JavaTypeFlexibility r102, boolean r103, boolean r104, Set r105, SimpleType r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.howThisTypeIsUsed;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.flexibility;
    L8:
        JavaTypeFlexibility r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.isRaw;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isForAnnotationParameter;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.visitedTypeParameters;
    L17:
        Set r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.defaultType;
    L20:
        TypeUsage r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final JavaTypeAttributes copy(TypeUsage r100, JavaTypeFlexibility r110, boolean r111, boolean r112, Set<? extends TypeParameterDescriptor> r113, SimpleType r114) {
        Intrinsics.checkNotNullParameter(r100, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r110, "flexibility");
        return new JavaTypeAttributes(r100, r110, r111, r112, r113, r114);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public int hashCode() {
        SimpleType r100 = getDefaultType();
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 + ((r101 * 31) + getHowThisTypeIsUsed().hashCode());
        int r103 = r102 + ((r102 * 31) + this.flexibility.hashCode());
        int r104 = r103 + ((r103 * 31) + (this.isRaw ? 1 : 0));
        return r104 + ((r104 * 31) + (this.isForAnnotationParameter ? 1 : 0));
    L5:
        r101 = 0;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public boolean equals(Object r100) {
        if ((r100 instanceof JavaTypeAttributes) == true) goto L5;
        return false;
    L5:
        JavaTypeAttributes r101 = (JavaTypeAttributes) r100;
        if (Intrinsics.areEqual(r101.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r101.getHowThisTypeIsUsed() == getHowThisTypeIsUsed()) goto L10;
        return false;
    L10:
        if (r101.flexibility == this.flexibility) goto L12;
        return false;
    L12:
        if (r101.isRaw == this.isRaw) goto L14;
        return false;
    L14:
        if (r101.isForAnnotationParameter != this.isForAnnotationParameter) goto L21;
        return true;
    L21:
        return false;
    }

    public final JavaTypeAttributes markIsRaw(boolean r110) {
        return copy$default(this, null, null, r110, false, null, null, 59, null);
    }

    public JavaTypeAttributes withDefaultType(SimpleType r110) {
        return copy$default(this, null, null, false, false, null, r110, 31, null);
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility r110) {
        Intrinsics.checkNotNullParameter(r110, "flexibility");
        return copy$default(this, null, r110, false, false, null, null, 61, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r110) {
        Intrinsics.checkNotNullParameter(r110, "typeParameter");
        if (getVisitedTypeParameters() == null) goto L5;
        Set r111 = SetsKt.plus(getVisitedTypeParameters(), r110);
    L7:
        return copy$default(this, null, null, false, false, r111, null, 47, null);
    L5:
        r111 = SetsKt.setOf(r110);
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public /* bridge */ /* synthetic */ ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r100) {
        return withNewVisitedTypeParameter(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeAttributes(TypeUsage r100, JavaTypeFlexibility r101, boolean r102, boolean r103, Set<? extends TypeParameterDescriptor> r104, SimpleType r105) {
        Intrinsics.checkNotNullParameter(r100, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r101, "flexibility");
        super(r100, r104, r105);
        this.howThisTypeIsUsed = r100;
        this.flexibility = r101;
        this.isRaw = r102;
        this.isForAnnotationParameter = r103;
        this.visitedTypeParameters = r104;
        this.defaultType = r105;
    }

    public /* synthetic */ JavaTypeAttributes(TypeUsage r100, JavaTypeFlexibility r101, boolean r110, boolean r111, Set r112, SimpleType r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        r101 = JavaTypeFlexibility.INFLEXIBLE;
    L5:
        JavaTypeFlexibility r102 = r101;
        if ((r114 & 4) == 0) goto L8;
        boolean r103 = false;
    L10:
        if ((r114 & 8) == 0) goto L12;
        boolean r104 = false;
    L14:
        if ((r114 & 16) == 0) goto L16;
        Set r105 = null;
    L18:
        if ((r114 & 32) == 0) goto L20;
        SimpleType r106 = null;
    L21:
        this(r100, r102, r103, r104, r105, r106);
        return;
    L20:
        r106 = r113;
        goto L21
    L16:
        r105 = r112;
        goto L18
    L12:
        r104 = r111;
        goto L14
    L8:
        r103 = r110;
        goto L10
    }
}
