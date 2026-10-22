package com.bytedance.jedi.arch.ext.list.differ;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"asPrefetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "enablePrefetch", "", "prefetchDistance", "", "ext_list_release"}, k = 2, mv = {1, 1, 16})
public final class JediListPrefetcherKt {
    public static final JediListPrefetcher asPrefetcher(JediListPrefetcher.Fetcher r100, boolean r101, int r102) {
        return new JediListPrefetcher.Builder(r100).setEnablePrefetch(r101).setPrefetchDistance(r102).build();
    }

    public static /* synthetic */ JediListPrefetcher asPrefetcher$default(JediListPrefetcher.Fetcher r100, boolean r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = 10;
    L9:
        return asPrefetcher(r100, r101, r102);
    }
}
