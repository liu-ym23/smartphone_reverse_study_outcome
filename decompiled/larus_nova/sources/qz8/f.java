package qz8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/larus/commercecredit/impl/entity/CreditInfo;", "", "totalCreditNum", "", "iconUrl", "", "darkModeIconUrl", "creditText", "creditDescText", "subscribeCredit", "Lcom/larus/commercecredit/impl/entity/SubscribeCredit;", "rechargeCredit", "Lcom/larus/commercecredit/impl/entity/RechargeCredit;", "bonusCredit", "Lcom/larus/commercecredit/impl/entity/BonusCredit;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/commercecredit/impl/entity/SubscribeCredit;Lcom/larus/commercecredit/impl/entity/RechargeCredit;Lcom/larus/commercecredit/impl/entity/BonusCredit;)V", "getTotalCreditNum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIconUrl", "()Ljava/lang/String;", "getDarkModeIconUrl", "getCreditText", "getCreditDescText", "getSubscribeCredit", "()Lcom/larus/commercecredit/impl/entity/SubscribeCredit;", "getRechargeCredit", "()Lcom/larus/commercecredit/impl/entity/RechargeCredit;", "getBonusCredit", "()Lcom/larus/commercecredit/impl/entity/BonusCredit;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/commercecredit/impl/entity/SubscribeCredit;Lcom/larus/commercecredit/impl/entity/RechargeCredit;Lcom/larus/commercecredit/impl/entity/BonusCredit;)Lcom/larus/commercecredit/impl/entity/CreditInfo;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("bonus_credit")
    private final c bonusCredit;

    @SerializedName("credit_desc_text")
    private final String creditDescText;

    @SerializedName("credit_text")
    private final String creditText;

    @SerializedName("dark_mode_icon_url")
    private final String darkModeIconUrl;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("recharge_credit")
    private final n rechargeCredit;

    @SerializedName("subscribe_credit")
    private final p subscribeCredit;

    @SerializedName("total_credit_num")
    private final Long totalCreditNum;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.totalCreditNum, r101.totalCreditNum) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkModeIconUrl, r101.darkModeIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creditText, r101.creditText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creditDescText, r101.creditDescText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subscribeCredit, r101.subscribeCredit) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rechargeCredit, r101.rechargeCredit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bonusCredit, r101.bonusCredit) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.totalCreditNum;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.darkModeIconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.creditText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.creditDescText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        p r116 = this.subscribeCredit;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        n r119 = this.rechargeCredit;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        c r122 = this.bonusCredit;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "CreditInfo(totalCreditNum=" + this.totalCreditNum + ", iconUrl=" + this.iconUrl + ", darkModeIconUrl=" + this.darkModeIconUrl + ", creditText=" + this.creditText + ", creditDescText=" + this.creditDescText + ", subscribeCredit=" + this.subscribeCredit + ", rechargeCredit=" + this.rechargeCredit + ", bonusCredit=" + this.bonusCredit + ')';
    }

    public final String b() {
        return this.creditDescText;
    }

    public final String c() {
        return this.creditText;
    }

    public final String d() {
        return this.darkModeIconUrl;
    }

    public final String e() {
        return this.iconUrl;
    }

    public final Long f() {
        return this.totalCreditNum;
    }

    public /* synthetic */ f(int r110) {
        this(null, null, null, null, null, null, null, null);
    }

    public static f a(f r100, Long r110) {
        return new f(r110, r100.iconUrl, r100.darkModeIconUrl, r100.creditText, r100.creditDescText, r100.subscribeCredit, r100.rechargeCredit, r100.bonusCredit);
    }

    public f(Long r100, String r101, String r102, String r103, String r104, p r105, n r106, c r107) {
        this.totalCreditNum = r100;
        this.iconUrl = r101;
        this.darkModeIconUrl = r102;
        this.creditText = r103;
        this.creditDescText = r104;
        this.subscribeCredit = r105;
        this.rechargeCredit = r106;
        this.bonusCredit = r107;
    }
}
