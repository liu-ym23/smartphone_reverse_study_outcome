package com.bytedance.ies.bullet.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/core/AppState;", "", "ON_APP_HIDE", "ON_APP_SHOW", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AppState extends Enum<AppState> {
    public static final AppState ON_APP_HIDE = null;
    public static final AppState ON_APP_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppState[] f246427a = null;

    public static AppState valueOf(String r100) {
        return (AppState) r27.a.a(AppState.class, r100);
    }

    public static AppState[] values() {
        return (AppState[]) f246427a.clone();
    }

    static {
        AppState r100 = new AppState("ON_APP_HIDE", 0);
        ON_APP_HIDE = r100;
        AppState r101 = new AppState("ON_APP_SHOW", 1);
        ON_APP_SHOW = r101;
        f246427a = new AppState[]{r100, r101};
    }

    public AppState(String r100, int r101) {
        super(r100, r101);
    }
}
