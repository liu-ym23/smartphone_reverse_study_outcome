package com.ss.android.ugc.route_monitor.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/route_monitor/api/MonitorMode;", "", "DEEPLINK", "SPECIFIC_DEST_PAGE", "SPECIFIC_PAGE_COUNT", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final enum MonitorMode extends Enum<MonitorMode> {
    public static final MonitorMode DEEPLINK = null;
    public static final MonitorMode SPECIFIC_DEST_PAGE = null;
    public static final MonitorMode SPECIFIC_PAGE_COUNT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorMode[] f454386a = null;

    static {
        MonitorMode r100 = new MonitorMode("DEEPLINK", 0);
        DEEPLINK = r100;
        MonitorMode r101 = new MonitorMode("SPECIFIC_DEST_PAGE", 1);
        SPECIFIC_DEST_PAGE = r101;
        MonitorMode r102 = new MonitorMode("SPECIFIC_PAGE_COUNT", 2);
        SPECIFIC_PAGE_COUNT = r102;
        f454386a = new MonitorMode[]{r100, r101, r102};
    }

    public static MonitorMode valueOf(String r100) {
        return (MonitorMode) a.a(MonitorMode.class, r100);
    }

    public static MonitorMode[] values() {
        return (MonitorMode[]) f454386a.clone();
    }

    public MonitorMode(String r100, int r101) {
        super(r100, r101);
    }
}
