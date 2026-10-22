package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.larus.nova.R;
import com.ss.android.download.api.config.HttpMethod;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f223476f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f223477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e65.a f223478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b f223479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.widgets.a f223480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> f223481e;

    public static final class a {
    }

    static {
    }

    public final void d() {
        BaseOpenEntity r100 = this.f223478b.f471138a;
        if ((r100 instanceof BaseSpaceOpenEntity) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
        BaseSpaceOpenEntity r101 = (BaseSpaceOpenEntity) r100;
        SaveToSpaceMenu r102 = (SaveToSpaceMenu) e(r101.getMoreMenuActions(), SaveToSpaceMenu.class);
        if (r102 != null) goto L8;
    L11:
        if (r102 == null) goto L15;
        h(SaveToSpaceMenu.class, new h(this));
        return;
    L15:
        if (Intrinsics.areEqual(r101.getMountPoint(), "calendar") == false) goto L17;
        s55.e r103 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 0, "docx_file", r101.getFileId(), null, sbb.e.f541301l, FileBizDomain.FileBizDomainCALENDAR, "CCM_FILE_SAVE", "FILE", null, null, null, null, 31780);
    L18:
        boolean r104 = s55.a.f540731a.i(r103);
        int r105 = a95.a.f2276d;
        if (ex4.a.a(a95.a.b.a(null).f2279c) == false) goto L21;
        int r106 = R.string.LarkCCM_NewCM_Drive_SaveToDrive_Button;
    L22:
        com.bytedance.ee.bear.widgets.a r107 = this.f223480d;
        String r108 = this.f223477a.getResources().getString(r106);
        if (r104 == false) goto L25;
        float r109 = 1.0f;
    L26:
        i r110 = new i(this);
        cp5.b r111 = new cp5.b();
        r111.f464689a = r108;
        r111.f464692d = false;
        r111.f464693e = null;
        r111.f464694f = r110;
        r111.f464691c = false;
        r111.f464690b = -1;
        r111.f464695g = true;
        r111.f464696h = r109;
        r111.f464697i = true;
        r107.f(r111);
        return;
    L25:
        r109 = 0.3f;
        goto L26
    L21:
        r106 = R.string.LarkCCM_CM_MySpace_SaveToMySpace_Button;
        goto L22
    L17:
        r103 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 0, "docx_file", r101.getFileId(), null, null, null, null, null, null, null, null, null, 32740);
        goto L18
    L8:
        if (r102.f217014k == true) goto L11;
        tt5.a.h("DriveComponent", "buildSaveToSpaceMenuItemForSpaceFile() is not visible, ignore add menu");
    }

    public static boolean i(BaseMoreMenuAction r100) {
        Intrinsics.checkNotNullParameter(r100, "menuAction");
        if ((r100 instanceof DownloadMenu) == false) goto L5;
        return true;
    L5:
        if ((r100 instanceof SaveToLocalMenu) == false) goto L7;
        return true;
    L7:
        if ((r100 instanceof SaveToLocalMenuV2) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof OpenExternalMenu) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void c(a95.a r210) {
        Intrinsics.checkNotNullParameter(r210, "userComponentAbility");
        if (e(this.f223478b.f471138a.getMoreMenuActions(), OpenExternalMenu.class) == null) goto L6;
        h(OpenExternalMenu.class, new f(this, r210));
        return;
    L6:
        BaseOpenEntity r100 = this.f223478b.f471138a;
        s55.e r110 = new s55.e(HttpMethod.DOWNLOAD, PermissionOperation.DOWNLOAD, 0, r100.getMountPoint(), r100.getFileId(), null, sbb.e.f541301l, null, null, null, null, null, null, null, 32676);
        boolean r101 = s55.a.f540731a.i(r110);
        com.bytedance.ee.bear.widgets.a r102 = this.f223480d;
        CharSequence r103 = this.f223477a.getText(R.string.Drive_Drive_OpenWithOtherApps);
        if (r101 == false) goto L9;
        float r104 = 1.0f;
    L10:
        g r105 = new g(this, r210);
        cp5.b r106 = new cp5.b();
        r106.f464689a = r103;
        r106.f464692d = false;
        r106.f464693e = null;
        r106.f464694f = r105;
        r106.f464691c = false;
        r106.f464690b = -1;
        r106.f464695g = true;
        r106.f464696h = r104;
        r106.f464697i = true;
        r102.f(r106);
        return;
    L9:
        r104 = 0.3f;
        goto L10
    }

    public void f(BaseMoreMenuAction r100) {
        Intrinsics.checkNotNullParameter(r100, "menuAction");
        int r101 = w.f223656a;
        CompositeDisposable r102 = this.f223479c.f217024a;
        FragmentActivity r103 = this.f223477a;
        Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> r104 = this.f223481e;
        HashMap r105 = (HashMap) r104;
        w.a.a(r102, r103, r100, (com.bytedance.ee.bear.drive.biz.preview.more.a) r105.get(r100.getClass()));
    }

    public void g(BaseMoreMenuAction r100) {
        Intrinsics.checkNotNullParameter(r100, "menuAction");
        if ((r100 instanceof DownloadMenu) == false) goto L5;
    L10:
        int r101 = w.f223656a;
        CompositeDisposable r102 = this.f223479c.f217024a;
        FragmentActivity r103 = this.f223477a;
        Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> r104 = this.f223481e;
        HashMap r105 = (HashMap) r104;
        w.a.a(r102, r103, r100, (com.bytedance.ee.bear.drive.biz.preview.more.a) r105.get(r100.getClass()));
        return;
    L5:
        if ((r100 instanceof SaveToLocalMenu) == true) goto L10;
        if ((r100 instanceof SaveToLocalMenuV2) == true) goto L10;
        int r106 = w.f223656a;
        CompositeDisposable r107 = this.f223479c.f217024a;
        Map<Class<? extends BaseMoreMenuAction>, com.bytedance.ee.bear.drive.biz.preview.more.a> r108 = this.f223481e;
        HashMap r109 = (HashMap) r108;
        w.a.b(r107, r100, (com.bytedance.ee.bear.drive.biz.preview.more.a) r109.get(r100.getClass()));
    }

    public static final void b(b r310, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r311) {
        BaseOpenEntity r100 = r310.f223478b.f471138a;
        if (Intrinsics.areEqual(r100.getMountPoint(), "calendar") == false) goto L5;
        s55.e r101 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, R.string.CreationMobile_ECM_AdminDisableToast, "docx_file", r100.getFileId(), null, sbb.e.f541301l, FileBizDomain.FileBizDomainCALENDAR, "CCM_FILE_SAVE", "FILE", null, null, null, null, 31776);
    L7:
        if (s55.a.f540731a.k(r101, r310.f223477a) == true) goto L9;
        tt5.a.h("DriveAttachmentMoreMenuCreator", "handlePermissionUiAction return false");
        return;
    L9:
        w75.a r102 = null;
        DriveSpaceFileAttachmentExecutor r103 = new DriveSpaceFileAttachmentExecutor((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        r310.f223479c.f217024a.add(r103.a(r310.f223478b.f471138a.getFileId(), r310.f223478b.f471138a.getMountPoint(), r310.f223478b.f471139b.getFileName(), r310.f223478b.f471138a.getApiExtra()).subscribe(new m(r310, r311), new n(r310, r100, r311)));
        com.bytedance.ee.bear.drive.report.c r104 = o75.b.a().Ke();
        w75.c r105 = r310.f223478b.f471139b.getIFileModel();
        if (r105 == null) goto L12;
        r102 = r105.getDetails();
    L12:
        r104.n(r102, "save_to_drive", "none");
        return;
    L5:
        r101 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, R.string.CreationMobile_ECM_AdminDisableToast, "docx_file", r100.getFileId(), null, null, null, null, null, null, null, null, null, 32736);
        goto L7
    }

    public static BaseMoreMenuAction e(List r100, Class r101) {
        if (r100 == null) goto L12;
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (r101.isInstance((BaseMoreMenuAction) r103) == false) goto L6;
    L11:
        BaseMoreMenuAction r104 = (BaseMoreMenuAction) r103;
    L13:
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104;
    L10:
        r103 = null;
        goto L11
    L12:
        r104 = null;
        goto L13
    }

    public final void h(Class r100, com.bytedance.ee.bear.drive.biz.preview.more.a r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "action");
        ((HashMap) this.f223481e).put(r100, r101);
    }

    public b(FragmentActivity r100, e65.a r101, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "menuContext");
        Intrinsics.checkNotNullParameter(r110, "actionContext");
        this.f223477a = r100;
        this.f223478b = r101;
        this.f223479c = r110;
        this.f223480d = new com.bytedance.ee.bear.widgets.a(r100);
        this.f223481e = new HashMap();
        if (hu5.a.d(r101.f471138a.getMoreMenuActions()) == true) goto L37;
        BaseOpenEntity r102 = r101.f471138a;
        Iterator<BaseMoreMenuAction> r103 = r102.getMoreMenuActions().iterator();
    L7:
        if (r103.hasNext() == false) goto L48;
        BaseMoreMenuAction r111 = r103.next();
        if (r111.f217006c == 0) goto L10;
        if (r111.f217014k == false) goto L36;
        if (r111.f217015l == false) goto L36;
        r111.f217010g = this.f223478b.f471138a;
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = r111.e();
        if ((r111 instanceof SaveToSpaceMenu) == true) goto L19;
    L21:
        int r105 = r111.f217006c;
        if (r105 != R.string.Drive_Drive_SaveToSpace) goto L27;
        int r106 = a95.a.f2276d;
        if (ex4.a.a(a95.a.b.a(null).f2279c) == false) goto L26;
        r105 = R.string.LarkCCM_NewCM_Drive_SaveToDrive_Button;
        goto L27
    L26:
        r105 = R.string.LarkCCM_CM_MySpace_SaveToMySpace_Button;
    L27:
        CharSequence r107 = this.f223477a.getText(r105);
        if (r104.element == false) goto L30;
        float r108 = 1.0f;
    L31:
        e r109 = new e(r102, this, r111, r104);
        if (r111.f217007d <= 0) goto L34;
        int r112 = this.f223477a.getResources().getColor(r111.f217007d);
    L35:
        com.bytedance.ee.bear.widgets.a r113 = this.f223480d;
        cp5.b r114 = new cp5.b();
        r114.f464689a = r107;
        r114.f464692d = false;
        r114.f464693e = null;
        r114.f464694f = r109;
        r114.f464691c = false;
        r114.f464690b = r112;
        r114.f464695g = true;
        r114.f464696h = r108;
        r114.f464697i = true;
        r113.f(r114);
        goto L7
    L34:
        r112 = -1;
        goto L35
    L30:
        r108 = 0.3f;
        goto L31
    L19:
        if (((SaveToSpaceMenu) r111).f226007n != true) goto L21;
        r104.element = true;
    L36:
        tt5.a.k("DriveSdk", "initMenuActions menuAction not isVisible!!!, class=" + r111.getClass() + ", isAddByDefault=" + r111.f217015l);
        goto L7
    L10:
        tt5.a.d("DriveSdk", "initMenuActions menuAction name empty!!!, class=" + r111.getClass());
        goto L7
    L48:
        return;
    }

    public static final void a(b r210, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r211, a95.a r212) {
        BaseOpenEntity r100 = r210.f223478b.f471138a;
        PermissionOperation r101 = PermissionOperation.DOWNLOAD;
        String r102 = r100.getMountPoint();
        String r103 = r100.getFileId();
        sbb.e r110 = sbb.e.f541301l;
        if (s55.a.f540731a.k(new s55.e(HttpMethod.DOWNLOAD, r101, R.string.CreationMobile_ECM_AdminDisableToast, r102, r103, null, r110, null, null, null, null, null, null, null, 32672), r210.f223477a) == true) goto L5;
        tt5.a.h("DriveAttachmentMoreMenuCreator", "handlePermissionUiAction return false");
        return;
    L5:
        w75.a r104 = null;
        com.bytedance.ee.bear.middleground_permission_export.model.c r105 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        String r106 = r100.getFileId();
        boolean r107 = true;
        if (CipherManager.d() != 1) goto L9;
        r107 = false;
    L9:
        r105.m(null, r106, Boolean.FALSE, null, Boolean.valueOf(r107));
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(r110.f541317b, r100.getFileId(), OperationName.OPERATION_OPEN_WITH_THIRD_APP);
        com.bytedance.ee.bear.drive.biz.external.f r108 = com.bytedance.ee.bear.drive.biz.external.f.e(r210.f223478b.f471139b.getBizType(), r210.f223477a, r212);
        r108.f222917o = new j(r211, r210);
        r108.f222903a = new k(r100);
        w75.c r109 = r210.f223478b.f471139b.getIFileModel();
        com.bytedance.ee.bear.drive.biz.external.a.C3178a r111 = new com.bytedance.ee.bear.drive.biz.external.a.C3178a();
        if (r109 == null) goto L12;
        long r112 = r109.getFileSize();
    L13:
        r111.f222889b = r112;
        r111.f222888a = r100.getFileId();
        r111.f222890c = r100.getApiExtra();
        r111.f222891d = r100.getMountPoint();
        r111.f222892e = "from_docs_attachment_preview_download";
        r111.f222893f = r100.getBizScene();
        r111.f222894g = r100.getWatermarkScene();
        com.bytedance.ee.bear.drive.biz.external.a r113 = new com.bytedance.ee.bear.drive.biz.external.a(r111);
        BaseMoreMenuAction r114 = r211.f217034a;
        if (r114 == null) goto L16;
        String r115 = r114.f217016m;
    L17:
        r108.g(r113, null, r115);
        com.bytedance.ee.bear.drive.report.c r116 = o75.b.a().Ke();
        if (r109 == null) goto L20;
        r104 = r109.getDetails();
    L20:
        r116.n(r104, "open_in_other_apps", "none");
        return;
    L16:
        r115 = null;
        goto L17
    L12:
        r112 = 0;
        goto L13
    }
}
