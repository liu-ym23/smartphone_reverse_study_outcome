package com.bytedance.locallife.model.poi.resp;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiDetailApiDuration;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public class PoiDetail implements Serializable {

    @SerializedName("ab_map")
    public PoiServerAbmap abMap;

    @SerializedName("actual_source_type")
    public int actualSourceType;

    @SerializedName("body_in_container_offset")
    private PoiDistanceModel bodyInContainerOffset;

    @SerializedName("collect_text_config")
    @JsonAdapter(StringJsonAdapterFactory.class)
    public CollectTextConfig collectTextConfig;

    @SerializedName("enable_fling")
    private Boolean enableFling;

    @SerializedName("enable_over_scroll")
    private Boolean enableOverScroll;

    @SerializedName("expand_offset")
    private PoiDistanceModel expandOffset;

    @SerializedName("fast_close_coefficient")
    private Float fastCloseCoefficient;

    @SerializedName("has_mp_spu")
    public boolean hasMpSpu;

    @SerializedName("is_intention_page")
    public int isIntentionPage;

    @SerializedName("lynx_common_data")
    public String lynxCommonData;

    @SerializedName("lynx_global_props")
    private String lynxGlobalProps;

    @SerializedName("detail_api_duration")
    public PoiDetailApiDuration mPoiDetailApiDuration;

    @SerializedName("max_unfold_offset")
    private PoiDistanceModel maxUnfoldOffset;

    @SerializedName("must_close_to_half")
    private Boolean mustCloseToHalf;

    @SerializedName("poi_industry_skin_config")
    private HashMap<String, JsonObject> pageSkinStyle;

    @SerializedName("poi_distance_bury")
    public long poiDistanceBury;

    @SerializedName("poi_ext")
    public PoiExtension poiExtension;

    @SerializedName("auto_open_service")
    public PoiServiceEntryStruct poiServiceEntryStruct;

    @SerializedName("poi_info")
    public PoiStruct poiStruct;

    @SerializedName("product_info")
    public PoiProductInfo productInfo;

    @SerializedName("scroll_offset_to_unfold")
    private Integer scrollOffsetToUnfold;

    @SerializedName("slow_close_percent")
    private Float slowClosePercent;

    @SerializedName("top_offset")
    private PoiDistanceModel topOffset;

    @AllowImpl
    public String getBackendType() {
        PoiStruct r100 = this.poiStruct;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getBackendTypeCode();
    }

    @AllowImpl
    public String getCityCode() {
        PoiStruct r100 = this.poiStruct;
        if (r100 == null) goto L9;
        Address r101 = r100.address;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.cityCode;
    L9:
        return null;
    }

    @AllowImpl
    public String getPoiId() {
        PoiStruct r100 = this.poiStruct;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getPoiId();
    }

    @AllowImpl
    public String getPoiName() {
        PoiStruct r100 = this.poiStruct;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getPoiName();
    }

    @AllowImpl
    public boolean isCollected() {
        PoiStruct r100 = this.poiStruct;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getCollectStatus() != 1) goto L7;
        return true;
    }

    @AllowImpl
    public boolean isNoMargin() {
        PoiServerAbmap r100 = this.abMap;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (1 != r100.getNoMargin()) goto L9;
        return true;
    L9:
        return false;
    }

    public PoiDetail() {
        this.poiDistanceBury = -1;
        this.hasMpSpu = false;
    }

    @AllowImpl
    public PoiDistanceModel getBodyInContainerOffset() {
        return this.bodyInContainerOffset;
    }

    @AllowImpl
    public Boolean getEnableFling() {
        return this.enableFling;
    }

    @AllowImpl
    public Boolean getEnableOverScroll() {
        return this.enableOverScroll;
    }

    @AllowImpl
    public PoiDistanceModel getExpandOffset() {
        return this.expandOffset;
    }

    @AllowImpl
    public Float getFastCloseCoefficient() {
        return this.fastCloseCoefficient;
    }

    @AllowImpl
    public String getLynxCommonData() {
        return this.lynxCommonData;
    }

    @AllowImpl
    public String getLynxGlobalProps() {
        return this.lynxGlobalProps;
    }

    @AllowImpl
    public PoiDistanceModel getMaxUnfoldOffset() {
        return this.maxUnfoldOffset;
    }

    @AllowImpl
    public Boolean getMustCloseToHalf() {
        return this.mustCloseToHalf;
    }

    @AllowImpl
    public HashMap<String, JsonObject> getPageSkinStyle() {
        return this.pageSkinStyle;
    }

    @AllowImpl
    public Integer getScrollOffsetToUnfold() {
        return this.scrollOffsetToUnfold;
    }

    @AllowImpl
    public Float getSlowClosePercent() {
        return this.slowClosePercent;
    }

    @AllowImpl
    public PoiDistanceModel getTopOffset() {
        return this.topOffset;
    }

    @AllowImpl
    public void setBodyInContainerOffset(PoiDistanceModel r100) {
        this.bodyInContainerOffset = r100;
    }

    @AllowImpl
    public void setEnableFling(Boolean r100) {
        this.enableFling = r100;
    }

    @AllowImpl
    public void setEnableOverScroll(Boolean r100) {
        this.enableOverScroll = r100;
    }

    @AllowImpl
    public void setExpandOffset(PoiDistanceModel r100) {
        this.expandOffset = r100;
    }

    @AllowImpl
    public void setFastCloseCoefficient(Float r100) {
        this.fastCloseCoefficient = r100;
    }

    @AllowImpl
    public void setMaxUnfoldOffset(PoiDistanceModel r100) {
        this.maxUnfoldOffset = r100;
    }

    @AllowImpl
    public void setMustCloseToHalf(Boolean r100) {
        this.mustCloseToHalf = r100;
    }

    @AllowImpl
    public void setScrollOffsetToUnfold(Integer r100) {
        this.scrollOffsetToUnfold = r100;
    }

    @AllowImpl
    public void setSlowClosePercent(Float r100) {
        this.slowClosePercent = r100;
    }

    @AllowImpl
    public void setTopOffset(PoiDistanceModel r100) {
        this.topOffset = r100;
    }
}
