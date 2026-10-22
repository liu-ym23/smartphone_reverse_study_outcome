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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public final Context a;
    public final q75.a b;
    public final com.bytedance.ee.bear.drive.report.a c;
    public final List<a> d;
    public final p e;
    public final a95.a f;

    public class a {
        public final com.bytedance.ee.bear.drive.config.strategy.d a;
        public final ConcurrentLinkedQueue<DriveOfflineDoc> b;
        public final int c;
        public final AtomicInteger d;
        public final int e;
        public final t f;
        public final AtomicBoolean g;
        public final CompositeDisposable h;
        public final List<String> i;
        public final g85.f j;
        public final IApiPuller<FileInfoV1Puller.Params, f85.a> k;
        public final IDownloader l;
        public final /* synthetic */ m m;

        public a() {
            throw null;
        }

        public final synchronized void d() {
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L5:
            if (this.g.get() == false) goto L9;
            tt5.a.h("DrivePreloadExecutor", "current task is shutdown, preload type=" + this.e + " obj=" + this);     // Catch: Throwable -> L20
            monitor-exit(this);
            return;
        L9:
            this.h.clear();     // Catch: Throwable -> L20
            this.b.clear();     // Catch: Throwable -> L20
            RustDownload.shutdown(this.i);     // Catch: Throwable -> L20
            p r0 = this.m.e;     // Catch: Throwable -> L20
            if (r0 == null) goto L17;
            r0.getClass();     // Catch: Throwable -> L20
            tt5.a.h("TTVideoEngineWrapper", "cancel all video preload task");     // Catch: Exception -> L14 Throwable -> L20
            TTVideoEngine.cancelAllPreloadTasks();     // Catch: Exception -> L14 Throwable -> L20
        L14:
            e = move-exception;
            tt5.a.f("TTVideoEngineWrapper", e, false);     // Catch: Throwable -> L20
        L17:
            this.g.set(true);     // Catch: Throwable -> L20
            ((CopyOnWriteArrayList) this.m.d).remove(this);     // Catch: Throwable -> L20
            monitor-exit(this);
        }

        public static void a(Throwable r1) {
            if ((r1 instanceof DriveException) == true) goto L5;
            return;
        L5:
            if (((DriveException) r1).getErrorCode() != ErrCode.ENCRYPTION_KEY_DELETED) goto L9;
            tt5.a.h("DrivePreloadExecutor", "preload handleEncryptionKeyDeletedException");
            int r2 = com.bytedance.ee.bear.drive.biz.cache.a.a;
            com.bytedance.ee.bear.drive.biz.cache.a.C0118a.a();
            return;
        }

        public final synchronized void c(boolean r4) {
            monitor-enter(this);
            if (r4 == true) goto L18;
        L6:
            int r5 = this.d.get();     // Catch: Throwable -> L15
            if (r5 < this.c) goto L9;
        L12:
            tt5.a.h("DrivePreloadExecutor", "drive preload task done, type=" + this.e + ", preload count=" + r5);     // Catch: Throwable -> L15
            this.b.clear();     // Catch: Throwable -> L15
            ((CopyOnWriteArrayList) this.m.d).remove(this);     // Catch: Throwable -> L15
            this.g.set(true);     // Catch: Throwable -> L15
        L13:
            monitor-exit(this);
            return;
        L9:
            if (this.b.isEmpty() == true) goto L12;
            f(this.b.poll());     // Catch: Throwable -> L15
            goto L13
        L18:
            this.d.incrementAndGet();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        public final void f(final DriveOfflineDoc r11) {
            if (r11 != null) goto L5;
            tt5.a.c("preloadDrive == null");
            return;
        L5:
            t r0 = t.l();
            String r1 = du5.d.a(r11.a);
            a95.a r2 = this.m.f;
            r0.getClass();
            boolean r3 = true;
            if (t.i(r1, true, r2) != null) goto L10;
            r3 = false;
        L10:
            if (r3 == false) goto L13;
            tt5.a.b("DrivePreloadExecutor", "drive preload has cache. return. ");
            c(false);
            return;
        L13:
            tt5.a.h("DrivePreloadExecutor", "startPreloadTask...");
            this.h.add(this.k.pull(new FileInfoV1Puller.Params(r11.a, null, r11.h, this.a.d(), this.a.c(null), null)).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).doOnNext(new i0()).subscribe(new d(this, r11), new e(this)));
        }

        public final void b(Throwable r6, DriveOfflineDoc r7) {
            if ((r6 instanceof DriveException) == false) goto L5;
            DriveException r0 = (DriveException) r6;
        L7:
            if (r0 != null) goto L9;
        L21:
            tt5.a.f("DrivePreloadExecutor", r6, false);
            ErrReportHandler.handle(this.m.c, r6, r7.a, 4);
            c(true);
        L22:
            if (r0 != null) goto L24;
            return;
        L24:
            if (r0.getErrorCode() != ErrCode.OWNER_DELETED_FILE) goto L26;
        L29:
            ((rc5.a) org.koin.java.a.a(rc5.a.class)).O(r7.a).subscribe(new a0(), new h());
            return;
        L26:
            if (r0.getErrorCode() == ErrCode.FILE_NOT_FOUND) goto L29;
            a(r0);
            return;
        L9:
            if (r0.getErrorCode() != ErrCode.PRELOAD_SIZE_TOO_LARGE) goto L11;
        L20:
            tt5.a.k("DrivePreloadExecutor", "preload error, but can continue cal, error=" + r0);
            c(false);
            goto L22
        L11:
            if (r0.getErrorCode() == ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW) goto L20;
            if (r0.getErrorCode() == ErrCode.PERMISSION_DENIED) goto L20;
            if (r0.getErrorCode() == ErrCode.POLICY_DENIED) goto L20;
            if (r0.getErrorCode() == ErrCode.COPY_TIMEOUT) goto L20;
            if (r0.getErrorCode() != ErrCode.COPY_FAILED) goto L21;
        L5:
            r0 = null;
            goto L7
        }

        public final void e(final f85.a r3, final DriveOfflineDoc r4) {
            Disposable r5 = Flowable.just(r3).observeOn(fo5.d.e()).flatMap(new f(this, r3, r4)).subscribe(new a0(), new g(this, r4));
            this.h.add(r5);
        }

        public a(m r4, int r5, ConcurrentLinkedQueue r6) {
            this.m = r4;
            this.d = new AtomicInteger();
            this.g = new AtomicBoolean();
            this.h = new CompositeDisposable();
            this.i = new CopyOnWriteArrayList();
            o75.a r0 = o75.b.a();
            r0.getDriveConfig();
            if (r5 != 4) goto L5;
            this.a = r0.Ic(com.bytedance.ee.bear.drive.config.strategy.k.class);
        L6:
            this.f = r0.getCacheManager();
            this.j = r0.getMimeTypeManager();
            this.e = r5;
            this.b = r6;
            this.c = r4.a(r5);
            this.k = FileInfoPuller.V1((NetService) org.koin.java.a.a(NetService.class));
            o75.b.a().Tb();
            this.l = PlatformDownloader.create(new ApiDriveExecutor("2", r4.f), new DownStrategy(this.a), new c85.b(this.a, r4.f), r4.f);
            return;
        L5:
            this.a = r0.Ic(com.bytedance.ee.bear.drive.config.strategy.h.class);
            goto L6
        }
    }

    public final int a(int r2) {
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L14;
        if (r2 == 4) goto L18;
        return 0;
    L14:
        return this.b.b;
    L16:
        return this.b.c;
    L18:
        return this.b.a;
    L20:
        return this.b.d;
    }

    public m(Context r2, a95.a r3) {
        this.d = new CopyOnWriteArrayList();
        this.a = r2;
        o75.a r4 = o75.b.a();
        this.b = r4.getDriveConfig();
        this.c = r4.Tb();
        this.f = r3;
        this.e = new p(r3);
    }
}
