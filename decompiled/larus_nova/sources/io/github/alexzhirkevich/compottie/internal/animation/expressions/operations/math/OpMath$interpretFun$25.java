package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$25 extends FunctionReferenceImpl implements Function1<Double, Integer> {
    public static final OpMath$interpretFun$25 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$25();
    }

    public OpMath$interpretFun$25() {
        super(1, MathKt.class, "roundToInt", "roundToInt(D)I", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Double r100) {
        return invoke(r100.doubleValue());
    }

    public final Integer invoke(double r100) {
        return Integer.valueOf(MathKt.roundToInt(r100));
    }
}
