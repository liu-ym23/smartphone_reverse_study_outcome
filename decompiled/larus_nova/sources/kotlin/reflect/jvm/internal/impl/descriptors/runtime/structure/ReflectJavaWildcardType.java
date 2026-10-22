package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final Collection<JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final WildcardType reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public ReflectJavaType getBound() {
        Type[] r100 = getReflectType().getUpperBounds();
        Type[] r101 = getReflectType().getLowerBounds();
        if (r100.length > 1) goto L17;
        if (r101.length > 1) goto L17;
        if (r101.length != 1) goto L10;
        ReflectJavaType.Factory r102 = ReflectJavaType.Factory;
        Intrinsics.checkNotNull(r101);
        return r102.create((Type) ArraysKt.single(r101));
    L10:
        if (r100.length != 1) goto L15;
        Intrinsics.checkNotNull(r100);
        Type r103 = (Type) ArraysKt.single(r100);
        if (Intrinsics.areEqual(r103, Object.class) == true) goto L15;
        ReflectJavaType.Factory r104 = ReflectJavaType.Factory;
        Intrinsics.checkNotNull(r103);
        return r104.create(r103);
    L15:
        return null;
    L17:
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public /* bridge */ /* synthetic */ Type getReflectType() {
        return getReflectType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        return !Intrinsics.areEqual(ArraysKt.firstOrNull(getReflectType().getUpperBounds()), Object.class);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public /* bridge */ /* synthetic */ JavaType getBound() {
        return getBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public WildcardType getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaWildcardType(WildcardType r100) {
        Intrinsics.checkNotNullParameter(r100, "reflectType");
        this.reflectType = r100;
        this.annotations = CollectionsKt.emptyList();
    }
}
