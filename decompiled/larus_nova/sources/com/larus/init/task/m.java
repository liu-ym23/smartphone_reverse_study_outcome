package com.larus.init.task;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f351424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f351425b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f351426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f351427d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f351428e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f351429f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f351430g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f351431h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f351432i = null;

    public m() {
    }

    static {
        f351424a = new m();
        f351425b = new AtomicBoolean(false);
        f351427d = LazyKt.lazy(new f());
        f351428e = LazyKt.lazy(new g());
        f351429f = LazyKt.lazy(new h());
        f351430g = LazyKt.lazy(new i());
        f351431h = LazyKt.lazy(new j());
        f351432i = LazyKt.lazy(new k());
    }

    public static boolean a() {
        return ((Boolean) f351432i.getValue()).booleanValue();
    }

    public static void b() {
        if (a() == true) goto L5;
        return;
    L5:
        final boolean r100 = c("IvyKit", ((Boolean) f351427d.getValue()).booleanValue());
        final boolean r101 = c("Applet", ((Boolean) f351428e.getValue()).booleanValue());
        final boolean r102 = c("TTVideoEngine", ((Boolean) f351429f.getValue()).booleanValue());
        final boolean r103 = c("LocalLife", ((Boolean) f351430g.getValue()).booleanValue());
        final boolean r104 = c("ECommerce", ((Boolean) f351431h.getValue()).booleanValue());
        if (r100 == true) goto L13;
        if (r101 == true) goto L13;
        if (r102 == true) goto L13;
        if (r103 == true) goto L13;
        if (r104 == true) goto L13;
        boolean r105 = false;
    L14:
        if (r105 == true) goto L16;
        return;
    L16:
        if (f351425b.compareAndSet(false, true) == false) goto L21;
        FLogger.f375446a.i("BackgroundLazyInit", "event=foreground_replay_scheduled, ivyKit=" + r100 + ", applet=" + r101 + ", videoEngine=" + r102 + ", localLife=" + r103 + ", ecommerce=" + r104);
        ag9.a.f3362a.execute(new l(r102, r100, r103, r101, r104));
        return;
    L21:
        return;
    L13:
        r105 = true;
        goto L14
    }

    public static void d(String r100) {
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=" + r100 + ", trigger=foreground_replay");
    }

    public static boolean c(String r100, boolean r101) {
        boolean r102 = false;
        if (r101 == true) goto L5;
        return false;
    L5:
        if (r101 == true) goto L7;
    L9:
        FLogger.f375446a.i("BackgroundLazyInit", "event=lazy_init_decision, component=" + r100 + ", settingEnabled=" + r101 + ", backgroundColdLaunch=" + f351426c + ", enabled=" + r102);
        return r102;
    L7:
        if (f351426c == false) goto L9;
        r102 = true;
        goto L9
    }
}
