package com.bytedance.jedi.model.fetcher;

import com.bytedance.jedi.model.datasource.IDataSource;
import com.bytedance.jedi.model.traceable.ITracePoint;
import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0002\"\u0004\b\u0004\u0010\u0003\"\u0004\b\u0005\u0010\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u00070\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "K", "V", "RESP", "traceable", "Lcom/bytedance/jedi/model/traceable/ITraceable;", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/model/traceable/ITraceable;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IBatchFetcher$Companion$DataSourceImpl$observeAll$1 extends Lambda implements Function1<ITraceable<Pair<Object, Object>>, Boolean> {
    final /* synthetic */ IDataSource<?, ?>[] $exclude;

    public IBatchFetcher$Companion$DataSourceImpl$observeAll$1(IDataSource<?, ?>[] r100) {
        this.$exclude = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(ITraceable<Pair<Object, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceable");
        IDataSource<?, ?>[] r101 = this.$exclude;
        int r102 = r101.length;
        boolean r103 = false;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L13;
        ITracePoint<Pair<?, ?>> r105 = r101[r104].c();
        if (r105 == null) goto L8;
        boolean r106 = r100.a(r105);
    L9:
        if (r106 == true) goto L10;
        r104 = r104 + 1;
        goto L4
    L10:
        r103 = true;
        goto L13
    L8:
        r106 = true;
    L13:
        return Boolean.valueOf(!r103);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ITraceable<Pair<Object, Object>> r100) {
        return invoke2(r100);
    }
}
