package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public abstract Member getMember();

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public ReflectJavaClass getContainingClass() {
        return new ReflectJavaClass(getMember().getDeclaringClass());
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        Member r100 = getMember();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        String r100 = getMember().getName();
        if (r100 == null) goto L7;
        Name r101 = Name.identifier(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return SpecialNames.NO_NAME_PROVIDED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        int r100 = getModifiers();
        if (Modifier.isPublic(r100) == false) goto L6;
        return Visibilities.Public.INSTANCE;
    L6:
        if (Modifier.isPrivate(r100) == false) goto L9;
        return Visibilities.Private.INSTANCE;
    L9:
        if (Modifier.isProtected(r100) == false) goto L15;
        if (Modifier.isStatic(r100) == false) goto L19;
        return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
    L19:
        return JavaVisibilities.ProtectedAndPackage.INSTANCE;
    L15:
        return JavaVisibilities.PackageVisibility.INSTANCE;
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public ReflectJavaMember() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public /* bridge */ /* synthetic */ JavaClass getContainingClass() {
        return getContainingClass();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ReflectJavaMember) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getMember(), ((ReflectJavaMember) r100).getMember()) == false) goto L7;
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

    public final List<JavaValueParameter> getValueParameters(Type[] r110, Annotation[][] r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "parameterTypes");
        Intrinsics.checkNotNullParameter(r111, "parameterAnnotations");
        ArrayList r100 = new ArrayList(r110.length);
        List<String> r101 = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (r101 == null) goto L5;
        int r102 = r101.size() - r110.length;
    L6:
        int r103 = r110.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L22;
        ReflectJavaType r105 = ReflectJavaType.Factory.create(r110[r104]);
        if (r101 == null) goto L15;
        String r106 = (String) CollectionsKt.getOrNull(r101, r104 + r102);
        if (r106 == null) goto L14;
    L16:
        if (r112 == true) goto L18;
    L20:
        boolean r107 = false;
    L21:
        r100.add(new ReflectJavaValueParameter(r105, r111[r104], r106, r107));
        r104 = r104 + 1;
        goto L7
    L18:
        if (r104 != ArraysKt.getLastIndex(r110)) goto L20;
        r107 = true;
        goto L21
    L14:
        throw new IllegalStateException(("No parameter with index " + r104 + '+' + r102 + " (name=" + getName() + " type=" + r105 + ") in " + this).toString());
    L15:
        r106 = null;
        goto L16
    L22:
        return r100;
    L5:
        r102 = 0;
        goto L6
    }
}
