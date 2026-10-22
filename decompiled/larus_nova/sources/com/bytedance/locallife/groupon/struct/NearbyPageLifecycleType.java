package com.bytedance.locallife.groupon.struct;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyPageLifecycleType;", "", "UNKNOWN", EffectConstants.NORMAL, "TOP_TAB", "BOTTOM_TAB", "SIDE_BAR", "FRAGMENT_VISIBILITY", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyPageLifecycleType extends Enum<NearbyPageLifecycleType> {
    public static final NearbyPageLifecycleType BOTTOM_TAB = null;
    public static final NearbyPageLifecycleType FRAGMENT_VISIBILITY = null;
    public static final NearbyPageLifecycleType NORMAL = null;
    public static final NearbyPageLifecycleType SIDE_BAR = null;
    public static final NearbyPageLifecycleType TOP_TAB = null;
    public static final NearbyPageLifecycleType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyPageLifecycleType[] f258833a = null;

    public static NearbyPageLifecycleType valueOf(String r100) {
        return (NearbyPageLifecycleType) r27.a.a(NearbyPageLifecycleType.class, r100);
    }

    public static NearbyPageLifecycleType[] values() {
        return (NearbyPageLifecycleType[]) f258833a.clone();
    }

    static {
        NearbyPageLifecycleType r100 = new NearbyPageLifecycleType("UNKNOWN", 0);
        UNKNOWN = r100;
        NearbyPageLifecycleType r101 = new NearbyPageLifecycleType(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        NearbyPageLifecycleType r102 = new NearbyPageLifecycleType("TOP_TAB", 2);
        TOP_TAB = r102;
        NearbyPageLifecycleType r103 = new NearbyPageLifecycleType("BOTTOM_TAB", 3);
        BOTTOM_TAB = r103;
        NearbyPageLifecycleType r104 = new NearbyPageLifecycleType("SIDE_BAR", 4);
        SIDE_BAR = r104;
        NearbyPageLifecycleType r105 = new NearbyPageLifecycleType("FRAGMENT_VISIBILITY", 5);
        FRAGMENT_VISIBILITY = r105;
        f258833a = new NearbyPageLifecycleType[]{r100, r101, r102, r103, r104, r105};
    }

    public NearbyPageLifecycleType(String r100, int r101) {
        super(r100, r101);
    }
}
