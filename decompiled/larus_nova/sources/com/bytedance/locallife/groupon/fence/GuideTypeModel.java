package com.bytedance.locallife.groupon.fence;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R$\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\n¨\u0006:"}, d2 = {"Lcom/bytedance/locallife/groupon/fence/GuideTypeModel;", "", "", "toString", "", "guideType", "I", "getGuideType", "()I", "setGuideType", "(I)V", "", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "images", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "tittle", "Ljava/lang/String;", "getTittle", "()Ljava/lang/String;", "setTittle", "(Ljava/lang/String;)V", "bannerTitle", "getBannerTitle", "setBannerTitle", "button", "getButton", "setButton", "schema", "getSchema", "setSchema", "bannerSchema", "getBannerSchema", "setBannerSchema", "lynxUrl", "getLynxUrl", "setLynxUrl", "firstShowTime", "Ljava/lang/Integer;", "getFirstShowTime", "()Ljava/lang/Integer;", "setFirstShowTime", "(Ljava/lang/Integer;)V", "Lcom/bytedance/locallife/groupon/fence/MovingGuideFrequency;", "frequency", "Lcom/bytedance/locallife/groupon/fence/MovingGuideFrequency;", "getFrequency", "()Lcom/bytedance/locallife/groupon/fence/MovingGuideFrequency;", "setFrequency", "(Lcom/bytedance/locallife/groupon/fence/MovingGuideFrequency;)V", "dataFrom", "getDataFrom", "setDataFrom", "<init>", "()V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class GuideTypeModel {

    @SerializedName("banner_schema")
    private String bannerSchema;

    @SerializedName("banner_title")
    private String bannerTitle;

    @SerializedName("button")
    private String button;
    private int dataFrom;

    @SerializedName("show_time")
    private Integer firstShowTime;

    @SerializedName("frequency")
    private MovingGuideFrequency frequency;

    @SerializedName("guide_type")
    private int guideType;

    @SerializedName("images")
    private List<? extends UrlModel> images;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private String lynxUrl;

    @SerializedName("schema")
    private String schema;

    @SerializedName("title")
    private String tittle;

    public String toString() {
        return "{guideType=" + this.guideType + ", tittle=" + this.tittle + ", button=" + this.button + ", schema=" + this.schema + ", lynxUrl=" + this.lynxUrl + '}';
    }

    public GuideTypeModel() {
        this.firstShowTime = 5;
    }

    public final String getBannerSchema() {
        return this.bannerSchema;
    }

    public final String getBannerTitle() {
        return this.bannerTitle;
    }

    public final String getButton() {
        return this.button;
    }

    public final int getDataFrom() {
        return this.dataFrom;
    }

    public final Integer getFirstShowTime() {
        return this.firstShowTime;
    }

    public final MovingGuideFrequency getFrequency() {
        return this.frequency;
    }

    public final int getGuideType() {
        return this.guideType;
    }

    public final List<UrlModel> getImages() {
        return this.images;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTittle() {
        return this.tittle;
    }

    public final void setBannerSchema(String r100) {
        this.bannerSchema = r100;
    }

    public final void setBannerTitle(String r100) {
        this.bannerTitle = r100;
    }

    public final void setButton(String r100) {
        this.button = r100;
    }

    public final void setDataFrom(int r100) {
        this.dataFrom = r100;
    }

    public final void setFirstShowTime(Integer r100) {
        this.firstShowTime = r100;
    }

    public final void setFrequency(MovingGuideFrequency r100) {
        this.frequency = r100;
    }

    public final void setGuideType(int r100) {
        this.guideType = r100;
    }

    public final void setImages(List<? extends UrlModel> r100) {
        this.images = r100;
    }

    public final void setLynxUrl(String r100) {
        this.lynxUrl = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setTittle(String r100) {
        this.tittle = r100;
    }
}
