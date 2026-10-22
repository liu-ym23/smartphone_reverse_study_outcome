package o4;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.settings.d;
import d3.a0;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t5.k;
import t5.o;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements i3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f521941a;

    @Override // i3.b
    public final int getPriority() {
        return 50;
    }

    @Override // i3.b
    public final void reset() {
        a r100 = this.f521941a;
        Object r101 = r100.f521939b;
        monitor-enter(r101);
        r100.f521938a = null;     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r101);
        r100.f521940c.clear();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f521941a = new a();
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "invocation");
        a0 r101 = r100.f488078c.getContainerContext();
        if (r101 == null) goto L5;
        r101.getAppletId();
    L5:
        a r102 = this.f521941a;
        String r103 = r100.f488076a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "methodName");
        d.f37592a.getClass();
        o r104 = d.a().aiBridgeConfig().e();
        if (r104 != null) goto L9;
        r104 = new o(null);
    L9:
        if (r104.a() == true) goto L12;
        return null;
    L12:
        if (r104.b().contains(r103) == true) goto L63;
        j3.a r105 = r102.f521938a;
        if (r105 != null) goto L27;
        Object r106 = r102.f521939b;
        monitor-enter(r106);
        j3.a r107 = r102.f521938a;     // Catch: Throwable -> L56
        if (r107 == null) goto L23;
        monitor-exit(r106);
        r105 = r107;
        goto L27
    L23:
        com.bytedance.ai.applet.base.log.b r108 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L56
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[AIBridge][RateLimit] init: " + r104);     // Catch: Throwable -> L56
        j3.a r109 = new j3.a(r104.c(), r104.d());     // Catch: Throwable -> L56
        r102.f521938a = r109;     // Catch: Throwable -> L56
        monitor-exit(r106);
        r105 = r109;
    L56:
        th = move-exception;
        throw th;
    L27:
        if (j3.a.a(r105) == false) goto L30;
        com.bytedance.ai.applet.base.log.b r110 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("ai_bridge", "[AIBridge] method:" + r103 + " rate limited, reason:global", null);
        f3.a r111 = f3.a.f475278s;
        AIBridgeMethod.Error r112 = new AIBridgeMethod.Error(0, r111.f475286b, null, r111);
    L55:
        return r112;
    L30:
        j3.a r113 = r102.f521940c.get(r103);
        if (r113 != null) goto L53;
        k r114 = r104.e().get(r103);
        if (r114 == null) goto L38;
        Integer r115 = r114.a();
        if (r115 == null) goto L38;
        int r116 = r115.intValue();
    L39:
        k r117 = r104.e().get(r103);
        if (r117 == null) goto L44;
        Long r118 = r117.b();
        if (r118 == null) goto L44;
        long r119 = r118.longValue();
    L45:
        ConcurrentHashMap<String, j3.a> r120 = r102.f521940c;
        j3.a r121 = r120.get(r103);
        if (r121 != null) goto L51;
        r121 = new j3.a(r116, r119);
        j3.a r122 = r120.putIfAbsent(r103, r121);
        if (r122 == null) goto L51;
        r121 = r122;
    L51:
        r113 = r121;
    L44:
        r119 = r104.g();
    L38:
        r116 = r104.f();
    L53:
        if (j3.a.a(r113) == false) goto L61;
        com.bytedance.ai.applet.base.log.b r123 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("ai_bridge", "[AIBridge] method:" + r103 + " rate limited, reason:method", null);
        f3.a r124 = f3.a.f475278s;
        r112 = new AIBridgeMethod.Error(0, r124.f475286b, null, r124);
        goto L55
    L61:
        return null;
    L63:
        return null;
    }
}
