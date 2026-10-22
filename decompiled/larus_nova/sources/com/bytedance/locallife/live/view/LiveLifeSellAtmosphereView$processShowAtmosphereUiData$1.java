package com.bytedance.locallife.live.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView", f = "LiveLifeSellAtmosphereView.kt", i = {0, 1, 2, 3}, l = {238, 246, 252, 258, 262}, m = "processShowAtmosphereUiData", n = {"this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0"})
public final class LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveLifeSellAtmosphereView this$0;

    public LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1(LiveLifeSellAtmosphereView r100, Continuation<? super LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LiveLifeSellAtmosphereView r101 = this.this$0;
        int r102 = LiveLifeSellAtmosphereView.f260779w;
        return r101.g(null, this);
    }
}
