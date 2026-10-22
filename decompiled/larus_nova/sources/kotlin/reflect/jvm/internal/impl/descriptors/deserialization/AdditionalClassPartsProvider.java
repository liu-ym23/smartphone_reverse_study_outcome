package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes5.dex */
public interface AdditionalClassPartsProvider {

    /* JADX INFO: loaded from: classes42.dex */
    public static final class None implements AdditionalClassPartsProvider {
        public static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        private None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<Name> getFunctionsNames(ClassDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<KotlinType> getSupertypes(ClassDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection<SimpleFunctionDescriptor> getFunctions(Name r100, ClassDescriptor r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "classDescriptor");
            return CollectionsKt.emptyList();
        }
    }

    Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor r100);

    Collection<SimpleFunctionDescriptor> getFunctions(Name r100, ClassDescriptor r101);

    Collection<Name> getFunctionsNames(ClassDescriptor r100);

    Collection<KotlinType> getSupertypes(ClassDescriptor r100);
}
