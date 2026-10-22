package com.obric.oui.pullrefresh;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/pullrefresh/RefreshState;", "", "IDLE", "PULL_TO_REFRESH", "RELEASE_TO_REFRESH", "REFRESHING", "FINISH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum RefreshState extends Enum<RefreshState> {
    public static final RefreshState FINISH = null;
    public static final RefreshState IDLE = null;
    public static final RefreshState PULL_TO_REFRESH = null;
    public static final RefreshState REFRESHING = null;
    public static final RefreshState RELEASE_TO_REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshState[] f402574a = null;

    public static RefreshState valueOf(String r100) {
        return (RefreshState) r27.a.a(RefreshState.class, r100);
    }

    public static RefreshState[] values() {
        return (RefreshState[]) f402574a.clone();
    }

    static {
        RefreshState r100 = new RefreshState("IDLE", 0);
        IDLE = r100;
        RefreshState r101 = new RefreshState("PULL_TO_REFRESH", 1);
        PULL_TO_REFRESH = r101;
        RefreshState r102 = new RefreshState("RELEASE_TO_REFRESH", 2);
        RELEASE_TO_REFRESH = r102;
        RefreshState r103 = new RefreshState("REFRESHING", 3);
        REFRESHING = r103;
        RefreshState r104 = new RefreshState("FINISH", 4);
        FINISH = r104;
        f402574a = new RefreshState[]{r100, r101, r102, r103, r104};
    }

    public RefreshState(String r100, int r101) {
        super(r100, r101);
    }
}
