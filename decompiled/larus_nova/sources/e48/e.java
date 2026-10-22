package e48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f471007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f471008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f471009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f471010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f471011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f471012g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f471006a, r101.f471006a) == true) goto L12;
        return false;
    L12:
        if (this.f471007b == r101.f471007b) goto L15;
        return false;
    L15:
        if (this.f471008c == r101.f471008c) goto L18;
        return false;
    L18:
        if (this.f471009d == r101.f471009d) goto L21;
        return false;
    L21:
        if (this.f471010e == r101.f471010e) goto L24;
        return false;
    L24:
        if (this.f471011f == r101.f471011f) goto L27;
        return false;
    L27:
        if (this.f471012g == r101.f471012g) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final int hashCode() {
        int r100 = this.f471006a.hashCode() * 31;
        boolean r101 = this.f471007b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f471008c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f471009d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f471010e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f471011f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f471012g;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    }

    public final String toString() {
        return "AccountSecurityObservationState(uid=" + this.f471006a + ", inObservation=" + this.f471007b + ", remainingSeconds=" + this.f471008c + ", expireAtMs=" + this.f471009d + ", updatedAtMs=" + this.f471010e + ", chatMessageCountThreshold=" + this.f471011f + ", browsedChatMessageCount=" + this.f471012g + ')';
    }

    public e(String r100, boolean r101, long r102, long r103, long r104, long r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f471006a = r100;
        this.f471007b = r101;
        this.f471008c = r102;
        this.f471009d = r103;
        this.f471010e = r104;
        this.f471011f = r110;
        this.f471012g = r111;
    }
}
