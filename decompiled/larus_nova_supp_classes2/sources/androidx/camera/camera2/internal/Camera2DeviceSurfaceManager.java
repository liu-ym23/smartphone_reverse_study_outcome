package androidx.camera.camera2.internal;

import android.content.Context;
import android.util.Pair;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2DeviceSurfaceManager implements CameraDeviceSurfaceManager {
    private static final String TAG = "Camera2DeviceSurfaceManager";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final Map<String, SupportedSurfaceCombination> mCameraSupportedSurfaceCombinationMap;

    public Camera2DeviceSurfaceManager(Context r2, Object r3, Set<String> r4) throws CameraUnavailableException {
        this(r2, new AnonymousClass1(), r3, r4);
    }

    private void init(Context r5, CameraManagerCompat r6, Set<String> r7) throws CameraUnavailableException {
        Preconditions.checkNotNull(r5);
        Iterator<String> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        String r0 = r8.next();
        this.mCameraSupportedSurfaceCombinationMap.put(r0, new SupportedSurfaceCombination(r5, r0, r6, this.mCamcorderProfileHelper));
        goto L4
    }

    public Camera2DeviceSurfaceManager(Context r2, CamcorderProfileHelper r3, Object r4, Set<String> r5) throws CameraUnavailableException {
        this.mCameraSupportedSurfaceCombinationMap = new HashMap();
        Preconditions.checkNotNull(r3);
        this.mCamcorderProfileHelper = r3;
        if ((r4 instanceof CameraManagerCompat) == false) goto L5;
        CameraManagerCompat r6 = (CameraManagerCompat) r4;
    L6:
        init(r2, r6, r5);
        return;
    L5:
        r6 = CameraManagerCompat.from(r2);
        goto L6
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public SurfaceConfig transformSurfaceConfig(int r2, String r3, int r4, Size r5) {
        SupportedSurfaceCombination r6 = this.mCameraSupportedSurfaceCombinationMap.get(r3);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.transformSurfaceConfig(r2, r4, r5);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecs(int r8, String r9, List<AttachedSurfaceInfo> r10, Map<UseCaseConfig<?>, List<Size>> r11, boolean r12, boolean r13) {
        Preconditions.checkArgument(!r11.isEmpty(), "No new use cases to be bound.");
        SupportedSurfaceCombination r1 = this.mCameraSupportedSurfaceCombinationMap.get(r9);
        if (r1 == null) goto L7;
        return r1.getSuggestedStreamSpecifications(r8, r10, r11, r12, r13);
    L7:
        throw new IllegalArgumentException("No such camera id in supported combination list: " + r9);
    }
}
