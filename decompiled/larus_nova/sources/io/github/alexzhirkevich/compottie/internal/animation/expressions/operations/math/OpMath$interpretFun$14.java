package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$14 extends FunctionReferenceImpl implements Function1<Double, Double> {
    public static final OpMath$interpretFun$14 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$14();
    }

    public OpMath$interpretFun$14() {
        super(1, MathKt.class, "expm1", "expm1(D)D", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Double invoke(Double r100) {
        return invoke(r100.doubleValue());
    }

    public final Double invoke(double r100) {
        return Double.valueOf(Math.expm1(r100));
    }
}
