package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public final class FilteredAnnotations implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        Annotations r100 = this.delegate;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<AnnotationDescriptor> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L6;
        if (shouldBeReturned(r101.next()) == false) goto L9;
        boolean r102 = true;
    L14:
        if (this.isDefinitelyNewInference == false) goto L19;
        if (r102 == false) goto L24;
        return false;
    L24:
        return true;
    L19:
        return r102;
    L6:
        r102 = false;
        goto L14
    L5:
        if (((Collection) r100).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations r100 = this.delegate;
        ArrayList r101 = new ArrayList();
        Iterator<AnnotationDescriptor> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        AnnotationDescriptor r103 = r102.next();
        if (shouldBeReturned(r103) == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return r101.iterator();
    }

    private final boolean shouldBeReturned(AnnotationDescriptor r100) {
        FqName r101 = r100.getFqName();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.fqNameFilter.invoke(r101).booleanValue() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo10727findAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        if (this.fqNameFilter.invoke(r100).booleanValue() == true) goto L7;
        return null;
    L7:
        return this.delegate.mo10727findAnnotation(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        if (this.fqNameFilter.invoke(r100).booleanValue() == true) goto L7;
        return false;
    L7:
        return this.delegate.hasAnnotation(r100);
    }

    public FilteredAnnotations(Annotations r100, Function1<? super FqName, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "fqNameFilter");
        this(r100, false, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(Annotations r100, boolean r101, Function1<? super FqName, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r102, "fqNameFilter");
        this.delegate = r100;
        this.isDefinitelyNewInference = r101;
        this.fqNameFilter = r102;
    }
}
