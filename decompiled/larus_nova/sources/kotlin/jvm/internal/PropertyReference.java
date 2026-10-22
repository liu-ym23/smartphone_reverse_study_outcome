package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean syntheticJavaProperty;

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable compute() {
        if (this.syntheticJavaProperty == false) goto L6;
        return this;
    L6:
        return super.compute();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KProperty getReflected() {
        if (this.syntheticJavaProperty == true) goto L7;
        return (KProperty) super.getReflected();
    L7:
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable r100 = compute();
        if (r100 == this) goto L7;
        return r100.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public PropertyReference(Object r100) {
        super(r100);
        this.syntheticJavaProperty = false;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof PropertyReference) == false) goto L19;
        PropertyReference r101 = (PropertyReference) r100;
        if (getOwner().equals(r101.getOwner()) == true) goto L10;
    L16:
        return false;
    L10:
        if (getName().equals(r101.getName()) == false) goto L16;
        if (getSignature().equals(r101.getSignature()) == false) goto L16;
        if (Intrinsics.areEqual(getBoundReceiver(), r101.getBoundReceiver()) == false) goto L16;
        return true;
    L19:
        if ((r100 instanceof KProperty) == true) goto L21;
        return false;
    L21:
        return r100.equals(compute());
    }

    public PropertyReference(Object r110, Class r111, String r112, String r113, int r114) {
        boolean r100 = false;
        if ((r114 & 1) != 1) goto L5;
        boolean r101 = true;
    L6:
        super(r110, r111, r112, r113, r101);
        if ((r114 & 2) != 2) goto L9;
        r100 = true;
    L9:
        this.syntheticJavaProperty = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }
}
