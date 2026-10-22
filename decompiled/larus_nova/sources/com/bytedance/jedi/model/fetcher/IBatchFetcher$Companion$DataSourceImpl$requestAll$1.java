package com.bytedance.jedi.model.fetcher;

import com.bytedance.jedi.model.traceable.ITracePoint;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0000\u001a2\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002 \u0005*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "K", "V", "kotlin.jvm.PlatformType", "RESP", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/util/List;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IBatchFetcher$Companion$DataSourceImpl$requestAll$1 extends Lambda implements Function1<Object, List<? extends Pair<Object, Object>>> {
    final /* synthetic */ IBatchFetcher$Companion$DataSourceImpl<Object, Object, Object> this$0;

    public IBatchFetcher$Companion$DataSourceImpl$requestAll$1(IBatchFetcher$Companion$DataSourceImpl<Object, Object, Object> r100) {
        this.this$0 = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Pair<Object, Object>> invoke2(Object r100) {
        ITracePoint<Pair<Object, Object>> r101 = this.this$0.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.jedi.model.fetcher.IBatchFetcher<K of com.bytedance.jedi.model.fetcher.IBatchFetcherKt.toInheritance, V of com.bytedance.jedi.model.fetcher.IBatchFetcherKt.toInheritance, RESP of com.bytedance.jedi.model.fetcher.IBatchFetcherKt.toInheritance>");
        return ((IBatchFetcher) r101).f();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends Pair<Object, Object>> invoke(Object r100) {
        return invoke2(r100);
    }
}
