package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OverridingStrategy {
    public OverridingStrategy() {
    }

    public abstract void addFakeOverride(CallableMemberDescriptor r100);

    public abstract void inheritanceConflict(CallableMemberDescriptor r100, CallableMemberDescriptor r101);

    public abstract void overrideConflict(CallableMemberDescriptor r100, CallableMemberDescriptor r101);

    public void setOverriddenDescriptors(CallableMemberDescriptor r100, Collection<? extends CallableMemberDescriptor> r101) {
        Intrinsics.checkNotNullParameter(r100, "member");
        Intrinsics.checkNotNullParameter(r101, "overridden");
        r100.setOverriddenDescriptors(r101);
    }
}
