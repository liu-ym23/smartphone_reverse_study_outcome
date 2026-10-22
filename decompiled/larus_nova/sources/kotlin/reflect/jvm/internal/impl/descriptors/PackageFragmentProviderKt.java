package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public final class PackageFragmentProviderKt {
    public static final boolean isEmpty(PackageFragmentProvider r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fqName");
        if ((r100 instanceof PackageFragmentProviderOptimized) == false) goto L6;
        return ((PackageFragmentProviderOptimized) r100).isEmpty(r101);
    L6:
        return packageFragments(r100, r101).isEmpty();
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fqName");
        ArrayList r102 = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(r100, r101, r102);
        return r102;
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider r100, FqName r101, Collection<PackageFragmentDescriptor> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fqName");
        Intrinsics.checkNotNullParameter(r102, "packageFragments");
        if ((r100 instanceof PackageFragmentProviderOptimized) == false) goto L5;
        ((PackageFragmentProviderOptimized) r100).collectPackageFragments(r101, r102);
        return;
    L5:
        r102.addAll(r100.getPackageFragments(r101));
    }
}
