package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final String debugName;
    private final List<PackageFragmentProvider> providers;

    public String toString() {
        return this.debugName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        ArrayList r101 = new ArrayList();
        Iterator<PackageFragmentProvider> r102 = this.providers.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r102.next(), r100, r101);
        goto L4
    L7:
        return CollectionsKt.toList(r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        List<PackageFragmentProvider> r101 = this.providers;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (PackageFragmentProviderKt.isEmpty((PackageFragmentProvider) r102.next(), r100) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "providers");
        Intrinsics.checkNotNullParameter(r101, "debugName");
        this.providers = r100;
        this.debugName = r101;
        r100.size();
        CollectionsKt.toSet(r100).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r100, Collection<PackageFragmentDescriptor> r101) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Intrinsics.checkNotNullParameter(r101, "packageFragments");
        Iterator<PackageFragmentProvider> r102 = this.providers.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r102.next(), r100, r101);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r100, Function1<? super Name, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Intrinsics.checkNotNullParameter(r101, "nameFilter");
        HashSet r102 = new HashSet();
        Iterator<PackageFragmentProvider> r103 = this.providers.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.addAll(r103.next().getSubPackagesOf(r100, r101));
        goto L4
    L6:
        return r102;
    }
}
