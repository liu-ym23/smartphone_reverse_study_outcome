package a55;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.module.dependency.StringResDef;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.RenderItem;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.ArrayList;
import jg5.k;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements a55.b, m85.a {
    public ViewOwner a;
    public final z b;

    /* JADX INFO: renamed from: a55.a$a, reason: collision with other inner class name */
    public static final class C0002a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StringResDef.values().length];
            r0[StringResDef.Doc_Comment_CopyFailed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[StringResDef.DLP_CHECKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[StringResDef.DLP_SENSATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // m85.a
    public final String getReleaseKey() {
        return "DriveContextMenuItemClickProxy";
    }

    @Override // m85.a
    public final void onRelease() {
        tt5.a.h("DriveContextMenuItemClickProxy", "onRelease()...");
        this.a = null;
    }

    public final void a(boolean r13) {
        tt5.a.h("DriveContextMenuItemClickProxy", "doAuditCopy() isCopySuccess=" + r13);
        ViewOwner r0 = this.a;
        if (r0 == null) goto L5;
        DriveViewModel r1 = (DriveViewModel) r0.viewModel(DriveViewModel.class);
    L6:
        if (r1 == null) goto L8;
        boolean r2 = r1.isTypeWiki();
    L9:
        if (r1 == null) goto L11;
        WikiInfo r3 = r1.getWikiInfo();
    L12:
        ArrayList r10 = new ArrayList();
        r10.add(new RenderItem.Builder().Key("content_type").Value("text").build());
        if (r3 == null) goto L15;
        String r4 = r3.getWikiToken();
    L16:
        if (r3 == null) goto L18;
        String r5 = r3.getSpaceId();
    L19:
        dj5.a r9 = new dj5.a(r4, r5, null, 28);
        if (r1 == null) goto L24;
        BaseOpenEntity r6 = r1.getOpenEntity();
        if (r6 == null) goto L24;
        HostDocumentInfo r7 = r6.getHostDocumentInfo();
    L25:
        int r8 = 12;
        if (r7 != null) goto L47;
        if (r1 == null) goto L29;
        c r11 = r1.getIFileModel();
    L30:
        HostDocumentInfo r12 = new HostDocumentInfo();
        if (r11 == null) goto L34;
        String r14 = r11.getFileToken();
        if (r14 == null) goto L34;
    L35:
        r12.setObjToken(r14);
        r12.setType(12);
        if (r1 == null) goto L40;
        BaseOpenEntity r16 = r1.getOpenEntity();
        if (r16 == null) goto L40;
        String r17 = r16.getFileName();
    L41:
        r12.setTitle(r17);
        if (r11 == null) goto L45;
        String r18 = r11.a();
        if (r18 == null) goto L45;
    L46:
        r12.setCreatorTenantId(r18);
    L48:
        com.bytedance.ee.bear.middleground_permission_export.model.c r19 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        if (r3 == null) goto L51;
        r8 = r3.getObjType();
    L51:
        e r20 = e.d(r8);
        if (r2 == false) goto L54;
        ContainerType r21 = ContainerType.Wiki;
    L55:
        if (r2 == false) goto L61;
        if (r3 == null) goto L61;
        String r22 = r3.getWikiToken();
        if (r22 == null) goto L61;
        String r23 = r22;
    L62:
        r19.f(r20, r12, r21, r23, r9, r10, Boolean.valueOf(!r13));
        return;
    L61:
        r23 = "";
        goto L62
    L54:
        r21 = ContainerType.ContainerTypeUnknown;
    L45:
        r18 = "";
    L40:
        r17 = null;
    L34:
        r14 = "";
        goto L35
    L29:
        r11 = null;
        goto L30
    L47:
        r12 = r7;
    L24:
        r7 = null;
        goto L25
    L18:
        r5 = null;
        goto L19
    L15:
        r4 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = false;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public a(ViewOwner r1, z r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean b(int r26, boolean r27, int r28, Context r29, String r210, PointValue r30) {
        int r2 = 1;
        switch(r26) {
            case 16908320: goto L6;
            case 16908321: goto L6;
            default: goto L76;
        };
    L76:
        return true;
    L6:
        if (r30 != null) goto L8;
    L11:
        ViewOwner r4 = this.a;
        if (r4 == null) goto L22;
        u55.b r5 = (u55.b) ((DriveMGPermissionVM) r4.viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r5 == null) goto L20;
        DocPermission r6 = r5.b;
        if (r6 == null) goto L20;
        IDocUserPermission r7 = r6.a;
        if (r7 == null) goto L20;
        boolean r8 = r7.isCopyAuthByLeader();
    L21:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        k.a.a.d(r8, r27);
    L20:
        r8 = false;
    L22:
        z r9 = this.b;
        if (r9 == null) goto L76;
        if (TextUtils.isEmpty(r9.o) == true) goto L76;
        String r10 = this.b.t;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        String r11 = "";
        if (jg5.e.a.a.g() == false) goto L46;
        s55.a r12 = s55.a.a;
        String r13 = this.b.o;
        Application r14 = eu5.b.a;
        if (r210 != null) goto L31;
        String r16 = "";
    L32:
        boolean r17 = s55.a.l(r12, "CONTENT_COPY", r10, r13, r14, r16, null, null, null, null, 992);
        if (r17 == false) goto L40;
        int r0 = t55.b.a;
        if (r30 == null) goto L38;
        r2 = r30.getPoint();
    L38:
        if (t55.b.a(r2) == false) goto L40;
        return false;
    L40:
        tt5.a.h("DriveContextMenuItemClickProxy", "reportAuditCopy() isCopySuccess=" + r17);
        a(r17);     // Catch: Exception -> L43
    L45:
        return r17;
    L43:
        e = move-exception;
        tt5.a.e("DriveContextMenuItemClickProxy", "reportAuditCopy() error", e, false);
        goto L45
    L31:
        r16 = r210;
        goto L32
    L46:
        FileBizDomain r3 = pw4.b.d(r10);
        if (Intrinsics.areEqual(r10, "calendar") == false) goto L49;
        r3 = FileBizDomain.FileBizDomainCCM;
    L49:
        gj5.c r18 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(pw4.b.b(r10), r3, pw4.b.f(this.b.t), this.b.o);
        if (r18.a == true) goto L53;
        s55.e r1 = new s55.e(null, null, 0, r10, this.b.o, null, null, null, null, null, null, null, null, null, 32743);
        s55.a r19 = s55.a.a;
        s55.a.n(r18, 2131887246, pw4.b.b(r10), r1);
        return false;
    L53:
        String r20 = ((d) org.koin.java.a.c(d.class, null, null, 6)).f("", "CCM_CONTENT_COPY", r28);
        if (r29 != null) goto L56;
        Context r21 = eu5.b.a;
    L57:
        Intrinsics.checkNotNull(r21);
        StringResDef r22 = StringResDef.Doc_Comment_CopyFailed;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "stringResDef");
        int r23 = b.a[r22.ordinal()];
        if (r23 != 1) goto L60;
        r11 = r21.getString(2131887613);
    L68:
        if (TextUtils.isEmpty(r20) == true) goto L71;
        if (r28 == 0) goto L71;
    L72:
        if (r29 != null) goto L74;
        Context r24 = eu5.b.a;
    L75:
        Toast.showFailureText(r24, r20, 0);
        goto L76
    L74:
        r24 = r29;
    L71:
        r20 = r11;
        goto L72
    L60:
        if (r23 != 2) goto L62;
        r11 = r21.getString(2131889028);
        goto L68
    L62:
        if (r23 != 3) goto L68;
        r11 = r21.getString(2131889029);
        goto L68
    L56:
        r21 = r29;
        goto L57
    L8:
        if (r30.isEscaped() == false) goto L11;
        tt5.a.h("DriveContextMenuItemClickProxy", "escaped");
        return true;
    }
}
