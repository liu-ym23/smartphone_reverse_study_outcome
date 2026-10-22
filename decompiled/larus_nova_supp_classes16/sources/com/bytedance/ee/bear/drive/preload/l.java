package com.bytedance.ee.bear.drive.preload;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l extends IDownloader.ICallback<f85.a> {
    public boolean a;
    public final /* synthetic */ DriveOfflineDoc b;
    public final /* synthetic */ f85.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ m.a f;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onFailure(DriveException r3) {
        this.f.b(r3, this.b);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onHitCache(w75.c<f85.a> r2) {
        onSuccess(null, ((f85.a.C0229a) ((f85.a) r2.getDetails()).a).p);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onNoDownload(w75.c<f85.a> r2) {
        tt5.a.h("DrivePreloadExecutor", "onNoDownloadCompleted");
        this.f.c(false);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onServerTransform(w75.c<f85.a> r2) {
        tt5.a.h("DrivePreloadExecutor", "onServerTransform");
        this.f.c(false);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onSubmit(String r2) {
        ((CopyOnWriteArrayList) this.f.i).add(r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onRustFailed(String r3, int r4) {
        tt5.a.d("DrivePreloadExecutor", "rust on failed, key=" + r3 + " errorCode=" + r4);
        com.bytedance.ee.bear.drive.report.a r5 = this.f.m.c;
        f85.a r0 = this.c;
        r5.getClass();
        if (r4 == 1000) goto L7;
        r5.o(com.bytedance.ee.bear.drive.report.c.e(r0), r4, 4);
    L7:
        if (this.a == true) goto L10;
        this.a = true;
        this.f.c(true);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onSuccess(String r3, String r4) {
        if (this.a == false) goto L6;
        tt5.a.h("DrivePreloadExecutor", "mIsDone before");
        return;
    L6:
        this.a = true;
        if (TextUtils.isEmpty(r3) == true) goto L13;
        tt5.a.h("DrivePreloadExecutor", "download done");
        f85.a r5 = this.c;
        int r0 = 2;
        if (r5.m == 2) goto L12;
        r0 = 0;
    L12:
        f85.a.C0229a r6 = (f85.a.C0229a) r5.a;
        v85.c.a r7 = new v85.c.a();
        r7.a = r0;
        r7.b = this.d;
        r7.c = r6.a;
        r7.d = r6.b;
        r7.c(this.c.a());
        r7.d(this.c.b());
        f85.a r1 = this.c;
        r7.g = r1.r;
        r7.h = r6.p;
        r7.i = this.e;
        r7.j = r1.f;
        r7.k = r1.h;
        r7.l = this.f.a.getPreviewFileSourceType();
        r7.n = r6.g;
        r7.o = this.c.e();
        r7.p = r6.s;
        v85.c r8 = new v85.c(r7);
        m.a r9 = this.f;
        r9.f.m(r8, r9.m.f.b).subscribeOn(fo5.d.b()).subscribe(new j(this), new k(this));
        return;
    L13:
        tt5.a.h("DrivePreloadExecutor", "download hit cache");
        this.f.c(true);
    }

    public l(m.a r1, DriveOfflineDoc r2, f85.a r3, String r4, String r5) {
        this.f = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = false;
    }
}
