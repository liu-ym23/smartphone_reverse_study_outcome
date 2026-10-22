package com.larus.im.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/service/FlowRTCEnginePoolObtainResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAILED", "SUCCESS", "EXISTED", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowRTCEnginePoolObtainResult extends Enum<FlowRTCEnginePoolObtainResult> {
    public static final FlowRTCEnginePoolObtainResult EXISTED = null;
    public static final FlowRTCEnginePoolObtainResult FAILED = null;
    public static final FlowRTCEnginePoolObtainResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowRTCEnginePoolObtainResult[] f350611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350612b = null;
    private final int value;

    public static EnumEntries<FlowRTCEnginePoolObtainResult> getEntries() {
        return f350612b;
    }

    static {
        FlowRTCEnginePoolObtainResult r100 = new FlowRTCEnginePoolObtainResult("FAILED", 0, 0);
        FAILED = r100;
        FlowRTCEnginePoolObtainResult r101 = new FlowRTCEnginePoolObtainResult("SUCCESS", 1, 1);
        SUCCESS = r101;
        FlowRTCEnginePoolObtainResult r102 = new FlowRTCEnginePoolObtainResult("EXISTED", 2, 2);
        EXISTED = r102;
        FlowRTCEnginePoolObtainResult[] r103 = {r100, r101, r102};
        f350611a = r103;
        f350612b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowRTCEnginePoolObtainResult[] values() {
        return (FlowRTCEnginePoolObtainResult[]) f350611a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowRTCEnginePoolObtainResult valueOf(String r100) {
        return (FlowRTCEnginePoolObtainResult) r27.a.a(FlowRTCEnginePoolObtainResult.class, r100);
    }

    public FlowRTCEnginePoolObtainResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
