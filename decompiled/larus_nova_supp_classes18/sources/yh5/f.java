package yh5;

import com.bytedance.ee.bear.lark.dependency.i0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionReportInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements ph5.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: yh5.f$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0339a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[BizDomain.values().length];
                r0[BizDomain.FileBizDomainCCM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
            L61:
                r0[BizDomain.FileBizDomainIM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
            L65:
                r0[BizDomain.FileBizDomainMAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            L45:
                r0[BizDomain.FileBizDomainCALENDAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
            L47:
                r0[BizDomain.FileBizDomainTODO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
            L55:
                r0[BizDomain.FileBizDomainOPENPLATFORM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
            L14:
                a = r0;
                int[] r1 = new int[DenyType.values().length];
                r1[DenyType.DLP_DETECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
            L51:
                r1[DenyType.DLP_SENSATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
            L57:
                r1[DenyType.ADMIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
            L63:
                r1[DenyType.FILE_STRATEGY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
            L39:
                r1[DenyType.USER_PERMISSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
            L49:
                r1[DenyType.TT_BLOCK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
            L59:
                r1[DenyType.AUDIT_CONTROL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
            L43:
                r1[DenyType.DEFAULT_NONE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
            L23:
                b = r1;
            }
        }

        public static FileBizDomain a(BizDomain r1) {
            Intrinsics.checkNotNullParameter(r1, "bizDomain");
            FileBizDomain r0 = FileBizDomain.FileBizDomainUNKNOWN;
            switch(C0339a.a[r1.ordinal()]) {
                case 1: goto L11;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L12;
            };
        L12:
            return FileBizDomain.FileBizDomainUNKNOWN;
        L13:
            return FileBizDomain.FileBizDomainUNKNOWN;
        L14:
            return FileBizDomain.FileBizDomainTODO;
        L15:
            return FileBizDomain.FileBizDomainCALENDAR;
        L16:
            return FileBizDomain.FileBizDomainMAIL;
        L17:
            return FileBizDomain.FileBizDomainIM;
        L11:
            return FileBizDomain.FileBizDomainCCM;
        }

        public static void f(PermissionResponse r5) {
            Intrinsics.checkNotNullParameter(r5, "response");
            PermissionRequest r1 = r5.getCacheReqRequest();     // Catch: Throwable -> L8
            if (r1 != null) goto L6;
            r1 = new PermissionRequest(new BaseEntity("", sbb.e.e, BizDomain.FileBizDomainCCM, ""), "");     // Catch: Throwable -> L8
        L6:
            com.bytedance.ee.bear.middleground.permission.c.F(c(r1, r5));     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            tt5.a.d("PermSdkUtils", "reportSdkClickResult " + th.getMessage());
        }

        @EntityType
        public static String g(int r1) {
            if (r1 != sbb.e.g.b) goto L6;
        L32:
            return "DOC";
        L6:
            if (r1 != sbb.e.o.b) goto L9;
            return "DOCX";
        L9:
            if (r1 != sbb.e.h.b) goto L12;
            return "SHEET";
        L12:
            if (r1 != sbb.e.k.b) goto L15;
            return "MINDNOTE";
        L15:
            if (r1 != sbb.e.l.b) goto L18;
            return "FILE";
        L18:
            if (r1 != sbb.e.i.b) goto L21;
            return "BITABLE";
        L21:
            if (r1 != sbb.e.f.b) goto L24;
            return "SPACE_CATALOG";
        L24:
            if (r1 != sbb.e.x.b) goto L27;
            return "IM_MSG_FILE";
        L27:
            if (r1 != sbb.e.m.b) goto L30;
            return "SLIDES";
        L30:
            if (r1 != sbb.e.q.b) goto L32;
            return "MeetingMinutes";
        }

        public static PermissionReportInfo c(PermissionRequest r2, PermissionResponse r3) {
            PermissionReportInfo r0 = new PermissionReportInfo();
            r0.setAllow(r3.getAllow());
            BizDomain r1 = r2.getBaseEntity().getDomain();
            if (r1 == null) goto L6;
            String r4 = r1.getBiz();
            if (r4 == null) goto L6;
        L7:
            r0.setDomain(r4);
            sbb.e r5 = r2.getBaseEntity().getType();
            if (r5 == null) goto L11;
            String r6 = r5.getType();
            if (r6 == null) goto L11;
        L12:
            r0.setType(r6);
            r0.setOperation(r2.getOperation());
            r0.setHasNet(com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a());
            DenyType r7 = r3.getDenySource().getDenyType();
            switch(C0339a.b[r7.ordinal()]) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                default: goto L22;
            };
        L15:
            String r8 = "AUDIT_CONTROL";
        L23:
            r0.setBlockType(r8);
            return r0;
        L16:
            r8 = "TT_BLOCK";
            goto L23
        L17:
            r8 = "USER_PERMISSION";
            goto L23
        L18:
            r8 = "FILE_STRATEGY";
            goto L23
        L19:
            r8 = "ADMIN";
            goto L23
        L20:
            r8 = "DLP_SENSITIVE";
            goto L23
        L21:
            r8 = "DLP_DETECTING";
            goto L23
        L22:
            r8 = "DEFAULT_NONE";
        L11:
            r6 = "unknown";
        L6:
            r4 = BizDomain.FileBizDomainCCM.getBiz();
            goto L7
        }

        public static boolean d(PermissionRequest r1, UserPermissionEntity r2) {
            Intrinsics.checkNotNullParameter(r1, "permissionRequest");
            if (r2 == null) goto L5;
            Object r3 = r2.getUserPermission();
        L7:
            if (Intrinsics.areEqual(r1.getOperation(), "CONTENT_COPY") == true) goto L9;
        L15:
            return false;
        L9:
            if ((r3 instanceof IDocUserPermission) == false) goto L15;
            if (((IDocUserPermission) r3).isCopyAuthByKp() == false) goto L15;
            if (com.bytedance.ee.bear.middleground.permission.b.a() == false) goto L15;
            return true;
        L5:
            r3 = null;
            goto L7
        }

        public static void e(PermissionRequest r1, PermissionResponse r2) {
            Intrinsics.checkNotNullParameter(r1, "request");
            Intrinsics.checkNotNullParameter(r2, "response");
            com.bytedance.ee.bear.middleground.permission.c.E(c(r1, r2));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            tt5.a.d("PermSdkUtils", "reportSdkCheckResult " + th.getMessage());
        }

        public static String b(String r4, String r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.OPT);
            int r2 = e.a;
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.OPT);
            long r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            if (r6 == (-900099004)) goto L12;
            switch(r6) {
                case 900099001: goto L19;
                case 900099002: goto L18;
                case 900099003: goto L17;
                case 900099004: goto L16;
                default: goto L21;
            };
        L21:
            return "";
        L16:
            return UIHelper.getString(2131889029);
        L17:
            return UIHelper.getString(2131889027);
        L18:
            return UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r0 + "");
        L19:
            return UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r0 + "");
        L12:
            if ("CCM_CONTENT_COPY".equals(r5) == false) goto L15;
            return UIHelper.getString(2131889023);
        L15:
            return UIHelper.getString(2131889029);
        }
    }

    static {
    }

    public f() {
    }

    @Override // ph5.c
    public final FileBizDomain a(BizDomain r2) {
        Intrinsics.checkNotNullParameter(r2, "domain");
        return a.a(r2);
    }

    @Override // ph5.c
    public final PermissionRequest b(String r5) {
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.OPT);
        return new PermissionRequest(new BaseEntity("", sbb.e.e, BizDomain.FileBizDomainCCM, ""), r5);
    }

    @Override // ph5.c
    public final String c(int r1) {
        return a.g(r1);
    }

    @Override // ph5.c
    public final boolean d(PermissionResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "permissionResponse");
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.d(r2);
    }

    @Override // ph5.c
    public final boolean e(PermissionResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "permissionResponse");
        if (UiType.DISABLED == r2.getDenySource().getUiType()) goto L5;
        return true;
    L5:
        return false;
    }
}
