package com.ss.android.lark.search.dto.info;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchSectionInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "data", "", "getData", "()Ljava/util/List;", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSectionInfo extends SearchBaseInfo {
    private final List<SearchBaseInfo> data;

    public SearchSectionInfo() {
        this.data = new ArrayList();
    }

    public final List<SearchBaseInfo> getData() {
        return this.data;
    }
}
