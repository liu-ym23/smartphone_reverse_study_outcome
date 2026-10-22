package ti5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final int a;
    public boolean b;
    public final String c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final boolean g;

    public d() {
        this(false, false, null, false, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.g == true) goto L19;
        r2 = 1237;
    L19:
        return r7 + r2;
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TransferApplyData(permissionData=" + this.a + ", isSelected=" + this.b + ", description=" + this.c + ", showSelectedPermission=" + this.d + ", title=" + this.e + ", showDivider=" + this.f + ", savePermission=" + this.g + ')';
    }

    public d(boolean r5, boolean r6, String r7, boolean r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r5 = false;
    L6:
        if ((r9 & 4) == 0) goto L8;
        String r0 = "";
    L10:
        if ((r9 & 8) == 0) goto L13;
        r6 = false;
    L13:
        if ((r9 & 16) == 0) goto L16;
        r7 = "";
    L16:
        if ((r9 & 32) == 0) goto L19;
        r8 = false;
    L19:
        if ((r9 & 64) == 0) goto L21;
        boolean r10 = true;
    L22:
        Intrinsics.checkNotNullParameter(r0, "description");
        Intrinsics.checkNotNullParameter(r7, "title");
        this.a = 0;
        this.b = r5;
        this.c = r0;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r10;
        return;
    L21:
        r10 = false;
        goto L22
    L8:
        r0 = null;
        goto L10
    }
}
