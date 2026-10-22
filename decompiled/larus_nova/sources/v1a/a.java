package v1a;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean a(Field r100, KClass<?>... r101) {
        if (r101.length <= 0) goto L9;
        KClass<?> r102 = r101[0];
        Class<?> r103 = r100.getType();
        if ((r103 instanceof ParameterizedType) == false) goto L8;
        Class r104 = JvmClassMappingKt.getJavaClass(r102);
        Type r105 = ((ParameterizedType) r103).getRawType();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.lang.Class<*>");
        return r104.isAssignableFrom((Class) r105);
    L8:
        return JvmClassMappingKt.getJavaClass(r102).isAssignableFrom(r103);
    L9:
        return false;
    }
}
