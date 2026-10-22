package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    private final JavaClassifier classifier;
    private final Type reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public List<JavaType> getTypeArguments() {
        List<Type> r100 = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory r101 = ReflectJavaType.Factory;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r101.create((Type) r103.next()));
        goto L4
    L6:
        return r102;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        Type r100 = getReflectType();
        if ((r100 instanceof Class) == true) goto L5;
        return false;
    L5:
        if (((Class) r100).getTypeParameters().length != 0) goto L7;
        boolean r101 = true;
    L9:
        if ((!r101) == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        r101 = false;
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaClassifierType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "reflectType");
        this.reflectType = r100;
        Type r101 = getReflectType();
        if ((r101 instanceof Class) == false) goto L6;
        JavaClassifier r102 = new ReflectJavaClass((Class) r101);
    L11:
        this.classifier = r102;
        return;
    L6:
        if ((r101 instanceof TypeVariable) == false) goto L9;
        r102 = new ReflectJavaTypeParameter((TypeVariable) r101);
        goto L11
    L9:
        if ((r101 instanceof ParameterizedType) == false) goto L14;
        Type r103 = ((ParameterizedType) r101).getRawType();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.lang.Class<*>");
        r102 = new ReflectJavaClass((Class) r103);
        goto L11
    L14:
        throw new IllegalStateException("Not a classifier type (" + r101.getClass() + "): " + r101);
    }
}
