package com.bytedance.salamander.anniex;

import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class x {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f268498a = null;

        static {
            int[] r100 = new int[SLEventType.values().length];
            r100[SLEventType.PERFORMANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L71:
            r100[SLEventType.MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L83:
            r100[SLEventType.BLANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[SLEventType.FETCH_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[SLEventType.JSB_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L65:
            r100[SLEventType.JSB_PERF.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L77:
            r100[SLEventType.NATIVE_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[SLEventType.PV.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L73:
            r100[SLEventType.JSB_CONFIG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L75:
            r100[SLEventType.CONTAINER_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L47:
            r100[SLEventType.JS_EXCEPTION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L69:
            r100[SLEventType.STATIC.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L81:
            r100[SLEventType.RES_LOADER_PERF.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L45:
            r100[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L59:
            r100[SLEventType.RES_LOADER_ERROR.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L79:
            r100[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L51:
            r100[SLEventType.AJAX.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L55:
            r100[SLEventType.RESOURCE_PERFORMANCE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L67:
            r100[SLEventType.STATIC_SRI.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L49:
            r100[SLEventType.END_TO_END.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L23:
            f268498a = r100;
        }
    }

    public static final c6 a(JSONObject r210) {
        Intrinsics.checkNotNullParameter(r210, "jsonObject");
        c6 r100 = new c6();
        JSONObject r101 = com.bytedance.anniex.bd.foundation.impl.o.j(r210, "data", com.bytedance.anniex.bd.foundation.impl.o.c());
        long r102 = 0;
        com.bytedance.anniex.bd.foundation.impl.o.l(r101, "update_time", 0);
        r100.f267996b = com.bytedance.anniex.bd.foundation.impl.o.f(r101, "duration", 0);
        r100.f267997c = com.bytedance.anniex.bd.foundation.impl.o.l(r101, Constant.KEY_SETTING_ID, 0);
        long r103 = com.bytedance.anniex.bd.foundation.impl.o.l(r101, "enable_switch", 0);
        c8.f268007l.getClass();
        int r104 = 0;
    L3:
        boolean r110 = true;
        if (r104 > c8.f268006k) goto L15;
        if (r104 == 0) goto L7;
        r103 = r103 >> 1;
    L7:
        s4 r105 = (s4) ((LinkedHashMap) c8.f268005j).get(Integer.valueOf(r104));
        if (r105 == null) goto L14;
        long r111 = r103 % ((long) 2);
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        if (r111 != 0) goto L13;
        r110 = false;
    L13:
        r105.f268371a = r110;
    L14:
        r104 = r104 + 1;
        goto L3
    L15:
        Map<String, Integer> r107 = a2.a(com.bytedance.anniex.bd.foundation.impl.o.j(r101, "all_event_sample", com.bytedance.anniex.bd.foundation.impl.o.c()));
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f267998d = r107;
        JSONObject r108 = com.bytedance.anniex.bd.foundation.impl.o.j(r101, "bid_info", com.bytedance.anniex.bd.foundation.impl.o.c());
        long r109 = r100.f267997c;
        Intrinsics.checkNotNullParameter(r108, "bidObject");
        l5 r112 = new l5();
        JSONObject r113 = com.bytedance.anniex.bd.foundation.impl.o.c();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type org.json.JSONObject{ com.bytedance.anniex.bd.foundation.api.BDAnnieXBasicTypeKt.SLJSONObject }");
        Iterator r114 = com.bytedance.anniex.bd.foundation.impl.o.k(r108).iterator();
    L17:
        if (r114.hasNext() == false) goto L70;
        String r115 = (String) r114.next();
        JSONObject r116 = com.bytedance.anniex.bd.foundation.impl.o.j(r108, r115, r113);
        long r117 = com.bytedance.anniex.bd.foundation.impl.o.l(r116, "hit_sample", r102);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.String");
        k5 r118 = new k5(r115);
        r118.f268178b = r117;
        r118.f268179c = r109;
        Map<String, Integer> r119 = a2.a(com.bytedance.anniex.bd.foundation.impl.o.j(r116, "event_name_sample", r113));
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r118.f268180d = r119;
        Map<String, k5> r120 = r112.f268218a;
        Intrinsics.checkNotNullParameter(r118, "bidConfig");
        JSONObject r121 = r108;
        int r122 = 0;
    L20:
        if (r122 >= 47) goto L69;
        if (r122 == 0) goto L23;
        r117 = r117 >> 1;
    L23:
        long r123 = r109;
        long r124 = r117;
        if ((r117 % ((long) 2)) != com.bytedance.rts.foundation.k.d(IntCompanionObject.INSTANCE, 1)) goto L68;
        Intrinsics.checkNotNullParameter(r118, "bidConfig");
        switch(r122) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            case 12: goto L55;
            case 13: goto L54;
            case 14: goto L53;
            case 15: goto L52;
            case 16: goto L51;
            case 17: goto L50;
            case 18: goto L68;
            case 19: goto L49;
            case 20: goto L48;
            case 21: goto L47;
            case 22: goto L46;
            case 23: goto L45;
            case 24: goto L44;
            case 25: goto L43;
            case 26: goto L42;
            case 27: goto L41;
            case 28: goto L40;
            case 29: goto L68;
            case 30: goto L68;
            case 31: goto L68;
            case 32: goto L68;
            case 33: goto L68;
            case 34: goto L39;
            case 35: goto L38;
            case 36: goto L37;
            case 37: goto L68;
            case 38: goto L36;
            case 39: goto L35;
            case 40: goto L34;
            case 41: goto L33;
            case 42: goto L32;
            case 43: goto L31;
            case 44: goto L30;
            case 45: goto L29;
            case 46: goto L28;
            default: goto L68;
        };
    L28:
        r118.R = true;
        goto L68
    L29:
        r118.Q = true;
        goto L68
    L30:
        r118.O = true;
        goto L68
    L31:
        r118.P = true;
        goto L68
    L32:
        r118.N = true;
        goto L68
    L33:
        r118.M = true;
        goto L68
    L34:
        r118.K = true;
        goto L68
    L35:
        r118.L = true;
        goto L68
    L36:
        r118.f268176J = true;
        goto L68
    L37:
        r118.I = true;
        goto L68
    L38:
        r118.H = true;
        goto L68
    L39:
        r118.G = true;
        goto L68
    L40:
        r118.F = true;
        goto L68
    L41:
        r118.E = true;
        goto L68
    L42:
        r118.D = true;
        goto L68
    L43:
        r118.C = true;
        goto L68
    L44:
        r118.B = true;
        goto L68
    L45:
        r118.A = true;
        goto L68
    L46:
        r118.f268202z = true;
        goto L68
    L47:
        r118.f268201y = true;
        goto L68
    L48:
        r118.f268200x = true;
        goto L68
    L49:
        r118.f268199w = true;
        goto L68
    L50:
        r118.f268198v = true;
        goto L68
    L51:
        r118.f268197u = true;
        goto L68
    L52:
        r118.f268196t = true;
        goto L68
    L53:
        r118.f268195s = true;
        goto L68
    L54:
        r118.f268194r = true;
        goto L68
    L55:
        r118.f268193q = true;
        goto L68
    L56:
        r118.f268192p = true;
        goto L68
    L57:
        r118.f268191o = true;
        goto L68
    L58:
        r118.f268190n = true;
        goto L68
    L59:
        r118.f268189m = true;
        goto L68
    L60:
        r118.f268188l = true;
        goto L68
    L61:
        r118.f268187k = true;
        goto L68
    L62:
        r118.f268186j = true;
        goto L68
    L63:
        r118.f268185i = true;
        goto L68
    L64:
        r118.f268184h = true;
        goto L68
    L65:
        r118.f268183g = true;
        goto L68
    L66:
        r118.f268182f = true;
        goto L68
    L67:
        r118.f268181e = true;
    L68:
        r122 = r122 + 1;
        r109 = r123;
        r117 = r124;
        goto L20
    L69:
        com.bytedance.rts.foundation.m.e(r120, r115, r118);
        r108 = r121;
        r102 = 0;
        goto L17
    L70:
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r100.f267995a = r112;
        int r125 = or3.a.f524932a;
        JSONArray r126 = com.bytedance.anniex.bd.foundation.impl.o.g(r101, DownloadSettingKeys.UrlInterceptConfig.HOST_LIST, new JSONArray());
        Intrinsics.checkNotNullParameter(r126, "jsonArray");
        Set<String> r127 = com.bytedance.rts.foundation.q.b(new String[0]);
        int r128 = 0;
    L72:
        if (r128 >= com.bytedance.anniex.bd.foundation.impl.o.h(r126)) goto L77;
        Intrinsics.checkNotNullParameter(r126, "jsonArr");
        String r129 = r126.optString(r128);
        if (r129 == null) goto L76;
        r127.add(r129);
    L76:
        r128 = r128 + 1;
        goto L72
    L77:
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        r100.f267999e = r127;
        return r100;
    }
}
