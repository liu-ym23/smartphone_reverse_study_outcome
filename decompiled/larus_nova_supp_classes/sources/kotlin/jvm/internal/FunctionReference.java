package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        int r0 = 0;
    L7:
        return ((r0 + getName().hashCode()) * 31) + getSignature().hashCode();
    L5:
        r0 = getOwner().hashCode() * 31;
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
        KCallable r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
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

    public FunctionReference(int r8) {
        this(r8, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionReference) == false) goto L23;
        FunctionReference r6 = (FunctionReference) r5;
        if (getName().equals(r6.getName()) == true) goto L10;
    L20:
        return false;
    L10:
        if (getSignature().equals(r6.getSignature()) == false) goto L20;
        if (this.flags != r6.flags) goto L20;
        if (this.arity != r6.arity) goto L20;
        if (Intrinsics.areEqual(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L20;
        if (Intrinsics.areEqual(getOwner(), r6.getOwner()) == false) goto L20;
        return true;
    L23:
        if ((r5 instanceof KFunction) == true) goto L25;
        return false;
    L25:
        return r5.equals(compute());
    }

    public FunctionReference(int r8, Object r9) {
        this(r8, r9, null, null, null, 0);
    }

    public FunctionReference(int r9, Object r10, Class r11, String r12, String r13, int r14) {
        if ((r14 & 1) != 1) goto L5;
        boolean r7 = true;
    L6:
        super(r10, r11, r12, r13, r7);
        this.arity = r9;
        this.flags = r14 >> 1;
        return;
    L5:
        r7 = false;
        goto L6
    }
}
