package tc2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f545391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f545392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f545393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f545394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f545395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f545396g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L20;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f545390a, r101.f545390a) == true) goto L8;
        return false;
    L8:
        if (this.f545391b == r101.f545391b) goto L10;
        return false;
    L10:
        if (this.f545392c == r101.f545392c) goto L12;
        return false;
    L12:
        if (this.f545393d == r101.f545393d) goto L14;
        return false;
    L14:
        if (this.f545394e == r101.f545394e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f545395f, r101.f545395f) == true) goto L18;
        return false;
    L18:
        if (this.f545396g == r101.f545396g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f545390a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f545391b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f545392c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f545393d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f545394e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f545395f;
        if (r111 == null) goto L9;
        r101 = r111.hashCode();
    L9:
        int r112 = (r110 + r101) * 31;
        boolean r113 = this.f545396g;
        ?? r114 = r113;
        if (r113 == false) goto L13;
        r114 = 1;
    L13:
        return r112 + r114;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SelfSendInfo(sendType=" + this.f545390a + ", sendTime=" + this.f545391b + ", receiveTime=" + this.f545392c + ", startSendTime=" + this.f545393d + ", apiSuccessTime=" + this.f545394e + ", messageType=" + this.f545395f + ", isSelfClickSend=" + this.f545396g + ")";
    }

    public /* synthetic */ j(String r110, long r111, long r112, long r210, long r211, String r212, int r213) {
        if ((r213 & 8) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r213 & 16) == 0) goto L9;
        long r113 = 0;
    L11:
        if ((r213 & 32) == 0) goto L13;
        String r114 = "--default--";
    L14:
        this(r110, r111, r112, r100, r113, r114, false);
        return;
    L13:
        r114 = r212;
        goto L14
    L9:
        r113 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public j(String r100, long r101, long r102, long r103, long r104, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        Intrinsics.checkNotNullParameter(r110, "messageType");
        this.f545390a = r100;
        this.f545391b = r101;
        this.f545392c = r102;
        this.f545393d = r103;
        this.f545394e = r104;
        this.f545395f = r110;
        this.f545396g = r111;
    }
}
