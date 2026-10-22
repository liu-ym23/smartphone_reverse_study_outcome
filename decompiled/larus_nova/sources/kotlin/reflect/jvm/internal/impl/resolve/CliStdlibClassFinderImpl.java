package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* JADX INFO: loaded from: classes42.dex */
final class CliStdlibClassFinderImpl implements StdlibClassFinder {
    public static final CliStdlibClassFinderImpl INSTANCE = null;

    static {
        INSTANCE = new CliStdlibClassFinderImpl();
    }

    private CliStdlibClassFinderImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder
    public ClassDescriptor findEnumEntriesClass(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleDescriptor");
        return FindClassInModuleKt.findClassAcrossModuleDependencies(r100, StandardClassIds.INSTANCE.getEnumEntries());
    }
}
