package com.ss.android.ugc.aweme.search.hostimpl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostimpl/ECSearchAwemeHostService;", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchAwemeHostService;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchAwemeHostService implements ITradeSearchAwemeHostService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchAwemeHostService f453269a = null;

    private ECSearchAwemeHostService() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final boolean banOvalBlur() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final boolean containCurrentPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String getPageType(FragmentActivity r100) {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String getPitayaUploadInfo(FragmentActivity r100) {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String getPrivacyState() {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final List<Pair<String, String>> getSearchHistoryForSugSession(SearchEnterParam r100) {
        Intrinsics.checkNotNullParameter(r100, "enterParam");
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final Object getValueByConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final View inflate(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void initSlice() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String nextPredictId() {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void openRoute(Context r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "map");
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void ovalDimBlur(View r100, float r101) {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final String staticBuildTransWithPitaya(FragmentActivity r100) {
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService
    public final void staticConsumePitayaUploadInfo(FragmentActivity r100) {
    }

    static {
        f453269a = new ECSearchAwemeHostService();
    }
}
