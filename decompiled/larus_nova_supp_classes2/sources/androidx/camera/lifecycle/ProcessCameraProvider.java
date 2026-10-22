package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jk\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u0001042\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u00042\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0001¢\u0006\u0004\b:\u0010;J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0007J5\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010?J\u0018\u0010)\u001a\u00020@2\u000e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0004H\u0007J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010<\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020.H\u0017J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010M\u001a\u00020$H\u0002J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010<\u001a\u00020.H\u0016J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010M\u001a\u00020$H\u0002J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0007J%\u0010W\u001a\u00020D2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0017¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020DH\u0017R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR$\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "()V", "cameraInfos", "", "Landroidx/camera/core/CameraInfo;", "activeConcurrentCameraInfos", "getActiveConcurrentCameraInfos", "()Ljava/util/List;", "setActiveConcurrentCameraInfos", "(Ljava/util/List;)V", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "cameraOperatingMode", "", "getCameraOperatingMode", "()I", "setCameraOperatingMode", "(I)V", "isConcurrentCameraModeOn", "", "()Z", "mCameraInfoMap", "", "Landroidx/camera/core/internal/CameraUseCaseAdapter$CameraId;", "Landroidx/camera/core/impl/RestrictedCameraInfo;", "mCameraX", "Landroidx/camera/core/CameraX;", "mCameraXConfigProvider", "Landroidx/camera/core/CameraXConfig$Provider;", "mCameraXInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "mCameraXShutdownFuture", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mLifecycleCameraRepository", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", "mLock", "", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "primaryCameraSelector", "Landroidx/camera/core/CameraSelector;", "secondaryCameraSelector", "primaryLayoutSettings", "Landroidx/camera/core/LayoutSettings;", "secondaryLayoutSettings", "viewPort", "Landroidx/camera/core/ViewPort;", "effects", "Landroidx/camera/core/CameraEffect;", "useCases", "", "Landroidx/camera/core/UseCase;", "bindToLifecycle$camera_lifecycle_release", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/ViewPort;Ljava/util/List;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "cameraSelector", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "configureInstanceInternal", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getAvailableCameraInfos", "getCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "cameraInfo", "getCameraInfo", "getOrCreateCameraXInstance", "context", "hasCamera", "isBound", "useCase", "isPreview", "isVideoCapture", "setCameraX", "cameraX", "setContext", "shutdownAsync", "unbind", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    public static final Companion Companion = null;
    private static final ProcessCameraProvider sAppInstance = null;
    private final Map<CameraUseCaseAdapter.CameraId, RestrictedCameraInfo> mCameraInfoMap;
    private CameraX mCameraX;
    private CameraXConfig.Provider mCameraXConfigProvider;
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    private ListenableFuture<Void> mCameraXShutdownFuture;
    private Context mContext;
    private final LifecycleCameraRepository mLifecycleCameraRepository;
    private final Object mLock;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider$Companion;", "", "()V", "sAppInstance", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "configureInstance", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getInstance", "Lcom/google/common/util/concurrent/ListenableFuture;", "context", "Landroid/content/Context;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ ProcessCameraProvider a(Function1 r0, Object r1) {
            return getInstance$lambda$0(r0, r1);
        }

        @JvmStatic
        public final void configureInstance(CameraXConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "cameraXConfig");
            Trace.beginSection("CX:configureInstance");
            ProcessCameraProvider.access$configureInstanceInternal(ProcessCameraProvider.access$getSAppInstance$cp(), r2);     // Catch: Throwable -> L6
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L6
            Trace.endSection();
            return;
        L6:
            th = move-exception;
            Trace.endSection();
            throw th;
        }

        @JvmStatic
        public final ListenableFuture<ProcessCameraProvider> getInstance(final Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Preconditions.checkNotNull(r3);
            ListenableFuture r0 = ProcessCameraProvider.access$getOrCreateCameraXInstance(ProcessCameraProvider.access$getSAppInstance$cp(), r3);
            final Function1<CameraX, ProcessCameraProvider> r1 = new ProcessCameraProvider$Companion$getInstance$1(r3);
            return Futures.transform(r0, new d(r1), CameraXExecutors.directExecutor());
        }

        private static final ProcessCameraProvider getInstance$lambda$0(Function1 r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "$tmp0");
            return (ProcessCameraProvider) r1.invoke(r2);
        }
    }

    public static /* synthetic */ Object a(ProcessCameraProvider r0, CameraX r1, CallbackToFutureAdapter.Completer r2) {
        return getOrCreateCameraXInstance$lambda$18$lambda$17(r0, r1, r2);
    }

    public static /* synthetic */ ListenableFuture b(Function1 r0, Object r1) {
        return getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(r0, r1);
    }

    public static /* synthetic */ void c(ProcessCameraProvider r0) {
        shutdownAsync$lambda$0(r0);
    }

    @JvmStatic
    public static final void configureInstance(CameraXConfig r1) {
        Companion.configureInstance(r1);
    }

    @JvmStatic
    public static final ListenableFuture<ProcessCameraProvider> getInstance(Context r1) {
        return Companion.getInstance(r1);
    }

    static {
        Companion = new Companion(null);
        sAppInstance = new ProcessCameraProvider();
    }

    private final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX r0 = this.mCameraX;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
    L5:
        return new ArrayList();
    }

    private final int getCameraOperatingMode() {
        CameraX r0 = this.mCameraX;
        if (r0 != null) goto L6;
        return 0;
    L6:
        Intrinsics.checkNotNull(r0);
        return r0.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L10
        CameraX r1 = access$getMCameraX$p(this);     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L10
        Iterator<CameraInternal> r2 = r1.getCameraRepository().getCameras().iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L8;
        r0.add(r2.next().getCameraInfo());     // Catch: Throwable -> L10
        goto L5
    L8:
        Trace.endSection();
        return r0;
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public final List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        Objects.requireNonNull(access$getMCameraX$p(this));     // Catch: Throwable -> L16
        CameraX r0 = access$getMCameraX$p(this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L16
        Objects.requireNonNull(r0.getCameraFactory().getCameraCoordinator());     // Catch: Throwable -> L16
        CameraX r1 = access$getMCameraX$p(this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L16
        List<List<CameraSelector>> r2 = r1.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();     // Catch: Throwable -> L16
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<List<CameraSelector>> r4 = r2.iterator();     // Catch: Throwable -> L16
    L4:
        if (r4.hasNext() == false) goto L14;
        List<CameraSelector> r5 = r4.next();     // Catch: Throwable -> L16
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<CameraSelector> r7 = r5.iterator();     // Catch: Throwable -> L16
    L8:
        if (r7.hasNext() == false) goto L12;
        r6.add(getCameraInfo(r7.next()));     // Catch: Throwable -> L16
        goto L8
    L12:
        r3.add(r6);     // Catch: Throwable -> L16
        goto L4
    L14:
        Trace.endSection();
        return r3;
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public final ListenableFuture<Void> shutdownAsync() {
        Threads.runOnMainSync(new b(this));
        CameraX r0 = this.mCameraX;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.getCameraFactory().getCameraCoordinator().shutdown();
    L5:
        CameraX r1 = this.mCameraX;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        ListenableFuture<Void> r2 = r1.shutdown();
    L9:
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mCameraXConfigProvider = null;     // Catch: Throwable -> L15
        this.mCameraXInitializeFuture = null;     // Catch: Throwable -> L15
        this.mCameraXShutdownFuture = r2;     // Catch: Throwable -> L15
        this.mCameraInfoMap.clear();     // Catch: Throwable -> L15
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r3);
        this.mCameraX = null;
        this.mContext = null;
        return r2;
    L15:
        th = move-exception;
        throw th;
    L8:
        r2 = Futures.immediateFuture(null);
        goto L9
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        Threads.checkMainThread();     // Catch: Throwable -> L6
        access$setCameraOperatingMode(this, 0);     // Catch: Throwable -> L6
        access$getMLifecycleCameraRepository$p(this).unbindAll();     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        Trace.endSection();
        return;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    private ProcessCameraProvider() {
        this.mLock = new Object();
        this.mCameraXShutdownFuture = Futures.immediateFuture(null);
        this.mLifecycleCameraRepository = new LifecycleCameraRepository();
        this.mCameraInfoMap = new HashMap();
    }

    public final boolean isConcurrentCameraModeOn() {
        if (getCameraOperatingMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ ProcessCameraProvider access$getSAppInstance$cp() {
        return sAppInstance;
    }

    public static final /* synthetic */ List access$getActiveConcurrentCameraInfos(ProcessCameraProvider r0) {
        return r0.getActiveConcurrentCameraInfos();
    }

    public static final /* synthetic */ int access$getCameraOperatingMode(ProcessCameraProvider r0) {
        return r0.getCameraOperatingMode();
    }

    public static final /* synthetic */ Map access$getMCameraInfoMap$p(ProcessCameraProvider r0) {
        return r0.mCameraInfoMap;
    }

    public static final /* synthetic */ CameraX access$getMCameraX$p(ProcessCameraProvider r0) {
        return r0.mCameraX;
    }

    public static final /* synthetic */ CameraXConfig.Provider access$getMCameraXConfigProvider$p(ProcessCameraProvider r0) {
        return r0.mCameraXConfigProvider;
    }

    public static final /* synthetic */ Context access$getMContext$p(ProcessCameraProvider r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ LifecycleCameraRepository access$getMLifecycleCameraRepository$p(ProcessCameraProvider r0) {
        return r0.mLifecycleCameraRepository;
    }

    public static final /* synthetic */ Object access$getMLock$p(ProcessCameraProvider r0) {
        return r0.mLock;
    }

    private final void configureInstanceInternal(final CameraXConfig r4) {
        Trace.beginSection("CX:configureInstanceInternal");
        Object r0 = access$getMLock$p(this);     // Catch: Throwable -> L16
        monitor-enter(r0);     // Catch: Throwable -> L16
        Preconditions.checkNotNull(r4);     // Catch: Throwable -> L13
        if (access$getMCameraXConfigProvider$p(this) != null) goto L8;
        boolean r1 = true;
    L9:
        Preconditions.checkState(r1, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");     // Catch: Throwable -> L13
        access$setMCameraXConfigProvider$p(this, new ProcessCameraProvider$configureInstanceInternal$1$1$1(r4));     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L16
        Trace.endSection();
        return;
    L8:
        r1 = false;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    private final ListenableFuture<CameraX> getOrCreateCameraXInstance(Context r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ListenableFuture<CameraX> r1 = this.mCameraXInitializeFuture;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r1;
    L9:
        final CameraX r2 = new CameraX(r4, this.mCameraXConfigProvider);     // Catch: Throwable -> L12
        ListenableFuture<CameraX> r5 = CallbackToFutureAdapter.getFuture(new c(this, r2));     // Catch: Throwable -> L12
        this.mCameraXInitializeFuture = r5;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    private final boolean isPreview(UseCase r1) {
        return r1 instanceof Preview;
    }

    private final boolean isVideoCapture(UseCase r3) {
        if (r3.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.getCurrentConfig().getCaptureType() != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) goto L7;
        return true;
    }

    private final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> r2) {
        CameraX r0 = this.mCameraX;
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(r2);
    }

    private final void setCameraOperatingMode(int r2) {
        CameraX r0 = this.mCameraX;
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(r2);
    }

    private final void setCameraX(CameraX r1) {
        this.mCameraX = r1;
    }

    private final void setContext(Context r1) {
        this.mContext = r1;
    }

    private static final void shutdownAsync$lambda$0(ProcessCameraProvider r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.unbindAll();
        r1.mLifecycleCameraRepository.clear();
    }

    public final ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> r14) {
        Intrinsics.checkNotNullParameter(r14, "singleCameraConfigs");
        Trace.beginSection("CX:bindToLifecycle-Concurrent");
    L80:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (r14.size() < 2) goto L79;
        if (r14.size() > 2) goto L77;
        ConcurrentCamera.SingleCameraConfig r1 = r14.get(0);     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L80
        ConcurrentCamera.SingleCameraConfig r2 = r1;     // Catch: Throwable -> L80
        boolean r3 = true;
        ConcurrentCamera.SingleCameraConfig r4 = r14.get(1);     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L80
        ConcurrentCamera.SingleCameraConfig r5 = r4;     // Catch: Throwable -> L80
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L80
        if (Intrinsics.areEqual(r2.getCameraSelector().getLensFacing(), r5.getCameraSelector().getLensFacing()) == true) goto L11;
        Context r6 = access$getMContext$p(this);     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L80
        if (r6.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent") == false) goto L75;
        if (access$getCameraOperatingMode(this) == 1) goto L73;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L80
        CameraInfo r7 = getCameraInfo(r2.getCameraSelector());     // Catch: IllegalArgumentException -> L70 Throwable -> L80
        CameraInfo r8 = getCameraInfo(r5.getCameraSelector());     // Catch: IllegalArgumentException -> L70 Throwable -> L80
        r12.add(r7);     // Catch: Throwable -> L80
        r12.add(r8);     // Catch: Throwable -> L80
        if ((!access$getActiveConcurrentCameraInfos(this).isEmpty()) == true) goto L42;
    L46:
        access$setCameraOperatingMode(this, 2);     // Catch: Throwable -> L80
        if (Objects.equals(r2.getUseCaseGroup().getUseCases(), r5.getUseCaseGroup().getUseCases()) == true) goto L49;
    L59:
        r3 = false;
    L60:
        if (r3 == false) goto L62;
        LifecycleOwner r9 = r2.getLifecycleOwner();     // Catch: Throwable -> L80
        CameraSelector r10 = r2.getCameraSelector();     // Catch: Throwable -> L80
        CameraSelector r0 = r5.getCameraSelector();     // Catch: Throwable -> L80
        LayoutSettings r13 = r2.getLayoutSettings();     // Catch: Throwable -> L80
        LayoutSettings r15 = r5.getLayoutSettings();     // Catch: Throwable -> L80
        ViewPort r16 = r2.getUseCaseGroup().getViewPort();     // Catch: Throwable -> L80
        List<CameraEffect> r17 = r2.getUseCaseGroup().getEffects();     // Catch: Throwable -> L80
        UseCase[] r18 = (UseCase[]) r2.getUseCaseGroup().getUseCases().toArray(new UseCase[0]);     // Catch: Throwable -> L80
        r11.add(bindToLifecycle$camera_lifecycle_release(r9, r10, r0, r13, r15, r16, r17, (UseCase[]) Arrays.copyOf(r18, r18.length)));     // Catch: Throwable -> L80
    L66:
        access$setActiveConcurrentCameraInfos(this, r12);     // Catch: Throwable -> L80
    L67:
        ConcurrentCamera r19 = new ConcurrentCamera(r11);     // Catch: Throwable -> L80
        Trace.endSection();
        return r19;
    L62:
        Iterator<ConcurrentCamera.SingleCameraConfig> r20 = r14.iterator();     // Catch: Throwable -> L80
    L64:
        if (r20.hasNext() == false) goto L66;
        ConcurrentCamera.SingleCameraConfig r21 = r20.next();     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L80
        LifecycleOwner r22 = r21.getLifecycleOwner();     // Catch: Throwable -> L80
        CameraSelector r23 = r21.getCameraSelector();     // Catch: Throwable -> L80
        LayoutSettings r24 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L80
        ViewPort r25 = r21.getUseCaseGroup().getViewPort();     // Catch: Throwable -> L80
        List<CameraEffect> r26 = r21.getUseCaseGroup().getEffects();     // Catch: Throwable -> L80
        UseCase[] r27 = (UseCase[]) r21.getUseCaseGroup().getUseCases().toArray(new UseCase[0]);     // Catch: Throwable -> L80
        r11.add(bindToLifecycle$camera_lifecycle_release(r22, r23, null, r24, r24, r25, r26, (UseCase[]) Arrays.copyOf(r27, r27.length)));     // Catch: Throwable -> L80
        goto L64
    L49:
        if (r2.getUseCaseGroup().getUseCases().size() != 2) goto L59;
        UseCase r28 = r2.getUseCaseGroup().getUseCases().get(0);     // Catch: Throwable -> L80
        UseCase r29 = r2.getUseCaseGroup().getUseCases().get(1);     // Catch: Throwable -> L80
        if (access$isVideoCapture(this, r28) == false) goto L55;
        if (access$isPreview(this, r29) == true) goto L60;
    L55:
        if (access$isPreview(this, r28) == false) goto L59;
        if (access$isVideoCapture(this, r29) == false) goto L59;
    L42:
        if (Intrinsics.areEqual(r12, access$getActiveConcurrentCameraInfos(this)) == true) goto L46;
        throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras.");     // Catch: Throwable -> L80
    L71:
        throw new IllegalArgumentException("Invalid camera selectors in camera configs.");     // Catch: Throwable -> L80
    L73:
        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");     // Catch: Throwable -> L80
    L75:
        throw new UnsupportedOperationException("Concurrent camera is not supported on the device.");     // Catch: Throwable -> L80
    L11:
        if (access$getCameraOperatingMode(this) == 2) goto L32;
        if (Intrinsics.areEqual(r2.getLifecycleOwner(), r5.getLifecycleOwner()) == false) goto L30;
        if (Intrinsics.areEqual(r2.getUseCaseGroup().getViewPort(), r5.getUseCaseGroup().getViewPort()) == false) goto L30;
        if (Intrinsics.areEqual(r2.getUseCaseGroup().getEffects(), r5.getUseCaseGroup().getEffects()) == false) goto L30;
        LifecycleOwner r30 = r2.getLifecycleOwner();     // Catch: Throwable -> L80
        CameraSelector r31 = r2.getCameraSelector();     // Catch: Throwable -> L80
        ViewPort r32 = r2.getUseCaseGroup().getViewPort();     // Catch: Throwable -> L80
        List<CameraEffect> r33 = r2.getUseCaseGroup().getEffects();     // Catch: Throwable -> L80
        ArrayList r34 = new ArrayList();     // Catch: Throwable -> L80
        Iterator<ConcurrentCamera.SingleCameraConfig> r35 = r14.iterator();     // Catch: Throwable -> L80
    L20:
        if (r35.hasNext() == false) goto L28;
        ConcurrentCamera.SingleCameraConfig r36 = r35.next();     // Catch: Throwable -> L80
        Intrinsics.checkNotNull(r36);     // Catch: Throwable -> L80
        Iterator<UseCase> r37 = r36.getUseCaseGroup().getUseCases().iterator();     // Catch: Throwable -> L80
    L23:
        if (r37.hasNext() == false) goto L27;
        UseCase r38 = r37.next();     // Catch: Throwable -> L80
        String r110 = r36.getCameraSelector().getPhysicalCameraId();     // Catch: Throwable -> L80
        if (r110 == null) goto L23;
        r38.setPhysicalCameraId(r110);     // Catch: Throwable -> L80
        goto L23
    L27:
        r34.addAll(r36.getUseCaseGroup().getUseCases());     // Catch: Throwable -> L80
        goto L20
    L28:
        access$setCameraOperatingMode(this, 1);     // Catch: Throwable -> L80
        LayoutSettings r39 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L80
        UseCase[] r40 = (UseCase[]) r34.toArray(new UseCase[0]);     // Catch: Throwable -> L80
        r11.add(bindToLifecycle$camera_lifecycle_release(r30, r31, null, r39, r39, r32, r33, (UseCase[]) Arrays.copyOf(r40, r40.length)));     // Catch: Throwable -> L80
    L30:
        throw new IllegalArgumentException("Two camera configs need to have the same lifecycle owner, view port and effects.");     // Catch: Throwable -> L80
    L32:
        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");     // Catch: Throwable -> L80
    L77:
        throw new IllegalArgumentException("Concurrent camera is only supporting two cameras at maximum.");     // Catch: Throwable -> L80
    L79:
        throw new IllegalArgumentException("Concurrent camera needs two camera configs.");     // Catch: Throwable -> L80
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector r5) {
        Intrinsics.checkNotNullParameter(r5, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        CameraX r0 = access$getMCameraX$p(this);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L16
        CameraInfoInternal r1 = r5.select(r0.getCameraRepository().getCameras()).getCameraInfoInternal();     // Catch: Throwable -> L16
        CameraConfig r6 = access$getCameraConfig(this, r5, r1);     // Catch: Throwable -> L16
        CameraUseCaseAdapter.CameraId r2 = CameraUseCaseAdapter.CameraId.create(r1.getCameraId(), r6.getCompatibilityId());     // Catch: Throwable -> L16
        Object r3 = access$getMLock$p(this);     // Catch: Throwable -> L16
        monitor-enter(r3);     // Catch: Throwable -> L16
        Object r4 = access$getMCameraInfoMap$p(this).get(r2);     // Catch: Throwable -> L13
        if (r4 != null) goto L8;
        r4 = new RestrictedCameraInfo(r1, r6);     // Catch: Throwable -> L13
        access$getMCameraInfoMap$p(this).put(r2, r4);     // Catch: Throwable -> L13
    L8:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L16
        RestrictedCameraInfo r8 = (RestrictedCameraInfo) r4;     // Catch: Throwable -> L16
        Trace.endSection();
        return r8;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector r2) throws CameraInfoUnavailableException {
        Intrinsics.checkNotNullParameter(r2, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        CameraX r0 = access$getMCameraX$p(this);     // Catch: Throwable -> L5 IllegalArgumentException -> L8
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L5 IllegalArgumentException -> L8
        r2.select(r0.getCameraRepository().getCameras());     // Catch: Throwable -> L5 IllegalArgumentException -> L8
        boolean r3 = true;
    L9:
        Trace.endSection();
        return r3;
    L8:
        r3 = false;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(UseCase r3) {
        Intrinsics.checkNotNullParameter(r3, "useCase");
        Iterator<LifecycleCamera> r0 = this.mLifecycleCameraRepository.getLifecycleCameras().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().isBound(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(UseCase... r3) {
        Intrinsics.checkNotNullParameter(r3, "useCases");
        Trace.beginSection("CX:unbind");
        Threads.checkMainThread();     // Catch: Throwable -> L10
        if (access$getCameraOperatingMode(this) == 2) goto L9;
        access$getMLifecycleCameraRepository$p(this).unbind(CollectionsKt.listOf(Arrays.copyOf(r3, r3.length)));     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        Trace.endSection();
        return;
    L9:
        throw new UnsupportedOperationException("Unbind usecase is not supported in concurrent camera mode, call unbindAll() first.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static final /* synthetic */ void access$configureInstanceInternal(ProcessCameraProvider r0, CameraXConfig r1) {
        r0.configureInstanceInternal(r1);
    }

    public static final /* synthetic */ ListenableFuture access$getOrCreateCameraXInstance(ProcessCameraProvider r0, Context r1) {
        return r0.getOrCreateCameraXInstance(r1);
    }

    public static final /* synthetic */ boolean access$isPreview(ProcessCameraProvider r0, UseCase r1) {
        return r0.isPreview(r1);
    }

    public static final /* synthetic */ boolean access$isVideoCapture(ProcessCameraProvider r0, UseCase r1) {
        return r0.isVideoCapture(r1);
    }

    public static final /* synthetic */ void access$setActiveConcurrentCameraInfos(ProcessCameraProvider r0, List r1) {
        r0.setActiveConcurrentCameraInfos(r1);
    }

    public static final /* synthetic */ void access$setCameraOperatingMode(ProcessCameraProvider r0, int r1) {
        r0.setCameraOperatingMode(r1);
    }

    public static final /* synthetic */ void access$setCameraX(ProcessCameraProvider r0, CameraX r1) {
        r0.setCameraX(r1);
    }

    public static final /* synthetic */ void access$setContext(ProcessCameraProvider r0, Context r1) {
        r0.setContext(r1);
    }

    public static final /* synthetic */ void access$setMCameraXConfigProvider$p(ProcessCameraProvider r0, CameraXConfig.Provider r1) {
        r0.mCameraXConfigProvider = r1;
    }

    private final CameraConfig getCameraConfig(CameraSelector r5, CameraInfo r6) {
        Iterator<CameraFilter> r7 = r5.getCameraFilterSet().iterator();
        CameraConfig r0 = null;
    L4:
        if (r7.hasNext() == false) goto L14;
        CameraFilter r1 = r7.next();
        if (Intrinsics.areEqual(r1.getIdentifier(), CameraFilter.DEFAULT_ID) == true) goto L4;
        CameraConfigProvider r2 = ExtendedCameraConfigProviderStore.getConfigProvider(r1.getIdentifier());
        Context r3 = this.mContext;
        Intrinsics.checkNotNull(r3);
        CameraConfig r4 = r2.getConfig(r6, r3);
        if (r4 == null) goto L4;
        if (r0 != null) goto L13;
        r0 = r4;
        goto L4
    L13:
        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
    L14:
        if (r0 == null) goto L16;
        return r0;
    L16:
        return CameraConfigs.defaultConfig();
    }

    private static final ListenableFuture getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        return (ListenableFuture) r1.invoke(r2);
    }

    public static final /* synthetic */ CameraConfig access$getCameraConfig(ProcessCameraProvider r0, CameraSelector r1, CameraInfo r2) {
        return r0.getCameraConfig(r1, r2);
    }

    private static final Object getOrCreateCameraXInstance$lambda$18$lambda$17(ProcessCameraProvider r3, final CameraX r4, final CallbackToFutureAdapter.Completer r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$cameraX");
        Intrinsics.checkNotNullParameter(r5, "completer");
        Object r0 = r3.mLock;
        monitor-enter(r0);
        FutureChain r6 = FutureChain.from(r3.mCameraXShutdownFuture);     // Catch: Throwable -> L8
        final Function1<Void, ListenableFuture<Void>> r1 = new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1(r4);     // Catch: Throwable -> L8
        Futures.addCallback(r6.transformAsync(new a(r1), CameraXExecutors.directExecutor()), new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1(r5, r4), CameraXExecutors.directExecutor());     // Catch: Throwable -> L8
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return "ProcessCameraProvider-initializeCameraX";
    L8:
        th = move-exception;
        throw th;
    }

    public final Camera bindToLifecycle(LifecycleOwner r11, CameraSelector r12, UseCaseGroup r13) {
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "cameraSelector");
        Intrinsics.checkNotNullParameter(r13, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (access$getCameraOperatingMode(this) == 2) goto L9;
        access$setCameraOperatingMode(this, 1);     // Catch: Throwable -> L10
        LayoutSettings r6 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L10
        ViewPort r7 = r13.getViewPort();     // Catch: Throwable -> L10
        List<CameraEffect> r8 = r13.getEffects();     // Catch: Throwable -> L10
        UseCase[] r14 = (UseCase[]) r13.getUseCases().toArray(new UseCase[0]);     // Catch: Throwable -> L10
        Camera r15 = bindToLifecycle$camera_lifecycle_release(r11, r12, null, r6, r6, r7, r8, (UseCase[]) Arrays.copyOf(r14, r14.length));     // Catch: Throwable -> L10
        Trace.endSection();
        return r15;
    L9:
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");     // Catch: Throwable -> L10
    }

    public final Camera bindToLifecycle(LifecycleOwner r11, CameraSelector r12, UseCase... r13) {
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "cameraSelector");
        Intrinsics.checkNotNullParameter(r13, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
    L10:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (access$getCameraOperatingMode(this) == 2) goto L9;
        access$setCameraOperatingMode(this, 1);     // Catch: Throwable -> L10
        LayoutSettings r6 = LayoutSettings.DEFAULT;     // Catch: Throwable -> L10
        Camera r14 = bindToLifecycle$camera_lifecycle_release(r11, r12, null, r6, r6, null, CollectionsKt.emptyList(), (UseCase[]) Arrays.copyOf(r13, r13.length));     // Catch: Throwable -> L10
        Trace.endSection();
        return r14;
    L9:
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");     // Catch: Throwable -> L10
    }

    public final Camera bindToLifecycle$camera_lifecycle_release(LifecycleOwner r19, CameraSelector r20, CameraSelector r21, LayoutSettings r22, LayoutSettings r23, ViewPort r24, List<? extends CameraEffect> r25, UseCase... r26) {
        Intrinsics.checkNotNullParameter(r19, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r20, "primaryCameraSelector");
        Intrinsics.checkNotNullParameter(r22, "primaryLayoutSettings");
        Intrinsics.checkNotNullParameter(r23, "secondaryLayoutSettings");
        Intrinsics.checkNotNullParameter(r25, "effects");
        Intrinsics.checkNotNullParameter(r26, "useCases");
        Trace.beginSection("CX:bindToLifecycle-internal");
        Threads.checkMainThread();     // Catch: Throwable -> L33
        CameraX r6 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L33
        CameraInternal r8 = r20.select(r6.getCameraRepository().getCameras());     // Catch: Throwable -> L33
        boolean r7 = true;
        r8.setPrimary(true);     // Catch: Throwable -> L33
        CameraInfo r2 = getCameraInfo(r20);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");     // Catch: Throwable -> L33
        RestrictedCameraInfo r10 = (RestrictedCameraInfo) r2;     // Catch: Throwable -> L33
        if (r21 == null) goto L6;
        CameraX r9 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L33
        CameraInternal r11 = r21.select(r9.getCameraRepository().getCameras());     // Catch: Throwable -> L33
        r11.setPrimary(false);     // Catch: Throwable -> L33
        CameraInfo r3 = getCameraInfo(r21);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");     // Catch: Throwable -> L33
        RestrictedCameraInfo r12 = (RestrictedCameraInfo) r3;     // Catch: Throwable -> L33
        CameraInternal r13 = r11;
    L7:
        LifecycleCamera r4 = access$getMLifecycleCameraRepository$p(this).getLifecycleCamera(r19, CameraUseCaseAdapter.generateCameraId(r10, r12));     // Catch: Throwable -> L33
        Collection<LifecycleCamera> r5 = access$getMLifecycleCameraRepository$p(this).getLifecycleCameras();     // Catch: Throwable -> L33
        Iterator r14 = ArraysKt.filterNotNull(r26).iterator();     // Catch: Throwable -> L33
    L9:
        if (r14.hasNext() == false) goto L22;
        UseCase r15 = (UseCase) r14.next();     // Catch: Throwable -> L33
        Iterator<LifecycleCamera> r16 = r5.iterator();     // Catch: Throwable -> L33
    L12:
        if (r16.hasNext() == false) goto L9;
        LifecycleCamera r17 = r16.next();     // Catch: Throwable -> L33
        if (r17.isBound(r15) == false) goto L12;
        if (Intrinsics.areEqual(r17, r4) == true) goto L12;
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L33
        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{r15}, 1)));     // Catch: Throwable -> L33
    L22:
        if (r4 != null) goto L25;
        LifecycleCameraRepository r27 = access$getMLifecycleCameraRepository$p(this);     // Catch: Throwable -> L33
        CameraX r28 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L33
        CameraCoordinator r110 = r28.getCameraFactory().getCameraCoordinator();     // Catch: Throwable -> L33
        CameraX r29 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r29);     // Catch: Throwable -> L33
        CameraDeviceSurfaceManager r30 = r29.getCameraDeviceSurfaceManager();     // Catch: Throwable -> L33
        CameraX r31 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r31);     // Catch: Throwable -> L33
        r4 = r27.createLifecycleCamera(r19, new CameraUseCaseAdapter(r8, r13, r10, r12, r22, r23, r110, r30, r31.getDefaultConfigFactory()));     // Catch: Throwable -> L33
    L25:
        if (r26.length == 0) goto L28;
        r7 = false;
    L28:
        if (r7 == false) goto L30;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L33
    L31:
        Trace.endSection();
        return r4;
    L30:
        LifecycleCameraRepository r32 = access$getMLifecycleCameraRepository$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L33
        List r111 = CollectionsKt.listOf(Arrays.copyOf(r26, r26.length));     // Catch: Throwable -> L33
        CameraX r0 = access$getMCameraX$p(this);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L33
        r32.bindToLifecycleCamera(r4, r24, r25, r111, r0.getCameraFactory().getCameraCoordinator());     // Catch: Throwable -> L33
        goto L31
    L6:
        r13 = null;
        r12 = null;
    L33:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
