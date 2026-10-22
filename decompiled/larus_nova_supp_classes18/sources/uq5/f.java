package uq5;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final FragmentActivity a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final ar5.a h;
    public final boolean i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        int r11 = 1231;
        if (this.f == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (r10 + r12) * 31;
        if (this.g == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        ar5.a r16 = this.h;
        if (r16 == null) goto L26;
        r2 = r16.hashCode();
    L26:
        int r17 = (r15 + r2) * 31;
        if (this.i == true) goto L31;
        r11 = 1237;
    L31:
        return r17 + r11;
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "WikiTreePanelDialogShowParams(context=" + this.a + ", title=" + this.b + ", spaceId=" + this.c + ", wikiToken=" + this.d + ", uniqueUiId=" + this.e + ", needOnBoarding=" + this.f + ", isNeedExpandWindow=" + this.g + ", pathResolveContext=" + this.h + ", reusePathResolveTree=" + this.i + ')';
    }

    public final FragmentActivity getContext() {
        return this.a;
    }

    public f(FragmentActivity r2, String r3, String r4, String r5, String r6, boolean r7, ar5.a r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
