package org.slf4j.helpers;

import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase {
    private static final long serialVersionUID = 9044267456635152283L;

    @Override // org.slf4j.helpers.NamedLoggerBase
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atDebug() {
        return xwc.b.a(this);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atError() {
        return xwc.b.b(this);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atInfo() {
        return xwc.b.c(this);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atLevel(Level r100) {
        return xwc.b.d(this, r100);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atTrace() {
        return xwc.b.e(this);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atWarn() {
        return xwc.b.f(this);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String r100);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String r100, Object r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String r100, Object r101, Object r102);

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ void debug(String r100, Throwable r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String r100, Object... r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String r100);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String r100, Object r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String r100, Object r101, Object r102);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String r100, Throwable r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String r100, Object... r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String r100);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String r100, Object r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String r100, Object r101, Object r102);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String r100, Throwable r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String r100, Object... r101);

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ boolean isDebugEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level r100) {
        return xwc.b.g(this, r100);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ boolean isErrorEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ boolean isInfoEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ boolean isTraceEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ boolean isWarnEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ void trace(String r100);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String r100, Object r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String r100, Object r101, Object r102);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String r100, Throwable r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String r100, Object... r101);

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public abstract /* synthetic */ void warn(String r100);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String r100, Object r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String r100, Object r101, Object r102);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String r100, Throwable r101);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String r100, Object... r101);

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public MarkerIgnoringBase() {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isDebugEnabled(Marker r100) {
        return isDebugEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isErrorEnabled(Marker r100) {
        return isErrorEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isInfoEnabled(Marker r100) {
        return isInfoEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isTraceEnabled(Marker r100) {
        return isTraceEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isWarnEnabled(Marker r100) {
        return isWarnEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public ywc.b makeLoggingEventBuilder(Level r100) {
        return new ywc.a(this);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker r100, String r101) {
        debug(r101);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker r100, String r101) {
        error(r101);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker r100, String r101) {
        info(r101);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker r100, String r101) {
        trace(r101);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker r100, String r101) {
        warn(r101);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker r100, String r101, Object r102) {
        debug(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker r100, String r101, Object r102) {
        error(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker r100, String r101, Object r102) {
        info(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker r100, String r101, Object r102) {
        trace(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker r100, String r101, Object r102) {
        warn(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker r100, String r101, Throwable r102) {
        debug(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker r100, String r101, Throwable r102) {
        error(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker r100, String r101, Throwable r102) {
        info(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker r100, String r101, Throwable r102) {
        trace(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker r100, String r101, Throwable r102) {
        warn(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker r100, String r101, Object... r102) {
        debug(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker r100, String r101, Object... r102) {
        error(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker r100, String r101, Object... r102) {
        info(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker r100, String r101, Object... r102) {
        trace(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker r100, String r101, Object... r102) {
        warn(r101, r102);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker r100, String r101, Object r102, Object r103) {
        debug(r101, r102, r103);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker r100, String r101, Object r102, Object r103) {
        error(r101, r102, r103);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker r100, String r101, Object r102, Object r103) {
        info(r101, r102, r103);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker r100, String r101, Object r102, Object r103) {
        trace(r101, r102, r103);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker r100, String r101, Object r102, Object r103) {
        warn(r101, r102, r103);
    }
}
