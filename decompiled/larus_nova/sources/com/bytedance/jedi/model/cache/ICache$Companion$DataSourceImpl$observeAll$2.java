package com.bytedance.jedi.model.cache;

import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003 \u0004*\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u001a\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "K", "V", "kotlin.jvm.PlatformType", "it", "Lcom/bytedance/jedi/model/traceable/ITraceable;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ICache$Companion$DataSourceImpl$observeAll$2 extends Lambda implements Function1<ITraceable<Pair<Object, Object>>, Pair<Object, Object>> {
    public static final ICache$Companion$DataSourceImpl$observeAll$2 INSTANCE = null;

    static {
        INSTANCE = new ICache$Companion$DataSourceImpl$observeAll$2();
    }

    public ICache$Companion$DataSourceImpl$observeAll$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Object, Object> invoke2(ITraceable<Pair<Object, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.payload();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<Object, Object> invoke(ITraceable<Pair<Object, Object>> r100) {
        return invoke2(r100);
    }
}
