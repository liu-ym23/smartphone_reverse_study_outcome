package com.lynx.tasm.core.resource;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.i;
import com.lynx.tasm.q;
import com.lynx.tasm.q0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.utils.UIThreadUtils;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import d8a.d;
import d8a.e;
import d8a.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import l7a.f;
import l7a.g;
import l7a.h;
import l7a.j;

/* JADX INFO: loaded from: classes32.dex */
public class LynxResourceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f383305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f383306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f383307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f8a.a f383308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<i> f383309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0 f383310f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f383311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f383312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f383313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LynxResourceLoader f383314d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f383314d.e(this.f383311a, this.f383312b, this.f383313c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LynxResourceLoader r100, long r101, String r102, int r103) {
            this.f383314d = r100;
            this.f383311a = r101;
            this.f383312b = r102;
            this.f383313c = r103;
        }
    }

    public class b implements e8a.a<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l7a.b f383315a;

        @Override // e8a.a
        public final void onResponse(LynxResourceResponse<byte[]> r100) {
            int r101 = 0;
            if (r100.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L5;
            boolean r102 = true;
        L6:
            Throwable r103 = r100.f383710c;
            l7a.b r104 = this.f383315a;
            byte[] r105 = r100.f383709b;
            if (r103 == null) goto L9;
            String r106 = r103.getMessage();
        L11:
            if (r104.a() == true) goto L14;
            return;
        L14:
            if (r102 == false) goto L21;
            LLog.i("LynxResourceLoader", "load resource success with url: " + r104.f507879b);
            if (r105 != null) goto L18;
        L19:
            r106 = "get null data for provider.";
            r101 = 30301;
        L20:
            LynxResourceLoader.a(r104.f507877c, r105, r101, r106);
            return;
        L18:
            if (r105.length != 0) goto L20;
        L21:
            LLog.i("LynxResourceLoader", "load resource failed with url: " + r104.f507879b + " error message: " + r106);
            LynxResourceLoader.a(r104.f507877c, null, 30301, r106 + ": " + r106);
            return;
        L9:
            r106 = "";
            goto L11
        L5:
            r102 = false;
            goto L6
        }

        public b(String r100, long r101) {
            this.f383315a = new l7a.b(r100, r101);
        }
    }

    private native void nativeConfigLynxResourceSetting();

    public static native void nativeInvokeCallback(long r100, byte[] r101, long r102, ByteBuffer r103, int r104, String r105);

    public static byte[] d(String r110) {
        String r100 = r110.substring(14);
    L32:
        th = th;
        InputStream r101 = null;
    L61:
        LLog.e("LynxResourceLoader", "loadLynxJSAsset " + r110 + "with error message " + th.getMessage());     // Catch: Throwable -> L43
        if (r101 != null) goto L56;
    L41:
        LLog.e("LynxResourceLoader", "loadLynxJSAsset failed, can not load ".concat(r110));
        return null;
    L56:
        r101.close();     // Catch: IOException -> L38
    L38:
        IOException e100 = e;
        StringBuilder r102 = new StringBuilder("loadLynxJSAsset inputStream close error: ");
    L40:
        r102.append(e100.getMessage());
        LLog.e("LynxResourceLoader", r102.toString());
    L43:
        th = move-exception;
        if (r101 != null) goto L52;
    L49:
        throw th;
    L52:
        r101.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        LLog.e("LynxResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
        goto L49
    L5:
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L58;
    L11:
        r101 = null;
    L12:
        if (r101 == null) goto L63;
    L14:
        if (r101 == null) goto L27;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        byte[] r104 = new byte[4096];     // Catch: Throwable -> L19
    L16:
        int r105 = r101.read(r104);     // Catch: Throwable -> L19
        if (r105 == (-1)) goto L21;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L19
        goto L16
    L21:
        byte[] r111 = r103.toByteArray();     // Catch: Throwable -> L19
        r101.close();     // Catch: IOException -> L24
    L26:
        return r111;
    L24:
        e = move-exception;
        LLog.e("LynxResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
    L19:
        th = th;
        goto L61
    L27:
        if (r101 == null) goto L41;
        r101.close();     // Catch: IOException -> L30
    L30:
        e100 = e;
        r102 = new StringBuilder("loadLynxJSAsset inputStream close error: ");
        goto L40
    L63:
        r101 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r100);     // Catch: Throwable -> L19
        goto L14
    L58:
        String[] r106 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: IOException -> L10 Throwable -> L32
        if (r106.length != 2) goto L11;
        r101 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r106[0] + "_dev." + r106[1]);     // Catch: IOException -> L10 Throwable -> L32
        goto L11
    }

    public final k c(int r100) {
        q r101 = this.f383305a;
        if (r101 != null) goto L5;
        k r102 = null;
    L13:
        if (r102 != null) goto L15;
        LLog.e("LynxResourceLoader", "lynx resource provider is null, type: " + r100);
    L15:
        return r102;
    L5:
        if (r100 != 7) goto L7;
        String r103 = "DYNAMIC_COMPONENT";
    L11:
        r102 = (k) ((HashMap) r101.f383554e).get(r103);
        goto L13
    L7:
        if (r100 == 9) goto L9;
        r103 = "";
        goto L11
    L9:
        r103 = "EXTERNAL_JS_SOURCE";
        goto L11
    }

    public final boolean b(long r110, String r111, LynxResourceRequest.LynxResourceType r112) {
        if (this.f383307c.f507897a == null) goto L5;
        boolean r100 = true;
    L6:
        LLog.i("LynxResourceLoader", "Generic template fetcher existed: " + r100);
        if (r100 == true) goto L9;
        return false;
    L9:
        this.f383307c.f507897a.b(new LynxResourceRequest(r111, r112), new l7a.i(new l7a.k(r111, r110, this.f383310f, r112)));
        return true;
    L5:
        r100 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(long r110, String r111, int r210) {
        String r100 = null;
        if (r210 != 7) goto L5;
        LynxResourceRequest.LynxResourceType r101 = LynxResourceRequest.LynxResourceType.LynxResourceTypeDynamicComponent;
        if (b(r110, r111, r101) == true) goto L140;
        e r102 = this.f383306b;
        l7a.e r103 = new l7a.e(this, r111, r110, r101);
        if (r102.f467437a == null) goto L101;
        TraceEvent.beginSection("Using DynamicComponentFetcher");
        r102.f467437a.loadDynamicComponent(r111, new d(r103));
        TraceEvent.endSection("Using DynamicComponentFetcher");
        boolean r104 = true;
    L102:
        if (r104 == true) goto L141;
        k r105 = c(7);
        if (r105 != null) goto L107;
        boolean r106 = false;
    L108:
        if (r106 == true) goto L142;
        a(r110, null, -1, "No available provider or fetcher.");
        return;
    L142:
        return;
    L107:
        r105.request(new com.lynx.tasm.provider.LynxResourceRequest(r111), new f(this, r111, r110, r101));
        r106 = true;
        goto L108
    L141:
        return;
    L101:
        r104 = false;
        goto L102
    L140:
        return;
    L5:
        if (r210 != 9) goto L7;
        f8a.a r107 = this.f383308d;
        if (r107 == null) goto L85;
        r107.a(new LynxResourceRequest(r111, LynxResourceRequest.LynxResourceType.LynxResourceTypeExternalJSSource), new g(this, r111, r110));
        boolean r108 = true;
    L86:
        if (r108 == true) goto L138;
        k r109 = c(9);
        if (r109 != null) goto L91;
        boolean r112 = false;
    L92:
        if (r112 == true) goto L139;
        a(r110, null, -1, "No available provider or fetcher.");
        return;
    L139:
        return;
    L91:
        r109.request(new com.lynx.tasm.provider.LynxResourceRequest(r111), new h(this, r111, r110));
        r112 = true;
        goto L92
    L138:
        return;
    L85:
        r108 = false;
        goto L86
    L7:
        if (r210 == 11) goto L16;
        if (r210 == 15) goto L12;
        a(r110, null, -1, "Unsupported type" + r210);
        return;
    L12:
        if (b(r110, r111, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate) == true) goto L137;
        a(r110, null, -1, "No available provider or fetcher.");
        return;
    L137:
        return;
    L16:
        if (TextUtils.isEmpty(r111) == false) goto L19;
        LLog.w("LynxResourceLoader", "loadJSSource failed with empty name");
    L75:
        byte[] r113 = r100;
    L76:
        a(r110, r113, 0, r100);
        return;
    L19:
        LLog.i("LynxResourceLoader", "loadJSSource with name " + r111);
    L66:
        th = th;
        InputStream r114 = null;
    L119:
        String r115 = th.getMessage();     // Catch: Throwable -> L77
        if (r114 != null) goto L115;
    L73:
        if (r115 == null) goto L75;
        UIThreadUtils.runOnUiThread(new l7a.d(this, 30302, "loadLocalResource", "Error when loading js source", r115, r111));
        LLog.e("LynxResourceLoader", "loadJSSource " + r111 + "with error message: " + r115);
        goto L75
    L115:
        r114.close();     // Catch: IOException -> L72
    L77:
        th = move-exception;
        if (r114 == null) goto L131;
        r114.close();     // Catch: IOException -> L114
        throw th;
    L132:
        throw th;
    L131:
        throw th;
    L21:
        if ("assets://lynx_core.js".equals(r111) == true) goto L23;
    L31:
        r114 = null;
    L32:
        if (r114 == null) goto L34;
    L53:
        if (r114 == null) goto L63;
        ByteArrayOutputStream r116 = new ByteArrayOutputStream();     // Catch: Throwable -> L58
        byte[] r117 = new byte[4096];     // Catch: Throwable -> L58
    L55:
        int r118 = r114.read(r117);     // Catch: Throwable -> L58
        if (r118 == (-1)) goto L60;
        r116.write(r117, 0, r118);     // Catch: Throwable -> L58
        goto L55
    L60:
        byte[] r119 = r116.toByteArray();     // Catch: Throwable -> L58
    L123:
        r114.close();     // Catch: IOException -> L113
    L62:
        r100 = null;
        r113 = r119;
        goto L76
    L63:
        if (r114 == null) goto L75;
        r114.close();     // Catch: IOException -> L112
        goto L75
    L34:
        if (r111.length() <= 7) goto L43;
        if (r111.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L43;
        String r120 = r111.substring(7);     // Catch: Throwable -> L58
        if (r120.startsWith(HTTP.URL_DEFAULT) == false) goto L40;
        PolarisFileWrapper r121 = new PolarisFileWrapper(r120);     // Catch: Throwable -> L58
    L41:
        InputStream r122 = new PolarisFileInputStreamWrapper(r121);     // Catch: Throwable -> L58
    L47:
        r114 = r122;
        goto L53
    L40:
        r121 = new PolarisFileWrapper(LynxEnv.inst().getAppContext().getFilesDir(), r120);     // Catch: Throwable -> L58
    L43:
        if (r111.length() <= 9) goto L49;
        if (r111.startsWith("assets://") == false) goto L49;
        r122 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r111.substring(9));     // Catch: Throwable -> L58
    L49:
        if (r111.startsWith("lynx_assets://") == false) goto L53;
        r119 = d(r111);     // Catch: Throwable -> L58
        if (r114 == null) goto L62;
    L23:
        if (LynxEnv.inst().isDevtoolEnabled() == false) goto L31;
        r114 = LynxEnv.inst().getAppContext().getResources().getAssets().open("lynx_core_dev.js");     // Catch: IOException -> L26 Throwable -> L66
    L29:
        if (r114 == null) goto L32;
        nativeConfigLynxResourceSetting();     // Catch: Throwable -> L58
    L58:
        th = th;
        goto L119
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        r114 = null;
        goto L29
    }

    public void loadBytecode(long r100, String r101, int r102) {
        if (r102 == 16) goto L5;
        return;
    L5:
        if (this.f383308d == null) goto L8;
        LynxResourceRequest.LynxResourceType r103 = LynxResourceRequest.LynxResourceType.LynxResourceTypeGeneric;
        new b(r101, r100).onResponse(LynxResourceResponse.a(new Throwable("fetchBytecode is not implemented.")));
        return;
    L8:
        a(r100, null, -1, "No available provider or fetcher.");
    }

    public static void a(long r100, byte[] r110, int r111, String r112) {
        nativeInvokeCallback(r100, r110, 0, null, r111, r112);
    }

    private void loadResource(long r100, String r110, int r111, boolean r112) {
        if (r112 == false) goto L9;
        e(r100, r110, r111);
        return;
    L9:
        LynxThreadPool.b().execute(new a(this, r100, r110, r111));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(r100, null, -1, th.getMessage());
    }

    public LynxResourceLoader(q r100, k7a.a r101, i r102, h8a.a r103, f8a.a r104) {
        this.f383310f = new q0();
        this.f383305a = r100;
        this.f383306b = new e(r101);
        this.f383309e = new WeakReference(r102);
        this.f383307c = new j(r103);
        this.f383308d = r104;
    }
}
