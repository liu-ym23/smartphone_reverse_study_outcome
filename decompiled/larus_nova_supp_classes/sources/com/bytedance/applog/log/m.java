package com.bytedance.applog.log;

import java.util.Locale;
import jx3.a;
import jx3.d;
import jx3.e;
import jx3.f;
import jx3.g;
import jx3.j;
import jx3.k;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m {
    public static volatile Boolean a;

    static {
        a = Boolean.FALSE;
    }

    public static boolean b() {
        return !a.booleanValue();
    }

    public static String a(a r3) {
        if (r3 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        if ((r3 instanceof f) == false) goto L10;
        return "FORWARD_EVENT";
    L10:
        if ((r3 instanceof e) == false) goto L17;
        if ("applog_trace".equals(((e) r3).B) == false) goto L15;
        return "TRACE";
    L15:
        return "EVENT_V3";
    L17:
        if ((r3 instanceof j) == false) goto L20;
        return "EVENT_V3";
    L20:
        if ((r3 instanceof jx3.c) == false) goto L24;
        return ((jx3.c) r3).y.toUpperCase(Locale.ROOT);
    L24:
        if ((r3 instanceof g) == false) goto L28;
        return "LAUNCH";
    L28:
        if ((r3 instanceof k) == false) goto L32;
        return "TERMINATE";
    L32:
        if ((r3 instanceof d) == false) goto L35;
        return "LOG_DATA";
    L35:
        return XmlPullParser.NO_NAMESPACE;
    }

    public static void e(String r3) {
        if (b() == false) goto L5;
        return;
    L5:
        if (nx3.k.g("init_end") == true) goto L10;
        ((g) g.z.b(new Object[0])).e(f("init_end"), r3);
        return;
    }

    public static String f(String r1) {
        return "applog_".concat(r1);
    }

    public static void c(String r2, g.b r3) {
        if (b() == false) goto L5;
        return;
    L5:
        if (nx3.k.g(r2) == true) goto L10;
        ((g) g.z.b(new Object[0])).a(f(r2), r3);
        return;
    }

    public static void d(String r2, Object r3) {
        if (b() == false) goto L5;
        return;
    L5:
        if (nx3.k.g(r2) == false) goto L8;
        return;
    L8:
        if ((r3 instanceof a) == false) goto L10;
        ((g) g.z.b(new Object[0])).a(f(r2), new a(r3));
        return;
    L10:
        ((g) g.z.b(new Object[0])).e(f(r2), r3);
    }
}
