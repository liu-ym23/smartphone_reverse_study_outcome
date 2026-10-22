package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.help.EventExposureTime$reportAllCardExposure$2", f = "EventExposureTime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventExposureTime$reportAllCardExposure$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $reportCard;
    final /* synthetic */ Map $state;
    int label;
    final /* synthetic */ EventExposureTime this$0;

    public EventExposureTime$reportAllCardExposure$2(EventExposureTime r1, List r2, Map r3, Continuation r4) {
        this.this$0 = r1;
        this.$reportCard = r2;
        this.$state = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        return new EventExposureTime$reportAllCardExposure$2(this.this$0, this.$reportCard, this.$state, r5);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r5);
        Iterator r6 = this.$reportCard.iterator();
    L6:
        if (r6.hasNext() == false) goto L20;
        BaseViewHolder r0 = (BaseViewHolder) r6.next();
        if (this.this$0.o.f == false) goto L13;
        if (this.$state.get(r0) == null) goto L13;
        if (Intrinsics.areEqual((Boolean) this.$state.get(r0), Boxing.boxBoolean(true)) == false) goto L6;
    L13:
        ECHybridListItemVO r1 = r0.c;
        if (r1 == null) goto L16;
        r1.N = System.currentTimeMillis();
    L16:
        JSONObject r2 = this.this$0.i(r0);
        if (r2 == null) goto L6;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r2);
        goto L6
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
