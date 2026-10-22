package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchActionRecommendInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "actionRecommends", "", "Lcom/ss/android/lark/search/dto/info/SearchActionRecommend;", "maxRows", "", "<init>", "(Ljava/util/List;I)V", "getActionRecommends", "()Ljava/util/List;", "setActionRecommends", "(Ljava/util/List;)V", "getMaxRows", "()I", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchActionRecommendInfo extends SearchBaseInfo {
    private List<SearchActionRecommend> actionRecommends;
    private final int maxRows;

    public final List<SearchActionRecommend> getActionRecommends() {
        return this.actionRecommends;
    }

    public final int getMaxRows() {
        return this.maxRows;
    }

    public final void setActionRecommends(List<SearchActionRecommend> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionRecommends = r100;
    }

    public SearchActionRecommendInfo(List<SearchActionRecommend> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "actionRecommends");
        this.actionRecommends = r100;
        this.maxRows = r101;
        this.type = SearchCommonConstants.SearchResultType.ACTION;
    }
}
