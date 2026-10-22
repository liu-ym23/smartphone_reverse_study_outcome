package n62;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f518150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f518151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f518152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e f518153d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (this.f518150a == r101.f518150a) goto L8;
        return false;
    L8:
        if (this.f518151b == r101.f518151b) goto L10;
        return false;
    L10:
        if (this.f518152c == r101.f518152c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f518153d, r101.f518153d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        boolean r100 = this.f518150a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f518151b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        boolean r105 = this.f518152c;
        if (r105 == true) goto L9;
        r101 = r105;
    L9:
        int r106 = (r104 + r101) * 31;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r107 = this.f518153d;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L14:
        return r106 + r108;
    L12:
        r108 = 0;
        goto L14
    }

    public final String toString() {
        return "CreateChannelConfig(autoInvite=" + this.f518150a + ", inviteDelay=" + this.f518151b + ", toast=" + this.f518152c + ", logInfo=" + this.f518153d + ")";
    }

    public i(boolean r100, long r101, boolean r102, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r103) {
        this.f518150a = r100;
        this.f518151b = r101;
        this.f518152c = r102;
        this.f518153d = r103;
    }
}
