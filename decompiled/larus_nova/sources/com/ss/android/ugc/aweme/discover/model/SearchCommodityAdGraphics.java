package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAdGraphics;", "Ljava/io/Serializable;", "()V", "coverImgUrl", "", "getCoverImgUrl", "()Ljava/lang/String;", "setCoverImgUrl", "(Ljava/lang/String;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "mpUrl", "getMpUrl", "setMpUrl", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "setOpenUrl", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityAdGraphics implements Serializable {

    @SerializedName("cover_img_url")
    private String coverImgUrl;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("mp_url")
    private String mpUrl;

    @SerializedName("open_url")
    private String openUrl;

    public SearchCommodityAdGraphics() {
    }

    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getMpUrl() {
        return this.mpUrl;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final void setCoverImgUrl(String r100) {
        this.coverImgUrl = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setMpUrl(String r100) {
        this.mpUrl = r100;
    }

    public final void setOpenUrl(String r100) {
        this.openUrl = r100;
    }
}
