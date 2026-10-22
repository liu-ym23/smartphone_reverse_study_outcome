package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> r100) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_INNER);
        this.inner = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(ClassDescriptor r100, LazyJavaResolverContext r101) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "c");
        List<SyntheticJavaPartsProvider> r102 = this.inner;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        CollectionsKt.addAll(r103, ((SyntheticJavaPartsProvider) r104.next()).getMethodNames(r100, r101));
        goto L4
    L6:
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getNestedClassNames(ClassDescriptor r100, LazyJavaResolverContext r101) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "c");
        List<SyntheticJavaPartsProvider> r102 = this.inner;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        CollectionsKt.addAll(r103, ((SyntheticJavaPartsProvider) r104.next()).getNestedClassNames(r100, r101));
        goto L4
    L6:
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(ClassDescriptor r100, LazyJavaResolverContext r101) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "c");
        List<SyntheticJavaPartsProvider> r102 = this.inner;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        CollectionsKt.addAll(r103, ((SyntheticJavaPartsProvider) r104.next()).getStaticFunctionNames(r100, r101));
        goto L4
    L6:
        return r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(ClassDescriptor r100, List<ClassConstructorDescriptor> r101, LazyJavaResolverContext r102) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "c");
        Iterator<T> r103 = this.inner.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r103.next()).generateConstructors(r100, r101, r102);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public PropertyDescriptorImpl modifyField(ClassDescriptor r100, PropertyDescriptorImpl r101, LazyJavaResolverContext r102) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "propertyDescriptor");
        Intrinsics.checkNotNullParameter(r102, "c");
        Iterator<T> r103 = this.inner.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r101 = ((SyntheticJavaPartsProvider) r103.next()).modifyField(r100, r101, r102);
        goto L4
    L6:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(ClassDescriptor r100, Name r101, Collection<SimpleFunctionDescriptor> r102, LazyJavaResolverContext r103) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r103, "c");
        Iterator<T> r104 = this.inner.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r104.next()).generateMethods(r100, r101, r102, r103);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateNestedClass(ClassDescriptor r100, Name r101, List<ClassDescriptor> r102, LazyJavaResolverContext r103) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r103, "c");
        Iterator<T> r104 = this.inner.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r104.next()).generateNestedClass(r100, r101, r102, r103);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(ClassDescriptor r100, Name r101, Collection<SimpleFunctionDescriptor> r102, LazyJavaResolverContext r103) {
        Intrinsics.checkNotNullParameter(r100, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r103, "c");
        Iterator<T> r104 = this.inner.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r104.next()).generateStaticFunctions(r100, r101, r102, r103);
        goto L4
    }
}
