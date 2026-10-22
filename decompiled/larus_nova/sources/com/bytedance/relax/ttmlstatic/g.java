package com.bytedance.relax.ttmlstatic;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267235a = 0;

    public static final class a {
        public static boolean b(Object r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if ((r100 instanceof Map) == false) goto L8;
            Map r101 = (Map) r100;
        L9:
            if (r101 == null) goto L12;
            return true;
        L12:
            return false;
        L8:
            r101 = null;
            goto L9
        }

        public static ArrayList c(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            int r101 = com.bytedance.rts.kmp.foundation.g.f267611a;
            Map r102 = (Map) r100;
            Intrinsics.checkNotNullParameter(r102, "json");
            return new ArrayList(r102.keySet());
        }

        public static int e(Object r110) {
            Intrinsics.checkNotNullParameter("$.userNameStatus", "path");
            int r100 = g.f267235a;
            Integer r101 = null;
            if (r110 == null) goto L45;
            t87.c.f545056a.getClass();
            Intrinsics.checkNotNullParameter(r110, "value");
            if ((r110 instanceof Number) == false) goto L45;
            if ((r110 instanceof Double) == false) goto L10;
            Double r102 = (Double) r110;
        L12:
            if ((r110 instanceof Integer) == false) goto L14;
            Integer r103 = (Integer) r110;
        L15:
            boolean r104 = true;
            if (r103 == null) goto L25;
            if (r102 == null) goto L23;
            int r105 = com.bytedance.rts.kmp.foundation.c.f267609a;
            if (r103.intValue() != r102.doubleValue()) goto L21;
            boolean r106 = true;
        L22:
            if (r106 == false) goto L25;
        L21:
            r106 = false;
        L23:
            r101 = r103;
        L25:
            if ((r110 instanceof Long) == false) goto L27;
            Long r111 = (Long) r110;
        L28:
            if (r111 == null) goto L38;
            int r107 = com.bytedance.rts.kmp.foundation.d.f267610a;
            int r108 = (int) r111.longValue();
            int r109 = com.bytedance.rts.kmp.foundation.c.f267609a;
            if (r108 != r111.longValue()) goto L38;
            if (r102 != null) goto L33;
        L37:
            r101 = Integer.valueOf(r108);
            goto L45
        L33:
            if (r111.longValue() != r102.doubleValue()) goto L35;
            boolean r112 = true;
        L36:
            if (r112 == false) goto L38;
        L35:
            r112 = false;
        L38:
            if (r102 == null) goto L45;
            int r113 = com.bytedance.rts.kmp.foundation.b.f267608a;
            int r114 = (int) r102.doubleValue();
            int r115 = com.bytedance.rts.kmp.foundation.c.f267609a;
            if (r114 == r102.doubleValue()) goto L43;
            r104 = false;
        L43:
            if (r104 == false) goto L45;
            r101 = Integer.valueOf(r114);
            goto L45
        L27:
            r111 = null;
            goto L28
        L14:
            r103 = null;
            goto L15
        L10:
            r102 = null;
        L45:
            if (r101 == null) goto L49;
            return r101.intValue();
        L49:
            throw new Throwable("[TTML Static] Expected exact int32 at $.userNameStatus.");
        }

        public static Object a(Object r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Intrinsics.checkNotNullParameter(r101, "key");
            int r102 = com.bytedance.rts.kmp.foundation.g.f267611a;
            return com.bytedance.rts.kmp.foundation.g.a.a((Map) r100, r101);
        }

        public static boolean d(Object r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            int r102 = g.f267235a;
            if (r100 == null) goto L9;
            t87.c.f545056a.getClass();
            Intrinsics.checkNotNullParameter(r100, "value");
            boolean r103 = r100 instanceof Boolean;
            if (r103 == false) goto L9;
            if (r103 == false) goto L9;
            Boolean r104 = (Boolean) r100;
        L10:
            if (r104 == null) goto L14;
            return r104.booleanValue();
        L14:
            throw new Throwable("[TTML Static] Expected boolean at " + r101 + '.');
        L9:
            r104 = null;
            goto L10
        }

        public static String f(Object r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            int r102 = g.f267235a;
            if ((r100 instanceof String) == false) goto L5;
            String r103 = (String) r100;
        L6:
            if (r103 == null) goto L9;
            return r103;
        L9:
            throw new Throwable("[TTML Static] Expected string at " + r101 + '.');
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    public g() {
    }
}
