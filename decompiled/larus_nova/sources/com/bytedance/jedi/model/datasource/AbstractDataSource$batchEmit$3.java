package com.bytedance.jedi.model.datasource;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a2\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002 \u0005*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "K", "V", "kotlin.jvm.PlatformType", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AbstractDataSource$batchEmit$3 extends Lambda implements Function1<Pair<Object, Object>, List<? extends Pair<Object, Object>>> {
    public static final AbstractDataSource$batchEmit$3 INSTANCE = null;

    static {
        INSTANCE = new AbstractDataSource$batchEmit$3();
    }

    public AbstractDataSource$batchEmit$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<Pair<Object, Object>> invoke2(Pair<Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return CollectionsKt.listOf(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends Pair<Object, Object>> invoke(Pair<Object, Object> r100) {
        return invoke2(r100);
    }
}
