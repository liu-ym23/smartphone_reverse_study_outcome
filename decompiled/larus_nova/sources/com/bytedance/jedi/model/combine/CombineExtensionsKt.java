package com.bytedance.jedi.model.combine;

import com.bytedance.jedi.model.datasource.IDataSource;
import com.bytedance.jedi.model.ext.cache.guava.LruCache;
import com.bytedance.jedi.model.fetcher.AbstractFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"model_release"}, k = 2, mv = {1, 7, 1})
public final class CombineExtensionsKt {
    public static Combine a(AbstractFetcher r100, LruCache r101) {
        CombineExtensionsKt$withCache$1 r102 = CombineExtensionsKt$withCache$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "cache");
        Intrinsics.checkNotNullParameter(r102, "block");
        Combine.Companion r103 = Combine.f251051d;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        IDataSource r104 = (IDataSource) r101.f251048a.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "fetcher");
        Intrinsics.checkNotNullParameter(r104, "cache");
        Intrinsics.checkNotNullParameter(r102, "block");
        Combine.Mapper r105 = new Combine.Mapper();
        r102.invoke(r105);
        return new Combine(r100, r104, r105);
    }
}
