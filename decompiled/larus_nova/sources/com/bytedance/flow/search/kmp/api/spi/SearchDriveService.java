package com.bytedance.flow.search.kmp.api.spi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import pd6.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveService;", "Lcom/bytedance/kmp/spi/IKmpService;", "requestRecentDriveFileList", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveResult;", "length", "", "loadMoreLabel", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFileTypeIconResId", "entityType", "fileType", "fileName", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SearchDriveService extends a {
    Object G2(String r100, Continuation r101);

    int x0(String r100, String r101, String r102);
}
