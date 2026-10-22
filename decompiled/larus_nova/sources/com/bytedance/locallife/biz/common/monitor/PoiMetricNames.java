package com.bytedance.locallife.biz.common.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/biz/common/monitor/PoiMetricNames;", "", "", "metricNames", "Ljava/lang/String;", "getMetricNames", "()Ljava/lang/String;", "FMP_DURATION", "OLD_FMP_DURATION", "LAUNCH_DURATION", "POI_DETAIL_API_DURATION", "POI_FEED_API_DURATION", "POI_FILL_CONTENT_DURATION", "POI_FILL_FEED_DURATION", "REUSE_OR_DIRECT", "POI_DETAIL_ACT_INIT_DURATION", "DYNAMIC_PAGE_INIT", "DYNAMIC_API_DURATION", "DYNAMIC_DATA_ANALYSIS_DURATION", "DYNAMIC_DATA_RENDER_DURATION", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiMetricNames extends Enum<PoiMetricNames> {
    public static final PoiMetricNames DYNAMIC_API_DURATION = null;
    public static final PoiMetricNames DYNAMIC_DATA_ANALYSIS_DURATION = null;
    public static final PoiMetricNames DYNAMIC_DATA_RENDER_DURATION = null;
    public static final PoiMetricNames DYNAMIC_PAGE_INIT = null;
    public static final PoiMetricNames FMP_DURATION = null;
    public static final PoiMetricNames LAUNCH_DURATION = null;
    public static final PoiMetricNames OLD_FMP_DURATION = null;
    public static final PoiMetricNames POI_DETAIL_ACT_INIT_DURATION = null;
    public static final PoiMetricNames POI_DETAIL_API_DURATION = null;
    public static final PoiMetricNames POI_FEED_API_DURATION = null;
    public static final PoiMetricNames POI_FILL_CONTENT_DURATION = null;
    public static final PoiMetricNames POI_FILL_FEED_DURATION = null;
    public static final PoiMetricNames REUSE_OR_DIRECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiMetricNames[] f256623a = null;
    private final String metricNames;

    public static PoiMetricNames valueOf(String r100) {
        return (PoiMetricNames) a.a(PoiMetricNames.class, r100);
    }

    public static PoiMetricNames[] values() {
        return (PoiMetricNames[]) f256623a.clone();
    }

    static {
        PoiMetricNames r100 = new PoiMetricNames("FMP_DURATION", 0, "fmp_duration");
        FMP_DURATION = r100;
        PoiMetricNames r101 = new PoiMetricNames("OLD_FMP_DURATION", 1, "old_fmp_duration");
        OLD_FMP_DURATION = r101;
        PoiMetricNames r102 = new PoiMetricNames("LAUNCH_DURATION", 2, "launch_duration");
        LAUNCH_DURATION = r102;
        PoiMetricNames r103 = new PoiMetricNames("POI_DETAIL_API_DURATION", 3, "detail_request_duration");
        POI_DETAIL_API_DURATION = r103;
        PoiMetricNames r104 = new PoiMetricNames("POI_FEED_API_DURATION", 4, "feed_request_duration");
        POI_FEED_API_DURATION = r104;
        PoiMetricNames r105 = new PoiMetricNames("POI_FILL_CONTENT_DURATION", 5, "fill_content_duration");
        POI_FILL_CONTENT_DURATION = r105;
        PoiMetricNames r110 = new PoiMetricNames("POI_FILL_FEED_DURATION", 6, "fill_feed_duration");
        POI_FILL_FEED_DURATION = r110;
        PoiMetricNames r111 = new PoiMetricNames("REUSE_OR_DIRECT", 7, "reuse_or_direct");
        REUSE_OR_DIRECT = r111;
        PoiMetricNames r112 = new PoiMetricNames("POI_DETAIL_ACT_INIT_DURATION", 8, "detail_act_init_duration");
        POI_DETAIL_ACT_INIT_DURATION = r112;
        PoiMetricNames r113 = new PoiMetricNames("DYNAMIC_PAGE_INIT", 9, "dynamic_page_init_duration");
        DYNAMIC_PAGE_INIT = r113;
        PoiMetricNames r114 = new PoiMetricNames("DYNAMIC_API_DURATION", 10, "dynamic_request_duration");
        DYNAMIC_API_DURATION = r114;
        PoiMetricNames r106 = new PoiMetricNames("DYNAMIC_DATA_ANALYSIS_DURATION", 11, "dynamic_data_analysis_duration");
        DYNAMIC_DATA_ANALYSIS_DURATION = r106;
        PoiMetricNames r107 = new PoiMetricNames("DYNAMIC_DATA_RENDER_DURATION", 12, "dynamic_data_render_duration");
        DYNAMIC_DATA_RENDER_DURATION = r107;
        f256623a = new PoiMetricNames[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final String getMetricNames() {
        return this.metricNames;
    }

    public PoiMetricNames(String r100, int r101, String r102) {
        super(r100, r101);
        this.metricNames = r102;
    }
}
