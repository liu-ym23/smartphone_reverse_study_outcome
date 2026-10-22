package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeProjectionBase implements TypeProjection {
    public TypeProjectionBase() {
    }

    public int hashCode() {
        int r100 = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType()) == true) goto L11;
        int r101 = r100 * 31;
        if (isStarProjection() == false) goto L8;
        int r102 = 17;
    L10:
        return r101 + r102;
    L8:
        r102 = getType().hashCode();
        goto L10
    L11:
        return (r100 * 31) + 19;
    }

    public String toString() {
        if (isStarProjection() == false) goto L7;
        return "*";
    L7:
        if (getProjectionKind() != Variance.INVARIANT) goto L11;
        return getType().toString();
    L11:
        return getProjectionKind() + " " + getType();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TypeProjection) == true) goto L8;
        return false;
    L8:
        TypeProjection r101 = (TypeProjection) r100;
        if (isStarProjection() == r101.isStarProjection()) goto L12;
        return false;
    L12:
        if (getProjectionKind() == r101.getProjectionKind()) goto L15;
        return false;
    L15:
        if (getType().equals(r101.getType()) == true) goto L17;
        return false;
    L17:
        return true;
    }
}
