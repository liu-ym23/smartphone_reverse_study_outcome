package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public interface TypeAliasExpansionReportStrategy {

    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = null;

        static {
            INSTANCE = new DO_NOTHING();
        }

        private DO_NOTHING() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(TypeSubstitutor r100, KotlinType r101, KotlinType r102, TypeParameterDescriptor r103) {
            Intrinsics.checkNotNullParameter(r100, "substitutor");
            Intrinsics.checkNotNullParameter(r101, "unsubstitutedArgument");
            Intrinsics.checkNotNullParameter(r102, "argument");
            Intrinsics.checkNotNullParameter(r103, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor r100, TypeParameterDescriptor r101, KotlinType r102) {
            Intrinsics.checkNotNullParameter(r100, "typeAlias");
            Intrinsics.checkNotNullParameter(r102, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "annotation");
        }
    }

    void boundsViolationInSubstitution(TypeSubstitutor r100, KotlinType r101, KotlinType r102, TypeParameterDescriptor r103);

    void conflictingProjection(TypeAliasDescriptor r100, TypeParameterDescriptor r101, KotlinType r102);

    void recursiveTypeAlias(TypeAliasDescriptor r100);

    void repeatedAnnotation(AnnotationDescriptor r100);
}
