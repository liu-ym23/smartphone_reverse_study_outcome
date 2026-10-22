package m93;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b1\u0010\u000bR\u001c\u00102\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000b¨\u00064"}, d2 = {"Lm93/u;", "", "", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "", "kolId", "Ljava/lang/Long;", "getKolId", "()Ljava/lang/Long;", "secKolId", "getSecKolId", "recommendInfo", "getRecommendInfo", "productId", "getProductId", "shopId", "getShopId", "Lm93/y;", "recReason", "Lm93/y;", "getRecReason", "()Lm93/y;", "campaginStock", "getCampaginStock", "Lm93/n;", "coverWhiteBg", "Lm93/n;", "getCoverWhiteBg", "()Lm93/n;", "dupId", "getDupId", "Lm93/l;", "coverLong", "Lm93/l;", "getCoverLong", "()Lm93/l;", "Lm93/m;", "coverRecommend", "Lm93/m;", "getCoverRecommend", "()Lm93/m;", "freightId", "getFreightId", "spuSimId", "getSpuSimId", "brandId", "getBrandId", "vctgClusterId", "getVctgClusterId", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512624b;

    @SerializedName("brand_id")
    private final Long brandId;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f512625c;

    @SerializedName("campagin_stock")
    private final Long campaginStock;

    @SerializedName("cover_long")
    private final l coverLong;

    @SerializedName("cover_recommend")
    private final m coverRecommend;

    @SerializedName("cover_white_bg")
    private final n coverWhiteBg;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f512626d;

    @SerializedName("dup_id")
    private final Long dupId;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f512627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Object> f512628f;

    @SerializedName("freight_id")
    private final Long freightId;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f512629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f512630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f512631i;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_ID)
    private final Long kolId;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("rec_reason")
    private final y recReason;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName("sec_kol_id")
    private final String secKolId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("spu_sim_id")
    private final Long spuSimId;

    @SerializedName("vctg_cluster_id")
    private final Long vctgClusterId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L56;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f512623a, r101.f512623a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512624b, r101.f512624b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512625c, r101.f512625c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512626d, r101.f512626d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f512627e, r101.f512627e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f512628f, r101.f512628f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512629g, r101.f512629g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.kolId, r101.kolId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.secKolId, r101.secKolId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f512630h, r101.f512630h) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.recReason, r101.recReason) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f512631i, r101.f512631i) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.campaginStock, r101.campaginStock) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.coverWhiteBg, r101.coverWhiteBg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.dupId, r101.dupId) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.coverLong, r101.coverLong) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.coverRecommend, r101.coverRecommend) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.freightId, r101.freightId) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.spuSimId, r101.spuSimId) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.brandId, r101.brandId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.vctgClusterId, r101.vctgClusterId) == true) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f512623a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f512624b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f512625c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        k r110 = this.f512626d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        t r113 = this.f512627e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<Object> r116 = this.f512628f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f512629g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.promotionId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.kolId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.secKolId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.recommendInfo;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f512630h;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.productId;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.shopId;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        y r143 = this.recReason;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        p r146 = this.f512631i;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Long r149 = this.campaginStock;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        n r152 = this.coverWhiteBg;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Long r155 = this.dupId;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        l r158 = this.coverLong;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        m r161 = this.coverRecommend;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Long r164 = this.freightId;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        Long r167 = this.spuSimId;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        Long r170 = this.brandId;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        Long r173 = this.vctgClusterId;
        if (r173 == null) goto L102;
        r101 = r173.hashCode();
    L102:
        return r172 + r101;
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewerProduct(id=" + this.f512623a + ", title=" + this.f512624b + ", desc=" + this.f512625c + ", cover=" + this.f512626d + ", price=" + this.f512627e + ", tags=" + this.f512628f + ", link=" + this.f512629g + ", promotionId=" + this.promotionId + ", kolId=" + this.kolId + ", secKolId=" + this.secKolId + ", recommendInfo=" + this.recommendInfo + ", status=" + this.f512630h + ", productId=" + this.productId + ", shopId=" + this.shopId + ", recReason=" + this.recReason + ", extra=" + this.f512631i + ", campaginStock=" + this.campaginStock + ", coverWhiteBg=" + this.coverWhiteBg + ", dupId=" + this.dupId + ", coverLong=" + this.coverLong + ", coverRecommend=" + this.coverRecommend + ", freightId=" + this.freightId + ", spuSimId=" + this.spuSimId + ", brandId=" + this.brandId + ", vctgClusterId=" + this.vctgClusterId + ")";
    }

    public u() {
        this.f512623a = null;
        this.f512624b = null;
        this.f512625c = null;
        this.f512626d = null;
        this.f512627e = null;
        this.f512628f = null;
        this.f512629g = null;
        this.promotionId = null;
        this.kolId = null;
        this.secKolId = null;
        this.recommendInfo = null;
        this.f512630h = null;
        this.productId = null;
        this.shopId = null;
        this.recReason = null;
        this.f512631i = null;
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
