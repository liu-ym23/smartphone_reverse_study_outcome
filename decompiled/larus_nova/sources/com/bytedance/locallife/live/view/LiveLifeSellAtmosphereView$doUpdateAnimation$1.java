package com.bytedance.locallife.live.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView", f = "LiveLifeSellAtmosphereView.kt", i = {0, 0, 2, 2, 4, 4}, l = {331, 332, 343, 347, 353, 357}, m = "doUpdateAnimation", n = {"this", "atmosphereUiData", "this", "atmosphereUiData", "this", "atmosphereUiData"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class LiveLifeSellAtmosphereView$doUpdateAnimation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveLifeSellAtmosphereView this$0;

    public LiveLifeSellAtmosphereView$doUpdateAnimation$1(LiveLifeSellAtmosphereView r100, Continuation<? super LiveLifeSellAtmosphereView$doUpdateAnimation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LiveLifeSellAtmosphereView r101 = this.this$0;
        int r102 = LiveLifeSellAtmosphereView.f260779w;
        return r101.f(null, null, this);
    }
}
