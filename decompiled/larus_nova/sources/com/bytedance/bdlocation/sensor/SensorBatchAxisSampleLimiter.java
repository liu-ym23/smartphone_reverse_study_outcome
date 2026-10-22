package com.bytedance.bdlocation.sensor;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchAxisSampleLimiter;", "", "()V", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "Lcom/bytedance/bdlocation/sensor/AxisSample;", "samples", "maxSize", "", "limitByConfig", "samplingIntervalUs", "resolveMaxSampleSize", "pushIntervalMs", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchAxisSampleLimiter {
    public static final SensorBatchAxisSampleLimiter INSTANCE = null;

    private SensorBatchAxisSampleLimiter() {
    }

    static {
        INSTANCE = new SensorBatchAxisSampleLimiter();
    }

    private final List<AxisSample> limit(List<AxisSample> r110, int r111) {
        if (r111 > 0) goto L4;
    L19:
        return r110;
    L4:
        if (r110.size() <= r111) goto L19;
        List r112 = CollectionsKt.sortedWith(r110, new SensorBatchAxisSampleLimiter$limit$$inlined$sortedBy$1());
        if (r111 != 1) goto L11;
        return CollectionsKt.listOf(CollectionsKt.last(r112));
    L11:
        if (r111 == 2) goto L13;
        List r100 = r112.subList(1, r112.size() - 1);
        int r101 = r111 - 2;
        ArrayList r102 = new ArrayList(r111);
        r102.add(CollectionsKt.first(r112));
        int r113 = 0;
    L15:
        if (r113 >= r101) goto L17;
        r113 = r113 + 1;
        r102.add(ListProtector.get(r100, RangesKt.coerceIn(((int) ((((double) r113) * ((double) (r100.size() + 1))) / ((double) (r101 + 1)))) - 1, 0, r100.size() - 1)));
        goto L15
    L17:
        r102.add(CollectionsKt.last(r112));
        return r102;
    L13:
        return CollectionsKt.listOf(new AxisSample[]{(AxisSample) CollectionsKt.first(r112), (AxisSample) CollectionsKt.last(r112)});
    }

    private final int resolveMaxSampleSize(int r100, long r101) {
        if (r100 > 0) goto L4;
        return 0;
    L4:
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return Math.max(1, (int) ((r101 * 1000) / ((long) r100)));
    }

    public final List<AxisSample> limitByConfig(List<AxisSample> r100, int r101) {
        return limit(r100, resolveMaxSampleSize(r101, BDLocationConfig.getFusionLocationSensorBatchPushIntervalMs()));
    }
}
