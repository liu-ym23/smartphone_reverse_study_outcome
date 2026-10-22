package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public final class ResolutionAnchorProviderKt {
    private static final ModuleCapability<ResolutionAnchorProvider> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = null;

    static {
        RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability("ResolutionAnchorProvider");
    }

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ResolutionAnchorProvider r101 = (ResolutionAnchorProvider) r100.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getResolutionAnchor(r100);
    }
}
