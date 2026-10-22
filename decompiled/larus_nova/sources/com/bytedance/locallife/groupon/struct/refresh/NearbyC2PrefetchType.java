package com.bytedance.locallife.groupon.struct.refresh;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/refresh/NearbyC2PrefetchType;", "", "PREFETCH", "CHECK", "DIRECT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyC2PrefetchType extends Enum<NearbyC2PrefetchType> {
    public static final NearbyC2PrefetchType CHECK = null;
    public static final NearbyC2PrefetchType DIRECT = null;
    public static final NearbyC2PrefetchType PREFETCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyC2PrefetchType[] f258848a = null;

    public static NearbyC2PrefetchType valueOf(String r100) {
        return (NearbyC2PrefetchType) a.a(NearbyC2PrefetchType.class, r100);
    }

    public static NearbyC2PrefetchType[] values() {
        return (NearbyC2PrefetchType[]) f258848a.clone();
    }

    static {
        NearbyC2PrefetchType r100 = new NearbyC2PrefetchType("PREFETCH", 0);
        PREFETCH = r100;
        NearbyC2PrefetchType r101 = new NearbyC2PrefetchType("CHECK", 1);
        CHECK = r101;
        NearbyC2PrefetchType r102 = new NearbyC2PrefetchType("DIRECT", 2);
        DIRECT = r102;
        f258848a = new NearbyC2PrefetchType[]{r100, r101, r102};
    }

    public NearbyC2PrefetchType(String r100, int r101) {
        super(r100, r101);
    }
}
