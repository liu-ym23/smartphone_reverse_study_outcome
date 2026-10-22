package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;

/* JADX INFO: loaded from: classes5.dex */
public class SubpackagesScope extends MemberScopeImpl {
    private final FqName fqName;
    private final ModuleDescriptor moduleDescriptor;

    public String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    public final PackageViewDescriptor getPackage(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r100.isSpecial() == false) goto L5;
        return null;
    L5:
        PackageViewDescriptor r101 = this.moduleDescriptor.getPackage(this.fqName.child(r100));
        if (r101.isEmpty() == false) goto L8;
        return null;
    L8:
        return r101;
    }

    public SubpackagesScope(ModuleDescriptor r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r101, "fqName");
        this.moduleDescriptor = r100;
        this.fqName = r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r100, Function1<? super Name, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "kindFilter");
        Intrinsics.checkNotNullParameter(r101, "nameFilter");
        if (r100.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (this.fqName.isRoot() == true) goto L9;
    L12:
        Collection<FqName> r102 = this.moduleDescriptor.getSubPackagesOf(this.fqName, r101);
        ArrayList r103 = new ArrayList(r102.size());
        Iterator<FqName> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L18;
        Name r105 = r104.next().shortName();
        if (r101.invoke(r105).booleanValue() == false) goto L14;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r103, getPackage(r105));
        goto L14
    L18:
        return r103;
    L9:
        if (r100.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE) == false) goto L12;
        return CollectionsKt.emptyList();
    }
}
