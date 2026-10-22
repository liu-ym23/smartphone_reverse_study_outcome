package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes23.dex */
public class f extends a implements Callable<d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f277236i = "f";

    public f(String r100, int r101, c r102, Context r103, String r104, GrsBaseInfo r105, com.huawei.hms.framework.network.grs.e.c r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0146: MOVE (r7 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:62:0x0146 */
    @Override // java.util.concurrent.Callable
    public d call() {
        String r100 = f277236i;
        Logger.i(r100, "Post call execute");
        long r101 = 0;
        HttpsURLConnection r102 = null;
        InputStream r103 = null;
        byte[] r104 = null;
        long r105 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L43 IOException -> L45
        r101 = System.currentTimeMillis();     // Catch: IOException -> L40 Throwable -> L43
        HttpsURLConnection r110 = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());     // Catch: IOException -> L40 Throwable -> L43
        if (r110 != null) goto L13;
        Logger.w(r100, "create HttpsURLConnection instance by url return null.");     // Catch: IOException -> L38 Throwable -> L61
        if (r110 != null) goto L85;
    L12:
        return null;
    L85:
        r110.disconnect();     // Catch: Throwable -> L10 RuntimeException -> L11
    L11:
        Logger.w(f277236i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
    L10:
        Logger.w(f277236i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
        goto L12
    L13:
        r110.setRequestProperty("Content-Type", "application/json; charset=UTF-8");     // Catch: IOException -> L38 Throwable -> L61
        r110.setRequestProperty("Connection", "close");     // Catch: IOException -> L38 Throwable -> L61
        r110.setRequestMethod("POST");     // Catch: IOException -> L38 Throwable -> L61
        r110.setDoOutput(true);     // Catch: IOException -> L38 Throwable -> L61
        r110.setDoInput(true);     // Catch: IOException -> L38 Throwable -> L61
        if (b() == null) goto L18;
        String r111 = b().a();     // Catch: IOException -> L38 Throwable -> L61
    L21:
        if (TextUtils.isEmpty(r111) == false) goto L23;
        r111 = "&";
    L23:
        r110.setRequestProperty("If-None-Match", r111);     // Catch: IOException -> L38 Throwable -> L61
        r110.connect();     // Catch: IOException -> L38 Throwable -> L61
        com.huawei.hms.framework.network.grs.h.f.a.a(r110, f().a(PromotionProductPrivilegesStruct.SERVICES, ""));     // Catch: IOException -> L38 Throwable -> L61
        int r112 = r110.getResponseCode();     // Catch: IOException -> L38 Throwable -> L61
        Logger.i(r100, "httpsURLConnection result code:" + r112);     // Catch: IOException -> L38 Throwable -> L61
        if (r112 == 200) goto L75;
    L31:
        Map r113 = r110.getHeaderFields();     // Catch: IOException -> L38 Throwable -> L61
        r110.disconnect();     // Catch: IOException -> L38 Throwable -> L61
        long r114 = SystemClock.elapsedRealtime();     // Catch: IOException -> L38 Throwable -> L61
        long r115 = System.currentTimeMillis();     // Catch: IOException -> L38 Throwable -> L61
        if (r104 != null) goto L34;
        byte[] r116 = new byte[0];     // Catch: IOException -> L38 Throwable -> L61
    L35:
        this.f277195a = new d(r112, r113, r116, r114 - r105);     // Catch: IOException -> L38 Throwable -> L61
        r110.disconnect();     // Catch: Throwable -> L69 RuntimeException -> L70
    L56:
        this.f277195a.b(c());
        this.f277195a.a(d());
        this.f277195a.b(r101);
        this.f277195a.a(r115);
        if (b() == null) goto L60;
        b().a(this.f277195a);
    L60:
        return this.f277195a;
    L54:
        Logger.w(f277236i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
    L52:
        Logger.w(f277236i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
        goto L56
    L34:
        r116 = r104;
        goto L35
    L75:
        r103 = r110.getInputStream();     // Catch: Throwable -> L28
        byte[] r106 = IoUtils.toByteArray(r103);     // Catch: Throwable -> L28
        IoUtils.closeSecure(r103);     // Catch: IOException -> L38 Throwable -> L61
        r104 = r106;
    L28:
        th = move-exception;
        IoUtils.closeSecure(r103);     // Catch: IOException -> L38 Throwable -> L61
        throw th;     // Catch: IOException -> L38 Throwable -> L61
    L18:
        r111 = "";
    L38:
        e = e;
    L42:
        long r210 = r101;
        r101 = r105;
        long r107 = r210;
    L47:
        long r117 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L61
        r115 = System.currentTimeMillis();     // Catch: Throwable -> L61
        Logger.w(f277236i, "RequestCallableV2 run task catch IOException", e);     // Catch: Throwable -> L61
        this.f277195a = new d(e, r117 - r101);     // Catch: Throwable -> L61
        if (r110 != null) goto L79;
    L55:
        r101 = r107;
        goto L56
    L79:
        r110.disconnect();     // Catch: Throwable -> L51 RuntimeException -> L53
    L53:
        r101 = r107;
    L51:
        r101 = r107;
        goto L52
    L40:
        e = e;
        r110 = null;
    L43:
        th = th;
    L63:
        if (r102 != null) goto L81;
    L68:
        throw th;
    L81:
        r102.disconnect();     // Catch: Throwable -> L66 RuntimeException -> L67
    L67:
        Logger.w(f277236i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
    L66:
        Logger.w(f277236i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
    L45:
        e = e;
        r110 = null;
        r107 = 0;
    L61:
        th = th;
        r102 = r10;
        goto L63
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ d call() {
        return call();
    }
}
