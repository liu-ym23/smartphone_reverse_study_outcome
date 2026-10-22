package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchValueUtils;", "", "()V", "finiteDouble", "", "value", "defaultValue", "finiteFloat", "", "isFinite", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchValueUtils {
    public static final SensorBatchValueUtils INSTANCE = null;

    private SensorBatchValueUtils() {
    }

    static {
        INSTANCE = new SensorBatchValueUtils();
    }

    public final boolean isFinite(double r2) {
        if (Double.isNaN(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isInfinite(r2) == true) goto L7;
        return true;
    }

    public final boolean isFinite(float r2) {
        if (Float.isNaN(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isInfinite(r2) == true) goto L7;
        return true;
    }

    public final double finiteDouble(double r2, double r4) {
        if (Double.isNaN(r2) == true) goto L7;
        if (Double.isInfinite(r2) == true) goto L7;
        return r2;
    L7:
        return r4;
    }

    public final float finiteFloat(float r2, float r3) {
        if (Float.isNaN(r2) == true) goto L7;
        if (Float.isInfinite(r2) == true) goto L7;
        return r2;
    L7:
        return r3;
    }

    public static /* synthetic */ double finiteDouble$default(SensorBatchValueUtils r0, double r1, double r3, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0.0d;
    L6:
        return r0.finiteDouble(r1, r3);
    }

    public static /* synthetic */ float finiteFloat$default(SensorBatchValueUtils r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0.0f;
    L6:
        return r0.finiteFloat(r1, r2);
    }
}
