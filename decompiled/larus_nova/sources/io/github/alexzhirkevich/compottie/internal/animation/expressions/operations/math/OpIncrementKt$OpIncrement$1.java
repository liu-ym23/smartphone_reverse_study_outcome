package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OpIncrementKt$OpIncrement$1 extends FunctionReferenceImpl implements Function1<Object, Object> {
    public static final OpIncrementKt$OpIncrement$1 INSTANCE = null;

    static {
        INSTANCE = new OpIncrementKt$OpIncrement$1();
    }

    public OpIncrementKt$OpIncrement$1() {
        super(1, OpIncrementKt.class, "increment", "increment(Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Object r101 = b.b(r100);
        if ((r101 instanceof Long) == false) goto L6;
        return Long.valueOf(((Number) r101).longValue() + 1);
    L6:
        if ((r101 instanceof Double) == false) goto L9;
        return Double.valueOf(((Number) r101).doubleValue() + ((double) 1));
    L9:
        if ((r101 instanceof Number) == false) goto L13;
        return Double.valueOf(((Number) r101).doubleValue() + ((double) 1));
    L13:
        throw new IllegalStateException(("can't increment " + r101).toString());
    }
}
