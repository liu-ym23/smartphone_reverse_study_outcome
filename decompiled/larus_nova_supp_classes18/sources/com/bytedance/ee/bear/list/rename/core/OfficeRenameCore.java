package com.bytedance.ee.bear.list.rename.core;

import android.content.Context;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeRenameCore {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeRenameEditAvailability.values().length];
            r0[OfficeRenameEditAvailability.Visible.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OfficeRenameEditAvailability.Prefetching.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OfficeRenameEditAvailability.Disabled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements nc5.a<SimpleRequestResult> {
        public final /* synthetic */ com.bytedance.ee.bear.list.rename.core.b a;
        public final /* synthetic */ Function1<c, Unit> b;

        @Override // nc5.a
        public final void onFailure(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            tt5.a.e("OfficeRenameCore", "rename failed. type=" + this.a.b.getType(), r4, false);
            this.b.invoke(new c.a(this.a.e, r4));
        }

        @Override // nc5.a
        public final void onSuccess(SimpleRequestResult r5) {
            Intrinsics.checkNotNullParameter(r5, "result");
            rc5.a r6 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
            int r0 = OfficeRenameCore.a;
            com.bytedance.ee.bear.list.rename.core.b r1 = this.a;
            if (OfficeRenameCore.b(r1.b) == false) goto L5;
            String r2 = OfficeRenameCore.e(r1.b, r1.c);
        L17:
            r6.T(r2, this.a.d);
            this.b.invoke(c.b.a);
            return;
        L5:
            String r3 = r1.b.d;
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            if (r3.length() != 0) goto L11;
            boolean r4 = true;
        L12:
            if (r4 == false) goto L16;
            r2 = r1.c.getToken();
            if (r2 != null) goto L17;
            r2 = "";
            goto L17
        L16:
            r2 = r3;
            goto L17
        L11:
            r4 = false;
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(com.bytedance.ee.bear.list.rename.core.b r1, Function1<? super c, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static boolean b(Document r2) {
        Intrinsics.checkNotNullParameter(r2, "document");
        if (r2.getType() != e.l.b) goto L5;
    L10:
        return true;
    L5:
        if (r2.getType() == 16) goto L7;
    L9:
        return false;
    L7:
        if (r2.y1 != 12) goto L9;
        goto L9
    }

    public static Function0 d(com.bytedance.ee.bear.list.rename.core.b r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r8, "request");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Document r0 = r8.b;
        oj5.c r1 = r8.c;
        int r2 = r0.getType();
        e r3 = e.f;
        boolean r5 = false;
        String r7 = "";
        if (r2 != r3.b) goto L9;
        String r4 = r0.d;
        if (r4 == null) goto L24;
    L7:
        r7 = r4;
    L24:
        if (r7.length() != 0) goto L26;
        r5 = true;
    L26:
        if (r5 == false) goto L29;
        tt5.a.k("OfficeRenameCore", "rename failed, request token is empty. type=" + r8.b.getType());
        r9.invoke(new c.a(r8.e, null));
        return null;
    L29:
        qd5.b r6 = new qd5.b();
        int r10 = r8.b.getType();
        int r11 = r3.b;
        if (r10 == r11) goto L33;
        r11 = e.l.b;
    L33:
        final nc5.b r12 = r6.f(r11, r7, r8.d, new b(r8, r9));
        return new OfficeRenameCore$rename$1(r12);
    L9:
        if (b(r0) == false) goto L11;
        r7 = e(r0, r1);
        goto L24
    L11:
        String r13 = r1.getToken();
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        if (r13.length() != 0) goto L17;
        boolean r14 = true;
    L18:
        if (r14 == false) goto L22;
        r4 = r0.d;
        if (r4 != null) goto L7;
    L22:
        r7 = r13;
        goto L24
    L17:
        r14 = false;
        goto L18
    }

    public static String e(Document r5, oj5.c r6) {
        boolean r1 = false;
        String r4 = "";
        if (r5.getType() == 16) goto L5;
    L41:
        String r7 = r6.getToken();
        if (r7 != null) goto L45;
        r7 = "";
    L45:
        if (r7.length() != 0) goto L47;
        boolean r0 = true;
    L48:
        if (r0 == false) goto L53;
        r7 = r5.G1;
        if (r7 != null) goto L53;
        r7 = "";
    L53:
        if (r7.length() != 0) goto L55;
        r1 = true;
    L55:
        if (r1 == false) goto L63;
        String r8 = r5.d;
        if (r8 == null) goto L61;
        r4 = r8;
    L61:
        return r4;
    L63:
        return r7;
    L47:
        r0 = false;
        goto L48
    L5:
        if (r5.y1 != 12) goto L41;
        String r2 = r5.G1;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        if (r2.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L24;
        if ((r6 instanceof oj5.a) == false) goto L17;
        oj5.a r9 = (oj5.a) r6;
    L18:
        if (r9 == null) goto L20;
        r2 = r9.o;
    L21:
        if (r2 != null) goto L24;
        r2 = "";
        goto L24
    L20:
        r2 = null;
        goto L21
    L17:
        r9 = null;
    L24:
        if (r2.length() != 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L32;
        r2 = r6.getToken();
        if (r2 != null) goto L32;
        r2 = "";
    L32:
        if (r2.length() != 0) goto L34;
        r1 = true;
    L34:
        if (r1 == false) goto L62;
        String r11 = r5.d;
        if (r11 == null) goto L40;
        r4 = r11;
    L40:
        return r4;
    L62:
        return r2;
    L26:
        r10 = false;
        goto L27
    L12:
        r3 = false;
        goto L13
    }

    public static com.bytedance.ee.bear.list.rename.core.a a(Context r9, Document r10, oj5.c r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "document");
        Intrinsics.checkNotNullParameter(r11, "moreInfo");
        boolean r1 = false;
        if (NodeType.isShortcut(r10.M1) == false) goto L6;
    L10:
        boolean r0 = false;
    L12:
        if (r0 == true) goto L20;
        com.bytedance.ee.bear.list.rename.core.a.b r12 = com.bytedance.ee.bear.list.rename.core.a.b.a;
        if (NodeType.isShortcut(r10.M1) == false) goto L16;
        String r2 = "shortcut_not_supported";
    L17:
        c(r10, r11, r12, r2);
        return r12;
    L16:
        r2 = "unsupported_type";
        goto L17
    L20:
        if (j.a.a.getNetworkState().a() == true) goto L23;
        com.bytedance.ee.bear.list.rename.core.a.C0033a r3 = new com.bytedance.ee.bear.list.rename.core.a.C0033a(r9.getString(2131887951));
        c(r10, r11, r3, "network_disconnected");
        return r3;
    L23:
        boolean r4 = r11 instanceof oj5.b;
        if (r4 == false) goto L41;
        oj5.b r7 = (oj5.b) r11;
        if (r7.q == true) goto L37;
        ShareFolderUserPermission r8 = r7.t;
        if (r8 == null) goto L32;
        r1 = Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).B(r7, r8, "EDIT"), Boolean.TRUE);
        goto L37
    L32:
        if (r7.l == false) goto L35;
    L36:
        r1 = true;
        goto L37
    L35:
        if (r10.U >= 2) goto L36;
    L37:
        if (r1 == false) goto L39;
        OfficeRenameEditAvailability r5 = OfficeRenameEditAvailability.Visible;
    L59:
        int r6 = a.a[r5.ordinal()];
        if (r6 == 1) goto L94;
        if (r6 != 2) goto L63;
        com.bytedance.ee.bear.list.rename.core.a.c r13 = com.bytedance.ee.bear.list.rename.core.a.c.a;
        c(r10, r11, r13, "placeholder_doc_permission_wait_real_permission");
        return r13;
    L63:
        if (r6 != 3) goto L92;
        com.bytedance.ee.bear.list.rename.core.a.C0033a r14 = new com.bytedance.ee.bear.list.rename.core.a.C0033a(r9.getString(2131887803));
        if (r4 == false) goto L79;
        oj5.b r15 = (oj5.b) r11;
        if (r15.q == false) goto L70;
        String r16 = "folder_shortcut_not_supported";
    L90:
        c(r10, r11, r14, r16);
        return r14;
    L70:
        if (r15.t == null) goto L73;
        r16 = "folder_operation_edit_denied";
        goto L90
    L73:
        if (r15.l == false) goto L75;
    L77:
        r16 = "folder_edit_denied";
        goto L90
    L75:
        if (r10.U >= 2) goto L77;
        r16 = "folder_list_permission_denied";
        goto L90
    L79:
        if ((r11 instanceof oj5.a) == false) goto L89;
        oj5.a r17 = (oj5.a) r11;
        if (r17.p == false) goto L84;
        r16 = "doc_shortcut_not_supported";
        goto L90
    L84:
        if ((r17.i.a instanceof DefaultDocUserPermission) == true) goto L86;
    L88:
        r16 = "doc_operation_edit_denied";
        goto L90
    L86:
        if (b(r10) == false) goto L88;
        r16 = "placeholder_doc_permission_without_fallback";
        goto L90
    L89:
        r16 = "more_info_cannot_edit";
        goto L90
    L92:
        throw new NoWhenBranchMatchedException();
    L94:
        com.bytedance.ee.bear.list.rename.core.a.d r18 = com.bytedance.ee.bear.list.rename.core.a.d.a;
        c(r10, r11, r18, "edit_permission_allowed");
        return r18;
    L39:
        r5 = OfficeRenameEditAvailability.Disabled;
        goto L59
    L41:
        if ((r11 instanceof oj5.a) == false) goto L56;
        oj5.a r19 = (oj5.a) r11;
        if (r19.p == false) goto L45;
        r5 = OfficeRenameEditAvailability.Disabled;
        goto L59
    L45:
        IDocUserPermission r20 = r19.i.a;
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r19, r20, "EDIT"), Boolean.TRUE) == false) goto L49;
        r5 = OfficeRenameEditAvailability.Visible;
        goto L59
    L49:
        if ((r20 instanceof DefaultDocUserPermission) == true) goto L52;
        r5 = OfficeRenameEditAvailability.Disabled;
        goto L59
    L52:
        if (b(r10) == false) goto L54;
        r5 = OfficeRenameEditAvailability.Prefetching;
        goto L59
    L54:
        r5 = OfficeRenameEditAvailability.Disabled;
        goto L59
    L56:
        if (r11.n() == false) goto L58;
        r5 = OfficeRenameEditAvailability.Visible;
        goto L59
    L58:
        r5 = OfficeRenameEditAvailability.Disabled;
        goto L59
    L6:
        if (r10.getType() != e.f.b) goto L8;
    L11:
        r0 = true;
        goto L12
    L8:
        if (b(r10) == false) goto L10;
        goto L10
    }

    public static void c(Document r2, oj5.c r3, com.bytedance.ee.bear.list.rename.core.a r4, String r5) {
        StringBuilder r0 = new StringBuilder("rename availability decision. token=");
        String r1 = r2.d;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(du5.b.k(r1));
        r0.append(", type=");
        r0.append(r2.getType());
        r0.append(", realType=");
        r0.append(r2.y1);
        r0.append(", nodeType=");
        r0.append(r2.M1);
        r0.append(", moreInfo=");
        r0.append(r3.getClass().getSimpleName());
        r0.append(", moreType=");
        r0.append(r3.getType());
        r0.append(", moreRealType=");
        r0.append(r3.i());
        r0.append(", result=");
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.list.rename.core.a.d.a) == false) goto L9;
        String r6 = "Visible";
    L17:
        r0.append(r6);
        r0.append(", reason=");
        r0.append(r5);
        tt5.a.h("OfficeRenameCore", r0.toString());
        return;
    L9:
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.list.rename.core.a.b.a) == false) goto L12;
        r6 = "Hidden";
        goto L17
    L12:
        if (Intrinsics.areEqual(r4, com.bytedance.ee.bear.list.rename.core.a.c.a) == false) goto L15;
        r6 = "Prefetching";
        goto L17
    L15:
        if ((r4 instanceof com.bytedance.ee.bear.list.rename.core.a.C0033a) == false) goto L20;
        r6 = "Disabled";
        goto L17
    L20:
        throw new NoWhenBranchMatchedException();
    }
}
