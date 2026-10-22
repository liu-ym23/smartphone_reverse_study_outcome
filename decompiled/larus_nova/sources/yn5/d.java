package yn5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f568555b;

    public d() {
        this(false, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f568554a, r101.f568554a) == true) goto L12;
        return false;
    L12:
        if (this.f568555b == r101.f568555b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f568554a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f568555b == false) goto L9;
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
        return "TemplateBitableSelectResult(workspaceToken=" + this.f568554a + ", needNewWorkspace=" + this.f568555b + ')';
    }

    public /* synthetic */ d(boolean r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = false;
    L5:
        this(null, r100);
    }

    public d(String r100, boolean r101) {
        this.f568554a = r100;
        this.f568555b = r101;
    }
}
