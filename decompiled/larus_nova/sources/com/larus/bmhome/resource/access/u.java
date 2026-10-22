package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f313753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f313754b = null;

    public u() {
    }

    static {
        f313753a = new u();
        f313754b = SetsKt.setOf(new String[]{"task_id", "file_identifier", "scene", "source_type", com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, "node_key", "stage", "cost_ms", "result", "error_code", "policy_version", "route_decision", "route_reason", "cache_hit", "sdk_route", "remote_resolve", "is_task_reused", "wait_cost_ms", "estimated_saved_ms"});
    }

    public static void b(t r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[trace] taskId=");
        r102.append(r100.f313732a);
        r102.append(", fileIdentifier=");
        r102.append(r100.f313736e);
        r102.append(", scene=");
        r102.append(r100.f313733b);
        r102.append(", resourceInputType=");
        r102.append(r100.f313734c);
        r102.append(", mediaType=");
        r102.append(r100.f313735d);
        r102.append(", nodeKey=");
        r102.append(r100.f313737f);
        r102.append(", stage=");
        r102.append(r100.f313738g);
        r102.append(", costMs=");
        r102.append(r100.f313739h);
        r102.append(", result=");
        r102.append(r100.f313740i);
        r102.append(", errorCode=");
        String r103 = r100.f313741j;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.append(r103);
        r102.append(", policyVersion=");
        String r105 = r100.f313742k;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.append(r105);
        r102.append(", routeDecision=");
        String r106 = r100.f313743l;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r102.append(r106);
        r102.append(", routeReason=");
        String r107 = r100.f313744m;
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        r102.append(r107);
        r102.append(", cacheHit=");
        String r108 = r100.f313745n;
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r102.append(r108);
        r102.append(", sdkRoute=");
        String r109 = r100.f313746o;
        if (r109 != null) goto L20;
        r109 = "";
    L20:
        r102.append(r109);
        r102.append(", remoteResolve=");
        String r110 = r100.f313747p;
        if (r110 != null) goto L23;
        r110 = "";
    L23:
        r102.append(r110);
        r102.append(", isTaskReused=");
        r102.append(r100.f313748q);
        r102.append(", waitCostMs=");
        r102.append(r100.f313749r);
        r102.append(", estimatedSavedMs=");
        r102.append(r100.f313750s);
        r102.append(", attributes=");
        r102.append(r100.f313751t);
        r101.i("ResourceAccessObserveReporter", r102.toString());
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L61
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L61
        r112.put("task_id", r100.f313732a);     // Catch: Throwable -> L61
        r112.put("file_identifier", r100.f313736e);     // Catch: Throwable -> L61
        r112.put("scene", r100.f313733b.f313767a);     // Catch: Throwable -> L61
        r112.put("source_type", r100.f313734c.name());     // Catch: Throwable -> L61
        r112.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r100.f313735d.name());     // Catch: Throwable -> L61
        r112.put("node_key", r100.f313737f);     // Catch: Throwable -> L61
        r112.put("stage", r100.f313738g);     // Catch: Throwable -> L61
        r112.put("cost_ms", r100.f313739h);     // Catch: Throwable -> L61
        r112.put("result", r100.f313740i);     // Catch: Throwable -> L61
        String r113 = r100.f313741j;     // Catch: Throwable -> L61
        if (r113 != null) goto L27;
        r113 = "";
    L27:
        r112.put("error_code", r113);     // Catch: Throwable -> L61
        String r114 = r100.f313742k;     // Catch: Throwable -> L61
        if (r114 != null) goto L30;
        r114 = "";
    L30:
        r112.put("policy_version", r114);     // Catch: Throwable -> L61
        String r115 = r100.f313743l;     // Catch: Throwable -> L61
        if (r115 != null) goto L33;
        r115 = "";
    L33:
        r112.put("route_decision", r115);     // Catch: Throwable -> L61
        String r116 = r100.f313744m;     // Catch: Throwable -> L61
        if (r116 != null) goto L36;
        r116 = "";
    L36:
        r112.put("route_reason", r116);     // Catch: Throwable -> L61
        String r117 = r100.f313745n;     // Catch: Throwable -> L61
        if (r117 != null) goto L39;
        r117 = "";
    L39:
        r112.put("cache_hit", r117);     // Catch: Throwable -> L61
        String r118 = r100.f313746o;     // Catch: Throwable -> L61
        if (r118 != null) goto L42;
        r118 = "";
    L42:
        r112.put("sdk_route", r118);     // Catch: Throwable -> L61
        String r119 = r100.f313747p;     // Catch: Throwable -> L61
        if (r119 == null) goto L46;
        r104 = r119;
    L46:
        r112.put("remote_resolve", r104);     // Catch: Throwable -> L61
        Boolean r120 = r100.f313748q;     // Catch: Throwable -> L61
        if (r120 != null) goto L49;
    L53:
        Long r121 = r100.f313749r;     // Catch: Throwable -> L61
        if (r121 == null) goto L56;
        r112.put("wait_cost_ms", r121.longValue());     // Catch: Throwable -> L61
    L56:
        Long r122 = r100.f313750s;     // Catch: Throwable -> L61
        if (r122 == null) goto L59;
        r112.put("estimated_saved_ms", r122.longValue());     // Catch: Throwable -> L61
    L59:
        a(r112, r100.f313751t);     // Catch: Throwable -> L61
        com.larus.platform.service.o.f365780a.reportEvent("resource_access_pipeline_trace", r112);     // Catch: Throwable -> L61
        Object r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L81;
        FLogger.f375446a.e("ResourceAccessObserveReporter", "[trace] report applog failed", r124);
    L81:
        Set r125 = ServiceManager.get().getServices(ResourceAccessObserver.class, true);     // Catch: Throwable -> L75
        if (r125 != null) goto L69;
        r125 = SetsKt.emptySet();     // Catch: Throwable -> L75
    L69:
        Iterator r126 = r125.iterator();     // Catch: Throwable -> L75
    L71:
        if (r126.hasNext() == false) goto L73;
        ((ResourceAccessObserver) r126.next()).onEvent(r100);     // Catch: Throwable -> L75
        goto L71
    L73:
        Object r127 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L77:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 == null) goto L86;
        FLogger.f375446a.e("ResourceAccessObserveReporter", "[trace] notify observer failed", r128);
        return;
    L86:
        return;
    L75:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L77
    L49:
        if (r120.booleanValue() == false) goto L51;
        int r130 = 1;
    L52:
        r112.put("is_task_reused", r130);     // Catch: Throwable -> L61
        goto L53
    L51:
        r130 = 0;
    L61:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    }

    public static void a(JSONObject r100, Map r101) {
        Iterator r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        String r105 = (String) r103.getValue();
        if (StringsKt.isBlank(r104) == true) goto L4;
        if (f313754b.contains(r104) == false) goto L11;
        r104 = "attr_" + r104;
    L11:
        r100.put(r104, r105);
        goto L4
    }
}
