package com.bytedance.locallife.groupon.api;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/groupon/api/NearbyHalfType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "COMMON_HALF", "POI_HALF", "GOODS_HALF", "SEARCH_HALF", FlowDoraWifiScene.OTHER, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyHalfType extends Enum<NearbyHalfType> {
    public static final NearbyHalfType COMMON_HALF = null;
    public static final NearbyHalfType GOODS_HALF = null;
    public static final NearbyHalfType OTHER = null;
    public static final NearbyHalfType POI_HALF = null;
    public static final NearbyHalfType SEARCH_HALF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyHalfType[] f258784a = null;
    private final String value;

    public static NearbyHalfType valueOf(String r100) {
        return (NearbyHalfType) a.a(NearbyHalfType.class, r100);
    }

    public static NearbyHalfType[] values() {
        return (NearbyHalfType[]) f258784a.clone();
    }

    static {
        NearbyHalfType r100 = new NearbyHalfType("COMMON_HALF", 0, "common");
        COMMON_HALF = r100;
        NearbyHalfType r101 = new NearbyHalfType("POI_HALF", 1, AppletNaviType.POI);
        POI_HALF = r101;
        NearbyHalfType r102 = new NearbyHalfType("GOODS_HALF", 2, "goods");
        GOODS_HALF = r102;
        NearbyHalfType r103 = new NearbyHalfType("SEARCH_HALF", 3, "search");
        SEARCH_HALF = r103;
        NearbyHalfType r104 = new NearbyHalfType(FlowDoraWifiScene.OTHER, 4, "other");
        OTHER = r104;
        f258784a = new NearbyHalfType[]{r100, r101, r102, r103, r104};
    }

    public final String getValue() {
        return this.value;
    }

    public NearbyHalfType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
