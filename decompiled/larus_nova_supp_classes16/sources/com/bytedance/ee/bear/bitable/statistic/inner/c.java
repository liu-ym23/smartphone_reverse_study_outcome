package com.bytedance.ee.bear.bitable.statistic.inner;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.config.BitableStatisticConfig;
import com.bytedance.ee.bear.bitable.statistic.g;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.bytedance.ee.bear.bitable.statistic.k;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c implements m {
    private m realService;

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void stopAllTrace() {
        this.realService.stopAllTrace();
    }

    public c(Lazy<? extends xw4.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "appLogger");
        BitableStatisticConfig r0 = (BitableStatisticConfig) BitableStatisticConfig.a.getValue();
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.a(), Boolean.TRUE);
    L6:
        if (r1 == false) goto L8;
        m r4 = new zu4.c();
    L9:
        this.realService = r4;
        return;
    L8:
        r4 = new BitableStatisticServiceReal(r3);
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public com.bytedance.ee.bear.bitable.statistic.c createFpsTrace(String r2) {
        return this.realService.createFpsTrace(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public String createNormalTrace(String r2) {
        return this.realService.createNormalTrace(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public g createProcessTrace(String r2) {
        return this.realService.createProcessTrace(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeAllConsumer(String r2) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        this.realService.removeAllConsumer(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addFpsConsumer(String r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.realService.addFpsConsumer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addNormalConsumer(String r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.realService.addNormalConsumer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addNormalPoint(String r2, BitableStatisticEventModel$NormalPointModel r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "point");
        this.realService.addNormalPoint(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addProcessConsumer(String r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.realService.addProcessConsumer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public String createDefaultNormalTrace(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return this.realService.createDefaultNormalTrace(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeFpsConsumer(String r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.realService.removeFpsConsumer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeNormalConsumer(String r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.realService.removeNormalConsumer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeProcessConsumer(String r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.realService.removeProcessConsumer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void setCommonParams(String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.realService.setCommonParams(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void stopTrace(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        this.realService.stopTrace(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addTraceExtra(String r2, String r3, Serializable r4) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.realService.addTraceExtra(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void appendTraceExtraIfNotExist(String r2, String r3, Serializable r4) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.realService.appendTraceExtraIfNotExist(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void reportError(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
        this.realService.reportError(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public com.bytedance.ee.bear.bitable.statistic.c createDefaultFpsTrace(String r2, boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return this.realService.createDefaultFpsTrace(r2, r3, r4, r5);
    }
}
