package wf6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f559478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559479b;

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f559478a == r101.f559478a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f559479b, r101.f559479b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f559478a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f559479b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "CancelApplyParams(needShowSuccessToast=" + this.f559478a + ", fromSource=" + this.f559479b + ")";
    }

    public /* synthetic */ a(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = "";
    L9:
        this(r102, r100);
        return;
    L5:
        r102 = false;
        goto L7
    }

    public a(boolean r100, String r101) {
        this.f559478a = r100;
        this.f559479b = r101;
    }
}
