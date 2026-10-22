package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/shopping/mall/feed/help/EventExposureTime$scrollListener$1$onScrollStateChanged$2$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.help.EventExposureTime$scrollListener$1$onScrollStateChanged$2$1", f = "EventExposureTime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventExposureTime$scrollListener$1$onScrollStateChanged$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseViewHolder $holder;
    final /* synthetic */ Ref.IntRef $inVisibleCount$inlined;
    int label;
    final /* synthetic */ EventExposureTime$scrollListener$1 this$0;

    public EventExposureTime$scrollListener$1$onScrollStateChanged$$inlined$forEach$lambda$1(BaseViewHolder r1, Continuation r2, EventExposureTime$scrollListener$1 r3, Ref.IntRef r4) {
        this.$holder = r1;
        this.this$0 = r3;
        this.$inVisibleCount$inlined = r4;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        return new EventExposureTime$scrollListener$1$onScrollStateChanged$$inlined$forEach$lambda$1(this.$holder, r5, this.this$0, this.$inVisibleCount$inlined);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        EventExposureTime r4 = this.this$0.b;
        BaseViewHolder r0 = this.$holder;
        int r1 = EventExposureTime.q;
        JSONObject r5 = r4.i(r0);
        if (r5 == null) goto L8;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r5);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
