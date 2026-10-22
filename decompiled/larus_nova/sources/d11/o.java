package d11;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f466344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f466347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f466348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466349f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L18;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f466344a, r101.f466344a) == true) goto L8;
        return false;
    L8:
        if (this.f466345b == r101.f466345b) goto L10;
        return false;
    L10:
        if (this.f466346c == r101.f466346c) goto L12;
        return false;
    L12:
        if (this.f466347d == r101.f466347d) goto L14;
        return false;
    L14:
        if (this.f466348e == r101.f466348e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f466349f, r101.f466349f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.f466344a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f466345b) * 31) + this.f466346c) * 31;
        long r104 = this.f466347d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f466348e;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.f466349f;
        if (r108 == null) goto L10;
        r101 = r108.hashCode();
    L10:
        return r107 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SwitchChannelInviteParams(inviteeAnchorIds=" + this.f466344a + ", matchType=" + this.f466345b + ", inviteType=" + this.f466346c + ", channelId=" + this.f466347d + ", roomId=" + this.f466348e + ", clientAttachedInfo=" + this.f466349f + ")";
    }

    public o(List r100, int r101, int r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "inviteeAnchorIds");
        Intrinsics.checkNotNullParameter("", "clientAttachedInfo");
        this.f466344a = r100;
        this.f466345b = r101;
        this.f466346c = r102;
        this.f466347d = r103;
        this.f466348e = r104;
        this.f466349f = "";
    }
}
