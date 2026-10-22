package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.locallife.live.model.GroupPurchaseChannelSale;
import com.bytedance.locallife.live.model.GroupPurchaseFlashSale;
import com.bytedance.locallife.live.model.GroupPurchaseMinusSale;
import com.bytedance.locallife.live.model.Lottery;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\t¢\u0006\u0006\b²\u0001\u0010³\u0001J\b\u0010\u0003\u001a\u00020\u0000H\u0016R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R*\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0007\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R$\u0010@\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u000e\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R$\u0010C\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u000e\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R$\u0010F\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u000e\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010P\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0007\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000bR$\u0010S\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u000e\u001a\u0004\bT\u0010\u0010\"\u0004\bU\u0010\u0012R$\u0010V\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010\u000e\u001a\u0004\bW\u0010\u0010\"\u0004\bX\u0010\u0012R$\u0010Y\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u0015\u001a\u0004\bZ\u0010\u0017\"\u0004\b[\u0010\u0019R$\u0010\\\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0015\u001a\u0004\b]\u0010\u0017\"\u0004\b^\u0010\u0019R\"\u0010`\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000e\u001a\u0004\bg\u0010\u0010\"\u0004\bh\u0010\u0012R$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010a\u001a\u0004\bq\u0010c\"\u0004\br\u0010eR\"\u0010s\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010a\u001a\u0004\bt\u0010c\"\u0004\bu\u0010eR$\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R&\u0010~\u001a\u00020}8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0015\u001a\u0005\b\u0085\u0001\u0010\u0017\"\u0005\b\u0086\u0001\u0010\u0019R,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R9\u0010\u009e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010\u009c\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R,\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R,\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001¨\u0006´\u0001"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;", "Ljava/io/Serializable;", "", "clone", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeImageInfo;", "imageInfos", "Ljava/util/List;", "getImageInfos", "()Ljava/util/List;", "setImageInfos", "(Ljava/util/List;)V", "", "imageTagUrl", "Ljava/lang/String;", "getImageTagUrl", "()Ljava/lang/String;", "setImageTagUrl", "(Ljava/lang/String;)V", "", "stock", "Ljava/lang/Long;", "getStock", "()Ljava/lang/Long;", "setStock", "(Ljava/lang/Long;)V", "Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "flashSale", "Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "getFlashSale", "()Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "setFlashSale", "(Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;)V", "Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "minusSale", "Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "getMinusSale", "()Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "setMinusSale", "(Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/ExecutionPlan;", "executionPlan", "Lcom/bytedance/locallife/live/goodsshelves/bean/ExecutionPlan;", "getExecutionPlan", "()Lcom/bytedance/locallife/live/goodsshelves/bean/ExecutionPlan;", "setExecutionPlan", "(Lcom/bytedance/locallife/live/goodsshelves/bean/ExecutionPlan;)V", "cardTitle", "getCardTitle", "setCardTitle", "Lcom/bytedance/locallife/live/goodsshelves/bean/TicketInfo;", "tickets", "getTickets", "setTickets", "Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "displayControl", "Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "getDisplayControl", "()Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "setDisplayControl", "(Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;)V", "actualAmount", "getActualAmount", "setActualAmount", "originAmount", "getOriginAmount", "setOriginAmount", "discount", "getDiscount", "setDiscount", "salePoint", "getSalePoint", "setSalePoint", "Lcom/bytedance/locallife/live/goodsshelves/bean/PoiInfo;", AppletNaviType.POI, "Lcom/bytedance/locallife/live/goodsshelves/bean/PoiInfo;", "getPoi", "()Lcom/bytedance/locallife/live/goodsshelves/bean/PoiInfo;", "setPoi", "(Lcom/bytedance/locallife/live/goodsshelves/bean/PoiInfo;)V", "rightList", "getRightList", "setRightList", "soldCount", "getSoldCount", "setSoldCount", "grouponId", "getGrouponId", "setGrouponId", "soldStartTime", "getSoldStartTime", "setSoldStartTime", "soldEndTime", "getSoldEndTime", "setSoldEndTime", "", "consumptionTimes", "I", "getConsumptionTimes", "()I", "setConsumptionTimes", "(I)V", "cardTypeName", "getCardTypeName", "setCardTypeName", "Lcom/bytedance/locallife/live/goodsshelves/bean/BrandLabel;", "brandLabel", "Lcom/bytedance/locallife/live/goodsshelves/bean/BrandLabel;", "getBrandLabel", "()Lcom/bytedance/locallife/live/goodsshelves/bean/BrandLabel;", "setBrandLabel", "(Lcom/bytedance/locallife/live/goodsshelves/bean/BrandLabel;)V", "productType", "getProductType", "setProductType", "productBizline", "getProductBizline", "setProductBizline", "Lcom/bytedance/locallife/live/goodsshelves/bean/Brand;", "brand", "Lcom/bytedance/locallife/live/goodsshelves/bean/Brand;", "getBrand", "()Lcom/bytedance/locallife/live/goodsshelves/bean/Brand;", "setBrand", "(Lcom/bytedance/locallife/live/goodsshelves/bean/Brand;)V", "", "needRefresh", "Z", "getNeedRefresh", "()Z", "setNeedRefresh", "(Z)V", "merchantAccountId", "getMerchantAccountId", "setMerchantAccountId", "Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "memberInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "getMemberInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "setMemberInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;)V", "Lcom/bytedance/locallife/live/model/Lottery;", "lottery", "Lcom/bytedance/locallife/live/model/Lottery;", "getLottery", "()Lcom/bytedance/locallife/live/model/Lottery;", "setLottery", "(Lcom/bytedance/locallife/live/model/Lottery;)V", "Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", "channelSale", "Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", "getChannelSale", "()Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", "setChannelSale", "(Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;)V", "", "", "caiJingInfo", "Ljava/util/Map;", "getCaiJingInfo", "()Ljava/util/Map;", "setCaiJingInfo", "(Ljava/util/Map;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", "drawTicketParamsInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", "getDrawTicketParamsInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", "setDrawTicketParamsInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/i0;", "bffCardData", "Lcom/bytedance/locallife/live/goodsshelves/bean/i0;", "getBffCardData", "()Lcom/bytedance/locallife/live/goodsshelves/bean/i0;", "setBffCardData", "(Lcom/bytedance/locallife/live/goodsshelves/bean/i0;)V", "<init>", "()V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeCardData implements Serializable, Cloneable {

    @SerializedName("actual_amount")
    private String actualAmount;
    private i0 bffCardData;

    @SerializedName("brand")
    private Brand brand;

    @SerializedName("brand_label")
    private BrandLabel brandLabel;

    @SerializedName("cai_jing_coupon")
    private Map<String, ? extends Object> caiJingInfo;

    @SerializedName("source")
    private String cardTitle;

    @SerializedName("card_type_name")
    private String cardTypeName;

    @SerializedName("channel_sale")
    private GroupPurchaseChannelSale channelSale;

    @SerializedName("consumption_times")
    private int consumptionTimes;

    @SerializedName("discount")
    private String discount;

    @SerializedName("display_control")
    private DisplayControl displayControl;

    @SerializedName("draw_ticket_params")
    private DrawTicketParamsInfo drawTicketParamsInfo;

    @SerializedName("execution_plan")
    private ExecutionPlan executionPlan;

    @SerializedName("flash_sale")
    private GroupPurchaseFlashSale flashSale;

    @SerializedName("groupon_id")
    private String grouponId;

    @SerializedName("image_info")
    private List<LiveLocalLifeImageInfo> imageInfos;

    @SerializedName("image_tag_url")
    private String imageTagUrl;

    @SerializedName("lottery")
    private Lottery lottery;

    @SerializedName("member_info")
    private MemberInfo memberInfo;

    @SerializedName("account_id")
    private Long merchantAccountId;

    @SerializedName("minus_sale")
    private GroupPurchaseMinusSale minusSale;

    @SerializedName("need_refresh")
    private boolean needRefresh;

    @SerializedName("origin_amount")
    private String originAmount;

    @SerializedName(AppletNaviType.POI)
    private PoiInfo poi;

    @SerializedName("product_bizline")
    private int productBizline;

    @SerializedName("product_type")
    private int productType;

    @SerializedName("right_list")
    private List<String> rightList;

    @SerializedName("sale_point")
    private String salePoint;

    @SerializedName("sold_count")
    private String soldCount;

    @SerializedName("sold_end_time")
    private Long soldEndTime;

    @SerializedName("sold_start_time")
    private Long soldStartTime;

    @SerializedName("stock")
    private Long stock;

    @SerializedName("ticket")
    private List<TicketInfo> tickets;

    public LiveLocalLifeCardData() {
    }

    public LiveLocalLifeCardData clone() throws CloneNotSupportedException {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.bean.LiveLocalLifeCardData");
        return (LiveLocalLifeCardData) r100;
    }

    public final String getActualAmount() {
        return this.actualAmount;
    }

    public final i0 getBffCardData() {
        return this.bffCardData;
    }

    public final Brand getBrand() {
        return this.brand;
    }

    public final BrandLabel getBrandLabel() {
        return this.brandLabel;
    }

    public final Map<String, Object> getCaiJingInfo() {
        return this.caiJingInfo;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final String getCardTypeName() {
        return this.cardTypeName;
    }

    public final GroupPurchaseChannelSale getChannelSale() {
        return this.channelSale;
    }

    public final int getConsumptionTimes() {
        return this.consumptionTimes;
    }

    public final String getDiscount() {
        return this.discount;
    }

    public final DisplayControl getDisplayControl() {
        return this.displayControl;
    }

    public final DrawTicketParamsInfo getDrawTicketParamsInfo() {
        return this.drawTicketParamsInfo;
    }

    public final ExecutionPlan getExecutionPlan() {
        return this.executionPlan;
    }

    public final GroupPurchaseFlashSale getFlashSale() {
        return this.flashSale;
    }

    public final String getGrouponId() {
        return this.grouponId;
    }

    public final List<LiveLocalLifeImageInfo> getImageInfos() {
        return this.imageInfos;
    }

    public final String getImageTagUrl() {
        return this.imageTagUrl;
    }

    public final Lottery getLottery() {
        return this.lottery;
    }

    public final MemberInfo getMemberInfo() {
        return this.memberInfo;
    }

    public final Long getMerchantAccountId() {
        return this.merchantAccountId;
    }

    public final GroupPurchaseMinusSale getMinusSale() {
        return this.minusSale;
    }

    public final boolean getNeedRefresh() {
        return this.needRefresh;
    }

    public final String getOriginAmount() {
        return this.originAmount;
    }

    public final PoiInfo getPoi() {
        return this.poi;
    }

    public final int getProductBizline() {
        return this.productBizline;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final List<String> getRightList() {
        return this.rightList;
    }

    public final String getSalePoint() {
        return this.salePoint;
    }

    public final String getSoldCount() {
        return this.soldCount;
    }

    public final Long getSoldEndTime() {
        return this.soldEndTime;
    }

    public final Long getSoldStartTime() {
        return this.soldStartTime;
    }

    public final Long getStock() {
        return this.stock;
    }

    public final List<TicketInfo> getTickets() {
        return this.tickets;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8498clone() {
        return clone();
    }

    public final void setActualAmount(String r100) {
        this.actualAmount = r100;
    }

    public final void setBffCardData(i0 r100) {
        this.bffCardData = r100;
    }

    public final void setBrand(Brand r100) {
        this.brand = r100;
    }

    public final void setBrandLabel(BrandLabel r100) {
        this.brandLabel = r100;
    }

    public final void setCaiJingInfo(Map<String, ? extends Object> r100) {
        this.caiJingInfo = r100;
    }

    public final void setCardTitle(String r100) {
        this.cardTitle = r100;
    }

    public final void setCardTypeName(String r100) {
        this.cardTypeName = r100;
    }

    public final void setChannelSale(GroupPurchaseChannelSale r100) {
        this.channelSale = r100;
    }

    public final void setConsumptionTimes(int r100) {
        this.consumptionTimes = r100;
    }

    public final void setDiscount(String r100) {
        this.discount = r100;
    }

    public final void setDisplayControl(DisplayControl r100) {
        this.displayControl = r100;
    }

    public final void setDrawTicketParamsInfo(DrawTicketParamsInfo r100) {
        this.drawTicketParamsInfo = r100;
    }

    public final void setExecutionPlan(ExecutionPlan r100) {
        this.executionPlan = r100;
    }

    public final void setFlashSale(GroupPurchaseFlashSale r100) {
        this.flashSale = r100;
    }

    public final void setGrouponId(String r100) {
        this.grouponId = r100;
    }

    public final void setImageInfos(List<LiveLocalLifeImageInfo> r100) {
        this.imageInfos = r100;
    }

    public final void setImageTagUrl(String r100) {
        this.imageTagUrl = r100;
    }

    public final void setLottery(Lottery r100) {
        this.lottery = r100;
    }

    public final void setMemberInfo(MemberInfo r100) {
        this.memberInfo = r100;
    }

    public final void setMerchantAccountId(Long r100) {
        this.merchantAccountId = r100;
    }

    public final void setMinusSale(GroupPurchaseMinusSale r100) {
        this.minusSale = r100;
    }

    public final void setNeedRefresh(boolean r100) {
        this.needRefresh = r100;
    }

    public final void setOriginAmount(String r100) {
        this.originAmount = r100;
    }

    public final void setPoi(PoiInfo r100) {
        this.poi = r100;
    }

    public final void setProductBizline(int r100) {
        this.productBizline = r100;
    }

    public final void setProductType(int r100) {
        this.productType = r100;
    }

    public final void setRightList(List<String> r100) {
        this.rightList = r100;
    }

    public final void setSalePoint(String r100) {
        this.salePoint = r100;
    }

    public final void setSoldCount(String r100) {
        this.soldCount = r100;
    }

    public final void setSoldEndTime(Long r100) {
        this.soldEndTime = r100;
    }

    public final void setSoldStartTime(Long r100) {
        this.soldStartTime = r100;
    }

    public final void setStock(Long r100) {
        this.stock = r100;
    }

    public final void setTickets(List<TicketInfo> r100) {
        this.tickets = r100;
    }
}
