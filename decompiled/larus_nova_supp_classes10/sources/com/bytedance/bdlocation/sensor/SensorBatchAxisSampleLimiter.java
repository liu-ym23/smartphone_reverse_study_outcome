package com.bytedance.bdlocation.sensor;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchAxisSampleLimiter;", "", "()V", "limit", "", "Lcom/bytedance/bdlocation/sensor/AxisSample;", "samples", "maxSize", "", "limitByConfig", "samplingIntervalUs", "resolveMaxSampleSize", "pushIntervalMs", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchAxisSampleLimiter {
    public static final SensorBatchAxisSampleLimiter INSTANCE = null;

    private SensorBatchAxisSampleLimiter() {
    }

    static {
        INSTANCE = new SensorBatchAxisSampleLimiter();
    }

    private final List<AxisSample> limit(List<AxisSample> r10, int r11) {
        if (r11 > 0) goto L4;
    L19:
        return r10;
    L4:
        if (r10.size() <= r11) goto L19;
        List r12 = CollectionsKt.sortedWith(r10, new SensorBatchAxisSampleLimiter$limit$$inlined$sortedBy$1());
        if (r11 != 1) goto L11;
        return CollectionsKt.listOf(CollectionsKt.last(r12));
    L11:
        if (r11 == 2) goto L13;
        List r2 = r12.subList(1, r12.size() - 1);
        int r3 = r11 - 2;
        ArrayList r4 = new ArrayList(r11);
        r4.add(CollectionsKt.first(r12));
        int r13 = 0;
    L15:
        if (r13 >= r3) goto L17;
        r13 = r13 + 1;
        r4.add(ListProtector.get(r2, RangesKt.coerceIn(((int) ((((double) r13) * ((double) (r2.size() + 1))) / ((double) (r3 + 1)))) - 1, 0, r2.size() - 1)));
        goto L15
    L17:
        r4.add(CollectionsKt.last(r12));
        return r4;
    L13:
        return CollectionsKt.listOf(new AxisSample[]{(AxisSample) CollectionsKt.first(r12), (AxisSample) CollectionsKt.last(r12)});
    }

    private final int resolveMaxSampleSize(int r4, long r5) {
        if (r4 > 0) goto L4;
        return 0;
    L4:
        if (r5 > 0) goto L7;
        return 0;
    L7:
        return Math.max(1, (int) ((r5 * 1000) / ((long) r4)));
    }

    public final List<AxisSample> limitByConfig(List<AxisSample> r3, int r4) {
        return limit(r3, resolveMaxSampleSize(r4, BDLocationConfig.getFusionLocationSensorBatchPushIntervalMs()));
    }
}
