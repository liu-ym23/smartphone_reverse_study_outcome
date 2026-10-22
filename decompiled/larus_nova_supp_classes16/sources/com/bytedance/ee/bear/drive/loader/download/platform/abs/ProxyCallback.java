package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import com.bytedance.ee.bear.drive.loader.model.DriveException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ProxyCallback extends IDownloader.ICallback {
    private static final String TAG = "DrivePlatform_ProxyCallback";
    private final IDownloader.ICallback callback;

    public static /* synthetic */ void a(ProxyCallback r0, String r1, int r2) {
        r0.lambda$onRustFailed$5(r1, r2);
    }

    public static /* synthetic */ void b(ProxyCallback r0, IDownloader.TransStatus r1) {
        r0.lambda$onTransStatusChanged$7(r1);
    }

    public static /* synthetic */ void c(ProxyCallback r0, String r1) {
        r0.lambda$onSubmit$6(r1);
    }

    public static /* synthetic */ void d(ProxyCallback r0, int r1) {
        r0.lambda$onProgress$4(r1);
    }

    public static /* synthetic */ void e(ProxyCallback r0, w75.c r1) {
        r0.lambda$onServerTransform$1(r1);
    }

    public static /* synthetic */ void f(ProxyCallback r0, DriveException r1) {
        r0.lambda$onFailure$3(r1);
    }

    public static /* synthetic */ void g(ProxyCallback r0, w75.c r1) {
        r0.lambda$onHitCache$2(r1);
    }

    public static /* synthetic */ void h(ProxyCallback r0, String r1, String r2) {
        r0.lambda$onSuccess$8(r1, r2);
    }

    public static /* synthetic */ void i(ProxyCallback r0, w75.c r1) {
        r0.lambda$onNoDownload$0(r1);
    }

    public ProxyCallback(IDownloader.ICallback r1) {
        this.callback = r1;
    }

    private void callbackInUIThread(Runnable r2) {
        fo5.d.d().scheduleDirect(r2);
    }

    private /* synthetic */ void lambda$onFailure$3(DriveException r2) {
        this.callback.onFailure(r2);
    }

    private /* synthetic */ void lambda$onHitCache$2(w75.c r2) {
        this.callback.onHitCache(r2);
    }

    private /* synthetic */ void lambda$onNoDownload$0(w75.c r2) {
        this.callback.onNoDownload(r2);
    }

    private /* synthetic */ void lambda$onProgress$4(int r2) {
        this.callback.onProgress(r2);
    }

    private /* synthetic */ void lambda$onServerTransform$1(w75.c r2) {
        this.callback.onServerTransform(r2);
    }

    private /* synthetic */ void lambda$onSubmit$6(String r2) {
        this.callback.onSubmit(r2);
    }

    private /* synthetic */ void lambda$onTransStatusChanged$7(IDownloader.TransStatus r2) {
        this.callback.onTransStatusChanged(r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onFailure(final DriveException r3) {
        tt5.a.d(TAG, "ProxyCallback.onFailure() exp=" + r3);
        callbackInUIThread(new g(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onHitCache(final w75.c r3) {
        tt5.a.h(TAG, "ProxyCallback.onHitCache()");
        callbackInUIThread(new i(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onNoDownload(final w75.c r3) {
        tt5.a.h(TAG, "ProxyCallback.onNoDownload()");
        callbackInUIThread(new h(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onProgress(final int r2) {
        callbackInUIThread(new f(this, r2));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onServerTransform(final w75.c r3) {
        tt5.a.h(TAG, "ProxyCallback.onServerTransform()");
        callbackInUIThread(new e(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onSubmit(final String r3) {
        tt5.a.h(TAG, "ProxyCallback.onSubmit() key=" + r3);
        callbackInUIThread(new j(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onTransStatusChanged(final IDownloader.TransStatus r3) {
        tt5.a.h(TAG, "ProxyCallback.onStatusChanged() status=" + r3);
        callbackInUIThread(new c(this, r3));
    }

    private /* synthetic */ void lambda$onRustFailed$5(String r2, int r3) {
        this.callback.onRustFailed(r2, r3);
    }

    private /* synthetic */ void lambda$onSuccess$8(String r2, String r3) {
        this.callback.onSuccess(r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onRustFailed(final String r3, final int r4) {
        tt5.a.d(TAG, "ProxyCallback.onRustFailed() key=" + r3 + ", code=" + r4);
        callbackInUIThread(new k(this, r3, r4));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public void onSuccess(final String r3, final String r4) {
        tt5.a.h(TAG, "ProxyCallback.onSuccess() key=" + r3 + ", dataVersion=" + r4);
        callbackInUIThread(new d(this, r3, r4));
    }
}
