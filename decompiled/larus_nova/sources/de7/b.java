package de7;

import android.util.Base64;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.prefetchv2.v;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f468072a = null;

    static {
        f468072a = new b();
    }

    public b() {
    }

    public final synchronized int a(String r110, int r111, IBDXBridgeContext r112, v r113) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "sessionId");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r112, "bridgeContext");     // Catch: Throwable -> L26
        ByteArrayOutputStream r100 = r113.f247609i;     // Catch: Throwable -> L26
        int r101 = 0;
        if (r100 == null) goto L14;
        byte[] r102 = r100.toByteArray();     // Catch: Throwable -> L26
        int r103 = r102.length;     // Catch: Throwable -> L26
        if (r103 <= r111) goto L16;
        String r104 = Base64.encodeToString(r102, r111, r102.length - r111, 2);     // Catch: Throwable -> L26
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L26
        r105.put("streamLoadType", 1);     // Catch: Throwable -> L26
        r105.put("data", r104);     // Catch: Throwable -> L26
        r105.put("content-range", "bytes=" + r111 + '-' + r103);     // Catch: Throwable -> L26
        r105.put("length", Integer.valueOf(r104.length()));     // Catch: Throwable -> L26
        r105.put("streamSessionId", r110);     // Catch: Throwable -> L26
        r105.put("stage", "inProgress");     // Catch: Throwable -> L26
        r105.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);     // Catch: Throwable -> L26
        r105.put("clientCode", 0);     // Catch: Throwable -> L26
        Integer r106 = r113.f247601a;     // Catch: Throwable -> L26
        if (r106 == null) goto L12;
        int r107 = r106.intValue();     // Catch: Throwable -> L26
    L13:
        r105.put("httpCode", Integer.valueOf(r107));     // Catch: Throwable -> L26
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r112.sendEvent("x.requestChunkData", r105);     // Catch: Throwable -> L26
        HybridLogger r109 = HybridLogger.f246343a;     // Catch: Throwable -> L26
        HybridLogger.m("XPrefetch", "发送流式 Prefetch 部分缓存数据 index = " + r111 + ", length = " + r103, null, null, 12);     // Catch: Throwable -> L26
        goto L16
    L12:
        r107 = 0;
    L16:
        if (r113.f247610j != true) goto L18;
        boolean r114 = true;
    L19:
        if (r114 == false) goto L24;
        LinkedHashMap r115 = new LinkedHashMap();     // Catch: Throwable -> L26
        r115.put("streamLoadType", 1);     // Catch: Throwable -> L26
        r115.put("stage", BitableAnalytic.SelectSceneClickType.COMPLETE);     // Catch: Throwable -> L26
        r115.put("streamSessionId", r110);     // Catch: Throwable -> L26
        r115.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);     // Catch: Throwable -> L26
        r115.put("clientCode", 0);     // Catch: Throwable -> L26
        Integer r116 = r113.f247601a;     // Catch: Throwable -> L26
        if (r116 == null) goto L23;
        r101 = r116.intValue();     // Catch: Throwable -> L26
    L23:
        r115.put("httpCode", Integer.valueOf(r101));     // Catch: Throwable -> L26
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r112.sendEvent("x.requestChunkData", r115);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return r103;
    L18:
        r114 = false;
        goto L19
    L14:
        r103 = 0;
    L26:
        th = move-exception;
        throw th;
    }
}
