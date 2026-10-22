package uj5;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final String a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final boolean l;
    public final boolean m;
    public final String n;

    public b() {
        this(null, 0, false, null, null, null, null, false, null, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((((((((((r5 + r6) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        if (this.l == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.m == true) goto L23;
        r2 = 1237;
    L23:
        return ((r9 + r2) * 31) + this.n.hashCode();
    L17:
        r8 = 1237;
        goto L18
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
        return "PermissionSettingParams(token=" + this.a + ", objType=" + this.b + ", isSpaceV2=" + this.c + ", isWiki=" + this.d + ", creatorTenantId=" + this.e + ", isAtVc=" + this.f + ", subFileType=" + this.g + ", module=" + this.h + ", subModule=" + this.i + ", usePermissionStr=" + this.j + ", publicPermissionStr=" + this.k + ", isOwner=" + this.l + ", hasLeader=" + this.m + ", url=" + this.n + ')';
    }

    public /* synthetic */ b(String r19, int r20, boolean r21, String r22, String r23, String r24, String r25, boolean r26, String r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r28 & 2) == 0) goto L9;
        int r5 = -1;
    L11:
        if ((r28 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r28 & 16) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r28 & 64) == 0) goto L21;
        String r1 = "";
    L23:
        if ((r28 & 128) == 0) goto L25;
        String r11 = "";
    L27:
        if ((r28 & 256) == 0) goto L29;
        String r12 = "";
    L31:
        if ((r28 & 512) == 0) goto L33;
        String r13 = "";
    L35:
        if ((r28 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L37;
        String r14 = "";
    L39:
        if ((r28 & DocUserPermission.USER_PREVIEW) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r28 & DocUserPermission.USER_PERCEIVE) == 0) goto L45;
        boolean r16 = true;
    L47:
        if ((r28 & 8192) == 0) goto L49;
        String r17 = "";
    L50:
        this(r4, r5, r6, false, r8, false, r1, r11, r12, r13, r14, r15, r16, r17);
        return;
    L49:
        r17 = r27;
        goto L50
    L45:
        r16 = false;
        goto L47
    L41:
        r15 = r26;
        goto L43
    L37:
        r14 = null;
        goto L39
    L33:
        r13 = r25;
        goto L35
    L29:
        r12 = r24;
        goto L31
    L25:
        r11 = r23;
        goto L27
    L21:
        r1 = null;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public b(String r2, int r3, boolean r4, boolean r5, String r6, boolean r7, String r8, String r9, String r10, String r11, String r12, boolean r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r8, "subFileType");
        Intrinsics.checkNotNullParameter(r9, "module");
        Intrinsics.checkNotNullParameter(r10, "subModule");
        Intrinsics.checkNotNullParameter(r11, "usePermissionStr");
        Intrinsics.checkNotNullParameter(r12, "publicPermissionStr");
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_URL);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}
