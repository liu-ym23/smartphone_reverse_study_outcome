package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes42.dex */
public final class StarProjectionImpl extends TypeProjectionBase {
    private final Lazy _type$delegate;
    private final TypeParameterDescriptor typeParameter;

    public static /* synthetic */ KotlinType accessor$StarProjectionImpl$lambda0(StarProjectionImpl r100) {
        return _type_delegate$lambda$0(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner r100) {
        Intrinsics.checkNotNullParameter(r100, "kotlinTypeRefiner");
        return this;
    }

    private final KotlinType get_type() {
        return (KotlinType) this._type$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        return get_type();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    public StarProjectionImpl(TypeParameterDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "typeParameter");
        this.typeParameter = r100;
        this._type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$$Lambda$0(this));
    }

    private static final KotlinType _type_delegate$lambda$0(StarProjectionImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return StarProjectionImplKt.starProjectionType(r100.typeParameter);
    }
}
