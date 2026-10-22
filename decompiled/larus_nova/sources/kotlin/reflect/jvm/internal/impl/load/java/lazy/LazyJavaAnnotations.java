package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class LazyJavaAnnotations implements Annotations {
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    private final JavaAnnotationOwner annotationOwner;
    private final boolean areAnnotationsFreshlySupported;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f504570c;

    public static /* synthetic */ AnnotationDescriptor accessor$LazyJavaAnnotations$lambda0(LazyJavaAnnotations r100, JavaAnnotation r101) {
        return annotationDescriptors$lambda$0(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        if (this.annotationOwner.getAnnotations().isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.annotationOwner.isDeprecatedInJavaDoc() == true) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.f504570c))).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo10727findAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        JavaAnnotation r101 = this.annotationOwner.findAnnotation(r100);
        if (r101 == null) goto L7;
        AnnotationDescriptor r102 = this.annotationDescriptors.invoke(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(r100, this.annotationOwner, this.f504570c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r100) {
        return Annotations.DefaultImpls.hasAnnotation(this, r100);
    }

    private static final AnnotationDescriptor annotationDescriptors$lambda$0(LazyJavaAnnotations r100, JavaAnnotation r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "annotation");
        return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(r101, r100.f504570c, r100.areAnnotationsFreshlySupported);
    }

    public LazyJavaAnnotations(LazyJavaResolverContext r100, JavaAnnotationOwner r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "annotationOwner");
        this.f504570c = r100;
        this.annotationOwner = r101;
        this.areAnnotationsFreshlySupported = r102;
        this.annotationDescriptors = r100.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$$Lambda$0(this));
    }

    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext r100, JavaAnnotationOwner r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }
}
