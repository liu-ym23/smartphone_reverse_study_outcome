package g15;

import android.net.Uri;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements rw4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rw4.a f479610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e f479611b;

    @Override // rw4.a
    public final void onDismiss() {
        this.f479610a.onDismiss();
    }

    @Override // rw4.a
    public final void onExportStart() {
        this.f479610a.onExportStart();
    }

    @Override // rw4.a
    public final void onStartDownload() {
        this.f479610a.onStartDownload();
    }

    @Override // rw4.a
    public final void onStartPolling() {
        this.f479610a.onStartPolling();
    }

    @Override // rw4.a
    public final void onDownloading(int r100) {
        this.f479610a.onDownloading(r100);
    }

    @Override // rw4.a
    public final void onPolling(int r100) {
        this.f479610a.onPolling(r100);
    }

    @Override // rw4.a
    public final void onSuccess(Uri r100) {
        com.bytedance.ee.bear.document.export.e r101 = this.f479611b;
        r101.f219751l = 0;
        r101.f219752m = null;
        this.f479610a.onSuccess(r100);
    }

    public v(com.bytedance.ee.bear.document.export.e r100, rw4.a r101) {
        this.f479611b = r100;
        this.f479610a = r101;
    }

    @Override // rw4.a
    public final void onFail(int r100, Throwable r101) {
        com.bytedance.ee.bear.document.export.e.c(this.f479611b, r100, r101);
        this.f479610a.onFail(r100, r101);
    }
}
