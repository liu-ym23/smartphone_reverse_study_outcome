package rd3;

import com.bytedance.android.ec.model.InnerFlowAdData;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.CommerceGoodCoupon;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentStatStruct;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\bU\u0010VR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010?\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\rR$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010O\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lrd3/a;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "parentProductId", "e", "Lrd3/o;", "rank", "Lrd3/o;", "g", "()Lrd3/o;", "Lyd3/p;", "resourceCard", "Lyd3/p;", "i", "()Lyd3/p;", "setResourceCard", "(Lyd3/p;)V", "resourceBarData", "h", "Lcom/bytedance/android/shopping/feed/model/FeedUserStruct;", "user", "Lcom/bytedance/android/shopping/feed/model/FeedUserStruct;", "getUser", "()Lcom/bytedance/android/shopping/feed/model/FeedUserStruct;", "Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "live", "Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "getLive", "()Lcom/bytedance/android/shopping/feed/model/FeedLiveStruct;", "Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "video", "Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "getVideo", "()Lcom/bytedance/android/shopping/feed/model/FeedVideoStruct;", "Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "products", "Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "getProducts", "()Lcom/bytedance/android/shopping/feed/model/GuessULikeItemProductStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "coupon", "Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "getCoupon", "()Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "promotion", "Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "f", "()Lcom/bytedance/android/ec/model/inflowfeed/Promotion;", "k", "(Lcom/bytedance/android/ec/model/inflowfeed/Promotion;)V", "", "promotions", "Ljava/util/List;", "getPromotions", "()Ljava/util/List;", "setPromotions", "(Ljava/util/List;)V", "aweme", "getAweme", "Lrd3/g;", "extra", "Lrd3/g;", "d", "()Lrd3/g;", "j", "(Lrd3/g;)V", "Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", "ad", "Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", "a", "()Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", "setAd", "(Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;)V", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public static final C0231a r = null;
    public InnerFlowAdRawData a;

    @SerializedName("ad")
    private GuessULikeAdData ad;

    @SerializedName("aweme")
    private final String aweme;
    public String b;
    public transient ProductFeedViewModel c;

    @SerializedName("coupon")
    private final CommerceGoodCoupon coupon;
    public String d;
    public boolean e;

    @SerializedName("extra")
    private g extra;
    public int f;
    public Integer g;
    public String h;
    public String i;

    @SerializedName("id")
    private final String id;
    public String j;
    public final Map<String, String> k;
    public Integer l;

    @SerializedName("live")
    private final FeedLiveStruct live;
    public String m;
    public boolean n;
    public String o;
    public Map<String, String> p;

    @SerializedName("parent_product_id")
    private final String parentProductId;

    @SerializedName("products")
    private final GuessULikeItemProductStruct products;

    @SerializedName("promotion")
    private Promotion promotion;

    @SerializedName("promotions")
    private List<Promotion> promotions;
    public boolean q;

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
    public static final class C0231a {
        public C0231a() {
        }

        public static a c(PromotionProductStruct r2) {
            Intrinsics.checkNotNullParameter(r2, "promotionStruct");
            a r0 = new a();
            r0.l(2);
            Promotion r1 = new Promotion();
            r1.setPromotionInfo(r2);
            Unit r3 = Unit.INSTANCE;
            r0.k(r1);
            r0.f = 0;
            r0.e = false;
            return r0;
        }

        public static a a(AnchorV3Param r6, PromotionProductStruct r7) {
            a r0 = new a();
            r0.l(2);
            Promotion r1 = new Promotion();
            r1.setPromotionInfo(r7);
            Unit r2 = Unit.INSTANCE;
            r0.k(r1);
            boolean r3 = false;
            r0.e = false;
            Map<String, String> r4 = null;
            if (r6 == null) goto L8;
            ECLogExtraData r5 = r6.getLogExtraData();
            if (r5 == null) goto L8;
            String r8 = r5.getRequestId();
            if (r8 == null) goto L8;
        L15:
            String r9 = "";
            if (r8 != null) goto L18;
            r8 = "";
        L18:
            r0.d = r8;
            g r10 = new g();
            if (r6 == null) goto L26;
            ECLogExtraData r11 = r6.getLogExtraData();
            if (r11 == null) goto L26;
            String r12 = r11.getRecommendInfo();
            if (r12 == null) goto L26;
            r9 = r12;
        L26:
            r10.d(r9);
            if (r6 == null) goto L29;
            Integer r13 = r6.getFollowStatus();
        L31:
            if (r13 != null) goto L34;
        L36:
            r10.c(Boolean.valueOf(r3));
            r0.j(r10);
            if (r6 == null) goto L39;
            InnerFlowAdRawData r14 = r6.getAdInnerFlowLogExtra();
        L40:
            r0.a = r14;
            if (r6 != null) goto L43;
        L62:
            if (r7 == null) goto L64;
            String r15 = r7.getGoodPriceStripData();
        L65:
            r0.o = r15;
            if (r7 == null) goto L68;
            r4 = r7.getGoodPriceStripLogExtra();
        L68:
            r0.p = r4;
            return r0;
        L64:
            r15 = null;
            goto L65
        L43:
            if (com.bytedance.android.shopping.anchorv3.a.c(r6) != true) goto L62;
            InnerFlowAdRawData r16 = r0.a;
            if (r16 == null) goto L51;
            JSONObject r17 = com.bytedance.android.shopping.anchorv3.a.a(r6);
            if (r17 == null) goto L49;
            String r18 = r17.optString("log_extra");
        L50:
            r16.setLogExtra(r18);
            goto L51
        L49:
            r18 = null;
        L51:
            InnerFlowAdRawData r19 = r0.a;
            if (r19 == null) goto L62;
            InnerFlowAdData r20 = r19.getAdData();
            if (r20 == null) goto L62;
            JSONObject r21 = com.bytedance.android.shopping.anchorv3.a.a(r6);
            if (r21 == null) goto L60;
            String r22 = r21.optString("cid");
            if (r22 == null) goto L60;
            Long r23 = StringsKt.toLongOrNull(r22);
        L61:
            r20.setCreativeId(r23);
        L60:
            r23 = null;
            goto L61
        L39:
            r14 = null;
            goto L40
        L34:
            if (r13.intValue() != 1) goto L36;
            r3 = true;
            goto L36
        L29:
            r13 = null;
        L8:
            if (r6 == null) goto L10;
            String r24 = r6.getEntranceInfo();
        L11:
            JSONObject r25 = com.bytedance.android.shopping.anchorv3.a.d(r24);
            if (r25 == null) goto L14;
            r8 = r25.optString("request_id");
            goto L15
        L14:
            r8 = null;
            goto L15
        L10:
            r24 = null;
            goto L11
        }

        public static a b(ProductFeedViewModel r5, String r6, ProductFeedAdapter.b r7) {
            Intrinsics.checkNotNullParameter(r5, "productFeedViewModel");
            Intrinsics.checkNotNullParameter(r6, "promotionId");
            AnchorV3Param r0 = r5.m907getAnchorV3Param();
            if (r7 == null) goto L5;
            PromotionProductStruct r8 = (PromotionProductStruct) r7.b;
        L6:
            if (r0 == null) goto L19;
            List r2 = r0.getPromotions();
            if (r2 == null) goto L19;
            Iterator r3 = r2.iterator();
        L11:
            if (r3.hasNext() == false) goto L19;
            PromotionProductStruct r4 = (PromotionProductStruct) r3.next();
            PromotionProductBaseStruct r9 = r4.getBaseInfo();
            if (r9 == null) goto L15;
            String r10 = r9.getPromotionId();
        L17:
            if (Intrinsics.areEqual(r10, r6) == false) goto L11;
            r8 = r4;
            goto L11
        L15:
            r10 = null;
        L19:
            a r11 = a(r0, r8);
            r11.c = r5;
            return r11;
        L5:
            r8 = null;
            goto L6
        }
    }

    static {
        r = new C0231a();
    }

    public final boolean b() {
        Promotion r0 = this.promotion;
        if (r0 == null) goto L53;
        PromotionProductStruct r1 = r0.getPromotionInfo();
        if (r1 == null) goto L54;
        PromotionProductCommentsStruct r2 = r1.getCommentInfo();
        if (r2 == null) goto L55;
        List r3 = r2.getComments();
        if (r3 != null) goto L11;
        return false;
    L11:
        if ((!r3.isEmpty()) != true) goto L57;
        ProductFeedViewModel r4 = this.c;
        Object r5 = null;
        if (r4 == null) goto L19;
        InnerFlowPageStyleDTO r6 = r4.getInnerFlowPageStyle();
        if (r6 == null) goto L19;
        PageStyle r7 = r6.getPageStyle();
        if (r7 == null) goto L19;
        Integer r8 = r7.getCommentStyle();
    L20:
        if (r8 != null) goto L23;
    L24:
        Promotion r9 = this.promotion;
        if (r9 == null) goto L45;
        PromotionProductStruct r10 = r9.getPromotionInfo();
        if (r10 == null) goto L45;
        PromotionProductCommentsStruct r11 = r10.getCommentInfo();
        if (r11 == null) goto L45;
        List r12 = r11.getStats();
        if (r12 == null) goto L45;
        Iterator r13 = r12.iterator();
    L34:
        if (r13.hasNext() == false) goto L44;
        Object r14 = r13.next();
        Long r15 = ((PromotionProductCommentStatStruct) r14).getId();
        if (r15 != null) goto L39;
    L41:
        boolean r16 = false;
    L42:
        if (r16 == false) goto L34;
        r5 = r14;
        goto L44
    L39:
        if (r15.longValue() != 3) goto L41;
        r16 = true;
    L44:
        r5 = (PromotionProductCommentStatStruct) r5;
    L45:
        if (r5 == null) goto L59;
        return true;
    L59:
        return false;
    L23:
        if (r8.intValue() != 0) goto L24;
        return false;
    L19:
        r8 = null;
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
        Integer r0 = this.type;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        if (r0 != null) goto L16;
    L18:
        if (r0 == null) goto L24;
        if (r0.intValue() != 5) goto L24;
        return "rank_card";
    L24:
        if (r0 == null) goto L32;
        if (r0.intValue() != 23) goto L32;
        yd3.p r1 = this.resourceCard;
        if (r1 == null) goto L32;
        return r1.f();
    L32:
        return "";
    L16:
        if (r0.intValue() != 4) goto L18;
        return "video";
    L11:
        if (r0.intValue() != 2) goto L13;
        return "product";
    L6:
        if (r0.intValue() != 1) goto L8;
        return "live";
    }

    public a() {
        this.e = true;
        this.f = -1;
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = new LinkedHashMap();
        this.l = 0;
        this.m = "";
    }

    public final GuessULikeAdData a() {
        return this.ad;
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

    public final void j(g r1) {
        this.extra = r1;
    }

    public final void k(Promotion r1) {
        this.promotion = r1;
    }

    public final void l(Integer r1) {
        this.type = r1;
    }
}
