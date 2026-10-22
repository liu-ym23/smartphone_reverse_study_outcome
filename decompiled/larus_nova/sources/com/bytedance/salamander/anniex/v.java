package com.bytedance.salamander.anniex;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class v {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f268415a = null;

        static {
            int[] r100 = new int[SLEventType.values().length];
            r100[SLEventType.PV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L79:
            r100[SLEventType.JSB_CONFIG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L91:
            r100[SLEventType.FETCH_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L57:
            r100[SLEventType.JSB_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L61:
            r100[SLEventType.JSB_PERF.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L73:
            r100[SLEventType.JS_EXCEPTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L85:
            r100[SLEventType.PERFORMANCE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L65:
            r100[SLEventType.BLANK.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L81:
            r100[SLEventType.JSB_PAGE_VISIT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L83:
            r100[SLEventType.NATIVE_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L51:
            r100[SLEventType.CONTAINER_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L77:
            r100[SLEventType.RESOURCE_PERFORMANCE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L89:
            r100[SLEventType.RES_LOADER_PERF.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
        L63:
            r100[SLEventType.RES_LOADER_ERROR.ordinal()] = 15;     // Catch: NoSuchFieldError -> L41
        L87:
            r100[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L42
        L55:
            r100[SLEventType.AJAX.ordinal()] = 17;     // Catch: NoSuchFieldError -> L43
        L59:
            r100[SLEventType.STATIC.ordinal()] = 18;     // Catch: NoSuchFieldError -> L44
        L75:
            r100[SLEventType.STATIC_SRI.ordinal()] = 19;     // Catch: NoSuchFieldError -> L45
        L53:
            r100[SLEventType.END_TO_END.ordinal()] = 20;     // Catch: NoSuchFieldError -> L46
        L69:
            r100[SLEventType.CUSTOM.ordinal()] = 21;     // Catch: NoSuchFieldError -> L47
        L71:
            r100[SLEventType.MEMORY.ordinal()] = 22;     // Catch: NoSuchFieldError -> L48
        L25:
            f268415a = r100;
        }
    }

    public static final String a(SLEventType r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        switch(a.f268415a[r100.ordinal()]) {
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            case 7: goto L36;
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L30;
            case 11: goto L28;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L18;
            case 17: goto L16;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L10;
            case 21: goto L8;
            case 22: goto L6;
            default: goto L5;
        };
    L6:
        return "memory";
    L8:
        return "custom";
    L10:
        return "end_to_end";
    L12:
        return "static_sri";
    L14:
        return "static";
    L16:
        return "ajax";
    L18:
        return "res_loader_error_template";
    L20:
        return "res_loader_error";
    L22:
        return "res_loader_perf_template";
    L24:
        return "res_loader_perf";
    L26:
        return "resource_performance";
    L28:
        return "container_error";
    L30:
        return "native_error";
    L32:
        return "jsb_pv";
    L34:
        return "blank";
    L36:
        return "performance";
    L38:
        return "js_exception";
    L40:
        return "jsb_perf";
    L42:
        return "jsb_error";
    L44:
        return "fetch_error";
    L46:
        return "jsb_config";
    L48:
        return "navigation_start";
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
