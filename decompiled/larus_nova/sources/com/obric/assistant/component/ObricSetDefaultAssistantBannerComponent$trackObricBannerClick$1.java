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
@DebugMetadata(c = "com.obric.assistant.component.ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1", f = "ObricSetDefaultAssistantBannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    private /* synthetic */ Object L$0;
    int label;

    public ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1(String r100, Continuation<? super ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1> r101) {
        this.$actionType = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1 r102 = new ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1(this.$actionType, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricSetDefaultAssistantBannerComponent$trackObricBannerClick$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        JSONObject r102 = new JSONObject();
        String r103 = this.$actionType;
        r102.put("banner_type", "obric_perodic_default_guide_banner");
        r102.put("action_type", r103);
        FLogger.f375446a.i("ObricSetDefaultAssistantBannerComponent", "report obric_banner_click: " + r102);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        IObricSystemReporter.f391337a.getClass();     // Catch: Throwable -> L11
        IObricSystemReporter r105 = IObricSystemReporter.a.a();     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        r105.b("obric_banner_click", r102);     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        FLogger.f375446a.w("ObricSetDefaultAssistantBannerComponent", "report obric_banner_click failed. " + r108.getMessage(), r108);
    L17:
        return Unit.INSTANCE;
    L8:
        r106 = null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
