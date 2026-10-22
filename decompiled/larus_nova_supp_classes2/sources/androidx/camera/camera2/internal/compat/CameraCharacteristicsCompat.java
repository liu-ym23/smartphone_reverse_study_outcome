package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CameraCharacteristicsCompat {
    private final CameraCharacteristicsCompatImpl mCameraCharacteristicsImpl;
    private final String mCameraId;
    private StreamConfigurationMapCompat mStreamConfigurationMapCompat;
    private final Map<CameraCharacteristics.Key<?>, Object> mValuesCache;

    public interface CameraCharacteristicsCompatImpl {
        <T> T get(CameraCharacteristics.Key<T> r1);

        Set<String> getPhysicalCameraIds();

        CameraCharacteristics unwrap();
    }

    public Set<String> getPhysicalCameraIds() {
        return this.mCameraCharacteristicsImpl.getPhysicalCameraIds();
    }

    public StreamConfigurationMapCompat getStreamConfigurationMapCompat() {
        if (this.mStreamConfigurationMapCompat != null) goto L15;
        StreamConfigurationMap r0 = (StreamConfigurationMap) get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: AssertionError -> L9 Throwable -> L11
        if (r0 == null) goto L8;
        this.mStreamConfigurationMapCompat = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(r0, new OutputSizesCorrector(this.mCameraId));
        goto L15
    L8:
        throw new IllegalArgumentException("StreamConfigurationMap is null!");
    L11:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage());
    L15:
        return this.mStreamConfigurationMapCompat;
    }

    public boolean isZoomOverrideAvailable() {
        if (Build.VERSION.SDK_INT < 34) goto L12;
        int[] r0 = (int[]) this.mCameraCharacteristicsImpl.get(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
        if (r0 == null) goto L12;
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        if (r0[r3] == 1) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    }

    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristicsImpl.unwrap();
    }

    private boolean isKeyNonCacheable(CameraCharacteristics.Key<?> r2) {
        return r2.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    public <T> T get(CameraCharacteristics.Key<T> r3) {
        if (isKeyNonCacheable(r3) == true) goto L5;
        monitor-enter(this);
        T r0 = (T) this.mValuesCache.get(r3);
        if (r0 == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L11:
        T r1 = (T) this.mCameraCharacteristicsImpl.get(r3);
        if (r1 == null) goto L14;
        this.mValuesCache.put((CameraCharacteristics.Key<?>) r3, r1);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r1;
    L16:
        th = move-exception;
        throw th;
    L5:
        return (T) this.mCameraCharacteristicsImpl.get(r3);
    }

    private CameraCharacteristicsCompat(CameraCharacteristics r3, String r4) {
        this.mValuesCache = new HashMap();
        this.mStreamConfigurationMapCompat = null;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mCameraCharacteristicsImpl = new CameraCharacteristicsApi28Impl(r3);
    L6:
        this.mCameraId = r4;
        return;
    L5:
        this.mCameraCharacteristicsImpl = new CameraCharacteristicsBaseImpl(r3);
        goto L6
    }

    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(CameraCharacteristics r1, String r2) {
        return new CameraCharacteristicsCompat(r1, r2);
    }
}
