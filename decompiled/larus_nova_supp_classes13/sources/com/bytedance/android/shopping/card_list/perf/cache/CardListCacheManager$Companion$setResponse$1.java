package com.bytedance.android.shopping.card_list.perf.cache;

import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager$Companion$setResponse$1", f = "CardListCacheManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CardListCacheManager$Companion$setResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LauncherBizType $bizType;
    final /* synthetic */ String $monitorId;
    final /* synthetic */ String $responseBody;
    final /* synthetic */ String $source;
    int label;

    public CardListCacheManager$Companion$setResponse$1(String r1, String r2, LauncherBizType r3, String r4, Continuation r5) {
        this.$monitorId = r1;
        this.$responseBody = r2;
        this.$bizType = r3;
        this.$source = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "completion");
        return new CardListCacheManager$Companion$setResponse$1(this.$monitorId, this.$responseBody, this.$bizType, this.$source, r8);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        CardListRunCatchExtKt.a(this.$monitorId, "storage cache response", new AnonymousClass1(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
