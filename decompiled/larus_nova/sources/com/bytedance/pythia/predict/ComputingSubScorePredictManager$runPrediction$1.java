package com.bytedance.pythia.predict;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ln87/b;", "result", "", AbsMethodDelegate.TAG_INVOKE, "(Ln87/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class ComputingSubScorePredictManager$runPrediction$1 extends Lambda implements Function1<n87.b, Unit> {
    final /* synthetic */ ComputingSubScorePredictManager this$0;

    public ComputingSubScorePredictManager$runPrediction$1(ComputingSubScorePredictManager r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(n87.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        ComputingSubScorePredictManager r101 = this.this$0;
        int r102 = ComputingSubScorePredictManager.f267095g;
        r101.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("config");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(n87.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
