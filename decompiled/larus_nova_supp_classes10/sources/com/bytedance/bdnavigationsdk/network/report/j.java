package com.bytedance.bdnavigationsdk.network.report;

import com.bytedance.bdnavigationsdk.b0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.internal.r0;
import nuc.a1;
import nuc.g1;
import nuc.v2;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.bdnavigationsdk.c a;
    public final b0 b;
    public final CoroutineScope c;
    public b d;

    public static final class a {
    }

    public interface b {
        void a(g r1);

        void b(Exception r1);
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            r84.a.b("上报协程异常", r3, 1);
        }
    }

    static {
    }

    public j() {
        int r0 = q84.a.a;
        this.a = q84.b.a;
        int r1 = v84.a.a;
        this.b = v84.b.a;
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()).plus(new c(CoroutineExceptionHandler.Key)));
    }

    public static g b(String r4) {
        v r1 = w.a(new i());     // Catch: Exception -> L19 IllegalArgumentException -> L21 SerializationException -> L23
        if (r4.length() != 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L18;
        g r5 = (g) r1.c(g.Companion.serializer(), r4);     // Catch: Exception -> L19 IllegalArgumentException -> L21 SerializationException -> L23
        String r3 = r5.a;     // Catch: Exception -> L19 IllegalArgumentException -> L21 SerializationException -> L23
        if (r3 == null) goto L16;
        if (StringsKt.equals(r3, Constants.Ok.getValue(), true) == false) goto L14;
        return r5;
    L14:
        throw new Exception("响应失败，code无效");     // Catch: Exception -> L19 IllegalArgumentException -> L21 SerializationException -> L23
    L16:
        throw new Exception("响应失败，code为空");     // Catch: Exception -> L19 IllegalArgumentException -> L21 SerializationException -> L23
    L18:
        throw new Exception("响应失败，response为空");     // Catch: Exception -> L19 IllegalArgumentException -> L21 SerializationException -> L23
    L6:
        r2 = false;
    L19:
        e = move-exception;
        throw e;
    L22:
        throw new Exception("响应失败，解析异常");
    L24:
        throw new Exception("响应失败，解析异常");
    }

    public final void c(f r12) {
        r84.a.d(null, "收到上报请求", 5);
        Map<String, String> r0 = s84.a.a;     // Catch: Exception -> L5
        BuildersKt.launch$default(this.c, null, null, new ReportService$reportApi$1(this, "https://road.bytedance.com", "/route/zj/navigation/v1/logger/submit", r12, null), 3, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b r1 = this.d;
        if (r1 == null) goto L12;
        r1.b(e);
        return;
    }

    public static final String a(j r6, f r7) {
        r6.getClass();
        v r8 = w.a(new h());
        String r1 = r7.c;
        v2 r2 = v2.a;
        Intrinsics.checkNotNullParameter(r2, "serializer");
        String r3 = r7.d;
        Intrinsics.checkNotNullParameter(r2, "serializer");
        String r4 = r7.e;
        Intrinsics.checkNotNullParameter(r2, "serializer");
        String r5 = r7.f;
        Intrinsics.checkNotNullParameter(r2, "serializer");
        String r9 = r7.g;
        Intrinsics.checkNotNullParameter(r2, "serializer");
        Long r10 = Long.valueOf(r7.h);
        g1 r11 = g1.a;
        Intrinsics.checkNotNullParameter(r11, "serializer");
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("did", r0.a(r8, r1, r2)), TuplesKt.to("business", r0.a(r8, r3, r2)), TuplesKt.to("profile", r0.a(r8, r4, r2)), TuplesKt.to("session_id", r0.a(r8, r5, r2)), TuplesKt.to("logger_content", r0.a(r8, r9, r2)), TuplesKt.to("logger_timestamp", r0.a(r8, r10, r11))});
        kuc.a.f(StringCompanionObject.INSTANCE);
        a1 r0 = kuc.a.c(r2, ouc.i.Companion.serializer());
        Intrinsics.checkNotNullParameter(r0, "serializer");
        return r0.a(r8, r12, r0).toString();
    }
}
