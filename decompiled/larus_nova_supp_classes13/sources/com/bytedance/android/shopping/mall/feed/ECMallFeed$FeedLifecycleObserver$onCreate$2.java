package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/c;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.ECMallFeed$FeedLifecycleObserver$onCreate$2", f = "ECMallFeed.kt", i = {}, l = {4052}, m = "invokeSuspend", n = {}, s = {})
public final class ECMallFeed$FeedLifecycleObserver$onCreate$2 extends SuspendLambda implements Function1<Continuation<? super com.bytedance.android.shopping.api.mall.c>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ECMallFeed.FeedLifecycleObserver this$0;

    public ECMallFeed$FeedLifecycleObserver$onCreate$2(ECMallFeed.FeedLifecycleObserver r1, Continuation r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ECMallFeed$FeedLifecycleObserver$onCreate$2(this.this$0, r3);
    }

    public final Object invoke(Object r2) {
        return create((Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ECMallFeed$FeedLifecycleObserver$onCreate$2 r2 = (ECMallFeed$FeedLifecycleObserver$onCreate$2) this.L$0;
        ResultKt.throwOnFailure(r9);
    L13:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        this.L$0 = this;
        this.label = 1;
        final SafeContinuation r10 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        ECMallFeed r3 = this.this$0.b;
        r3.getClass();
        ECMallFavoriteSectionHelper r4 = r3.V;
        Context r5 = r3.e0();
        Function1<com.bytedance.android.shopping.api.mall.c, Unit> r7 = new ECMallFeed$FeedLifecycleObserver$onCreate$2$1$1(r10);
        Lazy r6 = ECMallFavoriteSectionHelper.I;
        r4.B(r5, 0, true, null, r7);
        r9 = r10.getOrThrow();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r9 != r0) goto L13;
        return r0;
    }
}
