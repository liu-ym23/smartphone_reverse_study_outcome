package com.bytedance.applet.aibridge.navigation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import com.larus.navigation.api.NavigationService;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static final Object a = null;
    public static final Handler b = null;
    public static volatile a c;
    public static b d;
    public static volatile com.larus.navigation.api.x e;
    public static volatile long f;
    public static volatile Pair<Double, Double> g;

    public static final class a {
        public final String a;
        public final rv3.i b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DetailPageSession(navigationId=" + this.a + ", pageData=" + this.b + ')';
        }

        public a(String r2, rv3.i r3) {
            Intrinsics.checkNotNullParameter(r2, "navigationId");
            Intrinsics.checkNotNullParameter(r3, "pageData");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final rv3.i a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "PendingInitialPageData(pageData=" + this.a + ", expiresAtElapsedRealtime=" + this.b + ')';
        }

        public b(rv3.i r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "pageData");
            this.a = r2;
            this.b = r3;
        }
    }

    public l() {
    }

    static {
        a = new Object();
        b = new Handler(Looper.getMainLooper());
    }

    public static void b() {
        if (com.bytedance.applet.utils.t.a() == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 33) goto L8;
        return;
    L8:
        com.larus.navigation.api.c.d("nav_jsb_helper", "requesting POST_NOTIFICATIONS permission");
        t0.e(new i());
    }

    public static rv3.i e(com.larus.navigation.api.w r8) {
        Intrinsics.checkNotNullParameter(r8, "current");
        Object r0 = a;
        monitor-enter(r0);
        b r1 = d;     // Catch: Throwable -> L16
        rv3.i r2 = null;
        if (r1 != null) goto L8;
    L14:
        monitor-exit(r0);
        return r2;
    L8:
        if (SystemClock.elapsedRealtime() < r1.b) goto L10;
        d = null;     // Catch: Throwable -> L16
        goto L14
    L10:
        rv3.i r3 = r1.a;     // Catch: Throwable -> L16
        if (c(r8, r3) == false) goto L14;
        r2 = r3;
    L16:
        th = move-exception;
        throw th;
    }

    public static List f(List r11) {
        List r0 = r11;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        ArrayList r2 = null;
        if ((!r1) == true) goto L13;
        r11 = null;
    L13:
        if (r11 == null) goto L21;
        List r12 = r11;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L16:
        if (r13.hasNext() == false) goto L21;
        com.larus.navigation.api.y r3 = (com.larus.navigation.api.y) r13.next();
        double r4 = r3.a;
        double r5 = r3.b;
        String r6 = r3.e;
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r2.add(new rv3.l(r4, r5, r6, r3.c, r3.d));
    L21:
        return r2;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean c(com.larus.navigation.api.w r10, rv3.i r11) {
        String r0 = r11.e();
        String r3 = null;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L23:
        if (r1 != null) goto L25;
    L27:
        rv3.j r2 = r11.d();
        if (r2 != null) goto L31;
        return false;
    L31:
        if (Math.abs(r10.b.a - r2.b()) <= 1.0E-6d) goto L33;
    L68:
        return false;
    L33:
        if (Math.abs(r10.b.b - r2.c()) > 1.0E-6d) goto L68;
        String r4 = r10.l;
        if (r4 != null) goto L38;
    L40:
        r4 = null;
    L41:
        String r5 = r11.b();
        if (r5 != null) goto L44;
    L46:
        r5 = null;
    L47:
        if (r5 != null) goto L49;
    L51:
        String r12 = r10.m;
        if (r12 != null) goto L54;
    L56:
        r12 = null;
    L57:
        String r13 = r11.c();
        if (r13 != null) goto L60;
    L62:
        if (r3 != null) goto L64;
        return true;
    L64:
        if (Intrinsics.areEqual(r12, r3) == true) goto L75;
        return false;
    L75:
        return true;
    L60:
        if ((!StringsKt.isBlank(r13)) == false) goto L62;
        r3 = r13;
        goto L62
    L54:
        if ((!StringsKt.isBlank(r12)) == false) goto L56;
    L49:
        if (Intrinsics.areEqual(r4, r5) == true) goto L51;
        return false;
    L44:
        if ((!StringsKt.isBlank(r5)) == false) goto L46;
    L38:
        if ((!StringsKt.isBlank(r4)) == false) goto L40;
    L25:
        if (r10.c == r1.intValue()) goto L27;
        return false;
    L5:
        switch(r0.hashCode()) {
            case 1118815609: goto L19;
            case 1227428899: goto L15;
            case 1421379145: goto L12;
            case 1920367559: goto L8;
            default: goto L69;
        };
    L69:
        r1 = null;
        goto L23
    L8:
        if (r0.equals("driving") == false) goto L70;
        r1 = 2;
        goto L23
    L70:
        r1 = null;
        goto L23
    L12:
        if (r0.equals("e_cycling") == false) goto L71;
    L17:
        r1 = 1;
        goto L23
    L71:
        r1 = null;
        goto L23
    L15:
        if (r0.equals("cycling") == true) goto L17;
        r1 = null;
        goto L23
    L19:
        if (r0.equals("walking") == false) goto L73;
        r1 = 0;
        goto L23
    L73:
        r1 = null;
        goto L23
    }

    public static void d(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (r3 == true) goto L5;
        return;
    L5:
        NavigationMultitaskCard.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "reason");
        NavigationCardSessionState r5 = NavigationMultitaskCard.e;
        monitor-enter(r5);
        NavigationCardSessionState.a r0 = r5.b;     // Catch: Throwable -> L22
        if (r5.c != NavigationCardSessionState.Phase.WAITING_FOR_START) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r0 = null;
    L14:
        monitor-exit(r5);
        if (r0 == null) goto L18;
        int r6 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("nav_multitask_map", "releaseRetentionOnStartFailure: " + r4 + " — releasing retained card");
        NavigationMultitaskCard.j("quick_restart_start_failed", r0);
    L18:
        NavigationService r7 = (NavigationService) ServiceManager.get().getService(NavigationService.class);
        if (r7 == null) goto L27;
        r7.j(r4);
        return;
    L27:
        return;
    L10:
        r1 = false;
    L22:
        th = move-exception;
        throw th;
    }

    public static rv3.i g(String r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "navigationId");
        Intrinsics.checkNotNullParameter(r4, "transform");
        Object r0 = a;
        monitor-enter(r0);
        a r1 = c;     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
    L11:
        rv3.i r5 = null;
    L12:
        monitor-exit(r0);
        return r5;
    L7:
        if (Intrinsics.areEqual(r1.a, r3) == false) goto L11;
        Object r6 = r4.invoke(r1.b);     // Catch: Throwable -> L14
        rv3.i r7 = (rv3.i) r6;     // Catch: Throwable -> L14
        String r2 = r1.a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r2, "navigationId");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r7, "pageData");     // Catch: Throwable -> L14
        c = new a(r2, r7);     // Catch: Throwable -> L14
        r5 = (rv3.i) r6;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static String a(com.larus.navigation.api.w r37, String r38, rv3.i r39) {
        NavigationPageFrom r15 = NavigationPageFrom.TOOL;
        Intrinsics.checkNotNullParameter(r37, "param");
        Intrinsics.checkNotNullParameter(r38, "navigationId");
        Intrinsics.checkNotNullParameter(r15, "from");
        String r12 = UUID.randomUUID().toString();     // Catch: RuntimeException -> L95
        int r3 = com.larus.navigation.api.c.a;     // Catch: RuntimeException -> L95
        StringBuilder r4 = new StringBuilder("buildNavDetailUrl/v2: from=");     // Catch: RuntimeException -> L95
        r4.append(r15);     // Catch: RuntimeException -> L95
        r4.append(" routePlanType=");     // Catch: RuntimeException -> L95
        r4.append(r37.c);     // Catch: RuntimeException -> L95
        r4.append(" hasStartPoint=");     // Catch: RuntimeException -> L95
        if (r37.a == null) goto L6;
        boolean r2 = true;
    L7:
        r4.append(r2);     // Catch: RuntimeException -> L95
        r4.append(" hasPoiId=");     // Catch: RuntimeException -> L95
        String r5 = r37.l;     // Catch: RuntimeException -> L95
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L16;
        boolean r7 = true;
    L17:
        r4.append(r7);     // Catch: RuntimeException -> L95
        r4.append(" outlinkId=");     // Catch: RuntimeException -> L95
        r4.append(r12);     // Catch: RuntimeException -> L95
        r4.append(" verbalMode=");     // Catch: RuntimeException -> L95
        r4.append(r37.e);     // Catch: RuntimeException -> L95
        r4.append(" navigateUniqueId='");     // Catch: RuntimeException -> L95
        r4.append(r37.f);     // Catch: RuntimeException -> L95
        r4.append("' botId=");     // Catch: RuntimeException -> L95
        r4.append(r37.g);     // Catch: RuntimeException -> L95
        r4.append(" conversationId=");     // Catch: RuntimeException -> L95
        r4.append(r37.h);     // Catch: RuntimeException -> L95
        r4.append(" isQuickRestart=");     // Catch: RuntimeException -> L95
        r4.append(r37.i);     // Catch: RuntimeException -> L95
        r4.append(" ridingType=");     // Catch: RuntimeException -> L95
        r4.append(r37.j);     // Catch: RuntimeException -> L95
        r4.append(" businessId=");     // Catch: RuntimeException -> L95
        r4.append(r37.k);     // Catch: RuntimeException -> L95
        r4.append(" coordType=");     // Catch: RuntimeException -> L95
        r4.append(r37.n);     // Catch: RuntimeException -> L95
        r4.append(" rotationChangeMinInterval=");     // Catch: RuntimeException -> L95
        r4.append(r37.p);     // Catch: RuntimeException -> L95
        r4.append(" waypoints=");     // Catch: RuntimeException -> L95
        List r8 = r37.q;     // Catch: RuntimeException -> L95
        if (r8 == null) goto L20;
        int r9 = r8.size();     // Catch: RuntimeException -> L95
    L21:
        r4.append(r9);     // Catch: RuntimeException -> L95
        r4.append(" prefer=");     // Catch: RuntimeException -> L95
        r4.append(r37.d);     // Catch: RuntimeException -> L95
        com.larus.navigation.api.c.d("nav_jsb_helper", r4.toString());     // Catch: RuntimeException -> L95
        int r10 = r37.c;     // Catch: RuntimeException -> L95
        if (r10 == 0) goto L28;
        if (r10 == 1) goto L27;
        if (r10 != 2) goto L28;
        String r11 = "driving";
    L29:
        com.larus.navigation.api.a r13 = r37.a;     // Catch: RuntimeException -> L95
        if (r13 == null) goto L32;
        Unit r14 = new rv3.j(r13.a, r13.b, r13.d);     // Catch: RuntimeException -> L95
    L33:
        com.larus.navigation.api.a r16 = r37.b;     // Catch: RuntimeException -> L95
        rv3.j r17 = new rv3.j(r16.a, r16.b, r16.d);     // Catch: RuntimeException -> L95
        Integer r18 = r37.d;     // Catch: RuntimeException -> L95
        Integer r19 = r37.e;     // Catch: RuntimeException -> L95
        String r20 = r37.f;     // Catch: RuntimeException -> L95
        if (r20.length() <= 0) goto L36;
        boolean r21 = true;
    L37:
        if (r21 == false) goto L39;
        String r110 = r20;
    L40:
        String r22 = r37.g;     // Catch: RuntimeException -> L95
        String r23 = r37.h;     // Catch: RuntimeException -> L95
        boolean r24 = r37.i;     // Catch: RuntimeException -> L95
        Integer r1 = r37.j;     // Catch: RuntimeException -> L95
        String r25 = r37.k;     // Catch: RuntimeException -> L95
        String r26 = r37.l;     // Catch: RuntimeException -> L95
        String r27 = r37.m;     // Catch: RuntimeException -> L95
        int r111 = r37.n;     // Catch: RuntimeException -> L95
        int r28 = r37.p;     // Catch: RuntimeException -> L95
        rv3.i r29 = new rv3.i(r11, r14, r17, r15, "relaunch", Integer.valueOf(r10), r18, r19, r110, r22, r23, Boolean.valueOf(r24), r1, r25, r26, r27, Integer.valueOf(r111), Integer.valueOf(r28), f(r37.q), r26, null, r12);     // Catch: RuntimeException -> L95
        rv3.j r30 = r29.d();     // Catch: RuntimeException -> L95
        if (r30 == null) goto L65;
        String r31 = r30.d();     // Catch: RuntimeException -> L95
        if (r31 != null) goto L46;
    L49:
        boolean r112 = true;
    L50:
        if (r112 == false) goto L65;
        if (r39 == null) goto L65;
        rv3.j r32 = r39.d();     // Catch: RuntimeException -> L95
        if (r32 == null) goto L65;
        String r113 = r32.d();     // Catch: RuntimeException -> L95
        if (r113 == null) goto L65;
        if ((!StringsKt.isBlank(r113)) == true) goto L62;
        r113 = null;
    L62:
        if (r113 == null) goto L65;
        r29 = rv3.i.a(r29, null, rv3.j.a(r30, r113), null, null, null, 4194299);     // Catch: RuntimeException -> L95
        goto L65
    L46:
        if (StringsKt.isBlank(r31) == true) goto L49;
        r112 = false;
    L65:
        rv3.i r0 = r29;
        e = r37.r;     // Catch: RuntimeException -> L95
        Object r33 = a;     // Catch: RuntimeException -> L95
        monitor-enter(r33);     // Catch: RuntimeException -> L95
        c = new a(r38, r0);     // Catch: Throwable -> L89
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L89
        monitor-exit(r33);     // Catch: RuntimeException -> L95
        String r114 = rv3.k.a(r0, "relaunch", null, null);     // Catch: RuntimeException -> L93
        StringBuilder r34 = new StringBuilder("[H5_OUT/sslocal/direct] mode=");     // Catch: RuntimeException -> L93
        int r35 = r37.c;     // Catch: RuntimeException -> L93
        if (r35 == 0) goto L79;
        if (r35 != 1) goto L75;
        String r36 = "cycling";
    L80:
        r34.append(r36);     // Catch: RuntimeException -> L93
        r34.append(" from=");     // Catch: RuntimeException -> L93
        r34.append(r15);     // Catch: RuntimeException -> L93
        r34.append(" | hasStartPoint=");     // Catch: RuntimeException -> L93
        if (r37.a == null) goto L83;
        boolean r115 = true;
    L84:
        r34.append(r115);     // Catch: RuntimeException -> L93
        r34.append(" outlinkId=");     // Catch: RuntimeException -> L93
        r34.append(r12);     // Catch: RuntimeException -> L93
        r34.append(" | waypoints=");     // Catch: RuntimeException -> L93
        List r40 = r37.q;     // Catch: RuntimeException -> L93
        if (r40 == null) goto L87;
        int r41 = r40.size();     // Catch: RuntimeException -> L93
    L88:
        r34.append(r41);     // Catch: RuntimeException -> L93
        r34.append(" | uriLen=");     // Catch: RuntimeException -> L93
        r34.append(r114.length());     // Catch: RuntimeException -> L93
        com.larus.navigation.api.c.d("nav_protocol_trace", r34.toString());     // Catch: RuntimeException -> L93
        return r114;
    L87:
        r41 = 0;
        goto L88
    L83:
        r115 = false;
        goto L84
    L75:
        if (r35 != 2) goto L79;
        r36 = "driving";
    L79:
        r36 = "walking";
        goto L80
    L93:
        e = e;
    L97:
        int r42 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_jsb_helper", "buildNavDetailUrl error: type=".concat(e.getClass().getSimpleName()));
        return r14;
    L89:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L93
    L39:
        r110 = null;
        goto L40
    L36:
        r21 = false;
        goto L37
    L32:
        r14 = null;
        goto L33
    L27:
        r11 = "cycling";
    L28:
        r11 = "walking";
        goto L29
    L20:
        r9 = 0;
        goto L21
    L16:
        r7 = false;
        goto L17
    L10:
        if (StringsKt.isBlank(r5) == true) goto L13;
        r6 = false;
        goto L14
    L6:
        r2 = false;
    L95:
        e = e;
        r14 = null;
        goto L97
    }
}
