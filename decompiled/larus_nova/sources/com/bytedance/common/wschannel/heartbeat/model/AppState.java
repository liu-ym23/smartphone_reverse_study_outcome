package com.bytedance.common.wschannel.heartbeat.model;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum AppState extends Enum<AppState> {
    private static final /* synthetic */ AppState[] $VALUES = null;
    public static final AppState STATE_BACKGROUND = null;
    public static final AppState STATE_DOZE = null;
    public static final AppState STATE_FOREGROUND = null;
    public static final AppState STATE_LIGHT_DOZE = null;

    static {
        AppState r100 = new AppState("STATE_FOREGROUND", 0);
        STATE_FOREGROUND = r100;
        AppState r101 = new AppState("STATE_BACKGROUND", 1);
        STATE_BACKGROUND = r101;
        AppState r102 = new AppState("STATE_LIGHT_DOZE", 2);
        STATE_LIGHT_DOZE = r102;
        AppState r103 = new AppState("STATE_DOZE", 3);
        STATE_DOZE = r103;
        $VALUES = new AppState[]{r100, r101, r102, r103};
    }

    public static AppState[] values() {
        return (AppState[]) $VALUES.clone();
    }

    public static AppState valueOf(String r100) {
        return (AppState) a.a(AppState.class, r100);
    }

    private AppState(String r100, int r101) {
        super(r100, r101);
    }
}
