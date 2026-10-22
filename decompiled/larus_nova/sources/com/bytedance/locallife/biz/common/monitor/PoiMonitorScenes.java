package com.bytedance.locallife.biz.common.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/biz/common/monitor/PoiMonitorScenes;", "", "", "sceneName", "Ljava/lang/String;", "getSceneName", "()Ljava/lang/String;", "POI_DETAIL_PAGE_MONITOR", "POI_DETAIL_CONTENT_LYNX_MONITOR", "POI_DETAIL_LYNX_UNLOAD", "POI_DETAIL_STAGGER_FPS", "POI_NET_API_RESPONSE", "POI_DETAIL_RATE_FLOW_FPS", "POI_DETAIL_UGC_FLOW_FPS", "POI_DYNAMIC_PAGE", "POI_DETAIL_DITO_FPS", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiMonitorScenes extends Enum<PoiMonitorScenes> {
    public static final PoiMonitorScenes POI_DETAIL_CONTENT_LYNX_MONITOR = null;
    public static final PoiMonitorScenes POI_DETAIL_DITO_FPS = null;
    public static final PoiMonitorScenes POI_DETAIL_LYNX_UNLOAD = null;
    public static final PoiMonitorScenes POI_DETAIL_PAGE_MONITOR = null;
    public static final PoiMonitorScenes POI_DETAIL_RATE_FLOW_FPS = null;
    public static final PoiMonitorScenes POI_DETAIL_STAGGER_FPS = null;
    public static final PoiMonitorScenes POI_DETAIL_UGC_FLOW_FPS = null;
    public static final PoiMonitorScenes POI_DYNAMIC_PAGE = null;
    public static final PoiMonitorScenes POI_NET_API_RESPONSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiMonitorScenes[] f256624a = null;
    private final String sceneName;

    public static PoiMonitorScenes valueOf(String r100) {
        return (PoiMonitorScenes) a.a(PoiMonitorScenes.class, r100);
    }

    public static PoiMonitorScenes[] values() {
        return (PoiMonitorScenes[]) f256624a.clone();
    }

    static {
        PoiMonitorScenes r100 = new PoiMonitorScenes("POI_DETAIL_PAGE_MONITOR", 0, "poi_detail_page_monitor");
        POI_DETAIL_PAGE_MONITOR = r100;
        PoiMonitorScenes r101 = new PoiMonitorScenes("POI_DETAIL_CONTENT_LYNX_MONITOR", 1, "poi_detail_content_lynx_monitor");
        POI_DETAIL_CONTENT_LYNX_MONITOR = r101;
        PoiMonitorScenes r102 = new PoiMonitorScenes("POI_DETAIL_LYNX_UNLOAD", 2, "poi_detail_lynx_unload");
        POI_DETAIL_LYNX_UNLOAD = r102;
        PoiMonitorScenes r103 = new PoiMonitorScenes("POI_DETAIL_STAGGER_FPS", 3, "poi_detail_stagger_fms");
        POI_DETAIL_STAGGER_FPS = r103;
        PoiMonitorScenes r104 = new PoiMonitorScenes("POI_NET_API_RESPONSE", 4, "poi_net_api_response");
        POI_NET_API_RESPONSE = r104;
        PoiMonitorScenes r105 = new PoiMonitorScenes("POI_DETAIL_RATE_FLOW_FPS", 5, "poi_detail_rate_flow_fps");
        POI_DETAIL_RATE_FLOW_FPS = r105;
        PoiMonitorScenes r110 = new PoiMonitorScenes("POI_DETAIL_UGC_FLOW_FPS", 6, "poi_detail_ugc_flow_fps");
        POI_DETAIL_UGC_FLOW_FPS = r110;
        PoiMonitorScenes r111 = new PoiMonitorScenes("POI_DYNAMIC_PAGE", 7, "poi_dynamic_monitor");
        POI_DYNAMIC_PAGE = r111;
        PoiMonitorScenes r112 = new PoiMonitorScenes("POI_DETAIL_DITO_FPS", 8, "poi_detail_dito_fps");
        POI_DETAIL_DITO_FPS = r112;
        f256624a = new PoiMonitorScenes[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final String getSceneName() {
        return this.sceneName;
    }

    public PoiMonitorScenes(String r100, int r101, String r102) {
        super(r100, r101);
        this.sceneName = r102;
    }
}
