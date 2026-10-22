package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$17 extends FunctionReferenceImpl implements Function2<Double, Double, Long> {
    public static final OpMath$interpretFun$17 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$17();
    }

    public OpMath$interpretFun$17() {
        super(2, v.class, "imul", "imul(DD)J", 1);
    }

    public final Long invoke(double r100, double r101) {
        int r102 = (int) r100;
        int r103 = (int) r101;
        int r104 = (r102 >>> 16) & 65535;
        int r105 = r102 & 65535;
        int r106 = (r103 >>> 16) & 65535;
        int r107 = r103 & 65535;
        return Long.valueOf(((r105 * r107) + ((((r104 * r107) + (r105 * r106)) << 16) >>> 0)) | 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(Double r100, Double r101) {
        return invoke(r100.doubleValue(), r101.doubleValue());
    }
}
