package nv6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R$\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!¨\u0006$"}, d2 = {"Lnv6/s0;", "", "", "cardId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Lnv6/x;", "titleUrl", "Lnv6/x;", "f", "()Lnv6/x;", "productImageUrl", "e", "", "width", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "background", "b", "is_folding", "h", "", "Lnv6/g;", "attrInfoList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "eventParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "extraParams", "getExtraParams", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("data")
    private final List<g> attrInfoList;

    @SerializedName("background")
    private final String background;

    @SerializedName("card_id")
    private final String cardId;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("is_folding")
    private final Integer is_folding;

    @SerializedName("product_image_url")
    private final x productImageUrl;

    @SerializedName("title_url")
    private final x titleUrl;

    @SerializedName("width")
    private final Integer width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleUrl, r101.titleUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productImageUrl, r101.productImageUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.is_folding, r101.is_folding) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.attrInfoList, r101.attrInfoList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.cardId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        x r104 = this.titleUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        x r107 = this.productImageUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.width;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.background;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.is_folding;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<g> r119 = this.attrInfoList;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.eventParams;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extraParams;
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
        return "StickerData(cardId=" + this.cardId + ", titleUrl=" + this.titleUrl + ", productImageUrl=" + this.productImageUrl + ", width=" + this.width + ", background=" + this.background + ", is_folding=" + this.is_folding + ", attrInfoList=" + this.attrInfoList + ", eventParams=" + this.eventParams + ", extraParams=" + this.extraParams + ')';
    }

    public s0() {
        this.cardId = null;
        this.titleUrl = null;
        this.productImageUrl = null;
        this.width = null;
        this.background = null;
        this.is_folding = null;
        this.attrInfoList = null;
        this.eventParams = null;
        this.extraParams = null;
    }

    public final List<g> a() {
        return this.attrInfoList;
    }

    public final String b() {
        return this.background;
    }

    public final String c() {
        return this.cardId;
    }

    public final Map<String, String> d() {
        return this.eventParams;
    }

    public final x e() {
        return this.productImageUrl;
    }

    public final x f() {
        return this.titleUrl;
    }

    public final Integer g() {
        return this.width;
    }

    public final Integer h() {
        return this.is_folding;
    }
}
