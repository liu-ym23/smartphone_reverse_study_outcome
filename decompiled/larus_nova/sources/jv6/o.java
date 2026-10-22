package jv6;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Ljv6/o;", "", "", "shareFromUid", "J", "f", "()J", "", "scene", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "anchorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "playShareId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "playId", "b", "shareCouponId", "e", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("anchor_id")
    private final long anchorId;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("play_share_id")
    private final String playShareId;

    @SerializedName("scene")
    private final Integer scene;

    @SerializedName("share_coupon_id")
    private final String shareCouponId;

    @SerializedName("share_from_uid")
    private final long shareFromUid;

    public o() {
        this.shareFromUid = 0;
        this.scene = 1;
        this.anchorId = 0;
        this.playShareId = null;
        this.playId = null;
        this.shareCouponId = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.shareFromUid == r101.shareFromUid) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L15;
        return false;
    L15:
        if (this.anchorId == r101.anchorId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.playShareId, r101.playShareId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shareCouponId, r101.shareCouponId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.shareFromUid;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Integer r102 = this.scene;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.anchorId;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.playShareId;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.playId;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.shareCouponId;
        if (r113 == null) goto L19;
        r103 = r113.hashCode();
    L19:
        return r112 + r103;
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareRefluxInfo(shareFromUid=" + this.shareFromUid + ", scene=" + this.scene + ", anchorId=" + this.anchorId + ", playShareId=" + this.playShareId + ", playId=" + this.playId + ", shareCouponId=" + this.shareCouponId + ')';
    }

    public final long a() {
        return this.anchorId;
    }

    public final String b() {
        return this.playId;
    }

    public final String c() {
        return this.playShareId;
    }

    public final Integer d() {
        return this.scene;
    }

    public final String e() {
        return this.shareCouponId;
    }

    public final long f() {
        return this.shareFromUid;
    }
}
