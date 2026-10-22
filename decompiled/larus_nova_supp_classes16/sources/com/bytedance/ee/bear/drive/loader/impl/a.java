package com.bytedance.ee.bear.drive.loader.impl;

import b85.d0;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.config.strategy.j;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.DownStrategy;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.download.platform.PlatformDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.ApiImFileExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.RustDownload;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SheetInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SlidesInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.FileInfoV2Puller;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends u75.a {
    public final DrivePluginHost c;
    public final OnlineOpenEntity d;
    public final d0<FileInfoV2Puller.Params, f85.b> e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.impl.a$a, reason: collision with other inner class name */
    public static final class C0166a implements IFileDownloadDependency {
        public final /* synthetic */ com.bytedance.ee.bear.drive.config.strategy.d a;
        public final /* synthetic */ a b;

        @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
        public final String getAppId() {
            return this.b.d.getAppId();
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
        public final com.bytedance.ee.bear.drive.config.strategy.d getPreviewStrategy() {
            com.bytedance.ee.bear.drive.config.strategy.d r0 = this.a;
            Intrinsics.checkNotNull(r0);
            return r0;
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
        public final t getCacheManager() {
            return o75.b.a().getCacheManager();
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
        public final com.bytedance.ee.bear.drive.report.a getDevReport() {
            return o75.b.a().Tb();
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
        public final g85.f getMimeTypeManager() {
            return o75.b.a().getMimeTypeManager();
        }

        public C0166a(com.bytedance.ee.bear.drive.config.strategy.d r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
        public final String getCacheKey(String r1, String r2) {
            String r3 = t.e(this.b.d.getAppId(), r1);
            if (r3 != null) goto L6;
            return "";
        L6:
            return r3;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // u75.b
    public final void a() {
        if (this.c.c.getIFileModel() == null) goto L5;
        this.e.d(this.c.c.getIFileModel());
        return;
    L5:
        tt5.a.d("DriveComponent", "loadDirectly() error iFileModel null");
    }

    @Override // u75.b
    public final void onDetach() {
        this.b.a(InfoCode.OnDetach, null);
        tt5.a.h("IMFileLoader", "onDetach()");
        d0<FileInfoV2Puller.Params, f85.b> r0 = this.e;
        r0.b.clear();
        RustDownload.shutdown(r0.f);
    }

    @Override // u75.a, u75.b
    public final void load() {
        super.load();
        this.e.c();
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [P, com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.FileInfoV2Puller$Params] */
    public a(DrivePluginHost r8) {
        Intrinsics.checkNotNullParameter(r8, "host");
        super(r8);
        this.c = r8;
        BaseOpenEntity r0 = r8.c.getOpenEntity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity");
        OnlineOpenEntity r1 = (OnlineOpenEntity) r0;
        this.d = r1;
        com.bytedance.ee.bear.drive.config.strategy.d r2 = j.b(r8.c);
        d0.c r3 = new d0.c();
        r3.a.a = r1.getFileId();
        r3.a.b = r8.c.isVCFollowMode();
        r3.e = r8.b();
        r3.a.e = r1.getEncryptedFile();
        r3.b = new C0166a(r2, this);
        r3.d = PlatformDownloader.create(new ApiImFileExecutor(r1.getAppId(), r8.b()), new DownStrategy(r2), new c85.d(r2, r8.b()), r8.b());
        r3.a.g = new FileInfoV2Puller.Params(r1.getAppId(), r1.getFileId(), r1.getAuthExtra(), r1.getMountPoint());
        r3.f = FileInfoPuller.V2((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        SheetInfoPuller.Params r4 = new SheetInfoPuller.Params();
        r4.setFileToken(r1.getFileId());
        r4.setFileName(r1.getFileName());
        r4.setLoadListener(this.b);
        Unit r5 = Unit.INSTANCE;
        r3.a.h = r4;
        r3.g = SheetInfoPuller.Companion.v2((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        SlidesInfoPuller.Params r6 = new SlidesInfoPuller.Params();
        r6.setFileToken(r1.getFileId());
        r6.setFileName(r1.getFileName());
        r6.setLoadListener(this.b);
        r3.a.i = r6;
        r3.h = SlidesInfoPuller.Companion.v2((NetService) r8.b().a(NetService.class));
        r3.i = new c85.g(r1, r8.b());
        r3.j = this.b;
        r3.k = r1;
        this.e = r3.a();
    }
}
