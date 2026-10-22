package com.bytedance.jedi.model.datasource;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "K", "kotlin.jvm.PlatformType", "V", "it", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Pair;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AbstractDataSource$batchEmit$1$1 extends Lambda implements Function1<Pair<Object, Object>, Object> {
    public static final AbstractDataSource$batchEmit$1$1 INSTANCE = null;

    static {
        INSTANCE = new AbstractDataSource$batchEmit$1$1();
    }

    public AbstractDataSource$batchEmit$1$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Pair<Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.getFirst();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Pair<Object, Object> r100) {
        return invoke2(r100);
    }
}
