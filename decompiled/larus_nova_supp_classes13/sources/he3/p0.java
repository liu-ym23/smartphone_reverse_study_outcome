package he3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010<\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010F\u001a\u0004\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010K\u001a\u0004\u0018\u00010J8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010U\u001a\u0004\u0018\u00010T8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001c\u0010Z\u001a\u0004\u0018\u00010Y8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R(\u0010`\u001a\u0010\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020\u0001\u0018\u00010^8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001c\u0010e\u001a\u0004\u0018\u00010d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001c\u0010j\u001a\u0004\u0018\u00010i8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001c\u0010o\u001a\u0004\u0018\u00010n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010y¨\u0006z"}, d2 = {"Lhe3/p0;", "", "Lhe3/e1;", "baseInfo", "Lhe3/e1;", "b", "()Lhe3/e1;", "Lhe3/c2;", "titleInfo", "Lhe3/c2;", "q", "()Lhe3/c2;", "Lhe3/k1;", "coverInfo", "Lhe3/k1;", "g", "()Lhe3/k1;", "Lhe3/d2;", "titleTagInfo", "Lhe3/d2;", "r", "()Lhe3/d2;", "Lhe3/p1;", "priceInfo", "Lhe3/p1;", "k", "()Lhe3/p1;", "Lhe3/u1;", "salesInfo", "Lhe3/u1;", "n", "()Lhe3/u1;", "Lhe3/b2;", "tagInfo", "Lhe3/b2;", "getTagInfo", "()Lhe3/b2;", "Lhe3/r1;", "recReasonInfo", "Lhe3/r1;", "m", "()Lhe3/r1;", "u", "(Lhe3/r1;)V", "Lhe3/r0;", "shopInfo", "Lhe3/r0;", "p", "()Lhe3/r0;", "Lhe3/q0;", "linkInfo", "Lhe3/q0;", "j", "()Lhe3/q0;", "Lhe3/n1;", "logisticsInfo", "Lhe3/n1;", "getLogisticsInfo", "()Lhe3/n1;", "Lhe3/g2;", "channelInfo", "Lhe3/g2;", "getChannelInfo", "()Lhe3/g2;", "Lhe3/h1;", "cartInfo", "Lhe3/h1;", "d", "()Lhe3/h1;", "Lhe3/g1;", "buyButtonInfo", "Lhe3/g1;", "c", "()Lhe3/g1;", "Lhe3/i1;", "collectInfo", "Lhe3/i1;", "e", "()Lhe3/i1;", "Lhe3/j1;", "commentInfo", "Lhe3/j1;", "f", "()Lhe3/j1;", "Lhe3/v1;", "scrollingTextInfo", "Lhe3/v1;", "getScrollingTextInfo", "()Lhe3/v1;", "Lhe3/a2;", "shareInfo", "Lhe3/a2;", "getShareInfo", "()Lhe3/a2;", "", "", "trackInfo", "Ljava/util/Map;", "s", "()Ljava/util/Map;", "Lhe3/w1;", "searchTagInfo", "Lhe3/w1;", "o", "()Lhe3/w1;", "Lhe3/w0;", "custom", "Lhe3/w0;", "h", "()Lhe3/w0;", "Lhe3/h2;", "promotionInfo", "Lhe3/h2;", "l", "()Lhe3/h2;", "Lhe3/m1;", "extendInfo", "Lhe3/m1;", "i", "()Lhe3/m1;", "t", "(Lhe3/m1;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 {
    public Map<String, ? extends Object> a;

    @SerializedName("base_info")
    private final e1 baseInfo;

    @SerializedName("buy_button_info")
    private final g1 buyButtonInfo;

    @SerializedName("cart_info")
    private final h1 cartInfo;

    @SerializedName("channel_info")
    private final g2 channelInfo;

    @SerializedName("collect_info")
    private final i1 collectInfo;

    @SerializedName("comment_info")
    private final j1 commentInfo;

    @SerializedName("cover_info")
    private final k1 coverInfo;

    @SerializedName("custom")
    private final w0 custom;

    @SerializedName("extend_info")
    private m1 extendInfo;

    @SerializedName("link_info")
    private final q0 linkInfo;

    @SerializedName("logistics_info")
    private final n1 logisticsInfo;

    @SerializedName("price_info")
    private final p1 priceInfo;

    @SerializedName("promotion_info")
    private final h2 promotionInfo;

    @SerializedName("rec_reason_info")
    private r1 recReasonInfo;

    @SerializedName("sales_info")
    private final u1 salesInfo;

    @SerializedName("scrolling_text_info")
    private final v1 scrollingTextInfo;

    @SerializedName("search_tag_info")
    private final w1 searchTagInfo;

    @SerializedName("share_info")
    private final a2 shareInfo;

    @SerializedName("shop_info")
    private final r0 shopInfo;

    @SerializedName("tag_info")
    private final b2 tagInfo;

    @SerializedName("title_info")
    private final c2 titleInfo;

    @SerializedName("title_tag_info")
    private final d2 titleTagInfo;

    @SerializedName("track_info")
    private final Map<String, Object> trackInfo;

    public p0() {
        this(null, null, null, null, null, null, null, null, 8388607);
    }

    public final Map<String, Object> a() {
        Map<String, ? extends Object> r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map<String, Object> r1 = this.trackInfo;
        if (r1 == null) goto L8;
        Object r2 = r1.get("ai_rec_param");
    L10:
        if (TypeIntrinsics.isMutableMap(r2) == true) goto L12;
        r2 = null;
    L12:
        Map<String, ? extends Object> r3 = (Map) r2;
        if (r3 == null) goto L16;
        this.a = r3;
        return r3;
    L16:
        return null;
    L8:
        r2 = null;
        goto L10
    }

    public final e1 b() {
        return this.baseInfo;
    }

    public final g1 c() {
        return this.buyButtonInfo;
    }

    public final h1 d() {
        return this.cartInfo;
    }

    public final i1 e() {
        return this.collectInfo;
    }

    public final j1 f() {
        return this.commentInfo;
    }

    public final k1 g() {
        return this.coverInfo;
    }

    public final w0 h() {
        return this.custom;
    }

    public final m1 i() {
        return this.extendInfo;
    }

    public final q0 j() {
        return this.linkInfo;
    }

    public final p1 k() {
        return this.priceInfo;
    }

    public final h2 l() {
        return this.promotionInfo;
    }

    public final r1 m() {
        return this.recReasonInfo;
    }

    public final u1 n() {
        return this.salesInfo;
    }

    public final w1 o() {
        return this.searchTagInfo;
    }

    public final r0 p() {
        return this.shopInfo;
    }

    public final c2 q() {
        return this.titleInfo;
    }

    public final d2 r() {
        return this.titleTagInfo;
    }

    public final Map<String, Object> s() {
        return this.trackInfo;
    }

    public final void t(m1 r1) {
        this.extendInfo = r1;
    }

    public final void u(r1 r1) {
        this.recReasonInfo = r1;
    }

    public p0(c2 r3, k1 r4, p1 r5, u1 r6, r1 r7, r0 r8, h1 r9, m1 r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 16) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 32) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 128) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 256) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 4096) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 4194304) == 0) goto L26;
        r10 = null;
    L26:
        this.baseInfo = null;
        this.titleInfo = r3;
        this.coverInfo = r4;
        this.titleTagInfo = null;
        this.priceInfo = r5;
        this.salesInfo = r6;
        this.tagInfo = null;
        this.recReasonInfo = r7;
        this.shopInfo = r8;
        this.linkInfo = null;
        this.logisticsInfo = null;
        this.channelInfo = null;
        this.cartInfo = r9;
        this.buyButtonInfo = null;
        this.collectInfo = null;
        this.commentInfo = null;
        this.scrollingTextInfo = null;
        this.shareInfo = null;
        this.trackInfo = null;
        this.searchTagInfo = null;
        this.custom = null;
        this.promotionInfo = null;
        this.extendInfo = r10;
    }
}
