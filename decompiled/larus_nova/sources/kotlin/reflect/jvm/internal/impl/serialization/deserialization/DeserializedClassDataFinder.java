package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes5.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "packageFragmentProvider");
        this.packageFragmentProvider = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r100) {
        Intrinsics.checkNotNullParameter(r100, "classId");
        Iterator<PackageFragmentDescriptor> r101 = PackageFragmentProviderKt.packageFragments(this.packageFragmentProvider, r100.getPackageFqName()).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        PackageFragmentDescriptor r102 = r101.next();
        if ((r102 instanceof DeserializedPackageFragment) == false) goto L4;
        ClassData r103 = ((DeserializedPackageFragment) r102).getClassDataFinder().findClassData(r100);
        if (r103 == null) goto L4;
        return r103;
    L10:
        return null;
    }
}
