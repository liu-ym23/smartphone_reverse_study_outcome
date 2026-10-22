package com.ss.android.ugc.aweme.search.hostapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0006H&J$\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u0006H&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u0006H&J,\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"H&J\u001a\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020&H&J\u0012\u0010'\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010(\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&¨\u0006)"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchAwemeHostService;", "", "banOvalBlur", "", "containCurrentPage", "pageName", "", "getPageType", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "getPitayaUploadInfo", "activity", "getPrivacyState", "getSearchHistoryForSugSession", "", "Lkotlin/Pair;", "enterParam", "Lcom/ss/android/ugc/aweme/search/model/SearchEnterParam;", "getValueByConfig", "key", WidgetCostModule.TYPE_INFLATE, "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "layoutId", "", "initSlice", "", "nextPredictId", "openRoute", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "schema", "map", "", "ovalDimBlur", "dimView", "dimRadius", "", "staticBuildTransWithPitaya", "staticConsumePitayaUploadInfo", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ITradeSearchAwemeHostService {
    boolean banOvalBlur();

    boolean containCurrentPage(String r100);

    String getPageType(FragmentActivity r100);

    String getPitayaUploadInfo(FragmentActivity r100);

    String getPrivacyState();

    List<Pair<String, String>> getSearchHistoryForSugSession(SearchEnterParam r100);

    Object getValueByConfig(String r100);

    View inflate(ViewGroup r100, int r101);

    void initSlice();

    String nextPredictId();

    void openRoute(Context r100, String r101, Map<String, String> r102);

    void ovalDimBlur(View r100, float r101);

    String staticBuildTransWithPitaya(FragmentActivity r100);

    void staticConsumePitayaUploadInfo(FragmentActivity r100);
}
