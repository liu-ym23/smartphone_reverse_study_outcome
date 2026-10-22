package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    public static /* synthetic */ AnnotationDescriptor accessor$CompositeAnnotations$lambda0(FqName r100, Annotations r101) {
        return findAnnotation$lambda$2(r100, r101);
    }

    public static /* synthetic */ Sequence accessor$CompositeAnnotations$lambda1(Annotations r100) {
        return iterator$lambda$4(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> r100 = this.delegates;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((Annotations) r101.next()).isEmpty() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.delegates), CompositeAnnotations$$Lambda$1.INSTANCE).iterator();
    }

    public CompositeAnnotations(Annotations... r100) {
        Intrinsics.checkNotNullParameter(r100, "delegates");
        this(ArraysKt.toList(r100));
    }

    private static final Sequence iterator$lambda$4(Annotations r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return CollectionsKt.asSequence(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo10727findAnnotation(final FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.delegates), new CompositeAnnotations$$Lambda$0(r100)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Iterator r101 = CollectionsKt.asSequence(this.delegates).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (((Annotations) r101.next()).hasAnnotation(r100) == false) goto L4;
        return true;
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> r100) {
        Intrinsics.checkNotNullParameter(r100, "delegates");
        this.delegates = r100;
    }

    private static final AnnotationDescriptor findAnnotation$lambda$2(FqName r100, Annotations r101) {
        Intrinsics.checkNotNullParameter(r100, "$fqName");
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.mo10727findAnnotation(r100);
    }
}
