package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR,\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR&\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R \u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateSelect;", "Ljava/io/Serializable;", "()V", "businessInfo", "", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;", "getBusinessInfo", "()Ljava/util/Map;", "setBusinessInfo", "(Ljava/util/Map;)V", "deleteRenderInfos", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/DeleteRenderInfo;", "getDeleteRenderInfos", "()Ljava/util/List;", "setDeleteRenderInfos", "(Ljava/util/List;)V", "rebackParams", "", "getRebackParams", "setRebackParams", "styleInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;", "getStyleInfo", "setStyleInfo", "updateRenderInfos", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateRenderInfo;", "getUpdateRenderInfos", "setUpdateRenderInfos", "updateStrategy", "getUpdateStrategy", "()Ljava/lang/String;", "setUpdateStrategy", "(Ljava/lang/String;)V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateSelect implements Serializable {
    public static final Companion Companion = null;
    public static final String STRATEGY_DELETE_INSERT_AT_END = "delete_insert_policy_end_of_selection";
    public static final String STRATEGY_UPDATE_WITH_ANIMATION = "update_with_animation";

    @SerializedName("business_info")
    private Map<String, BusinessItem> businessInfo;

    @SerializedName("delete_info")
    private List<DeleteRenderInfo> deleteRenderInfos;

    @SerializedName("reback_params")
    private Map<String, String> rebackParams;

    @SerializedName("style_info")
    private Map<String, StyleItem> styleInfo;

    @SerializedName("render_info")
    private List<UpdateRenderInfo> updateRenderInfos;

    @SerializedName("update_strategy")
    private String updateStrategy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateSelect$Companion;", "", "()V", "STRATEGY_DELETE_INSERT_AT_END", "", "STRATEGY_UPDATE_WITH_ANIMATION", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public UpdateSelect() {
    }

    public final Map<String, BusinessItem> getBusinessInfo() {
        return this.businessInfo;
    }

    public final List<DeleteRenderInfo> getDeleteRenderInfos() {
        return this.deleteRenderInfos;
    }

    public final Map<String, String> getRebackParams() {
        return this.rebackParams;
    }

    public final Map<String, StyleItem> getStyleInfo() {
        return this.styleInfo;
    }

    public final List<UpdateRenderInfo> getUpdateRenderInfos() {
        return this.updateRenderInfos;
    }

    public final String getUpdateStrategy() {
        return this.updateStrategy;
    }

    public final void setBusinessInfo(Map<String, BusinessItem> r100) {
        this.businessInfo = r100;
    }

    public final void setDeleteRenderInfos(List<DeleteRenderInfo> r100) {
        this.deleteRenderInfos = r100;
    }

    public final void setRebackParams(Map<String, String> r100) {
        this.rebackParams = r100;
    }

    public final void setStyleInfo(Map<String, StyleItem> r100) {
        this.styleInfo = r100;
    }

    public final void setUpdateRenderInfos(List<UpdateRenderInfo> r100) {
        this.updateRenderInfos = r100;
    }

    public final void setUpdateStrategy(String r100) {
        this.updateStrategy = r100;
    }
}
