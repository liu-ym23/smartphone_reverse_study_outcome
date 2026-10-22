package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public final class StdlibClassFinderKt {
    private static final ModuleCapability<StdlibClassFinder> STDLIB_CLASS_FINDER_CAPABILITY = null;

    static {
        STDLIB_CLASS_FINDER_CAPABILITY = new ModuleCapability("StdlibClassFinder");
    }

    public static final StdlibClassFinder getStdlibClassFinder(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StdlibClassFinder r101 = (StdlibClassFinder) r100.getCapability(STDLIB_CLASS_FINDER_CAPABILITY);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return CliStdlibClassFinderImpl.INSTANCE;
    }
}
