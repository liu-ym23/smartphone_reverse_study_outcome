package com.bytedance.jedi.model.fetcher;

import com.bytedance.jedi.model.datasource.Optional;
import com.bytedance.jedi.model.datasource.OptionalKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0002\"\u0004\b\u0005\u0010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/bytedance/jedi/model/datasource/Optional;", "V", "kotlin.jvm.PlatformType", "K", "RESP", "it", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IBatchFetcher$Companion$DataSourceImpl$observe$2 extends Lambda implements Function1<Pair<Object, Object>, Optional<Object>> {
    public static final IBatchFetcher$Companion$DataSourceImpl$observe$2 INSTANCE = null;

    static {
        INSTANCE = new IBatchFetcher$Companion$DataSourceImpl$observe$2();
    }

    public IBatchFetcher$Companion$DataSourceImpl$observe$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Optional<Object> invoke2(Pair<Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return OptionalKt.a(r100.getSecond());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Optional<Object> invoke(Pair<Object, Object> r100) {
        return invoke2(r100);
    }
}
