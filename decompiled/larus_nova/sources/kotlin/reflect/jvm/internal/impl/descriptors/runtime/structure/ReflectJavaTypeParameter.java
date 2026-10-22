package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    private final TypeVariable<?> typeVariable;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        TypeVariable<?> r100 = this.typeVariable;
        if ((r100 instanceof AnnotatedElement) == true) goto L7;
        return null;
    L7:
        return (AnnotatedElement) r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        return Name.identifier(this.typeVariable.getName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] r100 = this.typeVariable.getBounds();
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(new ReflectJavaClassifierType(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L5:
        ReflectJavaClassifierType r104 = (ReflectJavaClassifierType) CollectionsKt.singleOrNull(r101);
        if (r104 == null) goto L8;
        Type r105 = r104.getReflectType();
    L10:
        if (Intrinsics.areEqual(r105, Object.class) == true) goto L12;
        return r101;
    L12:
        return CollectionsKt.emptyList();
    L8:
        r105 = null;
        goto L10
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    public String toString() {
        return ReflectJavaTypeParameter.class.getName() + ": " + this.typeVariable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        AnnotatedElement r100 = getElement();
        if (r100 == null) goto L9;
        Annotation[] r101 = r100.getDeclaredAnnotations();
        if (r101 == null) goto L9;
        List<ReflectJavaAnnotation> r102 = ReflectJavaAnnotationOwnerKt.getAnnotations(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return getUpperBounds();
    }

    public ReflectJavaTypeParameter(TypeVariable<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "typeVariable");
        this.typeVariable = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ReflectJavaTypeParameter) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter) r100).typeVariable) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        AnnotatedElement r101 = getElement();
        if (r101 == null) goto L7;
        Annotation[] r102 = r101.getDeclaredAnnotations();
        if (r102 == null) goto L7;
        return ReflectJavaAnnotationOwnerKt.findAnnotation(r102, r100);
    L7:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r100) {
        return findAnnotation(r100);
    }
}
