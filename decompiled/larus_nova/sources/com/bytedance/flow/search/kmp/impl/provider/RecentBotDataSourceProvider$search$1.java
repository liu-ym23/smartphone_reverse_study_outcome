package com.bytedance.flow.search.kmp.impl.provider;

import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.provider.RecentBotDataSourceProvider", f = "RecentBotDataSourceProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {41}, m = "search", n = {"query", "collected", "currentAnchor", "serverHasMore", "loadFailed", MapMonitorConst.ATTEMPT}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2"})
public final class RecentBotDataSourceProvider$search$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentBotDataSourceProvider this$0;

    public RecentBotDataSourceProvider$search$1(RecentBotDataSourceProvider r100, Continuation<? super RecentBotDataSourceProvider$search$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
