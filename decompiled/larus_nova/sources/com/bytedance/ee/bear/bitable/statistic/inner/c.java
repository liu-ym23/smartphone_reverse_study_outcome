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

/* JADX INFO: loaded from: classes16.dex */
public abstract class c implements m {
    private m realService;

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void stopAllTrace() {
        this.realService.stopAllTrace();
    }

    public c(Lazy<? extends xw4.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "appLogger");
        BitableStatisticConfig r101 = BitableStatisticConfig.f215651a.getValue();
        if (r101 == null) goto L5;
        boolean r102 = Intrinsics.areEqual(r101.a(), Boolean.TRUE);
    L6:
        if (r102 == false) goto L8;
        m r103 = new zu4.c();
    L9:
        this.realService = r103;
        return;
    L8:
        r103 = new BitableStatisticServiceReal(r100);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public com.bytedance.ee.bear.bitable.statistic.c createFpsTrace(String r100) {
        return this.realService.createFpsTrace(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public String createNormalTrace(String r100) {
        return this.realService.createNormalTrace(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public g createProcessTrace(String r100) {
        return this.realService.createProcessTrace(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeAllConsumer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        this.realService.removeAllConsumer(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addFpsConsumer(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.realService.addFpsConsumer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addNormalConsumer(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.realService.addNormalConsumer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addNormalPoint(String r100, BitableStatisticEventModel$NormalPointModel r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "point");
        this.realService.addNormalPoint(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addProcessConsumer(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.realService.addProcessConsumer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public String createDefaultNormalTrace(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return this.realService.createDefaultNormalTrace(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeFpsConsumer(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.realService.removeFpsConsumer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeNormalConsumer(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.realService.removeNormalConsumer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void removeProcessConsumer(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        this.realService.removeProcessConsumer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void setCommonParams(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.realService.setCommonParams(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void stopTrace(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        this.realService.stopTrace(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void addTraceExtra(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.realService.addTraceExtra(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void appendTraceExtraIfNotExist(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.realService.appendTraceExtraIfNotExist(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public void reportError(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        this.realService.reportError(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public com.bytedance.ee.bear.bitable.statistic.c createDefaultFpsTrace(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return this.realService.createDefaultFpsTrace(r100, r101, r102, r103);
    }
}
