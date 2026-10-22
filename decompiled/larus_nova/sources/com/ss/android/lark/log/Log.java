package com.ss.android.lark.log;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.logger.dynamic.DynamicLogFilterProvider;
import com.suite.lark.component.logger.printer.MoltenV2Printer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class Log {
    public static final int A_LOGGER = 4;
    public static final int MOLTEN_LOGGER = 8;
    private static String _logTag;
    private static final List<a> errorHooks = null;
    private static boolean inited;
    private static c logger;
    private static f sLogConfig;

    /* JADX INFO: loaded from: classes36.dex */
    public interface a {
        void e();
    }

    public Log() {
    }

    static {
        logger = new h();
        inited = false;
        _logTag = "lark";
        errorHooks = new CopyOnWriteArrayList();
    }

    public static void initWithNone() {
        sLogConfig = new f(new f.a());
        logger = new h();
        inited = true;
    }

    public static void flushDiskLog() {
        ALogService.flushSafely();
    }

    public static f getLogConfig() {
        return sLogConfig;
    }

    public static void addErrorHook(a r100) {
        errorHooks.add(r100);
    }

    public static void d(String r100) {
        d(_logTag, r100);
    }

    public static void e(String r100) {
        e(_logTag, r100);
    }

    public static void i(String r100) {
        i(_logTag, r100);
    }

    public static void init(final f r100) {
        sLogConfig = r100;
        int r101 = e.f431384a;
        Intrinsics.checkNotNullParameter(r100, "logConfig");
        pqb.e r102 = new pqb.e(r100);
        Intrinsics.checkNotNullParameter(r102, "logger");
        pqb.e.f530322a = r102;
        pqb.g.a r103 = pqb.g.f530323a;
        monitor-enter(r103);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (pqb.g.a() != null) goto L7;
        new pqb.g();     // Catch: Throwable -> L40
    L7:
        monitor-exit(r103);
        boolean r104 = r100.f431388d;
        if (r104 == false) goto L11;
        com.suite.component.logger.api.LogLevel r105 = com.suite.component.logger.api.LogLevel.DEBUG;
    L12:
        com.suite.lark.component.logger.c.a r106 = new com.suite.lark.component.logger.c.a(new com.suite.component.logger.b(r105, r100.f431389e, r100.f431390f, r104, r100.f431387c));
        com.suite.component.logger.f r107 = com.suite.component.logger.f.f460139a;
        Intrinsics.checkNotNullParameter(r107, "cache");
        r106.f460101c = r107;
        knc.a r108 = knc.a.f504329a;
        Intrinsics.checkNotNullParameter(r108, "collector");
        r106.f460102d.add(r108);
        qqb.d r109 = qqb.d.f534510a;
        Intrinsics.checkNotNullParameter(r109, "collector");
        r106.f460102d.add(r109);
        knc.b r110 = new knc.b();
        Intrinsics.checkNotNullParameter(r110, "collector");
        r106.f460102d.add(r110);
        lnc.b r111 = new lnc.b();
        Intrinsics.checkNotNullParameter(r111, "interceptor");
        r106.f460103e.add(r111);
        lnc.c r112 = (lnc.c) DynamicLogFilterProvider.f460159b.getValue();
        Intrinsics.checkNotNullParameter(r112, "interceptor");
        r106.f460103e.add(r112);
        if (r100.f431388d == false) goto L15;
        com.suite.component.logger.api.g r113 = new com.suite.component.logger.api.g(new LarkLoggerFactory$create$1$1(r100));
        Intrinsics.checkNotNullParameter(r113, "printer");
        r106.f460104f.add(r113);
    L15:
        mnc.a r114 = new mnc.a(r102, new LarkLoggerFactory$create$1$2(r100));
        Intrinsics.checkNotNullParameter(r114, "printer");
        r106.f460104f.add(r114);
        if (r100.f431386b != 8) goto L29;
        f.b r115 = r100.f431393i;
        if (r115 == null) goto L20;
        Pair<String, String> r116 = r115.a();
    L21:
        String r117 = r100.f431387c;
        int r118 = r100.f431391g;
        if (r116 == null) goto L24;
        String r119 = (String) r116.first;
    L25:
        if (r116 == null) goto L27;
        String r120 = (String) r116.second;
    L28:
        MoltenV2Printer r121 = new MoltenV2Printer(new MoltenV2Printer.b(r117, r118, r119, r120), new LarkLoggerFactory$create$1$3(r100));
        Intrinsics.checkNotNullParameter(r121, "printer");
        r106.f460104f.add(r121);
        goto L29
    L27:
        r120 = null;
        goto L28
    L24:
        r119 = null;
        goto L25
    L20:
        r116 = null;
    L29:
        com.suite.component.logger.api.b r122 = com.suite.component.logger.Log.f460087a;
        Intrinsics.checkNotNullParameter(r106, "builder");
        if (com.suite.component.logger.Log.f460089c == true) goto L37;
        com.suite.component.logger.Log.f460089c = true;
        com.suite.component.logger.Log.f460087a = r106;
        com.suite.component.logger.Log.f460088b = r106.a();
        com.suite.component.logger.api.a r123 = com.suite.component.logger.Log.f460087a.f460101c;
        if (r123 == null) goto L38;
        Iterator<T> r124 = r123.a().iterator();
    L35:
        if (r124.hasNext() == false) goto L38;
        com.suite.component.logger.c r125 = (com.suite.component.logger.c) r124.next();
        com.suite.component.logger.api.h r126 = com.suite.component.logger.Log.f460088b;
        Intrinsics.checkNotNull(r125);
        r126.h(r125);
    L38:
        logger = new d(com.suite.component.logger.Log.f460088b);
        inited = true;
        return;
    L37:
        com.suite.component.logger.Log.f460088b.w("log", "default logger can only set once", null);
        goto L38
    L11:
        r105 = com.suite.component.logger.api.LogLevel.INFO;
        goto L12
    }

    public static boolean removeErrorHook(a r100) {
        return errorHooks.remove(r100);
    }

    public static void v(String r100) {
        v(_logTag, r100);
    }

    public static void w(String r100) {
        w(_logTag, r100);
    }

    public static void d(String r100, String r101) {
        if (cacheLogIfNeeded(3, r100, r101, null) == true) goto L6;
        logger.d(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        e(r100, r101, null, false);
    }

    public static void i(String r100, String r101) {
        if (cacheLogIfNeeded(4, r100, r101, null) == true) goto L6;
        logger.i(r100, r101);
        return;
    }

    public static void json(String r100, String r101) {
        json(_logTag, r100, r101);
    }

    public static void v(String r100, String r101) {
        if (cacheLogIfNeeded(2, r100, r101, null) == true) goto L6;
        logger.v(r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if (cacheLogIfNeeded(5, r100, r101, null) == true) goto L6;
        logger.w(r100, r101);
        return;
    }

    public static void warn(String r100, Map<String, String> r101) {
        warn(r100, "", r101);
    }

    public static void wtf(String r100, String r101) {
        logger.wtf(r100, r101);
    }

    public static void d(String r100, Throwable r101) {
        d(_logTag, r100, r101);
    }

    public static void e(String r100, Throwable r101) {
        e(r100, r101, false);
    }

    public static void i(String r100, Throwable r101) {
        i(_logTag, r100, r101);
    }

    public static void v(String r100, Throwable r101) {
        v(_logTag, r100, r101);
    }

    public static void w(String r100, Throwable r101) {
        w(_logTag, r100, r101);
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (cacheLogIfNeeded(3, r100, r101, r102) == true) goto L6;
        logger.d(r100, r101, r102);
        return;
    }

    public static void e(String r100, Throwable r101, boolean r102) {
        e(_logTag, r100, r101, r102);
    }

    public static void error(String r100, String[] r101, Map<String, String> r102) {
        error(r100, r101, "", r102);
    }

    public static void i(String r100, String r101, Throwable r102) {
        if (cacheLogIfNeeded(4, r100, r101, r102) == true) goto L6;
        logger.i(r100, r101, r102);
        return;
    }

    public static void json(String r100, String r101, String r102) {
        logger.a(r100, r101, r102);
    }

    public static void v(String r100, String r101, Throwable r102) {
        if (cacheLogIfNeeded(2, r100, r101, r102) == true) goto L6;
        logger.v(r100, r101, r102);
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (cacheLogIfNeeded(5, r100, r101, r102) == true) goto L6;
        logger.w(r100, r101, r102);
        return;
    }

    public static void warn(String r100, String r101, Map<String, String> r102) {
        warn(r100, _logTag, r101, r102);
    }

    public static void wtf(String r100, String r101, Throwable r102) {
        logger.wtf(r100, r101, r102);
    }

    public static void xml(String r100, String r101, String r102) {
        logger.c(r100, r101, r102);
    }

    public static void e(String r100, String r101, Throwable r102) {
        e(r100, r101, r102, false);
    }

    public static void warn(String r100, String[] r101, Map<String, String> r102) {
        warn(r100, r101, "", r102);
    }

    private static boolean cacheLogIfNeeded(int r100, String r101, String r102, Throwable r103) {
        if (inited == false) goto L22;
        return false;
    L22:
        Object r104 = com.suite.component.logger.c.f460112w;     // Catch: Throwable -> L19
        com.suite.component.logger.c r105 = com.suite.component.logger.c.a.a();     // Catch: Throwable -> L19
        com.suite.component.logger.api.LogLevel r106 = com.suite.component.logger.api.LogLevel.fromValue(r100);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r106, "<set-?>");     // Catch: Throwable -> L19
        r105.f460115a = r106;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Throwable -> L19
        r105.f460116b = r101;     // Catch: Throwable -> L19
        r105.b("[cache] " + r102);     // Catch: Throwable -> L19
        r105.f460124j = r103;     // Catch: Throwable -> L19
        r105.f460125k = ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L19
        String r107 = ThreadMethodProxy.currentThread().getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r107, "<set-?>");     // Catch: Throwable -> L19
        r105.f460126l = r107;     // Catch: Throwable -> L19
        r105.f460129o = System.currentTimeMillis();     // Catch: Throwable -> L19
        int r108 = knc.b.f504331a;     // Catch: Throwable -> L19
        knc.b.a.a(r105);     // Catch: Throwable -> L19
        com.suite.component.logger.f r109 = com.suite.component.logger.f.f460139a;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r105, MapController.ITEM_LAYER_TAG);     // Catch: Throwable -> L19
        LinkedList<com.suite.component.logger.c> r110 = com.suite.component.logger.f.f460140b;     // Catch: Throwable -> L19
        monitor-enter(r110);     // Catch: Throwable -> L19
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L7:
        if (com.suite.component.logger.f.f460140b.size() >= 2000) goto L9;
        com.suite.component.logger.f.f460140b.add(r105);     // Catch: Throwable -> L12
    L9:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r110);     // Catch: Throwable -> L19
        return true;
    L23:
        return true;
    }

    public static void debug(String r100, String r101, String r102, Map<String, String> r103) {
        logger.b(LogLevel.DEBUG.getNumber(), r100, new String[]{r101}, r102, r103);
    }

    public static void e(String r100, String r101, Throwable r102, boolean r103) {
        if (cacheLogIfNeeded(6, r100, r101, r102) == true) goto L5;
        logger.e(r100, r101, r102);
    L5:
        reportError(r100, r101, r102, Boolean.valueOf(r103));
    }

    public static void error(String r100, String[] r101, String r102, Map<String, String> r103) {
        logger.b(LogLevel.ERROR.getNumber(), r100, r101, r102, r103);
    }

    public static void info(String r100, String r101, String r102, Map<String, String> r103) {
        logger.b(LogLevel.INFO.getNumber(), r100, new String[]{r101}, r102, r103);
    }

    public static void reportError(String r100, String r101, Throwable r102, Boolean r103) {
        Iterator<a> r104 = errorHooks.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        a r105 = r104.next();
        r103.booleanValue();
        r105.e();
        goto L4
    }

    public static void warn(String r100, String[] r101, String r102, Map<String, String> r103) {
        logger.b(LogLevel.WARN.getNumber(), r100, r101, r102, r103);
    }

    public static void error(String r100, String r101, String r102, Map<String, String> r103) {
        error(r100, new String[]{r101}, r102, r103);
    }

    public static void warn(String r100, String r101, String r102, Map<String, String> r103) {
        warn(r100, new String[]{r101}, r102, r103);
    }
}
