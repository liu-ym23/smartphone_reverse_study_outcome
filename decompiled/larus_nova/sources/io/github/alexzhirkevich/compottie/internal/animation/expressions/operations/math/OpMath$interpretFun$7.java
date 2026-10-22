package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$7 extends FunctionReferenceImpl implements Function2<Double, Double, Double> {
    public static final OpMath$interpretFun$7 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$7();
    }

    public OpMath$interpretFun$7() {
        super(2, MathKt.class, "atan2", "atan2(DD)D", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Double invoke(Double r100, Double r101) {
        return invoke(r100.doubleValue(), r101.doubleValue());
    }

    public final Double invoke(double r100, double r101) {
        return Double.valueOf(Math.atan2(r100, r101));
    }
}
