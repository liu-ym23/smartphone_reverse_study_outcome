package androidx.camera.video.internal.workaround;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class QualityValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final Map<Integer, Quality> CAMCORDER_TO_VIDEO_QUALITY_MAP = null;
    private final CameraInfoInternal mCameraInfo;
    private final EncoderProfilesProvider mProvider;
    private final Quirks mQuirks;

    static {
        HashMap r0 = new HashMap();
        CAMCORDER_TO_VIDEO_QUALITY_MAP = r0;
        r0.put(1, Quality.HIGHEST);
        r0.put(8, Quality.UHD);
        r0.put(6, Quality.FHD);
        r0.put(5, Quality.HD);
        r0.put(4, Quality.SD);
        r0.put(0, Quality.LOWEST);
    }

    private boolean isDeviceValidQuality(int r4) {
        Quality r5 = CAMCORDER_TO_VIDEO_QUALITY_MAP.get(Integer.valueOf(r4));
        if (r5 == null) goto L15;
        Iterator r0 = this.mQuirks.getAll(VideoQualityQuirk.class).iterator();
    L6:
        if (r0.hasNext() == false) goto L25;
        VideoQualityQuirk r1 = (VideoQualityQuirk) r0.next();
        if (r1 == null) goto L6;
        if (r1.isProblematicVideoQuality(this.mCameraInfo, r5) == false) goto L6;
        if (workaroundBySurfaceProcessing(r1) == true) goto L6;
        return false;
    L25:
        return true;
    L15:
        return true;
    }

    private static boolean workaroundBySurfaceProcessing(Quirk r1) {
        if ((r1 instanceof SurfaceProcessingQuirk) == true) goto L5;
    L7:
        return false;
    L5:
        if (((SurfaceProcessingQuirk) r1).workaroundBySurfaceProcessing() == false) goto L7;
        return true;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r2) {
        if (hasProfile(r2) == true) goto L7;
        return null;
    L7:
        return this.mProvider.getAll(r2);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r2) {
        if (this.mProvider.hasProfile(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDeviceValidQuality(r2) == false) goto L7;
        return true;
    }

    public QualityValidatedEncoderProfilesProvider(EncoderProfilesProvider r1, CameraInfoInternal r2, Quirks r3) {
        this.mProvider = r1;
        this.mCameraInfo = r2;
        this.mQuirks = r3;
    }
}
