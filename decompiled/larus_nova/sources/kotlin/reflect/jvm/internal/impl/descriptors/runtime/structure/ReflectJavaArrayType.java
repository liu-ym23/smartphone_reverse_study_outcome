package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final Collection<JavaAnnotation> annotations;
    private final ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    private final Type reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public /* bridge */ /* synthetic */ JavaType getComponentType() {
        return getComponentType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }

    public ReflectJavaArrayType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "reflectType");
        this.reflectType = r100;
        Type r101 = getReflectType();
        if ((r101 instanceof GenericArrayType) == false) goto L6;
        ReflectJavaType r102 = ReflectJavaType.Factory.create(((GenericArrayType) r101).getGenericComponentType());
    L10:
        this.componentType = r102;
        this.annotations = CollectionsKt.emptyList();
        return;
    L6:
        if ((r101 instanceof Class) == false) goto L13;
        Class r103 = (Class) r101;
        if (r103.isArray() == false) goto L13;
        r102 = ReflectJavaType.Factory.create(r103.getComponentType());
    L13:
        throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
    }
}
