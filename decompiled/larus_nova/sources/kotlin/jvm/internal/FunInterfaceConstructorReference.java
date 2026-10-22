package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes41.dex */
public class FunInterfaceConstructorReference extends FunctionReference {
    private final Class funInterface;

    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return "fun interface ".concat(this.funInterface.getName());
    }

    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public FunInterfaceConstructorReference(Class r100) {
        super(1);
        this.funInterface = r100;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FunInterfaceConstructorReference) == true) goto L10;
        return false;
    L10:
        return this.funInterface.equals(((FunInterfaceConstructorReference) r100).funInterface);
    }
}
