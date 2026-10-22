package com.bytedance.bdp.bdpbase.core;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/bdp/bdpbase/core/BdpLocalAB;", "", "", "value$delegate", "Lkotlin/Lazy;", "getValue", "()Z", "value", "LoadingFeat_Enable", "LoadingFeat_SkeletonShowLoading", "SkeletonEnable", "TopApiOpt", "CpRequestUseOkhttp_Only", "CpRequestUseOkhttp_RemovePreHttpDns", "GetServiceLockOpt", "BdpTaskOpt_event", "BdpTaskOpt_logger", "ApiCostOpt", "PathPreHost", "MemoryOpt", "LcpTest", "ForceRecord", "PerfTools", "IndustryCoverageEnable", "WorkerEnable", "NewPredefineEnable", "HybridDevtoolEnable", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
public final enum BdpLocalAB extends Enum<BdpLocalAB> {
    public static final BdpLocalAB ApiCostOpt = null;
    public static final BdpLocalAB BdpTaskOpt_event = null;
    public static final BdpLocalAB BdpTaskOpt_logger = null;
    public static final BdpLocalAB CpRequestUseOkhttp_Only = null;
    public static final BdpLocalAB CpRequestUseOkhttp_RemovePreHttpDns = null;
    public static final BdpLocalAB ForceRecord = null;
    public static final BdpLocalAB GetServiceLockOpt = null;
    public static final BdpLocalAB HybridDevtoolEnable = null;
    public static final BdpLocalAB IndustryCoverageEnable = null;
    public static final BdpLocalAB LcpTest = null;
    public static final BdpLocalAB LoadingFeat_Enable = null;
    public static final BdpLocalAB LoadingFeat_SkeletonShowLoading = null;
    public static final BdpLocalAB MemoryOpt = null;
    public static final BdpLocalAB NewPredefineEnable = null;
    public static final BdpLocalAB PathPreHost = null;
    public static final BdpLocalAB PerfTools = null;
    public static final BdpLocalAB SkeletonEnable = null;
    public static final BdpLocalAB TopApiOpt = null;
    public static final BdpLocalAB WorkerEnable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BdpLocalAB[] f201084a = null;
    private final Lazy value$delegate;

    static {
        BdpLocalAB r100 = new BdpLocalAB("LoadingFeat_Enable", 0);
        LoadingFeat_Enable = r100;
        BdpLocalAB r101 = new BdpLocalAB("LoadingFeat_SkeletonShowLoading", 1);
        LoadingFeat_SkeletonShowLoading = r101;
        BdpLocalAB r102 = new BdpLocalAB("SkeletonEnable", 2);
        SkeletonEnable = r102;
        BdpLocalAB r103 = new BdpLocalAB("TopApiOpt", 3);
        TopApiOpt = r103;
        BdpLocalAB r104 = new BdpLocalAB("CpRequestUseOkhttp_Only", 4);
        CpRequestUseOkhttp_Only = r104;
        BdpLocalAB r105 = new BdpLocalAB("CpRequestUseOkhttp_RemovePreHttpDns", 5);
        CpRequestUseOkhttp_RemovePreHttpDns = r105;
        BdpLocalAB r106 = new BdpLocalAB("GetServiceLockOpt", 6);
        GetServiceLockOpt = r106;
        BdpLocalAB r107 = new BdpLocalAB("BdpTaskOpt_event", 7);
        BdpTaskOpt_event = r107;
        BdpLocalAB r108 = new BdpLocalAB("BdpTaskOpt_logger", 8);
        BdpTaskOpt_logger = r108;
        BdpLocalAB r109 = new BdpLocalAB("ApiCostOpt", 9);
        ApiCostOpt = r109;
        BdpLocalAB r110 = new BdpLocalAB("PathPreHost", 10);
        PathPreHost = r110;
        BdpLocalAB r111 = new BdpLocalAB("MemoryOpt", 11);
        MemoryOpt = r111;
        BdpLocalAB r112 = new BdpLocalAB("LcpTest", 12);
        LcpTest = r112;
        BdpLocalAB r113 = new BdpLocalAB("ForceRecord", 13);
        ForceRecord = r113;
        BdpLocalAB r114 = new BdpLocalAB("PerfTools", 14);
        PerfTools = r114;
        BdpLocalAB r115 = new BdpLocalAB("IndustryCoverageEnable", 15);
        IndustryCoverageEnable = r115;
        BdpLocalAB r116 = new BdpLocalAB("WorkerEnable", 16);
        WorkerEnable = r116;
        BdpLocalAB r117 = new BdpLocalAB("NewPredefineEnable", 17);
        NewPredefineEnable = r117;
        BdpLocalAB r118 = new BdpLocalAB("HybridDevtoolEnable", 18);
        HybridDevtoolEnable = r118;
        f201084a = new BdpLocalAB[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public static BdpLocalAB valueOf(String r100) {
        return (BdpLocalAB) r27.a.a(BdpLocalAB.class, r100);
    }

    public static BdpLocalAB[] values() {
        return (BdpLocalAB[]) f201084a.clone();
    }

    public final boolean getValue() {
        return ((Boolean) this.value$delegate.getValue()).booleanValue();
    }

    public BdpLocalAB(String r100, int r101) {
        super(r100, r101);
        this.value$delegate = LazyKt.lazy(new BdpLocalAB$value$2(this));
    }
}
