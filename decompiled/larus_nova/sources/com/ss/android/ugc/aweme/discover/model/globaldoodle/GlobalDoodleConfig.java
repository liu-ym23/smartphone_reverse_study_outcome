package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.SearchClickLinkConfig;
import com.ss.android.ugc.aweme.discover.model.ShoppingCart;
import com.ss.android.ugc.aweme.discover.model.pushtimecard.PushTimeLynxFeedOutData;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class GlobalDoodleConfig implements Serializable {
    public static final int DOUBLE_COLUMN_LAYOUT_TYPE_STAGGER = 3;
    public static final int FROM_COMMODITY_SELECTS = 1;
    public static final int FROM_NORMAL = 0;
    public static final int INIT_DOUBLE_COLUMN_LAYOUT_TYPE = -1;

    @SerializedName("cart_container")
    public CartContainer cartContainer;

    @SerializedName("double_column_layout_type")
    private int doubleColumnLayoutType;

    @SerializedName("ecom_intent")
    private String ecomIntent;

    @SerializedName("ecom_intent_map")
    private Map<String, Object> ecomIntentMap;

    @SerializedName("enter_from")
    public String enterFrom;

    @SerializedName("feedback_config")
    public SearchClickLinkConfig feedbackConfig;

    @SerializedName("feelgood_msg")
    public FeelGoodInfo feelgoodInfo;

    @SerializedName("guide_search_info")
    public GuideSearchDataBindConfig guildSearchConfig;

    @SerializedName("has_sidebar")
    public boolean hasSideBar;

    @SerializedName("live_inner_search_change_channel")
    public String liveInnerSearchChangeChannel;

    @SerializedName("live_inner_search_change_enter_from")
    public String liveInnerSearchChangeEnterFrom;

    @SerializedName("loadmore_preload_threshold")
    public int loadMorePreloadThreshold;

    @SerializedName("insert_coupon_config")
    public SurpriseInsertCouponConfig mCouponInsertConfig;

    @SerializedName("no_result_config")
    public SearchClickLinkConfig noResultConfig;
    private List<String> patchItems;

    @SerializedName("pendant_toast")
    public String pendantToast;

    @SerializedName("pitaya_data")
    public Map<String, String> pitayaData;

    @SerializedName("push_time_feed_out_lynx_items")
    public List<PushTimeLynxFeedOutData> pushTimeLynxFeedOutData;

    @SerializedName("query_correct_type")
    public int queryCorrectType;

    @SerializedName("keyword")
    public String requestKeyword;

    @SerializedName("result_from")
    public int resultFrom;

    @SerializedName("shopping_cart")
    public ShoppingCart shoppingCart;

    @SerializedName(SubInfo.KEY_FORMAT)
    public String showFormat;

    @SerializedName("shown_count")
    public int shownCount;

    @SerializedName("srp_algo_for_wind_vane")
    private String srpAlgoForWindVane;

    @SerializedName("toast_info")
    public ToastInfo toastInfo;

    @SerializedName("user_guide")
    public SearchUserGuide userGuide;

    public Boolean getHasSideBar() {
        return Boolean.valueOf(this.hasSideBar);
    }

    public GlobalDoodleConfig() {
        this.resultFrom = 0;
        this.queryCorrectType = 1;
        this.enterFrom = null;
        this.loadMorePreloadThreshold = 0;
        this.shoppingCart = null;
        this.pitayaData = null;
        this.cartContainer = null;
        this.shownCount = 0;
        this.guildSearchConfig = null;
        this.mCouponInsertConfig = null;
        this.pushTimeLynxFeedOutData = null;
        this.hasSideBar = false;
        this.toastInfo = null;
        this.liveInnerSearchChangeChannel = null;
        this.liveInnerSearchChangeEnterFrom = null;
        this.ecomIntent = null;
        this.srpAlgoForWindVane = null;
        this.ecomIntentMap = null;
        this.doubleColumnLayoutType = -1;
        this.patchItems = new ArrayList();
    }

    public int getDoubleColumnLayoutType() {
        return this.doubleColumnLayoutType;
    }

    public String getEcomIntent() {
        return this.ecomIntent;
    }

    public Map<String, Object> getEcomIntentMap() {
        return this.ecomIntentMap;
    }

    public List<String> getPatchItems() {
        return this.patchItems;
    }

    public String getSrpAlgoForWindVane() {
        return this.srpAlgoForWindVane;
    }

    public void addPatchItem(List<String> r100) {
        this.patchItems.addAll(r100);
    }

    public void setEcomIntent(String r100) {
        this.ecomIntent = r100;
    }

    public void setEcomIntentMap(Map<String, Object> r100) {
        this.ecomIntentMap = r100;
    }

    public void setHasSideBar(Boolean r100) {
        this.hasSideBar = r100.booleanValue();
    }

    public void setSrpAlgoForWindVane(String r100) {
        this.srpAlgoForWindVane = r100;
    }
}
