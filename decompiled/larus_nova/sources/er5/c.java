package er5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473599b;

    public c() {
        this(null, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f473598a, r101.f473598a) == true) goto L12;
        return false;
    L12:
        if (this.f473599b == r101.f473599b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f473598a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f473599b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NewBitableSelectResult(workspaceToken=" + this.f473598a + ", needNewWorkspace=" + this.f473599b + ')';
    }

    public c(String r100, boolean r101) {
        this.f473598a = r100;
        this.f473599b = r101;
    }
}
