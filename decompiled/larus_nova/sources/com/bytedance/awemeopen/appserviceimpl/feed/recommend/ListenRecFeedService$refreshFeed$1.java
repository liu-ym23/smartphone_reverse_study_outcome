package com.bytedance.awemeopen.appserviceimpl.feed.recommend;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lr14/c;", "items", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ListenRecFeedService$refreshFeed$1 extends Lambda implements Function1<List<? extends r14.c>, List<? extends r14.c>> {
    final /* synthetic */ com.bytedance.awemeopen.domain.feed.recommend.b $recFeedParams;
    final /* synthetic */ ListenRecFeedService this$0;

    public ListenRecFeedService$refreshFeed$1(ListenRecFeedService r100, com.bytedance.awemeopen.domain.feed.recommend.b r101) {
        this.this$0 = r100;
        this.$recFeedParams = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<r14.c> invoke2(List<r14.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        return this.this$0.f198114c.invoke(r100, this.$recFeedParams, Boolean.TRUE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends r14.c> invoke(List<? extends r14.c> r100) {
        return invoke2(r100);
    }
}
