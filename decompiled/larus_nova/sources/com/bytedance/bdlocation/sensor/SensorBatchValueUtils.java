package com.bytedance.bdlocation.sensor;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchValueUtils;", "", "()V", "finiteDouble", "", "value", "defaultValue", "finiteFloat", "", "isFinite", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchValueUtils {
    public static final SensorBatchValueUtils INSTANCE = null;

    private SensorBatchValueUtils() {
    }

    static {
        INSTANCE = new SensorBatchValueUtils();
    }

    public final boolean isFinite(double r100) {
        if (Double.isNaN(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isInfinite(r100) == true) goto L7;
        return true;
    }

    public final boolean isFinite(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isInfinite(r100) == true) goto L7;
        return true;
    }

    public final double finiteDouble(double r100, double r101) {
        if (Double.isNaN(r100) == true) goto L7;
        if (Double.isInfinite(r100) == true) goto L7;
        return r100;
    L7:
        return r101;
    }

    public final float finiteFloat(float r100, float r101) {
        if (Float.isNaN(r100) == true) goto L7;
        if (Float.isInfinite(r100) == true) goto L7;
        return r100;
    L7:
        return r101;
    }

    public static /* synthetic */ double finiteDouble$default(SensorBatchValueUtils r100, double r101, double r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        return r100.finiteDouble(r101, r102);
    }

    public static /* synthetic */ float finiteFloat$default(SensorBatchValueUtils r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0.0f;
    L6:
        return r100.finiteFloat(r101, r102);
    }
}
