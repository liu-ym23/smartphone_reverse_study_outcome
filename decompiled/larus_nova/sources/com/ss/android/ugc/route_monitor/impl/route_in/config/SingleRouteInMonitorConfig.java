package com.ss.android.ugc.route_monitor.impl.route_in.config;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_in/config/SingleRouteInMonitorConfig;", "", "configConditionList", "", "Lcom/ss/android/ugc/route_monitor/impl/route_in/config/SingleConfigCondition;", "monitorModeData", "Lcom/ss/android/ugc/route_monitor/impl/route_in/config/RouteMonitorModeData;", "(Ljava/util/List;Lcom/ss/android/ugc/route_monitor/impl/route_in/config/RouteMonitorModeData;)V", "getConfigConditionList", "()Ljava/util/List;", "getMonitorModeData", "()Lcom/ss/android/ugc/route_monitor/impl/route_in/config/RouteMonitorModeData;", "toString", "", "route-monitor_release"}, k = 1, mv = {1, 1, 16})
public final class SingleRouteInMonitorConfig {
    private final List<SingleConfigCondition> configConditionList;
    private final RouteMonitorModeData monitorModeData;

    public String toString() {
        return "{configConditionList = " + this.configConditionList + ", monitorModeData = " + this.monitorModeData + '}';
    }

    public final List<SingleConfigCondition> getConfigConditionList() {
        return this.configConditionList;
    }

    public final RouteMonitorModeData getMonitorModeData() {
        return this.monitorModeData;
    }

    public SingleRouteInMonitorConfig(List<SingleConfigCondition> r100, RouteMonitorModeData r101) {
        this.configConditionList = r100;
        this.monitorModeData = r101;
    }
}
