package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b¨\u0006 "}, d2 = {"Lnv6/s;", "", "", "cardUrl", "Ljava/lang/String;", "getCardUrl", "()Ljava/lang/String;", "", "cardStyle", "Ljava/lang/Integer;", "getCardStyle", "()Ljava/lang/Integer;", "showDuration", "d", "", "showSeconds", "Ljava/lang/Long;", "getShowSeconds", "()Ljava/lang/Long;", "", "needShow", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "delayFadeTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "onlyUpdateSticker", "c", "liveStickerStyle", "getLiveStickerStyle", "isAttrProduct", "e", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("card_style")
    private final Integer cardStyle;

    @SerializedName("card_url")
    private final String cardUrl;

    @SerializedName("delay_fade_time")
    private final Integer delayFadeTime;

    @SerializedName("is_sticker_product")
    private final Integer isAttrProduct;

    @SerializedName("live_sticker_style")
    private final Integer liveStickerStyle;

    @SerializedName("need_show")
    private final Boolean needShow;

    @SerializedName("update_only_sticker")
    private final Integer onlyUpdateSticker;

    @SerializedName("show_duration")
    private final Integer showDuration;

    @SerializedName("show_seconds")
    private final Long showSeconds;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.cardUrl, r101.cardUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardStyle, r101.cardStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showDuration, r101.showDuration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showSeconds, r101.showSeconds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.needShow, r101.needShow) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.delayFadeTime, r101.delayFadeTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.onlyUpdateSticker, r101.onlyUpdateSticker) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.liveStickerStyle, r101.liveStickerStyle) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isAttrProduct, r101.isAttrProduct) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.cardUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cardStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.showDuration;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.showSeconds;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.needShow;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.delayFadeTime;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.onlyUpdateSticker;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.liveStickerStyle;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.isAttrProduct;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GroupPurchaseControlData(cardUrl=" + this.cardUrl + ", cardStyle=" + this.cardStyle + ", showDuration=" + this.showDuration + ", showSeconds=" + this.showSeconds + ", needShow=" + this.needShow + ", delayFadeTime=" + this.delayFadeTime + ", onlyUpdateSticker=" + this.onlyUpdateSticker + ", liveStickerStyle=" + this.liveStickerStyle + ", isAttrProduct=" + this.isAttrProduct + ')';
    }

    public s() {
        Boolean r100 = Boolean.FALSE;
        this.cardUrl = null;
        this.cardStyle = null;
        this.showDuration = null;
        this.showSeconds = null;
        this.needShow = r100;
        this.delayFadeTime = null;
        this.onlyUpdateSticker = null;
        this.liveStickerStyle = null;
        this.isAttrProduct = null;
    }

    public final Integer a() {
        return this.delayFadeTime;
    }

    public final Boolean b() {
        return this.needShow;
    }

    public final Integer c() {
        return this.onlyUpdateSticker;
    }

    public final Integer d() {
        return this.showDuration;
    }

    public final Integer e() {
        return this.isAttrProduct;
    }
}
