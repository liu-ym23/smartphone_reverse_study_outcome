package g15;

import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements rw4.a {
    public final /* synthetic */ rw4.a a;
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e b;

    @Override // rw4.a
    public final void onDismiss() {
        this.a.onDismiss();
    }

    @Override // rw4.a
    public final void onExportStart() {
        this.a.onExportStart();
    }

    @Override // rw4.a
    public final void onStartDownload() {
        this.a.onStartDownload();
    }

    @Override // rw4.a
    public final void onStartPolling() {
        this.a.onStartPolling();
    }

    @Override // rw4.a
    public final void onDownloading(int r2) {
        this.a.onDownloading(r2);
    }

    @Override // rw4.a
    public final void onPolling(int r2) {
        this.a.onPolling(r2);
    }

    @Override // rw4.a
    public final void onSuccess(Uri r3) {
        com.bytedance.ee.bear.document.export.e r0 = this.b;
        r0.l = 0;
        r0.m = null;
        this.a.onSuccess(r3);
    }

    public v(com.bytedance.ee.bear.document.export.e r1, rw4.a r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // rw4.a
    public final void onFail(int r2, Throwable r3) {
        com.bytedance.ee.bear.document.export.e.c(this.b, r2, r3);
        this.a.onFail(r2, r3);
    }
}
