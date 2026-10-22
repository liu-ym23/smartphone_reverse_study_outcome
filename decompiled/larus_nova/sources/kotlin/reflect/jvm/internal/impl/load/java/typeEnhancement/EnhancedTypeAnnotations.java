package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
final class EnhancedTypeAnnotations implements Annotations {
    private final FqName fqNameToMatch;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt.emptyList().iterator();
    }

    public EnhancedTypeAnnotations(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqNameToMatch");
        this.fqNameToMatch = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public EnhancedTypeAnnotationDescriptor mo10727findAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        if (Intrinsics.areEqual(r100, this.fqNameToMatch) == true) goto L7;
        return null;
    L7:
        return EnhancedTypeAnnotationDescriptor.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r100) {
        return Annotations.DefaultImpls.hasAnnotation(this, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public /* bridge */ /* synthetic */ AnnotationDescriptor mo10727findAnnotation(FqName r100) {
        return mo10727findAnnotation(r100);
    }
}
