package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.commerce.service.models.TaoBao;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 {2\u00020\u0001:\u0002|}B\u0007¢\u0006\u0004\by\u0010zR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR$\u0010)\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR$\u00102\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\"\u00105\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR*\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010@\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R*\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010;\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0004\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR$\u0010^\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0004\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR$\u0010g\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0004\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR$\u0010k\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR*\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010;\u001a\u0004\br\u0010=\"\u0004\bs\u0010?R\"\u0010t\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010\u001a\u001a\u0004\bu\u0010\u001c\"\u0004\bv\u0010\u001eR\u0017\u0010w\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\bw\u0010!\u001a\u0004\bx\u0010#¨\u0006~"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/BaseDetailPromotion;", "Ljava/io/Serializable;", "", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "setPromotionId", "(Ljava/lang/String;)V", "productId", "getProductId", "setProductId", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "detailUrl", "getDetailUrl", "setDetailUrl", "elasticTitle", "getElasticTitle", "setElasticTitle", "elasticIntroduction", "getElasticIntroduction", "setElasticIntroduction", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "", "promotionSource", "J", "getPromotionSource", "()J", "setPromotionSource", "(J)V", "elasticType", "getElasticType", "setElasticType", "marketPrice", "Ljava/lang/Integer;", "getMarketPrice", "()Ljava/lang/Integer;", "setMarketPrice", "(Ljava/lang/Integer;)V", "minPrice", "getMinPrice", "setMinPrice", "maxPrice", "getMaxPrice", "setMaxPrice", SalesInfoStruct.SALES, "getSales", "setSales", "", "Lt14/a;", "images", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "elasticImages", "getElasticImages", "setElasticImages", "labels", "getLabels", "setLabels", "Lcom/ss/android/ugc/aweme/commerce/service/models/TaoBao;", "taobao", "Lcom/ss/android/ugc/aweme/commerce/service/models/TaoBao;", "getTaobao", "()Lcom/ss/android/ugc/aweme/commerce/service/models/TaoBao;", "setTaobao", "(Lcom/ss/android/ugc/aweme/commerce/service/models/TaoBao;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionToutiao;", "toutiao", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionToutiao;", "getToutiao", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionToutiao;", "setToutiao", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionToutiao;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionVisitor;", "visitor", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionVisitor;", "getVisitor", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionVisitor;", "setVisitor", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionVisitor;)V", "smallAppUrl", "getSmallAppUrl", "setSmallAppUrl", "brandIcon", "Lt14/a;", "getBrandIcon", "()Lt14/a;", "setBrandIcon", "(Lt14/a;)V", "jumpToAppUrl", "getJumpToAppUrl", "setJumpToAppUrl", "goodsSource", "getGoodsSource", "setGoodsSource", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;", "buyBtn", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;", "getBuyBtn", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;", "setBuyBtn", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;)V", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "price", "getPrice", "setPrice", "commodityType", "getCommodityType", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SourceType", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public class BaseDetailPromotion implements Serializable {
    public static final a Companion = null;
    public static final int ELASTIC_TYPE_UPDATE = 2;
    public static final int NEW = 2;
    public static final int NORMAL = 1;
    public static final int RECOMMEND = 3;

    @SerializedName("brand_icon")
    private t14.a brandIcon;

    @SerializedName("buy_button")
    private CommerceButton buyBtn;
    private final long commodityType;

    @SerializedName("detail_url")
    private String detailUrl;

    @SerializedName("elastic_images")
    private List<? extends t14.a> elasticImages;

    @SerializedName("elastic_introduction")
    private String elasticIntroduction;

    @SerializedName("elastic_title")
    private String elasticTitle;

    @SerializedName("elastic_type")
    private int elasticType;

    @SerializedName("goods_source")
    private String goodsSource;

    @SerializedName("images")
    private List<? extends t14.a> images;

    @SerializedName(PdpOpenThirdParam.KEY_OPEN_APP_URL)
    private String jumpToAppUrl;

    @SerializedName("label")
    private List<String> labels;

    @SerializedName("market_price")
    private Integer marketPrice;

    @SerializedName("max_price")
    private Integer maxPrice;

    @SerializedName("min_price")
    private int minPrice;

    @SerializedName("price")
    private int price;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("promotion_id")
    private String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private long promotionSource;

    @SerializedName(SalesInfoStruct.SALES)
    private int sales;

    @SerializedName("small_app_url")
    private String smallAppUrl;

    @SerializedName("status")
    private int status;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<String> tags;

    @SerializedName("taobao")
    private TaoBao taobao;

    @SerializedName("title")
    private String title;

    @SerializedName("toutiao")
    private PromotionToutiao toutiao;

    @SerializedName("visitor")
    private PromotionVisitor visitor;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/BaseDetailPromotion$SourceType;", "", "", "type", "J", "getType", "()J", "TAOBAO", "GAME", "EASY_GO", "EASY_GO_SELECTED", "TAOBAO_PHONE", "XIAO_DIAN", "TAOBAO_COMMAND", "JINGDONG", "KAOLA", "UNKNOWN", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final enum SourceType extends Enum<SourceType> {
        public static final SourceType EASY_GO = null;
        public static final SourceType EASY_GO_SELECTED = null;
        public static final SourceType GAME = null;
        public static final SourceType JINGDONG = null;
        public static final SourceType KAOLA = null;
        public static final SourceType TAOBAO = null;
        public static final SourceType TAOBAO_COMMAND = null;
        public static final SourceType TAOBAO_PHONE = null;
        public static final SourceType UNKNOWN = null;
        public static final SourceType XIAO_DIAN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SourceType[] f198197a = null;
        private final long type;

        public static SourceType valueOf(String r100) {
            return (SourceType) r27.a.a(SourceType.class, r100);
        }

        public static SourceType[] values() {
            return (SourceType[]) f198197a.clone();
        }

        static {
            SourceType r100 = new SourceType("TAOBAO", 0, 1);
            TAOBAO = r100;
            SourceType r101 = new SourceType("GAME", 1, 2);
            GAME = r101;
            SourceType r102 = new SourceType("EASY_GO", 2, 3);
            EASY_GO = r102;
            SourceType r103 = new SourceType("EASY_GO_SELECTED", 3, 4);
            EASY_GO_SELECTED = r103;
            SourceType r104 = new SourceType("TAOBAO_PHONE", 4, 5);
            TAOBAO_PHONE = r104;
            SourceType r105 = new SourceType("XIAO_DIAN", 5, 6);
            XIAO_DIAN = r105;
            SourceType r106 = new SourceType("TAOBAO_COMMAND", 6, 7);
            TAOBAO_COMMAND = r106;
            SourceType r110 = new SourceType("JINGDONG", 7, 8);
            JINGDONG = r110;
            SourceType r111 = new SourceType("KAOLA", 8, 9);
            KAOLA = r111;
            SourceType r112 = new SourceType("UNKNOWN", 9, -1);
            UNKNOWN = r112;
            f198197a = new SourceType[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112};
        }

        public final long getType() {
            return this.type;
        }

        public SourceType(String r100, int r101, long r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BaseDetailPromotion() {
        this.promotionId = "";
        this.productId = "";
        this.title = "";
        this.detailUrl = "";
        this.elasticTitle = "";
        this.elasticIntroduction = "";
        this.status = 2;
        this.promotionSource = SourceType.UNKNOWN.getType();
        this.sales = -1;
        this.images = CollectionsKt.emptyList();
        this.elasticImages = CollectionsKt.emptyList();
        this.labels = CollectionsKt.emptyList();
        this.goodsSource = "";
        this.commodityType = this.promotionSource;
    }

    public final t14.a getBrandIcon() {
        return this.brandIcon;
    }

    public final CommerceButton getBuyBtn() {
        return this.buyBtn;
    }

    public final long getCommodityType() {
        return this.commodityType;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final List<t14.a> getElasticImages() {
        return this.elasticImages;
    }

    public final String getElasticIntroduction() {
        return this.elasticIntroduction;
    }

    public final String getElasticTitle() {
        return this.elasticTitle;
    }

    public final int getElasticType() {
        return this.elasticType;
    }

    public final String getGoodsSource() {
        return this.goodsSource;
    }

    public final List<t14.a> getImages() {
        return this.images;
    }

    public final String getJumpToAppUrl() {
        return this.jumpToAppUrl;
    }

    public final List<String> getLabels() {
        return this.labels;
    }

    public final Integer getMarketPrice() {
        return this.marketPrice;
    }

    public final Integer getMaxPrice() {
        return this.maxPrice;
    }

    public final int getMinPrice() {
        return this.minPrice;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final int getSales() {
        return this.sales;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final TaoBao getTaobao() {
        return this.taobao;
    }

    public final String getTitle() {
        return this.title;
    }

    public final PromotionToutiao getToutiao() {
        return this.toutiao;
    }

    public final PromotionVisitor getVisitor() {
        return this.visitor;
    }

    public final void setBrandIcon(t14.a r100) {
        this.brandIcon = r100;
    }

    public final void setBuyBtn(CommerceButton r100) {
        this.buyBtn = r100;
    }

    public final void setDetailUrl(String r100) {
        this.detailUrl = r100;
    }

    public final void setElasticImages(List<? extends t14.a> r100) {
        this.elasticImages = r100;
    }

    public final void setElasticIntroduction(String r100) {
        this.elasticIntroduction = r100;
    }

    public final void setElasticTitle(String r100) {
        this.elasticTitle = r100;
    }

    public final void setElasticType(int r100) {
        this.elasticType = r100;
    }

    public final void setGoodsSource(String r100) {
        this.goodsSource = r100;
    }

    public final void setImages(List<? extends t14.a> r100) {
        this.images = r100;
    }

    public final void setJumpToAppUrl(String r100) {
        this.jumpToAppUrl = r100;
    }

    public final void setLabels(List<String> r100) {
        this.labels = r100;
    }

    public final void setMarketPrice(Integer r100) {
        this.marketPrice = r100;
    }

    public final void setMaxPrice(Integer r100) {
        this.maxPrice = r100;
    }

    public final void setMinPrice(int r100) {
        this.minPrice = r100;
    }

    public final void setPrice(int r100) {
        this.price = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setPromotionSource(long r100) {
        this.promotionSource = r100;
    }

    public final void setSales(int r100) {
        this.sales = r100;
    }

    public final void setSmallAppUrl(String r100) {
        this.smallAppUrl = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTags(List<String> r100) {
        this.tags = r100;
    }

    public final void setTaobao(TaoBao r100) {
        this.taobao = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setToutiao(PromotionToutiao r100) {
        this.toutiao = r100;
    }

    public final void setVisitor(PromotionVisitor r100) {
        this.visitor = r100;
    }
}
