package com.bytedance.salamander.anniex;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f268506a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.salamander.anniex.x6$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3753a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f268507a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f268508b = null;

            static {
                int[] r100 = new int[SLEventType.values().length];
                r100[SLEventType.PV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
            L57:
                r100[SLEventType.JSB_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
            L69:
                r100[SLEventType.JSB_PERF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
            L43:
                r100[SLEventType.JS_EXCEPTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
            L45:
                r100[SLEventType.FETCH_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
            L53:
                r100[SLEventType.END_TO_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
            L65:
                r100[SLEventType.PERFORMANCE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
            L47:
                r100[SLEventType.NATIVE_ERROR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
            L59:
                r100[SLEventType.CUSTOM.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
            L61:
                r100[SLEventType.RES_LOADER_PERF.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
            L41:
                r100[SLEventType.RES_LOADER_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
            L55:
                r100[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
            L67:
                r100[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
            L39:
                r100[SLEventType.CONTAINER_ERROR.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
            L18:
                f268507a = r100;
                int[] r101 = new int[ContainerType.values().length];
                r101[ContainerType.Lynx.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
            L63:
                r101[ContainerType.Web.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
            L21:
                f268508b = r101;
            }
        }

        public a() {
        }

        public static boolean e() {
            if (j5.f268155j.f268157a == false) goto L11;
            s4 r100 = c8.f268007l.f268008a;
            if (r100 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("monitor");
            r100 = null;
        L9:
            if (r100.a() == false) goto L11;
            return true;
        L11:
            return false;
        }

        public static k5 d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bid");
            z5.f268541a.getClass();
            l5 r101 = z5.a.a().f267995a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "bid");
            if (com.bytedance.rts.foundation.m.b(r101.f268218a, r100) == false) goto L6;
            Object r102 = ((LinkedHashMap) r101.f268218a).get(r100);
            Intrinsics.checkNotNull(r102);
            return (k5) r102;
        L6:
            if (com.bytedance.rts.foundation.m.b(r101.f268218a, "__hybrid_default") == false) goto L9;
            Object r103 = ((LinkedHashMap) r101.f268218a).get("__hybrid_default");
            Intrinsics.checkNotNull(r103);
            return (k5) r103;
        L9:
            return new k5("__hybrid_default");
        }

        public static boolean a(o5 r100, k5 r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "bidConfig");
            int r102 = a7.f267970a;
            SLEventType r103 = SLEventType.PV;
            String r104 = r100.f268270c.f268290a;
            z5.f268541a.getClass();
            c6 r105 = z5.a.a();
            if (com.bytedance.rts.foundation.m.b(r101.f268180d, r104) != true) goto L12;
            Integer r106 = r101.f268180d.get(r104);
            if (r106 != null) goto L8;
            return false;
        L8:
            if (r106.intValue() != 1) goto L33;
            return true;
        L33:
            return false;
        L12:
            if (com.bytedance.rts.foundation.m.b(r105.f267998d, r104) != true) goto L20;
            Integer r107 = r105.f267998d.get(r104);
            if (r107 != null) goto L17;
            return false;
        L17:
            if (r107.intValue() != 1) goto L35;
            return true;
        L35:
            return false;
        L20:
            int r108 = r100.f268270c.f268291b;
            Intrinsics.checkNotNullParameter(r101, "bidConfig");
            switch(r108) {
                case 0: goto L44;
                case 1: goto L43;
                case 2: goto L42;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L38;
                case 7: goto L37;
                default: goto L32;
            };
        L37:
            return r101.f268188l;
        L38:
            return r101.f268187k;
        L39:
            return r101.f268186j;
        L40:
            return r101.f268185i;
        L41:
            return r101.f268184h;
        L42:
            return r101.f268183g;
        L43:
            return r101.f268182f;
        L44:
            return r101.f268181e;
        L32:
            return r101.f268189m;
        }

        public static boolean b(u5 r100, k5 r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "bidConfig");
            int r102 = a7.f267970a;
            if (r100.a() != SLEventType.END_TO_END) goto L12;
            SLEventType r103 = r100.a();
            Intrinsics.checkNotNullParameter(r103, "eventType");
            Intrinsics.checkNotNullParameter(r101, "bidConfig");
            int r104 = x.a.f268498a[r103.ordinal()];
            if (r104 == 10) goto L11;
            if (r104 == 20) goto L60;
            return false;
        L60:
            return r101.R;
        L11:
            return r101.G;
        L12:
            ContainerType r105 = r100.f268408a.f268428h;
            int r106 = C3753a.f268508b[r105.ordinal()];
            if (r106 != 1) goto L15;
            SLEventType r107 = r100.a();
            Intrinsics.checkNotNullParameter(r107, "eventType");
            Intrinsics.checkNotNullParameter(r101, "bidConfig");
            switch(x.a.f268498a[r107.ordinal()]) {
                case 1: goto L59;
                case 2: goto L95;
                case 3: goto L94;
                case 4: goto L93;
                case 5: goto L92;
                case 6: goto L91;
                case 7: goto L90;
                case 8: goto L89;
                case 9: goto L88;
                case 10: goto L87;
                case 11: goto L86;
                case 12: goto L85;
                case 13: goto L84;
                case 14: goto L83;
                case 15: goto L82;
                case 16: goto L81;
                default: goto L96;
            };
        L96:
            return false;
        L81:
            return r101.Q;
        L82:
            return r101.O;
        L83:
            return r101.P;
        L84:
            return r101.N;
        L85:
            return r101.I;
        L86:
            return r101.H;
        L87:
            return r101.G;
        L88:
            return r101.F;
        L89:
            return r101.F;
        L90:
            return r101.E;
        L91:
            return r101.D;
        L92:
            return r101.C;
        L93:
            return r101.B;
        L94:
            return r101.A;
        L95:
            return r101.f268202z;
        L59:
            return r101.f268202z;
        L15:
            if (r106 == 2) goto L17;
            return false;
        L17:
            SLEventType r108 = r100.a();
            Intrinsics.checkNotNullParameter(r108, "eventType");
            Intrinsics.checkNotNullParameter(r101, "bidConfig");
            switch(x.a.f268498a[r108.ordinal()]) {
                case 1: goto L39;
                case 2: goto L79;
                case 3: goto L78;
                case 4: goto L77;
                case 5: goto L76;
                case 6: goto L75;
                case 7: goto L74;
                case 8: goto L73;
                case 9: goto L72;
                case 10: goto L71;
                case 11: goto L70;
                case 12: goto L69;
                case 13: goto L68;
                case 14: goto L67;
                case 15: goto L66;
                case 16: goto L65;
                case 17: goto L64;
                case 18: goto L63;
                case 19: goto L62;
                default: goto L80;
            };
        L80:
            return false;
        L62:
            return r101.f268201y;
        L63:
            return r101.f268192p;
        L64:
            return r101.f268191o;
        L65:
            return r101.M;
        L66:
            return r101.K;
        L67:
            return r101.L;
        L68:
            return r101.f268176J;
        L69:
            return r101.f268193q;
        L70:
            return r101.f268194r;
        L71:
            return r101.G;
        L72:
            return r101.f268200x;
        L73:
            return r101.f268200x;
        L74:
            return r101.f268199w;
        L75:
            return r101.f268198v;
        L76:
            return r101.f268197u;
        L77:
            return r101.f268196t;
        L78:
            return r101.f268195s;
        L79:
            return r101.f268190n;
        L39:
            return r101.f268190n;
        }

        public static boolean c(SLEventType r100, ContainerType r101) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            Intrinsics.checkNotNullParameter(r101, "engineType");
            s4 r102 = null;
            switch(C3753a.f268507a[r100.ordinal()]) {
                case 1: goto L91;
                case 2: goto L71;
                case 3: goto L51;
                case 4: goto L47;
                case 5: goto L27;
                case 6: goto L21;
                case 7: goto L10;
                case 8: goto L6;
                case 9: goto L89;
                case 10: goto L89;
                case 11: goto L89;
                case 12: goto L89;
                case 13: goto L89;
                case 14: goto L89;
                default: goto L94;
            };
        L21:
            s4 r103 = c8.f268007l.f268016i;
            if (r103 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("endToEnd");
            r103 = null;
        L25:
            boolean r104 = r103.a();
        L96:
            if (j5.f268155j.f268157a == false) goto L105;
            s4 r105 = c8.f268007l.f268008a;
            if (r105 == null) goto L100;
            r102 = r105;
        L102:
            if (r102.a() == false) goto L105;
            if (r104 == false) goto L105;
            return true;
        L100:
            Intrinsics.throwUninitializedPropertyAccessException("monitor");
        L105:
            return false;
        L89:
            r104 = true;
        L94:
            r104 = false;
            goto L96
        L6:
            if (r101 != ContainerType.Lynx) goto L8;
            r104 = c8.f268007l.a().a();
            goto L96
        L8:
            r104 = c8.f268007l.b().a();
            goto L96
        L10:
            if (r101 != ContainerType.Lynx) goto L20;
            c8 r106 = c8.f268007l;
            if (r106.a().a() == false) goto L94;
            s4 r107 = r106.f268013f;
            if (r107 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("lynxPerf");
            r107 = null;
        L18:
            if (r107.a() == false) goto L94;
        L20:
            r104 = c8.f268007l.b().a();
            goto L96
        L27:
            if (r101 != ContainerType.Lynx) goto L37;
            c8 r108 = c8.f268007l;
            if (r108.a().a() == false) goto L94;
            s4 r109 = r108.f268014g;
            if (r109 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("lynxFetch");
            r109 = null;
        L35:
            if (r109.a() == false) goto L94;
        L37:
            c8 r110 = c8.f268007l;
            if (r110.b().a() == false) goto L94;
            s4 r111 = r110.f268010c;
            if (r111 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("webFetch");
            r111 = null;
        L44:
            if (r111.a() == false) goto L94;
        L47:
            if (r101 != ContainerType.Lynx) goto L49;
            r104 = c8.f268007l.a().a();
            goto L96
        L49:
            r104 = c8.f268007l.b().a();
            goto L96
        L51:
            if (r101 != ContainerType.Lynx) goto L61;
            c8 r112 = c8.f268007l;
            if (r112.a().a() == false) goto L94;
            s4 r113 = r112.f268015h;
            if (r113 != null) goto L59;
            Intrinsics.throwUninitializedPropertyAccessException("lynxJsb");
            r113 = null;
        L59:
            if (r113.a() == false) goto L94;
        L61:
            c8 r114 = c8.f268007l;
            if (r114.b().a() == false) goto L94;
            s4 r115 = r114.f268011d;
            if (r115 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("webJSB");
            r115 = null;
        L68:
            if (r115.a() == false) goto L94;
        L71:
            if (r101 != ContainerType.Lynx) goto L81;
            c8 r116 = c8.f268007l;
            if (r116.a().a() == false) goto L94;
            s4 r117 = r116.f268015h;
            if (r117 != null) goto L79;
            Intrinsics.throwUninitializedPropertyAccessException("lynxJsb");
            r117 = null;
        L79:
            if (r117.a() == false) goto L94;
        L81:
            c8 r118 = c8.f268007l;
            if (r118.b().a() == false) goto L94;
            s4 r119 = r118.f268011d;
            if (r119 != null) goto L88;
            Intrinsics.throwUninitializedPropertyAccessException("webJSB");
            r119 = null;
        L88:
            if (r119.a() == false) goto L94;
        L91:
            if (r101 != ContainerType.Lynx) goto L93;
            r104 = c8.f268007l.a().a();
            goto L96
        L93:
            r104 = c8.f268007l.b().a();
            goto L96
        }
    }

    static {
        f268506a = new a();
    }
}
