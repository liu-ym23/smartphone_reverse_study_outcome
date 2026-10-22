package com.bytedance.bdnavigationsdk.network.config;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdnavigationsdk.b0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.SerializationException;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.bdnavigationsdk.c a;
    public final b0 b;
    public final CoroutineScope c;
    public b d;

    public static final class a {
    }

    public interface b {
        void a(Exception r1);

        void b(e r1);
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            r84.a.b("获取配置协程异常", r3, 1);
        }
    }

    static {
    }

    public g() {
        int r0 = q84.a.a;
        this.a = q84.b.a;
        int r1 = v84.a.a;
        this.b = v84.b.a;
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()).plus(new c(CoroutineExceptionHandler.Key)));
    }

    public static e b(String r4) {
        v r1 = w.a(new f());     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
        if (r4.length() != 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L22;
        e r5 = (e) r1.c(e.Companion.serializer(), r4);     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
        String r3 = r5.a;     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
        if (r3 == null) goto L20;
        if (StringsKt.equals(r3, Constants.Ok.getValue(), true) == false) goto L18;
        if (r5.c == null) goto L16;
        return r5;
    L16:
        throw new Exception("响应失败，configInfo为空");     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
    L18:
        throw new Exception("响应失败，code无效");     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
    L20:
        throw new Exception("响应失败，code为空");     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
    L22:
        throw new Exception("响应失败，response为空");     // Catch: Exception -> L23 IllegalArgumentException -> L25 SerializationException -> L27
    L6:
        r2 = false;
    L23:
        e = move-exception;
        throw e;
    L28:
        throw new Exception("响应失败，解析异常");
    L26:
        throw new Exception("响应失败，解析异常");
    }

    public final void c(d r12) {
        r84.a.d(null, "收到获取配置请求", 5);
        Map<String, String> r0 = s84.a.a;     // Catch: Exception -> L5
        BuildersKt.launch$default(this.c, null, null, new ConfigureService$configureApi$1(this, "https://road.bytedance.com", "/route/zj/navigation/v1/config", r12, null), 3, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b r1 = this.d;
        if (r1 == null) goto L12;
        r1.a(e);
        return;
    }

    public static final Map a(g r2, d r3) {
        r2.getClass();
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appid", r3.a), TuplesKt.to("device_platform", r3.b), TuplesKt.to(LocationMonitorConst.DEVICE_BRAND, r3.c), TuplesKt.to("device_model", r3.d)});
    }
}
