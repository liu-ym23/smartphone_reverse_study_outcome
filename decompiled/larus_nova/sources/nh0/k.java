package nh0;

import com.bytedance.android.live.base.model.user.User;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final User f519133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f519134e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L16;
        k r101 = (k) r100;
        if (this.f519130a == r101.f519130a) goto L8;
        return false;
    L8:
        if (this.f519131b == r101.f519131b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519132c, r101.f519132c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519133d, r101.f519133d) == true) goto L14;
        return false;
    L14:
        if (this.f519134e == r101.f519134e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = ((this.f519130a * 31) + this.f519131b) * 31;
        String r101 = this.f519132c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        User r105 = this.f519133d;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        int r106 = (r104 + r102) * 31;
        boolean r107 = this.f519134e;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        return r106 + r108;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "SeatClickExtraObject:{seatIndex=" + this.f519130a + ", clickType=" + this.f519131b + '}';
    }

    public k(int r100, int r101, String r102, User r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "thxToUserId");
        this.f519130a = r100;
        this.f519131b = r101;
        this.f519132c = r102;
        this.f519133d = r103;
        this.f519134e = r104;
    }
}
