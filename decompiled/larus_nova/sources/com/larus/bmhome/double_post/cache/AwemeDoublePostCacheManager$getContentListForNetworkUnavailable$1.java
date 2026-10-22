package com.larus.bmhome.double_post.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager", f = "AwemeDoublePostCacheManager.kt", i = {}, l = {100}, m = "getContentListForNetworkUnavailable", n = {}, s = {})
public final class AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwemeDoublePostCacheManager this$0;

    public AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1(AwemeDoublePostCacheManager r100, Continuation<? super AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
