package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class b {
    public static final /* synthetic */ int f = 0;
    public final FragmentActivity a;
    public final e65.a b;
    public final com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b c;
    public final com.bytedance.ee.bear.widgets.a d;
    public final Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> e;

    public static final class a {
    }

    static {
    }

    public final void d() {
        BaseOpenEntity r1 = this.b.a;
        if ((r1 instanceof BaseSpaceOpenEntity) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
        BaseSpaceOpenEntity r2 = (BaseSpaceOpenEntity) r1;
        SaveToSpaceMenu r3 = (SaveToSpaceMenu) e(r2.getMoreMenuActions(), SaveToSpaceMenu.class);
        if (r3 != null) goto L8;
    L11:
        if (r3 == null) goto L15;
        h(SaveToSpaceMenu.class, new h(this));
        return;
    L15:
        if (Intrinsics.areEqual(r2.getMountPoint(), "calendar") == false) goto L17;
        s55.e r4 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 0, "docx_file", r2.getFileId(), null, sbb.e.l, FileBizDomain.FileBizDomainCALENDAR, "CCM_FILE_SAVE", "FILE", null, null, null, null, 31780);
    L18:
        boolean r5 = s55.a.a.i(r4);
        int r6 = a95.a.d;
        if (ex4.a.a(a95.a.b.a(null).c) == false) goto L21;
        int r7 = 2131889592;
    L22:
        com.bytedance.ee.bear.widgets.a r8 = this.d;
        String r9 = this.a.getResources().getString(r7);
        if (r5 == false) goto L25;
        float r10 = 1.0f;
    L26:
        i r11 = new i(this);
        cp5.b r12 = new cp5.b();
        r12.a = r9;
        r12.d = false;
        r12.e = null;
        r12.f = r11;
        r12.c = false;
        r12.b = -1;
        r12.g = true;
        r12.h = r10;
        r12.i = true;
        r8.f(r12);
        return;
    L25:
        r10 = 0.3f;
        goto L26
    L21:
        r7 = 2131888793;
        goto L22
    L17:
        r4 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 0, "docx_file", r2.getFileId(), null, null, null, null, null, null, null, null, null, 32740);
        goto L18
    L8:
        if (r3.k == true) goto L11;
        tt5.a.h("DriveComponent", "buildSaveToSpaceMenuItemForSpaceFile() is not visible, ignore add menu");
    }

    public static boolean i(BaseMoreMenuAction r1) {
        Intrinsics.checkNotNullParameter(r1, "menuAction");
        if ((r1 instanceof DownloadMenu) == false) goto L5;
        return true;
    L5:
        if ((r1 instanceof SaveToLocalMenu) == false) goto L7;
        return true;
    L7:
        if ((r1 instanceof SaveToLocalMenuV2) == false) goto L9;
        return true;
    L9:
        if ((r1 instanceof OpenExternalMenu) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void c(a95.a r21) {
        Intrinsics.checkNotNullParameter(r21, "userComponentAbility");
        if (e(this.b.a.getMoreMenuActions(), OpenExternalMenu.class) == null) goto L6;
        h(OpenExternalMenu.class, new f(this, r21));
        return;
    L6:
        BaseOpenEntity r2 = this.b.a;
        s55.e r16 = new s55.e("DOWNLOAD", PermissionOperation.DOWNLOAD, 0, r2.getMountPoint(), r2.getFileId(), null, sbb.e.l, null, null, null, null, null, null, null, 32676);
        boolean r3 = s55.a.a.i(r16);
        com.bytedance.ee.bear.widgets.a r4 = this.d;
        CharSequence r5 = this.a.getText(2131888429);
        if (r3 == false) goto L9;
        float r6 = 1.0f;
    L10:
        g r7 = new g(this, r21);
        cp5.b r1 = new cp5.b();
        r1.a = r5;
        r1.d = false;
        r1.e = null;
        r1.f = r7;
        r1.c = false;
        r1.b = -1;
        r1.g = true;
        r1.h = r6;
        r1.i = true;
        r4.f(r1);
        return;
    L9:
        r6 = 0.3f;
        goto L10
    }

    public void f(BaseMoreMenuAction r5) {
        Intrinsics.checkNotNullParameter(r5, "menuAction");
        int r0 = w.a;
        CompositeDisposable r1 = this.c.a;
        FragmentActivity r2 = this.a;
        Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> r3 = this.e;
        HashMap r4 = (HashMap) r3;
        w.a.a(r1, r2, r5, (com.bytedance.ee.bear.drive.biz.preview.more.a) r4.get(r5.getClass()));
    }

    public void g(BaseMoreMenuAction r5) {
        Intrinsics.checkNotNullParameter(r5, "menuAction");
        if ((r5 instanceof DownloadMenu) == false) goto L5;
    L10:
        int r0 = w.a;
        CompositeDisposable r1 = this.c.a;
        FragmentActivity r2 = this.a;
        Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> r3 = this.e;
        HashMap r4 = (HashMap) r3;
        w.a.a(r1, r2, r5, (com.bytedance.ee.bear.drive.biz.preview.more.a) r4.get(r5.getClass()));
        return;
    L5:
        if ((r5 instanceof SaveToLocalMenu) == true) goto L10;
        if ((r5 instanceof SaveToLocalMenuV2) == true) goto L10;
        int r6 = w.a;
        CompositeDisposable r7 = this.c.a;
        Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> r8 = this.e;
        HashMap r9 = (HashMap) r8;
        w.a.b(r7, r5, (com.bytedance.ee.bear.drive.biz.preview.more.a) r9.get(r5.getClass()));
    }

    public static final void b(b r36, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r37) {
        BaseOpenEntity r2 = r36.b.a;
        if (Intrinsics.areEqual(r2.getMountPoint(), "calendar") == false) goto L5;
        s55.e r3 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 2131887246, "docx_file", r2.getFileId(), null, sbb.e.l, FileBizDomain.FileBizDomainCALENDAR, "CCM_FILE_SAVE", "FILE", null, null, null, null, 31776);
    L7:
        if (s55.a.a.k(r3, r36.a) == true) goto L9;
        tt5.a.h("DriveAttachmentMoreMenuCreator", "handlePermissionUiAction return false");
        return;
    L9:
        w75.a r6 = null;
        DriveSpaceFileAttachmentExecutor r4 = new DriveSpaceFileAttachmentExecutor((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        r36.c.a.add(r4.a(r36.b.a.getFileId(), r36.b.a.getMountPoint(), r36.b.b.getFileName(), r36.b.a.getApiExtra()).subscribe(new m(r36, r37), new n(r36, r2, r37)));
        com.bytedance.ee.bear.drive.report.c r1 = o75.b.a().Ke();
        w75.c r0 = r36.b.b.getIFileModel();
        if (r0 == null) goto L12;
        r6 = r0.getDetails();
    L12:
        r1.n(r6, "save_to_drive", "none");
        return;
    L5:
        r3 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 2131887246, "docx_file", r2.getFileId(), null, null, null, null, null, null, null, null, null, 32736);
        goto L7
    }

    public static BaseMoreMenuAction e(List r3, Class r4) {
        if (r3 == null) goto L12;
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r1 = r5.next();
        if (r4.isInstance((BaseMoreMenuAction) r1) == false) goto L6;
    L11:
        BaseMoreMenuAction r2 = (BaseMoreMenuAction) r1;
    L13:
        if (r2 != null) goto L16;
        return null;
    L16:
        return r2;
    L10:
        r1 = null;
        goto L11
    L12:
        r2 = null;
        goto L13
    }

    public final void h(Class r2, com.bytedance.ee.bear.drive.biz.preview.more.a r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        ((HashMap) this.e).put(r2, r3);
    }

    public b(FragmentActivity r8, e65.a r9, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "menuContext");
        Intrinsics.checkNotNullParameter(r10, "actionContext");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = new com.bytedance.ee.bear.widgets.a(r8);
        this.e = new HashMap();
        if (hu5.a.d(r9.a.getMoreMenuActions()) == true) goto L37;
        BaseOpenEntity r11 = r9.a;
        Iterator<BaseMoreMenuAction> r12 = r11.getMoreMenuActions().iterator();
    L7:
        if (r12.hasNext() == false) goto L48;
        BaseMoreMenuAction r13 = r12.next();
        if (r13.c == 0) goto L10;
        if (r13.k == false) goto L36;
        if (r13.l == false) goto L36;
        r13.g = this.b.a;
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = r13.e();
        if ((r13 instanceof SaveToSpaceMenu) == true) goto L19;
    L21:
        int r1 = r13.c;
        if (r1 != 2131888449) goto L27;
        int r2 = a95.a.d;
        if (ex4.a.a(a95.a.b.a(null).c) == false) goto L26;
        r1 = 2131889592;
        goto L27
    L26:
        r1 = 2131888793;
    L27:
        CharSequence r3 = this.a.getText(r1);
        if (r0.element == false) goto L30;
        float r4 = 1.0f;
    L31:
        e r5 = new e(r11, this, r13, r0);
        if (r13.d <= 0) goto L34;
        int r14 = this.a.getResources().getColor(r13.d);
    L35:
        com.bytedance.ee.bear.widgets.a r6 = this.d;
        cp5.b r7 = new cp5.b();
        r7.a = r3;
        r7.d = false;
        r7.e = null;
        r7.f = r5;
        r7.c = false;
        r7.b = r14;
        r7.g = true;
        r7.h = r4;
        r7.i = true;
        r6.f(r7);
        goto L7
    L34:
        r14 = -1;
        goto L35
    L30:
        r4 = 0.3f;
        goto L31
    L19:
        if (((SaveToSpaceMenu) r13).n != true) goto L21;
        r0.element = true;
    L36:
        tt5.a.k("DriveSdk", "initMenuActions menuAction not isVisible!!!, class=" + r13.getClass() + ", isAddByDefault=" + r13.l);
        goto L7
    L10:
        tt5.a.d("DriveSdk", "initMenuActions menuAction name empty!!!, class=" + r13.getClass());
        goto L7
    L48:
        return;
    }

    public static final void a(b r21, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r22, a95.a r23) {
        BaseOpenEntity r2 = r21.b.a;
        PermissionOperation r5 = PermissionOperation.DOWNLOAD;
        String r7 = r2.getMountPoint();
        String r8 = r2.getFileId();
        sbb.e r14 = sbb.e.l;
        if (s55.a.a.k(new s55.e("DOWNLOAD", r5, 2131887246, r7, r8, null, r14, null, null, null, null, null, null, null, 32672), r21.a) == true) goto L5;
        tt5.a.h("DriveAttachmentMoreMenuCreator", "handlePermissionUiAction return false");
        return;
    L5:
        w75.a r4 = null;
        com.bytedance.ee.bear.middleground_permission_export.model.c r6 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        String r9 = r2.getFileId();
        boolean r10 = true;
        if (CipherManager.d() != 1) goto L9;
        r10 = false;
    L9:
        r6.m(null, r9, Boolean.FALSE, null, Boolean.valueOf(r10));
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(r14.b, r2.getFileId(), "open_with_other_app");
        com.bytedance.ee.bear.drive.biz.external.f r3 = com.bytedance.ee.bear.drive.biz.external.f.e(r21.b.b.getBizType(), r21.a, r23);
        r3.o = new j(r22, r21);
        r3.a = new k(r2);
        w75.c r0 = r21.b.b.getIFileModel();
        com.bytedance.ee.bear.drive.biz.external.a.C0122a r11 = new com.bytedance.ee.bear.drive.biz.external.a.C0122a();
        if (r0 == null) goto L12;
        long r12 = r0.getFileSize();
    L13:
        r11.b = r12;
        r11.a = r2.getFileId();
        r11.c = r2.getApiExtra();
        r11.d = r2.getMountPoint();
        r11.e = "from_docs_attachment_preview_download";
        r11.f = r2.getBizScene();
        r11.g = r2.getWatermarkScene();
        com.bytedance.ee.bear.drive.biz.external.a r13 = new com.bytedance.ee.bear.drive.biz.external.a(r11);
        BaseMoreMenuAction r1 = r22.a;
        if (r1 == null) goto L16;
        String r16 = r1.m;
    L17:
        r3.g(r13, null, r16);
        com.bytedance.ee.bear.drive.report.c r17 = o75.b.a().Ke();
        if (r0 == null) goto L20;
        r4 = r0.getDetails();
    L20:
        r17.n(r4, "open_in_other_apps", "none");
        return;
    L16:
        r16 = null;
        goto L17
    L12:
        r12 = 0;
        goto L13
    }
}
