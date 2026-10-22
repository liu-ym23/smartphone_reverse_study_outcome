package ve5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f554398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f554401d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f554398a == r101.f554398a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554399b, r101.f554399b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554400c, r101.f554400c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554401d, r101.f554401d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f554398a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f554399b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f554400c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f554401d;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingBotAuthInfo(botId=" + this.f554398a + ", actionUrl=" + this.f554399b + ", deviceCode=" + this.f554400c + ", deviceCodeExpireTime=" + this.f554401d + ')';
    }

    public n(long r100, String r101, String r102, Long r103) {
        this.f554398a = r100;
        this.f554399b = r101;
        this.f554400c = r102;
        this.f554401d = r103;
    }
}
