package z45;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveManualResponseEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r0 extends IDownloader.ICallback<f85.a> {
    public final /* synthetic */ com.bytedance.ee.bear.drive.services.w.b a;
    public final /* synthetic */ pw4.d b;
    public final /* synthetic */ String c;
    public final /* synthetic */ f85.a d;
    public final /* synthetic */ j0 e;

    public static void a(String r2) {
        ArrayList r0 = new ArrayList();
        r0.add(r2);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).l(r0).subscribe(new p0(), new q0());
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onFailure(DriveException r5) {
        j0 r0 = this.e;
        com.bytedance.ee.bear.drive.services.w.b r1 = this.a;
        f85.a r2 = this.d;
        String r3 = this.c;
        r0.getClass();
        j0.i(r5, r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onHitCache(w75.c<f85.a> r2) {
        onSuccess(null, ((f85.a.C0229a) ((f85.a) r2.getDetails()).a).p);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onNoDownload(w75.c<f85.a> r5) {
        super.onNoDownload(r5);
        tt5.a.d("DRIVE_MANUAL_CACHE", "receive onNoDownloadCompleted");
        j0.d(this.e, this.a, r5, this.b.a, this.c);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onProgress(int r13) {
        f85.a.C0229a r0 = (f85.a.C0229a) this.d.a;
        if (TextUtils.isEmpty(r0.a) == true) goto L5;
        String r1 = r0.a;
    L6:
        DriveManualResponseEntity r2 = new DriveManualResponseEntity(4, r1, r13, this.c, 0, "", r0.c, r0.k);
        tt5.a.h("DRIVE_MANUAL_CACHE", "updateProgress p=" + r13);
        com.bytedance.ee.bear.drive.services.w.b r14 = this.a;
        if (r14 == null) goto L10;
        ((h85.u) r14).a(r2);
        return;
    L10:
        return;
    L5:
        r1 = this.b.a;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onServerTransform(final w75.c<f85.a> r13) {
        tt5.a.d("DRIVE_MANUAL_CACHE", "receive onStreamingUrlCompleted");
        if (i75.h.c(this.e.l, ((f85.a.C0229a) ((f85.a) r13.getDetails()).a).k, ((f85.a) r13.getDetails()).f) == false) goto L6;
        final com.bytedance.ee.bear.drive.view.preview.excel.b r0 = this.e.k;
        final f85.a r1 = (f85.a) r13.getDetails();
        r0.getClass();
        Flowable r2 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new com.bytedance.ee.bear.drive.view.preview.excel.a(r0, r1));
        final pw4.d r7 = this.b;
        final String r8 = this.c;
        final com.bytedance.ee.bear.drive.services.w.b r9 = this.a;
        r2.subscribe(new n0(this, r13, r7, r8, r9), new o0(this, r9, r13, r7, r8));
        return;
    L6:
        j0.d(this.e, this.a, r13, this.b.a, this.c);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onSubmit(String r3) {
        Map<String, String> r0 = this.e.b;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(((f85.a.C0229a) this.d.a).a, r3);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onRustFailed(String r18, int r19) {
        tt5.a.d("DRIVE_MANUAL_CACHE", "rust onFailed, key=" + r18 + " code=" + r19);
        if (r19 != 1000) goto L5;
        return;
    L5:
        f85.a.C0229a r3 = (f85.a.C0229a) this.d.a;
        if (TextUtils.isEmpty(r3.a) == true) goto L8;
        String r6 = r3.a;
    L9:
        DriveManualResponseEntity r7 = new DriveManualResponseEntity(0, r6, 0, this.c, 503, "rust return failed, key=" + r18 + " code=" + r19, r3.c, r3.k);
        if (r19 == 1010) goto L12;
        Context r0 = this.e.g;     // Catch: Throwable -> L17
        if (z75.b.f(com.bytedance.ee.bear.drive.cache.t.f(), this.e.p.b).getFreeSpace() >= ((f85.a.C0229a) this.d.a).c) goto L24;
        tt5.a.d("DRIVE_MANUAL_CACHE", "user phone space not enough");     // Catch: Throwable -> L17
        r7.e = 502;     // Catch: Throwable -> L17
    L24:
    L19:
        com.bytedance.ee.bear.drive.services.w.b r1 = this.a;
        if (r1 == null) goto L22;
        ((h85.u) r1).a(r7);
    L22:
        ((ConcurrentHashMap) this.e.o).remove(this.b.a);
        return;
    L12:
        r7.e = 508;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        tt5.a.f("DRIVE_MANUAL_CACHE", th, false);
        goto L19
    L8:
        r6 = this.b.a;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onSuccess(String r12, String r13) {
        tt5.a.h("DRIVE_MANUAL_CACHE", "updateProgress finish, download size=" + ((f85.a.C0229a) this.d.a).c);
        String r14 = (String) ((ConcurrentHashMap) this.e.o).get(this.b.a);
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        com.bytedance.ee.bear.drive.report.c r1 = this.e.n;
        f85.a.C0229a r2 = (f85.a.C0229a) this.d.a;
        r1.w(r14, "finish_download", r2.a, r2.k);
        if (TextUtils.isEmpty(r12) == true) goto L8;
        j0.a(this.e, this.d, this.b.a, this.c, this.a, false);
    L16:
        ((ConcurrentHashMap) this.e.o).remove(this.b.a);
        return;
    L8:
        tt5.a.h("DRIVE_MANUAL_CACHE", "put cache finished, it alerady cached");
        if (this.a == null) goto L15;
        f85.a.C0229a r16 = (f85.a.C0229a) this.d.a;
        if (TextUtils.isEmpty(r16.a) == true) goto L13;
        String r17 = r16.a;
    L14:
        String r3 = r17;
        ((h85.u) this.a).a(new DriveManualResponseEntity(5, r3, 100, this.c, 0, "", r16.c, r16.k));
        goto L15
    L13:
        r17 = this.b.a;
    L15:
        a(((f85.a.C0229a) this.d.a).a);
        goto L16
    }

    public r0(j0 r1, com.bytedance.ee.bear.drive.services.w.b r2, pw4.d r3, String r4, f85.a r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
