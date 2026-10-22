package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceAttachmentOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.external.f;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SpaceFileDownloadManager {
    public final Context a;
    public final BaseOpenEntity b;
    public final w75.a c;
    public final d d;
    public final f e;
    public com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/spacefile/SpaceFileDownloadManager$EResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "USER_CANCELLED", "PERMISSION_DENIED", "CIPHER_DENIED", "FILE_TOO_LARGE", "DOWNLOAD_FAILED", "SAVE_FAILED", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EResult extends Enum<EResult> {
        public static final EResult CIPHER_DENIED = null;
        public static final EResult DOWNLOAD_FAILED = null;
        public static final EResult FILE_TOO_LARGE = null;
        public static final EResult PERMISSION_DENIED = null;
        public static final EResult SAVE_FAILED = null;
        public static final EResult SUCCESS = null;
        public static final EResult USER_CANCELLED = null;
        public static final /* synthetic */ EResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EResult> getEntries() {
            return b;
        }

        static {
            EResult r0 = new EResult("SUCCESS", 0);
            SUCCESS = r0;
            EResult r1 = new EResult("USER_CANCELLED", 1);
            USER_CANCELLED = r1;
            EResult r3 = new EResult("PERMISSION_DENIED", 2);
            PERMISSION_DENIED = r3;
            EResult r5 = new EResult("CIPHER_DENIED", 3);
            CIPHER_DENIED = r5;
            EResult r7 = new EResult("FILE_TOO_LARGE", 4);
            FILE_TOO_LARGE = r7;
            EResult r9 = new EResult("DOWNLOAD_FAILED", 5);
            DOWNLOAD_FAILED = r9;
            EResult r11 = new EResult("SAVE_FAILED", 6);
            SAVE_FAILED = r11;
            EResult[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static EResult[] values() {
            return (EResult[]) a.clone();
        }

        public static EResult valueOf(String r1) {
            return (EResult) r27.a.a(EResult.class, r1);
        }

        public EResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(EResult r1);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SpaceFileDownloadManager a;
        public final /* synthetic */ String b;

        public c(SpaceFileDownloadManager r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.showFailureText(this.a.a, this.b, 0);     // Catch: Throwable -> L4
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
        w75.a r1 = this.c;
        if (s55.a.a.k(new e("DOWNLOAD", PermissionOperation.DOWNLOAD, 0, this.b.getMountPoint(), this.b.getFileId(), null, null, null, null, null, null, null, null, null, 32740), this.a) == true) goto L10;
        d r4 = this.d;
        if (r4 == null) goto L7;
        d.a(r4, null, null, 0, 15);
    L7:
        a(r1, false);
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r2 = this.f;
        if (r2 == null) goto L45;
        r2.a(EResult.PERMISSION_DENIED);
        return;
    L45:
        return;
    L10:
        boolean r5 = true;
        if (CipherManager.d() != 1) goto L19;
        Toast.showText(this.a, 2131887290);
        CipherManager.h();
        tt5.a.h(AbsDriveMoreMenuPlugin.TAG, "CipherManager status is " + CipherManager.d());
        d r6 = this.d;
        if (r6 == null) goto L15;
        d.a(r6, null, null, 0, 15);
    L15:
        a(r1, false);
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r3 = this.f;
        if (r3 == null) goto L47;
        r3.a(EResult.CIPHER_DENIED);
        return;
    L47:
        return;
    L19:
        if (d(r1) == false) goto L26;
        d r7 = this.d;
        if (r7 == null) goto L23;
        d.a(r7, null, null, 0, 15);
    L23:
        a(r1, true);
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r8 = this.f;
        if (r8 == null) goto L49;
        r8.a(EResult.FILE_TOO_LARGE);
        return;
    L49:
        return;
    L26:
        if (r1 == null) goto L31;
        w75.b r9 = r1.c();
        if (r9 == null) goto L31;
        String r10 = r9.k;
        if (r10 == null) goto L31;
    L34:
        boolean r11 = h.e(r10);
        boolean r12 = h.n(r10);
        if (r11 == true) goto L39;
        if (r12 == true) goto L39;
        r5 = false;
    L39:
        ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.l.b, this.b.getFileId(), "save_to_local");
        AtomicReference r13 = new AtomicReference(r1);
        com.bytedance.ee.bear.drive.report.c r14 = o75.b.a().Ke();
        BaseOpenEntity r16 = this.b;
        if (r16 != null) goto L42;
        r14.getClass();
    L43:
        f r17 = this.e;
        r17.o = new com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.a(this, r13, r1);
        r17.a = new d65.a(this);
        com.bytedance.ee.bear.drive.biz.external.c r18 = new com.bytedance.ee.bear.drive.biz.external.c(new com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.b(this, r5));
        r18.b = false;
        tt5.a.h("DriveComponent", "buildDownloadMenuItem() ext=" + r10 + ", isImage=" + r11 + ", isVideo=" + r12);
        f r19 = this.e;
        com.bytedance.ee.bear.drive.biz.external.a.C0122a r20 = new com.bytedance.ee.bear.drive.biz.external.a.C0122a();
        r20.b = 0;
        r20.a = this.b.getFileId();
        r20.c = this.b.getApiExtra();
        r20.d = this.b.getMountPoint();
        r20.e = this.b.getDownloadFrom();
        r20.f = this.b.getBizScene();
        r20.g = this.b.getWatermarkScene();
        r19.g(new com.bytedance.ee.bear.drive.biz.external.a(r20), r18, "LARK-PSDA-ccm_space_drive_download");
        return;
    L42:
        r14.d.v("ccm_drive_file_download_view", r14.g(r16));
    L31:
        r10 = this.b.getFileExt();
        if (r10 != null) goto L34;
        r10 = "";
        goto L34
    }

    public final boolean d(w75.a r5) {
        long r0 = o75.b.a().getDriveConfig().a().getDownload_origin_file_max_size() * ((long) 1024);
        if (r5 == null) goto L7;
        w75.b r6 = r5.c();
        if (r6 == null) goto L7;
        long r2 = r6.c;
    L9:
        if (r2 <= r0) goto L16;
        m.a(new c(this, xo5.a.c(this.a, 2131887284, "SIZE", wu5.a.b(Long.valueOf(r0), "B"))));
        com.bytedance.ee.bear.drive.report.c r7 = o75.b.a().Ke();
        BaseOpenEntity r1 = this.b;
        if (r1 != null) goto L13;
        r7.getClass();
        return true;
    L13:
        HashMap<String, Object> r3 = r7.g(r1);
        r7.d.v("ccm_drive_exceed_download_limit_view", r3);
        return true;
    L16:
        return false;
    L7:
        r2 = 0;
        goto L9
    }

    public final void a(w75.a r3, boolean r4) {
        b(r3, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e("SCClipboardManager", "auditDownload() error", e, false);
    }

    public final void b(w75.a r9, boolean r10) {
        boolean r0 = com.bytedance.ee.bear.middleground.permission.audit.d.h();
        tt5.a.h("SCClipboardManager", "doAuditDownload() isSuccess=" + r10 + "， isDisableDriveDownload = " + r0 + ", openEntity.appId = " + this.b.getAppId());
        if (r0 == true) goto L5;
    L10:
        if (r9 == null) goto L15;
        w75.b r1 = r9.c();
        if (r1 == null) goto L15;
        String r2 = r1.k;
        if (r2 == null) goto L15;
    L18:
        boolean r3 = h.e(r2);
        boolean r4 = h.n(r2);
        String r5 = null;
        if (Intrinsics.areEqual(this.b.getMountPoint(), FileInfoPuller.CALLER_WIKI) == true) goto L21;
    L23:
        dj5.a r6 = null;
    L24:
        HostDocumentInfo r7 = this.b.getHostDocumentInfo();
        if (r7 != null) goto L34;
        r7 = new HostDocumentInfo();
        String r8 = this.b.getFileName();
        if (r8 != null) goto L33;
        if (r9 == null) goto L32;
        w75.b r11 = r9.c();
        if (r11 == null) goto L32;
        r8 = r11.b;
    L32:
        r8 = null;
    L33:
        r7.setTitle(r8);
        r7.setType(12);
    L34:
        BaseOpenEntity r12 = this.b;
        if ((r12 instanceof SpaceThirdPartyOpenEntity) == false) goto L38;
        r7.setDocToken(((SpaceThirdPartyOpenEntity) r12).getDocToken());
    L38:
        if ((this.b instanceof SpaceAttachmentOpenEntity) == true) goto L40;
    L42:
        com.bytedance.ee.bear.middleground_permission_export.model.c r13 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        DriveData r14 = new DriveData();
        r14.setToken(this.b.getFileId());
        if (y0.d(this.b.getFileName()) == false) goto L49;
        if (r9 == null) goto L48;
        w75.b r16 = r9.c();
        if (r16 == null) goto L48;
        String r17 = r16.b;
    L50:
        r14.setName(r17);
        if (r9 == null) goto L56;
        w75.b r18 = r9.c();
        if (r18 == null) goto L56;
        String r19 = r18.f;
        if (r19 == null) goto L56;
    L61:
        r14.setMimeType(r19);
        r14.setAppId(this.b.getAppId());
        r14.setAppFileId(this.b.getFileId());
        r14.setImage(Boolean.valueOf(r3));
        r14.setVideo(Boolean.valueOf(r4));
        Unit r20 = Unit.INSTANCE;
        r13.i(r7, r6, r14, Boolean.valueOf(!r10));
        return;
    L56:
        if (r9 == null) goto L58;
        r5 = r9.r;
    L58:
        if (r5 != null) goto L60;
        r19 = this.b.getMimeType();
        goto L61
    L60:
        r19 = r5;
    L48:
        r17 = null;
        goto L50
    L49:
        r17 = this.b.getFileName();
        goto L50
    L40:
        if (TextUtils.isEmpty(r7.getDocToken()) == false) goto L42;
        r7.setDocToken(((SpaceAttachmentOpenEntity) this.b).getMountNodeToken());
        goto L42
    L21:
        if ((this.b instanceof SpaceFileOpenEntity) == false) goto L23;
        BearUrl r21 = p.a().Z(((SpaceFileOpenEntity) this.b).getWikiUrl());
        r6 = new dj5.a(r21.b, null, r21.a, 24);
    L15:
        r2 = this.b.getFileExt();
        if (r2 != null) goto L18;
        r2 = "";
        goto L18
    L5:
        if (Intrinsics.areEqual(this.b.getAppId(), "2") == false) goto L7;
    L8:
        tt5.a.h("SCClipboardManager", "doAuditDownload() audit disabled, appId=" + this.b.getAppId());
        return;
    L7:
        if (Intrinsics.areEqual(this.b.getAppId(), "56") == false) goto L10;
        goto L8
    }

    public SpaceFileDownloadManager(Context r2, BaseOpenEntity r3, w75.a r4, d r5, a95.a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "openEntity");
        Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = f.e(r3.getBizType(), r2, r6);
    }
}
