package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* JADX INFO: loaded from: classes5.dex */
public final class RuntimeModuleData {
    public static final Companion Companion = null;
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader r100) {
            Intrinsics.checkNotNullParameter(r100, "classLoader");
            ReflectKotlinClassFinder r101 = new ReflectKotlinClassFinder(r100);
            DeserializationComponentsForJava.Companion.ModuleData r102 = DeserializationComponentsForJava.Companion.createModuleData(r101, new ReflectKotlinClassFinder(Unit.class.getClassLoader()), new ReflectJavaClassFinder(r100), "runtime module for " + r100, RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(r102.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(r102.getDeserializedDescriptorResolver(), r101), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents r100, PackagePartScopeCache r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    private RuntimeModuleData(DeserializationComponents r100, PackagePartScopeCache r101) {
        this.deserialization = r100;
        this.packagePartScopeCache = r101;
    }
}
