package com.bytedance.security.android.aopcheck.reporter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/ReportManager;", "", "()V", "mLock", "mReporters", "", "Lcom/bytedance/security/android/aopcheck/reporter/IReporter;", "addReporter", "", "reporter", "report", "serviceName", "", "event", "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", "reportInit", "duration", "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class ReportManager {
    public static final ReportManager INSTANCE = null;
    private static final Object mLock = null;
    private static final List<IReporter> mReporters = null;

    private ReportManager() {
    }

    static {
        INSTANCE = new ReportManager();
        mReporters = new ArrayList();
        mLock = new Object();
    }

    public final void addReporter(IReporter r100) {
        mReporters.add(r100);
    }

    public final void reportInit(long r100) {
        Object r101 = mLock;
        monitor-enter(r101);
        Iterator<T> r102 = mReporters.iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        ((IReporter) r102.next()).doReportInitEvnt(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void report(String r100, IEvent r101) {
        Object r102 = mLock;
        monitor-enter(r102);
        Iterator<T> r103 = mReporters.iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((IReporter) r103.next()).doReport(r101);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
