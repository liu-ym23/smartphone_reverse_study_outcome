package com.bytedance.android.shopping.dto;

import android.text.TextUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionAppointment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionPreSale;
import com.bytedance.android.ec.model.response.anchorv3.SeckillInfo;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u0090\u0001B\t¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u0007J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007R$\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010)\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R$\u0010/\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010!\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R$\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010!\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\"\u00105\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u00106\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R$\u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u00106\u001a\u0004\bK\u00108\"\u0004\bL\u0010:R$\u0010M\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010E\u001a\u0004\bN\u0010G\"\u0004\bO\u0010IR\"\u0010P\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u00106\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R*\u0010T\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR*\u0010Z\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010W\"\u0004\b\\\u0010YR*\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010U\u001a\u0004\b^\u0010W\"\u0004\b_\u0010YR$\u0010a\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010u\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010!\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R$\u0010x\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R%\u0010~\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010!\u001a\u0004\b\u007f\u0010#\"\u0005\b\u0080\u0001\u0010%R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010!\u001a\u0005\b\u0082\u0001\u0010#\"\u0005\b\u0083\u0001\u0010%R,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0013\u0010\u008c\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010>¨\u0006\u0091\u0001"}, d2 = {"Lcom/bytedance/android/shopping/dto/BaseDetailPromotion;", "Ljava/io/Serializable;", "", "getPrice", "()Ljava/lang/Long;", "", "getFixedSales", "", "isTaobaoGood", "isMiniProgramGood", "isThirdParty", "isJDGood", "isKaolaGood", "isBuyWithoutCheck", "isVirtualGood", "isPreSaleGood", "isAppointment", "isSecKillGood", "isGoodInPreSale", "isGoodInAppointment", "isGoodInSecKill", "", "getFirstFullReduction", "isOnSale", "", "imageList", "shortTitle", "longTitle", "hasCoupon", "hasToutiaoCoupon", "hasTaobaoCoupon", "isOtherTypeGood", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "setPromotionId", "(Ljava/lang/String;)V", "productId", "getProductId", "setProductId", "title", "getTitle", "setTitle", "detailUrl", "getDetailUrl", "setDetailUrl", "elasticTitle", "getElasticTitle", "setElasticTitle", "elasticIntroduction", "getElasticIntroduction", "setElasticIntroduction", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "promotionSource", "J", "getPromotionSource", "()J", "setPromotionSource", "(J)V", "elasticType", "getElasticType", "setElasticType", "marketPrice", "Ljava/lang/Integer;", "getMarketPrice", "()Ljava/lang/Integer;", "setMarketPrice", "(Ljava/lang/Integer;)V", "minPrice", "getMinPrice", "setMinPrice", "maxPrice", "getMaxPrice", "setMaxPrice", "sales", "getSales", "setSales", "Lcom/bytedance/android/ec/model/ECUrlModel;", "images", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "elasticImages", "getElasticImages", "setElasticImages", "labels", "getLabels", "setLabels", "Lcom/bytedance/android/shopping/dto/TaoBao;", "taobao", "Lcom/bytedance/android/shopping/dto/TaoBao;", "getTaobao", "()Lcom/bytedance/android/shopping/dto/TaoBao;", "setTaobao", "(Lcom/bytedance/android/shopping/dto/TaoBao;)V", "Lcom/bytedance/android/shopping/dto/PromotionToutiao;", "toutiao", "Lcom/bytedance/android/shopping/dto/PromotionToutiao;", "getToutiao", "()Lcom/bytedance/android/shopping/dto/PromotionToutiao;", "setToutiao", "(Lcom/bytedance/android/shopping/dto/PromotionToutiao;)V", "Lcom/bytedance/android/shopping/dto/PromotionVisitor;", "visitor", "Lcom/bytedance/android/shopping/dto/PromotionVisitor;", "getVisitor", "()Lcom/bytedance/android/shopping/dto/PromotionVisitor;", "setVisitor", "(Lcom/bytedance/android/shopping/dto/PromotionVisitor;)V", "smallAppUrl", "getSmallAppUrl", "setSmallAppUrl", "brandIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBrandIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setBrandIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "jumpToAppUrl", "getJumpToAppUrl", "setJumpToAppUrl", "goodsSource", "getGoodsSource", "setGoodsSource", "Lcom/bytedance/android/shopping/dto/CommerceButton;", "buyBtn", "Lcom/bytedance/android/shopping/dto/CommerceButton;", "getBuyBtn", "()Lcom/bytedance/android/shopping/dto/CommerceButton;", "setBuyBtn", "(Lcom/bytedance/android/shopping/dto/CommerceButton;)V", "getCommodityType", "commodityType", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseDetailPromotion implements Serializable {
    public static final a Companion = null;
    public static final int ELASTIC_TYPE_UPDATE = 2;
    public static final int NEW = 2;
    public static final int NORMAL = 1;
    public static final int RECOMMEND = 3;

    @SerializedName("brand_icon")
    private ECUrlModel brandIcon;

    @SerializedName("buy_button")
    private CommerceButton buyBtn;

    @SerializedName("detail_url")
    private String detailUrl;

    @SerializedName("elastic_images")
    private List<? extends ECUrlModel> elasticImages;

    @SerializedName("elastic_introduction")
    private String elasticIntroduction;

    @SerializedName("elastic_title")
    private String elasticTitle;

    @SerializedName("elastic_type")
    private int elasticType;

    @SerializedName("goods_source")
    private String goodsSource;

    @SerializedName("images")
    private List<? extends ECUrlModel> images;

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

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private String productId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_ID)
    private String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private long promotionSource;

    @SerializedName("sales")
    private int sales;

    @SerializedName("small_app_url")
    private String smallAppUrl;

    @SerializedName("status")
    private int status;

    @SerializedName("taobao")
    private TaoBao taobao;

    @SerializedName("title")
    private String title;

    @SerializedName("toutiao")
    private PromotionToutiao toutiao;

    @SerializedName("visitor")
    private PromotionVisitor visitor;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(long r3) {
            if (r3 != SourceType.TAOBAO.getType()) goto L5;
        L10:
            return true;
        L5:
            if (r3 == SourceType.TAOBAO_PHONE.getType()) goto L10;
            if (r3 == SourceType.TAOBAO_COMMAND.getType()) goto L10;
            return false;
        }
    }

    @JvmStatic
    public static final boolean isTaobaoGood(long r1) {
        Companion.getClass();
        return a.a(r1);
    }

    static {
        Companion = new a();
    }

    public final String getFirstFullReduction() {
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L7;
        TouTiaoFullReductionInfo r1 = r0.getReductionInfo();
        if (r1 == null) goto L7;
        List<String> r2 = r1.getFullReduction();
    L8:
        List<String> r3 = r2;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        return null;
    L17:
        return (String) ListProtector.get(r2, 0);
    L11:
        if (r3.isEmpty() == true) goto L14;
        r4 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final int getFixedSales() {
        int r0 = this.sales;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    public final boolean hasTaobaoCoupon() {
        TaoBao r0 = this.taobao;
        if (r0 == null) goto L9;
        TaobaoCouponInfo r1 = r0.getCoupon();
        if (r1 == null) goto L9;
        if (r1.isValid() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean hasToutiaoCoupon() {
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L5;
        List<String> r1 = r0.getCouponRule();
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if ((!r1.isEmpty()) == false) goto L10;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final List<String> imageList() {
        List<? extends ECUrlModel> r0 = this.elasticImages;
        if (r0 != null) goto L5;
    L10:
        List<? extends ECUrlModel> r1 = this.images;
        if (r1 == null) goto L19;
        if ((!r1.isEmpty()) != true) goto L19;
        List<? extends ECUrlModel> r2 = this.images;
        Intrinsics.checkNotNull(r2);
        List<String> r3 = ((ECUrlModel) ListProtector.get(r2, 0)).getUrlList();
        if (r3 == null) goto L17;
        return r3;
    L17:
        return CollectionsKt.emptyList();
    L19:
        return CollectionsKt.emptyList();
    L5:
        if ((!r0.isEmpty()) != true) goto L10;
        List<? extends ECUrlModel> r4 = this.elasticImages;
        Intrinsics.checkNotNull(r4);
        List<String> r5 = ((ECUrlModel) ListProtector.get(r4, 0)).getUrlList();
        if (r5 == null) goto L9;
        return r5;
    L9:
        return CollectionsKt.emptyList();
    }

    public final boolean isAppointment() {
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L5;
        PromotionAppointment r1 = r0.getAppointment();
    L6:
        if (r1 == null) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isBuyWithoutCheck() {
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L5;
        Boolean r1 = r0.getNeedCheck();
    L7:
        return Intrinsics.areEqual(r1, Boolean.FALSE);
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isJDGood() {
        a r0 = Companion;
        long r1 = this.promotionSource;
        r0.getClass();
        if (r1 != SourceType.JINGDONG.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isKaolaGood() {
        a r0 = Companion;
        long r1 = this.promotionSource;
        r0.getClass();
        if (r1 != SourceType.KAOLA.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMiniProgramGood() {
        a r0 = Companion;
        long r1 = this.promotionSource;
        r0.getClass();
        if (r1 != SourceType.JINGDONG.getType()) goto L5;
    L8:
        return true;
    L5:
        if (r1 == SourceType.KAOLA.getType()) goto L8;
        return false;
    }

    public final boolean isOnSale() {
        if (this.status != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOtherTypeGood() {
        a r0 = Companion;
        long r1 = this.promotionSource;
        r0.getClass();
        SourceType.a r2 = SourceType.Companion;
        Long r3 = Long.valueOf(r1);
        r2.getClass();
        return !SourceType.a.a(r3);
    }

    public final boolean isPreSaleGood() {
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L5;
        PromotionPreSale r1 = r0.getPreSale();
    L6:
        if (r1 == null) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isTaobaoGood() {
        a r0 = Companion;
        long r1 = this.promotionSource;
        r0.getClass();
        return a.a(r1);
    }

    public final boolean isThirdParty() {
        a r0 = Companion;
        long r1 = this.promotionSource;
        r0.getClass();
        if (a.a(r1) == false) goto L5;
        return true;
    L5:
        if (r1 != SourceType.JINGDONG.getType()) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L18;
        SourceType.a r5 = SourceType.Companion;
        Long r2 = Long.valueOf(r1);
        r5.getClass();
        if ((!SourceType.a.a(r2)) == true) goto L19;
        return false;
    L19:
        return true;
    L18:
        return true;
    L7:
        if (r1 == SourceType.KAOLA.getType()) goto L10;
        r4 = false;
        goto L11
    }

    public final boolean isVirtualGood() {
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L7;
        VirtualPromotionBean r1 = r0.getVirtualPromotion();
        if (r1 == null) goto L7;
        return r1.isVirtualGoods();
    L7:
        return false;
    }

    public final String longTitle() {
        if (TextUtils.isEmpty(this.title) == true) goto L7;
        String r0 = this.title;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        if (TextUtils.isEmpty(this.elasticTitle) == true) goto L10;
        String r1 = this.elasticTitle;
        Intrinsics.checkNotNull(r1);
        return r1;
    L10:
        return "";
    }

    public final String shortTitle() {
        if (TextUtils.isEmpty(this.elasticTitle) == true) goto L7;
        String r0 = this.elasticTitle;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        if (TextUtils.isEmpty(this.title) == true) goto L10;
        String r1 = this.title;
        Intrinsics.checkNotNull(r1);
        return r1;
    L10:
        return "";
    }

    public BaseDetailPromotion() {
        this.status = 2;
        this.promotionSource = SourceType.UNKNOWN.getType();
        this.sales = -1;
        this.images = CollectionsKt.emptyList();
        this.elasticImages = CollectionsKt.emptyList();
        this.labels = CollectionsKt.emptyList();
        this.goodsSource = "";
    }

    public final Long getPrice() {
        if (isThirdParty() == false) goto L6;
        return Long.valueOf(this.minPrice);
    L6:
        if (isGoodInSecKill() == false) goto L13;
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L12;
        SeckillInfo r1 = r0.getSecKillInfo();
        if (r1 == null) goto L12;
        int r2 = r1.getSkuMinPrice();
    L15:
        return Long.valueOf(r2);
    L12:
        return null;
    L13:
        r2 = this.minPrice;
        goto L15
    }

    public final boolean hasCoupon() {
        if (hasTaobaoCoupon() == false) goto L5;
    L8:
        return true;
    L5:
        if (hasToutiaoCoupon() == true) goto L8;
        return false;
    }

    public final boolean isGoodInAppointment() {
        if (isAppointment() == true) goto L5;
        return false;
    L5:
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L13;
        PromotionAppointment r1 = r0.getAppointment();
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.getServerTime() >= r1.getStartTime()) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public final boolean isGoodInPreSale() {
        if (isPreSaleGood() == true) goto L5;
        return false;
    L5:
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L13;
        PromotionPreSale r1 = r0.getPreSale();
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.getServerTime() >= r1.getEndTime()) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public final boolean isGoodInSecKill() {
        if (isSecKillGood() == true) goto L5;
        return false;
    L5:
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L16;
        SeckillInfo r1 = r0.getSecKillInfo();
        if (r1 == null) goto L17;
        long r2 = r1.getBeginTime();
        long r4 = r1.getEndTime();
        long r6 = r1.getCurrentTime();
        if (r2 <= r6) goto L13;
        return false;
    L13:
        if (r4 < r6) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    }

    public final boolean isSecKillGood() {
        if (isPreSaleGood() == false) goto L5;
        return false;
    L5:
        if (isAppointment() == true) goto L15;
        PromotionToutiao r0 = this.toutiao;
        if (r0 == null) goto L16;
        SeckillInfo r1 = r0.getSecKillInfo();
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.canBeShow() != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    public final ECUrlModel getBrandIcon() {
        return this.brandIcon;
    }

    public final CommerceButton getBuyBtn() {
        return this.buyBtn;
    }

    public final long getCommodityType() {
        return this.promotionSource;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final List<ECUrlModel> getElasticImages() {
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

    public final List<ECUrlModel> getImages() {
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

    @JvmStatic
    public static final boolean isJDGood(long r3) {
        Companion.getClass();
        if (r3 != SourceType.JINGDONG.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isKaolaGood(long r3) {
        Companion.getClass();
        if (r3 != SourceType.KAOLA.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isSelfGood(long r3) {
        Companion.getClass();
        if (r3 != SourceType.GAME.getType()) goto L5;
    L12:
        return true;
    L5:
        if (r3 == SourceType.EASY_GO.getType()) goto L12;
        if (r3 == SourceType.EASY_GO_SELECTED.getType()) goto L12;
        if (r3 == SourceType.XIAO_DIAN.getType()) goto L12;
        return false;
    }

    public final void setBrandIcon(ECUrlModel r1) {
        this.brandIcon = r1;
    }

    public final void setBuyBtn(CommerceButton r1) {
        this.buyBtn = r1;
    }

    public final void setDetailUrl(String r1) {
        this.detailUrl = r1;
    }

    public final void setElasticImages(List<? extends ECUrlModel> r1) {
        this.elasticImages = r1;
    }

    public final void setElasticIntroduction(String r1) {
        this.elasticIntroduction = r1;
    }

    public final void setElasticTitle(String r1) {
        this.elasticTitle = r1;
    }

    public final void setElasticType(int r1) {
        this.elasticType = r1;
    }

    public final void setGoodsSource(String r1) {
        this.goodsSource = r1;
    }

    public final void setImages(List<? extends ECUrlModel> r1) {
        this.images = r1;
    }

    public final void setJumpToAppUrl(String r1) {
        this.jumpToAppUrl = r1;
    }

    public final void setLabels(List<String> r1) {
        this.labels = r1;
    }

    public final void setMarketPrice(Integer r1) {
        this.marketPrice = r1;
    }

    public final void setMaxPrice(Integer r1) {
        this.maxPrice = r1;
    }

    public final void setMinPrice(int r1) {
        this.minPrice = r1;
    }

    public final void setProductId(String r1) {
        this.productId = r1;
    }

    public final void setPromotionId(String r1) {
        this.promotionId = r1;
    }

    public final void setPromotionSource(long r1) {
        this.promotionSource = r1;
    }

    public final void setSales(int r1) {
        this.sales = r1;
    }

    public final void setSmallAppUrl(String r1) {
        this.smallAppUrl = r1;
    }

    public final void setStatus(int r1) {
        this.status = r1;
    }

    public final void setTaobao(TaoBao r1) {
        this.taobao = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setToutiao(PromotionToutiao r1) {
        this.toutiao = r1;
    }

    public final void setVisitor(PromotionVisitor r1) {
        this.visitor = r1;
    }
}
