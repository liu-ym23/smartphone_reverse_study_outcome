package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes23.dex */
public class InitReport {
    private static final int EVENT_LIMIT = 10;
    private static final String TAG = "HaReport";
    private static List<Runnable> eventsToReport;
    private static volatile boolean hasConnectNet;

    public InitReport() {
    }

    public static void disableConnectNet() {
        hasConnectNet = false;
    }

    static {
        eventsToReport = new CopyOnWriteArrayList();
    }

    public static void enableConnectNet() {
        if (hasConnectNet == false) goto L6;
        Logger.v(TAG, "has connect, not need to deal delay task");
        return;
    L6:
        Logger.v(TAG, "deal delay task");
        hasConnectNet = true;
        HianalyticsHelper.getInstance().getReportExecutor().submit(new AnonymousClass1());     // Catch: Throwable -> L9 RejectedExecutionException -> L10
    L15:
        return;
    L10:
        Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        return;
    L9:
        Logger.e(TAG, "the thread submit has fatal error!");
    }

    private static void submitAllEvents() {
        Iterator<Runnable> r100 = eventsToReport.iterator();     // Catch: Exception -> L9 NullPointerException -> L10 RejectedExecutionException -> L11
    L5:
        if (r100.hasNext() == false) goto L7;
        Runnable r101 = r100.next();     // Catch: Exception -> L9 NullPointerException -> L10 RejectedExecutionException -> L11
        HianalyticsHelper.getInstance().getReportExecutor().submit(r101);     // Catch: Exception -> L9 NullPointerException -> L10 RejectedExecutionException -> L11
        goto L5
    L7:
        eventsToReport.clear();     // Catch: Exception -> L9 NullPointerException -> L10 RejectedExecutionException -> L11
    L18:
        return;
    L10:
        Logger.e(TAG, "event is null occured");
        return;
    L11:
        Logger.e(TAG, "submit failed of rejected execution exception");
        return;
    L9:
        Logger.e(TAG, "submit failed because of some exception");
    }

    public static /* synthetic */ void access$000() {
        submitAllEvents();
    }

    public static boolean isHasConnectNet() {
        return hasConnectNet;
    }

    public static void executeDelay(Runnable r100) {
        if (hasConnectNet == true) goto L11;
        eventsToReport.add(r100);
        return;
    L11:
        HianalyticsHelper.getInstance().getReportExecutor().execute(r100);     // Catch: Throwable -> L6 RejectedExecutionException -> L7
    L14:
        return;
    L7:
        Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        return;
    L6:
        Logger.e(TAG, "the thread submit has fatal error!");
    }

    public static void reportWhenInit(Runnable r100) {
        if (hasConnectNet == false) goto L10;
        HianalyticsHelper.getInstance().getReportExecutor().execute(r100);     // Catch: Throwable -> L6 RejectedExecutionException -> L7
    L18:
        return;
    L7:
        Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        return;
    L6:
        Logger.e(TAG, "the thread submit has fatal error!");
        return;
    L10:
        if (eventsToReport.size() <= 10) goto L13;
        Logger.e("TAG", "the event to be report when init exceed the limit!");
        return;
    L13:
        eventsToReport.add(r100);
    }
}
