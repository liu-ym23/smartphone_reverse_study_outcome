package com.bytedance.ee.bear.drive.services;

import android.app.Application;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements w85.c {
    public znc.m a;
    public final String b;
    public final VFSPath c;

    @Override // w85.c
    public final Flowable<Boolean> clearCache() {
        return Flowable.just("").observeOn(fo5.d.b()).map(new m(this)).doOnError(new n()).onErrorReturnItem(Boolean.FALSE);
    }

    @Override // w85.c
    public final Flowable<Long> getCacheSize() {
        return Flowable.just("").observeOn(fo5.d.b()).map(new o(this)).doOnError(new p()).onErrorReturnItem(0L);
    }

    public final znc.m i() {
        znc.m.a r0 = new znc.m.a();     // Catch: IOException -> L4
        String r1 = this.b;     // Catch: IOException -> L4
        Intrinsics.checkNotNullParameter(r1, "sourceDirectory");     // Catch: IOException -> L4
        r0.b = new PolarisFileWrapper(r1);     // Catch: IOException -> L4
        r0.a(this.c.getRealPath());     // Catch: IOException -> L4
        r0.c = 1;     // Catch: IOException -> L4
        r0.e = 314572800;     // Catch: IOException -> L4
        return new znc.m(r0);
    L4:
        e = move-exception;
        tt5.a.d("DriveImageDownloader", "DriveImageDownloader init fail: " + e);
        return null;
    }

    public q() {
        Application r0 = eu5.b.a;
        Biz r1 = Biz.DOCS;
        this.b = ay4.c.b.a(r0, r1, "cover");
        VFSPath r2 = ay4.c.b(r1, "cover");
        this.c = r2;
        VFSFile r3 = r2.toFile();
        if (r3.exists() == true) goto L5;
        r3.mkdirs();
    L5:
        this.a = i();
    }

    public static String g(w85.a r2) {
        if (r2.b != DownloadRequestInfo.DownloadType.COVER) goto L6;
        return r2.e.toLowerCase() + "_cover";
    L6:
        return r2.e.toLowerCase();
    }

    @Override // w85.c
    public final void b(String r3) {
        final String[] r0 = {r3};
        Flowable.just("").subscribeOn(fo5.d.b()).doOnNext(new j(r0)).subscribe(new k(), new l());
    }

    @Override // w85.c
    public final w85.b d(final w85.a r37) {
        tt5.a.h("DriveImageDownloader", "downloadDriveFileInternal()... request = " + r37);
        w85.a.b r1 = r37.h;
        if (r1 == null) goto L5;
        r1.e(r37.d);
    L5:
        w85.b r2 = h(r37);
        if (r2 == null) goto L13;
        w85.a.b r3 = r37.h;
        if (r3 == null) goto L29;
        if (r37.a == false) goto L29;
        r3.c(r37.d, r2);
    L29:
        return r2;
    L13:
        final w85.b r10 = new w85.b();
        String r11 = g(r37);
        final CountDownLatch r12 = new CountDownLatch(1);
        final VFSPath r14 = this.c.subPath(g(r37));
        final boolean r6 = r37.a;
        DownloadCallback r29 = new DriveImageDownloader$1(this, r14, r37, r10, r6, r12);
        DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r4 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r5 = DriveBizScene.DriveBizScene_UNKNOWN;
        String r16 = r14.getRealPath();
        String r7 = r37.f;
        String r8 = r37.g;
        String r9 = r37.e;
        DownloadRequestInfo.DownloadType r13 = r37.b;
        String r17 = r37.i;
        int r18 = r37.j;
        DownloadRequestInfo.b r19 = r37.k;
        int r110 = r37.l;
        String r111 = r37.m;
        DriveBizScene r34 = DriveBizScene.DriveBizScene_UNKNOWN;
        DriveWatermarkScene r36 = DriveWatermarkScene.DriveWatermarkScene_NONE;
        if (r13 != DownloadRequestInfo.DownloadType.COVER) goto L18;
        if (r19 != null) goto L18;
        r19 = new DownloadRequestInfo.b(1280, 1280, "equal", true);
    L18:
        DownloadRequestInfo r20 = new DownloadRequestInfo(r16, r9, r7, r8, r110, "", r13, "", 0, false, r17, r18, r29, r19, false, r111, null, r34, r36);
        tt5.a.h("DriveImageDownloader", "startDownload, downloadRequestInfo: " + r20);
        r10.f = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().g(r20);
        if (r37.a == true) goto L26;
        r12.await(5, TimeUnit.MINUTES);     // Catch: InterruptedException -> L22
    L24:
        f(r11, r10);
        return r10;
    L22:
        e = move-exception;
        tt5.a.f("DriveImageDownloader", e, false);
        goto L24
    L26:
        return r10;
    }

    public final w85.b h(w85.a r7) {
        if (this.a != null) goto L28;
        return null;
    L28:
        String r2 = g(r7);     // Catch: IOException -> L24
        w85.b r3 = new w85.b();     // Catch: IOException -> L24
        f(r2, r3);     // Catch: IOException -> L24
        InputStream r4 = r3.a;     // Catch: IOException -> L24
        if (r4 == null) goto L13;
        if (r4.available() <= 0) goto L13;
        tt5.a.b("DriveImageDownloader", " downloadDrive success from lru cache");     // Catch: IOException -> L24
        r3.c = "2";     // Catch: IOException -> L24
        r3.e = 0;     // Catch: IOException -> L24
        return r3;
    L13:
        if (r7.c == false) goto L15;
        return null;
    L15:
        if (r7.b == DownloadRequestInfo.DownloadType.COVER) goto L17;
        String r8 = r7.e.toLowerCase() + "_cover";     // Catch: IOException -> L24
    L18:
        f(r8, r3);     // Catch: IOException -> L24
        InputStream r9 = r3.a;     // Catch: IOException -> L24
        if (r9 != null) goto L21;
        return null;
    L21:
        if (r9.available() <= 0) goto L32;
        tt5.a.b("DriveImageDownloader", " downloadDrive success from lru cache use other key");     // Catch: IOException -> L24
        r3.c = "2";     // Catch: IOException -> L24
        r3.e = 0;     // Catch: IOException -> L24
        return r3;
    L32:
        return null;
    L17:
        r8 = r7.e.toLowerCase();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        tt5.a.f("DriveImageDownloader", e, false);
        return null;
    }

    @Override // w85.c
    public final void a(List<w85.a> r27, w85.a.b r28) {
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((ArrayList) r27).iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        w85.a r4 = (w85.a) r3.next();
        w85.a.C0319a r5 = new w85.a.C0319a();
        r5.a = true;
        r5.b = r4.b;
        r5.d = r4.d;
        r5.g = ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).c(r4.j);
        r5.h = r4.i;
        r5.i = r4.j;
        r5.k = r4.k;
        r5.j = r28;
        w85.a r6 = new w85.a(r5);
        if (r28 == null) goto L8;
        r28.e(r4.d);
    L8:
        w85.b r7 = h(r6);
        if (r7 != null) goto L10;
        r2.add(r6);
        goto L4
    L10:
        if (r28 == null) goto L4;
        r28.c(r4.d, r7);
        goto L4
    L13:
        ArrayList r1 = new ArrayList();
        Iterator r8 = r2.iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        final w85.a r9 = (w85.a) r8.next();
        final VFSPath r10 = this.c.subPath(g(r9));
        int r11 = DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r12 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r24 = DriveBizScene.DriveBizScene_UNKNOWN;
        String r13 = r9.e;
        String r14 = r10.getRealPath();
        DownloadRequestInfo.b r16 = r9.k;
        String r17 = r9.g;
        DownloadCallback r18 = new DriveImageDownloader$2(this, r9, r10);
        r1.add(new DownloadRequestInfo(r14, r13, "", r17, r11, "", r9.b, "", 0, false, r9.i, r9.j, r18, r16, false, null, null, r24, null));
        goto L15
    L17:
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().u(r1);
    }

    @Override // w85.c
    public final w85.b c(String r2, DownloadRequestInfo.DownloadType r3) {
        w85.a.C0319a r0 = new w85.a.C0319a();
        r0.e = r2;
        r0.b = r3;
        return h(r0.a());
    }

    public final void f(String r4, w85.b r5) {
        znc.m r1 = this.a;     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Exception -> L9
        File r6 = r1.e(r4);     // Catch: Exception -> L9
        if (r6 == null) goto L15;
        r5.a = ay4.d.a().t(r6).toFile().newInputStream();     // Catch: Exception -> L9
        r5.b = r6;     // Catch: Exception -> L9
        r5.d = r6.length();     // Catch: Exception -> L9
        r5.c = DiagramData$RESULT.FAIL;     // Catch: Exception -> L9
        r5.e = 0;     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.e("DriveImageDownloader", "fillDownLoadResult exception!", e, false);
    }

    public static void e(q r1, String r2, w85.b r3, String r4, w85.a r5) {
        r1.getClass();
        if (r5.h == null) goto L19;
        r1.f(r2, r3);
        InputStream r6 = r3.a;     // Catch: IOException -> L12
        if (r6 != null) goto L8;
    L10:
        r5.h.a(r5.d, r4, -1);     // Catch: IOException -> L12
    L15:
        return;
    L8:
        if (r6.available() <= 0) goto L10;
        r5.h.c(r5.d, r3);     // Catch: IOException -> L12
    L12:
        e = move-exception;
        r5.h.a(r5.d, r4, -1);
        tt5.a.e("DriveImageDownloader", "download success, but io error occurred", e, false);
        return;
    }
}
