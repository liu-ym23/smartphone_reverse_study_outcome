package com.larus.init.task;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m {
    public static final m a = null;
    public static final AtomicBoolean b = null;
    public static volatile boolean c;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;

    public m() {
    }

    static {
        a = new m();
        b = new AtomicBoolean(false);
        d = LazyKt.lazy(new f());
        e = LazyKt.lazy(new g());
        f = LazyKt.lazy(new h());
        g = LazyKt.lazy(new i());
        h = LazyKt.lazy(new j());
        i = LazyKt.lazy(new k());
    }

    public static boolean a() {
        return ((Boolean) i.getValue()).booleanValue();
    }

    public static void b() {
        if (a() == true) goto L5;
        return;
    L5:
        boolean r4 = c("IvyKit", ((Boolean) d.getValue()).booleanValue());
        boolean r6 = c("Applet", ((Boolean) e.getValue()).booleanValue());
        boolean r3 = c("TTVideoEngine", ((Boolean) f.getValue()).booleanValue());
        boolean r5 = c("LocalLife", ((Boolean) g.getValue()).booleanValue());
        boolean r7 = c("ECommerce", ((Boolean) h.getValue()).booleanValue());
        if (r4 == true) goto L13;
        if (r6 == true) goto L13;
        if (r3 == true) goto L13;
        if (r5 == true) goto L13;
        if (r7 == true) goto L13;
        boolean r2 = false;
    L14:
        if (r2 == true) goto L16;
        return;
    L16:
        if (b.compareAndSet(false, true) == false) goto L21;
        FLogger.a.i("BackgroundLazyInit", "event=foreground_replay_scheduled, ivyKit=" + r4 + ", applet=" + r6 + ", videoEngine=" + r3 + ", localLife=" + r5 + ", ecommerce=" + r7);
        ag9.a.a.execute(new l(r3, r4, r5, r6, r7));
        return;
    L21:
        return;
    L13:
        r2 = true;
        goto L14
    }

    public static void d(String r3) {
        FLogger.a.i("BackgroundLazyInit", "event=component_init_request, component=" + r3 + ", trigger=foreground_replay");
    }

    public static boolean c(String r4, boolean r5) {
        boolean r0 = false;
        if (r5 == true) goto L5;
        return false;
    L5:
        if (r5 == true) goto L7;
    L9:
        FLogger.a.i("BackgroundLazyInit", "event=lazy_init_decision, component=" + r4 + ", settingEnabled=" + r5 + ", backgroundColdLaunch=" + c + ", enabled=" + r0);
        return r0;
    L7:
        if (c == false) goto L9;
        r0 = true;
        goto L9
    }
}
