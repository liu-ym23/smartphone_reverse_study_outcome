package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bL\u0010MR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopLiveTabHomeInfoModuleDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/store/home/entity/v;", "shopDisplayName", "Lcom/bytedance/android/shopping/store/home/entity/v;", "getShopDisplayName", "()Lcom/bytedance/android/shopping/store/home/entity/v;", "setShopDisplayName", "(Lcom/bytedance/android/shopping/store/home/entity/v;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopLogo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "tagList", "Ljava/util/List;", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "tagV2List", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "getTagV2List", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "setTagV2List", "(Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;)V", "Lcom/bytedance/android/ec/model/o;", "shopXZGInfo", "Lcom/bytedance/android/ec/model/o;", "getShopXZGInfo", "()Lcom/bytedance/android/ec/model/o;", "setShopXZGInfo", "(Lcom/bytedance/android/ec/model/o;)V", "Lcom/bytedance/android/shopping/store/home/entity/s;", "headerStyleConfig", "Lcom/bytedance/android/shopping/store/home/entity/s;", "getHeaderStyleConfig", "()Lcom/bytedance/android/shopping/store/home/entity/s;", "setHeaderStyleConfig", "(Lcom/bytedance/android/shopping/store/home/entity/s;)V", "Lcom/bytedance/android/shopping/store/home/entity/ECShopSellingPointDTO;", "shopSellingPoint", "getShopSellingPoint", "setShopSellingPoint", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "", "hideFollowBtn", "Z", "getHideFollowBtn", "()Z", "setHideFollowBtn", "(Z)V", "Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "fansInfo", "Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "getFansInfo", "()Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "setFansInfo", "(Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;)V", "Lim/v;", "liveInfo", "Lim/v;", "getLiveInfo", "()Lim/v;", "setLiveInfo", "(Lim/v;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopLiveTabHomeInfoModuleDTO implements Serializable {

    @SerializedName("fans_info")
    private FansClubInfo fansInfo;

    @SerializedName("follow_status")
    private Integer followStatus;

    @SerializedName("header_style_config")
    private s headerStyleConfig;

    @SerializedName("hide_follow_button")
    private boolean hideFollowBtn;

    @SerializedName("live_info")
    private im.v liveInfo;

    @SerializedName("shop_display_name")
    private v shopDisplayName;

    @SerializedName("shop_logo")
    private ECUrlModel shopLogo;

    @SerializedName("shop_selling_point_tags")
    private List<ECShopSellingPointDTO> shopSellingPoint;

    @SerializedName("shop_xzg_info")
    private com.bytedance.android.ec.model.o shopXZGInfo;

    @SerializedName("tag_list")
    private List<? extends ECUrlModel> tagList;

    @SerializedName("tag_v2_list")
    private ECTagListDTO tagV2List;

    public ECShopLiveTabHomeInfoModuleDTO() {
    }

    public final FansClubInfo getFansInfo() {
        return this.fansInfo;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final s getHeaderStyleConfig() {
        return this.headerStyleConfig;
    }

    public final boolean getHideFollowBtn() {
        return this.hideFollowBtn;
    }

    public final im.v getLiveInfo() {
        return this.liveInfo;
    }

    public final v getShopDisplayName() {
        return this.shopDisplayName;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final List<ECShopSellingPointDTO> getShopSellingPoint() {
        return this.shopSellingPoint;
    }

    public final com.bytedance.android.ec.model.o getShopXZGInfo() {
        return this.shopXZGInfo;
    }

    public final List<ECUrlModel> getTagList() {
        return this.tagList;
    }

    public final ECTagListDTO getTagV2List() {
        return this.tagV2List;
    }

    public final void setFansInfo(FansClubInfo r1) {
        this.fansInfo = r1;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setHeaderStyleConfig(s r1) {
        this.headerStyleConfig = r1;
    }

    public final void setHideFollowBtn(boolean r1) {
        this.hideFollowBtn = r1;
    }

    public final void setLiveInfo(im.v r1) {
        this.liveInfo = r1;
    }

    public final void setShopDisplayName(v r1) {
        this.shopDisplayName = r1;
    }

    public final void setShopLogo(ECUrlModel r1) {
        this.shopLogo = r1;
    }

    public final void setShopSellingPoint(List<ECShopSellingPointDTO> r1) {
        this.shopSellingPoint = r1;
    }

    public final void setShopXZGInfo(com.bytedance.android.ec.model.o r1) {
        this.shopXZGInfo = r1;
    }

    public final void setTagList(List<? extends ECUrlModel> r1) {
        this.tagList = r1;
    }

    public final void setTagV2List(ECTagListDTO r1) {
        this.tagV2List = r1;
    }
}
