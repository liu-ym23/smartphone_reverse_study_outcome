package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes42.dex */
public final class EmptyPackageFragmentDescriptor extends PackageFragmentDescriptorImpl {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public /* bridge */ /* synthetic */ MemberScope getMemberScope() {
        return getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope.Empty getMemberScope() {
        return MemberScope.Empty.INSTANCE;
    }

    public EmptyPackageFragmentDescriptor(ModuleDescriptor r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "fqName");
        super(r100, r101);
    }
}
