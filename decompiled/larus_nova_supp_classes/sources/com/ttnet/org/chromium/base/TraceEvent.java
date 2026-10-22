package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("base::android")
@MainDex
public class TraceEvent implements AutoCloseable {
    public static final long ATRACE_TAG_APP = 4096;
    public static final long ATRACE_TAG_WEBVIEW = 16;
    private static ATrace sATrace;
    private static volatile boolean sEnabled;
    private static boolean sEventNameFilteringEnabled;
    private static AtomicBoolean sNativeTracingReady;
    private static AtomicBoolean sUiThreadReady;
    private final String mName;

    static {
        sNativeTracingReady = new AtomicBoolean();
        sUiThreadReady = new AtomicBoolean();
    }

    public static void onNativeTracingReady() {
        sNativeTracingReady.set(true);
        TraceEventJni.get().registerEnabledObserver();
        ATrace r0 = sATrace;
        if (r0 == null) goto L6;
        r0.onNativeTracingReady();
        return;
    }

    public static void onUiThreadReady() {
        sUiThreadReady.set(true);
        ATrace r0 = sATrace;
        if (r0 == null) goto L6;
        r0.onUiThreadReady();
    L6:
        if (sEnabled == false) goto L9;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static /* synthetic */ boolean access$200() {
        return sEnabled;
    }

    public static /* synthetic */ boolean access$300() {
        return sEventNameFilteringEnabled;
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static boolean eventNameFilteringEnabled() {
        return sEventNameFilteringEnabled;
    }

    public static View INVOKEVIRTUAL_com_ttnet_org_chromium_base_TraceEvent_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void begin(String r1) {
        begin(r1, null);
    }

    public static void dumpViewHierarchy(long r5) {
        if (ApplicationStatus.isInitialized() == true) goto L5;
        return;
    L5:
        Iterator r0 = ApplicationStatus.getRunningActivities().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Activity r1 = (Activity) r0.next();
        long r2 = TraceEventJni.get().startActivityDump(r1.getClass().getName(), r5);
        ViewHierarchyDumper.access$500(0, INVOKEVIRTUAL_com_ttnet_org_chromium_base_TraceEvent_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getRootView(), r2);
        goto L7
    }

    public static void end(String r1) {
        end(r1, null);
    }

    public static void instant(String r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r2, null);
        return;
    }

    public static TraceEvent scoped(String r1) {
        return scoped(r1, null);
    }

    public static void setEnabled(boolean r1) {
        if (r1 == false) goto L5;
        EarlyTraceEvent.disable();
    L5:
        if (sEnabled == r1) goto L16;
        sEnabled = r1;
        ATrace r0 = sATrace;
        if (r0 != null) goto L9;
    L10:
        Looper r2 = ThreadUtils.getUiThreadLooper();
        if (r1 == false) goto L13;
        BasicLooperMonitor r3 = LooperMonitorHolder.access$000();
    L14:
        r2.setMessageLogging(r3);
        goto L16
    L13:
        r3 = null;
        goto L14
    L9:
        if (r0.hasActiveSession() == false) goto L10;
    L16:
        if (sUiThreadReady.get() == false) goto L19;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static void setEventNameFilteringEnabled(boolean r0) {
        sEventNameFilteringEnabled = r0;
    }

    private TraceEvent(String r1, String r2) {
        this.mName = r1;
        begin(r1, r2);
    }

    public static void begin(String r1, String r2) {
        EarlyTraceEvent.begin(r1, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().begin(r1, r2);
        return;
    L5:
        ATrace r3 = sATrace;
        if (r3 == null) goto L10;
        r3.traceBegin(r1);
        return;
    }

    public static void end(String r1, String r2) {
        EarlyTraceEvent.end(r1, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().end(r1, r2);
        return;
    L5:
        ATrace r3 = sATrace;
        if (r3 == null) goto L10;
        r3.traceEnd();
        return;
    }

    public static void finishAsync(String r1, long r2) {
        EarlyTraceEvent.finishAsync(r1, r2);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().finishAsync(r1, r2);
        return;
    L5:
        ATrace r0 = sATrace;
        if (r0 == null) goto L10;
        r0.asyncTraceEnd(r1, (int) r2);
        return;
    }

    public static void instant(String r1, String r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r1, r2);
        return;
    }

    public static void instantAndroidIPC(String r1, long r2) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instantAndroidIPC(r1, r2);
        return;
    }

    public static void maybeEnableEarlyTracing(long r2, boolean r4) {
        if (r4 == false) goto L5;
        EarlyTraceEvent.maybeEnableInBrowserProcess();
    L5:
        if (r2 == 0) goto L13;
        sATrace = new ATrace(r2);
        if (sNativeTracingReady.get() == false) goto L10;
        sATrace.onNativeTracingReady();
    L10:
        if (sUiThreadReady.get() == false) goto L13;
        sATrace.onUiThreadReady();
    L13:
        if (EarlyTraceEvent.enabled() == false) goto L20;
        ATrace r3 = sATrace;
        if (r3 != null) goto L17;
    L18:
        ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        return;
    L17:
        if (r3.hasActiveSession() == false) goto L18;
        return;
    }

    public static TraceEvent scoped(String r1, String r2) {
        if (EarlyTraceEvent.enabled() == true) goto L9;
        if (enabled() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r1, r2);
    }

    public static void startAsync(String r1, long r2) {
        EarlyTraceEvent.startAsync(r1, r2);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().startAsync(r1, r2);
        return;
    L5:
        ATrace r0 = sATrace;
        if (r0 == null) goto L10;
        r0.asyncTraceBegin(r1, (int) r2);
        return;
    }
}
