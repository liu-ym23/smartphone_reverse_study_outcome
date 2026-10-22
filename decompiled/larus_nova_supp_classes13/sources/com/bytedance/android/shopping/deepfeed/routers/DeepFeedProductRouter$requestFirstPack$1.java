package com.bytedance.android.shopping.deepfeed.routers;

import com.bytedance.android.shopping.deepfeed.event.g;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import uc3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedProductRouter$requestFirstPack$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ g $enterInnerViewEvent;
    final /* synthetic */ f $monitor;
    final /* synthetic */ DeepFeedProductRouter this$0;

    public DeepFeedProductRouter$requestFirstPack$1(DeepFeedProductRouter r1, f r2, g r3) {
        this.$monitor = r2;
        super(1);
    }

    public final void invoke(boolean r3) {
        this.$monitor.j(System.currentTimeMillis());
        Lazy r4 = DeepFeedProductRouter.a;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
