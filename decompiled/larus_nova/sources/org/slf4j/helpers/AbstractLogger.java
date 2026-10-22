package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractLogger implements xwc.c, Serializable {
    private static final long serialVersionUID = -2529255052481744503L;
    protected String name;

    public AbstractLogger() {
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

    public abstract String getFullyQualifiedCallerName();

    public abstract void handleNormalizedLoggingCall(Level r100, Marker r101, String r102, Object[] r103, Throwable r104);

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

    public Object readResolve() throws ObjectStreamException {
        return xwc.e.c(getName());
    }

    @Override // xwc.c
    public String getName() {
        return this.name;
    }

    public void debug(String r100) {
        if (isDebugEnabled() == false) goto L6;
        c(Level.DEBUG, null, r100, null);
        return;
    }

    public void error(String r100) {
        if (isErrorEnabled() == false) goto L6;
        c(Level.ERROR, null, r100, null);
        return;
    }

    public void info(String r100) {
        if (isInfoEnabled() == false) goto L6;
        c(Level.INFO, null, r100, null);
        return;
    }

    @Override // xwc.c
    public ywc.b makeLoggingEventBuilder(Level r100) {
        return new ywc.a(this);
    }

    @Override // xwc.c
    public void trace(String r100) {
        if (isTraceEnabled() == false) goto L6;
        c(Level.TRACE, null, r100, null);
        return;
    }

    @Override // xwc.c
    public void warn(String r100) {
        if (isWarnEnabled() == false) goto L6;
        c(Level.WARN, null, r100, null);
        return;
    }

    public void debug(String r100, Object r101) {
        if (isDebugEnabled() == false) goto L6;
        d(Level.DEBUG, null, r100, r101);
        return;
    }

    public void error(String r100, Object r101) {
        if (isErrorEnabled() == false) goto L6;
        d(Level.ERROR, null, r100, r101);
        return;
    }

    public void info(String r100, Object r101) {
        if (isInfoEnabled() == false) goto L6;
        d(Level.INFO, null, r100, r101);
        return;
    }

    public void trace(String r100, Object r101) {
        if (isTraceEnabled() == false) goto L6;
        d(Level.TRACE, null, r100, r101);
        return;
    }

    public void warn(String r100, Object r101) {
        if (isWarnEnabled() == false) goto L6;
        d(Level.WARN, null, r100, r101);
        return;
    }

    @Override // xwc.c
    public void debug(String r100, Throwable r101) {
        if (isDebugEnabled() == false) goto L6;
        c(Level.DEBUG, null, r100, r101);
        return;
    }

    public void error(String r100, Throwable r101) {
        if (isErrorEnabled() == false) goto L6;
        c(Level.ERROR, null, r100, r101);
        return;
    }

    public void info(String r100, Throwable r101) {
        if (isInfoEnabled() == false) goto L6;
        c(Level.INFO, null, r100, r101);
        return;
    }

    public void trace(String r100, Throwable r101) {
        if (isTraceEnabled() == false) goto L6;
        c(Level.TRACE, null, r100, r101);
        return;
    }

    public void warn(String r100, Throwable r101) {
        if (isWarnEnabled() == false) goto L6;
        c(Level.WARN, null, r100, r101);
        return;
    }

    public void debug(String r100, Object... r101) {
        if (isDebugEnabled() == false) goto L6;
        b(Level.DEBUG, null, r100, r101);
        return;
    }

    public void error(String r100, Object... r101) {
        if (isErrorEnabled() == false) goto L6;
        b(Level.ERROR, null, r100, r101);
        return;
    }

    public void info(String r100, Object... r101) {
        if (isInfoEnabled() == false) goto L6;
        b(Level.INFO, null, r100, r101);
        return;
    }

    public void trace(String r100, Object... r101) {
        if (isTraceEnabled() == false) goto L6;
        b(Level.TRACE, null, r100, r101);
        return;
    }

    public void warn(String r100, Object... r101) {
        if (isWarnEnabled() == false) goto L6;
        b(Level.WARN, null, r100, r101);
        return;
    }

    public void debug(Marker r100, String r101) {
        if (isDebugEnabled(r100) == false) goto L6;
        c(Level.DEBUG, r100, r101, null);
        return;
    }

    public void error(Marker r100, String r101) {
        if (isErrorEnabled(r100) == false) goto L6;
        c(Level.ERROR, r100, r101, null);
        return;
    }

    public void info(Marker r100, String r101) {
        if (isInfoEnabled(r100) == false) goto L6;
        c(Level.INFO, r100, r101, null);
        return;
    }

    public void trace(Marker r100, String r101) {
        if (isTraceEnabled(r100) == false) goto L6;
        c(Level.TRACE, r100, r101, null);
        return;
    }

    public void warn(Marker r100, String r101) {
        if (isWarnEnabled(r100) == false) goto L6;
        c(Level.WARN, r100, r101, null);
        return;
    }

    public void debug(String r100, Object r101, Object r110) {
        if (isDebugEnabled() == false) goto L6;
        a(Level.DEBUG, null, r100, r101, r110);
        return;
    }

    public void error(String r100, Object r101, Object r110) {
        if (isErrorEnabled() == false) goto L6;
        a(Level.ERROR, null, r100, r101, r110);
        return;
    }

    public void info(String r100, Object r101, Object r110) {
        if (isInfoEnabled() == false) goto L6;
        a(Level.INFO, null, r100, r101, r110);
        return;
    }

    public void trace(String r100, Object r101, Object r110) {
        if (isTraceEnabled() == false) goto L6;
        a(Level.TRACE, null, r100, r101, r110);
        return;
    }

    public void warn(String r100, Object r101, Object r110) {
        if (isWarnEnabled() == false) goto L6;
        a(Level.WARN, null, r100, r101, r110);
        return;
    }

    public void debug(Marker r100, String r101, Object r102) {
        if (isDebugEnabled(r100) == false) goto L6;
        d(Level.DEBUG, r100, r101, r102);
        return;
    }

    public void error(Marker r100, String r101, Object r102) {
        if (isErrorEnabled(r100) == false) goto L6;
        d(Level.ERROR, r100, r101, r102);
        return;
    }

    public void info(Marker r100, String r101, Object r102) {
        if (isInfoEnabled(r100) == false) goto L6;
        d(Level.INFO, r100, r101, r102);
        return;
    }

    public void trace(Marker r100, String r101, Object r102) {
        if (isTraceEnabled(r100) == false) goto L6;
        d(Level.TRACE, r100, r101, r102);
        return;
    }

    public void warn(Marker r100, String r101, Object r102) {
        if (isWarnEnabled(r100) == false) goto L6;
        d(Level.WARN, r100, r101, r102);
        return;
    }

    public void debug(Marker r100, String r101, Throwable r102) {
        if (isDebugEnabled(r100) == false) goto L6;
        c(Level.DEBUG, r100, r101, r102);
        return;
    }

    public void error(Marker r100, String r101, Throwable r102) {
        if (isErrorEnabled(r100) == false) goto L6;
        c(Level.ERROR, r100, r101, r102);
        return;
    }

    public void info(Marker r100, String r101, Throwable r102) {
        if (isInfoEnabled(r100) == false) goto L6;
        c(Level.INFO, r100, r101, r102);
        return;
    }

    public void trace(Marker r100, String r101, Throwable r102) {
        if (isTraceEnabled(r100) == false) goto L6;
        c(Level.TRACE, r100, r101, r102);
        return;
    }

    public void warn(Marker r100, String r101, Throwable r102) {
        if (isWarnEnabled(r100) == false) goto L6;
        c(Level.WARN, r100, r101, r102);
        return;
    }

    public void debug(Marker r100, String r101, Object... r102) {
        if (isDebugEnabled(r100) == false) goto L6;
        b(Level.DEBUG, r100, r101, r102);
        return;
    }

    public void error(Marker r100, String r101, Object... r102) {
        if (isErrorEnabled(r100) == false) goto L6;
        b(Level.ERROR, r100, r101, r102);
        return;
    }

    public void info(Marker r100, String r101, Object... r102) {
        if (isInfoEnabled(r100) == false) goto L6;
        b(Level.INFO, r100, r101, r102);
        return;
    }

    public void trace(Marker r100, String r101, Object... r102) {
        if (isTraceEnabled(r100) == false) goto L6;
        b(Level.TRACE, r100, r101, r102);
        return;
    }

    public void warn(Marker r100, String r101, Object... r102) {
        if (isWarnEnabled(r100) == false) goto L6;
        b(Level.WARN, r100, r101, r102);
        return;
    }

    public final void b(Level r100, Marker r101, String r110, Object[] r111) {
        if (r111 != null) goto L4;
    L9:
        Throwable r102 = null;
    L10:
        Throwable r103 = r102;
        if (r103 == null) goto L21;
        if (r111 == null) goto L20;
        if (r111.length == 0) goto L20;
        int r104 = r111.length - 1;
        Object[] r105 = new Object[r104];
        if (r104 <= 0) goto L18;
        System.arraycopy(r111, 0, r105, 0, r104);
    L18:
        handleNormalizedLoggingCall(r100, r101, r110, r105, r103);
        return;
    L20:
        throw new IllegalStateException("non-sensical empty or null argument array");
    L21:
        handleNormalizedLoggingCall(r100, r101, r110, r111, null);
        return;
    L4:
        if (r111.length == 0) goto L9;
        Object r106 = r111[r111.length - 1];
        if ((r106 instanceof Throwable) == false) goto L9;
        r102 = (Throwable) r106;
        goto L10
    }

    public final void c(Level r100, Marker r101, String r102, Throwable r110) {
        handleNormalizedLoggingCall(r100, r101, r102, null, r110);
    }

    public final void d(Level r100, Marker r101, String r110, Object r111) {
        handleNormalizedLoggingCall(r100, r101, r110, new Object[]{r111}, null);
    }

    public void debug(Marker r100, String r101, Object r110, Object r111) {
        if (isDebugEnabled(r100) == false) goto L6;
        a(Level.DEBUG, r100, r101, r110, r111);
        return;
    }

    public void error(Marker r100, String r101, Object r110, Object r111) {
        if (isErrorEnabled(r100) == false) goto L6;
        a(Level.ERROR, r100, r101, r110, r111);
        return;
    }

    public void info(Marker r100, String r101, Object r110, Object r111) {
        if (isInfoEnabled(r100) == false) goto L6;
        a(Level.INFO, r100, r101, r110, r111);
        return;
    }

    public void trace(Marker r100, String r101, Object r110, Object r111) {
        if (isTraceEnabled(r100) == false) goto L6;
        a(Level.TRACE, r100, r101, r110, r111);
        return;
    }

    public void warn(Marker r100, String r101, Object r110, Object r111) {
        if (isWarnEnabled(r100) == false) goto L6;
        a(Level.WARN, r100, r101, r110, r111);
        return;
    }

    public final void a(Level r110, Marker r111, String r112, Object r113, Object r114) {
        if ((r114 instanceof Throwable) == false) goto L5;
        handleNormalizedLoggingCall(r110, r111, r112, new Object[]{r113}, (Throwable) r114);
        return;
    L5:
        handleNormalizedLoggingCall(r110, r111, r112, new Object[]{r113, r114}, null);
    }
}
