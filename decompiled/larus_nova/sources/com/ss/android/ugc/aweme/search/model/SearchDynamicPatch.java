package com.ss.android.ugc.aweme.search.model;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.lynx.tasm.TemplateData;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class SearchDynamicPatch extends DynamicPatch {

    @SerializedName(SimilarProductParam.AWEME_ID)
    public String awemeId;

    @SerializedName("aweme_index")
    int awemeIndex;
    public volatile transient Object cardLynxModel;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient JSONObject f453344f;

    @SerializedName("fall_back_lynx_schema")
    public String fallbackLynxSchema;

    @SerializedName("filtered_in_video_detail")
    int filteredInVideoDetail;
    public volatile transient Map<String, Object> globalProps;

    @SerializedName("preload_image")
    public List<String> preloadImage;
    public int realShowTimes;

    @SerializedName("selected_tab")
    public Integer selectedTab;

    @SerializedName("show_feedback")
    private boolean showFeedback;
    public transient Map<String, Object> subcardCommonData;
    public volatile transient TemplateData templateData;
    public volatile transient AtomicBoolean used;

    @SerializedName("waterfall_layout_schema")
    String waterfallLayoutSchema;

    @SerializedName("waterfall_layout_single_schema")
    String waterfallLayoutSingleSchema;

    public JSONObject getRawDataJson() {
        if (this.f453344f != null) goto L12;
        this.f453344f = new JSONObject(this.rawData);     // Catch: Throwable -> L6
    L9:
        if (this.f453344f != null) goto L12;
        this.f453344f = new JSONObject();
    L6:
        th = move-exception;
        th.printStackTrace();
    L12:
        return this.f453344f;
    }

    public SearchDynamicPatch() {
        this.realShowTimes = 0;
        this.f453344f = null;
        this.used = new AtomicBoolean(false);
        this.cardLynxModel = null;
    }

    public int getAwemeIndex() {
        return this.awemeIndex;
    }

    public int getFilteredInVideoDetail() {
        return this.filteredInVideoDetail;
    }

    public String getWaterfallLayoutSchema() {
        return this.waterfallLayoutSchema;
    }

    public String getWaterfallLayoutSingleSchema() {
        return this.waterfallLayoutSingleSchema;
    }

    public boolean isShowFeedback() {
        return this.showFeedback;
    }

    public void setAwemeIndex(int r100) {
        this.awemeIndex = r100;
    }

    public void setFilteredInVideoDetail(int r100) {
        this.filteredInVideoDetail = r100;
    }

    public void setWaterfallLayoutSingleSchema(String r100) {
        this.waterfallLayoutSingleSchema = r100;
    }
}
