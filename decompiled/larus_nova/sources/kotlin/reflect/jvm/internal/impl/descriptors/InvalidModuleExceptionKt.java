package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class InvalidModuleExceptionKt {
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = null;

    static {
        INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability("InvalidModuleNotifier");
    }

    public static final void moduleInvalidated(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        InvalidModuleNotifier r101 = (InvalidModuleNotifier) r100.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (r101 == null) goto L7;
        r101.notifyModuleInvalidated(r100);
        return;
    L7:
        throw new InvalidModuleException("Accessing invalid module descriptor " + r100);
    }
}
