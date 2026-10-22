package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.alipay.sdk.m.p.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes42.dex */
final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE = null;

    static {
        INSTANCE = new SignatureSerializer();
    }

    private SignatureSerializer() {
    }

    public final String constructorDesc(Constructor<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "constructor");
        StringBuilder r101 = new StringBuilder("(");
        Iterator r102 = ArrayIteratorKt.iterator(r100.getParameterTypes());
    L4:
        if (r102.hasNext() == false) goto L6;
        Class r103 = (Class) r102.next();
        Intrinsics.checkNotNull(r103);
        r101.append(ReflectClassUtilKt.getDesc(r103));
        goto L4
    L6:
        r101.append(")V");
        return r101.toString();
    }

    public final String fieldDesc(Field r100) {
        Intrinsics.checkNotNullParameter(r100, "field");
        return ReflectClassUtilKt.getDesc(r100.getType());
    }

    public final String methodDesc(Method r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        StringBuilder r101 = new StringBuilder("(");
        Iterator r102 = ArrayIteratorKt.iterator(r100.getParameterTypes());
    L4:
        if (r102.hasNext() == false) goto L6;
        Class r103 = (Class) r102.next();
        Intrinsics.checkNotNull(r103);
        r101.append(ReflectClassUtilKt.getDesc(r103));
        goto L4
    L6:
        r101.append(")");
        r101.append(ReflectClassUtilKt.getDesc(r100.getReturnType()));
        return r101.toString();
    }
}
