package androidx.camera.camera2.internal.concurrent;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Camera2CameraCoordinator implements CameraCoordinator {
    private static final String TAG = "Camera2CameraCoordinator";
    private List<CameraInfo> mActiveConcurrentCameraInfos;
    private final CameraManagerCompat mCameraManager;
    private int mCameraOperatingMode;
    private final Map<String, List<String>> mConcurrentCameraIdMap;
    private Set<Set<String>> mConcurrentCameraIds;
    private final List<CameraCoordinator.ConcurrentCameraModeListener> mConcurrentCameraModeListeners;

    public static /* synthetic */ List a(String r0, List r1) {
        return lambda$createCameraSelectorById$0(r0, r1);
    }

    private void retrieveConcurrentCameraIds() {
        Set<Set<String>> r1 = new HashSet();
        r1 = this.mCameraManager.getConcurrentCameraIds();     // Catch: CameraAccessExceptionCompat -> L5
    L6:
        Iterator<Set<String>> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L28;
        ArrayList r3 = new ArrayList(r2.next());
        if (r3.size() < 2) goto L8;
        String r5 = (String) ListProtector.get(r3, 0);
        String r7 = (String) ListProtector.get(r3, 1);
    L17:
        Logger.d(TAG, "Concurrent camera id pair: (" + r5 + ", " + r7 + ") is not backward compatible");
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L8;
        this.mConcurrentCameraIds.add(new HashSet(Arrays.asList(new String[]{r5, r7})));
        if (this.mConcurrentCameraIdMap.containsKey(r5) == true) goto L25;
        this.mConcurrentCameraIdMap.put(r5, new ArrayList());
    L25:
        if (this.mConcurrentCameraIdMap.containsKey(r7) == true) goto L27;
        this.mConcurrentCameraIdMap.put(r7, new ArrayList());
    L27:
        this.mConcurrentCameraIdMap.get(r5).add((String) ListProtector.get(r3, 1));
        this.mConcurrentCameraIdMap.get(r7).add((String) ListProtector.get(r3, 0));
        goto L8
    L13:
        if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, r5) == false) goto L18;
        if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, r7) == false) goto L18;
        r8 = true;
        goto L19
    L28:
        return;
    L5:
        Logger.e(TAG, "Failed to get concurrent camera ids");
        goto L6
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public List<List<CameraSelector>> getConcurrentCameraSelectors() {
        ArrayList r0 = new ArrayList();
        Iterator<Set<String>> r1 = this.mConcurrentCameraIds.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Set<String> r2 = r1.next();
        ArrayList r3 = new ArrayList();
        Iterator<String> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        String r5 = r4.next();
        r3.add(createCameraSelectorById(this.mCameraManager, r5));
        goto L7
    L9:
        r0.add(r3);
        goto L4
    L10:
        return r0;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void shutdown() {
        this.mConcurrentCameraModeListeners.clear();
        this.mConcurrentCameraIdMap.clear();
        this.mActiveConcurrentCameraInfos.clear();
        this.mConcurrentCameraIds.clear();
        this.mCameraOperatingMode = 0;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public List<CameraInfo> getActiveConcurrentCameraInfos() {
        return this.mActiveConcurrentCameraInfos;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public int getCameraOperatingMode() {
        return this.mCameraOperatingMode;
    }

    public Camera2CameraCoordinator(CameraManagerCompat r2) {
        this.mCameraOperatingMode = 0;
        this.mCameraManager = r2;
        this.mConcurrentCameraIdMap = new HashMap();
        this.mConcurrentCameraIds = new HashSet();
        this.mConcurrentCameraModeListeners = new ArrayList();
        this.mActiveConcurrentCameraInfos = new ArrayList();
        retrieveConcurrentCameraIds();
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void addListener(CameraCoordinator.ConcurrentCameraModeListener r2) {
        this.mConcurrentCameraModeListeners.add(r2);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public String getPairedConcurrentCameraId(String r5) {
        if (this.mConcurrentCameraIdMap.containsKey(r5) == true) goto L5;
        return null;
    L5:
        Iterator<String> r6 = this.mConcurrentCameraIdMap.get(r5).iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        String r0 = r6.next();
        Iterator<CameraInfo> r2 = this.mActiveConcurrentCameraInfos.iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        if (r0.equals(Camera2CameraInfo.from(r2.next()).getCameraId()) == false) goto L10;
        return r0;
    L14:
        return null;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void removeListener(CameraCoordinator.ConcurrentCameraModeListener r2) {
        this.mConcurrentCameraModeListeners.remove(r2);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setActiveConcurrentCameraInfos(List<CameraInfo> r2) {
        this.mActiveConcurrentCameraInfos = new ArrayList(r2);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setCameraOperatingMode(int r4) {
        if (r4 == this.mCameraOperatingMode) goto L9;
        Iterator<CameraCoordinator.ConcurrentCameraModeListener> r0 = this.mConcurrentCameraModeListeners.iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        r0.next().onCameraOperatingModeUpdated(this.mCameraOperatingMode, r4);
    L9:
        if (this.mCameraOperatingMode != 2) goto L12;
        if (r4 == 2) goto L12;
        this.mActiveConcurrentCameraInfos.clear();
    L12:
        this.mCameraOperatingMode = r4;
    }

    private static CameraSelector createCameraSelectorById(CameraManagerCompat r2, final String r3) {
        CameraSelector.Builder r0 = new CameraSelector.Builder().addCameraFilter(new a(r3));
        r0.requireLensFacing(((Integer) r2.getCameraCharacteristicsCompat(r3).get(CameraCharacteristics.LENS_FACING)).intValue());     // Catch: CameraAccessExceptionCompat -> L6
        return r0.build();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static /* synthetic */ List lambda$createCameraSelectorById$0(String r2, List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        CameraInfo r0 = (CameraInfo) r4.next();
        if (r2.equals(Camera2CameraInfo.from(r0).getCameraId()) == false) goto L4;
        return Collections.singletonList(r0);
    L10:
        throw new IllegalArgumentException("No camera can be find for id: " + r2);
    }
}
