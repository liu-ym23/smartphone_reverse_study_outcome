package com.bytedance.salamander.anniex;

import com.bytedance.apm.ApmAgent;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.salamander.anniex.a$a, reason: collision with other inner class name */
    public static final class C3752a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f267930a = null;

        static {
            int[] r100 = new int[SLEventType.values().length];
            r100[SLEventType.PV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r100[SLEventType.JSB_CONFIG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r100[SLEventType.STATIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[SLEventType.JS_EXCEPTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[SLEventType.FETCH_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r100[SLEventType.JSB_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r100[SLEventType.NATIVE_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r100[SLEventType.STATIC_SRI.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r100[SLEventType.RES_LOADER_ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r100[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r100[SLEventType.CONTAINER_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r100[SLEventType.END_TO_END.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r100[SLEventType.PERFORMANCE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r100[SLEventType.MEMORY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r100[SLEventType.AJAX.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r100[SLEventType.BLANK.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r100[SLEventType.RES_LOADER_PERF.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            f267930a = r100;
        }
    }

    static {
    }

    public a() {
    }

    public static String a(SLEventType r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        switch(b.f267930a[r100.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            case 16: goto L5;
            case 17: goto L5;
            case 18: goto L5;
            default: goto L4;
        };
    L4:
        return "bd_hybrid_monitor_normal";
    L5:
        return "bd_hybrid_monitor_p_one";
    L6:
        return "bd_hybrid_monitor_p_zero";
    }

    public static void b(SLEventType r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "result");
        String r102 = a(r100);
        int r103 = com.bytedance.anniex.bd.foundation.impl.e.f190142a;
        Intrinsics.checkNotNullParameter(r102, "logType");
        Intrinsics.checkNotNullParameter(r101, "result");
        ApmAgent.monitorCommonLog(r102, new JSONObject(TypeIntrinsics.asMutableMap(r101)));
        Iterator<e4> r104 = j5.f268155j.f268163g.iterator();
    L4:
        if (r104.hasNext() == false) goto L13;
        e4 r105 = r104.next();
        v.a(r100);     // Catch: Throwable -> L8
        r105.a();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.anniex.bd.foundation.impl.i r106 = com.bytedance.anniex.bd.foundation.impl.a.f190139a;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.foundation.RTSErrorKt.RTSError }");
        String r107 = th.getMessage();
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        r106.b("SLMonitor", "SLMonitorReportListener error: ".concat(r107));
        goto L4
    }
}
