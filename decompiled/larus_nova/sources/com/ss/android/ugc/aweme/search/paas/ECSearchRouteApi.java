package com.ss.android.ugc.aweme.search.paas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/search/paas/ECSearchRouteApi;", "", "routeToECSearch", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "searchResultParam", "Lcom/ss/android/ugc/aweme/search/model/SearchResultParam;", "searchEnterParam", "Lcom/ss/android/ugc/aweme/search/model/SearchEnterParam;", "options", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "intervalTime", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECSearchRouteApi {
    boolean routeToECSearch(Context r100, SearchResultParam r101, SearchEnterParam r102, Bundle r103, Uri r104, long r105);
}
