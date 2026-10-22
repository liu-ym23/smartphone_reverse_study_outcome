package com.larus.voicecall.impl.ui;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1", f = "RealtimeCallHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $failReason;
    final /* synthetic */ String $success;
    int label;

    public RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1(String r100, String r101, String r102, String r103, Continuation<? super RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1> r104) {
        this.$botId = r100;
        this.$conversationId = r101;
        this.$failReason = r102;
        this.$success = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1(this.$botId, this.$conversationId, this.$failReason, this.$success, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeCallHelperKt$reportRaiseCallStatusForSwipeEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$botId;
        String r102 = this.$conversationId;
        String r103 = this.$failReason;
        String r104 = this.$success;
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r101 != null) goto L21;
    L9:
        if (r102 == null) goto L11;
        r105.put("conversation_id", r102);     // Catch: JSONException -> L7
    L11:
        if (r103 == null) goto L13;
        r105.put("fail_reason", r103);     // Catch: JSONException -> L7
    L13:
        if (r104 == null) goto L17;
        r105.put("success", r104);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        FLogger.f375446a.e("RaiseForSwipeEventHelper", "error in RaiseForSwipeEventHelper raiseCallStatus " + e.getLocalizedMessage());
    L17:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("raise_call_status_for_swipe");
        r107.f21463a.merge(r106);
        r107.b();
        return Unit.INSTANCE;
    L21:
        r105.put("bot_id", r101);     // Catch: JSONException -> L7
        goto L9
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
