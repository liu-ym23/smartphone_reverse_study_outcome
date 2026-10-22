package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00106\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010;\u001a\u00020:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR(\u0010K\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010U\u001a\u0004\u0018\u00010T8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001c\u0010Z\u001a\u0004\u0018\u00010Y8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006^"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t0;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "image", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "i", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "title", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "p", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "benefits", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "carouselBenefits", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "f", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", TraceCons.METRIC_BACKGROUND, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "price", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "k", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "purchase", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "m", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "blank", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "e", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "atmosphere", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "", "", "durations", "Ljava/util/List;", "g", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "secondFrame", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "n", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "", "status", "I", "getStatus", "()I", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "l", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "bizExtendParam", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "", "", "eventParams", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "o", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "track", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "q", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "openPriceAnimation", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "j", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("atmosphere")
    private final IntroAtmosphere atmosphere;

    @SerializedName(TraceCons.METRIC_BACKGROUND)
    private final e background;

    @SerializedName("benefits")
    private final g benefits;

    @SerializedName("biz_extend_param")
    private final h bizExtendParam;

    @SerializedName("blank")
    private final i blank;

    @SerializedName("carousel_benefits")
    private final l carouselBenefits;

    @SerializedName("durations")
    private final List<Long> durations;

    @SerializedName("event_param")
    private final Map<String, String> eventParams;

    @SerializedName("image")
    private final u image;

    @SerializedName("open_price_animation")
    private final y openPriceAnimation;

    @SerializedName("price")
    private final IntroPrice price;

    @SerializedName("product")
    private final IntroProduct product;

    @SerializedName("purchase")
    private final k0 purchase;

    @SerializedName("second_frame")
    private final g0 secondFrame;

    @SerializedName("standard_event_track")
    private final StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private final int status;

    @SerializedName("title")
    private final o0 title;

    @SerializedName("track")
    private final j0 track;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t0) == false) goto L42;
        t0 r4 = (t0) r3;
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.benefits, r4.benefits) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.carouselBenefits, r4.carouselBenefits) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.background, r4.background) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.purchase, r4.purchase) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.blank, r4.blank) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.atmosphere, r4.atmosphere) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.durations, r4.durations) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.secondFrame, r4.secondFrame) == true) goto L28;
        return false;
    L28:
        if (this.status == r4.status) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.product, r4.product) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.bizExtendParam, r4.bizExtendParam) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.eventParams, r4.eventParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.standardEventTrack, r4.standardEventTrack) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.track, r4.track) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.openPriceAnimation, r4.openPriceAnimation) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public final int hashCode() {
        u r0 = this.image;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        o0 r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        g r7 = this.benefits;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        l r10 = this.carouselBenefits;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        e r13 = this.background;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        IntroPrice r16 = this.price;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        k0 r19 = this.purchase;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        i r22 = this.blank;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        IntroAtmosphere r25 = this.atmosphere;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<Long> r28 = this.durations;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        g0 r31 = this.secondFrame;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (((r30 + r32) * 31) + this.status) * 31;
        IntroProduct r34 = this.product;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        h r37 = this.bizExtendParam;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Map<String, String> r40 = this.eventParams;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        StandardEventTrack r43 = this.standardEventTrack;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        j0 r46 = this.track;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        y r49 = this.openPriceAnimation;
        if (r49 == null) goto L70;
        r1 = r49.hashCode();
    L70:
        return r48 + r1;
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
        return "LiveIntroProduct(image=" + this.image + ", title=" + this.title + ", benefits=" + this.benefits + ", carouselBenefits=" + this.carouselBenefits + ", background=" + this.background + ", price=" + this.price + ", purchase=" + this.purchase + ", blank=" + this.blank + ", atmosphere=" + this.atmosphere + ", durations=" + this.durations + ", secondFrame=" + this.secondFrame + ", status=" + this.status + ", product=" + this.product + ", bizExtendParam=" + this.bizExtendParam + ", eventParams=" + this.eventParams + ", standardEventTrack=" + this.standardEventTrack + ", track=" + this.track + ", openPriceAnimation=" + this.openPriceAnimation + ")";
    }

    public t0() {
        this.image = null;
        this.title = null;
        this.benefits = null;
        this.carouselBenefits = null;
        this.background = null;
        this.price = null;
        this.purchase = null;
        this.blank = null;
        this.atmosphere = null;
        this.durations = null;
        this.secondFrame = null;
        this.status = 0;
        this.product = null;
        this.bizExtendParam = null;
        this.eventParams = null;
        this.standardEventTrack = null;
        this.track = null;
        this.openPriceAnimation = null;
    }

    public final IntroAtmosphere a() {
        return this.atmosphere;
    }

    public final e b() {
        return this.background;
    }

    public final g c() {
        return this.benefits;
    }

    public final h d() {
        return this.bizExtendParam;
    }

    public final i e() {
        return this.blank;
    }

    public final l f() {
        return this.carouselBenefits;
    }

    public final List<Long> g() {
        return this.durations;
    }

    public final Map<String, String> h() {
        return this.eventParams;
    }

    public final u i() {
        return this.image;
    }

    public final y j() {
        return this.openPriceAnimation;
    }

    public final IntroPrice k() {
        return this.price;
    }

    public final IntroProduct l() {
        return this.product;
    }

    public final k0 m() {
        return this.purchase;
    }

    public final g0 n() {
        return this.secondFrame;
    }

    public final StandardEventTrack o() {
        return this.standardEventTrack;
    }

    public final o0 p() {
        return this.title;
    }

    public final j0 q() {
        return this.track;
    }
}
