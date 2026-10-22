package com.ss.android.lark.search.dto.info;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchHistoryListInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "historyList", "", "Lcom/ss/android/lark/search/dto/info/SearchInfoHistory;", "maxRows", "", "<init>", "(Ljava/util/List;I)V", "getHistoryList", "()Ljava/util/List;", "getMaxRows", "()I", "equals", "", "other", "", "hashCode", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchHistoryListInfo extends SearchBaseInfo {
    private final List<SearchInfoHistory> historyList;
    private final int maxRows;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public int hashCode() {
        return Objects.hash(new Object[]{getId(), Integer.valueOf(this.type), this.historyList, Integer.valueOf(this.maxRows)});
    }

    public final List<SearchInfoHistory> getHistoryList() {
        return this.historyList;
    }

    public final int getMaxRows() {
        return this.maxRows;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean equals(Object r100) {
        if (super.equals(r100) == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof SearchHistoryListInfo) == false) goto L24;
        SearchHistoryListInfo r101 = (SearchHistoryListInfo) r100;
        if (Intrinsics.areEqual(r101.historyList, this.historyList) == false) goto L13;
        if (r101.maxRows == this.maxRows) goto L24;
    L13:
        if (r101.historyList.size() == this.historyList.size()) goto L15;
        return false;
    L15:
        if (r101.maxRows != this.maxRows) goto L29;
        Iterator<T> r102 = r101.historyList.iterator();
        int r103 = 0;
    L19:
        if (r102.hasNext() == false) goto L24;
        int r104 = r103 + 1;
        if (Intrinsics.areEqual((SearchInfoHistory) r102.next(), ListProtector.get(this.historyList, r103)) == false) goto L30;
        r103 = r104;
        goto L19
    L30:
        return false;
    L29:
        return false;
    L24:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchHistoryListInfo(List<? extends SearchInfoHistory> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "historyList");
        this.historyList = r100;
        this.maxRows = r101;
        this.type = SearchCommonConstants.SearchResultType.HISTORY;
    }
}
