package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ModuleDependenciesImpl implements ModuleDependencies {
    private final List<ModuleDescriptorImpl> allDependencies;
    private final Set<ModuleDescriptorImpl> allExpectedByDependencies;
    private final List<ModuleDescriptorImpl> directExpectedByDependencies;
    private final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.allDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.directExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.modulesWhoseInternalsAreVisible;
    }

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> r100, Set<ModuleDescriptorImpl> r101, List<ModuleDescriptorImpl> r102, Set<ModuleDescriptorImpl> r103) {
        Intrinsics.checkNotNullParameter(r100, "allDependencies");
        Intrinsics.checkNotNullParameter(r101, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(r102, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(r103, "allExpectedByDependencies");
        this.allDependencies = r100;
        this.modulesWhoseInternalsAreVisible = r101;
        this.directExpectedByDependencies = r102;
        this.allExpectedByDependencies = r103;
    }
}
