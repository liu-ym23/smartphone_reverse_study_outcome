package j0c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f496845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f496846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f496847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f496848d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f496845a, r101.f496845a) == true) goto L12;
        return false;
    L12:
        if (this.f496846b == r101.f496846b) goto L15;
        return false;
    L15:
        if (this.f496847c == r101.f496847c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f496848d, r101.f496848d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f496845a.hashCode() * 31;
        if (this.f496846b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f496847c) * 31;
        String r103 = this.f496848d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskResult(taskName=" + this.f496845a + ", isSuccess=" + this.f496846b + ", errorCode=" + this.f496847c + ", errorMessage=" + this.f496848d + ')';
    }

    public c(b r100, boolean r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        this.f496845a = r100;
        this.f496846b = r101;
        this.f496847c = r102;
        this.f496848d = r103;
    }

    public /* synthetic */ c(b r100, boolean r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = "";
    L8:
        this(r100, r101, 0, r102);
    }
}
