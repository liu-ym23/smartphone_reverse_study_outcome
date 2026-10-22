package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue empty$delegate;
    private final FqName fqName;
    private final NotNullLazyValue fragments$delegate;
    private final MemberScope memberScope;
    private final ModuleDescriptorImpl module;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "empty", "getEmpty()Z"))};
    }

    public static /* synthetic */ List accessor$LazyPackageViewDescriptorImpl$lambda0(LazyPackageViewDescriptorImpl r100) {
        return fragments_delegate$lambda$0(r100);
    }

    public static /* synthetic */ boolean accessor$LazyPackageViewDescriptorImpl$lambda1(LazyPackageViewDescriptorImpl r100) {
        return empty_delegate$lambda$1(r100);
    }

    public static /* synthetic */ MemberScope accessor$LazyPackageViewDescriptorImpl$lambda2(LazyPackageViewDescriptorImpl r100) {
        return memberScope$lambda$3(r100);
    }

    public final boolean getEmpty() {
        return ((Boolean) StorageKt.getValue(this.empty$delegate, this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.fragments$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot() == false) goto L6;
        return null;
    L6:
        return getModule().getPackage(getFqName().parent());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public /* bridge */ /* synthetic */ ModuleDescriptor getModule() {
        return getModule();
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }

    private static final boolean empty_delegate$lambda$1(LazyPackageViewDescriptorImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return PackageFragmentProviderKt.isEmpty(r100.getModule().getPackageFragmentProvider(), r100.getFqName());
    }

    private static final List fragments_delegate$lambda$0(LazyPackageViewDescriptorImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return PackageFragmentProviderKt.packageFragments(r100.getModule().getPackageFragmentProvider(), r100.getFqName());
    }

    private static final MemberScope memberScope$lambda$3(LazyPackageViewDescriptorImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r100.isEmpty() == true) goto L12;
        List<PackageFragmentDescriptor> r101 = r100.getFragments();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(((PackageFragmentDescriptor) r103.next()).getMemberScope());
        goto L7
    L9:
        List r104 = CollectionsKt.plus(r102, new SubpackagesScope(r100.getModule(), r100.getFqName()));
        return ChainedMemberScope.Companion.create("package view scope for " + r100.getFqName() + " in " + r100.getModule().getName(), r104);
    L12:
        return MemberScope.Empty.INSTANCE;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PackageViewDescriptor) == false) goto L5;
        PackageViewDescriptor r101 = (PackageViewDescriptor) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getFqName(), r101.getFqName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getModule(), r101.getModule()) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r100, D r101) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        return r100.visitPackageViewDescriptor(this, r101);
    }

    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl r100, FqName r101, StorageManager r102) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "fqName");
        Intrinsics.checkNotNullParameter(r102, "storageManager");
        super(Annotations.Companion.getEMPTY(), r101.shortNameOrSpecial());
        this.module = r100;
        this.fqName = r101;
        this.fragments$delegate = r102.createLazyValue(new LazyPackageViewDescriptorImpl$$Lambda$0(this));
        this.empty$delegate = r102.createLazyValue(new LazyPackageViewDescriptorImpl$$Lambda$1(this));
        this.memberScope = new LazyScopeAdapter(r102, new LazyPackageViewDescriptorImpl$$Lambda$2(this));
    }
}
