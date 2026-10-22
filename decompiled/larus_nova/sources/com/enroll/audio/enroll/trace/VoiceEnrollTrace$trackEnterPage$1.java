package com.enroll.audio.enroll.trace;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
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

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.trace.VoiceEnrollTrace$trackEnterPage$1", f = "VoiceEnrollTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollTrace$trackEnterPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ Map<String, Object> $extraParams;
    final /* synthetic */ String $previousPage;
    int label;

    public VoiceEnrollTrace$trackEnterPage$1(String r100, String r101, String r102, Map<String, ? extends Object> r103, Continuation<? super VoiceEnrollTrace$trackEnterPage$1> r104) {
        this.$currentPage = r100;
        this.$previousPage = r101;
        this.$enterFrom = r102;
        this.$extraParams = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoiceEnrollTrace$trackEnterPage$1(this.$currentPage, this.$previousPage, this.$enterFrom, this.$extraParams, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceEnrollTrace$trackEnterPage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        JSONObject r101 = new JSONObject();
        ObricEnrollTraceParamDelegate.f392837b.b(r101, this.$currentPage, this.$previousPage, this.$enterFrom);
        Map<String, Object> r102 = this.$extraParams;
        if (r102 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, Object> r104 = r103.next();
        r101.put(r104.getKey(), r104.getValue());
    L10:
        IApplog.f287053a.reportEvent(CheckPointType.ENTER_PAGE, r101);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
