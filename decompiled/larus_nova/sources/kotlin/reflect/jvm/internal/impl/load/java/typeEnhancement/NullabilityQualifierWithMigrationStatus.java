package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    private final NullabilityQualifier qualifier;

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus r100, NullabilityQualifier r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.qualifier;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isForWarningOnly;
    L9:
        return r100.copy(r101, r102);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NullabilityQualifierWithMigrationStatus) == true) goto L8;
        return false;
    L8:
        NullabilityQualifierWithMigrationStatus r101 = (NullabilityQualifierWithMigrationStatus) r100;
        if (this.qualifier == r101.qualifier) goto L12;
        return false;
    L12:
        if (this.isForWarningOnly == r101.isForWarningOnly) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.qualifier.hashCode() * 31;
        if (this.isForWarningOnly == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.qualifier + ", isForWarningOnly=" + this.isForWarningOnly + ')';
    }

    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "qualifier");
        this.qualifier = r100;
        this.isForWarningOnly = r101;
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
