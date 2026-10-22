package com.obric.assistant.guide.trace;

import com.obric.assistant.reporter.IObricSystemReporter;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.obric.assistant.guide.trace.UserGuideTrace$trackSystemPageClickEvent$1", f = "UserGuideTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserGuideTrace$trackSystemPageClickEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $currentPage;
    int label;

    public UserGuideTrace$trackSystemPageClickEvent$1(String r100, String r101, Continuation<? super UserGuideTrace$trackSystemPageClickEvent$1> r102) {
        this.$currentPage = r100;
        this.$actionType = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UserGuideTrace$trackSystemPageClickEvent$1(this.$currentPage, this.$actionType, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UserGuideTrace$trackSystemPageClickEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        JSONObject r101 = new JSONObject();
        r101.put("current_page", this.$currentPage);
        r101.put("action_type", this.$actionType);
        IObricSystemReporter.f391337a.getClass();
        IObricSystemReporter r102 = IObricSystemReporter.a.a();
        if (r102 == null) goto L8;
        r102.b("obric_page_click", r101);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
