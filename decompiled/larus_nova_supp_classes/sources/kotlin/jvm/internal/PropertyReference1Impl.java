package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    @Override // kotlin.reflect.KProperty1
    public Object get(Object r4) {
        return mo165getGetter().call(new Object[]{r4});
    }

    public PropertyReference1Impl(KDeclarationContainer r7, String r8, String r9) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r7).getJClass(), r8, r9, !(r7 instanceof KClass) ? 1 : 0);
    }

    public PropertyReference1Impl(Class r7, String r8, String r9, int r10) {
        super(CallableReference.NO_RECEIVER, r7, r8, r9, r10);
    }

    public PropertyReference1Impl(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }
}
