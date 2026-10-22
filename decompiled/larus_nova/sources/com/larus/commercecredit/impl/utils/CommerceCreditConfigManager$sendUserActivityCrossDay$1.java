package com.larus.commercecredit.impl.utils;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditConfigManager", f = "CommerceCreditConfigManager.kt", i = {0}, l = {TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER}, m = "sendUserActivityCrossDay", n = {"scene"}, s = {"L$0"})
public final class CommerceCreditConfigManager$sendUserActivityCrossDay$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommerceCreditConfigManager this$0;

    public CommerceCreditConfigManager$sendUserActivityCrossDay$1(CommerceCreditConfigManager r100, Continuation<? super CommerceCreditConfigManager$sendUserActivityCrossDay$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, null, this);
    }
}
