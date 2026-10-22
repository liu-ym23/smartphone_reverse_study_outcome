package com.larus.agents.impl.settings;

import com.bytedance.keva.Keva;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/impl/settings/OfficeTaskPreference;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.settings.KevaOfficeTaskPreferenceRepository$get$2", f = "OfficeTaskPreferenceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KevaOfficeTaskPreferenceRepository$get$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KevaOfficeTaskPreferenceRepository this$0;

    public KevaOfficeTaskPreferenceRepository$get$2(KevaOfficeTaskPreferenceRepository r100, Continuation<? super KevaOfficeTaskPreferenceRepository$get$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        KevaOfficeTaskPreferenceRepository$get$2 r102 = new KevaOfficeTaskPreferenceRepository$get$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super b> r101) {
        return ((KevaOfficeTaskPreferenceRepository$get$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        KevaOfficeTaskPreferenceRepository r102 = this.this$0;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Keva r104 = KevaOfficeTaskPreferenceRepository.c(r102);     // Catch: Throwable -> L10
        String r105 = r104.getString("instruction", "");     // Catch: Throwable -> L10
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        Object r106 = Result.m9449constructorimpl(new b(r105, r104.getLong("revision", 0)));     // Catch: Throwable -> L10
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        FLogger.f375446a.e("OfficeTaskPreferenceRepo", "get preference failed: ".concat(r107.getClass().getSimpleName()));
        return new b("", 0);
    L21:
        return r106;
    L10:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
