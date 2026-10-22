package qe3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\u001c\u00103\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010!\u001a\u0004\b4\u0010#R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001aR\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\u001c\u0010;\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010!\u001a\u0004\b<\u0010#R\u001c\u0010=\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b>\u0010#R\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010\u0006R\u001c\u0010F\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010!\u001a\u0004\bG\u0010#R\u001c\u0010I\u001a\u0004\u0018\u00010H8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006R\u001c\u0010O\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006R\u001c\u0010Q\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010!\u001a\u0004\bR\u0010#R\u001c\u0010S\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010!\u001a\u0004\bT\u0010#R\u001c\u0010U\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\r\u001a\u0004\bV\u0010\u000fR\u001c\u0010W\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bW\u0010!\u001a\u0004\bX\u0010#R\u001c\u0010Z\u001a\u0004\u0018\u00010Y8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006R\"\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0018\u001a\u0004\ba\u0010\u001aR\u001c\u0010c\u001a\u0004\u0018\u00010b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001c\u0010g\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bg\u0010!\u001a\u0004\bh\u0010#R\u001c\u0010i\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bi\u0010!\u001a\u0004\bj\u0010#R\u001c\u0010k\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010\r\u001a\u0004\bl\u0010\u000fR\u001c\u0010m\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bm\u0010\r\u001a\u0004\bn\u0010\u000fR\"\u0010o\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\bo\u0010\u0018\u001a\u0004\bp\u0010\u001aR\u001c\u0010r\u001a\u0004\u0018\u00010q8\u0006X\u0087\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bv\u0010\r\u001a\u0004\bw\u0010\u000fR\u001c\u0010x\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bx\u0010\u0004\u001a\u0004\by\u0010\u0006R\u001c\u0010z\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bz\u0010\u0004\u001a\u0004\b{\u0010\u0006R\u001c\u0010|\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b|\u0010\u0004\u001a\u0004\b}\u0010\u0006R\u001c\u0010~\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010\u0004\u001a\u0004\b\u007f\u0010\u0006R\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u0004\u001a\u0005\b\u0081\u0001\u0010\u0006R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0004\u001a\u0005\b\u0083\u0001\u0010\u0006R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\r\u001a\u0005\b\u0085\u0001\u0010\u000fR\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0004\u001a\u0005\b\u0087\u0001\u0010\u0006R\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009b\u0001"}, d2 = {"Lqe3/e;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "title", "getTitle", SocialConstants.PARAM_APP_DESC, "getDesc", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lqe3/j;", "price", "Lqe3/j;", "getPrice", "()Lqe3/j;", "", "Lqe3/l;", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "getTags", "()Ljava/util/List;", "jumpLink", "getJumpLink", "promotionId", "getPromotionId", "", "kolIdInt", "Ljava/lang/Long;", "getKolIdInt", "()Ljava/lang/Long;", "secKolId", "getSecKolId", com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, "getRecommend_info", "setRecommend_info", "(Ljava/lang/String;)V", "", "state", "Ljava/lang/Integer;", "getState", "()Ljava/lang/Integer;", "productId", "getProductId", "kolId", "getKolId", SalesInfoStruct.SALES, "getSales", "icons", "getIcons", "shopId", "getShopId", "secShopId", "getSecShopId", "bizKind", "getBizKind", "promotionSource", "getPromotionSource", "Lqe3/k;", "recReason", "Lqe3/k;", "getRecReason", "()Lqe3/k;", "shareLink", "getShareLink", "visitorCount", "getVisitorCount", "Lqe3/i;", "extra", "Lqe3/i;", "getExtra", "()Lqe3/i;", "brandName", "getBrandName", "shortTitle", "getShortTitle", "campaginStock", "getCampaginStock", "campaginSales", "getCampaginSales", "coverWhiteBg", "getCoverWhiteBg", "payType", "getPayType", "Lqe3/g;", "category", "Lqe3/g;", "getCategory", "()Lqe3/g;", "sellingPoint", "getSellingPoint", "expendTags", "getExpendTags", "Lqe3/f;", "campaignInfo", "Lqe3/f;", "getCampaignInfo", "()Lqe3/f;", "dupId", "getDupId", "cashBack", "getCashBack", "coverLong", "getCoverLong", "recommendCover", "getRecommendCover", "detailPicture", "getDetailPicture", "Lqe3/h;", "drawInfo", "Lqe3/h;", "getDrawInfo", "()Lqe3/h;", "headImage", "getHeadImage", "shopName", "getShopName", "StoreName", "getStoreName", "StoreLogo", "getStoreLogo", "verticalMarket", "getVerticalMarket", "coverTagDesc", "getCoverTagDesc", "freightDesc", "getFreightDesc", "coverTag", "getCoverTag", "midTitle", "getMidTitle", "Lqe3/d;", "activityConf", "Lqe3/d;", "getActivityConf", "()Lqe3/d;", "originLocation", "getOriginLocation", "Lqe3/o;", "livePlayback", "Lqe3/o;", "getLivePlayback", "()Lqe3/o;", "Lqe3/a;", "coverVideo", "Lqe3/a;", "getCoverVideo", "()Lqe3/a;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("store_logo")
    private final String StoreLogo;

    @SerializedName("store_name")
    private final String StoreName;

    @SerializedName("activity_conf")
    private final d activityConf;

    @SerializedName("biz_kind")
    private final Long bizKind;

    @SerializedName("brand_name")
    private final String brandName;

    @SerializedName("campagin_sales")
    private final Long campaginSales;

    @SerializedName("campagin_stock")
    private final Long campaginStock;

    @SerializedName("campaign_info")
    private final f campaignInfo;

    @SerializedName("cash_back")
    private final Long cashBack;

    @SerializedName("category")
    private final g category;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("cover_long")
    private final ECUrlModel coverLong;

    @SerializedName("cover_tag")
    private final ECUrlModel coverTag;

    @SerializedName("cover_tag_desc")
    private final String coverTagDesc;

    @SerializedName("cover_video")
    private final a coverVideo;

    @SerializedName("cover_white_bg")
    private final ECUrlModel coverWhiteBg;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("detail_picture")
    private final List<ECUrlModel> detailPicture;

    @SerializedName("draw_info")
    private final h drawInfo;

    @SerializedName("dup_id")
    private final Long dupId;

    @SerializedName("expend_tags")
    private final List<l> expendTags;

    @SerializedName("extra")
    private final i extra;

    @SerializedName("freight_desc")
    private final String freightDesc;

    @SerializedName("image_list")
    private final ECUrlModel headImage;

    @SerializedName("icons")
    private final List<l> icons;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f532638id;

    @SerializedName("link")
    private final String jumpLink;

    @SerializedName("kol_id_str")
    private final String kolId;

    @SerializedName("kol_id_int")
    private final Long kolIdInt;

    @SerializedName("live_playback")
    private final o livePlayback;

    @SerializedName("mid_title")
    private final String midTitle;

    @SerializedName("origin_location")
    private final String originLocation;

    @SerializedName("pay_type")
    private final Long payType;

    @SerializedName("price")
    private final j price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final Long promotionSource;

    @SerializedName("rec_reason")
    private final k recReason;

    @SerializedName("cover_recommend")
    private final ECUrlModel recommendCover;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private String recommend_info;

    @SerializedName(SalesInfoStruct.SALES)
    private final Long sales;

    @SerializedName("sec_kol_id")
    private final String secKolId;

    @SerializedName("sec_shop_id")
    private final String secShopId;

    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_SELLING_POINT)
    private final String sellingPoint;

    @SerializedName(InvHitPoint.ShareMethod.SHARE_LINK)
    private final String shareLink;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("shop_name")
    private final String shopName;

    @SerializedName("short_title")
    private final String shortTitle;

    @SerializedName("state")
    private final Integer state;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<l> tags;

    @SerializedName("title")
    private final String title;

    @SerializedName("vertical_market")
    private final String verticalMarket;

    @SerializedName("visitor_count")
    private final Long visitorCount;

    public e() {
    }
}
