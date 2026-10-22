package com.obric.assistant.zeus.plugin;

import android.os.Handler;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.applog.api.IApplog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.IZeusReporter;
import com.volcengine.zeus.plugin.Plugin;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class q implements IZeusReporter {
    public static final Lazy<Handler> a = null;
    public static final Map<String, ArrayDeque<b>> b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final JSONObject b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            JSONObject r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingEvent(event=" + this.a + ", params=" + this.b + ')';
        }

        public b(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements com.volcengine.zeus.c {
        public final /* synthetic */ q a;
        public final /* synthetic */ String b;

        @Override // com.volcengine.zeus.c
        public final void onLoadSuccess() {
            final q r0 = this.a;
            final String r1 = this.b;
            r0.getClass();
            q.a.getValue().postDelayed(new p(r0, r1), 2000);
        }

        public c(q r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.volcengine.zeus.c
        public final void a(String r4, long r5) {
            q.b(this.a, this.b, "load timeout: " + r5);
        }

        @Override // com.volcengine.zeus.c
        public final void b(String r4, String r5) {
            q.b(this.a, this.b, "load failed: " + r5);
        }
    }

    public q() {
    }

    static {
        a = LazyKt.lazy(new o());
        b = new LinkedHashMap();
        c = new LinkedHashSet();
        d = new LinkedHashSet();
    }

    public static Object e(PluginClassLoader r6) {
        Class r0 = a(r6, "com.obric.aiagent.applog.IAppLog");
        Class r7 = a(r6, "com.ss.android.ugc.aweme.framework.services.ServiceManager");
        Object r2 = r7.getMethod("get", new Class[0]).invoke(null, new Object[0]);
        return r7.getMethod("getService", new Class[]{Class.class}).invoke(r2, new Object[]{r0});
    }

    public final void d(String r4) {
        Map<String, ArrayDeque<b>> r0 = b;
        monitor-enter(r0);
        c.remove(r4);     // Catch: Throwable -> L24
        ArrayDeque<b> r1 = r0.remove(r4);     // Catch: Throwable -> L24
        if (r1 == null) goto L7;
        List r2 = CollectionsKt.toList(r1);     // Catch: Throwable -> L24
    L8:
        if (r2 != null) goto L10;
        r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L24
    L10:
        monitor-exit(r0);
        if (r2.isEmpty() == false) goto L14;
        return;
    L14:
        Iterator r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L23;
        b r5 = (b) r3.next();
        if (Intrinsics.areEqual(r4, TaskUtils.MEMORY_DATA_PLUGIN_PKG_NAME) == true) goto L19;
        if (Intrinsics.areEqual(r4, "com.obric.aiagent.plugin") == false) goto L16;
        g(r5.a, r5.b);
        goto L16
    L19:
        h(r5.a, r5.b);
        goto L16
    L23:
        return;
    L7:
        r2 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(PluginClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public final void g(String r10, JSONObject r11) {
        PluginClassLoader r2 = f("com.obric.aiagent.plugin", r10, r11);     // Catch: Throwable -> L15
        if (r2 != null) goto L6;
        return;
    L6:
        Object r3 = e(r2);     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
        FLogger.a.w("ZeusReporter", "report Zeus mob failed in aiagent plugin process, IAppLog service is null");     // Catch: Throwable -> L15
        return;
    L10:
        Method r0 = a(r2, "com.obric.aiagent.applog.IAppLog").getMethod("report", new Class[]{String.class, JSONObject.class});     // Catch: Throwable -> L15
        Object[] r4 = new Object[2];     // Catch: Throwable -> L15
        r4[0] = r10;     // Catch: Throwable -> L15
        if (r11 != null) goto L13;
        r11 = new JSONObject();     // Catch: Throwable -> L15
    L13:
        r4[1] = r11;     // Catch: Throwable -> L15
        r0.invoke(r3, r4);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        FLogger.a.e("ZeusReporter", "report Zeus mob failed in aiagent plugin process", th);
    }

    public final void h(String r8, JSONObject r9) {
        PluginClassLoader r0 = f(TaskUtils.MEMORY_DATA_PLUGIN_PKG_NAME, r8, r9);     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        a(r0, "com.bytedance.applog.AppLog").getMethod("onEventV3", new Class[]{String.class, JSONObject.class}).invoke(null, new Object[]{r8, r9});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        FLogger.a.e("ZeusReporter", "report Zeus mob failed in memorydata plugin process", th);
    }

    @Override // com.volcengine.zeus.log.IZeusReporter
    public final void report(String r7, JSONObject r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        NovaApplication r1 = r0.getApplication();
        String r2 = q0.b(r1);
        if (r2 != null) goto L8;
        r2 = XmlPullParser.NO_NAMESPACE;
    L8:
        if (q0.c(r1) == false) goto L17;
        IApplog r3 = (IApplog) ServiceManager.get().getService(IApplog.class);     // Catch: Throwable -> L14
        if (r3 != null) goto L12;
        FLogger.a.w("ZeusReporter", "report Zeus mob failed in host process, IApplog service is null");     // Catch: Throwable -> L14
    L24:
        return;
    L12:
        r3.reportEvent(r7, r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        FLogger.a.e("ZeusReporter", "report Zeus mob failed in host process", th);
        return;
    L17:
        if (StringsKt.endsWith$default(r2, ":memorydata", false, 2, null) == false) goto L20;
        h(r7, r8);
        return;
    L20:
        if (StringsKt.endsWith$default(r2, ":aiagent", false, 2, null) == false) goto L22;
        g(r7, r8);
        return;
    L22:
        FLogger.a.w("ZeusReporter", "report Zeus mob failed in plugin process, unknown process=".concat(r2));
    }

    public static final void b(q r4, String r5, String r6) {
        r4.getClass();
        Map<String, ArrayDeque<b>> r7 = b;
        monitor-enter(r7);
        c.remove(r5);     // Catch: Throwable -> L12
        ArrayDeque<b> r0 = r7.remove(r5);     // Catch: Throwable -> L12
        if (r0 == null) goto L8;
        int r1 = r0.size();     // Catch: Throwable -> L12
    L9:
        monitor-exit(r7);
        FLogger.a.w("ZeusReporter", "drop pending Zeus mob events, plugin=" + r5 + ", reason=" + r6 + ", count=" + r1);
        return;
    L8:
        r1 = 0;
    L12:
        th = move-exception;
        throw th;
    }

    public final void c(String r8, String r9, JSONObject r10) {
        Map<String, ArrayDeque<b>> r0 = b;
        monitor-enter(r0);
        LinkedHashMap r1 = (LinkedHashMap) r0;     // Catch: Throwable -> L34
        Object r2 = r1.get(r8);     // Catch: Throwable -> L34
        if (r2 != null) goto L7;
        r2 = new ArrayDeque();     // Catch: Throwable -> L34
        r1.put(r8, r2);     // Catch: Throwable -> L34
    L7:
        ArrayDeque r3 = (ArrayDeque) r2;     // Catch: Throwable -> L34
    L9:
        if (r3.size() < 500) goto L12;
        r3.removeFirst();     // Catch: Throwable -> L34
        goto L9
    L12:
        if (r10 != null) goto L37;
        r10 = null;
    L18:
        r3.addLast(new b(r9, r10));     // Catch: Throwable -> L34
        boolean r11 = c.add(r8);     // Catch: Throwable -> L34
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r0);
        if (r11 == true) goto L43;
        return;
    L43:
        Zeus.runAfterLoad(r8, new c(this, r8), 60000);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        monitor-enter(b);
        c.remove(r8);     // Catch: Throwable -> L31
        FLogger.a.e("ZeusReporter", "register Zeus runAfterLoad failed, plugin=".concat(r8), th);
        return;
    L31:
        th = move-exception;
        throw th;
    L37:
        r10 = new JSONObject(r10.toString());     // Catch: Throwable -> L16
        goto L18
    L16:
        th = move-exception;
        FLogger.a.e("ZeusReporter", "copy Zeus mob params failed", th);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final PluginClassLoader f(String r3, String r4, JSONObject r5) {
        Map<String, ArrayDeque<b>> r0 = b;
        monitor-enter(r0);
        boolean r1 = !d.contains(r3);
        monitor-exit(r0);
        PluginClassLoader r2 = null;
        if (r1 == false) goto L11;
        c(r3, r4, r5);
        return null;
    L11:
        Plugin r6 = Zeus.getPlugin(r3);
        if (r6 == null) goto L14;
        r2 = r6.mClassLoader;
    L14:
        if (r2 != null) goto L16;
        FLogger.a.w("ZeusReporter", "report Zeus mob failed after post-load delay, classLoader is null, plugin=".concat(r3));
    L16:
        return r2;
    L17:
        th = move-exception;
        throw th;
    }
}
