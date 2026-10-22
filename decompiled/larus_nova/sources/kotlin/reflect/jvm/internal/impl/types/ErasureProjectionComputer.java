package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public class ErasureProjectionComputer {
    public ErasureProjectionComputer() {
    }

    public TypeProjection computeProjection(TypeParameterDescriptor r100, ErasureTypeAttributes r101, TypeParameterUpperBoundEraser r102, KotlinType r103) {
        Intrinsics.checkNotNullParameter(r100, "parameter");
        Intrinsics.checkNotNullParameter(r101, "typeAttr");
        Intrinsics.checkNotNullParameter(r102, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r103, "erasedUpperBound");
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r103);
    }

    public static /* synthetic */ TypeProjection computeProjection$default(ErasureProjectionComputer r100, TypeParameterDescriptor r101, ErasureTypeAttributes r102, TypeParameterUpperBoundEraser r103, KotlinType r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L7;
        r104 = r103.getErasedUpperBound(r101, r102);
    L7:
        return r100.computeProjection(r101, r102, r103, r104);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
    }
}
