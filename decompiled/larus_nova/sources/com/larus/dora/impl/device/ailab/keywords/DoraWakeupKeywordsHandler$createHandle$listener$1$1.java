package com.larus.dora.impl.device.ailab.keywords;

import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler$createHandle$listener$1$1", f = "DoraWakeupKeywordsHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraWakeupKeywordsHandler$createHandle$listener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ SAMICoreBlock $data;
    final /* synthetic */ SAMICoreCallBackEventType $type;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraWakeupKeywordsHandler$createHandle$listener$1$1(SAMICoreCallBackEventType r100, SAMICoreBlock r101, Function1<? super String, Unit> r102, Continuation<? super DoraWakeupKeywordsHandler$createHandle$listener$1$1> r103) {
        this.$type = r100;
        this.$data = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraWakeupKeywordsHandler$createHandle$listener$1$1(this.$type, this.$data, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraWakeupKeywordsHandler$createHandle$listener$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        if (this.$type == SAMICoreCallBackEventType.AIS_Ability) goto L8;
        g49.d.b("DoraWakeupKeywordsHandler", "SAMICoreCallBackListener callback type: " + this.$type + "， Unknown message");
        return Unit.INSTANCE;
    L8:
        Object r101 = this.$data.audioData[0];
        if ((r101 instanceof String) == false) goto L11;
        String r102 = (String) r101;
    L12:
        g49.d.d("DoraWakeupKeywordsHandler", "SAMICoreCallBackListener callback json: " + r102);
        this.$callback.invoke(r102);
        return Unit.INSTANCE;
    L11:
        r102 = null;
        goto L12
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
