package com.bytedance.iesgurd.statistic.model;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/iesgurd/statistic/model/CleanStrategy;", "", "BUSINESS_CALL", "CHECK_UPDATE", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "CACHE_POLICY", "EXPIRE_TIME", "LATE_REGISTER", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum CleanStrategy extends Enum<CleanStrategy> {
    public static final CleanStrategy BUSINESS_CALL = null;
    public static final CleanStrategy CACHE_POLICY = null;
    public static final CleanStrategy CHECK_UPDATE = null;
    public static final CleanStrategy EXPIRE_TIME = null;
    public static final CleanStrategy LATE_REGISTER = null;
    public static final CleanStrategy PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CleanStrategy[] f250849a = null;

    static {
        CleanStrategy r100 = new CleanStrategy("BUSINESS_CALL", 0);
        BUSINESS_CALL = r100;
        CleanStrategy r101 = new CleanStrategy("CHECK_UPDATE", 1);
        CHECK_UPDATE = r101;
        CleanStrategy r102 = new CleanStrategy(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 2);
        PUSH = r102;
        CleanStrategy r103 = new CleanStrategy("CACHE_POLICY", 3);
        CACHE_POLICY = r103;
        CleanStrategy r104 = new CleanStrategy("EXPIRE_TIME", 4);
        EXPIRE_TIME = r104;
        CleanStrategy r105 = new CleanStrategy("LATE_REGISTER", 5);
        LATE_REGISTER = r105;
        f250849a = new CleanStrategy[]{r100, r101, r102, r103, r104, r105};
    }

    public static CleanStrategy valueOf(String r100) {
        return (CleanStrategy) a.a(CleanStrategy.class, r100);
    }

    public static CleanStrategy[] values() {
        return (CleanStrategy[]) f250849a.clone();
    }

    public CleanStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
