package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ExpressionInterpreterImpl$parseExpressionOp$1 extends FunctionReferenceImpl implements Function2<Boolean, Boolean, Boolean> {
    public static final ExpressionInterpreterImpl$parseExpressionOp$1 INSTANCE = null;

    static {
        INSTANCE = new ExpressionInterpreterImpl$parseExpressionOp$1();
    }

    public ExpressionInterpreterImpl$parseExpressionOp$1() {
        super(2, Boolean.TYPE, "and", "and(Z)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean r100, Boolean r101) {
        return invoke(r100.booleanValue(), r101.booleanValue());
    }

    public final Boolean invoke(boolean r100, boolean r101) {
        return Boolean.valueOf(r100 & r101);
    }
}
