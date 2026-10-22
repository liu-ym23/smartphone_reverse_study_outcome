package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import kotlin.collections.ArraysKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class r implements te7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.c f247582a;

    public r(d.c r100) {
        this.f247582a = r100;
    }

    @Override // te7.b
    public final void a(te7.i r110) {
        InputStream r100 = r110.e();
        int r101 = r110.f545613b.element;
        if (r100 != null) goto L6;
        JSONObject r102 = new JSONObject();
        r102.put("code", 0);
        r102.put("message", "body failed");
        this.f247582a.a(new Exception(r102.toString()));
        return;
    L6:
        LinkedHashMap<String, String> r111 = r110.f545612a;
        HybridLogger.m("XPrefetch", "connect start stream", null, null, 12);     // Catch: Throwable -> L20 Exception -> L22
        BufferedInputStream r112 = new BufferedInputStream(r100);     // Catch: Throwable -> L20 Exception -> L22
        byte[] r103 = new byte[com.bytedance.ies.bullet.service.base.h.c()];     // Catch: Exception -> L18 Throwable -> L38
    L9:
        int r113 = r112.read(r103);     // Catch: Exception -> L18 Throwable -> L38
        if (r113 == (-1)) goto L52;
        d.c r114 = this.f247582a;     // Catch: Exception -> L18 Throwable -> L38
        d.b r115 = new d.b();     // Catch: Exception -> L18 Throwable -> L38
        r115.f247520a = ArraysKt.copyOfRange(r103, 0, r113);     // Catch: Exception -> L18 Throwable -> L38
        r115.f247522c = r111;     // Catch: Exception -> L18 Throwable -> L38
        r115.f247523d = r101;     // Catch: Exception -> L18 Throwable -> L38
        r114.c(r115);     // Catch: Exception -> L18 Throwable -> L38
        goto L9
    L52:
        HybridLogger.m("XPrefetch", "connect finally close", null, null, 12);     // Catch: IOException -> L16
        r110.a();     // Catch: IOException -> L16
        r112.close();     // Catch: IOException -> L16
        d.c r104 = this.f247582a;     // Catch: IOException -> L16
        d.b r105 = new d.b();     // Catch: IOException -> L16
        r105.f247522c = r111;     // Catch: IOException -> L16
        r105.f247523d = r101;     // Catch: IOException -> L16
        r104.b(r105);     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.m("XPrefetch", "connect finally exp e:" + e.getMessage(), null, null, 12);
        e.printStackTrace();
        d.c r107 = this.f247582a;
        Exception r108 = new Exception(e.getMessage());
    L36:
        r107.a(r108);
        return;
    L18:
        e = e;
    L24:
        HybridLogger r116 = HybridLogger.f246343a;     // Catch: Throwable -> L38
        HybridLogger.m("XPrefetch", "connect performStreamRequest error reason: " + e.getMessage(), null, null, 12);     // Catch: Throwable -> L38
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L38
        r117.put("code", 0);     // Catch: Throwable -> L38
        String r109 = e.getMessage();     // Catch: Throwable -> L38
        if (r109 != null) goto L27;
        r109 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L27:
        r117.put("message", r109);     // Catch: Throwable -> L38
        this.f247582a.a(new Exception(r117.toString()));     // Catch: Throwable -> L38
        HybridLogger.m("XPrefetch", "connect finally close", null, null, 12);     // Catch: IOException -> L34
        r110.a();     // Catch: IOException -> L34
        if (r112 == null) goto L32;
        r112.close();     // Catch: IOException -> L34
    L32:
        d.c r118 = this.f247582a;     // Catch: IOException -> L34
        d.b r119 = new d.b();     // Catch: IOException -> L34
        r119.f247522c = r111;     // Catch: IOException -> L34
        r119.f247523d = r101;     // Catch: IOException -> L34
        r118.b(r119);     // Catch: IOException -> L34
        return;
    L34:
        e = move-exception;
        HybridLogger r120 = HybridLogger.f246343a;
        HybridLogger.m("XPrefetch", "connect finally exp e:" + e.getMessage(), null, null, 12);
        e.printStackTrace();
        r107 = this.f247582a;
        r108 = new Exception(e.getMessage());
    L38:
        th = th;
    L39:
        Throwable r121 = th;
        HybridLogger.m("XPrefetch", "connect finally close", null, null, 12);     // Catch: IOException -> L45
        r110.a();     // Catch: IOException -> L45
        if (r112 == null) goto L43;
        r112.close();     // Catch: IOException -> L45
    L43:
        d.c r122 = this.f247582a;     // Catch: IOException -> L45
        d.b r123 = new d.b();     // Catch: IOException -> L45
        r123.f247522c = r111;     // Catch: IOException -> L45
        r123.f247523d = r101;     // Catch: IOException -> L45
        r122.b(r123);     // Catch: IOException -> L45
        throw r121;
    L45:
        e = move-exception;
        HybridLogger r124 = HybridLogger.f246343a;
        HybridLogger.m("XPrefetch", "connect finally exp e:" + e.getMessage(), null, null, 12);
        e.printStackTrace();
        this.f247582a.a(new Exception(e.getMessage()));
        throw r121;
    L22:
        e = e;
        r112 = null;
    L20:
        th = th;
        r112 = null;
        goto L39
    }
}
