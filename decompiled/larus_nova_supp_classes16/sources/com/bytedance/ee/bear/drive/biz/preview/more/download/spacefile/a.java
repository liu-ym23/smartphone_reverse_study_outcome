package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.external.f;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.m;
import com.larksuite.framework.utils.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements f.d {
    public final /* synthetic */ SpaceFileDownloadManager a;
    public final /* synthetic */ AtomicReference<w75.a> b;
    public final /* synthetic */ w75.a c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.a$a, reason: collision with other inner class name */
    public static final class RunnableC0145a implements Runnable {
        public final /* synthetic */ SpaceFileDownloadManager a;

        public RunnableC0145a(SpaceFileDownloadManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.showText(this.a.a, 2131888391);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SpaceFileDownloadManager a;

        public b(SpaceFileDownloadManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.showText(this.a.a, 2131887286);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SpaceFileDownloadManager a;

        public c(SpaceFileDownloadManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.showText(this.a.a, 2131888428);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final /* synthetic */ void onDismiss() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void d() {
        tt5.a.d("DriveComponent", "onStoragePermissionDenied");
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.a(SpaceFileDownloadManager.EResult.PERMISSION_DENIED);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void f() {
        this.a.a(this.c, true);
    }

    public final void g() {
        d r1 = this.a.d;
        if (r1 == null) goto L26;
        w75.a r0 = this.b.get();
        if (r0 == null) goto L9;
        w75.b r2 = r0.c();
        if (r2 == null) goto L9;
        long r3 = r2.c;
    L10:
        long r4 = r3;
        w75.a r5 = this.b.get();
        if (r5 == null) goto L16;
        w75.b r6 = r5.c();
        if (r6 == null) goto L16;
        String r7 = r6.b;
        if (r7 == null) goto L16;
    L17:
        w75.a r8 = this.b.get();
        if (r8 == null) goto L23;
        w75.b r9 = r8.c();
        if (r9 == null) goto L23;
        String r10 = r9.k;
        if (r10 == null) goto L23;
    L24:
        d.a(r1, r7, r10, r4, 1);
        return;
    L23:
        r10 = "";
    L16:
        r7 = "";
    L9:
        r3 = 0;
        goto L10
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void b() {
        g();
        com.bytedance.ee.bear.drive.report.c r0 = o75.b.a().Ke();
        BaseOpenEntity r1 = this.a.b;
        if (r1 != null) goto L5;
        r0.getClass();
    L6:
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r2 = this.a.f;
        if (r2 == null) goto L10;
        r2.a(SpaceFileDownloadManager.EResult.USER_CANCELLED);
        return;
    L10:
        return;
    L5:
        HashMap<String, Object> r3 = r0.g(r1);
        r3.put("click", "cancel");
        r0.d.v("ccm_drive_file_download_click", r3);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void e() {
        g();
        com.bytedance.ee.bear.drive.report.c r0 = o75.b.a().Ke();
        BaseOpenEntity r1 = this.a.b;
        if (r1 != null) goto L5;
        r0.getClass();
        return;
    L5:
        HashMap<String, Object> r2 = r0.g(r1);
        r2.put("click", "finish");
        r0.d.v("ccm_drive_file_download_click", r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void a(int r7) {
        this.a.a(this.c, false);     // Catch: Throwable -> L32
        g();     // Catch: Throwable -> L32
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r2 = this.a.f;     // Catch: Throwable -> L32
        if (r2 == null) goto L6;
        r2.a(SpaceFileDownloadManager.EResult.DOWNLOAD_FAILED);     // Catch: Throwable -> L32
    L6:
        String r3 = c1.c(this.a.a, i.e(this.a.a, System.currentTimeMillis() + ".txt", "text/plain", null, null));     // Catch: Throwable -> L32
        if (r7 != 3) goto L10;
        m.a(new RunnableC0145a(this.a));     // Catch: Throwable -> L32
        return;
    L10:
        if (this.a.d(this.b.get()) == false) goto L12;
        tt5.a.k("DriveComponent", "onFileLoadingFailure() showSizeTooLargeToast");     // Catch: Throwable -> L32
        return;
    L12:
        if (r3 == null) goto L30;
        VFSFile r8 = ay4.d.a().i(r3);     // Catch: Throwable -> L32
        long r4 = 0;
        if (r8 == null) goto L18;
        File r9 = r8.getParentFile();     // Catch: Throwable -> L32
        if (r9 == null) goto L18;
        long r5 = r9.getFreeSpace();     // Catch: Throwable -> L32
    L19:
        w75.a r10 = this.b.get();     // Catch: Throwable -> L32
        if (r10 == null) goto L25;
        w75.b r11 = r10.c();     // Catch: Throwable -> L32
        if (r11 == null) goto L25;
        r4 = r11.c;     // Catch: Throwable -> L32
    L25:
        if (r5 >= r4) goto L30;
        m.a(new b(this.a));     // Catch: Throwable -> L32
        com.bytedance.ee.bear.drive.report.c r12 = o75.b.a().Ke();     // Catch: Throwable -> L32
        BaseOpenEntity r6 = this.a.b;     // Catch: Throwable -> L32
        if (r6 != null) goto L29;
        r12.getClass();     // Catch: Throwable -> L32
        return;
    L29:
        r12.d.v("ccm_drive_exceed_storage_limit_view", r12.g(r6));     // Catch: Throwable -> L32
        return;
    L18:
        r5 = 0;
    L30:
        m.a(new c(this.a));     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        tt5.a.e("DriveComponent", "onFileLoadingFailure error", th, false);
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void c(w75.a r2) {
        this.b.set(r2);
        if (this.a.d(r2) == false) goto L8;
        this.a.e.b();
        com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.c r3 = this.a.f;
        if (r3 == null) goto L9;
        r3.a(SpaceFileDownloadManager.EResult.FILE_TOO_LARGE);
        return;
    L9:
        return;
    }

    public a(SpaceFileDownloadManager r1, AtomicReference<w75.a> r2, w75.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
