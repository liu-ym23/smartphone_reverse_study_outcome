package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes41.dex */
public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public void set(Object r100) {
        getSetter().call(new Object[]{r100});
    }

    public MutablePropertyReference0Impl(KDeclarationContainer r100, String r101, String r102) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r100).getJClass(), r101, r102, !(r100 instanceof KClass) ? 1 : 0);
    }

    public MutablePropertyReference0Impl(Class r100, String r101, String r102, int r110) {
        super(CallableReference.NO_RECEIVER, r100, r101, r102, r110);
    }

    public MutablePropertyReference0Impl(Object r100, Class r101, String r102, String r103, int r104) {
        super(r100, r101, r102, r103, r104);
    }
}
