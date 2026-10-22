package com.bytedance.jedi.model.traceable;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000326\u0010\u0004\u001a2\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0006 \u0007*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0006\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "K", "V", "it", "Lcom/bytedance/jedi/model/traceable/ITraceable;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TraceableObservedImpl$observeTraceable$1 extends Lambda implements Function1<ITraceable<Pair<Object, Object>>, Unit> {
    final /* synthetic */ TraceableObservedImpl<Object, Object> this$0;

    public TraceableObservedImpl$observeTraceable$1(TraceableObservedImpl<Object, Object> r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ITraceable<Pair<Object, Object>> r100) {
        ITracePoint<Pair<Object, Object>> r101 = this.this$0.f251194a.get();
        Intrinsics.checkNotNull(r101);
        r100.b(r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ITraceable<Pair<Object, Object>> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
