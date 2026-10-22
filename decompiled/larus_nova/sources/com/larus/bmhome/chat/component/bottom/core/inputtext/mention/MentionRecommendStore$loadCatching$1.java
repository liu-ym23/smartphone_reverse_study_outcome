package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore", f = "MentionRecommendStore.kt", i = {}, l = {191}, m = "loadCatching", n = {}, s = {})
final class MentionRecommendStore$loadCatching$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MentionRecommendStore this$0;

    public MentionRecommendStore$loadCatching$1(MentionRecommendStore r100, Continuation<? super MentionRecommendStore$loadCatching$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MentionRecommendStore.b(this.this$0, null, this);
    }
}
