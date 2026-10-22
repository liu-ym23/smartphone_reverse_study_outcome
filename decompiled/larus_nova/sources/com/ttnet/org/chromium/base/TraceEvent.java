package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.TraceEvent$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ATrace implements MessageQueue.IdleHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String TAG = "ATrace";
        private Method mAsyncTraceBeginMethod;
        private Method mAsyncTraceEndMethod;
        private Method mGetSystemPropertyMethod;
        private boolean mIdleHandlerRegistered;
        private Method mIsTraceTagEnabledMethod;
        private final AtomicBoolean mNativeTracingReady;
        private boolean mShouldWriteToSystemTrace;
        private Class<?> mSystemPropertiesClass;
        private Method mTraceBeginMethod;
        private Class<?> mTraceClass;
        private Method mTraceEndMethod;
        private final long mTraceTag;
        private final AtomicBoolean mTraceTagActive;
        private final AtomicBoolean mUiThreadReady;

        /* JADX INFO: loaded from: classes41.dex */
        public static class CategoryConfig {
            public String filter;
            public boolean shouldWriteToATrace;

            private CategoryConfig() {
                this.filter = "";
                this.shouldWriteToATrace = true;
            }

            public /* synthetic */ CategoryConfig(AnonymousClass1 r100) {
                this();
            }
        }

        public static /* synthetic */ void a(ATrace r100) {
            r100.lambda$onNativeTracingReady$0();
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public static /* synthetic */ void b(ATrace r100) {
            r100.lambda$onUiThreadReady$1();
        }

        private CategoryConfig getCategoryConfigFromATrace() {
            CategoryConfig r100 = new CategoryConfig(null);
            Integer r101 = getIntegerSystemProperty("debug.atrace.app_number");
            if (r101 != null) goto L5;
        L30:
            return r100;
        L5:
            if (r101.intValue() <= 0) goto L30;
            if (ContextUtils.getApplicationContext() == null) goto L30;
            String r102 = ContextUtils.getApplicationContext().getPackageName();
            int r103 = 0;
        L10:
            if (r103 >= r101.intValue()) goto L30;
            String r104 = getSystemProperty("debug.atrace.app_" + r103);
            if (r104 == null) goto L29;
            if (r104.startsWith(r102) == false) goto L29;
            String r105 = r104.substring(r102.length());
            if (r105.startsWith(HTTP.URL_DEFAULT) == false) goto L29;
            String[] r106 = r105.substring(1).split(":");
            int r107 = r106.length;
            int r108 = 0;
        L20:
            if (r108 >= r107) goto L29;
            String r109 = r106[r108];
            if (r109.equals("-atrace") == false) goto L25;
            r100.shouldWriteToATrace = false;
        L28:
            r108 = r108 + 1;
            goto L20
        L25:
            if (r100.filter.length() <= 0) goto L27;
            r100.filter += ",";
        L27:
            r100.filter += r109;
        L29:
            r103 = r103 + 1;
            goto L10
        }

        private boolean pollConfig() {
            boolean r100 = this.mTraceTagActive.get();
            boolean r101 = isTraceTagEnabled(this.mTraceTag);
            if (r100 != r101) goto L5;
            return false;
        L5:
            this.mTraceTagActive.set(r101);
            if (r101 == true) goto L9;
            EarlyTraceEvent.disable();
            disableNativeATrace();
            this.mShouldWriteToSystemTrace = false;
            ThreadUtils.getUiThreadLooper().setMessageLogging(null);
            return true;
        L9:
            CategoryConfig r102 = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get() == false) goto L16;
            if (r102.shouldWriteToATrace == false) goto L14;
            enableNativeATrace(r102.filter);
        L20:
            if (r102.shouldWriteToATrace == true) goto L22;
            ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        L22:
            return true;
        L14:
            setupATraceStartupTrace(r102.filter);
            goto L20
        L16:
            if (r102.shouldWriteToATrace == false) goto L18;
            this.mShouldWriteToSystemTrace = true;
            goto L20
        L18:
            EarlyTraceEvent.enable();
            goto L20
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get() == false) goto L6;
            ThreadUtils.postOnUiThread(new k(this));
            return;
        }

        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (ThreadUtils.runningOnUiThread() == true) goto L6;
            ThreadUtils.postOnUiThread(new j(this));
            return;
        L6:
            startPolling();
        }

        public void traceEnd() {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag)});     // Catch: Exception -> L7
            return;
        }

        private void disableNativeATrace() {
            TraceEventJni.get().stopATrace();
        }

        private void startPolling() {
            ThreadUtils.assertOnUiThread();
            if (this.mIdleHandlerRegistered == true) goto L5;
            Looper.myQueue().addIdleHandler(this);
            this.mIdleHandlerRegistered = true;
        L5:
            pollConfig();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            pollConfig();
            return true;
        }

        static {
        }

        private /* synthetic */ void lambda$onNativeTracingReady$0() {
            pollConfig();
        }

        private /* synthetic */ void lambda$onUiThreadReady$1() {
            startPolling();
        }

        public ATrace(long r110) {
            this.mNativeTracingReady = new AtomicBoolean();
            this.mUiThreadReady = new AtomicBoolean();
            this.mTraceTagActive = new AtomicBoolean();
            Class<?> r100 = INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$ATrace_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Trace");     // Catch: Exception -> L5
            this.mTraceClass = r100;     // Catch: Exception -> L5
            Class<?> r101 = Long.TYPE;     // Catch: Exception -> L5
            this.mIsTraceTagEnabledMethod = r100.getMethod("isTagEnabled", new Class[]{r101});     // Catch: Exception -> L5
            this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", new Class[]{r101, String.class});     // Catch: Exception -> L5
            this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", new Class[]{r101});     // Catch: Exception -> L5
            Class<?> r102 = this.mTraceClass;     // Catch: Exception -> L5
            Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L5
            this.mAsyncTraceBeginMethod = r102.getMethod("asyncTraceBegin", new Class[]{r101, String.class, r103});     // Catch: Exception -> L5
            this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", new Class[]{r101, String.class, r103});     // Catch: Exception -> L5
            Class<?> r104 = INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$ATrace_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
            this.mSystemPropertiesClass = r104;     // Catch: Exception -> L5
            this.mGetSystemPropertyMethod = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L5
        L7:
            this.mTraceTag = r110;
            pollConfig();
            return;
        L5:
            e = move-exception;
            Log.w(TAG, "Reflection error", new Object[]{e});
            this.mIsTraceTagEnabledMethod = null;
            goto L7
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_ttnet_org_chromium_base_TraceEvent$ATrace_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        private void enableNativeATrace(String r100) {
            TraceEventJni.get().startATrace(r100);
        }

        private Integer getIntegerSystemProperty(String r100) {
            String r101 = getSystemProperty(r100);
            if (r101 != null) goto L8;
            return null;
        L8:
            return Integer.decode(r101);
        L7:
            return null;
        }

        private String getSystemProperty(String r100) {
            return (String) this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, new Object[]{r100});
        L4:
            return null;
        }

        private boolean isTraceTagEnabled(long r100) {
            return ((Boolean) this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(r100)})).booleanValue();
        L5:
            return false;
        }

        private void setupATraceStartupTrace(String r100) {
            TraceEventJni.get().setupATraceStartupTrace(r100);
        }

        public void traceBegin(String r100) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r100});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceBegin(String r100, int r101) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r100, Integer.valueOf(r101)});     // Catch: Exception -> L7
            return;
        }

        public void asyncTraceEnd(String r100, int r101) {
            if (this.mShouldWriteToSystemTrace == true) goto L8;
            return;
        L8:
            this.mAsyncTraceEndMethod.invoke(this.mTraceClass, new Object[]{Long.valueOf(this.mTraceTag), r100, Integer.valueOf(r101)});     // Catch: Exception -> L7
            return;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final String FILTERED_EVENT_NAME = "Looper.dispatch: EVENT_NAME_FILTERED";
        static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 0;
        private String mCurrentTarget;

        public BasicLooperMonitor() {
        }

        static {
            SHORTEST_LOG_PREFIX_LENGTH = 18;
        }

        private static String getTarget(String r100) {
            int r101 = r100.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (r101 != (-1)) goto L5;
            int r102 = -1;
        L6:
            if (r102 != (-1)) goto L10;
            return "";
        L10:
            return r100.substring(r101 + 1, r102);
        L5:
            r102 = r100.indexOf(41, r101);
            goto L6
        }

        private static String getTargetName(String r100) {
            int r101 = r100.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (r101 != (-1)) goto L5;
            int r102 = -1;
        L6:
            if (r102 != (-1)) goto L8;
            r102 = r100.length();
        L8:
            if (r101 != (-1)) goto L12;
            return "";
        L12:
            return r100.substring(r101 + 2, r102);
        L5:
            r102 = r100.indexOf(58, r101);
            goto L6
        }

        public static String getTraceEventName(String r100) {
            if (TraceEvent.access$300() == false) goto L7;
            return FILTERED_EVENT_NAME;
        L7:
            return LOOPER_TASK_PREFIX + getTarget(r100) + "(" + getTargetName(r100) + ")";
        }

        public void beginHandling(String r100) {
            boolean r101 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L5;
            if (r101 == true) goto L5;
            return;
        L5:
            this.mCurrentTarget = getTraceEventName(r100);
            if (TraceEvent.access$200() == false) goto L8;
            TraceEventJni.get().beginToplevel(this.mCurrentTarget);
            return;
        L8:
            EarlyTraceEvent.begin(this.mCurrentTarget, true);
        }

        public void endHandling(String r100) {
            boolean r101 = EarlyTraceEvent.enabled();
            if (TraceEvent.access$200() == true) goto L6;
            if (r101 == true) goto L6;
        L11:
            this.mCurrentTarget = null;
            return;
        L6:
            if (this.mCurrentTarget == null) goto L11;
            if (TraceEvent.access$200() == false) goto L10;
            TraceEventJni.get().endToplevel(this.mCurrentTarget);
            goto L11
        L10:
            EarlyTraceEvent.end(this.mCurrentTarget, true);
            goto L11
        }

        @Override // android.util.Printer
        public void println(String r100) {
            if (r100.startsWith(">") == false) goto L5;
            beginHandling(r100);
            return;
        L5:
            endHandling(r100);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent_LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private final void syncIdleMonitoring() {
            if (TraceEvent.access$200() == false) goto L8;
            if (this.mIdleMonitorAttached == true) goto L8;
            this.mLastIdleStartedAt = TimeUtils.elapsedRealtimeMillis();
            Looper.myQueue().addIdleHandler(this);
            this.mIdleMonitorAttached = true;
            return;
        L8:
            if (this.mIdleMonitorAttached == true) goto L10;
            return;
        L10:
            if (TraceEvent.access$200() == true) goto L15;
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            return;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r100 = TimeUtils.elapsedRealtimeMillis();
            if (this.mLastIdleStartedAt != 0) goto L5;
            this.mLastIdleStartedAt = r100;
        L5:
            long r101 = r100 - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (r101 <= MIN_INTERESTING_BURST_DURATION_MILLIS) goto L8;
            traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + r101 + "ms elapsed since last idle");
        L8:
            this.mLastIdleStartedAt = r100;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }

        private IdleTracingLooperMonitor() {
        }

        public /* synthetic */ IdleTracingLooperMonitor(AnonymousClass1 r100) {
            this();
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void beginHandling(String r100) {
            if (this.mNumTasksSinceLastIdle != 0) goto L5;
            TraceEvent.end(IDLE_EVENT_NAME);
        L5:
            this.mLastWorkStartedAt = TimeUtils.elapsedRealtimeMillis();
            syncIdleMonitoring();
            super.beginHandling(r100);
        }

        @Override // com.ttnet.org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String r100) {
            long r101 = TimeUtils.elapsedRealtimeMillis() - this.mLastWorkStartedAt;
            if (r101 <= 16) goto L5;
            traceAndLog(5, "observed a task that took " + r101 + "ms: " + r100);
        L5:
            super.endHandling(r100);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        private static void traceAndLog(int r100, String r101) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance = null;

        private LooperMonitorHolder() {
        }

        static {
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) == false) goto L5;
            BasicLooperMonitor r100 = new IdleTracingLooperMonitor(null);
        L6:
            sInstance = r100;
            return;
        L5:
            r100 = new BasicLooperMonitor();
            goto L6
        }

        public static /* synthetic */ BasicLooperMonitor access$000() {
            return sInstance;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface Natives {
        void addViewDump(int r100, int r101, boolean r102, boolean r103, String r104, String r105, long r106);

        void begin(String r100, String r101);

        void beginToplevel(String r100);

        void end(String r100, String r101);

        void endToplevel(String r100);

        void finishAsync(String r100, long r101);

        void initViewHierarchyDump();

        void instant(String r100, String r101);

        void instantAndroidIPC(String r100, long r101);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String r100);

        void startATrace(String r100);

        long startActivityDump(String r100, long r101);

        void startAsync(String r100, long r101);

        void stopATrace();

        boolean viewHierarchyDumpEnabled();
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class ViewHierarchyDumper implements MessageQueue.IdleHandler {
        private static final String EVENT_NAME = "TraceEvent.ViewHierarchyDumper";
        private static final long MIN_VIEW_DUMP_INTERVAL_MILLIS = 1000;
        private static boolean sEnabled;
        private static ViewHierarchyDumper sInstance;
        private long mLastDumpTs;

        private ViewHierarchyDumper() {
        }

        public static /* synthetic */ void a() {
            lambda$updateEnabledState$0();
        }

        private static void disable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == false) goto L6;
            Looper.myQueue().removeIdleHandler(sInstance);
            sEnabled = false;
            return;
        }

        private static void enable() {
            ThreadUtils.assertOnUiThread();
            if (sEnabled == true) goto L6;
            Looper.myQueue().addIdleHandler(sInstance);
            sEnabled = true;
            return;
        }

        public static void updateEnabledState() {
            if (ThreadUtils.runningOnUiThread() == true) goto L7;
            ThreadUtils.postOnUiThread(new l());
            return;
        L7:
            if (TraceEventJni.get().viewHierarchyDumpEnabled() == false) goto L13;
            if (sInstance != null) goto L11;
            sInstance = new ViewHierarchyDumper();
        L11:
            enable();
            return;
        L13:
            if (sInstance == null) goto L17;
            disable();
            return;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long r100 = TimeUtils.elapsedRealtimeMillis();
            long r101 = this.mLastDumpTs;
            if (r101 != 0) goto L5;
        L6:
            this.mLastDumpTs = r100;
            TraceEventJni.get().initViewHierarchyDump();
            return true;
        L5:
            if ((r100 - r101) > 1000) goto L6;
            return true;
        }

        private static /* synthetic */ void lambda$updateEnabledState$0() {
            updateEnabledState();
        }

        public static /* synthetic */ void access$500(int r100, View r101, long r102) {
            dumpView(r100, r101, r102);
        }

        private static void dumpView(int r110, View r111, long r112) {
            ThreadUtils.assertOnUiThread();
            int r100 = r111.getId();
        L10:
            String r101 = "__name_not_found__";
        L11:
            String r102 = r101;
            TraceEventJni.get().addViewDump(r100, r110, r111.isShown(), r111.isDirty(), r111.getClass().getSimpleName(), r102, r112);
            if ((r111 instanceof ViewGroup) == false) goto L17;
            ViewGroup r113 = (ViewGroup) r111;
            int r114 = 0;
        L15:
            if (r114 >= r113.getChildCount()) goto L21;
            dumpView(r100, r113.getChildAt(r114), r112);
            r114 = r114 + 1;
            goto L15
        L21:
            return;
        L17:
            return;
        L4:
            if (r111.getResources() == null) goto L8;
            if (r100 == 0) goto L7;
            r101 = r111.getResources().getResourceName(r100);     // Catch: Resources.NotFoundException -> L10
            goto L11
        L7:
            r101 = "__no_id__";
            goto L11
        L8:
            r101 = "__no_resources__";
            goto L11
        }
    }

    static {
        sNativeTracingReady = new AtomicBoolean();
        sUiThreadReady = new AtomicBoolean();
    }

    public static void onNativeTracingReady() {
        sNativeTracingReady.set(true);
        TraceEventJni.get().registerEnabledObserver();
        ATrace r100 = sATrace;
        if (r100 == null) goto L6;
        r100.onNativeTracingReady();
        return;
    }

    public static void onUiThreadReady() {
        sUiThreadReady.set(true);
        ATrace r100 = sATrace;
        if (r100 == null) goto L6;
        r100.onUiThreadReady();
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

    public static View INVOKEVIRTUAL_com_ttnet_org_chromium_base_TraceEvent_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void begin(String r100) {
        begin(r100, null);
    }

    public static void dumpViewHierarchy(long r100) {
        if (ApplicationStatus.isInitialized() == true) goto L5;
        return;
    L5:
        Iterator<Activity> r101 = ApplicationStatus.getRunningActivities().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Activity r102 = r101.next();
        long r103 = TraceEventJni.get().startActivityDump(r102.getClass().getName(), r100);
        ViewHierarchyDumper.access$500(0, INVOKEVIRTUAL_com_ttnet_org_chromium_base_TraceEvent_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102.getWindow()).getRootView(), r103);
        goto L7
    }

    public static void end(String r100) {
        end(r100, null);
    }

    public static void instant(String r100) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r100, null);
        return;
    }

    public static TraceEvent scoped(String r100) {
        return scoped(r100, null);
    }

    public static void setEnabled(boolean r100) {
        if (r100 == false) goto L5;
        EarlyTraceEvent.disable();
    L5:
        if (sEnabled == r100) goto L16;
        sEnabled = r100;
        ATrace r101 = sATrace;
        if (r101 != null) goto L9;
    L10:
        Looper r102 = ThreadUtils.getUiThreadLooper();
        if (r100 == false) goto L13;
        BasicLooperMonitor r103 = LooperMonitorHolder.access$000();
    L14:
        r102.setMessageLogging(r103);
        goto L16
    L13:
        r103 = null;
        goto L14
    L9:
        if (r101.hasActiveSession() == false) goto L10;
    L16:
        if (sUiThreadReady.get() == false) goto L19;
        ViewHierarchyDumper.updateEnabledState();
        return;
    }

    public static void setEventNameFilteringEnabled(boolean r100) {
        sEventNameFilteringEnabled = r100;
    }

    private TraceEvent(String r100, String r101) {
        this.mName = r100;
        begin(r100, r101);
    }

    public static void begin(String r100, String r101) {
        EarlyTraceEvent.begin(r100, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().begin(r100, r101);
        return;
    L5:
        ATrace r102 = sATrace;
        if (r102 == null) goto L10;
        r102.traceBegin(r100);
        return;
    }

    public static void end(String r100, String r101) {
        EarlyTraceEvent.end(r100, false);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().end(r100, r101);
        return;
    L5:
        ATrace r102 = sATrace;
        if (r102 == null) goto L10;
        r102.traceEnd();
        return;
    }

    public static void finishAsync(String r100, long r101) {
        EarlyTraceEvent.finishAsync(r100, r101);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().finishAsync(r100, r101);
        return;
    L5:
        ATrace r102 = sATrace;
        if (r102 == null) goto L10;
        r102.asyncTraceEnd(r100, (int) r101);
        return;
    }

    public static void instant(String r100, String r101) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instant(r100, r101);
        return;
    }

    public static void instantAndroidIPC(String r100, long r101) {
        if (sEnabled == false) goto L6;
        TraceEventJni.get().instantAndroidIPC(r100, r101);
        return;
    }

    public static void maybeEnableEarlyTracing(long r100, boolean r101) {
        if (r101 == false) goto L5;
        EarlyTraceEvent.maybeEnableInBrowserProcess();
    L5:
        if (r100 == 0) goto L13;
        sATrace = new ATrace(r100);
        if (sNativeTracingReady.get() == false) goto L10;
        sATrace.onNativeTracingReady();
    L10:
        if (sUiThreadReady.get() == false) goto L13;
        sATrace.onUiThreadReady();
    L13:
        if (EarlyTraceEvent.enabled() == false) goto L20;
        ATrace r102 = sATrace;
        if (r102 != null) goto L17;
    L18:
        ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.access$000());
        return;
    L17:
        if (r102.hasActiveSession() == false) goto L18;
        return;
    }

    public static TraceEvent scoped(String r100, String r101) {
        if (EarlyTraceEvent.enabled() == true) goto L9;
        if (enabled() == true) goto L9;
        return null;
    L9:
        return new TraceEvent(r100, r101);
    }

    public static void startAsync(String r100, long r101) {
        EarlyTraceEvent.startAsync(r100, r101);
        if (sEnabled == false) goto L5;
        TraceEventJni.get().startAsync(r100, r101);
        return;
    L5:
        ATrace r102 = sATrace;
        if (r102 == null) goto L10;
        r102.asyncTraceBegin(r100, (int) r101);
        return;
    }
}
