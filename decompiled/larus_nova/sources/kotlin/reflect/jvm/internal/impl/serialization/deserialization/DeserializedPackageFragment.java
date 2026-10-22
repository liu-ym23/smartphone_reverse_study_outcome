package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final StorageManager storageManager;

    public abstract ClassDataFinder getClassDataFinder();

    public abstract void initialize(DeserializationComponents r100);

    public boolean hasTopLevelClass(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        MemberScope r101 = getMemberScope();
        if ((r101 instanceof DeserializedMemberScope) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeserializedMemberScope) r101).getClassNames$deserialization().contains(r100) == false) goto L7;
        return true;
    }

    public DeserializedPackageFragment(FqName r100, StorageManager r101, ModuleDescriptor r102) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        Intrinsics.checkNotNullParameter(r101, "storageManager");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        super(r102, r100);
        this.storageManager = r101;
    }
}
