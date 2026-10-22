package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public interface PackageViewDescriptorFactory {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            CAPABILITY = new ModuleCapability("PackageViewDescriptorFactory");
        }

        public final ModuleCapability<PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }
    }

    public static final class Default implements PackageViewDescriptorFactory {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
        public PackageViewDescriptor compute(ModuleDescriptorImpl r100, FqName r101, StorageManager r102) {
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter(r101, "fqName");
            Intrinsics.checkNotNullParameter(r102, "storageManager");
            return new LazyPackageViewDescriptorImpl(r100, r101, r102);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    PackageViewDescriptor compute(ModuleDescriptorImpl r100, FqName r101, StorageManager r102);
}
