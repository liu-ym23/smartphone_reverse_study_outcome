package com.bytedance.ee.bear.drive.preload;

import android.content.Context;
import com.bytedance.ee.bear.bitable.homepage.list.a0;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.DownStrategy;
import com.bytedance.ee.bear.drive.loader.download.ErrReportHandler;
import com.bytedance.ee.bear.drive.loader.download.platform.PlatformDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.ApiDriveExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.RustDownload;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.ss.ttvideoengine.TTVideoEngine;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import z45.i0;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f224533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q75.a f224534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.a f224535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f224536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f224537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a95.a f224538f;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.drive.config.strategy.d f224539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue<DriveOfflineDoc> f224540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f224541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f224542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f224543e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final t f224544f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f224545g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final CompositeDisposable f224546h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<String> f224547i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final g85.f f224548j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final IApiPuller<FileInfoV1Puller.Params, f85.a> f224549k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final IDownloader f224550l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ m f224551m;

        public a() {
            throw null;
        }

        public final synchronized void d() {
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L5:
            if (this.f224545g.get() == false) goto L9;
            tt5.a.h("DrivePreloadExecutor", "current task is shutdown, preload type=" + this.f224543e + " obj=" + this);     // Catch: Throwable -> L20
            monitor-exit(this);
            return;
        L9:
            this.f224546h.clear();     // Catch: Throwable -> L20
            this.f224540b.clear();     // Catch: Throwable -> L20
            RustDownload.shutdown(this.f224547i);     // Catch: Throwable -> L20
            p r100 = this.f224551m.f224537e;     // Catch: Throwable -> L20
            if (r100 == null) goto L17;
            r100.getClass();     // Catch: Throwable -> L20
            tt5.a.h("TTVideoEngineWrapper", "cancel all video preload task");     // Catch: Exception -> L14 Throwable -> L20
            TTVideoEngine.cancelAllPreloadTasks();     // Catch: Exception -> L14 Throwable -> L20
        L14:
            e = move-exception;
            tt5.a.f("TTVideoEngineWrapper", e, false);     // Catch: Throwable -> L20
        L17:
            this.f224545g.set(true);     // Catch: Throwable -> L20
            ((CopyOnWriteArrayList) this.f224551m.f224536d).remove(this);     // Catch: Throwable -> L20
            monitor-exit(this);
        }

        public static void a(Throwable r100) {
            if ((r100 instanceof DriveException) == true) goto L5;
            return;
        L5:
            if (((DriveException) r100).getErrorCode() != ErrCode.ENCRYPTION_KEY_DELETED) goto L9;
            tt5.a.h("DrivePreloadExecutor", "preload handleEncryptionKeyDeletedException");
            int r101 = com.bytedance.ee.bear.drive.biz.cache.a.f222617a;
            com.bytedance.ee.bear.drive.biz.cache.a.C3174a.a();
            return;
        }

        public final synchronized void c(boolean r100) {
            monitor-enter(this);
            if (r100 == true) goto L18;
        L6:
            int r101 = this.f224542d.get();     // Catch: Throwable -> L15
            if (r101 < this.f224541c) goto L9;
        L12:
            tt5.a.h("DrivePreloadExecutor", "drive preload task done, type=" + this.f224543e + ", preload count=" + r101);     // Catch: Throwable -> L15
            this.f224540b.clear();     // Catch: Throwable -> L15
            ((CopyOnWriteArrayList) this.f224551m.f224536d).remove(this);     // Catch: Throwable -> L15
            this.f224545g.set(true);     // Catch: Throwable -> L15
        L13:
            monitor-exit(this);
            return;
        L9:
            if (this.f224540b.isEmpty() == true) goto L12;
            f(this.f224540b.poll());     // Catch: Throwable -> L15
            goto L13
        L18:
            this.f224542d.incrementAndGet();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        public final void f(final DriveOfflineDoc r110) {
            if (r110 != null) goto L5;
            tt5.a.c("preloadDrive == null");
            return;
        L5:
            t r100 = t.l();
            String r101 = du5.d.a(r110.f216996a);
            a95.a r102 = this.f224551m.f224538f;
            r100.getClass();
            boolean r103 = true;
            if (t.i(r101, true, r102) != null) goto L10;
            r103 = false;
        L10:
            if (r103 == false) goto L13;
            tt5.a.b("DrivePreloadExecutor", "drive preload has cache. return. ");
            c(false);
            return;
        L13:
            tt5.a.h("DrivePreloadExecutor", "startPreloadTask...");
            this.f224546h.add(this.f224549k.pull(new FileInfoV1Puller.Params(r110.f216996a, null, r110.f217003h, this.f224539a.d(), this.f224539a.c(null), null)).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).doOnNext(new i0()).subscribe(new d(this, r110), new e(this)));
        }

        public final void b(Throwable r100, DriveOfflineDoc r101) {
            if ((r100 instanceof DriveException) == false) goto L5;
            DriveException r102 = (DriveException) r100;
        L7:
            if (r102 != null) goto L9;
        L21:
            tt5.a.f("DrivePreloadExecutor", r100, false);
            ErrReportHandler.handle(this.f224551m.f224535c, r100, r101.f216996a, 4);
            c(true);
        L22:
            if (r102 != null) goto L24;
            return;
        L24:
            if (r102.getErrorCode() != ErrCode.OWNER_DELETED_FILE) goto L26;
        L29:
            ((rc5.a) org.koin.java.a.a(rc5.a.class)).O(r101.f216996a).subscribe(new a0(), new h());
            return;
        L26:
            if (r102.getErrorCode() == ErrCode.FILE_NOT_FOUND) goto L29;
            a(r102);
            return;
        L9:
            if (r102.getErrorCode() != ErrCode.PRELOAD_SIZE_TOO_LARGE) goto L11;
        L20:
            tt5.a.k("DrivePreloadExecutor", "preload error, but can continue cal, error=" + r102);
            c(false);
            goto L22
        L11:
            if (r102.getErrorCode() == ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW) goto L20;
            if (r102.getErrorCode() == ErrCode.PERMISSION_DENIED) goto L20;
            if (r102.getErrorCode() == ErrCode.POLICY_DENIED) goto L20;
            if (r102.getErrorCode() == ErrCode.COPY_TIMEOUT) goto L20;
            if (r102.getErrorCode() != ErrCode.COPY_FAILED) goto L21;
        L5:
            r102 = null;
            goto L7
        }

        public final void e(final f85.a r100, final DriveOfflineDoc r101) {
            Disposable r102 = Flowable.just(r100).observeOn(fo5.d.e()).flatMap(new f(this, r100, r101)).subscribe(new a0(), new g(this, r101));
            this.f224546h.add(r102);
        }

        public a(m r100, int r101, ConcurrentLinkedQueue r102) {
            this.f224551m = r100;
            this.f224542d = new AtomicInteger();
            this.f224545g = new AtomicBoolean();
            this.f224546h = new CompositeDisposable();
            this.f224547i = new CopyOnWriteArrayList();
            o75.a r103 = o75.b.a();
            r103.getDriveConfig();
            if (r101 != 4) goto L5;
            this.f224539a = r103.Ic(com.bytedance.ee.bear.drive.config.strategy.k.class);
        L6:
            this.f224544f = r103.getCacheManager();
            this.f224548j = r103.getMimeTypeManager();
            this.f224543e = r101;
            this.f224540b = r102;
            this.f224541c = r100.a(r101);
            this.f224549k = FileInfoPuller.V1((NetService) org.koin.java.a.a(NetService.class));
            o75.b.a().Tb();
            this.f224550l = PlatformDownloader.create(new ApiDriveExecutor("2", r100.f224538f), new DownStrategy(this.f224539a), new c85.b(this.f224539a, r100.f224538f), r100.f224538f);
            return;
        L5:
            this.f224539a = r103.Ic(com.bytedance.ee.bear.drive.config.strategy.h.class);
            goto L6
        }
    }

    public final int a(int r100) {
        if (r100 == 0) goto L20;
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L14;
        if (r100 == 4) goto L18;
        return 0;
    L14:
        return this.f224534b.f531959b;
    L16:
        return this.f224534b.f531960c;
    L18:
        return this.f224534b.f531958a;
    L20:
        return this.f224534b.f531961d;
    }

    public m(Context r100, a95.a r101) {
        this.f224536d = new CopyOnWriteArrayList();
        this.f224533a = r100;
        o75.a r102 = o75.b.a();
        this.f224534b = r102.getDriveConfig();
        this.f224535c = r102.Tb();
        this.f224538f = r101;
        this.f224537e = new p(r101);
    }
}
