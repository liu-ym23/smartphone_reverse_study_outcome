package com.bytedance.locallife.groupon.struct.ai;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/ai/NearbyClientAiBusiness;", "", "", "businessName", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FEED_BUTTON", "FEATURE_CENTER", "GROUPON_FEED_REFRESH", "POI_FEED_CARD_PRELOAD_GALILEO", "POI_FEED_PRODUCT_CARD_PRELOAD_GALILEO", "GROUPON_PASSIVE_REFRESH", "GROUPON_TAB_BEHAVIOR_DETECTION", "GROUPON_TRANSFORMER_CARD_PRELOAD", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyClientAiBusiness extends Enum<NearbyClientAiBusiness> {
    public static final a Companion = null;
    public static final NearbyClientAiBusiness FEATURE_CENTER = null;
    public static final NearbyClientAiBusiness FEED_BUTTON = null;
    public static final NearbyClientAiBusiness GROUPON_FEED_REFRESH = null;
    public static final NearbyClientAiBusiness GROUPON_PASSIVE_REFRESH = null;
    public static final NearbyClientAiBusiness GROUPON_TAB_BEHAVIOR_DETECTION = null;
    public static final NearbyClientAiBusiness GROUPON_TRANSFORMER_CARD_PRELOAD = null;
    public static final NearbyClientAiBusiness POI_FEED_CARD_PRELOAD_GALILEO = null;
    public static final NearbyClientAiBusiness POI_FEED_PRODUCT_CARD_PRELOAD_GALILEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyClientAiBusiness[] f258842a = null;
    private final String businessName;

    public static NearbyClientAiBusiness valueOf(String r100) {
        return (NearbyClientAiBusiness) r27.a.a(NearbyClientAiBusiness.class, r100);
    }

    public static NearbyClientAiBusiness[] values() {
        return (NearbyClientAiBusiness[]) f258842a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.locallife.groupon.struct.ai.NearbyClientAiBusiness$a] */
    static {
        NearbyClientAiBusiness r100 = new NearbyClientAiBusiness("FEED_BUTTON", 0, "life_feed_button");
        FEED_BUTTON = r100;
        NearbyClientAiBusiness r101 = new NearbyClientAiBusiness("FEATURE_CENTER", 1, "life_feature_center");
        FEATURE_CENTER = r101;
        NearbyClientAiBusiness r102 = new NearbyClientAiBusiness("GROUPON_FEED_REFRESH", 2, "groupon_feed_refresh");
        GROUPON_FEED_REFRESH = r102;
        NearbyClientAiBusiness r103 = new NearbyClientAiBusiness("POI_FEED_CARD_PRELOAD_GALILEO", 3, "poi_feed_card_preload_galileo");
        POI_FEED_CARD_PRELOAD_GALILEO = r103;
        NearbyClientAiBusiness r104 = new NearbyClientAiBusiness("POI_FEED_PRODUCT_CARD_PRELOAD_GALILEO", 4, "poi_feed_product_card_preload_galileo");
        POI_FEED_PRODUCT_CARD_PRELOAD_GALILEO = r104;
        NearbyClientAiBusiness r105 = new NearbyClientAiBusiness("GROUPON_PASSIVE_REFRESH", 5, "groupon_passive_refresh");
        GROUPON_PASSIVE_REFRESH = r105;
        NearbyClientAiBusiness r110 = new NearbyClientAiBusiness("GROUPON_TAB_BEHAVIOR_DETECTION", 6, "groupon_tab_behavior_detection");
        GROUPON_TAB_BEHAVIOR_DETECTION = r110;
        NearbyClientAiBusiness r111 = new NearbyClientAiBusiness("GROUPON_TRANSFORMER_CARD_PRELOAD", 7, "homepage_life_transform_preload");
        GROUPON_TRANSFORMER_CARD_PRELOAD = r111;
        f258842a = new NearbyClientAiBusiness[]{r100, r101, r102, r103, r104, r105, r110, r111};
        Companion = new a();
    }

    public final String getBusinessName() {
        return this.businessName;
    }

    public NearbyClientAiBusiness(String r100, int r101, String r102) {
        super(r100, r101);
        this.businessName = r102;
    }
}
