package com.bytedance.android.shopping.deepfeed.data.repo;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/repo/i;", "result", "", "invoke", "(Lcom/bytedance/android/shopping/deepfeed/data/repo/i;)V", "finish"}, k = 3, mv = {1, 4, 3})
final class DeepFeedBFFRequest$requestCouponWaistReturnData$1 extends Lambda implements Function1<i, Unit> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ Ref.BooleanRef $finished;

    public DeepFeedBFFRequest$requestCouponWaistReturnData$1(Ref.BooleanRef r1, Function1 r2) {
        this.$finished = r1;
        this.$callback = r2;
        super(1);
    }

    public final void invoke(i r3) {
        Ref.BooleanRef r0 = this.$finished;
        if (r0.element == false) goto L5;
        return;
    L5:
        r0.element = true;
        this.$callback.invoke(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i) r1);
        return Unit.INSTANCE;
    }
}
