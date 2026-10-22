package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }

    public TypeParameterErasureOptions(boolean r100, boolean r101) {
        this.leaveNonTypeParameterTypes = r100;
        this.intersectUpperBounds = r101;
    }
}
