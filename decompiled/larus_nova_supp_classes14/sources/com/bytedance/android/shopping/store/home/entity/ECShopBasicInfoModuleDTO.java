package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 w2\u00020\u0001:\u0001xB\u0007¢\u0006\u0004\bu\u0010vR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b<\u00101\"\u0004\b=\u00103R$\u0010>\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010V\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010\u0004\u001a\u0004\bW\u0010\u0006\"\u0004\bX\u0010\bR*\u0010Z\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010/\u001a\u0004\b[\u00101\"\u0004\b\\\u00103R$\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006y"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopBasicInfoModuleDTO;", "Ljava/io/Serializable;", "", "shopId", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopLogo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "shopName", "getShopName", "setShopName", "brandTag", "getBrandTag", "setBrandTag", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputationDTO", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "getReputationDTO", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "setReputationDTO", "(Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;)V", "", "showSales", "Z", "getShowSales", "()Z", "setShowSales", "(Z)V", "", "Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItem;", "shopValueInfo", "Ljava/util/Map;", "getShopValueInfo", "()Ljava/util/Map;", "setShopValueInfo", "(Ljava/util/Map;)V", "", "Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItemWhite;", "shopValueInfoWhite", "Ljava/util/List;", "getShopValueInfoWhite", "()Ljava/util/List;", "setShopValueInfoWhite", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/store/home/entity/v;", "shopDisplayName", "Lcom/bytedance/android/shopping/store/home/entity/v;", "getShopDisplayName", "()Lcom/bytedance/android/shopping/store/home/entity/v;", "setShopDisplayName", "(Lcom/bytedance/android/shopping/store/home/entity/v;)V", "tagList", "getTagList", "setTagList", "shopLogoIcon", "getShopLogoIcon", "setShopLogoIcon", "Lcom/bytedance/android/ec/model/o;", "shopXZGInfo", "Lcom/bytedance/android/ec/model/o;", "getShopXZGInfo", "()Lcom/bytedance/android/ec/model/o;", "setShopXZGInfo", "(Lcom/bytedance/android/ec/model/o;)V", "", "shopType", "Ljava/lang/Integer;", "getShopType", "()Ljava/lang/Integer;", "setShopType", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/shopping/store/home/entity/s;", "headerStyleConfig", "Lcom/bytedance/android/shopping/store/home/entity/s;", "getHeaderStyleConfig", "()Lcom/bytedance/android/shopping/store/home/entity/s;", "setHeaderStyleConfig", "(Lcom/bytedance/android/shopping/store/home/entity/s;)V", "shopTypeDescription", "getShopTypeDescription", "setShopTypeDescription", "Lcom/bytedance/android/shopping/store/home/entity/ECShopSellingPointDTO;", "shopSellingPoint", "getShopSellingPoint", "setShopSellingPoint", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "tagV2List", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "getTagV2List", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "setTagV2List", "(Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;)V", "topTagList", "getTopTagList", "setTopTagList", "Lcom/bytedance/android/shopping/store/home/entity/WelfareCorpLabelDTO;", "welfareCorpLabelDTO", "Lcom/bytedance/android/shopping/store/home/entity/WelfareCorpLabelDTO;", "getWelfareCorpLabelDTO", "()Lcom/bytedance/android/shopping/store/home/entity/WelfareCorpLabelDTO;", "setWelfareCorpLabelDTO", "(Lcom/bytedance/android/shopping/store/home/entity/WelfareCorpLabelDTO;)V", "Lcom/bytedance/android/shopping/store/home/entity/ShopTags;", "shopTags", "Lcom/bytedance/android/shopping/store/home/entity/ShopTags;", "getShopTags", "()Lcom/bytedance/android/shopping/store/home/entity/ShopTags;", "setShopTags", "(Lcom/bytedance/android/shopping/store/home/entity/ShopTags;)V", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopBasicInfoModuleDTO implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("brand_tag")
    private ECUrlModel brandTag;

    @SerializedName("header_style_config")
    private s headerStyleConfig;

    @SerializedName("reputation")
    private AuthorReputationDTO reputationDTO;

    @SerializedName("shop_display_name")
    private v shopDisplayName;

    @SerializedName("shop_id")
    private String shopId;

    @SerializedName("shop_logo")
    private ECUrlModel shopLogo;

    @SerializedName("shop_logo_icon")
    private ECUrlModel shopLogoIcon;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("shop_selling_point_tags")
    private List<ECShopSellingPointDTO> shopSellingPoint;

    @SerializedName("shop_tags")
    private ShopTags shopTags;

    @SerializedName("shop_type")
    private Integer shopType;

    @SerializedName("shop_type_description")
    private String shopTypeDescription;

    @SerializedName("value_info")
    private Map<String, ShopValueInfoItem> shopValueInfo;

    @SerializedName("value_infos")
    private List<ShopValueInfoItemWhite> shopValueInfoWhite;

    @SerializedName("shop_xzg_info")
    private com.bytedance.android.ec.model.o shopXZGInfo;

    @SerializedName("show_sales")
    private boolean showSales;

    @SerializedName("tag_list")
    private List<? extends ECUrlModel> tagList;

    @SerializedName("tag_v2_list")
    private ECTagListDTO tagV2List;

    @SerializedName("top_tag_list")
    private ECTagListDTO topTagList;

    @SerializedName("welfare_corp_label")
    private WelfareCorpLabelDTO welfareCorpLabelDTO;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECShopBasicInfoModuleDTO() {
        this.showSales = true;
    }

    public final ECUrlModel getBrandTag() {
        return this.brandTag;
    }

    public final s getHeaderStyleConfig() {
        return this.headerStyleConfig;
    }

    public final AuthorReputationDTO getReputationDTO() {
        return this.reputationDTO;
    }

    public final v getShopDisplayName() {
        return this.shopDisplayName;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final ECUrlModel getShopLogoIcon() {
        return this.shopLogoIcon;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final List<ECShopSellingPointDTO> getShopSellingPoint() {
        return this.shopSellingPoint;
    }

    public final ShopTags getShopTags() {
        return this.shopTags;
    }

    public final Integer getShopType() {
        return this.shopType;
    }

    public final String getShopTypeDescription() {
        return this.shopTypeDescription;
    }

    public final Map<String, ShopValueInfoItem> getShopValueInfo() {
        return this.shopValueInfo;
    }

    public final List<ShopValueInfoItemWhite> getShopValueInfoWhite() {
        return this.shopValueInfoWhite;
    }

    public final com.bytedance.android.ec.model.o getShopXZGInfo() {
        return this.shopXZGInfo;
    }

    public final boolean getShowSales() {
        return this.showSales;
    }

    public final List<ECUrlModel> getTagList() {
        return this.tagList;
    }

    public final ECTagListDTO getTagV2List() {
        return this.tagV2List;
    }

    public final ECTagListDTO getTopTagList() {
        return this.topTagList;
    }

    public final WelfareCorpLabelDTO getWelfareCorpLabelDTO() {
        return this.welfareCorpLabelDTO;
    }

    public final void setBrandTag(ECUrlModel r1) {
        this.brandTag = r1;
    }

    public final void setHeaderStyleConfig(s r1) {
        this.headerStyleConfig = r1;
    }

    public final void setReputationDTO(AuthorReputationDTO r1) {
        this.reputationDTO = r1;
    }

    public final void setShopDisplayName(v r1) {
        this.shopDisplayName = r1;
    }

    public final void setShopId(String r1) {
        this.shopId = r1;
    }

    public final void setShopLogo(ECUrlModel r1) {
        this.shopLogo = r1;
    }

    public final void setShopLogoIcon(ECUrlModel r1) {
        this.shopLogoIcon = r1;
    }

    public final void setShopName(String r1) {
        this.shopName = r1;
    }

    public final void setShopSellingPoint(List<ECShopSellingPointDTO> r1) {
        this.shopSellingPoint = r1;
    }

    public final void setShopTags(ShopTags r1) {
        this.shopTags = r1;
    }

    public final void setShopType(Integer r1) {
        this.shopType = r1;
    }

    public final void setShopTypeDescription(String r1) {
        this.shopTypeDescription = r1;
    }

    public final void setShopValueInfo(Map<String, ShopValueInfoItem> r1) {
        this.shopValueInfo = r1;
    }

    public final void setShopValueInfoWhite(List<ShopValueInfoItemWhite> r1) {
        this.shopValueInfoWhite = r1;
    }

    public final void setShopXZGInfo(com.bytedance.android.ec.model.o r1) {
        this.shopXZGInfo = r1;
    }

    public final void setShowSales(boolean r1) {
        this.showSales = r1;
    }

    public final void setTagList(List<? extends ECUrlModel> r1) {
        this.tagList = r1;
    }

    public final void setTagV2List(ECTagListDTO r1) {
        this.tagV2List = r1;
    }

    public final void setTopTagList(ECTagListDTO r1) {
        this.topTagList = r1;
    }

    public final void setWelfareCorpLabelDTO(WelfareCorpLabelDTO r1) {
        this.welfareCorpLabelDTO = r1;
    }
}
