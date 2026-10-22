package com.ss.android.ugc.aweme.search.vision.result.v1;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.search.model.commodity.CommodityResultParam;
import com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel;
import com.ss.android.ugc.aweme.search.vision.model.data.Resources;
import com.ss.android.ugc.aweme.search.vision.model.data.SearchPhotoRequest;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/PhotoSearchBaseModel;", "Lcom/ss/android/ugc/aweme/search/vision/model/base/BaseSearchModel;", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PhotoSearchBaseModel extends BaseSearchModel {
    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ MutableLiveData<Object> getEcomSameCountLiveData();

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ boolean isHasMore();

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ void justSearchPhoto(SearchPhotoRequest r100, CommodityResultParam r101);

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ void loadMore(String r100);

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ SearchPhotoRequest obtainCurrentSearchPhotoRequest();

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ MutableLiveData<Resources<?>> obtainNetworkRequestLiveData();

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ void setSceneKey(int r100);

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ void setSearchSessionId(String r100);

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ void updateCurrentImageTosUri(String r100);

    @Override // com.ss.android.ugc.aweme.search.vision.model.base.BaseSearchModel
    public abstract /* synthetic */ void updatePhotoEnterModel(Object r100);

    public PhotoSearchBaseModel() {
    }
}
