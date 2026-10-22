package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes42.dex */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private static final ReadOnlyProperty annotationsAttribute$delegate = null;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(AnnotationsTypeAttributeKt.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};
        ReadOnlyProperty r100 = TypeAttributes.Companion.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = r100;
    }

    public static final Annotations getAnnotations(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AnnotationsTypeAttribute r101 = getAnnotationsAttribute(r100);
        if (r101 == null) goto L7;
        Annotations r102 = r101.getAnnotations();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return Annotations.Companion.getEMPTY();
    }

    public static final AnnotationsTypeAttribute getAnnotationsAttribute(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue(r100, $$delegatedProperties[0]);
    }
}
