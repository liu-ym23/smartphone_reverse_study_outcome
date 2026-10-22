package com.bytedance.jedi.model.fetcher;

import com.bytedance.jedi.model.datasource.IDataSource;
import com.bytedance.jedi.model.traceable.ITraceableObserved;
import com.bytedance.jedi.model.traceable.Traceable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0004H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "K", "V", "RESP", "it", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class PointcutKt$fire$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ IBatchFetcher<Object, Object, Object> $this_fire;

    public PointcutKt$fire$2(IBatchFetcher<Object, Object, Object> r100) {
        this.$this_fire = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        List r101 = this.$this_fire.f();
        IBatchFetcher<Object, Object, Object> r102 = this.$this_fire;
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Pair r104 = (Pair) r103.next();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        IDataSource r105 = (IDataSource) ((AbstractBatchFetcher) r102).f251070a.getValue();
        if ((r105 instanceof ITraceableObserved) == false) goto L8;
        ITraceableObserved r106 = (ITraceableObserved) r105;
    L9:
        if (r106 == null) goto L4;
        r106.b(Traceable.Companion.a(Traceable.f251191c, TuplesKt.to(r104.getFirst(), r104.getSecond())));
        goto L4
    L8:
        r106 = null;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
