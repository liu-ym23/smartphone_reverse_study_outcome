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

/* JADX INFO: loaded from: classes16.dex */
public final class c implements m {
    public c() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addFpsConsumer(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalConsumer(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalPoint(String r100, BitableStatisticEventModel$NormalPointModel r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "point");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addProcessConsumer(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addTraceExtra(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void appendTraceExtraIfNotExist(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createDefaultNormalTrace(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createNormalTrace(String r100) {
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeAllConsumer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeFpsConsumer(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeNormalConsumer(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeProcessConsumer(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void reportError(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void setCommonParams(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopAllTrace() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopTrace(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createFpsTrace(String r100) {
        return new a();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final g createProcessTrace(String r100) {
        return new b();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createDefaultFpsTrace(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return new a();
    }
}
