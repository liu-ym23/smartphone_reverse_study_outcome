package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.SkuBaseInfoComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b2\b\u0086\b\u0018\u0000 o2\u00020\u0001:\u0001pB\u0095\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u0013\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00103\u001a\u00020\u0013\u0012\b\b\u0002\u00104\u001a\u00020\u0013\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0013\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010;\u001a\u00020\"¢\u0006\u0004\bm\u0010nJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0013HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0013HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0013HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\t\u0010#\u001a\u00020\"HÆ\u0003J\u0097\u0002\u0010<\u001a\u00020\u00002\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010/\u001a\u00020\u00132\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00132\b\b\u0002\u00104\u001a\u00020\u00132\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00108\u001a\u00020\u00132\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010;\u001a\u00020\"HÆ\u0001J\t\u0010=\u001a\u00020\u0002HÖ\u0001J\t\u0010>\u001a\u00020\u0004HÖ\u0001J\u0013\u0010A\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010?HÖ\u0003R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010&\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010'\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010(\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010)\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010N\u001a\u0004\bQ\u0010PR\u001c\u0010*\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010H\u001a\u0004\bR\u0010JR\u001c\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010S\u001a\u0004\bV\u0010UR\u001c\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010S\u001a\u0004\bW\u0010UR\u001c\u0010.\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010H\u001a\u0004\bX\u0010JR\u001a\u0010/\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010Y\u001a\u0004\bZ\u0010[R\u001a\u00100\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010E\u001a\u0004\b\\\u0010GR\u001a\u00101\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010E\u001a\u0004\b]\u0010GR\u001a\u00102\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010E\u001a\u0004\b^\u0010GR\u001a\u00103\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010Y\u001a\u0004\b_\u0010[R\u001a\u00104\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010Y\u001a\u0004\b`\u0010[R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010B\u001a\u0004\ba\u0010DR\u001c\u00106\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010S\u001a\u0004\bb\u0010UR\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010B\u001a\u0004\bc\u0010DR\u001a\u00108\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010Y\u001a\u0004\bd\u0010[R\u001c\u00109\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010e\u001a\u0004\bf\u0010gR\u001c\u0010:\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010h\u001a\u0004\bi\u0010jR\u001a\u0010;\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010k\u001a\u0004\b;\u0010l¨\u0006q"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "Ljava/io/Serializable;", "", "component1", "", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "component3", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "component4", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component5", "component6", "component7", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "component8", "component9", "component10", "component11", "", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "component22", "Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "component23", "", "component24", "activityId", "activityType", "priceDesc", "activityTime", "activityBgUrl", "activityIconImage", "activityHintText", "price", "marketPrice", "discountPrice", "sales", "groupId", "joined", "groupSize", "percent", "skuMinPrice", "skuMaxPrice", "rulePageUrl", "depositPrice", "auctionId", "auctionStatus", "subsidy", "skuInfo", "isGroupBuying", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getActivityId", "()Ljava/lang/String;", "I", "getActivityType", "()I", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPriceDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "getActivityTime", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getActivityBgUrl", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getActivityIconImage", "getActivityHintText", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getPrice", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getMarketPrice", "getDiscountPrice", "getSales", "J", "getGroupId", "()J", "getJoined", "getGroupSize", "getPercent", "getSkuMinPrice", "getSkuMaxPrice", "getRulePageUrl", "getDepositPrice", "getAuctionId", "getAuctionStatus", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "getSubsidy", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "getSkuInfo", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "Z", "()Z", "<init>", "(Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;JIIIJJLjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Ljava/lang/String;JLcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;Z)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityVO implements Serializable {
    public static final a Companion = null;
    public static final long STATUS_BOUGHT_IN = 4;
    public static final long STATUS_DEAL = 3;
    public static final long STATUS_ON_AUCTION = 2;
    public static final long STATUS_OTHER_DEAL = 7;
    public static final long STATUS_PREVIEW = 1;

    @SerializedName("activity_bg_url")
    private final ImageModel activityBgUrl;

    @SerializedName("activity_hint_text")
    private final TextElement activityHintText;

    @SerializedName("activity_icon_image")
    private final ImageModel activityIconImage;

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("activity_time")
    private final ActivityTime activityTime;

    @SerializedName("activity_type")
    private final int activityType;

    @SerializedName("auction_id")
    private final String auctionId;

    @SerializedName("auction_status")
    private final long auctionStatus;

    @SerializedName("deposit_price")
    private final PriceElement depositPrice;

    @SerializedName("discount_price")
    private final PriceElement discountPrice;

    @SerializedName("group_id")
    private final long groupId;

    @SerializedName("group_size")
    private final int groupSize;

    @SerializedName("is_group_buying")
    private final boolean isGroupBuying;

    @SerializedName("joined")
    private final int joined;

    @SerializedName("market_price")
    private final PriceElement marketPrice;

    @SerializedName("percent")
    private final int percent;

    @SerializedName("price")
    private final PriceElement price;

    @SerializedName("price_desc")
    private final TextElement priceDesc;

    @SerializedName("rule_page_url")
    private final String rulePageUrl;

    @SerializedName("sales")
    private final TextElement sales;

    @SerializedName("sku_info")
    private final SkuBaseInfoComponent skuInfo;

    @SerializedName("sku_max_price")
    private final long skuMaxPrice;

    @SerializedName("sku_min_price")
    private final long skuMinPrice;

    @SerializedName("subsidy")
    private final PromotionSubsidizedActivity subsidy;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ActivityVO() {
        this(null, 0, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, null, 0, null, null, false, 16777215, null);
    }

    public static /* synthetic */ ActivityVO copy$default(ActivityVO r17, String r18, int r19, TextElement r20, ActivityTime r21, ImageModel r22, ImageModel r23, TextElement r24, PriceElement r25, PriceElement r26, PriceElement r27, TextElement r28, long r29, int r31, int r32, int r33, long r34, long r36, String r38, PriceElement r39, String r40, long r41, PromotionSubsidizedActivity r43, SkuBaseInfoComponent r44, boolean r45, int r46, Object r47) {
        if ((r46 & 1) == 0) goto L5;
        String r2 = r17.activityId;
    L7:
        if ((r46 & 2) == 0) goto L9;
        int r3 = r17.activityType;
    L11:
        if ((r46 & 4) == 0) goto L13;
        TextElement r4 = r17.priceDesc;
    L15:
        if ((r46 & 8) == 0) goto L17;
        ActivityTime r5 = r17.activityTime;
    L19:
        if ((r46 & 16) == 0) goto L21;
        ImageModel r6 = r17.activityBgUrl;
    L23:
        if ((r46 & 32) == 0) goto L25;
        ImageModel r7 = r17.activityIconImage;
    L27:
        if ((r46 & 64) == 0) goto L29;
        TextElement r8 = r17.activityHintText;
    L31:
        if ((r46 & 128) == 0) goto L33;
        PriceElement r9 = r17.price;
    L35:
        if ((r46 & 256) == 0) goto L37;
        PriceElement r10 = r17.marketPrice;
    L39:
        if ((r46 & 512) == 0) goto L41;
        PriceElement r11 = r17.discountPrice;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        TextElement r12 = r17.sales;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        long r13 = r17.groupId;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        int r15 = r17.joined;
    L54:
        int r35 = r15;
        if ((r46 & 8192) == 0) goto L57;
        int r16 = r17.groupSize;
    L58:
        int r37 = r16;
        if ((r46 & 16384) == 0) goto L61;
        int r110 = r17.percent;
    L62:
        long r210 = r13;
        if ((r46 & 32768) == 0) goto L65;
        long r14 = r17.skuMinPrice;
    L66:
        long r310 = r14;
        if ((r46 & 65536) == 0) goto L69;
        long r111 = r17.skuMaxPrice;
    L70:
        long r311 = r111;
        if ((r46 & 131072) == 0) goto L73;
        String r112 = r17.rulePageUrl;
    L75:
        if ((262144 & r46) == 0) goto L77;
        PriceElement r113 = r17.depositPrice;
    L78:
        PriceElement r312 = r113;
        if ((r46 & 524288) == 0) goto L81;
        String r114 = r17.auctionId;
    L82:
        String r313 = r112;
        String r42 = r114;
        if ((r46 & 1048576) == 0) goto L85;
        long r115 = r17.auctionStatus;
    L86:
        long r48 = r115;
        if ((r46 & 2097152) == 0) goto L89;
        PromotionSubsidizedActivity r116 = r17.subsidy;
    L91:
        if ((4194304 & r46) == 0) goto L93;
        SkuBaseInfoComponent r117 = r17.skuInfo;
    L95:
        if ((r46 & 8388608) == 0) goto L97;
        boolean r1 = r17.isGroupBuying;
    L99:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r210, r35, r37, r110, r310, r311, r313, r312, r42, r48, r116, r117, r1);
    L97:
        r1 = r45;
        goto L99
    L93:
        r117 = r44;
        goto L95
    L89:
        r116 = r43;
        goto L91
    L85:
        r115 = r41;
        goto L86
    L81:
        r114 = r40;
        goto L82
    L77:
        r113 = r39;
        goto L78
    L73:
        r112 = r38;
        goto L75
    L69:
        r111 = r36;
        goto L70
    L65:
        r14 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.activityId;
    }

    public final PriceElement component10() {
        return this.discountPrice;
    }

    public final TextElement component11() {
        return this.sales;
    }

    public final long component12() {
        return this.groupId;
    }

    public final int component13() {
        return this.joined;
    }

    public final int component14() {
        return this.groupSize;
    }

    public final int component15() {
        return this.percent;
    }

    public final long component16() {
        return this.skuMinPrice;
    }

    public final long component17() {
        return this.skuMaxPrice;
    }

    public final String component18() {
        return this.rulePageUrl;
    }

    public final PriceElement component19() {
        return this.depositPrice;
    }

    public final int component2() {
        return this.activityType;
    }

    public final String component20() {
        return this.auctionId;
    }

    public final long component21() {
        return this.auctionStatus;
    }

    public final PromotionSubsidizedActivity component22() {
        return this.subsidy;
    }

    public final SkuBaseInfoComponent component23() {
        return this.skuInfo;
    }

    public final boolean component24() {
        return this.isGroupBuying;
    }

    public final TextElement component3() {
        return this.priceDesc;
    }

    public final ActivityTime component4() {
        return this.activityTime;
    }

    public final ImageModel component5() {
        return this.activityBgUrl;
    }

    public final ImageModel component6() {
        return this.activityIconImage;
    }

    public final TextElement component7() {
        return this.activityHintText;
    }

    public final PriceElement component8() {
        return this.price;
    }

    public final PriceElement component9() {
        return this.marketPrice;
    }

    public final ActivityVO copy(String r31, int r32, TextElement r33, ActivityTime r34, ImageModel r35, ImageModel r36, TextElement r37, PriceElement r38, PriceElement r39, PriceElement r40, TextElement r41, long r42, int r44, int r45, int r46, long r47, long r49, String r51, PriceElement r52, String r53, long r54, PromotionSubsidizedActivity r56, SkuBaseInfoComponent r57, boolean r58) {
        return new ActivityVO(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44, r45, r46, r47, r49, r51, r52, r53, r54, r56, r57, r58);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ActivityVO) == false) goto L54;
        ActivityVO r7 = (ActivityVO) r6;
        if (Intrinsics.areEqual(this.activityId, r7.activityId) == true) goto L8;
        return false;
    L8:
        if (this.activityType == r7.activityType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceDesc, r7.priceDesc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activityTime, r7.activityTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activityBgUrl, r7.activityBgUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.activityIconImage, r7.activityIconImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.activityHintText, r7.activityHintText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.price, r7.price) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.marketPrice, r7.marketPrice) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.discountPrice, r7.discountPrice) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sales, r7.sales) == true) goto L28;
        return false;
    L28:
        if (this.groupId == r7.groupId) goto L30;
        return false;
    L30:
        if (this.joined == r7.joined) goto L32;
        return false;
    L32:
        if (this.groupSize == r7.groupSize) goto L34;
        return false;
    L34:
        if (this.percent == r7.percent) goto L36;
        return false;
    L36:
        if (this.skuMinPrice == r7.skuMinPrice) goto L38;
        return false;
    L38:
        if (this.skuMaxPrice == r7.skuMaxPrice) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.rulePageUrl, r7.rulePageUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.depositPrice, r7.depositPrice) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.auctionId, r7.auctionId) == true) goto L46;
        return false;
    L46:
        if (this.auctionStatus == r7.auctionStatus) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.subsidy, r7.subsidy) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.skuInfo, r7.skuInfo) == true) goto L52;
        return false;
    L52:
        if (this.isGroupBuying == r7.isGroupBuying) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.activityId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.activityType) * 31;
        TextElement r4 = this.priceDesc;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ActivityTime r7 = this.activityTime;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ImageModel r10 = this.activityBgUrl;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ImageModel r13 = this.activityIconImage;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        TextElement r16 = this.activityHintText;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        PriceElement r19 = this.price;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        PriceElement r22 = this.marketPrice;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        PriceElement r25 = this.discountPrice;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        TextElement r28 = this.sales;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        long r31 = this.groupId;
        int r32 = (((((((r30 + ((int) (r31 ^ (r31 >>> 32)))) * 31) + this.joined) * 31) + this.groupSize) * 31) + this.percent) * 31;
        long r33 = this.skuMinPrice;
        int r34 = (r32 + ((int) (r33 ^ (r33 >>> 32)))) * 31;
        long r35 = this.skuMaxPrice;
        int r36 = (r34 + ((int) (r35 ^ (r35 >>> 32)))) * 31;
        String r37 = this.rulePageUrl;
        if (r37 == null) goto L45;
        int r38 = r37.hashCode();
    L46:
        int r39 = (r36 + r38) * 31;
        PriceElement r40 = this.depositPrice;
        if (r40 == null) goto L49;
        int r41 = r40.hashCode();
    L50:
        int r42 = (r39 + r41) * 31;
        String r43 = this.auctionId;
        if (r43 == null) goto L53;
        int r44 = r43.hashCode();
    L54:
        int r45 = (r42 + r44) * 31;
        long r46 = this.auctionStatus;
        int r47 = (r45 + ((int) (r46 ^ (r46 >>> 32)))) * 31;
        PromotionSubsidizedActivity r48 = this.subsidy;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (r47 + r49) * 31;
        SkuBaseInfoComponent r51 = this.skuInfo;
        if (r51 == null) goto L61;
        r1 = r51.hashCode();
    L61:
        int r52 = (r50 + r1) * 31;
        boolean r53 = this.isGroupBuying;
        ?? r54 = r53;
        if (r53 == false) goto L65;
        r54 = 1;
    L65:
        return r52 + r54;
    L57:
        r49 = 0;
        goto L58
    L53:
        r44 = 0;
        goto L54
    L49:
        r41 = 0;
        goto L50
    L45:
        r38 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ActivityVO(activityId=" + this.activityId + ", activityType=" + this.activityType + ", priceDesc=" + this.priceDesc + ", activityTime=" + this.activityTime + ", activityBgUrl=" + this.activityBgUrl + ", activityIconImage=" + this.activityIconImage + ", activityHintText=" + this.activityHintText + ", price=" + this.price + ", marketPrice=" + this.marketPrice + ", discountPrice=" + this.discountPrice + ", sales=" + this.sales + ", groupId=" + this.groupId + ", joined=" + this.joined + ", groupSize=" + this.groupSize + ", percent=" + this.percent + ", skuMinPrice=" + this.skuMinPrice + ", skuMaxPrice=" + this.skuMaxPrice + ", rulePageUrl=" + this.rulePageUrl + ", depositPrice=" + this.depositPrice + ", auctionId=" + this.auctionId + ", auctionStatus=" + this.auctionStatus + ", subsidy=" + this.subsidy + ", skuInfo=" + this.skuInfo + ", isGroupBuying=" + this.isGroupBuying + ")";
    }

    public final ImageModel getActivityBgUrl() {
        return this.activityBgUrl;
    }

    public final TextElement getActivityHintText() {
        return this.activityHintText;
    }

    public final ImageModel getActivityIconImage() {
        return this.activityIconImage;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final ActivityTime getActivityTime() {
        return this.activityTime;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public final String getAuctionId() {
        return this.auctionId;
    }

    public final long getAuctionStatus() {
        return this.auctionStatus;
    }

    public final PriceElement getDepositPrice() {
        return this.depositPrice;
    }

    public final PriceElement getDiscountPrice() {
        return this.discountPrice;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final int getGroupSize() {
        return this.groupSize;
    }

    public final int getJoined() {
        return this.joined;
    }

    public final PriceElement getMarketPrice() {
        return this.marketPrice;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final PriceElement getPrice() {
        return this.price;
    }

    public final TextElement getPriceDesc() {
        return this.priceDesc;
    }

    public final String getRulePageUrl() {
        return this.rulePageUrl;
    }

    public final TextElement getSales() {
        return this.sales;
    }

    public final SkuBaseInfoComponent getSkuInfo() {
        return this.skuInfo;
    }

    public final long getSkuMaxPrice() {
        return this.skuMaxPrice;
    }

    public final long getSkuMinPrice() {
        return this.skuMinPrice;
    }

    public final PromotionSubsidizedActivity getSubsidy() {
        return this.subsidy;
    }

    public final boolean isGroupBuying() {
        return this.isGroupBuying;
    }

    public ActivityVO(String r4, int r5, TextElement r6, ActivityTime r7, ImageModel r8, ImageModel r9, TextElement r10, PriceElement r11, PriceElement r12, PriceElement r13, TextElement r14, long r15, int r17, int r18, int r19, long r20, long r22, String r24, PriceElement r25, String r26, long r27, PromotionSubsidizedActivity r29, SkuBaseInfoComponent r30, boolean r31) {
        this.activityId = r4;
        this.activityType = r5;
        this.priceDesc = r6;
        this.activityTime = r7;
        this.activityBgUrl = r8;
        this.activityIconImage = r9;
        this.activityHintText = r10;
        this.price = r11;
        this.marketPrice = r12;
        this.discountPrice = r13;
        this.sales = r14;
        this.groupId = r15;
        this.joined = r17;
        this.groupSize = r18;
        this.percent = r19;
        this.skuMinPrice = r20;
        this.skuMaxPrice = r22;
        this.rulePageUrl = r24;
        this.depositPrice = r25;
        this.auctionId = r26;
        this.auctionStatus = r27;
        this.subsidy = r29;
        this.skuInfo = r30;
        this.isGroupBuying = r31;
    }

    public /* synthetic */ ActivityVO(String r30, int r31, TextElement r32, ActivityTime r33, ImageModel r34, ImageModel r35, TextElement r36, PriceElement r37, PriceElement r38, PriceElement r39, TextElement r40, long r41, int r43, int r44, int r45, long r46, long r48, String r50, PriceElement r51, String r52, long r53, PromotionSubsidizedActivity r55, SkuBaseInfoComponent r56, boolean r57, int r58, DefaultConstructorMarker r59) {
        if ((r58 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r58 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r58 & 4) == 0) goto L13;
        TextElement r5 = null;
    L15:
        if ((r58 & 8) == 0) goto L17;
        ActivityTime r6 = null;
    L19:
        if ((r58 & 16) == 0) goto L21;
        ImageModel r7 = null;
    L23:
        if ((r58 & 32) == 0) goto L25;
        ImageModel r8 = null;
    L27:
        if ((r58 & 64) == 0) goto L29;
        TextElement r9 = null;
    L31:
        if ((r58 & 128) == 0) goto L33;
        PriceElement r10 = null;
    L35:
        if ((r58 & 256) == 0) goto L37;
        PriceElement r11 = null;
    L39:
        if ((r58 & 512) == 0) goto L41;
        PriceElement r12 = null;
    L43:
        if ((r58 & 1024) == 0) goto L45;
        TextElement r13 = null;
    L46:
        long r15 = 0;
        if ((r58 & 2048) == 0) goto L49;
        long r17 = 0;
    L51:
        if ((r58 & 4096) == 0) goto L53;
        int r14 = 0;
    L55:
        if ((r58 & 8192) == 0) goto L57;
        int r2 = 0;
    L59:
        if ((r58 & 16384) == 0) goto L61;
        int r4 = 0;
    L63:
        if ((r58 & 32768) == 0) goto L65;
        long r19 = 0;
    L67:
        if ((r58 & 65536) == 0) goto L69;
        long r21 = 0;
    L71:
        if ((r58 & 131072) == 0) goto L73;
        String r23 = null;
    L75:
        if ((r58 & 262144) == 0) goto L77;
        PriceElement r24 = null;
    L79:
        if ((r58 & 524288) == 0) goto L81;
        String r25 = null;
    L83:
        if ((r58 & 1048576) != 0) goto L87;
        r15 = r53;
    L87:
        if ((r58 & 2097152) == 0) goto L89;
        PromotionSubsidizedActivity r26 = null;
    L91:
        if ((r58 & 4194304) == 0) goto L93;
        SkuBaseInfoComponent r27 = null;
    L95:
        if ((r58 & 8388608) == 0) goto L97;
        boolean r0 = false;
    L98:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r17, r14, r2, r4, r19, r21, r23, r24, r25, r15, r26, r27, r0);
        return;
    L97:
        r0 = r57;
        goto L98
    L93:
        r27 = r56;
        goto L95
    L89:
        r26 = r55;
        goto L91
    L81:
        r25 = r52;
        goto L83
    L77:
        r24 = r51;
        goto L79
    L73:
        r23 = r50;
        goto L75
    L69:
        r21 = r48;
        goto L71
    L65:
        r19 = r46;
        goto L67
    L61:
        r4 = r45;
        goto L63
    L57:
        r2 = r44;
        goto L59
    L53:
        r14 = r43;
        goto L55
    L49:
        r17 = r41;
        goto L51
    L45:
        r13 = r40;
        goto L46
    L41:
        r12 = r39;
        goto L43
    L37:
        r11 = r38;
        goto L39
    L33:
        r10 = r37;
        goto L35
    L29:
        r9 = r36;
        goto L31
    L25:
        r8 = r35;
        goto L27
    L21:
        r7 = r34;
        goto L23
    L17:
        r6 = r33;
        goto L19
    L13:
        r5 = r32;
        goto L15
    L9:
        r3 = r31;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }
}
