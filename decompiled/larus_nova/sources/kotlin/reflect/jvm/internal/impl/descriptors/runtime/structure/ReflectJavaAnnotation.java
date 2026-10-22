package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements JavaAnnotation {

    /* JADX INFO: renamed from: annotation, reason: collision with root package name */
    private final Annotation f504568annotation;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isIdeExternalAnnotation() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public Collection<JavaAnnotationArgument> getArguments() {
        Method[] r100 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.f504568annotation)).getDeclaredMethods();
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Method r104 = r100[r103];
        r101.add(ReflectJavaAnnotationArgument.Factory.create(r104.invoke(this.f504568annotation, new Object[0]), Name.identifier(r104.getName())));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.f504568annotation)));
    }

    public int hashCode() {
        return System.identityHashCode(this.f504568annotation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.f504568annotation)));
    }

    public String toString() {
        return ReflectJavaAnnotation.class.getName() + ": " + this.f504568annotation;
    }

    public final Annotation getAnnotation() {
        return this.f504568annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public /* bridge */ /* synthetic */ JavaClass resolve() {
        return resolve();
    }

    public ReflectJavaAnnotation(Annotation r100) {
        Intrinsics.checkNotNullParameter(r100, "annotation");
        this.f504568annotation = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ReflectJavaAnnotation) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f504568annotation != ((ReflectJavaAnnotation) r100).f504568annotation) goto L7;
        return true;
    }
}
