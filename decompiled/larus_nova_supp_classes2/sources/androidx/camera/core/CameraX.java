package androidx.camera.core;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraProviderExecutionState;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.QuirkSettingsLoader;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraX {
    private static final Object MIN_LOG_LEVEL_LOCK = null;
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private static final SparseArray<Integer> sMinLogLevelReferenceCountMap = null;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    final CameraRepository mCameraRepository;
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private final ListenableFuture<Void> mInitInternalFuture;
    private InternalInitState mInitState;
    private final Object mInitializeLock;
    private final Integer mMinLogLevel;
    private final RetryPolicy mRetryPolicy;
    private final Handler mSchedulerHandler;
    private final HandlerThread mSchedulerThread;
    private ListenableFuture<Void> mShutdownInternalFuture;
    private CameraDeviceSurfaceManager mSurfaceManager;

    public static final enum InternalInitState extends Enum<InternalInitState> {
        private static final /* synthetic */ InternalInitState[] $VALUES = null;
        public static final InternalInitState INITIALIZED = null;
        public static final InternalInitState INITIALIZING = null;
        public static final InternalInitState INITIALIZING_ERROR = null;
        public static final InternalInitState SHUTDOWN = null;
        public static final InternalInitState UNINITIALIZED = null;

        private static /* synthetic */ InternalInitState[] $values() {
            return new InternalInitState[]{UNINITIALIZED, INITIALIZING, INITIALIZING_ERROR, INITIALIZED, SHUTDOWN};
        }

        static {
            UNINITIALIZED = new InternalInitState("UNINITIALIZED", 0);
            INITIALIZING = new InternalInitState("INITIALIZING", 1);
            INITIALIZING_ERROR = new InternalInitState("INITIALIZING_ERROR", 2);
            INITIALIZED = new InternalInitState("INITIALIZED", 3);
            SHUTDOWN = new InternalInitState("SHUTDOWN", 4);
            $VALUES = $values();
        }

        public static InternalInitState[] values() {
            return (InternalInitState[]) $VALUES.clone();
        }

        public static InternalInitState valueOf(String r1) {
            return (InternalInitState) r27.a.a(InternalInitState.class, r1);
        }

        private InternalInitState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ Object a(CameraX r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$shutdownInternal$4(r1);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void b(CameraX r0, Context r1, Executor r2, int r3, CallbackToFutureAdapter.Completer r4, long r5) {
        r0.lambda$initAndRetryRecursively$2(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Object c(CameraX r0, Context r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$initInternal$0(r1, r2);
    }

    public static /* synthetic */ void d(CameraX r0, Executor r1, long r2, int r4, Context r5, CallbackToFutureAdapter.Completer r6) {
        r0.lambda$initAndRetryRecursively$1(r1, r2, r4, r5, r6);
    }

    public static /* synthetic */ void e(CameraX r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$shutdownInternal$3(r1);
    }

    static {
        MIN_LOG_LEVEL_LOCK = new Object();
        sMinLogLevelReferenceCountMap = new SparseArray();
    }

    private void setStateToInitialized() {
        Object r0 = this.mInitializeLock;
        monitor-enter(r0);
        this.mInitState = InternalInitState.INITIALIZED;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ListenableFuture<Void> shutdownInternal() {
        Object r0 = this.mInitializeLock;
        monitor-enter(r0);
        this.mSchedulerHandler.removeCallbacksAndMessages(RETRY_TOKEN);     // Catch: Throwable -> L22
        int r1 = this.mInitState.ordinal();     // Catch: Throwable -> L22
        if (r1 != 0) goto L7;
        this.mInitState = InternalInitState.SHUTDOWN;     // Catch: Throwable -> L22
        ListenableFuture<Void> r2 = Futures.immediateFuture(null);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r2;
    L7:
        if (r1 == 1) goto L18;
        if (r1 != 2) goto L11;
    L13:
        this.mInitState = InternalInitState.SHUTDOWN;     // Catch: Throwable -> L22
        decreaseMinLogLevelReference(this.mMinLogLevel);     // Catch: Throwable -> L22
        this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new e(this));     // Catch: Throwable -> L22
    L14:
        ListenableFuture<Void> r3 = this.mShutdownInternalFuture;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r3;
    L11:
        if (r1 == 3) goto L13;
    L18:
        throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static void updateOrResetMinLogLevel() {
        SparseArray<Integer> r0 = sMinLogLevelReferenceCountMap;
        if (r0.size() != 0) goto L7;
        Logger.resetMinLogLevel();
        return;
    L7:
        if (r0.get(3) == null) goto L10;
        Logger.setMinLogLevel(3);
        return;
    L10:
        if (r0.get(4) == null) goto L13;
        Logger.setMinLogLevel(4);
        return;
    L13:
        if (r0.get(5) == null) goto L16;
        Logger.setMinLogLevel(5);
        return;
    L16:
        if (r0.get(6) == null) goto L22;
        Logger.setMinLogLevel(6);
        return;
    }

    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager r0 = this.mSurfaceManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public CameraFactory getCameraFactory() {
        CameraFactory r0 = this.mCameraFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory r0 = this.mDefaultConfigFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public boolean isInitialized() {
        Object r0 = this.mInitializeLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitState != InternalInitState.INITIALIZED) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public ListenableFuture<Void> shutdown() {
        return shutdownInternal();
    }

    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    public ListenableFuture<Void> getInitializeFuture() {
        return this.mInitInternalFuture;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_camera_core_CameraX_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static void decreaseMinLogLevelReference(Integer r3) {
        Object r0 = MIN_LOG_LEVEL_LOCK;
        monitor-enter(r0);
        if (r3 != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        SparseArray<Integer> r1 = sMinLogLevelReferenceCountMap;     // Catch: Throwable -> L14
        int r2 = r1.get(r3.intValue()).intValue() - 1;     // Catch: Throwable -> L14
        if (r2 != 0) goto L10;
        r1.remove(r3.intValue());     // Catch: Throwable -> L14
    L11:
        updateOrResetMinLogLevel();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L10:
        r1.put(r3.intValue(), Integer.valueOf(r2));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static CameraXConfig.Provider getConfigProvider(Context r5) {
        ComponentCallbacks2 r1 = ContextUtil.getApplicationFromContext(r5);
        if ((r1 instanceof CameraXConfig.Provider) == false) goto L30;
        return (CameraXConfig.Provider) r1;
    L30:
        Context r6 = ContextUtil.getApplicationContext(r5);     // Catch: NullPointerException -> L15 Throwable -> L17 NoSuchMethodException -> L19 InvocationTargetException -> L21 InstantiationException -> L23 ClassNotFoundException -> L25 PackageManager.NameNotFoundException -> L27
        Bundle r7 = r6.getPackageManager().getServiceInfo(new ComponentName(r6, MetadataHolderService.class), 640).metaData;     // Catch: NullPointerException -> L15 Throwable -> L17 NoSuchMethodException -> L19 InvocationTargetException -> L21 InstantiationException -> L23 ClassNotFoundException -> L25 PackageManager.NameNotFoundException -> L27
        if (r7 == null) goto L9;
        String r8 = r7.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER");     // Catch: NullPointerException -> L15 Throwable -> L17 NoSuchMethodException -> L19 InvocationTargetException -> L21 InstantiationException -> L23 ClassNotFoundException -> L25 PackageManager.NameNotFoundException -> L27
    L10:
        if (r8 != null) goto L32;
        Logger.e(TAG, "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");     // Catch: NullPointerException -> L15 Throwable -> L17 NoSuchMethodException -> L19 InvocationTargetException -> L21 InstantiationException -> L23 ClassNotFoundException -> L25 PackageManager.NameNotFoundException -> L27
        return null;
    L32:
        return (CameraXConfig.Provider) INVOKESTATIC_androidx_camera_core_CameraX_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r8).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L9:
        r8 = null;
    L17:
        e = move-exception;
        Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
        return null;
    }

    private static void increaseMinLogLevelReference(Integer r5) {
        Object r0 = MIN_LOG_LEVEL_LOCK;
        monitor-enter(r0);
        if (r5 != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        Preconditions.checkArgumentInRange(r5.intValue(), 3, 6, "minLogLevel");     // Catch: Throwable -> L13
        SparseArray<Integer> r1 = sMinLogLevelReferenceCountMap;     // Catch: Throwable -> L13
        int r3 = 1;
        if (r1.get(r5.intValue()) == null) goto L10;
        r3 = 1 + r1.get(r5.intValue()).intValue();     // Catch: Throwable -> L13
    L10:
        r1.put(r5.intValue(), Integer.valueOf(r3));     // Catch: Throwable -> L13
        updateOrResetMinLogLevel();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private ListenableFuture<Void> initInternal(final Context r4) {
        Object r0 = this.mInitializeLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitState != InternalInitState.UNINITIALIZED) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, "CameraX.initInternal() should only be called once per instance");     // Catch: Throwable -> L11
        this.mInitState = InternalInitState.INITIALIZING;     // Catch: Throwable -> L11
        ListenableFuture<Void> r5 = CallbackToFutureAdapter.getFuture(new h(this, r4));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L7:
        r1 = false;
        goto L8
    }

    private /* synthetic */ void lambda$shutdownInternal$3(CallbackToFutureAdapter.Completer r3) {
        if (this.mSchedulerThread == null) goto L8;
        Executor r0 = this.mCameraExecutor;
        if ((r0 instanceof CameraExecutor) == false) goto L7;
        ((CameraExecutor) r0).deinit();
    L7:
        this.mSchedulerThread.quit();
    L8:
        r3.set(null);
    }

    private /* synthetic */ Object lambda$shutdownInternal$4(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mCameraRepository.deinit().addListener(new g(this, r3), this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    private void traceExecutionState(RetryPolicy.ExecutionState r2) {
        if (Trace.isEnabled() == false) goto L9;
        if (r2 == null) goto L6;
        int r3 = r2.getStatus();
    L7:
        Trace.setCounter("CX:CameraProvider-RetryStatus", r3);
        return;
    L6:
        r3 = -1;
        goto L7
    }

    public CameraX(Context r2, CameraXConfig.Provider r3) {
        this(r2, r3, new QuirkSettingsLoader());
    }

    private /* synthetic */ Object lambda$initInternal$0(Context r8, CallbackToFutureAdapter.Completer r9) throws Exception {
        initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), 1, r8, r9);
        return "CameraX initInternal";
    }

    public CameraX(Context r3, CameraXConfig.Provider r4, Function<Context, QuirkSettings> r5) {
        this.mCameraRepository = new CameraRepository();
        this.mInitializeLock = new Object();
        this.mInitState = InternalInitState.UNINITIALIZED;
        this.mShutdownInternalFuture = Futures.immediateFuture(null);
        if (r4 == null) goto L5;
        this.mCameraXConfig = r4.getCameraXConfig();
    L8:
        updateQuirkSettings(r3, this.mCameraXConfig.getQuirkSettings(), r5);
        Executor r6 = this.mCameraXConfig.getCameraExecutor(null);
        Handler r7 = this.mCameraXConfig.getSchedulerHandler(null);
        if (r6 != null) goto L11;
        r6 = new CameraExecutor();
    L11:
        this.mCameraExecutor = r6;
        if (r7 != null) goto L14;
        PthreadHandlerThreadV2 r8 = new PthreadHandlerThreadV2("CameraX-scheduler", 10);
        this.mSchedulerThread = r8;
        ThreadMethodProxy.start(r8);
        this.mSchedulerHandler = HandlerCompat.createAsync(r8.getLooper());
    L15:
        CameraXConfig r9 = this.mCameraXConfig;
        Config.Option<Integer> r10 = CameraXConfig.OPTION_MIN_LOGGING_LEVEL;
        r9.getClass();
        Integer r11 = (Integer) ReadableConfig.CC.$default$retrieveOption(r9, r10, null);
        this.mMinLogLevel = r11;
        increaseMinLogLevelReference(r11);
        this.mRetryPolicy = new RetryPolicy.Builder(this.mCameraXConfig.getCameraProviderInitRetryPolicy()).build();
        this.mInitInternalFuture = initInternal(r3);
        return;
    L14:
        this.mSchedulerThread = null;
        this.mSchedulerHandler = r7;
        goto L15
    L5:
        CameraXConfig.Provider r12 = getConfigProvider(r3);
        if (r12 == null) goto L18;
        this.mCameraXConfig = r12.getCameraXConfig();
        goto L8
    L18:
        throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
    }

    private static void updateQuirkSettings(Context r1, QuirkSettings r2, Function<Context, QuirkSettings> r3) {
        if (r2 == null) goto L5;
        Logger.d(TAG, "QuirkSettings from CameraXConfig: " + r2);
    L6:
        if (r2 != null) goto L8;
        r2 = QuirkSettingsHolder.DEFAULT;
        Logger.d(TAG, "QuirkSettings by default: " + r2);
    L8:
        QuirkSettingsHolder.instance().set(r2);
        return;
    L5:
        r2 = r3.apply(r1);
        Logger.d(TAG, "QuirkSettings from app metadata: " + r2);
        goto L6
    }

    private void initAndRetryRecursively(final Executor r10, final long r11, final int r13, final Context r14, final CallbackToFutureAdapter.Completer<Void> r15) {
        r10.execute(new d(this, r14, r10, r13, r15, r11));
    }

    private /* synthetic */ void lambda$initAndRetryRecursively$1(Executor r8, long r9, int r11, Context r12, CallbackToFutureAdapter.Completer r13) {
        initAndRetryRecursively(r8, r9, r11 + 1, r12, r13);
    }

    private /* synthetic */ void lambda$initAndRetryRecursively$2(Context r19, final Executor r20, final int r21, final CallbackToFutureAdapter.Completer r22, final long r23) {
        String r1 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: ";
        Trace.beginSection("CX:initAndRetryRecursively");
        final Context r7 = ContextUtil.getApplicationContext(r19);
        CameraFactory.Provider r10 = this.mCameraXConfig.getCameraFactoryProvider(null);     // Catch: Throwable -> L30 Throwable -> L32 InitializationException -> L34 CameraValidator.CameraIdListIncorrectException -> L36
        if (r10 == null) goto L23;
        CameraThreadConfig r12 = CameraThreadConfig.create(this.mCameraExecutor, this.mSchedulerHandler);     // Catch: Throwable -> L30 Throwable -> L32 InitializationException -> L34 CameraValidator.CameraIdListIncorrectException -> L36
        CameraSelector r0 = this.mCameraXConfig.getAvailableCamerasLimiter(null);     // Catch: Throwable -> L30 Throwable -> L32 InitializationException -> L34 CameraValidator.CameraIdListIncorrectException -> L36
        this.mCameraFactory = r10.newInstance(r7, r12, r0, this.mCameraXConfig.getCameraOpenRetryMaxTimeoutInMillisWhileResuming());     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        CameraDeviceSurfaceManager.Provider r11 = this.mCameraXConfig.getDeviceSurfaceManagerProvider(null);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        if (r11 == null) goto L21;
        this.mSurfaceManager = r11.newInstance(r7, this.mCameraFactory.getCameraManager(), this.mCameraFactory.getAvailableCameraIds());     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        UseCaseConfigFactory.Provider r13 = this.mCameraXConfig.getUseCaseConfigFactoryProvider(null);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        if (r13 == null) goto L19;
        this.mDefaultConfigFactory = r13.newInstance(r7);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        if ((r20 instanceof CameraExecutor) == false) goto L14;
        ((CameraExecutor) r20).init(this.mCameraFactory);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
    L14:
        this.mCameraRepository.init(this.mCameraFactory);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        CameraValidator.validateCameras(r7, this.mCameraRepository, r0);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        if (r21 <= 1) goto L17;
        traceExecutionState(null);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
    L17:
        setStateToInitialized();     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
        r22.set(null);     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
    L57:
        Trace.endSection();
        return;
    L19:
        throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
    L21:
        throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
    L23:
        throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));     // Catch: RuntimeException -> L24 InitializationException -> L26 CameraValidator.CameraIdListIncorrectException -> L28 Throwable -> L30
    L26:
        e = e;
    L38:
        CameraProviderExecutionState r14 = new CameraProviderExecutionState(r23, r21, e);     // Catch: Throwable -> L30
        RetryPolicy.RetryConfig r15 = this.mRetryPolicy.onRetryDecisionRequested(r14);     // Catch: Throwable -> L30
        traceExecutionState(r14);     // Catch: Throwable -> L30
        if (r15.shouldRetry() == true) goto L41;
    L43:
        Object r2 = this.mInitializeLock;     // Catch: Throwable -> L30
        monitor-enter(r2);     // Catch: Throwable -> L30
        this.mInitState = InternalInitState.INITIALIZING_ERROR;     // Catch: Throwable -> L59
        monitor-exit(r2);     // Catch: Throwable -> L59
    L48:
        if (r15.shouldCompleteWithoutFailure() == false) goto L51;
        setStateToInitialized();     // Catch: Throwable -> L30
        r22.set(r1);     // Catch: Throwable -> L30
        goto L57
    L51:
        if ((e instanceof CameraValidator.CameraIdListIncorrectException) == false) goto L54;
        String r3 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).getAvailableCameraCount();     // Catch: Throwable -> L30
        Logger.e(TAG, r3, e);     // Catch: Throwable -> L30
        r22.setException(new InitializationException(new CameraUnavailableException(3, r3)));     // Catch: Throwable -> L30
        goto L57
    L54:
        if ((e instanceof InitializationException) == false) goto L56;
        r22.setException(e);     // Catch: Throwable -> L30
        goto L57
    L56:
        r22.setException(new InitializationException(e));     // Catch: Throwable -> L30
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L41:
        if (r21 >= Integer.MAX_VALUE) goto L43;
        Logger.w(TAG, "Retry init. Start time " + r23 + " current time " + SystemClock.elapsedRealtime(), e);     // Catch: Throwable -> L30
        HandlerCompat.postDelayed(this.mSchedulerHandler, new f(this, r20, r23, r21, r7, r22), RETRY_TOKEN, r15.getRetryDelayInMillis());     // Catch: Throwable -> L30
    L28:
        e = e;
    L24:
        e = e;
    L30:
        th = move-exception;
        Trace.endSection();
        throw th;
    L32:
        e = e;
        r1 = null;
        goto L38
    }
}
