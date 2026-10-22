package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public interface PlatformDependentDeclarationFilter {

    /* JADX INFO: loaded from: classes42.dex */
    public static final class All implements PlatformDependentDeclarationFilter {
        public static final All INSTANCE = null;

        static {
            INSTANCE = new All();
        }

        private All() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor r100, SimpleFunctionDescriptor r101) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            Intrinsics.checkNotNullParameter(r101, "functionDescriptor");
            return true;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class NoPlatformDependent implements PlatformDependentDeclarationFilter {
        public static final NoPlatformDependent INSTANCE = null;

        static {
            INSTANCE = new NoPlatformDependent();
        }

        private NoPlatformDependent() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor r100, SimpleFunctionDescriptor r101) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            Intrinsics.checkNotNullParameter(r101, "functionDescriptor");
            return !r101.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(ClassDescriptor r100, SimpleFunctionDescriptor r101);
}
