package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchImuCallback;", "", "onAccelerometerSample", "", "sample", "Lcom/bytedance/bdlocation/sensor/AxisSample;", "onGyroscopeSample", "onMagnetometerSample", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public interface SensorBatchImuCallback {
    void onAccelerometerSample(AxisSample r100);

    void onGyroscopeSample(AxisSample r100);

    void onMagnetometerSample(AxisSample r100);
}
