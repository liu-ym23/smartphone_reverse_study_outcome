package com.larus.agents.impl.settings;

import com.bytedance.keva.Keva;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.settings.KevaOfficeTaskPreferenceRepository$save$2", f = "OfficeTaskPreferenceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KevaOfficeTaskPreferenceRepository$save$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OfficeTaskPreferenceSaveResult>, Object> {
    final /* synthetic */ String $instruction;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KevaOfficeTaskPreferenceRepository this$0;

    public KevaOfficeTaskPreferenceRepository$save$2(String r100, KevaOfficeTaskPreferenceRepository r101, Continuation<? super KevaOfficeTaskPreferenceRepository$save$2> r102) {
        this.$instruction = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        KevaOfficeTaskPreferenceRepository$save$2 r102 = new KevaOfficeTaskPreferenceRepository$save$2(this.$instruction, this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super OfficeTaskPreferenceSaveResult> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super OfficeTaskPreferenceSaveResult> r101) {
        return ((KevaOfficeTaskPreferenceRepository$save$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        int r102 = c.f286714a;
        if (c.a(this.$instruction) == false) goto L7;
        KevaOfficeTaskPreferenceRepository r103 = this.this$0;
        String r104 = this.$instruction;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        Keva r106 = KevaOfficeTaskPreferenceRepository.c(r103);     // Catch: Throwable -> L11
        r106.storeString("instruction", r104);     // Catch: Throwable -> L11
        r106.storeLong("revision", Math.max(r106.getLong("revision", 0) + 1, System.currentTimeMillis()));     // Catch: Throwable -> L11
        Object r107 = Result.m9449constructorimpl(OfficeTaskPreferenceSaveResult.SUCCESS);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L22;
        FLogger.f375446a.e("OfficeTaskPreferenceRepo", "save preference failed: ".concat(r108.getClass().getSimpleName()));
        return OfficeTaskPreferenceSaveResult.FAILURE;
    L22:
        return r107;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L7:
        return OfficeTaskPreferenceSaveResult.MAX_CHARACTER_LIMIT_EXCEEDED;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
