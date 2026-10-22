package d11;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f466338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f466339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f466340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f466341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f466342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466343f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L18;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f466338a, r101.f466338a) == true) goto L8;
        return false;
    L8:
        if (this.f466339b == r101.f466339b) goto L10;
        return false;
    L10:
        if (this.f466340c == r101.f466340c) goto L12;
        return false;
    L12:
        if (this.f466341d == r101.f466341d) goto L14;
        return false;
    L14:
        if (this.f466342e == r101.f466342e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f466343f, r101.f466343f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.f466338a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f466339b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f466340c;
        int r106 = (((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f466341d) * 31) + this.f466342e) * 31;
        String r107 = this.f466343f;
        if (r107 == null) goto L10;
        r101 = r107.hashCode();
    L10:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SwitchChannelCancelParams(inviteeAnchorIds=" + this.f466338a + ", roomId=" + this.f466339b + ", channelId=" + this.f466340c + ", matchType=" + this.f466341d + ", inviteType=" + this.f466342e + ", reqSrc=" + this.f466343f + ")";
    }

    public n(List<String> r100, long r101, long r102, int r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "inviteeAnchorIds");
        Intrinsics.checkNotNullParameter(r105, "reqSrc");
        this.f466338a = r100;
        this.f466339b = r101;
        this.f466340c = r102;
        this.f466341d = r103;
        this.f466342e = r104;
        this.f466343f = r105;
    }
}
