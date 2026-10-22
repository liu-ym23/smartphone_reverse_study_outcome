package zu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.g;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.bytedance.ee.bear.bitable.statistic.k;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements m {
    public c() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addFpsConsumer(String r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalConsumer(String r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalPoint(String r2, BitableStatisticEventModel$NormalPointModel r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "point");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addProcessConsumer(String r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addTraceExtra(String r1, String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Intrinsics.checkNotNullParameter(r2, "key");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void appendTraceExtraIfNotExist(String r1, String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Intrinsics.checkNotNullParameter(r2, "key");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createDefaultNormalTrace(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createNormalTrace(String r1) {
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeAllConsumer(String r2) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeFpsConsumer(String r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeNormalConsumer(String r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeProcessConsumer(String r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void reportError(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void setCommonParams(String r1, Serializable r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopAllTrace() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopTrace(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createFpsTrace(String r1) {
        return new a();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final g createProcessTrace(String r1) {
        return new b();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createDefaultFpsTrace(String r1, boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        return new a();
    }
}
