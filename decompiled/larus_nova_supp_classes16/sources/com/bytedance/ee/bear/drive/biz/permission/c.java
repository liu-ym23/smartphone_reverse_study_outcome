package com.bytedance.ee.bear.drive.biz.permission;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jdb.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        public static void c(FragmentManager r13, int r14, boolean r16, String r17, Boolean r18, boolean r19, int r110) {
            int r0 = c.a;
            if ((r110 & 2) == 0) goto L5;
            int r6 = -1;
        L7:
            if ((r110 & 4) == 0) goto L9;
            boolean r7 = true;
        L11:
            if ((r110 & 32) == 0) goto L13;
            boolean r11 = false;
        L15:
            if ((r110 & 64) == 0) goto L17;
            int r12 = -1;
        L18:
            Intrinsics.checkNotNullParameter(r13, "fm");
            a(r13, false, "", "", r6, r7, r17, r18, "", r11, r12);
            return;
        L17:
            r12 = 0;
            goto L18
        L13:
            r11 = r19;
            goto L15
        L9:
            r7 = r16;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }

        @JvmStatic
        public static void b(AbsDrivePlugin r23, FragmentManager r24, u55.b r26, Runnable r27, int r28, boolean r29, String r210, boolean r30) {
            Intrinsics.checkNotNullParameter(r23, "fromPlugin");
            Intrinsics.checkNotNullParameter(r24, "fm");
            Intrinsics.checkNotNullParameter(r26, "permission");
            int r13 = r26.f();
            OwnerInfo r2 = r26.b.a.getOwnerInfo();
            int r16 = r26.g();
            String r14 = null;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            jg5.e r3 = jg5.e.a.a;
            boolean r5 = r3.d();
            if (r13 != 10016) goto L6;
            String r6 = r26.a;
            tt5.a.h("DriveNoPerm", "showRequestPasswordView");
            ((zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6)).d6(r24, r6, 12, r28, r29, r27);
            return;
        L6:
            if (r26.k() == false) goto L8;
        L9:
            if (r5 == false) goto L20;
            if (r16 != 2004) goto L20;
        L11:
            if (r16 != 2004) goto L13;
            int r7 = 2131889026;
        L14:
            String r0 = r26.a;
            tt5.a.h("DriveNoPerm", "showForbiddenView");
            zt5.a r4 = (zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6);
            if (r0 != null) goto L17;
            String r10 = "";
        L18:
            r4.Q2(r24, r28, r7, false, -1, r29, r10, 12, r210, r30, false, "", "forbidden", "", false, true, false, r16);
            return;
        L17:
            r10 = r0;
            goto L18
        L13:
            r7 = 2131889741;
        L20:
            if (r26.b.a.isSecretFileView() == true) goto L22;
        L23:
            if (r13 != 10046) goto L27;
        L24:
            if (r13 != 10046) goto L26;
            Toast.showFailureText(eu5.b.a, 2131889706);
        L26:
            a(r24, false, "", "", r28, r29, r210, Boolean.valueOf(r30), "", r26.h(), r13);
            return;
        L27:
            if (r2 == null) goto L35;
            if (r2.isCan_apply_perm() == false) goto L35;
            if (r2.isAdmin_can_cross() == false) goto L35;
            String r8 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r2.getDisplay_name(), r2.getName(), r2.getEn_name());
            Intrinsics.checkNotNull(r8);
            a(r24, true, r8, r26.a, r28, r29, r210, Boolean.valueOf(r30), r2.getId(), false, -1);
            return;
        L35:
            if (r26.b.a.isConditionAccessControl() == false) goto L38;
            boolean r9 = false;
            int r17 = ImportResult.STATUS_SHEET_IMPORT_EXCEED_IMAGE_LIMIT;
        L49:
            a(r24, r9, "", "", r28, r29, r210, Boolean.valueOf(r30), "", r26.h(), r17);
            if (r26.b.a.isCacViewControl() == false) goto L82;
            DrivePluginHost r11 = r23.getHost();
            if (r11 == null) goto L60;
            vo5.a r12 = r11.getUserComponent();
            if (r12 == null) goto L60;
            dn4.a r18 = (dn4.a) r12.a(dn4.a.class);
            if (r18 == null) goto L60;
            g r19 = r18.a();
            if (r19 == null) goto L60;
            boolean r20 = r19.isEnable("ccm.doc.cac_check_device");
        L61:
            if (r20 == true) goto L63;
            tt5.a.h("DriveNoPerm", "checkCacAsync, disabled by FG.");
            return;
        L63:
            String r21 = r26.a;
            tt5.a.h("DriveNoPerm", "checkCacAsync, token: " + r21);
            if (r21 == null) goto L84;
            gj5.b r22 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r31 = FileBizDomain.FileBizDomainCCM;
            OwnerInfo r32 = r26.b.a.getOwnerInfo();
            if (r32 == null) goto L69;
            r14 = r32.getId();
        L69:
            String r33 = r14;
            OwnerInfo r1 = r26.b.a.getOwnerInfo();
            if (r1 == null) goto L75;
            String r34 = r1.getTenant_id();
            if (r34 == null) goto L75;
            String r110 = r34;
        L76:
            r22.a("CCM_FILE_PREVIEW", r31, 12, r21, -1L, r33, r110, CheckPriority.RemoteFirst, new b(r23, r21));
            return;
        L75:
            r110 = "";
            goto L76
        L84:
            return;
        L60:
            r20 = false;
            goto L61
        L82:
            return;
        L38:
            if (r26.b.a.isControlByDLPInnerControl() == false) goto L40;
            r9 = false;
            r17 = ImportResult.STATUS_SHEET_CELL_CONTENT_TOO_LONG;
            goto L49
        L40:
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (r3.g() == false) goto L45;
            s55.a r36 = s55.a.a;
            if (s55.a.m(r26.a, "VIEW", r26.b).getDenySource().getDenyType() != DenyType.AUDIT_CONTROL) goto L45;
            boolean r37 = true;
        L46:
            if (r37 == false) goto L48;
            r9 = true;
            r17 = VersionPayLoadData.STATE_DELETE;
            goto L49
        L48:
            r9 = false;
            r17 = -1;
        L45:
            r37 = false;
            goto L46
        L22:
            if (r13 == 10047) goto L24;
        L8:
            if (r13 == 10013) goto L11;
            goto L9
        }

        public static void a(FragmentManager r17, boolean r18, String r19, String r20, int r21, boolean r22, String r23, Boolean r24, String r26, boolean r27, int r28) {
            tt5.a.h("DriveNoPerm", "showNoPermissionView");
            ((zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6)).P7(r17, r21, r20, sbb.e.l, r19, r18, r22, r23, Intrinsics.areEqual(r24, Boolean.TRUE), false, "", r26, r27, r28, false, null);
        }
    }

    static {
        new a();
    }
}
