package dv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.profit.scoreboard.dto.a f470104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f470105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f470106c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f470104a, r101.f470104a) == true) goto L8;
        return false;
    L8:
        if (this.f470105b == r101.f470105b) goto L10;
        return false;
    L10:
        if (this.f470106c == r101.f470106c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.profit.scoreboard.dto.a r100 = this.f470104a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f470105b) * 31;
        long r103 = this.f470106c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "Config(counterConfig=" + this.f470104a + ", linkUserCount=" + this.f470105b + ", otherRoomId=" + this.f470106c + ")";
    }

    public a(com.bytedance.android.live.profit.scoreboard.dto.a r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "counterConfig");
        this.f470104a = r100;
        this.f470105b = r101;
        this.f470106c = r102;
    }
}
