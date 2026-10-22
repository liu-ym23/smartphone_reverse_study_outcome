package com.obric.audio.enroll.trace;

import com.larus.applog.api.IApplog;
import com.obric.assistant.spi.audio.ObricEnrollTraceParamDelegate;
import java.util.Iterator;
import java.util.Map;
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
@DebugMetadata(c = "com.obric.audio.enroll.trace.VoiceEnrollTrace$trackPageClick$1", f = "VoiceEnrollTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollTrace$trackPageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ Map<String, Object> $extraParams;
    int label;

    public VoiceEnrollTrace$trackPageClick$1(String r100, String r101, String r102, Map<String, ? extends Object> r103, Continuation<? super VoiceEnrollTrace$trackPageClick$1> r104) {
        this.$currentPage = r100;
        this.$actionType = r101;
        this.$enterFrom = r102;
        this.$extraParams = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoiceEnrollTrace$trackPageClick$1(this.$currentPage, this.$actionType, this.$enterFrom, this.$extraParams, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceEnrollTrace$trackPageClick$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        JSONObject r101 = new JSONObject();
        ObricEnrollTraceParamDelegate.f392837b.a(r101, this.$currentPage, this.$actionType, this.$enterFrom);
        Map<String, Object> r102 = this.$extraParams;
        if (r102 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, Object> r104 = r103.next();
        r101.put(r104.getKey(), r104.getValue());
    L10:
        IApplog.f287053a.reportEvent("obric_page_click", r101);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
