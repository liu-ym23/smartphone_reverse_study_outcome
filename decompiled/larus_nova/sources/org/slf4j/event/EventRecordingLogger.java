package org.slf4j.event;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.CheckReturnValue;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.e;

/* JADX INFO: loaded from: classes42.dex */
public class EventRecordingLogger extends LegacyAbstractLogger {
    static final boolean RECORD_ALL_EVENTS = true;
    private static final long serialVersionUID = -176083308134819629L;
    Queue<b> eventQueue;
    e logger;
    String name;

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atDebug() {
        return xwc.b.a(this);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atError() {
        return xwc.b.b(this);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atInfo() {
        return xwc.b.c(this);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atLevel(Level r100) {
        return xwc.b.d(this, r100);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atTrace() {
        return xwc.b.e(this);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger
    @CheckReturnValue
    public /* bridge */ /* synthetic */ ywc.b atWarn() {
        return xwc.b.f(this);
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public String getFullyQualifiedCallerName() {
        return null;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level r100) {
        return xwc.b.g(this, r100);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.AbstractLogger, xwc.c
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, xwc.c
    public ywc.b makeLoggingEventBuilder(Level r100) {
        return new ywc.a(this);
    }

    public EventRecordingLogger(e r100, Queue<b> r101) {
        this.logger = r100;
        this.name = r100.f526223a;
        this.eventQueue = r101;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public void handleNormalizedLoggingCall(Level r100, Marker r101, String r102, Object[] r103, Throwable r104) {
        b r105 = new b();
        System.currentTimeMillis();
        r105.f526216a = r100;
        r105.f526218c = this.logger;
        if (r101 != null) goto L5;
    L8:
        ThreadMethodProxy.currentThread().getName();
        r105.f526219d = r103;
        this.eventQueue.add(r105);
        return;
    L5:
        if (r105.f526217b != null) goto L7;
        r105.f526217b = new ArrayList(2);
    L7:
        ((ArrayList) r105.f526217b).add(r101);
        goto L8
    }
}
