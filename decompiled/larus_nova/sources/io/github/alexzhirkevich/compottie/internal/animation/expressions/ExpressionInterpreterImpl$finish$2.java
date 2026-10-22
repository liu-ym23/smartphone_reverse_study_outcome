package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ExpressionInterpreterImpl$finish$2 extends FunctionReferenceImpl implements Function1<Object, Boolean> {
    public ExpressionInterpreterImpl$finish$2(Object r100) {
        super(1, r100, Character.TYPE, "equals", "equals(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object r100) {
        return Boolean.valueOf(this.receiver.equals(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return invoke(r100);
    }
}
