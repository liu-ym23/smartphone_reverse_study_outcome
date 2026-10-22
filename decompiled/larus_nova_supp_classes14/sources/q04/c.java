package q04;

import com.bytedance.awemeopen.bizmodels.profile.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final i a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        i r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L12;
        int r8 = 0;
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L16;
        int r11 = 0;
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L20;
        int r14 = 0;
    L21:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L20:
        r14 = r13.hashCode();
        goto L21
    L16:
        r11 = r10.hashCode();
        goto L17
    L12:
        r8 = r7.hashCode();
        goto L13
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserVerifyInfo(publishRemindInfo=" + this.a + ", isRedV=" + this.b + ", weiboVerifyText=" + this.c + ", enterpriseVerifyText=" + this.d + ", userPersonalText=" + this.e + ", benefitInfo=" + this.f + ')';
    }

    public c(i r1, boolean r2, String r3, String r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
