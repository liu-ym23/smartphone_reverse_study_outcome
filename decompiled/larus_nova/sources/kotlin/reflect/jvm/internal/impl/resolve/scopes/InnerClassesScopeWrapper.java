package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    private final MemberScope workerScope;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public String toString() {
        return "Classes from " + this.workerScope;
    }

    public InnerClassesScopeWrapper(MemberScope r100) {
        Intrinsics.checkNotNullParameter(r100, "workerScope");
        this.workerScope = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo10734getContributedClassifier(Name r100, LookupLocation r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "location");
        ClassifierDescriptor r102 = this.workerScope.mo10734getContributedClassifier(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if ((r102 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r103 = (ClassDescriptor) r102;
    L8:
        if (r103 == null) goto L11;
        return r103;
    L11:
        if ((r102 instanceof TypeAliasDescriptor) == true) goto L13;
        return null;
    L13:
        return (TypeAliasDescriptor) r102;
    L7:
        r103 = null;
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter r100, Function1<? super Name, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "kindFilter");
        Intrinsics.checkNotNullParameter(r101, "nameFilter");
        DescriptorKindFilter r102 = r100.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (r102 == null) goto L5;
        Collection<DeclarationDescriptor> r103 = this.workerScope.getContributedDescriptors(r102, r101);
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if ((r106 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        r104.add(r106);
        goto L8
    L12:
        return r104;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo10738recordLookup(Name r100, LookupLocation r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "location");
        this.workerScope.mo10738recordLookup(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r100, Function1 r101) {
        return getContributedDescriptors(r100, r101);
    }
}
