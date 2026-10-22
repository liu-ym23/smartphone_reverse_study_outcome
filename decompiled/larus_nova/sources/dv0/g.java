package dv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f470114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470115b;

    public final int hashCode() {
        long r100 = this.f470114a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f470115b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "Player(roomId=" + this.f470114a + ", score=" + this.f470115b + ")";
    }

    @Override // dv0.d
    public final long getRoomId() {
        return this.f470114a;
    }

    @Override // dv0.d
    public final String getScore() {
        return this.f470115b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.f470114a == r101.f470114a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f470115b, r101.f470115b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public g(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        this.f470114a = r100;
        this.f470115b = r101;
    }
}
