package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* JADX INFO: loaded from: classes42.dex */
public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers r100, NullabilityQualifierWithMigrationStatus r101, Collection r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.nullabilityQualifier;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.qualifierApplicabilityTypes;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.definitelyNotNull;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus r100, Collection<? extends AnnotationQualifierApplicabilityType> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r101, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JavaDefaultQualifiers) == true) goto L8;
        return false;
    L8:
        JavaDefaultQualifiers r101 = (JavaDefaultQualifiers) r100;
        if (Intrinsics.areEqual(this.nullabilityQualifier, r101.nullabilityQualifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.qualifierApplicabilityTypes, r101.qualifierApplicabilityTypes) == true) goto L15;
        return false;
    L15:
        if (this.definitelyNotNull == r101.definitelyNotNull) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31;
        if (this.definitelyNotNull == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", definitelyNotNull=" + this.definitelyNotNull + ')';
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r100, Collection<? extends AnnotationQualifierApplicabilityType> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r101, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = r100;
        this.qualifierApplicabilityTypes = r101;
        this.definitelyNotNull = r102;
    }

    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r100, Collection r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) != 0) goto L5;
    L8:
        this(r100, r101, r102);
        return;
    L5:
        if (r100.getQualifier() != NullabilityQualifier.NOT_NULL) goto L7;
        r102 = true;
        goto L8
    L7:
        r102 = false;
        goto L8
    }
}
