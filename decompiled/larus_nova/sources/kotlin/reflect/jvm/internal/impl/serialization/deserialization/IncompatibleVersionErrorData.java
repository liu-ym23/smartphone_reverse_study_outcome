package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes42.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T compilerVersion;
    private final T expectedVersion;
    private final String filePath;
    private final T languageVersion;

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IncompatibleVersionErrorData) == true) goto L8;
        return false;
    L8:
        IncompatibleVersionErrorData r101 = (IncompatibleVersionErrorData) r100;
        if (Intrinsics.areEqual(this.actualVersion, r101.actualVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.compilerVersion, r101.compilerVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.languageVersion, r101.languageVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expectedVersion, r101.expectedVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.classId, r101.classId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        T r100 = this.actualVersion;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        T r104 = this.compilerVersion;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        T r107 = this.languageVersion;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        T r110 = this.expectedVersion;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((((r109 + r101) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", compilerVersion=" + this.compilerVersion + ", languageVersion=" + this.languageVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }

    public IncompatibleVersionErrorData(T r100, T r101, T r102, T r103, String r104, ClassId r105) {
        Intrinsics.checkNotNullParameter(r104, "filePath");
        Intrinsics.checkNotNullParameter(r105, "classId");
        this.actualVersion = r100;
        this.compilerVersion = r101;
        this.languageVersion = r102;
        this.expectedVersion = r103;
        this.filePath = r104;
        this.classId = r105;
    }
}
