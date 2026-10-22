package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final Long g;
    public final Long h;
    public final g0 i;
    public final OfficeSpaceTab j;
    public final OfficeUploadStatus k;
    public final Integer l;
    public final String m;
    public final OfficeUploadTaskSource n;
    public final long o;
    public final long p;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r9 = (h0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L56;
        return false;
    L56:
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
        if (this.d == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((r4 + r5) * 31) + this.e.hashCode()) * 31;
        String r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((((((r12 + r14) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        Integer r16 = this.l;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.m;
        if (r19 == null) goto L30;
        r2 = r19.hashCode();
    L30:
        int r20 = (((r18 + r2) * 31) + this.n.hashCode()) * 31;
        long r21 = this.o;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        long r23 = this.p;
        return r22 + ((int) (r23 ^ (r23 >>> 32)));
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeUploadTask(localId=" + this.a + ", driveKey=" + this.b + ", filePointer=" + this.c + ", isFileUseUri=" + this.d + ", displayName=" + this.e + ", mimeType=" + this.f + ", totalBytes=" + this.g + ", uploadedBytes=" + this.h + ", target=" + this.i + ", refreshTab=" + this.j + ", status=" + this.k + ", errorCode=" + this.l + ", errorMessage=" + this.m + ", source=" + this.n + ", createdAt=" + this.o + ", updatedAt=" + this.p + ')';
    }

    public /* synthetic */ h0(String r23, String r24, String r25, boolean r26, String r27, String r28, Long r29, Long r30, g0 r31, OfficeUploadStatus r32, Integer r33, OfficeUploadTaskSource r34, int r35) {
        if ((r35 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r35 & 64) == 0) goto L9;
        Long r10 = null;
    L11:
        if ((r35 & 128) == 0) goto L13;
        Long r11 = null;
    L15:
        if ((r35 & 512) == 0) goto L17;
        OfficeSpaceTab r13 = OfficeSpaceTab.MINE;
    L19:
        if ((r35 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L21;
        OfficeUploadStatus r14 = OfficeUploadStatus.UNSTARTED;
    L23:
        if ((r35 & DocUserPermission.USER_PREVIEW) == 0) goto L25;
        Integer r15 = null;
    L27:
        if ((r35 & 8192) == 0) goto L29;
        OfficeUploadTaskSource r17 = OfficeUploadTaskSource.LOCAL;
    L31:
        if ((r35 & 16384) == 0) goto L33;
        long r18 = System.currentTimeMillis();
    L35:
        if ((r35 & 32768) == 0) goto L37;
        long r20 = System.currentTimeMillis();
    L38:
        this(r23, r5, r25, r26, r27, r28, r10, r11, r31, r13, r14, r15, null, r17, r18, r20);
        return;
    L37:
        r20 = 0;
        goto L38
    L33:
        r18 = 0;
        goto L35
    L29:
        r17 = r34;
        goto L31
    L25:
        r15 = r33;
        goto L27
    L21:
        r14 = r32;
        goto L23
    L17:
        r13 = null;
        goto L19
    L13:
        r11 = r30;
        goto L15
    L9:
        r10 = r29;
        goto L11
    L5:
        r5 = r24;
        goto L7
    }

    public h0(String r10, String r11, String r12, boolean r13, String r14, String r15, Long r16, Long r17, g0 r18, OfficeSpaceTab r19, OfficeUploadStatus r20, Integer r21, String r22, OfficeUploadTaskSource r23, long r24, long r26) {
        Intrinsics.checkNotNullParameter(r10, "localId");
        Intrinsics.checkNotNullParameter(r12, "filePointer");
        Intrinsics.checkNotNullParameter(r14, "displayName");
        Intrinsics.checkNotNullParameter(r18, "target");
        Intrinsics.checkNotNullParameter(r19, "refreshTab");
        Intrinsics.checkNotNullParameter(r20, "status");
        Intrinsics.checkNotNullParameter(r23, "source");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r26;
    }

    public static h0 a(h0 r17, String r18, String r19, String r20, boolean r21, String r22, String r23, Long r24, Long r25, g0 r26, OfficeSpaceTab r27, OfficeUploadStatus r28, Integer r29, String r30, OfficeUploadTaskSource r31, long r32, long r34, int r36) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = r17.a;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r17.b;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = r17.c;
    L15:
        if ((r36 & 8) == 0) goto L17;
        boolean r5 = r17.d;
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r6 = r17.e;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r7 = r17.f;
    L27:
        if ((r36 & 64) == 0) goto L29;
        Long r8 = r17.g;
    L31:
        if ((r36 & 128) == 0) goto L33;
        Long r9 = r17.h;
    L35:
        if ((r36 & 256) == 0) goto L37;
        g0 r10 = r17.i;
    L39:
        if ((r36 & 512) == 0) goto L41;
        OfficeSpaceTab r11 = r17.j;
    L43:
        if ((r36 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        OfficeUploadStatus r12 = r17.k;
    L47:
        if ((r36 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        Integer r13 = r17.l;
    L51:
        if ((r36 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        String r14 = r17.m;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        OfficeUploadTaskSource r15 = r17.n;
    L58:
        String r33 = r14;
        Integer r210 = r13;
        if ((r36 & 16384) == 0) goto L61;
        long r16 = r17.o;
    L62:
        long r35 = r16;
        if ((r36 & 32768) == 0) goto L65;
        long r110 = r17.p;
    L66:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r2, "localId");
        Intrinsics.checkNotNullParameter(r4, "filePointer");
        Intrinsics.checkNotNullParameter(r6, "displayName");
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r11, "refreshTab");
        Intrinsics.checkNotNullParameter(r12, "status");
        Intrinsics.checkNotNullParameter(r15, "source");
        return new h0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r210, r33, r15, r35, r110);
    L65:
        r110 = r34;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
