package com.larus.bmhome.taskskill.view;

import com.larus.bmhome.taskskill.network.PcDeviceRepository;
import com.ss.bduploader.BDAbstractUpload;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.view.PcConnectionStatusManager$authorizeDevice$1$result$1", f = "PcConnectionStatusManager.kt", i = {}, l = {BDAbstractUpload.KeyIsXQuicLibAvailable}, m = "invokeSuspend", n = {}, s = {})
public final class PcConnectionStatusManager$authorizeDevice$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $targetDeviceId;
    final /* synthetic */ String $ticket;
    int label;

    public PcConnectionStatusManager$authorizeDevice$1$result$1(String r100, String r101, Continuation<? super PcConnectionStatusManager$authorizeDevice$1$result$1> r102) {
        this.$targetDeviceId = r100;
        this.$ticket = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PcConnectionStatusManager$authorizeDevice$1$result$1(this.$targetDeviceId, this.$ticket, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends Unit>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<Unit>> r101) {
        return ((PcConnectionStatusManager$authorizeDevice$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L12:
        return Result.m9448boximpl(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        PcDeviceRepository r104 = PcDeviceRepository.f314355a;
        String r105 = this.$targetDeviceId;
        String r106 = this.$ticket;
        this.label = 1;
        r103 = r104.a(r105, r106, this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
