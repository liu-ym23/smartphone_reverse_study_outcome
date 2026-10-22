package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int r100, KDeclarationContainer r101, String r110, String r111) {
        super(r100, CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r101).getJClass(), r110, r111, !(r101 instanceof KClass) ? 1 : 0);
    }

    public FunctionReferenceImpl(int r100, Class r101, String r110, String r111, int r112) {
        super(r100, CallableReference.NO_RECEIVER, r101, r110, r111, r112);
    }

    public FunctionReferenceImpl(int r100, Object r101, Class r102, String r103, String r104, int r105) {
        super(r100, r101, r102, r103, r104, r105);
    }
}
