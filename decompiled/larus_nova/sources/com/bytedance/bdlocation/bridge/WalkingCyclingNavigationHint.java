package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class WalkingCyclingNavigationHint {
    public static final int NAVIGATION_CODE_ALREADY_YAW = 4;
    public static final int NAVIGATION_CODE_ARRIVED = 9;
    public static final int NAVIGATION_CODE_OK = 0;
    public static final int NAVIGATION_CODE_SUSPECTED_YAW_AT_START = 6;
    public static final int NAVIGATION_CODE_SUSPECTED_YAW_AT_TRAVEL = 3;
    public final int navigationCode;
    public final float projectionBearing;
    public final boolean valid;

    public WalkingCyclingNavigationHint(boolean r100, int r101, float r102) {
        this.valid = r100;
        this.navigationCode = r101;
        this.projectionBearing = r102;
    }
}
