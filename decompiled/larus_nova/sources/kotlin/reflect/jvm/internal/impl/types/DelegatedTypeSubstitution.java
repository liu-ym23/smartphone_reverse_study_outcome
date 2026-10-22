package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes42.dex */
public class DelegatedTypeSubstitution extends TypeSubstitution {
    private final TypeSubstitution substitution;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        return this.substitution.approximateCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.substitution.approximateContravariantCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public DelegatedTypeSubstitution(TypeSubstitution r100) {
        Intrinsics.checkNotNullParameter(r100, "substitution");
        this.substitution = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public Annotations filterAnnotations(Annotations r100) {
        Intrinsics.checkNotNullParameter(r100, "annotations");
        return this.substitution.filterAnnotations(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo10737get(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.substitution.mo10737get(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public KotlinType prepareTopLevelType(KotlinType r100, Variance r101) {
        Intrinsics.checkNotNullParameter(r100, "topLevelType");
        Intrinsics.checkNotNullParameter(r101, "position");
        return this.substitution.prepareTopLevelType(r100, r101);
    }
}
