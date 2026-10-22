package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.drive.loader.model.DriveException;

/* JADX INFO: loaded from: classes16.dex */
public class ProxyCallback extends IDownloader.ICallback {
    private static final String TAG = "DrivePlatform_ProxyCallback";
    private final IDownloader.ICallback callback;

    public static /* synthetic */ void a(ProxyCallback r100, String r101, int r102) {
        r100.lambda$onRustFailed$5(r101, r102);
    }

    public static /* synthetic */ void b(ProxyCallback r100, IDownloader.TransStatus r101) {
        r100.lambda$onTransStatusChanged$7(r101);
    }

    public static /* synthetic */ void c(ProxyCallback r100, String r101) {
        r100.lambda$onSubmit$6(r101);
    }

    public static /* synthetic */ void d(ProxyCallback r100, int r101) {
        r100.lambda$onProgress$4(r101);
    }

    public static /* synthetic */ void e(ProxyCallback r100, w75.c r101) {
        r100.lambda$onServerTransform$1(r101);
    }

    public static /* synthetic */ void f(ProxyCallback r100, DriveException r101) {
        r100.lambda$onFailure$3(r101);
    }

    public static /* synthetic */ void g(ProxyCallback r100, w75.c r101) {
        r100.lambda$onHitCache$2(r101);
    }

    public static /* synthetic */ void h(ProxyCallback r100, String r101, String r102) {
        r100.lambda$onSuccess$8(r101, r102);
    }

    public static /* synthetic */ void i(ProxyCallback r100, w75.c r101) {
        r100.lambda$onNoDownload$0(r101);
    }

    public ProxyCallback(IDownloader.ICallback r100) {
        this.callback = r100;
    }

    private void callbackInUIThread(Runnable r100) {
        fo5.d.d().scheduleDirect(r100);
    }

    private /* synthetic */ void lambda$onFailure$3(DriveException r100) {
        this.callback.onFailure(r100);
    }

    private /* synthetic */ void lambda$onHitCache$2(w75.c r100) {
        this.callback.onHitCache(r100);
    }

    private /* synthetic */ void lambda$onNoDownload$0(w75.c r100) {
        this.callback.onNoDownload(r100);
    }

    private /* synthetic */ void lambda$onProgress$4(int r100) {
        this.callback.onProgress(r100);
    }

    private /* synthetic */ void lambda$onServerTransform$1(w75.c r100) {
        this.callback.onServerTransform(r100);
    }

    private /* synthetic */ void lambda$onSubmit$6(String r100) {
        this.callback.onSubmit(r100);
    }

    private /* synthetic */ void lambda$onTransStatusChanged$7(IDownloader.TransStatus r100) {
        this.callback.onTransStatusChanged(r100);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onFailure(final DriveException r100) {
        tt5.a.d(TAG, "ProxyCallback.onFailure() exp=" + r100);
        callbackInUIThread(new g(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onHitCache(final w75.c r100) {
        tt5.a.h(TAG, "ProxyCallback.onHitCache()");
        callbackInUIThread(new i(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onNoDownload(final w75.c r100) {
        tt5.a.h(TAG, "ProxyCallback.onNoDownload()");
        callbackInUIThread(new h(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onProgress(final int r100) {
        callbackInUIThread(new f(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onServerTransform(final w75.c r100) {
        tt5.a.h(TAG, "ProxyCallback.onServerTransform()");
        callbackInUIThread(new e(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onSubmit(final String r100) {
        tt5.a.h(TAG, "ProxyCallback.onSubmit() key=" + r100);
        callbackInUIThread(new j(this, r100));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onTransStatusChanged(final IDownloader.TransStatus r100) {
        tt5.a.h(TAG, "ProxyCallback.onStatusChanged() status=" + r100);
        callbackInUIThread(new c(this, r100));
    }

    private /* synthetic */ void lambda$onRustFailed$5(String r100, int r101) {
        this.callback.onRustFailed(r100, r101);
    }

    private /* synthetic */ void lambda$onSuccess$8(String r100, String r101) {
        this.callback.onSuccess(r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onRustFailed(final String r100, final int r101) {
        tt5.a.d(TAG, "ProxyCallback.onRustFailed() key=" + r100 + ", code=" + r101);
        callbackInUIThread(new k(this, r100, r101));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onSuccess(final String r100, final String r101) {
        tt5.a.h(TAG, "ProxyCallback.onSuccess() key=" + r100 + ", dataVersion=" + r101);
        callbackInUIThread(new d(this, r100, r101));
    }
}
