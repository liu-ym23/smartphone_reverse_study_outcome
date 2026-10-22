package nv6;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lnv6/t;", "", "", "aggCardId", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "isAggCard", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "showingCardId", "getShowingCardId", "", "mpId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mpName", "d", "serverStartTime", "J", "f", "()J", "serverEndTime", "e", "lifeShareId", "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("agg_card_id")
    private final Long aggCardId;

    @SerializedName("is_agg_card")
    private final Boolean isAggCard;

    @SerializedName("life_share_id")
    private final String lifeShareId;

    @SerializedName(BdpAppEventConstant.PARAMS_MP_ID)
    private final String mpId;

    @SerializedName(BdpAppEventConstant.PARAMS_MP_NAME)
    private final String mpName;

    @SerializedName("server_end_time")
    private final long serverEndTime;

    @SerializedName("server_start_time")
    private final long serverStartTime;

    @SerializedName("showing_card_id")
    private final Long showingCardId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.aggCardId, r101.aggCardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAggCard, r101.isAggCard) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showingCardId, r101.showingCardId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mpId, r101.mpId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mpName, r101.mpName) == true) goto L24;
        return false;
    L24:
        if (this.serverStartTime == r101.serverStartTime) goto L27;
        return false;
    L27:
        if (this.serverEndTime == r101.serverEndTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lifeShareId, r101.lifeShareId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.aggCardId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isAggCard;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.showingCardId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mpId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mpName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.serverStartTime;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.serverEndTime;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        String r120 = this.lifeShareId;
        if (r120 == null) goto L27;
        r101 = r120.hashCode();
    L27:
        return r119 + r101;
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
        return "GroupPurchaseExtra(aggCardId=" + this.aggCardId + ", isAggCard=" + this.isAggCard + ", showingCardId=" + this.showingCardId + ", mpId=" + this.mpId + ", mpName=" + this.mpName + ", serverStartTime=" + this.serverStartTime + ", serverEndTime=" + this.serverEndTime + ", lifeShareId=" + this.lifeShareId + ')';
    }

    public t() {
        this.aggCardId = null;
        this.isAggCard = null;
        this.showingCardId = null;
        this.mpId = null;
        this.mpName = null;
        this.serverStartTime = 0;
        this.serverEndTime = 0;
        this.lifeShareId = null;
    }

    public final Long a() {
        return this.aggCardId;
    }

    public final String b() {
        return this.lifeShareId;
    }

    public final String c() {
        return this.mpId;
    }

    public final String d() {
        return this.mpName;
    }

    public final long e() {
        return this.serverEndTime;
    }

    public final long f() {
        return this.serverStartTime;
    }
}
