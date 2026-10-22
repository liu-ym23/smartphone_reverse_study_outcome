package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes5.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public PropertyReference0Impl(KDeclarationContainer r100, String r101, String r102) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r100).getJClass(), r101, r102, !(r100 instanceof KClass) ? 1 : 0);
    }

    public PropertyReference0Impl(Class r100, String r101, String r102, int r110) {
        super(CallableReference.NO_RECEIVER, r100, r101, r102, r110);
    }

    public PropertyReference0Impl(Object r100, Class r101, String r102, String r103, int r104) {
        super(r100, r101, r102, r103, r104);
    }
}
