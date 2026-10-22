package com.bytedance.applet.impl.moa;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.moa.MoaGrantingNetworkGateway", f = "MoaGrantingNetworkGateway.kt", i = {0, 0, 0, 1, 1}, l = {22, ECDraweeView.SELF_ADJUST_3X_TO_DP}, m = "completeGranting", n = {"serverOption", "retryDelayMS", "attempt", "serverOption", "retryDelayMS"}, s = {"L$0", "L$1", "I$2", "L$0", "L$1"})
public final class MoaGrantingNetworkGateway$completeGranting$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaGrantingNetworkGateway this$0;

    public MoaGrantingNetworkGateway$completeGranting$1(MoaGrantingNetworkGateway r1, Continuation<? super MoaGrantingNetworkGateway$completeGranting$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
