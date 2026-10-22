package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$13 extends FunctionReferenceImpl implements Function1<Double, Double> {
    public static final OpMath$interpretFun$13 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$13();
    }

    public OpMath$interpretFun$13() {
        super(1, MathKt.class, OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES, "exp(D)D", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Double invoke(Double r100) {
        return invoke(r100.doubleValue());
    }

    public final Double invoke(double r100) {
        return Double.valueOf(Math.exp(r100));
    }
}
