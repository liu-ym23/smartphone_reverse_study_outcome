package com.bytedance.ee.bear.drive.loader.download;

import android.app.Application;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.Flowable;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class DownCallback<FM extends w75.a> extends IDownloader.ICallback<FM> {
    private static final u75.b.a EMPTY_CB = null;
    private static final String TAG = "DRIVE_PREVIEW_FLOW_DownCallback";
    private final DownloadOptions downloadOptions;
    private final w75.c<FM> iFileModel;
    private final WeakReference<u75.b.a> listener;
    private final IFileDownloadDependency resource;
    private final int sourceType;
    private a95.a userComponentAbility;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.DownCallback$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ee$bear$drive$loader$download$platform$abs$IDownloader$TransStatus = null;

        static {
            int[] r0 = new int[IDownloader.TransStatus.values().length];
            $SwitchMap$com$bytedance$ee$bear$drive$loader$download$platform$abs$IDownloader$TransStatus = r0;
            r0[IDownloader.TransStatus.TRANSFORM_COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$download$platform$abs$IDownloader$TransStatus[IDownloader.TransStatus.TRANSFORMING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$download$platform$abs$IDownloader$TransStatus[IDownloader.TransStatus.TRANSFORM_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static /* synthetic */ DriveFilePath a(File r0, UserSession r1, Boolean r2) {
        return lambda$onSuccess$0(r0, r1, r2);
    }

    public static /* synthetic */ void b(Throwable r0) {
        lambda$onSuccess$2(r0);
    }

    public static /* synthetic */ void c(Throwable r0) {
        lambda$onSuccess$4(r0);
    }

    public static /* synthetic */ void d(DownCallback r0, File r1, UserSession r2, boolean r3, DriveFilePath r4) {
        r0.lambda$onSuccess$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void e(Boolean r0) {
        lambda$onSuccess$1(r0);
    }

    private static /* synthetic */ void lambda$onSuccess$1(Boolean r0) throws Exception {
    }

    static {
        EMPTY_CB = new u75.b.C0306b();
    }

    private u75.b.a safeGetListener() {
        u75.b.a r0 = this.listener.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        tt5.a.k("DriveComponent", "received rust callback after cancel download");
        return EMPTY_CB;
    }

    private static void lambda$onSuccess$2(Throwable r2) throws Exception {
        tt5.a.f("DRIVE_PREVIEW_FLOW", r2, false);
    }

    private static void lambda$onSuccess$4(Throwable r2) throws Exception {
        tt5.a.f(TAG, r2, false);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onHitCache(w75.c<FM> r2) {
        safeGetListener().b(r2.getDetails().i());
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onNoDownload(w75.c<FM> r2) {
        safeGetListener().b(r2.getDetails().i());
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onProgress(int r2) {
        safeGetListener().onProgress(r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onServerTransform(w75.c<FM> r2) {
        safeGetListener().b(r2.getDetails().i());
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onTransStatusChanged(IDownloader.TransStatus r3) {
        int r4 = AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$download$platform$abs$IDownloader$TransStatus[r3.ordinal()];
        if (r4 != 1) goto L5;
        safeGetListener().a(InfoCode.GenerateFinished, null);
        return;
    L5:
        if (r4 != 2) goto L7;
        safeGetListener().a(InfoCode.Generating, null);
        return;
    L7:
        if (r4 != 3) goto L15;
        safeGetListener().a(InfoCode.GenerateFailed, null);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onRustFailed(String r4, int r5) {
        if (r5 == 401) goto L33;
        if (r5 != 1000) goto L6;
    L34:
        com.bytedance.ee.bear.drive.report.a r6 = this.resource.getDevReport();
        w75.a r1 = this.iFileModel.getDetails();
        int r2 = this.sourceType;
        r6.getClass();
        if (r5 == 1000) goto L39;
        r6.o(com.bytedance.ee.bear.drive.report.c.e(r1), r5, r2);
        return;
    L39:
        return;
    L6:
        if (r5 != 1007) goto L8;
        safeGetListener().c(ErrCode.NO_NETWORK);
        goto L34
    L8:
        if (r5 == 1024) goto L33;
        if (r5 != 2003) goto L12;
    L31:
        safeGetListener().c(ErrCode.FILE_NOT_FOUND);
        goto L34
    L12:
        if (r5 != 3002) goto L14;
        safeGetListener().c(ErrCode.OWNER_DELETED_FILE);
        goto L34
    L14:
        if (r5 != 90003501) goto L16;
        safeGetListener().c(ErrCode.MAILCE_FILE);
        goto L34
    L16:
        if (r5 != 900023001) goto L18;
        safeGetListener().c(ErrCode.ENCRYPTION_KEY_DELETED);
        goto L34
    L18:
        if (r5 != 403) goto L20;
        safeGetListener().c(ErrCode.PERMISSION_DENIED);
        goto L34
    L20:
        if (r5 == 404) goto L31;
        switch(r5) {
            case 900101001: goto L26;
            case 900101002: goto L25;
            case 900101003: goto L24;
            case 900101004: goto L23;
            default: goto L22;
        };
    L22:
        safeGetListener().c(ErrCode.DEFAULT);
        goto L34
    L23:
        safeGetListener().c(ErrCode.DLP_EXTERNAL_SENSATIVE);
        goto L34
    L24:
        safeGetListener().c(ErrCode.DLP_INTERANL_SENSATIVE);
        goto L34
    L25:
        safeGetListener().c(ErrCode.DLP_EXTERNAL_CHECKING);
        goto L34
    L26:
        safeGetListener().c(ErrCode.DLP_INTERANL_CHECKING);
    L33:
        safeGetListener().c(ErrCode.RUST_NOT_LOGIN);
        goto L34
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onSuccess(String r4, String r5) {
        this.iFileModel.y();
        final UserSession r6 = this.userComponentAbility.b;
        DriveFilePath r7 = this.iFileModel.getLocalFilePath();
        DriveFilePath r0 = this.iFileModel.v();
        final VFSFile r1 = z75.b.e(r7, r6);
        VFSFile r2 = z75.b.e(r0, r6);
        final boolean r8 = z75.b.d(r7, r6);
        if (r8 == true) goto L6;
        r1 = r2;
    L6:
        Flowable.just(Boolean.TRUE).map(new c(r1, r6)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new d(this, r1, r6, r8), new e());
    }

    private static DriveFilePath lambda$onSuccess$0(File r7, UserSession r8, Boolean r9) throws Exception {
        tt5.a.h(TAG, "onSuccess copy file if Needed");
        if (CipherManager.d() == 1) goto L22;
    L17:
        DriveFilePath r5 = null;
    L18:
        if (r5 == null) goto L21;
        return r5;
    L21:
        return new DriveFilePath(Biz.DRIVE, "", "", true);
    L22:
        Application r0 = eu5.b.a;     // Catch: Exception -> L15
        DriveFilePath r1 = t.j();     // Catch: Exception -> L15
        VFSFile r3 = z75.b.f(r1, r8);     // Catch: Exception -> L15
        if (r3.exists() == true) goto L8;
        r3.mkdirs();     // Catch: Exception -> L15
    L8:
        Biz r4 = Biz.DRIVE;     // Catch: Exception -> L15
        Biz r6 = r1.getBiz();     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter(r6, "biz");     // Catch: Exception -> L15
        String r2 = r1.getRelativePath();     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter(r2, "relativePath");     // Catch: Exception -> L15
        String r10 = r7.getName();     // Catch: Exception -> L15
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        r5 = new DriveFilePath(r6, r2, r10, false);     // Catch: Exception -> L15
        VFSFile r11 = z75.b.e(r5, r8);     // Catch: Exception -> L15
        FileUtils.c(r7, r11);     // Catch: Exception -> L15
        if (r11.exists() == false) goto L17;
        tt5.a.h("DriveCacheManager", "copyAndGetTempPath new Path = " + r11.getCanonicalPath());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private void lambda$onSuccess$3(File r10, UserSession r11, boolean r12, DriveFilePath r13) throws Exception {
        DriveFilePath r0 = this.iFileModel.getLocalFilePath();
        DriveFilePath r1 = this.iFileModel.v();
        if (this.resource.getPreviewStrategy().b(r10.length(), this.iFileModel.getDetails(), this.iFileModel.I(), this.downloadOptions) == false) goto L10;
        int r2 = 2;
        if (this.iFileModel.J() == 2) goto L8;
        r2 = 0;
    L8:
        v85.c.a r14 = new v85.c.a();
        r14.a = r2;
        r14.b = this.resource.getPreviewStrategy().i(this.iFileModel.getDetails());
        r14.c = this.iFileModel.getFileToken();
        r14.d = this.iFileModel.getDetails().c().b;
        r14.c(r0);
        r14.d(r1);
        r14.g = this.iFileModel.getDetails().r;
        r14.h = this.iFileModel.h();
        r14.i = this.iFileModel.I();
        r14.j = this.iFileModel.B();
        r14.k = this.iFileModel.getExtra();
        r14.l = this.resource.getPreviewStrategy().getPreviewFileSourceType();
        r14.m = this.iFileModel.d();
        r14.n = this.iFileModel.C();
        r14.o = this.iFileModel.getDetails().e();
        r14.p = this.iFileModel.w();
        v85.c r3 = new v85.c(r14);
        tt5.a.h(TAG, "onSuccess put cache");
        this.resource.getCacheManager().m(r3, r11).subscribeOn(fo5.d.b()).subscribe(new a(), new b());
    L10:
        if (r13.isEmpty() == true) goto L14;
        if (r12 == false) goto L13;
        this.iFileModel.g(r13);
        goto L14
    L13:
        this.iFileModel.m(r13);
    L14:
        safeGetListener().b(this.iFileModel.getDetails().i());
        this.resource.getDevReport().s("rust_download", this.iFileModel.getDetails(), this.resource.getPreviewStrategy());
    }

    public DownCallback(w75.c<FM> r1, u75.b.a r2, IFileDownloadDependency r3, int r4, a95.a r5, DownloadOptions r6) {
        this.iFileModel = r1;
        this.listener = new WeakReference(r2);
        this.resource = r3;
        this.sourceType = r4;
        this.userComponentAbility = r5;
        this.downloadOptions = r6;
    }
}
