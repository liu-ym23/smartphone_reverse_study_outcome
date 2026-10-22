package uq5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final WikiInfo g;
    public final boolean h;
    public final String i;
    public final String j;
    public final String k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.e == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        WikiInfo r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.h == true) goto L30;
        r2 = 1237;
    L30:
        int r19 = (r18 + r2) * 31;
        String r20 = this.i;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        String r23 = this.j;
        if (r23 == null) goto L39;
        r5 = r23.hashCode();
    L39:
        return ((r22 + r5) * 31) + this.k.hashCode();
    L33:
        r21 = r20.hashCode();
        goto L34
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "NavigationParams(targetToken=" + this.a + ", popLast=" + this.b + ", targetSpace=" + this.c + ", targetSpaceName=" + this.d + ", dismissNow=" + this.e + ", title=" + this.f + ", wikiInfo=" + this.g + ", forceLoad=" + this.h + ", uniqueUiId=" + this.i + ", from=" + this.j + ", visibleSpaceId=" + this.k + ')';
    }

    public a(String r5, boolean r6, String r7, String r8, String r9, WikiInfo r10, boolean r11, String r12, String r13, String r14, int r15) {
        boolean r1 = true;
        if ((r15 & 2) == 0) goto L6;
        r6 = true;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r7 = null;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r8 = null;
    L12:
        if ((r15 & 16) != 0) goto L16;
        r1 = false;
    L16:
        if ((r15 & 32) == 0) goto L19;
        r9 = null;
    L19:
        if ((r15 & 64) == 0) goto L22;
        r10 = null;
    L22:
        if ((r15 & 128) == 0) goto L25;
        r11 = false;
    L25:
        if ((r15 & 256) == 0) goto L28;
        r12 = null;
    L28:
        if ((r15 & 512) == 0) goto L31;
        r13 = null;
    L31:
        if ((r15 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L33;
        r14 = "";
    L33:
        Intrinsics.checkNotNullParameter(r5, "targetToken");
        Intrinsics.checkNotNullParameter(r14, "visibleSpaceId");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r1;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
    }
}
