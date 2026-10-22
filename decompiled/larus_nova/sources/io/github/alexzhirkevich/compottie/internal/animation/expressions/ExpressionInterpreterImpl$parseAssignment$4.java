package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ExpressionInterpreterImpl$parseAssignment$4 extends FunctionReferenceImpl implements Function2<Object, Object, Object> {
    public static final ExpressionInterpreterImpl$parseAssignment$4 INSTANCE = null;

    static {
        INSTANCE = new ExpressionInterpreterImpl$parseAssignment$4();
    }

    public ExpressionInterpreterImpl$parseAssignment$4() {
        super(2, io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math.g.class, "OpDiv", "OpDiv(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math.g.a(r100, r101);
    }
}
