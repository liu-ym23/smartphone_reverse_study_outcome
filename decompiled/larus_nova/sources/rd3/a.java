package rd3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.ec.model.InnerFlowAdData;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.CommerceGoodCoupon;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentStatStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.model.FeedLiveStruct;
import com.bytedance.android.shopping.feed.model.FeedUserStruct;
import com.bytedance.android.shopping.feed.model.FeedVideoStruct;
import com.bytedance.android.shopping.feed.model.GuessULikeAdData;
import com.bytedance.android.shopping.feed.model.GuessULikeItemProductStruct;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\bU\u0010VR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010?\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\rR$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010O\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lrd3/a;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "parentProductId", "e", "Lrd3/o;", "rank", "Lrd3/o;", ce.f26391f, "()Lrd3/o;", "Lyd3/p;", "resourceCard", "Lyd3/p;", RXScreenCaptureService.KEY_INDEX, "()Lyd3/p;", "setResourceCard", "(Lyd3/p;)V", "resourceBarData", "h", "Lcom/bytedance/android/shopping/feed/model/FeedUserStruct;", "user", "Lcom/bytedance/android/shopping/feed/model/FeedUserStruct;", "getUser", "()Lcom/bytedance/android/shopping/feed/model/FeedUserStruct;", "Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "live", "Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "getLive", "()Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "video", "Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "getVideo", "()Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "products", "Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "getProducts", "()Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", AnchorBenefitToast.TYPE_COUPON, "Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "getCoupon", "()Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "promotion", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "f", "()Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", ce.f26396k, "(Lcom/bytedance/android/ec/model/inflowfeed/Promotion;)V", "", "promotions", "Ljava/util/List;", "getPromotions", "()Ljava/util/List;", "setPromotions", "(Ljava/util/List;)V", ShareChannel.DOUYIN, "getAweme", "Lrd3/g;", "extra", "Lrd3/g;", "d", "()Lrd3/g;", ce.f26395j, "(Lrd3/g;)V", "Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", "ad", "Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", "setAd", "(Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;)V", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C7462a f537232r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InnerFlowAdRawData f537233a;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    @SerializedName("ad")
    private GuessULikeAdData f537234ad;

    @SerializedName(ShareChannel.DOUYIN)
    private final String aweme;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f537235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ProductFeedViewModel f537236c;

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private final CommerceGoodCoupon coupon;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f537237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f537238e;

    @SerializedName("extra")
    private g extra;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f537239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f537240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f537241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f537242i;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f537243id;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f537244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f537245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f537246l;

    @SerializedName("live")
    private final FeedLiveStruct live;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f537247m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f537248n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f537249o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, String> f537250p;

    @SerializedName("parent_product_id")
    private final String parentProductId;

    @SerializedName("products")
    private final GuessULikeItemProductStruct products;

    @SerializedName("promotion")
    private Promotion promotion;

    @SerializedName("promotions")
    private List<Promotion> promotions;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f537251q;

    @SerializedName("rank")
    private final o rank;

    @SerializedName("resource_bar_data")
    private final String resourceBarData;

    @SerializedName("inner_resource_card")
    private yd3.p resourceCard;

    @SerializedName("type")
    private Integer type;

    @SerializedName("user")
    private final FeedUserStruct user;

    @SerializedName("video")
    private final FeedVideoStruct video;

    /* JADX INFO: renamed from: rd3.a$a, reason: collision with other inner class name */
    public static final class C7462a {
        public C7462a() {
        }

        public static a c(PromotionProductStruct r100) {
            Intrinsics.checkNotNullParameter(r100, "promotionStruct");
            a r101 = new a();
            r101.l(2);
            Promotion r102 = new Promotion();
            r102.setPromotionInfo(r100);
            Unit r103 = Unit.INSTANCE;
            r101.k(r102);
            r101.f537239f = 0;
            r101.f537238e = false;
            return r101;
        }

        public static a a(AnchorV3Param r100, PromotionProductStruct r101) {
            a r102 = new a();
            r102.l(2);
            Promotion r103 = new Promotion();
            r103.setPromotionInfo(r101);
            Unit r104 = Unit.INSTANCE;
            r102.k(r103);
            boolean r105 = false;
            r102.f537238e = false;
            Map<String, String> r106 = null;
            if (r100 == null) goto L8;
            ECLogExtraData r107 = r100.getLogExtraData();
            if (r107 == null) goto L8;
            String r108 = r107.getRequestId();
            if (r108 == null) goto L8;
        L15:
            String r109 = "";
            if (r108 != null) goto L18;
            r108 = "";
        L18:
            r102.f537237d = r108;
            g r110 = new g();
            if (r100 == null) goto L26;
            ECLogExtraData r111 = r100.getLogExtraData();
            if (r111 == null) goto L26;
            String r112 = r111.getRecommendInfo();
            if (r112 == null) goto L26;
            r109 = r112;
        L26:
            r110.d(r109);
            if (r100 == null) goto L29;
            Integer r113 = r100.getFollowStatus();
        L31:
            if (r113 != null) goto L34;
        L36:
            r110.c(Boolean.valueOf(r105));
            r102.j(r110);
            if (r100 == null) goto L39;
            InnerFlowAdRawData r114 = r100.getAdInnerFlowLogExtra();
        L40:
            r102.f537233a = r114;
            if (r100 != null) goto L43;
        L62:
            if (r101 == null) goto L64;
            String r115 = r101.getGoodPriceStripData();
        L65:
            r102.f537249o = r115;
            if (r101 == null) goto L68;
            r106 = r101.getGoodPriceStripLogExtra();
        L68:
            r102.f537250p = r106;
            return r102;
        L64:
            r115 = null;
            goto L65
        L43:
            if (com.bytedance.android.shopping.anchorv3.a.c(r100) != true) goto L62;
            InnerFlowAdRawData r116 = r102.f537233a;
            if (r116 == null) goto L51;
            JSONObject r117 = com.bytedance.android.shopping.anchorv3.a.a(r100);
            if (r117 == null) goto L49;
            String r118 = r117.optString("log_extra");
        L50:
            r116.setLogExtra(r118);
            goto L51
        L49:
            r118 = null;
        L51:
            InnerFlowAdRawData r119 = r102.f537233a;
            if (r119 == null) goto L62;
            InnerFlowAdData r120 = r119.getAdData();
            if (r120 == null) goto L62;
            JSONObject r121 = com.bytedance.android.shopping.anchorv3.a.a(r100);
            if (r121 == null) goto L60;
            String r122 = r121.optString("cid");
            if (r122 == null) goto L60;
            Long r123 = StringsKt.toLongOrNull(r122);
        L61:
            r120.setCreativeId(r123);
        L60:
            r123 = null;
            goto L61
        L39:
            r114 = null;
            goto L40
        L34:
            if (r113.intValue() != 1) goto L36;
            r105 = true;
            goto L36
        L29:
            r113 = null;
        L8:
            if (r100 == null) goto L10;
            String r124 = r100.getEntranceInfo();
        L11:
            JSONObject r125 = com.bytedance.android.shopping.anchorv3.a.d(r124);
            if (r125 == null) goto L14;
            r108 = r125.optString("request_id");
            goto L15
        L14:
            r108 = null;
            goto L15
        L10:
            r124 = null;
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static a b(ProductFeedViewModel r100, String r101, ProductFeedAdapter.b r102) {
            Intrinsics.checkNotNullParameter(r100, "productFeedViewModel");
            Intrinsics.checkNotNullParameter(r101, "promotionId");
            AnchorV3Param r103 = r100.m8290getAnchorV3Param();
            if (r102 == null) goto L5;
            PromotionProductStruct r104 = (PromotionProductStruct) r102.f174351b;
        L6:
            if (r103 == null) goto L19;
            List<PromotionProductStruct> r105 = r103.getPromotions();
            if (r105 == null) goto L19;
            Iterator<T> r106 = r105.iterator();
        L11:
            if (r106.hasNext() == false) goto L19;
            PromotionProductStruct r107 = (PromotionProductStruct) r106.next();
            PromotionProductBaseStruct r108 = r107.getBaseInfo();
            if (r108 == null) goto L15;
            String r109 = r108.getPromotionId();
        L17:
            if (Intrinsics.areEqual(r109, r101) == false) goto L11;
            r104 = r107;
            goto L11
        L15:
            r109 = null;
        L19:
            a r110 = a(r103, r104);
            r110.f537236c = r100;
            return r110;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        f537232r = new C7462a();
    }

    public final boolean b() {
        Promotion r100 = this.promotion;
        if (r100 == null) goto L53;
        PromotionProductStruct r101 = r100.getPromotionInfo();
        if (r101 == null) goto L54;
        PromotionProductCommentsStruct r102 = r101.getCommentInfo();
        if (r102 == null) goto L55;
        List<PromotionProductCommentStruct> r103 = r102.getComments();
        if (r103 != null) goto L11;
        return false;
    L11:
        if ((!r103.isEmpty()) != true) goto L57;
        ProductFeedViewModel r104 = this.f537236c;
        Object r105 = null;
        if (r104 == null) goto L19;
        InnerFlowPageStyleDTO r106 = r104.getInnerFlowPageStyle();
        if (r106 == null) goto L19;
        PageStyle r107 = r106.getPageStyle();
        if (r107 == null) goto L19;
        Integer r108 = r107.getCommentStyle();
    L20:
        if (r108 != null) goto L23;
    L24:
        Promotion r109 = this.promotion;
        if (r109 == null) goto L45;
        PromotionProductStruct r110 = r109.getPromotionInfo();
        if (r110 == null) goto L45;
        PromotionProductCommentsStruct r111 = r110.getCommentInfo();
        if (r111 == null) goto L45;
        List<PromotionProductCommentStatStruct> r112 = r111.getStats();
        if (r112 == null) goto L45;
        Iterator<T> r113 = r112.iterator();
    L34:
        if (r113.hasNext() == false) goto L44;
        Object r114 = r113.next();
        Long r115 = ((PromotionProductCommentStatStruct) r114).getId();
        if (r115 != null) goto L39;
    L41:
        boolean r116 = false;
    L42:
        if (r116 == false) goto L34;
        r105 = r114;
        goto L44
    L39:
        if (r115.longValue() != 3) goto L41;
        r116 = true;
    L44:
        r105 = (PromotionProductCommentStatStruct) r105;
    L45:
        if (r105 == null) goto L59;
        return true;
    L59:
        return false;
    L23:
        if (r108.intValue() != 0) goto L24;
        return false;
    L19:
        r108 = null;
        goto L20
    L57:
        return false;
    L55:
        return false;
    L54:
        return false;
    L53:
        return false;
    }

    public final String c() {
        Integer r100 = this.type;
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        if (r100 == null) goto L24;
        if (r100.intValue() != 5) goto L24;
        return "rank_card";
    L24:
        if (r100 == null) goto L32;
        if (r100.intValue() != 23) goto L32;
        yd3.p r101 = this.resourceCard;
        if (r101 == null) goto L32;
        return r101.f();
    L32:
        return "";
    L16:
        if (r100.intValue() != 4) goto L18;
        return "video";
    L11:
        if (r100.intValue() != 2) goto L13;
        return "product";
    L6:
        if (r100.intValue() != 1) goto L8;
        return "live";
    }

    public a() {
        this.f537238e = true;
        this.f537239f = -1;
        this.f537241h = "";
        this.f537242i = "";
        this.f537244j = "";
        this.f537245k = new LinkedHashMap();
        this.f537246l = 0;
        this.f537247m = "";
    }

    public final GuessULikeAdData a() {
        return this.f537234ad;
    }

    public final g d() {
        return this.extra;
    }

    public final String e() {
        return this.parentProductId;
    }

    public final Promotion f() {
        return this.promotion;
    }

    public final o g() {
        return this.rank;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String h() {
        return this.resourceBarData;
    }

    public final yd3.p i() {
        return this.resourceCard;
    }

    public final void j(g r100) {
        this.extra = r100;
    }

    public final void k(Promotion r100) {
        this.promotion = r100;
    }

    public final void l(Integer r100) {
        this.type = r100;
    }
}
