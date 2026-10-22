package he3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lhe3/r;", "", "", "hasLive", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "liveLink", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "shopDanceUrl", "f", "coverDanceUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "shopJumpLive", ce.f26391f, "coverJumpLive", "b", "Lhe3/b1;", "liveInteraction", "Lhe3/b1;", "d", "()Lhe3/b1;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("cover_dance_url")
    private final String coverDanceUrl;

    @SerializedName("cover_jump_live")
    private final Boolean coverJumpLive;

    @SerializedName("has_live")
    private final Boolean hasLive;

    @SerializedName("live_interaction")
    private final b1 liveInteraction;

    @SerializedName("live_link")
    private final String liveLink;

    @SerializedName("shop_dance_url")
    private final String shopDanceUrl;

    @SerializedName("shop_jump_live")
    private final Boolean shopJumpLive;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L20;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.hasLive, r101.hasLive) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveLink, r101.liveLink) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopDanceUrl, r101.shopDanceUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coverDanceUrl, r101.coverDanceUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopJumpLive, r101.shopJumpLive) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.coverJumpLive, r101.coverJumpLive) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveInteraction, r101.liveInteraction) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.hasLive;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveLink;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopDanceUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.coverDanceUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.shopJumpLive;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.coverJumpLive;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        b1 r119 = this.liveInteraction;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "DeepFeedLiveExtendInfo(hasLive=" + this.hasLive + ", liveLink=" + this.liveLink + ", shopDanceUrl=" + this.shopDanceUrl + ", coverDanceUrl=" + this.coverDanceUrl + ", shopJumpLive=" + this.shopJumpLive + ", coverJumpLive=" + this.coverJumpLive + ", liveInteraction=" + this.liveInteraction + ")";
    }

    public r() {
        this.hasLive = null;
        this.liveLink = null;
        this.shopDanceUrl = null;
        this.coverDanceUrl = null;
        this.shopJumpLive = null;
        this.coverJumpLive = null;
        this.liveInteraction = null;
    }

    public final String a() {
        return this.coverDanceUrl;
    }

    public final Boolean b() {
        return this.coverJumpLive;
    }

    public final Boolean c() {
        return this.hasLive;
    }

    public final b1 d() {
        return this.liveInteraction;
    }

    public final String e() {
        return this.liveLink;
    }

    public final String f() {
        return this.shopDanceUrl;
    }

    public final Boolean g() {
        return this.shopJumpLive;
    }
}
