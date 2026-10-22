package ia2;

import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ability f488847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f488848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f488849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f488850d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f488847a, r101.f488847a) == true) goto L8;
        return false;
    L8:
        if (this.f488848b == r101.f488848b) goto L10;
        return false;
    L10:
        if (this.f488849c == r101.f488849c) goto L12;
        return false;
    L12:
        if (this.f488850d == r101.f488850d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        Ability r100 = this.f488847a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f488848b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f488849c;
        ?? r108 = r107;
        if (r107 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f488850d;
        if (r110 == true) goto L17;
        r104 = r110;
    L17:
        return r109 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ItemData(ability=" + this.f488847a + ", isLoading=" + this.f488848b + ", shouldReportShowLog=" + this.f488849c + ", isLocateBottom=" + this.f488850d + ")";
    }

    public b(Ability r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f488847a = r100;
        this.f488848b = false;
        this.f488849c = true;
        this.f488850d = r101;
    }
}
