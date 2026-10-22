package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;
    private final int flags;

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.function(this);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    public int hashCode() {
        if (getOwner() != null) goto L5;
        int r100 = 0;
    L7:
        return ((r100 + getName().hashCode()) * 31) + getSignature().hashCode();
    L5:
        r100 = getOwner().hashCode() * 31;
        goto L7
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable r100 = compute();
        if (r100 == this) goto L7;
        return r100.toString();
    L7:
        if ("<init>".equals(getName()) == false) goto L10;
        return "constructor (Kotlin reflection is not available)";
    L10:
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public FunctionReference(int r100) {
        this(r100, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FunctionReference) == false) goto L23;
        FunctionReference r101 = (FunctionReference) r100;
        if (getName().equals(r101.getName()) == true) goto L10;
    L20:
        return false;
    L10:
        if (getSignature().equals(r101.getSignature()) == false) goto L20;
        if (this.flags != r101.flags) goto L20;
        if (this.arity != r101.arity) goto L20;
        if (Intrinsics.areEqual(getBoundReceiver(), r101.getBoundReceiver()) == false) goto L20;
        if (Intrinsics.areEqual(getOwner(), r101.getOwner()) == false) goto L20;
        return true;
    L23:
        if ((r100 instanceof KFunction) == true) goto L25;
        return false;
    L25:
        return r100.equals(compute());
    }

    public FunctionReference(int r100, Object r101) {
        this(r100, r101, null, null, null, 0);
    }

    public FunctionReference(int r100, Object r110, Class r111, String r112, String r113, int r114) {
        if ((r114 & 1) != 1) goto L5;
        boolean r101 = true;
    L6:
        super(r110, r111, r112, r113, r101);
        this.arity = r100;
        this.flags = r114 >> 1;
        return;
    L5:
        r101 = false;
        goto L6
    }
}
