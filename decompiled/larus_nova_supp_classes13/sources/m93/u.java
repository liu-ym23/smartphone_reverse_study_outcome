package m93;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b1\u0010\u000bR\u001c\u00102\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000b¨\u00064"}, d2 = {"Lm93/u;", "", "", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "", "kolId", "Ljava/lang/Long;", "getKolId", "()Ljava/lang/Long;", "secKolId", "getSecKolId", "recommendInfo", "getRecommendInfo", "productId", "getProductId", "shopId", "getShopId", "Lm93/y;", "recReason", "Lm93/y;", "getRecReason", "()Lm93/y;", "campaginStock", "getCampaginStock", "Lm93/n;", "coverWhiteBg", "Lm93/n;", "getCoverWhiteBg", "()Lm93/n;", "dupId", "getDupId", "Lm93/l;", "coverLong", "Lm93/l;", "getCoverLong", "()Lm93/l;", "Lm93/m;", "coverRecommend", "Lm93/m;", "getCoverRecommend", "()Lm93/m;", "freightId", "getFreightId", "spuSimId", "getSpuSimId", "brandId", "getBrandId", "vctgClusterId", "getVctgClusterId", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {
    public final String a;
    public final String b;

    @SerializedName("brand_id")
    private final Long brandId;
    public final String c;

    @SerializedName("campagin_stock")
    private final Long campaginStock;

    @SerializedName("cover_long")
    private final l coverLong;

    @SerializedName("cover_recommend")
    private final m coverRecommend;

    @SerializedName("cover_white_bg")
    private final n coverWhiteBg;
    public final k d;

    @SerializedName("dup_id")
    private final Long dupId;
    public final t e;
    public final List<Object> f;

    @SerializedName("freight_id")
    private final Long freightId;
    public final String g;
    public final Long h;
    public final p i;

    @SerializedName("kol_id")
    private final Long kolId;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_ID)
    private final String promotionId;

    @SerializedName("rec_reason")
    private final y recReason;

    @SerializedName("recommend_info")
    private final String recommendInfo;

    @SerializedName("sec_kol_id")
    private final String secKolId;

    @SerializedName("shop_id")
    private final String shopId;

    @SerializedName("spu_sim_id")
    private final Long spuSimId;

    @SerializedName("vctg_cluster_id")
    private final Long vctgClusterId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L56;
        u r4 = (u) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.promotionId, r4.promotionId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.kolId, r4.kolId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.secKolId, r4.secKolId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.recommendInfo, r4.recommendInfo) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.recReason, r4.recReason) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.campaginStock, r4.campaginStock) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.coverWhiteBg, r4.coverWhiteBg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.dupId, r4.dupId) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.coverLong, r4.coverLong) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.coverRecommend, r4.coverRecommend) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.freightId, r4.freightId) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.spuSimId, r4.spuSimId) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.brandId, r4.brandId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.vctgClusterId, r4.vctgClusterId) == true) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        k r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        t r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<Object> r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.promotionId;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.kolId;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.secKolId;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.recommendInfo;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.h;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.productId;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.shopId;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        y r43 = this.recReason;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        p r46 = this.i;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Long r49 = this.campaginStock;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        n r52 = this.coverWhiteBg;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        Long r55 = this.dupId;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        l r58 = this.coverLong;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        m r61 = this.coverRecommend;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        Long r64 = this.freightId;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        Long r67 = this.spuSimId;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        Long r70 = this.brandId;
        if (r70 == null) goto L97;
        int r71 = r70.hashCode();
    L98:
        int r72 = (r69 + r71) * 31;
        Long r73 = this.vctgClusterId;
        if (r73 == null) goto L102;
        r1 = r73.hashCode();
    L102:
        return r72 + r1;
    L97:
        r71 = 0;
        goto L98
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
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

    public final String toString() {
        return "NewerProduct(id=" + this.a + ", title=" + this.b + ", desc=" + this.c + ", cover=" + this.d + ", price=" + this.e + ", tags=" + this.f + ", link=" + this.g + ", promotionId=" + this.promotionId + ", kolId=" + this.kolId + ", secKolId=" + this.secKolId + ", recommendInfo=" + this.recommendInfo + ", status=" + this.h + ", productId=" + this.productId + ", shopId=" + this.shopId + ", recReason=" + this.recReason + ", extra=" + this.i + ", campaginStock=" + this.campaginStock + ", coverWhiteBg=" + this.coverWhiteBg + ", dupId=" + this.dupId + ", coverLong=" + this.coverLong + ", coverRecommend=" + this.coverRecommend + ", freightId=" + this.freightId + ", spuSimId=" + this.spuSimId + ", brandId=" + this.brandId + ", vctgClusterId=" + this.vctgClusterId + ")";
    }

    public u() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.promotionId = null;
        this.kolId = null;
        this.secKolId = null;
        this.recommendInfo = null;
        this.h = null;
        this.productId = null;
        this.shopId = null;
        this.recReason = null;
        this.i = null;
        this.campaginStock = null;
        this.coverWhiteBg = null;
        this.dupId = null;
        this.coverLong = null;
        this.coverRecommend = null;
        this.freightId = null;
        this.spuSimId = null;
        this.brandId = null;
        this.vctgClusterId = null;
    }
}
