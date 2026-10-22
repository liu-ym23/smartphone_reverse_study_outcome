package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR&\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchConfig;", "", "()V", "enableBackToTop", "", "getEnableBackToTop", "()I", "setEnableBackToTop", "(I)V", "imageOptForbidEntrance", "", "", "getImageOptForbidEntrance", "()Ljava/util/List;", "setImageOptForbidEntrance", "(Ljava/util/List;)V", "imageRemakeConfig", "Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchImageRemakeConfig;", "getImageRemakeConfig", "()Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchImageRemakeConfig;", "setImageRemakeConfig", "(Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchImageRemakeConfig;)V", "optClientExtraParser", "getOptClientExtraParser", "setOptClientExtraParser", "showToastConfigList", "Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchShowToastConfig;", "getShowToastConfigList", "setShowToastConfigList", "v2700UiOptConfig", "Lcom/ss/android/ugc/aweme/search/common/config/V2700FullConfig;", "getV2700UiOptConfig", "()Lcom/ss/android/ugc/aweme/search/common/config/V2700FullConfig;", "setV2700UiOptConfig", "(Lcom/ss/android/ugc/aweme/search/common/config/V2700FullConfig;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchConfig {

    @SerializedName("enable_back_to_top")
    private int enableBackToTop;

    @SerializedName("image_opt_forbid_entrance")
    private List<String> imageOptForbidEntrance;

    @SerializedName("image_remake_config")
    private PhotoSearchImageRemakeConfig imageRemakeConfig;

    @SerializedName("opt_parse_client_extra")
    private int optClientExtraParser;

    @SerializedName("show_toast_config_list")
    private List<PhotoSearchShowToastConfig> showToastConfigList;

    @SerializedName("v2700_opt_ab_channel_list_config")
    private V2700FullConfig v2700UiOptConfig;

    public PhotoSearchConfig() {
        this.v2700UiOptConfig = new V2700FullConfig();
        this.enableBackToTop = 1;
        this.optClientExtraParser = 1;
    }

    public final int getEnableBackToTop() {
        return this.enableBackToTop;
    }

    public final List<String> getImageOptForbidEntrance() {
        return this.imageOptForbidEntrance;
    }

    public final PhotoSearchImageRemakeConfig getImageRemakeConfig() {
        return this.imageRemakeConfig;
    }

    public final int getOptClientExtraParser() {
        return this.optClientExtraParser;
    }

    public final List<PhotoSearchShowToastConfig> getShowToastConfigList() {
        return this.showToastConfigList;
    }

    public final V2700FullConfig getV2700UiOptConfig() {
        return this.v2700UiOptConfig;
    }

    public final void setEnableBackToTop(int r100) {
        this.enableBackToTop = r100;
    }

    public final void setImageOptForbidEntrance(List<String> r100) {
        this.imageOptForbidEntrance = r100;
    }

    public final void setImageRemakeConfig(PhotoSearchImageRemakeConfig r100) {
        this.imageRemakeConfig = r100;
    }

    public final void setOptClientExtraParser(int r100) {
        this.optClientExtraParser = r100;
    }

    public final void setShowToastConfigList(List<PhotoSearchShowToastConfig> r100) {
        this.showToastConfigList = r100;
    }

    public final void setV2700UiOptConfig(V2700FullConfig r100) {
        this.v2700UiOptConfig = r100;
    }
}
