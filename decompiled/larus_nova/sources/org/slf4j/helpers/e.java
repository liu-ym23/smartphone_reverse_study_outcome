package org.slf4j.helpers;

import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class e implements xwc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile xwc.c f526224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f526225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f526226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EventRecordingLogger f526227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Queue<org.slf4j.event.b> f526228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f526229g;

    public final xwc.c a() {
        if (this.f526224b == null) goto L7;
        return this.f526224b;
    L7:
        if (this.f526229g == false) goto L11;
        return NOPLogger.NOP_LOGGER;
    L11:
        if (this.f526227e != null) goto L14;
        this.f526227e = new EventRecordingLogger(this, this.f526228f);
    L14:
        return this.f526227e;
    }

    public final boolean b() {
        Boolean r100 = this.f526225c;
        if (r100 != null) goto L5;
        this.f526226d = this.f526224b.getClass().getMethod("log", new Class[]{org.slf4j.event.a.class});     // Catch: NoSuchMethodException -> L8
        this.f526225c = Boolean.TRUE;     // Catch: NoSuchMethodException -> L8
    L10:
        return this.f526225c.booleanValue();
    L8:
        this.f526225c = Boolean.FALSE;
        goto L10
    L5:
        return r100.booleanValue();
    }

    public final int hashCode() {
        return this.f526223a.hashCode();
    }

    @Override // xwc.c
    public final boolean isDebugEnabled() {
        return a().isDebugEnabled();
    }

    @Override // xwc.c
    public final boolean isErrorEnabled() {
        return a().isErrorEnabled();
    }

    @Override // xwc.c
    public final boolean isInfoEnabled() {
        return a().isInfoEnabled();
    }

    @Override // xwc.c
    public final boolean isTraceEnabled() {
        return a().isTraceEnabled();
    }

    @Override // xwc.c
    public final boolean isWarnEnabled() {
        return a().isWarnEnabled();
    }

    @Override // xwc.c
    public final String getName() {
        return this.f526223a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L14:
        return false;
    L8:
        if (e.class != r100.getClass()) goto L14;
        if (this.f526223a.equals(((e) r100).f526223a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // xwc.c
    public final boolean isEnabledForLevel(Level r100) {
        return a().isEnabledForLevel(r100);
    }

    @Override // xwc.c
    public final ywc.b makeLoggingEventBuilder(Level r100) {
        return a().makeLoggingEventBuilder(r100);
    }

    @Override // xwc.c
    public final void trace(String r100) {
        a().trace(r100);
    }

    @Override // xwc.c
    public final void warn(String r100) {
        a().warn(r100);
    }

    @Override // xwc.c
    public final void debug(String r100, Throwable r101) {
        a().debug("Catched expected exception while generating candidates", r101);
    }

    public e(String r100, Queue<org.slf4j.event.b> r101, boolean r102) {
        this.f526223a = r100;
        this.f526228f = r101;
        this.f526229g = r102;
    }
}
