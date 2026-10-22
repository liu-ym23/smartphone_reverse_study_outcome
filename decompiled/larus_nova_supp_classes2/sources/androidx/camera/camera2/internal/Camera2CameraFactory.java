package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.concurrent.Camera2CameraCoordinator;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2CameraFactory implements CameraFactory {
    private static final int DEFAULT_ALLOWED_CONCURRENT_OPEN_CAMERAS = 1;
    private static final String TAG = "Camera2CameraFactory";
    private final List<String> mAvailableCameraIds;
    private final CameraCoordinator mCameraCoordinator;
    private final Map<String, Camera2CameraInfoImpl> mCameraInfos;
    private final CameraManagerCompat mCameraManager;
    private final long mCameraOpenRetryMaxTimeoutInMs;
    private final CameraStateRegistry mCameraStateRegistry;
    private final Context mContext;
    private final DisplayInfoManager mDisplayInfoManager;
    private final CameraThreadConfig mThreadConfig;

    @Override // androidx.camera.core.impl.CameraFactory
    public Set<String> getAvailableCameraIds() {
        return new LinkedHashSet(this.mAvailableCameraIds);
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public /* bridge */ /* synthetic */ Object getCameraManager() {
        return getCameraManager();
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public CameraCoordinator getCameraCoordinator() {
        return this.mCameraCoordinator;
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public CameraManagerCompat getCameraManager() {
        return this.mCameraManager;
    }

    private List<String> getBackwardCompatibleCameraIds(List<String> r5) throws InitializationException {
        ArrayList r0 = new ArrayList();
        Iterator<String> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        String r1 = r6.next();
        if (r1.equals("0") == true) goto L14;
        if (r1.equals("1") == true) goto L14;
        if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, r1) == true) goto L12;
        Logger.d(TAG, "Camera " + r1 + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
        goto L4
    L12:
        r0.add(r1);
    L14:
        r0.add(r1);
        goto L4
    L15:
        return r0;
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public CameraInternal getCamera(String r14) throws CameraUnavailableException {
        if (this.mAvailableCameraIds.contains(r14) == false) goto L7;
        return new Camera2CameraImpl(this.mContext, this.mCameraManager, r14, getCameraInfo(r14), this.mCameraCoordinator, this.mCameraStateRegistry, this.mThreadConfig.getCameraExecutor(), this.mThreadConfig.getSchedulerHandler(), this.mDisplayInfoManager, this.mCameraOpenRetryMaxTimeoutInMs);
    L7:
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    public Camera2CameraInfoImpl getCameraInfo(String r3) throws CameraUnavailableException {
        Camera2CameraInfoImpl r0 = this.mCameraInfos.get(r3);     // Catch: CameraAccessExceptionCompat -> L6
        if (r0 != null) goto L11;
        Camera2CameraInfoImpl r1 = new Camera2CameraInfoImpl(r3, this.mCameraManager);     // Catch: CameraAccessExceptionCompat -> L6
        this.mCameraInfos.put(r3, r1);     // Catch: CameraAccessExceptionCompat -> L6
        return r1;
    L11:
        return r0;
    L6:
        e = move-exception;
        throw CameraUnavailableExceptionHelper.createFrom(e);
    }

    public Camera2CameraFactory(Context r2, CameraThreadConfig r3, CameraSelector r4, long r5) throws InitializationException {
        this.mCameraInfos = new HashMap();
        this.mContext = r2;
        this.mThreadConfig = r3;
        CameraManagerCompat r6 = CameraManagerCompat.from(r2, r3.getSchedulerHandler());
        this.mCameraManager = r6;
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(r2);
        this.mAvailableCameraIds = getBackwardCompatibleCameraIds(CameraSelectionOptimizer.getSelectedAvailableCameraIds(this, r4));
        Camera2CameraCoordinator r7 = new Camera2CameraCoordinator(r6);
        this.mCameraCoordinator = r7;
        CameraStateRegistry r8 = new CameraStateRegistry(r7, 1);
        this.mCameraStateRegistry = r8;
        r7.addListener(r8);
        this.mCameraOpenRetryMaxTimeoutInMs = r5;
    }
}
