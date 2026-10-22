package xh0;

import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IncompatibleTag f563847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f563849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f563851e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f563847a, r101.f563847a) == true) goto L8;
        return false;
    L8:
        if (this.f563848b == r101.f563848b) goto L10;
        return false;
    L10:
        if (this.f563849c == r101.f563849c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f563850d, r101.f563850d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f563851e, r101.f563851e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        IncompatibleTag r100 = this.f563847a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f563848b) * 31;
        boolean r104 = this.f563849c;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f563850d;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f563851e;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PlayModeCheckResult(incompatibleTag=" + this.f563847a + ", ruleKey=" + this.f563848b + ", result=" + this.f563849c + ", reason=" + this.f563850d + ", toast=" + this.f563851e + ")";
    }

    public /* synthetic */ g(IncompatibleTag r100, int r101, boolean r102, String r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        int r103 = -1;
    L7:
        if ((r111 & 8) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r111 & 16) == 0) goto L13;
        String r105 = "";
    L14:
        this(r100, r103, r102, r104, r105);
        return;
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }

    public g(IncompatibleTag r100, int r101, boolean r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "incompatibleTag");
        Intrinsics.checkNotNullParameter(r103, "reason");
        Intrinsics.checkNotNullParameter(r104, "toast");
        this.f563847a = r100;
        this.f563848b = r101;
        this.f563849c = r102;
        this.f563850d = r103;
        this.f563851e = r104;
    }
}
