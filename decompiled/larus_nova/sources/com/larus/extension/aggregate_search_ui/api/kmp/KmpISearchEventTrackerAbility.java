package com.larus.extension.aggregate_search_ui.api.kmp;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.SearchTabTrackInfo;
import com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import m1a.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H&J\u001c\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\rH&J.\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH¦@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\nH&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\nH&¨\u0006'"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpISearchEventTrackerAbility;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentAbility;", "setEnterMethod", "", "enterMethod", "", "trackSearchDomainSwitch", "fromTab", "toTab", "switchLevel", "", "updateSelectedSearchFilters", "trackInfoList", "", "Lcom/bytedance/flow/search/kmp/api/model/SearchTabTrackInfo;", "trackSearchFilterShow", "filterType", FilterData.FilterSheetItem.Id.FILTER_VALUE, "trackClickSearchButton", "query", "trackSearchResultShow", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "reason", "trackSearchResultClick", "data", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "trackStayDetailPage", "trackSearchHistoryShow", "historyItems", "Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryItem;", "trackSearchHistoryManage", "opType", "rank", "beforeCnt", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShowHistoryCount", "updateShowHistoryCount", "count", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface KmpISearchEventTrackerAbility extends a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void trackSearchResultShow$default(KmpISearchEventTrackerAbility r100, ISearchDataPayload r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.trackSearchResultShow(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackSearchResultShow");
        }
    }

    int getShowHistoryCount();

    void setEnterMethod(String r100);

    void trackClickSearchButton(String r100);

    void trackSearchDomainSwitch(String r100, String r101, int r102);

    void trackSearchFilterShow(String r100, String r101);

    Object trackSearchHistoryManage(String r100, String r101, int r102, int r103, Continuation<? super Unit> r104);

    void trackSearchHistoryShow(List<SearchHistoryItem> r100);

    void trackSearchResultClick(FlowSearchData r100);

    void trackSearchResultShow(ISearchDataPayload r100, String r101);

    void trackStayDetailPage();

    void updateSelectedSearchFilters(List<SearchTabTrackInfo> r100);

    void updateShowHistoryCount(int r100);
}
