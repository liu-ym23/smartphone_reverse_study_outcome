package com.bytedance.android.livesdk.livecommerce.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECCartMonitor {
    public static volatile boolean a;
    public static boolean b;
    public static final Map<String, List<LogRule>> c = null;
    public static v0 d;
    public static final Map<String, String> e = null;
    public static final Handler f = null;
    public static boolean g;

    public static final class a implements Runnable {
        public final /* synthetic */ LogRuleInsertDelay a;

        public a(LogRuleInsertDelay r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r0 = ECCartMonitor.a;     // Catch: Throwable -> L4
            ECCartMonitor.b(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        c = new LinkedHashMap();
        e = new LinkedHashMap();
        f = new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final void f() {
        if (d != null) goto L5;
        return;
    L5:
        Handler r0 = f;
        LogRule r1 = null;
        r0.removeCallbacksAndMessages(null);
        List r2 = (List) ((LinkedHashMap) c).get(LogRuleInsertDelay.RULE_STR_CART_INSERT_DELAY);
        if (r2 == null) goto L8;
        LogRule r3 = (LogRule) CollectionsKt.firstOrNull(r2);
    L10:
        if ((r3 instanceof LogRuleInsertDelay) == false) goto L13;
        r1 = r3;
    L13:
        LogRuleInsertDelay r4 = (LogRuleInsertDelay) r1;
        if (r4 == null) goto L17;
        r0.postDelayed(new a(r4), ((long) r4.getDelaySeconds()) * 1000);
        return;
    L17:
        return;
    L8:
        r3 = null;
        goto L10
    }

    public static void a(a1 r6) {
        v0 r0 = d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a != null) goto L7;
        r0.a = new LinkedList();
    L7:
        LinkedList<a1> r1 = r0.a;
        if (r1 == null) goto L52;
        monitor-enter(r1);
    L41:
        th = move-exception;
        throw th;
    L11:
        if (c(r6) == false) goto L13;
    L14:
        int r2 = r1.size() - 1;     // Catch: Throwable -> L41
    L15:
        if (r2 < 0) goto L38;
        a1 r3 = r1.get(r2);     // Catch: Throwable -> L41
        a1 r4 = r3;     // Catch: Throwable -> L41
        if (c(r4) == false) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L26;
        r3 = null;
    L26:
        a1 r7 = r3;     // Catch: Throwable -> L41
        if (r7 == null) goto L38;
        if (c(r6) == false) goto L33;
        if (c(r7) == false) goto L33;
    L36:
        r1.remove(r2);     // Catch: Throwable -> L41
    L37:
        r2 = r2 - 1;     // Catch: Throwable -> L41
    L33:
        if (d(r6) == false) goto L37;
        if (d(r7) == false) goto L37;
    L19:
        if (d(r4) == true) goto L22;
        r5 = false;
    L38:
        r1.add(r6);     // Catch: Throwable -> L41
        monitor-exit(r1);
        return;
    L13:
        if (d(r6) == false) goto L38;
    }

    public static void b(LogRule r1) {
        String r2 = r1.getRequire();
        if (r2 != null) goto L6;
        return;
    L6:
        switch(r2.hashCode()) {
            case -1317299234: goto L15;
            case -592211387: goto L14;
            case 140325285: goto L12;
            case 2109773534: goto L9;
            default: goto L23;
        };
    L14:
        r2.equals(LogRule.REQUIRE_NO_AUTHORITY);
        return;
    L15:
        r2.equals(LogRule.REQUIRE_HAS_AUTHORITY);
        return;
    L23:
        return;
    L9:
        if (r2.equals(LogRule.REQUIRE_NO_CART) == false) goto L17;
        boolean r3 = p.a;
        return;
    L17:
        return;
    L12:
        if (r2.equals(LogRule.REQUIRE_HAS_CART) == false) goto L19;
        boolean r4 = p.a;
        return;
    }

    public static boolean c(a1 r3) {
        if ((r3 instanceof r0) == true) goto L5;
        return false;
    L5:
        if (((r0) r3).c != 10) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = false;
        goto L8
    }

    public static boolean d(a1 r1) {
        if ((r1 instanceof z0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z0) r1).c == false) goto L7;
        return true;
    }

    public static void e(String r2, String r3) {
        if (a == true) goto L5;
        return;
    L5:
        if (d != null) goto L9;
        final v0 r0 = new v0();
        int r1 = RoomContextController.h;
        final RoomContextController r4 = RoomContextController.a.b(r2, r3);
        UtilityKotlinExtentionsKt.i(new ECCartMonitor$onEnterRoom$1$1(r0, r4));
        d = r0;
        ((LinkedHashMap) e).clear();
        return;
    }

    public static void g(int r2, long r3) {
        if (r2 != 10) goto L5;
    L9:
        a(new r0(r2, r3));
    L11:
        if (d != null) goto L14;
        return;
    L14:
        if (g == false) goto L39;
        List r4 = (List) ((LinkedHashMap) c).get(LogRuleRevMsg.RULE_STR_REV_MSG);
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L20:
        if (r5.hasNext() == false) goto L40;
        LogRule r6 = (LogRule) r5.next();
        if ((r6 instanceof LogRuleRevMsg) == true) goto L24;
        LogRule r0 = null;
    L25:
        LogRuleRevMsg r1 = (LogRuleRevMsg) r0;
        if (r1 == null) goto L20;
        if (r1.isHandleMsgType(r2) != true) goto L20;
        b(r6);
        goto L20
    L24:
        r0 = r6;
        goto L25
    L40:
        return;
    L30:
        return;
    L39:
        return;
    L5:
        if (r2 == 11) goto L9;
        if (r2 == 13) goto L9;
        if (r2 != 14) goto L11;
        goto L9
    }
}
