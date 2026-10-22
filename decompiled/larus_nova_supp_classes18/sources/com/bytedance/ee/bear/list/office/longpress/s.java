package com.bytedance.ee.bear.list.office.longpress;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public static final s a = null;
    public static final ConcurrentHashMap<String, PermissionResponse> b = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> c = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> d = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressDisabledDispatchReason.values().length];
            r0[OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ Context d;

        public b(com.bytedance.ee.bear.more.office.c r1, int r2, oj5.c r3, Context r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            DocPermission r7 = (DocPermission) r6;
            tt5.a.h("OfficeMakeCopyActionExecutor", "fetch make copy permission success. actionId=" + this.a.a + ", type=" + this.b);
            oj5.c r0 = this.c;
            Intrinsics.checkNotNull(r7);
            r0.r(r7);
            Toast.cancelLoading();
            s r8 = s.a;
            Context r9 = this.d;
            com.bytedance.ee.bear.more.office.c r1 = this.a;
            oj5.c r2 = r1.g;
            if (s.k(r2, r1.f) == true) goto L5;
        L25:
            s.n(this.a.a);
            return;
        L5:
            if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L25;
            com.bytedance.ee.bear.more.office.a.C0116a r3 = s.p(r9, r2);
            if (r3 == null) goto L10;
            Toast.showText(r9, r3.a);
            goto L25
        L10:
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L21;
            com.bytedance.ee.bear.more.office.a.C0116a r4 = s.o(r9, r2);
            if (r4 == null) goto L15;
            s.h(r9, r1, r4);
            goto L25
        L15:
            PermissionResponse r5 = s.g(r2, r2.c().a);
            PermissionResponse.Companion.getClass();
            if (PermissionResponse.a.e(r5) == false) goto L25;
            s.b.put(r1.a, r5);
            com.bytedance.ee.bear.more.office.a r10 = s.s(r9, r5);
            if ((r10 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L24;
            s.h(r9, r1, (com.bytedance.ee.bear.more.office.a.C0116a) r10);
        L24:
            r1.k.invoke();
            s.m(r9, r1);
            s.n(r1.a);
            goto L25
        L21:
            com.bytedance.ee.bear.more.office.a r11 = s.r(r9, r2);
            if ((r11 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L24;
            Toast.showText(r9, ((com.bytedance.ee.bear.more.office.a.C0116a) r11).a);
            goto L25
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
        public final /* synthetic */ Context b;

        public c(com.bytedance.ee.bear.more.office.c r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tt5.a.e("OfficeMakeCopyActionExecutor", "fetch make copy permission failed. actionId=" + this.a.a, (Throwable) r4, false);
            Toast.cancelLoading();
            Toast.showFailureText(this.b, 2131887802);
            s r5 = s.a;
            s.n(this.a.a);
        }
    }

    public s() {
    }

    static {
        a = new s();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static Context a(com.bytedance.ee.bear.more.office.c r1) {
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

    public static String b(oj5.c r2) {
        String[] r0 = r2.B();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (ArraysKt.contains(r0, CommonMoreItemId.MAKE_COPY.getId()) != true) goto L7;
    L8:
        if (r1 == false) goto L12;
        Map<String, String> r3 = r2.M();
        if (r3 == null) goto L12;
        return r3.get(CommonMoreItemId.MAKE_COPY.getId());
    L12:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    public static com.bytedance.ee.bear.more.office.d c(com.bytedance.ee.bear.more.office.c r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Context r0 = a(r4);
        if (r0 == null) goto L5;
        oj5.c r1 = r4.g;
        if ((r1.c().a instanceof DefaultDocUserPermission) == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        d(r0, r4);
        return com.bytedance.ee.bear.more.office.d.f.a;
    L15:
        com.bytedance.ee.bear.more.office.a r3 = f(r4, null);
        if ((r3 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L31;
        com.bytedance.ee.bear.more.office.a.C0116a r5 = (com.bytedance.ee.bear.more.office.a.C0116a) r3;
        OfficeLongPressDisabledDispatchReason r6 = r5.b;
        if (r6 != OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY) goto L20;
    L28:
        d(r0, r4);
        return com.bytedance.ee.bear.more.office.d.f.a;
    L20:
        if (r6 == OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY) goto L28;
        h(r0, r4, r5);
        if (r5.b == null) goto L25;
        com.bytedance.ee.bear.more.office.d r7 = com.bytedance.ee.bear.more.office.d.a.a;
    L26:
        n(r4.a);
        return r7;
    L25:
        r7 = new com.bytedance.ee.bear.more.office.d.b(r5.a);
        goto L26
    L31:
        if (Intrinsics.areEqual(r3, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L34;
        n(r4.a);
        return com.bytedance.ee.bear.more.office.d.e.a;
    L34:
        m(r0, r4);
        n(r4.a);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L9:
        if (j(r1.getType()) == false) goto L11;
        r2 = true;
        goto L12
    L5:
        return new com.bytedance.ee.bear.more.office.d.b(com.bytedance.ee.bear.more.office.f.c());
    }

    public static gj5.c e(oj5.c r4) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r4.i(), q(r4));
    }

    public static boolean i(oj5.c r3) {
        if (r3.m() == false) goto L5;
        return false;
    L5:
        if ((r3 instanceof oj5.a) == false) goto L11;
        oj5.a r4 = (oj5.a) r3;
        return ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).p(r4.c, r4.n, r4.k);
    L11:
        return false;
    }

    public static boolean j(int r1) {
        if (r1 != sbb.e.g.b) goto L5;
    L20:
        return true;
    L5:
        if (r1 == sbb.e.o.b) goto L20;
        if (r1 == sbb.e.h.b) goto L20;
        if (r1 == sbb.e.k.b) goto L20;
        if (r1 == sbb.e.i.b) goto L20;
        if (r1 == sbb.e.l.b) goto L20;
        if (r1 == sbb.e.m.b) goto L17;
    L19:
        return false;
    L17:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.slides_enabled") == false) goto L19;
        goto L19
    }

    public static void n(String r1) {
        Intrinsics.checkNotNullParameter(r1, "actionId");
        b.remove(r1);
        CompositeDisposable r0 = c.remove(r1);
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        CompositeDisposable r2 = d.remove(r1);
        if (r2 == null) goto L9;
        r2.clear();
        return;
    }

    public static String q(oj5.c r4) {
        if (oj5.e.a(r4) == true) goto L5;
    L7:
        String r0 = r4.getToken();
    L9:
        if ((r4 instanceof oj5.a) == true) goto L11;
        return r0;
    L11:
        if (i(r4) == true) goto L13;
        return r0;
    L13:
        return ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).s(r0, ((oj5.a) r4).n);
    L5:
        if ((r4 instanceof oj5.f) == false) goto L7;
        r0 = ((oj5.f) r4).O;
        goto L9
    }

    public static void d(Context r7, com.bytedance.ee.bear.more.office.c r8) {
        oj5.c r0 = r8.g;
        if ((r0 instanceof oj5.a) == false) goto L5;
        oj5.a r1 = (oj5.a) r0;
    L6:
        if (r1 == null) goto L9;
        String r3 = r1.c;
        if (r3 == null) goto L9;
    L10:
        if (r1 == null) goto L12;
        int r2 = r1.getType();
    L13:
        ConcurrentHashMap<String, CompositeDisposable> r4 = c;
        String r5 = r8.a;
        CompositeDisposable r6 = r4.get(r5);
        if (r6 != null) goto L19;
        r6 = new CompositeDisposable();
        CompositeDisposable r9 = r4.putIfAbsent(r5, r6);
        if (r9 == null) goto L19;
        r6 = r9;
    L19:
        Toast.showLoading(r7, r7.getString(2131887769));
        r6.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r3, r2).subscribe(new b(r8, r2, r0, r7), new c(r8, r7)));
        return;
    L12:
        r2 = r0.getType();
    L9:
        r3 = q(r0);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static com.bytedance.ee.bear.more.office.a f(com.bytedance.ee.bear.more.office.c r11, com.bytedance.ee.bear.more.office.b r12) {
        Intrinsics.checkNotNullParameter(r11, "request");
        Context r0 = a(r11);
        oj5.a r2 = null;
        if (r0 != null) goto L6;
        com.bytedance.ee.bear.more.office.a.C0116a r13 = new com.bytedance.ee.bear.more.office.a.C0116a(com.bytedance.ee.bear.more.office.f.c(), null, 2);
        l(r11, r13, "missing_context");
        return r13;
    L6:
        oj5.c r3 = r11.g;
        boolean r5 = false;
        if (k(r3, r11.f) == true) goto L34;
        com.bytedance.ee.bear.more.office.a.b r14 = com.bytedance.ee.bear.more.office.a.b.a;
        if (r11.f.getType() != sbb.e.f.b) goto L11;
        String r1 = "folder_not_supported";
    L31:
        l(r11, r14, r1);
        return r14;
    L11:
        Map<String, Boolean> r4 = r3.K();
        CommonMoreItemId r6 = CommonMoreItemId.MAKE_COPY;
        if (Intrinsics.areEqual(r4.get(r6.getId()), Boolean.FALSE) == false) goto L14;
        r1 = "benefit_disabled";
        goto L31
    L14:
        String[] r7 = r3.O();
        if (r7 != null) goto L17;
    L19:
        if (r5 == false) goto L22;
        r1 = "js_invisible";
        goto L31
    L22:
        if (i(r3) == false) goto L25;
        r1 = "edition_doc_fg_disabled";
        goto L31
    L25:
        if (j(r3.getType()) == true) goto L28;
        r1 = "unsupported_type";
        goto L31
    L28:
        if (com.bytedance.ee.bear.more.q.b(r3) == false) goto L30;
        r1 = "phoenix_not_supported";
        goto L31
    L30:
        r1 = "visibility_unknown";
        goto L31
    L17:
        if (ArraysKt.contains(r7, r6.getId()) != true) goto L19;
        r5 = true;
        goto L19
    L34:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L37;
        com.bytedance.ee.bear.more.office.a.C0116a r15 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131887951), null, 2);
        l(r11, r15, "network_disconnected");
        return r15;
    L37:
        com.bytedance.ee.bear.more.office.a.C0116a r8 = p(r0, r3);
        if (r8 != null) goto L40;
        com.bytedance.ee.bear.more.office.a.C0116a r9 = o(r0, r3);
        if (r9 == null) goto L84;
        if (e(r3).b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L80;
        String r16 = "security_policy_blocked";
    L81:
        l(r11, r9, r16);
        return r9;
    L80:
        r16 = "admin_blocked";
        goto L81
    L84:
        if ((r3.c().a instanceof DefaultDocUserPermission) == true) goto L86;
    L88:
        boolean r10 = false;
    L89:
        oj5.c r17 = r11.g;
        if ((r17.c().a instanceof DefaultDocUserPermission) == false) goto L95;
        if (j(r17.getType()) == false) goto L95;
        r5 = true;
    L95:
        if (r5 == false) goto L114;
        ConcurrentHashMap<String, CompositeDisposable> r18 = d;
        if (r18.containsKey(r11.a) == true) goto L114;
        if ((r17 instanceof oj5.a) == false) goto L102;
        oj5.a r19 = (oj5.a) r17;
    L103:
        if (r19 == null) goto L106;
        String r20 = r19.c;
        if (r20 == null) goto L106;
    L107:
        if (r19 == null) goto L109;
        int r21 = r19.getType();
    L110:
        CompositeDisposable r22 = new CompositeDisposable();
        if (r18.putIfAbsent(r11.a, r22) != null) goto L114;
        r22.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r20, r21).subscribe(new u(r11, r17, r12, r21), new v(r11, r12)));
        goto L114
    L109:
        r21 = r17.getType();
    L106:
        r20 = q(r17);
        goto L107
    L102:
        r19 = null;
    L114:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L128;
        if (r10 == false) goto L119;
        com.bytedance.ee.bear.more.office.a.C0116a r110 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131892995), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        l(r11, r110, "placeholder_doc_permission_wait_real_permission");
        return r110;
    L119:
        PermissionResponse r111 = g(r3, r3.c().a);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.e(r111) == true) goto L123;
        com.bytedance.ee.bear.more.office.a.b r112 = com.bytedance.ee.bear.more.office.a.b.a;
        l(r11, r112, "permission_platform_ui_invisible");
        return r112;
    L123:
        b.put(r11.a, r111);
        com.bytedance.ee.bear.more.office.a r23 = s(r0, r111);
        if (r111.getAllow() == false) goto L126;
        String r113 = "permission_platform_allow_" + r111.getAllow();
    L127:
        l(r11, r23, r113);
    L143:
        return r23;
    L126:
        r113 = "permission_platform_denied";
        goto L127
    L128:
        if (r10 == false) goto L131;
        com.bytedance.ee.bear.more.office.a.C0116a r114 = new com.bytedance.ee.bear.more.office.a.C0116a(r0.getString(2131892995), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        l(r11, r114, "legacy_placeholder_doc_permission_wait_real_permission");
        return r114;
    L131:
        r23 = r(r0, r3);
        gj5.c r115 = e(r3);
        boolean r24 = r115.a;
        if (r24 == false) goto L134;
    L136:
        if (r24 == true) goto L139;
        String r116 = "legacy_admin_blocked";
    L142:
        l(r11, r23, r116);
        goto L143
    L139:
        if (r3.q() == true) goto L141;
        r116 = "legacy_user_permission_cannot_create_copy";
        goto L142
    L141:
        r116 = "legacy_all_make_copy_checks_passed";
        goto L142
    L134:
        if (r115.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L136;
        r116 = "legacy_security_policy_blocked";
        goto L142
    L86:
        if (j(r3.getType()) == false) goto L88;
        r10 = true;
        goto L89
    L40:
        if ((r3 instanceof oj5.a) == false) goto L42;
        r2 = (oj5.a) r3;
    L42:
        if (r2 == null) goto L48;
        ShareFolderUserPermission r117 = r2.t;
        if (r117 == null) goto L48;
        if (r117.canCreateSubNode() == true) goto L48;
        boolean r118 = true;
    L49:
        if (r118 == false) goto L52;
        String r119 = "parent_permission_cannot_create_sub_node";
    L73:
        l(r11, r8, r119);
        return r8;
    L52:
        if (r3.isSecretFileCopy() == true) goto L54;
    L56:
        if (r2 != null) goto L58;
    L60:
        boolean r120 = false;
    L61:
        if (r120 == true) goto L63;
    L65:
        String r121 = b(r3);
        if (r121 != null) goto L68;
    L69:
        r5 = true;
    L70:
        if (r5 == true) goto L72;
        r119 = "js_disabled";
        goto L73
    L72:
        r119 = "common_business_block";
        goto L73
    L68:
        if (r121.length() != 0) goto L70;
    L63:
        if (r2.q == false) goto L65;
        r119 = "shortcut_origin_deleted";
        goto L73
    L58:
        if (r2.p != true) goto L60;
        r120 = true;
        goto L61
    L54:
        if (r3.getType() != sbb.e.l.b) goto L56;
        r119 = "secret_file_copy_blocked";
    L48:
        r118 = false;
        goto L49
    }

    public static PermissionResponse g(oj5.c r13, IDocUserPermission r14) {
        UniBaseEntity r12 = new UniBaseEntity(q(r13), sbb.e.d(r13.i()), BizDomain.FileBizDomainCCM, r13.a(), r13.d(), null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r12, "CREATE_COPY"), new UserPermissionEntity(r14, null));
    }

    public static boolean k(oj5.c r3, Document r4) {
        if (r4.getType() != sbb.e.f.b) goto L5;
        return false;
    L5:
        Map<String, Boolean> r5 = r3.K();
        CommonMoreItemId r0 = CommonMoreItemId.MAKE_COPY;
        if (Intrinsics.areEqual(r5.get(r0.getId()), Boolean.FALSE) == true) goto L25;
        String[] r6 = r3.O();
        if (r6 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L16;
        return false;
    L16:
        if (i(r3) == false) goto L20;
        return com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.workspace.mobile.copy_edtion_enable");
    L20:
        if (j(r3.getType()) == true) goto L22;
        return false;
    L22:
        if (com.bytedance.ee.bear.more.q.b(r3) == true) goto L27;
        return true;
    L27:
        return false;
    L10:
        if (ArraysKt.contains(r6, r0.getId()) != true) goto L12;
        r7 = true;
        goto L13
    L25:
        return false;
    }

    public static void m(Context r24, com.bytedance.ee.bear.more.office.c r25) {
        oj5.c r2 = r25.g;
        if (TextUtils.isEmpty(r2.getTitle()) == false) goto L5;
        String r3 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(r24, r2.getType());
        Intrinsics.checkNotNull(r3);
    L6:
        oj5.c r6 = r25.g;
        if ((r6 instanceof oj5.a) == false) goto L15;
        com.bytedance.ee.bear.more.b r7 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Fragment r8 = r25.e;
        if (r8 == null) goto L11;
        Bundle r9 = r8.getArguments();
    L12:
        oj5.a r10 = (oj5.a) r6;
        r7.c(new com.bytedance.ee.bear.more.i(r9, r10.c, r10.getType(), false, r10.b(), "create_copy", "none", "", "", r6 instanceof oj5.f, r10.k, r10.r, r10.isOwner(), r10.L()));
        if (i(r6) == false) goto L15;
        ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).q(((oj5.a) r6).getType(), "create_copy", "ccm_docs_page_view", null, null, null);
        goto L15
    L11:
        r9 = null;
    L15:
        er5.b r4 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        boolean r11 = true;
        if (Intrinsics.areEqual(r25.h, "doc_detail") == true) goto L18;
    L20:
        boolean r5 = false;
    L22:
        if (r2.getType() == sbb.e.i.b) goto L24;
    L30:
        oj5.c r12 = r25.g;
        boolean r13 = oj5.e.a(r12);
        boolean r14 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).B();
        FolderVersion.a r15 = FolderVersion.Companion;
        Integer r16 = Integer.valueOf(r12.C());
        r15.getClass();
        boolean r17 = FolderVersion.a.c(r16);
        oj5.c r18 = r25.g;
        SpaceSelectorBean r19 = new SpaceSelectorBean();
        r19.a(q(r18));
        r19.a = r18.getType();
        r19.c = r18.x();
        String r110 = r18.b();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r19.e = r110;
        if (r18.E() == true) goto L33;
    L35:
        String r111 = r3;
    L36:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r19.f = r111;
        r19.g = r17;
        Intrinsics.checkNotNullParameter("innerpage_more", "<set-?>");
        r19.m = "innerpage_more";
        String r112 = r25.h;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r19.n = r112;
        r19.i = r18.isOwner();
        WikiSelectorBean r113 = new WikiSelectorBean();
        if (r13 == true) goto L39;
    L51:
        SelectorConfig r114 = new SelectorConfig();
        r114.d = true;
        r114.g = 3026;
        r114.b(r24.getString(2131889808));
        if (r13 == false) goto L54;
        r114.c(SelectorType.WIKI_MAKE_COPY_TO);
        r114.c = false;
    L72:
        Activity r20 = r25.getActivity();
        if (r20 == null) goto L75;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(r20);
    L75:
        Fragment r115 = r25.e;
        td5.f r116 = new td5.f();
        r116.a = 4;
        r116.e = 3026;
        if (r115 != null) goto L78;
    L80:
        r11 = false;
    L81:
        r116.h = r11;
        com.bytedance.ee.bear.contract.route.parcelable.f r117 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        if (r115 == null) goto L84;
        r117.a(r115, r114, r116, r19, r113);
        return;
    L84:
        r117.c(r24, r114, r116, r19, r113);
        return;
    L78:
        if (Boolean.valueOf(ForsetiHelper.s(r115)).booleanValue() != true) goto L80;
    L54:
        r114.c(SelectorType.SPACE_MAKE_COPY_TO);
        if (r14 == false) goto L58;
        if (r17 == false) goto L58;
        SelectorScope r21 = SelectorScope.ALL;
    L59:
        r114.a(r21);
        if (r17 == true) goto L62;
    L64:
        boolean r22 = false;
    L65:
        r114.c = r22;
        if (r14 == false) goto L70;
        if (r17 == false) goto L70;
        boolean r23 = false;
    L71:
        r114.e = r23;
        r114.i = r14;
        SelectorConfig.a r26 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r27 = new WeakReference(new t(r19, r24));
        r26.getClass();
        SelectorConfig.k = r27;
    L70:
        r23 = true;
        goto L71
    L62:
        if (r12.x() == null) goto L64;
        r22 = true;
    L58:
        r21 = SelectorScope.SPACE_ONLY;
        goto L59
    L39:
        if ((r12 instanceof oj5.f) == false) goto L51;
        oj5.f r28 = (oj5.f) r12;
        r113.i = r28.c;
        r113.j = r28.getType();
        r113.d = r28.O;
        oj5.d r118 = r28.H;
        if (r118 == null) goto L44;
        String r119 = r118.d();
        if (r119 == null) goto L44;
    L45:
        r113.a = r119;
        if (r28.p == true) goto L48;
    L50:
        r113.g = r3;
        r113.k = 0;
        r113.l = r28.p;
        r113.o = r28.isOwner();
        goto L51
    L48:
        if ((r12 instanceof oj5.a) == false) goto L50;
        r3 = r28.g.getTitle();
    L44:
        r119 = "";
        goto L45
    L33:
        if ((r18 instanceof oj5.a) == false) goto L35;
        r111 = ((oj5.a) r18).g.getTitle();
        goto L36
    L24:
        if (Intrinsics.areEqual(r25.h, "lark_workspace_bitable_landing") == true) goto L27;
        if (r5 == false) goto L30;
    L27:
        if (r4.j() == false) goto L30;
        r4.h(r24, r2.getToken(), r3);
        return;
    L18:
        if (ForsetiHelper.k() == true) goto L20;
        r5 = true;
        goto L22
    L5:
        r3 = r2.getTitle();
        goto L6
    }

    public static com.bytedance.ee.bear.more.office.a.C0116a o(Context r2, oj5.c r3) {
        gj5.c r4 = e(r3);
        if (r4.a == false) goto L6;
        return null;
    L6:
        if (r4.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L9;
        return new com.bytedance.ee.bear.more.office.a.C0116a(com.bytedance.ee.bear.more.office.f.c(), OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG);
    L9:
        return new com.bytedance.ee.bear.more.office.a.C0116a(r2.getString(2131887246), null, 2);
    }

    public static com.bytedance.ee.bear.more.office.a.C0116a p(Context r6, oj5.c r7) {
        if ((r7 instanceof oj5.a) == false) goto L5;
        oj5.a r0 = (oj5.a) r7;
    L6:
        boolean r2 = true;
        if (r0 == null) goto L11;
        ShareFolderUserPermission r3 = r0.t;
        if (r3 == null) goto L11;
        boolean r4 = r3.canCreateSubNode();
    L13:
        if (r4 == true) goto L17;
        return new com.bytedance.ee.bear.more.office.a.C0116a(r6.getString(2131887803), null, 2);
    L17:
        if (r7.isSecretFileCopy() == false) goto L23;
        if (r7.getType() != sbb.e.l.b) goto L23;
        return new com.bytedance.ee.bear.more.office.a.C0116a(r6.getString(2131889702), null, 2);
    L23:
        if (r0 != null) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == true) goto L30;
    L33:
        String r8 = b(r7);
        if (r8 != null) goto L36;
    L39:
        if (r2 == false) goto L41;
        return null;
    L41:
        return new com.bytedance.ee.bear.more.office.a.C0116a(r8, null, 2);
    L36:
        if (r8.length() == 0) goto L39;
        r2 = false;
        goto L39
    L30:
        if (r0.q == false) goto L33;
        return new com.bytedance.ee.bear.more.office.a.C0116a(r6.getString(2131889881), null, 2);
    L25:
        if (r0.p != true) goto L27;
        r5 = true;
    L11:
        r4 = true;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public static com.bytedance.ee.bear.more.office.a r(Context r4, oj5.c r5) {
        gj5.c r0 = e(r5);
        if (r0.a == true) goto L10;
        if (r0.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L8;
        return new com.bytedance.ee.bear.more.office.a.C0116a(com.bytedance.ee.bear.more.office.f.c(), OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG);
    L8:
        return new com.bytedance.ee.bear.more.office.a.C0116a(r4.getString(2131887246), null, 2);
    L10:
        if (r5.q() == true) goto L14;
        return new com.bytedance.ee.bear.more.office.a.C0116a(r4.getString(2131889698), null, 2);
    L14:
        return com.bytedance.ee.bear.more.office.a.d.a;
    }

    public static com.bytedance.ee.bear.more.office.a s(Context r3, PermissionResponse r4) {
        ph5.c r0 = (ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6);
        if (r4.getAllow() == false) goto L8;
        if (r0.e(r4) == false) goto L8;
        return com.bytedance.ee.bear.more.office.a.d.a;
    L8:
        return new com.bytedance.ee.bear.more.office.a.C0116a(r3.getString(2131889698), null, 2);
    }

    public static void h(Context r3, com.bytedance.ee.bear.more.office.c r4, com.bytedance.ee.bear.more.office.a.C0116a r5) {
        OfficeLongPressDisabledDispatchReason r0 = r5.b;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 != (-1)) goto L8;
        Toast.showText(r3, r5.a);
        return;
    L8:
        if (r1 != 1) goto L10;
        Context r6 = r4.getActivity();
        if (r6 != null) goto L23;
        return;
    L23:
        PermissionResponse r7 = b.get(r4.a);
        if (r7 == null) goto L32;
        ph5.e r8 = r7.getCallback();
        if (r8 == null) goto L33;
        r8.a(r6, r7);
        return;
    L33:
        return;
    L32:
        return;
    L10:
        if (r1 != 2) goto L12;
        oj5.c r9 = r4.g;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r9.i(), q(r9));
        return;
    L12:
        if (r1 != 3) goto L14;
    L18:
        d(r3, r4);
        return;
    L14:
        if (r1 == 4) goto L18;
        throw new NoWhenBranchMatchedException();
    L5:
        r1 = a.a[r0.ordinal()];
        goto L6
    }

    public static void l(com.bytedance.ee.bear.more.office.c r6, com.bytedance.ee.bear.more.office.a r7, String r8) {
        StringBuilder r0 = new StringBuilder("make-copy availability decision. ");
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
        r0.append(", result=");
        if (Intrinsics.areEqual(r7, com.bytedance.ee.bear.more.office.a.d.a) == false) goto L29;
        String r13 = "Visible";
    L37:
        r0.append(r13);
        r0.append(", reason=");
        r0.append(r8);
        tt5.a.h("OfficeMakeCopyActionExecutor", r0.toString());
        return;
    L29:
        if (Intrinsics.areEqual(r7, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L32;
        r13 = "Hidden";
        goto L37
    L32:
        if ((r7 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L35;
        r13 = "Loading";
        goto L37
    L35:
        if ((r7 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L40;
        r13 = "Disabled(reason=" + ((com.bytedance.ee.bear.more.office.a.C0116a) r7).b + ')';
        goto L37
    L40:
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
}
