package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.help.EventExposureTime$gulShowReport$1", f = "EventExposureTime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventExposureTime$gulShowReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $end;
    final /* synthetic */ long $start;
    int label;
    final /* synthetic */ EventExposureTime this$0;

    public EventExposureTime$gulShowReport$1(EventExposureTime r1, long r2, long r4, Continuation r6) {
        this.this$0 = r1;
        this.$start = r2;
        this.$end = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "completion");
        return new EventExposureTime$gulShowReport$1(this.this$0, this.$start, this.$end, r9);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r6);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L7
        r8.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, this.this$0.o.a);     // Catch: Throwable -> L7
        r8.putOpt("btm", EventExposureTime.e(this.this$0));     // Catch: Throwable -> L7
        r8.putOpt("exposure_start", Boxing.boxLong(this.$start));     // Catch: Throwable -> L7
        r8.putOpt("exposure_end", Boxing.boxLong(this.$end));     // Catch: Throwable -> L7
        r8.putOpt("exposure_time", Boxing.boxLong(this.$end - this.$start));     // Catch: Throwable -> L7
        EventExposureTime r1 = this.this$0;     // Catch: Throwable -> L7
        int r2 = r1.c + 1;     // Catch: Throwable -> L7
        r1.c = r2;     // Catch: Throwable -> L7
        r8.putOpt("exposure_num", Boxing.boxInt(r2));     // Catch: Throwable -> L7
        AppLogNewUtils.onEventV3("mall_gyl_show_time", r8);     // Catch: Throwable -> L7
        Result.constructor-impl(r8);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
