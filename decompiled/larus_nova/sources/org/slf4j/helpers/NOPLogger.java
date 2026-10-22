package org.slf4j.helpers;

import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
public class NOPLogger extends NamedLoggerBase {
    public static final NOPLogger NOP_LOGGER = null;
    private static final long serialVersionUID = -517220405410904473L;

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
    public final void debug(String r100) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(String r100, Object r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(String r100, Object r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final void debug(String r100, Throwable r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(String r100, Object... r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker r100, String r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker r100, String r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker r100, String r101, Object r102, Object r103) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker r100, String r101, Throwable r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker r100, String r101, Object... r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String r100) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String r100, Object r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String r100, Object r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String r100, Throwable r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String r100, Object... r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker r100, String r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker r100, String r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker r100, String r101, Object r102, Object r103) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker r100, String r101, Throwable r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker r100, String r101, Object... r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public String getName() {
        return "NOP";
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String r100) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String r100, Object r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String r100, Object r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String r100, Throwable r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String r100, Object... r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker r100, String r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker r100, String r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker r100, String r101, Object r102, Object r103) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker r100, String r101, Throwable r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker r100, String r101, Object... r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isDebugEnabled(Marker r100) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level r100) {
        return xwc.b.g(this, r100);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isErrorEnabled(Marker r100) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isInfoEnabled(Marker r100) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isTraceEnabled(Marker r100) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isWarnEnabled(Marker r100) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final void trace(String r100) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String r100, Object r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String r100, Object r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String r100, Throwable r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String r100, Object... r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker r100, String r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker r100, String r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker r100, String r101, Object r102, Object r103) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker r100, String r101, Throwable r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker r100, String r101, Object... r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public final void warn(String r100) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String r100, Object r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String r100, Object r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String r100, Throwable r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String r100, Object... r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker r100, String r101) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker r100, String r101, Object r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker r100, String r101, Object r102, Object r103) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker r100, String r101, Throwable r102) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker r100, String r101, Object... r102) {
    }

    static {
        NOP_LOGGER = new NOPLogger();
    }

    public NOPLogger() {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, xwc.c
    public ywc.b makeLoggingEventBuilder(Level r100) {
        return new ywc.a(this);
    }
}
