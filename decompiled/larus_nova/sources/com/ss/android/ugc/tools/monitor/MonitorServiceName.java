package com.ss.android.ugc.tools.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/tools/monitor/MonitorServiceName;", "", "", "serviceName", "Ljava/lang/String;", "getServiceName", "()Ljava/lang/String;", "SEARCH_PROP_RECOMMEND_LIST", "SEARCH_PROP", "SERVICE_RECORD_SEGMENTS_DELETE_ILLEGAL", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final enum MonitorServiceName extends Enum<MonitorServiceName> {
    public static final MonitorServiceName SEARCH_PROP = null;
    public static final MonitorServiceName SEARCH_PROP_RECOMMEND_LIST = null;
    public static final MonitorServiceName SERVICE_RECORD_SEGMENTS_DELETE_ILLEGAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorServiceName[] f454833a = null;
    private final String serviceName;

    static {
        MonitorServiceName r100 = new MonitorServiceName("SEARCH_PROP_RECOMMEND_LIST", 0, "search_prop_recommendation_list_shown_success_rate");
        SEARCH_PROP_RECOMMEND_LIST = r100;
        MonitorServiceName r101 = new MonitorServiceName("SEARCH_PROP", 1, "search_prop_success_rate");
        SEARCH_PROP = r101;
        MonitorServiceName r102 = new MonitorServiceName("SERVICE_RECORD_SEGMENTS_DELETE_ILLEGAL", 2, "service_creative_record_segments_delete_illegal");
        SERVICE_RECORD_SEGMENTS_DELETE_ILLEGAL = r102;
        f454833a = new MonitorServiceName[]{r100, r101, r102};
    }

    public static MonitorServiceName valueOf(String r100) {
        return (MonitorServiceName) a.a(MonitorServiceName.class, r100);
    }

    public static MonitorServiceName[] values() {
        return (MonitorServiceName[]) f454833a.clone();
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public MonitorServiceName(String r100, int r101, String r102) {
        super(r100, r101);
        this.serviceName = r102;
    }
}
