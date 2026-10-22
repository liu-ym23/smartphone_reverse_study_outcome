package cg3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\rR\u001c\u0010'\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\rR\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcg3/f;", "", "", "orderId", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "productId", "g", "", "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "rankShop", "l", "rankLogistic", "k", "rankGood", "j", "photos", "e", "videos", "p", "isAnonymous", "q", "contentCount", "b", "price", "f", "sales", "m", "", "productImages", "Ljava/util/List;", "h", "()Ljava/util/List;", "productTitle", "i", "topic", "n", "", "topicV2", "o", "", "fromReasonSelect", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("content")
    private final String content;

    @SerializedName("content_count")
    private final Long contentCount;

    @SerializedName("from_reason_select")
    private final Boolean fromReasonSelect;

    @SerializedName("anonymous")
    private final Long isAnonymous;

    @SerializedName("order_id")
    private final Long orderId;

    @SerializedName("photos")
    private final String photos;

    @SerializedName("product_price")
    private final String price;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final Long productId;

    @SerializedName("product_images")
    private final List<String> productImages;

    @SerializedName("product_title")
    private final String productTitle;

    @SerializedName("rank_good")
    private final Long rankGood;

    @SerializedName("rank_logistic")
    private final Long rankLogistic;

    @SerializedName("rank_shop")
    private final Long rankShop;

    @SerializedName("product_sales")
    private final String sales;

    @SerializedName("topic")
    private final String topic;

    @SerializedName("topic_v2")
    private final List<String> topicV2;

    @SerializedName("videos")
    private final String videos;

    public f() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071);
    }

    public final String a() {
        return this.content;
    }

    public final Long b() {
        return this.contentCount;
    }

    public final Boolean c() {
        return this.fromReasonSelect;
    }

    public final Long d() {
        return this.orderId;
    }

    public final String e() {
        return this.photos;
    }

    public final String f() {
        return this.price;
    }

    public final Long g() {
        return this.productId;
    }

    public final List<String> h() {
        return this.productImages;
    }

    public final String i() {
        return this.productTitle;
    }

    public final Long j() {
        return this.rankGood;
    }

    public final Long k() {
        return this.rankLogistic;
    }

    public final Long l() {
        return this.rankShop;
    }

    public final String m() {
        return this.sales;
    }

    public final String n() {
        return this.topic;
    }

    public final List<String> o() {
        return this.topicV2;
    }

    public final String p() {
        return this.videos;
    }

    public final Long q() {
        return this.isAnonymous;
    }

    public f(Long r18, Long r19, String r20, Long r21, Long r22, Long r23, String r24, String r25, Long r26, Long r27, String r28, String r29, List r30, String r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        Long r2 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Long r4 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Long r6 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Long r7 = null;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Long r8 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Long r11 = 0L;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Long r12 = 0L;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        List r15 = null;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        String r3 = null;
    L59:
        if ((r32 & 65536) == 0) goto L61;
        Boolean r1 = Boolean.FALSE;
    L62:
        this.orderId = r2;
        this.productId = r4;
        this.content = r5;
        this.rankShop = r6;
        this.rankLogistic = r7;
        this.rankGood = r8;
        this.photos = r9;
        this.videos = r10;
        this.isAnonymous = r11;
        this.contentCount = r12;
        this.price = r13;
        this.sales = r14;
        this.productImages = r15;
        this.productTitle = r3;
        this.topic = null;
        this.topicV2 = null;
        this.fromReasonSelect = r1;
        return;
    L61:
        r1 = null;
        goto L62
    L57:
        r3 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
