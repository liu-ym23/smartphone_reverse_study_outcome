package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchDefaults;", "", "()V", "MAGNETIC_DECLINATION_FALLBACK_DEG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchDefaults {
    public static final SensorBatchDefaults INSTANCE = null;
    public static final float MAGNETIC_DECLINATION_FALLBACK_DEG = -6.0f;

    private SensorBatchDefaults() {
    }

    static {
        INSTANCE = new SensorBatchDefaults();
    }
}
