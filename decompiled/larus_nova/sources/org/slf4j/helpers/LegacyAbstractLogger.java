package org.slf4j.helpers;

import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
public abstract class LegacyAbstractLogger extends AbstractLogger {
    private static final long serialVersionUID = -7041884104854048950L;

    @Override // org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atDebug() {
        return xwc.b.a(this);
    }

    @Override // org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atError() {
        return xwc.b.b(this);
    }

    @Override // org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atInfo() {
        return xwc.b.c(this);
    }

    @Override // org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atLevel(Level r100) {
        return xwc.b.d(this, r100);
    }

    @Override // org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atTrace() {
        return xwc.b.e(this);
    }

    @Override // org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atWarn() {
        return xwc.b.f(this);
    }

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public abstract /* synthetic */ boolean isDebugEnabled();

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level r100) {
        return xwc.b.g(this, r100);
    }

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public abstract /* synthetic */ boolean isErrorEnabled();

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public abstract /* synthetic */ boolean isInfoEnabled();

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public abstract /* synthetic */ boolean isTraceEnabled();

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public abstract /* synthetic */ boolean isWarnEnabled();

    public LegacyAbstractLogger() {
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public boolean isDebugEnabled(Marker r100) {
        return isDebugEnabled();
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public boolean isErrorEnabled(Marker r100) {
        return isErrorEnabled();
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public boolean isInfoEnabled(Marker r100) {
        return isInfoEnabled();
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public boolean isTraceEnabled(Marker r100) {
        return isTraceEnabled();
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public boolean isWarnEnabled(Marker r100) {
        return isWarnEnabled();
    }

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public ywc.b makeLoggingEventBuilder(Level r100) {
        return new ywc.a(this);
    }
}
