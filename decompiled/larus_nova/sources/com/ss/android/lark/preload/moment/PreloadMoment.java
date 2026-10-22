package com.ss.android.lark.preload.moment;

import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum PreloadMoment extends Enum<PreloadMoment> {
    public static final PreloadMoment FIRST_SCREEN_SHOWED = null;
    public static final PreloadMoment IDLE = null;
    public static final PreloadMoment IMMEDIATELY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadMoment[] f438808a = null;

    static {
        PreloadMoment r100 = new PreloadMoment("IDLE", 0);
        IDLE = r100;
        PreloadMoment r101 = new PreloadMoment("FIRST_SCREEN_SHOWED", 1);
        FIRST_SCREEN_SHOWED = r101;
        PreloadMoment r102 = new PreloadMoment("IMMEDIATELY", 2);
        IMMEDIATELY = r102;
        f438808a = new PreloadMoment[]{r100, r101, r102};
    }

    public static PreloadMoment[] values() {
        return (PreloadMoment[]) f438808a.clone();
    }

    public static PreloadMoment valueOf(String r100) {
        return (PreloadMoment) a.a(PreloadMoment.class, r100);
    }

    public PreloadMoment(String r100, int r101) {
        super(r100, r101);
    }
}
