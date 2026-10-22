package androidx.activity.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class ReportDrawnComposition$checkReporter$1 extends FunctionReferenceImpl implements Function1<Function0<? extends Boolean>, Unit> {
    public ReportDrawnComposition$checkReporter$1(Object r8) {
        super(1, r8, ReportDrawnComposition.class, "observeReporter", "observeReporter(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Function0) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Function0<Boolean> r2) {
        ReportDrawnComposition.access$observeReporter((ReportDrawnComposition) ((CallableReference) this).receiver, r2);
    }
}
