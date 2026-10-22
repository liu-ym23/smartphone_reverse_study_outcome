package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.bdnavigationsdk.b0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.SerializationException;
import ouc.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o {
    public final com.bytedance.bdnavigationsdk.c a;
    public final b0 b;
    public final CoroutineScope c;
    public b d;

    public static final class a {
    }

    public interface b {
        void a(p r1);

        void c(Exception r1);
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            r84.a.b("路径规划协程异常", r3, 1);
        }
    }

    static {
    }

    public o() {
        int r0 = q84.a.a;
        this.a = q84.b.a;
        int r1 = v84.a.a;
        this.b = v84.b.a;
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()).plus(new c(CoroutineExceptionHandler.Key)));
    }

    public static List d(List r6) {
        if (r6 == null) goto L8;
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L10;
        v r1 = (v) r8.next();
        r0.add(new v(com.bytedance.bdnavigationsdk.pojo.a.a(r1.a), r1.b, r1.c, r1.d));
        goto L5
    L10:
        return r0;
    L8:
        return CollectionsKt.emptyList();
    }

    public static final Map a(o r9, j r10) {
        r9.getClass();
        com.bytedance.bdnavigationsdk.e r11 = r84.a.a;
        r84.a.a("路径规划参数，routePlanParam = " + r10);
        com.bytedance.bdnavigationsdk.b r12 = com.bytedance.bdnavigationsdk.d.a();
        Pair[] r0 = new Pair[13];
        boolean r2 = false;
        r0[0] = TuplesKt.to("appid", r12.a);
        r0[1] = TuplesKt.to("did", r12.b);
        r0[2] = TuplesKt.to("business", r10.b);
        r0[3] = TuplesKt.to("session_id", r10.a);
        com.bytedance.bdnavigationsdk.pojo.a r13 = r10.d;
        r0[4] = TuplesKt.to("origin", r13.b + "," + r13.a);
        com.bytedance.bdnavigationsdk.pojo.a r14 = r10.e;
        r0[5] = TuplesKt.to("destination", r14.b + "," + r14.a);
        String r15 = r10.f;
        String r3 = "";
        if (r15 != null) goto L5;
        r15 = "";
    L5:
        r0[6] = TuplesKt.to("origin_id", r15);
        PoiType r16 = r10.i;
        if (r16 == null) goto L9;
        String r17 = Integer.valueOf(r16.getCode()).toString();
        if (r17 == null) goto L9;
    L10:
        r0[7] = TuplesKt.to("origin_id_type", r17);
        String r18 = r10.g;
        if (r18 != null) goto L13;
        r18 = "";
    L13:
        r0[8] = TuplesKt.to("destination_id", r18);
        PoiType r19 = r10.j;
        if (r19 == null) goto L19;
        String r20 = Integer.valueOf(r19.getCode()).toString();
        if (r20 == null) goto L19;
        r3 = r20;
    L19:
        r0[9] = TuplesKt.to("destination_id_type", r3);
        r0[10] = TuplesKt.to("alternative_route", String.valueOf(r10.h));
        r0[11] = TuplesKt.to("verbal_instructions", "true");
        r0[12] = TuplesKt.to("visual_instructions", "true");
        Map r21 = MapsKt.mutableMapOf(r0);
        List<v> r1 = r10.k;
        if (r1 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == true) goto L26;
        List<v> r110 = r10.k;
        Intrinsics.checkNotNull(r110);
        r21.put("waypoints", CollectionsKt.joinToString$default(r110, ";", null, null, 0, null, new k(), 30, null));
    L26:
        return r21;
    L22:
        if (r1.isEmpty() == false) goto L24;
    L9:
        r17 = "";
        goto L10
    }

    public static p c(j r5, String r6) {
        ouc.v r1 = w.a(new l());     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
        boolean r3 = false;
        if (r6.length() != 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L34;
        p r7 = (p) r1.c(p.Companion.serializer(), r6);     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
        String r4 = r7.a;     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
        if (r4 == null) goto L32;
        if (StringsKt.equals(r4, Constants.Ok.getValue(), true) == false) goto L30;
        d r8 = r7.d;     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
        if (r8 == null) goto L28;
        if (StringsKt.equals(r5.a, r8.c, true) == false) goto L26;
        List<RoutePath> r9 = r8.d;     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
        if (r9 != null) goto L19;
    L20:
        r3 = true;
    L21:
        if (r3 == true) goto L24;
        return r7;
    L24:
        throw new Exception("响应失败，paths为空");     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
    L19:
        if (r9.isEmpty() == false) goto L21;
    L26:
        throw new Exception("响应失败，sessionId不一致");     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
    L28:
        throw new Exception("响应失败，route为空");     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
    L30:
        throw new Exception("响应失败，code无效");     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
    L32:
        throw new Exception("响应失败，code为空");     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
    L34:
        throw new Exception("响应失败，response为空");     // Catch: Exception -> L35 IllegalArgumentException -> L37 SerializationException -> L39
    L6:
        r2 = false;
    L35:
        e = move-exception;
        throw e;
    L40:
        throw new Exception("响应失败，解析异常");
    L38:
        throw new Exception("响应失败，解析异常");
    }

    public static final p b(o r2, j r3, String r4) {
        r2.getClass();
        p r5 = c(r3, r4);     // Catch: Exception -> L8
        d r0 = r5.d;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L8
        if (r0.e.isEmpty() == false) goto L6;
        d r1 = r5.d;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L8
        List<v> r6 = d(r3.k);     // Catch: Exception -> L8
        r1.getClass();     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r6, "<set-?>");     // Catch: Exception -> L8
        r1.e = r6;     // Catch: Exception -> L8
    L6:
        com.bytedance.bdnavigationsdk.e r7 = r84.a.a;     // Catch: Exception -> L8
        r84.a.a("路径规划响应处理成功, response = " + r5);     // Catch: Exception -> L8
        return r5;
    L8:
        e = move-exception;
        r84.a.b("路径规划响应处理失败", e, 1);
        throw e;
    }

    public final void e(j r20, String r21, Function2<? super String, ? super p, Unit> r22, Function2<? super String, ? super Exception, Unit> r23) {
        Intrinsics.checkNotNullParameter(r21, "routeUpdateId");
        Intrinsics.checkNotNullParameter(r22, "onSuccess");
        Intrinsics.checkNotNullParameter(r23, "onFailure");
        r84.a.d(null, "收到路径规划请求", 5);
        if (r20 == null) goto L10;
        Map<String, String> r2 = s84.a.a;     // Catch: Exception -> L7
        BuildersKt.launch$default(this.c, null, null, new RoutePlanService$routerApi$3(this, "https://road.bytedance.com", "/route/zj/navigation/v2/route/" + r20.c, r20, r22, r21, r23, null), 3, null);     // Catch: Exception -> L11
        return;
    L7:
        e = e;
    L12:
        r23.invoke(r21, e);
        return;
    L10:
        throw new Exception("路径规划参数为空");     // Catch: Exception -> L11
    L11:
        e = e;
        goto L12
    }
}
