package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        KCallable r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public PropertyReference(Object r1) {
        super(r1);
        this.syntheticJavaProperty = false;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PropertyReference) == false) goto L19;
        PropertyReference r6 = (PropertyReference) r5;
        if (getOwner().equals(r6.getOwner()) == true) goto L10;
    L16:
        return false;
    L10:
        if (getName().equals(r6.getName()) == false) goto L16;
        if (getSignature().equals(r6.getSignature()) == false) goto L16;
        if (Intrinsics.areEqual(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L16;
        return true;
    L19:
        if ((r5 instanceof KProperty) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    public PropertyReference(Object r10, Class r11, String r12, String r13, int r14) {
        boolean r1 = false;
        if ((r14 & 1) != 1) goto L5;
        boolean r8 = true;
    L6:
        super(r10, r11, r12, r13, r8);
        if ((r14 & 2) != 2) goto L9;
        r1 = true;
    L9:
        this.syntheticJavaProperty = r1;
        return;
    L5:
        r8 = false;
        goto L6
    }
}
