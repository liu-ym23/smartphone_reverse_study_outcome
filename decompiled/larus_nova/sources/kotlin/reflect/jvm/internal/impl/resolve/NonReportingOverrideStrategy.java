package kotlin.reflect.jvm.internal.impl.resolve;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    public abstract void conflict(CallableMemberDescriptor r100, CallableMemberDescriptor r101);

    public NonReportingOverrideStrategy() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor r100, CallableMemberDescriptor r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "second");
        conflict(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor r100, CallableMemberDescriptor r101) {
        Intrinsics.checkNotNullParameter(r100, "fromSuper");
        Intrinsics.checkNotNullParameter(r101, "fromCurrent");
        conflict(r100, r101);
    }
}
