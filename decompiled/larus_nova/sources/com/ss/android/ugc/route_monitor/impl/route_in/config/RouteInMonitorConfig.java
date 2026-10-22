package com.ss.android.ugc.route_monitor.impl.route_in.config;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_in/config/RouteInMonitorConfig;", "Ljava/util/ArrayList;", "Lcom/ss/android/ugc/route_monitor/impl/route_in/config/SingleRouteInMonitorConfig;", "Lkotlin/collections/ArrayList;", "()V", "route-monitor_release"}, k = 1, mv = {1, 1, 16})
public final class RouteInMonitorConfig extends ArrayList<SingleRouteInMonitorConfig> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public RouteInMonitorConfig() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof SingleRouteInMonitorConfig) == true) goto L5;
        return false;
    L5:
        return contains((SingleRouteInMonitorConfig) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof SingleRouteInMonitorConfig) == true) goto L5;
        return -1;
    L5:
        return indexOf((SingleRouteInMonitorConfig) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof SingleRouteInMonitorConfig) == true) goto L5;
        return -1;
    L5:
        return lastIndexOf((SingleRouteInMonitorConfig) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof SingleRouteInMonitorConfig) == true) goto L5;
        return false;
    L5:
        return remove((SingleRouteInMonitorConfig) r100);
    }

    public /* bridge */ SingleRouteInMonitorConfig removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(SingleRouteInMonitorConfig r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(SingleRouteInMonitorConfig r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(SingleRouteInMonitorConfig r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ SingleRouteInMonitorConfig remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(SingleRouteInMonitorConfig r100) {
        return super.remove(r100);
    }
}
