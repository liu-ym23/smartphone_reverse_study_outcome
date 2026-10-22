package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LocationConfig {
    public static final int SYSTEM_TYPE_ANDROID = 1;
    public static final int SYSTEM_TYPE_HARMONY_OS = 3;
    public static final int SYSTEM_TYPE_IOS = 2;
    public static final int SYSTEM_TYPE_UNKNOWN = 0;
    public static final int USER_MOTION_MODE_CYCLING = 2;
    public static final int USER_MOTION_MODE_DRIVING = 3;
    public static final int USER_MOTION_MODE_UNKNOWN = 0;
    public static final int USER_MOTION_MODE_WALKING = 1;
    public static final int WORK_MODE_CRUISE = 1;
    public static final int WORK_MODE_NAVIGATION = 2;
    public static final int WORK_MODE_NORMAL = 0;
    public final String deviceBrand;
    public final String deviceModel;
    public final boolean enableTrackUpload;
    public final String lifeId;
    public final int systemType;
    public final int trackIntervalSec;
    public final int userMotionMode;
    public final int workMode;

    public LocationConfig() {
        this(1, 0, true, 15, null, 0, null, null);
    }

    public LocationConfig(int r10, int r11, boolean r12, int r13) {
        this(r10, r11, r12, r13, null, 0, null, null);
    }

    public LocationConfig(int r10, int r11, boolean r12, int r13, String r14) {
        this(r10, r11, r12, r13, r14, 0, null, null);
    }

    public LocationConfig(int r10, int r11, boolean r12, int r13, String r14, int r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public LocationConfig(int r1, int r2, boolean r3, int r4, String r5, int r6, String r7, String r8) {
        this.workMode = r1;
        this.userMotionMode = r2;
        this.enableTrackUpload = r3;
        this.trackIntervalSec = r4;
        this.lifeId = r5;
        this.systemType = r6;
        this.deviceModel = r7;
        this.deviceBrand = r8;
    }
}
