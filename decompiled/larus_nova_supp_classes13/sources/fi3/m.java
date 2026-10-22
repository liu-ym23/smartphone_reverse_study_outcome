package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lfi3/m;", "", "", "skuFrom", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "isGroupBuying", "Ljava/lang/Boolean;", "j", "()Ljava/lang/Boolean;", "isCustomBuying", "i", "scrollToInstallment", "d", "", "termCount", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "", "defaultSpecIDs", "Ljava/util/List;", "b", "()Ljava/util/List;", "ultimateBuyAB", "h", "forceYataSku", "c", "bizIdentifier", "a", "", "trackExtra", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("biz_identifier")
    private final String bizIdentifier;

    @SerializedName("default_spec_ids")
    private final List<String> defaultSpecIDs;

    @SerializedName("force_yata_sku")
    private final Integer forceYataSku;

    @SerializedName("is_custombuying")
    private final Boolean isCustomBuying;

    @SerializedName("is_groupbuying")
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L26;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.skuFrom, r4.skuFrom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isGroupBuying, r4.isGroupBuying) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isCustomBuying, r4.isCustomBuying) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scrollToInstallment, r4.scrollToInstallment) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.termCount, r4.termCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultSpecIDs, r4.defaultSpecIDs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ultimateBuyAB, r4.ultimateBuyAB) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.forceYataSku, r4.forceYataSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bizIdentifier, r4.bizIdentifier) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackExtra, r4.trackExtra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r0 = this.skuFrom;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isGroupBuying;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isCustomBuying;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.scrollToInstallment;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.termCount;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.defaultSpecIDs;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.ultimateBuyAB;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.forceYataSku;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.bizIdentifier;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, Object> r28 = this.trackExtra;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
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

    public /* synthetic */ m(String r15, Boolean r16, Boolean r17, Boolean r18, Integer r19, List r20, int r21) {
        Integer r2 = null;
        if ((r21 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        Boolean r5 = Boolean.FALSE;
    L11:
        if ((r21 & 4) == 0) goto L13;
        Boolean r6 = Boolean.FALSE;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Boolean r7 = Boolean.FALSE;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r21 & 32) == 0) goto L25;
        List r9 = null;
    L27:
        if ((r21 & 128) == 0) goto L29;
        r2 = 0;
    L29:
        this(r4, r5, r6, r7, r8, r9, null, r2, null, null);
        return;
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public m(String r1, Boolean r2, Boolean r3, Boolean r4, Integer r5, List<String> r6, Integer r7, Integer r8, String r9, Map<String, ? extends Object> r10) {
        this.skuFrom = r1;
        this.isGroupBuying = r2;
        this.isCustomBuying = r3;
        this.scrollToInstallment = r4;
        this.termCount = r5;
        this.defaultSpecIDs = r6;
        this.ultimateBuyAB = r7;
        this.forceYataSku = r8;
        this.bizIdentifier = r9;
        this.trackExtra = r10;
    }
}
