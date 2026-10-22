package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.feed.model.search.SearchCommodityTagInfo;
import com.ss.texturerender.VideoSurfaceTexture;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087D¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R \u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R \u0010%\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R \u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R \u0010/\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001e\u00102\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u0018\u0010:\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0017¨\u0006<"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommonInfo;", "Ljava/io/Serializable;", "()V", "commonProp", "Lcom/ss/android/ugc/aweme/discover/model/CommonInfoCommonProp;", "getCommonProp", "()Lcom/ss/android/ugc/aweme/discover/model/CommonInfoCommonProp;", "iconTag", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "getIconTag", "()Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "setIconTag", "(Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;)V", "pointType", "", "getPointType", "()Ljava/lang/Integer;", "setPointType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "sellingPtInfo", "getSellingPtInfo", "setSellingPtInfo", "showArrow", "", "getShowArrow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", n.KEY_SUB_TEXT, "getSubText", "setSubText", n.KEY_SUB_TEXT_COLOR, "getSubTextColor", "setSubTextColor", "text", "getText", "setText", "textBoldIndex", "", "getTextBoldIndex", "()Ljava/util/List;", "textColor", "getTextColor", "setTextColor", "textEllipsisIndex", "getTextEllipsisIndex", "()I", "setTextEllipsisIndex", "(I)V", "textExtra", "getTextExtra", "setTextExtra", VideoSurfaceTexture.KEY_TIME, "getTimeStamp", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonInfo implements Serializable {

    @SerializedName("common_prop")
    private final CommonInfoCommonProp commonProp;

    @SerializedName("icon_tag_infos")
    private SearchCommodityTagInfo iconTag;

    @SerializedName("point_type")
    private Integer pointType;

    @SerializedName("schema")
    private String schema;

    @SerializedName(a.KEY_SELLING_PT_INFO)
    private String sellingPtInfo;

    @SerializedName("show_arrow")
    private final Boolean showArrow;

    @SerializedName("sub_text")
    private String subText;

    @SerializedName("sub_text_color")
    private String subTextColor;

    @SerializedName("text")
    private String text;

    @SerializedName("text_bold_index")
    private final List<Integer> textBoldIndex;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("text_ellipsis_index")
    private int textEllipsisIndex;

    @SerializedName("text_extra")
    private String textExtra;

    @SerializedName("time_stamp")
    private final String timeStamp;

    public CommonInfo() {
        this.textEllipsisIndex = -1;
        this.showArrow = Boolean.FALSE;
    }

    public final CommonInfoCommonProp getCommonProp() {
        return this.commonProp;
    }

    public final SearchCommodityTagInfo getIconTag() {
        return this.iconTag;
    }

    public final Integer getPointType() {
        return this.pointType;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSellingPtInfo() {
        return this.sellingPtInfo;
    }

    public final Boolean getShowArrow() {
        return this.showArrow;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getSubTextColor() {
        return this.subTextColor;
    }

    public final String getText() {
        return this.text;
    }

    public final List<Integer> getTextBoldIndex() {
        return this.textBoldIndex;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getTextEllipsisIndex() {
        return this.textEllipsisIndex;
    }

    public final String getTextExtra() {
        return this.textExtra;
    }

    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public final void setIconTag(SearchCommodityTagInfo r100) {
        this.iconTag = r100;
    }

    public final void setPointType(Integer r100) {
        this.pointType = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSellingPtInfo(String r100) {
        this.sellingPtInfo = r100;
    }

    public final void setSubText(String r100) {
        this.subText = r100;
    }

    public final void setSubTextColor(String r100) {
        this.subTextColor = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setTextEllipsisIndex(int r100) {
        this.textEllipsisIndex = r100;
    }

    public final void setTextExtra(String r100) {
        this.textExtra = r100;
    }
}
