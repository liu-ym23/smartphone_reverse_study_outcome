package com.bytedance.ee.bear.list.office.longpress;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final h a = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> b = null;
    public static final ConcurrentHashMap<String, CompositeDisposable> c = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.list.office.longpress.h$a$a, reason: collision with other inner class name */
        public static final class C0030a extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0030a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0030a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "DisabledToast(tips=" + this.a + ')';
            }

            public C0030a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "tips");
                this.a = r2;
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

    public static final class b {
        public final String a;
        public final int b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "PermissionFetchArgs(token=" + this.a + ", type=" + this.b + ')';
        }

        public final int getType() {
            return this.b;
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            this.a = r2;
            this.b = 12;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileAuthResultFrom.values().length];
            r0[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public h() {
    }

    static {
        a = new h();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
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

    public static String b(Document r2) {
        if (g(r2) == false) goto L14;
        String r0 = r2.G1;
        if (r0 != null) goto L7;
    L11:
        String r3 = r2.d;
        if (r3 != null) goto L18;
    L16:
        return "";
    L18:
        return r3;
    L7:
        if ((!StringsKt.isBlank(r0)) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L11;
        return r0;
    L14:
        r3 = r2.d;
        if (r3 != null) goto L18;
        goto L16
    }

    public static com.bytedance.ee.bear.more.office.d c(com.bytedance.ee.bear.more.office.c r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        tt5.a.h("OfficeDownloadActionExecutor", "execute download action. " + h(r8));
        a r0 = m(r8);
        if (Intrinsics.areEqual(r0, a.c.a) == false) goto L6;
        return com.bytedance.ee.bear.more.office.d.e.a;
    L6:
        if (Intrinsics.areEqual(r0, a.b.a) == false) goto L9;
        return d(r8);
    L9:
        if (Intrinsics.areEqual(r0, a.e.a) == false) goto L32;
        Context r1 = a(r8);
        if (r1 != null) goto L13;
        r1 = eu5.b.a;
    L13:
        oj5.c r2 = r8.g;
        if ((r2 instanceof oj5.a) == false) goto L16;
        oj5.a r3 = (oj5.a) r2;
    L18:
        if (r3 != null) goto L20;
        tt5.a.k("OfficeDownloadActionExecutor", "fetch download permission skipped. " + h(r8) + ", reason=moreInfo_not_DocMoreInfo");
        Toast.showText(r1, com.bytedance.ee.bear.more.office.f.c());
    L48:
        return com.bytedance.ee.bear.more.office.d.f.a;
    L20:
        b r5 = n(r8.f, r3);
        if (StringsKt.isBlank(r5.a) == false) goto L23;
        tt5.a.k("OfficeDownloadActionExecutor", "fetch download permission skipped. " + h(r8) + ", reason=empty_token, type=" + r5.getType());
        Toast.showText(r1, com.bytedance.ee.bear.more.office.f.c());
        goto L48
    L23:
        ConcurrentHashMap<String, CompositeDisposable> r4 = b;
        String r6 = r8.a;
        CompositeDisposable r7 = r4.get(r6);
        if (r7 != null) goto L29;
        r7 = new CompositeDisposable();
        CompositeDisposable r9 = r4.putIfAbsent(r6, r7);
        if (r9 == null) goto L29;
        r7 = r9;
    L29:
        tt5.a.h("OfficeDownloadActionExecutor", "fetch download permission start. " + h(r8) + ", fetchToken=" + du5.b.k(r5.a) + ", type=" + r5.getType());
        Toast.showLoading(r1, r1.getString(2131887769));
        r7.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r5.a, r5.getType()).subscribe(new i(r8, r5, r3), new j(r8, r5, r1)));
        goto L48
    L16:
        r3 = null;
        goto L18
    L32:
        if ((r0 instanceof a.C0030a) == false) goto L35;
        return new com.bytedance.ee.bear.more.office.d.b(((a.C0030a) r0).a);
    L35:
        if ((r0 instanceof a.d) == false) goto L41;
        a.d r10 = (a.d) r0;
        ph5.e r11 = r10.a.getCallback();
        Context r12 = a(r8);
        if (r12 != null) goto L39;
        r12 = eu5.b.a;
    L39:
        r11.a(r12, r10.a);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L41:
        if ((r0 instanceof a.f) == false) goto L45;
        p(r8);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L45:
        throw new NoWhenBranchMatchedException();
    }

    public static com.bytedance.ee.bear.more.office.d.C0117d d(com.bytedance.ee.bear.more.office.c r21) {
        Context r1 = a(r21);
        if (r1 != null) goto L5;
        r1 = eu5.b.a;
    L5:
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r3 = LarkContext.getApplication();
        r2.getClass();
        if (((dn4.a) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r3, com.ss.android.lark.passportc.internal.v.class)).c(((com.ss.android.lark.passportc.convention.a) e0c.k.a(r3, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.mobile.audit_report_disable_space_drive_download") == false) goto L8;
        tt5.a.h("OfficeDownloadActionExecutor", "skip download audit because audit FG disabled. " + h(r21));
    L9:
        oj5.c r4 = r21.g;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new com.bytedance.ee.bear.more.i(null, r4.getToken(), r4.getType(), false, r4.b(), OperationName.OPERATION_DOWNLOAD, "none", "", "", false, false, r4.H(), r4.isOwner(), r4.L()));
        Document r0 = r21.f;
        Intrinsics.checkNotNullParameter(r0, "document");
        String r5 = b(r0);
        String r6 = r0.a;
        String r7 = "";
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        SpaceFileOpenEntity r8 = new SpaceFileOpenEntity(r5, r6);
        String r9 = r0.F;
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        r8.setFileExt(r9);
        r8.setDownloadFrom("rom_right_click_download");
        if (g(r0) == false) goto L25;
        String r10 = r0.p;
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r8.setUrl(r10);
        String r11 = r0.p;
        if (r11 == null) goto L24;
        r7 = r11;
    L24:
        r8.setOriginUrl(r7);
        r8.setAppId("56");
        r8.setMountPoint(DocumentType.WIKI_NAME);
    L27:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L29;
        r8.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r8.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L29:
        ((com.bytedance.ee.bear.g) org.koin.java.a.c(com.bytedance.ee.bear.g.class, null, null, 6)).a(r1, r8);
        return com.bytedance.ee.bear.more.office.d.C0117d.a;
    L25:
        r8.setMountPoint("explorer");
        goto L27
    L8:
        tt5.a.h("OfficeDownloadActionExecutor", "doAuditCCMFileDownload from Office long press. " + h(r21));
        com.bytedance.ee.bear.middleground_permission_export.model.c.a.a((com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6), b(r21.f));
        goto L9
    }

    public static boolean f(Document r2) {
        Intrinsics.checkNotNullParameter(r2, "document");
        if (r2.getType() != sbb.e.l.b) goto L5;
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

    public static boolean g(Document r2) {
        if (r2.getType() == 16) goto L5;
    L7:
        return false;
    L5:
        if (r2.y1 != 12) goto L7;
        return true;
    }

    public static String h(com.bytedance.ee.bear.more.office.c r3) {
        oj5.c r0 = r3.g;
        String r2 = null;
        if ((r0 instanceof oj5.a) == false) goto L5;
        oj5.a r1 = (oj5.a) r0;
    L6:
        if (r1 == null) goto L12;
        DocPermission r4 = r1.i;
        if (r4 == null) goto L12;
        IDocUserPermission r5 = r4.a;
        if (r5 == null) goto L12;
        r2 = r5.getClass().getSimpleName();
    L12:
        StringBuilder r6 = new StringBuilder("actionId=");
        r6.append(du5.b.k(r3.a));
        r6.append(", token=");
        r6.append(du5.b.k(b(r3.f)));
        r6.append(", objToken=");
        String r7 = r3.f.d;
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        r6.append(du5.b.k(r7));
        r6.append(", type=");
        r6.append(r3.f.getType());
        r6.append(", realType=");
        r6.append(r3.f.y1);
        r6.append(", isWikiDrive=");
        r6.append(g(r3.f));
        r6.append(", moreInfo=");
        r6.append(r3.g.getClass().getSimpleName());
        r6.append(", moreType=");
        r6.append(r3.g.getType());
        r6.append(", moreRealType=");
        r6.append(r3.g.i());
        r6.append(", userPerm=");
        r6.append(r2);
        return r6.toString();
    L5:
        r1 = null;
        goto L6
    }

    public static String j(a r1) {
        if (Intrinsics.areEqual(r1, a.c.a) == false) goto L6;
        return "Hidden";
    L6:
        if (Intrinsics.areEqual(r1, a.b.a) == false) goto L9;
        return "Enabled";
    L9:
        if (Intrinsics.areEqual(r1, a.e.a) == false) goto L12;
        return "PermissionPrefetching";
    L12:
        if ((r1 instanceof a.C0030a) == false) goto L15;
        return "DisabledToast";
    L15:
        if ((r1 instanceof a.d) == false) goto L18;
        return "PermissionPlatformAction";
    L18:
        if ((r1 instanceof a.f) == false) goto L22;
        return "SecurityPolicyDialog";
    L22:
        throw new NoWhenBranchMatchedException();
    }

    public static String k(com.bytedance.ee.bear.more.office.a r2) {
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.a.b.a) == false) goto L6;
        return "Hidden";
    L6:
        if (Intrinsics.areEqual(r2, com.bytedance.ee.bear.more.office.a.d.a) == false) goto L9;
        return "Visible";
    L9:
        if ((r2 instanceof com.bytedance.ee.bear.more.office.a.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r2 instanceof com.bytedance.ee.bear.more.office.a.C0116a) == false) goto L16;
        return "Disabled(reason=" + ((com.bytedance.ee.bear.more.office.a.C0116a) r2).b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static void l(String r1) {
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

    public static a m(com.bytedance.ee.bear.more.office.c r13) {
        Context r0 = a(r13);
        if (r0 != null) goto L6;
        a.C0030a r1 = new a.C0030a(com.bytedance.ee.bear.more.office.f.c());
        i(r13, r1, "missing_context");
        return r1;
    L6:
        oj5.c r2 = r13.g;
        if ((r2 instanceof oj5.a) == false) goto L9;
        oj5.a r3 = (oj5.a) r2;
    L10:
        if (r3 != null) goto L13;
        a.c r4 = a.c.a;
        i(r13, r4, "moreInfo_not_DocMoreInfo");
        return r4;
    L13:
        boolean r5 = f(r13.f);
        boolean r6 = ((ya5.b) org.koin.java.a.c(ya5.b.class, null, null, 6)).a();
        boolean r7 = false;
        if (r3.p == true) goto L16;
    L18:
        boolean r8 = false;
    L19:
        PermissionResponse.a r9 = PermissionResponse.Companion;
        PermissionResponse r10 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r3, "DOWNLOAD");
        r9.getClass();
        boolean r11 = PermissionResponse.a.e(r10);
        if (r5 == false) goto L25;
        if (r6 == false) goto L25;
        if (r8 == true) goto L25;
        if (r11 == false) goto L25;
        r7 = true;
    L25:
        tt5.a.h("OfficeDownloadActionExecutor", "download visibility check. " + h(r13) + ", visible=" + r7 + ", isDriveFileLike=" + r5 + ", suiteFileEnabled=" + r6 + ", shortcutDeleted=" + r8 + ", uiVisible=" + r11);
        if (r7 == true) goto L30;
        a.c r12 = a.c.a;
        i(r13, r12, "visibility_check_failed");
        return r12;
    L30:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L33;
        a.C0030a r14 = new a.C0030a(r0.getString(2131887951));
        i(r13, r14, "network_disconnected");
        return r14;
    L33:
        PermissionResponse r15 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r3, "DOWNLOAD");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r16 = jg5.e.a.a;
        boolean r17 = r16.g();
        gj5.c r18 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r3.i(), b(r13.f));
        if (r17 == false) goto L40;
        ph5.c r19 = (ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6);
        Intrinsics.checkNotNull(r15);
        if (r19.d(r15) == false) goto L40;
        a.d r20 = new a.d(r15);
        i(r13, r20, "permission_platform_ui_action");
        return r20;
    L40:
        if (r18.a == true) goto L50;
        int r21 = c.a[r18.b.ordinal()];
        if (r21 != 1) goto L44;
        a.f r22 = new a.f(r18);
        i(r13, r22, "security_policy_blocked");
        return r22;
    L44:
        if (r21 == 2) goto L46;
        a.C0030a r23 = new a.C0030a(r0.getString(2131887246));
        i(r13, r23, "admin_blocked_unknown_source");
        return r23;
    L46:
        a.C0030a r24 = new a.C0030a(r0.getString(2131887246));
        i(r13, r24, "authz_admin_blocked");
        return r24;
    L50:
        if (r3.isSecretFileExport() == false) goto L52;
    L74:
        a.C0030a r25 = new a.C0030a(r0.getString(2131889704));
        i(r13, r25, "secret_file_export_or_view_blocked");
        return r25;
    L52:
        if (r3.isSecretFileView() == true) goto L74;
        if (r17 == false) goto L56;
        ph5.c r26 = (ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6);
        Intrinsics.checkNotNull(r15);
        boolean r27 = r26.e(r15);
    L58:
        if (r27 == true) goto L62;
        a.C0030a r28 = new a.C0030a(r0.getString(2131887701));
        i(r13, r28, "permission_ui_disabled");
        return r28;
    L62:
        if (o(r13.f, r3) == false) goto L65;
        a.e r29 = a.e.a;
        i(r13, r29, "placeholder_doc_permission_wait_real_permission");
        return r29;
    L65:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (r16.g() == false) goto L68;
        boolean r30 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).o(r3, "EXPORT", r3.i.a).getAllow();
    L69:
        if (r30 == true) goto L72;
        a.C0030a r31 = new a.C0030a(r0.getString(2131887701));
        i(r13, r31, "user_permission_cannot_download");
        return r31;
    L72:
        a.b r32 = a.b.a;
        i(r13, r32, "all_permission_checks_passed");
        return r32;
    L68:
        r30 = r3.p();
        goto L69
    L56:
        r27 = r18.a;
        goto L58
    L16:
        if (r3.q == false) goto L18;
        r8 = true;
        goto L19
    L9:
        r3 = null;
        goto L10
    }

    public static void p(com.bytedance.ee.bear.more.office.c r4) {
        oj5.c r0 = r4.g;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r0.i(), b(r4.f));
    }

    public static com.bytedance.ee.bear.more.office.a e(com.bytedance.ee.bear.more.office.c r10, com.bytedance.ee.bear.office.list.adapter.p r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        a r0 = m(r10);
        a.e r1 = a.e.a;
        if (Intrinsics.areEqual(r0, r1) == false) goto L24;
        oj5.c r2 = r10.g;
        if ((r2 instanceof oj5.a) == false) goto L7;
        oj5.a r3 = (oj5.a) r2;
    L8:
        if (r3 == null) goto L24;
        if (o(r10.f, r3) == false) goto L22;
        ConcurrentHashMap<String, CompositeDisposable> r5 = c;
        if (r5.containsKey(r10.a) == true) goto L22;
        b r7 = n(r10.f, r3);
        if (StringsKt.isBlank(r7.a) == false) goto L18;
        tt5.a.k("OfficeDownloadActionExecutor", "prefetch download permission skipped. " + h(r10) + ", reason=empty_token, type=" + r7.getType());
        goto L24
    L18:
        CompositeDisposable r8 = new CompositeDisposable();
        if (r5.putIfAbsent(r10.a, r8) == null) goto L21;
        tt5.a.h("OfficeDownloadActionExecutor", "prefetch download permission skipped. " + h(r10) + ", reason=already_running");
        goto L24
    L21:
        tt5.a.h("OfficeDownloadActionExecutor", "prefetch download permission start. " + h(r10) + ", fetchToken=" + du5.b.k(r7.a) + ", type=" + r7.getType());
        r8.add(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r7.a, r7.getType()).subscribe(new k(r10, r3, r11, r7), new l(r10, r7, r11)));
    L22:
        tt5.a.h("OfficeDownloadActionExecutor", "prefetch download permission skipped. " + h(r10) + ", needFetch=" + o(r10.f, r3) + ", hasRunning=" + c.containsKey(r10.a));
        goto L24
    L7:
        r3 = null;
    L24:
        if (Intrinsics.areEqual(r0, a.c.a) == false) goto L27;
        com.bytedance.ee.bear.more.office.a r12 = com.bytedance.ee.bear.more.office.a.b.a;
    L41:
        tt5.a.h("OfficeDownloadActionExecutor", "download availability result. " + h(r10) + ", decision=" + j(r0) + ", availability=" + k(r12));
        return r12;
    L27:
        if (Intrinsics.areEqual(r0, a.b.a) == false) goto L30;
        r12 = com.bytedance.ee.bear.more.office.a.d.a;
        goto L41
    L30:
        if (Intrinsics.areEqual(r0, r1) == false) goto L33;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(com.bytedance.ee.bear.more.office.f.b(), OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY);
        goto L41
    L33:
        if ((r0 instanceof a.d) == false) goto L36;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(null, OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION, 1);
        goto L41
    L36:
        if ((r0 instanceof a.f) == false) goto L39;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(null, OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG, 1);
        goto L41
    L39:
        if ((r0 instanceof a.C0030a) == false) goto L44;
        r12 = new com.bytedance.ee.bear.more.office.a.C0116a(((a.C0030a) r0).a, null, 2);
        goto L41
    L44:
        throw new NoWhenBranchMatchedException();
    }

    public static b n(Document r5, oj5.a r6) {
        boolean r1 = false;
        String r3 = "";
        if (g(r5) == false) goto L34;
        String r0 = r5.G1;
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (r0.length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L16;
        r0 = r6.o;
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        if (r0.length() != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L24;
        r0 = r6.c;
        if (r0 != null) goto L24;
        r0 = "";
    L24:
        if (r0.length() != 0) goto L26;
        r1 = true;
    L26:
        if (r1 == false) goto L33;
        String r8 = r5.d;
        if (r8 == null) goto L31;
        r3 = r8;
    L31:
        r0 = r3;
    L33:
        return new b(r0);
    L18:
        r7 = false;
        goto L19
    L10:
        r4 = false;
        goto L11
    L34:
        String r9 = r6.c;
        if (r9 != null) goto L38;
        r9 = "";
    L38:
        if (r9.length() != 0) goto L40;
        r1 = true;
    L40:
        if (r1 == false) goto L47;
        String r10 = r5.d;
        if (r10 == null) goto L45;
        r3 = r10;
    L45:
        r9 = r3;
    L47:
        return new b(r9);
    }

    public static boolean o(Document r0, oj5.a r1) {
        if (f(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1.i.a instanceof DefaultDocUserPermission) == false) goto L7;
        return true;
    }

    public static void i(com.bytedance.ee.bear.more.office.c r2, a r3, String r4) {
        tt5.a.h("OfficeDownloadActionExecutor", "download permission decision. " + h(r2) + ", decision=" + j(r3) + ", reason=" + r4);
    }
}
