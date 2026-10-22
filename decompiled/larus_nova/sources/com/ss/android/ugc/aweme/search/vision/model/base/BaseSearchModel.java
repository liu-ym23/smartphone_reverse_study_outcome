package com.ss.android.ugc.aweme.search.vision.model.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.BasicInfo;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.BizData;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.ECSearchCommodityResponse;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.LoadMoreConfig;
import com.ss.android.ugc.aweme.search.model.commodity.CommodityResultParam;
import com.ss.android.ugc.aweme.search.vision.model.data.Resources;
import com.ss.android.ugc.aweme.search.vision.model.data.SearchPhotoRequest;
import com.ss.android.ugc.aweme.search.vision.model.data.VideoSearchRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000e\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0004J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0004J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0004J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0004J\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/base/BaseSearchModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/ss/android/ugc/aweme/search/vision/model/data/SearchPhotoRequest;", "request", "", "appendPassThrough", "Lcom/ss/android/ugc/aweme/search/vision/model/data/VideoSearchRequest;", "appendPassThroughForVideo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ECSearchCommodityResponse;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "updateEcomSearchPassThrough", "updateEcomSearchAllPassThrough", "ecomSearchPassThroughReset", "Lorg/json/JSONObject;", "extraCouponJson", "updateCouponPassThrough", "", "ecomSearchPassThrough", "Ljava/lang/String;", "getEcomSearchPassThrough", "()Ljava/lang/String;", "setEcomSearchPassThrough", "(Ljava/lang/String;)V", "ecomSearchAllPassThrough", "getEcomSearchAllPassThrough", "setEcomSearchAllPassThrough", "", "imageQueryDetection", "Ljava/util/List;", "getImageQueryDetection", "()Ljava/util/List;", "setImageQueryDetection", "(Ljava/util/List;)V", "Lorg/json/JSONObject;", "getExtraCouponJson", "()Lorg/json/JSONObject;", "setExtraCouponJson", "(Lorg/json/JSONObject;)V", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseSearchModel extends ViewModel {
    private String ecomSearchAllPassThrough;
    private String ecomSearchPassThrough;
    private JSONObject extraCouponJson;
    private List<String> imageQueryDetection;

    public final void ecomSearchPassThroughReset() {
        this.ecomSearchPassThrough = null;
    }

    public abstract /* synthetic */ MutableLiveData<Object> getEcomSameCountLiveData();

    public abstract /* synthetic */ boolean isHasMore();

    public abstract /* synthetic */ void justSearchPhoto(SearchPhotoRequest r100, CommodityResultParam r101);

    public abstract /* synthetic */ void loadMore(String r100);

    public abstract /* synthetic */ SearchPhotoRequest obtainCurrentSearchPhotoRequest();

    public abstract /* synthetic */ MutableLiveData<Resources<?>> obtainNetworkRequestLiveData();

    public abstract /* synthetic */ void setSceneKey(int r100);

    public abstract /* synthetic */ void setSearchSessionId(String r100);

    public abstract /* synthetic */ void updateCurrentImageTosUri(String r100);

    public abstract /* synthetic */ void updatePhotoEnterModel(Object r100);

    public BaseSearchModel() {
    }

    public final String getEcomSearchAllPassThrough() {
        return this.ecomSearchAllPassThrough;
    }

    public final String getEcomSearchPassThrough() {
        return this.ecomSearchPassThrough;
    }

    public final JSONObject getExtraCouponJson() {
        return this.extraCouponJson;
    }

    public final List<String> getImageQueryDetection() {
        return this.imageQueryDetection;
    }

    public final void appendPassThrough(SearchPhotoRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        r100.f453644m = this.ecomSearchPassThrough;
        r100.f453645n = this.ecomSearchAllPassThrough;
    }

    public final void appendPassThroughForVideo(VideoSearchRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        r100.getClass();
    }

    public final void setEcomSearchAllPassThrough(String r100) {
        this.ecomSearchAllPassThrough = r100;
    }

    public final void setEcomSearchPassThrough(String r100) {
        this.ecomSearchPassThrough = r100;
    }

    public final void setExtraCouponJson(JSONObject r100) {
        this.extraCouponJson = r100;
    }

    public final void setImageQueryDetection(List<String> r100) {
        this.imageQueryDetection = r100;
    }

    public final void updateCouponPassThrough(JSONObject r100) {
        this.extraCouponJson = r100;
    }

    public final void updateEcomSearchAllPassThrough(ECSearchCommodityResponse r100) {
        if (r100 == null) goto L8;
        BizData r101 = r100.getBizData();
        if (r101 == null) goto L8;
        BasicInfo r102 = r101.getBasicInfo();
        if (r102 == null) goto L8;
        String r103 = r102.getEcomSearchAllPassThrough();
    L9:
        this.ecomSearchAllPassThrough = r103;
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void updateEcomSearchPassThrough(ECSearchCommodityResponse r100) {
        if (r100 == null) goto L8;
        BizData r101 = r100.getBizData();
        if (r101 == null) goto L8;
        LoadMoreConfig r102 = r101.getLoadMoreConfig();
        if (r102 == null) goto L8;
        String r103 = r102.getEcomSearchPassThrough();
    L9:
        this.ecomSearchPassThrough = r103;
        return;
    L8:
        r103 = null;
        goto L9
    }
}
