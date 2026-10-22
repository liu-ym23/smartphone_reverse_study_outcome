package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    private final Collection<PackageFragmentDescriptor> packageFragments;

    public static /* synthetic */ FqName accessor$PackageFragmentProviderImpl$lambda0(PackageFragmentDescriptor r100) {
        return getSubPackagesOf$lambda$3(r100);
    }

    public static /* synthetic */ boolean accessor$PackageFragmentProviderImpl$lambda1(FqName r100, FqName r101) {
        return getSubPackagesOf$lambda$4(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> r100) {
        Intrinsics.checkNotNullParameter(r100, "packageFragments");
        this.packageFragments = r100;
    }

    private static final FqName getSubPackagesOf$lambda$3(PackageFragmentDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Collection<PackageFragmentDescriptor> r101 = this.packageFragments;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r104).getFqName(), r100) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Collection<PackageFragmentDescriptor> r101 = this.packageFragments;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r102.next()).getFqName(), r100) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }

    private static final boolean getSubPackagesOf$lambda$4(FqName r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "$fqName");
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.isRoot() == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101.parent(), r100) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r100, Collection<PackageFragmentDescriptor> r101) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Intrinsics.checkNotNullParameter(r101, "packageFragments");
        Iterator<T> r102 = this.packageFragments.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r103).getFqName(), r100) == false) goto L4;
        r101.add(r103);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(final FqName r100, Function1<? super Name, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Intrinsics.checkNotNullParameter(r101, "nameFilter");
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(this.packageFragments), PackageFragmentProviderImpl$$Lambda$0.INSTANCE), new PackageFragmentProviderImpl$$Lambda$1(r100)));
    }
}
