package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OpMath$interpretFun$23 extends FunctionReferenceImpl implements Function1<List<? extends Double>, Double> {
    public static final OpMath$interpretFun$23 INSTANCE = null;

    static {
        INSTANCE = new OpMath$interpretFun$23();
    }

    public OpMath$interpretFun$23() {
        super(1, CollectionsKt.class, BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "minOrThrow(Ljava/lang/Iterable;)D", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Double invoke2(List<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Double.valueOf(CollectionsKt.minOrThrow(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Double invoke(List<? extends Double> r100) {
        return invoke2(r100);
    }
}
