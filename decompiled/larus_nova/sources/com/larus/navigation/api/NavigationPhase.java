package com.larus.navigation.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/navigation/api/NavigationPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ENGINE_SELECT", "SDK_INIT", "GET_ORIGIN", "ROUTE_PLAN", "NAV_STARTED", "NAVIGATING", "PAUSED", "NAV_STOPPED", "ERROR", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigationPhase extends Enum<NavigationPhase> {
    public static final NavigationPhase ENGINE_SELECT = null;
    public static final NavigationPhase ERROR = null;
    public static final NavigationPhase GET_ORIGIN = null;
    public static final NavigationPhase IDLE = null;
    public static final NavigationPhase NAVIGATING = null;
    public static final NavigationPhase NAV_STARTED = null;
    public static final NavigationPhase NAV_STOPPED = null;
    public static final NavigationPhase PAUSED = null;
    public static final NavigationPhase ROUTE_PLAN = null;
    public static final NavigationPhase SDK_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationPhase[] f359628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359629b = null;

    public static EnumEntries<NavigationPhase> getEntries() {
        return f359629b;
    }

    static {
        NavigationPhase r100 = new NavigationPhase("IDLE", 0);
        IDLE = r100;
        NavigationPhase r101 = new NavigationPhase("ENGINE_SELECT", 1);
        ENGINE_SELECT = r101;
        NavigationPhase r102 = new NavigationPhase("SDK_INIT", 2);
        SDK_INIT = r102;
        NavigationPhase r103 = new NavigationPhase("GET_ORIGIN", 3);
        GET_ORIGIN = r103;
        NavigationPhase r104 = new NavigationPhase("ROUTE_PLAN", 4);
        ROUTE_PLAN = r104;
        NavigationPhase r105 = new NavigationPhase("NAV_STARTED", 5);
        NAV_STARTED = r105;
        NavigationPhase r110 = new NavigationPhase("NAVIGATING", 6);
        NAVIGATING = r110;
        NavigationPhase r111 = new NavigationPhase("PAUSED", 7);
        PAUSED = r111;
        NavigationPhase r112 = new NavigationPhase("NAV_STOPPED", 8);
        NAV_STOPPED = r112;
        NavigationPhase r113 = new NavigationPhase("ERROR", 9);
        ERROR = r113;
        NavigationPhase[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f359628a = r114;
        f359629b = EnumEntriesKt.enumEntries(r114);
    }

    public static NavigationPhase[] values() {
        return (NavigationPhase[]) f359628a.clone();
    }

    public static NavigationPhase valueOf(String r100) {
        return (NavigationPhase) r27.a.a(NavigationPhase.class, r100);
    }

    public NavigationPhase(String r100, int r101) {
        super(r100, r101);
    }
}
