package com.obric.assistant.settings.provider;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.DoubaoWhisperSettingProvider$getSettingItems$4", f = "DoubaoWhisperSettingProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoWhisperSettingProvider$getSettingItems$4 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;

    public DoubaoWhisperSettingProvider$getSettingItems$4(Continuation<? super DoubaoWhisperSettingProvider$getSettingItems$4> r100) {
        super(1, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new DoubaoWhisperSettingProvider$getSettingItems$4(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((DoubaoWhisperSettingProvider$getSettingItems$4) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return Boxing.boxBoolean(t9a.b.a().b());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
