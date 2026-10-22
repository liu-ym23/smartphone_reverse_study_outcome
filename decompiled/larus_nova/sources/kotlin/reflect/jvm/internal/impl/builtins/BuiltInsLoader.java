package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes42.dex */
public interface BuiltInsLoader {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Lazy<BuiltInsLoader> Instance$delegate = null;

        private Companion() {
        }

        public static /* synthetic */ BuiltInsLoader accessor$BuiltInsLoader$Companion$lambda0() {
            return Instance_delegate$lambda$0();
        }

        static {
            $$INSTANCE = new Companion();
            Instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$$Lambda$0.INSTANCE);
        }

        private static final BuiltInsLoader Instance_delegate$lambda$0() {
            ServiceLoader r100 = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
            Intrinsics.checkNotNull(r100);
            BuiltInsLoader r101 = (BuiltInsLoader) CollectionsKt.firstOrNull(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }

        public final BuiltInsLoader getInstance() {
            return Instance$delegate.getValue();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    PackageFragmentProvider createPackageFragmentProvider(StorageManager r100, ModuleDescriptor r101, Iterable<? extends ClassDescriptorFactory> r102, PlatformDependentDeclarationFilter r103, AdditionalClassPartsProvider r104, boolean r105);
}
