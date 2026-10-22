package km5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int s = 0;
    public final int a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final ArrayList<Integer> g;
    public final ArrayList<Integer> h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final IDocPublicPermission m;
    public final IDocUserPermission n;
    public final boolean o;
    public final boolean p;
    public final ShareScene q;
    public Object r;

    /* JADX INFO: renamed from: km5.a$a, reason: collision with other inner class name */
    public static final class C0256a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.d == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.e == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        String r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ArrayList<Integer> r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ArrayList<Integer> r16 = this.h;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.i == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.j == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.k == false) goto L37;
        int r23 = 1231;
    L38:
        int r24 = (r22 + r23) * 31;
        if (this.l == false) goto L41;
        int r25 = 1231;
    L42:
        int r26 = (r24 + r25) * 31;
        IDocPublicPermission r27 = this.m;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (r26 + r28) * 31;
        IDocUserPermission r30 = this.n;
        if (r30 == null) goto L50;
        r2 = r30.hashCode();
    L50:
        int r31 = (r29 + r2) * 31;
        if (this.o == false) goto L53;
        int r32 = 1231;
    L54:
        int r33 = (r31 + r32) * 31;
        if (this.p == true) goto L59;
        r5 = 1237;
    L59:
        return ((r33 + r5) * 31) + this.q.hashCode();
    L53:
        r32 = 1237;
        goto L54
    L45:
        r28 = r27.hashCode();
        goto L46
    L41:
        r25 = 1237;
        goto L42
    L37:
        r23 = 1237;
        goto L38
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
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
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DocumentShareItemModelParams(source=" + this.a + ", type=" + this.b + ", token=" + this.c + ", isWiki=" + this.d + ", canExport=" + this.e + ", mindNoteViewType=" + this.f + ", disabledShareTypes=" + this.g + ", badgeShareTypes=" + this.h + ", isAtVC=" + this.i + ", adminPerceiveControl=" + this.j + ", update=" + this.k + ", isSpaceV2=" + this.l + ", publicPermission=" + this.m + ", userPermission=" + this.n + ", isEditionDoc=" + this.o + ", showExportImage=" + this.p + ", shareScene=" + this.q + ')';
    }

    public a(int r4, int r5, String r6, boolean r7, boolean r8, String r9, ArrayList<Integer> r10, ArrayList<Integer> r11, boolean r12, boolean r13, boolean r14, boolean r15, IDocPublicPermission r16, IDocUserPermission r17, boolean r18, boolean r19, ShareScene r20) {
        Intrinsics.checkNotNullParameter(r20, "shareScene");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
    }

    public /* synthetic */ a(int r22, int r23, String r24, boolean r25, boolean r26, String r27, ArrayList r28, ArrayList r29, boolean r30, boolean r31, boolean r32, boolean r33, IDocPublicPermission r34, IDocUserPermission r35, boolean r36, boolean r37, ShareScene r38, int r39) {
        if ((r39 & 16384) == 0) goto L5;
        boolean r18 = false;
    L7:
        if ((32768 & r39) == 0) goto L9;
        boolean r19 = false;
    L11:
        if ((r39 & 65536) == 0) goto L13;
        ShareScene r20 = ShareScene.DOCUMENT;
    L14:
        this(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r18, r19, r20);
        return;
    L13:
        r20 = r38;
        goto L14
    L9:
        r19 = r37;
        goto L11
    L5:
        r18 = r36;
        goto L7
    }
}
