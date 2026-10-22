package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
abstract class NamedLoggerBase implements xwc.c, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    public NamedLoggerBase() {
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atDebug() {
        return xwc.b.a(this);
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atError() {
        return xwc.b.b(this);
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atInfo() {
        return xwc.b.c(this);
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atLevel(Level r100) {
        return xwc.b.d(this, r100);
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atTrace() {
        return xwc.b.e(this);
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atWarn() {
        return xwc.b.f(this);
    }

    public abstract /* synthetic */ void debug(String r100);

    public abstract /* synthetic */ void debug(String r100, Object r101);

    public abstract /* synthetic */ void debug(String r100, Object r101, Object r102);

    @Override // xwc.c
    public abstract /* synthetic */ void debug(String r100, Throwable r101);

    public abstract /* synthetic */ void debug(String r100, Object... r101);

    public abstract /* synthetic */ void debug(Marker r100, String r101);

    public abstract /* synthetic */ void debug(Marker r100, String r101, Object r102);

    public abstract /* synthetic */ void debug(Marker r100, String r101, Object r102, Object r103);

    public abstract /* synthetic */ void debug(Marker r100, String r101, Throwable r102);

    public abstract /* synthetic */ void debug(Marker r100, String r101, Object... r102);

    public abstract /* synthetic */ void error(String r100);

    public abstract /* synthetic */ void error(String r100, Object r101);

    public abstract /* synthetic */ void error(String r100, Object r101, Object r102);

    public abstract /* synthetic */ void error(String r100, Throwable r101);

    public abstract /* synthetic */ void error(String r100, Object... r101);

    public abstract /* synthetic */ void error(Marker r100, String r101);

    public abstract /* synthetic */ void error(Marker r100, String r101, Object r102);

    public abstract /* synthetic */ void error(Marker r100, String r101, Object r102, Object r103);

    public abstract /* synthetic */ void error(Marker r100, String r101, Throwable r102);

    public abstract /* synthetic */ void error(Marker r100, String r101, Object... r102);

    public abstract /* synthetic */ void info(String r100);

    public abstract /* synthetic */ void info(String r100, Object r101);

    public abstract /* synthetic */ void info(String r100, Object r101, Object r102);

    public abstract /* synthetic */ void info(String r100, Throwable r101);

    public abstract /* synthetic */ void info(String r100, Object... r101);

    public abstract /* synthetic */ void info(Marker r100, String r101);

    public abstract /* synthetic */ void info(Marker r100, String r101, Object r102);

    public abstract /* synthetic */ void info(Marker r100, String r101, Object r102, Object r103);

    public abstract /* synthetic */ void info(Marker r100, String r101, Throwable r102);

    public abstract /* synthetic */ void info(Marker r100, String r101, Object... r102);

    @Override // xwc.c
    public abstract /* synthetic */ boolean isDebugEnabled();

    public abstract /* synthetic */ boolean isDebugEnabled(Marker r100);

    @Override // xwc.c
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level r100) {
        return xwc.b.g(this, r100);
    }

    @Override // xwc.c
    public abstract /* synthetic */ boolean isErrorEnabled();

    public abstract /* synthetic */ boolean isErrorEnabled(Marker r100);

    @Override // xwc.c
    public abstract /* synthetic */ boolean isInfoEnabled();

    public abstract /* synthetic */ boolean isInfoEnabled(Marker r100);

    @Override // xwc.c
    public abstract /* synthetic */ boolean isTraceEnabled();

    public abstract /* synthetic */ boolean isTraceEnabled(Marker r100);

    @Override // xwc.c
    public abstract /* synthetic */ boolean isWarnEnabled();

    public abstract /* synthetic */ boolean isWarnEnabled(Marker r100);

    @Override // xwc.c
    public abstract /* synthetic */ void trace(String r100);

    public abstract /* synthetic */ void trace(String r100, Object r101);

    public abstract /* synthetic */ void trace(String r100, Object r101, Object r102);

    public abstract /* synthetic */ void trace(String r100, Throwable r101);

    public abstract /* synthetic */ void trace(String r100, Object... r101);

    public abstract /* synthetic */ void trace(Marker r100, String r101);

    public abstract /* synthetic */ void trace(Marker r100, String r101, Object r102);

    public abstract /* synthetic */ void trace(Marker r100, String r101, Object r102, Object r103);

    public abstract /* synthetic */ void trace(Marker r100, String r101, Throwable r102);

    public abstract /* synthetic */ void trace(Marker r100, String r101, Object... r102);

    @Override // xwc.c
    public abstract /* synthetic */ void warn(String r100);

    public abstract /* synthetic */ void warn(String r100, Object r101);

    public abstract /* synthetic */ void warn(String r100, Object r101, Object r102);

    public abstract /* synthetic */ void warn(String r100, Throwable r101);

    public abstract /* synthetic */ void warn(String r100, Object... r101);

    public abstract /* synthetic */ void warn(Marker r100, String r101);

    public abstract /* synthetic */ void warn(Marker r100, String r101, Object r102);

    public abstract /* synthetic */ void warn(Marker r100, String r101, Object r102, Object r103);

    public abstract /* synthetic */ void warn(Marker r100, String r101, Throwable r102);

    public abstract /* synthetic */ void warn(Marker r100, String r101, Object... r102);

    public Object readResolve() throws ObjectStreamException {
        return xwc.e.c(getName());
    }

    @Override // xwc.c
    public String getName() {
        return this.name;
    }

    @Override // xwc.c
    public ywc.b makeLoggingEventBuilder(Level r100) {
        return new ywc.a(this);
    }
}
