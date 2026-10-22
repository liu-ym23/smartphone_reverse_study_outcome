package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = null;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r100) {
            this();
        }

        public final ReflectJavaType create(Type r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            boolean r101 = r100 instanceof Class;
            if (r101 == false) goto L8;
            Class r102 = (Class) r100;
            if (r102.isPrimitive() == false) goto L8;
            return new ReflectJavaPrimitiveType(r102);
        L8:
            if ((r100 instanceof GenericArrayType) == true) goto L17;
            if (r101 == false) goto L14;
            if (((Class) r100).isArray() == true) goto L17;
        L14:
            if ((r100 instanceof WildcardType) == false) goto L16;
            ReflectJavaType r103 = new ReflectJavaWildcardType((WildcardType) r100);
        L19:
            return r103;
        L16:
            r103 = new ReflectJavaClassifierType(r100);
        L17:
            r103 = new ReflectJavaArrayType(r100);
            goto L19
        }
    }

    static {
        Factory = new Factory(null);
    }

    public ReflectJavaType() {
    }

    public abstract Type getReflectType();

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ReflectJavaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) r100).getReflectType()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Iterator<T> r101 = getAnnotations().iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        ClassId r104 = ((JavaAnnotation) r103).getClassId();
        if (r104 == null) goto L9;
        r102 = r104.asSingleFqName();
    L9:
        if (Intrinsics.areEqual(r102, r100) == false) goto L3;
        r102 = r103;
    L12:
        return (JavaAnnotation) r102;
    }
}
