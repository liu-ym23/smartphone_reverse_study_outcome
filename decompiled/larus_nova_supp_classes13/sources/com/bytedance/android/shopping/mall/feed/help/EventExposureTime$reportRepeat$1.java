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
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.help.EventExposureTime$reportRepeat$1", f = "EventExposureTime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventExposureTime$reportRepeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ String $logId1;
    final /* synthetic */ String $logId2;
    final /* synthetic */ int $repeatNum;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ EventExposureTime this$0;

    public EventExposureTime$reportRepeat$1(EventExposureTime r1, int r2, int r3, String r4, String r5, String r6, Continuation r7) {
        this.this$0 = r1;
        this.$repeatNum = r2;
        this.$index = r3;
        this.$logId1 = r4;
        this.$logId2 = r5;
        this.$type = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new EventExposureTime$reportRepeat$1(this.this$0, this.$repeatNum, this.$index, this.$logId1, this.$logId2, this.$type, r10);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L7
        r5.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, this.this$0.o.a);     // Catch: Throwable -> L7
        r5.putOpt("btm", EventExposureTime.e(this.this$0));     // Catch: Throwable -> L7
        r5.putOpt("repeat_num", Boxing.boxInt(this.$repeatNum));     // Catch: Throwable -> L7
        r5.putOpt("index", Boxing.boxInt(this.$index));     // Catch: Throwable -> L7
        r5.putOpt("log1", this.$logId1);     // Catch: Throwable -> L7
        r5.putOpt("log2", this.$logId2);     // Catch: Throwable -> L7
        r5.putOpt("business_type", this.$type);     // Catch: Throwable -> L7
        AppLogNewUtils.onEventV3("mall_card_type_repeat", r5);     // Catch: Throwable -> L7
        Result.constructor-impl(r5);     // Catch: Throwable -> L7
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
