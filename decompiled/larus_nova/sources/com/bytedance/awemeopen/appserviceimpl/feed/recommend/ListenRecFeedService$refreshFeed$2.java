package com.bytedance.awemeopen.appserviceimpl.feed.recommend;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lr14/c;", "data", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;Ljava/lang/Exception;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ListenRecFeedService$refreshFeed$2 extends Lambda implements Function2<List<? extends r14.c>, Exception, Unit> {
    final /* synthetic */ r34.b<r14.c> $callback;

    public ListenRecFeedService$refreshFeed$2(r34.b<r14.c> r100) {
        this.$callback = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<r14.c> r100, Exception r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L6;
        this.$callback.onSuccess(r100);
        return;
    L6:
        this.$callback.onFail(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends r14.c> r100, Exception r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
