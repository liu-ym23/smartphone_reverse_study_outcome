package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    private final KotlinBuiltIns builtIns;
    private final Map<ModuleCapability<?>, Object> capabilities;
    private ModuleDependencies dependencies;
    private boolean isValid;
    private PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    private final PackageViewDescriptorFactory packageViewDescriptorFactory;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    private final TargetPlatform platform;
    private final Name stableName;
    private final StorageManager storageManager;

    public ModuleDescriptorImpl(Name r110, StorageManager r111, KotlinBuiltIns r112, TargetPlatform r113) {
        Intrinsics.checkNotNullParameter(r110, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r111, "storageManager");
        Intrinsics.checkNotNullParameter(r112, "builtIns");
        this(r110, r111, r112, r113, null, null, 48, null);
    }

    public static /* synthetic */ PackageViewDescriptor accessor$ModuleDescriptorImpl$lambda0(ModuleDescriptorImpl r100, FqName r101) {
        return packages$lambda$0(r100, r101);
    }

    public static /* synthetic */ CompositePackageFragmentProvider accessor$ModuleDescriptorImpl$lambda1(ModuleDescriptorImpl r100) {
        return packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(r100);
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    private final boolean isInitialized() {
        if (this.packageFragmentProviderForModuleContent == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies r100 = this.dependencies;
        if (r100 == null) goto L7;
        return r100.getDirectExpectedByDependencies();
    L7:
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        if (isValid() == true) goto L5;
        r100.append(" !isValid");
    L5:
        r100.append(" packageFragmentProvider: ");
        PackageFragmentProvider r101 = this.packageFragmentProviderForModuleContent;
        if (r101 == null) goto L8;
        String r102 = r101.getClass().getSimpleName();
    L9:
        r100.append(r102);
        return r100.toString();
    L8:
        r102 = null;
        goto L9
    }

    private final String getId() {
        return getName().toString();
    }

    public void assertValid() {
        if (isValid() == true) goto L6;
        InvalidModuleExceptionKt.moduleInvalidated(this);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    public boolean isValid() {
        return this.isValid;
    }

    private static final CompositePackageFragmentProvider packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(ModuleDescriptorImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        ModuleDependencies r101 = r100.dependencies;
        if (r101 == null) goto L15;
        List<ModuleDescriptorImpl> r102 = r101.getAllDependencies();
        r100.assertValid();
        r102.contains(r100);
        List<ModuleDescriptorImpl> r103 = r102;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        ((ModuleDescriptorImpl) r104.next()).isInitialized();
        goto L6
    L8:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L13;
        PackageFragmentProvider r107 = ((ModuleDescriptorImpl) r106.next()).packageFragmentProviderForModuleContent;
        Intrinsics.checkNotNull(r107);
        r105.add(r107);
        goto L10
    L13:
        return new CompositePackageFragmentProvider(r105, "CompositeProvider@ModuleDescriptor for " + r100.getName());
    L15:
        throw new AssertionError("Dependencies of module " + r100.getId() + " were not set before querying module content");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(ModuleCapability<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "capability");
        T r101 = (T) this.capabilities.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        assertValid();
        return this.packages.invoke(r100);
    }

    public final void initialize(PackageFragmentProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = r100;
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptors");
        setDependencies(r100, SetsKt.emptySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "targetModule");
        if (Intrinsics.areEqual(this, r100) == false) goto L5;
        return true;
    L5:
        ModuleDependencies r101 = this.dependencies;
        Intrinsics.checkNotNull(r101);
        if (CollectionsKt.contains(r101.getModulesWhoseInternalsAreVisible(), r100) == false) goto L9;
        return true;
    L9:
        if (getExpectedByModules().contains(r100) == false) goto L12;
        return true;
    L12:
        if (r100.getExpectedByModules().contains(this) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final void setDependencies(ModuleDescriptorImpl... r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptors");
        setDependencies(ArraysKt.toList(r100));
    }

    public final void setDependencies(ModuleDependencies r100) {
        Intrinsics.checkNotNullParameter(r100, "dependencies");
        this.dependencies = r100;
    }

    private static final PackageViewDescriptor packages$lambda$0(ModuleDescriptorImpl r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "fqName");
        return r100.packageViewDescriptorFactory.compute(r100, r101, r100.storageManager);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r100, D r101) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName r100, Function1<? super Name, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Intrinsics.checkNotNullParameter(r101, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(r100, r101);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r100, Set<ModuleDescriptorImpl> r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptors");
        Intrinsics.checkNotNullParameter(r101, "friends");
        setDependencies(new ModuleDependenciesImpl(r100, r101, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }

    public ModuleDescriptorImpl(Name r100, StorageManager r101, KotlinBuiltIns r102, TargetPlatform r103, Map<ModuleCapability<?>, ? extends Object> r104, Name r105) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, "storageManager");
        Intrinsics.checkNotNullParameter(r102, "builtIns");
        Intrinsics.checkNotNullParameter(r104, "capabilities");
        super(Annotations.Companion.getEMPTY(), r100);
        this.storageManager = r101;
        this.builtIns = r102;
        this.platform = r103;
        this.stableName = r105;
        if (r100.isSpecial() == false) goto L10;
        this.capabilities = r104;
        PackageViewDescriptorFactory r106 = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
        if (r106 != null) goto L7;
        r106 = PackageViewDescriptorFactory.Default.INSTANCE;
    L7:
        this.packageViewDescriptorFactory = r106;
        this.isValid = true;
        this.packages = r101.createMemoizedFunction(new ModuleDescriptorImpl$$Lambda$0(this));
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new ModuleDescriptorImpl$$Lambda$1(this));
        return;
    L10:
        throw new IllegalArgumentException("Module name must be special: " + r100);
    }

    public /* synthetic */ ModuleDescriptorImpl(Name r110, StorageManager r111, KotlinBuiltIns r112, TargetPlatform r113, Map r114, Name r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        TargetPlatform r100 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r116 & 32) == 0) goto L13;
        Name r102 = null;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
