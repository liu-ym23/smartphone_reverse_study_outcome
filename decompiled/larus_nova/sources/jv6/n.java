package jv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Ljv6/n;", "", "", "playShareId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Ljv6/i;", "playInfo", "Ljv6/i;", "c", "()Ljv6/i;", "Ljv6/j;", "masterCoupon", "Ljv6/j;", "getMasterCoupon", "()Ljv6/j;", "guestCoupon", "b", "Ljv6/p;", "fromUserInfo", "Ljv6/p;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljv6/p;", "", "toUserInfo", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "status", "I", "getStatus", "()I", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("from_user")
    private final p fromUserInfo;

    @SerializedName("guest_coupon")
    private final j guestCoupon;

    @SerializedName("master_coupon")
    private final j masterCoupon;

    @SerializedName("play_info")
    private final i playInfo;

    @SerializedName("play_share_id")
    private final String playShareId;

    @SerializedName("status")
    private final int status;

    @SerializedName("to_user")
    private final List<p> toUserInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.playShareId, r101.playShareId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.playInfo, r101.playInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.masterCoupon, r101.masterCoupon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.guestCoupon, r101.guestCoupon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fromUserInfo, r101.fromUserInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.toUserInfo, r101.toUserInfo) == true) goto L27;
        return false;
    L27:
        if (this.status == r101.status) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.playShareId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        i r104 = this.playInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        j r107 = this.masterCoupon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        j r110 = this.guestCoupon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        p r113 = this.fromUserInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<p> r116 = this.toUserInfo;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((r115 + r101) * 31) + this.status;
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
        return "SharePlayInfo(playShareId=" + this.playShareId + ", playInfo=" + this.playInfo + ", masterCoupon=" + this.masterCoupon + ", guestCoupon=" + this.guestCoupon + ", fromUserInfo=" + this.fromUserInfo + ", toUserInfo=" + this.toUserInfo + ", status=" + this.status + ')';
    }

    public final p a() {
        return this.fromUserInfo;
    }

    public final j b() {
        return this.guestCoupon;
    }

    public final i c() {
        return this.playInfo;
    }

    public final String d() {
        return this.playShareId;
    }

    public final List<p> e() {
        return this.toUserInfo;
    }
}
