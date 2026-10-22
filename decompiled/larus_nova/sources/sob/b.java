package sob;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f542807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f542808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f542809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f542810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f542811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f542812g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f542806a, r101.f542806a) == true) goto L12;
        return false;
    L12:
        if (this.f542807b == r101.f542807b) goto L15;
        return false;
    L15:
        if (this.f542808c == r101.f542808c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f542809d, r101.f542809d) == true) goto L21;
        return false;
    L21:
        if (this.f542810e == r101.f542810e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f542811f, r101.f542811f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f542812g, r101.f542812g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f542806a.hashCode() * 31;
        int r101 = 1231;
        if (this.f542807b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f542808c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.f542809d;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r104 + r107) * 31) + this.f542810e) * 31;
        String r109 = this.f542811f;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f542812g;
        if (r112 == null) goto L23;
        r106 = r112.hashCode();
    L23:
        return r111 + r106;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrUserInfo(eventId=" + this.f542806a + ", isNameSearched=" + this.f542807b + ", isAccept=" + this.f542808c + ", resultCat=" + this.f542809d + ", resultCatRank=" + this.f542810e + ", asrUserId=" + this.f542811f + ", clientUserId=" + this.f542812g + ')';
    }

    public b(boolean r100, boolean r101, String r102, int r103, String r104, String r105) {
        String r106 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r106, com.heytap.mcssdk.constant.b.f276361k);
        this.f542806a = r106;
        this.f542807b = r100;
        this.f542808c = r101;
        this.f542809d = r102;
        this.f542810e = r103;
        this.f542811f = r104;
        this.f542812g = r105;
    }
}
