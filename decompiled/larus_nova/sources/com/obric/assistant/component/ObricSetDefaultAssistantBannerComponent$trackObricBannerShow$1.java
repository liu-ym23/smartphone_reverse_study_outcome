package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricSystemReporter;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1", f = "ObricSetDefaultAssistantBannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1(Continuation<? super ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1 r102 = new ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricSetDefaultAssistantBannerComponent$trackObricBannerShow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        JSONObject r102 = new JSONObject();
        r102.put("banner_type", "obric_perodic_default_guide_banner");
        FLogger.f375446a.i("ObricSetDefaultAssistantBannerComponent", "report obric_banner_show: " + r102);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        IObricSystemReporter.f391337a.getClass();     // Catch: Throwable -> L11
        IObricSystemReporter r104 = IObricSystemReporter.a.a();     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        r104.b("obric_banner_show", r102);     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L13:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        FLogger.f375446a.w("ObricSetDefaultAssistantBannerComponent", "report obric_banner_show failed. " + r107.getMessage(), r107);
    L17:
        return Unit.INSTANCE;
    L8:
        r105 = null;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
