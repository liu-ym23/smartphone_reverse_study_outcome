package com.larus.bmhome.view.actionbar.gaokao;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator", f = "GaokaoRankCalculator.kt", i = {0}, l = {17}, m = "calculateRank", n = {PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0"})
public final class GaokaoRankCalculator$calculateRank$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GaokaoRankCalculator this$0;

    public GaokaoRankCalculator$calculateRank$1(GaokaoRankCalculator r100, Continuation<? super GaokaoRankCalculator$calculateRank$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
