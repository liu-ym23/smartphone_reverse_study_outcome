package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.feed.model.NearbyCities;

/* JADX INFO: loaded from: classes21.dex */
public class h extends BaseResponse {

    @SerializedName("active_description")
    String activeDescription;

    @SerializedName("active_id")
    String activeId;

    @SerializedName("current_city")
    NearbyCities.CityBean currentCity;

    @SerializedName("current_city_groupon_page")
    NearbyCities.CityBean currentCityGrouponPage;

    @SerializedName("current_city_groupon_tab")
    NearbyCities.CityBean currentCityGrouponTab;

    @SerializedName("current_position_name")
    String currentPositionName;

    public h() {
    }
}
