package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lhe3/r;", "", "", "hasLive", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "liveLink", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "shopDanceUrl", "f", "coverDanceUrl", "a", "shopJumpLive", "g", "coverJumpLive", "b", "Lhe3/b1;", "liveInteraction", "Lhe3/b1;", "d", "()Lhe3/b1;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L20;
        r r4 = (r) r3;
        if (Intrinsics.areEqual(this.hasLive, r4.hasLive) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveLink, r4.liveLink) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopDanceUrl, r4.shopDanceUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coverDanceUrl, r4.coverDanceUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopJumpLive, r4.shopJumpLive) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.coverJumpLive, r4.coverJumpLive) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveInteraction, r4.liveInteraction) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Boolean r0 = this.hasLive;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.liveLink;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.shopDanceUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.coverDanceUrl;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.shopJumpLive;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.coverJumpLive;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        b1 r19 = this.liveInteraction;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
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
