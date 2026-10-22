package com.lynx.canvas.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonLoaderService;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class CanvasResourceLoader {
    private static final String TAG = "KryptonCanvasResourceLoader";
    WeakReference<KryptonApp> mWeakKryptonApp;

    private KryptonLoaderService getLoaderService() {
        KryptonApp r100 = this.mWeakKryptonApp.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return (KryptonLoaderService) r100.getService(KryptonLoaderService.class);
    }

    public CanvasResourceLoader(KryptonApp r100) {
        this.mWeakKryptonApp = new WeakReference(r100);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_lynx_canvas_loader_CanvasResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private KryptonLoaderService.LoadPolicy parseLoadPolicy(int r100) {
        KryptonLoaderService.LoadPolicy[] r101 = KryptonLoaderService.LoadPolicy.values();
        if (r100 < 0) goto L10;
        if (r100 >= r101.length) goto L10;
        return r101[r100];
    L10:
        return KryptonLoaderService.LoadPolicy.DEFAULT_ASYNC;
    }

    public Bitmap decodeDataURLSync(String r100) {
        if (r100.startsWith(fyb.a.KEY_DATA) == true) goto L5;
    L15:
        KryptonLLog.e(TAG, "decode DataURL failed, not data url");
        return null;
    L5:
        if (r100.indexOf("base64,") == (-1)) goto L15;
        byte[] r101 = Base64.decode(r100.substring(r100.indexOf("base64,") + 7), 0);     // Catch: Exception -> L9
        Bitmap r102 = BitmapFactory.decodeByteArray(r101, 0, r101.length);     // Catch: Exception -> L9
    L11:
        if (r102 != null) goto L14;
        KryptonLLog.e(TAG, "decode data url failed, bitmap = null ");
        return null;
    L14:
        return r102;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, "decode data url failed, throw exception " + e);
        r102 = null;
        goto L11
    }

    public Bitmap loadImageSync(String r100) {
        if (r100 != null) goto L6;
        KryptonLLog.e(TAG, "url empty");
        return null;
    L6:
        KryptonLoaderService r101 = getLoaderService();
        if (r101 != null) goto L10;
        KryptonLLog.e(TAG, "loaderService not found");
        return null;
    L10:
        byte[] r102 = r101.loadUrlSync(r100);
        if (r102 != null) goto L14;
        KryptonLLog.e(TAG, "loadUrlSync return null");
        return null;
    L14:
        Bitmap r103 = BitmapFactory.decodeByteArray(r102, 0, r102.length);
        if (r103 != null) goto L18;
        KryptonLLog.e(TAG, "loadImageSync failed, bitmap = null ");
        return null;
    L18:
        return r103;
    }

    public void onGetSupportedExtensions(String[] r100) {
        KryptonLoaderService r101 = getLoaderService();
        if (r101 == null) goto L6;
        r101.onGetSupportedExtensions(r100);
        return;
    }

    public String redirectUrl(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        KryptonLoaderService r101 = getLoaderService();
        if (r101 == null) goto L10;
        String r102 = r101.redirectUrl(r100);
        if (r102 == null) goto L10;
        return r102;
    L10:
        return r100;
    }

    public void loadImage(String r100, long r101) {
        final CanvasResourceResolver r102 = new CanvasResourceResolver(r101, r100);
        if (r100 != null) goto L6;
        rejectWithErrorMessage("url empty", r102, false);
        return;
    L6:
        KryptonLoaderService r103 = getLoaderService();
        if (r103 != null) goto L10;
        rejectWithErrorMessage("loaderService not found", r102, false);
        return;
    L10:
        r103.loadUrlWithImageResolver(r100, new AnonymousClass1(this, r102));
    }

    private void rejectWithErrorMessage(String r100, CanvasResourceResolver r101, boolean r102) {
        KryptonLLog.e(TAG, r100);
        if (r102 == false) goto L5;
        r101.resolveStreamLoadEnd(false, r100);
        return;
    L5:
        r101.reject(r100);
    }

    private void streamLoadAssets(String r100, final CanvasResourceResolver r101, KryptonLoaderService r102) {
        r102.loadUrlWithStreamDelegate(r100, new AnonymousClass5(this, r101));
    }

    public void loadAssets(String r100, long r101, boolean r110) {
        loadAssetsWithPolicy(r100, r101, r110, KryptonLoaderService.LoadPolicy.DEFAULT_ASYNC.ordinal());
    }

    public static /* synthetic */ void access$000(CanvasResourceLoader r100, String r101, CanvasResourceResolver r102, boolean r103) {
        r100.rejectWithErrorMessage(r101, r102, r103);
    }

    public void loadAssetsWithPolicy(String r100, long r101, final boolean r102, int r103) {
        final CanvasResourceResolver r104 = new CanvasResourceResolver(r101, r100);
        if (r100 != null) goto L6;
        KryptonLLog.e(TAG, "Url is required!");
        rejectWithErrorMessage("url empty", r104, r102);
        return;
    L6:
        KryptonLoaderService r105 = getLoaderService();
        if (r105 != null) goto L10;
        KryptonLLog.e(TAG, "Loader service not founded!");
        rejectWithErrorMessage("loaderService not found", r104, r102);
        return;
    L10:
        if (r102 == true) goto L16;
    L14:
        KryptonLoaderService.LoadPolicy r106 = parseLoadPolicy(r103);
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] loadAssetsWithPolicy enter, policy=" + r106 + ", streamLoad=" + r102 + ", url=" + KryptonResourceUtils.getTruncatePath(r100) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        StringBuilder r107 = new StringBuilder("[readFilePreferCurrentThread] dispatch to loaderService=");
        r107.append(r105.getClass().getSimpleName());
        r107.append(", policy=");
        r107.append(r106);
        KryptonLLog.i(TAG, r107.toString());
        r105.loadUrlWithDataResolverWithPolicy(r100, new AnonymousClass3(this, r104, r102), r106);
        return;
    L16:
        KryptonLLog.i(TAG, "Load stream assets.");     // Catch: UnsupportedOperationException -> L13
        streamLoadAssets(r100, r104, r105);     // Catch: UnsupportedOperationException -> L13
        return;
    L13:
        KryptonLLog.i(TAG, "do not support stream load");
        goto L14
    }

    public void loadImageWithOptions(String r100, boolean r101, boolean r102, long r103) {
        final CanvasResourceResolver r104 = new CanvasResourceResolver(r103, r100);
        if (r100 != null) goto L5;
    L16:
        rejectWithErrorMessage("url empty", r104, false);
        return;
    L5:
        if (r100.isEmpty() == true) goto L16;
        KryptonLoaderService r105 = getLoaderService();
        if (r105 != null) goto L11;
        rejectWithErrorMessage("loaderService not found", r104, false);
        return;
    L11:
        KryptonLoaderService.ImageResolver r106 = new AnonymousClass2(this, r104);
        KryptonLoaderService.ImageLoadOptions r107 = new KryptonLoaderService.ImageLoadOptions(r101, r102);
        KryptonLLog.i(TAG, "loadImageWithOptions " + r100 + " " + r107);     // Catch: UnsupportedOperationException -> L14
        r105.loadImageWithOptions(r100, r107, r106);     // Catch: UnsupportedOperationException -> L14
        return;
    L14:
        KryptonLLog.e(TAG, "loadImageWithOptions not supported, fallback to loadUrlWithImageResolver ".concat(r100));
        r105.loadUrlWithImageResolver(r100, r106);
    }

    public byte[] encodeBitmap(ByteBuffer r100, int r101, int r102, int r103, float r104) {
        if (r101 != 0) goto L6;
        Bitmap.CompressFormat r105 = Bitmap.CompressFormat.PNG;
    L8:
        Bitmap r106 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);
        r106.copyPixelsFromBuffer(r100);
        ByteArrayOutputStream r107 = new ByteArrayOutputStream(((r102 * r103) / 4) + 256);
        if (r106.compress(r105, Math.round(r104 * 100.0f), r107) == true) goto L11;
    L12:
        return null;
    L11:
        return r107.toByteArray();
    L6:
        if (r101 != 1) goto L12;
        r105 = Bitmap.CompressFormat.JPEG;
        goto L8
    }

    public void loadAssetsRange(String r100, final int r110, final int r111, long r112, final boolean r113) {
        final CanvasResourceResolver r101 = new CanvasResourceResolver(r112, r100);
        if (r100 != null) goto L6;
        KryptonLLog.e(TAG, "Url is required!");
        rejectWithErrorMessage("url empty", r101, r113);
        return;
    L6:
        KryptonLoaderService r114 = getLoaderService();
        if (r114 != null) goto L10;
        KryptonLLog.e(TAG, "Loader service not founded!");
        rejectWithErrorMessage("loaderService not found", r101, r113);
        return;
    L10:
        if (r111 >= r110) goto L14;
        KryptonLLog.e(TAG, "end less than start!");
        rejectWithErrorMessage("end less than start", r101, r113);
        return;
    L14:
        if (r100.startsWith(UriUtil.LOCAL_ASSET_SCHEME) == false) goto L30;
        r114.loadUrlWithDataResolver(r100, new AnonymousClass4(this, r101, r110, r111, r113));
        return;
    L30:
        HttpURLConnection r102 = (HttpURLConnection) INVOKEVIRTUAL_com_lynx_canvas_loader_CanvasResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));     // Catch: IOException -> L28
        r102.setRequestMethod("GET");     // Catch: IOException -> L28
        r102.setRequestProperty("Range", "bytes=" + r110 + "-" + r111);     // Catch: IOException -> L28
        r102.connect();     // Catch: IOException -> L28
        int r115 = r102.getResponseCode();     // Catch: IOException -> L28
        if (r115 != 206) goto L25;
        BufferedInputStream r116 = new BufferedInputStream(r102.getInputStream());     // Catch: IOException -> L28
        ByteArrayOutputStream r117 = new ByteArrayOutputStream();     // Catch: IOException -> L28
        byte[] r118 = new byte[1024];     // Catch: IOException -> L28
    L21:
        int r119 = r116.read(r118);     // Catch: IOException -> L28
        if (r119 == (-1)) goto L24;
        r117.write(r118, 0, r119);     // Catch: IOException -> L28
        goto L21
    L24:
        r101.resolve(r117.toByteArray(), 0, r117.toByteArray().length);     // Catch: IOException -> L28
        r117.close();     // Catch: IOException -> L28
        r116.close();     // Catch: IOException -> L28
    L26:
        r102.disconnect();     // Catch: IOException -> L28
        return;
    L25:
        r101.reject("load failed " + r115);     // Catch: IOException -> L28
    L28:
        rejectWithErrorMessage("load from net failed", r101, false);
    }

    public byte[] overrideTextureUpload(int r210, int r211, int r212, int r213, int r214, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, long r318, long r410, int r411, long r412, ByteBuffer r413) {
        KryptonLoaderService r100 = getLoaderService();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.overrideTextureUpload(new KryptonLoaderService.TextureUploadRequest(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413));
    }
}
