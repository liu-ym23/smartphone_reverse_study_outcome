package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE = null;

    static {
        INSTANCE = new TypeMappingConfigurationImpl();
    }

    private TypeMappingConfigurationImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedFullInternalNameForClass(ClassDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedInternalNameForClass(ClassDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    /* JADX INFO: renamed from: getPredefinedTypeForClass, reason: avoid collision after fix types in other method */
    public JvmType getPredefinedTypeForClass2(ClassDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType preprocessType(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(KotlinType r100, ClassDescriptor r101) {
        Intrinsics.checkNotNullParameter(r100, "kotlinType");
        Intrinsics.checkNotNullParameter(r101, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType commonSupertype(Collection<? extends KotlinType> r110) {
        Intrinsics.checkNotNullParameter(r110, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + CollectionsKt.joinToString$default(r110, null, null, null, 0, null, null, 63, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public /* bridge */ /* synthetic */ JvmType getPredefinedTypeForClass(ClassDescriptor r100) {
        return getPredefinedTypeForClass2(r100);
    }
}
