package com.ss.android.ugc.aweme.search.common.viewpager;

import com.ss.android.ugc.aweme.search.common.ISearchBackListener;
import com.ss.android.ugc.aweme.search.vision.result.IResultRenderListener;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/viewpager/IECPhotoSearchBaseFragment;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECPhotoSearchBaseFragment {
    void Cv();

    void gf(JSONObject r100);

    boolean handleBackPressed();

    void kd(IResultRenderListener r100);

    void setSearchBackListener(ISearchBackListener r100);
}
