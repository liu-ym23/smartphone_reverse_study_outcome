package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceAttachmentOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.external.f;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.download.api.config.HttpMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import com.ss.lark.android.encryption.CipherManager;
import i75.h;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import s55.e;

/* JADX INFO: loaded from: classes16.dex */
public final class SpaceFileDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f223495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseOpenEntity f223496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w75.a f223497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f223498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f223499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c f223500f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/spacefile/SpaceFileDownloadManager$EResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "USER_CANCELLED", "PERMISSION_DENIED", "CIPHER_DENIED", "FILE_TOO_LARGE", "DOWNLOAD_FAILED", "SAVE_FAILED", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EResult extends Enum<EResult> {
        public static final EResult CIPHER_DENIED = null;
        public static final EResult DOWNLOAD_FAILED = null;
        public static final EResult FILE_TOO_LARGE = null;
        public static final EResult PERMISSION_DENIED = null;
        public static final EResult SAVE_FAILED = null;
        public static final EResult SUCCESS = null;
        public static final EResult USER_CANCELLED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EResult[] f223501a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f223502b = null;

        public static EnumEntries<EResult> getEntries() {
            return f223502b;
        }

        static {
            EResult r100 = new EResult("SUCCESS", 0);
            SUCCESS = r100;
            EResult r101 = new EResult("USER_CANCELLED", 1);
            USER_CANCELLED = r101;
            EResult r102 = new EResult("PERMISSION_DENIED", 2);
            PERMISSION_DENIED = r102;
            EResult r103 = new EResult("CIPHER_DENIED", 3);
            CIPHER_DENIED = r103;
            EResult r104 = new EResult("FILE_TOO_LARGE", 4);
            FILE_TOO_LARGE = r104;
            EResult r105 = new EResult("DOWNLOAD_FAILED", 5);
            DOWNLOAD_FAILED = r105;
            EResult r110 = new EResult("SAVE_FAILED", 6);
            SAVE_FAILED = r110;
            EResult[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f223501a = r111;
            f223502b = EnumEntriesKt.enumEntries(r111);
        }

        public static EResult[] values() {
            return (EResult[]) f223501a.clone();
        }

        public static EResult valueOf(String r100) {
            return (EResult) r27.a.a(EResult.class, r100);
        }

        public EResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(EResult r100);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceFileDownloadManager f223503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f223504b;

        public c(SpaceFileDownloadManager r100, String r101) {
            this.f223503a = r100;
            this.f223504b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.showFailureText(this.f223503a.f223495a, this.f223504b, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        w75.a r100 = this.f223497c;
        if (s55.a.f540731a.k(new e(HttpMethod.DOWNLOAD, PermissionOperation.DOWNLOAD, 0, this.f223496b.getMountPoint(), this.f223496b.getFileId(), null, null, null, null, null, null, null, null, null, 32740), this.f223495a) == true) goto L10;
        d r101 = this.f223498d;
        if (r101 == null) goto L7;
        d.a(r101, null, null, 0, 15);
    L7:
        a(r100, false);
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r102 = this.f223500f;
        if (r102 == null) goto L45;
        r102.a(EResult.PERMISSION_DENIED);
        return;
    L45:
        return;
    L10:
        boolean r103 = true;
        if (CipherManager.d() != 1) goto L19;
        Toast.showText(this.f223495a, R.string.CreationMobile_ECM_SecuritySettingKAToast);
        CipherManager.h();
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "CipherManager status is " + CipherManager.d());
        d r104 = this.f223498d;
        if (r104 == null) goto L15;
        d.a(r104, null, null, 0, 15);
    L15:
        a(r100, false);
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r105 = this.f223500f;
        if (r105 == null) goto L47;
        r105.a(EResult.CIPHER_DENIED);
        return;
    L47:
        return;
    L19:
        if (d(r100) == false) goto L26;
        d r106 = this.f223498d;
        if (r106 == null) goto L23;
        d.a(r106, null, null, 0, 15);
    L23:
        a(r100, true);
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r107 = this.f223500f;
        if (r107 == null) goto L49;
        r107.a(EResult.FILE_TOO_LARGE);
        return;
    L49:
        return;
    L26:
        if (r100 == null) goto L31;
        w75.b r108 = r100.c();
        if (r108 == null) goto L31;
        String r109 = r108.f558567k;
        if (r109 == null) goto L31;
    L34:
        boolean r110 = h.e(r109);
        boolean r111 = h.n(r109);
        if (r110 == true) goto L39;
        if (r111 == true) goto L39;
        r103 = false;
    L39:
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.f541301l.f541317b, this.f223496b.getFileId(), OperationName.OPERATION_SAVE_TO_LOCAL);
        AtomicReference r112 = new AtomicReference(r100);
        com.bytedance.ee.bear.drive.report.c r113 = o75.b.a().Ke();
        BaseOpenEntity r114 = this.f223496b;
        if (r114 != null) goto L42;
        r113.getClass();
    L43:
        f r115 = this.f223499e;
        r115.f222917o = new com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.a(this, r112, r100);
        r115.f222903a = new d65.a(this);
        com.bytedance.ee.bear.drive.biz.external.c r116 = new com.bytedance.ee.bear.drive.biz.external.c(new com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.b(this, r103));
        r116.f222896b = false;
        tt5.a.h("DriveComponent", "buildDownloadMenuItem() ext=" + r109 + ", isImage=" + r110 + ", isVideo=" + r111);
        f r117 = this.f223499e;
        com.bytedance.ee.bear.drive.biz.external.a.C3178a r118 = new com.bytedance.ee.bear.drive.biz.external.a.C3178a();
        r118.f222889b = 0;
        r118.f222888a = this.f223496b.getFileId();
        r118.f222890c = this.f223496b.getApiExtra();
        r118.f222891d = this.f223496b.getMountPoint();
        r118.f222892e = this.f223496b.getDownloadFrom();
        r118.f222893f = this.f223496b.getBizScene();
        r118.f222894g = this.f223496b.getWatermarkScene();
        r117.g(new com.bytedance.ee.bear.drive.biz.external.a(r118), r116, "LARK-PSDA-ccm_space_drive_download");
        return;
    L42:
        r113.f224585d.v("ccm_drive_file_download_view", r113.g(r114));
    L31:
        r109 = this.f223496b.getFileExt();
        if (r109 != null) goto L34;
        r109 = "";
        goto L34
    }

    public final boolean d(w75.a r100) {
        long r101 = o75.b.a().getDriveConfig().a().getDownload_origin_file_max_size() * ((long) 1024);
        if (r100 == null) goto L7;
        w75.b r102 = r100.c();
        if (r102 == null) goto L7;
        long r103 = r102.f558559c;
    L9:
        if (r103 <= r101) goto L16;
        m.a(new c(this, xo5.a.c(this.f223495a, R.string.CreationMobile_ECM_SaveToLocal_TooLarge_toast, "SIZE", wu5.a.b(Long.valueOf(r101), "B"))));
        com.bytedance.ee.bear.drive.report.c r104 = o75.b.a().Ke();
        BaseOpenEntity r105 = this.f223496b;
        if (r105 != null) goto L13;
        r104.getClass();
        return true;
    L13:
        HashMap<String, Object> r106 = r104.g(r105);
        r104.f224585d.v("ccm_drive_exceed_download_limit_view", r106);
        return true;
    L16:
        return false;
    L7:
        r103 = 0;
        goto L9
    }

    public final void a(w75.a r100, boolean r101) {
        b(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e("SCClipboardManager", "auditDownload() error", e, false);
    }

    public final void b(w75.a r100, boolean r110) {
        boolean r101 = com.bytedance.ee.bear.middleground.permission.audit.d.h();
        tt5.a.h("SCClipboardManager", "doAuditDownload() isSuccess=" + r110 + "， isDisableDriveDownload = " + r101 + ", openEntity.appId = " + this.f223496b.getAppId());
        if (r101 == true) goto L5;
    L10:
        if (r100 == null) goto L15;
        w75.b r102 = r100.c();
        if (r102 == null) goto L15;
        String r103 = r102.f558567k;
        if (r103 == null) goto L15;
    L18:
        boolean r104 = h.e(r103);
        boolean r105 = h.n(r103);
        String r106 = null;
        if (Intrinsics.areEqual(this.f223496b.getMountPoint(), "wiki") == true) goto L21;
    L23:
        dj5.a r107 = null;
    L24:
        HostDocumentInfo r108 = this.f223496b.getHostDocumentInfo();
        if (r108 != null) goto L34;
        r108 = new HostDocumentInfo();
        String r109 = this.f223496b.getFileName();
        if (r109 != null) goto L33;
        if (r100 == null) goto L32;
        w75.b r111 = r100.c();
        if (r111 == null) goto L32;
        r109 = r111.f558558b;
    L32:
        r109 = null;
    L33:
        r108.setTitle(r109);
        r108.setType(12);
    L34:
        BaseOpenEntity r112 = this.f223496b;
        if ((r112 instanceof SpaceThirdPartyOpenEntity) == false) goto L38;
        r108.setDocToken(((SpaceThirdPartyOpenEntity) r112).getDocToken());
    L38:
        if ((this.f223496b instanceof SpaceAttachmentOpenEntity) == true) goto L40;
    L42:
        com.bytedance.ee.bear.middleground_permission_export.model.c r113 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        DriveData r114 = new DriveData();
        r114.setToken(this.f223496b.getFileId());
        if (y0.d(this.f223496b.getFileName()) == false) goto L49;
        if (r100 == null) goto L48;
        w75.b r115 = r100.c();
        if (r115 == null) goto L48;
        String r116 = r115.f558558b;
    L50:
        r114.setName(r116);
        if (r100 == null) goto L56;
        w75.b r117 = r100.c();
        if (r117 == null) goto L56;
        String r118 = r117.f558562f;
        if (r118 == null) goto L56;
    L61:
        r114.setMimeType(r118);
        r114.setAppId(this.f223496b.getAppId());
        r114.setAppFileId(this.f223496b.getFileId());
        r114.setImage(Boolean.valueOf(r104));
        r114.setVideo(Boolean.valueOf(r105));
        Unit r119 = Unit.INSTANCE;
        r113.i(r108, r107, r114, Boolean.valueOf(!r110));
        return;
    L56:
        if (r100 == null) goto L58;
        r106 = r100.f558549r;
    L58:
        if (r106 != null) goto L60;
        r118 = this.f223496b.getMimeType();
        goto L61
    L60:
        r118 = r106;
    L48:
        r116 = null;
        goto L50
    L49:
        r116 = this.f223496b.getFileName();
        goto L50
    L40:
        if (TextUtils.isEmpty(r108.getDocToken()) == false) goto L42;
        r108.setDocToken(((SpaceAttachmentOpenEntity) this.f223496b).getMountNodeToken());
        goto L42
    L21:
        if ((this.f223496b instanceof SpaceFileOpenEntity) == false) goto L23;
        BearUrl r120 = p.a().Z(((SpaceFileOpenEntity) this.f223496b).getWikiUrl());
        r107 = new dj5.a(r120.f222561b, null, r120.f222560a, 24);
    L15:
        r103 = this.f223496b.getFileExt();
        if (r103 != null) goto L18;
        r103 = "";
        goto L18
    L5:
        if (Intrinsics.areEqual(this.f223496b.getAppId(), "2") == false) goto L7;
    L8:
        tt5.a.h("SCClipboardManager", "doAuditDownload() audit disabled, appId=" + this.f223496b.getAppId());
        return;
    L7:
        if (Intrinsics.areEqual(this.f223496b.getAppId(), BDLocationException.ERROR_SHAKE_UPLOAD) == false) goto L10;
        goto L8
    }

    public SpaceFileDownloadManager(Context r100, BaseOpenEntity r101, w75.a r102, d r103, a95.a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "openEntity");
        Intrinsics.checkNotNullParameter(r104, "userComponentAbility");
        this.f223495a = r100;
        this.f223496b = r101;
        this.f223497c = r102;
        this.f223498d = r103;
        this.f223499e = f.e(r101.getBizType(), r100, r104);
    }
}
