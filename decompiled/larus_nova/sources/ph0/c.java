package ph0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f529235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f529236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f529237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f529238d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f529235a, r101.f529235a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f529236b, r101.f529236b) == true) goto L10;
        return false;
    L10:
        if (this.f529237c == r101.f529237c) goto L12;
        return false;
    L12:
        if (this.f529238d == r101.f529238d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.f529235a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f529236b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((r103 + r101) * 31) + this.f529237c) * 31;
        boolean r106 = this.f529238d;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RtsSilenceEvent(uid=" + this.f529235a + ", interactId=" + this.f529236b + ", silenceStatus=" + this.f529237c + ", forceResumeAudio=" + this.f529238d + ")";
    }

    public c(String r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "interactId");
        this.f529235a = r100;
        this.f529236b = r101;
        this.f529237c = r102;
        this.f529238d = r103;
    }
}
