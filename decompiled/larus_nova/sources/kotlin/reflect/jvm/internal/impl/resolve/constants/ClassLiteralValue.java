package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes42.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final ClassId classId;

    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClassLiteralValue) == true) goto L8;
        return false;
    L8:
        ClassLiteralValue r101 = (ClassLiteralValue) r100;
        if (Intrinsics.areEqual(this.classId, r101.classId) == true) goto L12;
        return false;
    L12:
        if (this.arrayNestedness == r101.arrayNestedness) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.arrayNestedness;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r100.append("kotlin/Array<");
        r103 = r103 + 1;
        goto L3
    L5:
        r100.append(this.classId);
        int r104 = this.arrayNestedness;
    L6:
        if (r102 >= r104) goto L9;
        r100.append(">");
        r102 = r102 + 1;
        goto L6
    L9:
        return r100.toString();
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public ClassLiteralValue(ClassId r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "classId");
        this.classId = r100;
        this.arrayNestedness = r101;
    }
}
