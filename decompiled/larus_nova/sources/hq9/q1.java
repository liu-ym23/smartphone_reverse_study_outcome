package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486750d;

    public q1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q1) == true) goto L8;
        return false;
    L8:
        q1 r101 = (q1) r100;
        if (this.f486747a == r101.f486747a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486748b, r101.f486748b) == true) goto L15;
        return false;
    L15:
        if (this.f486749c == r101.f486749c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486750d, r101.f486750d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486747a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f486748b.hashCode()) * 31;
        if (this.f486749c == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f486750d.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "HttpEnvConfig(boeEnable=" + this.f486747a + ", boeEnv=" + this.f486748b + ", ppeEnable=" + this.f486749c + ", ppeEnv=" + this.f486750d + ')';
    }

    public /* synthetic */ q1(int r100) {
        this(false, "", false, "");
    }

    public q1(boolean r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "boeEnv");
        Intrinsics.checkNotNullParameter(r103, "ppeEnv");
        this.f486747a = r100;
        this.f486748b = r101;
        this.f486749c = r102;
        this.f486750d = r103;
    }
}
