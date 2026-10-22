package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final m a = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> b = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> c = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.m$a$a, reason: collision with other inner class name */
        public static final class C0031a extends a {
            public final String a;
            public final PermissionResponse b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0031a) == true) goto L8;
                return false;
            L8:
                C0031a r6 = (C0031a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                PermissionResponse r1 = this.b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "DisabledToast(tips=" + this.a + ", permissionResponseForDisabledClick=" + this.b + ')';
            }

            public C0031a(String r2, PermissionResponse r3) {
                Intrinsics.checkNotNullParameter(r2, "tips");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {
            public final PermissionResponse a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "PermissionPlatformAction(response=" + this.a + ')';
            }

            public d(PermissionResponse r2) {
                Intrinsics.checkNotNullParameter(r2, "response");
                this.a = r2;
            }
        }

        public static final class e extends a {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public static final class f extends a {
            public final gj5.c a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "SecurityPolicyDialog(result=" + this.a + ')';
            }

            public f(gj5.c r2) {
                Intrinsics.checkNotNullParameter(r2, "result");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileAuthResultFrom.values().length];
            r0[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
        public final /* synthetic */ oj5.a b;
        public final /* synthetic */ FragmentActivity c;

        public c(com.bytedance.ee.bear.more.office.c r1, oj5.a r2, FragmentActivity r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            DocPermission r4 = (DocPermission) r3;
            tt5.a.h("OfficeExportAsActionExecutor", "fetch export permission success. actionId=" + this.a.a + ", type=" + this.b.getType());
            oj5.a r0 = this.b;
            Intrinsics.checkNotNull(r4);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "docPermission");
            r0.i = r4;
            Toast.cancelLoading();
            m r5 = m.a;
            FragmentActivity r6 = this.c;
            com.bytedance.ee.bear.more.office.d r1 = m.c(this.a);
            if (Intrinsics.areEqual(r1, com.bytedance.ee.bear.more.office.d.C0117d.a) == false) goto L5;
        L19:
            m.g(this.a.a);
            return;
        L5:
            if (Intrinsics.areEqual(r1, com.bytedance.ee.bear.more.office.d.a.a) == true) goto L19;
            if (Intrinsics.areEqual(r1, com.bytedance.ee.bear.more.office.d.f.a) == true) goto L19;
            if (Intrinsics.areEqual(r1, com.bytedance.ee.bear.more.office.d.e.a) == false) goto L12;
            Toast.showFailureText(r6, com.bytedance.ee.bear.more.office.f.c());
            goto L19
        L12:
            if ((r1 instanceof com.bytedance.ee.bear.more.office.d.b) == false) goto L15;
            Toast.showFailureText(r6, ((com.bytedance.ee.bear.more.office.d.b) r1).a);
            goto L19
        L15:
            if ((r1 instanceof com.bytedance.ee.bear.more.office.d.c) == false) goto L18;
            Toast.showFailureText(r6, ((com.bytedance.ee.bear.more.office.d.c) r1).a);
            goto L19
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
        public final /* synthetic */ FragmentActivity b;

        public d(com.bytedance.ee.bear.more.office.c r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tt5.a.e("OfficeExportAsActionExecutor", "fetch export permission failed. actionId=" + this.a.a, (Throwable) r4, false);
            Toast.cancelLoading();
            Toast.showFailureText(this.b, 2131887802);
            m r5 = m.a;
            m.g(this.a.a);
        }
    }

    public m() {
    }

    static {
        a = new m();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static Context b(com.bytedance.ee.bear.more.office.c r1) {
        FragmentActivity r0 = r1.getActivity();
        if (r0 != null) goto L11;
        Fragment r2 = r1.e;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getContext();
    L11:
        return r0;
    }

    public static com.bytedance.ee.bear.more.office.d c(com.bytedance.ee.bear.more.office.c r24) {
        a r2 = i(r24, false);
        if (Intrinsics.areEqual(r2, a.c.a) == false) goto L5;
        g(r24.a);
        return com.bytedance.ee.bear.more.office.d.e.a;
    L5:
        String r4 = "";
        if (Intrinsics.areEqual(r2, a.b.a) == false) goto L23;
        FragmentActivity r3 = r24.getActivity();
        if (r3 == null) goto L53;
        oj5.c r5 = r24.g;
        com.bytedance.ee.bear.more.b r7 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r9 = Bundle.EMPTY;
        String r8 = r5.getToken();
        if (r8 != null) goto L13;
        String r10 = "";
    L14:
        r7.c(new com.bytedance.ee.bear.more.i(r9, r10, r5.getType(), false, r5.b(), "export_as", "ccm_space_export_as_view", "", "", false, r5.m(), r5.H(), r5.isOwner(), r5.L()));
        com.bytedance.ee.bear.d r1 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        int r11 = r5.getType();
        int r12 = r5.i();
        String r13 = r5.getToken();
        String r6 = r5.getToken();
        if (r6 != null) goto L17;
        String r14 = "";
    L19:
        if (r1.h(r3, new com.bytedance.ee.bear.d.a(r11, r12, r13, r14, r5.getTitle(), r5.t(), r5.a(), r5.d(), r5.m(), r5.h(), r5.s(), r5.N(), r5.c().a), new n(r24)) == false) goto L21;
        h(r24, "ccm_space_export_as_view", null);
        g(r24.a);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L21:
        g(r24.a);
        return new com.bytedance.ee.bear.more.office.d.c(0);
    L17:
        r14 = r6;
        goto L19
    L13:
        r10 = r8;
        goto L14
    L53:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    L23:
        if (Intrinsics.areEqual(r2, a.e.a) == false) goto L26;
        d(r24);
        return com.bytedance.ee.bear.more.office.d.f.a;
    L26:
        if ((r2 instanceof a.C0031a) == false) goto L37;
        a.C0031a r15 = (a.C0031a) r2;
        PermissionResponse r16 = r15.b;
        if (r16 == null) goto L35;
        ph5.e r17 = r16.getCallback();
        if (r17 == null) goto L35;
        Context r18 = b(r24);
        if (r18 != null) goto L34;
        r18 = eu5.b.a;
    L34:
        r17.a(r18, r15.b);
    L35:
        g(r24.a);
        return new com.bytedance.ee.bear.more.office.d.b(r15.a);
    L37:
        if ((r2 instanceof a.d) == false) goto L43;
        a.d r19 = (a.d) r2;
        ph5.e r20 = r19.a.getCallback();
        Context r21 = b(r24);
        if (r21 != null) goto L41;
        r21 = eu5.b.a;
    L41:
        r20.a(r21, r19.a);
        g(r24.a);
        return com.bytedance.ee.bear.more.office.d.a.a;
    L43:
        if ((r2 instanceof a.f) == false) goto L51;
        oj5.c r22 = r24.g;
        gj5.b r23 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r25 = FileBizDomain.FileBizDomainCCM;
        int r26 = r22.getType();
        String r27 = r22.getToken();
        if (r27 == null) goto L48;
        r4 = r27;
    L48:
        r23.c("CCM_EXPORT", r25, r26, r4);
        g(r24.a);
        return com.bytedance.ee.bear.more.office.d.a.a;
    L51:
        throw new NoWhenBranchMatchedException();
    }

    public static void d(com.bytedance.ee.bear.more.office.c r6) {
        FragmentActivity r0 = r6.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        oj5.c r1 = r6.g;
        if ((r1 instanceof oj5.a) == false) goto L8;
        oj5.a r2 = (oj5.a) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, CompositeDisposable> r3 = b;
        String r4 = r6.a;
        CompositeDisposable r5 = r3.get(r4);
        if (r5 != null) goto L17;
        r5 = new CompositeDisposable();
        CompositeDisposable r7 = r3.putIfAbsent(r4, r5);
        if (r7 == null) goto L17;
        r5 = r7;
    L17:
        Toast.showLoading(r0, r0.getString(2131887769));
        r5.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r2.c, r2.getType()).subscribe(new c(r6, r2, r0), new d(r6, r0)));
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static void g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "actionId");
        CompositeDisposable r0 = b.remove(r1);
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        CompositeDisposable r2 = c.remove(r1);
        if (r2 == null) goto L9;
        r2.clear();
        return;
    }

    public static com.bytedance.ee.bear.more.office.a e(com.bytedance.ee.bear.more.office.c r6, com.bytedance.ee.bear.office.list.adapter.p r7) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Context r0 = b(r6);
        if (r0 != null) goto L5;
        r0 = eu5.b.a;
    L5:
        boolean r1 = true;
        a r2 = i(r6, true);
        if (Intrinsics.areEqual(r2, a.c.a) == false) goto L9;
        com.bytedance.ee.bear.more.office.a r3 = com.bytedance.ee.bear.more.office.a.b.a;
    L27:
        oj5.c r4 = r6.g;
        if ((r4 instanceof oj5.a) == false) goto L30;
        oj5.a r5 = (oj5.a) r4;
    L31:
        if (r5 != null) goto L34;
    L47:
        return r3;
    L34:
        if ((r5.i.a instanceof DefaultDocUserPermission) == true) goto L36;
    L38:
        r1 = false;
    L39:
        if (r1 == false) goto L47;
        ConcurrentHashMap<String, CompositeDisposable> r8 = c;
        if (r8.containsKey(r6.a) == true) goto L47;
        CompositeDisposable r9 = new CompositeDisposable();
        if (r8.putIfAbsent(r6.a, r9) != null) goto L47;
        r9.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r5.c, r5.getType()).subscribe(new o(r6, r5, r7), new p(r6, r7)));
        goto L47
    L36:
        if (q.a(r5) == false) goto L38;
    L30:
        r5 = null;
        goto L31
    L9:
        if (Intrinsics.areEqual(r2, a.b.a) == false) goto L12;
        r3 = com.bytedance.ee.bear.more.office.a.d.a;
        goto L27
    L12:
        if (Intrinsics.areEqual(r2, a.e.a) == false) goto L15;
        r3 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131892995), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        goto L27
    L15:
        if ((r2 instanceof a.d) == false) goto L18;
        r3 = new com.bytedance.ee.bear.more.office.a.C0116a(null, OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION, 1);
        goto L27
    L18:
        if ((r2 instanceof a.f) == false) goto L21;
        r3 = new com.bytedance.ee.bear.more.office.a.C0116a(null, OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG, 1);
        goto L27
    L21:
        if ((r2 instanceof a.C0031a) == false) goto L49;
        a.C0031a r10 = (a.C0031a) r2;
        String r11 = r10.a;
        if (r10.b == null) goto L25;
        OfficeLongPressDisabledDispatchReason r12 = OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION;
    L26:
        r3 = new com.bytedance.ee.bear.more.office.a.C0116a(r11, r12);
        goto L27
    L25:
        r12 = null;
        goto L26
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public static a i(com.bytedance.ee.bear.more.office.c r11, boolean r12) {
        Context r0 = b(r11);
        if (r0 != null) goto L6;
        a.C0031a r13 = new a.C0031a(com.bytedance.ee.bear.more.office.f.c(), null);
        f(r11, r13, "missing_context");
        return r13;
    L6:
        oj5.c r2 = r11.g;
        if ((r2 instanceof oj5.a) == false) goto L9;
        oj5.a r3 = (oj5.a) r2;
    L10:
        if (r3 != null) goto L14;
        a.c r14 = a.c.a;
        f(r11, r14, "moreInfo_not_DocMoreInfo");
        return r14;
    L14:
        if (q.a(r3) == true) goto L16;
    L94:
        a.c r15 = a.c.a;
        f(r11, r15, "unsupported_export_type_or_wiki_container");
        return r15;
    L16:
        if (r3.getType() == 16) goto L94;
        if (r3.p == true) goto L21;
    L24:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r4 = jg5.e.a.a.g();
        if (r12 == true) goto L27;
    L34:
        boolean r16 = false;
    L35:
        if (r4 == false) goto L38;
        if (r16 == true) goto L38;
        PermissionResponse r5 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r3.c, r3, BizDomain.FileBizDomainCCM, "EXPORT", r3.i.a);
    L39:
        if (r5 == null) goto L45;
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.e(r5) == true) goto L45;
        a.c r17 = a.c.a;
        f(r11, r17, "permission_platform_ui_invisible");
        return r17;
    L45:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L48;
        a.C0031a r18 = new a.C0031a(r0.getString(2131887951), null);
        f(r11, r18, "network_disconnected");
        return r18;
    L48:
        gj5.b r6 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r7 = FileBizDomain.FileBizDomainCCM;
        int r8 = r3.getType();
        String r9 = r3.c;
        if (r9 != null) goto L51;
        r9 = "";
    L51:
        gj5.c r10 = r6.g("CCM_EXPORT", r7, r8, r9);
        if (r10.a == true) goto L59;
        if (b.a[r10.b.ordinal()] != 1) goto L56;
        a.f r19 = new a.f(r10);
        f(r11, r19, "security_policy_blocked");
        return r19;
    L56:
        a.C0031a r110 = new a.C0031a(r0.getString(2131887246), null);
        f(r11, r110, "admin_blocked");
        return r110;
    L59:
        if (r3.isSecretFileExport() == false) goto L61;
    L92:
        a.C0031a r111 = new a.C0031a(r0.getString(2131889704), null);
        f(r11, r111, "secret_file_export_or_view_blocked");
        return r111;
    L61:
        if (r3.isSecretFileView() == true) goto L92;
        if (r16 == false) goto L67;
        a.e r112 = a.e.a;
        f(r11, r112, "placeholder_doc_permission_wait_real_permission");
        return r112;
    L67:
        if (r5 == null) goto L83;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r5) == false) goto L73;
        a.b r113 = a.b.a;
        f(r11, r113, "permission_platform_ui_enabled");
        return r113;
    L73:
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r5) == false) goto L77;
        a.d r114 = new a.d(r5);
        f(r11, r114, "permission_platform_ui_action");
        return r114;
    L77:
        if (r3.p == false) goto L79;
        String r115 = r0.getString(2131889882);
        Intrinsics.checkNotNull(r115);
    L80:
        a.C0031a r1 = new a.C0031a(r115, r5);
        f(r11, r1, "permission_platform_ui_disabled");
        return r1;
    L79:
        r115 = r0.getString(2131887706);
        Intrinsics.checkNotNull(r115);
        goto L80
    L83:
        if (r3.p() == false) goto L85;
        a.b r116 = a.b.a;
        f(r11, r116, "all_export_checks_passed");
        return r116;
    L85:
        if (r3.p == false) goto L87;
        String r117 = r0.getString(2131889882);
        Intrinsics.checkNotNull(r117);
    L88:
        a.C0031a r20 = new a.C0031a(r117, null);
        f(r11, r20, "user_permission_cannot_export");
        return r20;
    L87:
        r117 = r0.getString(2131887706);
        Intrinsics.checkNotNull(r117);
    L38:
        r5 = null;
        goto L39
    L27:
        if ((r3.i.a instanceof DefaultDocUserPermission) == true) goto L29;
    L31:
        boolean r118 = false;
    L32:
        if (r118 == false) goto L34;
        r16 = true;
        goto L35
    L29:
        if (q.a(r3) == false) goto L31;
        r118 = true;
        goto L32
    L21:
        if (r3.q == false) goto L24;
        a.c r119 = a.c.a;
        f(r11, r119, "shortcut_origin_deleted");
        return r119;
    L9:
        r3 = null;
        goto L10
    }

    public static void f(com.bytedance.ee.bear.more.office.c r6, a r7, String r8) {
        StringBuilder r0 = new StringBuilder("export-as permission decision. ");
        StringBuilder r1 = new StringBuilder("actionId=");
        r1.append(du5.b.k(r6.a));
        r1.append(", token=");
        oj5.c r2 = r6.g;
        String r4 = null;
        if ((r2 instanceof oj5.a) == false) goto L5;
        oj5.a r3 = (oj5.a) r2;
    L6:
        if (r3 == null) goto L8;
        String r5 = r3.c;
    L9:
        String r9 = "";
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        if (r5.length() != 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L22;
        String r11 = r6.f.d;
        if (r11 == null) goto L21;
        r9 = r11;
    L21:
        r5 = r9;
    L22:
        r1.append(du5.b.k(r5));
        r1.append(", type=");
        r1.append(r6.g.getType());
        r1.append(", realType=");
        r1.append(r6.g.i());
        r1.append(", moreInfo=");
        r1.append(r6.g.getClass().getSimpleName());
        r1.append(", isShortcut=");
        r1.append(r6.g.E());
        r1.append(", userPerm=");
        IDocUserPermission r12 = r6.g.c().a;
        if (r12 == null) goto L25;
        r4 = r12.getClass().getSimpleName();
    L25:
        r1.append(r4);
        r0.append(r1.toString());
        r0.append(", decision=");
        if (Intrinsics.areEqual(r7, a.c.a) == false) goto L29;
        String r13 = "Hidden";
    L43:
        r0.append(r13);
        r0.append(", reason=");
        r0.append(r8);
        tt5.a.h("OfficeExportAsActionExecutor", r0.toString());
        return;
    L29:
        if (Intrinsics.areEqual(r7, a.b.a) == false) goto L32;
        r13 = "Enabled";
        goto L43
    L32:
        if (Intrinsics.areEqual(r7, a.e.a) == false) goto L35;
        r13 = "Prefetching";
        goto L43
    L35:
        if ((r7 instanceof a.C0031a) == false) goto L38;
        r13 = "DisabledToast";
        goto L43
    L38:
        if ((r7 instanceof a.d) == false) goto L41;
        r13 = "PermissionPlatformAction";
        goto L43
    L41:
        if ((r7 instanceof a.f) == false) goto L46;
        r13 = "SecurityPolicyDialog";
        goto L43
    L46:
        throw new NoWhenBranchMatchedException();
    L15:
        r10 = false;
        goto L16
    L8:
        r5 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public static void h(com.bytedance.ee.bear.more.office.c r15, String r16, Map r17) {
        oj5.c r0 = r15.g;
        com.bytedance.ee.bear.more.b r1 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r4 = Bundle.EMPTY;
        String r2 = r0.getToken();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.I(new com.bytedance.ee.bear.more.l(r16, r4, r2, r0.getType(), r0.b(), false, r0.m(), r0.isOwner(), false, r0.L(), r17));
    }

    public static final void a(com.bytedance.ee.bear.more.office.c r18, String r19, String r20, Map r21) {
        oj5.c r0 = r18.g;
        com.bytedance.ee.bear.more.b r1 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r4 = Bundle.EMPTY;
        String r2 = r0.getToken();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.E(new com.bytedance.ee.bear.more.m(r19, r4, r2, r0.getType(), r0.b(), false, r0.m(), r20, "none", "", r0.isOwner(), false, r0.L(), r21));
    }
}
