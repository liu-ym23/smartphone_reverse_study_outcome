package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes41.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    @Override // kotlin.reflect.KProperty2
    public Object get(Object r100, Object r101) {
        return getGetter().call(new Object[]{r100, r101});
    }

    public PropertyReference2Impl(KDeclarationContainer r100, String r101, String r102) {
        super(((ClassBasedDeclarationContainer) r100).getJClass(), r101, r102, !(r100 instanceof KClass) ? 1 : 0);
    }

    public PropertyReference2Impl(Class r100, String r101, String r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
