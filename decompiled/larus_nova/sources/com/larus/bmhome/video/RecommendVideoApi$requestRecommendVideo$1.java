package com.larus.bmhome.video;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.RecommendVideoApi", f = "RecommendVideoApi.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {169}, m = "requestRecommendVideo", n = {"scene", "type", "messageId", "recommendType", "page", "isInnerStreamPreload", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "J$0"})
public final class RecommendVideoApi$requestRecommendVideo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApi this$0;

    public RecommendVideoApi$requestRecommendVideo$1(RecommendVideoApi r100, Continuation<? super RecommendVideoApi$requestRecommendVideo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        RecommendVideoApi r100 = this.this$0;
        RecommendVideoApi r111 = RecommendVideoApi.f315177a;
        return r100.e(null, null, 0, 0, false, false, null, null, null, null, null, this);
    }
}
