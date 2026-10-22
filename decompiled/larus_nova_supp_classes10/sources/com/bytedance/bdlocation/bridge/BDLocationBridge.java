package com.bytedance.bdlocation.bridge;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BDLocationBridge {
    private static final ExecutorService LOCATION_CALLBACK_DISPATCHER = null;
    private static final int MAX_PENDING_LOCATION_CALLBACKS = 10;
    private static final ExecutorService PLATFORM_DELEGATE_DISPATCHER = null;
    private static final ExecutorService RUNTIME_STATE_CALLBACK_DISPATCHER = null;

    public static final class CallbackGate {
        private static final ThreadLocal<CallbackGate> CURRENT_GATE = null;
        private boolean accepting;
        private int callbacksInFlight;
        private boolean cancelPending;
        private boolean deliveryScheduled;
        private final Deque<CallbackTask> pending;

        public static /* synthetic */ void a(CallbackGate r0, ExecutorService r1) {
            r0.lambda$deliveryFinished$2(r1);
        }

        public static /* synthetic */ void b(CallbackGate r0, CallbackTask r1, ExecutorService r2) {
            r0.lambda$scheduleNext$1(r1, r2);
        }

        public static /* synthetic */ void c(CallbackGate r0, ExecutorService r1) {
            r0.lambda$enqueue$0(r1);
        }

        public void closeAndWait() {
            monitor-enter(this);
            boolean r0 = false;
            this.accepting = false;     // Catch: Throwable -> L31
            ThreadLocal<CallbackGate> r1 = CURRENT_GATE;     // Catch: Throwable -> L31
            if (r1.get() != this) goto L7;
        L12:
            boolean r2 = true;
        L13:
            if (r2 == false) goto L18;
            this.cancelPending = true;     // Catch: Throwable -> L31
            this.pending.clear();     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L18:
            if (this.callbacksInFlight <= 0) goto L20;
        L34:
            wait();     // Catch: InterruptedException -> L30 Throwable -> L31
        L30:
            r0 = true;
            goto L18
        L20:
            if (this.deliveryScheduled == true) goto L34;
            if (this.pending.isEmpty() == false) goto L34;
            if (r0 == false) goto L26;
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L31
        L26:
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L7:
            if (r1.get() != null) goto L9;
        L11:
            r2 = false;
            goto L13
        L9:
            if (this.callbacksInFlight != 0) goto L11;
        L31:
            th = move-exception;
            throw th;
        }

        static {
            CURRENT_GATE = new ThreadLocal();
        }

        private CallbackGate() {
            this.pending = new ArrayDeque();
            this.accepting = true;
        }

        public /* synthetic */ CallbackGate(AnonymousClass1 r1) {
            this();
        }

        private void deliveryFinished(final ExecutorService r3) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.cancelPending == false) goto L8;
            this.pending.clear();     // Catch: Throwable -> L15
            this.deliveryScheduled = false;     // Catch: Throwable -> L15
            notifyAll();     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L8:
            boolean r0 = !this.pending.isEmpty();     // Catch: Throwable -> L15
            if (r0 == true) goto L11;
            this.deliveryScheduled = false;     // Catch: Throwable -> L15
            notifyAll();     // Catch: Throwable -> L15
        L11:
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r0 == false) goto L19;
            r3.execute(new i(this, r3));
            return;
        }

        private /* synthetic */ void lambda$deliveryFinished$2(ExecutorService r1) {
            scheduleNext(r1);
        }

        private /* synthetic */ void lambda$enqueue$0(ExecutorService r1) {
            scheduleNext(r1);
        }

        private void scheduleNext(final ExecutorService r3) {
            monitor-enter(this);
        L22:
            th = move-exception;
            throw th;
        L4:
            if (this.cancelPending == false) goto L8;
            this.pending.clear();     // Catch: Throwable -> L22
            this.deliveryScheduled = false;     // Catch: Throwable -> L22
            notifyAll();     // Catch: Throwable -> L22
            monitor-exit(this);     // Catch: Throwable -> L22
            return;
        L8:
            final CallbackTask r0 = this.pending.pollFirst();     // Catch: Throwable -> L22
            if (r0 != null) goto L13;
            this.deliveryScheduled = false;     // Catch: Throwable -> L22
            notifyAll();     // Catch: Throwable -> L22
            monitor-exit(this);     // Catch: Throwable -> L22
            return;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L22
            Runnable r1 = new h(this, r0, r3);
            Executor r2 = r0.callbackExecutor();     // Catch: Throwable -> L20
            if (r2 != null) goto L18;
            r1.run();     // Catch: Throwable -> L20
        L25:
            return;
        L18:
            r2.execute(r1);     // Catch: Throwable -> L20
        L20:
            deliveryFinished(r3);
        }

        private void deliver(CallbackTask r3, ExecutorService r4) {
            monitor-enter(this);
        L28:
            th = move-exception;
            throw th;
        L4:
            if (this.cancelPending == false) goto L8;
            deliveryFinished(r4);     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
            return;
        L8:
            this.callbacksInFlight++;     // Catch: Throwable -> L28
            ThreadLocal<CallbackGate> r0 = CURRENT_GATE;     // Catch: Throwable -> L28
            CallbackGate r1 = r0.get();     // Catch: Throwable -> L28
            r0.set(this);     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
            r3.run();     // Catch: Throwable -> L19
            r0.set(r1);
            monitor-enter(this);
            this.callbacksInFlight--;     // Catch: Throwable -> L16
            notifyAll();     // Catch: Throwable -> L16
            monitor-exit(this);     // Catch: Throwable -> L16
        L15:
            deliveryFinished(r4);
            return;
        L16:
            th = move-exception;
            throw th;
        L19:
            CURRENT_GATE.set(r1);
            monitor-enter(this);
            this.callbacksInFlight--;     // Catch: Throwable -> L25
            notifyAll();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$scheduleNext$1(CallbackTask r1, ExecutorService r2) {
            deliver(r1, r2);
        }

        public void enqueue(CallbackTask r2, final ExecutorService r3, int r4) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (this.accepting == true) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L18
            return;
        L8:
            if (this.pending.size() < r4) goto L10;
            this.pending.removeFirst();     // Catch: Throwable -> L18
            goto L8
        L10:
            this.pending.addLast(r2);     // Catch: Throwable -> L18
            if (this.deliveryScheduled == true) goto L13;
            boolean r5 = true;
            this.deliveryScheduled = true;     // Catch: Throwable -> L18
        L14:
            monitor-exit(this);     // Catch: Throwable -> L18
            if (r5 == false) goto L23;
            r3.execute(new g(this, r3));
            return;
        L23:
            return;
        L13:
            r5 = false;
            goto L14
        }
    }

    public interface CallbackTask {
        Executor callbackExecutor();

        void run();
    }

    public static final class DispatchingNetworkRequestHandle implements PlatformNetworkRequestHandle {
        private final NativeNetworkCallback callback;
        private boolean cancelled;
        private PlatformNetworkRequestHandle delegateHandle;
        private final String requestId;

        @Override // com.bytedance.bdlocation.bridge.PlatformNetworkRequestHandle
        public void cancel() {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.cancelled == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L7:
            this.cancelled = true;     // Catch: Throwable -> L15
            PlatformNetworkRequestHandle r1 = this.delegateHandle;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r1 == null) goto L11;
            BDLocationBridge.access$100().execute(new j(r1));
        L11:
            NativeNetworkCallback r2 = this.callback;
            if (r2 == null) goto L19;
            r2.onComplete(PlatformNetworkResponse.failure(this.requestId, 1, "platform network request cancelled"));
            return;
        }

        @Override // com.bytedance.bdlocation.bridge.PlatformNetworkRequestHandle
        public synchronized boolean isCancelled() {
            monitor-enter(this);
            boolean r0 = this.cancelled;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public void attach(PlatformNetworkRequestHandle r3) {
            monitor-enter(this);
            this.delegateHandle = r3;     // Catch: Throwable -> L9
            boolean r0 = this.cancelled;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            if (r0 == false) goto L14;
            if (r3 == null) goto L15;
            BDLocationBridge.access$100().execute(new j(r3));
            return;
        L15:
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public DispatchingNetworkRequestHandle(String r1, NativeNetworkCallback r2) {
            this.requestId = r1;
            this.callback = r2;
        }

        public void fail(int r3, String r4) {
            NativeNetworkCallback r0 = this.callback;
            if (r0 == null) goto L6;
            r0.onComplete(PlatformNetworkResponse.failure(this.requestId, r3, r4));
            return;
        }
    }

    public static final class TerminalUploadCallback implements NativeNetworkCallback {
        private final NativeNetworkCallback delegate;
        private final NativeNetworkProgressCallback progress;

        @Override // com.bytedance.bdlocation.bridge.NativeNetworkCallback
        public void onComplete(PlatformNetworkResponse r3) {
            NativeNetworkCallback r0 = this.delegate;     // Catch: Throwable -> L9
            if (r0 == null) goto L5;
            r0.onComplete(r3);     // Catch: Throwable -> L9
        L5:
            NativeNetworkProgressCallback r4 = this.progress;
            if ((r4 instanceof NativeNetworkProgressCallbackProxy) == false) goto L16;
            ((NativeNetworkProgressCallbackProxy) r4).close();
            return;
        L16:
            return;
        L9:
            th = move-exception;
            NativeNetworkProgressCallback r1 = this.progress;
            if ((r1 instanceof NativeNetworkProgressCallbackProxy) == false) goto L13;
            ((NativeNetworkProgressCallbackProxy) r1).close();
        L13:
            throw th;
        }

        public TerminalUploadCallback(NativeNetworkCallback r1, NativeNetworkProgressCallback r2) {
            this.delegate = r1;
            this.progress = r2;
        }
    }

    private BDLocationBridge() {
    }

    public static /* synthetic */ void a(PlatformTrackerDelegate r0, TrackerDataEvent r1, TrackerTrackOptions r2) {
        lambda$dispatchTrackData$3(r0, r1, r2);
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static native long addLocationListener(String r0, LocationListener r1);

    public static native long addRuntimeStateListener(String r0, PlatformRuntimeStateListener r1);

    public static /* synthetic */ void b(DispatchingNetworkRequestHandle r0, PlatformNetworkDelegate r1, PlatformNetworkUploadRequest r2, NativeNetworkCallback r3, NativeNetworkProgressCallback r4) {
        lambda$dispatchUpload$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void c(DispatchingNetworkRequestHandle r0, PlatformNetworkDelegate r1, PlatformNetworkRequest r2, NativeNetworkCallback r3) {
        lambda$dispatchNetwork$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void d(Executor r0, Runnable r1) {
        lambda$dispatchPlatform$5(r0, r1);
    }

    public static /* synthetic */ void e(PlatformLoggerDelegate r0, LogRecord r1) {
        lambda$dispatchLog$4(r0, r1);
    }

    public static /* synthetic */ void f(PlatformTrackerDelegate r0, TrackerServiceEvent r1, TrackerTrackOptions r2) {
        lambda$dispatchTrackService$2(r0, r1, r2);
    }

    public static native long getBDLocationInstance(String r0, PlatformTrackerDelegate r1, PlatformLoggerDelegate r2);

    public static native boolean pushSensorBatch(String r0, SensorBatch r1);

    public static native boolean removeLocationListener(String r0, long r1);

    public static native boolean runTestCommand(String r0, String r1, String r2);

    public static native boolean setLocationConfig(String r0, LocationConfig r1);

    public static native boolean startLocation(String r0, String r1);

    public static native boolean stopLocation(String r0, String r1);

    public static native boolean updateOutputInterval(String r0, int r1, int r2);

    static {
        LOCATION_CALLBACK_DISPATCHER = PThreadExecutorsUtils.newSingleThreadExecutor(new AnonymousClass1());
        RUNTIME_STATE_CALLBACK_DISPATCHER = PThreadExecutorsUtils.newSingleThreadExecutor(new AnonymousClass2());
        PLATFORM_DELEGATE_DISPATCHER = PThreadExecutorsUtils.newSingleThreadExecutor(new AnonymousClass3());
        INVOKESTATIC_com_bytedance_bdlocation_bridge_BDLocationBridge_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bdlocation_bridge");
    }

    public static Object createCallbackGate() {
        return new CallbackGate(null);
    }

    public static /* synthetic */ ExecutorService access$100() {
        return PLATFORM_DELEGATE_DISPATCHER;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bdlocation_bridge_BDLocationBridge_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static void closeCallbackGate(Object r1) {
        if ((r1 instanceof CallbackGate) == false) goto L6;
        ((CallbackGate) r1).closeAndWait();
        return;
    }

    private static String throwableMessage(Throwable r2) {
        String r0 = "";
        if (r2 != null) goto L5;
        return "";
    L5:
        String r1 = r2.getMessage();
        if (r1 == null) goto L10;
        r0 = r1;
    L10:
        return r2.getClass().getName() + ": " + r0;
    }

    private static LogRecord toLogRecord(PlatformLogRecord r17) {
        if (r17 == null) goto L5;
        LinkedHashMap r13 = new LinkedHashMap();
        PlatformLogField[] r1 = r17.fields;
        if (r1 == null) goto L15;
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        PlatformLogField r4 = r1[r3];
        if (r4 == null) goto L13;
        r13.put(r4.key, r4.value);
    L13:
        r3 = r3 + 1;
    L15:
        return new LogRecord(r17.level, r17.tag, r17.message, r13, r17.sourceFile, r17.sourceFunction, r17.sourceLine);
    L5:
        return new LogRecord(1, "", "", null, "", "", 0);
    }

    private static Map<String, TrackerMetricValue> toMetricMap(PlatformTrackerField[] r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        PlatformTrackerField r3 = r5[r2];
        TrackerMetricValue r4 = toMetricValue(r3);
        if (r3 == null) goto L11;
        if (r4 == null) goto L11;
        r0.put(r3.key, r4);
    L11:
        r2 = r2 + 1;
        goto L6
    L12:
        return r0;
    }

    private static TrackerMetricValue toMetricValue(PlatformTrackerField r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = r3.kind;
        if (r1 == 1) goto L8;
        if (r1 == 0) goto L11;
        return null;
    L11:
        return new TrackerIntMetricValue(r3.intValue);
    L8:
        return new TrackerDoubleMetricValue(r3.doubleValue);
    }

    private static TrackerDataEvent toTrackerDataEvent(PlatformTrackerDataEvent r3) {
        if (r3 != null) goto L6;
        return new TrackerDataEvent("", null, "");
    L6:
        return new TrackerDataEvent(r3.logType, toValueMap(r3.data), r3.purpose);
    }

    private static TrackerServiceEvent toTrackerServiceEvent(PlatformTrackerServiceEvent r12) {
        if (r12 != null) goto L6;
        return new TrackerServiceEvent("", null, null, null, "");
    L6:
        return new TrackerServiceEvent(r12.serviceName, toMetricMap(r12.metric), toValueMap(r12.category), toValueMap(r12.extra), r12.purpose);
    }

    private static TrackerTrackOptions toTrackerTrackOptions(PlatformTrackerTrackOptions r2) {
        if (r2 != null) goto L6;
        return new TrackerTrackOptions(0, false);
    L6:
        return new TrackerTrackOptions(r2.uploadMode, r2.bypassLocalGate);
    }

    private static TrackerValue toValue(PlatformTrackerField r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = r3.kind;
        if (r1 == 0) goto L21;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        return null;
    L15:
        return new TrackerStringValue(r3.stringValue);
    L17:
        return new TrackerBoolValue(r3.boolValue);
    L19:
        return new TrackerDoubleValue(r3.doubleValue);
    L21:
        return new TrackerIntValue(r3.intValue);
    }

    private static Map<String, TrackerValue> toValueMap(PlatformTrackerField[] r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        PlatformTrackerField r3 = r5[r2];
        TrackerValue r4 = toValue(r3);
        if (r3 == null) goto L11;
        if (r4 == null) goto L11;
        r0.put(r3.key, r4);
    L11:
        r2 = r2 + 1;
        goto L6
    L12:
        return r0;
    }

    private static void dispatch(Executor r0, Runnable r1) {
        if (r0 != null) goto L5;
        r1.run();
        return;
    L5:
        r0.execute(r1);
    }

    public static void dispatchLog(final PlatformLoggerDelegate r2, PlatformLogRecord r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        final LogRecord r4 = toLogRecord(r3);
        dispatchPlatform(r2.callbackExecutor(), new a(r2, r4));     // Catch: Throwable -> L7
        return;
    }

    private static void dispatchPlatform(final Executor r2, final Runnable r3) {
        PLATFORM_DELEGATE_DISPATCHER.execute(new e(r2, r3));
    }

    private static /* synthetic */ void lambda$dispatchLog$4(PlatformLoggerDelegate r0, LogRecord r1) {
        r0.log(r1);
    }

    private static /* synthetic */ void lambda$dispatchPlatform$5(Executor r0, Runnable r1) {
        dispatch(r0, r1);
    }

    public static void dispatchLocation(Object r1, final LocationListener r2, final LocationOutput r3) {
        if ((r1 instanceof CallbackGate) == true) goto L5;
        return;
    L5:
        ((CallbackGate) r1).enqueue(new AnonymousClass4(r2, r3), LOCATION_CALLBACK_DISPATCHER, 10);
    }

    public static PlatformNetworkRequestHandle dispatchNetwork(final PlatformNetworkDelegate r2, final PlatformNetworkRequest r3, final NativeNetworkCallback r4) {
        if (r3 != null) goto L5;
        String r1 = "";
    L6:
        final DispatchingNetworkRequestHandle r0 = new DispatchingNetworkRequestHandle(r1, r4);
        if (r2 != null) goto L10;
        r0.fail(10, "platform network delegate is null");
        return r0;
    L10:
        Runnable r5 = new c(r0, r2, r3, r4);
        dispatchPlatform(r2.callbackExecutor(), r5);     // Catch: Throwable -> L13
    L15:
        return r0;
    L13:
        th = move-exception;
        r0.fail(12, throwableMessage(th));
        goto L15
    L5:
        r1 = r3.requestId;
        goto L6
    }

    public static void dispatchTrackData(final PlatformTrackerDelegate r2, PlatformTrackerDataEvent r3, PlatformTrackerTrackOptions r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        final TrackerDataEvent r5 = toTrackerDataEvent(r3);
        final TrackerTrackOptions r6 = toTrackerTrackOptions(r4);
        dispatchPlatform(r2.callbackExecutor(), new b(r2, r5, r6));     // Catch: Throwable -> L7
        return;
    }

    public static void dispatchTrackService(final PlatformTrackerDelegate r2, PlatformTrackerServiceEvent r3, PlatformTrackerTrackOptions r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        final TrackerServiceEvent r5 = toTrackerServiceEvent(r3);
        final TrackerTrackOptions r6 = toTrackerTrackOptions(r4);
        dispatchPlatform(r2.callbackExecutor(), new d(r2, r5, r6));     // Catch: Throwable -> L7
        return;
    }

    private static /* synthetic */ void lambda$dispatchTrackData$3(PlatformTrackerDelegate r0, TrackerDataEvent r1, TrackerTrackOptions r2) {
        r0.trackData(r1, r2);
    }

    private static /* synthetic */ void lambda$dispatchTrackService$2(PlatformTrackerDelegate r0, TrackerServiceEvent r1, TrackerTrackOptions r2) {
        r0.trackService(r1, r2);
    }

    public static void dispatchRuntimeState(Object r1, final PlatformRuntimeStateListener r2, final int r3, final String r4) {
        if ((r1 instanceof CallbackGate) == true) goto L5;
        return;
    L5:
        ((CallbackGate) r1).enqueue(new AnonymousClass5(r2, r3, r4), RUNTIME_STATE_CALLBACK_DISPATCHER, 10);
    }

    public static PlatformNetworkRequestHandle dispatchUpload(final PlatformNetworkDelegate r7, final PlatformNetworkUploadRequest r8, NativeNetworkCallback r9, final NativeNetworkProgressCallback r10) {
        if (r8 != null) goto L4;
        PlatformNetworkRequest r0 = null;
    L5:
        final TerminalUploadCallback r5 = new TerminalUploadCallback(r9, r10);
        if (r0 != null) goto L8;
        String r1 = "";
    L9:
        final DispatchingNetworkRequestHandle r11 = new DispatchingNetworkRequestHandle(r1, r5);
        if (r7 != null) goto L13;
        r11.fail(10, "platform network delegate is null");
        return r11;
    L13:
        Runnable r2 = new f(r11, r7, r8, r5, r10);
        dispatchPlatform(r7.callbackExecutor(), r2);     // Catch: Throwable -> L16
    L18:
        return r11;
    L16:
        th = move-exception;
        r11.fail(12, throwableMessage(th));
        goto L18
    L8:
        r1 = r0.requestId;
        goto L9
    L4:
        r0 = r8.request;
        goto L5
    }

    private static /* synthetic */ void lambda$dispatchNetwork$0(DispatchingNetworkRequestHandle r2, PlatformNetworkDelegate r3, PlatformNetworkRequest r4, NativeNetworkCallback r5) {
        if (r2.isCancelled() == false) goto L17;
        return;
    L17:
    L14:
        th = move-exception;
        r2.fail(12, throwableMessage(th));
        return;
    L7:
        if (r3.canSend(r4) == true) goto L10;
        r2.fail(6, "platform network delegate rejected the request");     // Catch: Throwable -> L14
        return;
    L10:
        PlatformNetworkRequestHandle r6 = r3.send(r4, r5);     // Catch: Throwable -> L14
        r2.attach(r6);     // Catch: Throwable -> L14
        if (r6 != null) goto L18;
        r2.fail(12, "platform network delegate returned null handle");     // Catch: Throwable -> L14
        return;
    }

    private static /* synthetic */ void lambda$dispatchUpload$1(DispatchingNetworkRequestHandle r2, PlatformNetworkDelegate r3, PlatformNetworkUploadRequest r4, NativeNetworkCallback r5, NativeNetworkProgressCallback r6) {
        if (r2.isCancelled() == false) goto L17;
        return;
    L17:
    L14:
        th = move-exception;
        r2.fail(12, throwableMessage(th));
        return;
    L7:
        if (r3.canUpload(r4) == true) goto L10;
        r2.fail(6, "platform network delegate rejected the upload request");     // Catch: Throwable -> L14
        return;
    L10:
        PlatformNetworkRequestHandle r7 = r3.upload(r4, r5, r6);     // Catch: Throwable -> L14
        r2.attach(r7);     // Catch: Throwable -> L14
        if (r7 != null) goto L18;
        r2.fail(12, "platform upload delegate returned null handle");     // Catch: Throwable -> L14
        return;
    }
}
