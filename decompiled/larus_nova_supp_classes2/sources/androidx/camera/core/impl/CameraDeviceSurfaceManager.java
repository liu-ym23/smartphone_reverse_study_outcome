package androidx.camera.core.impl;

import android.content.Context;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraDeviceSurfaceManager {

    public interface Provider {
        CameraDeviceSurfaceManager newInstance(Context r1, Object r2, Set<String> r3) throws InitializationException;
    }

    Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecs(int r1, String r2, List<AttachedSurfaceInfo> r3, Map<UseCaseConfig<?>, List<Size>> r4, boolean r5, boolean r6);

    SurfaceConfig transformSurfaceConfig(int r1, String r2, int r3, Size r4);
}
