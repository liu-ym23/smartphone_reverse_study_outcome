package g92;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.profit.privilege.model.danmu.b f480496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f480497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480498c;

    public c() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f480496a, r101.f480496a) == true) goto L8;
        return false;
    L8:
        if (this.f480497b == r101.f480497b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f480498c, r101.f480498c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.profit.privilege.model.danmu.b r100 = this.f480496a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f480497b) * 31;
        String r104 = this.f480498c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DanmakuTabMemory(tab=" + this.f480496a + ", position=" + this.f480497b + ", date=" + this.f480498c + ")";
    }

    public c(com.bytedance.android.live.profit.privilege.model.danmu.b r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        int r103 = -1;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = "";
    L12:
        Intrinsics.checkNotNullParameter(r101, "date");
        this.f480496a = r100;
        this.f480497b = r103;
        this.f480498c = r101;
        return;
    L8:
        r103 = 0;
        goto L10
    }
}
