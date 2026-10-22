package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.random;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OpTemporalWiggle$wiggle$1 extends FunctionReferenceImpl implements Function1<prc.f, Float> {
    public OpTemporalWiggle$wiggle$1(Object r100) {
        super(1, r100, vrc.c.class, AbsMethodDelegate.TAG_INVOKE, "invoke(Lio/github/alexzhirkevich/compottie/internal/AnimationState;)F", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Float invoke2(prc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((vrc.c) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "state");
        return Float.valueOf(Duration.m10811getInWholeMillisecondsimpl(r100.d()) / 1000.0f);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(prc.f r100) {
        return invoke2(r100);
    }
}
