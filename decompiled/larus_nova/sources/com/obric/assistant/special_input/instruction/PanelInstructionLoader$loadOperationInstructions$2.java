package com.obric.assistant.special_input.instruction;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import vea.q;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/network/api/bean/OperationInstruction;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadOperationInstructions$2", f = "PanelInstructionLoader.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class PanelInstructionLoader$loadOperationInstructions$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends q>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public PanelInstructionLoader$loadOperationInstructions$2(Continuation<? super PanelInstructionLoader$loadOperationInstructions$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PanelInstructionLoader$loadOperationInstructions$2 r102 = new PanelInstructionLoader$loadOperationInstructions$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends q>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<q>> r101) {
        return ((PanelInstructionLoader$loadOperationInstructions$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L21
    L15:
        List r103 = (List) r100;     // Catch: Throwable -> L21
    L17:
        if (r103 != null) goto L19;
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L21
    L19:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L21
    L23:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L26;
        FLogger.f375446a.e("PanelInstructionLoader", "loadOperationInstructions failed: " + r105.getMessage());
    L26:
        List r106 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r104) == true) goto L29;
        return r104;
    L29:
        return r106;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r107 = (CoroutineScope) this.L$0;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L21
        IObricNetworkService r109 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L21
        if (r109 == null) goto L16;
        this.label = 1;     // Catch: Throwable -> L21
        r100 = r109.getOperationInstructions(this);     // Catch: Throwable -> L21
        if (r100 != r101) goto L15;
        return r101;
    L16:
        r103 = null;
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
