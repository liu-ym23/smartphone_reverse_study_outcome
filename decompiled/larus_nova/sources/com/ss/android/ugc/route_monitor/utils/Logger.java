package com.ss.android.ugc.route_monitor.utils;

import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f454745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f454746b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f454747c = null;

    static {
        f454745a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(Logger.class), "isDebug", "isDebug$route_monitor_release()Z"))};
        f454747c = new Logger();
        f454746b = new q(Logger$isDebug$2.INSTANCE);
    }

    public Logger() {
    }

    public final boolean c() {
        return ((Boolean) f454746b.getValue(this, f454745a[0])).booleanValue();
    }

    public final boolean a() {
        com.ss.android.ugc.route_monitor.c.a().getClass();
        if (c() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public final boolean b() {
        com.ss.android.ugc.route_monitor.c.a().getClass();
        if (c() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public final boolean e() {
        com.ss.android.ugc.route_monitor.c.a().getClass();
        if (c() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public final boolean d(Throwable r100) {
        com.ss.android.ugc.route_monitor.c.a().getClass();
        if (c() == true) goto L6;
        return false;
    L6:
        r100.getMessage();
        return true;
    }
}
