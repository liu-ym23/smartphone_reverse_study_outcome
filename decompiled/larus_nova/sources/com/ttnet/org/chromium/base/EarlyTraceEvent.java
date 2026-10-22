package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("base::android")
@MainDex
public class EarlyTraceEvent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
    static final int STATE_DISABLED = 0;
    static final int STATE_ENABLED = 1;
    static final int STATE_FINISHED = 2;
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    public static final String TRACE_EARLY_JAVA_IN_CHILD_SWITCH = "trace-early-java-in-child";
    private static final String TRACE_STARTUP_SWITCH = "trace-startup";
    static List<AsyncEvent> sAsyncEvents;
    private static boolean sCachedBackgroundStartupTracingFlag;
    private static volatile boolean sEnabledInChildProcessBeforeCommandLine;
    static List<Event> sEvents;
    static final Object sLock = null;
    static volatile int sState;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class AsyncEvent {
        final long mId;
        final boolean mIsStart;
        final String mName;
        final long mTimeNanos;

        public AsyncEvent(String r100, long r101, boolean r102) {
            this.mName = r100;
            this.mId = r101;
            this.mIsStart = r102;
            this.mTimeNanos = System.nanoTime();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Event {
        final boolean mIsStart;
        final boolean mIsToplevel;
        final String mName;
        final int mThreadId;
        final long mThreadTimeMillis;
        final long mTimeNanos;

        public Event(String r100, boolean r101, boolean r102) {
            this.mIsStart = r101;
            this.mIsToplevel = r102;
            this.mName = r100;
            this.mThreadId = Process.myTid();
            this.mTimeNanos = System.nanoTime();
            this.mThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface Natives {
        void recordEarlyAsyncBeginEvent(String r100, long r101, long r102);

        void recordEarlyAsyncEndEvent(String r100, long r101, long r102);

        void recordEarlyBeginEvent(String r100, long r101, int r102, long r103);

        void recordEarlyEndEvent(String r100, long r101, int r102, long r103);

        void recordEarlyToplevelBeginEvent(String r100, long r101, int r102, long r103);

        void recordEarlyToplevelEndEvent(String r100, long r101, int r102, long r103);
    }

    public EarlyTraceEvent() {
    }

    public static void earlyEnableInChildWithoutCommandLine() {
        sEnabledInChildProcessBeforeCommandLine = true;
        enable();
    }

    static {
        sState = 0;
        sLock = new Object();
    }

    public static void disable() {
        Object r100 = sLock;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (enabled() == true) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L9:
        if (sEvents.isEmpty() == true) goto L12;
        dumpEvents(sEvents);     // Catch: Throwable -> L17
        sEvents.clear();     // Catch: Throwable -> L17
    L12:
        if (sAsyncEvents.isEmpty() == true) goto L14;
        dumpAsyncEvents(sAsyncEvents);     // Catch: Throwable -> L17
        sAsyncEvents.clear();     // Catch: Throwable -> L17
    L14:
        sState = 2;     // Catch: Throwable -> L17
        sEvents = null;     // Catch: Throwable -> L17
        sAsyncEvents = null;     // Catch: Throwable -> L17
        monitor-exit(r100);     // Catch: Throwable -> L17
    }

    public static void enable() {
        Object r100 = sLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sState == 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        sEvents = new ArrayList();     // Catch: Throwable -> L11
        sAsyncEvents = new ArrayList();     // Catch: Throwable -> L11
        sState = 1;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public static boolean enabled() {
        if (sState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void onCommandLineAvailableInChildProcess() {
        if (sEnabledInChildProcessBeforeCommandLine == true) goto L5;
        return;
    L5:
        Object r100 = sLock;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (CommandLine.getInstance().hasSwitch(TRACE_EARLY_JAVA_IN_CHILD_SWITCH) == true) goto L13;
        reset();     // Catch: Throwable -> L17
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L13:
        if (sState != 0) goto L15;
        enable();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L17
    }

    public static void reset() {
        Object r100 = sLock;
        monitor-enter(r100);
        sState = 0;     // Catch: Throwable -> L8
        sEvents = null;     // Catch: Throwable -> L8
        sAsyncEvents = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void maybeEnableInBrowserProcess() {
        ThreadUtils.assertOnUiThread();
        if (sState == 0) goto L5;
        return;
    L5:
        StrictMode.ThreadPolicy r100 = StrictMode.allowThreadDiskReads();
    L24:
        th = move-exception;
        StrictMode.setThreadPolicy(r100);
        throw th;
    L7:
        boolean r101 = true;
        if (CommandLine.getInstance().hasSwitch(TRACE_STARTUP_SWITCH) == false) goto L27;
        boolean r102 = true;
    L14:
        if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false) == false) goto L19;
        if (r102 == false) goto L17;
        setBackgroundStartupTracingFlag(false);     // Catch: Throwable -> L24
        sCachedBackgroundStartupTracingFlag = false;     // Catch: Throwable -> L24
        goto L19
    L17:
        sCachedBackgroundStartupTracingFlag = true;     // Catch: Throwable -> L24
    L20:
        StrictMode.setThreadPolicy(r100);
        if (r101 == false) goto L30;
        enable();
        return;
    L30:
        return;
    L19:
        r101 = r102;
        goto L20
    L27:
        r102 = new PolarisFileWrapper(TRACE_CONFIG_FILENAME).exists();     // Catch: SecurityException -> L12 Throwable -> L24
    L12:
        r102 = false;
        goto L14
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    private static void dumpAsyncEvents(List<AsyncEvent> r110) {
        Iterator<AsyncEvent> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L9;
        AsyncEvent r100 = r111.next();
        if (r100.mIsStart == true) goto L7;
        EarlyTraceEventJni.get().recordEarlyAsyncEndEvent(r100.mName, r100.mId, r100.mTimeNanos);
        goto L4
    L7:
        EarlyTraceEventJni.get().recordEarlyAsyncBeginEvent(r100.mName, r100.mId, r100.mTimeNanos);
        goto L4
    }

    private static void dumpEvents(List<Event> r110) {
        Iterator<Event> r100 = r110.iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        Event r101 = r100.next();
        if (r101.mIsStart == true) goto L8;
        if (r101.mIsToplevel == true) goto L13;
        EarlyTraceEventJni.get().recordEarlyEndEvent(r101.mName, r101.mTimeNanos, r101.mThreadId, r101.mThreadTimeMillis);
        goto L4
    L13:
        EarlyTraceEventJni.get().recordEarlyToplevelEndEvent(r101.mName, r101.mTimeNanos, r101.mThreadId, r101.mThreadTimeMillis);
        goto L4
    L8:
        if (r101.mIsToplevel == true) goto L9;
        EarlyTraceEventJni.get().recordEarlyBeginEvent(r101.mName, r101.mTimeNanos, r101.mThreadId, r101.mThreadTimeMillis);
        goto L4
    L9:
        EarlyTraceEventJni.get().recordEarlyToplevelBeginEvent(r101.mName, r101.mTimeNanos, r101.mThreadId, r101.mThreadTimeMillis);
        goto L4
    }

    public static List<Event> getMatchingCompletedEventsForTesting(String r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Event> r103 = sEvents.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        Event r104 = r103.next();     // Catch: Throwable -> L12
        if (r104.mName.equals(r100) == false) goto L6;
        r102.add(r104);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    public static void setBackgroundStartupTracingFlag(boolean r100) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, r100).apply();
    }

    public static void begin(String r100, boolean r101) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r102 = new Event(r100, true, r101);
        Object r103 = sLock;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L11:
        sEvents.add(r102);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
    }

    public static void end(String r100, boolean r101) {
        if (enabled() == true) goto L5;
        return;
    L5:
        Event r102 = new Event(r100, false, r101);
        Object r103 = sLock;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L11:
        sEvents.add(r102);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
    }

    public static void finishAsync(String r100, long r101) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r102 = new AsyncEvent(r100, r101, false);
        Object r103 = sLock;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r102);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
    }

    public static void startAsync(String r100, long r101) {
        if (enabled() == true) goto L5;
        return;
    L5:
        AsyncEvent r102 = new AsyncEvent(r100, r101, true);
        Object r103 = sLock;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (enabled() == true) goto L11;
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L11:
        sAsyncEvents.add(r102);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
    }
}
