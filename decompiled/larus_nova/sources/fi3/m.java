package fi3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lfi3/m;", "", "", "skuFrom", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "isGroupBuying", "Ljava/lang/Boolean;", ce.f26395j, "()Ljava/lang/Boolean;", "isCustomBuying", RXScreenCaptureService.KEY_INDEX, "scrollToInstallment", "d", "", "termCount", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "", "defaultSpecIDs", "Ljava/util/List;", "b", "()Ljava/util/List;", "ultimateBuyAB", "h", "forceYataSku", "c", "bizIdentifier", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "trackExtra", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("biz_identifier")
    private final String bizIdentifier;

    @SerializedName("default_spec_ids")
    private final List<String> defaultSpecIDs;

    @SerializedName("force_yata_sku")
    private final Integer forceYataSku;

    @SerializedName("is_custombuying")
    private final Boolean isCustomBuying;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING)
    private final Boolean isGroupBuying;

    @SerializedName("scroll_to_installment")
    private final Boolean scrollToInstallment;

    @SerializedName("sku_from")
    private final String skuFrom;

    @SerializedName("term_count")
    private final Integer termCount;

    @SerializedName("track_extra")
    private final Map<String, Object> trackExtra;

    @SerializedName("ultimate_buy_ab")
    private final Integer ultimateBuyAB;

    public m() {
        this(null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L26;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.skuFrom, r101.skuFrom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isGroupBuying, r101.isGroupBuying) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isCustomBuying, r101.isCustomBuying) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scrollToInstallment, r101.scrollToInstallment) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.termCount, r101.termCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultSpecIDs, r101.defaultSpecIDs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ultimateBuyAB, r101.ultimateBuyAB) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.forceYataSku, r101.forceYataSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bizIdentifier, r101.bizIdentifier) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackExtra, r101.trackExtra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.skuFrom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isGroupBuying;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isCustomBuying;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.scrollToInstallment;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.termCount;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.defaultSpecIDs;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.ultimateBuyAB;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.forceYataSku;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.bizIdentifier;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, Object> r128 = this.trackExtra;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "OpenSkuExtra(skuFrom=" + this.skuFrom + ", isGroupBuying=" + this.isGroupBuying + ", isCustomBuying=" + this.isCustomBuying + ", scrollToInstallment=" + this.scrollToInstallment + ", termCount=" + this.termCount + ", defaultSpecIDs=" + this.defaultSpecIDs + ", ultimateBuyAB=" + this.ultimateBuyAB + ", forceYataSku=" + this.forceYataSku + ", bizIdentifier=" + this.bizIdentifier + ", trackExtra=" + this.trackExtra + ")";
    }

    public final String a() {
        return this.bizIdentifier;
    }

    public final List<String> b() {
        return this.defaultSpecIDs;
    }

    public final Integer c() {
        return this.forceYataSku;
    }

    public final Boolean d() {
        return this.scrollToInstallment;
    }

    public final String e() {
        return this.skuFrom;
    }

    public final Integer f() {
        return this.termCount;
    }

    public final Map<String, Object> g() {
        return this.trackExtra;
    }

    public final Integer h() {
        return this.ultimateBuyAB;
    }

    public final Boolean i() {
        return this.isCustomBuying;
    }

    public final Boolean j() {
        return this.isGroupBuying;
    }

    public /* synthetic */ m(String r110, Boolean r111, Boolean r112, Boolean r113, Integer r114, List r210, int r211) {
        Integer r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        Boolean r102 = Boolean.FALSE;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Boolean r103 = Boolean.FALSE;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Boolean r104 = Boolean.FALSE;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r211 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r211 & 128) == 0) goto L29;
        r100 = 0;
    L29:
        this(r101, r102, r103, r104, r105, r106, null, r100, null, null);
        return;
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public m(String r100, Boolean r101, Boolean r102, Boolean r103, Integer r104, List<String> r105, Integer r106, Integer r107, String r108, Map<String, ? extends Object> r110) {
        this.skuFrom = r100;
        this.isGroupBuying = r101;
        this.isCustomBuying = r102;
        this.scrollToInstallment = r103;
        this.termCount = r104;
        this.defaultSpecIDs = r105;
        this.ultimateBuyAB = r106;
        this.forceYataSku = r107;
        this.bizIdentifier = r108;
        this.trackExtra = r110;
    }
}
