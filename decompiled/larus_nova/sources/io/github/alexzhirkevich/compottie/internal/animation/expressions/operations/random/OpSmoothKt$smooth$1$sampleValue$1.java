package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import io.github.alexzhirkevich.compottie.internal.animation.j2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OpSmoothKt$smooth$1$sampleValue$1 extends FunctionReferenceImpl implements Function1<prc.f, Object> {
    public OpSmoothKt$smooth$1$sampleValue$1(Object r100) {
        super(1, r100, j2.class, TemplateNodeType.RAW, "raw(Lio/github/alexzhirkevich/compottie/internal/AnimationState;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(prc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((j2) this.receiver).d(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(prc.f r100) {
        return invoke2(r100);
    }
}
