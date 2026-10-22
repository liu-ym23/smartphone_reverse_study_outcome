package yh5;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements ph5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567580a = 0;

    public static final class a {

        /* JADX INFO: renamed from: yh5.f$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C8342a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f567581a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f567582b = null;

            static {
                int[] r100 = new int[BizDomain.values().length];
                r100[BizDomain.FileBizDomainCCM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
            L61:
                r100[BizDomain.FileBizDomainIM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
            L65:
                r100[BizDomain.FileBizDomainMAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            L45:
                r100[BizDomain.FileBizDomainCALENDAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
            L47:
                r100[BizDomain.FileBizDomainTODO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
            L55:
                r100[BizDomain.FileBizDomainOPENPLATFORM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
            L14:
                f567581a = r100;
                int[] r101 = new int[DenyType.values().length];
                r101[DenyType.DLP_DETECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
            L51:
                r101[DenyType.DLP_SENSATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
            L57:
                r101[DenyType.ADMIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
            L63:
                r101[DenyType.FILE_STRATEGY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
            L39:
                r101[DenyType.USER_PERMISSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
            L49:
                r101[DenyType.TT_BLOCK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
            L59:
                r101[DenyType.AUDIT_CONTROL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
            L43:
                r101[DenyType.DEFAULT_NONE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
            L23:
                f567582b = r101;
            }
        }

        public static FileBizDomain a(BizDomain r100) {
            Intrinsics.checkNotNullParameter(r100, "bizDomain");
            FileBizDomain r101 = FileBizDomain.FileBizDomainUNKNOWN;
            switch(C8342a.f567581a[r100.ordinal()]) {
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

        public static void f(PermissionResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            PermissionRequest r101 = r100.getCacheReqRequest();     // Catch: Throwable -> L8
            if (r101 != null) goto L6;
            r101 = new PermissionRequest(new BaseEntity("", sbb.e.f541294e, BizDomain.FileBizDomainCCM, ""), "");     // Catch: Throwable -> L8
        L6:
            com.bytedance.ee.bear.middleground.permission.c.F(c(r101, r100));     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            tt5.a.d("PermSdkUtils", "reportSdkClickResult " + th.getMessage());
        }

        @EntityType
        public static String g(int r100) {
            if (r100 != sbb.e.f541296g.f541317b) goto L6;
        L32:
            return PreloadConfigModel.VERSION_CHECK_TYPE_DOC;
        L6:
            if (r100 != sbb.e.f541304o.f541317b) goto L9;
            return PreloadConfigModel.VERSION_CHECK_TYPE_DOCX;
        L9:
            if (r100 != sbb.e.f541297h.f541317b) goto L12;
            return "SHEET";
        L12:
            if (r100 != sbb.e.f541300k.f541317b) goto L15;
            return PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE;
        L15:
            if (r100 != sbb.e.f541301l.f541317b) goto L18;
            return "FILE";
        L18:
            if (r100 != sbb.e.f541298i.f541317b) goto L21;
            return "BITABLE";
        L21:
            if (r100 != sbb.e.f541295f.f541317b) goto L24;
            return "SPACE_CATALOG";
        L24:
            if (r100 != sbb.e.f541313x.f541317b) goto L27;
            return "IM_MSG_FILE";
        L27:
            if (r100 != sbb.e.f541302m.f541317b) goto L30;
            return "SLIDES";
        L30:
            if (r100 != sbb.e.f541306q.f541317b) goto L32;
            return "MeetingMinutes";
        }

        public static PermissionReportInfo c(PermissionRequest r100, PermissionResponse r101) {
            PermissionReportInfo r102 = new PermissionReportInfo();
            r102.setAllow(r101.getAllow());
            BizDomain r103 = r100.getBaseEntity().getDomain();
            if (r103 == null) goto L6;
            String r104 = r103.getBiz();
            if (r104 == null) goto L6;
        L7:
            r102.setDomain(r104);
            sbb.e r105 = r100.getBaseEntity().getType();
            if (r105 == null) goto L11;
            String r106 = r105.getType();
            if (r106 == null) goto L11;
        L12:
            r102.setType(r106);
            r102.setOperation(r100.getOperation());
            r102.setHasNet(com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a());
            DenyType r107 = r101.getDenySource().getDenyType();
            switch(C8342a.f567582b[r107.ordinal()]) {
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
            String r108 = "AUDIT_CONTROL";
        L23:
            r102.setBlockType(r108);
            return r102;
        L16:
            r108 = "TT_BLOCK";
            goto L23
        L17:
            r108 = "USER_PERMISSION";
            goto L23
        L18:
            r108 = "FILE_STRATEGY";
            goto L23
        L19:
            r108 = "ADMIN";
            goto L23
        L20:
            r108 = "DLP_SENSITIVE";
            goto L23
        L21:
            r108 = "DLP_DETECTING";
            goto L23
        L22:
            r108 = "DEFAULT_NONE";
        L11:
            r106 = "unknown";
        L6:
            r104 = BizDomain.FileBizDomainCCM.getBiz();
            goto L7
        }

        public static boolean d(PermissionRequest r100, UserPermissionEntity r101) {
            Intrinsics.checkNotNullParameter(r100, "permissionRequest");
            if (r101 == null) goto L5;
            Object r102 = r101.getUserPermission();
        L7:
            if (Intrinsics.areEqual(r100.getOperation(), "CONTENT_COPY") == true) goto L9;
        L15:
            return false;
        L9:
            if ((r102 instanceof IDocUserPermission) == false) goto L15;
            if (((IDocUserPermission) r102).isCopyAuthByKp() == false) goto L15;
            if (com.bytedance.ee.bear.middleground.permission.b.a() == false) goto L15;
            return true;
        L5:
            r102 = null;
            goto L7
        }

        public static void e(PermissionRequest r100, PermissionResponse r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "response");
            com.bytedance.ee.bear.middleground.permission.c.E(c(r100, r101));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            tt5.a.d("PermSdkUtils", "reportSdkCheckResult " + th.getMessage());
        }

        public static String b(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
            int r103 = e.f567579a;
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
            long r104 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            if (r102 == (-900099004)) goto L12;
            switch(r102) {
                case 900099001: goto L19;
                case 900099002: goto L18;
                case 900099003: goto L17;
                case 900099004: goto L16;
                default: goto L21;
            };
        L21:
            return "";
        L16:
            return UIHelper.getString(R.string.LarkCCM_Docs_DLP_Toast_ActionFailed);
        L17:
            return UIHelper.getString(R.string.LarkCCM_Docs_DLP_SensitiveInfo_ActionFailed);
        L18:
            return UIHelper.mustacheFormat(R.string.LarkCCM_Docs_DLP_SystemChecking_Mob, "number", r104 + "");
        L19:
            return UIHelper.mustacheFormat(R.string.LarkCCM_Docs_DLP_SystemChecking_Mob, "number", r104 + "");
        L12:
            if ("CCM_CONTENT_COPY".equals(r101) == false) goto L15;
            return UIHelper.getString(R.string.LarkCCM_Docs_DLP_CopyFailed_Toast);
        L15:
            return UIHelper.getString(R.string.LarkCCM_Docs_DLP_Toast_ActionFailed);
        }
    }

    static {
    }

    public f() {
    }

    @Override // ph5.c
    public final FileBizDomain a(BizDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        return a.a(r100);
    }

    @Override // ph5.c
    public final PermissionRequest b(String r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        return new PermissionRequest(new BaseEntity("", sbb.e.f541294e, BizDomain.FileBizDomainCCM, ""), r100);
    }

    @Override // ph5.c
    public final String c(int r100) {
        return a.g(r100);
    }

    @Override // ph5.c
    public final boolean d(PermissionResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionResponse");
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.d(r100);
    }

    @Override // ph5.c
    public final boolean e(PermissionResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionResponse");
        if (UiType.DISABLED == r100.getDenySource().getUiType()) goto L5;
        return true;
    L5:
        return false;
    }
}
