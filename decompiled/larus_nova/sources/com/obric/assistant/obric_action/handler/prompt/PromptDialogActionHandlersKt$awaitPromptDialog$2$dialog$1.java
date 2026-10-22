package com.obric.assistant.obric_action.handler.prompt;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$1 extends FunctionReferenceImpl implements Function1<j, Unit> {
    final /* synthetic */ Ref.BooleanRef $completed;
    final /* synthetic */ kotlinx.coroutines.i<j> $continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$1(Ref.BooleanRef r100, kotlinx.coroutines.i<? super j> r101) {
        this.$completed = r100;
        this.$continuation = r101;
        super(1, Intrinsics.Kotlin.class, BitableAnalytic.SelectSceneClickType.COMPLETE, "awaitPromptDialog$lambda$0$complete(Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlinx/coroutines/CancellableContinuation;Lcom/obric/assistant/obric_action/handler/prompt/PromptDialogActionResult;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(j r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        h.b(this.$completed, this.$continuation, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(j r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
