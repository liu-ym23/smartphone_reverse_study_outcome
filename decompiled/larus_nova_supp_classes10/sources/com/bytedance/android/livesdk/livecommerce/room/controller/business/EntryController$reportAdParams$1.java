package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController$reportAdParams$1", f = "EntryController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EntryController$reportAdParams$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map $reportParams;
    final /* synthetic */ com.bytedance.android.ec.adapter.api.state.a $roomState;
    int label;
    final /* synthetic */ EntryController this$0;

    public EntryController$reportAdParams$1(EntryController r1, Map r2, com.bytedance.android.ec.adapter.api.state.a r3, Continuation r4) {
        this.this$0 = r1;
        this.$reportParams = r2;
        this.$roomState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        return new EntryController$reportAdParams$1(this.this$0, this.$reportParams, this.$roomState, r5);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r10);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L18
        Unit r0 = null;
        if (this.this$0.v() == false) goto L11;
        LiveRoomParams r12 = this.this$0.A().m.l();     // Catch: Throwable -> L18
        if (r12 == null) goto L10;
        JSONObject r13 = r12.getEntranceInfo();     // Catch: Throwable -> L18
    L12:
        JSONObject r4 = r13;
    L13:
        int r14 = ECSdk.a;     // Catch: Throwable -> L18
        IECAPTService r15 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Throwable -> L18
        if (r15 == null) goto L16;
        r15.record(new lg.k(new lg.e((String) this.$reportParams.get("log_extra"), null, r4, (String) this.$reportParams.get("creative_id"), this.$roomState.f, 482)));     // Catch: Throwable -> L18
        r0 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r16 = Result.constructor-impl(r0);     // Catch: Throwable -> L18
    L20:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L24;
        ECExceptionMonitor.e(r17);
    L24:
        return Unit.INSTANCE;
    L10:
        r4 = null;
        goto L13
    L11:
        ECEventUtilsV2.b.getClass();     // Catch: Throwable -> L18
        r13 = ECEventUtilsV2.f("", null, null);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
