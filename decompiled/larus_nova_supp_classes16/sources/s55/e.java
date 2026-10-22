package s55;

import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final String a;
    public final PermissionOperation b;
    public final int c;
    public final String d;
    public final String e;
    public final Long f;
    public final sbb.e g;
    public final FileBizDomain h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final Long m;
    public final Long n;
    public final Long o;

    public e(String r17, PermissionOperation r18, String r19, Long r20) {
        Intrinsics.checkNotNullParameter(r17, "operation");
        Intrinsics.checkNotNullParameter(r18, "operationV2");
        this(r17, r18, 2131887246, "docx_file", r19, r20, null, null, null, null, null, null, null, null, 32704);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        sbb.e r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        FileBizDomain r14 = this.h;
        if (r14 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r13 + r16) * 31;
        String r18 = this.i;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.j;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        String r24 = this.k;
        if (r24 != null) goto L33;
        int r26 = 0;
    L34:
        int r27 = (r23 + r26) * 31;
        String r28 = this.l;
        if (r28 != null) goto L37;
        int r29 = 0;
    L38:
        int r30 = (r27 + r29) * 31;
        Long r31 = this.m;
        if (r31 != null) goto L41;
        int r32 = 0;
    L42:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.n;
        if (r34 != null) goto L45;
        int r36 = 0;
    L46:
        int r37 = (r33 + r36) * 31;
        Long r38 = this.o;
        if (r38 == null) goto L51;
        r2 = r38.hashCode();
    L51:
        return r37 + r2;
    L45:
        r36 = r34.hashCode();
        goto L46
    L41:
        r32 = r31.hashCode();
        goto L42
    L37:
        r29 = r28.hashCode();
        goto L38
    L33:
        r26 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
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
        return "PermissionParam(operation=" + this.a + ", operationV2=" + this.b + ", unableTips=" + this.c + ", mountPoint=" + this.d + ", token=" + this.e + ", senderTenantID=" + this.f + ", tokenEntityType=" + this.g + ", scopedFileBizDomain=" + this.h + ", scopedEntityOperate=" + this.i + ", scopedEntityType=" + this.j + ", msgId=" + this.k + ", fileKey=" + this.l + ", chatID=" + this.m + ", chatType=" + this.n + ", senderUserId=" + this.o + ')';
    }

    public e(String r17, PermissionOperation r18, int r19, String r20, String r21, Long r22, sbb.e r23, FileBizDomain r24, String r26, String r27, String r28, Long r29, Long r210, Long r30, int r31) {
        String r3 = "";
        if ((r31 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r31 & 2) == 0) goto L9;
        PermissionOperation r4 = PermissionOperation.UNKNOWN;
    L11:
        if ((r31 & 4) == 0) goto L13;
        int r5 = -1;
    L15:
        if ((r31 & 16) != 0) goto L19;
        r3 = r21;
    L19:
        if ((r31 & 32) == 0) goto L21;
        Long r6 = -1L;
    L23:
        if ((r31 & 64) == 0) goto L25;
        sbb.e r7 = null;
    L27:
        if ((r31 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L29;
        FileBizDomain r9 = null;
    L31:
        if ((r31 & 256) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r31 & 512) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r31 & 1024) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r31 & 4096) == 0) goto L45;
        Long r13 = null;
    L47:
        if ((r31 & 8192) == 0) goto L49;
        Long r14 = null;
    L51:
        if ((r31 & 16384) == 0) goto L53;
        Long r1 = null;
    L54:
        Intrinsics.checkNotNullParameter(r2, "operation");
        Intrinsics.checkNotNullParameter(r4, "operationV2");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r20;
        this.e = r3;
        this.f = r6;
        this.g = r7;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = null;
        this.m = r13;
        this.n = r14;
        this.o = r1;
        return;
    L53:
        r1 = r30;
        goto L54
    L49:
        r14 = r210;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
