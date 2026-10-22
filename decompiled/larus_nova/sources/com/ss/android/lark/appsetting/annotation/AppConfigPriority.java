package com.ss.android.lark.appsetting.annotation;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum AppConfigPriority extends Enum<AppConfigPriority> {
    public static final AppConfigPriority LIBRA_FIRST = null;
    public static final AppConfigPriority SETTINGS_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppConfigPriority[] f408930a = null;

    static {
        AppConfigPriority r100 = new AppConfigPriority("SETTINGS_ONLY", 0);
        SETTINGS_ONLY = r100;
        AppConfigPriority r101 = new AppConfigPriority("LIBRA_FIRST", 1);
        LIBRA_FIRST = r101;
        f408930a = new AppConfigPriority[]{r100, r101};
    }

    public static AppConfigPriority[] values() {
        return (AppConfigPriority[]) f408930a.clone();
    }

    public static AppConfigPriority valueOf(String r100) {
        return (AppConfigPriority) a.a(AppConfigPriority.class, r100);
    }

    public AppConfigPriority(String r100, int r101) {
        super(r100, r101);
    }
}
